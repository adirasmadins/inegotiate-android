package com.google.gdata.client.authn.oauth;

import com.amazonaws.services.s3.internal.Constants;
import com.google.gdata.util.common.util.Base64;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class OAuthHmacSha1Signer implements OAuthSigner {
    public String getSignature(String baseString, OAuthParameters oauthParameters) throws OAuthException {
        if (oauthParameters == null) {
            try {
                throw new OAuthException("OAuth parameters cannot be null");
            } catch (Throwable e) {
                throw new OAuthException(e);
            } catch (Throwable e2) {
                throw new OAuthException(e2);
            } catch (Throwable e22) {
                throw new OAuthException(e22);
            }
        }
        SecretKey key = new SecretKeySpec(getKey(oauthParameters).getBytes(StringEncodings.UTF8), Constants.HMAC_SHA1_ALGORITHM);
        Mac mac = Mac.getInstance(Constants.HMAC_SHA1_ALGORITHM);
        mac.init(key);
        return Base64.encode(mac.doFinal(baseString.getBytes(StringEncodings.UTF8)));
    }

    private String getKey(OAuthParameters oauthParameters) {
        return OAuthUtil.encode(oauthParameters.getOAuthConsumerSecret()) + "&" + OAuthUtil.encode(oauthParameters.getOAuthTokenSecret());
    }

    public String getSignatureMethod() {
        return "HMAC-SHA1";
    }
}
