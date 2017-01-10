package com.google.gdata.util;

import com.google.gdata.util.ErrorDomain.ErrorCode;
import java.io.IOException;
import java.net.HttpURLConnection;

public class NotModifiedException extends ServiceException {
    public NotModifiedException() {
        super("Not Modified");
        initResponseCode();
    }

    public NotModifiedException(String message) {
        super(message);
        initResponseCode();
    }

    public NotModifiedException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public NotModifiedException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public NotModifiedException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
        initResponseCode();
    }

    public NotModifiedException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(304);
    }
}
