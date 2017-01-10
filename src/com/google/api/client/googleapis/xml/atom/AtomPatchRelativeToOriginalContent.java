package com.google.api.client.googleapis.xml.atom;

import com.google.api.client.xml.AbstractXmlHttpContent;
import com.google.gdata.util.Namespaces;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

public final class AtomPatchRelativeToOriginalContent extends AbstractXmlHttpContent {
    public Object originalEntry;
    public Object patchedEntry;

    protected void writeTo(XmlSerializer serializer) throws IOException {
        this.namespaceDictionary.serialize(serializer, Namespaces.atom, "entry", GData.computePatch(this.patchedEntry, this.originalEntry));
    }
}
