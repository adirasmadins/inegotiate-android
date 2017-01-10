package com.google.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.C0254a;
import com.google.ads.internal.C0264d;
import com.google.ads.util.C0299b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.ads.p */
public class C0288p implements C0220n {
    private static final C0254a f347a;

    static {
        f347a = (C0254a) C0254a.f170a.m137b();
    }

    public void m327a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("urls");
        if (str == null) {
            C0299b.m390e("Could not get the urls param from canOpenURLs gmsg.");
            return;
        }
        String[] split = str.split(",");
        Map hashMap2 = new HashMap();
        PackageManager packageManager = webView.getContext().getPackageManager();
        for (String str2 : split) {
            boolean z;
            String[] split2 = str2.split(";", 2);
            if (packageManager.resolveActivity(new Intent(split2.length >= 2 ? split2[1] : "android.intent.action.VIEW", Uri.parse(split2[0])), 65536) != null) {
                z = true;
            } else {
                z = false;
            }
            hashMap2.put(str2, Boolean.valueOf(z));
        }
        f347a.m145a(webView, hashMap2);
    }
}
