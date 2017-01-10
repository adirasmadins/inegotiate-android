package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.namespace.NamespaceContext;
import com.amazonaws.javax.xml.namespace.QName;
import com.amazonaws.javax.xml.stream.events.Attribute;
import com.amazonaws.javax.xml.stream.events.Characters;
import com.amazonaws.javax.xml.stream.events.Comment;
import com.amazonaws.javax.xml.stream.events.DTD;
import com.amazonaws.javax.xml.stream.events.EndDocument;
import com.amazonaws.javax.xml.stream.events.EndElement;
import com.amazonaws.javax.xml.stream.events.EntityDeclaration;
import com.amazonaws.javax.xml.stream.events.EntityReference;
import com.amazonaws.javax.xml.stream.events.Namespace;
import com.amazonaws.javax.xml.stream.events.ProcessingInstruction;
import com.amazonaws.javax.xml.stream.events.StartDocument;
import com.amazonaws.javax.xml.stream.events.StartElement;
import java.util.Iterator;

public abstract class XMLEventFactory {
    public abstract Attribute createAttribute(QName qName, String str);

    public abstract Attribute createAttribute(String str, String str2);

    public abstract Attribute createAttribute(String str, String str2, String str3, String str4);

    public abstract Characters createCData(String str);

    public abstract Characters createCharacters(String str);

    public abstract Comment createComment(String str);

    public abstract DTD createDTD(String str);

    public abstract EndDocument createEndDocument();

    public abstract EndElement createEndElement(QName qName, Iterator it);

    public abstract EndElement createEndElement(String str, String str2, String str3);

    public abstract EndElement createEndElement(String str, String str2, String str3, Iterator it);

    public abstract EntityReference createEntityReference(String str, EntityDeclaration entityDeclaration);

    public abstract Characters createIgnorableSpace(String str);

    public abstract Namespace createNamespace(String str);

    public abstract Namespace createNamespace(String str, String str2);

    public abstract ProcessingInstruction createProcessingInstruction(String str, String str2);

    public abstract Characters createSpace(String str);

    public abstract StartDocument createStartDocument();

    public abstract StartDocument createStartDocument(String str);

    public abstract StartDocument createStartDocument(String str, String str2);

    public abstract StartDocument createStartDocument(String str, String str2, boolean z);

    public abstract StartElement createStartElement(QName qName, Iterator it, Iterator it2);

    public abstract StartElement createStartElement(String str, String str2, String str3);

    public abstract StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2);

    public abstract StartElement createStartElement(String str, String str2, String str3, Iterator it, Iterator it2, NamespaceContext namespaceContext);

    public abstract void setLocation(Location location);

    protected XMLEventFactory() {
    }

    public static XMLEventFactory newInstance() throws FactoryConfigurationError {
        return (XMLEventFactory) FactoryFinder.find("com.amazonaws.javax.xml.stream.XMLEventFactory", "com.sun.xml.internal.stream.events.XMLEventFactoryImpl");
    }

    public static XMLEventFactory newFactory() throws FactoryConfigurationError {
        return (XMLEventFactory) FactoryFinder.find("com.amazonaws.javax.xml.stream.XMLEventFactory", "com.sun.xml.internal.stream.events.XMLEventFactoryImpl");
    }

    public static XMLEventFactory newInstance(String factoryId, ClassLoader classLoader) throws FactoryConfigurationError {
        try {
            return (XMLEventFactory) FactoryFinder.newInstance(factoryId, classLoader, false);
        } catch (ConfigurationError e) {
            throw new FactoryConfigurationError(e.getException(), e.getMessage());
        }
    }

    public static XMLEventFactory newFactory(String factoryId, ClassLoader classLoader) throws FactoryConfigurationError {
        try {
            return (XMLEventFactory) FactoryFinder.newInstance(factoryId, classLoader, false);
        } catch (ConfigurationError e) {
            throw new FactoryConfigurationError(e.getException(), e.getMessage());
        }
    }
}
