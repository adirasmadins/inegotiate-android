package com.amazonaws.http;

import com.amazonaws.Request;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.entity.BasicHttpEntity;
import org.apache.http.entity.InputStreamEntity;

class RepeatableInputStreamRequestEntity extends BasicHttpEntity {
    private static final Log log;
    private InputStream content;
    private boolean firstAttempt;
    private InputStreamEntity inputStreamRequestEntity;
    private IOException originalException;

    static {
        log = LogFactory.getLog(AmazonHttpClient.class);
    }

    RepeatableInputStreamRequestEntity(Request<?> request) {
        String str;
        this.firstAttempt = true;
        setChunked(false);
        long j = -1;
        try {
            str = (String) request.getHeaders().get(HttpHeaders.CONTENT_LENGTH);
            j = str != null ? Long.parseLong(str) : -1;
        } catch (NumberFormatException e) {
            log.warn("Unable to parse content length from request.  Buffering contents in memory.");
        }
        str = (String) request.getHeaders().get(HttpHeaders.CONTENT_TYPE);
        this.inputStreamRequestEntity = new InputStreamEntity(request.getContent(), j);
        this.inputStreamRequestEntity.setContentType(str);
        this.content = request.getContent();
        setContent(this.content);
        setContentType(str);
        setContentLength(j);
    }

    public boolean isChunked() {
        return false;
    }

    public boolean isRepeatable() {
        return this.content.markSupported() || this.inputStreamRequestEntity.isRepeatable();
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        try {
            if (!this.firstAttempt && isRepeatable()) {
                this.content.reset();
            }
            this.firstAttempt = false;
            this.inputStreamRequestEntity.writeTo(outputStream);
        } catch (IOException e) {
            if (this.originalException == null) {
                this.originalException = e;
            }
            throw this.originalException;
        }
    }
}
