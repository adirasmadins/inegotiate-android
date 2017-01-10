package com.google.gdata.model.atom;

import com.google.common.collect.Lists;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.GDataProtocol;
import com.google.gdata.client.Service;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.IEntry;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.ElementMetadata.Cardinality;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.model.ValidationContext;
import com.google.gdata.model.atompub.Control;
import com.google.gdata.model.atompub.Edited;
import com.google.gdata.model.batch.BatchId;
import com.google.gdata.model.batch.BatchInterrupted;
import com.google.gdata.model.batch.BatchOperation;
import com.google.gdata.model.batch.BatchStatus;
import com.google.gdata.model.gd.GdAttributes;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.NotModifiedException;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Entry extends Element implements IEntry {
    public static final ElementKey<String, Element> ID;
    public static final ElementKey<Void, Entry> KEY;
    public static final ElementKey<DateTime, Element> PUBLISHED;
    public static final ElementKey<String, TextContent> RIGHTS;
    public static final ElementKey<String, TextContent> SUMMARY;
    public static final ElementKey<String, TextContent> TITLE;
    public static final ElementKey<DateTime, Element> UPDATED;
    protected EntryState state;

    protected static class EntryState {
        public boolean canEdit;
        public Service service;
        public String versionId;

        protected EntryState() {
            this.canEdit = true;
        }
    }

    static {
        KEY = ElementKey.of(new QName(Namespaces.atomNs, "entry"), Entry.class);
        ID = Source.ID;
        UPDATED = Source.UPDATED;
        PUBLISHED = ElementKey.of(new QName(Namespaces.atomNs, "published"), DateTime.class, Element.class);
        TITLE = Source.TITLE;
        RIGHTS = Source.RIGHTS;
        SUMMARY = ElementKey.of(new QName(Namespaces.atomNs, "summary"), String.class, TextContent.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(KEY)) {
            registry.build(PUBLISHED);
            registry.build(SUMMARY);
            ElementCreator builder = registry.build(KEY).setCardinality(Cardinality.MULTIPLE);
            builder.addAttribute(GdAttributes.ETAG);
            builder.addAttribute(GdAttributes.KIND);
            builder.addAttribute(GdAttributes.FIELDS);
            builder.addElement(ID);
            builder.addElement(PUBLISHED);
            builder.addElement(UPDATED);
            builder.addElement(Edited.KEY);
            builder.addElement(Control.KEY);
            builder.addElement(Category.KEY);
            builder.addElement(TITLE);
            builder.addElement(SUMMARY);
            builder.addElement(RIGHTS);
            builder.addElement(Content.KEY).adapt(TextContent.KIND, TextContent.KEY).adapt(OtherContent.KIND, OtherContent.KEY).adapt(OutOfLineContent.KIND, OutOfLineContent.KEY);
            builder.addElement(Link.KEY);
            builder.addElement(Author.KEY);
            builder.addElement(Contributor.KEY);
            builder.addElement(Source.KEY);
            builder.addElement(BatchId.KEY);
            builder.addElement(BatchInterrupted.KEY);
            builder.addElement(BatchOperation.KEY);
            builder.addElement(BatchStatus.KEY);
            TextContent.registerMetadata(registry);
            OtherContent.registerMetadata(registry);
            OutOfLineContent.registerMetadata(registry);
        }
    }

    public Entry() {
        this(KEY);
    }

    protected Entry(ElementKey<?, ? extends Entry> key) {
        super((ElementKey) key);
        this.state = new EntryState();
    }

    protected Entry(ElementKey<?, ? extends Entry> key, Entry source) {
        super(key, source);
        this.state = source.state;
    }

    public String getId() {
        return (String) getElementValue(ID);
    }

    public void setId(String v) {
        if (v == null || !"-".equals(v)) {
            setElement(ID, v == null ? null : new Element(ID).setTextValue(v));
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

    public DateTime getPublished() {
        return (DateTime) getElementValue(PUBLISHED);
    }

    public void setPublished(DateTime v) {
        if (v == null || v.getTzShift() != null) {
            setElement(PUBLISHED, v == null ? null : new Element(PUBLISHED).setTextValue(v));
            return;
        }
        throw new IllegalArgumentException("Entry.published must have a timezone.");
    }

    public DateTime getUpdated() {
        return (DateTime) getElementValue(UPDATED);
    }

    public void setUpdated(DateTime v) {
        if (v == null || v.getTzShift() != null) {
            setElement(UPDATED, v == null ? null : new Element(UPDATED).setTextValue(v));
            return;
        }
        throw new IllegalArgumentException("Entry.updated must have a timezone.");
    }

    public DateTime getEdited() {
        return (DateTime) getElementValue(Edited.KEY);
    }

    public void setEdited(DateTime v) {
        if (v == null || v.getTzShift() != null) {
            setElement(Edited.KEY, v == null ? null : new Edited(v));
            return;
        }
        throw new IllegalArgumentException("Entry.edited must have a timezone.");
    }

    public Set<Category> getCategories() {
        return getElementSet(Category.KEY);
    }

    public void addCategory(Category v) {
        addElement(Category.KEY, (Element) v);
    }

    public void clearCategories() {
        removeElement(Category.KEY);
    }

    public TextContent getTitle() {
        return (TextContent) getElement(TITLE);
    }

    public void setTitle(TextContent v) {
        setElement(TITLE, (Element) v);
    }

    public TextContent getSummary() {
        return (TextContent) getElement(SUMMARY);
    }

    public void setSummary(TextContent v) {
        setElement(SUMMARY, (Element) v);
    }

    public TextContent getRights() {
        return (TextContent) getElement(RIGHTS);
    }

    public void setRights(TextContent v) {
        setElement(RIGHTS, (Element) v);
    }

    public Content getContent() {
        return (Content) getElement(Content.KEY);
    }

    public void setContent(Content v) {
        setElement(Content.KEY, (Element) v);
    }

    public void removeContent() {
        removeElement(Content.KEY);
    }

    public TextContent getTextContent() {
        Content content = getContent();
        if (content == null) {
            return null;
        }
        if (content instanceof TextContent) {
            return (TextContent) content;
        }
        throw new IllegalStateException("Content object is not a TextContent");
    }

    public String getPlainTextContent() {
        TextContent content = getTextContent();
        return content == null ? null : content.getPlainText();
    }

    public List<Link> getLinks() {
        return getElements(Link.KEY);
    }

    public void addLink(Link v) {
        addElement(Link.KEY, (Element) v);
    }

    public Link addLink(String rel, String type, String href) {
        try {
            Link link = new Link(rel, type, new URI(href));
            addLink(link);
            return link;
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public boolean removeLink(Link link) {
        return removeElement(Link.KEY, link);
    }

    public void removeLinks() {
        removeElement(Link.KEY);
    }

    public List<Person> getAuthors() {
        return getElements(Author.KEY);
    }

    public void addAuthor(Person v) {
        addElement(Author.KEY, (Element) v);
    }

    public boolean removeAuthor(Person v) {
        return removeElement(Author.KEY, v);
    }

    public void clearAuthors() {
        removeElement(Author.KEY);
    }

    public List<Person> getContributors() {
        return getElements(Contributor.KEY);
    }

    public void addContributor(Person v) {
        addElement(Contributor.KEY, (Element) v);
    }

    public boolean removeContributor(Person v) {
        return removeElement(Contributor.KEY, v);
    }

    public void clearContributors() {
        removeElement(Contributor.KEY);
    }

    public Source getSource() {
        return (Source) getElement(Source.KEY);
    }

    public void setSource(Source v) {
        setElement(Source.KEY, (Element) v);
    }

    public void setDraft(Boolean v) {
        Control control = null;
        if (Boolean.TRUE.equals(v)) {
            control = new Control();
            control.setDraft(true);
        }
        setElement(Control.KEY, (Element) control);
    }

    public boolean isDraft() {
        Control control = getControl();
        return control != null && control.isDraft();
    }

    public Control getControl() {
        return (Control) getElement(Control.KEY);
    }

    public Entry setControl(Control value) {
        setElement(Control.KEY, (Element) value);
        return this;
    }

    public boolean hasControl() {
        return hasElement(Control.KEY);
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

    public Link getLink(String rel, String type) {
        for (Link link : getLinks()) {
            if (link.matches(rel, type)) {
                return link;
            }
        }
        return null;
    }

    public List<Link> getLinks(String relToMatch, String typeToMatch) {
        List<Link> result = new ArrayList();
        for (Link link : getLinks()) {
            if (link.matches(relToMatch, typeToMatch)) {
                result.add(link);
            }
        }
        return result;
    }

    public void removeLinks(String relToMatch, String typeToMatch) {
        List<Link> toRemove = Lists.newArrayList();
        for (Link link : getLinks()) {
            if (link.matches(relToMatch, typeToMatch)) {
                toRemove.add(link);
            }
        }
        for (Link link2 : toRemove) {
            removeLink(link2);
        }
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
        addLink(link);
    }

    public Link getSelfLink() {
        return getLink(Rel.SELF, Type.ATOM);
    }

    public Link getEditLink() {
        return getLink(Rel.ENTRY_EDIT, Type.ATOM);
    }

    public Link getMediaEditLink() {
        return getLink(Rel.MEDIA_EDIT, null);
    }

    public Link getResumableEditMediaLink() {
        return getLink(Rel.RESUMABLE_EDIT_MEDIA, null);
    }

    public Link getHtmlLink() {
        return getLink(Rel.ALTERNATE, Type.HTML);
    }

    public Entry getSelf() throws IOException, ServiceException {
        if (this.state.service == null) {
            throw new ServiceException(CoreErrorDomain.ERR.entryNotAssociated);
        }
        Link selfLink = getSelfLink();
        if (selfLink == null) {
            throw new UnsupportedOperationException("Entry cannot be retrieved");
        }
        URL entryUrl = selfLink.getHrefUri().toURL();
        try {
            String etag = getEtag();
            if (etag != null) {
                return (Entry) this.state.service.getEntry(entryUrl, getClass(), etag);
            }
            return (Entry) this.state.service.getEntry(entryUrl, getClass(), getEdited() != null ? getEdited() : getUpdated());
        } catch (NotModifiedException e) {
            return this;
        }
    }

    public Entry update() throws IOException, ServiceException {
        if (this.state.service == null) {
            throw new ServiceException(CoreErrorDomain.ERR.entryNotAssociated);
        }
        Link editLink = getEditLink();
        if (editLink == null) {
            throw new UnsupportedOperationException("Entry cannot be updated");
        }
        return (Entry) this.state.service.update(editLink.getHrefUri().toURL(), this);
    }

    public void delete() throws IOException, ServiceException {
        if (this.state.service == null) {
            throw new ServiceException(CoreErrorDomain.ERR.entryNotAssociated);
        }
        Link editLink = getEditLink();
        if (editLink == null) {
            throw new UnsupportedOperationException("Entry cannot be deleted");
        }
        URI editUrl = editLink.getHrefUri();
        String etag = getEtag();
        Service service = this.state.service;
        if (GDataProtocol.isWeakEtag(etag)) {
            etag = null;
        }
        service.delete(editUrl, etag);
    }

    protected Element narrow(ElementMetadata<?, ?> metadata, ValidationContext vc) {
        String term = Kinds.getElementKind(this);
        if (term != null) {
            return adapt(this, metadata, term);
        }
        return super.narrow(metadata, vc);
    }
}
