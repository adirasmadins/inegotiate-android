package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;
import com.amazonaws.javax.xml.stream.util.ReadOnlyIterator;
import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EndElementEvent extends DummyEvent implements EndElement {
    List fNamespaces;
    QName fQName;

    public EndElementEvent() {
        this.fNamespaces = null;
        init();
    }

    protected void init() {
        setEventType(2);
        this.fNamespaces = new ArrayList();
    }

    public EndElementEvent(String prefix, String uri, String localpart) {
        this(new QName(uri, localpart, prefix));
    }

    public EndElementEvent(QName qname) {
        this.fNamespaces = null;
        this.fQName = qname;
        init();
    }

    public QName getName() {
        return this.fQName;
    }

    public void setName(QName qname) {
        this.fQName = qname;
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write(XMLStreamWriterImpl.OPEN_END_TAG);
        String prefix = this.fQName.getPrefix();
        if (prefix != null && prefix.length() > 0) {
            writer.write(prefix);
            writer.write(58);
        }
        writer.write(this.fQName.getLocalPart());
        writer.write(62);
    }

    public Iterator getNamespaces() {
        if (this.fNamespaces != null) {
            this.fNamespaces.iterator();
        }
        return new ReadOnlyIterator();
    }

    void addNamespace(Namespace attr) {
        if (attr != null) {
            this.fNamespaces.add(attr);
        }
    }

    public String toString() {
        return new StringBuffer().append(new StringBuffer().append(XMLStreamWriterImpl.OPEN_END_TAG).append(nameAsString()).toString()).append(">").toString();
    }

    public String nameAsString() {
        if (StringUtil.EMPTY_STRING.equals(this.fQName.getNamespaceURI())) {
            return this.fQName.getLocalPart();
        }
        if (this.fQName.getPrefix() != null) {
            return new StringBuffer().append("['").append(this.fQName.getNamespaceURI()).append("']:").append(this.fQName.getPrefix()).append(":").append(this.fQName.getLocalPart()).toString();
        }
        return new StringBuffer().append("['").append(this.fQName.getNamespaceURI()).append("']:").append(this.fQName.getLocalPart()).toString();
    }
}
