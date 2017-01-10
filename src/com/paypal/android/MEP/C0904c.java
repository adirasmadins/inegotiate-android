package com.paypal.android.MEP;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.paypal.android.MEP.p000a.C0882d.C08791;
import com.paypal.android.p003a.C0919b;

/* renamed from: com.paypal.android.MEP.c */
class C0904c extends BroadcastReceiver {
    private /* synthetic */ PayPalActivity f730a;

    C0904c(PayPalActivity payPalActivity) {
        this.f730a = payPalActivity;
    }

    public final void onReceive(Context context, Intent intent) {
        PayPalActivity.f524h = null;
        String action = intent.getAction();
        if (action.equals(PayPalActivity.LOGIN_SUCCESS)) {
            if (PayPal.getInstance().getPayType() == 3) {
                C08791.m466b(6);
                return;
            }
            C0919b.m619e().m655a("mpl-review");
            C08791.m466b(3);
        } else if (action.equals(PayPalActivity.LOGIN_FAIL)) {
            C08791.m466b(0);
            if (intent.getStringExtra("ERROR_TIMEOUT") != null) {
                PayPalActivity.f524h = intent.getStringExtra("ERROR_TIMEOUT");
            }
        } else if (action.equals(PayPalActivity.CREATE_PAYMENT_SUCCESS)) {
            if (PayPal.getInstance().getPayType() == 3) {
                C08791.m466b(6);
                return;
            }
            C0919b.m619e().m655a("mpl-review");
            C08791.m466b(3);
        } else if (action.equals(PayPalActivity.FATAL_ERROR)) {
            this.f730a.f529f = intent;
            C08791.m466b(5);
        }
    }
}
