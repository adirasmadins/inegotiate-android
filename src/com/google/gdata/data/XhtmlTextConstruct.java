package com.google.gdata.data;

import com.google.gdata.data.TextConstruct.RssFormat;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlBlob;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.html.HtmlToText;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import org.codehaus.jackson.impl.JsonWriteContext;

public class XhtmlTextConstruct extends TextConstruct {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected XmlBlob xhtml;

    /* renamed from: com.google.gdata.data.XhtmlTextConstruct.1 */
    static /* synthetic */ class C07251 {
        static final /* synthetic */ int[] $SwitchMap$com$google$gdata$data$TextConstruct$RssFormat;

        static {
            $SwitchMap$com$google$gdata$data$TextConstruct$RssFormat = new int[RssFormat.values().length];
            try {
                $SwitchMap$com$google$gdata$data$TextConstruct$RssFormat[RssFormat.FULL_HTML.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$google$gdata$data$TextConstruct$RssFormat[RssFormat.PLAIN_TEXT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public class AtomHandler extends ElementHandler {
        public AtomHandler() throws IOException {
            XhtmlTextConstruct.this.xhtml = new XmlBlob();
            initializeXmlBlob(XhtmlTextConstruct.this.xhtml, true, true);
            XhtmlTextConstruct.this.lang = this.xmlLang;
        }

        public void processAttribute(String namespace, String localName, String value) throws ParseException {
            if (namespace.equals(Namespaces.xml) && localName.equals("lang")) {
                XhtmlTextConstruct.this.lang = this.xmlLang;
            }
        }
    }

    static {
        $assertionsDisabled = !XhtmlTextConstruct.class.desiredAssertionStatus();
    }

    public XhtmlTextConstruct(XmlBlob xhtml) {
        this.xhtml = xhtml;
    }

    public XhtmlTextConstruct(XmlBlob xhtml, String lang) {
        this.xhtml = xhtml;
        this.lang = lang;
    }

    public int getType() {
        return 3;
    }

    public boolean isEmpty() {
        return this.xhtml == null;
    }

    public XmlBlob getXhtml() {
        if (this.xhtml == null) {
            this.xhtml = new XmlBlob();
        }
        return this.xhtml;
    }

    public void setXhtml(XmlBlob v) {
        this.xhtml = v;
    }

    public String getPlainText() {
        String str = null;
        if (this.xhtml != null) {
            try {
                StringWriter sw = new StringWriter();
                new XmlWriter(sw).innerXml(this.xhtml.getBlob());
                str = HtmlToText.htmlToPlainText(sw.toString());
            } catch (IOException e) {
            }
        }
        return str;
    }

    public void generateAtom(XmlWriter w, String elementName) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(2);
        attrs.add(new Attribute("type", "xhtml"));
        if (this.lang != null) {
            attrs.add(new Attribute("xml:lang", this.lang));
        }
        XmlBlob.startElement(w, Namespaces.atomNs, elementName, this.xhtml, attrs, null);
        XmlBlob.endElement(w, Namespaces.atomNs, elementName, this.xhtml);
    }

    public void generateRss(XmlWriter w, String elementName, RssFormat rssFormat) throws IOException {
        switch (C07251.$SwitchMap$com$google$gdata$data$TextConstruct$RssFormat[rssFormat.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                StringWriter sw = new StringWriter();
                new XmlWriter(sw).innerXml(this.xhtml.getBlob());
                w.simpleElement(Namespaces.rssNs, elementName, null, sw.toString());
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                w.simpleElement(Namespaces.rssNs, elementName, null, getPlainText());
            default:
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
        }
    }
}
