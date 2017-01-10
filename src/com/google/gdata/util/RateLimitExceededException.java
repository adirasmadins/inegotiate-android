package com.google.gdata.util;

import com.google.gdata.client.CoreErrorDomain;
import java.io.IOException;
import java.net.HttpURLConnection;

public class RateLimitExceededException extends ServiceException {
    public RateLimitExceededException() {
        this(CoreErrorDomain.ERR.rateLimitExceeded);
    }

    public RateLimitExceededException(String message) {
        this(CoreErrorDomain.ERR.rateLimitExceeded.withExtendedHelp(message));
    }

    public RateLimitExceededException(String message, Throwable cause) {
        this(CoreErrorDomain.ERR.rateLimitExceeded.withExtendedHelp(message), cause);
    }

    public RateLimitExceededException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public RateLimitExceededException(Throwable cause) {
        this(CoreErrorDomain.ERR.rateLimitExceeded, cause);
    }

    public RateLimitExceededException(ErrorContent errorCode) {
        super(errorCode);
        initResponseCode();
    }

    public RateLimitExceededException(ErrorContent errorCode, Throwable cause) {
        super(errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(403);
    }
}
