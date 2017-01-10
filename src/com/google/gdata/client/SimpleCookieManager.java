package com.google.gdata.client;

import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multiset;
import com.google.gdata.client.http.GoogleGDataRequest.GoogleCookie;
import java.util.Iterator;
import java.util.Set;

public class SimpleCookieManager implements CookieManager {
    static final /* synthetic */ boolean $assertionsDisabled;
    protected Multiset<GoogleCookie> cookies;
    protected boolean cookiesEnabled;

    static {
        $assertionsDisabled = !SimpleCookieManager.class.desiredAssertionStatus();
    }

    public SimpleCookieManager() {
        this.cookies = ConcurrentHashMultiset.create();
        this.cookiesEnabled = true;
    }

    public void setCookiesEnabled(boolean cookiesEnabled) {
        this.cookiesEnabled = cookiesEnabled;
        if (!this.cookiesEnabled) {
            clearCookies();
        }
    }

    public boolean cookiesEnabled() {
        return this.cookiesEnabled;
    }

    public void clearCookies() {
        this.cookies.clear();
    }

    public void addCookie(GoogleCookie cookie) {
        if ($assertionsDisabled || this.cookiesEnabled) {
            this.cookies.remove(cookie);
            this.cookies.add(cookie);
            return;
        }
        throw new AssertionError();
    }

    public Set<GoogleCookie> getCookies() {
        Iterator<GoogleCookie> cookieIter = this.cookies.iterator();
        while (cookieIter.hasNext()) {
            if (((GoogleCookie) cookieIter.next()).hasExpired()) {
                cookieIter.remove();
            }
        }
        return this.cookies.elementSet();
    }
}
