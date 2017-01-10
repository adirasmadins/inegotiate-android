package com.google.gdata.util;

import com.amazonaws.services.s3.internal.Constants;
import com.google.gdata.util.ErrorDomain.ErrorCode;
import java.io.IOException;
import java.net.HttpURLConnection;

public class PreconditionFailedException extends ServiceException {
    public PreconditionFailedException() {
        super("Precondition Failed");
        initResponseCode();
    }

    public PreconditionFailedException(String message) {
        super(message);
        initResponseCode();
    }

    public PreconditionFailedException(String message, Throwable cause) {
        super(message, cause);
        initResponseCode();
    }

    public PreconditionFailedException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        initResponseCode();
    }

    public PreconditionFailedException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
        initResponseCode();
    }

    public PreconditionFailedException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode, cause);
        initResponseCode();
    }

    private void initResponseCode() {
        setHttpErrorCodeOverride(Constants.FAILED_PRECONDITION_STATUS_CODE);
    }
}
