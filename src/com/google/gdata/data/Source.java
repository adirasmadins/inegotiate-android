package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.DocumentQuery;
import com.google.gdata.client.GDataProtocol.Query;
import com.google.gdata.data.Category.AtomHandler;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.ILink.Type;
import com.google.gdata.data.Kind.Adaptable;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.xml.sax.Attributes;

public class Source extends ExtensionPoint {
    protected SourceState srcState;

    public class SourceHandler extends ExtensionHandler {

        private class IconHandler extends ElementHandler {
            private IconHandler() {
            }

            public void processEndElement() throws ParseException {
                if (Source.this.srcState.icon != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateIcon);
                } else if (this.value == null) {
                    throw new ParseException(CoreErrorDomain.ERR.iconValueRequired);
                } else {
                    Source.this.srcState.icon = this.value;
                }
            }
        }

        private class IdHandler extends ElementHandler {
            private IdHandler() {
            }

            public void processEndElement() throws ParseException {
                if (Source.this.srcState.id != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateFeedId);
                } else if (this.value == null) {
                    throw new ParseException(CoreErrorDomain.ERR.idValueRequired);
                } else {
                    Source.this.srcState.id = this.value;
                }
            }
        }

        private class LogoHandler extends ElementHandler {
            private LogoHandler() {
            }

            public void processEndElement() throws ParseException {
                if (Source.this.srcState.logo != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateLogo);
                } else if (this.value == null) {
                    throw new ParseException(CoreErrorDomain.ERR.logoValueRequired);
                } else {
                    Source.this.srcState.logo = this.value;
                }
            }
        }

        class UpdatedHandler extends Rfc3339Handler {
            UpdatedHandler() {
            }

            public void processEndElement() throws ParseException {
                super.processEndElement();
                Source.this.srcState.updated = getDateTime();
            }
        }

        public SourceHandler(ExtensionProfile extProfile) {
            super(Source.this, extProfile, Source.class);
        }

        protected SourceHandler(ExtensionProfile extProfile, Class<? extends ExtensionPoint> extClass) {
            super(Source.this, extProfile, extClass);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (!namespace.equals(Namespaces.atom)) {
                return super.getChildHandler(namespace, localName, attrs);
            }
            if (localName.equals("id")) {
                return new IdHandler();
            }
            if (localName.equals("updated")) {
                return new UpdatedHandler();
            }
            if (localName.equals(Query.CATEGORY)) {
                Adaptable adaptable;
                Category cat = new Category();
                if (Source.this instanceof Adaptable) {
                    adaptable = Source.this;
                } else {
                    adaptable = null;
                }
                cat.getClass();
                return new AtomHandler(this.extProfile, Source.this.srcState.categories, adaptable);
            } else if (localName.equals(DocumentQuery.TITLE_SORT)) {
                chi = TextConstruct.getChildHandler(attrs);
                if (Source.this.srcState.title != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateTitle);
                }
                Source.this.srcState.title = chi.textConstruct;
                return chi.handler;
            } else if (localName.equals("subtitle")) {
                chi = TextConstruct.getChildHandler(attrs);
                if (Source.this.srcState.subtitle != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateSubtitle);
                }
                Source.this.srcState.subtitle = chi.textConstruct;
                return chi.handler;
            } else if (localName.equals("rights")) {
                chi = TextConstruct.getChildHandler(attrs);
                if (Source.this.srcState.rights != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateRights);
                }
                Source.this.srcState.rights = chi.textConstruct;
                return chi.handler;
            } else if (localName.equals("icon")) {
                return new IconHandler();
            } else {
                if (localName.equals("logo")) {
                    return new LogoHandler();
                }
                if (localName.equals("link")) {
                    Link link = new Link();
                    Source.this.srcState.links.add(link);
                    link.getClass();
                    return new Link.AtomHandler(this.extProfile);
                } else if (localName.equals(Query.AUTHOR)) {
                    Person author = new Person();
                    Source.this.srcState.authors.add(author);
                    author.getClass();
                    return new Person.AtomHandler(this.extProfile);
                } else if (localName.equals("contributor")) {
                    Person contributor = new Person();
                    Source.this.srcState.contributors.add(contributor);
                    contributor.getClass();
                    return new Person.AtomHandler(this.extProfile);
                } else if (!localName.equals("generator")) {
                    return null;
                } else {
                    if (Source.this.srcState.generator != null) {
                        throw new ParseException(CoreErrorDomain.ERR.duplicateGenerator);
                    }
                    Source.this.srcState.generator = new Generator();
                    Generator generator = Source.this.srcState.generator;
                    generator.getClass();
                    return new Generator.AtomHandler();
                }
            }
        }
    }

    protected static class SourceState {
        public LinkedList<Person> authors;
        public HashSet<Category> categories;
        public LinkedList<Person> contributors;
        public Generator generator;
        public String icon;
        public String id;
        public LinkedList<Link> links;
        public String logo;
        public TextConstruct rights;
        public TextConstruct subtitle;
        public TextConstruct title;
        public DateTime updated;

        protected SourceState() {
            this.categories = new HashSet();
            this.links = new LinkedList();
            this.authors = new LinkedList();
            this.contributors = new LinkedList();
        }
    }

    public Source() {
        this.srcState = new SourceState();
    }

    protected Source(Source sourceSource) {
        super(sourceSource);
        this.srcState = sourceSource.srcState;
    }

    public String getId() {
        return this.srcState.id;
    }

    public void setId(String v) {
        this.srcState.id = v;
    }

    public DateTime getUpdated() {
        return this.srcState.updated;
    }

    public void setUpdated(DateTime v) {
        this.srcState.updated = v;
    }

    public Set<Category> getCategories() {
        return this.srcState.categories;
    }

    public TextConstruct getTitle() {
        return this.srcState.title;
    }

    public void setTitle(TextConstruct v) {
        this.srcState.title = v;
    }

    public TextConstruct getSubtitle() {
        return this.srcState.subtitle;
    }

    public void setSubtitle(TextConstruct v) {
        this.srcState.subtitle = v;
    }

    public TextConstruct getRights() {
        return this.srcState.rights;
    }

    public void setRights(TextConstruct v) {
        this.srcState.rights = v;
    }

    public String getIcon() {
        return this.srcState.icon;
    }

    public void setIcon(String v) {
        this.srcState.icon = v;
    }

    public String getLogo() {
        return this.srcState.logo;
    }

    public void setLogo(String v) {
        this.srcState.logo = v;
    }

    public List<Link> getLinks() {
        return this.srcState.links;
    }

    public List<Person> getAuthors() {
        return this.srcState.authors;
    }

    public List<Person> getContributors() {
        return this.srcState.contributors;
    }

    public Generator getGenerator() {
        return this.srcState.generator;
    }

    public void setGenerator(Generator v) {
        this.srcState.generator = v;
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
        Iterator i$ = this.srcState.links.iterator();
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
        Iterator i$ = this.srcState.links.iterator();
        while (i$.hasNext()) {
            Link link = (Link) i$.next();
            if (link.matches(relToMatch, typeToMatch)) {
                result.add(link);
            }
        }
        return result;
    }

    public void addLink(Link link) {
        this.srcState.links.add(link);
    }

    public Link addLink(String rel, String type, String href) {
        Link link = new Link(rel, type, href);
        addLink(link);
        return link;
    }

    public void removeLinks(String relToMatch, String typeToMatch) {
        Iterator<Link> iterator = this.srcState.links.iterator();
        while (iterator.hasNext()) {
            if (((Link) iterator.next()).matches(relToMatch, typeToMatch)) {
                iterator.remove();
            }
        }
    }

    public void removeLinks() {
        this.srcState.links.clear();
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
        this.srcState.links.add(link);
    }

    public Link getHtmlLink() {
        return getLink(Rel.ALTERNATE, Type.HTML);
    }

    public void generateAtom(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        generateStartElement(w, Namespaces.atomNs, "source", null, null);
        generateInnerAtom(w, extProfile);
        generateExtensions(w, extProfile);
        w.endElement(Namespaces.atomNs, "source");
    }

    protected void generateInnerAtom(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        if (this.srcState.id != null) {
            w.simpleElement(Namespaces.atomNs, "id", null, this.srcState.id);
        }
        if (this.srcState.updated != null) {
            w.simpleElement(Namespaces.atomNs, "updated", null, this.srcState.updated.toString());
        }
        w.startRepeatingElement();
        Iterator i$ = this.srcState.categories.iterator();
        while (i$.hasNext()) {
            ((Category) i$.next()).generateAtom(w);
        }
        w.endRepeatingElement();
        if (this.srcState.title != null) {
            this.srcState.title.generateAtom(w, DocumentQuery.TITLE_SORT);
        }
        if (this.srcState.subtitle != null) {
            this.srcState.subtitle.generateAtom(w, "subtitle");
        }
        if (this.srcState.rights != null) {
            this.srcState.rights.generateAtom(w, "rights");
        }
        if (this.srcState.icon != null) {
            w.simpleElement(Namespaces.atomNs, "icon", null, this.srcState.icon);
        }
        if (this.srcState.logo != null) {
            w.simpleElement(Namespaces.atomNs, "logo", null, this.srcState.logo);
        }
        w.startRepeatingElement();
        i$ = this.srcState.links.iterator();
        while (i$.hasNext()) {
            ((Link) i$.next()).generateAtom(w, extProfile);
        }
        w.endRepeatingElement();
        w.startRepeatingElement();
        i$ = this.srcState.authors.iterator();
        while (i$.hasNext()) {
            ((Person) i$.next()).generateAtom(extProfile, w, Query.AUTHOR);
        }
        w.endRepeatingElement();
        w.startRepeatingElement();
        i$ = this.srcState.contributors.iterator();
        while (i$.hasNext()) {
            ((Person) i$.next()).generateAtom(extProfile, w, "contributor");
        }
        w.endRepeatingElement();
        if (this.srcState.generator != null) {
            this.srcState.generator.generateAtom(w);
        }
    }

    public void parseAtom(ExtensionProfile extProfile, InputStream stream) throws IOException, ParseException {
        new XmlParser().parse(stream, new SourceHandler(extProfile), Namespaces.atom, "source");
    }

    public void parseAtom(ExtensionProfile extProfile, Reader reader) throws IOException, ParseException {
        new XmlParser().parse(reader, new SourceHandler(extProfile), Namespaces.atom, "source");
    }
}
