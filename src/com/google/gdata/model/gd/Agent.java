package com.google.gdata.model.gd;

import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Agent extends Element {
    public static final ElementKey<String, Agent> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "agent"), String.class, Agent.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
        }
    }

    public Agent() {
        super(KEY);
    }

    protected Agent(ElementKey<String, ? extends Agent> key) {
        super((ElementKey) key);
    }

    protected Agent(ElementKey<String, ? extends Agent> key, Element source) {
        super(key, source);
    }

    public Agent(String value) {
        this();
        setValue(value);
    }

    public Agent lock() {
        return (Agent) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public Agent setValue(String value) {
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
        return Element.eq(getValue(), ((Agent) obj).getValue());
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
