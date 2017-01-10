package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0264d;
import com.google.ads.util.C0299b;
import java.util.HashMap;

/* renamed from: com.google.ads.r */
public class C0291r implements C0220n {
    public void m331a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        if (webView instanceof AdWebView) {
            ((AdWebView) webView).m131a();
        } else {
            C0299b.m384b("Trying to close WebView that isn't an AdWebView");
        }
    }
}
