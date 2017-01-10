package com.google.gdata.data;

import com.amazonaws.services.s3.internal.Mimetypes;
import com.google.ads.AdActivity;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.PlainTextConstruct.AtomHandler;
import com.google.gdata.model.atom.TextContent;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlBlob;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.xml.sax.Attributes;

public abstract class TextConstruct implements ITextConstruct {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected String lang;

    public static class ChildHandlerInfo {
        public ElementHandler handler;
        public TextConstruct textConstruct;
    }

    public enum RssFormat {
        PLAIN_TEXT,
        FULL_HTML
    }

    public static class Type {
        public static final int HTML = 2;
        public static final int TEXT = 1;
        public static final int XHTML = 3;
    }

    public abstract void generateAtom(XmlWriter xmlWriter, String str) throws IOException;

    public abstract void generateRss(XmlWriter xmlWriter, String str, RssFormat rssFormat) throws IOException;

    public abstract String getPlainText();

    public abstract int getType();

    public abstract boolean isEmpty();

    static {
        $assertionsDisabled = !TextConstruct.class.desiredAssertionStatus();
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String v) {
        this.lang = v;
    }

    public static TextConstruct create(int type, String textOrHtml, XmlBlob xhtml) {
        switch (type) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return new PlainTextConstruct(textOrHtml);
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return new HtmlTextConstruct(textOrHtml);
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return new XhtmlTextConstruct(xhtml);
            default:
                if ($assertionsDisabled) {
                    return null;
                }
                throw new AssertionError("Invalid type: " + String.valueOf(type));
        }
    }

    public static TextConstruct plainText(String text) {
        return new PlainTextConstruct(text);
    }

    public static TextConstruct html(String html) {
        return new HtmlTextConstruct(html);
    }

    public static TextConstruct xhtml(XmlBlob div) {
        return new XhtmlTextConstruct(div);
    }

    public static ChildHandlerInfo getChildHandler(Attributes attrs) throws ParseException, IOException {
        String type = attrs.getValue(StringUtil.EMPTY_STRING, "type");
        ChildHandlerInfo childHandlerInfo = new ChildHandlerInfo();
        if (type == null || type.equals(TextContent.KIND) || type.equals("text/plain")) {
            PlainTextConstruct ptc = new PlainTextConstruct();
            ptc.getClass();
            childHandlerInfo.handler = new AtomHandler();
            childHandlerInfo.textConstruct = ptc;
        } else if (type.equals(AdActivity.HTML_PARAM) || type.equals(Mimetypes.MIMETYPE_HTML)) {
            HtmlTextConstruct htc = new HtmlTextConstruct();
            htc.getClass();
            childHandlerInfo.handler = new HtmlTextConstruct.AtomHandler();
            childHandlerInfo.textConstruct = htc;
        } else if (type.equals("xhtml")) {
            XhtmlTextConstruct xtc = new XhtmlTextConstruct();
            xtc.getClass();
            childHandlerInfo.handler = new XhtmlTextConstruct.AtomHandler();
            childHandlerInfo.textConstruct = xtc;
        } else {
            ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidTextContentType);
            pe.setInternalReason("Invalid text content type: '" + type + "'");
            throw pe;
        }
        return childHandlerInfo;
    }
}
