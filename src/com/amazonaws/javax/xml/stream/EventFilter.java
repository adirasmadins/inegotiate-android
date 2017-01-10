package com.amazonaws.javax.xml.stream;

import com.amazonaws.javax.xml.stream.events.XMLEvent;

public interface EventFilter {
    boolean accept(XMLEvent xMLEvent);
}
