package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.GDataProtocol.Query;
import com.google.gdata.data.Kind.Adaptable;
import com.google.gdata.data.Kind.Adaptor;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.Attributes;

public class Category implements ICategory {
    public static final char SCHEME_PREFIX = '{';
    public static final char SCHEME_SUFFIX = '}';
    private static final Pattern categoryPattern;
    protected String label;
    protected String labelLang;
    protected String scheme;
    protected String term;

    public class AtomHandler extends ElementHandler {
        Adaptable adaptable;
        Set<Category> categorySet;
        ExtensionProfile extProfile;

        public AtomHandler(ExtensionProfile extProfile, Set<Category> categorySet, Adaptable adaptable) {
            this.extProfile = extProfile;
            this.categorySet = categorySet;
            this.adaptable = adaptable;
        }

        public void processAttribute(String namespace, String localName, String value) {
            if (namespace.equals(StringUtil.EMPTY_STRING) && localName.equals("scheme")) {
                Category.this.scheme = value;
            } else if (namespace.equals(StringUtil.EMPTY_STRING) && localName.equals("term")) {
                Category.this.term = value;
            } else if (namespace.equals(StringUtil.EMPTY_STRING) && localName.equals("label")) {
                Category.this.label = value;
            }
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) {
            return null;
        }

        public void processEndElement() throws ParseException {
            if (Category.this.term == null) {
                throw new ParseException(CoreErrorDomain.ERR.missingTermAttribute);
            }
            Category.this.labelLang = this.xmlLang;
            if (this.categorySet != null) {
                this.categorySet.add(Category.this);
            }
            if (this.adaptable != null && this.extProfile.isAutoExtending() && Kind.isKindCategory(Category.this)) {
                try {
                    Adaptor adaptor = Kind.getAdaptor(Category.this.term, this.adaptable);
                    if (adaptor != null) {
                        this.extProfile.addDeclarations(adaptor);
                    }
                } catch (Throwable ae) {
                    throw new ParseException(CoreErrorDomain.ERR.cantLoadKindAdaptor, ae);
                }
            }
        }
    }

    static {
        categoryPattern = Pattern.compile("(\\{([^\\}]+)\\})?(.+)");
    }

    public Category(String category) {
        Matcher m = categoryPattern.matcher(category);
        if (m.matches()) {
            if (m.group(2) != null) {
                this.scheme = m.group(2);
            }
            this.term = m.group(3);
            return;
        }
        throw new IllegalArgumentException("Invalid category: " + category);
    }

    public Category(String scheme, String term) {
        this(scheme, term, null);
    }

    public Category(String scheme, String term, String label) {
        this.scheme = scheme;
        if (term == null) {
            throw new NullPointerException("Invalid term. Cannot be null");
        }
        this.term = term;
        this.label = label;
    }

    public String getScheme() {
        return this.scheme;
    }

    public void setScheme(String v) {
        this.scheme = v;
    }

    public String getTerm() {
        return this.term;
    }

    public void setTerm(String v) {
        this.term = v;
    }

    public String getLabel() {
        return this.label;
    }

    public void setLabel(String v) {
        this.label = v;
    }

    public String getLabelLang() {
        return this.labelLang;
    }

    public void setLabelLang(String v) {
        this.labelLang = v;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.scheme != null) {
            sb.append(SCHEME_PREFIX);
            sb.append(this.scheme);
            sb.append(SCHEME_SUFFIX);
        }
        sb.append(this.term);
        if (this.label != null) {
            sb.append("(");
            sb.append(this.label);
            sb.append(")");
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Category) {
            return toString().equals(obj.toString());
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i = 0;
        if (this.scheme != null) {
            hashCode = this.scheme.hashCode();
        } else {
            hashCode = 0;
        }
        hashCode = (((hashCode + 629) * 37) + this.term.hashCode()) * 37;
        if (this.label != null) {
            i = this.label.hashCode();
        }
        return hashCode + i;
    }

    public void generateAtom(XmlWriter w) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(3);
        if (this.scheme != null) {
            attrs.add(new Attribute("scheme", this.scheme));
        }
        if (this.term != null) {
            attrs.add(new Attribute("term", this.term));
        }
        if (this.label != null) {
            attrs.add(new Attribute("label", this.label));
        }
        if (this.labelLang != null) {
            attrs.add(new Attribute("xml:lang", this.labelLang));
        }
        w.simpleElement(Namespaces.atomNs, Query.CATEGORY, attrs, null);
    }

    public void generateRss(XmlWriter w) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(3);
        if (this.scheme != null) {
            attrs.add(new Attribute("domain", this.scheme));
        }
        if (this.labelLang != null) {
            attrs.add(new Attribute("xml:lang", this.labelLang));
        }
        String value = this.term;
        if (this.term == null) {
            value = this.label;
        }
        w.simpleElement(Namespaces.rssNs, Query.CATEGORY, attrs, value);
    }
}
