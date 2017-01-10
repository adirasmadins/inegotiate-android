package com.google.gdata.client.http;

import com.google.common.net.HttpHeaders;
import com.google.gdata.client.authn.oauth.GoogleOAuthParameters;
import com.google.gdata.data.ILink.Rel;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.common.base.CharEscapers;
import com.google.gdata.util.common.base.Charsets;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.common.io.CharStreams;
import com.google.gdata.util.common.util.Base64;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.util.Map;

public class AuthSubUtil {
    private static final String DEFAULT_DOMAIN = "www.google.com";
    private static final String DEFAULT_PROTOCOL = "https";
    private static final SecureRandom RANDOM;

    private enum SignatureAlgorithm {
        DSA_SHA1("dsa-sha1", "SHA1withDSA"),
        RSA_SHA1("rsa-sha1", "SHA1withRSA");
        
        private final String authSubName;
        private final String jcaName;

        private SignatureAlgorithm(String authSubName, String jcaName) {
            this.authSubName = authSubName;
            this.jcaName = jcaName;
        }

        public String toString() {
            return this.jcaName;
        }

        public String getAuthSubName() {
            return this.authSubName;
        }

        public String getJCAName() {
            return this.jcaName;
        }
    }

    static {
        RANDOM = new SecureRandom();
    }

    public static String getRequestUrl(String nextUrl, String scope, boolean secure, boolean session) {
        return getRequestUrl(DEFAULT_PROTOCOL, DEFAULT_DOMAIN, nextUrl, scope, secure, session);
    }

    public static String getRequestUrl(String protocol, String domain, String nextUrl, String scope, boolean secure, boolean session) {
        StringBuffer url = new StringBuffer(protocol).append("://");
        url.append(domain).append("/accounts/AuthSubRequest");
        addParameter(url, Rel.NEXT, nextUrl);
        addParameter(url, GoogleOAuthParameters.SCOPE_KEY, scope);
        addParameter(url, "secure", secure ? "1" : "0");
        addParameter(url, "session", session ? "1" : "0");
        return url.toString();
    }

    public static String getRequestUrl(String hostedDomain, String nextUrl, String scope, boolean secure, boolean session) {
        return getRequestUrl(DEFAULT_PROTOCOL, DEFAULT_DOMAIN, hostedDomain, nextUrl, scope, secure, session);
    }

    public static String getRequestUrl(String protocol, String domain, String hostedDomain, String nextUrl, String scope, boolean secure, boolean session) {
        StringBuffer url = new StringBuffer(getRequestUrl(protocol, domain, nextUrl, scope, secure, session));
        addParameter(url, "hd", hostedDomain);
        return url.toString();
    }

    public static String getTokenFromReply(URL url) {
        return getTokenFromReply(url.getQuery());
    }

