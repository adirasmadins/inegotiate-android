package com.google.gdata.model.atom;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.XmlBlob;
import com.google.gdata.util.common.util.Base64;
import com.google.gdata.util.common.util.Base64DecoderException;
import java.util.Iterator;

public class OtherContent extends Content {
    public static final ElementKey<String, OtherContent> KEY;
    public static final String KIND = "other";

    static {
        KEY = ElementKey.of(Content.KEY.getId(), String.class, OtherContent.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Content.registerMetadata(registry);
            ElementCreator builder = registry.build(KEY);
            builder.addElement(Feed.KEY);
            builder.addElement(Entry.KEY);
            registry.adapt(Content.KEY, KIND, KEY);
        }
    }

    public OtherContent() {
        super(KEY);
    }

    public OtherContent(Content content) {
        super(KEY, content);
    }

    protected OtherContent(ElementKey<?, ?> key) {
        super(key);
    }

    public int getType() {
        if (getXml() != null || getXmlContent() != null) {
            return 5;
        }
        if (getMimeType().getMediaType().equals(TextContent.KIND)) {
            return 4;
        }
        return 6;
    }

    public void setMimeType(ContentType v) {
        setAttributeValue(TYPE, (Object) v.getMediaType());
    }

    public XmlBlob getXml() {
        return null;
    }

    public void setXml(XmlBlob v) {
        throw new UnsupportedOperationException("Not supported yet");
    }

    public Element getXmlContent() {
        Iterator<Element> iter = getElementIterator();
        if (iter.hasNext()) {
            return (Element) iter.next();
        }
        return null;
    }

    public void setXmlContent(Element content) {
        addElement(content);
    }

    public String getText() {
        return (String) getTextValue(KEY);
    }

    public void setText(String v) {
        setTextValue(v);
    }

    public byte[] getBytes() {
        String value = getText();
        if (value == null) {
            return null;
        }
        try {
            return Base64.decode(value);
        } catch (Base64DecoderException e) {
            throw new IllegalStateException("Value was not base64 encoded: " + value);
        }
    }

    public void setBytes(byte[] v) {
        setText(Base64.encode(v));
    }

    protected void validate(ElementMetadata<?, ?> metadata, ValidationContext vc) {
        super.validate(metadata, vc);
        int maximumChildren = hasTextValue() ? 0 : 1;
        if (getElementCount() > maximumChildren) {
            vc.addError((Element) this, "Content cannot contain more than " + maximumChildren + " child elements, but contains " + getElementCount());
        }
    }
}
