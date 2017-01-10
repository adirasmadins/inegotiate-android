package com.google.ads;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.amazonaws.services.s3.model.ProgressEvent;
import com.google.ads.C0280l.C0279a;
import com.google.ads.ai.C0225b;
import com.google.ads.internal.AdVideoView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0254a;
import com.google.ads.internal.C0264d;
import com.google.ads.internal.C0265e;
import com.google.ads.internal.C0271i;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0299b;
import com.google.ads.util.C0315g;
import java.util.HashMap;

public class AdActivity extends Activity implements OnClickListener {
    public static final String BASE_URL_PARAM = "baseurl";
    public static final String CUSTOM_CLOSE_PARAM = "custom_close";
    public static final String HTML_PARAM = "html";
    public static final String INTENT_ACTION_PARAM = "i";
    public static final String ORIENTATION_PARAM = "o";
    public static final String TYPE_PARAM = "m";
    public static final String URL_PARAM = "u";
    private static final C0254a f7a;
    private static final Object f8b;
    private static AdActivity f9c;
    private static C0264d f10d;
    private static AdActivity f11e;
    private static AdActivity f12f;
    private static final StaticMethodWrapper f13g;
    private AdWebView f14h;
    private FrameLayout f15i;
    private int f16j;
    private ViewGroup f17k;
    private boolean f18l;
    private long f19m;
    private RelativeLayout f20n;
    private AdActivity f21o;
    private boolean f22p;
    private boolean f23q;
    private boolean f24r;
    private boolean f25s;
    private AdVideoView f26t;

    public static class StaticMethodWrapper {
        public boolean isShowing() {
            boolean z;
            synchronized (AdActivity.f8b) {
                z = AdActivity.f11e != null;
            }
            return z;
        }

        public void launchAdActivity(C0264d adManager, C0265e adOpener) {
            synchronized (AdActivity.f8b) {
                if (AdActivity.f10d == null) {
                    AdActivity.f10d = adManager;
                } else if (AdActivity.f10d != adManager) {
                    C0299b.m384b("Tried to launch a new AdActivity with a different AdManager.");
                    return;
                }
                Activity activity = (Activity) adManager.m219h().f318e.m414a();
                if (activity == null) {
                    C0299b.m390e("activity was null while launching an AdActivity.");
                    return;
                }
                Intent intent = new Intent(activity.getApplicationContext(), AdActivity.class);
                intent.putExtra("com.google.ads.AdOpener", adOpener.m239a());
                try {
                    C0299b.m380a("Launching AdActivity.");
                    activity.startActivity(intent);
                } catch (Throwable e) {
                    C0299b.m385b("Activity not found.", e);
                }
            }
        }
    }

    public AdActivity() {
        this.f17k = null;
        this.f21o = null;
    }

    static {
        f7a = (C0254a) C0254a.f170a.m137b();
        f8b = new Object();
        f9c = null;
        f10d = null;
        f11e = null;
        f12f = null;
        f13g = new StaticMethodWrapper();
    }

    protected View m8a(int i, boolean z) {
        this.f16j = (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
        this.f15i = new FrameLayout(getApplicationContext());
        this.f15i.setMinimumWidth(this.f16j);
        this.f15i.setMinimumHeight(this.f16j);
        this.f15i.setOnClickListener(this);
        setCustomClose(z);
        return this.f15i;
    }

    private void m2a(String str) {
        C0299b.m384b(str);
        finish();
    }

    private void m3a(String str, Throwable th) {
        C0299b.m385b(str, th);
        finish();
    }

    public AdVideoView getAdVideoView() {
        return this.f26t;
    }

    public AdWebView getOpeningAdWebView() {
        if (this.f21o != null) {
            return this.f21o.f14h;
        }
        synchronized (f8b) {
            if (f10d == null) {
                C0299b.m390e("currentAdManager was null while trying to get the opening AdWebView.");
                return null;
            }
            AdWebView k = f10d.m222k();
            if (k != this.f14h) {
                return k;
            }
            return null;
        }
    }

    public static boolean isShowing() {
        return f13g.isShowing();
    }

    public static void launchAdActivity(C0264d adManager, C0265e adOpener) {
        f13g.launchAdActivity(adManager, adOpener);
    }

    protected void m12a(HashMap<String, String> hashMap, C0264d c0264d) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.google.android.apps.plus", "com.google.android.apps.circles.platform.PlusOneActivity"));
        intent.addCategory("android.intent.category.LAUNCHER");
        intent.putExtras(getIntent().getExtras());
        intent.putExtra("com.google.circles.platform.intent.extra.ENTITY", (String) hashMap.get(URL_PARAM));
        intent.putExtra("com.google.circles.platform.intent.extra.ENTITY_TYPE", C0225b.AD.f74c);
        intent.putExtra("com.google.circles.platform.intent.extra.ACTION", (String) hashMap.get("a"));
        m11a(c0264d);
        try {
            C0299b.m380a("Launching Google+ intent from AdActivity.");
            startActivityForResult(intent, 0);
        } catch (Throwable e) {
            m3a(e.getMessage(), e);
        }
    }

