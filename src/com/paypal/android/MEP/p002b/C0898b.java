package com.paypal.android.MEP.p002b;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout.LayoutParams;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalAdvancedPayment;
import com.paypal.android.MEP.PayPalInvoiceItem;
import com.paypal.android.MEP.PayPalPreapproval;
import com.paypal.android.MEP.PayPalReceiverDetails;
import com.paypal.android.MEP.p000a.C0882d;
import com.paypal.android.MEP.p000a.C0885e;
import com.paypal.android.MEP.p000a.C0889h;
import com.paypal.android.p001b.C0872j;
import com.paypal.android.p001b.C0895c;
import com.paypal.android.p001b.C0940f;
import com.paypal.android.p003a.C0921d;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0930l;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;
import java.math.BigDecimal;
import java.util.ArrayList;
import org.codehaus.jackson.io.CharacterEscapes;

/* renamed from: com.paypal.android.MEP.b.b */
public final class C0898b extends C0895c implements OnTouchListener {
    private C0940f f711e;
    private boolean f712f;
    private GradientDrawable f713g;
    private GradientDrawable f714h;

    public C0898b(Context context, C0872j c0872j) {
        super(context);
        PayPal instance = PayPal.getInstance();
        PayPalAdvancedPayment payment = instance.getPayment();
        PayPalPreapproval preapproval = instance.getPreapproval();
        boolean z = c0872j instanceof C0882d;
        Object obj = ((c0872j instanceof C0889h) || (c0872j instanceof C0885e)) ? 1 : null;
        m516a(new LayoutParams(-1, -2), 0);
        m516a(new LayoutParams(-1, -2), 1);
        this.f713g = C0921d.m666a(-1, -1510918, -7829368);
        this.f714h = C0921d.m666a(-1, 14209956, -7829368);
        setBackgroundDrawable(this.f713g);
        setPadding(5, 5, 5, 0);
        m522a(C0922e.m670a(14218, 463));
        m524b(C0922e.m670a(38432, 430));
        setOnTouchListener(this);
        View a;
        if (instance.getPayType() != 3) {
            int i;
            String description;
            boolean z2 = payment.getTotalShipping().compareTo(BigDecimal.ZERO) > 0 || payment.getTotalTax().compareTo(BigDecimal.ZERO) > 0 || instance.getDynamicAmountCalculationEnabled() || payment.hasPrimaryReceiever() || payment.getReceivers().size() > 1;
            this.f712f = z2;
            if (!(((PayPalReceiverDetails) payment.getReceivers().get(0)).getInvoiceData() == null || ((PayPalReceiverDetails) payment.getReceivers().get(0)).getInvoiceData().getInvoiceItems() == null)) {
                for (i = 0; i < ((PayPalReceiverDetails) payment.getReceivers().get(0)).getInvoiceData().getInvoiceItems().size(); i++) {
                    if (((PayPalInvoiceItem) ((PayPalReceiverDetails) payment.getReceivers().get(0)).getInvoiceData().getInvoiceItems().get(i)).isValid()) {
                        this.f712f = true;
                    }
                }
            }
            this.a.setGravity(16);
            View a2 = obj != null ? C0922e.m672a(context, "system-icon-confirmation.png") : (instance.isPersonalPayment() || instance.getTextType() == 1) ? C0922e.m672a(context, "shopping-list-enabled.png") : C0922e.m672a(context, "shopping-cart-enabled.png");
            this.a.addView(a2);
            this.f711e = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_BOLD, 0.5f, 0.5f);
            if (obj != null) {
                if (instance.isPersonalPayment() || instance.getTextType() == 1) {
                    this.f711e.m745a(C0925h.m680a("ANDROID_total_paid") + ":");
                } else {
                    this.f711e.m745a(C0925h.m680a("ANDROID_receipt") + ":");
                }
            } else if (this.f712f) {
                this.f711e.m745a(C0925h.m680a("ANDROID_my_total") + ":");
            } else {
                description = ((PayPalReceiverDetails) payment.getReceivers().get(0)).getDescription();
                if (description == null || description.length() <= 0) {
                    this.f711e.m745a(C0925h.m680a("ANDROID_my_total") + ":");
                } else {
                    this.f711e.m745a(description + ":");
                }
            }
            this.f711e.m744a(-16777216);
            if (payment.hasPrimaryReceiever()) {
                this.f711e.m747b(C0930l.m697a(payment.getPrimaryReceiver().getTotal(), payment.getCurrencyType()));
            } else {
                this.f711e.m747b(C0930l.m697a(payment.getTotal(), payment.getCurrencyType()));
            }
            this.f711e.m746b(-13408768);
            this.f711e.setPadding(5, 0, 5, 0);
            this.a.addView(this.f711e);
            this.a.addView(this.c);
            this.c.setVisibility(0);
            if (this.f712f) {
                this.b.setOrientation(1);
                a2 = new View(context);
                a2.setLayoutParams(new LayoutParams(-1, 1));
                a2.setBackgroundColor(-7829368);
                this.b.addView(a2);
                if (payment.hasPrimaryReceiever()) {
                    this.b.addView(C0899c.m547a(context, payment.getPrimaryReceiver(), payment.getCurrencyType()));
                } else {
                    ArrayList receivers = payment.getReceivers();
                    if (receivers.size() == 1) {
                        this.b.addView(C0899c.m547a(context, (PayPalReceiverDetails) receivers.get(0), payment.getCurrencyType()));
                    } else {
                        for (i = 0; i < receivers.size(); i++) {
                            this.b.addView(new C0899c(context, (PayPalReceiverDetails) receivers.get(i), payment.getCurrencyType()));
                        }
                    }
                }
                a2 = new View(context);
                a2.setLayoutParams(new LayoutParams(-1, 1));
                a2.setBackgroundColor(-7829368);
                this.b.addView(a2);
                a = C0934o.m736a(C0933a.HELVETICA_14_BOLD, context);
                a.setGravity(5);
                description = payment.hasPrimaryReceiever() ? C0930l.m697a(payment.getPrimaryReceiver().getTotal(), payment.getCurrencyType()) : C0930l.m696a(payment.getTotal().toString(), payment.getCurrencyType());
                if (description.contains(payment.getCurrencyType())) {
                    a.setText(C0925h.m680a("ANDROID_total") + ": " + description);
                } else {
                    a.setText(C0925h.m680a("ANDROID_total") + " (" + payment.getCurrencyType() + "): " + description);
                }
                this.b.addView(a);
                a2 = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                a2.setLayoutParams(new LayoutParams(-1, -2));
                a2.setGravity(5);
                a2.setText(C0925h.m680a("ANDROID_shipping_tax_estimated_note"));
                if (instance.getDynamicAmountCalculationEnabled() && z) {
                    this.b.addView(a2);
                    return;
                }
                return;
            }
            setClickable(false);
            return;
        }
        this.f712f = true;
        this.a.setGravity(16);
        this.a.addView(obj != null ? C0922e.m672a(context, "system-icon-confirmation.png") : C0922e.m672a(context, "shopping-list-enabled.png"));
        this.f711e = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_BOLD, 0.5f, 0.5f);
        if (obj != null) {
            this.f711e.m745a(C0925h.m680a("ANDROID_receipt") + ":");
            this.f711e.m747b(StringUtil.EMPTY_STRING);
        } else {
            this.f711e.m745a(C0925h.m680a("ANDROID_billing_summary"));
            this.f711e.m747b(StringUtil.EMPTY_STRING);
        }
        this.f711e.m744a(-16777216);
        this.f711e.m746b(-13408768);
        this.a.addView(this.f711e);
        this.a.addView(this.c);
        this.c.setVisibility(0);
        PayPalPreapproval preapproval2 = instance.getPreapproval();
        if (!z) {
            this.b.setOrientation(1);
            a = new View(context);
            a.setLayoutParams(new LayoutParams(-1, 1));
            a.setBackgroundColor(-7829368);
            this.b.addView(a);
            a = new C0940f(context, C0933a.HELVETICA_12_BOLD, C0933a.HELVETICA_12_NORMAL);
            a.m745a(C0925h.m680a("ANDROID_name") + ":");
            a.m747b(preapproval.getMerchantName());
            this.b.addView(a);
            if (preapproval2.getStartDate() != null && preapproval2.getStartDate().length() > 0) {
                a = new C0940f(context, C0933a.HELVETICA_12_BOLD, C0933a.HELVETICA_12_NORMAL);
                a.m745a(C0925h.m680a("ANDROID_start_date") + ":");
                a.m747b(C0925h.m681a(preapproval2.getStartDate(), 2));
                this.b.addView(a);
            }
            if (preapproval2.getEndDate() != null && preapproval2.getEndDate().length() > 0) {
                a = new C0940f(context, C0933a.HELVETICA_12_BOLD, C0933a.HELVETICA_12_NORMAL);
                a.m745a(C0925h.m680a("ANDROID_end_date") + ":");
                a.m747b(C0925h.m681a(preapproval2.getEndDate(), 2));
                this.b.addView(a);
            }
        }
    }

    public final void m545a(boolean z, boolean z2) {
        if (z && this.f712f) {
            setFocusable(true);
            setClickable(true);
            this.c.setVisibility(0);
            this.f711e.m744a(-16777216);
            this.f711e.m746b(-13408768);
            return;
        }
        setFocusable(false);
        setClickable(false);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        if (z2) {
            this.f711e.m744a(-7829368);
            this.f711e.m746b(-7829368);
        }
    }

    public final void m546b(boolean z) {
        if (z) {
            setBackgroundDrawable(this.f714h);
        } else {
            setBackgroundDrawable(this.f713g);
        }
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (isFocusable()) {
            switch (motionEvent.getAction()) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                    setBackgroundDrawable(this.f714h);
                    break;
                default:
                    setBackgroundDrawable(this.f713g);
                    break;
            }
        }
        return false;
    }
}
