package com.google.ads;

import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.C0242g.C0241a;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.util.C0296a;
import com.google.ads.util.C0299b;

/* renamed from: com.google.ads.k */
class C0277k implements MediationInterstitialListener {
    private final C0245h f294a;

    C0277k(C0245h c0245h) {
        this.f294a = c0245h;
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> adapter) {
        synchronized (this.f294a) {
            C0296a.m369a((Object) adapter, this.f294a.m115i());
            if (this.f294a.m109c()) {
                C0299b.m384b("Got an onReceivedAd() callback after loadAdTask is done from an interstitial adapter. Ignoring callback.");
            } else {
                this.f294a.m107a(true, C0241a.AD);
            }
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> adapter, ErrorCode error) {
        synchronized (this.f294a) {
            C0296a.m369a((Object) adapter, this.f294a.m115i());
            C0299b.m380a("Mediation adapter " + adapter.getClass().getName() + " failed to receive ad with error code: " + error);
            if (this.f294a.m109c()) {
                C0299b.m384b("Got an onFailedToReceiveAd() callback after loadAdTask is done from an interstitial adapter.  Ignoring callback.");
            } else {
                this.f294a.m107a(false, error == ErrorCode.NO_FILL ? C0241a.NO_FILL : C0241a.ERROR);
            }
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        synchronized (this.f294a) {
            this.f294a.m116j().m86a(this.f294a);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        synchronized (this.f294a) {
            this.f294a.m116j().m91b(this.f294a);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        synchronized (this.f294a) {
            this.f294a.m116j().m92c(this.f294a);
        }
    }
}