    protected void m13b(HashMap<String, String> hashMap, C0264d c0264d) {
        if (hashMap == null) {
            m2a("Could not get the paramMap in launchIntent()");
            return;
        }
        String str = (String) hashMap.get(URL_PARAM);
        if (str == null) {
            m2a("Could not get the URL parameter in launchIntent().");
            return;
        }
        String str2 = (String) hashMap.get(INTENT_ACTION_PARAM);
        String str3 = (String) hashMap.get(TYPE_PARAM);
        Uri parse = Uri.parse(str);
        Intent intent = str2 == null ? new Intent("android.intent.action.VIEW", parse) : new Intent(str2, parse);
        if (str3 != null) {
            intent.setDataAndType(parse, str3);
        }
        m11a(c0264d);
        try {
            C0299b.m380a("Launching an intent from AdActivity: " + intent.getAction() + " - " + parse);
            startActivity(intent);
        } catch (Throwable e) {
            m3a(e.getMessage(), e);
        }
    }

    protected void m11a(C0264d c0264d) {
        this.f14h = null;
        this.f19m = SystemClock.elapsedRealtime();
        this.f22p = true;
        synchronized (f8b) {
            if (f9c == null) {
                f9c = this;
                c0264d.m233v();
            }
        }
    }

    protected AdVideoView m9a(Activity activity) {
        return new AdVideoView(activity, this.f14h);
    }

    public void moveAdVideoView(int x, int y, int width, int height) {
        if (this.f26t != null) {
            this.f26t.setLayoutParams(m0a(x, y, width, height));
            this.f26t.requestLayout();
        }
    }

    public void newAdVideoView(int x, int y, int width, int height) {
        if (this.f26t == null) {
            this.f26t = m9a((Activity) this);
            this.f20n.addView(this.f26t, 0, m0a(x, y, width, height));
            synchronized (f8b) {
                if (f10d == null) {
                    C0299b.m390e("currentAdManager was null while trying to get the opening AdWebView.");
                    return;
                }
                f10d.m223l().m302b(false);
            }
        }
    }

    private LayoutParams m0a(int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = new LayoutParams(i3, i4);
        layoutParams.setMargins(i, i2, 0, 0);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        return layoutParams;
    }

    public void onClick(View v) {
        finish();
    }

