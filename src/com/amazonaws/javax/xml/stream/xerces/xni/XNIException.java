package com.amazonaws.javax.xml.stream.xerces.xni;

public class XNIException extends RuntimeException {
    private Exception fException;

    public XNIException(String message) {
        super(message);
    }

    public XNIException(Exception exception) {
        super(exception.getMessage());
        this.fException = exception;
    }

    public XNIException(String message, Exception exception) {
        super(message);
        this.fException = exception;
    }

    public Exception getException() {
        return this.fException;
    }
}
