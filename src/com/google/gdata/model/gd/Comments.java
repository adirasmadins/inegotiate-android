package com.google.gdata.model.gd;

import com.amazonaws.javax.xml.stream.Constants;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;

public class Comments extends Element {
    public static final ElementKey<Void, Comments> KEY;

    static {
        KEY = ElementKey.of(new QName(Namespaces.gNs, Constants.DOM_COMMENTS), Void.class, Comments.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(KEY).addElement(FeedLink.KEY).setRequired(true);
        }
    }

    public Comments() {
        super(KEY);
    }

    protected Comments(ElementKey<?, ? extends Comments> key) {
        super((ElementKey) key);
    }

    protected Comments(ElementKey<?, ? extends Comments> key, Element source) {
        super(key, source);
    }

    public Comments lock() {
        return (Comments) super.lock();
    }

    public FeedLink getFeedLink() {
        return (FeedLink) super.getElement(FeedLink.KEY);
    }

    public Comments setFeedLink(FeedLink feedLink) {
        super.setElement(FeedLink.KEY, (Element) feedLink);
        return this;
    }

    public boolean hasFeedLink() {
        return super.hasElement(FeedLink.KEY);
    }
}
