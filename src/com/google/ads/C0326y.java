package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0264d;
import com.google.ads.util.C0299b;
import java.util.HashMap;

/* renamed from: com.google.ads.y */
public class C0326y implements C0220n {
    public void m421a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("afma_notify_dt");
        C0299b.m386c("Received log message: <\"string\": \"" + ((String) hashMap.get("string")) + "\", \"afmaNotifyDt\": \"" + str + "\">");
    }
}
