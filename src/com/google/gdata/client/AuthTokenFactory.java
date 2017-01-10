package com.google.gdata.client;

import com.google.gdata.client.GoogleService.SessionExpiredException;
import com.google.gdata.util.AuthenticationException;

public interface AuthTokenFactory {

    public interface AuthToken {
    }

    public interface TokenListener {
        void tokenChanged(AuthToken authToken);
    }

    AuthToken getAuthToken();

    void handleSessionExpiredException(SessionExpiredException sessionExpiredException) throws SessionExpiredException, AuthenticationException;
}
