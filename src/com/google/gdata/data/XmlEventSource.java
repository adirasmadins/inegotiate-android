package com.google.gdata.data;

import java.io.IOException;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public interface XmlEventSource {
    void parse(DefaultHandler defaultHandler) throws SAXException, IOException;
}
