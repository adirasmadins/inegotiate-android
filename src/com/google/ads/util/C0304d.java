package com.google.ads.util;

import android.os.Build;
import com.google.gdata.data.docs.DocumentListEntry;

/* renamed from: com.google.ads.util.d */
class C0304d {
    static final C0304d f408d;
    static final C0304d f409e;
    public final String f410a;
    public final String f411b;
    public final String f412c;

    static {
        f408d = new C0304d();
        f409e = new C0304d(DocumentListEntry.UNKNOWN_LABEL, "generic", "generic");
    }

    C0304d() {
        this.f410a = Build.BOARD;
        this.f411b = Build.DEVICE;
        this.f412c = Build.BRAND;
    }

    C0304d(String str, String str2, String str3) {
        this.f410a = str;
        this.f411b = str2;
        this.f412c = str3;
    }

    public boolean equals(Object o) {
        if (!(o instanceof C0304d)) {
            return false;
        }
        C0304d c0304d = (C0304d) o;
        if (C0304d.m399a(this.f410a, c0304d.f410a) && C0304d.m399a(this.f411b, c0304d.f411b) && C0304d.m399a(this.f412c, c0304d.f412c)) {
            return true;
        }
        return false;
    }

    private static boolean m399a(String str, String str2) {
        if (str != null) {
            return str.equals(str2);
        }
        return str == str2;
    }

    public int hashCode() {
        int i = 0;
        if (this.f410a != null) {
            i = 0 + this.f410a.hashCode();
        }
        if (this.f411b != null) {
            i += this.f411b.hashCode();
        }
        if (this.f412c != null) {
            return i + this.f412c.hashCode();
        }
        return i;
    }
}
