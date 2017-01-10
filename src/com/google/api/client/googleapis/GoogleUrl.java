package com.google.api.client.googleapis;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

public class GoogleUrl extends GenericUrl {
    @Key
    public String alt;
    @Key
    public String fields;
    @Key
    public Boolean prettyprint;

    public GoogleUrl(String encodedUrl) {
        super(encodedUrl);
    }
}
