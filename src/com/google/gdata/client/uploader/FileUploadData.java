package com.google.gdata.client.uploader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileUploadData implements UploadData {
    private final File file;
    private FileInputStream stream;

    public FileUploadData(File file) throws IOException {
        if (file == null) {
            throw new IOException();
        }
        this.file = file;
        if (file.exists() && file.canRead()) {
            this.stream = new FileInputStream(file);
            return;
        }
        throw new IOException();
    }

    public long length() {
        return this.file.length();
    }

    public void read(byte[] destination) throws IOException {
        this.stream.read(destination);
    }

    public void setPosition(long position) throws IOException {
        this.stream = new FileInputStream(this.file);
        this.stream.skip(position);
    }

    public int read(byte[] chunk, int i, int length) throws IOException {
        return this.stream.read(chunk, i, length);
    }

    public String getFileName() {
        return this.file.getName();
    }
}
