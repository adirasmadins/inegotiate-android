package com.google.ads.util;

import android.annotation.TargetApi;
import android.view.View;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.google.ads.C0281m;
import com.google.ads.util.C0315g.C0313a;

@TargetApi(14)
/* renamed from: com.google.ads.util.h */
public class C0317h {

    /* renamed from: com.google.ads.util.h.a */
    public static class C0316a extends C0313a {
        public C0316a(C0281m c0281m) {
            super(c0281m);
        }

        public void onShowCustomView(View view, int requestedOrientation, CustomViewCallback callback) {
            callback.onCustomViewHidden();
        }
    }
}
