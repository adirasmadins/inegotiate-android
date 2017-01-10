package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.events.EntityReference;
import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.javax.xml.stream.events.XMLEventAllocatorImpl;
import com.amazonaws.javax.xml.stream.util.XMLEventAllocator;
import com.google.gdata.util.common.base.StringUtil;
import java.util.NoSuchElementException;

public class XMLEventReaderImpl implements XMLEventReader {
    private XMLEvent fLastEvent;
    private XMLEvent fPeekedEvent;
    protected XMLEventAllocator fXMLEventAllocator;
    protected XMLStreamReader fXMLReader;

    public XMLEventReaderImpl(XMLStreamReader reader) throws XMLStreamException {
        this.fXMLReader = reader;
        this.fXMLEventAllocator = (XMLEventAllocator) reader.getProperty(XMLInputFactory.ALLOCATOR);
        if (this.fXMLEventAllocator == null) {
            this.fXMLEventAllocator = new XMLEventAllocatorImpl();
        }
        this.fPeekedEvent = this.fXMLEventAllocator.allocate(this.fXMLReader);
    }

    public boolean hasNext() {
        if (this.fPeekedEvent != null) {
            return true;
        }
        try {
            return this.fXMLReader.hasNext();
        } catch (XMLStreamException e) {
            return false;
        }
    }

    public XMLEvent nextEvent() throws XMLStreamException {
        if (this.fPeekedEvent != null) {
            this.fLastEvent = this.fPeekedEvent;
            this.fPeekedEvent = null;
            return this.fLastEvent;
        } else if (this.fXMLReader.hasNext()) {
            this.fXMLReader.next();
            XMLEvent allocate = this.fXMLEventAllocator.allocate(this.fXMLReader);
            this.fLastEvent = allocate;
            return allocate;
        } else {
            this.fLastEvent = null;
            throw new NoSuchElementException();
        }
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public void close() throws XMLStreamException {
        this.fXMLReader.close();
    }

    public String getElementText() throws XMLStreamException {
        if (this.fLastEvent.getEventType() != 1) {
            throw new XMLStreamException2("parser must be on START_ELEMENT to read next text", this.fLastEvent.getLocation());
        }
        String data = null;
        if (this.fPeekedEvent != null) {
            XMLEvent event = this.fPeekedEvent;
            this.fPeekedEvent = null;
            int type = event.getEventType();
            if (type == 4 || type == 6 || type == 12) {
                data = event.asCharacters().getData();
            } else if (type == 9) {
                data = ((EntityReference) event).getDeclaration().getReplacementText();
            } else if (!(type == 5 || type == 3)) {
                if (type == 1) {
                    throw new XMLStreamException2("elementGetText() function expects text only elment but START_ELEMENT was encountered.", event.getLocation());
                } else if (type == 2) {
                    return StringUtil.EMPTY_STRING;
                }
            }
            StringBuffer buffer = new StringBuffer();
            if (data != null && data.length() > 0) {
                buffer.append(data);
            }
            event = nextEvent();
            while (event.getEventType() != 2) {
                if (type == 4 || type == 6 || type == 12) {
                    data = event.asCharacters().getData();
                } else if (type == 9) {
                    data = ((EntityReference) event).getDeclaration().getReplacementText();
                } else if (!(type == 5 || type == 3)) {
                    if (type == 8) {
                        throw new XMLStreamException2("unexpected end of document when reading element text content");
                    } else if (type == 1) {
                        throw new XMLStreamException2("elementGetText() function expects text only elment but START_ELEMENT was encountered.", event.getLocation());
                    } else {
                        throw new XMLStreamException2(new StringBuffer().append("Unexpected event type ").append(type).toString(), event.getLocation());
                    }
                }
                if (data != null && data.length() > 0) {
                    buffer.append(data);
                }
                event = nextEvent();
            }
            return buffer.toString();
        }
        data = this.fXMLReader.getElementText();
        this.fLastEvent = this.fXMLEventAllocator.allocate(this.fXMLReader);
        return data;
    }

    public Object getProperty(String name) throws IllegalArgumentException {
        return this.fXMLReader.getProperty(name);
    }

    public XMLEvent nextTag() throws XMLStreamException {
        XMLEvent event;
        if (this.fPeekedEvent != null) {
            event = this.fPeekedEvent;
            this.fPeekedEvent = null;
            int eventType = event.getEventType();
            if ((event.isCharacters() && event.asCharacters().isWhiteSpace()) || eventType == 3 || eventType == 5 || eventType == 7) {
                event = nextEvent();
                eventType = event.getEventType();
            }
            while (true) {
                if ((!event.isCharacters() || !event.asCharacters().isWhiteSpace()) && eventType != 3 && eventType != 5) {
                    break;
                }
                event = nextEvent();
                eventType = event.getEventType();
            }
            if (eventType == 1 || eventType == 2) {
                return event;
            }
            throw new XMLStreamException2("expected start or end tag", event.getLocation());
        }
        this.fXMLReader.nextTag();
        event = this.fXMLEventAllocator.allocate(this.fXMLReader);
        this.fLastEvent = event;
        return event;
    }

    public Object next() {
        try {
            return nextEvent();
        } catch (XMLStreamException e) {
            this.fLastEvent = null;
            throw new NoSuchElementException();
        }
    }

    public XMLEvent peek() throws XMLStreamException {
        if (this.fPeekedEvent != null) {
            return this.fPeekedEvent;
        }
        if (!hasNext()) {
            return null;
        }
        this.fXMLReader.next();
        this.fPeekedEvent = this.fXMLEventAllocator.allocate(this.fXMLReader);
        return this.fPeekedEvent;
    }
}
