package com.paypal.android.p003a;

import com.paypal.android.MEP.PayPal;
import com.paypal.android.p005c.C0926a;
import junit.framework.Assert;

/* renamed from: com.paypal.android.a.i */
class C0927i implements C0926a {
    C0927i() {
    }

    public final void m692a(int i, Object obj) {
        Assert.assertTrue(i == 8);
        PayPal.getInstance().setLibraryInitialized(true);
        PayPal.getInstance().onInitializeCompletedOK(i, obj);
    }

    public final void m693b(int i, Object obj) {
        Assert.assertTrue(i == 8);
        PayPal.getInstance().setLibraryInitialized(false);
        PayPal.getInstance().onInitializeCompletedError(i, obj);
    }
}
