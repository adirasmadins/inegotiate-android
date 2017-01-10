package com.google.gdata.model.gd;

import com.google.gdata.data.ILink;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.Feed;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;

public class FeedLink extends Element implements ILink {
    public static final AttributeKey<Integer> COUNT_HINT;
    public static final AttributeKey<String> HREF;
    public static final ElementKey<Void, FeedLink> KEY;
    public static final AttributeKey<Boolean> READ_ONLY;
    public static final AttributeKey<String> REL;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, "feedLink"), FeedLink.class);
        COUNT_HINT = AttributeKey.of(new QName("countHint"), Integer.class);
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
            builder.addAttribute(COUNT_HINT);
            builder.addElement(Feed.KEY);
        }
    }

    public FeedLink() {
        super(KEY);
    }

    protected FeedLink(ElementKey<?, ? extends FeedLink> key) {
        super((ElementKey) key);
    }

    protected FeedLink(ElementKey<?, ? extends FeedLink> key, Element source) {
        super(key, source);
    }

    public Integer getCountHint() {
        return (Integer) getAttributeValue(COUNT_HINT);
    }

    public void setCountHint(Integer countHint) {
        setAttributeValue(COUNT_HINT, (Object) countHint);
    }

    public boolean hasCountHint() {
        return getCountHint() != null;
    }

    public Feed getFeed() {
        return (Feed) getElement(Feed.KEY);
    }

    public void setFeed(Feed feed) {
        setElement(Feed.KEY, (Element) feed);
    }

    public boolean hasFeed() {
        return hasElement(Feed.KEY);
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
        return "{FeedLink countHint=" + getAttributeValue(COUNT_HINT) + " href=" + ((String) getAttributeValue(HREF)) + " readOnly=" + getAttributeValue(READ_ONLY) + " rel=" + ((String) getAttributeValue(REL)) + "}";
    }

    public String getType() {
        return ContentType.getAtomFeed().toString();
    }

    public void setType(String type) {
        throw new UnsupportedOperationException("Type property not modifiable in " + FeedLink.class.getSimpleName());
    }
}
