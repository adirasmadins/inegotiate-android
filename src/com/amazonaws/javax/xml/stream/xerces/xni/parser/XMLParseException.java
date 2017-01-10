package com.amazonaws.javax.xml.stream.xerces.xni.parser;

import com.amazonaws.javax.xml.stream.xerces.xni.XMLLocator;
import com.amazonaws.javax.xml.stream.xerces.xni.XNIException;

public class XMLParseException extends XNIException {
    protected String fBaseSystemId;
    protected int fColumnNumber;
    protected String fExpandedSystemId;
    protected int fLineNumber;
    protected String fLiteralSystemId;
    protected String fPublicId;

    public XMLParseException(XMLLocator locator, String message) {
        super(message);
        this.fLineNumber = -1;
        this.fColumnNumber = -1;
        if (locator != null) {
            this.fPublicId = locator.getPublicId();
            this.fLiteralSystemId = locator.getLiteralSystemId();
            this.fExpandedSystemId = locator.getExpandedSystemId();
            this.fBaseSystemId = locator.getBaseSystemId();
            this.fLineNumber = locator.getLineNumber();
            this.fColumnNumber = locator.getColumnNumber();
        }
    }

    public XMLParseException(XMLLocator locator, String message, Exception exception) {
        super(message, exception);
        this.fLineNumber = -1;
        this.fColumnNumber = -1;
        this.fPublicId = locator.getPublicId();
        this.fLiteralSystemId = locator.getLiteralSystemId();
        this.fExpandedSystemId = locator.getExpandedSystemId();
        this.fBaseSystemId = locator.getBaseSystemId();
        this.fLineNumber = locator.getLineNumber();
        this.fColumnNumber = locator.getColumnNumber();
    }

    public String getPublicId() {
        return this.fPublicId;
    }

    public String getExpandedSystemId() {
        return this.fExpandedSystemId;
    }

    public String getLiteralSystemId() {
        return this.fLiteralSystemId;
    }

    public String getBaseSystemId() {
        return this.fBaseSystemId;
    }

    public int getLineNumber() {
        return this.fLineNumber;
    }

    public int getColumnNumber() {
        return this.fColumnNumber;
    }

    public String toString() {
        StringBuffer str = new StringBuffer();
        if (this.fPublicId != null) {
            str.append(this.fPublicId);
        }
        str.append(':');
        if (this.fPublicId != null) {
            str.append(this.fPublicId);
        }
        str.append(':');
        if (this.fLiteralSystemId != null) {
            str.append(this.fLiteralSystemId);
        }
        str.append(':');
        if (this.fExpandedSystemId != null) {
            str.append(this.fExpandedSystemId);
        }
        str.append(':');
        if (this.fBaseSystemId != null) {
            str.append(this.fBaseSystemId);
        }
        str.append(':');
        str.append(this.fLineNumber);
        str.append(':');
        str.append(this.fColumnNumber);
        str.append(':');
        String message = getMessage();
        if (message == null) {
            Exception exception = getException();
            if (exception != null) {
                message = exception.getMessage();
            }
        }
        if (message != null) {
            str.append(message);
        }
        return str.toString();
    }
}
