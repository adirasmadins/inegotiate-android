package com.amazonaws.javax.xml.stream.util;

import com.amazonaws.javax.xml.stream.XMLStreamException;
import com.amazonaws.javax.xml.stream.events.XMLEvent;

public interface XMLEventConsumer {
    void add(XMLEvent xMLEvent) throws XMLStreamException;
}
