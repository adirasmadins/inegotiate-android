package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

@Beta
public final class LimitInputStream extends FilterInputStream {
    private long left;
    private long mark;

    public LimitInputStream(InputStream in, long limit) {
        super(in);
        this.mark = -1;
        Preconditions.checkNotNull(in);
        Preconditions.checkArgument(limit >= 0, "limit must be non-negative");
        this.left = limit;
    }

    public int available() throws IOException {
        return (int) Math.min((long) this.in.available(), this.left);
    }

    public synchronized void mark(int readlimit) {
        this.in.mark(readlimit);
        this.mark = this.left;
    }

    public int read() throws IOException {
        if (this.left == 0) {
            return -1;
        }
        int result = this.in.read();
        if (result == -1) {
            return result;
        }
        this.left--;
        return result;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        if (this.left == 0) {
            return -1;
        }
        int result = this.in.read(b, off, (int) Math.min((long) len, this.left));
        if (result == -1) {
            return result;
        }
        this.left -= (long) result;
        return result;
    }

    public synchronized void reset() throws IOException {
        if (!this.in.markSupported()) {
            throw new IOException("Mark not supported");
        } else if (this.mark == -1) {
            throw new IOException("Mark not set");
        } else {
            this.in.reset();
            this.left = this.mark;
        }
    }

    public long skip(long n) throws IOException {
        long skipped = this.in.skip(Math.min(n, this.left));
        this.left -= skipped;
        return skipped;
    }
}
