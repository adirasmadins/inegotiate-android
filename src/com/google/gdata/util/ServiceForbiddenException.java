package com.google.gdata.util;

import com.google.gdata.util.ErrorDomain.ErrorCode;
import java.io.IOException;
import java.net.HttpURLConnection;

public class ServiceForbiddenException extends ServiceException {
    public ServiceForbiddenException(String message) {
        super(message);
        initResponseCode();
    }

    public ServiceForbiddenException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public ServiceForbiddenException(Throwable cause) {
        super(cause);
        initResponseCode();
    }

    public ServiceForbiddenException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public ServiceForbiddenException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
        initResponseCode();
    }

    public ServiceForbiddenException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(403);
    }
}
