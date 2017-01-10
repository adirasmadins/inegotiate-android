package com.google.ads;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import com.google.ads.C0242g.C0241a;
import com.google.ads.internal.C0270h;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.util.C0296a;
import com.google.ads.util.C0299b;
import java.util.HashMap;

/* renamed from: com.google.ads.h */
public class C0245h {
    final C0270h f135a;
    private final C0240f f136b;
    private boolean f137c;
    private boolean f138d;
    private C0241a f139e;
    private final C0239e f140f;
    private MediationAdapter<?, ?> f141g;
    private boolean f142h;
    private boolean f143i;
    private View f144j;
    private final Handler f145k;
    private final String f146l;
    private final AdRequest f147m;
    private final HashMap<String, String> f148n;

    /* renamed from: com.google.ads.h.1 */
    class C02431 implements Runnable {
        final /* synthetic */ C0245h f132a;

        C02431(C0245h c0245h) {
            this.f132a = c0245h;
        }

        public void run() {
            if (this.f132a.m118l()) {
                C0296a.m373b(this.f132a.f141g);
                try {
                    this.f132a.f141g.destroy();
                    C0299b.m380a("Called destroy() for adapter with class: " + this.f132a.f141g.getClass().getName());
                } catch (Throwable th) {
                    C0299b.m385b("Error while destroying adapter (" + this.f132a.m114h() + "):", th);
                }
            }
        }
    }

    /* renamed from: com.google.ads.h.2 */
    class C02442 implements Runnable {
        final /* synthetic */ MediationInterstitialAdapter f133a;
        final /* synthetic */ C0245h f134b;

        C02442(C0245h c0245h, MediationInterstitialAdapter mediationInterstitialAdapter) {
            this.f134b = c0245h;
            this.f133a = mediationInterstitialAdapter;
        }

        public void run() {
            try {
                this.f133a.showInterstitial();
            } catch (Throwable th) {
                C0299b.m385b("Error while telling adapter (" + this.f134b.m114h() + ") ad to show interstitial: ", th);
            }
        }
    }

    public C0245h(C0239e c0239e, C0270h c0270h, C0240f c0240f, String str, AdRequest adRequest, HashMap<String, String> hashMap) {
        C0296a.m374b(TextUtils.isEmpty(str));
        this.f140f = c0239e;
        this.f135a = c0270h;
        this.f136b = c0240f;
        this.f146l = str;
        this.f147m = adRequest;
        this.f148n = hashMap;
        this.f137c = false;
        this.f138d = false;
        this.f139e = null;
        this.f141g = null;
        this.f142h = false;
        this.f143i = false;
        this.f144j = null;
        this.f145k = new Handler(Looper.getMainLooper());
    }

    public C0240f m103a() {
        return this.f136b;
    }

    public synchronized void m104a(Activity activity) {
        C0296a.m375b(this.f142h, "startLoadAdTask has already been called.");
        this.f142h = true;
        this.f145k.post(new C0247i(this, activity, this.f146l, this.f147m, this.f148n));
    }

    public synchronized void m108b() {
        C0296a.m372a(this.f142h, "destroy() called but startLoadAdTask has not been called.");
        this.f145k.post(new C02431(this));
    }

    public synchronized boolean m109c() {
        return this.f137c;
    }

    public synchronized boolean m110d() {
        C0296a.m372a(this.f137c, "isLoadAdTaskSuccessful() called when isLoadAdTaskDone() is false.");
        return this.f138d;
    }

    public synchronized C0241a m111e() {
        C0241a c0241a;
        if (this.f139e == null) {
            c0241a = C0241a.TIMEOUT;
        } else {
            c0241a = this.f139e;
        }
        return c0241a;
    }

    public synchronized View m112f() {
        C0296a.m372a(this.f137c, "getAdView() called when isLoadAdTaskDone() is false.");
        return this.f144j;
    }

    public synchronized void m113g() {
        C0296a.m371a(this.f135a.m297a());
        try {
            this.f145k.post(new C02442(this, (MediationInterstitialAdapter) this.f141g));
        } catch (Throwable e) {
            C0299b.m385b("In Ambassador.show(): ambassador.adapter does not implement the MediationInterstitialAdapter interface.", e);
        }
    }

    public synchronized String m114h() {
        return this.f141g != null ? this.f141g.getClass().getName() : "\"adapter was not created.\"";
    }

    synchronized void m107a(boolean z, C0241a c0241a) {
        this.f138d = z;
        this.f137c = true;
        this.f139e = c0241a;
        notify();
    }

    synchronized void m106a(MediationAdapter<?, ?> mediationAdapter) {
        this.f141g = mediationAdapter;
    }

    synchronized MediationAdapter<?, ?> m115i() {
        return this.f141g;
    }

    C0239e m116j() {
        return this.f140f;
    }

    synchronized void m105a(View view) {
        this.f144j = view;
    }

    synchronized void m117k() {
        this.f143i = true;
    }

    synchronized boolean m118l() {
        return this.f143i;
    }
}
