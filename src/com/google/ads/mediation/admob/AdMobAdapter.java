package com.google.ads.mediation.admob;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.google.ads.Ad;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.InterstitialAd;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.NetworkExtras;
import com.google.ads.util.AdUtil;

public class AdMobAdapter implements MediationBannerAdapter<AdMobAdapterExtras, AdMobAdapterServerParameters>, MediationInterstitialAdapter<AdMobAdapterExtras, AdMobAdapterServerParameters> {
    private MediationBannerListener f333a;
    private MediationInterstitialListener f334b;
    private AdView f335c;
    private InterstitialAd f336d;

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.a */
    private class C0283a implements AdListener {
        final /* synthetic */ AdMobAdapter f331a;

        private C0283a(AdMobAdapter adMobAdapter) {
            this.f331a = adMobAdapter;
        }

        public void onReceiveAd(Ad ad) {
            this.f331a.f333a.onReceivedAd(this.f331a);
        }

        public void onFailedToReceiveAd(Ad ad, ErrorCode error) {
            this.f331a.f333a.onFailedToReceiveAd(this.f331a, error);
        }

        public void onPresentScreen(Ad ad) {
            this.f331a.f333a.onClick(this.f331a);
            this.f331a.f333a.onPresentScreen(this.f331a);
        }

        public void onDismissScreen(Ad ad) {
            this.f331a.f333a.onDismissScreen(this.f331a);
        }

        public void onLeaveApplication(Ad ad) {
            this.f331a.f333a.onLeaveApplication(this.f331a);
        }
    }

    /* renamed from: com.google.ads.mediation.admob.AdMobAdapter.b */
    private class C0284b implements AdListener {
        final /* synthetic */ AdMobAdapter f332a;

        private C0284b(AdMobAdapter adMobAdapter) {
            this.f332a = adMobAdapter;
        }

        public void onReceiveAd(Ad ad) {
            this.f332a.f334b.onReceivedAd(this.f332a);
        }

        public void onFailedToReceiveAd(Ad ad, ErrorCode error) {
            this.f332a.f334b.onFailedToReceiveAd(this.f332a, error);
        }

        public void onPresentScreen(Ad ad) {
            this.f332a.f334b.onPresentScreen(this.f332a);
        }

        public void onDismissScreen(Ad ad) {
            this.f332a.f334b.onDismissScreen(this.f332a);
        }

        public void onLeaveApplication(Ad ad) {
            this.f332a.f334b.onLeaveApplication(this.f332a);
        }
    }

    private void m315a() {
        if (m317b()) {
            throw new IllegalStateException("Adapter has already been destroyed");
        }
    }

    private boolean m317b() {
        return this.f335c == null && this.f336d == null;
    }

    private AdRequest m313a(Activity activity, AdMobAdapterServerParameters adMobAdapterServerParameters, MediationAdRequest mediationAdRequest, AdMobAdapterExtras adMobAdapterExtras) {
        NetworkExtras adMobAdapterExtras2 = new AdMobAdapterExtras(adMobAdapterExtras);
        adMobAdapterExtras2.addExtra("_norefresh", "t");
        adMobAdapterExtras2.addExtra("gw", Integer.valueOf(1));
        if (adMobAdapterServerParameters.allowHouseAds != null) {
            adMobAdapterExtras2.addExtra("mad_hac", adMobAdapterServerParameters.allowHouseAds);
        }
        AdRequest networkExtras = new AdRequest().setBirthday(mediationAdRequest.getBirthday()).setGender(mediationAdRequest.getGender()).setKeywords(mediationAdRequest.getKeywords()).setLocation(mediationAdRequest.getLocation()).setNetworkExtras(adMobAdapterExtras2);
        if (mediationAdRequest.isTesting()) {
            networkExtras.addTestDevice(AdUtil.m339a((Context) activity));
        }
        return networkExtras;
    }

    protected AdView m318a(Activity activity, AdSize adSize, String str) {
        return new AdView(activity, adSize, str);
    }

    protected InterstitialAd m319a(Activity activity, String str) {
        return new InterstitialAd(activity, str);
    }

    public Class<AdMobAdapterExtras> getAdditionalParametersType() {
        return AdMobAdapterExtras.class;
    }

    public Class<AdMobAdapterServerParameters> getServerParametersType() {
        return AdMobAdapterServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener listener, Activity activity, AdMobAdapterServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, AdMobAdapterExtras extras) {
        this.f333a = listener;
        if (!(adSize.isAutoHeight() || adSize.isFullWidth() || (extras != null && extras.getUseExactAdSize()))) {
            adSize = adSize.findBestSize(AdSize.BANNER, AdSize.IAB_BANNER, AdSize.IAB_LEADERBOARD, AdSize.IAB_MRECT, AdSize.IAB_WIDE_SKYSCRAPER);
            if (adSize == null) {
                listener.onFailedToReceiveAd(this, ErrorCode.NO_FILL);
                return;
            }
        }
        this.f335c = m318a(activity, adSize, serverParameters.adUnitId);
        this.f335c.setAdListener(new C0283a());
        this.f335c.loadAd(m313a(activity, serverParameters, mediationAdRequest, extras));
    }

    public View getBannerView() {
        return this.f335c;
    }

    public void destroy() {
        m315a();
        if (this.f335c != null) {
            this.f335c.stopLoading();
            this.f335c.destroy();
            this.f335c = null;
        }
        if (this.f336d != null) {
            this.f336d.stopLoading();
            this.f336d = null;
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener listener, Activity activity, AdMobAdapterServerParameters serverParameters, MediationAdRequest mediationAdRequest, AdMobAdapterExtras extras) {
        this.f334b = listener;
        this.f336d = m319a(activity, serverParameters.adUnitId);
        this.f336d.setAdListener(new C0284b());
        this.f336d.loadAd(m313a(activity, serverParameters, mediationAdRequest, extras));
    }

    public void showInterstitial() {
        this.f336d.show();
    }
}
