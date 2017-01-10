package com.google.ads;

import android.webkit.WebView;
import com.google.ads.internal.C0264d;
import com.google.ads.util.C0299b;
import java.util.HashMap;

/* renamed from: com.google.ads.o */
public class C0287o implements C0220n {
    public void m326a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("name");
        if (str == null) {
            C0299b.m384b("Error: App event with no name parameter.");
        } else {
            c0264d.m206a(str, (String) hashMap.get("info"));
        }
    }
}
