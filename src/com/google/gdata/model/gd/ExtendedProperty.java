package com.google.gdata.model.gd;

import com.google.gdata.client.authn.oauth.OAuthParameters;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class ExtendedProperty extends Element {
    public static final ElementKey<Void, ExtendedProperty> KEY;
    public static final AttributeKey<String> NAME;
    public static final AttributeKey<String> REALM;
    public static final AttributeKey<String> VALUE;

    public static final class Realm {
        private static final String[] ALL_VALUES;
        public static final String SHARED = "http://schemas.google.com/g/2005#shared";

        static {
            ALL_VALUES = new String[]{SHARED};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Realm() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "extendedProperty"), Void.class, ExtendedProperty.class);
        NAME = AttributeKey.of(new QName(null, "name"), String.class);
        REALM = AttributeKey.of(new QName(null, OAuthParameters.REALM_KEY), String.class);
        VALUE = AttributeKey.of(new QName(null, "value"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(NAME).setRequired(true);
            builder.addAttribute(REALM);
            builder.addAttribute(VALUE);
        }
    }

    public ExtendedProperty() {
        super(KEY);
    }

    protected ExtendedProperty(ElementKey<?, ? extends ExtendedProperty> key) {
        super((ElementKey) key);
    }

    protected ExtendedProperty(ElementKey<?, ? extends ExtendedProperty> key, Element source) {
        super(key, source);
    }

    public ExtendedProperty lock() {
        return (ExtendedProperty) super.lock();
    }

    public String getName() {
        return (String) super.getAttributeValue(NAME);
    }

    public ExtendedProperty setName(String name) {
        super.setAttributeValue(NAME, (Object) name);
        return this;
    }

    public boolean hasName() {
        return super.hasAttribute(NAME);
    }

    public String getRealm() {
        return (String) super.getAttributeValue(REALM);
    }

    public ExtendedProperty setRealm(String realm) {
        super.setAttributeValue(REALM, (Object) realm);
        return this;
    }

    public boolean hasRealm() {
        return super.hasAttribute(REALM);
    }

    public String getValue() {
        return (String) super.getAttributeValue(VALUE);
    }

    public ExtendedProperty setValue(String value) {
        super.setAttributeValue(VALUE, (Object) value);
        return this;
    }

    public boolean hasValue() {
        return super.hasAttribute(VALUE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        ExtendedProperty other = (ExtendedProperty) obj;
        if (Element.eq(getName(), other.getName()) && Element.eq(getRealm(), other.getRealm()) && Element.eq(getValue(), other.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getName() != null) {
            result = (result * 37) + getName().hashCode();
        }
        if (getRealm() != null) {
            result = (result * 37) + getRealm().hashCode();
        }
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
