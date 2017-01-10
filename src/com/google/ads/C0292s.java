package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0264d;
import com.google.ads.util.C0299b;
import java.util.HashMap;

/* renamed from: com.google.ads.s */
public class C0292s implements C0220n {
    public void m332a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        if (webView instanceof AdWebView) {
            ((AdWebView) webView).setCustomClose("1".equals(hashMap.get(AdActivity.CUSTOM_CLOSE_PARAM)));
        } else {
            C0299b.m384b("Trying to set a custom close icon on a WebView that isn't an AdWebView");
        }
    }
}
