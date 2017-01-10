package com.google.gdata.model.atompub;

import com.google.common.collect.Maps;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.Category;
import com.google.gdata.util.Namespaces;
import java.util.List;
import java.util.Map;

public class Categories extends Element {
    public static final AttributeKey<Fixed> FIXED;
    public static final AttributeKey<String> HREF;
    public static final ElementKey<Void, Categories> KEY;
    public static final AttributeKey<String> SCHEME;

    public enum Fixed {
        NO,
        YES;
        
        private static final Map<String, Fixed> VALUE_MAP;

        static {
            VALUE_MAP = Maps.newHashMap();
            for (Fixed value : values()) {
                VALUE_MAP.put(value.toString(), value);
            }
        }

        public String toString() {
            return name().toLowerCase();
        }

        public static Fixed fromString(String value) {
            return (Fixed) VALUE_MAP.get(value);
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomPubStandardNs, "categories"), Void.class, Categories.class);
        FIXED = AttributeKey.of(new QName(null, "fixed"), Fixed.class);
        HREF = AttributeKey.of(new QName(null, "href"), String.class);
        SCHEME = AttributeKey.of(new QName(null, "scheme"), String.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(FIXED);
            builder.addAttribute(HREF);
            builder.addAttribute(SCHEME);
            builder.addElement(Category.KEY).setCardinality(Cardinality.MULTIPLE);
        }
    }

    public Categories() {
        super(KEY);
    }

    protected Categories(ElementKey<?, ? extends Categories> key) {
        super((ElementKey) key);
    }

    protected Categories(ElementKey<?, ? extends Categories> key, Element source) {
        super(key, source);
    }

    public Categories lock() {
        return (Categories) super.lock();
    }

    public List<Category> getCategories() {
        return super.getElements(Category.KEY);
    }

    public Categories addCategory(Category category) {
        super.addElement(Category.KEY, (Element) category);
        return this;
    }

    public boolean removeCategory(Category category) {
        return super.removeElement((Element) category);
    }

    public void clearCategories() {
        super.removeElement(Category.KEY);
    }

    public boolean hasCategories() {
        return super.hasElement(Category.KEY);
    }

    public Fixed getFixed() {
        return (Fixed) super.getAttributeValue(FIXED);
    }

    public Categories setFixed(Fixed fixed) {
        super.setAttributeValue(FIXED, (Object) fixed);
        return this;
    }

    public boolean hasFixed() {
        return super.hasAttribute(FIXED);
    }

    public String getHref() {
        return (String) super.getAttributeValue(HREF);
    }

    public Categories setHref(String href) {
        super.setAttributeValue(HREF, (Object) href);
        return this;
    }

    public boolean hasHref() {
        return super.hasAttribute(HREF);
    }

    public String getScheme() {
        return (String) super.getAttributeValue(SCHEME);
    }

    public Categories setScheme(String scheme) {
        super.setAttributeValue(SCHEME, (Object) scheme);
        return this;
    }

    public boolean hasScheme() {
        return super.hasAttribute(SCHEME);
    }
}
