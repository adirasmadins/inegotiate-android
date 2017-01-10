package com.paypal.android.p003a;

import com.paypal.android.MEP.PayPal;

/* renamed from: com.paypal.android.a.f */
public final class C0923f extends Exception {
    private static final long serialVersionUID = 1;

    public C0923f(String str) {
        super(str);
        PayPal.loge("BadXMLException", "BadXMLException: " + str);
    }
}
