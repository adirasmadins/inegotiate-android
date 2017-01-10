package com.google.gdata.client.authn.oauth;

import com.google.gdata.util.common.base.StringUtil;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class OAuthParameters {
    public static final String OAUTH_CALLBACK_KEY = "oauth_callback";
    public static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    public static final String OAUTH_CONSUMER_SECRET = "oauth_consumer_secret";
    public static final String OAUTH_KEY = "OAuth";
    public static final String OAUTH_NONCE_KEY = "oauth_nonce";
    public static final String OAUTH_SIGNATURE_KEY = "oauth_signature";
    public static final String OAUTH_SIGNATURE_METHOD_KEY = "oauth_signature_method";
    public static final String OAUTH_TIMESTAMP_KEY = "oauth_timestamp";
    public static final String OAUTH_TOKEN_KEY = "oauth_token";
    public static final String OAUTH_TOKEN_SECRET_KEY = "oauth_token_secret";
    public static final String OAUTH_VERIFIER_KEY = "oauth_verifier";
    public static final String REALM_KEY = "realm";
    public static final String XOAUTH_REQUESTOR_ID_KEY = "xoauth_requestor_id";
    protected Map<String, String> baseParameters;
    protected Map<String, String> extraParameters;
    private OAuthType oauthType;

    public enum OAuthType {
        TWO_LEGGED_OAUTH,
        THREE_LEGGED_OAUTH
    }

    public OAuthParameters() {
        this.oauthType = OAuthType.THREE_LEGGED_OAUTH;
        this.baseParameters = new HashMap();
        this.extraParameters = new HashMap();
    }

    public Map<String, String> getBaseParameters() {
        return Collections.unmodifiableMap(this.baseParameters);
    }

    public Map<String, String> getExtraParameters() {
        return Collections.unmodifiableMap(this.extraParameters);
    }

    public void addCustomBaseParameter(String key, String value) {
        put(key, value, this.baseParameters);
    }

    public void removeCustomBaseParameter(String key) {
        remove(key, this.baseParameters);
    }

    public void addExtraParameter(String key, String value) {
        put(key, value, this.extraParameters);
    }

    public void reset() {
        remove(OAUTH_NONCE_KEY, this.baseParameters);
        remove(OAUTH_TIMESTAMP_KEY, this.baseParameters);
        remove(OAUTH_VERIFIER_KEY, this.baseParameters);
        remove(OAUTH_SIGNATURE_KEY, this.extraParameters);
    }

    public String getOAuthConsumerKey() {
        return get(OAUTH_CONSUMER_KEY, this.baseParameters);
    }

    public void setOAuthConsumerKey(String consumerKey) {
        put(OAUTH_CONSUMER_KEY, consumerKey, this.baseParameters);
    }

    public boolean checkOAuthConsumerKeyExists() {
        return checkExists(OAUTH_CONSUMER_KEY, this.baseParameters);
    }

    public void assertOAuthConsumerKeyExists() throws OAuthException {
        assertExists(OAUTH_CONSUMER_KEY, this.baseParameters);
    }

    public String getOAuthConsumerSecret() {
        return get(OAUTH_CONSUMER_SECRET, this.extraParameters);
    }

    public void setOAuthConsumerSecret(String consumerSecret) {
        put(OAUTH_CONSUMER_SECRET, consumerSecret, this.extraParameters);
    }

    public boolean checkOAuthConsumerSecretExists() {
        return checkExists(OAUTH_CONSUMER_SECRET, this.extraParameters);
    }

    public void assertOAuthConsumerSecretExists() throws OAuthException {
        assertExists(OAUTH_CONSUMER_SECRET, this.extraParameters);
    }

    public String getOAuthNonce() {
        return get(OAUTH_NONCE_KEY, this.baseParameters);
    }

    public void setOAuthNonce(String oauthNonce) {
        put(OAUTH_NONCE_KEY, oauthNonce, this.baseParameters);
    }

    public boolean checkOAuthNonceExists() {
        return checkExists(OAUTH_NONCE_KEY, this.baseParameters);
    }

    public void assertOAuthNonceExists() throws OAuthException {
        assertExists(OAUTH_NONCE_KEY, this.baseParameters);
    }

    public String getOAuthSignature() {
        return get(OAUTH_SIGNATURE_KEY, this.extraParameters);
    }

    public void setOAuthSignature(String signature) {
        put(OAUTH_SIGNATURE_KEY, signature, this.extraParameters);
    }

    public boolean checkOAuthSignatureExists() {
        return checkExists(OAUTH_SIGNATURE_KEY, this.extraParameters);
    }

    public void assertOAuthSignatureExists() throws OAuthException {
        assertExists(OAUTH_SIGNATURE_KEY, this.extraParameters);
    }

    public String getOAuthSignatureMethod() {
        return get(OAUTH_SIGNATURE_METHOD_KEY, this.baseParameters);
    }

    public void setOAuthSignatureMethod(String signatureMethod) {
        put(OAUTH_SIGNATURE_METHOD_KEY, signatureMethod, this.baseParameters);
    }

    public boolean checkOAuthSignatureMethodExists() {
        return checkExists(OAUTH_SIGNATURE_METHOD_KEY, this.baseParameters);
    }

    public void assertOAuthSignatureMethodExists() throws OAuthException {
        assertExists(OAUTH_SIGNATURE_METHOD_KEY, this.baseParameters);
    }

    public String getOAuthTimestamp() {
        return get(OAUTH_TIMESTAMP_KEY, this.baseParameters);
    }

    public void setOAuthTimestamp(String timestamp) {
        put(OAUTH_TIMESTAMP_KEY, timestamp, this.baseParameters);
    }

    public boolean checkOAuthTimestampExists() {
        return checkExists(OAUTH_TIMESTAMP_KEY, this.baseParameters);
    }

    public void assertOAuthTimestampExists() throws OAuthException {
        assertExists(OAUTH_TIMESTAMP_KEY, this.baseParameters);
    }

    public String getOAuthToken() {
        return get(OAUTH_TOKEN_KEY, this.baseParameters);
    }

    public void setOAuthToken(String token) {
        put(OAUTH_TOKEN_KEY, token, this.baseParameters);
    }

    public boolean checkOAuthTokenExists() {
        return checkExists(OAUTH_TOKEN_KEY, this.baseParameters);
    }

    public void assertOAuthTokenExists() throws OAuthException {
        assertExists(OAUTH_TOKEN_KEY, this.baseParameters);
    }

    public String getOAuthTokenSecret() {
        return get(OAUTH_TOKEN_SECRET_KEY, this.extraParameters);
    }

    public void setOAuthTokenSecret(String tokenSecret) {
        put(OAUTH_TOKEN_SECRET_KEY, tokenSecret, this.extraParameters);
    }

    public boolean checkOAuthTokenSecretExists() {
        return checkExists(OAUTH_TOKEN_SECRET_KEY, this.extraParameters);
    }

    public void assertOAuthTokenSecretExists() throws OAuthException {
        assertExists(OAUTH_TOKEN_SECRET_KEY, this.extraParameters);
    }

    public OAuthType getOAuthType() {
        return this.oauthType;
    }

    public void setOAuthType(OAuthType type) {
        this.oauthType = type;
    }

    public String getOAuthVerifier() {
        return get(OAUTH_VERIFIER_KEY, this.baseParameters);
    }

    public void setOAuthVerifier(String verifier) {
        put(OAUTH_VERIFIER_KEY, verifier, this.baseParameters);
    }

    public boolean checkOAuthVerifierExists() {
        return checkExists(OAUTH_VERIFIER_KEY, this.baseParameters);
    }

    public void assertOAuthVerifierExists() throws OAuthException {
        assertExists(OAUTH_VERIFIER_KEY, this.baseParameters);
    }

    public String getOAuthCallback() {
        return get(OAUTH_CALLBACK_KEY, this.extraParameters);
    }

    public void setOAuthCallback(String oauthCallback) {
        put(OAUTH_CALLBACK_KEY, oauthCallback, this.extraParameters);
    }

    public boolean checkOAuthCallbackExists() {
        return checkExists(OAUTH_CALLBACK_KEY, this.extraParameters);
    }

    public void assertOAuthCallbackExists() throws OAuthException {
        assertExists(OAUTH_CALLBACK_KEY, this.extraParameters);
    }

    public String getRealm() {
        return get(REALM_KEY, this.extraParameters);
    }

    public void setRealm(String realm) {
        put(REALM_KEY, realm, this.extraParameters);
    }

    public boolean checkRealmExists() {
        return checkExists(REALM_KEY, this.extraParameters);
    }

    public void assertRealmExists() throws OAuthException {
        assertExists(REALM_KEY, this.extraParameters);
    }

    protected String get(String key, Map<String, String> params) {
        String s = (String) params.get(key);
        return s == null ? StringUtil.EMPTY_STRING : s;
    }

    protected void put(String key, String value, Map<String, String> params) {
        params.put(key, value);
    }

    protected void remove(String key, Map<String, String> params) {
        params.remove(key);
    }

    protected boolean checkExists(String key, Map<String, String> params) {
        return get(key, params).length() > 0;
    }

    protected void assertExists(String key, Map<String, String> params) throws OAuthException {
        if (!checkExists(key, params)) {
            throw new OAuthException(key + " does not exist.");
        }
    }
}
