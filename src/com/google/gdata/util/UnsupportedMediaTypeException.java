package com.google.gdata.util;

import com.google.gdata.util.ErrorDomain.ErrorCode;
import java.io.IOException;
import java.net.HttpURLConnection;

public class UnsupportedMediaTypeException extends ServiceException {
    public UnsupportedMediaTypeException(String message) {
        super(message);
        initResponseCode();
    }

    public UnsupportedMediaTypeException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public UnsupportedMediaTypeException(Throwable cause) {
        super(cause);
        initResponseCode();
    }

    public UnsupportedMediaTypeException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public UnsupportedMediaTypeException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
        initResponseCode();
    }

    public UnsupportedMediaTypeException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(415);
    }
}
