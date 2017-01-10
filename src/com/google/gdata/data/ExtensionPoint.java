package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.ExtensionVisitor.StoppedException;
import com.google.gdata.model.QName;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlBlob;
import com.google.gdata.util.XmlParser;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.Pair;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.xml.sax.Attributes;

public class ExtensionPoint extends AbstractExtension {
    private ExtensionManifest manifest;
    private Map<Class<? extends Extension>, Extension> nonRepeatingExtensionMap;
    private Map<Class<? extends Extension>, List<Extension>> repeatingExtensionMap;
    protected XmlBlob xmlBlob;

    public class ExtensionHandler extends AttributesHandler {
        protected ExtensionManifest extManifest;
        protected ExtensionProfile extProfile;
        protected Class<? extends ExtensionPoint> extendedClass;
        protected boolean hasExtensions;

        public ExtensionHandler(ExtensionPoint extensionPoint, ExtensionProfile profile, Class<? extends ExtensionPoint> extendedClass) {
            this(profile, extendedClass, null);
        }

        public ExtensionHandler(ExtensionProfile profile, Class<? extends ExtensionPoint> extendedClass, Attributes attrs) {
            super(attrs);
            this.extProfile = profile;
            this.extendedClass = extendedClass;
            this.extManifest = profile.getManifest(extendedClass);
            if (this.extManifest != null) {
                this.hasExtensions = true;
            }
            ExtensionPoint.this.initializeArbitraryXml(this.extProfile, extendedClass, this);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (this.hasExtensions) {
                ElementHandler extensionHandler = ExtensionPoint.this.getExtensionHandler(this.extProfile, this.extendedClass, namespace, localName, attrs);
                if (extensionHandler != null) {
                    return extensionHandler;
                }
            }
            return super.getChildHandler(namespace, localName, attrs);
        }

        public void processEndElement() throws ParseException {
            super.processEndElement();
            if (this.extManifest != null && AbstractExtension.isStrictValidation()) {
                ExtensionPoint.this.checkRequiredExtensions(this.extManifest);
            }
            for (Extension extension : ExtensionPoint.this.nonRepeatingExtensionMap.values()) {
                if (extension instanceof ValidatingExtension) {
                    ((ValidatingExtension) extension).validate(ExtensionPoint.this);
                }
            }
            for (List<Extension> extList : ExtensionPoint.this.repeatingExtensionMap.values()) {
                for (Extension extension2 : extList) {
                    if (extension2 instanceof ValidatingExtension) {
                        ((ValidatingExtension) extension2).validate(ExtensionPoint.this);
                    }
                }
            }
        }
    }

    public class CumulativeBlobHandler extends ElementHandler {
        private final ExtensionProfile extProfile;
        private final Class<? extends ExtensionPoint> extendedClass;

        public CumulativeBlobHandler(ExtensionProfile extProfile, Class<? extends ExtensionPoint> extendedClass) {
            this.extProfile = extProfile;
            this.extendedClass = extendedClass;
            ExtensionPoint.this.initializeArbitraryXml(extProfile, extendedClass, this);
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            ElementHandler extensionHandler = ExtensionPoint.this.getExtensionHandler(this.extProfile, this.extendedClass, namespace, localName, attrs);
            return extensionHandler != null ? extensionHandler : super.getChildHandler(namespace, localName, attrs);
        }
    }

    public ExtensionPoint() {
        this.nonRepeatingExtensionMap = new LinkedHashMap();
        this.repeatingExtensionMap = new LinkedHashMap();
        this.xmlBlob = new XmlBlob();
    }

    protected ExtensionPoint(ExtensionPoint sourcePoint) {
        this.nonRepeatingExtensionMap = new LinkedHashMap();
        this.repeatingExtensionMap = new LinkedHashMap();
        this.xmlBlob = new XmlBlob();
        this.nonRepeatingExtensionMap = sourcePoint.nonRepeatingExtensionMap;
        this.repeatingExtensionMap = sourcePoint.repeatingExtensionMap;
        this.xmlBlob = sourcePoint.xmlBlob;
        this.manifest = sourcePoint.manifest;
    }

