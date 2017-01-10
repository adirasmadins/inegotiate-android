package com.google.gdata.data;

import com.amazonaws.javax.xml.transform.OutputKeys;
import com.google.gdata.util.Namespaces;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.xml.XmlWriter;
import com.google.gdata.util.common.xml.XmlWriter.Attribute;
import java.io.IOException;
import java.util.ArrayList;

public class Generator implements IGenerator {
    protected String name;
    protected String uri;
    protected String version;

    public class AtomHandler extends ElementHandler {
        public void processAttribute(String namespace, String localName, String value) {
            if (namespace.equals(StringUtil.EMPTY_STRING) && localName.equals(OutputKeys.VERSION)) {
                Generator.this.version = value;
            } else if (namespace.equals(StringUtil.EMPTY_STRING) && localName.equals("uri")) {
                Generator.this.uri = value;
            }
        }

        public void processEndElement() {
            Generator.this.name = this.value;
        }
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String v) {
        this.version = v;
    }

    public String getUri() {
        return this.uri;
    }

    public String getHref() {
        return this.uri;
    }

    public void setUri(String v) {
        this.uri = v;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String v) {
        this.name = v;
    }

    public void generateAtom(XmlWriter w) throws IOException {
        ArrayList<Attribute> attrs = new ArrayList(2);
        if (this.version != null) {
            attrs.add(new Attribute(OutputKeys.VERSION, this.version));
        }
        if (this.uri != null) {
            attrs.add(new Attribute("uri", this.uri));
        }
        w.simpleElement(Namespaces.atomNs, "generator", attrs, this.name);
    }
}
