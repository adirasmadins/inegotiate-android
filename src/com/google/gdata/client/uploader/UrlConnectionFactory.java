package com.google.gdata.client.uploader;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

interface UrlConnectionFactory {
    public static final UrlConnectionFactory DEFAULT;

    /* renamed from: com.google.gdata.client.uploader.UrlConnectionFactory.1 */
    static class C07161 implements UrlConnectionFactory {
        C07161() throws IOException {
        }

        public HttpURLConnection create(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    HttpURLConnection create(URL url) throws IOException;

    static {
        DEFAULT = new C07161();
    }
}
