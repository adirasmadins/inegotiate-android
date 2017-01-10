package com.google.gdata.model.atom;

import com.amazonaws.services.s3.internal.Mimetypes;
import com.google.ads.AdActivity;
import com.google.common.collect.ImmutableMap;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.Versions;
import com.google.gdata.data.ITextConstruct;
import com.google.gdata.data.ITextContent;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.ElementValidator;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.model.XmlBlob;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.html.HtmlToText;
import org.codehaus.jackson.impl.JsonWriteContext;

public class TextContent extends Content implements ITextContent, ITextConstruct {
    public static final ElementKey<String, TextContent> CONSTRUCT;
    public static final ElementKey<String, XmlBlob> DIV;
    public static final ElementKey<String, TextContent> KEY;
    public static final String KIND = "text";
    private static final ImmutableMap<String, Integer> TYPE_MAP;
    private static final int UNKNOWN_TYPE = -1;

    private static class TextContentValidator implements ElementValidator {
        private TextContentValidator() {
        }

        public void validate(ValidationContext vc, Element e, ElementMetadata<?, ?> elementMetadata) {
            int type = TextContent.getType(e);
            switch (type) {
                case TextContent.UNKNOWN_TYPE /*-1*/:
                    vc.addError(e, CoreErrorDomain.ERR.invalidTextContentType.withInternalReason("Invalid type: " + type));
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                    if (!e.hasTextValue()) {
                        vc.addError(e, CoreErrorDomain.ERR.missingTextContent);
                    }
                    if (e.getElementCount() != 0) {
                        vc.addError(e, CoreErrorDomain.ERR.invalidChildElement.withInternalReason("Child elements not allowed on text content"));
                    }
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                    if (!e.hasElement(TextContent.DIV)) {
                        vc.addError(e, CoreErrorDomain.ERR.missingExtensionElement.withInternalReason("xhtml text content must have a div element"));
                    } else if (e.getElementCount() != 1) {
                        vc.addError(e, CoreErrorDomain.ERR.invalidChildElement.withInternalReason("xhtml must only have a single child element"));
                    }
                default:
                    throw new IllegalStateException("Shouldn't be possible, TYPE_MAP can only map to text, html, or xhtml.");
            }
        }
    }

    static {
        CONSTRUCT = ElementKey.of(null, String.class, TextContent.class);
        KEY = ElementKey.of(Content.KEY.getId(), String.class, TextContent.class);
        DIV = ElementKey.of(new QName(Namespaces.xhtmlNs, "div"), String.class, XmlBlob.class);
        TYPE_MAP = ImmutableMap.builder().put("plain", Integer.valueOf(1)).put(KIND, Integer.valueOf(1)).put("text/plain", Integer.valueOf(1)).put(AdActivity.HTML_PARAM, Integer.valueOf(2)).put(Mimetypes.MIMETYPE_HTML, Integer.valueOf(2)).put("xhtml", Integer.valueOf(3)).build();
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(CONSTRUCT)) {
            Content.registerMetadata(registry);
            registry.build(CONSTRUCT).setValidator(new TextContentValidator()).addElement(DIV);
            ElementCreator builder = registry.build(KEY);
            registry.adapt(Content.KEY, KIND, KEY);
        }
    }

    public static TextContent create(int type, String textOrHtml, XmlBlob xhtml) {
        switch (type) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return plainText(textOrHtml);
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return html(textOrHtml);
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return xhtml(xhtml);
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }

    public static TextContent plainText(String text) {
        TextContent content = new TextContent();
        content.setText(text);
        return content;
    }

    public static TextContent html(String html) {
        TextContent content = new TextContent();
        content.setHtml(html);
        return content;
    }

    public static TextContent xhtml(XmlBlob div) {
        TextContent content = new TextContent();
        content.setXhtml(div);
        return content;
    }

    private static int getType(Element e) {
        String type = (String) e.getAttributeValue(Content.TYPE);
        Integer typeVal = Integer.valueOf(type == null ? 1 : ((Integer) TYPE_MAP.get(type)).intValue());
        return typeVal == null ? UNKNOWN_TYPE : typeVal.intValue();
    }

    public TextContent() {
        super(CONSTRUCT);
    }

    protected TextContent(ElementKey<?, ?> key) {
        super(key);
    }

    protected TextContent(ElementKey<?, ?> key, Content content) {
        super(key, content);
    }

    public int getType() {
        int type = getType(this);
        return type == UNKNOWN_TYPE ? 1 : type;
    }

    public boolean isEmpty() {
        return StringUtil.isEmpty(getText()) && getElementCount() == 0;
    }

    public String getPlainText() {
        switch (getType()) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                return getText();
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                return HtmlToText.htmlToPlainText(getText());
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                return getXhtml().getBlob();
            default:
                throw new IllegalStateException("Shouldn't be possible, getType can only return TEXT, HTML, or XHTML.");
        }
    }

    public String getText() {
        return (String) getTextValue(KEY);
    }

    public String getHtml() {
        return getText();
    }

    public XmlBlob getXhtml() {
        if (getType() != 3) {
            return null;
        }
        XmlBlob div = (XmlBlob) getElement(DIV);
        if (div != null) {
            return div;
        }
        div = new XmlBlob(DIV);
        setXhtml(div);
        return div;
    }

    public void setText(String text) {
        if (Service.getVersion().isBefore(Versions.V2)) {
            setAttributeValue(Content.TYPE, (Object) KIND);
        } else {
            setAttributeValue(Content.TYPE, null);
        }
        setTextValue(text);
    }

    public void setHtml(String html) {
        setAttributeValue(Content.TYPE, (Object) AdActivity.HTML_PARAM);
        setTextValue(html);
    }

    public void setXhtml(XmlBlob div) {
        setAttributeValue(Content.TYPE, (Object) "xhtml");
        setElement(DIV, (Element) div);
    }

    public Element resolve(ElementMetadata<?, ?> metadata, ValidationContext vc) {
        int type = getType();
        if (type == 1 && Service.getVersion().isBefore(Versions.V2) && getAttributeValue(Content.TYPE) == null) {
            setAttributeValue(Content.TYPE, (Object) KIND);
        }
        if ((type == 1 || type == 2) && getTextValue() == null) {
            setTextValue(StringUtil.EMPTY_STRING);
        }
        return super.resolve(metadata, vc);
    }

    public ITextConstruct getContent() {
        return this;
    }
}
