package com.google.gdata.wireformats;

import com.google.gdata.util.ServiceException;

public class ContentModelException extends ServiceException {
    public ContentModelException(String message) {
        super(message);
    }

    public ContentModelException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContentModelException(Throwable cause) {
        super(cause);
    }
}
