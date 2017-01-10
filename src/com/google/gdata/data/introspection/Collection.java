package com.google.gdata.data.introspection;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.DocumentQuery;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.Versions;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.Reference;
import com.google.gdata.data.TextConstruct;
import com.google.gdata.data.TextConstruct.ChildHandlerInfo;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.Version;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.xml.sax.Attributes;

public class Collection extends ExtensionPoint implements Reference, ICollection {
    private List<String> accepts;
    private XmlNamespace atomPubNs;
    private List<Categories> categoriesList;
    private Version coreVersion;
    private String href;
    private TextConstruct title;

    public class Handler extends ExtensionHandler {

        class AcceptHandler extends ElementHandler {
            AcceptHandler() {
            }

            public void processEndElement() {
                if (this.value == null) {
                    this.value = StringUtil.EMPTY_STRING;
                }
                if (Collection.this.coreVersion.isCompatible(Versions.V1)) {
                    Collection.this.accepts = Arrays.asList(this.value.split(","));
                } else {
                    Collection.this.addAccept(this.value);
                }
            }
        }

        public Handler(ExtensionProfile extProfile, Attributes attrs) {
            super(extProfile, Collection.class, attrs);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (namespace.equals(Namespaces.atom)) {
                if (localName.equals(DocumentQuery.TITLE_SORT) && !Collection.this.coreVersion.isCompatible(Versions.V1)) {
                    ChildHandlerInfo chi = TextConstruct.getChildHandler(attrs);
                    if (Collection.this.title != null) {
                        throw new ParseException(CoreErrorDomain.ERR.duplicateTitle);
                    }
                    Collection.this.title = chi.textConstruct;
                    return chi.handler;
                }
            } else if (namespace.equals(Collection.this.atomPubNs.getUri())) {
                if (localName.equals("accept")) {
                    return new AcceptHandler();
                }
                if (localName.equals("categories")) {
                    Categories newCategories = new Categories();
                    Collection.this.addCategories(newCategories);
                    newCategories.getClass();
                    return new com.google.gdata.data.introspection.Categories.Handler(this.extProfile, attrs);
                }
            }
            return super.getChildHandler(namespace, localName, attrs);
        }

        public void processEndElement() throws ParseException {
            super.processEndElement();
            if (Collection.this.title == null) {
                throw new ParseException(CoreErrorDomain.ERR.collectionTitleRequired);
            }
        }
    }

    public Collection() {
        this.coreVersion = Service.getVersion();
        this.atomPubNs = Namespaces.getAtomPubNs();
        this.accepts = new ArrayList();
        this.categoriesList = new ArrayList();
    }

    public Collection(String href) {
        this(href, null);
    }

    public Collection(String href, TextConstruct title) {
        this.coreVersion = Service.getVersion();
        this.atomPubNs = Namespaces.getAtomPubNs();
        this.accepts = new ArrayList();
        this.categoriesList = new ArrayList();
        this.href = href;
        this.title = title;
    }

    public Collection(String href, TextConstruct title, String... accepts) {
        this(href, title);
        this.accepts = Arrays.asList(accepts);
    }

    public static String getAtomEntryAcceptType() {
        if (Service.getVersion().isCompatible(Versions.V1)) {
            return "entry";
        }
        return "application/atom+xml;type=entry";
    }

    public TextConstruct getTitle() {
        return this.title;
    }

    public void setTitle(TextConstruct title) {
        this.title = title;
    }

    public String getHref() {
        return this.href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getType() {
        return ContentType.getAtomFeed().toString();
    }

    public List<String> getAcceptList() {
        return this.accepts;
    }

    public void addAccept(String accept) {
        this.accepts.add(accept);
    }

    public List<Categories> getCategoriesList() {
        return this.categoriesList;
    }

    public void addCategories(Categories c) {
        this.categoriesList.add(c);
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(1);
        if (this.coreVersion.isCompatible(Versions.V1)) {
            attrs.add(new Attribute(DocumentQuery.TITLE_SORT, this.title.getPlainText()));
        }
        attrs.add(new Attribute("href", this.href));
        w.startElement(this.atomPubNs, "collection", attrs, null);
        if (!this.coreVersion.isCompatible(Versions.V1)) {
            if (this.title != null) {
                this.title.generateAtom(w, DocumentQuery.TITLE_SORT);
            }
            for (String accept : this.accepts) {
                if (this.accepts != null) {
                    w.simpleElement(this.atomPubNs, "accept", null, accept);
                }
            }
            for (Categories categories : getCategoriesList()) {
                categories.generate(w, extProfile);
            }
        } else if (this.accepts != null) {
            StringBuffer acceptBuf = new StringBuffer();
            for (String accept2 : this.accepts) {
                if (acceptBuf.length() != 0) {
                    acceptBuf.append(',');
                }
                acceptBuf.append(accept2);
            }
            w.simpleElement(this.atomPubNs, "accept", null, acceptBuf.toString());
        }
        generateExtensions(w, extProfile);
        w.endElement(this.atomPubNs, "collection");
    }

    public void consumeAttributes(AttributeHelper attrHelper) throws ParseException {
        this.href = attrHelper.consume("href", true);
        if (this.coreVersion.isCompatible(Versions.V1)) {
            this.title = new PlainTextConstruct(attrHelper.consume(DocumentQuery.TITLE_SORT, true));
        }
    }

    public ElementHandler getHandler(ExtensionProfile p, String namespace, String localName, Attributes attrs) {
        return new Handler(p, attrs);
    }
}
