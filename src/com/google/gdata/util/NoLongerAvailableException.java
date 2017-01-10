package com.google.gdata.util;

import com.google.gdata.util.ErrorDomain.ErrorCode;
import java.io.IOException;
import java.net.HttpURLConnection;

public class NoLongerAvailableException extends ServiceException {
    public NoLongerAvailableException() {
        super("No longer available");
        initResponseCode();
    }

    public NoLongerAvailableException(String message) {
        super(message);
        initResponseCode();
    }

    public NoLongerAvailableException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public NoLongerAvailableException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public NoLongerAvailableException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
        initResponseCode();
    }

    public NoLongerAvailableException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(410);
    }
}
