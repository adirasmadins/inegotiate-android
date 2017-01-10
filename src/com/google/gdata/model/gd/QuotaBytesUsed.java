package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class QuotaBytesUsed extends Element {
    public static final ElementKey<Long, QuotaBytesUsed> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "quotaBytesUsed"), Long.class, QuotaBytesUsed.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY).setContentRequired(false);
        }
    }

    public QuotaBytesUsed() {
        super(KEY);
    }

    protected QuotaBytesUsed(ElementKey<Long, ? extends QuotaBytesUsed> key) {
        super((ElementKey) key);
    }

    protected QuotaBytesUsed(ElementKey<Long, ? extends QuotaBytesUsed> key, Element source) {
        super(key, source);
    }

    public QuotaBytesUsed(Long value) {
        this();
        setValue(value);
    }

    public QuotaBytesUsed lock() {
        return (QuotaBytesUsed) super.lock();
    }

    public Long getValue() {
        return (Long) super.getTextValue(KEY);
    }

    public QuotaBytesUsed setValue(Long value) {
        super.setTextValue(value);
        return this;
    }

    public boolean hasValue() {
        return super.hasTextValue();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        return Element.eq(getValue(), ((QuotaBytesUsed) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
