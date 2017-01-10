package com.amazonaws.services.s3.internal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RepeatableFileInputStream extends InputStream {
    private static final Log log;
    private long bytesReadPastMarkPoint;
    private File file;
    private FileInputStream fis;
    private long markPoint;

    static {
        log = LogFactory.getLog(RepeatableFileInputStream.class);
    }

    public RepeatableFileInputStream(File file) throws FileNotFoundException {
        this.file = null;
        this.fis = null;
        this.bytesReadPastMarkPoint = 0;
        this.markPoint = 0;
        if (file == null) {
            throw new IllegalArgumentException("File cannot be null");
        }
        this.fis = new FileInputStream(file);
        this.file = file;
    }

    public int available() throws IOException {
        return this.fis.available();
    }

    public void close() throws IOException {
        this.fis.close();
    }

    public InputStream getWrappedInputStream() {
        return this.fis;
    }

    public void mark(int i) {
        this.markPoint += this.bytesReadPastMarkPoint;
        this.bytesReadPastMarkPoint = 0;
        if (log.isDebugEnabled()) {
            log.debug("Input stream marked at " + this.markPoint + " bytes");
        }
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        int read = this.fis.read();
        if (read == -1) {
            return -1;
        }
        this.bytesReadPastMarkPoint++;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.fis.read(bArr, i, i2);
        this.bytesReadPastMarkPoint += (long) read;
        return read;
    }

    public void reset() throws IOException {
        this.fis.close();
        this.fis = new FileInputStream(this.file);
        long j = this.markPoint;
        while (j > 0) {
            j -= this.fis.skip(j);
        }
        if (log.isDebugEnabled()) {
            log.debug("Reset to mark point " + this.markPoint + " after returning " + this.bytesReadPastMarkPoint + " bytes");
        }
        this.bytesReadPastMarkPoint = 0;
    }

    public long skip(long j) throws IOException {
        long skip = this.fis.skip(j);
        this.bytesReadPastMarkPoint += skip;
        return skip;
    }
}
