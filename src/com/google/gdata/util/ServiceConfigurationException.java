package com.google.gdata.util;

import com.google.gdata.util.ErrorDomain.ErrorCode;

public class ServiceConfigurationException extends ServiceException {
    public ServiceConfigurationException(String message) {
        super(message);
    }

    public ServiceConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceConfigurationException(Throwable cause) {
        super(cause);
    }

    public ServiceConfigurationException(ErrorCode errorCode) {
        super((ErrorContent) errorCode);
    }

    public ServiceConfigurationException(ErrorCode errorCode, Throwable cause) {
        super((ErrorContent) errorCode, cause);
    }
}
