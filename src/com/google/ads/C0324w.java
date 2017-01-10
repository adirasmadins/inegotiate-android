package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0263c;
import com.google.ads.internal.C0263c.C0261d;
import com.google.ads.internal.C0264d;
import com.google.ads.util.C0299b;
import java.util.HashMap;

/* renamed from: com.google.ads.w */
public class C0324w implements C0220n {
    public void m416a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        C0261d c0261d;
        String str = (String) hashMap.get("url");
        String str2 = (String) hashMap.get("type");
        String str3 = (String) hashMap.get("afma_notify_dt");
        boolean equals = "1".equals(hashMap.get("drt_include"));
        String str4 = (String) hashMap.get("request_scenario");
        boolean equals2 = "1".equals(hashMap.get("use_webview_loadurl"));
        if (C0261d.OFFLINE_EMPTY.f193e.equals(str4)) {
            c0261d = C0261d.OFFLINE_EMPTY;
        } else if (C0261d.OFFLINE_USING_BUFFERED_ADS.f193e.equals(str4)) {
            c0261d = C0261d.OFFLINE_USING_BUFFERED_ADS;
        } else if (C0261d.ONLINE_USING_BUFFERED_ADS.f193e.equals(str4)) {
            c0261d = C0261d.ONLINE_USING_BUFFERED_ADS;
        } else {
            c0261d = C0261d.ONLINE_SERVER_REQUEST;
        }
        C0299b.m386c("Received ad url: <url: \"" + str + "\" type: \"" + str2 + "\" afmaNotifyDt: \"" + str3 + "\" useWebViewLoadUrl: \"" + equals2 + "\">");
        C0263c j = c0264d.m221j();
        if (j != null) {
            j.m183c(equals);
            j.m174a(c0261d);
            j.m185d(equals2);
            j.m184d(str);
        }
    }
}
