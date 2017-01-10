package com.google.ads;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.ads.internal.AdWebView;
import com.google.ads.internal.C0255b;
import com.google.ads.internal.C0264d;
import com.google.ads.internal.C0275j;
import com.google.ads.util.AdUtil;
import com.google.ads.util.C0299b;
import java.util.HashSet;
import java.util.Set;

public class AdView extends RelativeLayout implements Ad {
    private C0264d f48a;

    public AdView(Activity activity, AdSize adSize, String adUnitId) {
        super(activity.getApplicationContext());
        try {
            m23a((Context) activity, adSize, null);
            m27b(activity, adSize, null);
            m19a(activity, adSize, adUnitId);
        } catch (C0255b e) {
            m21a((Context) activity, e.m153c("Could not initialize AdView"), adSize, null);
            e.m151a("Could not initialize AdView");
        }
    }

    protected AdView(Activity activity, AdSize[] adSizes, String adUnitId) {
        this(activity, new AdSize(0, 0), adUnitId);
        m22a(adSizes);
    }

    public AdView(Context context, AttributeSet attrs) {
        super(context, attrs);
        m20a(context, attrs);
    }

    public AdView(Context context, AttributeSet attrs, int defStyle) {
        this(context, attrs);
    }

    void m29a(Context context, String str, int i, AdSize adSize, AttributeSet attributeSet) {
        if (adSize == null) {
            adSize = AdSize.BANNER;
        }
        AdSize createAdSize = AdSize.createAdSize(adSize, context.getApplicationContext());
        if (getChildCount() == 0) {
            View textView = attributeSet == null ? new TextView(context) : new TextView(context, attributeSet);
            textView.setGravity(17);
            textView.setText(str);
            textView.setTextColor(i);
            textView.setBackgroundColor(-16777216);
            View linearLayout = attributeSet == null ? new LinearLayout(context) : new LinearLayout(context, attributeSet);
            linearLayout.setGravity(17);
            View linearLayout2 = attributeSet == null ? new LinearLayout(context) : new LinearLayout(context, attributeSet);
            linearLayout2.setGravity(17);
            linearLayout2.setBackgroundColor(i);
            int a = m18a(context, createAdSize.getWidth());
            int a2 = m18a(context, createAdSize.getHeight());
            linearLayout.addView(textView, a - 2, a2 - 2);
            linearLayout2.addView(linearLayout);
            addView(linearLayout2, a, a2);
        }
    }

    private int m18a(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    private boolean m23a(Context context, AdSize adSize, AttributeSet attributeSet) {
        if (AdUtil.m360c(context)) {
            return true;
        }
        m21a(context, "You must have AdActivity declared in AndroidManifest.xml with configChanges.", adSize, attributeSet);
        return false;
    }

    private boolean m27b(Context context, AdSize adSize, AttributeSet attributeSet) {
        if (AdUtil.m357b(context)) {
            return true;
        }
        m21a(context, "You must have INTERNET and ACCESS_NETWORK_STATE permissions in AndroidManifest.xml.", adSize, attributeSet);
        return false;
    }

    public void destroy() {
        this.f48a.m209b();
    }

    private void m21a(Context context, String str, AdSize adSize, AttributeSet attributeSet) {
        C0299b.m384b(str);
        m29a(context, str, -65536, adSize, attributeSet);
    }

    AdSize[] m30a(String str) {
        String[] split = str.split(",");
        AdSize[] adSizeArr = new AdSize[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    AdSize adSize = new AdSize("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException e) {
                    return null;
                }
            }
            adSize = "BANNER".equals(trim) ? AdSize.BANNER : "SMART_BANNER".equals(trim) ? AdSize.SMART_BANNER : "IAB_MRECT".equals(trim) ? AdSize.IAB_MRECT : "IAB_BANNER".equals(trim) ? AdSize.IAB_BANNER : "IAB_LEADERBOARD".equals(trim) ? AdSize.IAB_LEADERBOARD : "IAB_WIDE_SKYSCRAPER".equals(trim) ? AdSize.IAB_WIDE_SKYSCRAPER : null;
            if (adSize == null) {
                return null;
            }
            adSizeArr[i] = adSize;
        }
        return adSizeArr;
    }

