package com.google.api.client.xml.atom;

import com.google.api.client.xml.AbstractXmlHttpContent;
import com.google.gdata.util.Namespaces;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

public class AtomContent extends AbstractXmlHttpContent {
    public Object entry;

    public AtomContent() {
        this.contentType = Atom.CONTENT_TYPE;
    }

    public final void writeTo(XmlSerializer serializer) throws IOException {
        this.namespaceDictionary.serialize(serializer, Namespaces.atom, "entry", this.entry);
    }
}
