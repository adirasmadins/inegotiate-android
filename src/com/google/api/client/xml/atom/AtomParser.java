package com.google.api.client.xml.atom;

import com.google.api.client.xml.XmlHttpParser;

public final class AtomParser extends XmlHttpParser {
    public AtomParser() {
        this.contentType = Atom.CONTENT_TYPE;
    }
}
