package com.google.gdata.model.gd;

import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Rating extends Element {
    public static final AttributeKey<Float> AVERAGE;
    public static final ElementKey<Void, Rating> KEY;
    public static final AttributeKey<Integer> MAX;
    public static final AttributeKey<Integer> MIN;
    public static final AttributeKey<Integer> NUM_RATERS;
    public static final AttributeKey<String> REL;
    public static final AttributeKey<Integer> VALUE;

    public static final class Rel {
        private static final String[] ALL_VALUES;
        public static final String OVERALL = "http://schemas.google.com/g/2005#overall";
        public static final String PRICE = "http://schemas.google.com/g/2005#price";
        public static final String QUALITY = "http://schemas.google.com/g/2005#quality";

        static {
            ALL_VALUES = new String[]{OVERALL, PRICE, QUALITY};
        }

        public static String[] values() {
            return ALL_VALUES;
        }

        private Rel() {
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "rating"), Void.class, Rating.class);
        AVERAGE = AttributeKey.of(new QName(null, "average"), Float.class);
        MAX = AttributeKey.of(new QName(null, "max"), Integer.class);
        MIN = AttributeKey.of(new QName(null, "min"), Integer.class);
        NUM_RATERS = AttributeKey.of(new QName(null, "numRaters"), Integer.class);
        REL = AttributeKey.of(new QName(null, "rel"), String.class);
        VALUE = AttributeKey.of(new QName(null, "value"), Integer.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(AVERAGE);
            builder.addAttribute(MAX);
            builder.addAttribute(MIN);
            builder.addAttribute(NUM_RATERS);
            builder.addAttribute(REL);
            builder.addAttribute(VALUE);
        }
    }

    public Rating() {
        super(KEY);
    }

    protected Rating(ElementKey<?, ? extends Rating> key) {
        super((ElementKey) key);
    }

    protected Rating(ElementKey<?, ? extends Rating> key, Element source) {
        super(key, source);
    }

    public Rating lock() {
        return (Rating) super.lock();
    }

    public Float getAverage() {
        return (Float) super.getAttributeValue(AVERAGE);
    }

    public Rating setAverage(Float average) {
        super.setAttributeValue(AVERAGE, (Object) average);
        return this;
    }

    public boolean hasAverage() {
        return super.hasAttribute(AVERAGE);
    }

    public Integer getMax() {
        return (Integer) super.getAttributeValue(MAX);
    }

    public Rating setMax(Integer max) {
        super.setAttributeValue(MAX, (Object) max);
        return this;
    }

    public boolean hasMax() {
        return super.hasAttribute(MAX);
    }

    public Integer getMin() {
        return (Integer) super.getAttributeValue(MIN);
    }

    public Rating setMin(Integer min) {
        super.setAttributeValue(MIN, (Object) min);
        return this;
    }

    public boolean hasMin() {
        return super.hasAttribute(MIN);
    }

    public Integer getNumRaters() {
        return (Integer) super.getAttributeValue(NUM_RATERS);
    }

    public Rating setNumRaters(Integer numRaters) {
        super.setAttributeValue(NUM_RATERS, (Object) numRaters);
        return this;
    }

    public boolean hasNumRaters() {
        return super.hasAttribute(NUM_RATERS);
    }

    public String getRel() {
        return (String) super.getAttributeValue(REL);
    }

    public Rating setRel(String rel) {
        super.setAttributeValue(REL, (Object) rel);
        return this;
    }

    public boolean hasRel() {
        return super.hasAttribute(REL);
    }

    public Integer getValue() {
        return (Integer) super.getAttributeValue(VALUE);
    }

    public Rating setValue(Integer value) {
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
        Rating other = (Rating) obj;
        if (Element.eq(getAverage(), other.getAverage()) && Element.eq(getMax(), other.getMax()) && Element.eq(getMin(), other.getMin()) && Element.eq(getNumRaters(), other.getNumRaters()) && Element.eq(getRel(), other.getRel()) && Element.eq(getValue(), other.getValue())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getAverage() != null) {
            result = (result * 37) + getAverage().hashCode();
        }
        if (getMax() != null) {
            result = (result * 37) + getMax().hashCode();
        }
        if (getMin() != null) {
            result = (result * 37) + getMin().hashCode();
        }
        if (getNumRaters() != null) {
            result = (result * 37) + getNumRaters().hashCode();
        }
        if (getRel() != null) {
            result = (result * 37) + getRel().hashCode();
        }
        if (getValue() != null) {
            return (result * 37) + getValue().hashCode();
        }
        return result;
    }
}
