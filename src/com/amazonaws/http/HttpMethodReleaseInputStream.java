package com.amazonaws.http;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.client.methods.AbortableHttpRequest;

public class HttpMethodReleaseInputStream extends InputStream {
    private static final Log log;
    private boolean alreadyReleased;
    private HttpEntityEnclosingRequest httpRequest;
    private InputStream inputStream;
    private boolean underlyingStreamConsumed;

    static {
        log = LogFactory.getLog(HttpMethodReleaseInputStream.class);
    }

    public HttpMethodReleaseInputStream(HttpEntityEnclosingRequest httpEntityEnclosingRequest) {
        this.inputStream = null;
        this.httpRequest = null;
        this.alreadyReleased = false;
        this.underlyingStreamConsumed = false;
        this.httpRequest = httpEntityEnclosingRequest;
        try {
            this.inputStream = httpEntityEnclosingRequest.getEntity().getContent();
        } catch (Throwable e) {
            if (log.isWarnEnabled()) {
                log.warn("Unable to obtain HttpMethod's response data stream", e);
            }
            try {
                httpEntityEnclosingRequest.getEntity().getContent().close();
            } catch (Exception e2) {
            }
            this.inputStream = new ByteArrayInputStream(new byte[0]);
        }
    }

    public int available() throws IOException {
        try {
            return this.inputStream.available();
        } catch (Throwable e) {
            releaseConnection();
            if (log.isDebugEnabled()) {
                log.debug("Released HttpMethod as its response data stream threw an exception", e);
            }
            throw e;
        }
    }

    public void close() throws IOException {
        if (!this.alreadyReleased) {
            releaseConnection();
            if (log.isDebugEnabled()) {
                log.debug("Released HttpMethod as its response data stream is closed");
            }
        }
        this.inputStream.close();
    }

    protected void finalize() throws Throwable {
        if (!this.alreadyReleased) {
            if (log.isWarnEnabled()) {
                log.warn("Attempting to release HttpMethod in finalize() as its response data stream has gone out of scope. This attempt will not always succeed and cannot be relied upon! Please ensure S3 response data streams are always fully consumed or closed to avoid HTTP connection starvation.");
            }
            releaseConnection();
            if (log.isWarnEnabled()) {
                log.warn("Successfully released HttpMethod in finalize(). You were lucky this time... Please ensure S3 response data streams are always fully consumed or closed.");
            }
        }
        super.finalize();
    }

    public HttpEntityEnclosingRequest getHttpRequest() {
        return this.httpRequest;
    }

    public int read() throws IOException {
        try {
            int read = this.inputStream.read();
            if (read == -1) {
                this.underlyingStreamConsumed = true;
                if (!this.alreadyReleased) {
                    releaseConnection();
                    if (log.isDebugEnabled()) {
                        log.debug("Released HttpMethod as its response data stream is fully consumed");
                    }
                }
            }
            return read;
        } catch (Throwable e) {
            releaseConnection();
            if (log.isDebugEnabled()) {
                log.debug("Released HttpMethod as its response data stream threw an exception", e);
            }
            throw e;
        }
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        try {
            int read = this.inputStream.read(bArr, i, i2);
            if (read == -1) {
                this.underlyingStreamConsumed = true;
                if (!this.alreadyReleased) {
                    releaseConnection();
                    if (log.isDebugEnabled()) {
                        log.debug("Released HttpMethod as its response data stream is fully consumed");
                    }
                }
            }
            return read;
        } catch (Throwable e) {
            releaseConnection();
            if (log.isDebugEnabled()) {
                log.debug("Released HttpMethod as its response data stream threw an exception", e);
            }
            throw e;
        }
    }

    protected void releaseConnection() throws IOException {
        if (!this.alreadyReleased) {
            if (!this.underlyingStreamConsumed && (this.httpRequest instanceof AbortableHttpRequest)) {
                ((AbortableHttpRequest) this.httpRequest).abort();
            }
            this.inputStream.close();
            this.alreadyReleased = true;
        }
    }
}
