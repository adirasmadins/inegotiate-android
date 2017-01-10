package com.google.gdata.model.atom;

import com.google.gdata.data.IOutOfLineContent;
import com.google.gdata.data.Reference;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import java.net.URI;
import java.net.URISyntaxException;

public class OutOfLineContent extends Content implements IOutOfLineContent, Reference {
    public static final AttributeKey<String> ETAG;
    public static final ElementKey<String, OutOfLineContent> KEY;
    public static final String KIND = "out-of-line";
    public static final AttributeKey<Long> LENGTH;

    static {
        KEY = ElementKey.of(Content.KEY.getId(), String.class, OutOfLineContent.class);
        LENGTH = AttributeKey.of(new QName("length"), Long.class);
        ETAG = AttributeKey.of(new QName(Namespaces.gNs, "etag"));
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Content.registerMetadata(registry);
            ElementCreator builder = registry.build(KEY);
            builder.replaceAttribute(Content.SRC).setRequired(true);
            builder.addAttribute(LENGTH).setVisible(false);
            builder.addAttribute(ETAG);
            registry.adapt(Content.KEY, KIND, KEY);
        }
    }

    public OutOfLineContent() {
        super(KEY);
    }

    public OutOfLineContent(Content content) {
        super(KEY, content);
    }

    protected OutOfLineContent(ElementKey<?, ?> key) {
        super(key);
    }

    public int getType() {
        return 7;
    }

    public void setMimeType(ContentType v) {
        setAttributeValue(TYPE, v == null ? null : v.getMediaType());
    }

    @Deprecated
    public String getUri() {
        URI uri = getSrc();
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    @Deprecated
    public void setUri(String v) {
        try {
            setSrc(v == null ? null : new URI(v));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public void setSrc(URI v) {
        setAttributeValue(SRC, (Object) v);
    }

    public void setLength(long length) {
        setAttributeValue(LENGTH, length == -1 ? null : Long.valueOf(length));
    }

    public String getHref() {
        URI uri = (URI) getAttributeValue(SRC);
        return uri == null ? null : uri.toString();
    }

    public void setHref(String href) {
        try {
            setAttributeValue(SRC, href == null ? null : new URI(href));
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Not a URI: " + href, e);
        }
    }

    public long getLength() {
        Long length = (Long) getAttributeValue(LENGTH);
        return length == null ? -1 : length.longValue();
    }

    public String getEtag() {
        return (String) getAttributeValue(ETAG);
    }

    public void setEtag(String etag) {
        setAttributeValue(ETAG, (Object) etag);
    }
}
