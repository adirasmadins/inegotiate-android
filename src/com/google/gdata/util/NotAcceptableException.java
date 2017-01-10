package com.google.gdata.util;

import com.google.gdata.util.ErrorDomain.ErrorCode;
import java.io.IOException;
import java.net.HttpURLConnection;

public class NotAcceptableException extends ServiceException {
    public NotAcceptableException() {
        super("Not Acceptable");
        initResponseCode();
    }

    public NotAcceptableException(String message) {
        super(message);
        initResponseCode();
    }

    public NotAcceptableException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public NotAcceptableException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
        initResponseCode();
    }

    public NotAcceptableException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(406);
    }
}
