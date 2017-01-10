package com.google.gdata.model.atom;

import com.google.gdata.client.GDataProtocol.Query;
import com.google.gdata.data.ICategory;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.common.base.Preconditions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Category extends Element implements ICategory {
    public static final ElementKey<Void, Category> KEY;
    public static final AttributeKey<String> LABEL;
    public static final AttributeKey<String> SCHEME;
    public static final AttributeKey<String> TERM;
    public static final AttributeKey<String> XML_LANG;
    private static final Pattern categoryPattern;

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomNs, Query.CATEGORY), Category.class);
        SCHEME = AttributeKey.of(new QName("scheme"));
        TERM = AttributeKey.of(new QName("term"));
        LABEL = AttributeKey.of(new QName("label"));
        XML_LANG = AttributeKey.of(new QName(Namespaces.xmlNs, "lang"));
        categoryPattern = Pattern.compile("(\\{([^\\}]+)\\})?(.+)");
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY).setCardinality(Cardinality.SET);
            builder.addAttribute(XML_LANG);
            builder.addAttribute(SCHEME);
            builder.addAttribute(TERM).setRequired(true);
            builder.addAttribute(LABEL);
        }
    }

    public Category() {
        super(KEY);
    }

    protected Category(ElementKey<?, ? extends Category> key) {
        super((ElementKey) key);
    }

    protected Category(ElementKey<?, ? extends Category> key, Element source) {
        super(key, source);
    }

    public Category(String category) {
        this();
        Matcher m = categoryPattern.matcher(category);
        if (m.matches()) {
            if (m.group(2) != null) {
                setScheme(m.group(2));
            }
            setTerm(m.group(3));
            return;
        }
        throw new IllegalArgumentException("Invalid category: " + category);
    }

    public Category(String scheme, String term) {
        this(scheme, term, null);
    }

    public Category(String scheme, String term, String label) {
        this();
        setScheme(scheme);
        if (term == null) {
            throw new NullPointerException("Invalid term. Cannot be null");
        }
        setTerm(term);
        setLabel(label);
    }

    public Category lock() {
        return (Category) super.lock();
    }

    public String getScheme() {
        return (String) getAttributeValue(SCHEME);
    }

    public void setScheme(String scheme) {
        setAttributeValue(SCHEME, (Object) scheme);
    }

    public String getTerm() {
        return (String) getAttributeValue(TERM);
    }

    public void setTerm(String term) {
        Preconditions.checkNotNull(term, "Null category term");
        setAttributeValue(TERM, (Object) term);
    }

    public String getLabel() {
        return (String) getAttributeValue(LABEL);
    }

    public void setLabel(String label) {
        setAttributeValue(LABEL, (Object) label);
    }

    public String getLabelLang() {
        return (String) getAttributeValue(XML_LANG);
    }

    public void setLabelLang(String lang) {
        setAttributeValue(XML_LANG, (Object) lang);
    }

    protected Element narrow(ElementMetadata<?, ?> meta, ValidationContext vc) {
        return adapt(this, meta, getScheme());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String scheme = getScheme();
        if (scheme != null) {
            sb.append("{");
            sb.append(scheme);
            sb.append("}");
        }
        sb.append(getTerm());
        String label = getLabel();
        if (label != null) {
            sb.append("(");
            sb.append(label);
            sb.append(")");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Category)) {
            return false;
        }
        Category other = (Category) obj;
        String scheme = getScheme();
        if (scheme == null) {
            if (other.getScheme() != null) {
                return false;
            }
        } else if (!scheme.equals(other.getScheme())) {
            return false;
        }
        String term = getTerm();
        if (term == null) {
            if (other.getTerm() != null) {
                return false;
            }
        } else if (!term.equals(other.getTerm())) {
            return false;
        }
        String label = getLabel();
        if (label == null) {
            if (other.getLabel() != null) {
                return false;
            }
        } else if (!label.equals(other.getLabel())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        String scheme = getScheme();
        if (scheme != null) {
            hashCode = scheme.hashCode();
        } else {
            hashCode = 0;
        }
        int result = hashCode + 629;
        String term = getTerm();
        int i2 = result * 37;
        if (term != null) {
            hashCode = term.hashCode();
        } else {
            hashCode = 0;
        }
        result = i2 + hashCode;
        String label = getLabel();
        hashCode = result * 37;
        if (label != null) {
            i = label.hashCode();
        }
        return hashCode + i;
    }
}
