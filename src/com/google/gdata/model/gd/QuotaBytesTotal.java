package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class QuotaBytesTotal extends Element {
    public static final ElementKey<Long, QuotaBytesTotal> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "quotaBytesTotal"), Long.class, QuotaBytesTotal.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY).setContentRequired(false);
        }
    }

    public QuotaBytesTotal() {
        super(KEY);
    }

    protected QuotaBytesTotal(ElementKey<Long, ? extends QuotaBytesTotal> key) {
        super((ElementKey) key);
    }

    protected QuotaBytesTotal(ElementKey<Long, ? extends QuotaBytesTotal> key, Element source) {
        super(key, source);
    }

    public QuotaBytesTotal(Long value) {
        this();
        setValue(value);
    }

    public QuotaBytesTotal lock() {
        return (QuotaBytesTotal) super.lock();
    }

    public Long getValue() {
        return (Long) super.getTextValue(KEY);
    }

    public QuotaBytesTotal setValue(Long value) {
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
        return Element.eq(getValue(), ((QuotaBytesTotal) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
