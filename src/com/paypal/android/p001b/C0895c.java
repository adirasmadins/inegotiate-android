package com.paypal.android.p001b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.p001b.C0938d.C0894a;

/* renamed from: com.paypal.android.b.c */
public class C0895c extends C0893g implements OnClickListener, C0894a {
    protected LinearLayout f690a;
    protected LinearLayout f691b;
    protected C0938d f692c;

    public C0895c(Context context) {
        super(context);
        setOnClickListener(this);
        setOnFocusChangeListener(this);
        this.f690a = new LinearLayout(context);
        this.f690a.setLayoutParams(new LayoutParams(-1, -2));
        this.f690a.setOrientation(0);
        this.f690a.setGravity(5);
        this.f690a.setPadding(5, 5, 5, 5);
        this.f691b = new LinearLayout(context);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        this.f691b.setLayoutParams(layoutParams);
        this.f691b.setPadding(5, 0, 5, 5);
        addView(this.f690a);
        addView(this.f691b);
        this.f691b.setVisibility(8);
        this.f692c = new C0938d(context);
        this.f692c.setLayoutParams(new LayoutParams(-2, -2));
        this.f692c.m741a(this);
        this.f692c.setGravity(16);
        this.f692c.setVisibility(8);
        this.f692c.setClickable(false);
        this.f692c.setFocusable(false);
    }

    public final void m520a() {
        int i = 1;
        if (this.d == 1) {
            i = 0;
        }
        m521a(i);
    }

    public void m521a(int i) {
        super.m515a(i);
        if (i == 1) {
            this.f691b.setVisibility(0);
            this.f692c.m739a(1);
            return;
        }
        this.f691b.setVisibility(8);
        this.f692c.m739a(0);
    }

    public final void m522a(Drawable drawable) {
        if (this.f692c != null) {
            float pow = (float) Math.pow((double) PayPal.getInstance().getDensity(), 2.0d);
            int minimumWidth = (int) (((float) drawable.getMinimumWidth()) * pow);
            int minimumHeight = (int) (pow * ((float) drawable.getMinimumHeight()));
            this.f692c.m740a(1, drawable);
            this.f692c.setLayoutParams(new LayoutParams(minimumWidth, minimumHeight));
        }
    }

    public final void m523a(boolean z) {
        if (z) {
            setClickable(true);
            setFocusable(true);
            this.f692c.setVisibility(0);
            return;
        }
        setClickable(false);
        setFocusable(false);
        this.f692c.setVisibility(8);
        this.f691b.setVisibility(8);
    }

    public final void m524b(Drawable drawable) {
        if (this.f692c != null) {
            float pow = (float) Math.pow((double) PayPal.getInstance().getDensity(), 2.0d);
            int minimumWidth = (int) (((float) drawable.getMinimumWidth()) * pow);
            int minimumHeight = (int) (pow * ((float) drawable.getMinimumHeight()));
            this.f692c.m740a(0, drawable);
            this.f692c.setLayoutParams(new LayoutParams(minimumWidth, minimumHeight));
        }
    }

    public void onClick(View view) {
        this.f692c.onClick(this.f692c);
    }
}
