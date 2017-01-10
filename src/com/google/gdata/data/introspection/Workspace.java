package com.google.gdata.data.introspection;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.client.DocumentQuery;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.Versions;
import com.google.gdata.data.AttributeHelper;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.data.ExtensionVisitor;
import com.google.gdata.data.ExtensionVisitor.StoppedException;
import com.google.gdata.data.PlainTextConstruct;
import com.google.gdata.data.TextConstruct;
import com.google.gdata.data.TextConstruct.ChildHandlerInfo;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.Version;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class Workspace extends ExtensionPoint implements IWorkspace {
    private XmlNamespace atomPubNs;
    private List<Collection> collectionList;
    private Version coreVersion;
    private TextConstruct title;

    public class Handler extends ExtensionHandler {
        public Handler(ExtensionProfile extProfile, Attributes attrs) {
            super(extProfile, Workspace.class, attrs);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (namespace.equals(Workspace.this.atomPubNs.getUri())) {
                if (localName.equals("collection")) {
                    Collection collection = new Collection();
                    Workspace.this.addCollection(collection);
                    collection.getClass();
                    return new com.google.gdata.data.introspection.Collection.Handler(this.extProfile, attrs);
                }
            } else if (namespace.equals(Namespaces.atom) && localName.equals(DocumentQuery.TITLE_SORT) && !Workspace.this.coreVersion.isCompatible(Versions.V1)) {
                if (Workspace.this.title != null) {
                    throw new ParseException(CoreErrorDomain.ERR.duplicateTitle);
                }
                ChildHandlerInfo chi = TextConstruct.getChildHandler(attrs);
                Workspace.this.title = chi.textConstruct;
                return chi.handler;
            }
            return super.getChildHandler(namespace, localName, attrs);
        }
    }

    public Workspace() {
        this.coreVersion = Service.getVersion();
        this.atomPubNs = Namespaces.getAtomPubNs();
        this.collectionList = new ArrayList();
    }

    public Workspace(TextConstruct title) {
        this.coreVersion = Service.getVersion();
        this.atomPubNs = Namespaces.getAtomPubNs();
        this.collectionList = new ArrayList();
        this.title = title;
    }

    public TextConstruct getTitle() {
        return this.title;
    }

    public void setTitle(TextConstruct v) {
        this.title = v;
    }

    public List<Collection> getCollections() {
        return this.collectionList;
    }

    public void addCollection(Collection coll) {
        this.collectionList.add(coll);
    }

    public Collection addCollection(String collectionUri, String title, String... acceptedTypes) {
        Collection collection = new Collection(collectionUri, new PlainTextConstruct(title), acceptedTypes);
        addCollection(collection);
        return collection;
    }

    protected void visitChildren(ExtensionVisitor ev) throws StoppedException {
        for (Collection collection : this.collectionList) {
            visitChild(ev, collection);
        }
        super.visitChildren(ev);
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList();
        if (this.coreVersion.isCompatible(Versions.V1)) {
            attrs.add(new Attribute(DocumentQuery.TITLE_SORT, this.title.getPlainText()));
        }
        w.startElement(this.atomPubNs, "workspace", attrs, null);
        if (!this.coreVersion.isCompatible(Versions.V1)) {
            this.title.generateAtom(w, DocumentQuery.TITLE_SORT);
        }
        w.startRepeatingElement();
        for (Collection collection : this.collectionList) {
            collection.generate(w, extProfile);
        }
        w.endRepeatingElement();
        generateExtensions(w, extProfile);
        w.endElement(this.atomPubNs, "workspace");
    }

    public void consumeAttributes(AttributeHelper attrHelper) throws ParseException {
        if (this.coreVersion.isCompatible(Versions.V1)) {
            this.title = new PlainTextConstruct(attrHelper.consume(DocumentQuery.TITLE_SORT, true));
        }
    }

    public ElementHandler getHandler(ExtensionProfile p, String namespace, String localName, Attributes attrs) {
        return new Handler(p, attrs);
    }

    public void processEndElement() throws ParseException {
        if (this.title == null) {
            throw new ParseException(CoreErrorDomain.ERR.workspaceTitleRequired);
        }
    }
}
