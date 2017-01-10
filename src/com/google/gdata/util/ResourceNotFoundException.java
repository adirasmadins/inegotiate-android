package com.google.gdata.util;

import com.google.gdata.util.ErrorDomain.ErrorCode;
import java.io.IOException;
import java.net.HttpURLConnection;

public class ResourceNotFoundException extends ServiceException {
    public ResourceNotFoundException(String message) {
        super(message);
        initResponseCode();
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public ResourceNotFoundException(Throwable cause) {
        super(cause);
        initResponseCode();
    }

    public ResourceNotFoundException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public ResourceNotFoundException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
        initResponseCode();
    }

    public ResourceNotFoundException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(404);
    }
}
