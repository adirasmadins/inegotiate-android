package com.paypal.android.MEP.p002b;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.PayPalInvoiceItem;
import com.paypal.android.MEP.PayPalReceiverDetails;
import com.paypal.android.p001b.C0895c;
import com.paypal.android.p001b.C0940f;
import com.paypal.android.p003a.C0921d;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0930l;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;
import java.math.BigDecimal;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.paypal.android.MEP.b.c */
public final class C0899c extends C0895c implements OnTouchListener {
    public C0899c(Context context, PayPalReceiverDetails payPalReceiverDetails, String str) {
        BigDecimal subtotal;
        int i = 0;
        super(context);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.setMargins(3, 3, 3, 3);
        m516a(layoutParams, 0);
        m516a(layoutParams, 1);
        setBackgroundColor(0);
        m522a(C0922e.m670a(130087, 2921));
        m524b(C0922e.m670a(63352, 2927));
        setOnTouchListener(this);
        this.a.setPadding(5, 0, 5, 0);
        this.a.setBackgroundColor(-2763307);
        this.a.setGravity(16);
        this.a.addView(this.c);
        this.c.setVisibility(0);
        View c0940f = new C0940f(context, C0933a.HELVETICA_14_BOLD, C0933a.HELVETICA_14_BOLD);
        c0940f.setPadding(3, 0, 0, 0);
        String merchantName = payPalReceiverDetails.getMerchantName();
        if (merchantName == null || merchantName.length() == 0) {
            merchantName = payPalReceiverDetails.getRecipient();
        }
        String a = C0930l.m697a(payPalReceiverDetails.getTotal(), str);
        c0940f.m745a(merchantName);
        c0940f.m747b(a);
        this.a.addView(c0940f);
        this.b.setPadding(10, 0, 0, 0);
        this.b.setOrientation(1);
        if (payPalReceiverDetails.getInvoiceData() == null || payPalReceiverDetails.getInvoiceData().getInvoiceItems() == null || payPalReceiverDetails.getInvoiceData().getInvoiceItems().size() <= 0) {
            subtotal = payPalReceiverDetails.getSubtotal();
            if (subtotal != null) {
                View c0940f2 = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
                c0940f2.m745a(C0925h.m680a("ANDROID_total"));
                c0940f2.m747b(C0930l.m697a(subtotal, str));
                this.b.addView(c0940f2);
            }
        } else {
            while (i < payPalReceiverDetails.getInvoiceData().getInvoiceItems().size()) {
                PayPalInvoiceItem payPalInvoiceItem = (PayPalInvoiceItem) payPalReceiverDetails.getInvoiceData().getInvoiceItems().get(i);
                String name = payPalInvoiceItem.getName();
                a = payPalInvoiceItem.getID();
                BigDecimal totalPrice = payPalInvoiceItem.getTotalPrice();
                BigDecimal unitPrice = payPalInvoiceItem.getUnitPrice();
                int quantity = payPalInvoiceItem.getQuantity();
                if (payPalInvoiceItem.isValid()) {
                    View c0940f3;
                    if (name != null && name.length() > 0) {
                        c0940f = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
                        c0940f.m745a(C0925h.m680a("ANDROID_item") + ": " + payPalInvoiceItem.getName());
                        if (totalPrice == null || totalPrice.toString().length() <= 0) {
                            c0940f.m747b(StringUtil.EMPTY_STRING);
                        } else {
                            c0940f.m747b(C0930l.m697a(totalPrice, str));
                        }
                        this.b.addView(c0940f);
                    } else if (totalPrice != null && totalPrice.compareTo(BigDecimal.ZERO) > 0) {
                        c0940f3 = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
                        c0940f3.m745a(C0925h.m680a("ANDROID_item") + ": " + C0925h.m680a("ANDROID_item") + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (i + 1));
                        c0940f3.m747b(totalPrice.toString());
                        this.b.addView(c0940f3);
                    }
                    if (a != null && a.length() > 0) {
                        c0940f3 = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                        c0940f3.setText(C0925h.m680a("ANDROID_item_num") + ": " + a);
                        this.b.addView(c0940f3);
                    }
                    if (unitPrice != null && unitPrice.compareTo(BigDecimal.ZERO) > 0) {
                        c0940f3 = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                        c0940f3.setText(C0925h.m680a("ANDROID_item_price") + ": " + C0930l.m697a(unitPrice, str));
                        this.b.addView(c0940f3);
                    }
                    if (quantity > 0) {
                        c0940f3 = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                        c0940f3.setText(C0925h.m680a("ANDROID_quantity") + ": " + quantity);
                        this.b.addView(c0940f3);
                    }
                    if (i != payPalReceiverDetails.getInvoiceData().getInvoiceItems().size() - 1) {
                        c0940f3 = C0921d.m667a(context, 5, 5);
                        c0940f3.setVisibility(4);
                        this.b.addView(c0940f3);
                    }
                }
                i++;
            }
        }
        subtotal = payPalReceiverDetails.getInvoiceData() != null ? payPalReceiverDetails.getInvoiceData().getTax() : null;
        if (subtotal != null && subtotal.compareTo(BigDecimal.ZERO) > 0) {
            c0940f2 = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
            c0940f2.m745a(C0925h.m680a("ANDROID_tax"));
            c0940f2.m747b(C0930l.m697a(subtotal, str));
            this.b.addView(c0940f2);
        }
        subtotal = payPalReceiverDetails.getInvoiceData() != null ? payPalReceiverDetails.getInvoiceData().getShipping() : null;
        if (subtotal != null && subtotal.compareTo(BigDecimal.ZERO) > 0) {
            c0940f2 = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
            c0940f2.m745a(C0925h.m680a("ANDROID_shipping"));
            c0940f2.m747b(C0930l.m697a(subtotal, str));
            this.b.addView(c0940f2);
        }
    }

