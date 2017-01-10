package com.google.gdata.util;

import com.google.gdata.util.ErrorDomain.ErrorCode;
import java.io.IOException;
import java.net.HttpURLConnection;

public class ServiceUnavailableException extends ServiceException {
    private int retryTime;

    public ServiceUnavailableException(String message) {
        super(message);
        this.retryTime = -1;
        initResponseCode();
    }

    public ServiceUnavailableException(String message, Throwable cause) {
        super(message, cause);
        this.retryTime = -1;
        initResponseCode();
    }

    public ServiceUnavailableException(Throwable cause) {
        super(cause.getMessage(), cause);
        this.retryTime = -1;
        initResponseCode();
    }

    public ServiceUnavailableException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        this.retryTime = -1;
        initResponseCode();
    }

    public ServiceUnavailableException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
        this.retryTime = -1;
        initResponseCode();
    }

    public ServiceUnavailableException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode, cause);
        this.retryTime = -1;
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(503);
    }

    public int getRetryTime() {
        return this.retryTime;
    }

    public void setRetryTime(int retryTime) {
        this.retryTime = retryTime;
    }
}
