package com.google.ads;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import com.google.ads.C0242g.C0241a;
import com.google.ads.internal.C0264d;
import com.google.ads.internal.C0270h;
import com.google.ads.util.C0296a;
import com.google.ads.util.C0299b;
import java.util.HashMap;
import java.util.List;

/* renamed from: com.google.ads.e */
public class C0239e {
    private final C0264d f112a;
    private C0245h f113b;
    private Object f114c;
    private Thread f115d;
    private Object f116e;
    private boolean f117f;
    private Object f118g;

    /* renamed from: com.google.ads.e.1 */
    class C02311 implements Runnable {
        final /* synthetic */ C0229c f94a;
        final /* synthetic */ AdRequest f95b;
        final /* synthetic */ C0239e f96c;

        C02311(C0239e c0239e, C0229c c0229c, AdRequest adRequest) {
            this.f96c = c0239e;
            this.f94a = c0229c;
            this.f95b = adRequest;
        }

        public void run() {
            this.f96c.m80b(this.f94a, this.f95b);
            synchronized (this.f96c.f116e) {
                this.f96c.f115d = null;
            }
        }
    }

    /* renamed from: com.google.ads.e.2 */
    class C02322 implements Runnable {
        final /* synthetic */ C0240f f97a;
        final /* synthetic */ boolean f98b;
        final /* synthetic */ C0239e f99c;

        C02322(C0239e c0239e, C0240f c0240f, boolean z) {
            this.f99c = c0239e;
            this.f97a = c0240f;
            this.f98b = z;
        }

        public void run() {
            this.f99c.f112a.m203a(this.f97a, this.f98b);
        }
    }

    /* renamed from: com.google.ads.e.3 */
    class C02333 implements Runnable {
        final /* synthetic */ View f100a;
        final /* synthetic */ C0240f f101b;
        final /* synthetic */ C0239e f102c;

        C02333(C0239e c0239e, View view, C0240f c0240f) {
            this.f102c = c0239e;
            this.f100a = view;
            this.f101b = c0240f;
        }

        public void run() {
            this.f102c.f112a.m199a(this.f100a, this.f102c.f113b, this.f101b, true);
        }
    }

    /* renamed from: com.google.ads.e.4 */
    class C02344 implements Runnable {
        final /* synthetic */ C0239e f103a;

        C02344(C0239e c0239e) {
            this.f103a = c0239e;
        }

        public void run() {
            this.f103a.f112a.m232u();
        }
    }

    /* renamed from: com.google.ads.e.5 */
    class C02355 implements Runnable {
        final /* synthetic */ C0239e f104a;

        C02355(C0239e c0239e) {
            this.f104a = c0239e;
        }

        public void run() {
            this.f104a.f112a.m231t();
        }
    }

    /* renamed from: com.google.ads.e.6 */
    class C02366 implements Runnable {
        final /* synthetic */ C0239e f105a;

        C02366(C0239e c0239e) {
            this.f105a = c0239e;
        }

        public void run() {
            this.f105a.f112a.m233v();
        }
    }

    /* renamed from: com.google.ads.e.7 */
    class C02377 implements Runnable {
        final /* synthetic */ C0229c f106a;
        final /* synthetic */ C0239e f107b;

        C02377(C0239e c0239e, C0229c c0229c) {
            this.f107b = c0239e;
            this.f106a = c0229c;
        }

        public void run() {
            this.f107b.f112a.m211b(this.f106a);
        }
    }

    /* renamed from: com.google.ads.e.8 */
    class C02388 implements Runnable {
        final /* synthetic */ C0245h f108a;
        final /* synthetic */ View f109b;
        final /* synthetic */ C0240f f110c;
        final /* synthetic */ C0239e f111d;

        C02388(C0239e c0239e, C0245h c0245h, View view, C0240f c0240f) {
            this.f111d = c0239e;
            this.f108a = c0245h;
            this.f109b = view;
            this.f110c = c0240f;
        }

