package com.google.gdata.model.gd;

import com.google.gdata.util.common.xml.XmlNamespace;

public class Namespaces {
    public static final String f442g = "http://schemas.google.com/g/2005";
    public static final String gAlias = "gd";
    public static final XmlNamespace gNs;
    public static final String gPrefix = "http://schemas.google.com/g/2005#";

    private Namespaces() {
    }

    static {
        gNs = new XmlNamespace(gAlias, f442g);
    }
}
