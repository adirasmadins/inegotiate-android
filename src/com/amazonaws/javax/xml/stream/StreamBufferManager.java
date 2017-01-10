package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.impl.io.ASCIIReader;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UCSReader;
import com.amazonaws.javax.xml.stream.xerces.impl.io.UTF8Reader;
import com.amazonaws.javax.xml.stream.xerces.util.EncodingMap;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.CharBuffer;
import java.util.Locale;

public class StreamBufferManager extends BufferManager {
    static final boolean DEBUG = false;
    static final int DEFAULT_LENGTH = 8192;
    CharBuffer charBuffer;
    boolean fAllowJavaEncodings;
    Reader fReader;

    protected final class RewindableInputStream extends InputStream {
        static final int DEFAULT_XMLDECL_BUFFER_SIZE = 64;
        private byte[] fData;
        private int fEndOffset;
        private InputStream fInputStream;
        private int fLength;
        private int fMark;
        private int fOffset;
        private int fStartOffset;

        public RewindableInputStream(InputStream is) {
            this.fData = new byte[DEFAULT_XMLDECL_BUFFER_SIZE];
            this.fInputStream = is;
            this.fStartOffset = 0;
            this.fEndOffset = -1;
            this.fOffset = 0;
            this.fLength = 0;
            this.fMark = 0;
        }

        public void setStartOffset(int offset) {
            this.fStartOffset = offset;
        }

        public void rewind() {
            this.fOffset = this.fStartOffset;
        }

        public int read() throws IOException {
            byte[] bArr;
            int i;
            if (this.fOffset < this.fLength) {
                bArr = this.fData;
                i = this.fOffset;
                this.fOffset = i + 1;
                return bArr[i] & 255;
            } else if (this.fOffset == this.fEndOffset) {
                return -1;
            } else {
                if (this.fOffset == this.fData.length) {
                    byte[] newData = new byte[(this.fOffset << 1)];
                    System.arraycopy(this.fData, 0, newData, 0, this.fOffset);
                    this.fData = newData;
                }
                int b = this.fInputStream.read();
                if (b == -1) {
                    this.fEndOffset = this.fOffset;
                    return -1;
                }
                bArr = this.fData;
                i = this.fLength;
                this.fLength = i + 1;
                bArr[i] = (byte) b;
                this.fOffset++;
                return b & 255;
            }
        }

        public int read(byte[] b, int off, int len) throws IOException {
            int bytesLeft = this.fLength - this.fOffset;
            if (bytesLeft != 0) {
                if (len >= bytesLeft) {
                    len = bytesLeft;
                } else if (len <= 0) {
                    return 0;
                }
                if (b != null) {
                    System.arraycopy(this.fData, this.fOffset, b, off, len);
                }
                this.fOffset += len;
                return len;
            } else if (this.fOffset == this.fEndOffset) {
                return -1;
            } else {
                return this.fInputStream.read(b, off, len);
            }
        }

        public long skip(long n) throws IOException {
            if (n <= 0) {
                return 0;
            }
            int bytesLeft = this.fLength - this.fOffset;
            if (bytesLeft == 0) {
                if (this.fOffset != this.fEndOffset) {
                    return this.fInputStream.skip(n);
                }
                return 0;
            } else if (n <= ((long) bytesLeft)) {
                this.fOffset = (int) (((long) this.fOffset) + n);
                return n;
            } else {
                this.fOffset += bytesLeft;
                if (this.fOffset == this.fEndOffset) {
                    return (long) bytesLeft;
                }
                return this.fInputStream.skip(n - ((long) bytesLeft)) + ((long) bytesLeft);
            }
        }

        public int available() throws IOException {
            int bytesLeft = this.fLength - this.fOffset;
            if (bytesLeft != 0) {
                return bytesLeft;
            }
            if (this.fOffset == this.fEndOffset) {
                return -1;
            }
            return this.fInputStream.available();
        }

        public void mark(int howMuch) {
            this.fMark = this.fOffset;
        }

        public void reset() {
            this.fOffset = this.fMark;
        }

        public boolean markSupported() {
            return true;
        }

        public void close() throws IOException {
            if (this.fInputStream != null) {
                this.fInputStream.close();
                this.fInputStream = null;
            }
        }
    }

    public StreamBufferManager(InputStream stream, String encoding) throws IOException {
        this.charBuffer = null;
        this.fReader = null;
        this.fAllowJavaEncodings = true;
        init(stream, encoding);
    }

