package com.google.gdata.client.uploader;

import java.io.IOException;

public interface UploadData {
    long length();

    int read(byte[] bArr, int i, int i2) throws IOException;

    void read(byte[] bArr) throws IOException;

    void setPosition(long j) throws IOException;
}
