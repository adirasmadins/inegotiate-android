package com.google.gdata.wireformats;

import com.google.common.collect.Maps;
import com.google.gdata.model.Attribute;
import com.google.gdata.model.AttributeKey;
import com.google.gdata.model.AttributeMetadata;
import com.google.gdata.model.Element;
import com.google.gdata.model.ElementMetadata;
import com.google.gdata.model.QName;
import com.google.gdata.util.common.xml.XmlNamespace;
import java.util.Iterator;
import java.util.Map;

public class GeneratorUtils {
    public static Map<String, XmlNamespace> calculateNamespaces(Element root, ElementMetadata<?, ?> metadata) {
        Map<String, XmlNamespace> namespaceMap = Maps.newHashMap();
        calculateNamespaces(namespaceMap, root, metadata);
        return namespaceMap;
    }

    private static void calculateNamespaces(Map<String, XmlNamespace> namespaces, Element e, ElementMetadata<?, ?> metadata) {
        addNamespace(namespaces, metadata == null ? e.getElementId() : metadata.getName());
        Iterator<Attribute> attIter = e.getAttributeIterator(metadata);
        while (attIter.hasNext()) {
            AttributeKey<?> attKey = ((Attribute) attIter.next()).getAttributeKey();
            AttributeMetadata<?> attMeta = metadata == null ? null : metadata.bindAttribute(attKey);
            addNamespace(namespaces, attMeta == null ? attKey.getId() : attMeta.getName());
        }
        Iterator<Element> childIter = e.getElementIterator(metadata);
        while (childIter.hasNext()) {
            Element child = (Element) childIter.next();
            calculateNamespaces(namespaces, child, metadata == null ? null : metadata.bindElement(child.getElementKey()));
        }
    }

    private static void addNamespace(Map<String, XmlNamespace> namespaces, QName name) {
        if (name != null) {
            XmlNamespace ns = name.getNs();
            if (ns != null && ns.getAlias() != null) {
                String uri = ns.getUri();
                if (!namespaces.containsKey(uri)) {
                    namespaces.put(uri, ns);
                }
            }
        }
    }
}
