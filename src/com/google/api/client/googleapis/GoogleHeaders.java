package com.google.api.client.googleapis;

import com.google.api.client.escape.PercentEscaper;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

public class GoogleHeaders extends HttpHeaders {
    public static final PercentEscaper SLUG_ESCAPER;
    @Key("X-GData-Client")
    public String gdataClient;
    @Key("X-GData-Key")
    public String gdataKey;
    @Key("GData-Version")
    public String gdataVersion;
    @Key("x-goog-acl")
    public String googAcl;
    @Key("x-goog-copy-source")
    public String googCopySource;
    @Key("x-goog-copy-source-if-match")
    public String googCopySourceIfMatch;
    @Key("x-goog-copy-source-if-modified-since")
    public String googCopySourceIfModifiedSince;
    @Key("x-goog-copy-source-if-none-match")
    public String googCopySourceIfNoneMatch;
    @Key("x-goog-copy-source-if-unmodified-since")
    public String googCopySourceIfUnmodifiedSince;
    @Key("x-goog-date")
    public String googDate;
    @Key("x-goog-metadata-directive")
    public String googMetadataDirective;
    @Key("X-HTTP-Method-Override")
    public String methodOverride;
    @Key("Slug")
    public String slug;

    static {
        SLUG_ESCAPER = new PercentEscaper(" !\"#$&'()*+,-./:;<=>?@[\\]^_`{|}~", false);
    }

    public void setSlugFromFileName(String fileName) {
        this.slug = SLUG_ESCAPER.escape(fileName);
    }

    public void setApplicationName(String applicationName) {
        this.userAgent = applicationName;
    }

    public void setDeveloperId(String developerId) {
        this.gdataKey = "key=" + developerId;
    }

    public void setGoogleLogin(String authToken) {
        this.authorization = getGoogleLoginValue(authToken);
    }

    public static String getGoogleLoginValue(String authToken) {
        return "GoogleLogin auth=" + authToken;
    }
}
