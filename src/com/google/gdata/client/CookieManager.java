package com.google.gdata.client;

import com.google.gdata.client.http.GoogleGDataRequest.GoogleCookie;
import java.util.Set;

public interface CookieManager {
    void addCookie(GoogleCookie googleCookie);

    void clearCookies();

    boolean cookiesEnabled();

    Set<GoogleCookie> getCookies();

    void setCookiesEnabled(boolean z);
}
