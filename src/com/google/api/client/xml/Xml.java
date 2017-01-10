package com.google.api.client.xml;

import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

public class Xml {
    public static XmlParserFactory parserFactory;

    public static class CustomizeParser {
        public boolean stopBeforeStartTag(String namespace, String localName) {
            return false;
        }

        public boolean stopAfterEndTag(String namespace, String localName) {
            return false;
        }
    }

    private static XmlParserFactory getParserFactory() throws XmlPullParserException {
        XmlParserFactory parserFactory = parserFactory;
        if (parserFactory != null) {
            return parserFactory;
        }
        parserFactory = DefaultXmlParserFactory.getInstance();
        parserFactory = parserFactory;
        return parserFactory;
    }

    public static XmlSerializer createSerializer() {
        try {
            return getParserFactory().createSerializer();
        } catch (XmlPullParserException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static XmlPullParser createParser() throws XmlPullParserException {
        XmlPullParser result = getParserFactory().createParser();
        if (result.getFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces")) {
            return result;
        }
        throw new IllegalStateException("XML pull parser must have namespace-aware feature");
    }

    public static String toStringOf(Object element) {
        return new XmlNamespaceDictionary().toStringOf(null, element);
    }

    private static void parseValue(String stringValue, Field field, Object destination, GenericXml genericXml, Map<String, Object> destinationMap, String name) {
        if (field != null) {
            Class fieldClass = field.getType();
            if (!Modifier.isFinal(field.getModifiers()) || FieldInfo.isPrimitive(fieldClass)) {
                FieldInfo.setFieldValue(field, destination, parseValue(stringValue, fieldClass));
                return;
            }
            throw new IllegalArgumentException("final sub-element fields are not supported");
        } else if (genericXml != null) {
            genericXml.set(name, parseValue(stringValue, null));
        } else if (destinationMap != null) {
            destinationMap.put(name, parseValue(stringValue, null));
        }
    }

    public static void parseElement(XmlPullParser parser, Object destination, XmlNamespaceDictionary namespaceDictionary, CustomizeParser customizeParser) throws IOException, XmlPullParserException {
        parseElementInternal(parser, destination, namespaceDictionary, customizeParser);
    }

    private static boolean parseElementInternal(XmlPullParser parser, Object destination, XmlNamespaceDictionary namespaceDictionary, CustomizeParser customizeParser) throws IOException, XmlPullParserException {
        Class<?> destinationClass = destination == null ? null : destination.getClass();
        GenericXml genericXml = destination instanceof GenericXml ? (GenericXml) destination : null;
        boolean isMap = genericXml == null && (destination instanceof Map);
        Map<String, Object> destinationMap = isMap ? (Map) destination : null;
        ClassInfo classInfo = (isMap || destination == null) ? null : ClassInfo.of(destinationClass);
        int eventType = parser.getEventType();
        if (parser.getEventType() == 0) {
            eventType = parser.next();
        }
        if (eventType == 2) {
            String alias;
            String fieldName;
            Field field;
            String prefix = parser.getPrefix();
            if (prefix == null) {
                alias = StringUtil.EMPTY_STRING;
            } else {
                alias = prefix;
            }
            namespaceDictionary.addNamespace(alias, parser.getNamespace());
            if (genericXml != null) {
                genericXml.namespaceDictionary = namespaceDictionary;
                String name = parser.getName();
                if (prefix != null) {
                    name = prefix + ":" + name;
                }
                genericXml.name = name;
            }
            if (destination != null) {
                int attributeCount = parser.getAttributeCount();
                for (int i = 0; i < attributeCount; i++) {
                    String attributeName = parser.getAttributeName(i);
                    String attributePrefix = parser.getAttributePrefix(i);
                    String attributeNamespace = parser.getAttributeNamespace(i);
                    if (attributePrefix != null) {
                        namespaceDictionary.addNamespace(attributePrefix, attributeNamespace);
                    }
                    fieldName = getFieldName(true, attributePrefix, attributeNamespace, attributeName);
                    if (isMap) {
                        field = null;
                    } else {
                        field = classInfo.getField(fieldName);
                    }
                    parseValue(parser.getAttributeValue(i), field, destination, genericXml, destinationMap, fieldName);
                }
            }
            while (true) {
                switch (parser.next()) {
                    case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                        return true;
                    case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                        if (customizeParser != null) {
                            if (customizeParser.stopBeforeStartTag(parser.getNamespace(), parser.getName())) {
                                return true;
                            }
                        }
                        int level;
                        if (destination != null) {
                            fieldName = getFieldName(false, parser.getPrefix(), parser.getNamespace(), parser.getName());
                            field = isMap ? null : classInfo.getField(fieldName);
                            Class fieldClass = field == null ? null : field.getType();
                            boolean isStopped = false;
                            if ((field == null && !isMap && genericXml == null) || (field != null && FieldInfo.isPrimitive(fieldClass))) {
                                level = 1;
                                while (level != 0) {
                                    switch (parser.next()) {
                                        case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                                            return true;
                                        case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                                            level++;
                                            break;
                                        case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                                            level--;
                                            break;
                                        case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                                            if (level != 1) {
                                                break;
                                            }
                                            parseValue(parser.getText(), field, destination, genericXml, destinationMap, fieldName);
                                            break;
                                        default:
                                            break;
                                    }
                                }
                            } else if (field == null || Map.class.isAssignableFrom(fieldClass)) {
                                Map<String, Object> mapValue = ClassInfo.newMapInstance(fieldClass);
                                isStopped = parseElementInternal(parser, mapValue, namespaceDictionary, customizeParser);
                                Collection<Object> list;
                                Collection<Object> arrayList;
                                if (isMap) {
                                    list = (Collection) destinationMap.get(fieldName);
                                    if (list == null) {
                                        arrayList = new ArrayList(1);
                                        destinationMap.put(fieldName, arrayList);
                                    }
                                    list.add(mapValue);
                                } else if (field != null) {
                                    FieldInfo.setFieldValue(field, destination, mapValue);
                                } else {
                                    GenericXml atom = (GenericXml) destination;
                                    list = (Collection) atom.get(fieldName);
                                    if (list == null) {
                                        arrayList = new ArrayList(1);
                                        atom.set(fieldName, arrayList);
                                    }
                                    list.add(mapValue);
                                }
                            } else if (Collection.class.isAssignableFrom(fieldClass)) {
                                Collection<Object> collectionValue = (Collection) FieldInfo.getFieldValue(field, destination);
                                if (collectionValue == null) {
                                    collectionValue = ClassInfo.newCollectionInstance(fieldClass);
                                    FieldInfo.setFieldValue(field, destination, collectionValue);
                                }
                                Object elementValue = null;
                                Class subFieldClass = ClassInfo.getCollectionParameter(field);
                                if (subFieldClass == null || FieldInfo.isPrimitive(subFieldClass)) {
                                    level = 1;
                                    while (level != 0) {
                                        switch (parser.next()) {
                                            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                                                return true;
                                            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                                                level++;
                                                break;
                                            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                                                level--;
                                                break;
                                            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                                                if (level == 1 && subFieldClass != null) {
                                                    elementValue = parseValue(parser.getText(), subFieldClass);
                                                    break;
                                                }
                                            default:
                                                break;
                                        }
                                    }
                                }
                                elementValue = ClassInfo.newInstance(subFieldClass);
                                isStopped = parseElementInternal(parser, elementValue, namespaceDictionary, customizeParser);
                                collectionValue.add(elementValue);
                            } else {
                                Object value = ClassInfo.newInstance(fieldClass);
                                isStopped = parseElementInternal(parser, value, namespaceDictionary, customizeParser);
                                FieldInfo.setFieldValue(field, destination, value);
                            }
                            if (!isStopped) {
                                break;
                            }
                            return true;
                        }
                        level = 1;
                        while (level != 0) {
                            switch (parser.next()) {
                                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                                    return true;
                                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                                    level++;
                                    break;
                                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                                    level--;
                                    break;
                                default:
                                    break;
                            }
                        }
                        continue;
                    case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                        if (customizeParser != null) {
                            if (customizeParser.stopAfterEndTag(parser.getNamespace(), parser.getName())) {
                                return true;
                            }
                        }
                        return false;
                    case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                        if (destination == null) {
                            break;
                        }
                        String textFieldName = "text()";
                        parseValue(parser.getText(), isMap ? null : classInfo.getField(textFieldName), destination, genericXml, destinationMap, textFieldName);
                        break;
                    default:
                        break;
                }
            }
        }
        throw new IllegalArgumentException("expected start of XML element, but got something else (event type " + eventType + ")");
    }

    private static String getFieldName(boolean isAttribute, String alias, String namespace, String name) {
        if (alias == null) {
            alias = StringUtil.EMPTY_STRING;
        }
        StringBuilder buf = new StringBuilder((alias.length() + 2) + name.length());
        if (isAttribute) {
            buf.append('@');
        }
        if (alias != StringUtil.EMPTY_STRING) {
            buf.append(alias).append(':');
        }
        return buf.append(name).toString();
    }

    private static Object parseValue(String stringValue, Class<?> fieldClass) {
        if (fieldClass == Double.class || fieldClass == Double.TYPE) {
            if (stringValue.equals("INF")) {
                return new Double(Double.POSITIVE_INFINITY);
            }
            if (stringValue.equals("-INF")) {
                return new Double(Double.NEGATIVE_INFINITY);
            }
        }
        if (fieldClass == Float.class || fieldClass == Float.TYPE) {
            if (stringValue.equals("INF")) {
                return Float.valueOf(Float.POSITIVE_INFINITY);
            }
            if (stringValue.equals("-INF")) {
                return Float.valueOf(Float.NEGATIVE_INFINITY);
            }
        }
        return FieldInfo.parsePrimitiveValue(fieldClass, stringValue);
    }

    private Xml() {
    }
}
