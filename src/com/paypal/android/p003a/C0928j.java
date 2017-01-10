package com.paypal.android.p003a;

import com.paypal.android.MEP.PayPal;
import com.paypal.android.p005c.C0926a;
import junit.framework.Assert;

/* renamed from: com.paypal.android.a.j */
class C0928j implements C0926a {
    C0928j() {
    }

    public final void m694a(int i, Object obj) {
        Assert.assertTrue(i == 12);
        PayPal.getInstance().setLibraryInitialized(false);
    }

    public final void m695b(int i, Object obj) {
        Assert.assertTrue(i == 12);
        PayPal.getInstance().setLibraryInitialized(false);
    }
}
