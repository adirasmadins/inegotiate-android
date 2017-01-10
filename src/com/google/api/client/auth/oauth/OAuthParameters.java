package com.google.api.client.auth.oauth;

import com.google.api.client.escape.PercentEscaper;
import com.google.api.client.http.HttpExecuteIntercepter;
import com.google.api.client.http.HttpTransport;
import java.security.SecureRandom;
import java.util.TreeMap;

public final class OAuthParameters {
    private static final PercentEscaper ESCAPER;
    private static final SecureRandom RANDOM;
    public String callback;
    public String consumerKey;
    public String nonce;
    public String realm;
    public String signature;
    public String signatureMethod;
    public OAuthSigner signer;
    public String timestamp;
    public String token;
    public String verifier;
    public String version;

    static {
        RANDOM = new SecureRandom();
        ESCAPER = new PercentEscaper("-_.~", false);
    }

    public void computeNonce() {
        this.nonce = Long.toHexString(Math.abs(RANDOM.nextLong()));
    }

    public void computeTimestamp() {
        this.timestamp = Long.toString(System.currentTimeMillis() / 1000);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void computeSignature(java.lang.String r25, com.google.api.client.http.GenericUrl r26) throws java.security.GeneralSecurityException {
        /*
        r24 = this;
        r0 = r24;
        r0 = r0.signer;
        r20 = r0;
        r19 = r20.getSignatureMethod();
        r0 = r19;
        r1 = r24;
        r1.signatureMethod = r0;
        r13 = new java.util.TreeMap;
        r13.<init>();
        r22 = "oauth_callback";
        r0 = r24;
        r0 = r0.callback;
        r23 = r0;
        r0 = r24;
        r1 = r22;
        r2 = r23;
        r0.putParameterIfValueNotNull(r13, r1, r2);
        r22 = "oauth_consumer_key";
        r0 = r24;
        r0 = r0.consumerKey;
        r23 = r0;
        r0 = r24;
        r1 = r22;
        r2 = r23;
        r0.putParameterIfValueNotNull(r13, r1, r2);
        r22 = "oauth_nonce";
        r0 = r24;
        r0 = r0.nonce;
        r23 = r0;
        r0 = r24;
        r1 = r22;
        r2 = r23;
        r0.putParameterIfValueNotNull(r13, r1, r2);
        r22 = "oauth_signature_method";
        r0 = r24;
        r1 = r22;
        r2 = r19;
        r0.putParameterIfValueNotNull(r13, r1, r2);
        r22 = "oauth_timestamp";
        r0 = r24;
        r0 = r0.timestamp;
        r23 = r0;
        r0 = r24;
        r1 = r22;
        r2 = r23;
        r0.putParameterIfValueNotNull(r13, r1, r2);
        r22 = "oauth_token";
        r0 = r24;
        r0 = r0.token;
        r23 = r0;
        r0 = r24;
        r1 = r22;
        r2 = r23;
        r0.putParameterIfValueNotNull(r13, r1, r2);
        r22 = "oauth_verifier";
        r0 = r24;
        r0 = r0.verifier;
        r23 = r0;
        r0 = r24;
        r1 = r22;
        r2 = r23;
        r0.putParameterIfValueNotNull(r13, r1, r2);
        r22 = "oauth_version";
        r0 = r24;
        r0 = r0.version;
        r23 = r0;
        r0 = r24;
        r1 = r22;
        r2 = r23;
        r0.putParameterIfValueNotNull(r13, r1, r2);
        r22 = r26.entrySet();
        r7 = r22.iterator();
    L_0x009f:
        r22 = r7.hasNext();
        if (r22 == 0) goto L_0x00df;
    L_0x00a5:
        r5 = r7.next();
        r5 = (java.util.Map.Entry) r5;
        r21 = r5.getValue();
        if (r21 == 0) goto L_0x009f;
    L_0x00b1:
        r9 = r5.getKey();
        r9 = (java.lang.String) r9;
        r0 = r21;
        r0 = r0 instanceof java.util.Collection;
        r22 = r0;
        if (r22 == 0) goto L_0x00d7;
    L_0x00bf:
        r21 = (java.util.Collection) r21;
        r8 = r21.iterator();
    L_0x00c5:
        r22 = r8.hasNext();
        if (r22 == 0) goto L_0x009f;
    L_0x00cb:
        r16 = r8.next();
        r0 = r24;
        r1 = r16;
        r0.putParameter(r13, r9, r1);
        goto L_0x00c5;
    L_0x00d7:
        r0 = r24;
        r1 = r21;
        r0.putParameter(r13, r9, r1);
        goto L_0x009f;
    L_0x00df:
        r14 = new java.lang.StringBuilder;
        r14.<init>();
        r6 = 1;
        r22 = r13.entrySet();
        r7 = r22.iterator();
    L_0x00ed:
        r22 = r7.hasNext();
        if (r22 == 0) goto L_0x0127;
    L_0x00f3:
        r4 = r7.next();
        r4 = (java.util.Map.Entry) r4;
        if (r6 == 0) goto L_0x011f;
    L_0x00fb:
        r6 = 0;
    L_0x00fc:
        r22 = r4.getKey();
        r22 = (java.lang.String) r22;
        r0 = r22;
        r14.append(r0);
        r21 = r4.getValue();
        r21 = (java.lang.String) r21;
        if (r21 == 0) goto L_0x00ed;
    L_0x010f:
        r22 = 61;
        r0 = r22;
        r22 = r14.append(r0);
        r0 = r22;
        r1 = r21;
        r0.append(r1);
        goto L_0x00ed;
    L_0x011f:
        r22 = 38;
        r0 = r22;
        r14.append(r0);
        goto L_0x00fc;
    L_0x0127:
        r11 = r14.toString();
        r10 = new com.google.api.client.http.GenericUrl;
        r10.<init>();
        r0 = r26;
        r0 = r0.scheme;
        r17 = r0;
        r0 = r17;
        r10.scheme = r0;
        r0 = r26;
        r0 = r0.host;
        r22 = r0;
        r0 = r22;
        r10.host = r0;
        r0 = r26;
        r0 = r0.pathParts;
        r22 = r0;
        r0 = r22;
        r10.pathParts = r0;
        r0 = r26;
        r15 = r0.port;
        r22 = "http";
        r0 = r22;
        r1 = r17;
        r22 = r0.equals(r1);
        if (r22 == 0) goto L_0x0164;
    L_0x015e:
        r22 = 80;
        r0 = r22;
        if (r15 == r0) goto L_0x0176;
    L_0x0164:
        r22 = "https";
        r0 = r22;
        r1 = r17;
        r22 = r0.equals(r1);
        if (r22 == 0) goto L_0x0177;
    L_0x0170:
        r22 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;
        r0 = r22;
        if (r15 != r0) goto L_0x0177;
    L_0x0176:
        r15 = -1;
    L_0x0177:
        r10.port = r15;
        r12 = r10.build();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r22 = escape(r25);
        r0 = r22;
        r22 = r3.append(r0);
        r23 = 38;
        r22.append(r23);
        r22 = escape(r12);
        r0 = r22;
        r22 = r3.append(r0);
        r23 = 38;
        r22.append(r23);
        r22 = escape(r11);
        r0 = r22;
        r3.append(r0);
        r18 = r3.toString();
        r0 = r20;
        r1 = r18;
        r22 = r0.computeSignature(r1);
        r0 = r22;
        r1 = r24;
        r1.signature = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.auth.oauth.OAuthParameters.computeSignature(java.lang.String, com.google.api.client.http.GenericUrl):void");
    }

    public String getAuthorizationHeader() {
        StringBuilder buf = new StringBuilder(com.google.gdata.client.authn.oauth.OAuthParameters.OAUTH_KEY);
        appendParameter(buf, com.google.gdata.client.authn.oauth.OAuthParameters.REALM_KEY, this.realm);
        appendParameter(buf, com.google.gdata.client.authn.oauth.OAuthParameters.OAUTH_CALLBACK_KEY, this.callback);
        appendParameter(buf, com.google.gdata.client.authn.oauth.OAuthParameters.OAUTH_CONSUMER_KEY, this.consumerKey);
        appendParameter(buf, com.google.gdata.client.authn.oauth.OAuthParameters.OAUTH_NONCE_KEY, this.nonce);
        appendParameter(buf, com.google.gdata.client.authn.oauth.OAuthParameters.OAUTH_SIGNATURE_KEY, this.signature);
        appendParameter(buf, com.google.gdata.client.authn.oauth.OAuthParameters.OAUTH_SIGNATURE_METHOD_KEY, this.signatureMethod);
        appendParameter(buf, com.google.gdata.client.authn.oauth.OAuthParameters.OAUTH_TIMESTAMP_KEY, this.timestamp);
        appendParameter(buf, com.google.gdata.client.authn.oauth.OAuthParameters.OAUTH_TOKEN_KEY, this.token);
        appendParameter(buf, com.google.gdata.client.authn.oauth.OAuthParameters.OAUTH_VERIFIER_KEY, this.verifier);
        appendParameter(buf, "oauth_version", this.version);
        return buf.substring(0, buf.length() - 1);
    }

    private void appendParameter(StringBuilder buf, String name, String value) {
        if (value != null) {
            buf.append(' ').append(escape(name)).append("=\"").append(escape(value)).append("\",");
        }
    }

    private void putParameterIfValueNotNull(TreeMap<String, String> parameters, String key, String value) {
        if (value != null) {
            putParameter(parameters, key, value);
        }
    }

    private void putParameter(TreeMap<String, String> parameters, String key, Object value) {
        parameters.put(escape(key), value == null ? null : escape(value.toString()));
    }

    public static String escape(String value) {
        return ESCAPER.escape(value);
    }

    public void signRequestsUsingAuthorizationHeader(HttpTransport transport) {
        for (HttpExecuteIntercepter intercepter : transport.intercepters) {
            if (intercepter.getClass() == OAuthAuthorizationHeaderIntercepter.class) {
                ((OAuthAuthorizationHeaderIntercepter) intercepter).oauthParameters = this;
                return;
            }
        }
        OAuthAuthorizationHeaderIntercepter newIntercepter = new OAuthAuthorizationHeaderIntercepter();
        newIntercepter.oauthParameters = this;
        transport.intercepters.add(newIntercepter);
    }
}
