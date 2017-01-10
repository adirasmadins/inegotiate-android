package com.google.gdata.util;

import com.google.common.net.HttpHeaders;
import com.google.gdata.client.authn.oauth.OAuthParameters;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthenticationException extends ServiceException {
    private static final Pattern PARAM_PATTERN;
    private static final Pattern SCHEME_PATTERN;
    private static String TOKEN;
    private String authHeader;
    private Map<String, String> parameters;
    private String scheme;

    public AuthenticationException(String message, String authHeader) {
        super(message);
        this.parameters = new HashMap();
        initFromAuthHeader(authHeader);
    }

    public AuthenticationException(String message) {
        super(message);
        this.parameters = new HashMap();
    }

    public AuthenticationException(HttpURLConnection httpConn) throws IOException {
        super(httpConn);
        this.parameters = new HashMap();
        initFromAuthHeader(httpConn.getHeaderField(HttpHeaders.WWW_AUTHENTICATE));
    }

    static {
        SCHEME_PATTERN = Pattern.compile("([^\\s$]*)\\s*(.*)?");
        TOKEN = "[\\p{ASCII}&&[^\\p{Cntrl} \t;/=\\[\\]\\(\\)\\<\\>\\@\\,\\:\\\"\\?\\=]]+";
        PARAM_PATTERN = Pattern.compile("(" + TOKEN + ")" + "\\s*=\\s*" + "(?:" + "\"([^\"]*)\"" + "|" + "(" + TOKEN + ")?" + ")");
    }

    private void initFromAuthHeader(String authHeader) {
        this.authHeader = authHeader;
        if (authHeader == null) {
            throw new NullPointerException("No authentication header information");
        }
        Matcher authMatcher = SCHEME_PATTERN.matcher(authHeader);
        if (authMatcher.matches()) {
            this.scheme = authMatcher.group(1);
            if (authMatcher.groupCount() > 1) {
                Matcher paramMatcher = PARAM_PATTERN.matcher(authMatcher.group(2));
                while (paramMatcher.find()) {
                    String value = paramMatcher.group(2);
                    if (value == null) {
                        value = paramMatcher.group(3);
                    }
                    this.parameters.put(paramMatcher.group(1), value);
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Unable to parse auth header: " + authHeader);
    }

    public String getScheme() {
        return this.scheme;
    }

    public String getRealm() {
        return (String) this.parameters.get(OAuthParameters.REALM_KEY);
    }

    public Map<String, String> getParameters() {
        return Collections.unmodifiableMap(this.parameters);
    }

    public String getAuthHeader() {
        return this.authHeader;
    }
}
