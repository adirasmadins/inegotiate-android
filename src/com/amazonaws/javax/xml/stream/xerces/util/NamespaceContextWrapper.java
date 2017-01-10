package com.amazonaws.javax.xml.stream.xerces.util;

import com.amazonaws.javax.xml.namespace.NamespaceContext;
import java.util.Iterator;

public class NamespaceContextWrapper implements NamespaceContext {
    private com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext fNamespaceContext;

    public NamespaceContextWrapper(com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext namespaceContext) {
        this.fNamespaceContext = namespaceContext;
    }

    public String getNamespaceURI(String prefix) {
        if (prefix != null) {
            return this.fNamespaceContext.getURI(prefix.intern());
        }
        throw new IllegalArgumentException("Prefix can't be null");
    }

    public String getPrefix(String namespaceURI) {
        if (namespaceURI != null) {
            return this.fNamespaceContext.getPrefix(namespaceURI.intern());
        }
        throw new IllegalArgumentException("URI can't be null");
    }

    public Iterator getPrefixes(String namespaceURI) {
        if (namespaceURI != null) {
            return ((NamespaceSupport) this.fNamespaceContext).getPrefixes(namespaceURI.intern()).iterator();
        }
        throw new IllegalArgumentException("URI can't be null");
    }

    public com.amazonaws.javax.xml.stream.xerces.xni.NamespaceContext getNamespaceContext() {
        return this.fNamespaceContext;
    }
}
