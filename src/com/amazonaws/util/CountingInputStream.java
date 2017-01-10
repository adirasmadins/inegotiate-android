package com.amazonaws.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream extends FilterInputStream {
    private long byteCount;

    public CountingInputStream(InputStream inputStream) {
        super(inputStream);
        this.byteCount = 0;
    }

    public long getByteCount() {
        return this.byteCount;
    }

    public int read() throws IOException {
        int read = super.read();
        this.byteCount = (read >= 0 ? 1 : 0) + this.byteCount;
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        this.byteCount = (read >= 0 ? (long) read : 0) + this.byteCount;
        return read;
    }
}
