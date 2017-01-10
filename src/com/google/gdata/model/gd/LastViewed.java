package com.google.gdata.model.gd;

import com.google.gdata.data.DateTime;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class LastViewed extends Element {
    public static final ElementKey<DateTime, LastViewed> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "lastViewed"), DateTime.class, LastViewed.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY).setContentRequired(false);
        }
    }

    public LastViewed() {
        super(KEY);
    }

    protected LastViewed(ElementKey<DateTime, ? extends LastViewed> key) {
        super((ElementKey) key);
    }

    protected LastViewed(ElementKey<DateTime, ? extends LastViewed> key, Element source) {
        super(key, source);
    }

    public LastViewed(DateTime value) {
        this();
        setValue(value);
    }

    public LastViewed lock() {
        return (LastViewed) super.lock();
    }

    public DateTime getValue() {
        return (DateTime) super.getTextValue(KEY);
    }

    public LastViewed setValue(DateTime value) {
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
        return Element.eq(getValue(), ((LastViewed) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
