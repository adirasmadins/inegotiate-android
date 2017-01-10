package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.writers.XMLDOMWriterImpl;
import com.amazonaws.javax.xml.stream.writers.XMLEventWriterImpl;
import com.amazonaws.javax.xml.stream.writers.XMLStreamWriterImpl;
import com.amazonaws.javax.xml.transform.Result;
import com.amazonaws.javax.xml.transform.dom.DOMResult;
import com.amazonaws.javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;
import java.io.Writer;

public class ZephyrWriterFactory extends XMLOutputFactory {
    private static final boolean DEBUG = false;
    private boolean fPropertyChanged;
    private PropertyManager fPropertyManager;
    boolean fReuseInstance;
    private XMLStreamWriterImpl fStreamWriter;

    public ZephyrWriterFactory() {
        this.fPropertyManager = new PropertyManager(2);
        this.fStreamWriter = null;
        this.fReuseInstance = false;
    }

    public XMLEventWriter createXMLEventWriter(OutputStream outputStream) throws XMLStreamException {
        return createXMLEventWriter(outputStream, null);
    }

    public XMLEventWriter createXMLEventWriter(OutputStream outputStream, String encoding) throws XMLStreamException {
        return new XMLEventWriterImpl(createXMLStreamWriter(outputStream, encoding));
    }

    public XMLEventWriter createXMLEventWriter(Result result) throws XMLStreamException {
        return new XMLEventWriterImpl(createXMLStreamWriter(result));
    }

    public XMLEventWriter createXMLEventWriter(Writer writer) throws XMLStreamException {
        return new XMLEventWriterImpl(createXMLStreamWriter(writer));
    }

    public XMLStreamWriter createXMLStreamWriter(Result result) throws XMLStreamException {
        if (result instanceof StreamResult) {
            return createXMLStreamWriter((StreamResult) result, null);
        }
        if (result instanceof DOMResult) {
            return new XMLDOMWriterImpl((DOMResult) result);
        }
        if (result instanceof Result) {
            return createXMLStreamWriter(new StreamResult(result.getSystemId()));
        }
        throw new UnsupportedOperationException(new StringBuffer().append("result of type ").append(result).append(" is not supported").toString());
    }

    public XMLStreamWriter createXMLStreamWriter(Writer writer) throws XMLStreamException {
        return createXMLStreamWriter(toStreamResult(null, writer, null), null);
    }

    public XMLStreamWriter createXMLStreamWriter(OutputStream outputStream) throws XMLStreamException {
        return createXMLStreamWriter(outputStream, null);
    }

    public XMLStreamWriter createXMLStreamWriter(OutputStream outputStream, String encoding) throws XMLStreamException {
        return createXMLStreamWriter(toStreamResult(outputStream, null, null), encoding);
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

    public void setProperty(String name, Object value) throws IllegalArgumentException {
        if (name == null || value == null || !this.fPropertyManager.containsProperty(name)) {
            throw new IllegalArgumentException(new StringBuffer().append("Property ").append(name).append("is not supported").toString());
        }
        if (name == Constants.REUSE_INSTANCE || name.equals(Constants.REUSE_INSTANCE)) {
            this.fReuseInstance = ((Boolean) value).booleanValue();
            if (this.fReuseInstance) {
                throw new IllegalArgumentException(new StringBuffer().append("Property ").append(name).append(" is not supported: XMLStreamWriters are not Thread safe").toString());
            }
        }
        this.fPropertyChanged = true;
        this.fPropertyManager.setProperty(name, value);
    }

    private StreamResult toStreamResult(OutputStream os, Writer writer, String systemId) {
        StreamResult sr = new StreamResult();
        sr.setOutputStream(os);
        sr.setWriter(writer);
        sr.setSystemId(systemId);
        return sr;
    }

    XMLStreamWriter createXMLStreamWriter(StreamResult sr, String encoding) throws XMLStreamException {
        try {
            if (!this.fReuseInstance || this.fStreamWriter == null || !this.fStreamWriter.canReuse() || this.fPropertyChanged) {
                XMLStreamWriter xMLStreamWriterImpl = new XMLStreamWriterImpl(sr, encoding, new PropertyManager(this.fPropertyManager));
                this.fStreamWriter = xMLStreamWriterImpl;
                return xMLStreamWriterImpl;
            }
            this.fStreamWriter.reset();
            this.fStreamWriter.setOutput(sr, encoding);
            return this.fStreamWriter;
        } catch (Throwable io) {
            throw new XMLStreamException2(io);
        }
    }
}
