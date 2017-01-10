package com.google.api.client.xml;

import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;

public class XmlHttpContent extends AbstractXmlHttpContent {
    public Object data;
    public String elementName;

    public final void writeTo(XmlSerializer serializer) throws IOException {
        this.namespaceDictionary.serialize(serializer, this.elementName, this.data);
    }
}
