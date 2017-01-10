package com.amazonaws.services.s3.internal;

import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class RepeatableInputStream extends InputStream {
    private static final Log log;
    private byte[] buffer;
    private int bufferOffset;
    private int bufferSize;
    private long bytesReadPastMark;
    private InputStream is;

    static {
        log = LogFactory.getLog(RepeatableInputStream.class);
    }

    public RepeatableInputStream(InputStream inputStream, int i) {
        this.is = null;
        this.bufferSize = 0;
        this.bufferOffset = 0;
        this.bytesReadPastMark = 0;
        this.buffer = null;
        if (inputStream == null) {
            throw new IllegalArgumentException("InputStream cannot be null");
        }
        this.is = inputStream;
        this.bufferSize = i;
        this.buffer = new byte[this.bufferSize];
        if (log.isDebugEnabled()) {
            log.debug("Underlying input stream will be repeatable up to " + this.buffer.length + " bytes");
        }
    }

    public int available() throws IOException {
        return this.is.available();
    }

    public void close() throws IOException {
        this.is.close();
    }

    public InputStream getWrappedInputStream() {
        return this.is;
    }

    public synchronized void mark(int i) {
        if (log.isDebugEnabled()) {
            log.debug("Input stream marked at " + this.bytesReadPastMark + " bytes");
        }
        if (this.bytesReadPastMark > ((long) this.bufferSize) || this.buffer == null) {
            this.bufferOffset = 0;
            this.bytesReadPastMark = 0;
            this.buffer = new byte[this.bufferSize];
        } else {
            Object obj = new byte[this.bufferSize];
            System.arraycopy(this.buffer, this.bufferOffset, obj, 0, (int) (this.bytesReadPastMark - ((long) this.bufferOffset)));
            this.buffer = obj;
            this.bytesReadPastMark -= (long) this.bufferOffset;
            this.bufferOffset = 0;
        }
    }

    public boolean markSupported() {
        return true;
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr);
        return read != -1 ? bArr[0] : read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read;
        Object obj = new byte[i2];
        if (((long) this.bufferOffset) >= this.bytesReadPastMark || this.buffer == null) {
            read = this.is.read(obj);
            if (read > 0) {
                if (this.bytesReadPastMark + ((long) read) <= ((long) this.bufferSize)) {
                    System.arraycopy(obj, 0, this.buffer, (int) this.bytesReadPastMark, read);
                    this.bufferOffset += read;
                } else if (this.buffer != null) {
                    if (log.isDebugEnabled()) {
                        log.debug("Buffer size " + this.bufferSize + " has been exceeded and the input stream " + "will not be repeatable until the next mark. Freeing buffer memory");
                    }
                    this.buffer = null;
                }
                System.arraycopy(obj, 0, bArr, i, read);
                this.bytesReadPastMark += (long) read;
            }
        } else {
            read = obj.length;
            if (((long) (this.bufferOffset + read)) > this.bytesReadPastMark) {
                read = ((int) this.bytesReadPastMark) - this.bufferOffset;
            }
            System.arraycopy(this.buffer, this.bufferOffset, bArr, i, read);
            this.bufferOffset += read;
        }
        return read;
    }

    public void reset() throws IOException {
        if (this.bytesReadPastMark <= ((long) this.bufferSize)) {
            if (log.isDebugEnabled()) {
                log.debug("Reset after reading " + this.bytesReadPastMark + " bytes.");
            }
            this.bufferOffset = 0;
            return;
        }
        throw new IOException("Input stream cannot be reset as " + this.bytesReadPastMark + " bytes have been written, exceeding the available buffer size of " + this.bufferSize);
    }
}