    public void declareExtensions(ExtensionProfile extProfile) {
    }

    public final <T extends Extension> boolean hasExtension(Class<T> extensionClass) {
        return this.nonRepeatingExtensionMap.containsKey(extensionClass);
    }

    public final <T extends Extension> boolean hasRepeatingExtension(Class<T> extensionClass) {
        List<T> ret = (List) this.repeatingExtensionMap.get(extensionClass);
        return (ret == null || ret.isEmpty()) ? false : true;
    }

    public <T extends Extension> T getExtension(Class<T> extensionClass) {
        return (Extension) this.nonRepeatingExtensionMap.get(extensionClass);
    }

    public Collection<Extension> getExtensions() {
        return Collections.unmodifiableCollection(this.nonRepeatingExtensionMap.values());
    }

    public <T extends Extension> List<T> getRepeatingExtension(Class<T> extensionClass) {
        List<T> ret = (List) this.repeatingExtensionMap.get(extensionClass);
        if (ret != null) {
            return ret;
        }
        ret = new ArrayList();
        this.repeatingExtensionMap.put(extensionClass, ret);
        return ret;
    }

    public Collection<List<Extension>> getRepeatingExtensions() {
        return Collections.unmodifiableCollection(this.repeatingExtensionMap.values());
    }

    protected boolean addExtension(Extension ext, Class<? extends Extension> extClass) {
        if (this.nonRepeatingExtensionMap.containsKey(extClass)) {
            return false;
        }
        this.nonRepeatingExtensionMap.put(extClass, ext);
        return true;
    }

    public void addExtension(Extension ext) {
        addExtension(ext, ext.getClass());
    }

    public void setExtension(Extension ext) {
        this.nonRepeatingExtensionMap.remove(ext.getClass());
        addExtension(ext, ext.getClass());
    }

    protected void addRepeatingExtension(Extension ext, Class<? extends Extension> extClass) {
        List<Extension> extList = (List) this.repeatingExtensionMap.get(extClass);
        if (extList == null) {
            extList = new ArrayList();
        }
        extList.add(ext);
        this.repeatingExtensionMap.put(extClass, extList);
    }

    public void addRepeatingExtension(Extension ext) {
        addRepeatingExtension(ext, ext.getClass());
    }

    public void removeExtension(Extension ext) {
        this.nonRepeatingExtensionMap.remove(ext.getClass());
    }

    public void removeExtension(Class<? extends Extension> extensionClass) {
        this.nonRepeatingExtensionMap.remove(extensionClass);
    }

    public void removeRepeatingExtension(Extension ext) {
        List<Extension> extList = (List) this.repeatingExtensionMap.get(ext.getClass());
        if (extList != null) {
            extList.remove(ext);
        }
    }

    protected void visitChild(ExtensionVisitor ev, Extension child) throws StoppedException {
        if (child instanceof ExtensionPoint) {
            ((ExtensionPoint) child).visit(ev, this);
        } else {
            ev.visit(this, child);
        }
    }

    protected void visitChildren(ExtensionVisitor ev) throws StoppedException {
        for (Extension ext : this.nonRepeatingExtensionMap.values()) {
            visitChild(ev, ext);
        }
        for (List<Extension> extList : this.repeatingExtensionMap.values()) {
            for (Extension ext2 : extList) {
                visitChild(ev, ext2);
            }
        }
    }

    public void visit(ExtensionVisitor ev, ExtensionPoint parent) throws StoppedException {
        if (ev.visit(parent, this)) {
            visitChildren(ev);
        }
        ev.visitComplete(this);
    }

    public XmlBlob getXmlBlob() {
        return this.xmlBlob;
    }

    public void setXmlBlob(XmlBlob xmlBlob) {
        this.xmlBlob = xmlBlob;
    }

