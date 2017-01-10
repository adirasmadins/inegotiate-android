package com.amazonaws;

import java.util.Map;

public class ResponseMetadata {
    public static final String AWS_REQUEST_ID = "AWS_REQUEST_ID";
    protected final Map<String, String> metadata;

    public ResponseMetadata(ResponseMetadata responseMetadata) {
        this(responseMetadata.metadata);
    }

    public ResponseMetadata(Map<String, String> map) {
        this.metadata = map;
    }

    public String getRequestId() {
        return (String) this.metadata.get(AWS_REQUEST_ID);
    }

    public String toString() {
        return this.metadata == null ? "{}" : this.metadata.toString();
    }
}
