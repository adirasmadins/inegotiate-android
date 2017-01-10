package com.google.api.client.xml;

import com.google.api.client.util.DataUtil;
import com.google.api.client.util.DateTime;
import com.google.api.client.util.FieldInfo;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.SortedSet;
import java.util.TreeSet;
import org.xmlpull.v1.XmlSerializer;

public final class XmlNamespaceDictionary {
    public final HashMap<String, String> namespaceAliasToUriMap;

    class ElementSerializer {
        final List<String> attributeNames;
        final List<Object> attributeValues;
        private final boolean errorOnUnknown;
        final List<String> subElementNames;
        final List<Object> subElementValues;
        Object textValue;

        ElementSerializer(Object elementValue, boolean errorOnUnknown) {
            this.textValue = null;
            this.attributeNames = new ArrayList();
            this.attributeValues = new ArrayList();
            this.subElementNames = new ArrayList();
            this.subElementValues = new ArrayList();
            this.errorOnUnknown = errorOnUnknown;
            if (FieldInfo.isPrimitive(elementValue.getClass())) {
                this.textValue = elementValue;
                return;
            }
            for (Entry<String, Object> entry : DataUtil.mapOf(elementValue).entrySet()) {
                Object fieldValue = entry.getValue();
                if (fieldValue != null) {
                    String fieldName = (String) entry.getKey();
                    if ("text()".equals(fieldName)) {
                        this.textValue = fieldValue;
                    } else if (fieldName.charAt(0) == '@') {
                        this.attributeNames.add(fieldName.substring(1));
                        this.attributeValues.add(fieldValue);
                    } else {
                        this.subElementNames.add(fieldName);
                        this.subElementValues.add(fieldValue);
                    }
                }
            }
        }

        String getNamespaceUriForAlias(String alias) {
            String result = (String) XmlNamespaceDictionary.this.namespaceAliasToUriMap.get(alias);
            if (result != null) {
                return result;
            }
            if (!this.errorOnUnknown) {
                return "http://unknown/" + alias;
            }
            StringBuilder append = new StringBuilder().append("unrecognized alias: ");
            if (alias.length() == 0) {
                alias = "(default)";
            }
            throw new IllegalArgumentException(append.append(alias).toString());
        }

        void serialize(XmlSerializer serializer, String elementName) throws IOException {
            String elementLocalName = null;
            String elementNamespaceUri = null;
            if (elementName != null) {
                int colon = elementName.indexOf(58);
                elementLocalName = elementName.substring(colon + 1);
                String alias = colon == -1 ? StringUtil.EMPTY_STRING : elementName.substring(0, colon);
                elementNamespaceUri = getNamespaceUriForAlias(alias);
                if (elementNamespaceUri == null) {
                    elementNamespaceUri = "http://unknown/" + alias;
                }
            }
            serialize(serializer, elementNamespaceUri, elementLocalName);
        }

        void serialize(XmlSerializer serializer, String elementNamespaceUri, String elementLocalName) throws IOException {
            int i;
            boolean errorOnUnknown = this.errorOnUnknown;
            if (elementLocalName == null) {
                if (errorOnUnknown) {
                    throw new IllegalArgumentException("XML name not specified");
                }
                elementLocalName = "unknownName";
            }
            serializer.startTag(elementNamespaceUri, elementLocalName);
            List<String> attributeNames = this.attributeNames;
            List<Object> attributeValues = this.attributeValues;
            int num = attributeNames.size();
            for (i = 0; i < num; i++) {
                String attributeNamespaceUri;
                String attributeName = (String) attributeNames.get(i);
                int colon = attributeName.indexOf(58);
                String attributeLocalName = attributeName.substring(colon + 1);
                if (colon == -1) {
                    attributeNamespaceUri = null;
                } else {
                    attributeNamespaceUri = getNamespaceUriForAlias(attributeName.substring(0, colon));
                }
                serializer.attribute(attributeNamespaceUri, attributeLocalName, XmlNamespaceDictionary.toSerializedValue(attributeValues.get(i)));
            }
            Object textValue = this.textValue;
            if (textValue != null) {
                serializer.text(XmlNamespaceDictionary.toSerializedValue(textValue));
            }
            List<String> subElementNames = this.subElementNames;
            List<Object> subElementValues = this.subElementValues;
            num = subElementNames.size();
            for (i = 0; i < num; i++) {
                Object subElementValue = subElementValues.get(i);
                String subElementName = (String) subElementNames.get(i);
                if (subElementValue instanceof Collection) {
                    for (Object subElement : (Collection) subElementValue) {
                        new ElementSerializer(subElement, errorOnUnknown).serialize(serializer, subElementName);
                    }
                } else {
                    new ElementSerializer(subElementValue, errorOnUnknown).serialize(serializer, subElementName);
                }
            }
            serializer.endTag(elementNamespaceUri, elementLocalName);
        }
    }

