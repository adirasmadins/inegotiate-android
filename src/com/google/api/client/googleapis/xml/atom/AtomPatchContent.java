package com.google.api.client.googleapis.xml.atom;

import com.google.api.client.xml.XmlHttpParser;
import com.google.api.client.xml.atom.AtomContent;

public final class AtomPatchContent extends AtomContent {
    public AtomPatchContent() {
        this.contentType = XmlHttpParser.CONTENT_TYPE;
    }
}
