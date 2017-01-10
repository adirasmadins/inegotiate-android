package com.amazonaws.javax.xml.stream;

import java.util.HashMap;

public class PropertyManager {
    public static final int CONTEXT_READER = 1;
    public static final int CONTEXT_WRITER = 2;
    public static final String STAX_ENTITIES = "com.amazonaws.javax.xml.stream.entities";
    public static final String STAX_NOTATIONS = "com.amazonaws.javax.xml.stream.notations";
    private static final String STRING_INTERNING = "http://xml.org/sax/features/string-interning";
    HashMap supportedProps;

    public PropertyManager(int context) {
        this.supportedProps = new HashMap();
        switch (context) {
            case CONTEXT_READER /*1*/:
                initConfigurableReaderProperties();
            case CONTEXT_WRITER /*2*/:
                initWriterProps();
            default:
        }
    }

    public PropertyManager(PropertyManager propertyManager) {
        this.supportedProps = new HashMap();
        this.supportedProps.putAll(propertyManager.getProperties());
    }

    private HashMap getProperties() {
        return this.supportedProps;
    }

    private void initConfigurableReaderProperties() {
        this.supportedProps.put(XMLInputFactory.IS_NAMESPACE_AWARE, Boolean.TRUE);
        this.supportedProps.put(XMLInputFactory.IS_VALIDATING, Boolean.FALSE);
        this.supportedProps.put(XMLInputFactory.IS_REPLACING_ENTITY_REFERENCES, Boolean.TRUE);
        this.supportedProps.put(XMLInputFactory.IS_SUPPORTING_EXTERNAL_ENTITIES, Boolean.TRUE);
        this.supportedProps.put(XMLInputFactory.IS_COALESCING, Boolean.FALSE);
        this.supportedProps.put(XMLInputFactory.SUPPORT_DTD, Boolean.TRUE);
        this.supportedProps.put(XMLInputFactory.REPORTER, null);
        this.supportedProps.put(XMLInputFactory.RESOLVER, null);
        this.supportedProps.put(XMLInputFactory.ALLOCATOR, null);
        this.supportedProps.put(STAX_NOTATIONS, null);
        this.supportedProps.put(STRING_INTERNING, Boolean.TRUE);
        this.supportedProps.put("http://apache.org/xml/features/allow-java-encodings", Boolean.TRUE);
        this.supportedProps.put(Constants.REUSE_INSTANCE, Boolean.FALSE);
        this.supportedProps.put("http://java.sun.com/xml/stream/properties/report-cdata-event", Boolean.FALSE);
        this.supportedProps.put("http://java.sun.com/xml/stream/properties/ignore-external-dtd", Boolean.FALSE);
        this.supportedProps.put("http://apache.org/xml/features/validation/warn-on-duplicate-attdef", Boolean.FALSE);
        this.supportedProps.put("http://apache.org/xml/features/warn-on-duplicate-entitydef", Boolean.FALSE);
        this.supportedProps.put("http://apache.org/xml/features/validation/warn-on-undeclared-elemdef", Boolean.FALSE);
        this.supportedProps.put("http://java.sun.com/xml/stream/properties/implementation-name", "sjsxp");
    }

    private void initWriterProps() {
        this.supportedProps.put(XMLOutputFactory.IS_REPAIRING_NAMESPACES, Boolean.FALSE);
        this.supportedProps.put(Constants.ESCAPE_CHARACTERS, Boolean.TRUE);
        this.supportedProps.put(Constants.REUSE_INSTANCE, Boolean.FALSE);
        this.supportedProps.put("http://java.sun.com/xml/stream/properties/implementation-name", "sjsxp");
        this.supportedProps.put("http://java.sun.com/xml/stream/properties/outputstream", null);
    }

    public boolean containsProperty(String property) {
        return this.supportedProps.containsKey(property);
    }

    public Object getProperty(String property) {
        return this.supportedProps.get(property);
    }

    public void setProperty(String property, Object value) {
        String equivalentProperty = null;
        if (property == XMLInputFactory.IS_NAMESPACE_AWARE || property.equals(XMLInputFactory.IS_NAMESPACE_AWARE)) {
            equivalentProperty = "http://apache.org/xml/features/namespaces";
        } else if (property == XMLInputFactory.IS_VALIDATING || property.equals(XMLInputFactory.IS_VALIDATING)) {
            if ((value instanceof Boolean) && ((Boolean) value).booleanValue()) {
                throw new IllegalArgumentException("true value of isValidating not supported");
            }
        } else if (property == STRING_INTERNING || property.equals(STRING_INTERNING)) {
            if ((value instanceof Boolean) && !((Boolean) value).booleanValue()) {
                throw new IllegalArgumentException("false value of http://xml.org/sax/features/string-interningfeature is not supported");
            }
        } else if (property == XMLInputFactory.RESOLVER || property.equals(XMLInputFactory.RESOLVER)) {
            this.supportedProps.put("http://apache.org/xml/properties/internal/stax-entity-resolver", new StaxEntityResolverWrapper((XMLResolver) value));
        }
        this.supportedProps.put(property, value);
        if (equivalentProperty != null) {
            this.supportedProps.put(equivalentProperty, value);
        }
    }

    public String toString() {
        return this.supportedProps.toString();
    }
}
