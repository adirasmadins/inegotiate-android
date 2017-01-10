package com.google.ads;

import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.C0280l.C0279a;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0264d;
import com.google.ads.internal.C0270h;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0278i.C0321c;
import com.google.ads.util.C0299b;
import com.google.ads.util.C0315g;
import java.util.HashMap;

/* renamed from: com.google.ads.x */
public class C0325x implements C0220n {
    public void m420a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        C0281m h = c0264d.m219h();
        C0279a c0279a = (C0279a) ((C0280l) h.f314a.m411a()).f313a.m411a();
        m417a((HashMap) hashMap, "min_hwa_banner", c0279a.f300a);
        m417a((HashMap) hashMap, "min_hwa_overlay", c0279a.f301b);
        m419c(hashMap, "mraid_banner_path", c0279a.f302c);
        m419c(hashMap, "mraid_expanded_banner_path", c0279a.f303d);
        m419c(hashMap, "mraid_interstitial_path", c0279a.f304e);
        m418b(hashMap, "ac_max_size", c0279a.f305f);
        m418b(hashMap, "ac_padding", c0279a.f306g);
        m418b(hashMap, "ac_total_quota", c0279a.f307h);
        m418b(hashMap, "db_total_quota", c0279a.f308i);
        m418b(hashMap, "db_quota_per_origin", c0279a.f309j);
        m418b(hashMap, "db_quota_step_size", c0279a.f310k);
        AdWebView k = c0264d.m222k();
        if (AdUtil.f371a >= 11) {
            C0315g.m409a(k.getSettings(), h);
            C0315g.m409a(webView.getSettings(), h);
        }
        if (!((C0270h) h.f324k.m411a()).m297a()) {
            boolean f = k.m136f();
            boolean z = AdUtil.f371a < ((Integer) c0279a.f300a.m412a()).intValue();
            if (!z && f) {
                C0299b.m380a("Re-enabling hardware acceleration for a banner after reading constants.");
                k.m133c();
            } else if (z && !f) {
                C0299b.m380a("Disabling hardware acceleration for a banner after reading constants.");
                k.m132b();
            }
        }
        c0279a.f311l.m413a(Boolean.valueOf(true));
    }

    private void m417a(HashMap<String, String> hashMap, String str, C0321c<Integer> c0321c) {
        try {
            String str2 = (String) hashMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                c0321c.m413a(Integer.valueOf(str2));
            }
        } catch (NumberFormatException e) {
            C0299b.m380a("Could not parse \"" + str + "\" constant.");
        }
    }

    private void m418b(HashMap<String, String> hashMap, String str, C0321c<Long> c0321c) {
        try {
            String str2 = (String) hashMap.get(str);
            if (!TextUtils.isEmpty(str2)) {
                c0321c.m413a(new Long(str2));
            }
        } catch (NumberFormatException e) {
            C0299b.m380a("Could not parse \"" + str + "\" constant.");
        }
    }

    private void m419c(HashMap<String, String> hashMap, String str, C0321c<String> c0321c) {
        String str2 = (String) hashMap.get(str);
        if (!TextUtils.isEmpty(str2)) {
            c0321c.m413a(str2);
        }
    }
}
