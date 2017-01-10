package com.google.gdata.util;

import com.google.gdata.util.common.xml.XmlNamespace;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class XmlBlob {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected String base;
    protected String blob;
    protected String fullText;
    protected String lang;
    protected LinkedList<XmlNamespace> namespaces;

    static {
        $assertionsDisabled = !XmlBlob.class.desiredAssertionStatus();
    }

    public XmlBlob() {
        this.namespaces = new LinkedList();
    }

    public String getLang() {
        return this.lang;
    }

    public void setLang(String v) {
        this.lang = v;
    }

    public String getBase() {
        return this.base;
    }

    public void setBase(String v) {
        this.base = v;
    }

    public List<XmlNamespace> getNamespaces() {
        return this.namespaces;
    }

    public boolean addNamespace(XmlNamespace namespace) {
        return this.namespaces.add(namespace);
    }

    public String getBlob() {
        return this.blob;
    }

    public void setBlob(String v) {
        this.blob = v;
    }

    public String getFullText() {
        return this.fullText;
    }

    public void setFullText(String v) {
        this.fullText = v;
    }

    public static void startElement(XmlWriter w, XmlNamespace namespace, String elementName, XmlBlob xml, Collection<Attribute> additionalAttrs, Collection<XmlNamespace> additionalNs) throws IOException {
        Collection<Attribute> attrs;
        Collection<XmlNamespace> namespaces;
        if (xml != null) {
            String lang = xml.getLang();
            String base = xml.getBase();
            if (lang != null || base != null) {
                attrs = new ArrayList();
                if (additionalAttrs != null) {
                    attrs.addAll(additionalAttrs);
                }
                if (lang != null) {
                    attrs.add(new Attribute("xml:lang", lang));
                }
                if (base != null) {
                    attrs.add(new Attribute("xml:base", base));
                }
            } else if ($assertionsDisabled || (lang == null && base == null)) {
                attrs = additionalAttrs;
            } else {
                throw new AssertionError();
            }
            List<XmlNamespace> blobNamespaces = xml.getNamespaces();
            int additionalNsSize = additionalNs == null ? 0 : additionalNs.size();
            if (blobNamespaces.size() == 0 && additionalNsSize == 0) {
                namespaces = null;
            } else {
                namespaces = new ArrayList(blobNamespaces.size() + additionalNsSize);
                for (XmlNamespace blobNs : blobNamespaces) {
                    namespaces.add(new XmlNamespace(blobNs.getAlias(), blobNs.getUri()));
                }
                if (additionalNs != null) {
                    namespaces.addAll(additionalNs);
                }
            }
        } else if ($assertionsDisabled || xml == null) {
            attrs = additionalAttrs;
            namespaces = additionalNs;
        } else {
            throw new AssertionError();
        }
        w.startElement(namespace, elementName, attrs, namespaces);
    }

    public static void endElement(XmlWriter w, XmlNamespace namespace, String elementName, XmlBlob xml) throws IOException {
        if (!(xml == null || xml.getBlob() == null)) {
            w.innerXml(xml.getBlob());
        }
        w.endElement(namespace, elementName);
    }
}
