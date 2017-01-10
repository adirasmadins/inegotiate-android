package com.google.ads.internal;

import android.net.Uri;
import android.webkit.WebView;
import com.google.ads.AdActivity;
import com.google.ads.C0220n;
import com.google.ads.C0287o;
import com.google.ads.C0288p;
import com.google.ads.C0289u;
import com.google.ads.C0290q;
import com.google.ads.C0291r;
import com.google.ads.C0292s;
import com.google.ads.C0293t;
import com.google.ads.C0323v;
import com.google.ads.C0324w;
import com.google.ads.C0325x;
import com.google.ads.C0326y;
import com.google.ads.C0327z;
import com.google.ads.aa;
import com.google.ads.ab;
import com.google.ads.ai;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0251f;
import com.google.ads.util.C0299b;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.google.ads.internal.a */
public class C0254a {
    public static final C0251f<C0254a> f170a;
    public static final Map<String, C0220n> f171b;
    public static final Map<String, C0220n> f172c;
    private static final C0254a f173d;

    /* renamed from: com.google.ads.internal.a.1 */
    static class C02501 extends HashMap<String, C0220n> {
        C02501() {
            put("/open", new C0327z());
            put("/canOpenURLs", new C0288p());
            put("/close", new C0291r());
            put("/customClose", new C0292s());
            put("/appEvent", new C0287o());
            put("/evalInOpener", new C0293t());
            put("/log", new C0326y());
            put("/click", new C0290q());
            put("/httpTrack", new C0289u());
            put("/touch", new aa());
            put("/video", new ab());
            put("/plusOne", new ai());
        }
    }

    /* renamed from: com.google.ads.internal.a.2 */
    static class C02522 implements C0251f<C0254a> {
        C02522() {
        }

        public /* synthetic */ Object m139b() {
            return m138a();
        }

        public C0254a m138a() {
            return C0254a.f173d;
        }
    }

    /* renamed from: com.google.ads.internal.a.3 */
    static class C02533 extends HashMap<String, C0220n> {
        C02533() {
            put("/invalidRequest", new C0323v());
            put("/loadAdURL", new C0324w());
            put("/loadSdkConstants", new C0325x());
        }
    }

    static {
        f173d = new C0254a();
        f170a = new C02522();
        f171b = Collections.unmodifiableMap(new C02533());
        f172c = Collections.unmodifiableMap(new C02501());
    }

    public String m141a(Uri uri, HashMap<String, String> hashMap) {
        if (m150c(uri)) {
            String host = uri.getHost();
            if (host == null) {
                C0299b.m390e("An error occurred while parsing the AMSG parameters.");
                return null;
            } else if (host.equals("launch")) {
                hashMap.put("a", "intent");
                hashMap.put(AdActivity.URL_PARAM, hashMap.get("url"));
                hashMap.remove("url");
                return "/open";
            } else if (host.equals("closecanvas")) {
                return "/close";
            } else {
                if (host.equals("log")) {
                    return "/log";
                }
                C0299b.m390e("An error occurred while parsing the AMSG: " + uri.toString());
                return null;
            }
        } else if (m149b(uri)) {
            return uri.getPath();
        } else {
            C0299b.m390e("Message was neither a GMSG nor an AMSG.");
            return null;
        }
    }

    public void m146a(C0264d c0264d, Map<String, C0220n> map, Uri uri, WebView webView) {
        HashMap b = AdUtil.m355b(uri);
        if (b == null) {
            C0299b.m390e("An error occurred while parsing the message parameters.");
            return;
        }
        String a = m141a(uri, b);
        if (a == null) {
            C0299b.m390e("An error occurred while parsing the message.");
            return;
        }
        C0220n c0220n = (C0220n) map.get(a);
        if (c0220n == null) {
            C0299b.m390e("No AdResponse found, <message: " + a + ">");
        } else {
            c0220n.m36a(c0264d, b, webView);
        }
    }

    public boolean m147a(Uri uri) {
        if (uri == null || !uri.isHierarchical()) {
            return false;
        }
        if (m149b(uri) || m150c(uri)) {
            return true;
        }
        return false;
    }

    public boolean m149b(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equals("gmsg")) {
            return false;
        }
        scheme = uri.getAuthority();
        if (scheme == null || !scheme.equals("mobileads.google.com")) {
            return false;
        }
        return true;
    }

    public boolean m150c(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme == null || !scheme.equals("admob")) {
            return false;
        }
        return true;
    }

    public void m144a(WebView webView, String str, String str2) {
        String str3 = "AFMA_ReceiveMessage";
        if (str2 != null) {
            m143a(webView, str3 + "('" + str + "', " + str2 + ");");
        } else {
            m143a(webView, str3 + "('" + str + "');");
        }
    }

    public void m143a(WebView webView, String str) {
        C0299b.m380a("Sending JS to a WebView: " + str);
        webView.loadUrl("javascript:" + str);
    }

    public void m145a(WebView webView, Map<String, Boolean> map) {
        m144a(webView, "openableURLs", new JSONObject(map).toString());
    }

    public void m142a(WebView webView) {
        m144a(webView, "onshow", "{'version': 'afma-sdk-a-v6.2.1'}");
    }

    public void m148b(WebView webView) {
        m144a(webView, "onhide", null);
    }
}
