package com.google.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import com.amazonaws.services.s3.internal.Constants;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.google.ads.AdRequest;
import com.google.ads.AdRequest.ErrorCode;
import com.google.ads.AdSize;
import com.google.ads.AdView;
import com.google.ads.C0227b;
import com.google.ads.C0229c;
import com.google.ads.C0230d;
import com.google.ads.C0280l;
import com.google.ads.C0280l.C0279a;
import com.google.ads.searchads.SearchAdRequest;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0299b;
import com.google.api.client.json.Json;
import com.google.gdata.client.GDataProtocol.Parameter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.google.ads.internal.c */
public class C0263c implements Runnable {
    boolean f201a;
    private String f202b;
    private String f203c;
    private String f204d;
    private String f205e;
    private boolean f206f;
    private C0268f f207g;
    private C0264d f208h;
    private AdRequest f209i;
    private WebView f210j;
    private String f211k;
    private LinkedList<String> f212l;
    private String f213m;
    private AdSize f214n;
    private volatile boolean f215o;
    private boolean f216p;
    private ErrorCode f217q;
    private boolean f218r;
    private int f219s;
    private Thread f220t;
    private boolean f221u;
    private C0261d f222v;

    /* renamed from: com.google.ads.internal.c.1 */
    class C02561 implements Runnable {
        final /* synthetic */ C0229c f175a;
        final /* synthetic */ C0263c f176b;

        C02561(C0263c c0263c, C0229c c0229c) {
            this.f176b = c0263c;
            this.f175a = c0229c;
        }

        public void run() {
            if (this.f176b.f210j != null) {
                this.f176b.f210j.stopLoading();
                this.f176b.f210j.destroy();
            }
            this.f176b.f208h.m205a(this.f176b.f213m);
            if (this.f176b.f214n != null) {
                ((C0270h) this.f176b.f208h.m219h().f324k.m411a()).m299b(this.f176b.f214n);
            }
            this.f176b.f208h.m202a(this.f175a);
        }
    }

