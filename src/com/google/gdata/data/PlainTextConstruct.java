package com.google.gdata.data;

import com.google.gdata.client.Service;
import com.google.gdata.client.Service.Versions;
import com.google.gdata.data.TextConstruct.RssFormat;
import com.google.gdata.model.atom.TextContent;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;

public class PlainTextConstruct extends TextConstruct {
    protected String text;

    public class AtomHandler extends ElementHandler {
        public void processAttribute(String namespace, String localName, String value) throws ParseException {
            if (!namespace.equals(StringUtil.EMPTY_STRING) || !localName.equals("type")) {
                super.processAttribute(namespace, localName, value);
            }
        }

        public void processEndElement() throws ParseException {
            if (this.value == null) {
                this.value = StringUtil.EMPTY_STRING;
            }
            PlainTextConstruct.this.text = this.value;
            PlainTextConstruct.this.lang = this.xmlLang;
        }
    }

    public PlainTextConstruct(String text) {
        this.text = text;
    }

    public PlainTextConstruct(String text, String lang) {
        this.text = text;
        this.lang = lang;
    }

    public int getType() {
        return 1;
    }

    public boolean isEmpty() {
        return getText() == null;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String v) {
        this.text = v;
    }

    public String getPlainText() {
        return this.text != null ? new String(this.text) : null;
    }

    public void generateAtom(XmlWriter w, String elementName) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList();
        if (Service.getVersion().isCompatible(Versions.V1)) {
            attrs.add(new Attribute("type", TextContent.KIND));
        }
        if (this.lang != null) {
            attrs.add(new Attribute("xml:lang", this.lang));
        }
        w.simpleElement(Namespaces.atomNs, elementName, attrs, this.text);
    }

    public void generateRss(XmlWriter w, String elementName, RssFormat rssFormat) throws IOException {
        w.simpleElement(Namespaces.rssNs, elementName, null, this.text);
    }
}
