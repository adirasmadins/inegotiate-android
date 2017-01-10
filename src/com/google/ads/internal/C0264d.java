package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.Ad;
import com.google.ads.AdActivity;
import com.google.ads.AdListener;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.AppEventListener;
import com.google.ads.C0227b;
import com.google.ads.C0229c;
import com.google.ads.C0230d;
import com.google.ads.C0239e;
import com.google.ads.C0240f;
import com.google.ads.C0242g;
import com.google.ads.C0245h;
import com.google.ads.C0280l;
import com.google.ads.C0280l.C0279a;
import com.google.ads.C0281m;
import com.google.ads.InterstitialAd;
import com.google.ads.ac;
import com.google.ads.ae;
import com.google.ads.ag;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0296a;
import com.google.ads.util.C0299b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.google.ads.internal.d */
public class C0264d {
    private static final Object f223a;
    private final C0281m f224b;
    private C0263c f225c;
    private AdRequest f226d;
    private C0269g f227e;
    private AdWebView f228f;
    private C0271i f229g;
    private Handler f230h;
    private long f231i;
    private boolean f232j;
    private boolean f233k;
    private boolean f234l;
    private boolean f235m;
    private boolean f236n;
    private SharedPreferences f237o;
    private long f238p;
    private ae f239q;
    private boolean f240r;
    private LinkedList<String> f241s;
    private LinkedList<String> f242t;
    private int f243u;
    private Boolean f244v;
    private C0230d f245w;
    private C0239e f246x;
    private C0240f f247y;
    private String f248z;

    static {
        f223a = new Object();
    }

    public C0264d(Ad ad, Activity activity, AdSize adSize, String str, ViewGroup viewGroup, boolean z) {
        this.f243u = -1;
        this.f248z = null;
        this.f240r = z;
        this.f227e = new C0269g();
        this.f225c = null;
        this.f226d = null;
        this.f233k = false;
        this.f230h = new Handler();
        this.f238p = 60000;
        this.f234l = false;
        this.f236n = false;
        this.f235m = true;
        AdView adView;
        InterstitialAd interstitialAd;
        C0270h c0270h;
        if (activity == null) {
            C0280l a = C0280l.m309a();
            if (ad instanceof AdView) {
                adView = (AdView) ad;
            } else {
                adView = null;
            }
            if (ad instanceof InterstitialAd) {
                interstitialAd = (InterstitialAd) ad;
            } else {
                interstitialAd = null;
            }
            if (adSize == null) {
                c0270h = C0270h.f274a;
            } else {
                c0270h = C0270h.m295a(adSize);
            }
            this.f224b = new C0281m(a, ad, adView, interstitialAd, str, null, null, viewGroup, c0270h);
            return;
        }
        synchronized (f223a) {
            this.f237o = activity.getApplicationContext().getSharedPreferences("GoogleAdMobAdsPrefs", 0);
            if (z) {
                long j = this.f237o.getLong("Timeout" + str, -1);
                if (j < 0) {
                    this.f231i = 5000;
                } else {
                    this.f231i = j;
                }
            } else {
                this.f231i = 60000;
            }
        }
        a = C0280l.m309a();
        if (ad instanceof AdView) {
            adView = (AdView) ad;
        } else {
            adView = null;
        }
        if (ad instanceof InterstitialAd) {
            interstitialAd = (InterstitialAd) ad;
        } else {
            interstitialAd = null;
        }
        Context applicationContext = activity.getApplicationContext();
        if (adSize == null) {
            c0270h = C0270h.f274a;
        } else {
            c0270h = C0270h.m296a(adSize, activity.getApplicationContext());
        }
        this.f224b = new C0281m(a, ad, adView, interstitialAd, str, activity, applicationContext, viewGroup, c0270h);
        this.f239q = new ae(this);
        this.f241s = new LinkedList();
        this.f242t = new LinkedList();
        m194a();
        AdUtil.m366h((Context) this.f224b.f319f.m411a());
        this.f245w = new C0230d();
        this.f246x = new C0239e(this);
        this.f244v = null;
        this.f247y = null;
    }

    public synchronized void m194a() {
        this.f228f = new AdWebView(this.f224b, ((C0270h) this.f224b.f324k.m411a()).m298b());
        this.f228f.setVisibility(8);
        this.f229g = C0271i.m300a(this, C0254a.f172c, true, this.f224b.m311b());
        this.f228f.setWebViewClient(this.f229g);
        if (AdUtil.f371a < ((Integer) ((C0279a) ((C0280l) this.f224b.f314a.m411a()).f313a.m411a()).f300a.m412a()).intValue() && !((C0270h) this.f224b.f324k.m411a()).m297a()) {
            C0299b.m380a("Disabling hardware acceleration for a banner.");
            this.f228f.m132b();
        }
    }

