package com.amazonaws.services.s3.internal.crypto;

import java.io.IOException;
import java.io.InputStream;

public class AdjustedRangeInputStream extends InputStream {
    private boolean closed;
    private InputStream decryptedContents;
    private long virtualAvailable;

    public AdjustedRangeInputStream(InputStream inputStream, long j, long j2) throws IOException {
        this.decryptedContents = inputStream;
        this.closed = false;
        initializeForRead(j, j2);
    }

    private void initializeForRead(long j, long j2) throws IOException {
        int i = j < ((long) JceEncryptionConstants.SYMMETRIC_CIPHER_BLOCK_SIZE) ? (int) j : ((int) (j % ((long) JceEncryptionConstants.SYMMETRIC_CIPHER_BLOCK_SIZE))) + JceEncryptionConstants.SYMMETRIC_CIPHER_BLOCK_SIZE;
        if (i != 0) {
            while (i > 0) {
                this.decryptedContents.read();
                i--;
            }
        }
        this.virtualAvailable = (long) (((int) (j2 - j)) + 1);
    }

    public int available() throws IOException {
        int available = this.decryptedContents.available();
        return ((long) available) < this.virtualAvailable ? available : (int) this.virtualAvailable;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.closed = true;
            this.decryptedContents.close();
        }
    }

    public int read() throws IOException {
        int read = this.virtualAvailable <= 0 ? -1 : this.decryptedContents.read();
        if (read != -1) {
            this.virtualAvailable--;
        } else {
            close();
            this.virtualAvailable = 0;
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.virtualAvailable <= 0) {
            i3 = -1;
        } else {
            i3 = ((long) i2) > this.virtualAvailable ? this.virtualAvailable < 2147483647L ? (int) this.virtualAvailable : Integer.MAX_VALUE : i2;
            i3 = this.decryptedContents.read(bArr, i, i3);
        }
        if (i3 != -1) {
            this.virtualAvailable -= (long) i3;
        } else {
            close();
            this.virtualAvailable = 0;
        }
        return i3;
    }
}
