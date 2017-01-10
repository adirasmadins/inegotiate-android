package com.google.gdata.util;

public class ParseException extends ServiceException {
    public ParseException(String message) {
        super(message);
        initResponseCode();
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public ParseException(Throwable cause) {
        super(cause);
        initResponseCode();
    }

    public ParseException(ErrorContent errorCode) {
        super(errorCode);
        initResponseCode();
    }

    public ParseException(ErrorContent errorCode, Throwable cause) {
        super(errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(400);
    }
}
