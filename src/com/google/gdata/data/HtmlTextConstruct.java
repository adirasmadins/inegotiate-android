package com.google.gdata.data;

import com.google.ads.AdActivity;
import com.google.gdata.data.TextConstruct.RssFormat;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.html.HtmlToText;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import org.codehaus.jackson.impl.JsonWriteContext;

public class HtmlTextConstruct extends TextConstruct {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected String html;

    /* renamed from: com.google.gdata.data.HtmlTextConstruct.1 */
    static /* synthetic */ class C07211 {
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
        public void processAttribute(String namespace, String localName, String value) throws ParseException {
            if (!namespace.equals(StringUtil.EMPTY_STRING) || !localName.equals("type")) {
                super.processAttribute(namespace, localName, value);
            }
        }

        public void processEndElement() throws ParseException {
            if (this.value == null) {
                this.value = StringUtil.EMPTY_STRING;
            }
            HtmlTextConstruct.this.html = this.value;
            HtmlTextConstruct.this.lang = this.xmlLang;
        }
    }

    static {
        $assertionsDisabled = !HtmlTextConstruct.class.desiredAssertionStatus();
    }

    public HtmlTextConstruct(String html) {
        this.html = html;
    }

    public HtmlTextConstruct(String html, String lang) {
        this.html = html;
        this.lang = lang;
    }

    public int getType() {
        return 2;
    }

    public boolean isEmpty() {
        return getHtml() == null;
    }

    public String getHtml() {
        return this.html;
    }

    public void setHtml(String v) {
        this.html = v;
    }

    public String getPlainText() {
        return !isEmpty() ? HtmlToText.htmlToPlainText(this.html) : null;
    }

    public void generateAtom(XmlWriter w, String elementName) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(2);
        attrs.add(new Attribute("type", AdActivity.HTML_PARAM));
        if (this.lang != null) {
            attrs.add(new Attribute("xml:lang", this.lang));
        }
        w.simpleElement(Namespaces.atomNs, elementName, attrs, this.html);
    }

    public void generateRss(XmlWriter w, String elementName, RssFormat rssFormat) throws IOException {
        switch (C07211.$SwitchMap$com$google$gdata$data$TextConstruct$RssFormat[rssFormat.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                w.simpleElement(Namespaces.rssNs, elementName, null, this.html);
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                w.simpleElement(Namespaces.rssNs, elementName, null, getPlainText());
            default:
                if (!$assertionsDisabled) {
                    throw new AssertionError();
                }
        }
    }
}