    private void m20a(Context context, AttributeSet attributeSet) {
        C0255b c0255b;
        AdSize[] adSizeArr;
        String c;
        AdSize adSize;
        if (attributeSet != null) {
            try {
                String b = m26b("adSize", context, attributeSet, true);
                AdSize[] a = m30a(b);
                if (a != null) {
                    try {
                        if (a.length != 0) {
                            if (!m25a("adUnitId", attributeSet)) {
                                throw new C0255b("Required XML attribute \"adUnitId\" missing", true);
                            } else if (isInEditMode()) {
                                m29a(context, "Ads by Google", -1, a[0], attributeSet);
                                return;
                            } else {
                                String b2 = m26b("adUnitId", context, attributeSet, true);
                                boolean a2 = m24a("loadAdOnCreate", context, attributeSet, false);
                                if (context instanceof Activity) {
                                    Activity activity = (Activity) context;
                                    m23a((Context) activity, a[0], attributeSet);
                                    m27b(activity, a[0], attributeSet);
                                    if (a.length == 1) {
                                        m19a(activity, a[0], b2);
                                    } else {
                                        m19a(activity, new AdSize(0, 0), b2);
                                        m22a(a);
                                    }
                                    if (a2) {
                                        Set c2 = m28c("testDevices", context, attributeSet, false);
                                        if (c2.contains("TEST_EMULATOR")) {
                                            c2.remove("TEST_EMULATOR");
                                            c2.add(AdRequest.TEST_EMULATOR);
                                        }
                                        loadAd(new AdRequest().setTestDevices(c2).setKeywords(m28c("keywords", context, attributeSet, false)));
                                        return;
                                    }
                                    return;
                                }
                                throw new C0255b("AdView was initialized with a Context that wasn't an Activity.", true);
                            }
                        }
                    } catch (C0255b e) {
                        c0255b = e;
                        adSizeArr = a;
                        c = c0255b.m153c("Could not initialize AdView");
                        if (adSizeArr != null) {
                        }
                        m21a(context, c, adSize, attributeSet);
                        c0255b.m151a("Could not initialize AdView");
                        if (!isInEditMode()) {
                            c0255b.m152b("Could not initialize AdView");
                        }
                    }
                }
                throw new C0255b("Attribute \"adSize\" invalid: " + b, true);
            } catch (C0255b e2) {
                C0255b c0255b2 = e2;
                adSizeArr = null;
                c0255b = c0255b2;
                c = c0255b.m153c("Could not initialize AdView");
                adSize = (adSizeArr != null || adSizeArr.length <= 0) ? AdSize.BANNER : adSizeArr[0];
                m21a(context, c, adSize, attributeSet);
                c0255b.m151a("Could not initialize AdView");
                if (!isInEditMode()) {
                    c0255b.m152b("Could not initialize AdView");
                }
            }
        }
    }

