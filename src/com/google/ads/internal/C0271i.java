package com.google.ads.internal;

import android.net.Uri;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.C0220n;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0299b;
import com.google.ads.util.C0315g.C0314b;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.ads.internal.i */
public class C0271i extends WebViewClient {
    private static final C0254a f277c;
    protected C0264d f278a;
    protected boolean f279b;
    private final Map<String, C0220n> f280d;
    private final boolean f281e;
    private boolean f282f;
    private boolean f283g;
    private boolean f284h;

    static {
        f277c = (C0254a) C0254a.f170a.m137b();
    }

    public C0271i(C0264d c0264d, Map<String, C0220n> map, boolean z, boolean z2) {
        this.f278a = c0264d;
        this.f280d = map;
        this.f281e = z;
        this.f282f = z2;
        this.f279b = false;
        this.f283g = false;
        this.f284h = false;
    }

    public static C0271i m300a(C0264d c0264d, Map<String, C0220n> map, boolean z, boolean z2) {
        if (AdUtil.f371a >= 11) {
            return new C0314b(c0264d, map, z, z2);
        }
        return new C0271i(c0264d, map, z, z2);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String url) {
        try {
            C0299b.m380a("shouldOverrideUrlLoading(\"" + url + "\")");
            Uri parse = Uri.parse(url);
            if (f277c.m147a(parse)) {
                f277c.m146a(this.f278a, this.f280d, parse, webView);
                return true;
            } else if (this.f282f) {
                if (AdUtil.m349a(parse)) {
                    return super.shouldOverrideUrlLoading(webView, url);
                }
                HashMap hashMap = new HashMap();
                hashMap.put(AdActivity.URL_PARAM, url);
                AdActivity.launchAdActivity(this.f278a, new C0265e("intent", hashMap));
                return true;
            } else if (this.f281e) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(AdActivity.URL_PARAM, parse.toString());
                AdActivity.launchAdActivity(this.f278a, new C0265e("intent", hashMap2));
                return true;
            } else {
                C0299b.m390e("URL is not a GMSG and can't handle URL: " + url);
                return true;
            }
        } catch (Throwable th) {
            C0299b.m385b("An unknown error occurred in shouldOverrideUrlLoading.", th);
            return true;
        }
    }

    public void onPageFinished(WebView view, String url) {
        if (this.f283g) {
            C0263c j = this.f278a.m221j();
            if (j != null) {
                j.m181c();
            } else {
                C0299b.m380a("adLoader was null while trying to setFinishedLoadingHtml().");
            }
            this.f283g = false;
        }
        if (this.f284h) {
            f277c.m142a(view);
            this.f284h = false;
        }
    }

    public void m301a(boolean z) {
        this.f279b = z;
    }

    public void m302b(boolean z) {
        this.f282f = z;
    }

    public void m303c(boolean z) {
        this.f283g = z;
    }

    public void m304d(boolean z) {
        this.f284h = z;
    }
}
