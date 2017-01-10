package com.google.gdata.data;

import java.io.InputStream;
import java.io.Reader;

public class ParseSource {
    private final XmlEventSource eventSource;
    private final InputStream inputStream;
    private final Reader reader;

    public ParseSource(Reader reader) {
        this.reader = reader;
        this.inputStream = null;
        this.eventSource = null;
    }

    public ParseSource(InputStream inputStream) {
        this.inputStream = inputStream;
        this.reader = null;
        this.eventSource = null;
    }

    public ParseSource(XmlEventSource eventSource) {
        this.eventSource = eventSource;
        this.reader = null;
        this.inputStream = null;
    }

    public final Reader getReader() {
        return this.reader;
    }

    public final InputStream getInputStream() {
        return this.inputStream;
    }

    public final XmlEventSource getEventSource() {
        return this.eventSource;
    }
}
