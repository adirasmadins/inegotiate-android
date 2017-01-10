package com.google.ads;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.gdata.util.common.base.StringUtil;

public class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER;
    public static final int FULL_WIDTH = -1;
    public static final AdSize IAB_BANNER;
    public static final AdSize IAB_LEADERBOARD;
    public static final AdSize IAB_MRECT;
    public static final AdSize IAB_WIDE_SKYSCRAPER;
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    public static final AdSize SMART_BANNER;
    private final int f42a;
    private final int f43b;
    private boolean f44c;
    private boolean f45d;
    private boolean f46e;
    private String f47f;

    static {
        SMART_BANNER = new AdSize(FULL_WIDTH, AUTO_HEIGHT, "mb");
        BANNER = new AdSize(320, PORTRAIT_AD_HEIGHT, "mb");
        IAB_MRECT = new AdSize(300, 250, "as");
        IAB_BANNER = new AdSize(468, 60, "as");
        IAB_LEADERBOARD = new AdSize(728, LARGE_AD_HEIGHT, "as");
        IAB_WIDE_SKYSCRAPER = new AdSize(160, 600, "as");
    }

    public AdSize(int width, int height) {
        this(width, height, null);
        if (m16a()) {
            this.f46e = false;
            this.f47f = "mb";
            return;
        }
        this.f46e = true;
    }

    private AdSize(int width, int height, String type) {
        boolean z;
        boolean z2 = true;
        this.f42a = width;
        this.f43b = height;
        this.f47f = type;
        if (width == FULL_WIDTH) {
            z = true;
        } else {
            z = false;
        }
        this.f44c = z;
        if (height != AUTO_HEIGHT) {
            z2 = false;
        }
        this.f45d = z2;
        this.f46e = false;
    }

    public static AdSize createAdSize(AdSize adSize, Context context) {
        if (context == null || !adSize.m16a()) {
            return adSize.m16a() ? BANNER : adSize;
        } else {
            AdSize adSize2 = new AdSize(adSize.f44c ? m15a(context) : adSize.getWidth(), adSize.f45d ? m17b(context) : adSize.getHeight(), adSize.f47f);
            adSize2.f45d = adSize.f45d;
            adSize2.f44c = adSize.f44c;
            adSize2.f46e = adSize.f46e;
            return adSize2;
        }
    }

    public boolean equals(Object other) {
        if (!(other instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) other;
        if (this.f42a == adSize.f42a && this.f43b == adSize.f43b) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (Integer.valueOf(this.f42a).hashCode() << 16) | (Integer.valueOf(this.f43b).hashCode() & 65535);
    }

    public int getWidth() {
        if (this.f42a >= 0) {
            return this.f42a;
        }
        throw new UnsupportedOperationException("Ad size was not set before getWidth() was called.");
    }

    public int getHeight() {
        if (this.f43b >= 0) {
            return this.f43b;
        }
        throw new UnsupportedOperationException("Ad size was not set before getHeight() was called.");
    }

    private boolean m16a() {
        return this.f42a < 0 || this.f43b < 0;
    }

    public boolean isFullWidth() {
        return this.f44c;
    }

    public boolean isAutoHeight() {
        return this.f45d;
    }

    public boolean isCustomAdSize() {
        return this.f46e;
    }

    public String toString() {
        return getWidth() + "x" + getHeight() + (this.f47f == null ? StringUtil.EMPTY_STRING : "_" + this.f47f);
    }

    public int getWidthInPixels(Context context) {
        return (int) TypedValue.applyDimension(1, (float) this.f42a, context.getResources().getDisplayMetrics());
    }

    public int getHeightInPixels(Context context) {
        return (int) TypedValue.applyDimension(1, (float) this.f43b, context.getResources().getDisplayMetrics());
    }

    public boolean isSizeAppropriate(int width, int height) {
        return ((double) width) <= ((double) this.f42a) * 1.25d && ((double) width) >= ((double) this.f42a) * 0.8d && ((double) height) <= ((double) this.f43b) * 1.25d && ((double) height) >= ((double) this.f43b) * 0.8d;
    }

    public AdSize findBestSize(AdSize... options) {
        AdSize adSize = null;
        double d = 0.0d;
        if (options != null) {
            int length = options.length;
            int i = 0;
            while (i < length) {
                double d2;
                AdSize adSize2;
                AdSize adSize3 = options[i];
                if (isSizeAppropriate(adSize3.f42a, adSize3.f43b)) {
                    d2 = (((double) adSize3.f42a) * ((double) adSize3.f43b)) / (((double) this.f42a) * ((double) this.f43b));
                    if (d2 > 1.0d) {
                        d2 = 1.0d / d2;
                    }
                    if (d2 > d) {
                        adSize2 = adSize3;
                        i++;
                        adSize = adSize2;
                        d = d2;
                    }
                }
                d2 = d;
                adSize2 = adSize;
                i++;
                adSize = adSize2;
                d = d2;
            }
        }
        return adSize;
    }

    private static int m15a(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (int) (((float) displayMetrics.widthPixels) / displayMetrics.density);
    }

    private static int m17b(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return LANDSCAPE_AD_HEIGHT;
        }
        if (i <= 720) {
            return PORTRAIT_AD_HEIGHT;
        }
        return LARGE_AD_HEIGHT;
    }
}
