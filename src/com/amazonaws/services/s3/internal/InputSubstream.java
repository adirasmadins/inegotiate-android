package com.amazonaws.services.s3.internal;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class InputSubstream extends FilterInputStream {
    private final boolean closeSourceStream;
    private long currentPosition;
    private long markedPosition;
    private final long requestedLength;
    private final long requestedOffset;

    public InputSubstream(InputStream inputStream, long j, long j2, boolean z) {
        super(inputStream);
        this.markedPosition = 0;
        this.currentPosition = 0;
        this.requestedLength = j2;
        this.requestedOffset = j;
        this.closeSourceStream = z;
    }

    public int available() throws IOException {
        return (int) Math.min(this.currentPosition < this.requestedOffset ? this.requestedLength : (this.requestedLength + this.requestedOffset) - this.currentPosition, (long) super.available());
    }

    public void close() throws IOException {
        if (this.closeSourceStream) {
            super.close();
        }
    }

    public synchronized void mark(int i) {
        this.markedPosition = this.currentPosition;
        super.mark(i);
    }

    public int read() throws IOException {
        byte[] bArr = new byte[1];
        int read = read(bArr, 0, 1);
        return read == -1 ? read : bArr[0];
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        while (this.currentPosition < this.requestedOffset) {
            this.currentPosition = super.skip(this.requestedOffset - this.currentPosition) + this.currentPosition;
        }
        long j = (this.requestedLength + this.requestedOffset) - this.currentPosition;
        if (j <= 0) {
            return -1;
        }
        int read = super.read(bArr, i, (int) Math.min((long) i2, j));
        this.currentPosition += (long) read;
        return read;
    }

    public synchronized void reset() throws IOException {
        this.currentPosition = this.markedPosition;
        super.reset();
    }
}