    public XmlBlob generateCumulativeXmlBlob(ExtensionProfile extProfile) throws IOException {
        XmlBlob cumulative = new XmlBlob();
        Collection<XmlNamespace> namespaces = cumulative.getNamespaces();
        StringWriter w = new StringWriter();
        XmlWriter xw = new XmlWriter(w);
        if (this.xmlBlob != null) {
            cumulative.setLang(this.xmlBlob.getLang());
            cumulative.setBase(this.xmlBlob.getBase());
            namespaces.addAll(this.xmlBlob.getNamespaces());
            w.write(this.xmlBlob.getBlob());
        }
        if (this.manifest != null) {
            for (XmlNamespace ns : this.manifest.getNamespaceDecls()) {
                XmlNamespace newNs = new XmlNamespace(ns.getAlias(), ns.getUri());
                if (!namespaces.contains(newNs)) {
                    namespaces.add(newNs);
                }
            }
        }
        for (Extension ext : this.nonRepeatingExtensionMap.values()) {
            ext.generate(xw, extProfile);
        }
        for (List<Extension> extList : this.repeatingExtensionMap.values()) {
            xw.startRepeatingElement();
            for (Extension ext2 : extList) {
                ext2.generate(xw, extProfile);
            }
            xw.endRepeatingElement();
        }
        cumulative.setBlob(w.toString());
        return cumulative;
    }

    public void parseCumulativeXmlBlob(XmlBlob blob, ExtensionProfile extProfile, Class<? extends ExtensionPoint> extendedClass) throws IOException, ParseException {
        this.xmlBlob = new XmlBlob();
        this.nonRepeatingExtensionMap.clear();
        this.repeatingExtensionMap.clear();
        StringWriter sw = new StringWriter();
        XmlWriter w = new XmlWriter(sw);
        XmlBlob.startElement(w, null, "CUMULATIVE_BLOB", blob, null, null);
        XmlBlob.endElement(w, null, "CUMULATIVE_BLOB", blob);
        new XmlParser().parse(new StringReader(sw.toString()), new CumulativeBlobHandler(extProfile, extendedClass), StringUtil.EMPTY_STRING, "CUMULATIVE_BLOB");
    }

    protected ExtensionManifest getManifest(ExtensionProfile extProfile, Class<? extends ExtensionPoint> extendedClass) {
        if (this.manifest == null) {
            this.manifest = extProfile.getManifest(extendedClass);
        }
        return this.manifest;
    }

