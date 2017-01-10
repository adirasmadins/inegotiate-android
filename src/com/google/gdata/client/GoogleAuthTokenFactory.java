package com.google.gdata.client;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.UrlEncodedParser;
import com.google.common.net.HttpHeaders;
import com.google.gdata.client.AuthTokenFactory.TokenListener;
import com.google.gdata.client.GoogleService.AccountDeletedException;
import com.google.gdata.client.GoogleService.AccountDisabledException;
import com.google.gdata.client.GoogleService.CaptchaRequiredException;
import com.google.gdata.client.GoogleService.InvalidCredentialsException;
import com.google.gdata.client.GoogleService.NotVerifiedException;
import com.google.gdata.client.GoogleService.ServiceUnavailableException;
import com.google.gdata.client.GoogleService.SessionExpiredException;
import com.google.gdata.client.GoogleService.TermsNotAgreedException;
import com.google.gdata.client.authn.oauth.GoogleOAuthHelper;
import com.google.gdata.client.authn.oauth.OAuthException;
import com.google.gdata.client.authn.oauth.OAuthParameters;
import com.google.gdata.client.authn.oauth.OAuthParameters.OAuthType;
import com.google.gdata.client.authn.oauth.OAuthSigner;
import com.google.gdata.client.authn.oauth.TwoLeggedOAuthHelper;
import com.google.gdata.client.http.AuthSubUtil;
import com.google.gdata.client.http.HttpAuthToken;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.common.base.CharEscapers;
import com.google.gdata.util.common.base.StringUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GoogleAuthTokenFactory implements AuthTokenFactory {
    public static final String GOOGLE_ACCOUNTS_PATH = "/accounts";
    public static final String GOOGLE_LOGIN_PATH = "/accounts/ClientLogin";
    private String applicationName;
    private HttpAuthToken authToken;
    private String domainName;
    private String loginProtocol;
    private String password;
    private String serviceName;
    private TokenListener tokenListener;
    private String username;

    public static class AuthSubToken implements HttpAuthToken {
        private PrivateKey key;
        private String token;

        public AuthSubToken(String token, PrivateKey key) {
            this.token = token;
            this.key = key;
        }

        public String getValue() {
            return this.token;
        }

        public String getAuthorizationHeader(URL requestUrl, String requestMethod) {
            try {
                return AuthSubUtil.formAuthorizationHeader(this.token, this.key, requestUrl, requestMethod);
            } catch (GeneralSecurityException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }

    public static class OAuth2Token implements HttpAuthToken {
        static final String HEADER_PREFIX = "Bearer ";
        final Credential credential;

        public OAuth2Token(Credential credential) {
            this.credential = credential;
        }

        public String getAuthorizationHeader(URL requestUrl, String requestMethod) {
            return HEADER_PREFIX + this.credential.getAccessToken();
        }

        public boolean refreshToken() throws AuthenticationException {
            try {
                return this.credential.refreshToken();
            } catch (IOException e) {
                AuthenticationException ae = new AuthenticationException("Failed to refresh access token: " + e.getMessage());
                ae.initCause(e);
                throw ae;
            }
        }
    }

    public static class OAuthToken implements HttpAuthToken {
        OAuthParameters parameters;
        final OAuthSigner signer;

        public OAuthToken(OAuthParameters parameters, OAuthSigner signer) {
            this.parameters = parameters;
            this.signer = signer;
        }

        public String getAuthorizationHeader(URL requestUrl, String requestMethod) {
            try {
                if (this.parameters.getOAuthType() == OAuthType.TWO_LEGGED_OAUTH) {
                    return new TwoLeggedOAuthHelper(this.signer, this.parameters).getAuthorizationHeader(requestUrl.toString(), requestMethod);
                }
                return new GoogleOAuthHelper(this.signer).getAuthorizationHeader(requestUrl.toString(), requestMethod, this.parameters);
            } catch (OAuthException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static class UserToken implements HttpAuthToken {
        private String token;

        public UserToken(String token) {
            this.token = token;
        }

        public String getValue() {
            return this.token;
        }

        public String getAuthorizationHeader(URL requestUrl, String requestMethod) {
            return "GoogleLogin auth=" + this.token;
        }
    }

    public GoogleAuthTokenFactory(String serviceName, String applicationName, TokenListener tokenListener) {
        this(serviceName, applicationName, "https", "www.google.com", tokenListener);
    }

    public GoogleAuthTokenFactory(String serviceName, String applicationName, String protocol, String domainName, TokenListener tokenListener) {
        this.serviceName = serviceName;
        this.applicationName = applicationName;
        this.domainName = domainName;
        this.loginProtocol = protocol;
        this.tokenListener = tokenListener;
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
        this.username = username;
        this.password = password;
        setUserToken(getAuthToken(username, password, captchaToken, captchaAnswer, this.serviceName, this.applicationName, accountType));
    }

    public void setUserToken(String token) {
        setAuthToken(new UserToken(token));
    }

    public void setAuthSubToken(String token) {
        setAuthSubToken(token, null);
    }

    public void setAuthSubToken(String token, PrivateKey key) {
        setAuthToken(new AuthSubToken(token, key));
    }

    public void setOAuthCredentials(OAuthParameters parameters, OAuthSigner signer) throws OAuthException {
        parameters.assertOAuthConsumerKeyExists();
        setAuthToken(new OAuthToken(parameters, signer));
    }

    public void setOAuth2Credentials(Credential credential) {
        setAuthToken(new OAuth2Token(credential));
    }

    public void setAuthToken(HttpAuthToken authToken) {
        this.authToken = authToken;
        if (this.tokenListener != null) {
            this.tokenListener.tokenChanged(authToken);
        }
    }

    public HttpAuthToken getAuthToken() {
        return this.authToken;
    }

    public String getAuthToken(String username, String password, String captchaToken, String captchaAnswer, String serviceName, String applicationName) throws AuthenticationException {
        return getAuthToken(username, password, captchaToken, captchaAnswer, serviceName, applicationName, ClientLoginAccountType.HOSTED_OR_GOOGLE);
    }

    public String getAuthToken(String username, String password, String captchaToken, String captchaAnswer, String serviceName, String applicationName, ClientLoginAccountType accountType) throws AuthenticationException {
        Map<String, String> params = new HashMap();
        params.put("Email", username);
        params.put("Passwd", password);
        params.put("source", applicationName);
        params.put("service", serviceName);
        params.put("accountType", accountType.getValue());
        if (captchaToken != null) {
            params.put("logintoken", captchaToken);
        }
        if (captchaAnswer != null) {
            params.put("logincaptcha", captchaAnswer);
        }
        try {
            Map<String, String> tokenPairs = StringUtil.string2Map(makePostRequest(new URL(this.loginProtocol + "://" + this.domainName + GOOGLE_LOGIN_PATH), params).trim(), "\n", "=", true);
            String token = (String) tokenPairs.get("Auth");
            if (token != null) {
                return token;
            }
            throw getAuthException(tokenPairs);
        } catch (IOException e) {
            AuthenticationException ae = new AuthenticationException("Error connecting with login URI");
            ae.initCause(e);
            throw ae;
        }
    }

    public static String makePostRequest(URL url, Map<String, String> parameters) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setUseCaches(false);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, UrlEncodedParser.CONTENT_TYPE);
        urlConnection.setRequestProperty(HttpHeaders.USER_AGENT, ((String) parameters.get("service")) + " GData-Java/" + GoogleAuthTokenFactory.class.getPackage().getImplementationVersion());
        StringBuilder content = new StringBuilder();
        boolean first = true;
        for (Entry<String, String> parameter : parameters.entrySet()) {
            if (!first) {
                content.append("&");
            }
            content.append(CharEscapers.uriEscaper().escape((String) parameter.getKey())).append("=");
            content.append(CharEscapers.uriEscaper().escape((String) parameter.getValue()));
            first = false;
        }
        OutputStream outputStream = null;
        try {
            outputStream = urlConnection.getOutputStream();
            outputStream.write(content.toString().getBytes("utf-8"));
            outputStream.flush();
            InputStream inputStream = null;
            StringBuilder outputBuilder = new StringBuilder();
            try {
                if (urlConnection.getResponseCode() == 200) {
                    inputStream = urlConnection.getInputStream();
                } else {
                    inputStream = urlConnection.getErrorStream();
                }
                if (inputStream != null) {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    while (true) {
                        String string = reader.readLine();
                        if (string == null) {
                            break;
                        }
                        outputBuilder.append(string).append('\n');
                    }
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                return outputBuilder.toString();
            } catch (Throwable th) {
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } finally {
            if (outputStream != null) {
                outputStream.close();
            }
        }
    }

    private AuthenticationException getAuthException(Map<String, String> pairs) {
        String errorName = (String) pairs.get("Error");
        if ("BadAuthentication".equals(errorName)) {
            return new InvalidCredentialsException("Invalid credentials");
        }
        if ("AccountDeleted".equals(errorName)) {
            return new AccountDeletedException("Account deleted");
        }
        if ("AccountDisabled".equals(errorName)) {
            return new AccountDisabledException("Account disabled");
        }
        if ("NotVerified".equals(errorName)) {
            return new NotVerifiedException("Not verified");
        }
        if ("TermsNotAgreed".equals(errorName)) {
            return new TermsNotAgreedException("Terms not agreed");
        }
        if ("ServiceUnavailable".equals(errorName)) {
            return new ServiceUnavailableException("Service unavailable");
        }
        if (!"CaptchaRequired".equals(errorName)) {
            return new AuthenticationException("Error authenticating (check service name)");
        }
        String captchaPath = (String) pairs.get("CaptchaUrl");
        StringBuilder captchaUrl = new StringBuilder();
        captchaUrl.append(this.loginProtocol).append("://").append(this.domainName).append(GOOGLE_ACCOUNTS_PATH).append('/').append(captchaPath);
        return new CaptchaRequiredException("Captcha required", captchaUrl.toString(), (String) pairs.get("CaptchaToken"));
    }

    public void handleSessionExpiredException(SessionExpiredException sessionExpired) throws SessionExpiredException, AuthenticationException {
        if (this.username != null && this.password != null) {
            setUserToken(getAuthToken(this.username, this.password, null, null, this.serviceName, this.applicationName));
        } else if (!(this.authToken instanceof OAuth2Token) || !((OAuth2Token) this.authToken).refreshToken()) {
            throw sessionExpired;
        }
    }
}
