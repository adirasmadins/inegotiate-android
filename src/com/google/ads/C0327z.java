package com.google.ads;

import android.webkit.WebView;
import com.google.ads.AdActivity.StaticMethodWrapper;
import com.google.ads.internal.C0264d;
import com.google.ads.internal.C0265e;
import com.google.ads.util.C0299b;
import java.util.HashMap;

/* renamed from: com.google.ads.z */
public class C0327z implements C0220n {
    private StaticMethodWrapper f429a;

    public C0327z() {
        this(new StaticMethodWrapper());
    }

    public C0327z(StaticMethodWrapper staticMethodWrapper) {
        this.f429a = staticMethodWrapper;
    }

    public void m422a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("a");
        if (str == null) {
            C0299b.m380a("Could not get the action parameter for open GMSG.");
        } else if (str.equals("webapp")) {
            this.f429a.launchAdActivity(c0264d, new C0265e("webapp", hashMap));
        } else if (str.equals("expand")) {
            this.f429a.launchAdActivity(c0264d, new C0265e("expand", hashMap));
        } else {
            this.f429a.launchAdActivity(c0264d, new C0265e("intent", hashMap));
        }
    }
}
