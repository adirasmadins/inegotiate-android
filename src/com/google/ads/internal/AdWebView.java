package com.google.ads.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.MeasureSpec;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.ads.AdActivity;
import com.google.ads.AdSize;
import com.google.ads.C0281m;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0299b;
import com.google.ads.util.C0315g;
import com.google.ads.util.C0315g.C0313a;
import com.google.ads.util.C0317h.C0316a;
import com.google.common.primitives.Ints;
import java.lang.ref.WeakReference;

public class AdWebView extends WebView {
    private WeakReference<AdActivity> f165a;
    private AdSize f166b;
    private boolean f167c;
    private boolean f168d;
    private boolean f169e;

    /* renamed from: com.google.ads.internal.AdWebView.1 */
    class C02491 implements DownloadListener {
        final /* synthetic */ AdWebView f164a;

        C02491(AdWebView adWebView) {
            this.f164a = adWebView;
        }

        public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimeType, long size) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.parse(url), mimeType);
                Context d = this.f164a.m134d();
                if (d != null && AdUtil.m348a(intent, d)) {
                    d.startActivity(intent);
                }
            } catch (ActivityNotFoundException e) {
                C0299b.m380a("Couldn't find an Activity to view url/mimetype: " + url + " / " + mimeType);
            } catch (Throwable th) {
                C0299b.m385b("Unknown error trying to start activity to view URL: " + url, th);
            }
        }
    }

    public AdWebView(C0281m slotState, AdSize adSize) {
        super((Context) slotState.f319f.m411a());
        this.f166b = adSize;
        this.f165a = null;
        this.f167c = false;
        this.f168d = false;
        this.f169e = false;
        setBackgroundColor(0);
        AdUtil.m344a((WebView) this);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        setDownloadListener(new C02491(this));
        if (AdUtil.f371a >= 11) {
            C0315g.m409a(settings, slotState);
        }
        setScrollBarStyle(33554432);
        if (AdUtil.f371a >= 14) {
            setWebChromeClient(new C0316a(slotState));
        } else if (AdUtil.f371a >= 11) {
            setWebChromeClient(new C0313a(slotState));
        }
    }

    public void m131a() {
        AdActivity d = m134d();
        if (d != null) {
            d.finish();
        }
    }

    public void m132b() {
        if (AdUtil.f371a >= 11) {
            C0315g.m407a((View) this);
        }
        this.f168d = true;
    }

    public void m133c() {
        if (this.f168d && AdUtil.f371a >= 11) {
            C0315g.m410b(this);
        }
        this.f168d = false;
    }

    public AdActivity m134d() {
        return this.f165a != null ? (AdActivity) this.f165a.get() : null;
    }

    public boolean m135e() {
        return this.f169e;
    }

    public boolean m136f() {
        return this.f168d;
    }

    public void setAdActivity(AdActivity adActivity) {
        this.f165a = new WeakReference(adActivity);
    }

    public void loadDataWithBaseURL(String baseUrl, String data, String mimeType, String encoding, String historyUrl) {
        try {
            super.loadDataWithBaseURL(baseUrl, data, mimeType, encoding, historyUrl);
        } catch (Throwable th) {
            C0299b.m385b("An error occurred while loading data in AdWebView:", th);
        }
    }

    public void loadUrl(String url) {
        try {
            super.loadUrl(url);
        } catch (Throwable th) {
            C0299b.m385b("An error occurred while loading a URL in AdWebView:", th);
        }
    }

    public void stopLoading() {
        try {
            super.stopLoading();
        } catch (Throwable th) {
            C0299b.m389d("An error occurred while stopping loading in AdWebView:", th);
        }
    }

    public void destroy() {
        try {
            super.destroy();
            setWebViewClient(new WebViewClient());
        } catch (Throwable th) {
            C0299b.m385b("An error occurred while destroying an AdWebView:", th);
        }
    }

    public synchronized void setAdSize(AdSize adSize) {
        this.f166b = adSize;
        requestLayout();
    }

    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = Integer.MAX_VALUE;
        synchronized (this) {
            if (isInEditMode()) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else if (this.f166b == null || this.f167c) {
                super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            } else {
                int mode = MeasureSpec.getMode(widthMeasureSpec);
                int size = MeasureSpec.getSize(widthMeasureSpec);
                int mode2 = MeasureSpec.getMode(heightMeasureSpec);
                int size2 = MeasureSpec.getSize(heightMeasureSpec);
                float f = getContext().getResources().getDisplayMetrics().density;
                int width = (int) (((float) this.f166b.getWidth()) * f);
                int height = (int) (((float) this.f166b.getHeight()) * f);
                if (mode == Integer.MIN_VALUE || mode == Ints.MAX_POWER_OF_TWO) {
                    mode = size;
                } else {
                    mode = Integer.MAX_VALUE;
                }
                if (mode2 == Integer.MIN_VALUE || mode2 == Ints.MAX_POWER_OF_TWO) {
                    i = size2;
                }
                if (((float) width) - (f * 6.0f) > ((float) mode) || height > r0) {
                    C0299b.m390e("Not enough space to show ad! Wants: <" + width + ", " + height + ">, Has: <" + size + ", " + size2 + ">");
                    setVisibility(8);
                    setMeasuredDimension(size, size2);
                } else {
                    setMeasuredDimension(width, height);
                }
            }
        }
    }

    public void setCustomClose(boolean useCustomClose) {
        this.f169e = useCustomClose;
        if (this.f165a != null) {
            AdActivity adActivity = (AdActivity) this.f165a.get();
            if (adActivity != null) {
                adActivity.setCustomClose(useCustomClose);
            }
        }
    }

    public void setIsExpandedMraid(boolean isCurrentlyExpandedMraid) {
        this.f167c = isCurrentlyExpandedMraid;
    }
}