    public static String getTokenFromReply(String queryString) {
        String encoded = (String) StringUtil.lowercaseKeys(StringUtil.string2Map(queryString, "&", "=", true)).get("token");
        if (encoded == null) {
            return null;
        }
        try {
            return URLDecoder.decode(encoded, StringEncodings.UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static PrivateKey getPrivateKeyFromKeystore(String keystore, String keystorePass, String keyAlias, String keyPass) throws IOException, GeneralSecurityException {
        Throwable th;
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        FileInputStream keyStream = null;
        try {
            FileInputStream keyStream2 = new FileInputStream(keystore);
            try {
                keyStore.load(keyStream2, keystorePass.toCharArray());
                PrivateKey privateKey = (PrivateKey) keyStore.getKey(keyAlias, keyPass.toCharArray());
                if (keyStream2 != null) {
                    keyStream2.close();
                }
                return privateKey;
            } catch (Throwable th2) {
                th = th2;
                keyStream = keyStream2;
                if (keyStream != null) {
                    keyStream.close();
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            if (keyStream != null) {
                keyStream.close();
            }
            throw th;
        }
    }

    public static String exchangeForSessionToken(String onetimeUseToken, PrivateKey key) throws IOException, GeneralSecurityException, AuthenticationException {
        return exchangeForSessionToken(DEFAULT_PROTOCOL, DEFAULT_DOMAIN, onetimeUseToken, key);
    }

    public static String exchangeForSessionToken(String protocol, String domain, String onetimeUseToken, PrivateKey key) throws IOException, GeneralSecurityException, AuthenticationException {
        URL url = new URL(getSessionTokenUrl(protocol, domain));
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestProperty(HttpHeaders.AUTHORIZATION, formAuthorizationHeader(onetimeUseToken, key, url, "GET"));
        if (httpConn.getResponseCode() == 200) {
            return (String) StringUtil.lowercaseKeys(StringUtil.string2Map(CharStreams.toString(new InputStreamReader(httpConn.getInputStream(), Charsets.ISO_8859_1)), "\n", "=", true)).get("token");
        }
        throw new AuthenticationException(httpConn.getResponseCode() + ": " + httpConn.getResponseMessage());
    }

    public static Map<String, String> getTokenInfo(String token, PrivateKey key) throws IOException, GeneralSecurityException, AuthenticationException {
        return getTokenInfo(DEFAULT_PROTOCOL, DEFAULT_DOMAIN, token, key);
    }

    public static Map<String, String> getTokenInfo(String protocol, String domain, String token, PrivateKey key) throws IOException, GeneralSecurityException, AuthenticationException {
        URL url = new URL(getTokenInfoUrl(protocol, domain));
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestProperty(HttpHeaders.AUTHORIZATION, formAuthorizationHeader(token, key, url, "GET"));
        if (httpConn.getResponseCode() == 200) {
            return StringUtil.string2Map(CharStreams.toString(new InputStreamReader(httpConn.getInputStream(), Charsets.ISO_8859_1)).trim(), "\n", "=", true);
        }
        throw new AuthenticationException(httpConn.getResponseCode() + ": " + httpConn.getResponseMessage());
    }

    public static void revokeToken(String token, PrivateKey key) throws IOException, GeneralSecurityException, AuthenticationException {
        revokeToken(DEFAULT_PROTOCOL, DEFAULT_DOMAIN, token, key);
    }

    public static void revokeToken(String protocol, String domain, String token, PrivateKey key) throws IOException, GeneralSecurityException, AuthenticationException {
        URL url = new URL(getRevokeTokenUrl(protocol, domain));
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setRequestProperty(HttpHeaders.AUTHORIZATION, formAuthorizationHeader(token, key, url, "GET"));
        if (httpConn.getResponseCode() != 200) {
            throw new AuthenticationException(httpConn.getResponseCode() + ": " + httpConn.getResponseMessage());
        }
    }

    public static String formAuthorizationHeader(String token, PrivateKey key, URL requestUrl, String requestMethod) throws GeneralSecurityException {
        if (key == null) {
            return String.format("AuthSub token=\"%s\"", new Object[]{token});
        }
        long timestamp = System.currentTimeMillis() / 1000;
        long nonce = RANDOM.nextLong();
        String encodedSignature = Base64.encode(sign(key, String.format("%s %s %d %s", new Object[]{requestMethod, requestUrl.toExternalForm(), Long.valueOf(timestamp), unsignedLongToString(nonce)}), getSigAlg(key)));
        return String.format("AuthSub token=\"%s\" data=\"%s\" sig=\"%s\" sigalg=\"%s\"", new Object[]{token, dataToSign, encodedSignature, sigAlg.getAuthSubName()});
    }

    private static void addParameter(StringBuffer url, String name, String value) {
        name = CharEscapers.uriEscaper().escape(name);
        value = CharEscapers.uriEscaper().escape(value);
        if (url.indexOf("?") != -1) {
            switch (url.charAt(url.length() - 1)) {
                case '&':
                case '?':
                    break;
                default:
                    url.append('&');
                    break;
            }
        }
        url.append('?');
        url.append(name).append('=').append(value);
    }

    private static byte[] sign(PrivateKey key, String data, SignatureAlgorithm algorithm) throws GeneralSecurityException {
        Signature signature = Signature.getInstance(algorithm.getJCAName());
        signature.initSign(key);
        signature.update(data.getBytes());
        return signature.sign();
    }

    private static SignatureAlgorithm getSigAlg(PrivateKey key) {
        String algorithm = key.getAlgorithm();
        if ("dsa".equalsIgnoreCase(algorithm)) {
            return SignatureAlgorithm.DSA_SHA1;
        }
        if ("rsa".equalsIgnoreCase(algorithm)) {
            return SignatureAlgorithm.RSA_SHA1;
        }
        throw new IllegalArgumentException("Unknown algorithm in private key.");
    }

    private static String getSessionTokenUrl(String protocol, String domain) {
        return protocol + "://" + domain + "/accounts/AuthSubSessionToken";
    }

    private static String getRevokeTokenUrl(String protocol, String domain) {
        return protocol + "://" + domain + "/accounts/AuthSubRevokeToken";
    }

    private static String getTokenInfoUrl(String protocol, String domain) {
        return protocol + "://" + domain + "/accounts/AuthSubTokenInfo";
    }

    private static String unsignedLongToString(long value) {
        if (value >= 0) {
            return Long.toString(value);
        }
        char[] cbuf = new char[20];
        int dst = 20;
        long top = value >>> 32;
        long bot = (value & 4294967295L) + ((top % ((long) 10)) << 32);
        top /= (long) 10;
        while (true) {
            if (bot <= 0 && top <= 0) {
                return new String(cbuf, dst, 20 - dst);
            }
            dst--;
            cbuf[dst] = Character.forDigit((int) (bot % ((long) 10)), 10);
            bot = (bot / ((long) 10)) + ((top % ((long) 10)) << 32);
            top /= (long) 10;
        }
    }
}
