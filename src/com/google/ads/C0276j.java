package com.google.ads;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.C0242g.C0241a;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.util.C0296a;
import com.google.ads.util.C0299b;

/* renamed from: com.google.ads.j */
class C0276j implements MediationBannerListener {
    private final C0245h f292a;
    private boolean f293b;

    public C0276j(C0245h c0245h) {
        this.f292a = c0245h;
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> adapter) {
        synchronized (this.f292a) {
            C0296a.m369a((Object) adapter, this.f292a.m115i());
            try {
                this.f292a.m105a(adapter.getBannerView());
                if (this.f292a.m109c()) {
                    this.f293b = true;
                    this.f292a.m116j().m87a(this.f292a, this.f292a.m112f());
                    return;
                }
                this.f293b = false;
                this.f292a.m107a(true, C0241a.AD);
            } catch (Throwable th) {
                C0299b.m385b("Error while getting banner View from adapter (" + this.f292a.m114h() + "): ", th);
                if (!this.f292a.m109c()) {
                    this.f292a.m107a(false, C0241a.EXCEPTION);
                }
            }
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> adapter, ErrorCode error) {
        synchronized (this.f292a) {
            C0296a.m369a((Object) adapter, this.f292a.m115i());
            C0299b.m380a("Mediation adapter " + adapter.getClass().getName() + " failed to receive ad with error code: " + error);
            if (!this.f292a.m109c()) {
                this.f292a.m107a(false, error == ErrorCode.NO_FILL ? C0241a.NO_FILL : C0241a.ERROR);
            }
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f292a) {
            this.f292a.m116j().m86a(this.f292a);
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f292a) {
            this.f292a.m116j().m91b(this.f292a);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f292a) {
            this.f292a.m116j().m92c(this.f292a);
        }
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        synchronized (this.f292a) {
            C0296a.m371a(this.f292a.m109c());
            this.f292a.m116j().m88a(this.f292a, this.f293b);
        }
    }
}
