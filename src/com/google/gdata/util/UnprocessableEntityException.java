package com.google.gdata.util;

import com.google.gdata.client.GDataProtocol.Error;
import java.io.IOException;
import java.net.HttpURLConnection;

public class UnprocessableEntityException extends ServiceException {
    public UnprocessableEntityException(String message) {
        super(message);
        initResponseCode();
    }

    public UnprocessableEntityException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public UnprocessableEntityException(Throwable cause) {
        super(cause);
        initResponseCode();
    }

    public UnprocessableEntityException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public UnprocessableEntityException(ErrorContent errorCode) {
        super(errorCode);
        initResponseCode();
    }

    public UnprocessableEntityException(ErrorContent errorCode, Throwable cause) {
        super(errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(Error.UNPROCESSABLE_ENTITY);
    }
}
