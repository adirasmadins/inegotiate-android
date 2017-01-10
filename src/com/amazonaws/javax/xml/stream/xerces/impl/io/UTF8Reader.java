package com.amazonaws.javax.xml.stream.xerces.impl.io;

import com.amazonaws.javax.xml.stream.util.ThreadLocalBufferAllocator;
import com.amazonaws.javax.xml.stream.xerces.impl.msg.XMLMessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.util.MessageFormatter;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UTFDataFormatException;
import java.util.Locale;

public class UTF8Reader extends Reader {
    private static final boolean DEBUG_READ = false;
    public static final int DEFAULT_BUFFER_SIZE = 2048;
    protected byte[] fBuffer;
    private MessageFormatter fFormatter;
    protected InputStream fInputStream;
    private Locale fLocale;
    protected int fOffset;
    private int fSurrogate;

    public UTF8Reader(InputStream inputStream) {
        this(inputStream, DEFAULT_BUFFER_SIZE, new XMLMessageFormatter(), Locale.getDefault());
    }

    public UTF8Reader(InputStream inputStream, MessageFormatter messageFormatter, Locale locale) {
        this(inputStream, DEFAULT_BUFFER_SIZE, messageFormatter, locale);
    }

    public UTF8Reader(InputStream inputStream, int size, MessageFormatter messageFormatter, Locale locale) {
        this.fSurrogate = -1;
        this.fFormatter = null;
        this.fLocale = null;
        this.fInputStream = inputStream;
        this.fFormatter = messageFormatter;
        this.fLocale = locale;
        this.fBuffer = ThreadLocalBufferAllocator.getBufferAllocator().getByteBuffer(size);
        if (this.fBuffer == null) {
            this.fBuffer = new byte[size];
        }
    }

    public int read() throws IOException {
        int c = this.fSurrogate;
        if (this.fSurrogate == -1) {
            int b0;
            int index;
            if (0 == this.fOffset) {
                b0 = this.fInputStream.read();
                index = 0;
            } else {
                index = 0 + 1;
                b0 = this.fBuffer[0] & 255;
            }
            if (b0 == -1) {
                return -1;
            }
            int i;
            if (b0 < XMLChar.MASK_NCNAME) {
                c = (char) b0;
                i = index;
            } else if ((b0 & 224) == 192) {
                if (index == this.fOffset) {
                    b1 = this.fInputStream.read();
                    i = index;
                } else {
                    i = index + 1;
                    b1 = this.fBuffer[index] & 255;
                }
                if (b1 == -1) {
                    expectedByte(2, 2);
                }
                if ((b1 & 192) != XMLChar.MASK_NCNAME) {
                    invalidByte(2, 2, b1);
                }
                c = ((b0 << 6) & 1984) | (b1 & 63);
            } else if ((b0 & 240) == 224) {
                if (index == this.fOffset) {
                    b1 = this.fInputStream.read();
                } else {
                    b1 = this.fBuffer[index] & 255;
                    index++;
                }
                if (b1 == -1) {
                    expectedByte(2, 3);
                }
                if ((b1 & 192) != XMLChar.MASK_NCNAME) {
                    invalidByte(2, 3, b1);
                }
                if (index == this.fOffset) {
                    b2 = this.fInputStream.read();
                    i = index;
                } else {
                    i = index + 1;
                    b2 = this.fBuffer[index] & 255;
                }
                if (b2 == -1) {
                    expectedByte(3, 3);
                }
                if ((b2 & 192) != XMLChar.MASK_NCNAME) {
                    invalidByte(3, 3, b2);
                }
                c = (((b0 << 12) & 61440) | ((b1 << 6) & 4032)) | (b2 & 63);
            } else if ((b0 & 248) == 240) {
                int b3;
                if (index == this.fOffset) {
                    b1 = this.fInputStream.read();
                } else {
                    b1 = this.fBuffer[index] & 255;
                    index++;
                }
                if (b1 == -1) {
                    expectedByte(2, 4);
                }
                if ((b1 & 192) != XMLChar.MASK_NCNAME) {
                    invalidByte(2, 3, b1);
                }
                if (index == this.fOffset) {
                    b2 = this.fInputStream.read();
                } else {
                    b2 = this.fBuffer[index] & 255;
                    index++;
                }
                if (b2 == -1) {
                    expectedByte(3, 4);
                }
                if ((b2 & 192) != XMLChar.MASK_NCNAME) {
                    invalidByte(3, 3, b2);
                }
                if (index == this.fOffset) {
                    b3 = this.fInputStream.read();
                    i = index;
                } else {
                    i = index + 1;
                    b3 = this.fBuffer[index] & 255;
                }
                if (b3 == -1) {
                    expectedByte(4, 4);
                }
                if ((b3 & 192) != XMLChar.MASK_NCNAME) {
                    invalidByte(4, 4, b3);
                }
                int uuuuu = ((b0 << 2) & 28) | ((b1 >> 4) & 3);
                if (uuuuu > 16) {
                    invalidSurrogate(uuuuu);
                }
                c = ((55296 | (((uuuuu - 1) << 6) & 960)) | ((b1 << 2) & 60)) | ((b2 >> 4) & 3);
                this.fSurrogate = (56320 | ((b2 << 6) & 960)) | (b3 & 63);
            } else {
                invalidByte(1, 1, b0);
                i = index;
            }
        } else {
            this.fSurrogate = -1;
        }
        return c;
    }

