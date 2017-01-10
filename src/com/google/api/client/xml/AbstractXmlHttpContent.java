package com.google.api.client.xml;

import com.google.api.client.http.HttpContent;
import java.io.IOException;
import java.io.OutputStream;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbstractXmlHttpContent implements HttpContent {
    public String contentType;
    public XmlNamespaceDictionary namespaceDictionary;

    protected abstract void writeTo(XmlSerializer xmlSerializer) throws IOException;

    public AbstractXmlHttpContent() {
        this.contentType = XmlHttpParser.CONTENT_TYPE;
    }

    public String getEncoding() {
        return null;
    }

    public long getLength() {
        return -1;
    }

    public final String getType() {
        return this.contentType;
    }

    public final void writeTo(OutputStream out) throws IOException {
        XmlSerializer serializer = Xml.createSerializer();
        serializer.setOutput(out, StringEncodings.UTF8);
        writeTo(serializer);
    }
}
