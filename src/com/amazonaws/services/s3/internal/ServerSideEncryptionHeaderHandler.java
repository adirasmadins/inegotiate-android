package com.amazonaws.services.s3.internal;

import com.amazonaws.http.HttpResponse;
import com.amazonaws.services.s3.Headers;

public class ServerSideEncryptionHeaderHandler<T extends ServerSideEncryptionResult> implements HeaderHandler<T> {
    public void handle(T t, HttpResponse httpResponse) {
        t.setServerSideEncryption((String) httpResponse.getHeaders().get(Headers.SERVER_SIDE_ENCRYPTION));
    }
}