    /* renamed from: com.google.ads.internal.c.2 */
    static /* synthetic */ class C02572 {
        static final /* synthetic */ int[] f177a;

        static {
            f177a = new int[C0261d.values().length];
            try {
                f177a[C0261d.ONLINE_SERVER_REQUEST.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f177a[C0261d.ONLINE_USING_BUFFERED_ADS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f177a[C0261d.OFFLINE_USING_BUFFERED_ADS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f177a[C0261d.OFFLINE_EMPTY.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.google.ads.internal.c.a */
    private static class C0258a implements Runnable {
        private final C0264d f178a;
        private final WebView f179b;
        private final C0268f f180c;
        private final ErrorCode f181d;
        private final boolean f182e;

        public C0258a(C0264d c0264d, WebView webView, C0268f c0268f, ErrorCode errorCode, boolean z) {
            this.f178a = c0264d;
            this.f179b = webView;
            this.f180c = c0268f;
            this.f181d = errorCode;
            this.f182e = z;
        }

        public void run() {
            if (this.f179b != null) {
                this.f179b.stopLoading();
                this.f179b.destroy();
            }
            if (this.f180c != null) {
                this.f180c.m259a();
            }
            if (this.f182e) {
                AdWebView k = this.f178a.m222k();
                k.stopLoading();
                k.setVisibility(8);
            }
            this.f178a.m200a(this.f181d);
        }
    }

    /* renamed from: com.google.ads.internal.c.b */
    private class C0259b extends Exception {
        final /* synthetic */ C0263c f183a;

        public C0259b(C0263c c0263c, String str) {
            this.f183a = c0263c;
            super(str);
        }
    }

    /* renamed from: com.google.ads.internal.c.c */
    private class C0260c implements Runnable {
        final /* synthetic */ C0263c f184a;
        private final String f185b;
        private final String f186c;
        private final WebView f187d;

        public C0260c(C0263c c0263c, WebView webView, String str, String str2) {
            this.f184a = c0263c;
            this.f187d = webView;
            this.f185b = str;
            this.f186c = str2;
        }

        public void run() {
            if (this.f186c != null) {
                this.f187d.loadDataWithBaseURL(this.f185b, this.f186c, Mimetypes.MIMETYPE_HTML, "utf-8", null);
            } else {
                this.f187d.loadUrl(this.f185b);
            }
        }
    }

    /* renamed from: com.google.ads.internal.c.d */
    public enum C0261d {
        ONLINE_USING_BUFFERED_ADS("online_buffered"),
        ONLINE_SERVER_REQUEST("online_request"),
        OFFLINE_USING_BUFFERED_ADS("offline_buffered"),
        OFFLINE_EMPTY("offline_empty");
        
        public String f193e;

        private C0261d(String str) {
            this.f193e = str;
        }
    }

    /* renamed from: com.google.ads.internal.c.e */
    private static class C0262e implements Runnable {
        private final C0264d f194a;
        private final WebView f195b;
        private final LinkedList<String> f196c;
        private final int f197d;
        private final boolean f198e;
        private final String f199f;
        private final AdSize f200g;

        public C0262e(C0264d c0264d, WebView webView, LinkedList<String> linkedList, int i, boolean z, String str, AdSize adSize) {
            this.f194a = c0264d;
            this.f195b = webView;
            this.f196c = linkedList;
            this.f197d = i;
            this.f198e = z;
            this.f199f = str;
            this.f200g = adSize;
        }

        public void run() {
            if (this.f195b != null) {
                this.f195b.stopLoading();
                this.f195b.destroy();
            }
            this.f194a.m207a(this.f196c);
            this.f194a.m196a(this.f197d);
            this.f194a.m208a(this.f198e);
            this.f194a.m205a(this.f199f);
            if (this.f200g != null) {
                ((C0270h) this.f194a.m219h().f324k.m411a()).m299b(this.f200g);
                this.f194a.m222k().setAdSize(this.f200g);
            }
            this.f194a.m193C();
        }
    }

    protected C0263c() {
        this.f222v = C0261d.ONLINE_SERVER_REQUEST;
    }

    public C0263c(C0264d c0264d) {
        this.f222v = C0261d.ONLINE_SERVER_REQUEST;
        this.f208h = c0264d;
        this.f211k = null;
        this.f202b = null;
        this.f203c = null;
        this.f204d = null;
        this.f212l = new LinkedList();
        this.f217q = null;
        this.f218r = false;
        this.f219s = -1;
        this.f206f = false;
        this.f216p = false;
        this.f213m = null;
        this.f214n = null;
        if (((Activity) c0264d.m219h().f318e.m414a()) != null) {
            this.f210j = new AdWebView(c0264d.m219h(), null);
            this.f210j.setWebViewClient(C0271i.m300a(c0264d, C0254a.f171b, false, false));
            this.f210j.setVisibility(8);
            this.f210j.setWillNotDraw(true);
            this.f207g = new C0268f(this, c0264d);
            return;
        }
        this.f210j = null;
        this.f207g = null;
        C0299b.m390e("activity was null while trying to create an AdLoader.");
    }

    protected synchronized void m175a(String str) {
        this.f212l.add(str);
    }

    protected void m168a() {
        C0299b.m380a("AdLoader cancelled.");
        if (this.f210j != null) {
            this.f210j.stopLoading();
            this.f210j.destroy();
        }
        if (this.f220t != null) {
            this.f220t.interrupt();
            this.f220t = null;
        }
        if (this.f207g != null) {
            this.f207g.m259a();
        }
        this.f215o = true;
    }

    protected void m172a(AdRequest adRequest) {
        this.f209i = adRequest;
        this.f215o = false;
        this.f220t = new Thread(this);
        this.f220t.start();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r11 = this;
        r9 = 0;
        monitor-enter(r11);
        r0 = r11.f210j;	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x000b;
    L_0x0007:
        r0 = r11.f207g;	 Catch:{ Throwable -> 0x00de }
        if (r0 != 0) goto L_0x0018;
    L_0x000b:
        r0 = "adRequestWebView was null while trying to load an ad.";
        com.google.ads.util.C0299b.m390e(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
    L_0x0017:
        return;
    L_0x0018:
        r0 = r11.f208h;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.m219h();	 Catch:{ Throwable -> 0x00de }
        r0 = r0.f318e;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.m414a();	 Catch:{ Throwable -> 0x00de }
        r0 = (android.app.Activity) r0;	 Catch:{ Throwable -> 0x00de }
        if (r0 != 0) goto L_0x0038;
    L_0x0028:
        r0 = "activity was null while forming an ad request.";
        com.google.ads.util.C0299b.m390e(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0038:
        r1 = r11.f208h;	 Catch:{ Throwable -> 0x00de }
        r3 = r1.m226o();	 Catch:{ Throwable -> 0x00de }
        r5 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x00de }
        r2 = r11.f209i;	 Catch:{ Throwable -> 0x00de }
        r1 = r11.f208h;	 Catch:{ Throwable -> 0x00de }
        r1 = r1.m219h();	 Catch:{ Throwable -> 0x00de }
        r1 = r1.f319f;	 Catch:{ Throwable -> 0x00de }
        r1 = r1.m411a();	 Catch:{ Throwable -> 0x00de }
        r1 = (android.content.Context) r1;	 Catch:{ Throwable -> 0x00de }
        r7 = r2.getRequestMap(r1);	 Catch:{ Throwable -> 0x00de }
        r1 = "extras";
        r1 = r7.get(r1);	 Catch:{ Throwable -> 0x00de }
        r2 = r1 instanceof java.util.Map;	 Catch:{ Throwable -> 0x00de }
        if (r2 == 0) goto L_0x00aa;
    L_0x0060:
        r1 = (java.util.Map) r1;	 Catch:{ Throwable -> 0x00de }
        r2 = "_adUrl";
        r2 = r1.get(r2);	 Catch:{ Throwable -> 0x00de }
        r8 = r2 instanceof java.lang.String;	 Catch:{ Throwable -> 0x00de }
        if (r8 == 0) goto L_0x0070;
    L_0x006c:
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x00de }
        r11.f202b = r2;	 Catch:{ Throwable -> 0x00de }
    L_0x0070:
        r2 = "_requestUrl";
        r2 = r1.get(r2);	 Catch:{ Throwable -> 0x00de }
        r8 = r2 instanceof java.lang.String;	 Catch:{ Throwable -> 0x00de }
        if (r8 == 0) goto L_0x007e;
    L_0x007a:
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x00de }
        r11.f211k = r2;	 Catch:{ Throwable -> 0x00de }
    L_0x007e:
        r2 = "_orientation";
        r2 = r1.get(r2);	 Catch:{ Throwable -> 0x00de }
        r8 = r2 instanceof java.lang.String;	 Catch:{ Throwable -> 0x00de }
        if (r8 == 0) goto L_0x0093;
    L_0x0088:
        r8 = "p";
        r8 = r2.equals(r8);	 Catch:{ Throwable -> 0x00de }
        if (r8 == 0) goto L_0x00d2;
    L_0x0090:
        r2 = 1;
        r11.f219s = r2;	 Catch:{ Throwable -> 0x00de }
    L_0x0093:
        r2 = "_norefresh";
        r1 = r1.get(r2);	 Catch:{ Throwable -> 0x00de }
        r2 = r1 instanceof java.lang.String;	 Catch:{ Throwable -> 0x00de }
        if (r2 == 0) goto L_0x00aa;
    L_0x009d:
        r2 = "t";
        r1 = r1.equals(r2);	 Catch:{ Throwable -> 0x00de }
        if (r1 == 0) goto L_0x00aa;
    L_0x00a5:
        r1 = r11.f208h;	 Catch:{ Throwable -> 0x00de }
        r1.m215d();	 Catch:{ Throwable -> 0x00de }
    L_0x00aa:
        r1 = r11.f202b;	 Catch:{ Throwable -> 0x00de }
        if (r1 != 0) goto L_0x0242;
    L_0x00ae:
        r1 = r11.f211k;	 Catch:{ Throwable -> 0x00de }
        if (r1 != 0) goto L_0x015d;
    L_0x00b2:
        r0 = r11.m167a(r7, r0);	 Catch:{ b -> 0x00ed }
        r1 = r11.m162f();	 Catch:{ Throwable -> 0x00de }
        r11.m157b(r0, r1);	 Catch:{ Throwable -> 0x00de }
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x00de }
        r0 = r0 - r5;
        r0 = r3 - r0;
        r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r2 <= 0) goto L_0x00cb;
    L_0x00c8:
        r11.wait(r0);	 Catch:{ InterruptedException -> 0x010d }
    L_0x00cb:
        r0 = r11.f215o;	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x0127;
    L_0x00cf:
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x00d2:
        r8 = "l";
        r2 = r2.equals(r8);	 Catch:{ Throwable -> 0x00de }
        if (r2 == 0) goto L_0x0093;
    L_0x00da:
        r2 = 0;
        r11.f219s = r2;	 Catch:{ Throwable -> 0x00de }
        goto L_0x0093;
    L_0x00de:
        r0 = move-exception;
        r1 = "An unknown error occurred in AdLoader.";
        com.google.ads.util.C0299b.m385b(r1, r0);	 Catch:{ all -> 0x0035 }
        r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR;	 Catch:{ all -> 0x0035 }
        r1 = 1;
        r11.m171a(r0, r1);	 Catch:{ all -> 0x0035 }
    L_0x00ea:
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x00ed:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r1.<init>();	 Catch:{ Throwable -> 0x00de }
        r2 = "Caught internal exception: ";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00de }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00de }
        com.google.ads.util.C0299b.m386c(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x010d:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r1.<init>();	 Catch:{ Throwable -> 0x00de }
        r2 = "AdLoader InterruptedException while getting the URL: ";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00de }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00de }
        com.google.ads.util.C0299b.m380a(r0);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0127:
        r0 = r11.f217q;	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x0134;
    L_0x012b:
        r0 = r11.f217q;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0134:
        r0 = r11.f211k;	 Catch:{ Throwable -> 0x00de }
        if (r0 != 0) goto L_0x015d;
    L_0x0138:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r0.<init>();	 Catch:{ Throwable -> 0x00de }
        r1 = "AdLoader timed out after ";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.append(r3);	 Catch:{ Throwable -> 0x00de }
        r1 = "ms while getting the URL.";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00de }
        com.google.ads.util.C0299b.m386c(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x015d:
        r0 = r11.f208h;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.m224m();	 Catch:{ Throwable -> 0x00de }
        r1 = com.google.ads.internal.C0263c.C02572.f177a;	 Catch:{ Throwable -> 0x00de }
        r2 = r11.f222v;	 Catch:{ Throwable -> 0x00de }
        r2 = r2.ordinal();	 Catch:{ Throwable -> 0x00de }
        r1 = r1[r2];	 Catch:{ Throwable -> 0x00de }
        switch(r1) {
            case 1: goto L_0x019c;
            case 2: goto L_0x01ab;
            case 3: goto L_0x01b4;
            case 4: goto L_0x01c0;
            default: goto L_0x0170;
        };	 Catch:{ Throwable -> 0x00de }
    L_0x0170:
        r0 = r11.f201a;	 Catch:{ Throwable -> 0x00de }
        if (r0 != 0) goto L_0x0226;
    L_0x0174:
        r0 = "Not using loadUrl().";
        com.google.ads.util.C0299b.m380a(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = r11.f207g;	 Catch:{ Throwable -> 0x00de }
        r1 = r11.f221u;	 Catch:{ Throwable -> 0x00de }
        r0.m261a(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = r11.f207g;	 Catch:{ Throwable -> 0x00de }
        r1 = r11.f211k;	 Catch:{ Throwable -> 0x00de }
        r0.m260a(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x00de }
        r0 = r0 - r5;
        r0 = r3 - r0;
        r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r2 <= 0) goto L_0x0195;
    L_0x0192:
        r11.wait(r0);	 Catch:{ InterruptedException -> 0x01d6 }
    L_0x0195:
        r0 = r11.f215o;	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x01f0;
    L_0x0199:
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x019c:
        r0.m286r();	 Catch:{ Throwable -> 0x00de }
        r0.m289u();	 Catch:{ Throwable -> 0x00de }
        r0.m292x();	 Catch:{ Throwable -> 0x00de }
        r0 = "Request scenario: Online server request.";
        com.google.ads.util.C0299b.m386c(r0);	 Catch:{ Throwable -> 0x00de }
        goto L_0x0170;
    L_0x01ab:
        r0.m288t();	 Catch:{ Throwable -> 0x00de }
        r0 = "Request scenario: Online using buffered ads.";
        com.google.ads.util.C0299b.m386c(r0);	 Catch:{ Throwable -> 0x00de }
        goto L_0x0170;
    L_0x01b4:
        r0.m291w();	 Catch:{ Throwable -> 0x00de }
        r0.m285q();	 Catch:{ Throwable -> 0x00de }
        r0 = "Request scenario: Offline using buffered ads.";
        com.google.ads.util.C0299b.m386c(r0);	 Catch:{ Throwable -> 0x00de }
        goto L_0x0170;
    L_0x01c0:
        r0.m285q();	 Catch:{ Throwable -> 0x00de }
        r0 = "Request scenario: Offline with no buffered ads.";
        com.google.ads.util.C0299b.m386c(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = "Network is unavailable.  Aborting ad request.";
        com.google.ads.util.C0299b.m386c(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x01d6:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r1.<init>();	 Catch:{ Throwable -> 0x00de }
        r2 = "AdLoader InterruptedException while getting the ad server's response: ";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00de }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00de }
        com.google.ads.util.C0299b.m380a(r0);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x01f0:
        r0 = r11.f217q;	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x01fd;
    L_0x01f4:
        r0 = r11.f217q;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x01fd:
        r0 = r11.f203c;	 Catch:{ Throwable -> 0x00de }
        if (r0 != 0) goto L_0x0242;
    L_0x0201:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r0.<init>();	 Catch:{ Throwable -> 0x00de }
        r1 = "AdLoader timed out after ";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.append(r3);	 Catch:{ Throwable -> 0x00de }
        r1 = "ms while waiting for the ad server's response.";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00de }
        com.google.ads.util.C0299b.m386c(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0226:
        r0 = r11.f211k;	 Catch:{ Throwable -> 0x00de }
        r11.f202b = r0;	 Catch:{ Throwable -> 0x00de }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r0.<init>();	 Catch:{ Throwable -> 0x00de }
        r1 = "Using loadUrl.  adBaseUrl: ";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r1 = r11.f202b;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00de }
        com.google.ads.util.C0299b.m380a(r0);	 Catch:{ Throwable -> 0x00de }
    L_0x0242:
        r0 = r11.f201a;	 Catch:{ Throwable -> 0x00de }
        if (r0 != 0) goto L_0x02fc;
    L_0x0246:
        r0 = r11.f206f;	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x0256;
    L_0x024a:
        r0 = r11.f208h;	 Catch:{ Throwable -> 0x00de }
        r1 = 1;
        r0.m213b(r1);	 Catch:{ Throwable -> 0x00de }
        r11.m178b();	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0256:
        r0 = r11.f205e;	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x0295;
    L_0x025a:
        r0 = r11.f205e;	 Catch:{ Throwable -> 0x00de }
        r1 = "application/json";
        r0 = r0.startsWith(r1);	 Catch:{ Throwable -> 0x00de }
        if (r0 != 0) goto L_0x026e;
    L_0x0264:
        r0 = r11.f205e;	 Catch:{ Throwable -> 0x00de }
        r1 = "text/javascript";
        r0 = r0.startsWith(r1);	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x0295;
    L_0x026e:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r0.<init>();	 Catch:{ Throwable -> 0x00de }
        r1 = "Expected HTML but received ";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r1 = r11.f205e;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r1 = ".";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00de }
        com.google.ads.util.C0299b.m384b(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0295:
        r0 = r11.f208h;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.m219h();	 Catch:{ Throwable -> 0x00de }
        r0 = r0.f325l;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.m412a();	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x02f0;
    L_0x02a3:
        r0 = r11.f214n;	 Catch:{ Throwable -> 0x00de }
        if (r0 != 0) goto L_0x02b5;
    L_0x02a7:
        r0 = "Multiple supported ad sizes were specified, but the server did not respond with a size.";
        com.google.ads.util.C0299b.m384b(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x02b5:
        r0 = r11.f208h;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.m219h();	 Catch:{ Throwable -> 0x00de }
        r0 = r0.f325l;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.m412a();	 Catch:{ Throwable -> 0x00de }
        r0 = (java.lang.Object[]) r0;	 Catch:{ Throwable -> 0x00de }
        r0 = java.util.Arrays.asList(r0);	 Catch:{ Throwable -> 0x00de }
        r1 = r11.f214n;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.contains(r1);	 Catch:{ Throwable -> 0x00de }
        if (r0 != 0) goto L_0x02fc;
    L_0x02cf:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r0.<init>();	 Catch:{ Throwable -> 0x00de }
        r1 = "The ad server did not respond with a supported AdSize: ";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r1 = r11.f214n;	 Catch:{ Throwable -> 0x00de }
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00de }
        com.google.ads.util.C0299b.m384b(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = com.google.ads.AdRequest.ErrorCode.INTERNAL_ERROR;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x02f0:
        r0 = r11.f214n;	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x02fc;
    L_0x02f4:
        r0 = "adSize was expected to be null in AdLoader.";
        com.google.ads.util.C0299b.m390e(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = 0;
        r11.f214n = r0;	 Catch:{ Throwable -> 0x00de }
    L_0x02fc:
        r0 = r11.f208h;	 Catch:{ Throwable -> 0x00de }
        r1 = 0;
        r0.m213b(r1);	 Catch:{ Throwable -> 0x00de }
        r11.m165i();	 Catch:{ Throwable -> 0x00de }
        r0 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Throwable -> 0x00de }
        r0 = r0 - r5;
        r0 = r3 - r0;
        r2 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r2 <= 0) goto L_0x0313;
    L_0x0310:
        r11.wait(r0);	 Catch:{ InterruptedException -> 0x031c }
    L_0x0313:
        r0 = r11.f218r;	 Catch:{ Throwable -> 0x00de }
        if (r0 == 0) goto L_0x0336;
    L_0x0317:
        r11.m166j();	 Catch:{ Throwable -> 0x00de }
        goto L_0x00ea;
    L_0x031c:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r1.<init>();	 Catch:{ Throwable -> 0x00de }
        r2 = "AdLoader InterruptedException while loading the HTML: ";
        r1 = r1.append(r2);	 Catch:{ Throwable -> 0x00de }
        r0 = r1.append(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00de }
        com.google.ads.util.C0299b.m380a(r0);	 Catch:{ Throwable -> 0x00de }
        monitor-exit(r11);	 Catch:{ all -> 0x0035 }
        goto L_0x0017;
    L_0x0336:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00de }
        r0.<init>();	 Catch:{ Throwable -> 0x00de }
        r1 = "AdLoader timed out after ";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.append(r3);	 Catch:{ Throwable -> 0x00de }
        r1 = "ms while loading the HTML.";
        r0 = r0.append(r1);	 Catch:{ Throwable -> 0x00de }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x00de }
        com.google.ads.util.C0299b.m386c(r0);	 Catch:{ Throwable -> 0x00de }
        r0 = com.google.ads.AdRequest.ErrorCode.NETWORK_ERROR;	 Catch:{ Throwable -> 0x00de }
        r1 = 1;
        r11.m171a(r0, r1);	 Catch:{ Throwable -> 0x00de }
        goto L_0x00ea;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.internal.c.run():void");
    }

    protected void m178b() {
        try {
            if (TextUtils.isEmpty(this.f205e)) {
                C0299b.m384b("Got a mediation response with no content type. Aborting mediation.");
                m171a(ErrorCode.INTERNAL_ERROR, false);
            } else if (this.f205e.startsWith(Json.CONTENT_TYPE)) {
                C0229c a = C0229c.m57a(this.f203c);
                C0263c.m155a(this.f204d, a, this.f208h.m220i());
                this.f208h.m204a(new C02561(this, a));
            } else {
                C0299b.m384b("Got a mediation response with a content type: '" + this.f205e + "'. Expected something starting with 'application/json'. Aborting mediation.");
                m171a(ErrorCode.INTERNAL_ERROR, false);
            }
        } catch (Throwable e) {
            C0299b.m385b("AdLoader can't parse gWhirl server configuration.", e);
            m171a(ErrorCode.INTERNAL_ERROR, false);
        }
    }

    static void m155a(String str, C0229c c0229c, C0230d c0230d) {
        if (str != null && !str.contains("no-store") && !str.contains("no-cache")) {
            Matcher matcher = Pattern.compile("max-age\\s*=\\s*(\\d+)").matcher(str);
            if (matcher.find()) {
                try {
                    c0230d.m69a(c0229c, Integer.parseInt(matcher.group(1)));
                    C0299b.m386c(String.format(Locale.US, "Caching gWhirl configuration for: %d seconds", new Object[]{Integer.valueOf(r0)}));
                    return;
                } catch (Throwable e) {
                    C0299b.m385b("Caught exception trying to parse cache control directive. Overflow?", e);
                    return;
                }
            }
            C0299b.m386c("Unrecognized cacheControlDirective: '" + str + "'. Not caching configuration.");
        }
    }

    public String m167a(Map<String, Object> map, Activity activity) throws C0259b {
        int i = 0;
        Context applicationContext = activity.getApplicationContext();
        C0269g m = this.f208h.m224m();
        long m2 = m.m281m();
        if (m2 > 0) {
            map.put("prl", Long.valueOf(m2));
        }
        m2 = m.m282n();
        if (m2 > 0) {
            map.put("prnl", Long.valueOf(m2));
        }
        String l = m.m280l();
        if (l != null) {
            map.put("ppcl", l);
        }
        l = m.m279k();
        if (l != null) {
            map.put("pcl", l);
        }
        m2 = m.m278j();
        if (m2 > 0) {
            map.put("pcc", Long.valueOf(m2));
        }
        map.put("preqs", Long.valueOf(m.m283o()));
        map.put("oar", Long.valueOf(m.m284p()));
        map.put("bas_on", Long.valueOf(m.m287s()));
        map.put("bas_off", Long.valueOf(m.m290v()));
        if (m.m293y()) {
            map.put("aoi_timeout", "true");
        }
        if (m.m263A()) {
            map.put("aoi_nofill", "true");
        }
        l = m.m266D();
        if (l != null) {
            map.put("pit", l);
        }
        map.put("ptime", Long.valueOf(C0269g.m262E()));
        m.m267a();
        m.m277i();
        if (this.f208h.m219h().m311b()) {
            map.put("format", "interstitial_mb");
        } else {
            AdSize b = ((C0270h) this.f208h.m219h().f324k.m411a()).m298b();
            if (b.isFullWidth()) {
                map.put("smart_w", "full");
            }
            if (b.isAutoHeight()) {
                map.put("smart_h", "auto");
            }
            if (b.isCustomAdSize()) {
                Map hashMap = new HashMap();
                hashMap.put("w", Integer.valueOf(b.getWidth()));
                hashMap.put("h", Integer.valueOf(b.getHeight()));
                map.put("ad_frame", hashMap);
            } else {
                map.put("format", b.toString());
            }
        }
        map.put("slotname", this.f208h.m219h().f317d.m411a());
        map.put("js", "afma-sdk-a-v6.2.1");
        try {
            int i2;
            int i3 = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionCode;
            CharSequence f = AdUtil.m364f(applicationContext);
            if (!TextUtils.isEmpty(f)) {
                map.put("mv", f);
            }
            map.put("msid", applicationContext.getPackageName());
            map.put("app_name", i3 + ".android." + applicationContext.getPackageName());
            map.put("isu", AdUtil.m339a(applicationContext));
            Object d = AdUtil.m361d(applicationContext);
            l = "net";
            if (d == null) {
                d = Constants.NULL_VERSION_ID;
            }
            map.put(l, d);
            String e = AdUtil.m363e(applicationContext);
            if (!(e == null || e.length() == 0)) {
                map.put("cap", e);
            }
            map.put("u_audio", Integer.valueOf(AdUtil.m365g(applicationContext).ordinal()));
            DisplayMetrics a = AdUtil.m338a(activity);
            map.put("u_sd", Float.valueOf(a.density));
            map.put("u_h", Integer.valueOf(AdUtil.m336a(applicationContext, a)));
            map.put("u_w", Integer.valueOf(AdUtil.m352b(applicationContext, a)));
            map.put(Parameter.LANGUAGE, Locale.getDefault().getLanguage());
            if (!(this.f208h.m219h().f322i == null || this.f208h.m219h().f322i.m411a() == null)) {
                AdView adView = (AdView) this.f208h.m219h().f322i.m411a();
                if (adView.getParent() != null) {
                    int[] iArr = new int[2];
                    adView.getLocationOnScreen(iArr);
                    i2 = iArr[0];
                    int i4 = iArr[1];
                    DisplayMetrics displayMetrics = ((Context) this.f208h.m219h().f319f.m411a()).getResources().getDisplayMetrics();
                    int i5 = displayMetrics.widthPixels;
                    int i6 = displayMetrics.heightPixels;
                    if (!adView.isShown() || adView.getWidth() + i2 <= 0 || adView.getHeight() + i4 <= 0 || i2 > i5 || i4 > i6) {
                        i6 = 0;
                    } else {
                        i6 = 1;
                    }
                    Map hashMap2 = new HashMap();
                    hashMap2.put("x", Integer.valueOf(i2));
                    hashMap2.put("y", Integer.valueOf(i4));
                    hashMap2.put("width", Integer.valueOf(adView.getWidth()));
                    hashMap2.put("height", Integer.valueOf(adView.getHeight()));
                    hashMap2.put("visible", Integer.valueOf(i6));
                    map.put("ad_pos", hashMap2);
                }
            }
            StringBuilder stringBuilder = new StringBuilder();
            AdSize[] adSizeArr = (AdSize[]) this.f208h.m219h().f325l.m412a();
            if (adSizeArr != null) {
                i2 = adSizeArr.length;
                while (i < i2) {
                    AdSize adSize = adSizeArr[i];
                    if (stringBuilder.length() != 0) {
                        stringBuilder.append("|");
                    }
                    stringBuilder.append(adSize.getWidth() + "x" + adSize.getHeight());
                    i++;
                }
                map.put("sz", stringBuilder.toString());
            }
            TelephonyManager telephonyManager = (TelephonyManager) applicationContext.getSystemService("phone");
            map.put("carrier", telephonyManager.getNetworkOperator());
            map.put("gnt", Integer.valueOf(telephonyManager.getNetworkType()));
            if (AdUtil.m359c()) {
                map.put("simulator", Integer.valueOf(1));
            }
            map.put("session_id", C0227b.m51a().m54b().toString());
            map.put("seq_num", C0227b.m51a().m55c().toString());
            l = AdUtil.m342a((Map) map);
            e = ((Boolean) ((C0279a) ((C0280l) this.f208h.m219h().f314a.m411a()).f313a.m411a()).f311l.m412a()).booleanValue() ? m163g() + m160d() + "(" + l + ");" + m164h() : m163g() + m161e() + m160d() + "(" + l + ");" + m164h();
            C0299b.m386c("adRequestUrlHtml: " + e);
            return e;
        } catch (NameNotFoundException e2) {
            throw new C0259b(this, "NameNotFoundException");
        }
    }

    private String m160d() {
        if (this.f209i instanceof SearchAdRequest) {
            return "AFMA_buildAdURL";
        }
        return "AFMA_buildAdURL";
    }

    private String m161e() {
        if (this.f209i instanceof SearchAdRequest) {
            return "AFMA_getSdkConstants();";
        }
        return "AFMA_getSdkConstants();";
    }

    private String m162f() {
        if (this.f209i instanceof SearchAdRequest) {
            return "http://www.gstatic.com/safa/";
        }
        return "http://media.admob.com/";
    }

    private String m163g() {
        if (this.f209i instanceof SearchAdRequest) {
            return "<html><head><script src=\"http://www.gstatic.com/safa/sdk-core-v40.js\"></script><script>";
        }
        return "<html><head><script src=\"http://media.admob.com/sdk-core-v40.js\"></script><script>";
    }

    private String m164h() {
        if (this.f209i instanceof SearchAdRequest) {
            return "</script></head><body></body></html>";
        }
        return "</script></head><body></body></html>";
    }

    protected void m171a(ErrorCode errorCode, boolean z) {
        this.f208h.m204a(new C0258a(this.f208h, this.f210j, this.f207g, errorCode, z));
    }

    private void m157b(String str, String str2) {
        this.f208h.m204a(new C0260c(this, this.f210j, str2, str));
    }

    private void m165i() {
        WebView k = this.f208h.m222k();
        this.f208h.m223l().m303c(true);
        this.f208h.m224m().m276h();
        this.f208h.m204a(new C0260c(this, k, this.f202b, this.f203c));
    }

    private void m166j() {
        this.f208h.m204a(new C0262e(this.f208h, this.f210j, this.f212l, this.f219s, this.f216p, this.f213m, this.f214n));
    }

    protected synchronized void m177a(boolean z) {
        this.f206f = z;
    }

    protected synchronized void m179b(String str) {
        this.f205e = str;
    }

    protected synchronized void m176a(String str, String str2) {
        this.f202b = str2;
        this.f203c = str;
        notify();
    }

    protected synchronized void m182c(String str) {
        this.f204d = str;
    }

    public synchronized void m184d(String str) {
        this.f211k = str;
        notify();
    }

    public synchronized void m186e(String str) {
        this.f213m = str;
    }

    public synchronized void m173a(AdSize adSize) {
        this.f214n = adSize;
    }

    public synchronized void m170a(ErrorCode errorCode) {
        this.f217q = errorCode;
        notify();
    }

    protected synchronized void m181c() {
        this.f218r = true;
        notify();
    }

    public synchronized void m180b(boolean z) {
        this.f216p = z;
    }

    public synchronized void m169a(int i) {
        this.f219s = i;
    }

    public synchronized void m183c(boolean z) {
        this.f221u = z;
    }

    public synchronized void m174a(C0261d c0261d) {
        this.f222v = c0261d;
    }

    public synchronized void m185d(boolean z) {
        this.f201a = z;
    }
}
