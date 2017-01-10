package com.amazonaws.javax.xml.stream.writers;

import com.amazonaws.javax.xml.stream.xerces.util.XMLStringBuffer;
import java.io.IOException;
import java.io.Writer;

public class XMLWriter extends Writer {
    private static final boolean DEBUG = false;
    private static final int THRESHHOLD_LENGTH = 4096;
    private XMLStringBuffer buffer;
    private int size;
    private Writer writer;

    public XMLWriter(Writer writer) {
        this(writer, THRESHHOLD_LENGTH);
    }

    public XMLWriter(Writer writer, int size) {
        this.buffer = new XMLStringBuffer(12288);
        this.writer = writer;
        this.size = size;
    }

    public void write(int c) throws IOException {
        ensureOpen();
        this.buffer.append((char) c);
        conditionalWrite();
    }

    public void write(char[] cbuf) throws IOException {
        write(cbuf, 0, cbuf.length);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        ensureOpen();
        if (len > this.size) {
            writeBufferedData();
            this.writer.write(cbuf, off, len);
            return;
        }
        this.buffer.append(cbuf, off, len);
        conditionalWrite();
    }

    public void write(String str, int off, int len) throws IOException {
        write(str.toCharArray(), off, len);
    }

    public void write(String str) throws IOException {
        if (str.length() > this.size) {
            writeBufferedData();
            this.writer.write(str);
            return;
        }
        this.buffer.append(str);
        conditionalWrite();
    }

    public void close() throws IOException {
        if (this.writer != null) {
            flush();
            this.writer.close();
            this.writer = null;
        }
    }

    public void flush() throws IOException {
        ensureOpen();
        writeBufferedData();
        this.writer.flush();
    }

    public void reset() {
        this.writer = null;
        this.buffer.clear();
        this.size = THRESHHOLD_LENGTH;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
        this.buffer.clear();
        this.size = THRESHHOLD_LENGTH;
    }

    public void setWriter(Writer writer, int size) {
        this.writer = writer;
        this.size = size;
    }

    protected Writer getWriter() {
        return this.writer;
    }

    private void conditionalWrite() throws IOException {
        if (this.buffer.length > this.size) {
            writeBufferedData();
        }
    }

    private void writeBufferedData() throws IOException {
        this.writer.write(this.buffer.ch, this.buffer.offset, this.buffer.length);
        this.buffer.clear();
    }

    private void ensureOpen() throws IOException {
        if (this.writer == null) {
            throw new IOException("Stream closed");
        }
    }
}
