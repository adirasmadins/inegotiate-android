package com.amazonaws.javax.xml.stream.writers;

import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.amazonaws.services.s3.model.ProgressEvent;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

public final class UTF8OutputStreamWriter extends Writer {
    int lastUTF16CodePoint;
    OutputStream out;

    public UTF8OutputStreamWriter(OutputStream out) {
        this.lastUTF16CodePoint = 0;
        this.out = out;
    }

    public String getEncoding() {
        return StringEncodings.UTF8;
    }

    public void write(int c) throws IOException {
        if (this.lastUTF16CodePoint != 0) {
            int uc = (((this.lastUTF16CodePoint & 1023) << 10) | (c & 1023)) + 65536;
            if (uc < 0 || uc >= 2097152) {
                throw new IOException(new StringBuffer().append("Atttempting to write invalid Unicode code point '").append(uc).append("'").toString());
            }
            this.out.write((uc >> 18) | 240);
            this.out.write(((uc >> 12) & 63) | XMLChar.MASK_NCNAME);
            this.out.write(((uc >> 6) & 63) | XMLChar.MASK_NCNAME);
            this.out.write((uc & 63) | XMLChar.MASK_NCNAME);
            this.lastUTF16CodePoint = 0;
        } else if (c < XMLChar.MASK_NCNAME) {
            this.out.write(c);
        } else if (c < ProgressEvent.PART_COMPLETED_EVENT_CODE) {
            this.out.write((c >> 6) | 192);
            this.out.write((c & 63) | XMLChar.MASK_NCNAME);
        } else if (c > 65535) {
        } else {
            if (XMLChar.isHighSurrogate(c) || XMLChar.isLowSurrogate(c)) {
                this.lastUTF16CodePoint = c;
                return;
            }
            this.out.write((c >> 12) | 224);
            this.out.write(((c >> 6) & 63) | XMLChar.MASK_NCNAME);
            this.out.write((c & 63) | XMLChar.MASK_NCNAME);
        }
    }

    public void write(char[] cbuf) throws IOException {
        for (int write : cbuf) {
            write(write);
        }
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        for (int i = 0; i < len; i++) {
            write(cbuf[off + i]);
        }
    }

    public void write(String str) throws IOException {
        int len = str.length();
        for (int i = 0; i < len; i++) {
            write(str.charAt(i));
        }
    }

    public void write(String str, int off, int len) throws IOException {
        for (int i = 0; i < len; i++) {
            write(str.charAt(off + i));
        }
    }

    public void flush() throws IOException {
        this.out.flush();
    }

    public void close() throws IOException {
        if (this.lastUTF16CodePoint != 0) {
            throw new IllegalStateException("Attempting to close a UTF8OutputStreamWriter while awaiting for a UTF-16 code unit");
        }
        this.out.close();
    }
}
