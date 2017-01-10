package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.transform.Result;
import java.io.OutputStream;
import java.io.Writer;

public abstract class XMLOutputFactory {
    static final String DEFAULIMPL = "com.sun.xml.internal.stream.XMLOutputFactoryImpl";
    public static final String IS_REPAIRING_NAMESPACES = "com.amazonaws.javax.xml.stream.isRepairingNamespaces";

    public abstract XMLEventWriter createXMLEventWriter(Result result) throws XMLStreamException;

    public abstract XMLEventWriter createXMLEventWriter(OutputStream outputStream) throws XMLStreamException;

    public abstract XMLEventWriter createXMLEventWriter(OutputStream outputStream, String str) throws XMLStreamException;

    public abstract XMLEventWriter createXMLEventWriter(Writer writer) throws XMLStreamException;

    public abstract XMLStreamWriter createXMLStreamWriter(Result result) throws XMLStreamException;

    public abstract XMLStreamWriter createXMLStreamWriter(OutputStream outputStream) throws XMLStreamException;

    public abstract XMLStreamWriter createXMLStreamWriter(OutputStream outputStream, String str) throws XMLStreamException;

    public abstract XMLStreamWriter createXMLStreamWriter(Writer writer) throws XMLStreamException;

    public abstract Object getProperty(String str) throws IllegalArgumentException;

    public abstract boolean isPropertySupported(String str);

    public abstract void setProperty(String str, Object obj) throws IllegalArgumentException;

    protected XMLOutputFactory() {
    }

    public static XMLOutputFactory newInstance() throws FactoryConfigurationError {
        return (XMLOutputFactory) FactoryFinder.find("com.amazonaws.javax.xml.stream.XMLOutputFactory", DEFAULIMPL);
    }

    public static XMLOutputFactory newFactory() throws FactoryConfigurationError {
        return (XMLOutputFactory) FactoryFinder.find("com.amazonaws.javax.xml.stream.XMLOutputFactory", DEFAULIMPL);
    }

    public static XMLInputFactory newInstance(String factoryId, ClassLoader classLoader) throws FactoryConfigurationError {
        try {
            return (XMLInputFactory) FactoryFinder.find(factoryId, classLoader, null);
        } catch (ConfigurationError e) {
            throw new FactoryConfigurationError(e.getException(), e.getMessage());
        }
    }

    public static XMLOutputFactory newFactory(String factoryId, ClassLoader classLoader) throws FactoryConfigurationError {
        try {
            return (XMLOutputFactory) FactoryFinder.find(factoryId, classLoader, null);
        } catch (ConfigurationError e) {
            throw new FactoryConfigurationError(e.getException(), e.getMessage());
        }
    }
}
