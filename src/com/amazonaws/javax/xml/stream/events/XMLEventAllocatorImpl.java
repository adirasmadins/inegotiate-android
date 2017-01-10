package com.amazonaws.javax.xml.stream.events;

import com.amazonaws.javax.xml.namespace.QName;
import com.amazonaws.javax.xml.stream.PropertyManager;
import com.amazonaws.javax.xml.stream.XMLInputFactory;
import com.amazonaws.javax.xml.stream.XMLStreamException;
import com.amazonaws.javax.xml.stream.XMLStreamException2;
import com.amazonaws.javax.xml.stream.XMLStreamReader;
import com.amazonaws.javax.xml.stream.util.XMLEventAllocator;
import com.amazonaws.javax.xml.stream.util.XMLEventConsumer;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceContextWrapper;
import com.amazonaws.javax.xml.stream.xerces.util.NamespaceSupport;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import java.util.List;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;

public class XMLEventAllocatorImpl implements XMLEventAllocator {
    public XMLEvent allocate(XMLStreamReader xMLStreamReader) throws XMLStreamException {
        if (xMLStreamReader != null) {
            return getXMLEvent(xMLStreamReader);
        }
        throw new XMLStreamException2("Reader cannot be null");
    }

    public void allocate(XMLStreamReader xMLStreamReader, XMLEventConsumer xMLEventConsumer) throws XMLStreamException {
        XMLEvent currentEvent = getXMLEvent(xMLStreamReader);
        if (currentEvent != null) {
            xMLEventConsumer.add(currentEvent);
        }
    }

    public XMLEventAllocator newInstance() {
        return new XMLEventAllocatorImpl();
    }

    XMLEvent getXMLEvent(XMLStreamReader streamReader) {
        CharacterEvent cDataEvent;
        switch (streamReader.getEventType()) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                StartElementEvent startElementEvent = new StartElementEvent(getQName(streamReader));
                fillAttributes(startElementEvent, streamReader);
                if (((Boolean) streamReader.getProperty(XMLInputFactory.IS_NAMESPACE_AWARE)).booleanValue()) {
                    fillNamespaceAttributes(startElementEvent, streamReader);
                    setNamespaceContext(startElementEvent, streamReader);
                }
                startElementEvent.setLocation(streamReader.getLocation());
                return startElementEvent;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                EndElementEvent endElementEvent = new EndElementEvent(getQName(streamReader));
                endElementEvent.setLocation(streamReader.getLocation());
                if (((Boolean) streamReader.getProperty(XMLInputFactory.IS_NAMESPACE_AWARE)).booleanValue()) {
                    fillNamespaceAttributes(endElementEvent, streamReader);
                }
                return endElementEvent;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                ProcessingInstructionEvent piEvent = new ProcessingInstructionEvent(streamReader.getPITarget(), streamReader.getPIData());
                piEvent.setLocation(streamReader.getLocation());
                return piEvent;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                cDataEvent = new CharacterEvent(streamReader.getText());
                cDataEvent.setLocation(streamReader.getLocation());
                return cDataEvent;
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                CommentEvent commentEvent = new CommentEvent(streamReader.getText());
                commentEvent.setLocation(streamReader.getLocation());
                return commentEvent;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                CharacterEvent spaceEvent = new CharacterEvent(streamReader.getText(), false, true);
                spaceEvent.setLocation(streamReader.getLocation());
                return spaceEvent;
            case SimpleLog.LOG_LEVEL_OFF /*7*/:
                StartDocumentEvent sdEvent = new StartDocumentEvent();
                sdEvent.setVersion(streamReader.getVersion());
                sdEvent.setEncoding(streamReader.getEncoding());
                if (streamReader.getCharacterEncodingScheme() != null) {
                    sdEvent.setDeclaredEncoding(true);
                } else {
                    sdEvent.setDeclaredEncoding(false);
                }
                sdEvent.setStandalone(streamReader.isStandalone());
                sdEvent.setLocation(streamReader.getLocation());
                return sdEvent;
            case PayPalActivity.VIEW_TEST /*8*/:
                EndDocumentEvent endDocumentEvent = new EndDocumentEvent();
                endDocumentEvent.setLocation(streamReader.getLocation());
                return endDocumentEvent;
            case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                EntityReferenceEvent entityEvent = new EntityReferenceEvent(streamReader.getLocalName(), new EntityDeclarationImpl(streamReader.getLocalName(), streamReader.getText()));
                entityEvent.setLocation(streamReader.getLocation());
                return entityEvent;
            case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                return null;
            case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                DTDEvent dtdEvent = new DTDEvent(streamReader.getText());
                dtdEvent.setLocation(streamReader.getLocation());
                List entities = (List) streamReader.getProperty(PropertyManager.STAX_ENTITIES);
                if (!(entities == null || entities.size() == 0)) {
                    dtdEvent.setEntities(entities);
                }
                List notations = (List) streamReader.getProperty(PropertyManager.STAX_NOTATIONS);
                if (!(notations == null || notations.size() == 0)) {
                    dtdEvent.setNotations(notations);
                }
                return dtdEvent;
            case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                cDataEvent = new CharacterEvent(streamReader.getText(), true);
                cDataEvent.setLocation(streamReader.getLocation());
                return cDataEvent;
            default:
                return null;
        }
    }

    protected XMLEvent getNextEvent(XMLStreamReader streamReader) throws XMLStreamException {
        streamReader.next();
        return getXMLEvent(streamReader);
    }

    protected void fillAttributes(StartElementEvent event, XMLStreamReader xmlr) {
        int len = xmlr.getAttributeCount();
        for (int i = 0; i < len; i++) {
            QName qname = xmlr.getAttributeName(i);
            String prefix = qname.getPrefix();
            String localpart = qname.getLocalPart();
            AttributeImpl attr = new AttributeImpl();
            attr.setName(qname);
            attr.setAttributeType(xmlr.getAttributeType(i));
            attr.setSpecified(xmlr.isAttributeSpecified(i));
            attr.setValue(xmlr.getAttributeValue(i));
            event.addAttribute(attr);
        }
    }

    protected void fillNamespaceAttributes(StartElementEvent event, XMLStreamReader xmlr) {
        int count = xmlr.getNamespaceCount();
        for (int i = 0; i < count; i++) {
            String uri = xmlr.getNamespaceURI(i);
            String prefix = xmlr.getNamespacePrefix(i);
            if (prefix == null) {
                prefix = StringUtil.EMPTY_STRING;
            }
            event.addNamespaceAttribute(new NamespaceImpl(prefix, uri));
        }
    }

    protected void fillNamespaceAttributes(EndElementEvent event, XMLStreamReader xmlr) {
        int count = xmlr.getNamespaceCount();
        for (int i = 0; i < count; i++) {
            String uri = xmlr.getNamespaceURI(i);
            String prefix = xmlr.getNamespacePrefix(i);
            if (prefix == null) {
                prefix = StringUtil.EMPTY_STRING;
            }
            event.addNamespace(new NamespaceImpl(prefix, uri));
        }
    }

    private void setNamespaceContext(StartElementEvent event, XMLStreamReader xmlr) {
        event.setNamespaceContext(new NamespaceContextWrapper(new NamespaceSupport(((NamespaceContextWrapper) xmlr.getNamespaceContext()).getNamespaceContext())));
    }

    private QName getQName(XMLStreamReader xmlr) {
        return new QName(xmlr.getNamespaceURI(), xmlr.getLocalName(), xmlr.getPrefix());
    }
}
