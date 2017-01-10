package com.google.gdata.model.atompub;

import com.google.common.collect.Lists;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.DocumentQuery;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.Versions;
import com.google.gdata.data.Reference;
import com.google.gdata.data.introspection.ICollection;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.model.atom.Source;
import com.google.gdata.model.atom.TextContent;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.Version;
import java.util.List;

public class Collection extends Element implements Reference, ICollection {
    public static final AttributeKey<String> HREF;
    public static final ElementKey<Void, Collection> KEY;
    public static final AttributeKey<String> TITLE;
    private final Version coreVersion;

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomPubStandardNs, "collection"), Collection.class);
        HREF = AttributeKey.of(new QName("href"));
        TITLE = AttributeKey.of(new QName(DocumentQuery.TITLE_SORT));
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(TITLE).setVisible(false);
            builder.addAttribute(HREF);
            builder.addElement(Accept.KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(Categories.KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(Source.TITLE).setRequired(true);
        }
    }

    public Collection() {
        super(KEY);
        this.coreVersion = Service.getVersion();
    }

    protected Collection(ElementKey<?, ? extends Collection> key) {
        super((ElementKey) key);
        this.coreVersion = Service.getVersion();
    }

    protected Collection(ElementKey<?, ? extends Collection> key, Element source) {
        super(key, source);
        this.coreVersion = Service.getVersion();
    }

    public Collection(String href) {
        this();
        setHref(href);
    }

    public Collection(String href, TextContent title, String... accepts) {
        this();
        setHref(href);
        setTitle(title);
        for (String accept : accepts) {
            addAccept(accept);
        }
    }

    public List<Accept> getAccepts() {
        List<Accept> accepts = super.getElements(Accept.KEY);
        if (!this.coreVersion.isCompatible(Versions.V1)) {
            return accepts;
        }
        List<Accept> result = Lists.newArrayList();
        for (Accept accept : accepts) {
            String acceptValue = accept.getValue();
            if (acceptValue == null || acceptValue.indexOf(44) == -1) {
                result.add(accept);
            } else {
                for (String part : acceptValue.split(",")) {
                    result.add(new Accept(part));
                }
            }
        }
        return result;
    }

    public List<String> getAcceptList() {
        List<Accept> accepts = getAccepts();
        List<String> result = Lists.newArrayListWithCapacity(accepts.size());
        for (Accept accept : accepts) {
            result.add(accept.getValue());
        }
        return result;
    }

    public Collection addAccept(Accept accept) {
        super.addElement(Accept.KEY, (Element) accept);
        return this;
    }

    public Collection addAccept(String accept) {
        super.addElement(Accept.KEY, new Accept(accept));
        return this;
    }

    public boolean removeAccept(Accept accept) {
        return super.removeElement(Accept.KEY, accept);
    }

    public boolean removeAccept(String acceptStr) {
        boolean modified = false;
        for (Accept accept : getAccepts()) {
            if (acceptStr.equals(accept.getValue())) {
                super.removeElement(Accept.KEY, accept);
                modified = true;
            }
        }
        return modified;
    }

    public boolean hasAccepts() {
        return super.hasElement(Accept.KEY);
    }

    public List<Categories> getCategorieses() {
        return super.getElements(Categories.KEY);
    }

    public Collection addCategories(Categories categories) {
        super.addElement(Categories.KEY, (Element) categories);
        return this;
    }

    public boolean hasCategorieses() {
        return super.hasElement(Categories.KEY);
    }

    public String getHref() {
        return (String) super.getAttributeValue(HREF);
    }

    public void setHref(String href) {
        setAttributeValue(HREF, (Object) href);
    }

    public boolean hasHref() {
        return getHref() != null;
    }

    public TextContent getTitle() {
        return (TextContent) super.getElement(Source.TITLE);
    }

    public Collection setTitle(TextContent title) {
        setAttributeValue(TITLE, title == null ? null : title.getPlainText());
        super.setElement(Source.TITLE, (Element) title);
        return this;
    }

    public boolean hasTitle() {
        return super.hasElement(Source.TITLE);
    }

    public Element resolve(ElementMetadata<?, ?> metadata, ValidationContext vc) {
        String titleAttribute = (String) getAttributeValue(TITLE);
        TextContent title = (TextContent) getElement(Source.TITLE);
        if (titleAttribute != null) {
            if (title == null) {
                addElement(Source.TITLE, (Element) TextContent.plainText(titleAttribute));
            } else if (!titleAttribute.equals(title.getPlainText())) {
                vc.addError((Element) this, CoreErrorDomain.ERR.duplicateTitle);
            }
        } else if (title != null) {
            setAttributeValue(TITLE, (Object) title.getPlainText());
        }
        if (this.coreVersion.isCompatible(Versions.V1)) {
            List<Accept> accepts = getAccepts();
            if (accepts.size() > 1) {
                StringBuilder sb = new StringBuilder();
                for (Accept accept : accepts) {
                    if (sb.length() > 0) {
                        sb.append(',');
                    }
                    sb.append(accept.getValue());
                }
                removeElement(Accept.KEY);
                addAccept(sb.toString());
            }
        }
        return super.resolve(metadata, vc);
    }

    public String toString() {
        return "{Collection href=" + ((String) getAttributeValue(HREF)) + "}";
    }
}
