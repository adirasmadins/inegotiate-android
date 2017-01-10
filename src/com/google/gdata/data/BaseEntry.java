package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.DocumentQuery;
import com.google.gdata.client.GDataProtocol;
import com.google.gdata.client.GDataProtocol.Parameter;
import com.google.gdata.client.GDataProtocol.Query;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.Versions;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.data.ExtensionVisitor.StoppedException;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.Kind.Adaptable;
import com.google.gdata.data.Kind.AdaptableHelper;
import com.google.gdata.data.Kind.Adaptor;
import com.google.gdata.data.Kind.AdaptorException;
import com.google.gdata.data.Source.SourceHandler;
import com.google.gdata.data.TextConstruct.ChildHandlerInfo;
import com.google.gdata.data.TextConstruct.RssFormat;
import com.google.gdata.data.batch.BatchInterrupted;
import com.google.gdata.data.batch.BatchStatus;
import com.google.gdata.data.docs.DocumentListEntry;
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
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import org.xml.sax.Attributes;

public abstract class BaseEntry<E extends BaseEntry> extends ExtensionPoint implements Adaptable, Adaptor, IEntry {
    private static final Collection<XmlNamespace> namespaceDeclsAtom;
    private static final Collection<XmlNamespace> namespaceDeclsRss;
    private XmlNamespace atomPubNs;
    protected EntryState state;

    public class AtomHandler extends ExtensionHandler {

        class EditedHandler extends Rfc3339Handler {
            EditedHandler() {
            }

            public void processEndElement() throws ParseException {
                super.processEndElement();
                BaseEntry.this.state.edited = getDateTime();
            }
        }

        class IdHandler extends ElementHandler {
            IdHandler() {
            }

            public void processEndElement() throws ParseException {
                if (BaseEntry.this.state.id != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateEntryId);
                } else if (this.value == null) {
                    throw new ParseException(CoreErrorDomain.ERR.idValueRequired);
                } else {
                    BaseEntry.this.state.id = this.value;
                }
            }
        }

        class PublishedHandler extends Rfc3339Handler {
            PublishedHandler() {
            }

            public void processEndElement() throws ParseException {
                super.processEndElement();
                BaseEntry.this.state.published = getDateTime();
            }
        }

        class UpdatedHandler extends Rfc3339Handler {
            UpdatedHandler() {
            }

            public void processEndElement() throws ParseException {
                super.processEndElement();
                BaseEntry.this.state.updated = getDateTime();
            }
        }

        public AtomHandler(ExtensionProfile extProfile) {
            super(BaseEntry.this, extProfile, BaseEntry.this.getClass());
        }

