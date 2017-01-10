package com.google.api.client.auth.oauth2;

import com.google.api.client.http.HttpExecuteIntercepter;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.GenericData;
import com.google.gdata.client.authn.oauth.OAuthParameters;
import java.util.Arrays;
import java.util.List;

public final class AccessProtectedResource {

    static abstract class AccessTokenIntercepter implements HttpExecuteIntercepter {
        String accessToken;

        AccessTokenIntercepter() {
        }

        void authorize(HttpTransport transport, String accessToken) {
            this.accessToken = accessToken;
            transport.removeIntercepters(AccessTokenIntercepter.class);
            transport.intercepters.add(this);
        }
    }

    static final class UsingAuthorizationHeader extends AccessTokenIntercepter {
        UsingAuthorizationHeader() {
        }

        public void intercept(HttpRequest request) {
            request.headers.authorization = "OAuth " + this.accessToken;
        }
    }

    static final class UsingFormEncodedBody extends AccessTokenIntercepter {
        private static final List<String> ALLOWED_METHODS;

        UsingFormEncodedBody() {
        }

        static {
            ALLOWED_METHODS = Arrays.asList(new String[]{"POST", "PUT", "DELETE"});
        }

        public void intercept(HttpRequest request) {
            if (ALLOWED_METHODS.contains(request.method)) {
                UrlEncodedContent content = request.content;
                if (content == null) {
                    content = new UrlEncodedContent();
                    request.content = content;
                }
                GenericData data = content.data;
                if (data == null) {
                    data = new GenericData();
                    content.data = data;
                }
                data.put(OAuthParameters.OAUTH_TOKEN_KEY, this.accessToken);
                return;
            }
            throw new IllegalArgumentException("expected one of these HTTP methods: " + ALLOWED_METHODS);
        }
    }

    static final class UsingQueryParameter extends AccessTokenIntercepter {
        UsingQueryParameter() {
        }

        public void intercept(HttpRequest request) {
            request.url.set(OAuthParameters.OAUTH_TOKEN_KEY, this.accessToken);
        }
    }

    public static void usingAuthorizationHeader(HttpTransport transport, String accessToken) {
        new UsingAuthorizationHeader().authorize(transport, accessToken);
    }

    public static void usingQueryParameter(HttpTransport transport, String accessToken) {
        new UsingQueryParameter().authorize(transport, accessToken);
    }

    public static void usingFormEncodedBody(HttpTransport transport, String accessToken) {
        new UsingFormEncodedBody().authorize(transport, accessToken);
    }

    private AccessProtectedResource() {
    }
}
