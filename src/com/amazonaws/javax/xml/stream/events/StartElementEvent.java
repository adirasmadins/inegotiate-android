package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.NamespaceContext;
import com.amazonaws.javax.xml.namespace.QName;
import com.amazonaws.javax.xml.stream.util.ReadOnlyIterator;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class StartElementEvent extends DummyEvent implements StartElement {
    private Map fAttributes;
    private NamespaceContext fNamespaceContext;
    private List fNamespaces;
    private QName fQName;

    public StartElementEvent(String prefix, String uri, String localpart) {
        this(new QName(uri, localpart, prefix));
    }

    public StartElementEvent(QName qname) {
        this.fNamespaceContext = null;
        this.fQName = qname;
        init();
    }

    public StartElementEvent(StartElement startelement) {
        this(startelement.getName());
        addAttributes(startelement.getAttributes());
        addNamespaceAttributes(startelement.getNamespaces());
    }

    protected void init() {
        setEventType(1);
        this.fAttributes = new HashMap();
        this.fNamespaces = new ArrayList();
    }

    public QName getName() {
        return this.fQName;
    }

    public void setName(QName qname) {
        this.fQName = qname;
    }

    public Iterator getAttributes() {
        if (this.fAttributes != null) {
            return new ReadOnlyIterator(this.fAttributes.values().iterator());
        }
        return new ReadOnlyIterator();
    }

    public Iterator getNamespaces() {
        if (this.fNamespaces != null) {
            return new ReadOnlyIterator(this.fNamespaces.iterator());
        }
        return new ReadOnlyIterator();
    }

    public Attribute getAttributeByName(QName qname) {
        if (qname == null) {
            return null;
        }
        return (Attribute) this.fAttributes.get(qname);
    }

    public String getNamespace() {
        return this.fQName.getNamespaceURI();
    }

    public String getNamespaceURI(String prefix) {
        if (getNamespace() != null && this.fQName.getPrefix().equals(prefix)) {
            return getNamespace();
        }
        if (this.fNamespaceContext != null) {
            return this.fNamespaceContext.getNamespaceURI(prefix);
        }
        return null;
    }

    public String toString() {
        Iterator it;
        String s = new StringBuffer().append("<").append(nameAsString()).toString();
        if (this.fAttributes != null) {
            it = getAttributes();
            while (it.hasNext()) {
                s = new StringBuffer().append(s).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(((Attribute) it.next()).toString()).toString();
            }
        }
        if (this.fNamespaces != null) {
            for (Namespace attr : this.fNamespaces) {
                s = new StringBuffer().append(s).append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR).append(attr.toString()).toString();
            }
        }
        return new StringBuffer().append(s).append(">").toString();
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

    public NamespaceContext getNamespaceContext() {
        return this.fNamespaceContext;
    }

    public void setNamespaceContext(NamespaceContext nc) {
        this.fNamespaceContext = nc;
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write(toString());
    }

    void addAttribute(Attribute attr) {
        if (attr.isNamespace()) {
            this.fNamespaces.add(attr);
        } else {
            this.fAttributes.put(attr.getName(), attr);
        }
    }

    void addAttributes(Iterator attrs) {
        if (attrs != null) {
            while (attrs.hasNext()) {
                Attribute attr = (Attribute) attrs.next();
                this.fAttributes.put(attr.getName(), attr);
            }
        }
    }

    void addNamespaceAttribute(Namespace attr) {
        if (attr != null) {
            this.fNamespaces.add(attr);
        }
    }

    void addNamespaceAttributes(Iterator attrs) {
        if (attrs != null) {
            while (attrs.hasNext()) {
                this.fNamespaces.add((Namespace) attrs.next());
            }
        }
    }
}
