package com.google.gdata.model.atom;

import com.google.gdata.client.DocumentQuery;
import com.google.gdata.data.ILink;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.util.Namespaces;
import java.net.URI;
import java.net.URISyntaxException;

public class Link extends Element implements ILink {
    public static final AttributeKey<String> ETAG;
    public static final AttributeKey<String> HREF;
    public static final AttributeKey<String> HREFLANG;
    public static final ElementKey<Void, Link> KEY;
    public static final AttributeKey<Long> LENGTH;
    public static final AttributeKey<String> REL;
    public static final AttributeKey<String> TITLE;
    public static final AttributeKey<String> TYPE;
    public static final AttributeKey<String> XML_LANG;
    protected long length;

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomNs, "link"), Link.class);
        HREF = AttributeKey.of(new QName("href"));
        REL = AttributeKey.of(new QName("rel"));
        TYPE = AttributeKey.of(new QName("type"));
        HREFLANG = AttributeKey.of(new QName("hreflang"));
        TITLE = AttributeKey.of(new QName(DocumentQuery.TITLE_SORT));
        XML_LANG = AttributeKey.of(new QName(Namespaces.xmlNs, "lang"));
        LENGTH = AttributeKey.of(new QName("length"), Long.class);
        ETAG = AttributeKey.of(new QName(Namespaces.gNs, "etag"));
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addAttribute(REL);
            builder.addAttribute(TYPE);
            builder.addAttribute(HREF).setRequired(true);
            builder.addAttribute(HREFLANG);
            builder.addAttribute(TITLE);
            builder.addAttribute(XML_LANG);
            builder.addAttribute(LENGTH);
            builder.addAttribute(ETAG);
            builder.addElement(Content.KEY);
        }
    }

    public Link() {
        super(KEY);
        this.length = -1;
    }

    protected Link(ElementKey<?, ? extends Link> key) {
        super((ElementKey) key);
        this.length = -1;
    }

    protected Link(ElementKey<?, ? extends Link> key, Element source) {
        super(key, source);
        this.length = -1;
    }

    @Deprecated
    public Link(String rel, String type, String href) {
        this();
        setRel(rel);
        setType(type);
        setHref(href);
    }

    public Link(String rel, String type, URI href) {
        this();
        setRel(rel);
        setType(type);
        setHref(href);
    }

    public String getRel() {
        String rel = (String) getAttributeValue(REL);
        return rel != null ? rel : Rel.ALTERNATE;
    }

    public void setRel(String v) {
        setAttributeValue(REL, (Object) v);
    }

    public String getType() {
        return (String) getAttributeValue(TYPE);
    }

    public void setType(String v) {
        setAttributeValue(TYPE, (Object) v);
    }

    public String getHref() {
        return (String) getAttributeValue(HREF);
    }

    public URI getHrefUri() {
        String href = getHref();
        if (href == null) {
            return null;
        }
        try {
            return new URI(href);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void setHref(String v) {
        setAttributeValue(HREF, (Object) v);
    }

    public void setHref(URI v) {
        setHref(v == null ? null : v.toString());
    }

    public String getHrefLang() {
        return (String) getAttributeValue(HREFLANG);
    }

    public void setHrefLang(String v) {
        setAttributeValue(HREFLANG, (Object) v);
    }

    public String getTitle() {
        return (String) getAttributeValue(TITLE);
    }

    public void setTitle(String v) {
        setAttributeValue(TITLE, (Object) v);
    }

    public String getTitleLang() {
        return (String) getAttributeValue(XML_LANG);
    }

    public void setTitleLang(String v) {
        setAttributeValue(XML_LANG, (Object) v);
    }

    public long getLength() {
        Long value = (Long) getAttributeValue(LENGTH);
        if (value == null) {
            return -1;
        }
        return value.longValue();
    }

    public void setLength(long v) {
        setAttributeValue(LENGTH, (Object) Long.valueOf(v));
    }

    public String getEtag() {
        return (String) getAttributeValue(ETAG);
    }

    public void setEtag(String v) {
        setAttributeValue(ETAG, (Object) v);
    }

    public Content getContent() {
        return (Content) getElement(Content.KEY);
    }

    public void setContent(Content c) {
        setElement(Content.KEY, (Element) c);
    }

    public boolean matches(String relToMatch, String typeToMatch) {
        return (relToMatch == null || relToMatch.equals(getRel())) && (typeToMatch == null || typeToMatch.equals(getType()));
    }

    protected Element narrow(ElementMetadata<?, ?> meta, ValidationContext vc) {
        return adapt(this, meta, getRel());
    }
}
