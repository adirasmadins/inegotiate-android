package com.google.gdata.data.geo;

import com.google.gdata.util.common.xml.XmlNamespace;

public class Namespaces {
    public static final String GEO_RSS = "http://www.georss.org/georss";
    public static final String GEO_RSS_ALIAS = "georss";
    public static final XmlNamespace GEO_RSS_NAMESPACE;
    public static final String GML = "http://www.opengis.net/gml";
    public static final String GML_ALIAS = "gml";
    public static final XmlNamespace GML_NAMESPACE;
    public static final String W3C_GEO = "http://www.w3.org/2003/01/geo/wgs84_pos#";
    public static final String W3C_GEO_ALIAS = "geo";
    public static final XmlNamespace W3C_GEO_NAMESPACE;

    static {
        W3C_GEO_NAMESPACE = new XmlNamespace(W3C_GEO_ALIAS, W3C_GEO);
        GEO_RSS_NAMESPACE = new XmlNamespace(GEO_RSS_ALIAS, GEO_RSS);
        GML_NAMESPACE = new XmlNamespace(GML_ALIAS, GML);
    }

    private Namespaces() {
    }
}
