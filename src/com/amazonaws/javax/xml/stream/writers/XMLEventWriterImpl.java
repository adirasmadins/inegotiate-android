package com.amazonaws.javax.xml.stream.writers;

import com.amazonaws.javax.xml.namespace.NamespaceContext;
import com.amazonaws.javax.xml.namespace.QName;
import com.amazonaws.javax.xml.stream.XMLEventReader;
import com.amazonaws.javax.xml.stream.XMLEventWriter;
import com.amazonaws.javax.xml.stream.XMLStreamException;
import com.amazonaws.javax.xml.stream.XMLStreamException2;
import com.amazonaws.javax.xml.stream.XMLStreamWriter;
import com.amazonaws.javax.xml.stream.events.Attribute;
import com.amazonaws.javax.xml.stream.events.Characters;
import com.amazonaws.javax.xml.stream.events.Comment;
import com.amazonaws.javax.xml.stream.events.DTD;
import com.amazonaws.javax.xml.stream.events.EntityReference;
import com.amazonaws.javax.xml.stream.events.Namespace;
import com.amazonaws.javax.xml.stream.events.ProcessingInstruction;
import com.amazonaws.javax.xml.stream.events.StartDocument;
import com.amazonaws.javax.xml.stream.events.StartElement;
import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import java.util.Iterator;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;

public class XMLEventWriterImpl implements XMLEventWriter {
    private static final boolean DEBUG = false;
    private XMLStreamWriter fStreamWriter;

    public XMLEventWriterImpl(XMLStreamWriter streamWriter) {
        this.fStreamWriter = streamWriter;
    }

    public void add(XMLEventReader xMLEventReader) throws XMLStreamException {
        if (xMLEventReader == null) {
            throw new XMLStreamException2("Event reader shouldn't be null");
        }
        while (xMLEventReader.hasNext()) {
            add(xMLEventReader.nextEvent());
        }
    }

    public void add(XMLEvent xMLEvent) throws XMLStreamException {
        QName qname;
        Namespace namespace;
        Attribute attribute;
        Characters characters;
        switch (xMLEvent.getEventType()) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                StartElement startElement = xMLEvent.asStartElement();
                qname = startElement.getName();
                this.fStreamWriter.writeStartElement(qname.getPrefix(), qname.getLocalPart(), qname.getNamespaceURI());
                Iterator iterator = startElement.getNamespaces();
                while (iterator.hasNext()) {
                    namespace = (Namespace) iterator.next();
                    this.fStreamWriter.writeNamespace(namespace.getPrefix(), namespace.getNamespaceURI());
                }
                Iterator attributes = startElement.getAttributes();
                while (attributes.hasNext()) {
                    attribute = (Attribute) attributes.next();
                    QName aqname = attribute.getName();
                    this.fStreamWriter.writeAttribute(aqname.getPrefix(), aqname.getNamespaceURI(), aqname.getLocalPart(), attribute.getValue());
                }
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                this.fStreamWriter.writeEndElement();
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                ProcessingInstruction processingInstruction = (ProcessingInstruction) xMLEvent;
                this.fStreamWriter.writeProcessingInstruction(processingInstruction.getTarget(), processingInstruction.getData());
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                characters = xMLEvent.asCharacters();
                if (characters.isCData()) {
                    this.fStreamWriter.writeCData(characters.getData());
                    return;
                }
                this.fStreamWriter.writeCharacters(characters.getData());
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                Comment comment = (Comment) xMLEvent;
                this.fStreamWriter.writeComment(comment.getText());
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
                StartDocument startDocument = (StartDocument) xMLEvent;
                try {
                    this.fStreamWriter.writeStartDocument(startDocument.getCharacterEncodingScheme(), startDocument.getVersion());
                } catch (XMLStreamException e) {
                    this.fStreamWriter.writeStartDocument(startDocument.getVersion());
                }
            case PayPalActivity.VIEW_TEST /*8*/:
                this.fStreamWriter.writeEndDocument();
            case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                EntityReference entityReference = (EntityReference) xMLEvent;
                this.fStreamWriter.writeEntityRef(entityReference.getName());
            case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                attribute = (Attribute) xMLEvent;
                qname = attribute.getName();
                this.fStreamWriter.writeAttribute(qname.getPrefix(), qname.getNamespaceURI(), qname.getLocalPart(), attribute.getValue());
            case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                DTD dtd = (DTD) xMLEvent;
                this.fStreamWriter.writeDTD(dtd.getDocumentTypeDeclaration());
            case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                characters = (Characters) xMLEvent;
                if (characters.isCData()) {
                    this.fStreamWriter.writeCData(characters.getData());
                }
            case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                namespace = (Namespace) xMLEvent;
                this.fStreamWriter.writeNamespace(namespace.getPrefix(), namespace.getNamespaceURI());
            default:
        }
    }

    public void close() throws XMLStreamException {
        this.fStreamWriter.close();
    }

    public void flush() throws XMLStreamException {
        this.fStreamWriter.flush();
    }

    public NamespaceContext getNamespaceContext() {
        return this.fStreamWriter.getNamespaceContext();
    }

    public String getPrefix(String namespaceURI) throws XMLStreamException {
        return this.fStreamWriter.getPrefix(namespaceURI);
    }

    public void setDefaultNamespace(String uri) throws XMLStreamException {
        this.fStreamWriter.setDefaultNamespace(uri);
    }

    public void setNamespaceContext(NamespaceContext namespaceContext) throws XMLStreamException {
        this.fStreamWriter.setNamespaceContext(namespaceContext);
    }

    public void setPrefix(String prefix, String uri) throws XMLStreamException {
        this.fStreamWriter.setPrefix(prefix, uri);
    }
}