        public void run() {
            if (this.f111d.m84e(this.f108a)) {
                C0299b.m380a("Trying to switch GWAdNetworkAmbassadors, but GWController().destroy() has been called. Destroying the new ambassador and terminating mediation.");
            } else {
                this.f111d.f112a.m199a(this.f109b, this.f108a, this.f110c, false);
            }
        }
    }

    public C0239e(C0264d c0264d) {
        this.f113b = null;
        this.f114c = new Object();
        this.f115d = null;
        this.f116e = new Object();
        this.f117f = false;
        this.f118g = new Object();
        C0296a.m373b((Object) c0264d);
        this.f112a = c0264d;
    }

    public boolean m89a() {
        boolean z;
        synchronized (this.f116e) {
            z = this.f115d != null;
        }
        return z;
    }

    public void m90b() {
        synchronized (this.f118g) {
            this.f117f = true;
            m94d(null);
            synchronized (this.f116e) {
                if (this.f115d != null) {
                    this.f115d.interrupt();
                }
            }
        }
    }

    public void m85a(C0229c c0229c, AdRequest adRequest) {
        synchronized (this.f116e) {
            if (m89a()) {
                C0299b.m386c("Mediation thread is not done executing previous mediation  request. Ignoring new mediation request");
                return;
            }
            C0239e.m75a(c0229c, this.f112a);
            this.f115d = new Thread(new C02311(this, c0229c, adRequest));
            this.f115d.start();
        }
    }

    public static boolean m75a(C0229c c0229c, C0264d c0264d) {
        if (c0229c.m68j() == null) {
            return true;
        }
        if (!c0264d.m219h().m311b()) {
            AdSize b = ((C0270h) c0264d.m219h().f324k.m411a()).m298b();
            if (c0229c.m68j().m297a()) {
                C0299b.m390e("AdView received a mediation response corresponding to an interstitial ad. Make sure you specify the banner ad size corresponding to the AdSize you used in your AdView  (" + b + ") in the ad-type field in the mediation UI.");
                return false;
            }
            AdSize b2 = c0229c.m68j().m298b();
            if (b2 == b) {
                return true;
            }
            C0299b.m390e("Mediation server returned ad size: '" + b2 + "', while the AdView was created with ad size: '" + b + "'. Using the ad-size passed to the AdView on creation.");
            return false;
        } else if (c0229c.m68j().m297a()) {
            return true;
        } else {
            C0299b.m390e("InterstitialAd received a mediation response corresponding to a non-interstitial ad. Make sure you specify 'interstitial' as the ad-type in the mediation UI.");
            return false;
        }
    }

    private boolean m77a(C0245h c0245h, String str) {
        if (m83e() == c0245h) {
            return true;
        }
        C0299b.m386c("GWController: ignoring callback to " + str + " from non showing ambassador with adapter class: '" + c0245h.m114h() + "'.");
        return false;
    }

    public void m88a(C0245h c0245h, boolean z) {
        if (m77a(c0245h, "onAdClicked()")) {
            this.f112a.m204a(new C02322(this, c0245h.m103a(), z));
        }
    }

    public void m87a(C0245h c0245h, View view) {
        if (m83e() != c0245h) {
            C0299b.m386c("GWController: ignoring onAdRefreshed() callback from non-showing ambassador (adapter class name is '" + c0245h.m114h() + "').");
            return;
        }
        this.f112a.m224m().m268a(C0241a.AD);
        this.f112a.m204a(new C02333(this, view, this.f113b.m103a()));
    }

    public void m86a(C0245h c0245h) {
        if (m77a(c0245h, "onPresentScreen")) {
            this.f112a.m204a(new C02344(this));
        }
    }

    public void m91b(C0245h c0245h) {
        if (m77a(c0245h, "onDismissScreen")) {
            this.f112a.m204a(new C02355(this));
        }
    }

