package com.google.gdata.util.io.base;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackInputStream;
import java.io.Reader;

public class UnicodeReader extends Reader {
    private static final int BOM_SIZE = 4;
    private final String defaultEnc;
    private final InputStreamReader internalInputStreamReader;

    public UnicodeReader(InputStream in, String defaultEnc) throws IOException {
        String encoding;
        int unread;
        this.defaultEnc = defaultEnc;
        byte[] bom = new byte[BOM_SIZE];
        PushbackInputStream pushbackStream = new PushbackInputStream(in, BOM_SIZE);
        int n = pushbackStream.read(bom, 0, bom.length);
        if (bom[0] == -17 && bom[1] == -69 && bom[2] == -65) {
            encoding = StringEncodings.UTF8;
            unread = n - 3;
        } else if (bom[0] == (byte) -2 && bom[1] == (byte) -1) {
            encoding = "UTF-16BE";
            unread = n - 2;
        } else if (bom[0] == (byte) -1 && bom[1] == (byte) -2) {
            encoding = "UTF-16LE";
            unread = n - 2;
        } else if (bom[0] == null && bom[1] == null && bom[2] == (byte) -2 && bom[3] == (byte) -1) {
            encoding = "UTF-32BE";
            unread = n - 4;
        } else if (bom[0] == (byte) -1 && bom[1] == (byte) -2 && bom[2] == null && bom[3] == null) {
            encoding = "UTF-32LE";
            unread = n - 4;
        } else {
            encoding = defaultEnc;
            unread = n;
        }
        if (unread > 0) {
            pushbackStream.unread(bom, n - unread, unread);
        } else if (unread < -1) {
            pushbackStream.unread(bom, 0, 0);
        }
        if (encoding == null) {
            this.internalInputStreamReader = new InputStreamReader(pushbackStream);
        } else {
            this.internalInputStreamReader = new InputStreamReader(pushbackStream, encoding);
        }
    }

    public String getDefaultEncoding() {
        return this.defaultEnc;
    }

    public String getEncoding() {
        return this.internalInputStreamReader.getEncoding();
    }

    public void close() throws IOException {
        this.internalInputStreamReader.close();
    }

    public int read(char[] cbuf, int off, int len) throws IOException {
        return this.internalInputStreamReader.read(cbuf, off, len);
    }
}
