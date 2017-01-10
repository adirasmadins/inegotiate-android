package com.amazonaws.javax.xml.stream.xerces.xni;

public interface XMLLocator extends XMLResourceIdentifier {
    int getCharacterOffset();

    int getColumnNumber();

    String getEncoding();

    int getLineNumber();
}