    public int read(char[] ch, int offset, int length) throws IOException {
        int count;
        int out = offset;
        int i = this.fSurrogate;
        if (r0 != -1) {
            ch[offset + 1] = (char) this.fSurrogate;
            this.fSurrogate = -1;
            length--;
            out++;
        }
        if (this.fOffset == 0) {
            if (length > this.fBuffer.length) {
                length = this.fBuffer.length;
            }
            count = this.fInputStream.read(this.fBuffer, 0, length);
            if (count == -1) {
                return -1;
            }
            count += out - offset;
        } else {
            count = this.fOffset;
            this.fOffset = 0;
        }
        int total = count;
        boolean isAscii = true;
        int lc = 0;
        int out2 = out;
        while (lc < total) {
            int b0 = this.fBuffer[lc] & 255;
            if (b0 >= 128) {
                isAscii = DEBUG_READ;
                break;
            }
            out = out2 + 1;
            ch[out2] = (char) b0;
            lc++;
            out2 = out;
        }
        if (isAscii) {
            out = out2;
            return count;
        }
        int in = lc;
        while (in < total) {
            b0 = this.fBuffer[in] & 255;
            if (b0 < 128) {
                out = out2 + 1;
                ch[out2] = (char) b0;
            } else {
                i = b0 & 224;
                int b1;
                if (r0 == 192) {
                    in++;
                    if (in < total) {
                        b1 = this.fBuffer[in] & 255;
                    } else {
                        b1 = this.fInputStream.read();
                        if (b1 == -1) {
                            if (out2 > offset) {
                                this.fBuffer[0] = (byte) b0;
                                this.fOffset = 1;
                                out = out2;
                                return out2 - offset;
                            }
                            expectedByte(2, 2);
                        }
                        count++;
                    }
                    i = b1 & 192;
                    if (r0 != 128) {
                        if (out2 > offset) {
                            this.fBuffer[0] = (byte) b0;
                            this.fBuffer[1] = (byte) b1;
                            this.fOffset = 2;
                            out = out2;
                            return out2 - offset;
                        }
                        invalidByte(2, 2, b1);
                    }
                    out = out2 + 1;
                    ch[out2] = (char) (((b0 << 6) & 1984) | (b1 & 63));
                    count--;
                } else {
                    i = b0 & 240;
                    int b2;
                    if (r0 == 224) {
                        in++;
                        if (in < total) {
                            b1 = this.fBuffer[in] & 255;
                        } else {
                            b1 = this.fInputStream.read();
                            if (b1 == -1) {
                                if (out2 > offset) {
                                    this.fBuffer[0] = (byte) b0;
                                    this.fOffset = 1;
                                    out = out2;
                                    return out2 - offset;
                                }
                                expectedByte(2, 3);
                            }
                            count++;
                        }
                        i = b1 & 192;
                        if (r0 != 128) {
                            if (out2 > offset) {
                                this.fBuffer[0] = (byte) b0;
                                this.fBuffer[1] = (byte) b1;
                                this.fOffset = 2;
                                out = out2;
                                return out2 - offset;
                            }
                            invalidByte(2, 3, b1);
                        }
                        in++;
                        if (in < total) {
                            b2 = this.fBuffer[in] & 255;
                        } else {
                            b2 = this.fInputStream.read();
                            if (b2 == -1) {
                                if (out2 > offset) {
                                    this.fBuffer[0] = (byte) b0;
                                    this.fBuffer[1] = (byte) b1;
                                    this.fOffset = 2;
                                    out = out2;
                                    return out2 - offset;
                                }
                                expectedByte(3, 3);
                            }
                            count++;
                        }
                        i = b2 & 192;
                        if (r0 != 128) {
                            if (out2 > offset) {
                                this.fBuffer[0] = (byte) b0;
                                this.fBuffer[1] = (byte) b1;
                                this.fBuffer[2] = (byte) b2;
                                this.fOffset = 3;
                                out = out2;
                                return out2 - offset;
                            }
                            invalidByte(3, 3, b2);
                        }
                        out = out2 + 1;
                        ch[out2] = (char) ((((b0 << 12) & 61440) | ((b1 << 6) & 4032)) | (b2 & 63));
                        count -= 2;
                    } else {
                        i = b0 & 248;
                        if (r0 == 240) {
                            int b3;
                            in++;
                            if (in < total) {
                                b1 = this.fBuffer[in] & 255;
                            } else {
                                b1 = this.fInputStream.read();
                                if (b1 == -1) {
                                    if (out2 > offset) {
                                        this.fBuffer[0] = (byte) b0;
                                        this.fOffset = 1;
                                        out = out2;
                                        return out2 - offset;
                                    }
                                    expectedByte(2, 4);
                                }
                                count++;
                            }
                            i = b1 & 192;
                            if (r0 != 128) {
                                if (out2 > offset) {
                                    this.fBuffer[0] = (byte) b0;
                                    this.fBuffer[1] = (byte) b1;
                                    this.fOffset = 2;
                                    out = out2;
                                    return out2 - offset;
                                }
                                invalidByte(2, 4, b1);
                            }
                            in++;
                            if (in < total) {
                                b2 = this.fBuffer[in] & 255;
                            } else {
                                b2 = this.fInputStream.read();
                                if (b2 == -1) {
                                    if (out2 > offset) {
                                        this.fBuffer[0] = (byte) b0;
                                        this.fBuffer[1] = (byte) b1;
                                        this.fOffset = 2;
                                        out = out2;
                                        return out2 - offset;
                                    }
                                    expectedByte(3, 4);
                                }
                                count++;
                            }
                            i = b2 & 192;
                            if (r0 != 128) {
                                if (out2 > offset) {
                                    this.fBuffer[0] = (byte) b0;
                                    this.fBuffer[1] = (byte) b1;
                                    this.fBuffer[2] = (byte) b2;
                                    this.fOffset = 3;
                                    out = out2;
                                    return out2 - offset;
                                }
                                invalidByte(3, 4, b2);
                            }
                            in++;
                            if (in < total) {
                                b3 = this.fBuffer[in] & 255;
                            } else {
                                b3 = this.fInputStream.read();
                                if (b3 == -1) {
                                    if (out2 > offset) {
                                        this.fBuffer[0] = (byte) b0;
                                        this.fBuffer[1] = (byte) b1;
                                        this.fBuffer[2] = (byte) b2;
                                        this.fOffset = 3;
                                        out = out2;
                                        return out2 - offset;
                                    }
                                    expectedByte(4, 4);
                                }
                                count++;
                            }
                            i = b3 & 192;
                            if (r0 != 128) {
                                if (out2 > offset) {
                                    this.fBuffer[0] = (byte) b0;
                                    this.fBuffer[1] = (byte) b1;
                                    this.fBuffer[2] = (byte) b2;
                                    this.fBuffer[3] = (byte) b3;
                                    this.fOffset = 4;
                                    out = out2;
                                    return out2 - offset;
                                }
                                invalidByte(4, 4, b2);
                            }
                            int uuuuu = ((b0 << 2) & 28) | ((b1 >> 4) & 3);
                            if (uuuuu > 16) {
                                invalidSurrogate(uuuuu);
                            }
                            int yyyyyy = b2 & 63;
                            int hs = ((55296 | (((uuuuu - 1) << 6) & 960)) | ((b1 & 15) << 2)) | (yyyyyy >> 4);
                            int ls = (56320 | ((yyyyyy << 6) & 960)) | (b3 & 63);
                            out = out2 + 1;
                            ch[out2] = (char) hs;
                            out2 = out + 1;
                            ch[out] = (char) ls;
                            count -= 2;
                            out = out2;
                        } else if (out2 > offset) {
                            this.fBuffer[0] = (byte) b0;
                            this.fOffset = 1;
                            out = out2;
                            return out2 - offset;
                        } else {
                            invalidByte(1, 1, b0);
                            out = out2;
                        }
                    }
                }
            }
            in++;
            out2 = out;
        }
        return count;
    }

