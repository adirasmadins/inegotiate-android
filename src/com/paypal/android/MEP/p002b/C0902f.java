package com.paypal.android.MEP.p002b;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout.LayoutParams;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalAdvancedPayment;
import com.paypal.android.MEP.PayPalReceiverDetails;
import com.paypal.android.p003a.C0921d;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;

/* renamed from: com.paypal.android.MEP.b.f */
public final class C0902f extends Dialog implements OnClickListener {
    private Button f728a;
    private Button f729b;

    public C0902f(Context context) {
        CharSequence merchantName;
        super(context);
        setCancelable(false);
        setCanceledOnTouchOutside(false);
        requestWindowFeature(1);
        View a = C0921d.m667a(context, -1, -1);
        a.setOrientation(1);
        a.setGravity(1);
        a.setPadding(10, 5, 10, 5);
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-1510918, -4336918});
        gradientDrawable.setCornerRadius(3.0f);
        gradientDrawable.setStroke(0, 0);
        a.setBackgroundDrawable(gradientDrawable);
        View a2 = C0934o.m736a(C0933a.HELVETICA_16_BOLD, context);
        a2.setText(C0925h.m680a("ANDROID_cancel_transaction"));
        a2.setGravity(17);
        a2.setPadding(0, 0, 0, 10);
        a.addView(a2);
        String a3 = C0925h.m680a("ANDROID_go_back_to_merchant");
        PayPal instance = PayPal.getInstance();
        PayPalAdvancedPayment payment = instance.getPayment();
        if (instance.getPayType() == 3) {
            merchantName = instance.getPreapproval().getMerchantName();
        } else if (instance.getPayType() == 0) {
            if (instance.isPersonalPayment()) {
                merchantName = ((PayPalReceiverDetails) payment.getReceivers().get(0)).getRecipient();
            } else {
                merchantName = ((PayPalReceiverDetails) payment.getReceivers().get(0)).getMerchantName();
                if (merchantName == null || merchantName.length() <= 0) {
                    merchantName = ((PayPalReceiverDetails) payment.getReceivers().get(0)).getRecipient();
                }
            }
        } else if (instance.getPayType() == 2) {
            merchantName = payment.getPrimaryReceiver().getMerchantName();
            if (merchantName == null || merchantName.length() <= 0) {
                merchantName = payment.getPrimaryReceiver().getRecipient();
            }
        } else {
            merchantName = C0925h.m680a("ANDROID_the_merchant");
        }
        merchantName = a3.replace("%m", merchantName);
        View a4 = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, context);
        a4.setText(merchantName);
        a4.setGravity(17);
        a.addView(a4);
        a2 = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, context);
        a2.setText(C0925h.m680a("ANDROID_lose_all_information"));
        a2.setGravity(17);
        a.addView(a2);
        a2 = C0921d.m667a(context, -1, -2);
        a2.setOrientation(0);
        a2.setGravity(16);
        a2.setPadding(0, 10, 0, 10);
        a4 = C0921d.m668a(context, -1, -2, 0.5f);
        a4.setOrientation(1);
        a4.setGravity(1);
        a4.setPadding(0, 0, 3, 0);
        this.f728a = new Button(context);
        this.f728a.setText(C0925h.m680a("ANDROID_ok"));
        this.f728a.setTextColor(-16777216);
        this.f728a.setLayoutParams(new LayoutParams(-1, C0921d.m669b()));
        this.f728a.setGravity(17);
        this.f728a.setBackgroundDrawable(C0922e.m671a());
        this.f728a.setOnClickListener(this);
        a4.addView(this.f728a);
        a2.addView(a4);
        a4 = C0921d.m668a(context, -1, -2, 0.5f);
        a4.setOrientation(1);
        a4.setGravity(1);
        a4.setPadding(3, 0, 0, 0);
        this.f729b = new Button(context);
        this.f729b.setText(C0925h.m680a("ANDROID_cancel"));
        this.f729b.setTextColor(-16777216);
        this.f729b.setLayoutParams(new LayoutParams(-1, C0921d.m669b()));
        this.f729b.setGravity(17);
        this.f729b.setBackgroundDrawable(C0922e.m673b());
        this.f729b.setOnClickListener(this);
        a4.addView(this.f729b);
        a2.addView(a4);
        a.addView(a2);
        setContentView(a);
    }

    public final void onClick(View view) {
        if (view == this.f728a) {
            dismiss();
            PayPalActivity.getInstance().paymentCanceled();
        } else if (view == this.f729b) {
            dismiss();
        }
    }
}
