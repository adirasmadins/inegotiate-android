package com.google.gdata.client.authn.oauth;

import com.google.common.net.HttpHeaders;
import com.google.gdata.util.common.base.StringUtil;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class OAuthHelper {
    private String accessTokenUrl;
    private OAuthHttpClient httpClient;
    private String requestTokenUrl;
    private String revokeTokenUrl;
    private OAuthSigner signer;
    private String userAuthorizationUrl;

    static abstract class KeyValuePair {
        private String keyValueEndDelimiter;
        private String keyValueStartDelimiter;
        private List<String> keys;
        private String pairDelimiter;
        private List<String> values;

        protected KeyValuePair(String keyValueStartDelimiter, String keyValueEndDelimiter, String pairDelimiter) {
            this.keyValueStartDelimiter = keyValueStartDelimiter;
            this.keyValueEndDelimiter = keyValueEndDelimiter;
            this.pairDelimiter = pairDelimiter;
            this.keys = new ArrayList();
            this.values = new ArrayList();
        }

        public void add(String key, String value) {
            this.keys.add(key);
            this.values.add(value);
        }

        public String getKey(int i) {
            return (String) this.keys.get(i);
        }

        public String getValue(int i) {
            return (String) this.values.get(i);
        }

        public int size() {
            return this.keys.size();
        }

        public String toString() {
            StringBuilder keyValueString = new StringBuilder();
            int length = size();
            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    keyValueString.append(this.pairDelimiter);
                }
                keyValueString.append(OAuthUtil.encode(getKey(i))).append(this.keyValueStartDelimiter).append(OAuthUtil.encode(getValue(i))).append(this.keyValueEndDelimiter);
            }
            return keyValueString.toString();
        }
    }

    static class HeaderKeyValuePair extends KeyValuePair {
        public HeaderKeyValuePair() {
            super("=\"", "\"", ", ");
        }
    }

    private static class QueryKeyValuePair extends KeyValuePair {
        public QueryKeyValuePair() {
            super("=", StringUtil.EMPTY_STRING, "&");
        }
    }

    @Deprecated
    public OAuthHelper(String requestTokenUrl, String userAuthorizationUrl, String accessTokenUrl, OAuthSigner signer) {
        this(requestTokenUrl, userAuthorizationUrl, accessTokenUrl, signer, new OAuthHttpClient());
    }

    @Deprecated
    public OAuthHelper(String requestTokenUrl, String userAuthorizationUrl, String accessTokenUrl, OAuthSigner signer, OAuthHttpClient httpClient) {
        this.requestTokenUrl = requestTokenUrl;
        this.userAuthorizationUrl = userAuthorizationUrl;
        this.accessTokenUrl = accessTokenUrl;
        this.signer = signer;
        this.httpClient = httpClient;
    }

    public OAuthHelper(String requestTokenUrl, String userAuthorizationUrl, String accessTokenUrl, String revokeTokenUrl, OAuthSigner signer) {
        this(requestTokenUrl, userAuthorizationUrl, accessTokenUrl, revokeTokenUrl, signer, new OAuthHttpClient());
    }

    public OAuthHelper(String requestTokenUrl, String userAuthorizationUrl, String accessTokenUrl, String revokeTokenUrl, OAuthSigner signer, OAuthHttpClient httpClient) {
        this.requestTokenUrl = requestTokenUrl;
        this.userAuthorizationUrl = userAuthorizationUrl;
        this.accessTokenUrl = accessTokenUrl;
        this.revokeTokenUrl = revokeTokenUrl;
        this.signer = signer;
        this.httpClient = httpClient;
    }

    public String getAccessTokenUrl() {
        return this.accessTokenUrl;
    }

    public void setAccessTokenUrl(String url) {
        this.accessTokenUrl = url;
    }

    public String getRequestTokenUrl() {
        return this.requestTokenUrl;
    }

    public void setRequestTokenUrl(String url) {
        this.requestTokenUrl = url;
    }

    public String getUserAuthorizationUrl() {
        return this.userAuthorizationUrl;
    }

    public void setUserAuthorizationUrl(String url) {
        this.userAuthorizationUrl = url;
    }

    public String getRevokeTokenUrl() {
        return this.revokeTokenUrl;
    }

    public void setRevokeTokenUrl(String url) {
        this.revokeTokenUrl = url;
    }

    public void getUnauthorizedRequestToken(OAuthParameters oauthParameters) throws OAuthException {
        new TwoLeggedOAuthHelper(this.signer, oauthParameters).validateInputParameters();
        boolean oauthCallbackExists = false;
        if (oauthParameters.checkOAuthCallbackExists()) {
            oauthParameters.addCustomBaseParameter(OAuthParameters.OAUTH_CALLBACK_KEY, oauthParameters.getOAuthCallback());
            oauthCallbackExists = true;
        }
        Map<String, String> queryString = OAuthUtil.parseQuerystring(this.httpClient.getResponse(getOAuthUrl(this.requestTokenUrl, "GET", oauthParameters)));
        oauthParameters.setOAuthToken((String) queryString.get(OAuthParameters.OAUTH_TOKEN_KEY));
        oauthParameters.setOAuthTokenSecret((String) queryString.get(OAuthParameters.OAUTH_TOKEN_SECRET_KEY));
        if (oauthCallbackExists) {
            oauthParameters.removeCustomBaseParameter(OAuthParameters.OAUTH_CALLBACK_KEY);
        }
        oauthParameters.reset();
    }

    @Deprecated
    public String getUserAuthorizationUrl(OAuthParameters oauthParameters) throws OAuthException {
        getUnauthorizedRequestToken(oauthParameters);
        return createUserAuthorizationUrl(oauthParameters);
    }

    public String createUserAuthorizationUrl(OAuthParameters oauthParameters) {
        KeyValuePair queryParams = new QueryKeyValuePair();
        queryParams.add(OAuthParameters.OAUTH_TOKEN_KEY, oauthParameters.getOAuthToken());
        if (oauthParameters.getOAuthCallback().length() > 0) {
            queryParams.add(OAuthParameters.OAUTH_CALLBACK_KEY, oauthParameters.getOAuthCallback());
        }
        return this.userAuthorizationUrl + "?" + queryParams.toString();
    }

    public void getOAuthParametersFromCallback(URL url, OAuthParameters oauthParameters) {
        getOAuthParametersFromCallback(url.getQuery(), oauthParameters);
    }

    public void getOAuthParametersFromCallback(String queryString, OAuthParameters oauthParameters) {
        Map<String, String> params = OAuthUtil.parseQuerystring(queryString);
        oauthParameters.setOAuthToken((String) params.get(OAuthParameters.OAUTH_TOKEN_KEY));
        if (params.get(OAuthParameters.OAUTH_TOKEN_SECRET_KEY) != null) {
            oauthParameters.setOAuthTokenSecret((String) params.get(OAuthParameters.OAUTH_TOKEN_SECRET_KEY));
        }
        if (params.get(OAuthParameters.OAUTH_VERIFIER_KEY) != null) {
            oauthParameters.setOAuthVerifier((String) params.get(OAuthParameters.OAUTH_VERIFIER_KEY));
        }
    }

    public String getAccessToken(URL url, OAuthParameters oauthParameters) throws OAuthException {
        return getAccessToken(url.getQuery(), oauthParameters);
    }

    public String getAccessToken(String queryString, OAuthParameters oauthParameters) throws OAuthException {
        getOAuthParametersFromCallback(queryString, oauthParameters);
        return getAccessToken(oauthParameters);
    }

    public String getAccessToken(OAuthParameters oauthParameters) throws OAuthException {
        new TwoLeggedOAuthHelper(this.signer, oauthParameters).validateInputParameters();
        oauthParameters.assertOAuthTokenExists();
        if (this.signer instanceof OAuthHmacSha1Signer) {
            oauthParameters.assertOAuthTokenSecretExists();
        }
        Map<String, String> queryString = OAuthUtil.parseQuerystring(this.httpClient.getResponse(getOAuthUrl(this.accessTokenUrl, "GET", oauthParameters)));
        oauthParameters.setOAuthToken((String) queryString.get(OAuthParameters.OAUTH_TOKEN_KEY));
        oauthParameters.setOAuthTokenSecret((String) queryString.get(OAuthParameters.OAUTH_TOKEN_SECRET_KEY));
        oauthParameters.reset();
        return oauthParameters.getOAuthToken();
    }

    public String getAuthorizationHeader(String requestUrl, String httpMethod, OAuthParameters oauthParameters) throws OAuthException {
        TwoLeggedOAuthHelper helper = new TwoLeggedOAuthHelper(this.signer, oauthParameters);
        helper.validateInputParameters();
        if (!containsUser(requestUrl)) {
            oauthParameters.assertOAuthTokenExists();
            if (this.signer instanceof OAuthHmacSha1Signer) {
                oauthParameters.assertOAuthTokenSecretExists();
            }
        }
        return helper.addParametersAndRetrieveHeader(requestUrl, httpMethod);
    }

    public void revokeToken(OAuthParameters oauthParameters) throws OAuthException {
        Map<String, String> headers = new HashMap();
        headers.put(HttpHeaders.AUTHORIZATION, getAuthorizationHeader(this.revokeTokenUrl, "GET", oauthParameters));
        try {
            this.httpClient.getResponse(new URL(this.revokeTokenUrl), headers);
        } catch (Throwable mue) {
            throw new OAuthException(mue);
        }
    }

    public URL getOAuthUrl(String baseUrl, String httpMethod, OAuthParameters oauthParameters) throws OAuthException {
        new TwoLeggedOAuthHelper(this.signer, oauthParameters).addCommonRequestParameters(baseUrl, httpMethod);
        KeyValuePair queryParams = new QueryKeyValuePair();
        for (Entry<String, String> e : oauthParameters.getBaseParameters().entrySet()) {
            if (((String) e.getValue()).length() > 0) {
                queryParams.add((String) e.getKey(), (String) e.getValue());
            }
        }
        queryParams.add(OAuthParameters.OAUTH_SIGNATURE_KEY, oauthParameters.getOAuthSignature());
        StringBuilder fullUrl = new StringBuilder(baseUrl);
        fullUrl.append(baseUrl.indexOf("?") > 0 ? "&" : "?");
        fullUrl.append(queryParams.toString());
        try {
            return new URL(fullUrl.toString());
        } catch (Throwable mue) {
            throw new OAuthException(mue);
        }
    }

    private boolean containsUser(String requestUrl) {
        return requestUrl.contains(OAuthParameters.XOAUTH_REQUESTOR_ID_KEY);
    }
}