    public XmlNamespaceDictionary() {
        this.namespaceAliasToUriMap = new HashMap();
    }

    public void addNamespace(String alias, String uri) {
        if (alias == null || uri == null) {
            throw new NullPointerException();
        }
        HashMap<String, String> namespaceAliasToUriMap = this.namespaceAliasToUriMap;
        String knownUri = (String) namespaceAliasToUriMap.get(alias);
        if (!uri.equals(knownUri)) {
            if (knownUri != null) {
                throw new IllegalArgumentException("expected namespace alias <" + alias + "> to be <" + knownUri + "> but encountered <" + uri + ">");
            }
            namespaceAliasToUriMap.put(alias, uri);
        }
    }

    public String toStringOf(String elementName, Object element) {
        try {
            StringWriter writer = new StringWriter();
            XmlSerializer serializer = Xml.createSerializer();
            serializer.setOutput(writer);
            serialize(serializer, elementName, element, false);
            return writer.toString();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void serialize(XmlSerializer serializer, String elementNamespaceUri, String elementLocalName, Object element) throws IOException {
        serialize(serializer, elementNamespaceUri, elementLocalName, element, true);
    }

    public void serialize(XmlSerializer serializer, String elementName, Object element) throws IOException {
        serialize(serializer, elementName, element, true);
    }

    private void serialize(XmlSerializer serializer, String elementNamespaceUri, String elementLocalName, Object element, boolean errorOnUnknown) throws IOException {
        startDoc(serializer, element, errorOnUnknown, elementNamespaceUri).serialize(serializer, elementNamespaceUri, elementLocalName);
        serializer.endDocument();
    }

    private void serialize(XmlSerializer serializer, String elementName, Object element, boolean errorOnUnknown) throws IOException {
        startDoc(serializer, element, errorOnUnknown, null).serialize(serializer, elementName);
        serializer.endDocument();
    }

    private ElementSerializer startDoc(XmlSerializer serializer, Object element, boolean errorOnUnknown, String extraNamespace) throws IOException {
        serializer.startDocument(null, null);
        SortedSet<String> aliases = new TreeSet();
        computeAliases(element, aliases);
        HashMap<String, String> namespaceAliasToUriMap = this.namespaceAliasToUriMap;
        boolean foundExtra = extraNamespace == null;
        for (String alias : aliases) {
            String uri = (String) namespaceAliasToUriMap.get(alias);
            serializer.setPrefix(alias, uri);
            if (!foundExtra && uri.equals(extraNamespace)) {
                foundExtra = true;
            }
        }
        if (!foundExtra) {
            for (Entry<String, String> entry : namespaceAliasToUriMap.entrySet()) {
                if (extraNamespace.equals(entry.getValue())) {
                    serializer.setPrefix((String) entry.getKey(), extraNamespace);
                    break;
                }
            }
        }
        return new ElementSerializer(element, errorOnUnknown);
    }

    private void computeAliases(Object element, SortedSet<String> aliases) {
        for (Entry<String, Object> entry : DataUtil.mapOf(element).entrySet()) {
            Object value = entry.getValue();
            if (value != null) {
                String name = (String) entry.getKey();
                if (!"text()".equals(name)) {
                    int colon = name.indexOf(58);
                    boolean isAttribute = name.charAt(0) == '@';
                    if (!(colon == -1 && isAttribute)) {
                        String alias;
                        if (colon == -1) {
                            alias = StringUtil.EMPTY_STRING;
                        } else {
                            alias = name.substring(name.charAt(0) == '@' ? 1 : 0, colon);
                        }
                        aliases.add(alias);
                    }
                    if (!(isAttribute || FieldInfo.isPrimitive(value))) {
                        if (value instanceof Collection) {
                            for (Object subValue : (Collection) value) {
                                computeAliases(subValue, aliases);
                            }
                        } else {
                            computeAliases(value, aliases);
                        }
                    }
                }
            }
        }
    }

    static String toSerializedValue(Object value) {
        if (value instanceof Float) {
            Float f = (Float) value;
            if (f.floatValue() == Float.POSITIVE_INFINITY) {
                return "INF";
            }
            if (f.floatValue() == Float.NEGATIVE_INFINITY) {
                return "-INF";
            }
        }
        if (value instanceof Double) {
            Double d = (Double) value;
            if (d.doubleValue() == Double.POSITIVE_INFINITY) {
                return "INF";
            }
            if (d.doubleValue() == Double.NEGATIVE_INFINITY) {
                return "-INF";
            }
        }
        if ((value instanceof String) || (value instanceof Number) || (value instanceof Boolean)) {
            return value.toString();
        }
        if (value instanceof DateTime) {
            return ((DateTime) value).toStringRfc3339();
        }
        throw new IllegalArgumentException("unrecognized value type: " + value.getClass());
    }
}
