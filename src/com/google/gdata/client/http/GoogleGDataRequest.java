package com.google.gdata.client.http;

import com.google.common.net.HttpHeaders;
import com.google.gdata.client.GDataProtocol.Header;
import com.google.gdata.client.GoogleAuthTokenFactory.OAuth2Token;
import com.google.gdata.client.GoogleService;
import com.google.gdata.client.GoogleService.SessionExpiredException;
import com.google.gdata.client.Service.GDataRequest;
import com.google.gdata.client.Service.GDataRequest.RequestType;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.RedirectRequiredException;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.Version;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.CookieHandler;
import java.net.URI;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

public class GoogleGDataRequest extends HttpGDataRequest {
    public static final String DISABLE_COOKIE_HANDLER_PROPERTY = "com.google.gdata.DisableCookieHandler";
    private static final ThreadLocal<GoogleService> activeService;
    private static final GoogleCookieHandler googleCookieHandler;
    private static final Logger logger;
    private Version responseVersion;
    private GoogleService service;

    public static class Factory extends com.google.gdata.client.http.HttpGDataRequest.Factory {
        protected GDataRequest createRequest(RequestType type, URL requestUrl, ContentType contentType) throws IOException, ServiceException {
            return new GoogleGDataRequest(type, requestUrl, contentType, this.authToken, this.headerMap, this.privateHeaderMap, this.connectionSource);
        }
    }

    public static class GoogleCookie {
        private String domain;
        private Date expires;
        private String name;
        private String path;
        private String value;

        public String getDomain() {
            return this.domain;
        }

        public String getPath() {
            return this.path;
        }

        public String getName() {
            return this.name;
        }

        String getValue() {
            return this.value;
        }

        public Date getExpires() {
            return this.expires != null ? (Date) this.expires.clone() : null;
        }

        public GoogleCookie(URI uri, String cookieHeader) {
            String[] attributes = cookieHeader.split(";");
            String nameValue = attributes[0].trim();
            int equals = nameValue.indexOf(61);
            if (equals < 0) {
                throw new IllegalArgumentException("Cookie is not a name/value pair");
            }
            this.name = nameValue.substring(0, equals);
            this.value = nameValue.substring(equals + 1);
            this.path = "/";
            this.domain = uri.getHost();
            for (int i = 1; i < attributes.length; i++) {
                nameValue = attributes[i].trim();
                equals = nameValue.indexOf(61);
                if (equals != -1) {
                    String name = nameValue.substring(0, equals);
                    String value = nameValue.substring(equals + 1);
                    if (name.equalsIgnoreCase("domain")) {
                        if (uri.getPort() > 0) {
                            int colon = value.lastIndexOf(58);
                            if (colon > 0) {
                                value = value.substring(0, colon);
                            }
                        }
                        String uriDomain = uri.getHost();
                        if (uriDomain.equals(value)) {
                            this.domain = value;
                        } else if (!matchDomain(uriDomain, value)) {
                            throw new IllegalArgumentException("Trying to set foreign cookie");
                        }
                        this.domain = value;
                    } else if (name.equalsIgnoreCase("path")) {
                        this.path = value;
                    } else if (name.equalsIgnoreCase("expires")) {
                        try {
                            this.expires = new SimpleDateFormat("E, dd-MMM-yyyy k:m:s 'GMT'", Locale.US).parse(value);
                        } catch (ParseException e) {
                            try {
                                this.expires = new SimpleDateFormat("E, dd MMM yyyy k:m:s 'GMT'", Locale.US).parse(value);
                            } catch (ParseException e2) {
                                throw new IllegalArgumentException("Bad date format in header: " + value);
                            }
                        }
                    } else {
                        continue;
                    }
                }
            }
        }

        private boolean matchDomain(String testDomain, String tailDomain) {
            if (!testDomain.endsWith(tailDomain)) {
                return false;
            }
            if (testDomain.length() == tailDomain.length() || tailDomain.charAt(0) == '.' || testDomain.charAt((testDomain.length() - tailDomain.length()) - 1) == '.') {
                return true;
            }
            return false;
        }

        public boolean hasExpired() {
            if (this.expires == null) {
                return false;
            }
            return new Date().after(this.expires);
        }

        public boolean matches(URI uri) {
            if (hasExpired() || !matchDomain(uri.getHost(), this.domain)) {
                return false;
            }
            String path = uri.getPath();
            if (path == null) {
                path = "/";
            }
            return path.startsWith(this.path);
        }

        String getHeaderValue() {
            StringBuilder result = new StringBuilder(this.name);
            result.append("=");
            result.append(this.value);
            return result.toString();
        }

        public boolean equals(Object o) {
            if (o == null || !(o instanceof GoogleCookie)) {
                return false;
            }
            GoogleCookie cookie = (GoogleCookie) o;
            if (!this.name.equals(cookie.name) || !this.domain.equals(cookie.domain)) {
                return false;
            }
            if (this.path != null) {
                return this.path.equals(cookie.path);
            }
            if (cookie.path == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((this.name.hashCode() + 629) * 37) + this.domain.hashCode()) * 37) + (this.path != null ? this.path.hashCode() : 0);
        }

