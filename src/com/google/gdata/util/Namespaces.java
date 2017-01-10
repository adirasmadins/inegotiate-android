package com.google.gdata.util;

import com.amazonaws.javax.xml.XMLConstants;
import com.google.gdata.client.Service;
import com.google.gdata.client.Service.Versions;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlNamespace;

public final class Namespaces {
    public static final String atom = "http://www.w3.org/2005/Atom";
    public static final XmlNamespace atomNs;
    @Deprecated
    public static final String atomPub = "http://purl.org/atom/app#";
    public static final String atomPubDraft = "http://purl.org/atom/app#";
    public static final XmlNamespace atomPubDraftNs;
    @Deprecated
    public static final XmlNamespace atomPubNs;
    public static final String atomPubStandard = "http://www.w3.org/2007/app";
    public static final XmlNamespace atomPubStandardNs;
    public static final String batch = "http://schemas.google.com/gdata/batch";
    public static final String batchAlias = "batch";
    public static final XmlNamespace batchNs;
    public static final String f443g = "http://schemas.google.com/g/2005";
    public static final String gAlias = "gd";
    public static final String gKind = "http://schemas.google.com/g/2005#kind";
    public static final XmlNamespace gNs;
    public static final String gPrefix = "http://schemas.google.com/g/2005#";
    public static final String gdataConfig = "http://schemas.google.com/gdata/config/2005";
    public static final XmlNamespace gdataConfigNs;
    public static final String gr = "http://schemas.google.com/g/2005#runtime";
    public static final XmlNamespace grNs;
    @Deprecated
    public static final String openSearch = "http://a9.com/-/spec/opensearchrss/1.0/";
    public static final String openSearch1_0 = "http://a9.com/-/spec/opensearchrss/1.0/";
    public static final XmlNamespace openSearch1_0Ns;
    public static final String openSearch1_1 = "http://a9.com/-/spec/opensearch/1.1/";
    public static final XmlNamespace openSearch1_1Ns;
    @Deprecated
    public static final String openSearchDesc = "http://a9.com/-/spec/opensearchdescription/1.0/";
    @Deprecated
    public static final String openSearchDesc1_1 = "http://a9.com/-/spec/opensearchdescription/1.1/";
    @Deprecated
    public static final XmlNamespace openSearchDesc1_1Ns;
    @Deprecated
    public static final XmlNamespace openSearchDescNs;
    @Deprecated
    public static final XmlNamespace openSearchNs;
    public static final XmlNamespace rssNs;
    public static final String xhtml = "http://www.w3.org/1999/xhtml";
    public static final XmlNamespace xhtmlNs;
    public static final String xml = "http://www.w3.org/XML/1998/namespace";
    public static final XmlNamespace xmlNs;

    private Namespaces() {
    }

    static {
        xmlNs = new XmlNamespace(XMLConstants.XML_NS_PREFIX, xml);
        atomNs = new XmlNamespace("atom", atom);
        atomPubDraftNs = new XmlNamespace("app", atomPubDraft);
        atomPubStandardNs = new XmlNamespace("app", atomPubStandard);
        atomPubNs = atomPubDraftNs;
        rssNs = null;
        openSearch1_0Ns = new XmlNamespace("openSearch", openSearch1_0);
        openSearch1_1Ns = new XmlNamespace("openSearch", openSearch1_1);
        openSearchNs = openSearch1_0Ns;
        openSearchDescNs = new XmlNamespace("openSearchDesc", openSearchDesc);
        openSearchDesc1_1Ns = new XmlNamespace("openSearchDesc", openSearchDesc1_1);
        xhtmlNs = new XmlNamespace("xh", xhtml);
        gdataConfigNs = new XmlNamespace("gc", gdataConfig);
        gNs = new XmlNamespace(gAlias, f443g);
        grNs = new XmlNamespace("gr", gr);
        batchNs = new XmlNamespace(batchAlias, batch);
    }

    public static final XmlNamespace getAtomPubNs() {
        return Service.getVersion().isCompatible(Versions.V1) ? atomPubNs : atomPubStandardNs;
    }

    public static final XmlNamespace getOpenSearchNs() {
        return Service.getVersion().isCompatible(Versions.V1) ? openSearchNs : openSearch1_1Ns;
    }

    public static final XmlNamespace getOpenSearchDescNs() {
        return Service.getVersion().isCompatible(Versions.V1) ? openSearchDescNs : openSearchDesc1_1Ns;
    }

    public static String inflate(String name, String namespace) {
        return (name == null || StringUtil.EMPTY_STRING.equals(name) || name.contains("://")) ? name : namespace + name;
    }

    public static String inflate(String name) {
        return inflate(name, gPrefix);
    }

    public static String deflate(String uri, String namespace) {
        if (uri != null && uri.startsWith(namespace)) {
            return uri.substring(namespace.length());
        }
        return uri;
    }

    public static String deflate(String uri) {
        return deflate(uri, gPrefix);
    }
}
