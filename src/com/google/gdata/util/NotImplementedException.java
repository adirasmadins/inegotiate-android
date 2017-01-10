package com.google.gdata.util;

import com.google.gdata.util.ErrorDomain.ErrorCode;
import java.io.IOException;
import java.net.HttpURLConnection;

public class NotImplementedException extends ServiceException {
    public NotImplementedException(String message) {
        super(message);
        initResponseCode();
    }

    public NotImplementedException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public NotImplementedException(Throwable cause) {
        super(cause);
        initResponseCode();
    }

    public NotImplementedException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public NotImplementedException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
        initResponseCode();
    }

    public NotImplementedException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(501);
    }
}
