package com.amazonaws.services.s3.internal.crypto;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteRangeCapturingInputStream extends FilterInputStream {
    private final byte[] block;
    private int blockPosition;
    private final long endingPosition;
    private int markedBlockPosition;
    private long markedStreamPosition;
    private final long startingPosition;
    private long streamPosition;

    public ByteRangeCapturingInputStream(InputStream inputStream, long j, long j2) {
        super(inputStream);
        this.blockPosition = 0;
        if (j >= j2) {
            throw new IllegalArgumentException("Invalid byte range specified: the starting position must be less than the ending position");
        }
        this.startingPosition = j;
        this.endingPosition = j2;
        this.block = new byte[((int) (j2 - j))];
    }

    public byte[] getBlock() {
        return this.block;
    }

    public synchronized void mark(int i) {
        super.mark(i);
        if (markSupported()) {
            this.markedStreamPosition = this.streamPosition;
            this.markedBlockPosition = this.blockPosition;
        }
    }

    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            return -1;
        }
        if (this.streamPosition >= this.startingPosition && this.streamPosition <= this.endingPosition) {
            byte[] bArr = this.block;
            int i = this.blockPosition;
            this.blockPosition = i + 1;
            bArr[i] = (byte) read;
        }
        this.streamPosition++;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        if (this.streamPosition + ((long) read) >= this.startingPosition && this.streamPosition <= this.endingPosition) {
            int i3 = 0;
            while (i3 < read) {
                if (this.streamPosition + ((long) i3) >= this.startingPosition && this.streamPosition + ((long) i3) < this.endingPosition) {
                    byte[] bArr2 = this.block;
                    int i4 = this.blockPosition;
                    this.blockPosition = i4 + 1;
                    bArr2[i4] = bArr[i + i3];
                }
                i3++;
            }
        }
        this.streamPosition += (long) read;
        return read;
    }

    public synchronized void reset() throws IOException {
        super.reset();
        if (markSupported()) {
            this.streamPosition = this.markedStreamPosition;
            this.blockPosition = this.markedBlockPosition;
        }
    }
}