    public static LinearLayout m547a(Context context, PayPalReceiverDetails payPalReceiverDetails, String str) {
        BigDecimal subtotal;
        LinearLayout linearLayout = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setPadding(5, 0, 5, 5);
        linearLayout.setPadding(10, 0, 0, 0);
        linearLayout.setOrientation(1);
        if (payPalReceiverDetails.getInvoiceData() == null || payPalReceiverDetails.getInvoiceData().getInvoiceItems() == null || payPalReceiverDetails.getInvoiceData().getInvoiceItems().size() <= 0) {
            subtotal = payPalReceiverDetails.getSubtotal();
            if (subtotal != null) {
                View c0940f = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
                c0940f.m745a(C0925h.m680a("ANDROID_total"));
                c0940f.m747b(C0930l.m697a(subtotal, str));
                linearLayout.addView(c0940f);
            }
        } else {
            for (int i = 0; i < payPalReceiverDetails.getInvoiceData().getInvoiceItems().size(); i++) {
                PayPalInvoiceItem payPalInvoiceItem = (PayPalInvoiceItem) payPalReceiverDetails.getInvoiceData().getInvoiceItems().get(i);
                String name = payPalInvoiceItem.getName();
                String id = payPalInvoiceItem.getID();
                BigDecimal totalPrice = payPalInvoiceItem.getTotalPrice();
                BigDecimal unitPrice = payPalInvoiceItem.getUnitPrice();
                int quantity = payPalInvoiceItem.getQuantity();
                if (payPalInvoiceItem.isValid()) {
                    View c0940f2;
                    if (name != null && name.length() > 0) {
                        View c0940f3 = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
                        c0940f3.m745a(C0925h.m680a("ANDROID_item") + ": " + payPalInvoiceItem.getName());
                        if (totalPrice == null || totalPrice.toString().length() <= 0) {
                            c0940f3.m747b(StringUtil.EMPTY_STRING);
                        } else {
                            c0940f3.m747b(C0930l.m697a(totalPrice, str));
                        }
                        linearLayout.addView(c0940f3);
                    } else if (totalPrice != null && totalPrice.compareTo(BigDecimal.ZERO) > 0) {
                        c0940f2 = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
                        c0940f2.m745a(C0925h.m680a("ANDROID_item") + ": " + C0925h.m680a("ANDROID_item") + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + (i + 1));
                        c0940f2.m747b(totalPrice.toString());
                        linearLayout.addView(c0940f2);
                    }
                    if (id != null && id.length() > 0) {
                        c0940f2 = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                        c0940f2.setText(C0925h.m680a("ANDROID_item_num") + ": " + id);
                        linearLayout.addView(c0940f2);
                    }
                    if (unitPrice != null && unitPrice.compareTo(BigDecimal.ZERO) > 0) {
                        c0940f2 = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                        c0940f2.setText(C0925h.m680a("ANDROID_item_price") + ": " + C0930l.m697a(unitPrice, str));
                        linearLayout.addView(c0940f2);
                    }
                    if (quantity > 0) {
                        c0940f2 = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                        c0940f2.setText(C0925h.m680a("ANDROID_quantity") + ": " + quantity);
                        linearLayout.addView(c0940f2);
                    }
                    if (i != payPalReceiverDetails.getInvoiceData().getInvoiceItems().size() - 1) {
                        c0940f2 = C0921d.m667a(context, 5, 5);
                        c0940f2.setVisibility(4);
                        linearLayout.addView(c0940f2);
                    }
                }
            }
        }
        subtotal = payPalReceiverDetails.getInvoiceData() != null ? payPalReceiverDetails.getInvoiceData().getTax() : null;
        if (subtotal != null && subtotal.compareTo(BigDecimal.ZERO) > 0) {
            c0940f = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
            c0940f.m745a(C0925h.m680a("ANDROID_tax"));
            c0940f.m747b(C0930l.m697a(subtotal, str));
            linearLayout.addView(c0940f);
        }
        subtotal = payPalReceiverDetails.getInvoiceData() != null ? payPalReceiverDetails.getInvoiceData().getShipping() : null;
        if (subtotal != null && subtotal.compareTo(BigDecimal.ZERO) > 0) {
            c0940f = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
            c0940f.m745a(C0925h.m680a("ANDROID_shipping"));
            c0940f.m747b(C0930l.m697a(subtotal, str));
            linearLayout.addView(c0940f);
        }
        return linearLayout;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}
