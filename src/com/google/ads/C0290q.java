package com.google.ads;

import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.internal.C0264d;
import com.google.ads.internal.C0269g;
import com.google.ads.util.C0299b;
import java.util.HashMap;
import java.util.Locale;

/* renamed from: com.google.ads.q */
public class C0290q extends C0289u {
    public void m330a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get(AdActivity.URL_PARAM);
        if (str == null) {
            C0299b.m390e("Could not get URL from click gmsg.");
            return;
        }
        C0269g m = c0264d.m224m();
        if (m != null) {
            Uri parse = Uri.parse(str);
            str = parse.getHost();
            if (str != null && str.toLowerCase(Locale.US).endsWith(".admob.com")) {
                str = null;
                String path = parse.getPath();
                if (path != null) {
                    String[] split = path.split("/");
                    if (split.length >= 4) {
                        str = split[2] + "/" + split[3];
                    }
                }
                m.m269a(str);
            }
        }
        super.m329a(c0264d, hashMap, webView);
    }
}
