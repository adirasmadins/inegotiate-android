package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.util.XMLEventAllocator;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import com.amazonaws.javax.xml.transform.Source;
import java.io.InputStream;
import java.io.Reader;

public class ZephyrParserFactory extends XMLInputFactory {
    private static final boolean DEBUG = false;
    boolean fPropertyChanged;
    private PropertyManager fPropertyManager;
    boolean fReuseInstance;
    private XMLReaderImpl fTempReader;

    public ZephyrParserFactory() {
        this.fPropertyManager = new PropertyManager(1);
        this.fTempReader = null;
        this.fPropertyChanged = false;
        this.fReuseInstance = false;
    }

    void initEventReader() {
        this.fPropertyChanged = true;
    }

    public XMLEventReader createXMLEventReader(InputStream inputstream) throws XMLStreamException {
        initEventReader();
        return new XMLEventReaderImpl(createXMLStreamReader(inputstream));
    }

    public XMLEventReader createXMLEventReader(Reader reader) throws XMLStreamException {
        initEventReader();
        return new XMLEventReaderImpl(createXMLStreamReader(reader));
    }

    public XMLEventReader createXMLEventReader(Source source) throws XMLStreamException {
        initEventReader();
        return new XMLEventReaderImpl(createXMLStreamReader(source));
    }

    public XMLEventReader createXMLEventReader(String systemId, InputStream inputstream) throws XMLStreamException {
        initEventReader();
        return new XMLEventReaderImpl(createXMLStreamReader(systemId, inputstream));
    }

    public XMLEventReader createXMLEventReader(InputStream stream, String encoding) throws XMLStreamException {
        initEventReader();
        return new XMLEventReaderImpl(createXMLStreamReader(stream, encoding));
    }

    public XMLEventReader createXMLEventReader(String systemId, Reader reader) throws XMLStreamException {
        initEventReader();
        return new XMLEventReaderImpl(createXMLStreamReader(systemId, reader));
    }

    public XMLEventReader createXMLEventReader(XMLStreamReader reader) throws XMLStreamException {
        initEventReader();
        return new XMLEventReaderImpl(reader);
    }

    public XMLStreamReader createXMLStreamReader(Reader reader) throws XMLStreamException {
        return createXMLStreamReader(null, reader);
    }

    public XMLStreamReader createXMLStreamReader(String systemId, Reader reader) throws XMLStreamException {
        return getXMLStreamReaderImpl(new XMLInputSource(null, systemId, null, reader, null));
    }

    public XMLStreamReader createXMLStreamReader(Source source) throws XMLStreamException {
        return new XMLReaderImpl(jaxpSourcetoXMLInputSource(source), new PropertyManager(this.fPropertyManager));
    }

    public XMLStreamReader createXMLStreamReader(InputStream inputStream) throws XMLStreamException {
        return createXMLStreamReader(null, inputStream, null);
    }

    public XMLStreamReader createXMLStreamReader(String systemId, InputStream inputStream) throws XMLStreamException {
        return createXMLStreamReader(systemId, inputStream, null);
    }

    public XMLStreamReader createXMLStreamReader(InputStream inputStream, String encoding) throws XMLStreamException {
        return createXMLStreamReader(null, inputStream, encoding);
    }

    public XMLStreamReader createXMLStreamReader(String systemId, InputStream inputStream, String encoding) throws XMLStreamException {
        return getXMLStreamReaderImpl(new XMLInputSource(null, systemId, null, inputStream, encoding));
    }

    public XMLEventAllocator getEventAllocator() {
        return (XMLEventAllocator) getProperty(XMLInputFactory.ALLOCATOR);
    }

    public XMLReporter getXMLReporter() {
        return (XMLReporter) this.fPropertyManager.getProperty(XMLInputFactory.REPORTER);
    }

    public XMLResolver getXMLResolver() {
        return (XMLResolver) this.fPropertyManager.getProperty(XMLInputFactory.RESOLVER);
    }

    public void setXMLReporter(XMLReporter xmlreporter) {
        this.fPropertyManager.setProperty(XMLInputFactory.REPORTER, xmlreporter);
    }

    public void setXMLResolver(XMLResolver xmlresolver) {
        this.fPropertyManager.setProperty(XMLInputFactory.RESOLVER, xmlresolver);
    }

    public XMLEventReader createFilteredReader(XMLEventReader reader, EventFilter filter) throws XMLStreamException {
        return new EventFilterSupport(reader, filter);
    }

    public XMLStreamReader createFilteredReader(XMLStreamReader reader, StreamFilter filter) throws XMLStreamException {
        if (reader == null || filter == null) {
            return null;
        }
        return new XMLStreamFilterImpl(reader, filter);
    }

    public Object getProperty(String name) throws IllegalArgumentException {
        if (name == null) {
            throw new IllegalArgumentException("Property not supported");
        } else if (this.fPropertyManager.containsProperty(name)) {
            return this.fPropertyManager.getProperty(name);
        } else {
            throw new IllegalArgumentException("Property not supported");
        }
    }

    public boolean isPropertySupported(String name) {
        if (name == null) {
            return false;
        }
        return this.fPropertyManager.containsProperty(name);
    }

    public void setEventAllocator(XMLEventAllocator allocator) {
        this.fPropertyManager.setProperty(XMLInputFactory.ALLOCATOR, allocator);
    }

    public void setProperty(String name, Object value) throws IllegalArgumentException {
        if (name == null || value == null || !this.fPropertyManager.containsProperty(name)) {
            throw new IllegalArgumentException(new StringBuffer().append("Property ").append(name).append(" is not supported").toString());
        }
        if (name == Constants.REUSE_INSTANCE || name.equals(Constants.REUSE_INSTANCE)) {
            this.fReuseInstance = ((Boolean) value).booleanValue();
        } else {
            this.fPropertyChanged = true;
        }
        this.fPropertyManager.setProperty(name, value);
    }

    XMLStreamReader getXMLStreamReaderImpl(XMLInputSource inputSource) throws XMLStreamException {
        XMLStreamReader xMLReaderImpl;
        if (this.fTempReader == null) {
            this.fPropertyChanged = false;
            xMLReaderImpl = new XMLReaderImpl(inputSource, new PropertyManager(this.fPropertyManager));
            this.fTempReader = xMLReaderImpl;
            return xMLReaderImpl;
        } else if (this.fReuseInstance && this.fTempReader.canReuse() && !this.fPropertyChanged) {
            this.fTempReader.reset();
            this.fTempReader.setInputSource(inputSource);
            this.fPropertyChanged = false;
            return this.fTempReader;
        } else {
            this.fPropertyChanged = false;
            xMLReaderImpl = new XMLReaderImpl(inputSource, new PropertyManager(this.fPropertyManager));
            this.fTempReader = xMLReaderImpl;
            return xMLReaderImpl;
        }
    }

    XMLInputSource jaxpSourcetoXMLInputSource(Source source) {
        throw new UnsupportedOperationException(new StringBuffer().append("Cannot create XMLStreamReader or XMLEventReader from a ").append(source.getClass().getName()).toString());
    }
}
