package com.google.ads.internal;

import com.google.ads.util.C0299b;

/* renamed from: com.google.ads.internal.b */
public final class C0255b extends Exception {
    public final boolean f174a;

    public C0255b(String str, boolean z) {
        super(str);
        this.f174a = z;
    }

    public C0255b(String str, boolean z, Throwable th) {
        super(str, th);
        this.f174a = z;
    }

    public void m151a(String str) {
        C0299b.m384b(m153c(str));
        C0299b.m381a(null, (Throwable) this);
    }

    public void m152b(String str) {
        Throwable th;
        String c = m153c(str);
        if (!this.f174a) {
            th = null;
        }
        throw new RuntimeException(c, th);
    }

    public String m153c(String str) {
        if (this.f174a) {
            return str + ": " + getMessage();
        }
        return str;
    }
}
