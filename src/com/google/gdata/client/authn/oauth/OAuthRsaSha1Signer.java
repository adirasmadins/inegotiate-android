package com.google.gdata.client.authn.oauth;

import com.google.gdata.util.common.util.Base64;
import com.google.gdata.util.common.util.Base64DecoderException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;

public class OAuthRsaSha1Signer implements OAuthSigner {
    PrivateKey privateKey;

    public OAuthRsaSha1Signer(PrivateKey privateKey) throws OAuthException {
        setPrivateKey(privateKey);
    }

    public OAuthRsaSha1Signer(String privateKeyString) throws OAuthException {
        if (privateKeyString == null) {
            throw new OAuthException("Private key string cannot be null");
        } else if (privateKeyString.length() == 0) {
            throw new OAuthException("Private key string cannot be empty");
        } else {
            try {
                setPrivateKey(RsaSha1PrivateKeyHelper.getPrivateKey(privateKeyString));
            } catch (Base64DecoderException e) {
                throw new OAuthException("Invalid private key", e);
            } catch (NoSuchAlgorithmException e2) {
                throw new OAuthException("Invalid private key", e2);
            } catch (InvalidKeySpecException e3) {
                throw new OAuthException("Invalid private key", e3);
            }
        }
    }

    public OAuthRsaSha1Signer(byte[] privateKeyBytes) throws OAuthException {
        if (privateKeyBytes == null) {
            throw new OAuthException("Private key bytes cannot be null");
        } else if (privateKeyBytes.length == 0) {
            throw new OAuthException("Private key bytes cannot be empty");
        } else {
            try {
                setPrivateKey(RsaSha1PrivateKeyHelper.getPrivateKey(privateKeyBytes));
            } catch (NoSuchAlgorithmException e) {
                throw new OAuthException("Invalid private key", e);
            } catch (InvalidKeySpecException e2) {
                throw new OAuthException("Invalid private key", e2);
            }
        }
    }

    public void setPrivateKey(PrivateKey privateKey) throws OAuthException {
        if (privateKey == null) {
            throw new OAuthException("Private key cannot be null");
        }
        this.privateKey = privateKey;
    }

    public String getSignature(String baseString, OAuthParameters oauthParameters) throws OAuthException {
        if (this.privateKey == null) {
            throw new OAuthException("Private key cannot be null");
        }
        try {
            Signature signer = Signature.getInstance("SHA1withRSA");
            signer.initSign(this.privateKey);
            signer.update(baseString.getBytes(StringEncodings.UTF8));
            return Base64.encode(signer.sign());
        } catch (NoSuchAlgorithmException e) {
            throw new OAuthException("Error generating signature", e);
        } catch (InvalidKeyException e2) {
            throw new OAuthException("Error generating signature", e2);
        } catch (SignatureException e3) {
            throw new OAuthException("Error generating signature", e3);
        } catch (UnsupportedEncodingException e4) {
            throw new OAuthException("Error generating signature", e4);
        }
    }

    public String getSignatureMethod() {
        return "RSA-SHA1";
    }
}
