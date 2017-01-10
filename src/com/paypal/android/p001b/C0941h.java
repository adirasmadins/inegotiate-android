package com.paypal.android.p001b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.paypal.android.p003a.C0921d;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;

/* renamed from: com.paypal.android.b.h */
public final class C0941h extends LinearLayout {
    public C0941h(String str, Context context) {
        super(context);
        setOrientation(1);
        setPadding(0, 0, 0, 0);
        setLayoutParams(new LayoutParams(-1, -2));
        setGravity(80);
        View a = C0921d.m667a(context, -1, -2);
        a.setOrientation(0);
        a.setPadding(0, 0, 0, 0);
        a.setGravity(80);
        View a2 = C0934o.m736a(C0933a.HELVETICA_14_BOLD, context);
        a2.setLayoutParams(new LayoutParams(-1, -2, 1.0f));
        a2.setPadding(5, 5, 0, 0);
        a2.setGravity(83);
        a2.setBackgroundColor(0);
        a2.setTextColor(-3637184);
        a2.setText(str);
        a.addView(a2);
        a.addView(C0922e.m672a(context, "paypal_logo_22.png"));
        a2 = C0921d.m667a(context, -2, -2);
        a2.setPadding(5, 5, 5, 5);
        a2.addView(C0922e.m672a(context, "lock-icon.png"));
        a.addView(a2);
        addView(a);
        a = C0921d.m667a(context, -1, -2);
        a.setOrientation(0);
        a.setPadding(5, 5, 5, 10);
        a.setGravity(48);
        a2 = new ImageView(context);
        a2.setLayoutParams(new LayoutParams(-1, 2));
        Drawable gradientDrawable = new GradientDrawable(Orientation.LEFT_RIGHT, new int[]{-6042131, -14993820, -6042131});
        gradientDrawable.setCornerRadius(0.0f);
        gradientDrawable.setStroke(0, 0);
        gradientDrawable.setAlpha(XMLChar.MASK_NCNAME);
        a2.setBackgroundDrawable(gradientDrawable);
        a.addView(a2);
        addView(a);
    }
}