    public synchronized void m209b() {
        if (this.f246x != null) {
            this.f246x.m90b();
        }
        this.f224b.f326m.m413a(null);
        this.f224b.f327n.m413a(null);
        m191A();
        if (this.f228f != null) {
            this.f228f.destroy();
        }
    }

    public void m205a(String str) {
        Uri build = new Builder().encodedQuery(str).build();
        StringBuilder stringBuilder = new StringBuilder();
        Map b = AdUtil.m355b(build);
        for (String str2 : b.keySet()) {
            stringBuilder.append(str2).append(" = ").append((String) b.get(str2)).append("\n");
        }
        this.f248z = stringBuilder.toString().trim();
        if (TextUtils.isEmpty(this.f248z)) {
            this.f248z = null;
        }
    }

    public String m214c() {
        return this.f248z;
    }

    public synchronized void m215d() {
        this.f235m = false;
        C0299b.m380a("Refreshing is no longer allowed on this AdView.");
    }

    public synchronized void m216e() {
        if (this.f234l) {
            C0299b.m380a("Disabling refreshing.");
            this.f230h.removeCallbacks(this.f239q);
            this.f234l = false;
        } else {
            C0299b.m380a("Refreshing is already disabled.");
        }
    }

    public synchronized void m217f() {
        this.f236n = false;
        if (!this.f224b.m310a()) {
            C0299b.m380a("Tried to enable refreshing on something other than an AdView.");
        } else if (!this.f235m) {
            C0299b.m380a("Refreshing disabled on this AdView");
        } else if (this.f234l) {
            C0299b.m380a("Refreshing is already enabled.");
        } else {
            C0299b.m380a("Enabling refreshing every " + this.f238p + " milliseconds.");
            this.f230h.postDelayed(this.f239q, this.f238p);
            this.f234l = true;
        }
    }

    public void m218g() {
        m217f();
        this.f236n = true;
    }

    public C0281m m219h() {
        return this.f224b;
    }

    public synchronized C0230d m220i() {
        return this.f245w;
    }

    public synchronized C0263c m221j() {
        return this.f225c;
    }

    public synchronized AdWebView m222k() {
        return this.f228f;
    }

    public synchronized C0271i m223l() {
        return this.f229g;
    }

    public C0269g m224m() {
        return this.f227e;
    }

    public synchronized void m196a(int i) {
        this.f243u = i;
    }

    public synchronized int m225n() {
        return this.f243u;
    }

    public long m226o() {
        return this.f231i;
    }

    public synchronized boolean m227p() {
        return this.f225c != null;
    }

    public synchronized boolean m228q() {
        return this.f232j;
    }

    public synchronized boolean m229r() {
        return this.f233k;
    }

    public synchronized boolean m230s() {
        return this.f234l;
    }

    public synchronized void m201a(AdRequest adRequest) {
        if (m227p()) {
            C0299b.m390e("loadAd called while the ad is already loading, so aborting.");
        } else if (AdActivity.isShowing()) {
            C0299b.m390e("loadAd called while an interstitial or landing page is displayed, so aborting");
        } else if (AdUtil.m360c((Context) this.f224b.f319f.m411a()) && AdUtil.m357b((Context) this.f224b.f319f.m411a())) {
            if (ag.m46a((Context) this.f224b.f319f.m411a(), this.f237o.getLong("GoogleAdMobDoritosLife", 60000))) {
                ag.m42a((Activity) this.f224b.f318e.m414a());
            }
            this.f233k = false;
            this.f241s.clear();
            this.f226d = adRequest;
            if (this.f245w.m70a()) {
                this.f246x.m85a(this.f245w.m71b(), adRequest);
            } else {
                this.f225c = new C0263c(this);
                this.f225c.m172a(adRequest);
            }
        }
    }

    public synchronized void m200a(ErrorCode errorCode) {
        this.f225c = null;
        if (errorCode == ErrorCode.NETWORK_ERROR) {
            m195a(60.0f);
            if (!m230s()) {
                m218g();
            }
        }
        if (this.f224b.m311b()) {
            if (errorCode == ErrorCode.NO_FILL) {
                this.f227e.m264B();
            } else if (errorCode == ErrorCode.NETWORK_ERROR) {
                this.f227e.m294z();
            }
        }
        C0299b.m386c("onFailedToReceiveAd(" + errorCode + ")");
        AdListener adListener = (AdListener) this.f224b.f326m.m412a();
        if (adListener != null) {
            adListener.onFailedToReceiveAd((Ad) this.f224b.f321h.m411a(), errorCode);
        }
    }

