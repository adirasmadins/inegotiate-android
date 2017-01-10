package com.google.gdata.wireformats;

import com.google.gdata.util.ErrorContent;
import com.google.gdata.util.ServiceException;

public class ContentCreationException extends ServiceException {
    public ContentCreationException(String message) {
        super(message);
    }

    public ContentCreationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContentCreationException(Throwable cause) {
        super(cause);
    }

    public ContentCreationException(ErrorContent errorCode) {
        super(errorCode);
    }

    public ContentCreationException(ErrorContent errorCode, Throwable cause) {
        super(errorCode, cause);
    }
}
