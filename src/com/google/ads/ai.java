package com.google.ads;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.ads.internal.C0264d;
import com.google.ads.internal.C0265e;
import java.util.HashMap;

public class ai implements C0220n {

    /* renamed from: com.google.ads.ai.a */
    private static class C0224a implements OnClickListener {
        public void onClick(DialogInterface dialog, int which) {
        }
    }

    /* renamed from: com.google.ads.ai.b */
    public enum C0225b {
        AD("ad"),
        APP("app");
        
        public String f74c;

        private C0225b(String str) {
            this.f74c = str;
        }
    }

    /* renamed from: com.google.ads.ai.c */
    private static class C0226c implements OnClickListener {
        private C0264d f75a;

        public C0226c(C0264d c0264d) {
            this.f75a = c0264d;
        }

        public void onClick(DialogInterface dialog, int which) {
            HashMap hashMap = new HashMap();
            hashMap.put(AdActivity.URL_PARAM, "market://details?id=com.google.android.apps.plus");
            AdActivity.launchAdActivity(this.f75a, new C0265e("intent", hashMap));
        }
    }

    public void m50a(C0264d c0264d, HashMap<String, String> hashMap, WebView webView) {
        Context context = (Context) c0264d.m219h().f319f.m411a();
        String str = (String) hashMap.get("a");
        if (str != null) {
            if (str.equals("resize")) {
                ag.m44a(webView, (String) hashMap.get(AdActivity.URL_PARAM));
                return;
            } else if (str.equals("state")) {
                ag.m43a((Activity) c0264d.m219h().f318e.m414a(), webView, (String) hashMap.get(AdActivity.URL_PARAM));
                return;
            }
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
        if (ah.m49a(intent, context)) {
            AdActivity.launchAdActivity(c0264d, new C0265e("plusone", hashMap));
        } else if (!ah.m49a(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.apps.plus")), context)) {
        } else {
            if (TextUtils.isEmpty((CharSequence) hashMap.get("d")) || TextUtils.isEmpty((CharSequence) hashMap.get(AdActivity.ORIENTATION_PARAM)) || TextUtils.isEmpty((CharSequence) hashMap.get("c"))) {
                HashMap hashMap2 = new HashMap();
                hashMap2.put(AdActivity.URL_PARAM, "market://details?id=com.google.android.apps.plus");
                AdActivity.launchAdActivity(c0264d, new C0265e("intent", hashMap2));
                return;
            }
            Builder builder = new Builder(context);
            builder.setMessage((CharSequence) hashMap.get("d")).setPositiveButton((CharSequence) hashMap.get(AdActivity.ORIENTATION_PARAM), new C0226c(c0264d)).setNegativeButton((CharSequence) hashMap.get("c"), new C0224a());
            builder.create().show();
        }
    }
}
