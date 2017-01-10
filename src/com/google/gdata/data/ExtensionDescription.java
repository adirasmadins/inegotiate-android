package com.google.gdata.data;

import com.google.gdata.client.CoreErrorDomain;
import com.google.gdata.data.ExtensionPoint.ExtensionHandler;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;

public class ExtensionDescription extends ExtensionPoint implements Comparable<ExtensionDescription> {
    private boolean aggregate;
    private boolean arbitraryXml;
    private Class<? extends Extension> extensionClass;
    private String localName;
    private boolean mixedContent;
    private XmlNamespace namespace;
    private boolean repeatable;
    private boolean required;

    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Default {
        boolean allowsArbitraryXml() default false;

        boolean allowsMixedContent() default false;

        boolean isAggregate() default false;

        boolean isRepeatable() default false;

        boolean isRequired() default false;

        String localName();

        String nsAlias();

        String nsUri();
    }

    public class Handler extends ExtensionHandler {
        public Handler(ExtensionProfile configProfile, ClassLoader configLoader, List<XmlNamespace> namespaces, Attributes attrs) throws ParseException {
            super(ExtensionDescription.this, configProfile, ExtensionDescription.class);
            String nsValue = attrs.getValue(StringUtil.EMPTY_STRING, "namespace");
            if (nsValue == null) {
                throw new ParseException(CoreErrorDomain.ERR.missingNamespace);
            }
            for (XmlNamespace declaredNs : namespaces) {
                if (!declaredNs.getAlias().equals(nsValue)) {
                    if (declaredNs.getUri().equals(nsValue)) {
                    }
                }
                ExtensionDescription.this.namespace = declaredNs;
                break;
            }
            if (ExtensionDescription.this.namespace == null) {
                ParseException pe = new ParseException(CoreErrorDomain.ERR.missingNamespaceDescription);
                pe.setInternalReason("No matching NamespaceDescription for " + nsValue);
                throw pe;
            }
            ExtensionDescription.this.localName = attrs.getValue(StringUtil.EMPTY_STRING, "localName");
            if (ExtensionDescription.this.localName == null) {
                throw new ParseException(CoreErrorDomain.ERR.missingLocalName);
            }
            String extensionClassName = attrs.getValue(StringUtil.EMPTY_STRING, "extensionClass");
            if (extensionClassName == null) {
                throw new ParseException(CoreErrorDomain.ERR.missingExtensionClass);
            }
            try {
                Class<?> extClass = configLoader.loadClass(extensionClassName);
                if (Extension.class.isAssignableFrom(extClass)) {
                    ExtensionDescription.this.extensionClass = extClass;
                    Boolean bool = getBooleanAttribute(attrs, "required");
                    boolean z = bool != null && bool.booleanValue();
                    ExtensionDescription.this.required = z;
                    bool = getBooleanAttribute(attrs, "repeatable");
                    z = bool != null && bool.booleanValue();
                    ExtensionDescription.this.repeatable = z;
                    bool = getBooleanAttribute(attrs, "aggregate");
                    z = bool != null && bool.booleanValue();
                    ExtensionDescription.this.aggregate = z;
                    bool = getBooleanAttribute(attrs, "arbitraryXml");
                    z = bool != null && bool.booleanValue();
                    ExtensionDescription.this.arbitraryXml = z;
                    bool = getBooleanAttribute(attrs, "mixedContent");
                    z = bool != null && bool.booleanValue();
                    ExtensionDescription.this.mixedContent = z;
                    return;
                }
                throw new ParseException(CoreErrorDomain.ERR.mustImplementExtension);
            } catch (Throwable e) {
                pe = new ParseException(CoreErrorDomain.ERR.cantLoadExtensionClass, e);
                pe.setInternalReason("Unable to load extensionClass: " + extensionClassName);
                throw pe;
            }
        }
    }

