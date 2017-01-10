package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLResourceIdentifier;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;
import com.amazonaws.javax.xml.stream.xerces.xni.parser.XMLInputSource;
import java.io.IOException;
import java.io.InputStream;

public class StaxEntityResolverWrapper {
    XMLResolver fStaxResolver;

    public StaxEntityResolverWrapper(XMLResolver resolver) {
        this.fStaxResolver = resolver;
    }

    public void setStaxEntityResolver(XMLResolver resolver) {
        this.fStaxResolver = resolver;
    }

    public XMLResolver getStaxEntityResolver() {
        return this.fStaxResolver;
    }

    public StaxXMLInputSource resolveEntity(XMLResourceIdentifier resourceIdentifier) throws XNIException, IOException {
        try {
            return getStaxInputSource(this.fStaxResolver.resolveEntity(resourceIdentifier.getPublicId(), resourceIdentifier.getLiteralSystemId(), resourceIdentifier.getBaseSystemId(), null));
        } catch (Exception streamException) {
            throw new XNIException(streamException);
        }
    }

    StaxXMLInputSource getStaxInputSource(Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof InputStream) {
            return new StaxXMLInputSource(new XMLInputSource(null, null, null, (InputStream) object, null));
        } else if (object instanceof XMLStreamReader) {
            return new StaxXMLInputSource((XMLStreamReader) object);
        } else {
            if (object instanceof XMLEventReader) {
                return new StaxXMLInputSource((XMLEventReader) object);
            }
            return null;
        }
    }
}