    protected void generate(XmlWriter w, ExtensionProfile p, XmlNamespace namespace, String localName, List<Attribute> attrs, AttributeGenerator generator) throws IOException {
        if (generator.getContent() != null) {
            throw new IllegalStateException("No content allowed on an extension point");
        }
        try {
            ExtensionManifest profManifest = p.getManifest(getClass());
            if (profManifest != null) {
                checkRequiredExtensions(profManifest);
            }
            generateStartElement(w, namespace, localName, attrs, null);
            generateExtensions(w, p);
            w.endElement(namespace, localName);
        } catch (ParseException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }

    public ElementHandler getHandler(ExtensionProfile p, String namespace, String localName, Attributes attrs) throws ParseException {
        return new ExtensionHandler(p, getClass(), attrs);
    }

    protected void generateStartElement(XmlWriter w, XmlNamespace namespace, String elementName, Collection<Attribute> additionalAttrs, Collection<XmlNamespace> additionalNs) throws IOException {
        XmlBlob.startElement(w, namespace, elementName, this.xmlBlob, additionalAttrs, additionalNs);
    }

    protected void generateExtensions(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        for (Extension ext : this.nonRepeatingExtensionMap.values()) {
            ext.generate(w, extProfile);
        }
        for (List<Extension> extList : this.repeatingExtensionMap.values()) {
            w.startRepeatingElement();
            for (Extension ext2 : extList) {
                ext2.generate(w, extProfile);
            }
            w.endRepeatingElement();
        }
        if (this.xmlBlob != null) {
            w.innerXml(this.xmlBlob.getBlob());
        }
    }

    protected void initializeArbitraryXml(ExtensionProfile profile, Class<? extends ExtensionPoint> extPoint, ElementHandler handler) {
        boolean arbitraryXml = profile.allowsArbitraryXml();
        boolean mixedContent = false;
        ExtensionManifest profManifest = getManifest(profile, extPoint);
        if (profManifest != null && profManifest.arbitraryXml) {
            arbitraryXml = profManifest.arbitraryXml;
            mixedContent = profManifest.mixedContent;
        }
        if (arbitraryXml) {
            handler.initializeXmlBlob(this.xmlBlob, mixedContent, false);
        }
    }

    protected ExtensionDescription getExtensionDescription(ExtensionProfile extProfile, Class<? extends ExtensionPoint> extPoint, String namespaceUri, String localName) {
        ExtensionManifest profManifest = getManifest(extProfile, extPoint);
        if (profManifest == null) {
            return null;
        }
        ExtensionDescription extDescription = (ExtensionDescription) profManifest.supportedExtensions.get(Pair.of(namespaceUri, localName));
        if (extDescription == null) {
            return (ExtensionDescription) profManifest.supportedExtensions.get(Pair.of(namespaceUri, QName.ANY_LOCALNAME));
        }
        return extDescription;
    }

    protected static <T extends Extension> T createExtensionInstance(Class<T> extClass) throws ParseException {
        try {
            return (Extension) extClass.newInstance();
        } catch (Throwable e) {
            throw new ParseException(CoreErrorDomain.ERR.cantCreateExtension, e);
        } catch (Throwable e2) {
            throw new ParseException(CoreErrorDomain.ERR.cantCreateExtension, e2);
        }
    }

    protected ElementHandler getExtensionHandler(ExtensionProfile extProfile, Class<? extends ExtensionPoint> extPoint, String namespaceUri, String localName, Attributes attrs) throws ParseException, IOException {
        ElementHandler elementHandler = null;
        ExtensionDescription extDescription = getExtensionDescription(extProfile, extPoint, namespaceUri, localName);
        if (extDescription != null) {
            Class<? extends Extension> extClass = extDescription.getExtensionClass();
            if (extClass != null) {
                Extension extension = null;
                if (extDescription.isAggregate()) {
                    extension = getExtension(extClass);
                }
                boolean needsAdd = true;
                if (extension == null) {
                    extension = createExtensionInstance(extClass);
                } else {
                    needsAdd = false;
                }
                elementHandler = extension.getHandler(extProfile, namespaceUri, localName, attrs);
                if (needsAdd) {
                    if (extDescription.isRepeatable()) {
                        addRepeatingExtension(extension, extClass);
                    } else if (!addExtension(extension, extClass)) {
                        ParseException pe = new ParseException(CoreErrorDomain.ERR.duplicateExtension);
                        pe.setInternalReason("Duplicate extension element " + namespaceUri + ":" + localName);
                        throw pe;
                    }
                }
            }
        }
        return elementHandler;
    }

    protected void checkRequiredExtensions(ExtensionManifest profManifest) throws ParseException {
        for (ExtensionDescription extDescription : profManifest.supportedExtensions.values()) {
            if (extDescription.isRequired()) {
                boolean found;
                Class<? extends Extension> extClass = extDescription.getExtensionClass();
                if (extDescription.isRepeatable()) {
                    found = this.repeatingExtensionMap.containsKey(extClass);
                } else {
                    found = this.nonRepeatingExtensionMap.containsKey(extClass);
                }
                if (!found) {
                    ParseException pe = new ParseException(CoreErrorDomain.ERR.missingExtensionElement);
                    pe.setInternalReason("Required extension element " + extDescription.getNamespace().getUri() + ":" + extDescription.getLocalName() + " not found.");
                    throw pe;
                }
            }
        }
    }
}
