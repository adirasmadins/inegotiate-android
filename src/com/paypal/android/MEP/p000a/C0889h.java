package com.paypal.android.MEP.p000a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.p002b.C0898b;
import com.paypal.android.p001b.C0872j;
import com.paypal.android.p001b.C0893g;
import com.paypal.android.p001b.C0893g.C0874a;
import com.paypal.android.p001b.C0940f;
import com.paypal.android.p001b.C0941h;
import com.paypal.android.p003a.C0919b;
import com.paypal.android.p003a.C0921d;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0934o.C0933a;

/* renamed from: com.paypal.android.MEP.a.h */
public final class C0889h extends C0872j implements OnClickListener, C0874a {
    public static String f677a;
    private C0898b f678b;
    private Button f679c;

    static {
        f677a = null;
    }

    public C0889h(Context context) {
        super(context);
    }

    public final void m507a() {
    }

    public final void m508a(Context context) {
        PayPal instance = PayPal.getInstance();
        super.m440a(context);
        View a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setPadding(5, 5, 5, 15);
        this.f678b = new C0898b(context, this);
        this.f678b.m517a((C0874a) this);
        a.addView(this.f678b);
        addView(a);
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.setPadding(5, 5, 5, 5);
        linearLayout.setBackgroundDrawable(C0921d.m665a());
        if (instance.getTextType() == 1) {
            linearLayout.addView(new C0941h(C0925h.m680a("ANDROID_donation_made"), context));
        } else {
            linearLayout.addView(new C0941h(C0925h.m680a("ANDROID_payment_made"), context));
        }
        View c0940f = new C0940f(context, C0933a.HELVETICA_16_NORMAL, C0933a.HELVETICA_16_NORMAL);
        c0940f.setLayoutParams(new LayoutParams(-1, -2));
        String a2 = C0925h.m680a("ANDROID_successfully_paid_amount_to_recipient");
        if (instance.getTextType() == 1) {
            a2 = C0925h.m680a("ANDROID_successfully_donated_amount_to_recipient");
        }
        c0940f.m745a(a2.replace("{1}", instance.getPayment().getTotal().toString()) + ".");
        linearLayout.addView(c0940f);
        a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setGravity(1);
        this.f679c = new Button(context);
        this.f679c.setText(C0925h.m680a("ANDROID_done"));
        this.f679c.setLayoutParams(new LayoutParams(-2, C0921d.m669b()));
        this.f679c.setBackgroundDrawable(C0922e.m671a());
        this.f679c.setTextColor(-16777216);
        this.f679c.setOnClickListener(this);
        a.addView(this.f679c);
        linearLayout.addView(a);
        addView(linearLayout);
    }

    public final void m509a(C0893g c0893g, int i) {
    }

    public final void m510b() {
    }

    public final void onClick(View view) {
        if (view == this.f679c) {
            if (f677a == null || f677a.length() == 0) {
                f677a = "1111111";
            }
            PayPalActivity.getInstance().paymentSucceeded((String) C0919b.m619e().m657c("PayKey"), (String) C0919b.m619e().m657c("PaymentExecStatus"), true);
        }
    }
}
