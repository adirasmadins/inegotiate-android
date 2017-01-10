package com.paypal.android.MEP;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.paypal.android.p001b.C0872j;

/* renamed from: com.paypal.android.MEP.b */
class C0903b extends BroadcastReceiver {
    C0903b(PayPalActivity payPalActivity) {
    }

    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.indexOf(PayPalActivity._pushIntent) != -1) {
            PayPalActivity.f523c.m428a(Integer.parseInt(action.substring(PayPalActivity._pushIntent.length())));
        } else if (action.indexOf(PayPalActivity._popIntent) != -1) {
            PayPalActivity.m429a(PayPalActivity.f523c);
        } else if (action.indexOf(PayPalActivity._replaceIntent) != -1) {
            PayPalActivity.m433b(PayPalActivity.f523c, Integer.parseInt(action.substring(PayPalActivity._replaceIntent.length())));
        } else if (action.indexOf(PayPalActivity._updateIntent) != -1) {
            ((C0872j) PayPalActivity.f523c.f527d.lastElement()).m441b();
        }
    }
}
