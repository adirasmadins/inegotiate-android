package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import java.io.IOException;
import java.io.Writer;

public class CommentEvent extends DummyEvent implements Comment {
    private String fText;

    public CommentEvent() {
        init();
    }

    public CommentEvent(String text) {
        init();
        this.fText = text;
    }

    protected void init() {
        setEventType(5);
    }

    public String toString() {
        return new StringBuffer().append(XMLStreamWriterImpl.START_COMMENT).append(getText()).append(XMLStreamWriterImpl.END_COMMENT).toString();
    }

    public String getText() {
        return this.fText;
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write(new StringBuffer().append(XMLStreamWriterImpl.START_COMMENT).append(getText()).append(XMLStreamWriterImpl.END_COMMENT).toString());
    }
}
