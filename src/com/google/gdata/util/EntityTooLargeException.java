package com.google.gdata.util;

import java.io.IOException;
import java.net.HttpURLConnection;

public class EntityTooLargeException extends ServiceException {
    public EntityTooLargeException(String message) {
        super(message);
        initResponseCode();
    }

    public EntityTooLargeException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public EntityTooLargeException(Throwable cause) {
        super(cause);
        initResponseCode();
    }

    public EntityTooLargeException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public EntityTooLargeException(ErrorContent errorCode) {
        super(errorCode);
        initResponseCode();
    }

    public EntityTooLargeException(ErrorContent errorCode, Throwable cause) {
        super(errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(413);
    }
}
