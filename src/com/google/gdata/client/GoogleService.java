package com.google.gdata.client;

import com.google.api.client.auth.oauth2.Credential;
import com.google.common.annotations.Beta;
import com.google.common.net.HttpHeaders;
import com.google.gdata.client.AuthTokenFactory.AuthToken;
import com.google.gdata.client.AuthTokenFactory.TokenListener;
import com.google.gdata.client.Service.GDataRequest;
import com.google.gdata.client.Service.GDataRequest.RequestType;
import com.google.gdata.client.Service.GDataRequestFactory;
import com.google.gdata.client.authn.oauth.OAuthException;
import com.google.gdata.client.authn.oauth.OAuthParameters;
import com.google.gdata.client.authn.oauth.OAuthSigner;
import com.google.gdata.client.batch.BatchInterruptedException;
import com.google.gdata.client.http.GoogleGDataRequest;
import com.google.gdata.client.http.GoogleGDataRequest.Factory;
import com.google.gdata.client.http.GoogleGDataRequest.GoogleCookie;
import com.google.gdata.data.DateTime;
import com.google.gdata.data.IEntry;
import com.google.gdata.data.IFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ContentType;
import com.google.gdata.util.RedirectRequiredException;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.PrivateKey;
import java.util.Map;
import java.util.Set;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class GoogleService extends Service implements TokenListener {
    private AuthTokenFactory authTokenFactory;
    private CookieManager cookieManager;

    public static class AccountDeletedException extends AuthenticationException {
        public AccountDeletedException(String message) {
            super(message);
        }
    }

    public static class AccountDisabledException extends AuthenticationException {
        public AccountDisabledException(String message) {
            super(message);
        }
    }

    public static class CaptchaRequiredException extends AuthenticationException {
        private String captchaToken;
        private String captchaUrl;

        public CaptchaRequiredException(String message, String captchaUrl, String captchaToken) {
            super(message);
            this.captchaToken = captchaToken;
            this.captchaUrl = captchaUrl;
        }

        public String getCaptchaToken() {
            return this.captchaToken;
        }

        public String getCaptchaUrl() {
            return this.captchaUrl;
        }
    }

    public static class InvalidCredentialsException extends AuthenticationException {
        public InvalidCredentialsException(String message) {
            super(message);
        }
    }

    public static class NotVerifiedException extends AuthenticationException {
        public NotVerifiedException(String message) {
            super(message);
        }
    }

    public static class ServiceUnavailableException extends AuthenticationException {
        public ServiceUnavailableException(String message) {
            super(message);
        }
    }

    public static class SessionExpiredException extends AuthenticationException {
        public SessionExpiredException(String message) {
            super(message);
        }
    }

    public static class TermsNotAgreedException extends AuthenticationException {
        public TermsNotAgreedException(String message) {
            super(message);
        }
    }

    public GoogleService(String serviceName, String applicationName) {
        this(serviceName, applicationName, "https", "www.google.com");
    }

    public GoogleService(String serviceName, String applicationName, String protocol, String domainName) {
        this.requestFactory = new Factory();
        this.authTokenFactory = new GoogleAuthTokenFactory(serviceName, applicationName, protocol, domainName, this);
        this.cookieManager = new SimpleCookieManager();
        initRequestFactory(applicationName);
    }

    public GoogleService(String applicationName, GDataRequestFactory requestFactory, AuthTokenFactory authTokenFactory) {
        this.requestFactory = requestFactory;
        this.authTokenFactory = authTokenFactory;
        this.cookieManager = new SimpleCookieManager();
        initRequestFactory(applicationName);
    }

    private void initRequestFactory(String applicationName) {
        if (applicationName != null) {
            this.requestFactory.setHeader(HttpHeaders.USER_AGENT, applicationName + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + getServiceVersion());
        } else {
            this.requestFactory.setHeader(HttpHeaders.USER_AGENT, getServiceVersion());
        }
    }

    public AuthTokenFactory getAuthTokenFactory() {
        return this.authTokenFactory;
    }

    public void setAuthTokenFactory(AuthTokenFactory authTokenFactory) {
        this.authTokenFactory = authTokenFactory;
    }

    public CookieManager getCookieManager() {
        return this.cookieManager;
    }

    public void setCookieManager(CookieManager cookieManager) {
        this.cookieManager = cookieManager;
    }

    public void tokenChanged(AuthToken newToken) {
        if (this.cookieManager != null) {
            this.cookieManager.clearCookies();
        }
        this.requestFactory.setAuthToken(newToken);
    }

    public void setUserCredentials(String username, String password) throws AuthenticationException {
        setUserCredentials(username, password, ClientLoginAccountType.HOSTED_OR_GOOGLE);
    }

    public void setUserCredentials(String username, String password, ClientLoginAccountType accountType) throws AuthenticationException {
        setUserCredentials(username, password, null, null, accountType);
    }

    public void setUserCredentials(String username, String password, String captchaToken, String captchaAnswer) throws AuthenticationException {
        setUserCredentials(username, password, captchaToken, captchaAnswer, ClientLoginAccountType.HOSTED_OR_GOOGLE);
    }

    public void setUserCredentials(String username, String password, String captchaToken, String captchaAnswer, ClientLoginAccountType accountType) throws AuthenticationException {
        getGoogleAuthTokenFactory().setUserCredentials(username, password, captchaToken, captchaAnswer, accountType);
        this.requestFactory.setAuthToken(this.authTokenFactory.getAuthToken());
    }

    public void setUserToken(String token) {
        getGoogleAuthTokenFactory().setUserToken(token);
        this.requestFactory.setAuthToken(this.authTokenFactory.getAuthToken());
    }

    public void setOAuthCredentials(OAuthParameters parameters, OAuthSigner signer) throws OAuthException {
        getGoogleAuthTokenFactory().setOAuthCredentials(parameters, signer);
        this.requestFactory.setAuthToken(this.authTokenFactory.getAuthToken());
    }

    @Beta
    public void setOAuth2Credentials(Credential credential) {
        getGoogleAuthTokenFactory().setOAuth2Credentials(credential);
        this.requestFactory.setAuthToken(this.authTokenFactory.getAuthToken());
    }

    public void setAuthSubToken(String token) {
        setAuthSubToken(token, null);
    }

    public void setAuthSubToken(String token, PrivateKey key) {
        getGoogleAuthTokenFactory().setAuthSubToken(token, key);
        this.requestFactory.setAuthToken(this.authTokenFactory.getAuthToken());
    }

    public String getAuthToken(String username, String password, String captchaToken, String captchaAnswer, String serviceName, String applicationName) throws AuthenticationException {
        return getGoogleAuthTokenFactory().getAuthToken(username, password, captchaToken, captchaAnswer, serviceName, applicationName);
    }

    public static String makePostRequest(URL url, Map<String, String> parameters) throws IOException {
        return GoogleAuthTokenFactory.makePostRequest(url, parameters);
    }

    public void setHandlesCookies(boolean handlesCookies) {
        if (this.cookieManager != null) {
            this.cookieManager.setCookiesEnabled(handlesCookies);
        } else if (handlesCookies) {
            throw new IllegalArgumentException("No cookie manager defined");
        }
    }

    public boolean handlesCookies() {
        if (this.cookieManager == null) {
            return false;
        }
        return this.cookieManager.cookiesEnabled();
    }

    public void addCookie(GoogleCookie cookie) {
        if (this.cookieManager != null) {
            this.cookieManager.addCookie(cookie);
        }
    }

    public Set<GoogleCookie> getCookies() {
        if (this.cookieManager != null) {
            return this.cookieManager.getCookies();
        }
        throw new IllegalArgumentException("No cookie manager defined");
    }

    public GDataRequest createRequest(RequestType type, URL requestUrl, ContentType contentType) throws IOException, ServiceException {
        GDataRequest request = super.createRequest(type, requestUrl, contentType);
        if (request instanceof GoogleGDataRequest) {
            ((GoogleGDataRequest) request).setService(this);
        }
        return request;
    }

    protected GDataRequest createRequest(Query query, ContentType contentType) throws IOException, ServiceException {
        GDataRequest request = super.createRequest(query, contentType);
        if (request instanceof GoogleGDataRequest) {
            ((GoogleGDataRequest) request).setService(this);
        }
        return request;
    }

    public <E extends IEntry> E getEntry(URL entryUrl, Class<E> entryClass, DateTime ifModifiedSince) throws IOException, ServiceException {
        try {
            return super.getEntry(entryUrl, (Class) entryClass, ifModifiedSince);
        } catch (RedirectRequiredException e) {
            entryUrl = handleRedirectException(e);
            return super.getEntry(entryUrl, (Class) entryClass, ifModifiedSince);
        } catch (SessionExpiredException e2) {
            handleSessionExpiredException(e2);
            return super.getEntry(entryUrl, (Class) entryClass, ifModifiedSince);
        }
    }

    public <E extends IEntry> E getEntry(URL entryUrl, Class<E> entryClass, String etag) throws IOException, ServiceException {
        try {
            return super.getEntry(entryUrl, (Class) entryClass, etag);
        } catch (RedirectRequiredException e) {
            entryUrl = handleRedirectException(e);
            return super.getEntry(entryUrl, (Class) entryClass, etag);
        } catch (SessionExpiredException e2) {
            handleSessionExpiredException(e2);
            return super.getEntry(entryUrl, (Class) entryClass, etag);
        }
    }

    public <E extends IEntry> E update(URL entryUrl, E entry) throws IOException, ServiceException {
        try {
            return super.update(entryUrl, entry);
        } catch (RedirectRequiredException e) {
            entryUrl = handleRedirectException(e);
            return super.update(entryUrl, entry);
        } catch (SessionExpiredException e2) {
            handleSessionExpiredException(e2);
            return super.update(entryUrl, entry);
        }
    }

    public <E extends IEntry> E insert(URL feedUrl, E entry) throws IOException, ServiceException {
        try {
            return super.insert(feedUrl, entry);
        } catch (RedirectRequiredException e) {
            feedUrl = handleRedirectException(e);
            return super.insert(feedUrl, entry);
        } catch (SessionExpiredException e2) {
            handleSessionExpiredException(e2);
            return super.insert(feedUrl, entry);
        }
    }

    public <F extends IFeed> F getFeed(URL feedUrl, Class<F> feedClass, DateTime ifModifiedSince) throws IOException, ServiceException {
        try {
            return super.getFeed(feedUrl, (Class) feedClass, ifModifiedSince);
        } catch (RedirectRequiredException e) {
            feedUrl = handleRedirectException(e);
            return super.getFeed(feedUrl, (Class) feedClass, ifModifiedSince);
        } catch (SessionExpiredException e2) {
            handleSessionExpiredException(e2);
            return super.getFeed(feedUrl, (Class) feedClass, ifModifiedSince);
        }
    }

    public <F extends IFeed> F getFeed(URL feedUrl, Class<F> feedClass, String etag) throws IOException, ServiceException {
        try {
            return super.getFeed(feedUrl, (Class) feedClass, etag);
        } catch (RedirectRequiredException e) {
            feedUrl = handleRedirectException(e);
            return super.getFeed(feedUrl, (Class) feedClass, etag);
        } catch (SessionExpiredException e2) {
            handleSessionExpiredException(e2);
            return super.getFeed(feedUrl, (Class) feedClass, etag);
        }
    }

    public <F extends IFeed> F getFeed(Query query, Class<F> feedClass, DateTime ifModifiedSince) throws IOException, ServiceException {
        try {
            return super.getFeed(query, (Class) feedClass, ifModifiedSince);
        } catch (RedirectRequiredException e) {
            query = new Query(handleRedirectException(e));
            return super.getFeed(query, (Class) feedClass, ifModifiedSince);
        } catch (SessionExpiredException e2) {
            handleSessionExpiredException(e2);
            return super.getFeed(query, (Class) feedClass, ifModifiedSince);
        }
    }

    public <F extends IFeed> F getFeed(Query query, Class<F> feedClass, String etag) throws IOException, ServiceException {
        try {
            return super.getFeed(query, (Class) feedClass, etag);
        } catch (RedirectRequiredException e) {
            query = new Query(handleRedirectException(e));
            return super.getFeed(query, (Class) feedClass, etag);
        } catch (SessionExpiredException e2) {
            handleSessionExpiredException(e2);
            return super.getFeed(query, (Class) feedClass, etag);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void delete(java.net.URL r2) throws java.io.IOException, com.google.gdata.util.ServiceException {
        /*
        r1 = this;
        super.delete(r2);	 Catch:{ RedirectRequiredException -> 0x0004, SessionExpiredException -> 0x000d }
    L_0x0003:
        return;
    L_0x0004:
        r0 = move-exception;
        r2 = r1.handleRedirectException(r0);
    L_0x0009:
        super.delete(r2);
        goto L_0x0003;
    L_0x000d:
        r0 = move-exception;
        r1.handleSessionExpiredException(r0);
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gdata.client.GoogleService.delete(java.net.URL):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void delete(java.net.URL r2, java.lang.String r3) throws java.io.IOException, com.google.gdata.util.ServiceException {
        /*
        r1 = this;
        super.delete(r2, r3);	 Catch:{ RedirectRequiredException -> 0x0004, SessionExpiredException -> 0x000d }
    L_0x0003:
        return;
    L_0x0004:
        r0 = move-exception;
        r2 = r1.handleRedirectException(r0);
    L_0x0009:
        super.delete(r2, r3);
        goto L_0x0003;
    L_0x000d:
        r0 = move-exception;
        r1.handleSessionExpiredException(r0);
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gdata.client.GoogleService.delete(java.net.URL, java.lang.String):void");
    }

    protected URL handleRedirectException(RedirectRequiredException redirect) throws ServiceException {
        try {
            return new URL(redirect.getRedirectLocation());
        } catch (MalformedURLException e) {
            ServiceException se = new ServiceException(CoreErrorDomain.ERR.invalidRedirectedToUrl);
            se.setInternalReason("Invalid redirected-to URL - " + redirect.getRedirectLocation());
            throw se;
        }
    }

    protected void handleSessionExpiredException(SessionExpiredException e) throws ServiceException {
        this.authTokenFactory.handleSessionExpiredException(e);
    }

    public <F extends IFeed> F batch(URL feedUrl, F inputFeed) throws IOException, ServiceException, BatchInterruptedException {
        try {
            return super.batch(feedUrl, inputFeed);
        } catch (RedirectRequiredException e) {
            feedUrl = handleRedirectException(e);
            return super.batch(feedUrl, inputFeed);
        } catch (SessionExpiredException e2) {
            handleSessionExpiredException(e2);
            return super.batch(feedUrl, inputFeed);
        }
    }

    private GoogleAuthTokenFactory getGoogleAuthTokenFactory() {
        if (this.authTokenFactory instanceof GoogleAuthTokenFactory) {
            return (GoogleAuthTokenFactory) this.authTokenFactory;
        }
        throw new IllegalStateException("Invalid authentication token factory");
    }
}
