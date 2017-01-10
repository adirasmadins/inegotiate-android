package com.google.gdata.model.transforms.atom;

import com.amazonaws.javax.xml.stream.Constants;
import com.amazonaws.javax.xml.transform.OutputKeys;
import com.google.common.collect.Lists;
import com.google.gdata.client.DocumentQuery;
import com.google.gdata.client.GDataProtocol.Query;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.Metadata.VirtualValue;
import com.google.gdata.model.MetadataContext;
import com.google.gdata.model.MetadataRegistry;
import com.google.gdata.model.MetadataValueTransform;
import com.google.gdata.model.QName;
import com.google.gdata.model.atom.Author;
import com.google.gdata.model.atom.Category;
import com.google.gdata.model.atom.Content;
import com.google.gdata.model.atom.Contributor;
import com.google.gdata.model.atom.Entry;
import com.google.gdata.model.atom.Feed;
import com.google.gdata.model.atom.Link;
import com.google.gdata.model.atom.OutOfLineContent;
import com.google.gdata.model.atom.Person;
import com.google.gdata.model.atom.Source;
import com.google.gdata.model.atom.Source.Generator;
import com.google.gdata.model.atom.TextContent;
import com.google.gdata.model.atompub.Edited;
import com.google.gdata.model.gd.GdAttributes;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import com.google.gdata.wireformats.XmlGenerator.XmlElementGenerator;
import com.google.gdata.wireformats.XmlWireFormatProperties;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AtomRssTransforms {
    private static final QName AUTHOR;
    private static final QName CATEGORY;
    private static final QName COPYRIGHT;
    private static final QName DESCRIPTION;
    private static final QName DOMAIN;
    private static final QName GENERATOR;
    private static final QName GUID;
    private static final QName ITEM;
    private static final QName LAST_BUILD_DATE;
    private static final QName MANAGING_EDITOR;
    private static final QName PUB_DATE;
    private static final QName RSS_NAME;
    private static final QName TITLE;

    /* renamed from: com.google.gdata.model.transforms.atom.AtomRssTransforms.1 */
    static class C07371 extends XmlElementGenerator {
        C07371() {
        }

        protected List<Attribute> getAttributes(Element e, ElementMetadata<?, ?> metadata) {
            List<Attribute> attrs = super.getAttributes(e, metadata);
            if (attrs == null) {
                attrs = Lists.newArrayListWithExpectedSize(1);
            }
            attrs.add(new Attribute("isPermaLink", "false"));
            return attrs;
        }
    }

    /* renamed from: com.google.gdata.model.transforms.atom.AtomRssTransforms.2 */
    static class C07382 implements VirtualValue {
        public Object generate(Element element, ElementMetadata<?, ?> elementMetadata) {
            DateTime date = (DateTime) element.getTextValue(Entry.PUBLISHED);
            return date == null ? StringUtil.EMPTY_STRING : date.toStringRfc822();
        }

        C07382() throws ParseException {
        }

        public void parse(Element element, ElementMetadata<?, ?> elementMetadata, Object value) throws ParseException {
            element.setTextValue(DateTime.parseRfc822(value.toString()));
        }
    }

    /* renamed from: com.google.gdata.model.transforms.atom.AtomRssTransforms.3 */
    static class C07393 extends XmlElementGenerator {
        public boolean startElement(XmlWriter xw, Element parent, Element e, ElementMetadata<?, ?> metadata) throws IOException {
            if (!(e instanceof Person)) {
                return super.startElement(xw, parent, e, metadata);
            }
            boolean hasEmail;
            Person person = (Person) e;
            String email = person.getEmail();
            String name = person.getName();
            StringBuilder text = new StringBuilder();
            if (email != null) {
                hasEmail = true;
            } else {
                hasEmail = false;
            }
            if (hasEmail) {
                text.append(email);
            }
            if (name != null) {
                if (hasEmail) {
                    text.append(" (");
                }
                text.append(name);
                if (hasEmail) {
                    text.append(")");
                }
            }
            QName xmlName = getName(e, metadata);
            xw.simpleElement(xmlName.getNs(), xmlName.getLocalName(), null, text.toString());
            return false;
        }

        public void textContent(XmlWriter xw, Element e, ElementMetadata<?, ?> elementMetadata) {
        }

        C07393() throws IOException {
        }

        public void endElement(XmlWriter xw, Element e, ElementMetadata<?, ?> elementMetadata) {
        }
    }

    /* renamed from: com.google.gdata.model.transforms.atom.AtomRssTransforms.4 */
    static class C07404 extends XmlElementGenerator {
        public boolean startElement(XmlWriter xw, Element parent, Element e, ElementMetadata<?, ?> metadata) throws IOException {
            String str = null;
            if (!(e instanceof OutOfLineContent)) {
                return super.startElement(xw, parent, e, metadata);
            }
            OutOfLineContent content = (OutOfLineContent) e;
            ContentType type = content.getMimeType();
            URI src = content.getSrc();
            String mediaType = type == null ? null : type.getMediaType();
            if (src != null) {
                str = src.toString();
            }
            AtomRssTransforms.generateEnclosure(xw, mediaType, str, content.getLength());
            return false;
        }

        public void textContent(XmlWriter xw, Element e, ElementMetadata<?, ?> elementMetadata) {
        }

        C07404() throws IOException {
        }

        public void endElement(XmlWriter xw, Element e, ElementMetadata<?, ?> elementMetadata) {
        }
    }

    /* renamed from: com.google.gdata.model.transforms.atom.AtomRssTransforms.5 */
    static class C07415 extends XmlElementGenerator {
        public boolean startElement(XmlWriter xw, Element parent, Element e, ElementMetadata<?, ?> metadata) throws IOException {
            Collection<XmlNamespace> namespaces = getNamespaces(parent, e, metadata);
            List<Attribute> attrs = getAttributes(e, metadata);
            if (attrs == null) {
                attrs = Lists.newArrayList();
            }
            attrs.add(new Attribute(OutputKeys.VERSION, "2.0"));
            xw.startElement(Namespaces.rssNs, "rss", attrs, namespaces);
            xw.startElement(Namespaces.rssNs, "channel", null, null);
            if (!(e.hasElement(Source.SUBTITLE) || e.hasElement(Content.KEY))) {
                xw.simpleElement(Namespaces.rssNs, "description", null, StringUtil.EMPTY_STRING);
            }
            return true;
        }

        C07415() throws IOException {
        }

        public void endElement(XmlWriter xw, Element e, ElementMetadata<?, ?> metadata) throws IOException {
            xw.endElement(Namespaces.rssNs, "channel");
            super.endElement(xw, e, metadata);
        }
    }

    /* renamed from: com.google.gdata.model.transforms.atom.AtomRssTransforms.6 */
    static class C07426 implements VirtualValue {
        public Object generate(Element element, ElementMetadata<?, ?> elementMetadata) {
            DateTime date = (DateTime) element.getTextValue(Feed.UPDATED);
            return date == null ? StringUtil.EMPTY_STRING : date.toStringRfc822();
        }

        C07426() throws ParseException {
        }

        public void parse(Element element, ElementMetadata<?, ?> elementMetadata, Object value) throws ParseException {
            element.setTextValue(DateTime.parseRfc822(value.toString()));
        }
    }

    /* renamed from: com.google.gdata.model.transforms.atom.AtomRssTransforms.7 */
    static class C07437 extends XmlElementGenerator {
        public boolean startElement(XmlWriter xw, Element parent, Element e, ElementMetadata<?, ?> metadata) throws IOException {
            if (!(e instanceof Link)) {
                return super.startElement(xw, parent, e, metadata);
            }
            Link link = (Link) e;
            String rel = link.getRel();
            String type = link.getType();
            String href = link.getHref();
            long length = link.getLength();
            if (rel != null && rel.equals(Rel.ENCLOSURE)) {
                AtomRssTransforms.generateEnclosure(xw, type, href, length);
            } else if (Constants.DOM_COMMENTS.equals(rel)) {
                xw.simpleElement(Namespaces.rssNs, Constants.DOM_COMMENTS, null, href);
            } else if (Rel.ALTERNATE.equals(rel)) {
                xw.simpleElement(Namespaces.rssNs, "link", null, href);
            } else if (Rel.VIA.equals(rel) && href != null) {
                xw.simpleElement(Namespaces.rssNs, "source", Collections.singletonList(new Attribute("url", href)), null);
            }
            return false;
        }

        public void textContent(XmlWriter xw, Element e, ElementMetadata<?, ?> elementMetadata) {
        }

        C07437() throws IOException {
        }

        public void endElement(XmlWriter xw, Element e, ElementMetadata<?, ?> elementMetadata) {
        }
    }

    /* renamed from: com.google.gdata.model.transforms.atom.AtomRssTransforms.8 */
    static class C07448 extends XmlElementGenerator {
        public boolean startElement(XmlWriter xw, Element parent, Element e, ElementMetadata<?, ?> metadata) throws IOException {
            boolean isIcon = e.getElementId().equals(Source.ICON.getId());
            boolean isLogo = e.getElementId().equals(Source.LOGO.getId());
            if ((!isIcon && !isLogo) || !(parent instanceof Source)) {
                return super.startElement(xw, parent, e, metadata);
            }
            Source source = (Source) parent;
            if (isIcon && source.hasElement(Source.LOGO)) {
                return false;
            }
            xw.startElement(Namespaces.rssNs, "image", null, null);
            xw.simpleElement(Namespaces.rssNs, "url", null, String.valueOf(e.getTextValue()));
            TextContent title = source.getTitle();
            if (title != null) {
                xw.simpleElement(Namespaces.rssNs, DocumentQuery.TITLE_SORT, null, title.getPlainText());
            }
            Link htmlLink = source.getHtmlLink();
            if (htmlLink != null) {
                xw.simpleElement(Namespaces.rssNs, "link", null, htmlLink.getHref());
            }
            xw.endElement(Namespaces.rssNs, "image");
            return false;
        }

        public void textContent(XmlWriter xw, Element e, ElementMetadata<?, ?> elementMetadata) {
        }

        C07448() throws IOException {
        }

        public void endElement(XmlWriter xw, Element e, ElementMetadata<?, ?> elementMetadata) {
        }
    }

    static {
        DOMAIN = new QName("domain");
        CATEGORY = new QName(Namespaces.rssNs, Query.CATEGORY);
        ITEM = new QName(Namespaces.rssNs, DocumentListEntry.LABEL);
        GUID = new QName(Namespaces.rssNs, "guid");
        TITLE = new QName(Namespaces.rssNs, DocumentQuery.TITLE_SORT);
        PUB_DATE = new QName(Namespaces.rssNs, "pubDate");
        AUTHOR = new QName(Namespaces.rssNs, Query.AUTHOR);
        RSS_NAME = new QName(Namespaces.rssNs, "rss");
        DESCRIPTION = new QName(Namespaces.rssNs, "description");
        LAST_BUILD_DATE = new QName(Namespaces.rssNs, "lastBuildDate");
        COPYRIGHT = new QName(Namespaces.rssNs, "copyright");
        MANAGING_EDITOR = new QName(Namespaces.rssNs, "managingEditor");
        GENERATOR = new QName(Namespaces.rssNs, "generator");
    }

    public static void addTransforms(MetadataRegistry registry) {
        addCategoryTransforms(registry);
        addContentTransforms(registry);
        addEntryTransforms(registry);
        addEntryOutOfLineContentTransforms(registry);
        addFeedTransforms(registry);
        addLinkTransforms(registry);
        addSourceTransforms(registry);
        addPersonTransforms(registry);
        addGeneratorTransforms(registry);
        addAppEditedTransforms(registry);
    }

    private static void addCategoryTransforms(MetadataRegistry registry) {
        registry.build(Category.KEY, MetadataContext.RSS).setName(CATEGORY).setVirtualValue(new MetadataValueTransform(Category.TERM, Category.LABEL));
        registry.build(Category.KEY, Category.SCHEME, MetadataContext.RSS).setName(DOMAIN);
        registry.build(Category.KEY, Category.LABEL, MetadataContext.RSS).setVisible(false);
        registry.build(Category.KEY, Category.TERM, MetadataContext.RSS).setVisible(false);
    }

    private static void addContentTransforms(MetadataRegistry registry) {
        registry.build(TextContent.KEY, MetadataContext.RSS).setName(DESCRIPTION).whitelistAttributes(new AttributeKey[0]);
        registry.build(TextContent.CONSTRUCT, MetadataContext.RSS).whitelistAttributes(new AttributeKey[0]);
    }

    private static void addEntryTransforms(MetadataRegistry registry) {
        registry.build(Entry.KEY, MetadataContext.RSS).setName(ITEM);
        registry.build(Entry.KEY, GdAttributes.ETAG, MetadataContext.RSS).setVisible(false);
        XmlWireFormatProperties properties = new XmlWireFormatProperties();
        properties.setElementGenerator(new C07371());
        registry.build(Entry.KEY, Entry.ID, MetadataContext.RSS).setName(GUID).setProperties(properties);
        registry.build(Entry.KEY, Entry.TITLE, MetadataContext.RSS).setName(TITLE);
        registry.build(Entry.KEY, Entry.PUBLISHED, MetadataContext.RSS).setName(PUB_DATE).setVirtualValue(new C07382());
        XmlWireFormatProperties personProperties = new XmlWireFormatProperties();
        personProperties.setElementGenerator(new C07393());
        registry.build(Entry.KEY, Author.KEY, MetadataContext.RSS).setName(AUTHOR).setProperties(personProperties);
        registry.build(Entry.KEY, Contributor.KEY, MetadataContext.RSS).setName(AUTHOR).setProperties(personProperties);
        registry.build(Entry.KEY, Entry.RIGHTS, MetadataContext.RSS).setVisible(false);
    }

    private static void addEntryOutOfLineContentTransforms(MetadataRegistry registry) {
        XmlWireFormatProperties properties = new XmlWireFormatProperties();
        properties.setElementGenerator(new C07404());
        registry.build(OutOfLineContent.KEY, MetadataContext.RSS).setProperties(properties);
    }

    private static void addFeedTransforms(MetadataRegistry registry) {
        registry.build(Feed.KEY, GdAttributes.ETAG, MetadataContext.RSS).setVisible(false);
        XmlWireFormatProperties properties = new XmlWireFormatProperties();
        properties.setElementGenerator(new C07415());
        registry.build(Feed.KEY, MetadataContext.RSS).setName(RSS_NAME).setProperties(properties);
        registry.build(Feed.KEY, Feed.UPDATED, MetadataContext.RSS).setName(LAST_BUILD_DATE).setVirtualValue(new C07426());
    }

    private static void addLinkTransforms(MetadataRegistry registry) {
        XmlWireFormatProperties properties = new XmlWireFormatProperties();
        properties.setElementGenerator(new C07437());
        registry.build(Link.KEY, MetadataContext.RSS).setProperties(properties);
    }

    private static void addSourceTransforms(MetadataRegistry registry) {
        registry.build(Source.CONSTRUCT, Source.TITLE, MetadataContext.RSS).setName(TITLE);
        registry.build(Source.CONSTRUCT, Source.SUBTITLE, MetadataContext.RSS).setName(DESCRIPTION);
        XmlWireFormatProperties properties = new XmlWireFormatProperties();
        properties.setElementGenerator(new C07448());
        registry.build(Source.CONSTRUCT, Source.ICON, MetadataContext.RSS).setProperties(properties);
        registry.build(Source.CONSTRUCT, Source.LOGO, MetadataContext.RSS).setProperties(properties);
        registry.build(Source.CONSTRUCT, Source.RIGHTS, MetadataContext.RSS).setVisible(true).setName(COPYRIGHT);
        registry.build(Source.CONSTRUCT, Author.KEY, MetadataContext.RSS).setName(MANAGING_EDITOR).setVirtualValue(new MetadataValueTransform(Person.NAME));
    }

    private static void addPersonTransforms(MetadataRegistry registry) {
        registry.build(Person.KEY, Person.EMAIL, MetadataContext.RSS).setVisible(false);
        registry.build(Person.KEY, Person.NAME, MetadataContext.RSS).setVisible(false);
        registry.build(Person.KEY, Person.URI, MetadataContext.RSS).setVisible(false);
    }

    private static void addGeneratorTransforms(MetadataRegistry registry) {
        registry.build(Generator.KEY, MetadataContext.RSS).setName(GENERATOR);
        registry.build(Generator.KEY, Generator.URI, MetadataContext.RSS).setVisible(false);
        registry.build(Generator.KEY, Generator.VERSION, MetadataContext.RSS).setVisible(false);
    }

    private static void addAppEditedTransforms(MetadataRegistry registry) {
        registry.build(Edited.KEY, MetadataContext.RSS).setVisible(false);
    }

    private static void generateEnclosure(XmlWriter xw, String type, String href, long length) throws IOException {
        List<Attribute> attrs = new ArrayList(3);
        if (type != null) {
            attrs.add(new Attribute("type", type));
        }
        if (href != null) {
            attrs.add(new Attribute("url", href));
        }
        String str = "length";
        if (length == -1) {
            length = 0;
        }
        attrs.add(new Attribute(str, Long.toString(length)));
        xw.simpleElement(Namespaces.rssNs, Rel.ENCLOSURE, attrs, null);
    }

    private AtomRssTransforms() {
    }
}
