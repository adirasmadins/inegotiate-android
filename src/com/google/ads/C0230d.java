package com.google.ads;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;

/* renamed from: com.google.ads.d */
public class C0230d {
    private C0229c f88a;
    private long f89b;

    public C0230d() {
        this.f88a = null;
        this.f89b = -1;
    }

    public boolean m70a() {
        return this.f88a != null && SystemClock.elapsedRealtime() < this.f89b;
    }

    public void m69a(C0229c c0229c, int i) {
        this.f88a = c0229c;
        this.f89b = TimeUnit.MILLISECONDS.convert((long) i, TimeUnit.SECONDS) + SystemClock.elapsedRealtime();
    }

    public C0229c m71b() {
        return this.f88a;
    }
}
