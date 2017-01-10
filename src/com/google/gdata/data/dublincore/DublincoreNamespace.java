package com.google.gdata.data.dublincore;

import com.google.gdata.util.common.xml.XmlNamespace;

public class DublincoreNamespace {
    public static final String DC = "http://purl.org/dc/terms";
    public static final String DC_ALIAS = "dc";
    public static final XmlNamespace DC_NS;
    public static final String DC_PREFIX = "http://purl.org/dc/terms#";

    private DublincoreNamespace() {
    }

    static {
        DC_NS = new XmlNamespace(DC_ALIAS, DC);
    }
}
