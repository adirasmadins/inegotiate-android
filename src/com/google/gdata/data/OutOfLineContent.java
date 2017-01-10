package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.Versions;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;

public class OutOfLineContent extends Content implements IOutOfLineContent {
    protected String etag;
    protected String lang;
    protected long length;
    protected ContentType mimeType;
    protected String uri;

    public class AtomHandler extends ElementHandler {
        public void processAttribute(String namespace, String localName, String value) throws ParseException {
            if (namespace.equals(StringUtil.EMPTY_STRING)) {
                if (localName.equals("type")) {
                    try {
                        OutOfLineContent.this.mimeType = new ContentType(value);
                    } catch (Throwable e) {
                        throw new ParseException(CoreErrorDomain.ERR.invalidMimeType, e);
                    }
                } else if (localName.equals("src")) {
                    OutOfLineContent.this.uri = getAbsoluteUri(value);
                }
            } else if (namespace.equals(Namespaces.f443g) && localName.equals("etag")) {
                OutOfLineContent.this.setEtag(value);
            }
        }

        public void processEndElement() throws ParseException {
            if (OutOfLineContent.this.uri == null) {
                throw new ParseException(CoreErrorDomain.ERR.missingSrcAttribute);
            }
            OutOfLineContent.this.lang = this.xmlLang;
            super.processEndElement();
        }
    }

    public int getType() {
        return 7;
    }

    public ContentType getMimeType() {
        return this.mimeType;
    }

    public void setMimeType(ContentType v) {
        this.mimeType = v;
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String v) {
        this.lang = v;
    }

    public String getUri() {
        return this.uri;
    }

    public void setUri(String v) {
        this.uri = v;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long v) {
        this.length = v;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String v) {
        this.etag = v;
    }

    public void generateAtom(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(2);
        if (this.mimeType != null) {
            attrs.add(new Attribute("type", this.mimeType.getMediaType()));
        }
        if (this.uri != null) {
            attrs.add(new Attribute("src", this.uri));
        }
        if (!(this.etag == null || Service.getVersion().isCompatible(Versions.V1))) {
            attrs.add(new Attribute(Namespaces.gAlias, "etag", this.etag));
        }
        if (this.lang != null) {
            attrs.add(new Attribute("xml:lang", this.lang));
        }
        w.simpleElement(Namespaces.atomNs, "content", attrs, null);
    }

    public void generateRss(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(3);
        if (this.mimeType != null) {
            attrs.add(new Attribute("type", this.mimeType.getMediaType()));
        }
        if (this.uri != null) {
            attrs.add(new Attribute("url", this.uri));
        }
        if (this.length != -1) {
            attrs.add(new Attribute("length", Long.toString(this.length)));
        }
        w.simpleElement(Namespaces.rssNs, Rel.ENCLOSURE, attrs, null);
    }
}
