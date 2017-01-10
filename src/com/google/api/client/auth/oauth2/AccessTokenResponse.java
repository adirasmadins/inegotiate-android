package com.google.api.client.auth.oauth2;

import com.google.api.client.util.GenericData;
import com.google.api.client.util.Key;

public class AccessTokenResponse extends GenericData {
    @Key("access_token")
    public String accessToken;
    @Key("expires_in")
    public Long expiresIn;
    @Key("refresh_token")
    public String refreshToken;
    @Key
    public String scope;
}
