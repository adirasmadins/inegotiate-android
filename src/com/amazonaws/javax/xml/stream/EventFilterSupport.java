package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.javax.xml.stream.util.EventReaderDelegate;
import java.util.NoSuchElementException;

public class EventFilterSupport extends EventReaderDelegate {
    EventFilter fEventFilter;

    public EventFilterSupport(XMLEventReader eventReader, EventFilter eventFilter) {
        setParent(eventReader);
        this.fEventFilter = eventFilter;
    }

    public Object next() {
        try {
            return nextEvent();
        } catch (XMLStreamException e) {
            throw new NoSuchElementException();
        }
    }

    public boolean hasNext() {
        try {
            return peek() != null;
        } catch (XMLStreamException e) {
            return false;
        }
    }

    public XMLEvent nextEvent() throws XMLStreamException {
        if (super.hasNext()) {
            XMLEvent event = super.nextEvent();
            return this.fEventFilter.accept(event) ? event : nextEvent();
        } else {
            throw new NoSuchElementException();
        }
    }

    public XMLEvent nextTag() throws XMLStreamException {
        if (super.hasNext()) {
            XMLEvent event = super.nextTag();
            return this.fEventFilter.accept(event) ? event : nextTag();
        } else {
            throw new NoSuchElementException();
        }
    }

    public XMLEvent peek() throws XMLStreamException {
        XMLEvent event = super.peek();
        if (event == null) {
            return null;
        }
        if (this.fEventFilter.accept(event)) {
            return event;
        }
        super.next();
        return peek();
    }
}
