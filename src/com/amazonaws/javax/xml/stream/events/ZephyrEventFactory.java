package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.NamespaceContext;
import com.amazonaws.javax.xml.namespace.QName;
import com.amazonaws.javax.xml.stream.Location;
import com.amazonaws.javax.xml.stream.XMLEventFactory;
import java.util.Iterator;

public class ZephyrEventFactory extends XMLEventFactory {
    Location location;

    public ZephyrEventFactory() {
        this.location = null;
    }

    public Attribute createAttribute(String localName, String value) {
        AttributeImpl attr = new AttributeImpl(localName, value);
        if (this.location != null) {
            attr.setLocation(this.location);
        }
        return attr;
    }

    public Attribute createAttribute(QName name, String value) {
        return createAttribute(name.getPrefix(), name.getNamespaceURI(), name.getLocalPart(), value);
    }

    public Attribute createAttribute(String prefix, String namespaceURI, String localName, String value) {
        AttributeImpl attr = new AttributeImpl(prefix, namespaceURI, localName, value, null);
        if (this.location != null) {
            attr.setLocation(this.location);
        }
        return attr;
    }

    public Characters createCData(String content) {
        CharacterEvent charEvent = new CharacterEvent(content, true);
        if (this.location != null) {
            charEvent.setLocation(this.location);
        }
        return charEvent;
    }

    public Characters createCharacters(String content) {
        CharacterEvent charEvent = new CharacterEvent(content);
        if (this.location != null) {
            charEvent.setLocation(this.location);
        }
        return charEvent;
    }

    public Comment createComment(String text) {
        CommentEvent charEvent = new CommentEvent(text);
        if (this.location != null) {
            charEvent.setLocation(this.location);
        }
        return charEvent;
    }

    public DTD createDTD(String dtd) {
        DTDEvent dtdEvent = new DTDEvent(dtd);
        if (this.location != null) {
            dtdEvent.setLocation(this.location);
        }
        return dtdEvent;
    }

    public EndDocument createEndDocument() {
        EndDocumentEvent event = new EndDocumentEvent();
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public EndElement createEndElement(QName name, Iterator namespaces) {
        return createEndElement(name.getPrefix(), name.getNamespaceURI(), name.getLocalPart());
    }

    public EndElement createEndElement(String prefix, String namespaceUri, String localName) {
        EndElementEvent event = new EndElementEvent(prefix, namespaceUri, localName);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public EndElement createEndElement(String prefix, String namespaceUri, String localName, Iterator namespaces) {
        EndElementEvent event = new EndElementEvent(prefix, namespaceUri, localName);
        if (namespaces != null) {
            while (namespaces.hasNext()) {
                event.addNamespace((Namespace) namespaces.next());
            }
        }
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public EntityReference createEntityReference(String name, EntityDeclaration entityDeclaration) {
        EntityReferenceEvent event = new EntityReferenceEvent(name, entityDeclaration);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public Characters createIgnorableSpace(String content) {
        CharacterEvent event = new CharacterEvent(content, false, true);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public Namespace createNamespace(String namespaceURI) {
        NamespaceImpl event = new NamespaceImpl(namespaceURI);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public Namespace createNamespace(String prefix, String namespaceURI) {
        NamespaceImpl event = new NamespaceImpl(prefix, namespaceURI);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public ProcessingInstruction createProcessingInstruction(String target, String data) {
        ProcessingInstructionEvent event = new ProcessingInstructionEvent(target, data);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public Characters createSpace(String content) {
        CharacterEvent event = new CharacterEvent(content);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public StartDocument createStartDocument() {
        StartDocumentEvent event = new StartDocumentEvent();
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public StartDocument createStartDocument(String encoding) {
        StartDocumentEvent event = new StartDocumentEvent(encoding);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public StartDocument createStartDocument(String encoding, String version) {
        StartDocumentEvent event = new StartDocumentEvent(encoding, version);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public StartDocument createStartDocument(String encoding, String version, boolean standalone) {
        StartDocumentEvent event = new StartDocumentEvent(encoding, version, standalone);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public StartElement createStartElement(QName name, Iterator attributes, Iterator namespaces) {
        return createStartElement(name.getPrefix(), name.getNamespaceURI(), name.getLocalPart(), attributes, namespaces);
    }

    public StartElement createStartElement(String prefix, String namespaceUri, String localName) {
        StartElementEvent event = new StartElementEvent(prefix, namespaceUri, localName);
        if (this.location != null) {
            event.setLocation(this.location);
        }
        return event;
    }

    public StartElement createStartElement(String prefix, String namespaceUri, String localName, Iterator attributes, Iterator namespaces) {
        return createStartElement(prefix, namespaceUri, localName, attributes, namespaces, null);
    }

    public StartElement createStartElement(String prefix, String namespaceUri, String localName, Iterator attributes, Iterator namespaces, NamespaceContext context) {
        StartElementEvent elem = new StartElementEvent(prefix, namespaceUri, localName);
        elem.addAttributes(attributes);
        elem.addNamespaceAttributes(namespaces);
        elem.setNamespaceContext(context);
        if (this.location != null) {
            elem.setLocation(this.location);
        }
        return elem;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
