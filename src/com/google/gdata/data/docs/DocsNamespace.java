package com.google.gdata.data.docs;

import com.google.gdata.util.common.xml.XmlNamespace;

public class DocsNamespace {
    public static final String DOCS = "http://schemas.google.com/docs/2007";
    public static final String DOCS_ALIAS = "docs";
    public static final XmlNamespace DOCS_NS;
    public static final String DOCS_PREFIX = "http://schemas.google.com/docs/2007#";

    private DocsNamespace() {
    }

    static {
        DOCS_NS = new XmlNamespace(DOCS_ALIAS, DOCS);
    }
}
