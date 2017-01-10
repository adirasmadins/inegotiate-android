package com.google.ads.internal;

import android.content.Context;
import com.google.ads.AdSize;

/* renamed from: com.google.ads.internal.h */
public class C0270h {
    public static final C0270h f274a;
    private AdSize f275b;
    private final boolean f276c;

    static {
        f274a = new C0270h(null, true);
    }

    private C0270h(AdSize adSize, boolean z) {
        this.f275b = adSize;
        this.f276c = z;
    }

    public static C0270h m296a(AdSize adSize, Context context) {
        return new C0270h(AdSize.createAdSize(adSize, context), false);
    }

    public static C0270h m295a(AdSize adSize) {
        return C0270h.m296a(adSize, null);
    }

    public boolean m297a() {
        return this.f276c;
    }

    public AdSize m298b() {
        return this.f275b;
    }

    public void m299b(AdSize adSize) {
        if (!this.f276c) {
            this.f275b = adSize;
        }
    }
}
