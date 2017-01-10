package com.google.gdata.model.atom;

import com.amazonaws.javax.xml.transform.OutputKeys;
import com.google.common.collect.Lists;
import com.google.gdata.client.DocumentQuery;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.IGenerator;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementCreator;
import com.google.gdata.model.ElementKey;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.QName;
import com.google.gdata.util.Namespaces;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Source extends Element {
    public static final ElementKey<Void, Source> CONSTRUCT;
    public static final ElementKey<URI, Element> ICON;
    public static final ElementKey<String, Element> ID;
    public static final ElementKey<Void, Source> KEY;
    public static final ElementKey<URI, Element> LOGO;
    public static final ElementKey<String, TextContent> RIGHTS;
    public static final ElementKey<String, TextContent> SUBTITLE;
    public static final ElementKey<String, TextContent> TITLE;
    public static final ElementKey<DateTime, Element> UPDATED;

    public static class Generator extends Element implements IGenerator {
        public static final ElementKey<String, Generator> KEY;
        public static final AttributeKey<URI> URI;
        public static final AttributeKey<String> VERSION;

        static {
            KEY = ElementKey.of(new QName(Namespaces.atomNs, "generator"), String.class, Generator.class);
            VERSION = AttributeKey.of(new QName(OutputKeys.VERSION));
            URI = AttributeKey.of(new QName("uri"), URI.class);
        }

        public static void registerMetadata(MetadataRegistry registry) {
            if (!registry.isRegistered(KEY)) {
                ElementCreator builder = registry.build(KEY);
                builder.addAttribute(VERSION);
                builder.addAttribute(URI);
            }
        }

        public Generator() {
            super(KEY);
        }

        public Generator(ElementKey<?, ? extends Generator> key) {
            super((ElementKey) key);
        }

        public String getVersion() {
            return (String) getAttributeValue(VERSION);
        }

        public void setVersion(String v) {
            setAttributeValue(VERSION, (Object) v);
        }

        @Deprecated
        public String getHref() {
            URI uri = getUriUri();
            if (uri == null) {
                return null;
            }
            return uri.toString();
        }

        public URI getUriUri() {
            return (URI) getAttributeValue(URI);
        }

        @Deprecated
        public void setUri(String v) {
            try {
                setUri(v == null ? null : new URI(v));
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException(e);
            }
        }

        public void setUri(URI v) {
            setAttributeValue(URI, (Object) v);
        }

        public String getName() {
            return (String) getTextValue();
        }

        public void setName(String v) {
            setTextValue(v);
        }
    }

    static {
        CONSTRUCT = ElementKey.of(null, Source.class);
        KEY = ElementKey.of(new QName(Namespaces.atomNs, "source"), Void.class, Source.class);
        ID = ElementKey.of(new QName(Namespaces.atomNs, "id"));
        UPDATED = ElementKey.of(new QName(Namespaces.atomNs, "updated"), DateTime.class, Element.class);
        TITLE = ElementKey.of(new QName(Namespaces.atomNs, DocumentQuery.TITLE_SORT), String.class, TextContent.class);
        SUBTITLE = ElementKey.of(new QName(Namespaces.atomNs, "subtitle"), String.class, TextContent.class);
        RIGHTS = ElementKey.of(new QName(Namespaces.atomNs, "rights"), String.class, TextContent.class);
        ICON = ElementKey.of(new QName(Namespaces.atomNs, "icon"), URI.class, Element.class);
        LOGO = ElementKey.of(new QName(Namespaces.atomNs, "logo"), URI.class, Element.class);
    }

    public static void registerMetadata(MetadataRegistry registry) {
        if (!registry.isRegistered(CONSTRUCT)) {
            registry.build(ID);
            registry.build(UPDATED);
            registry.build(TITLE);
            registry.build(SUBTITLE);
            registry.build(RIGHTS);
            registry.build(ICON);
            registry.build(LOGO);
            ElementCreator builder = registry.build(CONSTRUCT);
            builder.addElement(ID);
            builder.addElement(UPDATED);
            builder.addElement(Category.KEY);
            builder.addElement(TITLE);
            builder.addElement(SUBTITLE);
            builder.addElement(RIGHTS);
            builder.addElement(ICON);
            builder.addElement(LOGO);
            builder.addElement(Link.KEY);
            builder.addElement(Author.KEY);
            builder.addElement(Contributor.KEY);
            builder.addElement(Generator.KEY);
            registry.build(KEY);
        }
    }

    public Source() {
        super(KEY);
    }

    protected Source(ElementKey<?, ? extends Source> key) {
        super((ElementKey) key);
    }

    protected Source(Source sourceSource) {
        this(KEY, sourceSource);
    }

    protected Source(ElementKey<?, ? extends Source> key, Element source) {
        super(key, source);
    }

    public String getId() {
        return (String) getElementValue(ID);
    }

    public void setId(String v) {
        setElement(ID, v == null ? null : new Element(ID).setTextValue(v));
    }

    public DateTime getUpdated() {
        return (DateTime) getElementValue(UPDATED);
    }

    public void setUpdated(DateTime v) {
        setElement(UPDATED, v == null ? null : new Element(UPDATED).setTextValue(v));
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

    public TextContent getSubtitle() {
        return (TextContent) getElement(SUBTITLE);
    }

    public void setSubtitle(TextContent v) {
        setElement(SUBTITLE, (Element) v);
    }

    public TextContent getRights() {
        return (TextContent) getElement(RIGHTS);
    }

    public void setRights(TextContent v) {
        setElement(RIGHTS, (Element) v);
    }

    @Deprecated
    public String getIcon() {
        URI uri = getIconUri();
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public URI getIconUri() {
        return (URI) getElementValue(ICON);
    }

    @Deprecated
    public void setIcon(String v) {
        try {
            setIcon(v == null ? null : new URI(v));
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void setIcon(URI v) {
        setElement(ICON, v == null ? null : new Element(ICON).setTextValue(v));
    }

    @Deprecated
    public String getLogo() {
        URI uri = getLogoUri();
        if (uri == null) {
            return null;
        }
        return uri.toString();
    }

    public URI getLogoUri() {
        return (URI) getElementValue(LOGO);
    }

    @Deprecated
    public void setLogo(String v) {
        try {
            setLogo(v == null ? null : new URI(v));
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void setLogo(URI v) {
        setElement(LOGO, v == null ? null : new Element(LOGO).setTextValue(v));
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

    public void clearLinks() {
        removeElement(Link.KEY);
    }

    public List<Person> getAuthors() {
        return getElements(Author.KEY);
    }

    public void addAuthor(Person v) {
        addElement(Author.KEY, (Element) v);
    }

    public void addAuthors(List<Person> v) {
        for (Person p : v) {
            addAuthor(p);
        }
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

    public void addContributors(List<Person> v) {
        for (Person p : v) {
            addContributor(p);
        }
    }

    public boolean removeContributor(Person v) {
        return removeElement(Contributor.KEY, v);
    }

    public void clearContributors() {
        removeElement(Contributor.KEY);
    }

    public Generator getGenerator() {
        return (Generator) getElement(Generator.KEY);
    }

    public void setGenerator(Generator v) {
        setElement(Generator.KEY, (Element) v);
    }

    public Generator setGenerator(String version, String uri, String name) {
        Generator gen = new Generator();
        gen.setVersion(version);
        gen.setUri(uri);
        gen.setName(name);
        setGenerator(gen);
        return gen;
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

    public void addHtmlLink(String htmlUrl, String lang, String title) {
        try {
            Link link = new Link(Rel.ALTERNATE, Type.HTML, new URI(htmlUrl));
            if (lang != null) {
                link.setHrefLang(lang);
            }
            if (title != null) {
                link.setTitle(title);
            }
            addElement(Link.KEY, (Element) link);
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public Link getHtmlLink() {
        return getLink(Rel.ALTERNATE, Type.HTML);
    }
}
