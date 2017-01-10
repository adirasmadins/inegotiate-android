package com.google.gdata.model.atom;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.Service;
import com.google.gdata.data.IFeed;
import com.google.gdata.data.IGenerator;
import com.google.gdata.data.ILink;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.ITextConstruct;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.model.batch.BatchOperation;
import com.google.gdata.model.gd.GdAttributes;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.NotModifiedException;
import com.google.gdata.util.ServiceException;
import com.google.gdata.wireformats.ContentCreationException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Feed extends Source implements IFeed {
    public static final ElementKey<Integer, Element> ITEMS_PER_PAGE;
    public static final ElementKey<Void, Feed> KEY;
    public static final ElementKey<Integer, Element> START_INDEX;
    public static final ElementKey<Integer, Element> TOTAL_RESULTS;
    public static final AttributeKey<URI> XML_BASE;
    protected final FeedState feedState;

    protected static class FeedState {
        public boolean canPost;
        public Service service;
        public String versionId;

        protected FeedState() {
            this.canPost = true;
        }
    }

    public /* bridge */ /* synthetic */ ILink addLink(String x0, String x1, String x2) {
        return super.addLink(x0, x1, x2);
    }

    public /* bridge */ /* synthetic */ IGenerator getGenerator() {
        return super.getGenerator();
    }

    public /* bridge */ /* synthetic */ ILink getLink(String x0, String x1) {
        return super.getLink(x0, x1);
    }

    public /* bridge */ /* synthetic */ ITextConstruct getSubtitle() {
        return super.getSubtitle();
    }

    public /* bridge */ /* synthetic */ ITextConstruct getTitle() {
        return super.getTitle();
    }

    public /* bridge */ /* synthetic */ IGenerator setGenerator(String x0, String x1, String x2) {
        return super.setGenerator(x0, x1, x2);
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomNs, "feed"), Feed.class);
        XML_BASE = AttributeKey.of(new QName(Namespaces.xmlNs, "base"), URI.class);
        ITEMS_PER_PAGE = ElementKey.of(new QName(Namespaces.openSearch1_1Ns, "itemsPerPage"), Integer.class, Element.class);
        START_INDEX = ElementKey.of(new QName(Namespaces.openSearch1_1Ns, "startIndex"), Integer.class, Element.class);
        TOTAL_RESULTS = ElementKey.of(new QName(Namespaces.openSearch1_1Ns, "totalResults"), Integer.class, Element.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            Source.registerMetadata(registry);
            ElementCreator builder = registry.build(KEY);
            builder.addAttribute(GdAttributes.ETAG);
            builder.addAttribute(GdAttributes.KIND);
            builder.addAttribute(GdAttributes.FIELDS);
            builder.addAttribute(XML_BASE);
            builder.addElement(TOTAL_RESULTS);
            builder.addElement(START_INDEX);
            builder.addElement(ITEMS_PER_PAGE);
            builder.addElement(BatchOperation.KEY);
            builder.addUndeclaredElementMarker();
            builder.addElement(Entry.KEY);
        }
    }

    public Feed() {
        this(KEY);
    }

    protected Feed(ElementKey<?, ? extends Feed> key) {
        super((ElementKey) key);
        this.feedState = new FeedState();
    }

    protected Feed(ElementKey<?, ? extends Feed> key, Feed source) {
        super(key, source);
        this.feedState = source.feedState;
    }

    public Service getService() {
        return this.feedState.service;
    }

    public void setService(Service v) {
        this.feedState.service = v;
        for (Entry entry : getEntries()) {
            entry.setService(v);
        }
    }

    public boolean getCanPost() {
        return this.feedState.canPost;
    }

    public void setCanPost(boolean v) {
        this.feedState.canPost = v;
    }

    public String getVersionId() {
        return this.feedState.versionId;
    }

    public void setVersionId(String v) {
        this.feedState.versionId = v;
    }

    public String getEtag() {
        return (String) getAttributeValue(GdAttributes.ETAG);
    }

    public void setEtag(String v) {
        setAttributeValue(GdAttributes.ETAG, (Object) v);
    }

    public String getKind() {
        return (String) getAttributeValue(GdAttributes.KIND);
    }

    public void setKind(String v) {
        setAttributeValue(GdAttributes.KIND, (Object) v);
    }

    public String getSelectedFields() {
        return (String) getAttributeValue(GdAttributes.FIELDS);
    }

    public void setSelectedFields(String v) {
        setAttributeValue(GdAttributes.FIELDS, (Object) v);
    }

    public URI getXmlBase() {
        return (URI) getAttributeValue(XML_BASE);
    }

    public void setXmlBase(URI v) {
        setAttributeValue(XML_BASE, (Object) v);
    }

    public int getTotalResults() {
        Integer v = (Integer) getElementValue(TOTAL_RESULTS);
        if (v == null) {
            return -1;
        }
        return v.intValue();
    }

    public void setTotalResults(int v) {
        if (v != -1) {
            setElement(TOTAL_RESULTS, new Element(TOTAL_RESULTS).setTextValue(Integer.valueOf(v)));
        } else {
            removeElement(TOTAL_RESULTS);
        }
    }

    public int getStartIndex() {
        Integer v = (Integer) getElementValue(START_INDEX);
        if (v == null) {
            return -1;
        }
        return v.intValue();
    }

    public void setStartIndex(int v) {
        if (v != -1) {
            setElement(START_INDEX, new Element(START_INDEX).setTextValue(Integer.valueOf(v)));
        } else {
            removeElement(START_INDEX);
        }
    }

    public int getItemsPerPage() {
        Integer v = (Integer) getElementValue(ITEMS_PER_PAGE);
        if (v == null) {
            return -1;
        }
        return v.intValue();
    }

    public void setItemsPerPage(int v) {
        if (v != -1) {
            setElement(ITEMS_PER_PAGE, new Element(ITEMS_PER_PAGE).setTextValue(Integer.valueOf(v)));
        } else {
            removeElement(ITEMS_PER_PAGE);
        }
    }

    public List<? extends Entry> getEntries() {
        return getElements(Entry.KEY);
    }

    protected <T extends Entry> List<T> getEntries(ElementKey<?, T> key) {
        return getElements((ElementKey) key);
    }

    public void setEntries(Collection<? extends Entry> entries) {
        clearEntries();
        for (Entry entry : entries) {
            addElement(Entry.KEY, (Element) entry);
        }
    }

    public void clearEntries() {
        removeElement(Entry.KEY);
    }

    public void addEntry(Entry entry) {
        addElement(entry);
    }

    public boolean removeEntry(Entry entry) {
        return removeElement(Entry.KEY, entry);
    }

    public Entry createEntry() {
        return createEntry(Entry.KEY);
    }

    public <E extends Entry> E createEntry(ElementKey<?, E> entryKey) {
        try {
            Entry entry = (Entry) Element.createElement(entryKey);
            if (this.feedState.service != null) {
                entry.setService(this.feedState.service);
            }
            return entry;
        } catch (ContentCreationException cce) {
            throw new IllegalStateException(cce);
        }
    }

    public Link getEntryPostLink() {
        return getLink(Rel.ENTRY_POST, Type.ATOM);
    }

    public Link getSelfLink() {
        return getLink(Rel.SELF, Type.ATOM);
    }

    public Link getNextLink() {
        return getLink(Rel.NEXT, Type.ATOM);
    }

    public Link getPreviousLink() {
        return getLink(Rel.PREVIOUS, Type.ATOM);
    }

    public Link getFeedBatchLink() {
        return getLink(Rel.FEED_BATCH, Type.ATOM);
    }

    public Feed getSelf() throws IOException, ServiceException {
        if (this.feedState.service == null) {
            throw new ServiceException(CoreErrorDomain.ERR.feedNotAssociated);
        }
        Link selfLink = getSelfLink();
        if (selfLink == null) {
            throw new UnsupportedOperationException("Feed cannot be retrieved");
        }
        URL feedUrl = selfLink.getHrefUri().toURL();
        try {
            String etag = getEtag();
            if (etag != null) {
                return (Feed) this.feedState.service.getFeed(feedUrl, getClass(), etag);
            }
            return (Feed) this.feedState.service.getFeed(feedUrl, getClass(), getUpdated());
        } catch (NotModifiedException e) {
            return this;
        }
    }

    public void removeLinks() {
        removeElement(Link.KEY);
    }

    public <T extends Entry> T insert(T newEntry) throws ServiceException, IOException {
        if (this.feedState.service == null) {
            throw new ServiceException(CoreErrorDomain.ERR.entryNotAssociated);
        }
        Link postLink = getEntryPostLink();
        if (postLink == null) {
            throw new UnsupportedOperationException("Media cannot be inserted");
        }
        return (Entry) this.feedState.service.insert(postLink.getHrefUri().toURL(), newEntry);
    }

    protected Element narrow(ElementMetadata<?, ?> meta, ValidationContext vc) {
        String kind = Kinds.getElementKind(this);
        if (kind != null) {
            return adapt(this, meta, kind);
        }
        return super.narrow(meta, vc);
    }

    public Element resolve(ElementMetadata<?, ?> metadata, ValidationContext vc) {
        this.feedState.canPost = getEntryPostLink() != null;
        return super.resolve(metadata, vc);
    }

    public <T extends Entry> List<T> getEntries(Class<T> returnClass) {
        List<T> result = new ArrayList();
        for (Entry entry : getEntries()) {
            if (returnClass.isInstance(entry)) {
                result.add(returnClass.cast(entry));
            }
        }
        return result;
    }
}