    public synchronized void m202a(C0229c c0229c) {
        this.f225c = null;
        if (c0229c.m62d()) {
            m195a((float) c0229c.m63e());
            if (!this.f234l) {
                m217f();
            }
        } else if (this.f234l) {
            m216e();
        }
        this.f246x.m85a(c0229c, this.f226d);
    }

    public synchronized void m199a(View view, C0245h c0245h, C0240f c0240f, boolean z) {
        C0299b.m380a("AdManager.onReceiveGWhirlAd() called.");
        this.f233k = true;
        this.f247y = c0240f;
        if (this.f224b.m310a()) {
            m198a(view);
            m187a(c0240f, Boolean.valueOf(z));
        }
        this.f246x.m94d(c0245h);
        AdListener adListener = (AdListener) this.f224b.f326m.m412a();
        if (adListener != null) {
            adListener.onReceiveAd((Ad) this.f224b.f321h.m411a());
        }
    }

    public synchronized void m203a(C0240f c0240f, boolean z) {
        C0299b.m380a(String.format(Locale.US, "AdManager.onGWhirlAdClicked(%b) called.", new Object[]{Boolean.valueOf(z)}));
        m190b(c0240f, Boolean.valueOf(z));
    }

    public synchronized void m211b(C0229c c0229c) {
        C0299b.m380a("AdManager.onGWhirlNoFill() called.");
        m188a(c0229c.m67i(), c0229c.m61c());
        AdListener adListener = (AdListener) this.f224b.f326m.m412a();
        if (adListener != null) {
            adListener.onFailedToReceiveAd((Ad) this.f224b.f321h.m411a(), ErrorCode.NO_FILL);
        }
    }

    public synchronized void m231t() {
        this.f227e.m265C();
        C0299b.m386c("onDismissScreen()");
        AdListener adListener = (AdListener) this.f224b.f326m.m412a();
        if (adListener != null) {
            adListener.onDismissScreen((Ad) this.f224b.f321h.m411a());
        }
    }

    public synchronized void m232u() {
        C0299b.m386c("onPresentScreen()");
        AdListener adListener = (AdListener) this.f224b.f326m.m412a();
        if (adListener != null) {
            adListener.onPresentScreen((Ad) this.f224b.f321h.m411a());
        }
    }

    public synchronized void m233v() {
        C0299b.m386c("onLeaveApplication()");
        AdListener adListener = (AdListener) this.f224b.f326m.m412a();
        if (adListener != null) {
            adListener.onLeaveApplication((Ad) this.f224b.f321h.m411a());
        }
    }

    public synchronized void m206a(String str, String str2) {
        AppEventListener appEventListener = (AppEventListener) this.f224b.f327n.m412a();
        if (appEventListener != null) {
            appEventListener.onAppEvent((Ad) this.f224b.f321h.m411a(), str, str2);
        }
    }

    public void m234w() {
        this.f227e.m274f();
        m192B();
    }

    private void m187a(C0240f c0240f, Boolean bool) {
        List d = c0240f.m98d();
        if (d == null) {
            d = new ArrayList();
            d.add("http://e.admob.com/imp?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@&adt=@gw_adt@&aec=@gw_aec@");
        }
        String b = c0240f.m96b();
        m189a(d, c0240f.m95a(), b, c0240f.m97c(), bool, this.f227e.m272d(), this.f227e.m273e());
    }

    private void m190b(C0240f c0240f, Boolean bool) {
        List e = c0240f.m99e();
        if (e == null) {
            e = new ArrayList();
            e.add("http://e.admob.com/clk?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&ad_network_id=@gw_adnetid@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&nr=@gw_adnetrefresh@");
        }
        m189a(e, c0240f.m95a(), c0240f.m96b(), c0240f.m97c(), bool, null, null);
    }

    private void m188a(List<String> list, String str) {
        List arrayList;
        if (list == null) {
            arrayList = new ArrayList();
            arrayList.add("http://e.admob.com/nofill?ad_loc=@gw_adlocid@&qdata=@gw_qdata@&js=@gw_sdkver@&session_id=@gw_sessid@&seq_num=@gw_seqnum@&adt=@gw_adt@&aec=@gw_aec@");
        } else {
            List<String> list2 = list;
        }
        m189a(arrayList, null, null, str, null, this.f227e.m272d(), this.f227e.m273e());
    }

