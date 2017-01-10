package com.google.gdata.model.atompub;

import com.google.gdata.data.DateTime;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Edited extends Element {
    public static final ElementKey<DateTime, Edited> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomPubStandardNs, "edited"), DateTime.class, Edited.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public Edited() {
        super(KEY);
    }

    protected Edited(ElementKey<DateTime, ? extends Edited> key) {
        super((ElementKey) key);
    }

    protected Edited(ElementKey<DateTime, ? extends Edited> key, Element source) {
        super(key, source);
    }

    public Edited(DateTime value) {
        this();
        setValue(value);
    }

    public Edited lock() {
        return (Edited) super.lock();
    }

    public DateTime getValue() {
        return (DateTime) super.getTextValue(KEY);
    }

    public Edited setValue(DateTime value) {
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
        return Element.eq(getValue(), ((Edited) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