        public void processAttribute(String namespace, String localName, String value) throws ParseException {
            if (namespace.equals(Namespaces.f443g)) {
                if (localName.equals("etag")) {
                    BaseEntry.this.setEtag(value);
                    return;
                } else if (localName.equals(Parameter.FIELDS)) {
                    BaseEntry.this.setSelectedFields(value);
                    return;
                } else if (localName.equals("kind")) {
                    BaseEntry.this.setKind(value);
                    return;
                }
            }
            super.processAttribute(namespace, localName, value);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (namespace.equals(Namespaces.atom)) {
                if (localName.equals("id")) {
                    return new IdHandler();
                }
                if (localName.equals("published")) {
                    return new PublishedHandler();
                }
                if (localName.equals("updated")) {
                    return new UpdatedHandler();
                }
                ChildHandlerInfo chi;
                if (localName.equals(DocumentQuery.TITLE_SORT)) {
                    chi = TextConstruct.getChildHandler(attrs);
                    if (BaseEntry.this.state.title != null) {
                        throw new ParseException(CoreErrorDomain.ERR.duplicateTitle);
                    }
                    BaseEntry.this.state.title = chi.textConstruct;
                    return chi.handler;
                } else if (localName.equals("summary")) {
                    chi = TextConstruct.getChildHandler(attrs);
                    if (BaseEntry.this.state.summary != null) {
                        throw new ParseException(CoreErrorDomain.ERR.duplicateSummary);
                    }
                    BaseEntry.this.state.summary = chi.textConstruct;
                    return chi.handler;
                } else if (localName.equals("rights")) {
                    chi = TextConstruct.getChildHandler(attrs);
                    if (BaseEntry.this.state.rights != null) {
                        throw new ParseException(CoreErrorDomain.ERR.duplicateRights);
                    }
                    BaseEntry.this.state.rights = chi.textConstruct;
                    return chi.handler;
                } else if (localName.equals("content")) {
                    if (BaseEntry.this.state.content != null) {
                        throw new ParseException(CoreErrorDomain.ERR.duplicateContent);
                    }
                    Content.ChildHandlerInfo chi2 = BaseEntry.this.getContentHandlerInfo(this.extProfile, attrs);
                    BaseEntry.this.state.content = chi2.content;
                    return chi2.handler;
                } else if (localName.equals(Query.CATEGORY)) {
                    Category cat = new Category();
                    cat.getClass();
                    return new com.google.gdata.data.Category.AtomHandler(this.extProfile, BaseEntry.this.state.categories, BaseEntry.this);
                } else if (localName.equals("link")) {
                    Link link = new Link();
                    BaseEntry.this.state.links.add(link);
                    link.getClass();
                    return new com.google.gdata.data.Link.AtomHandler(this.extProfile);
                } else if (localName.equals(Query.AUTHOR)) {
                    Person author;
                    ExtensionDescription extDescription = BaseEntry.this.getExtensionDescription(this.extProfile, this.extendedClass, namespace, localName);
                    if (extDescription == null || extDescription.getExtensionClass() == null) {
                        author = new Person();
                    } else {
                        author = (Person) ExtensionPoint.createExtensionInstance(extDescription.getExtensionClass());
                    }
                    BaseEntry.this.state.authors.add(author);
                    return author.getHandler(this.extProfile, namespace, localName, attrs);
                } else if (localName.equals("contributor")) {
                    Person contributor = new Person();
                    BaseEntry.this.state.contributors.add(contributor);
                    contributor.getClass();
                    return new com.google.gdata.data.Person.AtomHandler(this.extProfile);
                } else if (localName.equals("source")) {
                    BaseEntry.this.state.source = new Source();
                    Source source = BaseEntry.this.state.source;
                    source.getClass();
                    return new SourceHandler(this.extProfile);
                }
            } else if (!namespace.equals(BaseEntry.this.getAtomPubNs().getUri())) {
                return super.getChildHandler(namespace, localName, attrs);
            } else {
                if (localName.equals("control")) {
                    BaseEntry.this.state.pubControl = new PubControl();
                    PubControl pubControl = BaseEntry.this.state.pubControl;
                    pubControl.getClass();
                    return new com.google.gdata.data.PubControl.AtomHandler(this.extProfile);
                } else if (localName.equals("edited")) {
                    return new EditedHandler();
                }
            }
            return null;
        }

