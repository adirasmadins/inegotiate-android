package com.google.ads.util;

import android.util.Log;
import com.google.ads.AdRequest;

/* renamed from: com.google.ads.util.b */
public final class C0299b {
    public static C0298b f388a;
    private static int f389b;

    /* renamed from: com.google.ads.util.b.a */
    public enum C0297a {
        VERBOSE(2),
        DEBUG(3),
        INFO(4),
        WARN(5),
        ERROR(6);
        
        public final int f387f;

        private C0297a(int i) {
            this.f387f = i;
        }
    }

    /* renamed from: com.google.ads.util.b.b */
    public interface C0298b {
        void m377a(C0297a c0297a, String str, Throwable th);
    }

    static {
        f388a = null;
        f389b = 5;
    }

    private static void m378a(C0297a c0297a, String str) {
        C0299b.m379a(c0297a, str, null);
    }

    private static void m379a(C0297a c0297a, String str, Throwable th) {
        if (f388a != null) {
            f388a.m377a(c0297a, str, th);
        }
    }

    public static void m380a(String str) {
        if (C0299b.m383a(AdRequest.LOGTAG, 3)) {
            Log.d(AdRequest.LOGTAG, str);
        }
        C0299b.m378a(C0297a.DEBUG, str);
    }

    public static void m381a(String str, Throwable th) {
        if (C0299b.m383a(AdRequest.LOGTAG, 3)) {
            Log.d(AdRequest.LOGTAG, str, th);
        }
        C0299b.m379a(C0297a.DEBUG, str, th);
    }

    public static void m384b(String str) {
        if (C0299b.m383a(AdRequest.LOGTAG, 6)) {
            Log.e(AdRequest.LOGTAG, str);
        }
        C0299b.m378a(C0297a.ERROR, str);
    }

    public static void m385b(String str, Throwable th) {
        if (C0299b.m383a(AdRequest.LOGTAG, 6)) {
            Log.e(AdRequest.LOGTAG, str, th);
        }
        C0299b.m379a(C0297a.ERROR, str, th);
    }

    public static void m386c(String str) {
        if (C0299b.m383a(AdRequest.LOGTAG, 4)) {
            Log.i(AdRequest.LOGTAG, str);
        }
        C0299b.m378a(C0297a.INFO, str);
    }

    public static void m387c(String str, Throwable th) {
        if (C0299b.m383a(AdRequest.LOGTAG, 4)) {
            Log.i(AdRequest.LOGTAG, str, th);
        }
        C0299b.m379a(C0297a.INFO, str, th);
    }

    public static void m388d(String str) {
        if (C0299b.m383a(AdRequest.LOGTAG, 2)) {
            Log.v(AdRequest.LOGTAG, str);
        }
        C0299b.m378a(C0297a.VERBOSE, str);
    }

    public static void m390e(String str) {
        if (C0299b.m383a(AdRequest.LOGTAG, 5)) {
            Log.w(AdRequest.LOGTAG, str);
        }
        C0299b.m378a(C0297a.WARN, str);
    }

    public static void m389d(String str, Throwable th) {
        if (C0299b.m383a(AdRequest.LOGTAG, 5)) {
            Log.w(AdRequest.LOGTAG, str, th);
        }
        C0299b.m379a(C0297a.WARN, str, th);
    }

    public static boolean m383a(String str, int i) {
        return C0299b.m382a(i) || Log.isLoggable(str, i);
    }

    private static boolean m382a(int i) {
        return i >= f389b;
    }
}
