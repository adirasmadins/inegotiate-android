package com.google.api.client.xml.atom;

import com.google.api.client.xml.Xml.CustomizeParser;

public final class Atom {
    public static final String ATOM_NAMESPACE = "http://www.w3.org/2005/Atom";
    public static final String CONTENT_TYPE = "application/atom+xml";

    static final class StopAtAtomEntry extends CustomizeParser {
        static final StopAtAtomEntry INSTANCE;

        StopAtAtomEntry() {
        }

        static {
            INSTANCE = new StopAtAtomEntry();
        }

        public boolean stopBeforeStartTag(String namespace, String localName) {
            return "entry".equals(localName) && Atom.ATOM_NAMESPACE.equals(namespace);
        }
    }

    private Atom() {
    }

    public static void checkContentType(String contentType) {
        if (contentType == null || !contentType.startsWith(CONTENT_TYPE)) {
            throw new IllegalArgumentException("Wrong content type: expected <application/atom+xml> but got <" + contentType + ">");
        }
    }
}
