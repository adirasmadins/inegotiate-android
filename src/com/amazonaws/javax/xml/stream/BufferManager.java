package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.CharBuffer;

public abstract class BufferManager {
    static boolean DEBUG;
    protected boolean endOfStream;

    public abstract boolean arrangeCapacity(int i) throws IOException;

    public abstract void close() throws IOException;

    public abstract CharBuffer getCharBuffer();

    public abstract boolean getMore() throws IOException;

    public abstract void setEncoding(String str) throws IOException;

    public BufferManager() {
        this.endOfStream = false;
    }

    static {
        DEBUG = false;
    }

    public static BufferManager getBufferManager(XMLInputSource inputSource) throws IOException {
        InputStream stream = inputSource.getByteStream();
        if (stream instanceof FileInputStream) {
            if (DEBUG) {
                System.out.println("Using FileBufferManager");
            }
            return new FileBufferManager((FileInputStream) stream, inputSource.getEncoding());
        }
        if (DEBUG) {
            System.out.println("Using StreamBufferManager");
        }
        return new StreamBufferManager(stream, inputSource.getEncoding());
    }

    public boolean endOfStream() {
        return this.endOfStream;
    }

    protected Object[] getEncodingName(byte[] b4, int count) {
        if (count < 2) {
            return new Object[]{StringEncodings.UTF8, null};
        }
        int b0 = b4[0] & 255;
        int b1 = b4[1] & 255;
        if (b0 == 254 && b1 == 255) {
            return new Object[]{"UTF-16BE", new Boolean(true)};
        } else if (b0 == 255 && b1 == 254) {
            return new Object[]{"UTF-16LE", new Boolean(false)};
        } else if (count < 3) {
            return new Object[]{StringEncodings.UTF8, null};
        } else {
            int b2 = b4[2] & 255;
            if (b0 == 239 && b1 == 187 && b2 == 191) {
                return new Object[]{StringEncodings.UTF8, null};
            } else if (count < 4) {
                return new Object[]{StringEncodings.UTF8, null};
            } else {
                int b3 = b4[3] & 255;
                if (b0 == 0 && b1 == 0 && b2 == 0 && b3 == 60) {
                    return new Object[]{"ISO-10646-UCS-4", new Boolean(true)};
                } else if (b0 == 60 && b1 == 0 && b2 == 0 && b3 == 0) {
                    return new Object[]{"ISO-10646-UCS-4", new Boolean(false)};
                } else if (b0 == 0 && b1 == 0 && b2 == 60 && b3 == 0) {
                    return new Object[]{"ISO-10646-UCS-4", null};
                } else if (b0 == 0 && b1 == 60 && b2 == 0 && b3 == 0) {
                    return new Object[]{"ISO-10646-UCS-4", null};
                } else if (b0 == 0 && b1 == 60 && b2 == 0 && b3 == 63) {
                    return new Object[]{"UTF-16BE", new Boolean(true)};
                } else if (b0 == 60 && b1 == 0 && b2 == 63 && b3 == 0) {
                    return new Object[]{"UTF-16LE", new Boolean(false)};
                } else if (b0 == 76 && b1 == 111 && b2 == 167 && b3 == 148) {
                    return new Object[]{"CP037", null};
                } else {
                    return new Object[]{StringEncodings.UTF8, null};
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File(args[0]);
            System.out.println(new StringBuffer().append("url parameter = ").append(file.toURI().toString()).toString());
            URL url = new URL(file.toURI().toString());
            BufferManager sb = getBufferManager(new XMLInputSource(null, null, null, new FileInputStream(file), StringEncodings.UTF8));
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
}
