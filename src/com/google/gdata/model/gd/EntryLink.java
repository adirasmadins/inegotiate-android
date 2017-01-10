package com.google.gdata.model.gd;

import com.google.gdata.data.ILink;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.Entry;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;

public class EntryLink extends Element implements ILink {
    public static final AttributeKey<String> HREF;
    public static final ElementKey<Void, EntryLink> KEY;
    public static final AttributeKey<Boolean> READ_ONLY;
    public static final AttributeKey<String> REL;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "entryLink"), EntryLink.class);
        HREF = AttributeKey.of(new QName("href"));
        READ_ONLY = AttributeKey.of(new QName("readOnly"), Boolean.class);
        REL = AttributeKey.of(new QName("rel"));
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(REL);
            builder.addAttribute(HREF);
            builder.addAttribute(READ_ONLY);
            builder.addElement(Entry.KEY);
        }
    }

    public EntryLink() {
        super(KEY);
    }

    protected EntryLink(ElementKey<?, ? extends EntryLink> key) {
        super((ElementKey) key);
    }

    protected EntryLink(ElementKey<?, ? extends EntryLink> key, Element source) {
        super(key, source);
    }

    public Entry getEntry() {
        return (Entry) getElement(Entry.KEY);
    }

    public void setEntry(Entry entry) {
        setElement(Entry.KEY, (Element) entry);
    }

    public boolean hasEntry() {
        return hasElement(Entry.KEY);
    }

    public String getHref() {
        return (String) getAttributeValue(HREF);
    }

    public void setHref(String href) {
        setAttributeValue(HREF, (Object) href);
    }

    public boolean hasHref() {
        return getHref() != null;
    }

    public Boolean getReadOnly() {
        return (Boolean) getAttributeValue(READ_ONLY);
    }

    public void setReadOnly(Boolean readOnly) {
        setAttributeValue(READ_ONLY, (Object) readOnly);
    }

    public boolean hasReadOnly() {
        return getReadOnly() != null;
    }

    public String getRel() {
        return (String) getAttributeValue(REL);
    }

    public void setRel(String rel) {
        setAttributeValue(REL, (Object) rel);
    }

    public boolean hasRel() {
        return getRel() != null;
    }

    public String toString() {
        return "{EntryLink href=" + ((String) getAttributeValue(HREF)) + " readOnly=" + getAttributeValue(READ_ONLY) + " rel=" + ((String) getAttributeValue(REL)) + "}";
    }

    public String getType() {
        return ContentType.getAtomFeed().toString();
    }

    public void setType(String type) {
        throw new UnsupportedOperationException("Type property not modifiable in " + FeedLink.class.getSimpleName());
    }
}
