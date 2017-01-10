package com.google.gdata.model.gd;

import com.google.gdata.data.DateTime;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class GeoPt extends Element {
    public static final AttributeKey<Float> ELEV;
    public static final ElementKey<Void, GeoPt> KEY;
    public static final AttributeKey<String> LABEL;
    public static final AttributeKey<Float> LAT;
    public static final AttributeKey<Float> LON;
    public static final AttributeKey<DateTime> TIME;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "geoPt"), Void.class, GeoPt.class);
        ELEV = AttributeKey.of(new QName(null, "elev"), Float.class);
        LABEL = AttributeKey.of(new QName(null, "label"), String.class);
        LAT = AttributeKey.of(new QName(null, "lat"), Float.class);
        LON = AttributeKey.of(new QName(null, "lon"), Float.class);
        TIME = AttributeKey.of(new QName(null, "time"), DateTime.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(ELEV);
            builder.addAttribute(LABEL);
            builder.addAttribute(LAT);
            builder.addAttribute(LON);
            builder.addAttribute(TIME);
        }
    }

    public GeoPt() {
        super(KEY);
    }

    protected GeoPt(ElementKey<?, ? extends GeoPt> key) {
        super((ElementKey) key);
    }

    protected GeoPt(ElementKey<?, ? extends GeoPt> key, Element source) {
        super(key, source);
    }

    public GeoPt lock() {
        return (GeoPt) super.lock();
    }

    public Float getElev() {
        return (Float) super.getAttributeValue(ELEV);
    }

    public GeoPt setElev(Float elev) {
        super.setAttributeValue(ELEV, (Object) elev);
        return this;
    }

    public boolean hasElev() {
        return super.hasAttribute(ELEV);
    }

    public String getLabel() {
        return (String) super.getAttributeValue(LABEL);
    }

    public GeoPt setLabel(String label) {
        super.setAttributeValue(LABEL, (Object) label);
        return this;
    }

    public boolean hasLabel() {
        return super.hasAttribute(LABEL);
    }

    public Float getLat() {
        return (Float) super.getAttributeValue(LAT);
    }

    public GeoPt setLat(Float lat) {
        super.setAttributeValue(LAT, (Object) lat);
        return this;
    }

    public boolean hasLat() {
        return super.hasAttribute(LAT);
    }

    public Float getLon() {
        return (Float) super.getAttributeValue(LON);
    }

    public GeoPt setLon(Float lon) {
        super.setAttributeValue(LON, (Object) lon);
        return this;
    }

    public boolean hasLon() {
        return super.hasAttribute(LON);
    }

    public DateTime getTime() {
        return (DateTime) super.getAttributeValue(TIME);
    }

    public GeoPt setTime(DateTime time) {
        super.setAttributeValue(TIME, (Object) time);
        return this;
    }

    public boolean hasTime() {
        return super.hasAttribute(TIME);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!sameClassAs(obj)) {
            return false;
        }
        GeoPt other = (GeoPt) obj;
        if (Element.eq(getElev(), other.getElev()) && Element.eq(getLabel(), other.getLabel()) && Element.eq(getLat(), other.getLat()) && Element.eq(getLon(), other.getLon()) && Element.eq(getTime(), other.getTime())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = getClass().hashCode();
        if (getElev() != null) {
            result = (result * 37) + getElev().hashCode();
        }
        if (getLabel() != null) {
            result = (result * 37) + getLabel().hashCode();
        }
        if (getLat() != null) {
            result = (result * 37) + getLat().hashCode();
        }
        if (getLon() != null) {
            result = (result * 37) + getLon().hashCode();
        }
        if (getTime() != null) {
            return (result * 37) + getTime().hashCode();
        }
        return result;
    }
}
