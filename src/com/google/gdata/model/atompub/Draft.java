package com.google.gdata.model.atompub;

import com.google.common.collect.Maps;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;
import java.util.Map;

public class Draft extends Element {
    public static final ElementKey<Value, Draft> KEY;

    public enum Value {
        NO,
        YES;
        
        private static final Map<String, Value> VALUE_MAP;

        static {
            VALUE_MAP = Maps.newHashMap();
            for (Value value : values()) {
                VALUE_MAP.put(value.toString(), value);
            }
        }

        public String toString() {
            return name().toLowerCase();
        }

        public static Value fromString(String value) {
            return (Value) VALUE_MAP.get(value);
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomPubStandardNs, "draft"), Value.class, Draft.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public Draft() {
        super(KEY);
    }

    protected Draft(ElementKey<Value, ? extends Draft> key) {
        super((ElementKey) key);
    }

    protected Draft(ElementKey<Value, ? extends Draft> key, Element source) {
        super(key, source);
    }

    public Draft(Value value) {
        this();
        setValue(value);
    }

    public Draft lock() {
        return (Draft) super.lock();
    }

    public Value getValue() {
        return (Value) super.getTextValue(KEY);
    }

    public Draft setValue(Value value) {
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
        return Element.eq(getValue(), ((Draft) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
