package com.google.gdata.util.common.xml.parsing;

import com.amazonaws.javax.xml.XMLConstants;
import com.google.gdata.util.common.base.StringUtil;
import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

public class SecureGenericXMLFactory {
    private static final SecureEntityResolver NOOP_RESOLVER;

    protected static class SecureDocumentBuilderFactory extends DocumentBuilderFactory {
        private DocumentBuilderFactory factory;

        protected SecureDocumentBuilderFactory(DocumentBuilderFactory factory) {
            this.factory = factory;
            factory.setValidating(false);
            try {
                factory.setXIncludeAware(false);
            } catch (UnsupportedOperationException e) {
            } catch (NoSuchMethodError e2) {
            }
            try {
                factory.setAttribute("http://xml.org/sax/features/external-general-entities", Boolean.valueOf(false));
            } catch (IllegalArgumentException e3) {
            }
            try {
                factory.setAttribute("http://xml.org/sax/features/external-parameter-entities", Boolean.valueOf(false));
            } catch (IllegalArgumentException e4) {
            }
            try {
                factory.setAttribute("http://apache.org/xml/features/nonvalidating/load-external-dtd", Boolean.valueOf(false));
            } catch (IllegalArgumentException e5) {
            }
            try {
                factory.setAttribute(XMLConstants.FEATURE_SECURE_PROCESSING, Boolean.TRUE);
            } catch (IllegalArgumentException e6) {
            }
        }

        public DocumentBuilder newDocumentBuilder() throws ParserConfigurationException {
            DocumentBuilder docBuilder = this.factory.newDocumentBuilder();
            docBuilder.setEntityResolver(SecureGenericXMLFactory.NOOP_RESOLVER);
            return docBuilder;
        }

        public void setNamespaceAware(boolean awareness) {
            this.factory.setNamespaceAware(awareness);
        }

        public void setValidating(boolean validating) {
            this.factory.setValidating(validating);
        }

        public void setIgnoringElementContentWhitespace(boolean whitespace) {
            this.factory.setIgnoringElementContentWhitespace(whitespace);
        }

        public void setExpandEntityReferences(boolean expandEntityRef) {
            this.factory.setExpandEntityReferences(expandEntityRef);
        }

        public void setIgnoringComments(boolean ignoreComments) {
            this.factory.setIgnoringComments(ignoreComments);
        }

        public void setCoalescing(boolean coalescing) {
            this.factory.setCoalescing(coalescing);
        }

        public boolean isNamespaceAware() {
            return this.factory.isNamespaceAware();
        }

        public boolean isValidating() {
            return this.factory.isValidating();
        }

        public boolean isIgnoringElementContentWhitespace() {
            return this.factory.isIgnoringElementContentWhitespace();
        }

        public boolean isExpandEntityReferences() {
            return this.factory.isExpandEntityReferences();
        }

        public boolean isIgnoringComments() {
            return this.factory.isIgnoringComments();
        }

        public boolean isCoalescing() {
            return this.factory.isCoalescing();
        }

        public void setAttribute(String name, Object value) throws IllegalArgumentException {
            this.factory.setAttribute(name, value);
        }

        public Object getAttribute(String name) throws IllegalArgumentException {
            return this.factory.getAttribute(name);
        }

        public void setFeature(String name, boolean value) throws ParserConfigurationException {
            this.factory.setFeature(name, value);
        }

        public boolean getFeature(String name) throws ParserConfigurationException {
            return this.factory.getFeature(name);
        }

        public Schema getSchema() throws UnsupportedOperationException {
            return this.factory.getSchema();
        }

        public void setSchema(Schema schema) throws UnsupportedOperationException {
            this.factory.setSchema(schema);
        }

        public void setXIncludeAware(boolean state) throws UnsupportedOperationException {
            this.factory.setXIncludeAware(state);
        }

        public boolean isIncludeAware() throws UnsupportedOperationException {
            return this.factory.isXIncludeAware();
        }
    }

    private static final class SecureEntityResolver implements EntityResolver {
        private SecureEntityResolver() {
        }

        public InputSource resolveEntity(String publicId, String systemId) {
            return new InputSource(new StringReader(StringUtil.EMPTY_STRING));
        }
    }

    protected static class SecureSAXParserFactory extends SAXParserFactory {
        private SAXParserFactory factory;

        protected SecureSAXParserFactory(SAXParserFactory factory) throws ParserConfigurationException, SAXException {
            this.factory = factory;
            factory.setValidating(false);
            try {
                factory.setXIncludeAware(false);
            } catch (UnsupportedOperationException e) {
            } catch (NoSuchMethodError e2) {
            }
            try {
                factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            } catch (IllegalArgumentException e3) {
            } catch (SAXNotRecognizedException e4) {
            }
            try {
                factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            } catch (IllegalArgumentException e5) {
            } catch (SAXNotRecognizedException e6) {
            }
            try {
                factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            } catch (IllegalArgumentException e7) {
            } catch (SAXNotRecognizedException e8) {
            }
            try {
                factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            } catch (IllegalArgumentException e9) {
            } catch (SAXNotRecognizedException e10) {
            }
        }

        public SAXParser newSAXParser() throws ParserConfigurationException, SAXException {
            SAXParser parser = this.factory.newSAXParser();
            parser.getXMLReader().setEntityResolver(SecureGenericXMLFactory.NOOP_RESOLVER);
            return parser;
        }

        public void setNamespaceAware(boolean awareness) {
            this.factory.setNamespaceAware(awareness);
        }

        public void setValidating(boolean validating) {
            this.factory.setValidating(validating);
        }

        public boolean isNamespaceAware() {
            return this.factory.isNamespaceAware();
        }

        public boolean isValidating() {
            return this.factory.isValidating();
        }

        public void setFeature(String name, boolean value) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
            this.factory.setFeature(name, value);
        }

        public boolean getFeature(String name) throws ParserConfigurationException, SAXNotRecognizedException, SAXNotSupportedException {
            return this.factory.getFeature(name);
        }

        public Schema getSchema() throws UnsupportedOperationException {
            return this.factory.getSchema();
        }

        public void setSchema(Schema schema) throws UnsupportedOperationException {
            this.factory.setSchema(schema);
        }

        public void setXIncludeAware(boolean state) throws UnsupportedOperationException {
            this.factory.setXIncludeAware(state);
        }

        public boolean isXIncludeAware() throws UnsupportedOperationException {
            return this.factory.isXIncludeAware();
        }
    }

    static {
        NOOP_RESOLVER = new SecureEntityResolver();
    }

    protected SecureGenericXMLFactory() {
    }

    public static SAXParserFactory getSAXParserFactory(SAXParserFactory factory) throws ParserConfigurationException, SAXException {
        return new SecureSAXParserFactory(factory);
    }

    public static DocumentBuilderFactory getDocumentBuilderFactory(DocumentBuilderFactory factory) {
        return new SecureDocumentBuilderFactory(factory);
    }
}
