package com.google.gdata.wireformats;

import com.google.gdata.data.XmlEventSource;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.util.common.xml.parsing.SecureGenericXMLFactory;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.ParserAdapter;

public class SaxEventSource implements XmlEventSource {
    private static final Logger logger;
    private static final SAXParserFactory parserFactory;
    private final Reader reader;

    static {
        logger = Logger.getLogger(SaxEventSource.class.getCanonicalName());
        parserFactory = createSAXParserFactory();
    }

    private static SAXParserFactory createSAXParserFactory() {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            try {
                SAXParserFactory secureFactory = SecureGenericXMLFactory.getSAXParserFactory(factory);
                secureFactory.newSAXParser();
                factory = secureFactory;
            } catch (ParserConfigurationException e) {
            }
            factory.setNamespaceAware(true);
            return factory;
        } catch (SAXException e2) {
            throw new IllegalStateException("Failed to create a SAX parser factory", e2);
        }
    }

    public SaxEventSource(Reader reader) {
        Preconditions.checkNotNull(reader, "reader");
        this.reader = reader;
    }

    public void parse(DefaultHandler handler) throws IOException, SAXException {
        ParserAdapter pa = new ParserAdapter(createSaxParser().getParser());
        pa.setContentHandler(handler);
        pa.parse(new InputSource(this.reader));
    }

    private SAXParser createSaxParser() {
        try {
            return parserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("Invalid parser configuration", e);
        } catch (SAXException e2) {
            throw new IllegalStateException("Failed to create a SAX parser", e2);
        }
    }
}
