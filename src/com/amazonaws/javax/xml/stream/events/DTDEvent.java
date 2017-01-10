package com.amazonaws.javax.xml.stream.events;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class DTDEvent extends DummyEvent implements DTD {
    private String fDoctypeDeclaration;
    private List fEntities;
    private List fNotations;

    public DTDEvent() {
        init();
    }

    public DTDEvent(String doctypeDeclaration) {
        init();
        this.fDoctypeDeclaration = doctypeDeclaration;
    }

    public void setDocumentTypeDeclaration(String doctypeDeclaration) {
        this.fDoctypeDeclaration = doctypeDeclaration;
    }

    public String getDocumentTypeDeclaration() {
        return this.fDoctypeDeclaration;
    }

    public void setEntities(List entites) {
        this.fEntities = entites;
    }

    public List getEntities() {
        return this.fEntities;
    }

    public void setNotations(List notations) {
        this.fNotations = notations;
    }

    public List getNotations() {
        return this.fNotations;
    }

    public Object getProcessedDTD() {
        return null;
    }

    protected void init() {
        setEventType(11);
    }

    public String toString() {
        return this.fDoctypeDeclaration;
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write(this.fDoctypeDeclaration);
    }
}
