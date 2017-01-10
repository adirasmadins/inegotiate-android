package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.Kind.Adaptor;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeSet;
import org.xml.sax.Attributes;

public class ExtensionProfile {
    private Collection<XmlNamespace> additionalNamespaces;
    private boolean allowsArbitraryXml;
    private HashSet<Class<? extends Adaptor>> declared;
    private ExtensionProfile entryLinkProfile;
    private ExtensionProfile feedLinkProfile;
    private boolean isAutoExtending;
    private Collection<XmlNamespace> nsDecls;
    private final Map<Class<?>, ExtensionManifest> profile;

    /* renamed from: com.google.gdata.data.ExtensionProfile.1 */
    class C07201 implements Comparator<Class<?>> {
        C07201() {
        }

        public int compare(Class<?> c1, Class<?> c2) {
            return c1.getName().compareTo(c2.getName());
        }
    }

    public class ExtensionPointHandler extends ElementHandler {
        private boolean arbitraryXml;
        private ClassLoader configLoader;
        private ExtensionProfile configProfile;
        private List<ExtensionDescription> extDescriptions;
        private Class<? extends ExtensionPoint> extensionPoint;
        private List<XmlNamespace> namespaces;

        public ExtensionPointHandler(ExtensionProfile configProfile, ClassLoader configLoader, List<XmlNamespace> namespaces, Attributes attrs) throws ParseException {
            this.extDescriptions = new ArrayList();
            this.configProfile = configProfile;
            this.configLoader = configLoader;
            this.namespaces = namespaces;
            String extendedClassName = attrs.getValue(StringUtil.EMPTY_STRING, "extendedClass");
            if (extendedClassName == null) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.missingAttribute);
                pe.setInternalReason("ExtensionPoint extendedClass attribute is missing");
                throw pe;
            }
            try {
                Class<?> loadedClass = configLoader.loadClass(extendedClassName);
                if (ExtensionPoint.class.isAssignableFrom(loadedClass)) {
                    this.extensionPoint = ExtensionProfile.this.extensionPointClass(loadedClass);
                    Boolean val = getBooleanAttribute(attrs, "arbitraryXml");
                    if (val != null) {
                        this.arbitraryXml = val.booleanValue();
                        return;
                    }
                    return;
                }
                throw new ParseException(CoreErrorDomain.ERR.mustExtendExtensionPoint);
            } catch (Throwable e) {
                throw new ParseException(CoreErrorDomain.ERR.cantLoadExtensionPoint, e);
            }
        }

        public void processEndElement() {
            if (this.arbitraryXml) {
                ExtensionProfile.this.declareArbitraryXmlExtension(this.extensionPoint);
            }
            for (ExtensionDescription extDescription : this.extDescriptions) {
                ExtensionProfile.this.declare(this.extensionPoint, extDescription);
            }
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (!namespace.equals(Namespaces.gdataConfig) || !localName.equals("extensionDescription")) {
                return super.getChildHandler(namespace, localName, attrs);
            }
            ExtensionDescription extDescription = new ExtensionDescription();
            this.extDescriptions.add(extDescription);
            extDescription.getClass();
            return new com.google.gdata.data.ExtensionDescription.Handler(this.configProfile, this.configLoader, this.namespaces, attrs);
        }
    }

    public class Handler extends ElementHandler {
        private ClassLoader configLoader;
        private ExtensionProfile configProfile;
        private List<XmlNamespace> namespaces;

        public Handler(ExtensionProfile configProfile, ClassLoader configLoader, Attributes attrs) throws ParseException {
            this.namespaces = new ArrayList();
            this.configProfile = configProfile;
            this.configLoader = configLoader;
            if (attrs != null) {
                Boolean val = getBooleanAttribute(attrs, "arbitraryXml");
                if (val != null) {
                    ExtensionProfile.this.allowsArbitraryXml = val.booleanValue();
                }
            }
        }

        public void validate() {
        }

        public void processEndElement() {
            validate();
        }

        public ElementHandler getChildHandler(String namespace, String localName, Attributes attrs) throws ParseException, IOException {
            if (namespace.equals(Namespaces.gdataConfig)) {
                if (localName.equals("namespaceDescription")) {
                    String alias = attrs.getValue(StringUtil.EMPTY_STRING, "alias");
                    ParseException pe;
                    if (alias == null) {
                        pe = new ParseException(CoreErrorDomain.ERR.missingAttribute);
                        pe.setInternalReason("NamespaceDescription alias attribute is missing");
                        throw pe;
                    }
                    String uri = attrs.getValue(StringUtil.EMPTY_STRING, "uri");
                    if (uri == null) {
                        pe = new ParseException(CoreErrorDomain.ERR.missingAttribute);
                        pe.setInternalReason("NamespaceDescription uri attribute is missing");
                        throw pe;
                    }
                    XmlNamespace declaredNs = new XmlNamespace(alias, uri);
                    this.namespaces.add(declaredNs);
                    ExtensionProfile.this.declareAdditionalNamespace(declaredNs);
                    return new ElementHandler();
                } else if (localName.equals("extensionPoint")) {
                    return new ExtensionPointHandler(this.configProfile, this.configLoader, this.namespaces, attrs);
                }
            }
            return super.getChildHandler(namespace, localName, attrs);
        }
    }

    public ExtensionProfile() {
        this.declared = new HashSet();
        this.profile = new HashMap();
        this.additionalNamespaces = new LinkedHashSet();
        this.nsDecls = null;
        this.isAutoExtending = false;
        this.allowsArbitraryXml = true;
    }

    public void addDeclarations(Adaptor adaptor) {
        if (this.declared.add(adaptor.getClass())) {
            adaptor.declareExtensions(this);
        }
    }

    private Class<? extends ExtensionPoint> extensionPointClass(Class clazz) {
        return clazz;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void declare(java.lang.Class<? extends com.google.gdata.data.ExtensionPoint> r19, com.google.gdata.data.ExtensionDescription r20) {
        /*
        r18 = this;
        monitor-enter(r18);
        r17 = 0;
        r10 = r20;
    L_0x0005:
        r0 = r18;
        r1 = r0.isAutoExtending;	 Catch:{ all -> 0x008f }
        if (r1 == 0) goto L_0x0052;
    L_0x000b:
        r1 = com.google.gdata.data.Kind.Adaptable.class;
        r2 = r19.getSuperclass();	 Catch:{ all -> 0x008f }
        r1 = r1.isAssignableFrom(r2);	 Catch:{ all -> 0x008f }
        if (r1 == 0) goto L_0x0052;
    L_0x0017:
        if (r17 != 0) goto L_0x00bd;
    L_0x0019:
        r1 = r10.isRequired();	 Catch:{ all -> 0x008f }
        if (r1 == 0) goto L_0x00bd;
    L_0x001f:
        r17 = 1;
        r20 = new com.google.gdata.data.ExtensionDescription;	 Catch:{ all -> 0x008f }
        r2 = r10.getExtensionClass();	 Catch:{ all -> 0x008f }
        r3 = r10.getNamespace();	 Catch:{ all -> 0x008f }
        r4 = r10.getLocalName();	 Catch:{ all -> 0x008f }
        r5 = 0;
        r6 = r10.isRepeatable();	 Catch:{ all -> 0x008f }
        r7 = r10.isAggregate();	 Catch:{ all -> 0x008f }
        r8 = r10.allowsArbitraryXml();	 Catch:{ all -> 0x008f }
        r9 = r10.allowsMixedContent();	 Catch:{ all -> 0x008f }
        r1 = r20;
        r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x008f }
    L_0x0045:
        r1 = r19.getSuperclass();	 Catch:{ all -> 0x00bb }
        r0 = r18;
        r19 = r0.extensionPointClass(r1);	 Catch:{ all -> 0x00bb }
        r10 = r20;
        goto L_0x0005;
    L_0x0052:
        r15 = r18.getOrCreateManifest(r19);	 Catch:{ all -> 0x008f }
        r0 = r18;
        r1 = r0.profile;	 Catch:{ all -> 0x008f }
        r0 = r19;
        r1.put(r0, r15);	 Catch:{ all -> 0x008f }
        r13 = new com.google.gdata.util.common.base.Pair;	 Catch:{ all -> 0x008f }
        r1 = r10.getNamespace();	 Catch:{ all -> 0x008f }
        r1 = r1.getUri();	 Catch:{ all -> 0x008f }
        r2 = r10.getLocalName();	 Catch:{ all -> 0x008f }
        r13.<init>(r1, r2);	 Catch:{ all -> 0x008f }
        r1 = r15.supportedExtensions;	 Catch:{ all -> 0x008f }
        r1.put(r13, r10);	 Catch:{ all -> 0x008f }
        r1 = r15.subclassManifests;	 Catch:{ all -> 0x008f }
        r14 = r1.iterator();	 Catch:{ all -> 0x008f }
    L_0x007b:
        r1 = r14.hasNext();	 Catch:{ all -> 0x008f }
        if (r1 == 0) goto L_0x0094;
    L_0x0081:
        r16 = r14.next();	 Catch:{ all -> 0x008f }
        r16 = (com.google.gdata.data.ExtensionManifest) r16;	 Catch:{ all -> 0x008f }
        r0 = r16;
        r1 = r0.supportedExtensions;	 Catch:{ all -> 0x008f }
        r1.put(r13, r10);	 Catch:{ all -> 0x008f }
        goto L_0x007b;
    L_0x008f:
        r1 = move-exception;
        r20 = r10;
    L_0x0092:
        monitor-exit(r18);
        throw r1;
    L_0x0094:
        r1 = r10.allowsArbitraryXml();	 Catch:{ all -> 0x008f }
        if (r1 == 0) goto L_0x00b4;
    L_0x009a:
        r12 = r10.getExtensionClass();	 Catch:{ all -> 0x008f }
        r0 = r18;
        r11 = r0.getOrCreateManifest(r12);	 Catch:{ all -> 0x008f }
        r0 = r18;
        r1 = r0.profile;	 Catch:{ all -> 0x008f }
        r1.put(r12, r11);	 Catch:{ all -> 0x008f }
        r1 = r10.allowsMixedContent();	 Catch:{ all -> 0x008f }
        r0 = r18;
        r0.declareArbitraryXmlExtension(r12, r1);	 Catch:{ all -> 0x008f }
    L_0x00b4:
        r1 = 0;
        r0 = r18;
        r0.nsDecls = r1;	 Catch:{ all -> 0x008f }
        monitor-exit(r18);
        return;
    L_0x00bb:
        r1 = move-exception;
        goto L_0x0092;
    L_0x00bd:
        r20 = r10;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gdata.data.ExtensionProfile.declare(java.lang.Class, com.google.gdata.data.ExtensionDescription):void");
    }

    public synchronized void declare(Class<? extends ExtensionPoint> extendedType, Class<? extends Extension> extClass) {
        declare((Class) extendedType, ExtensionDescription.getDefaultDescription(extClass));
    }

    @Deprecated
    public synchronized void declareFeedExtension(ExtensionDescription extDesc) {
        declare(BaseFeed.class, extDesc);
    }

    @Deprecated
    public synchronized void declareFeedExtension(Class<? extends Extension> extClass) {
        declare(BaseFeed.class, (Class) extClass);
    }

    @Deprecated
    public synchronized void declareEntryExtension(ExtensionDescription extDesc) {
        declare(BaseEntry.class, extDesc);
    }

    @Deprecated
    public synchronized void declareEntryExtension(Class<? extends Extension> extClass) {
        declare(BaseEntry.class, (Class) extClass);
    }

    public synchronized void declareArbitraryXmlExtension(Class<? extends ExtensionPoint> extendedType) {
        declareArbitraryXmlExtension(extendedType, false);
    }

    public synchronized void declareArbitraryXmlExtension(Class<? extends ExtensionPoint> extendedType, boolean mixedContent) {
        ExtensionManifest manifest = getOrCreateManifest(extendedType);
        manifest.arbitraryXml = true;
        manifest.mixedContent = mixedContent;
        for (ExtensionManifest subclassManifest : manifest.subclassManifests) {
            subclassManifest.arbitraryXml = true;
            subclassManifest.mixedContent = mixedContent;
        }
        this.profile.put(extendedType, manifest);
        this.nsDecls = null;
    }

    public synchronized void declareAdditionalNamespace(XmlNamespace ns) {
        this.additionalNamespaces.add(ns);
    }

    public synchronized void declareFeedLinkProfile(ExtensionProfile profile) {
        this.feedLinkProfile = profile;
        this.nsDecls = null;
    }

    public synchronized ExtensionProfile getFeedLinkProfile() {
        return this.feedLinkProfile;
    }

    public synchronized void declareEntryLinkProfile(ExtensionProfile profile) {
        this.entryLinkProfile = profile;
        this.nsDecls = null;
    }

    public synchronized ExtensionProfile getEntryLinkProfile() {
        return this.entryLinkProfile;
    }

    public ExtensionManifest getManifest(Class<?> extendedType) {
        while (extendedType != null) {
            ExtensionManifest manifest = (ExtensionManifest) this.profile.get(extendedType);
            if (manifest != null) {
                return manifest;
            }
            extendedType = extendedType.getSuperclass();
        }
        return null;
    }

    public boolean isDeclared(Class<?> extendedType) {
        return this.profile.containsKey(extendedType);
    }

    public synchronized Collection<XmlNamespace> getNamespaceDecls() {
        if (this.nsDecls == null) {
            this.nsDecls = computeNamespaceDecls();
        }
        return this.nsDecls;
    }

    public void setAutoExtending(boolean v) {
        this.isAutoExtending = v;
    }

    public boolean isAutoExtending() {
        return this.isAutoExtending;
    }

    public void setArbitraryXml(boolean v) {
        this.allowsArbitraryXml = v;
    }

    public boolean allowsArbitraryXml() {
        return this.allowsArbitraryXml;
    }

    private ExtensionManifest getOrCreateManifest(Class<? extends ExtensionPoint> extendedType) {
        ExtensionManifest manifest = getManifest(extendedType);
        if (manifest != null && manifest.extendedType == extendedType) {
            return manifest;
        }
        ExtensionManifest newManifest = new ExtensionManifest(extendedType);
        Stack<ExtensionManifest> superManifests = new Stack();
        while (manifest != null) {
            superManifests.push(manifest);
            manifest = getManifest(manifest.extendedType.getSuperclass());
        }
        while (!superManifests.empty()) {
            ExtensionManifest superManifest = (ExtensionManifest) superManifests.pop();
            newManifest.supportedExtensions.putAll(superManifest.supportedExtensions);
            newManifest.arbitraryXml = superManifest.arbitraryXml;
            superManifest.subclassManifests.add(newManifest);
        }
        for (Entry<Class<?>, ExtensionManifest> profileMapping : this.profile.entrySet()) {
            if (extendedType.isAssignableFrom((Class) profileMapping.getKey())) {
                newManifest.subclassManifests.add(profileMapping.getValue());
            }
        }
        return newManifest;
    }

    private synchronized Collection<XmlNamespace> computeNamespaceDecls() {
        HashSet<XmlNamespace> result;
        result = new HashSet();
        result.addAll(this.additionalNamespaces);
        for (ExtensionManifest manifest : this.profile.values()) {
            result.addAll(manifest.getNamespaceDecls());
        }
        if (this.feedLinkProfile != null) {
            result.addAll(this.feedLinkProfile.computeNamespaceDecls());
        }
        if (this.entryLinkProfile != null) {
            result.addAll(this.entryLinkProfile.computeNamespaceDecls());
        }
        return Collections.unmodifiableSet(result);
    }

    public void parseConfig(ExtensionProfile configProfile, ClassLoader classLoader, InputStream stream) throws IOException, ParseException {
        new XmlParser().parse(stream, new Handler(configProfile, classLoader, null), Namespaces.gdataConfig, "extensionProfile");
    }

    public void generateConfig(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        Class<?> extensionPoint;
        List<Attribute> epAttrs = new ArrayList();
        epAttrs.add(new Attribute("arbitraryXml", this.allowsArbitraryXml));
        XmlWriter xmlWriter = w;
        xmlWriter.startElement(Namespaces.gdataConfigNs, "extensionProfile", epAttrs, this.nsDecls);
        for (XmlNamespace namespace : this.additionalNamespaces) {
            List<Attribute> nsAttrs = new ArrayList();
            nsAttrs.add(new Attribute("alias", namespace.getAlias()));
            nsAttrs.add(new Attribute("uri", namespace.getUri()));
            w.simpleElement(Namespaces.gdataConfigNs, "namespaceDescription", nsAttrs, null);
        }
        TreeSet<Class<?>> extensionSet = new TreeSet(new C07201());
        for (Class<?> extensionPoint2 : this.profile.keySet()) {
            extensionSet.add(extensionPoint2);
        }
        Iterator i$ = extensionSet.iterator();
        while (i$.hasNext()) {
            extensionPoint2 = (Class) i$.next();
            ExtensionManifest manifest = (ExtensionManifest) this.profile.get(extensionPoint2);
            List<Attribute> ptAttrs = new ArrayList();
            ptAttrs.add(new Attribute("extendedClass", extensionPoint2.getName()));
            ptAttrs.add(new Attribute("arbitraryXml", manifest.arbitraryXml));
            w.startElement(Namespaces.gdataConfigNs, "extensionPoint", ptAttrs, null);
            TreeSet<ExtensionDescription> descSet = new TreeSet();
            for (ExtensionDescription extDescription : manifest.getSupportedExtensions().values()) {
                descSet.add(extDescription);
            }
            Iterator i$2 = descSet.iterator();
            while (i$2.hasNext()) {
                ((ExtensionDescription) i$2.next()).generateConfig(w, extProfile);
            }
            w.endElement(Namespaces.gdataConfigNs, "extensionPoint");
        }
        w.endElement(Namespaces.gdataConfigNs, "extensionProfile");
    }
}