        public void processEndElement() throws ParseException {
            if (BaseEntry.this.getExtension(BatchStatus.class) == null && BaseEntry.this.getExtension(BatchInterrupted.class) == null) {
                super.processEndElement();
            }
        }
    }

    protected static class EntryState {
        public Adaptable adaptable;
        public LinkedList<Person> authors;
        public boolean canEdit;
        public HashSet<Category> categories;
        public Content content;
        public LinkedList<Person> contributors;
        public DateTime edited;
        public String etag;
        public String fields;
        public String id;
        public String kind;
        public LinkedList<Link> links;
        public PubControl pubControl;
        public DateTime published;
        public TextConstruct rights;
        public Service service;
        public Source source;
        public TextConstruct summary;
        public TextConstruct title;
        public DateTime updated;
        public String versionId;

        protected EntryState() {
            this.categories = new HashSet();
            this.links = new LinkedList();
            this.authors = new LinkedList();
            this.contributors = new LinkedList();
            this.canEdit = true;
            this.adaptable = new AdaptableHelper();
        }
    }

    private class OutOfLineReference implements Reference, Extension {
        private OutOfLineContent oolContent;

        private OutOfLineReference(OutOfLineContent oolContent) {
            this.oolContent = oolContent;
        }

        public String getHref() {
            return this.oolContent.getUri();
        }

        public void setHref(String href) {
            this.oolContent.setUri(href);
        }

        public void generate(XmlWriter w, ExtensionProfile extProfile) {
            throw new IllegalStateException("Should not be generated");
        }

        public ElementHandler getHandler(ExtensionProfile extProfile, String namespace, String localName, Attributes attrs) {
            throw new IllegalStateException("Should not be parsed");
        }
    }

    protected BaseEntry() {
        this.state = new EntryState();
    }

    private XmlNamespace getAtomPubNs() {
        if (this.atomPubNs == null) {
            this.atomPubNs = Namespaces.getAtomPubNs();
        }
        return this.atomPubNs;
    }

    protected BaseEntry(BaseEntry<?> sourceEntry) {
        super(sourceEntry);
        this.state = sourceEntry.state;
    }

    public String getId() {
        return this.state.id;
    }

    public void setId(String v) {
        if (v == null || !"-".equals(v)) {
            this.state.id = v;
            return;
        }
        throw new IllegalArgumentException("Entry.id must not be equal to '-'.");
    }

    public String getVersionId() {
        return this.state.versionId;
    }

    public void setVersionId(String v) {
        this.state.versionId = v;
    }

    public String getEtag() {
        return this.state.etag;
    }

    public void setEtag(String v) {
        this.state.etag = v;
    }

    public String getSelectedFields() {
        return this.state.fields;
    }

    public void setSelectedFields(String v) {
        this.state.fields = v;
    }

    public String getKind() {
        return this.state.kind;
    }

    public void setKind(String v) {
        this.state.kind = v;
    }

    public DateTime getPublished() {
        return this.state.published;
    }

    public void setPublished(DateTime v) {
        if (v == null || v.getTzShift() != null) {
            this.state.published = v;
            return;
        }
        throw new IllegalArgumentException("Entry.published must have a timezone.");
    }

    public DateTime getUpdated() {
        return this.state.updated;
    }

    public void setUpdated(DateTime v) {
        if (v == null || v.getTzShift() != null) {
            this.state.updated = v;
            return;
        }
        throw new IllegalArgumentException("Entry.updated must have a timezone.");
    }

    public DateTime getEdited() {
        return this.state.edited;
    }

    public void setEdited(DateTime v) {
        if (v == null || v.getTzShift() != null) {
            this.state.edited = v;
            return;
        }
        throw new IllegalArgumentException("Entry.edited must have a timezone.");
    }

    public Set<Category> getCategories() {
        return this.state.categories;
    }

    public TextConstruct getTitle() {
        return this.state.title;
    }

    public void setTitle(TextConstruct v) {
        this.state.title = v;
    }

    public TextConstruct getSummary() {
        return this.state.summary;
    }

    public void setSummary(TextConstruct v) {
        this.state.summary = v;
    }

    public TextConstruct getRights() {
        return this.state.rights;
    }

    public void setRights(TextConstruct v) {
        this.state.rights = v;
    }

    public Content getContent() {
        return this.state.content;
    }

    public void setContent(Content v) {
        this.state.content = v;
    }

    public TextContent getTextContent() {
        if (getContent() instanceof TextContent) {
            return (TextContent) getContent();
        }
        throw new IllegalStateException("Content object is not a TextContent");
    }

    public String getPlainTextContent() {
        TextConstruct textConstruct = getTextContent().getContent();
        if (textConstruct instanceof PlainTextConstruct) {
            return textConstruct.getPlainText();
        }
        throw new IllegalStateException("TextConstruct object is not a PlainTextConstruct");
    }

    public void setContent(TextConstruct tc) {
        this.state.content = new TextContent(tc);
    }

    public List<Link> getLinks() {
        return this.state.links;
    }

    public void addLink(Link link) {
        this.state.links.add(link);
    }

    public Link addLink(String rel, String type, String href) {
        Link link = new Link(rel, type, href);
        addLink(link);
        return link;
    }

    public List<Person> getAuthors() {
        return this.state.authors;
    }

    public List<Person> getContributors() {
        return this.state.contributors;
    }

    public Source getSource() {
        return this.state.source;
    }

    public void setSource(Source v) {
        this.state.source = v;
    }

    public void setDraft(Boolean v) {
        if (this.state.pubControl == null) {
            if (Boolean.TRUE.equals(v)) {
                this.state.pubControl = new PubControl();
            } else {
                return;
            }
        }
        this.state.pubControl.setDraft(v);
    }

    public boolean isDraft() {
        return this.state.pubControl != null ? this.state.pubControl.isDraft() : false;
    }

    public PubControl getPubControl() {
        return this.state.pubControl;
    }

    public void setPubControl(PubControl value) {
        this.state.pubControl = value;
    }

    public void setService(Service s) {
        this.state.service = s;
    }

    public Service getService() {
        return this.state.service;
    }

    public boolean getCanEdit() {
        return this.state.canEdit;
    }

    public void setCanEdit(boolean v) {
        this.state.canEdit = v;
    }

    public void addAdaptor(Adaptor adaptor) {
        this.state.adaptable.addAdaptor(adaptor);
    }

    public Collection<Adaptor> getAdaptors() {
        return this.state.adaptable.getAdaptors();
    }

    public <A extends Adaptor> A getAdaptor(Class<A> adaptorClass) {
        return this.state.adaptable.getAdaptor(adaptorClass);
    }

    public Link getLink(String rel, String type) {
        Iterator i$ = this.state.links.iterator();
        while (i$.hasNext()) {
            Link link = (Link) i$.next();
            if (link.matches(rel, type)) {
                return link;
            }
        }
        return null;
    }

    public List<Link> getLinks(String relToMatch, String typeToMatch) {
        List<Link> result = new ArrayList();
        Iterator i$ = this.state.links.iterator();
        while (i$.hasNext()) {
            Link link = (Link) i$.next();
            if (link.matches(relToMatch, typeToMatch)) {
                result.add(link);
            }
        }
        return result;
    }

    public void removeLinks(String relToMatch, String typeToMatch) {
        Iterator<Link> iterator = this.state.links.iterator();
        while (iterator.hasNext()) {
            if (((Link) iterator.next()).matches(relToMatch, typeToMatch)) {
                iterator.remove();
            }
        }
    }

    public void removeLinks() {
        this.state.links.clear();
    }

    public void addHtmlLink(String htmlUri, String lang, String title) {
        Link link = new Link();
        link.setRel(Rel.ALTERNATE);
        link.setType(Type.HTML);
        link.setHref(htmlUri);
        if (lang != null) {
            link.setHrefLang(lang);
        }
        if (title != null) {
            link.setTitle(title);
        }
        this.state.links.add(link);
    }

    public Link getSelfLink() {
        return getLink(Rel.SELF, Type.ATOM);
    }

    public Link getEditLink() {
        return getLink(Rel.ENTRY_EDIT, Type.ATOM);
    }

    public Link getMediaEditLink() {
        Link mediaLink = getLink(Rel.MEDIA_EDIT, null);
        if (mediaLink == null) {
            return getLink(Rel.MEDIA_EDIT_BACKCOMPAT, null);
        }
        return mediaLink;
    }

    public Link getResumableEditMediaLink() {
        return getLink(Rel.RESUMABLE_EDIT_MEDIA, null);
    }

    public Link getHtmlLink() {
        return getLink(Rel.ALTERNATE, Type.HTML);
    }

    public E getSelf() throws IOException, ServiceException {
        if (this.state.service == null) {
            throw new ServiceException(CoreErrorDomain.ERR.entryNotAssociated);
        }
        Link selfLink = getSelfLink();
        if (selfLink == null) {
            throw new UnsupportedOperationException("Entry cannot be retrieved");
        }
        URL entryUrl = new URL(selfLink.getHref());
        try {
            if (this.state.etag != null) {
                return (BaseEntry) this.state.service.getEntry(entryUrl, getClass(), this.state.etag);
            }
            return (BaseEntry) this.state.service.getEntry(entryUrl, getClass(), this.state.edited != null ? this.state.edited : this.state.updated);
        } catch (NotModifiedException e) {
            return this;
        }
    }

    public E update() throws IOException, ServiceException {
        if (this.state.service == null) {
            throw new ServiceException(CoreErrorDomain.ERR.entryNotAssociated);
        }
        Link editLink = getEditLink();
        if (editLink == null) {
            throw new UnsupportedOperationException("Entry cannot be updated");
        }
        return (BaseEntry) this.state.service.update(new URL(editLink.getHref()), this);
    }

    public void delete() throws IOException, ServiceException {
        if (this.state.service == null) {
            throw new ServiceException(CoreErrorDomain.ERR.entryNotAssociated);
        }
        Link editLink = getEditLink();
        if (editLink == null) {
            throw new UnsupportedOperationException("Entry cannot be deleted");
        }
        this.state.service.delete(new URL(editLink.getHref()), GDataProtocol.isWeakEtag(this.state.etag) ? null : this.state.etag);
    }

    protected void visitChildren(ExtensionVisitor ev) throws StoppedException {
        if (this.state.content instanceof OutOfLineContent) {
            visitChild(ev, new OutOfLineReference((OutOfLineContent) this.state.content, null));
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
        Set<XmlNamespace> nsDecls = new LinkedHashSet(namespaceDeclsAtom);
        nsDecls.addAll(extProfile.getNamespaceDecls());
        ArrayList<Attribute> attrs = new ArrayList(3);
        if (this.state.kind != null && Service.getVersion().isAfter(Versions.V1)) {
            nsDecls.add(Namespaces.gNs);
            attrs.add(new Attribute(Namespaces.gAlias, "kind", this.state.kind));
        }
        if (!(this.state.etag == null || Service.getVersion().isCompatible(Versions.V1))) {
            nsDecls.add(Namespaces.gNs);
            attrs.add(new Attribute(Namespaces.gAlias, "etag", this.state.etag));
        }
        if (this.state.fields != null && Service.getVersion().isAfter(Versions.V1)) {
            nsDecls.add(Namespaces.gNs);
            attrs.add(new Attribute(Namespaces.gAlias, Parameter.FIELDS, this.state.fields));
        }
        AttributeGenerator generator = new AttributeGenerator();
        putAttributes(generator);
        generateAttributes(attrs, generator);
        generateStartElement(w, Namespaces.atomNs, "entry", attrs, nsDecls);
        if (this.state.id != null) {
            w.simpleElement(Namespaces.atomNs, "id", null, this.state.id);
        }
        if (this.state.published != null) {
            w.simpleElement(Namespaces.atomNs, "published", null, this.state.published.toString());
        }
        if (this.state.updated != null) {
            w.simpleElement(Namespaces.atomNs, "updated", null, this.state.updated.toString());
        }
        if (this.state.edited != null) {
            w.simpleElement(getAtomPubNs(), "edited", null, this.state.edited.toString());
        }
        if (this.state.pubControl != null) {
            this.state.pubControl.generateAtom(w, extProfile);
        }
        w.startRepeatingElement();
        Iterator i$ = this.state.categories.iterator();
        while (i$.hasNext()) {
            ((Category) i$.next()).generateAtom(w);
        }
        w.endRepeatingElement();
        if (this.state.title != null) {
            this.state.title.generateAtom(w, DocumentQuery.TITLE_SORT);
        }
        if (this.state.summary != null) {
            this.state.summary.generateAtom(w, "summary");
        }
        if (this.state.rights != null) {
            this.state.rights.generateAtom(w, "rights");
        }
        if (this.state.content != null) {
            this.state.content.generateAtom(w, extProfile);
        }
        w.startRepeatingElement();
        i$ = this.state.links.iterator();
        while (i$.hasNext()) {
            ((Link) i$.next()).generateAtom(w, extProfile);
        }
        w.endRepeatingElement();
        w.startRepeatingElement();
        i$ = this.state.authors.iterator();
        while (i$.hasNext()) {
            ((Person) i$.next()).generateAtom(extProfile, w, Query.AUTHOR);
        }
        w.endRepeatingElement();
        w.startRepeatingElement();
        i$ = this.state.contributors.iterator();
        while (i$.hasNext()) {
            ((Person) i$.next()).generateAtom(extProfile, w, "contributor");
        }
        w.endRepeatingElement();
        if (this.state.source != null) {
            this.state.source.generateAtom(w, extProfile);
        }
        generateExtensions(w, extProfile);
        w.endElement(Namespaces.atomNs, "entry");
    }

    public void generateRss(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        Vector<XmlNamespace> nsDecls = new Vector(namespaceDeclsRss);
        nsDecls.addAll(extProfile.getNamespaceDecls());
        generateStartElement(w, Namespaces.rssNs, DocumentListEntry.LABEL, null, nsDecls);
        if (this.state.id != null) {
            List<Attribute> attrs = new ArrayList(1);
            attrs.add(new Attribute("isPermaLink", "false"));
            w.simpleElement(Namespaces.rssNs, "guid", attrs, this.state.id);
        }
        String lang = null;
        if (this.state.content != null) {
            lang = this.state.content.getLang();
        }
        if (lang == null && this.state.summary != null) {
            lang = this.state.summary.getLang();
        }
        if (lang == null && this.state.title != null) {
            lang = this.state.title.getLang();
        }
        if (lang != null) {
            w.simpleElement(Namespaces.rssNs, "language", null, lang);
        }
        if (this.state.published != null) {
            w.simpleElement(Namespaces.rssNs, "pubDate", null, this.state.published.toStringRfc822());
        }
        if (this.state.updated != null) {
            w.simpleElement(Namespaces.atomNs, "updated", null, this.state.updated.toString());
        }
        w.startRepeatingElement();
        Iterator i$ = this.state.categories.iterator();
        while (i$.hasNext()) {
            ((Category) i$.next()).generateRss(w);
        }
        w.endRepeatingElement();
        if (this.state.title != null) {
            this.state.title.generateRss(w, DocumentQuery.TITLE_SORT, RssFormat.PLAIN_TEXT);
        }
        if (this.state.summary != null) {
            this.state.summary.generateAtom(w, "summary");
        }
        if (this.state.content != null) {
            this.state.content.generateRss(w, extProfile);
        }
        w.startRepeatingElement();
        i$ = this.state.links.iterator();
        while (i$.hasNext()) {
            ((Link) i$.next()).generateRss(w);
        }
        w.endRepeatingElement();
        w.startRepeatingElement();
        i$ = this.state.authors.iterator();
        while (i$.hasNext()) {
            ((Person) i$.next()).generateRss(w, Query.AUTHOR);
        }
        w.endRepeatingElement();
        w.startRepeatingElement();
        i$ = this.state.contributors.iterator();
        while (i$.hasNext()) {
            ((Person) i$.next()).generateRss(w, Query.AUTHOR);
        }
        w.endRepeatingElement();
        generateExtensions(w, extProfile);
        w.endElement(Namespaces.rssNs, DocumentListEntry.LABEL);
    }

    static {
        namespaceDeclsAtom = new Vector(1);
        namespaceDeclsRss = new Vector(1);
        namespaceDeclsAtom.add(Namespaces.atomNs);
        namespaceDeclsRss.add(Namespaces.atomNs);
    }

    public static BaseEntry<?> readEntry(ParseSource source) throws IOException, ParseException, ServiceException {
        return readEntry(source, null, null);
    }

    public static <T extends BaseEntry> T readEntry(ParseSource source, Class<T> entryClass, ExtensionProfile extProfile) throws IOException, ParseException, ServiceException {
        return (BaseEntry) ParseUtil.readEntry(source, entryClass, extProfile, null);
    }

    public void parseAtom(ExtensionProfile extProfile, InputStream input) throws IOException, ParseException {
        new XmlParser().parse(input, new AtomHandler(extProfile), Namespaces.atom, "entry");
    }

    public void parseAtom(ExtensionProfile extProfile, Reader reader) throws IOException, ParseException {
        new XmlParser().parse(reader, new AtomHandler(extProfile), Namespaces.atom, "entry");
    }

    public void parseAtom(ExtensionProfile extProfile, XmlEventSource eventSource) throws IOException, ParseException {
        new EventSourceParser(new AtomHandler(extProfile), Namespaces.atom, "entry").parse(eventSource);
    }

    protected Content.ChildHandlerInfo getContentHandlerInfo(ExtensionProfile extProfile, Attributes attrs) throws ParseException, IOException {
        return Content.getChildHandler(extProfile, attrs);
    }

    public ElementHandler getHandler(ExtensionProfile p, String namespace, String localName, Attributes attrs) {
        return new AtomHandler(p);
    }

    public BaseEntry<?> getAdaptedEntry() throws AdaptorException {
        BaseEntry<?> adaptedEntry = null;
        for (Adaptor adaptor : getAdaptors()) {
            if ((adaptor instanceof BaseEntry) && (adaptedEntry == null || adaptedEntry.getClass().isAssignableFrom(adaptor.getClass()))) {
                adaptedEntry = (BaseEntry) adaptor;
            }
        }
        return adaptedEntry;
    }
}
