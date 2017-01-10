package com.amazonaws.javax.xml.stream.xerces.xni.parser;

import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;

public class XMLConfigurationException extends XNIException {
    public static final short NOT_RECOGNIZED = (short) 0;
    public static final short NOT_SUPPORTED = (short) 1;
    protected String fIdentifier;
    protected short fType;

    public XMLConfigurationException(short type, String identifier) {
        super(identifier);
        this.fType = type;
        this.fIdentifier = identifier;
    }

    public XMLConfigurationException(short type, String identifier, String message) {
        super(message);
        this.fType = type;
        this.fIdentifier = identifier;
    }

    public short getType() {
        return this.fType;
    }

    public String getIdentifier() {
        return this.fIdentifier;
    }
}