    public void onCreate(Bundle savedInstanceState) {
        boolean z = false;
        super.onCreate(savedInstanceState);
        this.f18l = false;
        synchronized (f8b) {
            if (f10d != null) {
                boolean z2;
                boolean z3;
                C0264d c0264d = f10d;
                if (f11e == null) {
                    f11e = this;
                    c0264d.m232u();
                }
                if (this.f21o == null && f12f != null) {
                    this.f21o = f12f;
                }
                f12f = this;
                if ((c0264d.m219h().m310a() && f11e == this) || (c0264d.m219h().m311b() && this.f21o == f11e)) {
                    c0264d.m234w();
                }
                boolean q = c0264d.m228q();
                C0279a c0279a = (C0279a) ((C0280l) c0264d.m219h().f314a.m411a()).f313a.m411a();
                if (AdUtil.f371a >= ((Integer) c0279a.f300a.m412a()).intValue()) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                this.f25s = z2;
                if (AdUtil.f371a >= ((Integer) c0279a.f301b.m412a()).intValue()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                this.f24r = z3;
                this.f20n = null;
                this.f22p = false;
                this.f23q = true;
                this.f26t = null;
                Bundle bundleExtra = getIntent().getBundleExtra("com.google.ads.AdOpener");
                if (bundleExtra == null) {
                    m2a("Could not get the Bundle used to create AdActivity.");
                    return;
                }
                C0265e c0265e = new C0265e(bundleExtra);
                String b = c0265e.m240b();
                HashMap c = c0265e.m241c();
                if (b.equals("plusone")) {
                    m12a(c, c0264d);
                    return;
                } else if (b.equals("intent")) {
                    m13b(c, c0264d);
                    return;
                } else {
                    this.f20n = new RelativeLayout(getApplicationContext());
                    int b2;
                    boolean z4;
                    if (b.equals("webapp")) {
                        this.f14h = new AdWebView(c0264d.m219h(), null);
                        WebViewClient a = C0271i.m300a(c0264d, C0254a.f172c, true, !q);
                        a.m304d(true);
                        if (q) {
                            a.m301a(true);
                        }
                        this.f14h.setWebViewClient(a);
                        b = (String) c.get(URL_PARAM);
                        String str = (String) c.get(BASE_URL_PARAM);
                        String str2 = (String) c.get(HTML_PARAM);
                        if (b != null) {
                            this.f14h.loadUrl(b);
                        } else if (str2 != null) {
                            this.f14h.loadDataWithBaseURL(str, str2, Mimetypes.MIMETYPE_HTML, "utf-8", null);
                        } else {
                            m2a("Could not get the URL or HTML parameter to show a web app.");
                            return;
                        }
                        b = (String) c.get(ORIENTATION_PARAM);
                        if ("p".equals(b)) {
                            b2 = AdUtil.m351b();
                        } else if ("l".equals(b)) {
                            b2 = AdUtil.m335a();
                        } else if (this == f11e) {
                            b2 = c0264d.m225n();
                        } else {
                            b2 = -1;
                        }
                        AdWebView adWebView = this.f14h;
                        if (c == null || !"1".equals(c.get(CUSTOM_CLOSE_PARAM))) {
                            z4 = false;
                        } else {
                            z4 = true;
                        }
                        m10a(adWebView, false, b2, q, z4);
                        return;
                    } else if (b.equals("interstitial") || b.equals("expand")) {
                        this.f14h = c0264d.m222k();
                        b2 = c0264d.m225n();
                        if (b.equals("expand")) {
                            this.f14h.setIsExpandedMraid(true);
                            this.f23q = false;
                            if (c != null && "1".equals(c.get(CUSTOM_CLOSE_PARAM))) {
                                z = true;
                            }
                            if (!this.f24r || this.f25s) {
                                z4 = z;
                            } else {
                                C0299b.m380a("Re-enabling hardware acceleration on expanding MRAID WebView.");
                                this.f14h.m133c();
                                z4 = z;
                            }
                        } else {
                            z4 = this.f14h.m135e();
                        }
                        m10a(this.f14h, true, b2, q, z4);
                        return;
                    } else {
                        m2a("Unknown AdOpener, <action: " + b + ">");
                        return;
                    }
                }
            }
            m2a("Could not get currentAdManager.");
        }
    }

    protected void m10a(AdWebView adWebView, boolean z, int i, boolean z2, boolean z3) {
        requestWindowFeature(1);
        Window window = getWindow();
        window.setFlags(ProgressEvent.PART_STARTED_EVENT_CODE, ProgressEvent.PART_STARTED_EVENT_CODE);
        if (AdUtil.f371a >= 11) {
            if (this.f24r) {
                C0299b.m380a("Enabling hardware acceleration on the AdActivity window.");
                C0315g.m408a(window);
            } else {
                C0299b.m380a("Disabling hardware acceleration on the AdActivity WebView.");
                adWebView.m132b();
            }
        }
        ViewParent parent = adWebView.getParent();
        if (parent != null) {
            if (!z2) {
                m2a("Interstitial created with an AdWebView that has a parent.");
                return;
            } else if (parent instanceof ViewGroup) {
                this.f17k = (ViewGroup) parent;
                this.f17k.removeView(adWebView);
            } else {
                m2a("MRAID banner was not a child of a ViewGroup.");
                return;
            }
        }
        if (adWebView.m134d() != null) {
            m2a("Interstitial created with an AdWebView that is already in use by another AdActivity.");
            return;
        }
        setRequestedOrientation(i);
        adWebView.setAdActivity(this);
        View a = m8a(z2 ? 50 : 32, z3);
        this.f20n.addView(adWebView, -1, -1);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-2, -2);
        if (z2) {
            layoutParams.addRule(10);
            layoutParams.addRule(11);
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        }
        this.f20n.addView(a, layoutParams);
        this.f20n.setKeepScreenOn(true);
        setContentView(this.f20n);
        this.f20n.getRootView().setBackgroundColor(-16777216);
        if (z) {
            f7a.m142a((WebView) adWebView);
        }
    }

