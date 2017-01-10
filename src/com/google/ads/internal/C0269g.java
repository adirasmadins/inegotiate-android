package com.google.ads.internal;

import android.os.SystemClock;
import com.google.ads.C0242g.C0241a;
import com.google.ads.util.C0299b;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.google.ads.internal.g */
public class C0269g {
    private static long f258f;
    private static long f259g;
    private static long f260h;
    private static long f261i;
    private static long f262j;
    private final LinkedList<Long> f263a;
    private long f264b;
    private long f265c;
    private long f266d;
    private final LinkedList<Long> f267e;
    private boolean f268k;
    private boolean f269l;
    private String f270m;
    private long f271n;
    private final LinkedList<Long> f272o;
    private final LinkedList<C0241a> f273p;

    static {
        f258f = 0;
        f259g = 0;
        f260h = 0;
        f261i = 0;
        f262j = -1;
    }

    public C0269g() {
        this.f268k = false;
        this.f269l = false;
        this.f263a = new LinkedList();
        this.f267e = new LinkedList();
        this.f272o = new LinkedList();
        this.f273p = new LinkedList();
        m267a();
    }

    protected synchronized void m267a() {
        this.f263a.clear();
        this.f264b = 0;
        this.f265c = 0;
        this.f266d = 0;
        this.f267e.clear();
        this.f271n = -1;
        this.f272o.clear();
        this.f273p.clear();
        this.f268k = false;
        this.f269l = false;
    }

    public synchronized void m270b() {
        this.f272o.clear();
        this.f273p.clear();
    }

    public synchronized void m271c() {
        this.f271n = SystemClock.elapsedRealtime();
    }

    public synchronized void m268a(C0241a c0241a) {
        this.f272o.add(Long.valueOf(SystemClock.elapsedRealtime() - this.f271n));
        this.f273p.add(c0241a);
    }

    public synchronized String m272d() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        Iterator it = this.f272o.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(longValue);
        }
        return stringBuilder.toString();
    }

    public synchronized String m273e() {
        StringBuilder stringBuilder;
        stringBuilder = new StringBuilder();
        Iterator it = this.f273p.iterator();
        while (it.hasNext()) {
            C0241a c0241a = (C0241a) it.next();
            if (stringBuilder.length() > 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(c0241a.ordinal());
        }
        return stringBuilder.toString();
    }

    protected void m274f() {
        C0299b.m388d("Ad clicked.");
        this.f263a.add(Long.valueOf(SystemClock.elapsedRealtime()));
    }

    protected void m275g() {
        C0299b.m388d("Ad request loaded.");
        this.f264b = SystemClock.elapsedRealtime();
    }

    protected synchronized void m276h() {
        C0299b.m388d("Ad request before rendering.");
        this.f265c = SystemClock.elapsedRealtime();
    }

    protected void m277i() {
        C0299b.m388d("Ad request started.");
        this.f266d = SystemClock.elapsedRealtime();
        f258f++;
    }

    protected long m278j() {
        if (this.f263a.size() != this.f267e.size()) {
            return -1;
        }
        return (long) this.f263a.size();
    }

    protected String m279k() {
        if (this.f263a.isEmpty() || this.f263a.size() != this.f267e.size()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.f263a.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(((Long) this.f267e.get(i)).longValue() - ((Long) this.f263a.get(i)).longValue()));
        }
        return stringBuilder.toString();
    }

    protected String m280l() {
        if (this.f263a.isEmpty()) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.f263a.size(); i++) {
            if (i != 0) {
                stringBuilder.append(",");
            }
            stringBuilder.append(Long.toString(((Long) this.f263a.get(i)).longValue() - this.f264b));
        }
        return stringBuilder.toString();
    }

    protected long m281m() {
        return this.f264b - this.f266d;
    }

    protected synchronized long m282n() {
        return this.f265c - this.f266d;
    }

    protected long m283o() {
        return f258f;
    }

    protected synchronized long m284p() {
        return f259g;
    }

    protected synchronized void m285q() {
        C0299b.m388d("Ad request network error");
        f259g++;
    }

    protected synchronized void m286r() {
        f259g = 0;
    }

    protected synchronized long m287s() {
        return f260h;
    }

    protected synchronized void m288t() {
        f260h++;
    }

    protected synchronized void m289u() {
        f260h = 0;
    }

    protected synchronized long m290v() {
        return f261i;
    }

    protected synchronized void m291w() {
        f261i++;
    }

    protected synchronized void m292x() {
        f261i = 0;
    }

    protected boolean m293y() {
        return this.f268k;
    }

    protected void m294z() {
        C0299b.m388d("Interstitial network error.");
        this.f268k = true;
    }

    protected boolean m263A() {
        return this.f269l;
    }

    protected void m264B() {
        C0299b.m388d("Interstitial no fill.");
        this.f269l = true;
    }

    public void m265C() {
        C0299b.m388d("Landing page dismissed.");
        this.f267e.add(Long.valueOf(SystemClock.elapsedRealtime()));
    }

    protected String m266D() {
        return this.f270m;
    }

    public void m269a(String str) {
        C0299b.m388d("Prior impression ticket = " + str);
        this.f270m = str;
    }

    public static long m262E() {
        if (f262j != -1) {
            return SystemClock.elapsedRealtime() - f262j;
        }
        f262j = SystemClock.elapsedRealtime();
        return 0;
    }
}
