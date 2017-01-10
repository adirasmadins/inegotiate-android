package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class GivenName extends Element {
    public static final ElementKey<String, GivenName> KEY;
    public static final AttributeKey<String> YOMI;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "givenName"), String.class, GivenName.class);
        YOMI = AttributeKey.of(new QName(null, "yomi"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY).addAttribute(YOMI);
        }
    }

    public GivenName() {
        super(KEY);
    }

    protected GivenName(ElementKey<String, ? extends GivenName> key) {
        super((ElementKey) key);
    }

    protected GivenName(ElementKey<String, ? extends GivenName> key, Element source) {
        super(key, source);
    }

    public GivenName(String value) {
        this();
        setValue(value);
    }

    public GivenName lock() {
        return (GivenName) super.lock();
    }

    public String getValue() {
        return (String) super.getTextValue(KEY);
    }

    public GivenName setValue(String value) {
        super.setTextValue(value);
        return this;
    }

    public boolean hasValue() {
        return super.hasTextValue();
    }

    public String getYomi() {
        return (String) super.getAttributeValue(YOMI);
    }

    public GivenName setYomi(String yomi) {
        super.setAttributeValue(YOMI, (Object) yomi);
        return this;
    }

    public boolean hasYomi() {
        return super.hasAttribute(YOMI);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        GivenName other = (GivenName) obj;
        if (Element.eq(getValue(), other.getValue()) && Element.eq(getYomi(), other.getYomi())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getValue() != null) {
            result = (result * 37) + getValue().hashCode();
        }
        if (getYomi() != null) {
            return (result * 37) + getYomi().hashCode();
        }
        return result;
    }
}
