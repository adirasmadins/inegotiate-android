package com.paypal.android.p001b;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;

/* renamed from: com.paypal.android.b.f */
public final class C0940f extends LinearLayout {
    private TextView f832a;
    private TextView f833b;

    public C0940f(Context context, C0933a c0933a, C0933a c0933a2) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -2, 0.5f));
        setBackgroundColor(0);
        this.f832a = C0934o.m736a(c0933a, context);
        this.f832a.setLayoutParams(new LayoutParams(-1, -2, 0.4f));
        this.f832a.setPadding(2, 2, 2, 2);
        this.f832a.setBackgroundColor(0);
        this.f832a.setVisibility(8);
        this.f833b = C0934o.m736a(c0933a2, context);
        this.f833b.setGravity(5);
        this.f833b.setLayoutParams(new LayoutParams(-1, -2, 0.6f));
        this.f833b.setPadding(2, 2, 2, 2);
        this.f833b.setBackgroundColor(0);
        this.f833b.setVisibility(8);
        addView(this.f832a);
        addView(this.f833b);
    }

    public C0940f(Context context, C0933a c0933a, C0933a c0933a2, float f, float f2) {
        super(context);
        setLayoutParams(new LayoutParams(-1, -2, 0.5f));
        setBackgroundColor(0);
        this.f832a = C0934o.m736a(c0933a, context);
        this.f832a.setLayoutParams(new LayoutParams(-1, -2, 0.5f));
        this.f832a.setPadding(2, 2, 2, 2);
        this.f832a.setBackgroundColor(0);
        this.f832a.setVisibility(8);
        this.f833b = C0934o.m736a(c0933a2, context);
        this.f833b.setGravity(5);
        this.f833b.setLayoutParams(new LayoutParams(-1, -2, 0.5f));
        this.f833b.setPadding(2, 2, 2, 2);
        this.f833b.setBackgroundColor(0);
        this.f833b.setVisibility(8);
        addView(this.f832a);
        addView(this.f833b);
    }

    public final void m744a(int i) {
        this.f832a.setTextColor(i);
    }

    public final void m745a(String str) {
        this.f832a.setVisibility(8);
        if (str != null && str.length() > 0) {
            this.f832a.setText(str);
            this.f832a.setVisibility(0);
        }
    }

    public final void m746b(int i) {
        this.f833b.setTextColor(i);
    }

    public final void m747b(String str) {
        this.f833b.setVisibility(8);
        if (str != null && str.length() > 0) {
            this.f833b.setText(str);
            this.f833b.setVisibility(0);
        }
    }
}
