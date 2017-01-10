package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class OriginalEvent extends Element {
    public static final AttributeKey<String> HREF;
    public static final ElementKey<Void, OriginalEvent> KEY;
    public static final AttributeKey<String> ORIGINAL_ID;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "originalEvent"), Void.class, OriginalEvent.class);
        HREF = AttributeKey.of(new QName(null, "href"), String.class);
        ORIGINAL_ID = AttributeKey.of(new QName(null, "id"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(HREF);
            builder.addAttribute(ORIGINAL_ID).setRequired(true);
            builder.addElement(When.KEY).setRequired(true);
        }
    }

    public OriginalEvent() {
        super(KEY);
    }

    protected OriginalEvent(ElementKey<?, ? extends OriginalEvent> key) {
        super((ElementKey) key);
    }

    protected OriginalEvent(ElementKey<?, ? extends OriginalEvent> key, Element source) {
        super(key, source);
    }

    public OriginalEvent lock() {
        return (OriginalEvent) super.lock();
    }

    public String getHref() {
        return (String) super.getAttributeValue(HREF);
    }

    public OriginalEvent setHref(String href) {
        super.setAttributeValue(HREF, (Object) href);
        return this;
    }

    public boolean hasHref() {
        return super.hasAttribute(HREF);
    }

    public String getOriginalId() {
        return (String) super.getAttributeValue(ORIGINAL_ID);
    }

    public OriginalEvent setOriginalId(String originalId) {
        super.setAttributeValue(ORIGINAL_ID, (Object) originalId);
        return this;
    }

    public boolean hasOriginalId() {
        return super.hasAttribute(ORIGINAL_ID);
    }

    public When getOriginalStartTime() {
        return (When) super.getElement(When.KEY);
    }

    public OriginalEvent setOriginalStartTime(When originalStartTime) {
        super.setElement(When.KEY, (Element) originalStartTime);
        return this;
    }

    public boolean hasOriginalStartTime() {
        return super.hasElement(When.KEY);
    }
}
