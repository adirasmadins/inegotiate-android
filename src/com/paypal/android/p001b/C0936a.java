package com.paypal.android.p001b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.CheckBox;
import android.widget.LinearLayout.LayoutParams;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.p003a.C0922e;

/* renamed from: com.paypal.android.b.a */
public final class C0936a extends CheckBox {
    private StateListDrawable f827a;

    public C0936a(Context context) {
        super(context);
        Drawable a = C0922e.m670a(97389, 842);
        Drawable a2 = C0922e.m670a(167861, 1154);
        Drawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setVisible(false, false);
        this.f827a = new StateListDrawable();
        this.f827a.addState(new int[]{-16842912}, a);
        this.f827a.addState(new int[]{16842912}, a2);
        setLayoutParams(new LayoutParams((int) (((double) a.getIntrinsicWidth()) * Math.pow((double) PayPal.getInstance().getDensity(), 2.0d)), (int) (((double) a.getIntrinsicHeight()) * Math.pow((double) PayPal.getInstance().getDensity(), 2.0d))));
        setBackgroundDrawable(this.f827a);
        setButtonDrawable(gradientDrawable);
    }
}
