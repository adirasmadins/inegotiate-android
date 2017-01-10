package com.google.gdata.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.logging.Logger;

public class LoggableInputStream extends FilterInputStream {
    private boolean closed;
    private final Logger logger;
    private final StringWriter sw;

    public LoggableInputStream(Logger logger, InputStream stream) {
        super(stream);
        this.sw = new StringWriter();
        this.closed = false;
        this.logger = logger;
    }

    public void close() throws IOException {
        if (!this.closed) {
            this.logger.finest(this.sw.toString());
            this.closed = true;
        }
        super.close();
    }

    public int read() throws IOException {
        int readInt = super.read();
        this.sw.write(readInt);
        return readInt;
    }

    public int read(byte[] b, int off, int len) throws IOException {
        int read = super.read(b, off, len);
        if (read > 0) {
            this.sw.write(new String(b, off, read));
        }
        return read;
    }

    public int read(byte[] b) throws IOException {
        int read = super.read(b);
        if (read > 0) {
            this.sw.write(new String(b, 0, read));
        }
        return read;
    }
}
