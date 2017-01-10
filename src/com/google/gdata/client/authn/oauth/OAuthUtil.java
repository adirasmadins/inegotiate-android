package com.google.gdata.client.authn.oauth;

import com.google.gdata.model.QName;
import com.google.gdata.util.common.base.CharEscapers;
import com.google.gdata.util.common.base.StringUtil;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class OAuthUtil {
    private OAuthUtil() {
    }

    public static String getNonce() {
        return Long.toString(System.nanoTime());
    }

    public static String getTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }

    public static String getSignatureBaseString(String requestUrl, String httpMethod, Map<String, String> baseParameters) throws OAuthException {
        return encode(httpMethod.toUpperCase()) + '&' + encode(normalizeUrl(requestUrl)) + '&' + encode(normalizeParameters(requestUrl, baseParameters));
    }

    public static String normalizeUrl(String requestUrl) throws OAuthException {
        if (requestUrl == null || requestUrl.length() == 0) {
            throw new OAuthException("Request Url cannot be empty");
        }
        try {
            URI uri = new URI(requestUrl);
            String authority = uri.getAuthority();
            String scheme = uri.getScheme();
            if (authority == null || scheme == null) {
                throw new OAuthException("Invalid Request Url");
            }
            authority = authority.toLowerCase();
            scheme = scheme.toLowerCase();
            if ((scheme.equals("http") && uri.getPort() == 80) || (scheme.equals("https") && uri.getPort() == 443)) {
                int index = authority.lastIndexOf(":");
                if (index >= 0) {
                    authority = authority.substring(0, index);
                }
            }
            return scheme + "://" + authority + uri.getRawPath();
        } catch (Throwable e) {
            throw new OAuthException(e);
        }
    }

    public static String normalizeParameters(String requestUrl, Map<String, String> requestParameters) {
        TreeMap<String, String> alphaParams = new TreeMap(requestParameters);
        if (requestUrl.indexOf(63) > 0) {
            alphaParams.putAll(parseQuerystring(requestUrl.substring(requestUrl.indexOf(63) + 1)));
        }
        StringBuilder paramString = new StringBuilder();
        for (Entry<String, String> e : alphaParams.entrySet()) {
            if (((String) e.getValue()).length() != 0) {
                if (paramString.length() > 0) {
                    paramString.append("&");
                }
                paramString.append(encode((String) e.getKey())).append("=").append(encode((String) e.getValue()));
            }
        }
        return paramString.toString();
    }

    public static Map<String, String> parseQuerystring(String queryString) {
        Map<String, String> map = new HashMap();
        if (!(queryString == null || queryString.equals(StringUtil.EMPTY_STRING))) {
            for (String param : queryString.split("&")) {
                try {
                    String[] keyValuePair = param.split("=", 2);
                    String name = URLDecoder.decode(keyValuePair[0], StringEncodings.UTF8);
                    if (name != StringUtil.EMPTY_STRING) {
                        map.put(name, keyValuePair.length > 1 ? URLDecoder.decode(keyValuePair[1], StringEncodings.UTF8) : StringUtil.EMPTY_STRING);
                    }
                } catch (UnsupportedEncodingException e) {
                }
            }
        }
        return map;
    }

    public static String encode(String stringToEncode) {
        return CharEscapers.uriEscaper().escape(stringToEncode).replace("+", "%20").replace(QName.ANY_LOCALNAME, "%2A").replace("%7E", "~");
    }
}
