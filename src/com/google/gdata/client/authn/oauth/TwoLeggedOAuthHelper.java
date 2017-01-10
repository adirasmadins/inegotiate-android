package com.google.gdata.client.authn.oauth;

import java.util.Map.Entry;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class TwoLeggedOAuthHelper {
    private final OAuthParameters parameters;
    private final OAuthSigner signer;

    public TwoLeggedOAuthHelper(OAuthSigner signer, OAuthParameters parameters) {
        this.signer = signer;
        this.parameters = parameters;
    }

    void validateInputParameters() throws OAuthException {
        this.parameters.assertOAuthConsumerKeyExists();
        if (this.signer instanceof OAuthHmacSha1Signer) {
            this.parameters.assertOAuthConsumerSecretExists();
        }
    }

    void addCommonRequestParameters(String baseUrl, String httpMethod) throws OAuthException {
        if (this.parameters.getOAuthSignatureMethod().length() == 0) {
            this.parameters.setOAuthSignatureMethod(this.signer.getSignatureMethod());
        }
        if (this.parameters.getOAuthTimestamp().length() == 0) {
            this.parameters.setOAuthTimestamp(OAuthUtil.getTimestamp());
        }
        if (this.parameters.getOAuthNonce().length() == 0) {
            this.parameters.setOAuthNonce(OAuthUtil.getNonce());
        }
        if (this.parameters.getOAuthSignature().length() == 0) {
            this.parameters.setOAuthSignature(this.signer.getSignature(OAuthUtil.getSignatureBaseString(baseUrl, httpMethod, this.parameters.getBaseParameters()), this.parameters));
        }
    }

    public String getAuthorizationHeader(String requestUrl, String httpMethod) throws OAuthException {
        validateInputParameters();
        return addParametersAndRetrieveHeader(requestUrl, httpMethod);
    }

    String addParametersAndRetrieveHeader(String requestUrl, String httpMethod) throws OAuthException {
        addCommonRequestParameters(requestUrl, httpMethod);
        KeyValuePair headerParams = new HeaderKeyValuePair();
        headerParams.add(OAuthParameters.REALM_KEY, this.parameters.getRealm());
        headerParams.add(OAuthParameters.OAUTH_SIGNATURE_KEY, this.parameters.getOAuthSignature());
        for (Entry<String, String> e : this.parameters.getBaseParameters().entrySet()) {
            if (((String) e.getValue()).length() > 0) {
                headerParams.add((String) e.getKey(), (String) e.getValue());
            }
        }
        this.parameters.reset();
        return OAuthParameters.OAUTH_KEY + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + headerParams.toString();
    }
}
