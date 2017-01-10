package com.google.gdata.util;

import java.io.IOException;
import java.net.HttpURLConnection;

public class InvalidEntryException extends ServiceException {
    public InvalidEntryException(String message) {
        super(message);
        initResponseCode();
    }

    public InvalidEntryException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public InvalidEntryException(Throwable cause) {
        super(cause.getMessage(), cause);
        initResponseCode();
    }

    public InvalidEntryException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public InvalidEntryException(ErrorContent errorCode) {
        super(errorCode);
        initResponseCode();
    }

    public InvalidEntryException(ErrorContent errorCode, Throwable cause) {
        super(errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(400);
    }
}
