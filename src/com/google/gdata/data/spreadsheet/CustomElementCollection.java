package com.google.gdata.data.spreadsheet;

import com.google.gdata.data.Extension;
import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.model.QName;
import com.google.gdata.util.ParseException;
import com.google.gdata.util.XmlParser.ElementHandler;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xml.sax.Attributes;

public class CustomElementCollection implements Extension {
    private Map<String, CustomElement> values;

    private class CustomElement {
        private String value;

        public CustomElement(String value) {
            this.value = value;
        }

        public CustomElement(String value, String comment) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

    private class CustomElementHandler extends ElementHandler {
        private String tagName;

        public CustomElementHandler(String tagName) {
            this.tagName = tagName;
        }

        public void processAttribute(String namespace, String localName, String value) throws ParseException {
        }

        public void processEndElement() throws ParseException {
            if (this.value == null) {
                CustomElementCollection.this.values.put(this.tagName, new CustomElement(null));
            } else {
                CustomElementCollection.this.values.put(this.tagName, new CustomElement(this.value));
            }
        }
    }

    public CustomElementCollection() {
        this.values = new LinkedHashMap();
    }

    public String getValue(String columnHeader) {
        CustomElement element = (CustomElement) this.values.get(columnHeader.toLowerCase());
        if (element == null) {
            return null;
        }
        return element.getValue();
    }

    public void setValueLocal(String columnHeader, String newContents) {
        if (newContents.startsWith("=")) {
            throw new IllegalArgumentException("Formulas are not supported.");
        }
        this.values.put(columnHeader.toLowerCase(), new CustomElement(newContents));
    }

    public void clearValueLocal(String columnHeader) {
        this.values.remove(columnHeader.toLowerCase());
    }

    public void replaceWithLocal(CustomElementCollection other) {
        this.values.clear();
        this.values.putAll(other.values);
    }

    public Set<String> getTags() {
        return this.values.keySet();
    }

    public static ExtensionDescription getDefaultDescription() {
        ExtensionDescription desc = new ExtensionDescription();
        desc.setExtensionClass(CustomElementCollection.class);
        desc.setNamespace(Namespaces.gSpreadCustomNs);
        desc.setLocalName(QName.ANY_LOCALNAME);
        desc.setAggregate(true);
        return desc;
    }

    public void generate(XmlWriter w, ExtensionProfile extProfile) throws IOException {
        for (Entry<String, CustomElement> entry : this.values.entrySet()) {
            w.simpleElement(Namespaces.gSpreadCustomNs, (String) entry.getKey(), new ArrayList(), ((CustomElement) entry.getValue()).getValue());
        }
    }

    public ElementHandler getHandler(ExtensionProfile extProfile, String namespace, String localName, Attributes attrs) throws ParseException, IOException {
        return new CustomElementHandler(localName);
    }
}
