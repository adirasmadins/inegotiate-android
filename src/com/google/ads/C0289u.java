package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0264d;
import com.google.ads.util.C0299b;
import java.util.HashMap;

/* renamed from: com.google.ads.u */
public class C0289u implements C0220n {
    public void m329a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get(AdActivity.URL_PARAM);
        if (str == null) {
            C0299b.m390e("Could not get URL from click gmsg.");
        } else {
            new Thread(m328a(str, webView)).start();
        }
    }

    protected Runnable m328a(String str, WebView webView) {
        return new ac(str, webView.getContext().getApplicationContext());
    }
}
