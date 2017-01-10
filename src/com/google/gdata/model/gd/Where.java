package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Where extends Element {
    public static final ElementKey<Void, Where> KEY;
    public static final AttributeKey<String> LABEL;
    public static final AttributeKey<String> REL;
    public static final AttributeKey<String> VALUE_STRING;

    public static final class Rel {
        private static final String[] ALL_VALUES;
        public static final String EVENT = "http://schemas.google.com/g/2005#event";
        public static final String EVENT_ALTERNATE = "http://schemas.google.com/g/2005#event.alternate";
        public static final String EVENT_PARKING = "http://schemas.google.com/g/2005#event.parking";

        static {
            ALL_VALUES = new String[]{EVENT, EVENT_ALTERNATE, EVENT_PARKING};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Rel() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "where"), Void.class, Where.class);
        LABEL = AttributeKey.of(new QName(null, "label"), String.class);
        REL = AttributeKey.of(new QName(null, "rel"), String.class);
        VALUE_STRING = AttributeKey.of(new QName(null, "valueString"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(LABEL);
            builder.addAttribute(REL);
            builder.addAttribute(VALUE_STRING);
            builder.addElement(EntryLink.KEY);
        }
    }

    public Where() {
        super(KEY);
    }

    protected Where(ElementKey<?, ? extends Where> key) {
        super((ElementKey) key);
    }

    protected Where(ElementKey<?, ? extends Where> key, Element source) {
        super(key, source);
    }

    public Where lock() {
        return (Where) super.lock();
    }

    public EntryLink getEntryLink() {
        return (EntryLink) super.getElement(EntryLink.KEY);
    }

    public Where setEntryLink(EntryLink entryLink) {
        super.setElement(EntryLink.KEY, (Element) entryLink);
        return this;
    }

    public boolean hasEntryLink() {
        return super.hasElement(EntryLink.KEY);
    }

    public String getLabel() {
        return (String) super.getAttributeValue(LABEL);
    }

    public Where setLabel(String label) {
        super.setAttributeValue(LABEL, (Object) label);
        return this;
    }

    public boolean hasLabel() {
        return super.hasAttribute(LABEL);
    }

    public String getRel() {
        return (String) super.getAttributeValue(REL);
    }

    public Where setRel(String rel) {
        super.setAttributeValue(REL, (Object) rel);
        return this;
    }

    public boolean hasRel() {
        return super.hasAttribute(REL);
    }

    public String getValueString() {
        return (String) super.getAttributeValue(VALUE_STRING);
    }

    public Where setValueString(String valueString) {
        super.setAttributeValue(VALUE_STRING, (Object) valueString);
        return this;
    }

    public boolean hasValueString() {
        return super.hasAttribute(VALUE_STRING);
    }
}
