package com.amazonaws;

public class AmazonClientException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public AmazonClientException(String str) {
        super(str);
    }

    public AmazonClientException(String str, Throwable th) {
        super(str, th);
    }
}
