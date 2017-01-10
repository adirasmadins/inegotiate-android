package com.google.gdata.model.atompub;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.DocumentQuery;
import com.google.gdata.data.introspection.IWorkspace;
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
import java.util.List;

public class Workspace extends Element implements IWorkspace {
    public static final ElementKey<Void, Workspace> KEY;
    public static final AttributeKey<String> TITLE;

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomPubStandardNs, "workspace"), Workspace.class);
        TITLE = AttributeKey.of(new QName(DocumentQuery.TITLE_SORT));
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(TITLE).setVisible(false);
            builder.addElement(Collection.KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addElement(Source.TITLE).setRequired(true);
        }
    }

    public Workspace() {
        super(KEY);
    }

    protected Workspace(ElementKey<?, ? extends Workspace> key) {
        super((ElementKey) key);
    }

    protected Workspace(ElementKey<?, ? extends Workspace> key, Element source) {
        super(key, source);
    }

    public Workspace(TextContent title) {
        this();
        setTitle(title);
    }

    public List<Collection> getCollections() {
        return super.getElements(Collection.KEY);
    }

    public void addCollection(Collection collection) {
        super.addElement(Collection.KEY, (Element) collection);
    }

    public Collection addCollection(String collectionUri, String title, String... acceptedTypes) {
        Collection collection = new Collection(collectionUri, TextContent.plainText(title), acceptedTypes);
        addCollection(collection);
        return collection;
    }

    public boolean removeCollection(Collection collection) {
        return super.removeElement(Collection.KEY, collection);
    }

    public boolean hasCollections() {
        return super.hasElement(Collection.KEY);
    }

    public TextContent getTitle() {
        return (TextContent) super.getElement(Source.TITLE);
    }

    public void setTitle(TextContent title) {
        setAttributeValue(TITLE, title == null ? null : title.getPlainText());
        super.setElement(Source.TITLE, (Element) title);
    }

    public boolean hasTitle() {
        return super.hasElement(Source.TITLE);
    }

    public Element resolve(ElementMetadata<?, ?> meta, ValidationContext vc) {
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
        return super.resolve(meta, vc);
    }

    public String toString() {
        return "{Workspace" + super.toString() + "}";
    }
}
