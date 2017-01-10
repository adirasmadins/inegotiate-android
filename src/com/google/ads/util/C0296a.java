package com.google.ads.util;

import android.text.TextUtils;
import android.util.Log;

/* renamed from: com.google.ads.util.a */
public class C0296a {
    private static boolean f380a;

    /* renamed from: com.google.ads.util.a.a */
    public static class C0295a extends Error {
        public C0295a(String str) {
            super(str);
        }
    }

    static {
        f380a = Log.isLoggable("GoogleAdsAssertion", 3);
    }

    public static void m371a(boolean z) {
        C0296a.m376c(z, "Assertion failed.");
    }

    public static void m372a(boolean z, String str) {
        C0296a.m376c(z, str);
    }

    public static void m374b(boolean z) {
        C0296a.m376c(!z, "Assertion failed.");
    }

    public static void m375b(boolean z, String str) {
        C0296a.m376c(!z, str);
    }

    public static void m368a(Object obj) {
        C0296a.m376c(obj == null, "Assertion that an object is null failed.");
    }

    public static void m373b(Object obj) {
        C0296a.m376c(obj != null, "Assertion that an object is not null failed.");
    }

    public static void m369a(Object obj, Object obj2) {
        C0296a.m376c(obj == obj2, "Assertion that 'a' and 'b' refer to the same object failed.a: " + obj + ", b: " + obj2);
    }

    public static void m370a(String str) {
        C0296a.m376c(!TextUtils.isEmpty(str), "Expected a non empty string, got: " + str);
    }

    private static void m376c(boolean z, String str) {
        if ((Log.isLoggable("GoogleAdsAssertion", 3) || f380a) && !z) {
            Throwable c0295a = new C0295a(str);
            Log.d("GoogleAdsAssertion", str, c0295a);
            throw c0295a;
        }
    }
}