    private boolean m24a(String str, Context context, AttributeSet attributeSet, boolean z) throws C0255b {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str);
        boolean attributeBooleanValue = attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/lib/com.google.ads", str, z);
        if (attributeValue != null) {
            String packageName = context.getPackageName();
            if (attributeValue.matches("^@([^:]+)\\:(.*)$")) {
                packageName = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
                attributeValue = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
            }
            if (attributeValue.startsWith("@bool/")) {
                String substring = attributeValue.substring("@bool/".length());
                TypedValue typedValue = new TypedValue();
                try {
                    getResources().getValue(packageName + ":bool/" + substring, typedValue, true);
                    if (typedValue.type == 18) {
                        return typedValue.data != 0;
                    } else {
                        throw new C0255b("Resource " + str + " was not a boolean: " + typedValue, true);
                    }
                } catch (Throwable e) {
                    throw new C0255b("Could not find resource for " + str + ": " + attributeValue, true, e);
                }
            }
        }
        return attributeBooleanValue;
    }

    private String m26b(String str, Context context, AttributeSet attributeSet, boolean z) throws C0255b {
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str);
        if (attributeValue != null) {
            String packageName = context.getPackageName();
            if (attributeValue.matches("^@([^:]+)\\:(.*)$")) {
                packageName = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "$1");
                attributeValue = attributeValue.replaceFirst("^@([^:]+)\\:(.*)$", "@$2");
            }
            if (attributeValue.startsWith("@string/")) {
                String substring = attributeValue.substring("@string/".length());
                TypedValue typedValue = new TypedValue();
                try {
                    getResources().getValue(packageName + ":string/" + substring, typedValue, true);
                    if (typedValue.string != null) {
                        attributeValue = typedValue.string.toString();
                    } else {
                        throw new C0255b("Resource " + str + " was not a string: " + typedValue, true);
                    }
                } catch (Throwable e) {
                    throw new C0255b("Could not find resource for " + str + ": " + attributeValue, true, e);
                }
            }
        }
        if (!z || attributeValue != null) {
            return attributeValue;
        }
        throw new C0255b("Required XML attribute \"" + str + "\" missing", true);
    }

    private Set<String> m28c(String str, Context context, AttributeSet attributeSet, boolean z) throws C0255b {
        String b = m26b(str, context, attributeSet, z);
        Set<String> hashSet = new HashSet();
        if (b != null) {
            for (String trim : b.split(",")) {
                String trim2 = trim2.trim();
                if (trim2.length() != 0) {
                    hashSet.add(trim2);
                }
            }
        }
        return hashSet;
    }

    private boolean m25a(String str, AttributeSet attributeSet) {
        return attributeSet.getAttributeValue("http://schemas.android.com/apk/lib/com.google.ads", str) != null;
    }

    private void m19a(Activity activity, AdSize adSize, String str) throws C0255b {
        View frameLayout = new FrameLayout(activity);
        frameLayout.setFocusable(false);
        this.f48a = new C0264d(this, activity, adSize, str, frameLayout, false);
        setGravity(17);
        try {
            View a = C0275j.m306a(activity, this.f48a);
            if (a != null) {
                a.addView(frameLayout, -2, -2);
                addView(a, -2, -2);
                return;
            }
            addView(frameLayout, -2, -2);
        } catch (Throwable e) {
            C0299b.m381a("Gestures disabled: Not supported on this version of Android.", e);
            addView(frameLayout, -2, -2);
        }
    }

    public boolean isReady() {
        if (this.f48a == null) {
            return false;
        }
        return this.f48a.m229r();
    }

    public boolean isRefreshing() {
        if (this.f48a == null) {
            return false;
        }
        return this.f48a.m230s();
    }

    public void loadAd(AdRequest adRequest) {
        if (this.f48a != null) {
            if (isRefreshing()) {
                this.f48a.m216e();
            }
            this.f48a.m201a(adRequest);
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f48a.m219h().f326m.m413a(adListener);
    }

    protected void setAppEventListener(AppEventListener appEventListener) {
        this.f48a.m219h().f327n.m413a(appEventListener);
    }

    protected void setSupportedAdSizes(AdSize... adSizes) {
        if (this.f48a.m219h().f325l.m412a() == null) {
            C0299b.m384b("Error: Tried to set supported ad sizes on a single-size AdView.");
        } else {
            m22a(adSizes);
        }
    }

    private void m22a(AdSize... adSizeArr) {
        Object obj = new AdSize[adSizeArr.length];
        for (int i = 0; i < adSizeArr.length; i++) {
            obj[i] = AdSize.createAdSize(adSizeArr[i], getContext());
        }
        this.f48a.m219h().f325l.m413a(obj);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        AdWebView k = this.f48a.m222k();
        if (k != null) {
            k.setVisibility(0);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void stopLoading() {
        if (this.f48a != null) {
            this.f48a.m191A();
        }
    }
}
