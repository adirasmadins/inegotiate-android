package com.google.gdata.client.http;

import com.amazonaws.services.s3.internal.Constants;
import com.google.common.net.HttpHeaders;
import com.google.gdata.client.AuthTokenFactory.AuthToken;
import com.google.gdata.client.GDataProtocol.Header;
import com.google.gdata.client.GDataProtocol.Method;
import com.google.gdata.client.Query;
import com.google.gdata.client.Service.GDataRequest;
import com.google.gdata.client.Service.GDataRequest.RequestType;
import com.google.gdata.client.Service.GDataRequestFactory;
import com.google.gdata.client.authn.oauthproxy.OAuthProxyProtocol;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.ParseSource;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.EntityTooLargeException;
import com.google.gdata.util.InvalidEntryException;
import com.google.gdata.util.LoggableInputStream;
import com.google.gdata.util.LoggableOutputStream;
import com.google.gdata.util.NoLongerAvailableException;
import com.google.gdata.util.NotAcceptableException;
import com.google.gdata.util.NotImplementedException;
import com.google.gdata.util.NotModifiedException;
import com.google.gdata.util.OAuthProxyException;
import com.google.gdata.util.PreconditionFailedException;
import com.google.gdata.util.ResourceNotFoundException;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.ServiceForbiddenException;
import com.google.gdata.util.VersionConflictException;
import com.google.gdata.util.common.xml.XmlWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class HttpGDataRequest implements GDataRequest {
    @Deprecated
    public static final String METHOD_OVERRIDE_HEADER = "X-HTTP-Method-Override";
    public static final String METHOD_OVERRIDE_PROPERTY = "com.google.gdata.UseMethodOverride";
    static final Logger logger;
    protected final HttpAuthToken authToken;
    protected int connectTimeout;
    protected final HttpUrlConnectionSource connectionSource;
    protected boolean executed;
    protected boolean expectsInput;
    protected boolean hasOutput;
    protected HttpURLConnection httpConn;
    private InputStream inputStream;
    protected ContentType inputType;
    protected int readTimeout;
    protected URL requestUrl;
    protected RequestType type;

    public static class Factory implements GDataRequestFactory {
        protected HttpAuthToken authToken;
        protected HttpUrlConnectionSource connectionSource;
        protected Map<String, String> headerMap;
        protected Map<String, String> privateHeaderMap;
        protected boolean useSsl;

        public Factory() {
            this.headerMap = new LinkedHashMap();
            this.privateHeaderMap = new LinkedHashMap();
            this.useSsl = false;
            this.connectionSource = JdkHttpUrlConnectionSource.INSTANCE;
        }

        public void setAuthToken(AuthToken authToken) {
            if (authToken == null || (authToken instanceof HttpAuthToken)) {
                setAuthToken((HttpAuthToken) authToken);
                return;
            }
            throw new IllegalArgumentException("Invalid token type");
        }

        public void setAuthToken(HttpAuthToken authToken) {
            this.authToken = authToken;
        }

        public void useSsl() {
            this.useSsl = true;
        }

        private void extendHeaderMap(Map<String, String> headerMap, String header, String value) {
            if (value == null) {
                headerMap.remove(header);
            } else {
                headerMap.put(header, value);
            }
        }

        public void setHeader(String header, String value) {
            extendHeaderMap(this.headerMap, header, value);
        }

        public void setPrivateHeader(String header, String value) {
            extendHeaderMap(this.privateHeaderMap, header, value);
        }

        public void setConnectionSource(HttpUrlConnectionSource connectionSource) {
            if (connectionSource == null) {
                throw new NullPointerException("connectionSource");
            }
            this.connectionSource = connectionSource;
        }

        public GDataRequest getRequest(RequestType type, URL requestUrl, ContentType contentType) throws IOException, ServiceException {
            if (this.useSsl && !requestUrl.getProtocol().startsWith("https")) {
                requestUrl = new URL(requestUrl.toString().replaceFirst("http", "https"));
            }
            return createRequest(type, requestUrl, contentType);
        }

        public GDataRequest getRequest(Query query, ContentType contentType) throws IOException, ServiceException {
            return getRequest(RequestType.QUERY, query.getUrl(), contentType);
        }

        protected GDataRequest createRequest(RequestType type, URL requestUrl, ContentType contentType) throws IOException, ServiceException {
            return new HttpGDataRequest(type, requestUrl, contentType, this.authToken, this.headerMap, this.privateHeaderMap, this.connectionSource);
        }
    }

    /* renamed from: com.google.gdata.client.http.HttpGDataRequest.1 */
    static /* synthetic */ class C07131 {
        static final /* synthetic */ int[] f440xa5d3fe30;

        static {
            f440xa5d3fe30 = new int[RequestType.values().length];
            try {
                f440xa5d3fe30[RequestType.QUERY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f440xa5d3fe30[RequestType.INSERT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f440xa5d3fe30[RequestType.BATCH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f440xa5d3fe30[RequestType.UPDATE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f440xa5d3fe30[RequestType.PATCH.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f440xa5d3fe30[RequestType.DELETE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    static {
        logger = Logger.getLogger(HttpGDataRequest.class.getName());
    }

    protected HttpGDataRequest(RequestType type, URL requestUrl, ContentType inputType, HttpAuthToken authToken, Map<String, String> headerMap, Map<String, String> privateHeaderMap, HttpUrlConnectionSource connectionSource) throws IOException {
        this.executed = false;
        this.connectTimeout = -1;
        this.readTimeout = -1;
        this.inputStream = null;
        this.connectionSource = connectionSource;
        this.type = type;
        this.inputType = inputType;
        this.requestUrl = requestUrl;
        this.httpConn = getRequestConnection(requestUrl);
        this.authToken = authToken;
        switch (C07131.f440xa5d3fe30[type.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                this.hasOutput = true;
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                this.expectsInput = true;
                this.hasOutput = true;
                setMethod("POST");
                setHeader(HttpHeaders.CONTENT_TYPE, inputType.toString());
                break;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                this.expectsInput = true;
                this.hasOutput = true;
                if (Boolean.getBoolean(METHOD_OVERRIDE_PROPERTY)) {
                    setMethod("POST");
                    setHeader(METHOD_OVERRIDE_HEADER, "PUT");
                } else {
                    setMethod("PUT");
                }
                setHeader(HttpHeaders.CONTENT_TYPE, inputType.toString());
                break;
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                this.expectsInput = true;
                this.hasOutput = true;
                setMethod("POST");
                setHeader(METHOD_OVERRIDE_HEADER, Method.PATCH);
                setHeader(HttpHeaders.CONTENT_TYPE, inputType.toString());
                break;
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                if (Boolean.getBoolean(METHOD_OVERRIDE_PROPERTY)) {
                    setMethod("POST");
                    setHeader(METHOD_OVERRIDE_HEADER, "DELETE");
                } else {
                    setMethod("DELETE");
                }
                setHeader(HttpHeaders.CONTENT_LENGTH, "0");
                break;
            default:
                throw new UnsupportedOperationException("Unknown request type:" + type);
        }
        if (authToken != null) {
            setPrivateHeader(HttpHeaders.AUTHORIZATION, authToken.getAuthorizationHeader(requestUrl, this.httpConn.getRequestMethod()));
        }
        if (headerMap != null) {
            for (Entry<String, String> e : headerMap.entrySet()) {
                setHeader((String) e.getKey(), (String) e.getValue());
            }
        }
        if (privateHeaderMap != null) {
            for (Entry<String, String> e2 : privateHeaderMap.entrySet()) {
                setPrivateHeader((String) e2.getKey(), (String) e2.getValue());
            }
        }
        setHeader(HttpHeaders.ACCEPT_ENCODING, "gzip");
        this.httpConn.setDoOutput(this.expectsInput);
    }

    protected HttpGDataRequest() {
        this.executed = false;
        this.connectTimeout = -1;
        this.readTimeout = -1;
        this.inputStream = null;
        this.connectionSource = JdkHttpUrlConnectionSource.INSTANCE;
        this.authToken = null;
    }

    public URL getRequestUrl() {
        return this.requestUrl;
    }

    public ContentType getRequestContentType() {
        return this.inputType;
    }

    protected HttpURLConnection getRequestConnection(URL requestUrl) throws IOException {
        try {
            HttpURLConnection uc = this.connectionSource.openConnection(requestUrl);
            uc.setUseCaches(false);
            uc.setInstanceFollowRedirects(true);
            return uc;
        } catch (IllegalArgumentException e) {
            throw new UnsupportedOperationException("Unsupported scheme:" + requestUrl.getProtocol());
        }
    }

    public void setConnectTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("Timeout cannot be negative");
        }
        this.connectTimeout = timeout;
    }

    public void setReadTimeout(int timeout) {
        if (timeout < 0) {
            throw new IllegalArgumentException("Timeout cannot be negative");
        }
        this.readTimeout = timeout;
    }

    public void setIfModifiedSince(DateTime conditionDate) {
        if (conditionDate != null) {
            if (this.type == RequestType.QUERY) {
                setHeader(Header.IF_MODIFIED_SINCE, conditionDate.toStringRfc822());
                return;
            }
            throw new IllegalStateException("Date conditions not supported for this request type");
        }
    }

    public void setEtag(String etag) {
        if (etag != null) {
            switch (C07131.f440xa5d3fe30[this.type.ordinal()]) {
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    if (etag != null) {
                        setHeader(Header.IF_NONE_MATCH, etag);
                    }
                case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                    if (etag != null) {
                        setHeader(Header.IF_MATCH, etag);
                    }
                default:
                    throw new IllegalStateException("Etag conditions not supported for this request type");
            }
        }
    }

    public OutputStream getRequestStream() throws IOException {
        if (!this.expectsInput) {
            throw new IllegalStateException("Request doesn't accept input");
        } else if (logger.isLoggable(Level.FINEST)) {
            return new LoggableOutputStream(logger, this.httpConn.getOutputStream());
        } else {
            return this.httpConn.getOutputStream();
        }
    }

    public XmlWriter getRequestWriter() throws IOException {
        return new XmlWriter(new OutputStreamWriter(getRequestStream(), "utf-8"));
    }

    public void setMethod(String method) throws ProtocolException {
        this.httpConn.setRequestMethod(method);
        if (logger.isLoggable(Level.FINE)) {
            logger.fine(method + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.httpConn.getURL().toExternalForm());
        }
    }

    public void setHeader(String name, String value) {
        this.httpConn.setRequestProperty(name, value);
        logger.finer(name + ": " + value);
    }

    public void setPrivateHeader(String name, String value) {
        this.httpConn.setRequestProperty(name, value);
        logger.finer(name + ": <Not Logged>");
    }

    public void execute() throws IOException, ServiceException {
        if (this.connectTimeout >= 0) {
            this.httpConn.setConnectTimeout(this.connectTimeout);
        }
        if (this.readTimeout >= 0) {
            this.httpConn.setReadTimeout(this.readTimeout);
        }
        String httpStrictPostRedirect = System.getProperty("http.strictPostRedirect");
        try {
            System.setProperty("http.strictPostRedirect", "true");
            this.httpConn.connect();
            if (logger.isLoggable(Level.FINE)) {
                if (!(this.httpConn.getURL() == this.requestUrl || this.httpConn.getURL().toExternalForm().equals(this.requestUrl.toExternalForm()))) {
                    logger.fine("Redirected to:" + this.httpConn.getURL().toExternalForm());
                }
                logger.fine(this.httpConn.getResponseCode() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.httpConn.getResponseMessage());
                if (logger.isLoggable(Level.FINER)) {
                    for (Entry<String, List<String>> headerField : this.httpConn.getHeaderFields().entrySet()) {
                        for (String value : (List) headerField.getValue()) {
                            logger.finer(((String) headerField.getKey()) + ": " + value);
                        }
                    }
                }
            }
            checkResponse();
            this.executed = true;
        } finally {
            if (httpStrictPostRedirect == null) {
                System.clearProperty("http.strictPostRedirect");
            } else {
                System.setProperty("http.strictPostRedirect", httpStrictPostRedirect);
            }
        }
    }

    protected void checkResponse() throws IOException, ServiceException {
        if (isOAuthProxyErrorResponse()) {
            handleOAuthProxyErrorResponse();
        } else if (this.httpConn.getResponseCode() >= 300) {
            handleErrorResponse();
        }
    }

    private boolean isOAuthProxyErrorResponse() throws IOException {
        Set<String> headers = this.httpConn.getHeaderFields().keySet();
        boolean isOAuthRedirectToApproval = headers.contains(OAuthProxyProtocol.Header.X_OAUTH_APPROVAL_URL);
        boolean isOtherOAuthError;
        if (this.httpConn.getResponseCode() == 200 && (headers.contains(OAuthProxyProtocol.Header.X_OAUTH_ERROR) || headers.contains(OAuthProxyProtocol.Header.X_OAUTH_ERROR_TEXT))) {
            isOtherOAuthError = true;
        } else {
            isOtherOAuthError = false;
        }
        if (isOAuthRedirectToApproval || isOtherOAuthError) {
            return true;
        }
        return false;
    }

    private void handleOAuthProxyErrorResponse() throws IOException, ServiceException {
        throw new OAuthProxyException(this.httpConn);
    }

    protected void handleErrorResponse() throws ServiceException, IOException {
        switch (this.httpConn.getResponseCode()) {
            case 304:
                throw new NotModifiedException(this.httpConn);
            case 400:
                throw new InvalidEntryException(this.httpConn);
            case 401:
                throw new AuthenticationException(this.httpConn);
            case 403:
                throw new ServiceForbiddenException(this.httpConn);
            case 404:
                throw new ResourceNotFoundException(this.httpConn);
            case 406:
                throw new NotAcceptableException(this.httpConn);
            case 409:
                throw new VersionConflictException(this.httpConn);
            case 410:
                throw new NoLongerAvailableException(this.httpConn);
            case Constants.FAILED_PRECONDITION_STATUS_CODE /*412*/:
                throw new PreconditionFailedException(this.httpConn);
            case 413:
                throw new EntityTooLargeException(this.httpConn);
            case 501:
                throw new NotImplementedException(this.httpConn);
            default:
                throw new ServiceException(this.httpConn);
        }
    }

    public ContentType getResponseContentType() {
        if (this.executed) {
            String value = this.httpConn.getHeaderField(HttpHeaders.CONTENT_TYPE);
            if (value == null) {
                return null;
            }
            return new ContentType(value);
        }
        throw new IllegalStateException("Must call execute() before attempting to read response");
    }

    public String getResponseHeader(String headerName) {
        return this.httpConn.getHeaderField(headerName);
    }

    public DateTime getResponseDateHeader(String headerName) {
        long dateValue = this.httpConn.getHeaderFieldDate(headerName, -1);
        return dateValue >= 0 ? new DateTime(dateValue) : null;
    }

    public InputStream getResponseStream() throws IOException {
        if (!this.executed) {
            throw new IllegalStateException("Must call execute() before attempting to read response");
        } else if (!this.hasOutput) {
            throw new IllegalStateException("Request doesn't have response data");
        } else if (this.inputStream != null) {
            return this.inputStream;
        } else {
            this.inputStream = this.httpConn.getInputStream();
            if ("gzip".equalsIgnoreCase(this.httpConn.getContentEncoding())) {
                this.inputStream = new GZIPInputStream(this.inputStream);
            }
            if (logger.isLoggable(Level.FINEST)) {
                return new LoggableInputStream(logger, this.inputStream);
            }
            return this.inputStream;
        }
    }

    public ParseSource getParseSource() throws IOException {
        return new ParseSource(getResponseStream());
    }

    public HttpURLConnection getConnection() {
        return this.httpConn;
    }

    public void end() {
        try {
            if (this.inputStream != null) {
                this.inputStream.close();
            }
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Error closing response stream", ioe);
        }
    }
}
