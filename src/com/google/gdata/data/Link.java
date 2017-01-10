package com.google.gdata.data;

import com.amazonaws.javax.xml.stream.Constants;
import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.DocumentQuery;
import com.google.gdata.data.Content.ChildHandlerInfo;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class Link extends ExtensionPoint implements ILink {
    protected Content content;
    protected String etag;
    protected String href;
    protected String hrefLang;
    protected long length;
    protected String rel;
    protected String title;
    protected String titleLang;
    protected String type;

    public class AtomHandler extends ExtensionHandler {
        private final boolean linkRequired;

        public AtomHandler(ExtensionProfile extProfile) {
            super(Link.this, extProfile, Link.class);
            this.linkRequired = true;
        }

        protected AtomHandler(ExtensionProfile extProfile, Class<? extends Link> extendedClass) {
            super(Link.this, extProfile, extendedClass);
            this.linkRequired = false;
        }

        public void processAttribute(String namespace, String localName, String value) throws ParseException {
            if (namespace.equals(StringUtil.EMPTY_STRING)) {
                if (localName.equals("rel")) {
                    Link.this.rel = value;
                } else if (localName.equals("type")) {
                    Link.this.type = value;
                } else if (localName.equals("href")) {
                    Link.this.href = getAbsoluteUri(value);
                } else if (localName.equals("hreflang")) {
                    Link.this.hrefLang = value;
                } else if (localName.equals(DocumentQuery.TITLE_SORT)) {
                    Link.this.title = value;
                } else if (localName.equals("length")) {
                    try {
                        Link.this.length = Integer.valueOf(value).longValue();
                    } catch (NumberFormatException e) {
                        throw new ParseException(CoreErrorDomain.ERR.lengthNotInteger);
                    }
                }
            } else if (namespace.equals(Namespaces.f443g) && localName.equals("etag")) {
                Link.this.etag = value;
            }
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (!namespace.equals(Namespaces.atom) || !localName.equals("content")) {
                return super.getChildHandler(namespace, localName, attrs);
            }
            if (Link.this.content != null) {
                throw new ParseException(CoreErrorDomain.ERR.duplicateContent);
            }
            ChildHandlerInfo chi = Content.getChildHandler(this.extProfile, attrs);
            Link.this.content = chi.content;
            return chi.handler;
        }

        public void processEndElement() throws ParseException {
            if (this.linkRequired && Link.this.href == null) {
                throw new ParseException(CoreErrorDomain.ERR.missingHrefAttribute);
            }
            Link.this.titleLang = this.xmlLang;
        }
    }

    public Link() {
        this.length = -1;
        this.content = null;
        this.etag = null;
    }

    public Link(String rel, String type, String href) {
        this.length = -1;
        this.content = null;
        this.etag = null;
        this.rel = rel;
        this.type = type;
        setHref(href);
    }

    public String getRel() {
        return this.rel != null ? this.rel : Rel.ALTERNATE;
    }

    public void setRel(String v) {
        this.rel = v;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String v) {
        this.type = v;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String v) {
        this.href = v;
    }

    public String getHrefLang() {
        return this.hrefLang;
    }

    public void setHrefLang(String v) {
        this.hrefLang = v;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String v) {
        this.title = v;
    }

    public String getTitleLang() {
        return this.titleLang;
    }

    public void setTitleLang(String v) {
        this.titleLang = v;
    }

    public long getLength() {
        return this.length;
    }

    public void setLength(long v) {
        this.length = v;
    }

    public Content getContent() {
        return this.content;
    }

    public void setContent(Content c) {
        this.content = c;
    }

    public String getEtag() {
        return this.etag;
    }

    public void setEtag(String v) {
        this.etag = v;
    }

    public boolean matches(String relToMatch, String typeToMatch) {
        return (relToMatch == null || relToMatch.equals(getRel())) && (typeToMatch == null || typeToMatch.equals(this.type));
    }

    public ElementHandler getHandler(ExtensionProfile p, String namespace, String localName, Attributes attrs) {
        return new AtomHandler(p);
    }

    public void generate(XmlWriter w, ExtensionProfile p) throws IOException {
        generateAtom(w, p);
    }

    public void generateAtom(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(3);
        List<XmlNamespace> nsDecls = new ArrayList();
        if (this.rel != null) {
            attrs.add(new Attribute("rel", this.rel));
        }
        if (this.type != null) {
            attrs.add(new Attribute("type", this.type));
        }
        if (this.href != null) {
            attrs.add(new Attribute("href", this.href));
        }
        if (this.hrefLang != null) {
            attrs.add(new Attribute("hreflang", this.hrefLang));
        }
        if (this.title != null) {
            attrs.add(new Attribute(DocumentQuery.TITLE_SORT, this.title));
        }
        if (this.titleLang != null) {
            attrs.add(new Attribute("xml:lang", this.titleLang));
        }
        if (this.length != -1) {
            attrs.add(new Attribute("length", String.valueOf(this.length)));
        }
        if (this.etag != null) {
            nsDecls.add(Namespaces.gNs);
            attrs.add(new Attribute(Namespaces.gAlias, "etag", this.etag));
        }
        generateStartElement(w, Namespaces.atomNs, "link", attrs, nsDecls);
        if (this.content != null) {
            this.content.generateAtom(w, extProfile);
        }
        generateExtensions(w, extProfile);
        w.endElement(Namespaces.atomNs, "link");
    }

    public void generateRss(XmlWriter w) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(3);
        if (this.rel != null && this.rel.equals(Rel.ENCLOSURE)) {
            if (this.type != null) {
                attrs.add(new Attribute("type", this.type));
            }
            if (this.href != null) {
                attrs.add(new Attribute("url", this.href));
            }
            if (this.length != -1) {
                attrs.add(new Attribute("length", String.valueOf(this.length)));
            }
            w.simpleElement(Namespaces.rssNs, Rel.ENCLOSURE, attrs, null);
        } else if (Constants.DOM_COMMENTS.equals(this.rel)) {
            w.simpleElement(Namespaces.rssNs, Constants.DOM_COMMENTS, null, this.href);
        } else if (Rel.ALTERNATE.equals(this.rel)) {
            w.simpleElement(Namespaces.rssNs, "link", null, this.href);
        } else if (Rel.VIA.equals(this.rel) && this.href != null) {
            attrs.add(new Attribute("url", this.href));
            w.simpleElement(Namespaces.rssNs, "source", attrs, null);
        }
    }
}
