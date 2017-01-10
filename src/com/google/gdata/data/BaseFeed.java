package com.google.gdata.data;

import com.amazonaws.javax.xml.transform.OutputKeys;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.DocumentQuery;
import com.google.gdata.client.GDataProtocol.Parameter;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.Versions;
import com.google.gdata.data.BaseEntry.AtomHandler;
import com.google.gdata.data.ExtensionVisitor.StoppedException;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.Kind.Adaptable;
import com.google.gdata.data.Kind.AdaptableHelper;
import com.google.gdata.data.Kind.Adaptor;
import com.google.gdata.data.Kind.AdaptorException;
import com.google.gdata.data.Source.SourceHandler;
import com.google.gdata.data.TextConstruct.RssFormat;
import com.google.gdata.util.EventSourceParser;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.NotModifiedException;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.ParseUtil;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.XmlParser;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import org.xml.sax.Attributes;

public abstract class BaseFeed<F extends BaseFeed, E extends BaseEntry> extends Source implements Adaptable, Adaptor, IFeed {
    private static final Collection<Attribute> rssHeaderAttrs;
    protected List<E> entries;
    protected Class<? extends E> entryClass;
    protected FeedState feedState;

    public class FeedHandler extends SourceHandler {
        private XmlNamespace openSearchNs;

        private class ItemsPerPageHandler extends ElementHandler {
            private ItemsPerPageHandler() {
            }

