package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.util.XMLEventAllocator;
import com.amazonaws.javax.xml.transform.Source;
import java.io.InputStream;
import java.io.Reader;

public abstract class XMLInputFactory {
    public static final String ALLOCATOR = "com.amazonaws.javax.xml.stream.allocator";
    static final String DEFAULIMPL = "com.amazonaws.javax.xml.stream.ZephyrParserFactory";
    public static final String IS_COALESCING = "com.amazonaws.javax.xml.stream.isCoalescing";
    public static final String IS_NAMESPACE_AWARE = "com.amazonaws.javax.xml.stream.isNamespaceAware";
    public static final String IS_REPLACING_ENTITY_REFERENCES = "com.amazonaws.javax.xml.stream.isReplacingEntityReferences";
    public static final String IS_SUPPORTING_EXTERNAL_ENTITIES = "com.amazonaws.javax.xml.stream.isSupportingExternalEntities";
    public static final String IS_VALIDATING = "com.amazonaws.javax.xml.stream.isValidating";
    public static final String REPORTER = "com.amazonaws.javax.xml.stream.reporter";
    public static final String RESOLVER = "com.amazonaws.javax.xml.stream.resolver";
    public static final String SUPPORT_DTD = "com.amazonaws.javax.xml.stream.supportDTD";

    public abstract XMLEventReader createFilteredReader(XMLEventReader xMLEventReader, EventFilter eventFilter) throws XMLStreamException;

    public abstract XMLStreamReader createFilteredReader(XMLStreamReader xMLStreamReader, StreamFilter streamFilter) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(XMLStreamReader xMLStreamReader) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(Source source) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(InputStream inputStream) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(InputStream inputStream, String str) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(Reader reader) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(String str, InputStream inputStream) throws XMLStreamException;

    public abstract XMLEventReader createXMLEventReader(String str, Reader reader) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(Source source) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(InputStream inputStream) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(InputStream inputStream, String str) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(Reader reader) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(String str, InputStream inputStream) throws XMLStreamException;

    public abstract XMLStreamReader createXMLStreamReader(String str, Reader reader) throws XMLStreamException;

    public abstract XMLEventAllocator getEventAllocator();

    public abstract Object getProperty(String str) throws IllegalArgumentException;

    public abstract XMLReporter getXMLReporter();

    public abstract XMLResolver getXMLResolver();

    public abstract boolean isPropertySupported(String str);

    public abstract void setEventAllocator(XMLEventAllocator xMLEventAllocator);

    public abstract void setProperty(String str, Object obj) throws IllegalArgumentException;

    public abstract void setXMLReporter(XMLReporter xMLReporter);

    public abstract void setXMLResolver(XMLResolver xMLResolver);

    protected XMLInputFactory() {
    }

    public static XMLInputFactory newInstance() throws FactoryConfigurationError {
        return (XMLInputFactory) FactoryFinder.find("com.amazonaws.javax.xml.stream.XMLInputFactory", DEFAULIMPL);
    }

    public static XMLInputFactory newFactory() throws FactoryConfigurationError {
        return (XMLInputFactory) FactoryFinder.find("com.amazonaws.javax.xml.stream.XMLInputFactory", DEFAULIMPL);
    }

    public static XMLInputFactory newInstance(String factoryId, ClassLoader classLoader) throws FactoryConfigurationError {
        try {
            return (XMLInputFactory) FactoryFinder.find(factoryId, classLoader, null);
        } catch (ConfigurationError e) {
            throw new FactoryConfigurationError(e.getException(), e.getMessage());
        }
    }

    public static XMLInputFactory newFactory(String factoryId, ClassLoader classLoader) throws FactoryConfigurationError {
        try {
            return (XMLInputFactory) FactoryFinder.find(factoryId, classLoader, null);
        } catch (ConfigurationError e) {
            throw new FactoryConfigurationError(e.getException(), e.getMessage());
        }
    }
}
