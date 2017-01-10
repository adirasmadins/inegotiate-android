package com.amazonaws.javax.xml.stream.events;

import java.io.IOException;
import java.io.Writer;

public class EndDocumentEvent extends DummyEvent implements EndDocument {
    public EndDocumentEvent() {
        init();
    }

    protected void init() {
        setEventType(8);
    }

    public String toString() {
        return "ENDDOCUMENT";
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
    }
}