            public void processEndElement() throws ParseException {
                if (BaseFeed.this.feedState.itemsPerPage != -1) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateItemsPerPage);
                } else if (this.value == null) {
                    throw new ParseException(CoreErrorDomain.ERR.logoValueRequired);
                } else {
                    try {
                        BaseFeed.this.feedState.itemsPerPage = Integer.valueOf(this.value).intValue();
                    } catch (NumberFormatException e) {
                        throw new ParseException(CoreErrorDomain.ERR.itemsPerPageNotInteger);
                    }
                }
            }
        }

        private class StartIndexHandler extends ElementHandler {
            private StartIndexHandler() {
            }

            public void processEndElement() throws ParseException {
                if (BaseFeed.this.feedState.startIndex != -1) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateStartIndex);
                } else if (this.value == null) {
                    throw new ParseException(CoreErrorDomain.ERR.logoValueRequired);
                } else {
                    try {
                        BaseFeed.this.feedState.startIndex = Integer.valueOf(this.value).intValue();
                    } catch (NumberFormatException e) {
                        throw new ParseException(CoreErrorDomain.ERR.startIndexNotInteger);
                    }
                }
            }
        }

        private class TotalResultsHandler extends ElementHandler {
            private TotalResultsHandler() {
            }

            public void processEndElement() throws ParseException {
                if (BaseFeed.this.feedState.totalResults != -1) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateTotalResults);
                } else if (this.value == null) {
                    throw new ParseException(CoreErrorDomain.ERR.logoValueRequired);
                } else {
                    try {
                        BaseFeed.this.feedState.totalResults = Integer.valueOf(this.value).intValue();
                    } catch (NumberFormatException e) {
                        throw new ParseException(CoreErrorDomain.ERR.totalResultsNotInteger);
                    }
                }
            }
        }

        public FeedHandler(ExtensionProfile extProfile) {
            super(extProfile, BaseFeed.this.getClass());
            this.openSearchNs = Namespaces.getOpenSearchNs();
        }

        public void processAttribute(String namespace, String localName, String value) throws ParseException {
            if (namespace.equals(Namespaces.f443g)) {
                if (localName.equals("etag")) {
                    BaseFeed.this.setEtag(value);
                    return;
                } else if (localName.equals(Parameter.FIELDS)) {
                    BaseFeed.this.setSelectedFields(value);
                    return;
                } else if (localName.equals("kind")) {
                    BaseFeed.this.setKind(value);
                    return;
                }
            }
            super.processAttribute(namespace, localName, value);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            ElementHandler extensionHandler = BaseFeed.this.getExtensionHandler(this.extProfile, BaseFeed.this.getClass(), namespace, localName, attrs);
            if (extensionHandler != null) {
                return extensionHandler;
            }
            if (namespace.equals(Namespaces.atom)) {
                if (!localName.equals("entry")) {
                    return super.getChildHandler(namespace, localName, attrs);
                }
                E entry = BaseFeed.this.createEntry();
                BaseFeed.this.entries.add(entry);
                entry.getClass();
                return new AtomHandler(this.extProfile);
            } else if (!namespace.equals(this.openSearchNs.getUri())) {
                return super.getChildHandler(namespace, localName, attrs);
            } else {
                if (localName.equals("totalResults")) {
                    return new TotalResultsHandler();
                }
                if (localName.equals("startIndex")) {
                    return new StartIndexHandler();
                }
                if (localName.equals("itemsPerPage")) {
                    return new ItemsPerPageHandler();
                }
                return null;
            }
        }

        public void processEndElement() {
            BaseFeed.this.feedState.canPost = BaseFeed.this.getEntryPostLink() != null;
        }
    }

    protected static class FeedState {
        public Adaptable adaptable;
        public boolean canPost;
        public String etag;
        public String fields;
        public int itemsPerPage;
        public String kind;
        public Service service;
        public int startIndex;
        public int totalResults;
        public String versionId;

        protected FeedState() {
            this.canPost = true;
            this.totalResults = -1;
            this.startIndex = -1;
            this.itemsPerPage = -1;
            this.adaptable = new AdaptableHelper();
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

    protected BaseFeed(Class<? extends E> entryClass) {
        this.entries = new LinkedList();
        this.feedState = new FeedState();
        this.entryClass = entryClass;
    }

    protected BaseFeed(Class<? extends E> entryClass, BaseFeed<?, ?> sourceFeed) {
        super(sourceFeed);
        this.entries = new LinkedList();
        this.feedState = sourceFeed.feedState;
        this.entryClass = entryClass;
    }

    public void declareExtensions(ExtensionProfile extProfile) {
        extProfile.addDeclarations(createEntry());
    }

    public Service getService() {
        return this.feedState.service;
    }

    public void setService(Service v) {
        this.feedState.service = v;
        for (BaseEntry entry : this.entries) {
            entry.setService(v);
        }
    }

    public boolean getCanPost() {
        return this.feedState.canPost;
    }

    public void setCanPost(boolean v) {
        this.feedState.canPost = v;
    }

    public void setVersionId(String v) {
        this.feedState.versionId = v;
    }

    public String getVersionId() {
        return this.feedState.versionId;
    }

    public String getEtag() {
        return this.feedState.etag;
    }

    public void setEtag(String v) {
        this.feedState.etag = v;
    }

    public String getSelectedFields() {
        return this.feedState.fields;
    }

    public void setSelectedFields(String fields) {
        this.feedState.fields = fields;
    }

    public String getKind() {
        return this.feedState.kind;
    }

    public void setKind(String v) {
        this.feedState.kind = v;
    }

    public int getTotalResults() {
        return this.feedState.totalResults;
    }

    public void setTotalResults(int v) {
        this.feedState.totalResults = v;
    }

    public int getStartIndex() {
        return this.feedState.startIndex;
    }

    public void setStartIndex(int v) {
        this.feedState.startIndex = v;
    }

    public int getItemsPerPage() {
        return this.feedState.itemsPerPage;
    }

    public void setItemsPerPage(int v) {
        this.feedState.itemsPerPage = v;
    }

    public List<E> getEntries() {
        return this.entries;
    }

    public void setEntries(List<E> entryList) {
        this.entries = entryList;
    }

    public void addAdaptor(Adaptor adaptor) {
        this.feedState.adaptable.addAdaptor(adaptor);
    }

    public Collection<Adaptor> getAdaptors() {
        return this.feedState.adaptable.getAdaptors();
    }

    public <A extends Adaptor> A getAdaptor(Class<A> adaptorClass) {
        return this.feedState.adaptable.getAdaptor(adaptorClass);
    }

    public E createEntry() {
        try {
            BaseEntry entry = (BaseEntry) this.entryClass.newInstance();
            if (this.feedState.service != null) {
                entry.setService(this.feedState.service);
            }
            return entry;
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException(e2);
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

    public F getSelf() throws IOException, ServiceException {
        if (this.feedState.service == null) {
            throw new ServiceException(CoreErrorDomain.ERR.feedNotAssociated);
        }
        Link selfLink = getSelfLink();
        if (selfLink == null) {
            throw new UnsupportedOperationException("Feed cannot be retrieved");
        }
        URL feedUrl = new URL(selfLink.getHref());
        try {
            if (this.feedState.etag != null) {
                return (BaseFeed) this.feedState.service.getFeed(feedUrl, getClass(), this.feedState.etag);
            }
            return (BaseFeed) this.feedState.service.getFeed(feedUrl, getClass(), this.srcState.updated);
        } catch (NotModifiedException e) {
            return this;
        }
    }

    public <T extends E> T insert(T newEntry) throws ServiceException, IOException {
        if (this.feedState.service == null) {
            throw new ServiceException(CoreErrorDomain.ERR.entryNotAssociated);
        }
        Link postLink = getEntryPostLink();
        if (postLink == null) {
            throw new UnsupportedOperationException("Media cannot be inserted");
        }
        return (BaseEntry) this.feedState.service.insert(new URL(postLink.getHref()), newEntry);
    }

    protected void visitChildren(ExtensionVisitor ev) throws StoppedException {
        for (BaseEntry<E> entry : this.entries) {
            visitChild(ev, entry);
        }
        for (Link link : getLinks()) {
            visitChild(ev, link);
        }
        super.visitChildren(ev);
    }

    public void generate(XmlWriter w, ExtensionProfile p) throws IOException {
        generateAtom(w, p);
    }

    public void generateAtom(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        generateFeedStart(extProfile, w, null);
        generateEntries(w, extProfile);
        generateFeedEnd(w);
    }

    private void generateEntries(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        w.startRepeatingElement();
        for (BaseEntry entry : this.entries) {
            entry.generateAtom(w, extProfile);
        }
        w.endRepeatingElement();
    }

    public void generateFeedEnd(XmlWriter w) throws IOException {
        w.endElement(Namespaces.atomNs, "feed");
    }

    public void generateFeedStart(ExtensionProfile extProfile, XmlWriter w, Collection<XmlNamespace> collection) throws IOException {
        XmlNamespace openSearchNs = Namespaces.getOpenSearchNs();
        Set<XmlNamespace> nsDecls = new LinkedHashSet();
        nsDecls.add(Namespaces.atomNs);
        nsDecls.add(openSearchNs);
        nsDecls.addAll(extProfile.getNamespaceDecls());
        ArrayList<Attribute> attrs = new ArrayList(3);
        if (this.feedState.kind != null && Service.getVersion().isAfter(Versions.V1)) {
            nsDecls.add(Namespaces.gNs);
            attrs.add(new Attribute(Namespaces.gAlias, "kind", this.feedState.kind));
        }
        if (this.feedState.etag != null && Service.getVersion().isAfter(Versions.V1)) {
            nsDecls.add(Namespaces.gNs);
            attrs.add(new Attribute(Namespaces.gAlias, "etag", this.feedState.etag));
        }
        if (this.feedState.fields != null && Service.getVersion().isAfter(Versions.V1)) {
            nsDecls.add(Namespaces.gNs);
            attrs.add(new Attribute(Namespaces.gAlias, Parameter.FIELDS, this.feedState.fields));
        }
        AttributeGenerator generator = new AttributeGenerator();
        putAttributes(generator);
        generateAttributes(attrs, generator);
        generateStartElement(w, Namespaces.atomNs, "feed", attrs, nsDecls);
        generateInnerAtom(w, extProfile);
        if (getTotalResults() != -1) {
            w.simpleElement(openSearchNs, "totalResults", null, String.valueOf(this.feedState.totalResults));
        }
        if (getStartIndex() != -1) {
            w.simpleElement(openSearchNs, "startIndex", null, String.valueOf(this.feedState.startIndex));
        }
        if (getItemsPerPage() != -1) {
            w.simpleElement(openSearchNs, "itemsPerPage", null, String.valueOf(this.feedState.itemsPerPage));
        }
        generateExtensions(w, extProfile);
    }

    public void generateRss(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        XmlNamespace openSearchNs = Namespaces.getOpenSearchNs();
        Vector<XmlNamespace> nsDecls = new Vector();
        nsDecls.add(Namespaces.atomNs);
        nsDecls.add(openSearchNs);
        nsDecls.addAll(extProfile.getNamespaceDecls());
        w.startElement(Namespaces.rssNs, "rss", rssHeaderAttrs, nsDecls);
        generateStartElement(w, Namespaces.rssNs, "channel", null, null);
        if (this.srcState.id != null) {
            w.simpleElement(Namespaces.atomNs, "id", null, this.srcState.id);
        }
        if (this.xmlBlob != null) {
            String lang = this.xmlBlob.getLang();
            if (lang != null) {
                w.simpleElement(Namespaces.rssNs, "language", null, lang);
            }
        }
        if (this.srcState.updated != null) {
            w.simpleElement(Namespaces.rssNs, "lastBuildDate", null, this.srcState.updated.toStringRfc822());
        }
        w.startRepeatingElement();
        Iterator i$ = this.srcState.categories.iterator();
        while (i$.hasNext()) {
            ((Category) i$.next()).generateRss(w);
        }
        w.endRepeatingElement();
        if (this.srcState.title != null) {
            this.srcState.title.generateRss(w, DocumentQuery.TITLE_SORT, RssFormat.PLAIN_TEXT);
        }
        if (this.srcState.subtitle != null) {
            this.srcState.subtitle.generateRss(w, "description", RssFormat.FULL_HTML);
        } else {
            w.simpleElement(Namespaces.rssNs, "description", null, null);
        }
        Link htmlLink = getHtmlLink();
        if (htmlLink != null) {
            w.simpleElement(Namespaces.rssNs, "link", null, htmlLink.getHref());
        }
        if (!(this.srcState.logo == null && this.srcState.icon == null)) {
            String str;
            w.startElement(Namespaces.rssNs, "image", null, null);
            XmlNamespace xmlNamespace = Namespaces.rssNs;
            String str2 = "url";
            if (this.srcState.logo != null) {
                str = this.srcState.logo;
            } else {
                str = this.srcState.icon;
            }
            w.simpleElement(xmlNamespace, str2, null, str);
            if (this.srcState.title != null) {
                this.srcState.title.generateRss(w, DocumentQuery.TITLE_SORT, RssFormat.PLAIN_TEXT);
            }
            if (htmlLink != null) {
                w.simpleElement(Namespaces.rssNs, "link", null, htmlLink.getHref());
            }
            w.endElement(Namespaces.rssNs, "image");
        }
        if (this.srcState.rights != null) {
            this.srcState.rights.generateRss(w, "copyright", RssFormat.PLAIN_TEXT);
        }
        if (this.srcState.authors.size() > 0) {
            ((Person) this.srcState.authors.get(0)).generateRss(w, "managingEditor");
        }
        if (this.srcState.generator != null) {
            String name = this.srcState.generator.getName();
            if (name != null) {
                w.simpleElement(Namespaces.rssNs, "generator", null, name);
            }
        }
        if (getTotalResults() != -1) {
            w.simpleElement(openSearchNs, "totalResults", null, String.valueOf(this.feedState.totalResults));
        }
        if (getStartIndex() != -1) {
            w.simpleElement(openSearchNs, "startIndex", null, String.valueOf(this.feedState.startIndex));
        }
        if (getItemsPerPage() != -1) {
            w.simpleElement(openSearchNs, "itemsPerPage", null, String.valueOf(this.feedState.itemsPerPage));
        }
        generateExtensions(w, extProfile);
        w.startRepeatingElement();
        for (BaseEntry entry : this.entries) {
            entry.generateRss(w, extProfile);
        }
        w.endRepeatingElement();
        w.endElement(Namespaces.rssNs, "channel");
        w.endElement(Namespaces.rssNs, "rss");
    }

    static {
        rssHeaderAttrs = new Vector(1);
        rssHeaderAttrs.add(new Attribute(OutputKeys.VERSION, "2.0"));
    }

    public static BaseFeed<?, ?> readFeed(ParseSource source) throws IOException, ParseException, ServiceException {
        return readFeed(source, null, null);
    }

    public static <F extends BaseFeed> F readFeed(ParseSource source, Class<F> feedClass, ExtensionProfile extProfile) throws IOException, ParseException, ServiceException {
        return (BaseFeed) ParseUtil.readFeed(source, feedClass, extProfile, null);
    }

    public void parseAtom(ExtensionProfile extProfile, InputStream input) throws IOException, ParseException {
        new XmlParser().parse(input, new FeedHandler(extProfile), Namespaces.atom, "feed");
    }

    public void parseAtom(ExtensionProfile extProfile, Reader reader) throws IOException, ParseException {
        new XmlParser().parse(reader, new FeedHandler(extProfile), Namespaces.atom, "feed");
    }

    public void parseAtom(ExtensionProfile extProfile, XmlEventSource source) throws IOException, ParseException {
        new EventSourceParser(new FeedHandler(extProfile), Namespaces.atom, "feed").parse(source);
    }

    public ElementHandler getHandler(ExtensionProfile p, String namespace, String localName, Attributes attrs) throws ParseException {
        return new FeedHandler(p);
    }

    public BaseFeed<?, ?> getAdaptedFeed() throws AdaptorException {
        BaseFeed adaptedFeed = null;
        for (Adaptor adaptor : getAdaptors()) {
            if ((adaptor instanceof BaseFeed) && (adaptedFeed == null || adaptedFeed.getClass().isAssignableFrom(adaptor.getClass()))) {
                adaptedFeed = (BaseFeed) adaptor;
            }
        }
        if (adaptedFeed != null) {
            List<E> sourceEntries;
            if (adaptedFeed != this) {
                sourceEntries = this.entries;
            } else {
                sourceEntries = new ArrayList();
                sourceEntries.addAll(this.entries);
            }
            adaptedFeed.getEntries().clear();
            for (E entry : sourceEntries) {
                adaptedFeed.getEntries().add(entry.getAdaptedEntry());
            }
        }
        return adaptedFeed;
    }

    public <T extends BaseEntry> List<T> getEntries(Class<T> returnClass) {
        List<T> adaptedEntries = new ArrayList();
        for (BaseEntry<?> entry : getEntries()) {
            BaseEntry adapted = (BaseEntry) entry.getAdaptor(returnClass);
            if (adapted != null) {
                adaptedEntries.add(adapted);
            }
        }
        return adaptedEntries;
    }
}
