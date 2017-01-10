package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0254a;
import com.google.ads.internal.C0264d;
import com.google.ads.util.C0299b;
import java.util.HashMap;

/* renamed from: com.google.ads.t */
public class C0293t implements C0220n {
    private static final C0254a f363a;

    static {
        f363a = (C0254a) C0254a.f170a.m137b();
    }

    public void m334a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("js");
        if (str == null) {
            C0299b.m384b("Could not get the JS to evaluate.");
        } else if (webView instanceof AdWebView) {
            AdActivity d = ((AdWebView) webView).m134d();
            if (d == null) {
                C0299b.m384b("Could not get the AdActivity from the AdWebView.");
                return;
            }
            WebView openingAdWebView = d.getOpeningAdWebView();
            if (openingAdWebView == null) {
                C0299b.m384b("Could not get the opening WebView.");
            } else {
                f363a.m143a(openingAdWebView, str);
            }
        } else {
            C0299b.m384b("Trying to evaluate JS in a WebView that isn't an AdWebView");
        }
    }
}