    public void onDestroy() {
        if (this.f20n != null) {
            this.f20n.removeAllViews();
        }
        if (isFinishing()) {
            m7d();
            if (this.f23q && this.f14h != null) {
                this.f14h.stopLoading();
                this.f14h.destroy();
                this.f14h = null;
            }
        }
        super.onDestroy();
    }

    public void onPause() {
        if (isFinishing()) {
            m7d();
        }
        super.onPause();
    }

    private void m7d() {
        if (!this.f18l) {
            if (this.f14h != null) {
                f7a.m148b(this.f14h);
                this.f14h.setAdActivity(null);
                this.f14h.setIsExpandedMraid(false);
                if (!(this.f23q || this.f20n == null || this.f17k == null)) {
                    if (this.f24r && !this.f25s) {
                        C0299b.m380a("Disabling hardware acceleration on collapsing MRAID WebView.");
                        this.f14h.m132b();
                    } else if (!this.f24r && this.f25s) {
                        C0299b.m380a("Re-enabling hardware acceleration on collapsing MRAID WebView.");
                        this.f14h.m133c();
                    }
                    this.f20n.removeView(this.f14h);
                    this.f17k.addView(this.f14h);
                }
            }
            if (this.f26t != null) {
                this.f26t.m129e();
                this.f26t = null;
            }
            if (this == f9c) {
                f9c = null;
            }
            f12f = this.f21o;
            synchronized (f8b) {
                if (!(f10d == null || !this.f23q || this.f14h == null)) {
                    if (this.f14h == f10d.m222k()) {
                        f10d.m194a();
                    }
                    this.f14h.stopLoading();
                }
                if (this == f11e) {
                    f11e = null;
                    if (f10d != null) {
                        f10d.m231t();
                        f10d = null;
                    } else {
                        C0299b.m390e("currentAdManager is null while trying to destroy AdActivity.");
                    }
                }
            }
            this.f18l = true;
            C0299b.m380a("AdActivity is closing.");
        }
    }

    public void onWindowFocusChanged(boolean hasFocus) {
        if (this.f22p && hasFocus && SystemClock.elapsedRealtime() - this.f19m > 250) {
            C0299b.m388d("Launcher AdActivity got focus and is closing.");
            finish();
        }
        super.onWindowFocusChanged(hasFocus);
    }

    public void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if (!(getOpeningAdWebView() == null || data == null || data.getExtras() == null || data.getExtras().getString("com.google.circles.platform.result.extra.CONFIRMATION") == null || data.getExtras().getString("com.google.circles.platform.result.extra.ACTION") == null)) {
            String string = data.getExtras().getString("com.google.circles.platform.result.extra.CONFIRMATION");
            String string2 = data.getExtras().getString("com.google.circles.platform.result.extra.ACTION");
            if (string.equals("yes")) {
                if (string2.equals("insert")) {
                    ag.m45a(getOpeningAdWebView(), true);
                } else if (string2.equals("delete")) {
                    ag.m45a(getOpeningAdWebView(), false);
                }
            }
        }
        finish();
    }

    public void setCustomClose(boolean useCustomClose) {
        if (this.f15i != null) {
            this.f15i.removeAllViews();
            if (!useCustomClose) {
                View imageButton = new ImageButton(this);
                imageButton.setImageResource(17301527);
                imageButton.setBackgroundColor(0);
                imageButton.setOnClickListener(this);
                imageButton.setPadding(0, 0, 0, 0);
                this.f15i.addView(imageButton, new FrameLayout.LayoutParams(this.f16j, this.f16j, 17));
            }
        }
    }
}
