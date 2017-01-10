package com.google.gdata.client.http;

import com.google.gdata.client.AuthTokenFactory.AuthToken;
import java.net.URL;

public interface HttpAuthToken extends AuthToken {
    String getAuthorizationHeader(URL url, String str);
}
