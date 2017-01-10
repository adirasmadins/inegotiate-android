package com.google.api.client.http;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class InputStreamContent implements HttpContent {
    private static final int BUFFER_SIZE = 2048;
    public String encoding;
    public InputStream inputStream;
    public long length;
    public String type;

    public InputStreamContent() {
        this.length = -1;
    }

    public void setFileInput(File file) throws FileNotFoundException {
        this.inputStream = new FileInputStream(file);
        this.length = file.length();
    }

    public void setByteArrayInput(byte[] content) {
        this.inputStream = new ByteArrayInputStream(content);
        this.length = (long) content.length;
    }

    public void writeTo(OutputStream out) throws IOException {
        InputStream inputStream = this.inputStream;
        long contentLength = this.length;
        if (contentLength < 0) {
            copy(inputStream, out);
            return;
        }
        byte[] buffer = new byte[BUFFER_SIZE];
        long remaining = contentLength;
        while (remaining > 0) {
            try {
                int read = inputStream.read(buffer, 0, (int) Math.min(2048, remaining));
                if (read == -1) {
                    break;
                }
                out.write(buffer, 0, read);
                remaining -= (long) read;
            } catch (Throwable th) {
                inputStream.close();
            }
        }
        inputStream.close();
    }

    public String getEncoding() {
        return this.encoding;
    }

    public long getLength() {
        return this.length;
    }

    public String getType() {
        return this.type;
    }

    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        try {
            byte[] tmp = new byte[BUFFER_SIZE];
            while (true) {
                int bytesRead = inputStream.read(tmp);
                if (bytesRead == -1) {
                    break;
                }
                outputStream.write(tmp, 0, bytesRead);
            }
        } finally {
            inputStream.close();
        }
    }
}
