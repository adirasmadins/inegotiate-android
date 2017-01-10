package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import com.google.ads.internal.C0270h;
import com.google.ads.internal.state.AdState;
import com.google.ads.util.C0278i;
import com.google.ads.util.C0278i.C0320b;
import com.google.ads.util.C0278i.C0321c;
import com.google.ads.util.C0278i.C0322d;

/* renamed from: com.google.ads.m */
public class C0281m extends C0278i {
    public final C0320b<C0280l> f314a;
    public final C0321c<AdState> f315b;
    public final C0321c<AdState> f316c;
    public final C0320b<String> f317d;
    public final C0322d<Activity> f318e;
    public final C0320b<Context> f319f;
    public final C0320b<ViewGroup> f320g;
    public final C0320b<Ad> f321h;
    public final C0320b<AdView> f322i;
    public final C0320b<InterstitialAd> f323j;
    public final C0320b<C0270h> f324k;
    public final C0321c<AdSize[]> f325l;
    public final C0321c<AdListener> f326m;
    public final C0321c<AppEventListener> f327n;

    public boolean m310a() {
        return !m311b();
    }

    public boolean m311b() {
        return ((C0270h) this.f324k.m411a()).m297a();
    }

    public C0281m(C0280l c0280l, Ad ad, AdView adView, InterstitialAd interstitialAd, String str, Activity activity, Context context, ViewGroup viewGroup, C0270h c0270h) {
        this.f315b = new C0321c(this, "currentAd", null);
        this.f316c = new C0321c(this, "nextAd", null);
        this.f326m = new C0321c(this, "adListener");
        this.f327n = new C0321c(this, "appEventListener");
        this.f314a = new C0320b(this, "appState", c0280l);
        this.f321h = new C0320b(this, "ad", ad);
        this.f322i = new C0320b(this, "adView", adView);
        this.f324k = new C0320b(this, "adType", c0270h);
        this.f317d = new C0320b(this, "adUnitId", str);
        this.f318e = new C0322d(this, "activity", activity);
        this.f323j = new C0320b(this, "interstitialAd", interstitialAd);
        this.f320g = new C0320b(this, "bannerContainer", viewGroup);
        this.f319f = new C0320b(this, "applicationContext", context);
        this.f325l = new C0321c(this, "adSizes", null);
    }
}