    public void m92c(C0245h c0245h) {
        if (m77a(c0245h, "onLeaveApplication")) {
            this.f112a.m204a(new C02366(this));
        }
    }

    public boolean m93c() {
        C0296a.m371a(this.f112a.m219h().m311b());
        C0245h e = m83e();
        if (e != null) {
            e.m113g();
            return true;
        }
        C0299b.m384b("There is no ad ready to show.");
        return false;
    }

    protected C0239e() {
        this.f113b = null;
        this.f114c = new Object();
        this.f115d = null;
        this.f116e = new Object();
        this.f117f = false;
        this.f118g = new Object();
        this.f112a = null;
    }

    private boolean m82d() {
        boolean z;
        synchronized (this.f118g) {
            z = this.f117f;
        }
        return z;
    }

    private void m80b(C0229c c0229c, AdRequest adRequest) {
        synchronized (this.f116e) {
            C0296a.m369a(Thread.currentThread(), this.f115d);
        }
        List<C0219a> f = c0229c.m64f();
        long b = c0229c.m59a() ? (long) c0229c.m60b() : 10000;
        for (C0219a c0219a : f) {
            C0299b.m380a("Looking to fetch ads from network: " + c0219a.m32b());
            List<String> c = c0219a.m33c();
            HashMap e = c0219a.m35e();
            List d = c0219a.m34d();
            String a = c0219a.m31a();
            String b2 = c0219a.m32b();
            String c2 = c0229c.m61c();
            if (d == null) {
                d = c0229c.m65g();
            }
            C0240f c0240f = new C0240f(a, b2, c2, d, c0229c.m66h(), c0229c.m67i());
            for (String b22 : c) {
                Activity activity = (Activity) this.f112a.m219h().f318e.m414a();
                if (activity == null) {
                    C0299b.m380a("Activity is null while mediating.  Terminating mediation thread.");
                    return;
                }
                this.f112a.m224m().m271c();
                if (!m78a(b22, activity, adRequest, c0240f, e, b)) {
                    if (m82d()) {
                        C0299b.m380a("GWController.destroy() called. Terminating mediation thread.");
                        return;
                    }
                }
                return;
            }
        }
        this.f112a.m204a(new C02377(this, c0229c));
    }

    private boolean m78a(String str, Activity activity, AdRequest adRequest, C0240f c0240f, HashMap<String, String> hashMap, long j) {
        C0245h c0245h = new C0245h(this, (C0270h) this.f112a.m219h().f324k.m411a(), c0240f, str, adRequest, hashMap);
        synchronized (c0245h) {
            c0245h.m104a(activity);
            while (!c0245h.m109c() && j > 0) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    c0245h.wait(j);
                    j -= SystemClock.elapsedRealtime() - elapsedRealtime;
                } catch (InterruptedException e) {
                    C0299b.m380a("Interrupted while waiting for ad network to load ad using adapter class: " + str);
                }
            }
            this.f112a.m224m().m268a(c0245h.m111e());
            if (c0245h.m109c() && c0245h.m110d()) {
                this.f112a.m204a(new C02388(this, c0245h, this.f112a.m219h().m311b() ? null : c0245h.m112f(), c0240f));
                return true;
            }
            c0245h.m108b();
            return false;
        }
    }

    private boolean m84e(C0245h c0245h) {
        boolean z;
        synchronized (this.f118g) {
            if (m82d()) {
                c0245h.m108b();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    private C0245h m83e() {
        C0245h c0245h;
        synchronized (this.f114c) {
            c0245h = this.f113b;
        }
        return c0245h;
    }

    public void m94d(C0245h c0245h) {
        synchronized (this.f114c) {
            if (this.f113b != c0245h) {
                if (this.f113b != null) {
                    this.f113b.m108b();
                }
                this.f113b = c0245h;
            }
        }
    }
}