    private void m189a(List<String> list, String str, String str2, String str3, Boolean bool, String str4, String str5) {
        String a = AdUtil.m339a((Context) this.f224b.f319f.m411a());
        C0227b a2 = C0227b.m51a();
        String bigInteger = a2.m54b().toString();
        String bigInteger2 = a2.m55c().toString();
        for (String a3 : list) {
            new Thread(new ac(C0242g.m101a(a3, (String) this.f224b.f317d.m411a(), bool, a, str, str2, str3, bigInteger, bigInteger2, str4, str5), (Context) this.f224b.f319f.m411a())).start();
        }
        this.f227e.m270b();
    }

    public synchronized void m235x() {
        Activity activity = (Activity) this.f224b.f318e.m414a();
        if (activity == null) {
            C0299b.m390e("activity was null while trying to ping tracking URLs.");
        } else {
            Iterator it = this.f241s.iterator();
            while (it.hasNext()) {
                new Thread(new ac((String) it.next(), activity.getApplicationContext())).start();
            }
        }
    }

    public void m204a(Runnable runnable) {
        this.f230h.post(runnable);
    }

    public synchronized void m236y() {
        if (this.f226d == null) {
            C0299b.m380a("Tried to refresh before calling loadAd().");
        } else if (this.f224b.m310a()) {
            if (((AdView) this.f224b.f322i.m411a()).isShown() && AdUtil.m362d()) {
                C0299b.m386c("Refreshing ad.");
                m201a(this.f226d);
            } else {
                C0299b.m380a("Not refreshing because the ad is not visible.");
            }
            if (this.f236n) {
                m216e();
            } else {
                this.f230h.postDelayed(this.f239q, this.f238p);
            }
        } else {
            C0299b.m380a("Tried to refresh an ad that wasn't an AdView.");
        }
    }

    public void m197a(long j) {
        synchronized (f223a) {
            Editor edit = this.f237o.edit();
            edit.putLong("Timeout" + this.f224b.f317d, j);
            edit.commit();
            if (this.f240r) {
                this.f231i = j;
            }
        }
    }

    public synchronized void m208a(boolean z) {
        this.f232j = z;
    }

    public void m198a(View view) {
        ((ViewGroup) this.f224b.f320g.m411a()).removeAllViews();
        ((ViewGroup) this.f224b.f320g.m411a()).addView(view);
    }

    public synchronized void m195a(float f) {
        long j = this.f238p;
        this.f238p = (long) (1000.0f * f);
        if (m230s() && this.f238p != j) {
            m216e();
            m217f();
        }
    }

    public synchronized void m210b(long j) {
        if (j > 0) {
            this.f237o.edit().putLong("GoogleAdMobDoritosLife", j).commit();
        }
    }

    public synchronized void m237z() {
        C0296a.m371a(this.f224b.m311b());
        if (this.f233k) {
            this.f233k = false;
            if (this.f244v == null) {
                C0299b.m384b("isMediationFlag is null in show() with isReady() true. we should have an ad and know whether this is a mediation request or not. ");
            } else if (!this.f244v.booleanValue()) {
                AdActivity.launchAdActivity(this, new C0265e("interstitial"));
                m235x();
            } else if (this.f246x.m93c()) {
                m187a(this.f247y, Boolean.valueOf(false));
            }
        } else {
            C0299b.m386c("Cannot show interstitial because it is not loaded and ready.");
        }
    }

    public synchronized void m191A() {
        if (this.f225c != null) {
            this.f225c.m168a();
            this.f225c = null;
        }
        if (this.f228f != null) {
            this.f228f.stopLoading();
        }
    }

    protected synchronized void m192B() {
        Activity activity = (Activity) this.f224b.f318e.m414a();
        if (activity == null) {
            C0299b.m390e("activity was null while trying to ping click tracking URLs.");
        } else {
            Iterator it = this.f242t.iterator();
            while (it.hasNext()) {
                new Thread(new ac((String) it.next(), activity.getApplicationContext())).start();
            }
        }
    }

    protected synchronized void m193C() {
        this.f225c = null;
        this.f233k = true;
        this.f228f.setVisibility(0);
        if (this.f224b.m310a()) {
            m198a(this.f228f);
        }
        this.f227e.m275g();
        if (this.f224b.m310a()) {
            m235x();
        }
        C0299b.m386c("onReceiveAd()");
        AdListener adListener = (AdListener) this.f224b.f326m.m412a();
        if (adListener != null) {
            adListener.onReceiveAd((Ad) this.f224b.f321h.m411a());
        }
    }

    protected synchronized void m212b(String str) {
        C0299b.m380a("Adding a tracking URL: " + str);
        this.f241s.add(str);
    }

    protected synchronized void m207a(LinkedList<String> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C0299b.m380a("Adding a click tracking URL: " + ((String) it.next()));
        }
        this.f242t = linkedList;
    }

    public void m213b(boolean z) {
        this.f244v = Boolean.valueOf(z);
    }
}
