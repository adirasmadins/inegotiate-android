package com.paypal.android.p003a;

import android.content.Intent;
import android.util.Log;
import com.paypal.android.MEP.C0890a.C0869b;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import junit.framework.Assert;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

/* renamed from: com.paypal.android.a.k */
class C0929k extends Thread {
    private /* synthetic */ C0919b f816a;

    C0929k(C0919b c0919b) {
        this.f816a = c0919b;
    }

    public final void run() {
        Exception e;
        boolean d;
        while (!this.f816a.f807i) {
            C0869b c0869b = (C0869b) this.f816a.f806h.get("delegate");
            Object h;
            switch (this.f816a.f805g) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                    boolean a;
                    PayPal.logd("MPL", "start LOGIN");
                    C0919b.m619e().m655a("mpl-review");
                    this.f816a.f805g = -1;
                    try {
                        a = C0919b.m607a(this.f816a, (String) this.f816a.f806h.get("usernameOrPhone"), (String) this.f816a.f806h.get("passwordOrPin"));
                    } catch (Exception e2) {
                        PayPal.loge("Login", "Error during call to log in. " + e2.getMessage());
                        a = false;
                    }
                    if (!a) {
                        this.f816a.f803e = -1;
                    }
                    if (!a) {
                        C0919b.m603a(this.f816a, "LOGIN", c0869b);
                        break;
                    }
                    c0869b.m435a(0, null);
                    PayPal.logd("MPL", "end LOGIN ok");
                    break;
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                    PayPal.logd("MPL", "start CREATE_PAYMENT");
                    this.f816a.f805g = -1;
                    C0919b.m619e().m656a("FundingPlanId", (Object) "0");
                    C0919b.m619e().m656a("FundingPlans", null);
                    C0919b.m619e().m656a("DefaultFundingPlan", null);
                    Object f = this.f816a.m651y();
                    if (f == null) {
                        this.f816a.f803e = -1;
                        C0919b.m603a(this.f816a, "CREATE_PAYMENT", c0869b);
                        break;
                    }
                    if (((String) f.get("ActionType")).equals("PAY")) {
                        c0869b.m435a(4, (Object) "-1");
                    } else {
                        c0869b.m435a(3, f);
                    }
                    PayPal.logd("MPL", "end CREATE_PAYMENT ok");
                    break;
                case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                    PayPal.logd("MPL", "start SEND_PAYMENT");
                    this.f816a.f805g = -1;
                    if (!this.f816a.m645s()) {
                        c0869b.m437d(this.f816a.m659f());
                        PayPalActivity.getInstance().sendBroadcast(new Intent("CHANGE_STRING"));
                        break;
                    }
                    h = C0919b.m626h(this.f816a);
                    if (h == null || h.length() <= 0) {
                        this.f816a.f803e = -1;
                    } else {
                        this.f816a.m655a("mpl-success");
                    }
                    if (h == null || h.length() <= 0) {
                        C0919b.m603a(this.f816a, "SEND_PAYMENT", c0869b);
                    } else {
                        c0869b.m435a(4, h);
                        PayPal.logd("MPL", "end SEND_PAYMENT ok");
                    }
                    PayPalActivity.getInstance().sendBroadcast(new Intent("CHANGE_STRING"));
                    break;
                    break;
                case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                    PayPal.logd("MPL", "start FUNDING");
                    this.f816a.f805g = -1;
                    h = this.f816a.m652z();
                    if (h == null) {
                        this.f816a.f803e = -1;
                        C0919b.m603a(this.f816a, "FUNDING", c0869b);
                        break;
                    }
                    c0869b.m435a(5, h);
                    PayPal.logd("MPL", "end FUNDING ok");
                    break;
                case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                    Assert.assertTrue("UPDATE_PAYMENT is supposed to be dead code", false);
                    break;
                case SimpleLog.LOG_LEVEL_OFF /*7*/:
                    this.f816a.f805g = -1;
                    if (!this.f816a.m646t()) {
                        this.f816a.f803e = -1;
                        C0919b.m603a(this.f816a, "GET_SHIPPING_ADDRESSES", c0869b);
                        break;
                    }
                    c0869b.m435a(7, this.f816a.f806h);
                    break;
                case PayPalActivity.VIEW_TEST /*8*/:
                    PayPal.logd("MPL", "start CHECK_AUTH");
                    this.f816a.f805g = -1;
                    if (this.f816a.m597B()) {
                        C0919b.f792a.m690a(8, this.f816a.f806h);
                        PayPal.logd("MPL", "end CHECK_AUTH ok");
                    } else {
                        C0919b.m602a(this.f816a, 8, C0919b.f792a);
                    }
                    this.f816a.f803e = -1;
                    break;
                case PayPalActivity.VIEW_NUM_VIEWS /*9*/:
                    Assert.assertTrue("QUICK_PAY is supposed to be dead code", false);
                    break;
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                    this.f816a.f805g = -1;
                    PayPal.logd("MPL", "start QUICK_LOGIN");
                    try {
                        d = this.f816a.m597B();
                        try {
                            d = C0919b.m621e(this.f816a);
                        } catch (Exception e3) {
                            e2 = e3;
                            Log.e("Login", "Error during call to log in. " + e2.getMessage());
                            if (!d) {
                                this.f816a.f803e = -1;
                            }
                            if (d) {
                                c0869b.m435a(10, null);
                                PayPal.logd("MPL", "end QUICK_LOGIN ok");
                            } else {
                                C0919b.m603a(this.f816a, "QUICK_LOGIN", c0869b);
                            }
                            Thread.sleep(100);
                        }
                    } catch (Exception e4) {
                        e2 = e4;
                        d = false;
                        Log.e("Login", "Error during call to log in. " + e2.getMessage());
                        if (d) {
                            this.f816a.f803e = -1;
                        }
                        if (d) {
                            C0919b.m603a(this.f816a, "QUICK_LOGIN", c0869b);
                        } else {
                            c0869b.m435a(10, null);
                            PayPal.logd("MPL", "end QUICK_LOGIN ok");
                        }
                        Thread.sleep(100);
                    }
                    if (d) {
                        this.f816a.f803e = -1;
                    }
                    if (d) {
                        c0869b.m435a(10, null);
                        PayPal.logd("MPL", "end QUICK_LOGIN ok");
                    } else {
                        C0919b.m603a(this.f816a, "QUICK_LOGIN", c0869b);
                    }
                case PayPal.PAYMENT_SUBTYPE_REMITTANCES /*11*/:
                    PayPal.logd("MPL", "start CREATE_PIN");
                    this.f816a.f805g = -1;
                    if (!this.f816a.m598C()) {
                        this.f816a.f803e = -1;
                        C0919b.m603a(this.f816a, "CREATE_PIN", c0869b);
                        break;
                    }
                    c0869b.m435a(11, this.f816a.f806h);
                    PayPal.logd("MPL", "end CREATE_PIN ok");
                    break;
                case PayPal.PAYMENT_SUBTYPE_RENT /*12*/:
                    PayPal.logd("MPL", "start REMOVE_AUTH");
                    this.f816a.f805g = -1;
                    if (this.f816a.m599D()) {
                        C0919b.f793b.m690a(12, this.f816a.f806h);
                        PayPal.logd("MPL", "end REMOVE_AUTH ok");
                    } else {
                        C0919b.m602a(this.f816a, 12, C0919b.f793b);
                    }
                    this.f816a.f803e = -1;
                    break;
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    this.f816a.f805g = -1;
                    if (!this.f816a.m648v()) {
                        this.f816a.f803e = -1;
                        C0919b.m603a(this.f816a, "PREAPPROVAL_DETAILS", c0869b);
                        break;
                    }
                    c0869b.m435a(13, null);
                    break;
                case PayPal.PAYMENT_SUBTYPE_MEDICAL /*14*/:
                    this.f816a.f805g = -1;
                    if (!this.f816a.m649w()) {
                        this.f816a.f803e = -1;
                        C0919b.m603a(this.f816a, "PREAPPROVAL_CONFIRM", c0869b);
                        break;
                    }
                    c0869b.m435a(14, null);
                    break;
                case PayPal.PAYMENT_SUBTYPE_CHILDCARE /*15*/:
                    if (!this.f816a.m647u()) {
                        this.f816a.f803e = -1;
                        C0919b.m603a(this.f816a, "CREATE_PREAPPROVAL", c0869b);
                        break;
                    }
                    c0869b.m435a(15, null);
                    break;
            }
            try {
                Thread.sleep(100);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        PayPal.logd("NetworkHandler", "thread exiting");
    }
}
