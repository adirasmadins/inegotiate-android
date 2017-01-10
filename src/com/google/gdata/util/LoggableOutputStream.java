package com.google.gdata.util;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Logger;

public class LoggableOutputStream extends FilterOutputStream {
    private ByteArrayOutputStream bos;
    private Logger logger;

    public LoggableOutputStream(Logger logger, OutputStream stream) {
        super(stream);
        this.bos = new ByteArrayOutputStream();
        this.logger = logger;
    }

    public void write(int b) throws IOException {
        super.write(b);
        this.bos.write(b);
    }

    public void close() throws IOException {
        super.close();
        this.logger.finest(this.bos.toString());
    }

    public void flush() throws IOException {
        super.flush();
        this.logger.finest(this.bos.toString());
        this.bos = new ByteArrayOutputStream();
    }
}
