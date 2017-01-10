package com.paypal.android.MEP.p002b;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.p000a.C0875a;
import com.paypal.android.MEP.p000a.C0875a.C0871a;
import com.paypal.android.MEP.p000a.C0882d.C08791;
import com.paypal.android.p003a.C0919b;

/* renamed from: com.paypal.android.MEP.b.d */
class C0900d implements OnClickListener {
    private /* synthetic */ C0897a f715a;

    C0900d(C0897a c0897a) {
        this.f715a = c0897a;
    }

    public final void onClick(View view) {
        int id = view.getId();
        if (this.f715a.f697f != null || (id & 2113929216) == 2113929216) {
            if ((id & 2130706432) == 2130706432) {
                int i = id - 2130706432;
                if (this.f715a.f697f != null) {
                    (PayPal.getInstance().getServer() == 2 ? C0875a.f590a : C0919b.m619e().m660g()).put("FundingPlanId", this.f715a.f706p.get(i));
                    PayPalActivity.getInstance().sendBroadcast(new Intent(PayPalActivity.CREATE_PAYMENT_SUCCESS));
                }
            } else if ((id & 2113929216) == 2113929216) {
                C0919b.m619e().m656a("FeeBearer", id - 2113929216 == 0 ? "ApplyFeeToSender" : "ApplyFeeToReceiver");
            } else {
                (PayPal.getInstance().getServer() == 2 ? C0875a.f590a : C0919b.m619e().m660g()).put("ShippingAddressId", (String) this.f715a.f705o.get(id - 2097152000));
                if ((PayPal.getInstance().getServer() != 2 ? C0919b.m619e().m663k() : 0) == 0) {
                    PayPalActivity.getInstance().sendBroadcast(new Intent(PayPalActivity.CREATE_PAYMENT_SUCCESS));
                } else {
                    this.f715a.f704n.m448a(C0871a.STATE_UPDATING);
                }
            }
            this.f715a.f696e = true;
            this.f715a.m536a(0);
            if (PayPal.getInstance().getServer() == 2) {
                this.f715a.m537a(6, null);
            }
            C08791.m465b();
        }
    }
}
