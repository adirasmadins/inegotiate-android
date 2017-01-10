package com.google.api.client.http;

import com.google.api.client.util.Base64;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;
import com.google.api.client.util.Strings;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class HttpHeaders extends GenericData {
    @Key("Accept")
    public String accept;
    @Key("Accept-Encoding")
    public String acceptEncoding;
    @Key("WWW-Authenticate")
    public String authenticate;
    @Key("Authorization")
    public String authorization;
    @Key("Cache-Control")
    public String cacheControl;
    @Key("Content-Encoding")
    public String contentEncoding;
    @Key("Content-Length")
    public String contentLength;
    @Key("Content-MD5")
    public String contentMD5;
    @Key("Content-Range")
    public String contentRange;
    @Key("Content-Type")
    public String contentType;
    @Key("Date")
    public String date;
    @Key("ETag")
    public String etag;
    @Key("Expires")
    public String expires;
    @Key("If-Match")
    public String ifMatch;
    @Key("If-Modified-Since")
    public String ifModifiedSince;
    @Key("If-None-Match")
    public String ifNoneMatch;
    @Key("If-Unmodified-Since")
    public String ifUnmodifiedSince;
    @Key("Last-Modified")
    public String lastModified;
    @Key("Location")
    public String location;
    @Key("MIME-Version")
    public String mimeVersion;
    @Key("Range")
    public String range;
    @Key("Retry-After")
    public String retryAfter;
    @Key("User-Agent")
    public String userAgent;

    public HttpHeaders() {
        this.acceptEncoding = "gzip";
    }

    public HttpHeaders clone() {
        return (HttpHeaders) super.clone();
    }

    public void setBasicAuthentication(String username, String password) {
        this.authorization = "Basic " + Strings.fromBytesUtf8(Base64.encode(Strings.toBytesUtf8(username + ":" + password)));
    }

    public Map<String, Collection<Object>> canonicalMap() {
        Map<String, Collection<Object>> result = new HashMap();
        for (Entry<String, Object> entry : entrySet()) {
            String canonicalName = ((String) entry.getKey()).toLowerCase();
            if (result.containsKey(canonicalName)) {
                throw new IllegalArgumentException("multiple headers of the same name (headers are case insensitive): " + canonicalName);
            }
            Collection<Object> value = entry.getValue();
            if (value != null) {
                if (value instanceof Collection) {
                    result.put(canonicalName, Collections.unmodifiableCollection(value));
                } else {
                    result.put(canonicalName, Collections.singleton(value));
                }
            }
        }
        return result;
    }

    static HashMap<String, String> getFieldNameMap(Class<? extends HttpHeaders> headersClass) {
        HashMap<String, String> fieldNameMap = new HashMap();
        for (String keyName : ClassInfo.of(headersClass).getKeyNames()) {
            fieldNameMap.put(keyName.toLowerCase(), keyName);
        }
        return fieldNameMap;
    }
}
