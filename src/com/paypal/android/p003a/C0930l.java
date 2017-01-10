package com.paypal.android.p003a;

import java.math.BigDecimal;

/* renamed from: com.paypal.android.a.l */
public final class C0930l {
    static {
    }

    public static String m696a(String str, String str2) {
        BigDecimal bigDecimal;
        try {
            bigDecimal = new BigDecimal(str);
        } catch (NumberFormatException e) {
            bigDecimal = new BigDecimal("0.0");
        }
        return C0925h.m682a(bigDecimal, str2);
    }

    public static String m697a(BigDecimal bigDecimal, String str) {
        return C0925h.m682a(bigDecimal, str);
    }
}
