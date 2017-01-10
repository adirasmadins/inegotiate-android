package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Ordering extends Element {
    public static final ElementKey<Void, Ordering> KEY;
    public static final AttributeKey<String> NEXT;
    public static final AttributeKey<String> ORDER_ID;
    public static final AttributeKey<String> PREV;
    public static final AttributeKey<String> REF;
    public static final AttributeKey<String> REL;

    public static final class Rel {
        private static final String[] ALL_VALUES;
        public static final String COMESAFTER = "comesAfter";
        public static final String FIRST = "first";
        public static final String LAST = "last";

        static {
            ALL_VALUES = new String[]{COMESAFTER, FIRST, LAST};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Rel() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "ordering"), Void.class, Ordering.class);
        ORDER_ID = AttributeKey.of(new QName(null, "orderId"), String.class);
        REL = AttributeKey.of(new QName(null, "rel"), String.class);
        REF = AttributeKey.of(new QName(null, "ref"), String.class);
        PREV = AttributeKey.of(new QName(null, "prev"), String.class);
        NEXT = AttributeKey.of(new QName(null, com.google.gdata.data.ILink.Rel.NEXT), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(ORDER_ID);
            builder.addAttribute(REL);
            builder.addAttribute(REF);
            builder.addAttribute(PREV);
            builder.addAttribute(NEXT);
        }
    }

    public Ordering() {
        super(KEY);
    }

    protected Ordering(ElementKey<?, ? extends Ordering> key) {
        super((ElementKey) key);
    }

    protected Ordering(ElementKey<?, ? extends Ordering> key, Element source) {
        super(key, source);
    }

    public Ordering lock() {
        return (Ordering) super.lock();
    }

    public String getNext() {
        return (String) super.getAttributeValue(NEXT);
    }

    public Ordering setNext(String next) {
        super.setAttributeValue(NEXT, (Object) next);
        return this;
    }

    public boolean hasNext() {
        return super.hasAttribute(NEXT);
    }

    public String getOrderId() {
        return (String) super.getAttributeValue(ORDER_ID);
    }

    public Ordering setOrderId(String orderId) {
        super.setAttributeValue(ORDER_ID, (Object) orderId);
        return this;
    }

    public boolean hasOrderId() {
        return super.hasAttribute(ORDER_ID);
    }

    public String getPrev() {
        return (String) super.getAttributeValue(PREV);
    }

    public Ordering setPrev(String prev) {
        super.setAttributeValue(PREV, (Object) prev);
        return this;
    }

    public boolean hasPrev() {
        return super.hasAttribute(PREV);
    }

    public String getRef() {
        return (String) super.getAttributeValue(REF);
    }

    public Ordering setRef(String ref) {
        super.setAttributeValue(REF, (Object) ref);
        return this;
    }

    public boolean hasRef() {
        return super.hasAttribute(REF);
    }

    public String getRel() {
        return (String) super.getAttributeValue(REL);
    }

    public Ordering setRel(String rel) {
        super.setAttributeValue(REL, (Object) rel);
        return this;
    }

    public boolean hasRel() {
        return super.hasAttribute(REL);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        Ordering other = (Ordering) obj;
        if (Element.eq(getNext(), other.getNext()) && Element.eq(getOrderId(), other.getOrderId()) && Element.eq(getPrev(), other.getPrev()) && Element.eq(getRef(), other.getRef()) && Element.eq(getRel(), other.getRel())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getNext() != null) {
            result = (result * 37) + getNext().hashCode();
        }
        if (getOrderId() != null) {
            result = (result * 37) + getOrderId().hashCode();
        }
        if (getPrev() != null) {
            result = (result * 37) + getPrev().hashCode();
        }
        if (getRef() != null) {
            result = (result * 37) + getRef().hashCode();
        }
        if (getRel() != null) {
            return (result * 37) + getRel().hashCode();
        }
        return result;
    }
}