    public long skip(long n) throws IOException {
        long remaining = n;
        char[] ch = new char[this.fBuffer.length];
        do {
            int count = read(ch, 0, ((long) ch.length) < remaining ? ch.length : (int) remaining);
            if (count <= 0) {
                break;
            }
            remaining -= (long) count;
        } while (remaining > 0);
        return n - remaining;
    }

    public boolean ready() throws IOException {
        return DEBUG_READ;
    }

    public boolean markSupported() {
        return DEBUG_READ;
    }

    public void mark(int readAheadLimit) throws IOException {
        throw new IOException(this.fFormatter.formatMessage(this.fLocale, "OperationNotSupported", new Object[]{"mark()", StringEncodings.UTF8}));
    }

    public void reset() throws IOException {
        this.fOffset = 0;
        this.fSurrogate = -1;
    }

    public void close() throws IOException {
        ThreadLocalBufferAllocator.getBufferAllocator().returnByteBuffer(this.fBuffer);
        this.fBuffer = null;
        this.fInputStream.close();
    }

    private void expectedByte(int position, int count) throws UTFDataFormatException {
        throw new UTFDataFormatException(this.fFormatter.formatMessage(this.fLocale, "ExpectedByte", new Object[]{Integer.toString(position), Integer.toString(count)}));
    }

    private void invalidByte(int position, int count, int c) throws UTFDataFormatException {
        throw new UTFDataFormatException(this.fFormatter.formatMessage(this.fLocale, "InvalidByte", new Object[]{Integer.toString(position), Integer.toString(count)}));
    }

    private void invalidSurrogate(int uuuuu) throws UTFDataFormatException {
        new StringBuffer().append("high surrogate bits in UTF-8 sequence must not exceed 0x10 but found 0x");
        throw new UTFDataFormatException(this.fFormatter.formatMessage(this.fLocale, "InvalidHighSurrogate", new Object[]{Integer.toHexString(uuuuu)}));
    }
}