        public String toString() {
            StringBuilder buf = new StringBuilder("GoogleCookie(");
            buf.append(this.domain);
            buf.append(this.path);
            buf.append("[");
            buf.append(this.name);
            buf.append("]");
            buf.append(")");
            return buf.toString();
        }
    }

    private static class GoogleCookieHandler extends CookieHandler {
        private CookieHandler nextHandler;

        private GoogleCookieHandler() {
            if (!Boolean.getBoolean(GoogleGDataRequest.DISABLE_COOKIE_HANDLER_PROPERTY)) {
                GoogleGDataRequest.logger.fine("Installing GoogleCookieHandler");
                this.nextHandler = CookieHandler.getDefault();
                CookieHandler.setDefault(this);
            }
        }

        public Map<String, List<String>> get(URI uri, Map<String, List<String>> requestHeaders) throws IOException {
            Map<String, List<String>> cookieHeaders = new HashMap();
            GoogleService service = (GoogleService) GoogleGDataRequest.activeService.get();
            if (service != null && service.handlesCookies()) {
                Set<GoogleCookie> cookies = service.getCookies();
                StringBuilder cookieBuf = new StringBuilder();
                for (GoogleCookie cookie : cookies) {
                    if (cookie.matches(uri)) {
                        if (cookieBuf.length() > 0) {
                            cookieBuf.append("; ");
                        }
                        cookieBuf.append(cookie.getHeaderValue());
                        GoogleGDataRequest.logger.fine("Setting cookie: " + cookie);
                    }
                }
                if (cookieBuf.length() != 0) {
                    cookieHeaders.put(HttpHeaders.COOKIE, Collections.singletonList(cookieBuf.toString()));
                }
            } else if (this.nextHandler != null) {
                return this.nextHandler.get(uri, requestHeaders);
            }
            return Collections.unmodifiableMap(cookieHeaders);
        }

        public void put(URI uri, Map<String, List<String>> responseHeaders) throws IOException {
            GoogleService service = (GoogleService) GoogleGDataRequest.activeService.get();
            if (service != null && service.handlesCookies()) {
                List<String> setCookieList = (List) responseHeaders.get(HttpHeaders.SET_COOKIE);
                if (setCookieList != null && setCookieList.size() > 0) {
                    for (String cookieValue : setCookieList) {
                        GoogleCookie cookie = new GoogleCookie(uri, cookieValue);
                        service.addCookie(cookie);
                        GoogleGDataRequest.logger.fine("Adding cookie:" + cookie);
                    }
                }
            } else if (this.nextHandler != null) {
                this.nextHandler.get(uri, responseHeaders);
            }
        }
    }

    static {
        logger = Logger.getLogger(GoogleGDataRequest.class.getName());
        try {
            if (Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null) {
                System.setProperty(DISABLE_COOKIE_HANDLER_PROPERTY, "true");
            }
        } catch (ClassNotFoundException e) {
        } catch (IllegalAccessException e2) {
        } catch (InvocationTargetException e3) {
        } catch (NoSuchMethodException e4) {
        }
        activeService = new ThreadLocal();
        if (Boolean.getBoolean(DISABLE_COOKIE_HANDLER_PROPERTY)) {
            googleCookieHandler = null;
        } else {
            googleCookieHandler = new GoogleCookieHandler();
        }
    }

    protected GoogleGDataRequest(RequestType type, URL requestUrl, ContentType contentType, HttpAuthToken authToken, Map<String, String> headerMap, Map<String, String> privateHeaderMap, HttpUrlConnectionSource connectionSource) throws IOException {
        super(type, requestUrl, contentType, authToken, headerMap, privateHeaderMap, connectionSource);
    }

    public Version getRequestVersion() {
        return this.service.getProtocolVersion();
    }

    public Version getResponseVersion() {
        if (this.executed) {
            return this.responseVersion;
        }
        throw new IllegalStateException("Request has not been executed");
    }

    public void setService(GoogleService service) {
        this.service = service;
        if (!Boolean.getBoolean("GoogleGDataRequest.disableVersionHeader")) {
            try {
                Version requestVersion = service.getProtocolVersion();
                if (requestVersion != null) {
                    setHeader(Header.VERSION, requestVersion.getVersionString());
                }
            } catch (IllegalStateException e) {
            }
        }
    }

    public void execute() throws IOException, ServiceException {
        try {
            activeService.set(this.service);
            this.httpConn.setInstanceFollowRedirects(false);
            super.execute();
            String versionHeader = this.httpConn.getHeaderField(Header.VERSION);
            if (versionHeader != null) {
                GoogleService service = (GoogleService) activeService.get();
                if (service != null) {
                    this.responseVersion = new Version(service.getClass(), versionHeader, new Version[0]);
                }
            }
            activeService.set(null);
        } catch (Throwable th) {
            activeService.set(null);
        }
    }

    protected void handleErrorResponse() throws IOException, ServiceException {
        try {
            switch (this.httpConn.getResponseCode()) {
                case 301:
                case 302:
                    throw new RedirectRequiredException(this.httpConn);
                default:
                    super.handleErrorResponse();
            }
        } catch (AuthenticationException e) {
            String msg = e.getMessage();
            if ((msg == null || !msg.contains("Token expired")) && (this.authToken == null || !(this.authToken instanceof OAuth2Token))) {
                throw e;
            }
            SessionExpiredException se = new SessionExpiredException(e.getMessage());
            se.setResponse(e.getResponseContentType(), e.getResponseBody());
            throw se;
        }
    }
}
