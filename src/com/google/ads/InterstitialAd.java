package com.google.ads;

import android.app.Activity;
import com.google.ads.internal.C0264d;

public class InterstitialAd implements Ad {
    private C0264d f49a;

    public InterstitialAd(Activity activity, String adUnitId) {
        this(activity, adUnitId, false);
    }

    public InterstitialAd(Activity activity, String adUnitId, boolean shortTimeout) {
        this.f49a = new C0264d(this, activity, null, adUnitId, null, shortTimeout);
    }

    public boolean isReady() {
        return this.f49a.m229r();
    }

    public void loadAd(AdRequest adRequest) {
        this.f49a.m201a(adRequest);
    }

    public void show() {
        this.f49a.m237z();
    }

    public void setAdListener(AdListener adListener) {
        this.f49a.m219h().f326m.m413a(adListener);
    }

    protected void setAppEventListener(AppEventListener appEventListener) {
        this.f49a.m219h().f327n.m413a(appEventListener);
    }

    public void stopLoading() {
        this.f49a.m191A();
    }
}
