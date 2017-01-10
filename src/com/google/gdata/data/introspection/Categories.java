package com.google.gdata.data.introspection;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.GDataProtocol.Query;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.Category;
import com.google.gdata.data.Category.AtomHandler;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.xml.sax.Attributes;

public class Categories extends ExtensionPoint {
    private XmlNamespace atomPubNs;
    private List<Category> categories;
    private String defaultScheme;
    private Boolean fixed;
    private String href;

    public class Handler extends ExtensionHandler {
        public Handler(ExtensionProfile extProfile, Attributes attrs) {
            super(extProfile, Categories.class, attrs);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (!namespace.equals(Namespaces.atom) || !localName.equals(Query.CATEGORY)) {
                return super.getChildHandler(namespace, localName, attrs);
            }
            Category category = new Category();
            Categories.this.addCategory(category);
            category.getClass();
            return new AtomHandler();
        }
    }

    public Categories() {
        this.atomPubNs = Namespaces.getAtomPubNs();
    }

    public Categories(boolean fixed, String defaultScheme, Category... categories) {
        this.atomPubNs = Namespaces.getAtomPubNs();
        this.fixed = Boolean.valueOf(fixed);
        this.defaultScheme = defaultScheme;
        if (categories.length != 0) {
            this.categories = Arrays.asList(categories);
        }
    }

    public Categories(String href) {
        this.atomPubNs = Namespaces.getAtomPubNs();
        this.href = href;
    }

    public boolean isFixed() {
        return this.fixed != null && this.fixed.booleanValue();
    }

    public String getDefaultScheme() {
        return this.defaultScheme;
    }

    public String getHref() {
        return this.href;
    }

    public List<Category> getCategoryList() {
        return this.categories;
    }

    public void addCategory(Category category) {
        if (this.categories == null) {
            this.categories = new ArrayList();
        }
        this.categories.add(category);
    }

    public ElementHandler getHandler(ExtensionProfile p, String namespace, String localName, Attributes attrs) {
        return new Handler(p, attrs);
    }

    protected void consumeAttributes(AttributeHelper helper) throws ParseException {
        this.href = helper.consume("href", false);
        this.defaultScheme = helper.consume("scheme", false);
        String fixedValue = helper.consume("fixed", false);
        if (fixedValue == null) {
            return;
        }
        if ("yes".equals(fixedValue)) {
            this.fixed = Boolean.valueOf(true);
        } else if ("no".equals(fixedValue)) {
            this.fixed = Boolean.valueOf(false);
        } else {
            ParseException pe = new ParseException(CoreErrorDomain.ERR.invalidFixedAttribute);
            pe.setInternalReason("Invalid value for fixed attribute:" + fixedValue);
            throw pe;
        }
    }

    public void validate() throws IllegalStateException {
        if (this.href == null) {
            return;
        }
        if (this.fixed != null || this.defaultScheme != null || this.categories != null) {
            throw new IllegalStateException("The href attribute cannot be used with other attributes or nested category elements");
        }
    }

    public void parseAtom(ExtensionProfile extProfile, XmlParser parser) throws IOException, ParseException {
        parser.parse(new Handler(extProfile, null), this.atomPubNs.getUri(), "categories");
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        List<Attribute> attrs = new ArrayList();
        if (this.fixed != null) {
            attrs.add(new Attribute("fixed", this.fixed.booleanValue() ? "yes" : "no"));
        }
        if (this.defaultScheme != null) {
            attrs.add(new Attribute("scheme", this.defaultScheme));
        }
        if (this.href != null) {
            attrs.add(new Attribute("href", this.href));
        }
        w.startElement(this.atomPubNs, "categories", attrs, null);
        if (this.categories != null) {
            w.startRepeatingElement();
            for (Category category : this.categories) {
                category.generateAtom(w);
            }
            w.endRepeatingElement();
        }
        generateExtensions(w, extProfile);
        w.endElement(this.atomPubNs, "categories");
    }
}
