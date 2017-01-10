package com.amazonaws.javax.xml.stream.xerces.xni;

import com.amazonaws.javax.xml.XMLConstants;
import com.google.gdata.util.Namespaces;
import java.util.Enumeration;
import java.util.Vector;

public interface NamespaceContext {
    public static final String XMLNS_URI;
    public static final String XML_URI;

    boolean declarePrefix(String str, String str2);

    Enumeration getAllPrefixes();

    String getDeclaredPrefixAt(int i);

    int getDeclaredPrefixCount();

    String getPrefix(String str);

    Vector getPrefixes(String str);

    String getURI(String str);

    void popContext();

    void pushContext();

    void reset();

    static {
        XML_URI = Namespaces.xml.intern();
        XMLNS_URI = XMLConstants.XMLNS_ATTRIBUTE_NS_URI.intern();
    }
}
