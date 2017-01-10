package com.google.gdata.data.threading;

import com.google.gdata.util.common.xml.XmlNamespace;

public class ThreadingNamespace {
    public static final String THR = "http://purl.org/syndication/thread/1.0";
    public static final String THR_ALIAS = "thr";
    public static final XmlNamespace THR_NS;
    public static final String THR_PREFIX = "http://purl.org/syndication/thread/1.0#";

    private ThreadingNamespace() {
    }

    static {
        THR_NS = new XmlNamespace(THR_ALIAS, THR);
    }
}
