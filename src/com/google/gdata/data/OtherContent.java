package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlBlob;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.util.Base64;
import com.google.gdata.util.common.util.Base64DecoderException;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.xml.sax.Attributes;

public class OtherContent extends Content {
    protected byte[] bytes;
    protected Extension ext;
    protected String lang;
    protected ContentType mimeType;
    protected String text;
    protected XmlBlob xml;

    public class AtomHandler extends ElementHandler {
        private final ExtensionProfile extProfile;
        private final int type;

        AtomHandler(ExtensionProfile extProfile, Attributes attrs) throws IOException {
            this.extProfile = extProfile;
            String typeAttr = attrs.getValue(StringUtil.EMPTY_STRING, "type");
            if ("application/atom+xml;type=feed".equals(typeAttr)) {
                OtherContent.this.ext = new Feed();
                this.type = 5;
            } else if ("application/atom+xml;type=entry".equals(typeAttr)) {
                this.type = 5;
                OtherContent.this.ext = new Entry();
            } else if (typeAttr.endsWith("+xml") || typeAttr.endsWith("/xml")) {
                this.type = 5;
                OtherContent.this.xml = new XmlBlob();
                initializeXmlBlob(OtherContent.this.xml, true, true);
            } else if (typeAttr.startsWith("text/")) {
                this.type = 4;
            } else {
                this.type = 6;
            }
        }

        public void processAttribute(String namespace, String localName, String value) throws ParseException {
            if (namespace.equals(StringUtil.EMPTY_STRING) && localName.equals("type")) {
                try {
                    OtherContent.this.mimeType = new ContentType(value);
                } catch (Throwable e) {
                    throw new ParseException(CoreErrorDomain.ERR.invalidMimeType, e);
                }
            }
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (OtherContent.this.ext != null) {
                return OtherContent.this.ext.getHandler(this.extProfile, namespace, localName, attrs);
            }
            return super.getChildHandler(namespace, localName, attrs);
        }

        public void processEndElement() throws ParseException {
            switch (this.type) {
                case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                    OtherContent.this.text = this.value;
                    OtherContent.this.lang = this.xmlLang;
                case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                    if (this.value != null) {
                        try {
                            OtherContent.this.bytes = Base64.decode(this.value);
                        } catch (Base64DecoderException e) {
                            throw new ParseException(CoreErrorDomain.ERR.invalidBase64);
                        }
                    }
                    OtherContent.this.lang = this.xmlLang;
                default:
                    throw new AssertionError("Invalid type for other content.");
            }
        }
    }

    public int getType() {
        if (this.ext != null || this.xml != null) {
            return 5;
        }
        if (this.text != null) {
            return 4;
        }
        return 6;
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

    public Extension getXmlContent() {
        return this.ext;
    }

    public void setXmlContent(Extension extension) {
        this.ext = extension;
        this.xml = null;
        this.text = null;
        this.bytes = null;
    }

    public XmlBlob getXml() {
        return this.xml;
    }

    public void setXml(XmlBlob v) {
        this.ext = null;
        this.xml = v;
        this.text = null;
        this.bytes = null;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String v) {
        this.ext = null;
        this.xml = null;
        this.text = v;
        this.bytes = null;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public void setBytes(byte[] v) {
        this.ext = null;
        this.xml = null;
        this.bytes = v;
        this.text = null;
    }

    public void generateAtom(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(2);
        if (this.mimeType != null) {
            attrs.add(new Attribute("type", this.mimeType.getMediaType()));
        }
        if (this.ext != null) {
            w.startElement(Namespaces.atomNs, "content", attrs, null);
            this.ext.generate(w, extProfile);
            w.endElement(Namespaces.atomNs, "content");
        } else if (this.xml != null) {
            XmlBlob.startElement(w, Namespaces.atomNs, "content", this.xml, attrs, null);
            XmlBlob.endElement(w, Namespaces.atomNs, "content", this.xml);
        } else {
            String value;
            if (this.text != null) {
                value = this.text;
                if (this.lang != null) {
                    attrs.add(new Attribute("xml:lang", this.lang));
                }
            } else if (this.bytes != null) {
                value = Base64.encode(this.bytes);
                if (this.lang != null) {
                    attrs.add(new Attribute("xml:lang", this.lang));
                }
            } else {
                value = null;
            }
            w.simpleElement(Namespaces.atomNs, "content", attrs, value);
        }
    }

    public void generateRss(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        if (getType() == 4) {
            w.simpleElement(Namespaces.rssNs, "description", null, this.text);
        } else {
            generateAtom(w, extProfile);
        }
    }
}
