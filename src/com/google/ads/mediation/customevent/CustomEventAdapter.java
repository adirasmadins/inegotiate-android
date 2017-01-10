package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.C0242g;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.C0296a;
import com.google.ads.util.C0299b;
import com.google.gdata.util.common.base.StringUtil;

public class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private String f342a;
    private CustomEventBanner f343b;
    private C0285a f344c;
    private CustomEventInterstitial f345d;

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.a */
    private class C0285a implements CustomEventBannerListener {
        final /* synthetic */ CustomEventAdapter f337a;
        private View f338b;
        private final MediationBannerListener f339c;

        public C0285a(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.f337a = customEventAdapter;
            this.f339c = mediationBannerListener;
        }

        public synchronized void onReceivedAd(View view) {
            C0299b.m380a(m320b() + " called onReceivedAd.");
            this.f338b = view;
            this.f339c.onReceivedAd(this.f337a);
        }

        public void onFailedToReceiveAd() {
            C0299b.m380a(m320b() + " called onFailedToReceiveAd().");
            this.f339c.onFailedToReceiveAd(this.f337a, ErrorCode.NO_FILL);
        }

        public void onClick() {
            C0299b.m380a(m320b() + " called onClick().");
            this.f339c.onClick(this.f337a);
        }

        public void onPresentScreen() {
            C0299b.m380a(m320b() + " called onPresentScreen().");
            this.f339c.onPresentScreen(this.f337a);
        }

        public void onDismissScreen() {
            C0299b.m380a(m320b() + " called onDismissScreen().");
            this.f339c.onDismissScreen(this.f337a);
        }

        public synchronized void onLeaveApplication() {
            C0299b.m380a(m320b() + " called onLeaveApplication().");
            this.f339c.onLeaveApplication(this.f337a);
        }

        public synchronized View m321a() {
            return this.f338b;
        }

        private String m320b() {
            return "Banner custom event labeled '" + this.f337a.f342a + "'";
        }
    }

    /* renamed from: com.google.ads.mediation.customevent.CustomEventAdapter.b */
    private class C0286b implements CustomEventInterstitialListener {
        final /* synthetic */ CustomEventAdapter f340a;
        private final MediationInterstitialListener f341b;

        public C0286b(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.f340a = customEventAdapter;
            this.f341b = mediationInterstitialListener;
        }

        public void onReceivedAd() {
            C0299b.m380a(m322a() + " called onReceivedAd.");
            this.f341b.onReceivedAd(this.f340a);
        }

        public void onFailedToReceiveAd() {
            C0299b.m380a(m322a() + " called onFailedToReceiveAd().");
            this.f341b.onFailedToReceiveAd(this.f340a, ErrorCode.NO_FILL);
        }

        public void onPresentScreen() {
            C0299b.m380a(m322a() + " called onPresentScreen().");
            this.f341b.onPresentScreen(this.f340a);
        }

        public void onDismissScreen() {
            C0299b.m380a(m322a() + " called onDismissScreen().");
            this.f341b.onDismissScreen(this.f340a);
        }

        public synchronized void onLeaveApplication() {
            C0299b.m380a(m322a() + " called onLeaveApplication().");
            this.f341b.onLeaveApplication(this.f340a);
        }

        private String m322a() {
            return "Interstitial custom event labeled '" + this.f340a.f342a + "'";
        }
    }

    public CustomEventAdapter() {
        this.f343b = null;
        this.f344c = null;
        this.f345d = null;
    }

    public void requestBannerAd(MediationBannerListener mediationListener, Activity activity, CustomEventServerParameters serverParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras mediationExtras) {
        C0296a.m368a(this.f342a);
        this.f342a = serverParameters.label;
        String str = serverParameters.className;
        String str2 = serverParameters.parameter;
        this.f343b = (CustomEventBanner) m323a(str, CustomEventBanner.class, this.f342a);
        if (this.f343b == null) {
            mediationListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
            return;
        }
        C0296a.m368a(this.f344c);
        this.f344c = new C0285a(this, mediationListener);
        try {
            this.f343b.requestBannerAd(this.f344c, activity, this.f342a, str2, adSize, mediationAdRequest, mediationExtras == null ? null : mediationExtras.getExtra(this.f342a));
        } catch (Throwable th) {
            m325a(StringUtil.EMPTY_STRING, th);
            mediationListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        }
    }

    public View getBannerView() {
        C0296a.m373b(this.f344c);
        return this.f344c.m321a();
    }

    public void showInterstitial() {
        C0296a.m373b(this.f345d);
        try {
            this.f345d.showInterstitial();
        } catch (Throwable th) {
            C0299b.m385b("Exception when showing custom event labeled '" + this.f342a + "'.", th);
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationListener, Activity activity, CustomEventServerParameters serverParameters, MediationAdRequest mediationAdRequest, CustomEventExtras mediationExtras) {
        C0296a.m368a(this.f342a);
        this.f342a = serverParameters.label;
        String str = serverParameters.className;
        String str2 = serverParameters.parameter;
        this.f345d = (CustomEventInterstitial) m323a(str, CustomEventInterstitial.class, this.f342a);
        if (this.f345d == null) {
            mediationListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
            return;
        }
        try {
            this.f345d.requestInterstitialAd(new C0286b(this, mediationListener), activity, this.f342a, str2, mediationAdRequest, mediationExtras == null ? null : mediationExtras.getExtra(this.f342a));
        } catch (Throwable th) {
            m325a(StringUtil.EMPTY_STRING, th);
            mediationListener.onFailedToReceiveAd(this, ErrorCode.INTERNAL_ERROR);
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void destroy() {
        if (this.f343b != null) {
            this.f343b.destroy();
        }
        if (this.f345d != null) {
            this.f345d.destroy();
        }
    }

    private void m325a(String str, Throwable th) {
        C0299b.m385b("Error during processing of custom event with label: '" + this.f342a + "'. Skipping custom event. " + str, th);
    }

    private <T> T m323a(String str, Class<T> cls, String str2) {
        try {
            return C0242g.m100a(str, cls);
        } catch (Throwable e) {
            m325a("Make sure you created a visible class named: " + str + ". ", e);
            return null;
        } catch (Throwable e2) {
            m325a("Make sure your custom event implements the " + cls.getName() + " interface.", e2);
            return null;
        } catch (Throwable e22) {
            m325a("Make sure the default constructor for class " + str + " is visible. ", e22);
            return null;
        } catch (Throwable e222) {
            m325a("Make sure the name " + str + " does not denote an abstract class or an interface.", e222);
            return null;
        } catch (Throwable e2222) {
            m325a(StringUtil.EMPTY_STRING, e2222);
            return null;
        }
    }
}
