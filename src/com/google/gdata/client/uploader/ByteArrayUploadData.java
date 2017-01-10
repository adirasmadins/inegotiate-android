package com.google.gdata.client.uploader;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ByteArrayUploadData implements UploadData {
    private final byte[] buffer;
    private final ByteArrayInputStream stream;

    public ByteArrayUploadData(byte[] buffer) {
        this.buffer = buffer;
        this.stream = new ByteArrayInputStream(buffer);
    }

    public long length() {
        return (long) this.buffer.length;
    }

    public void read(byte[] destination) throws IOException {
        this.stream.read(destination);
    }

    public void setPosition(long position) {
        this.stream.reset();
        this.stream.skip(position);
    }

    public int read(byte[] chunk, int i, int length) {
        return this.stream.read(chunk, i, length);
    }
}
