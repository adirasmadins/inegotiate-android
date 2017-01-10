package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;

public class StaxXMLInputSource {
    XMLEventReader fEventReader;
    XMLInputSource fInputSource;
    XMLStreamReader fStreamReader;

    public StaxXMLInputSource(XMLStreamReader streamReader) {
        this.fStreamReader = streamReader;
    }

    public StaxXMLInputSource(XMLEventReader eventReader) {
        this.fEventReader = eventReader;
    }

    public StaxXMLInputSource(XMLInputSource inputSource) {
        this.fInputSource = inputSource;
    }

    public XMLStreamReader getXMLStreamReader() {
        return this.fStreamReader;
    }

    public XMLEventReader getXMLEventReader() {
        return this.fEventReader;
    }

    public XMLInputSource getXMLInputSource() {
        return this.fInputSource;
    }

    public boolean hasXMLStreamOrXMLEventReader() {
        return (this.fStreamReader == null && this.fEventReader == null) ? false : true;
    }
}
