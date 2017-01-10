package com.google.gdata.model.atom;

import com.google.ads.AdActivity;
import com.google.gdata.data.IContent;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import java.net.URI;

public class Content extends Element implements IContent {
    public static final ElementKey<String, Content> CONSTRUCT;
    public static final ElementKey<String, Content> KEY;
    public static final AttributeKey<URI> SRC;
    public static final AttributeKey<String> TYPE;
    public static final AttributeKey<String> XML_LANG;

    static {
        CONSTRUCT = ElementKey.of(null, String.class, Content.class);
        KEY = ElementKey.of(new QName(Namespaces.atomNs, "content"), String.class, Content.class);
        XML_LANG = AttributeKey.of(new QName(Namespaces.xmlNs, "lang"));
        TYPE = AttributeKey.of(new QName("type"));
        SRC = AttributeKey.of(new QName("src"), URI.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(CONSTRUCT)) {
            ElementCreator constructBuilder = registry.build(CONSTRUCT).setContentRequired(false);
            constructBuilder.addAttribute(TYPE);
            constructBuilder.addAttribute(SRC);
            constructBuilder.addAttribute(XML_LANG);
            registry.build(KEY);
        }
    }

    public Content(ElementKey<?, ?> key) {
        super((ElementKey) key);
    }

    protected Content(ElementKey<?, ?> key, Element source) {
        super(key, source);
    }

    public int getType() {
        return 1;
    }

    public String getLang() {
        return (String) getAttributeValue(XML_LANG);
    }

    public void setLang(String lang) {
        setAttributeValue(XML_LANG, (Object) lang);
    }

    public ContentType getMimeType() {
        String type = (String) getAttributeValue(TYPE);
        if (type == null) {
            return null;
        }
        return new ContentType(type);
    }

    public URI getSrc() {
        return (URI) getAttributeValue(SRC);
    }

    protected Element narrow(ElementMetadata<?, ?> meta, ValidationContext vc) {
        if (!Content.class.equals(getClass())) {
            return this;
        }
        if (getSrc() != null) {
            return adapt(this, meta, OutOfLineContent.KIND);
        }
        String type = (String) getAttributeValue(TYPE);
        if (type == null || type.equals(TextContent.KIND) || type.equals(AdActivity.HTML_PARAM) || type.equals("xhtml")) {
            return adapt(this, meta, TextContent.KIND);
        }
        return adapt(this, meta, OtherContent.KIND);
    }
}
