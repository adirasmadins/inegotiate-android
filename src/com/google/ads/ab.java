package com.google.ads;

import android.app.Activity;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.webkit.WebView;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0254a;
import com.google.ads.internal.C0264d;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0299b;
import com.google.gdata.client.spreadsheet.ListQuery;
import java.util.HashMap;

public class ab implements C0220n {
    private static final C0254a f55a;

    static {
        f55a = (C0254a) C0254a.f170a.m137b();
    }

    protected int m38a(HashMap<String, String> hashMap, String str, int i, DisplayMetrics displayMetrics) {
        String str2 = (String) hashMap.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return (int) TypedValue.applyDimension(1, (float) Integer.parseInt(str2), displayMetrics);
        } catch (NumberFormatException e) {
            C0299b.m380a("Could not parse \"" + str + "\" in a video gmsg: " + str2);
            return i;
        }
    }

    public void m39a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        String str = (String) hashMap.get("action");
        if (str == null) {
            C0299b.m380a("No \"action\" parameter in a video gmsg.");
        } else if (webView instanceof AdWebView) {
            AdWebView adWebView = (AdWebView) webView;
            Activity d = adWebView.m134d();
            if (d == null) {
                C0299b.m380a("Could not get adActivity for a video gmsg.");
                return;
            }
            boolean equals = str.equals("new");
            boolean equals2 = str.equals(ListQuery.ORDERBY_POSITION);
            DisplayMetrics a;
            int a2;
            if (equals || equals2) {
                a = AdUtil.m338a(d);
                a2 = m38a(hashMap, "x", 0, a);
                int a3 = m38a(hashMap, "y", 0, a);
                int a4 = m38a(hashMap, "w", -1, a);
                int a5 = m38a(hashMap, "h", -1, a);
                if (equals && d.getAdVideoView() == null) {
                    d.newAdVideoView(a2, a3, a4, a5);
                    return;
                } else {
                    d.moveAdVideoView(a2, a3, a4, a5);
                    return;
                }
            }
            AdVideoView adVideoView = d.getAdVideoView();
            if (adVideoView == null) {
                f55a.m144a(adWebView, "onVideoEvent", "{'event': 'error', 'what': 'no_video_view'}");
            } else if (str.equals("click")) {
                a = AdUtil.m338a(d);
                int a6 = m38a(hashMap, "x", 0, a);
                a2 = m38a(hashMap, "y", 0, a);
                long uptimeMillis = SystemClock.uptimeMillis();
                adVideoView.m125a(MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) a6, (float) a2, 0));
            } else if (str.equals("controls")) {
                str = (String) hashMap.get("enabled");
                if (str == null) {
                    C0299b.m380a("No \"enabled\" parameter in a controls video gmsg.");
                } else if (str.equals("true")) {
                    adVideoView.setMediaControllerEnabled(true);
                } else {
                    adVideoView.setMediaControllerEnabled(false);
                }
            } else if (str.equals("currentTime")) {
                str = (String) hashMap.get("time");
                if (str == null) {
                    C0299b.m380a("No \"time\" parameter in a currentTime video gmsg.");
                    return;
                }
                try {
                    adVideoView.m124a((int) (Float.parseFloat(str) * 1000.0f));
                } catch (NumberFormatException e) {
                    C0299b.m380a("Could not parse \"time\" parameter: " + str);
                }
            } else if (str.equals("hide")) {
                adVideoView.setVisibility(4);
            } else if (str.equals("load")) {
                adVideoView.m126b();
            } else if (str.equals("pause")) {
                adVideoView.m127c();
            } else if (str.equals("play")) {
                adVideoView.m128d();
            } else if (str.equals("show")) {
                adVideoView.setVisibility(0);
            } else if (str.equals("src")) {
                adVideoView.setSrc((String) hashMap.get("src"));
            } else {
                C0299b.m380a("Unknown video action: " + str);
            }
        } else {
            C0299b.m380a("Could not get adWebView for a video gmsg.");
        }
    }
}
