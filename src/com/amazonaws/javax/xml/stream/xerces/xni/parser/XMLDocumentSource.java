package com.amazonaws.javax.xml.stream.xerces.xni.parser;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLDocumentHandler;

public interface XMLDocumentSource {
    XMLDocumentHandler getDocumentHandler();

    void setDocumentHandler(XMLDocumentHandler xMLDocumentHandler);
}