    public static ExtensionDescription getDefaultDescription(Class<? extends Extension> extensionClass) {
        Default defAnnot = (Default) extensionClass.getAnnotation(Default.class);
        if (defAnnot == null) {
            throw new IllegalArgumentException("No default description found for " + extensionClass);
        }
        return new ExtensionDescription(extensionClass, new XmlNamespace(defAnnot.nsAlias(), defAnnot.nsUri()), defAnnot.localName(), defAnnot.isRequired(), defAnnot.isRepeatable(), defAnnot.isAggregate(), defAnnot.allowsArbitraryXml(), defAnnot.allowsMixedContent());
    }

    public ExtensionDescription() {
        this.required = false;
        this.repeatable = false;
        this.aggregate = false;
        this.arbitraryXml = false;
        this.mixedContent = false;
    }

    public ExtensionDescription(Class<? extends Extension> extensionClass, XmlNamespace namespace, String localName, boolean required, boolean repeatable, boolean aggregate) {
        this(extensionClass, namespace, localName, required, repeatable, aggregate, false, false);
    }

    public ExtensionDescription(Class<? extends Extension> extensionClass, XmlNamespace namespace, String localName, boolean required, boolean repeatable, boolean aggregate, boolean arbitraryXml, boolean mixedContent) {
        this.required = false;
        this.repeatable = false;
        this.aggregate = false;
        this.arbitraryXml = false;
        this.mixedContent = false;
        this.namespace = namespace;
        this.localName = localName;
        this.extensionClass = extensionClass;
        this.required = required;
        this.repeatable = repeatable;
        this.aggregate = aggregate;
        this.arbitraryXml = arbitraryXml;
        this.mixedContent = mixedContent;
    }

    public ExtensionDescription(Class<? extends Extension> extensionClass, XmlNamespace namespace, String localName) {
        this(extensionClass, namespace, localName, false, false, false);
    }

    public void setNamespace(XmlNamespace namespace) {
        this.namespace = namespace;
    }

    public final XmlNamespace getNamespace() {
        return this.namespace;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public final String getLocalName() {
        return this.localName;
    }

    public void setExtensionClass(Class<? extends Extension> extensionClass) {
        this.extensionClass = extensionClass;
    }

    public final Class<? extends Extension> getExtensionClass() {
        return this.extensionClass;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public final boolean isRequired() {
        return this.required;
    }

    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    public final boolean isRepeatable() {
        return this.repeatable;
    }

    public void setAggregate(boolean aggregate) {
        this.aggregate = aggregate;
    }

    public final boolean isAggregate() {
        return this.aggregate;
    }

    public void setArbitraryXml(boolean arbitraryXml) {
        this.arbitraryXml = arbitraryXml;
    }

    public final boolean allowsArbitraryXml() {
        return this.arbitraryXml;
    }

    public void setMixedContent(boolean mixedContent) {
        this.mixedContent = mixedContent;
    }

    public final boolean allowsMixedContent() {
        return this.mixedContent;
    }

    public int compareTo(ExtensionDescription desc) {
        String ns1 = this.namespace.getUri();
        if (ns1 == null) {
            ns1 = StringUtil.EMPTY_STRING;
        }
        String ns2 = desc.namespace.getUri();
        if (ns2 == null) {
            ns2 = StringUtil.EMPTY_STRING;
        }
        int nscomp = ns1.compareTo(ns2);
        return nscomp != 0 ? nscomp : this.localName.compareTo(desc.localName);
    }

    public void generateConfig(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        List<Attribute> attrs = new ArrayList();
        attrs.add(new Attribute("namespace", this.namespace.getUri()));
        attrs.add(new Attribute("localName", this.localName));
        attrs.add(new Attribute("extensionClass", this.extensionClass.getName()));
        attrs.add(new Attribute("required", this.required));
        attrs.add(new Attribute("repeatable", this.repeatable));
        attrs.add(new Attribute("aggregate", this.aggregate));
        attrs.add(new Attribute("arbitraryXml", this.arbitraryXml));
        attrs.add(new Attribute("mixedContent", this.mixedContent));
        generateStartElement(w, Namespaces.gdataConfigNs, "extensionDescription", attrs, null);
        generateExtensions(w, extProfile);
        w.endElement(Namespaces.gdataConfigNs, "extensionDescription");
    }
}