    void init(InputStream istream, String encoding) throws IOException {
        InputStream stream = new RewindableInputStream(istream);
        if (encoding == null) {
            byte[] b4 = new byte[4];
            int count = 0;
            while (count < 4) {
                b4[count] = (byte) stream.read();
                count++;
            }
            if (count == 4) {
                Object[] encodingDesc = getEncodingName(b4, count);
                encoding = (String) encodingDesc[0];
                Boolean isBigEndian = (Boolean) encodingDesc[1];
                stream.reset();
                if (count > 2 && encoding.equals(StringEncodings.UTF8)) {
                    int b1 = b4[1] & 255;
                    int b2 = b4[2] & 255;
                    if ((b4[0] & 255) == 239 && b1 == 187 && b2 == 191) {
                        stream.skip(3);
                    }
                }
                this.fReader = createReader(stream, encoding, isBigEndian);
            } else {
                this.fReader = createReader(stream, encoding, null);
            }
        } else {
            this.fReader = createReader(stream, encoding, null);
        }
        this.charBuffer = CharBuffer.allocate(DEFAULT_LENGTH);
    }

    public CharBuffer getCharBuffer() {
        return this.charBuffer;
    }

    public boolean getMore() throws IOException {
        if (this.charBuffer.position() != 0) {
            this.charBuffer.compact();
        }
        char[] ch = this.charBuffer.array();
        int count = this.fReader.read(ch, this.charBuffer.position(), this.charBuffer.capacity());
        if (count == -1) {
            this.endOfStream = true;
            return DEBUG;
        }
        CharBuffer charBuffer = this.charBuffer;
        this.charBuffer = CharBuffer.wrap(ch);
        this.charBuffer.limit(count);
        if (count > 0) {
            return true;
        }
        return DEBUG;
    }

    protected Reader createReader(InputStream inputStream, String encoding, Boolean isBigEndian) throws IOException {
        if (encoding == null) {
            encoding = StringEncodings.UTF8;
        }
        String ENCODING = encoding.toUpperCase(Locale.ENGLISH);
        if (ENCODING.equals(StringEncodings.UTF8)) {
            return new UTF8Reader(inputStream, DEFAULT_LENGTH, null, Locale.getDefault());
        }
        if (ENCODING.equals(StringEncodings.US_ASCII)) {
            return new ASCIIReader(inputStream, DEFAULT_LENGTH, null, Locale.getDefault());
        }
        if (ENCODING.equals("ISO-10646-UCS-4")) {
            if (isBigEndian == null) {
                throw new IOException("Encoding byte order not supported");
            } else if (isBigEndian.booleanValue()) {
                return new UCSReader(inputStream, (short) 8);
            } else {
                return new UCSReader(inputStream, (short) 4);
            }
        } else if (!ENCODING.equals("ISO-10646-UCS-2")) {
            boolean validIANA = XMLChar.isValidIANAEncoding(encoding);
            boolean validJava = XMLChar.isValidJavaEncoding(encoding);
            if (!validIANA || (this.fAllowJavaEncodings && !validJava)) {
                throw new IOException(new StringBuffer().append("Encoding declaration ").append(encoding).append("not valid").toString());
            }
            String javaEncoding = EncodingMap.getIANA2JavaMapping(ENCODING);
            if (javaEncoding == null) {
                if (this.fAllowJavaEncodings) {
                    javaEncoding = encoding;
                } else {
                    throw new IOException(new StringBuffer().append("Encoding ").append(encoding).append(" not supported").toString());
                }
            }
            return new BufferedReader(new InputStreamReader(inputStream, javaEncoding));
        } else if (isBigEndian == null) {
            throw new IOException("Encoding byte order not supported");
        } else if (isBigEndian.booleanValue()) {
            return new UCSReader(inputStream, (short) 2);
        } else {
            return new UCSReader(inputStream, (short) 1);
        }
    }

    int getLength() {
        return DEFAULT_LENGTH;
    }

    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            System.out.println(new StringBuffer().append("url parameter = ").append(file.toURI().toString()).toString());
            StreamBufferManager sb = new StreamBufferManager(new URL(file.toURI().toString()).openStream(), StringEncodings.UTF8);
            CharBuffer cb = sb.getCharBuffer();
            int i = 0;
            while (sb.getMore()) {
                int i2 = i + 1;
                System.out.println(new StringBuffer().append("Loop ").append(i).append(" = ").append(sb.getCharBuffer()).toString());
                i = i2;
            }
            System.out.println(new StringBuffer().append("End of stream reached = ").append(sb.endOfStream()).toString());
            System.out.println(new StringBuffer().append("Total no. of loops required = ").append(i).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close() throws IOException {
        if (this.fReader != null) {
            this.fReader.close();
        }
    }

    public void setEncoding(String encoding) throws IOException {
    }

    public boolean arrangeCapacity(int length) throws IOException {
        return DEBUG;
    }
}
