package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.Writer;

public class NamedEvent extends DummyEvent {
    private QName name;

    public NamedEvent(QName qname) {
        this.name = qname;
    }

    public NamedEvent(String prefix, String uri, String localpart) {
        this.name = new QName(uri, localpart, prefix);
    }

    public String getPrefix() {
        return this.name.getPrefix();
    }

    public QName getName() {
        return this.name;
    }

    public void setName(QName qname) {
        this.name = qname;
    }

    public String nameAsString() {
        if (StringUtil.EMPTY_STRING.equals(this.name.getNamespaceURI())) {
            return this.name.getLocalPart();
        }
        if (this.name.getPrefix() != null) {
            return new StringBuffer().append("['").append(this.name.getNamespaceURI()).append("']:").append(getPrefix()).append(":").append(this.name.getLocalPart()).toString();
        }
        return new StringBuffer().append("['").append(this.name.getNamespaceURI()).append("']:").append(this.name.getLocalPart()).toString();
    }

    public String getNamespace() {
        return this.name.getNamespaceURI();
    }

    protected void writeAsEncodedUnicodeEx(Writer writer) throws IOException {
        writer.write(nameAsString());
    }
}
