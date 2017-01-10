package com.paypal.android.p001b;

import android.content.Context;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/* renamed from: com.paypal.android.b.g */
public class C0893g extends LinearLayout implements OnFocusChangeListener {
    private LayoutParams[] f686a;
    private C0874a f687b;
    private int f688c;
    protected int f689d;

    /* renamed from: com.paypal.android.b.g.a */
    public interface C0874a {
        void m443a(C0893g c0893g, int i);
    }

    public C0893g(Context context) {
        super(context);
        setOnFocusChangeListener(this);
        setFocusable(true);
        this.f689d = 0;
        this.f688c = 2;
        setOrientation(1);
    }

    public void m515a(int i) {
        if (i != this.f689d) {
            if (i < 0 || i >= this.f688c) {
                throw new IllegalArgumentException("State " + i + " is outside the acceptable range 0-" + (this.f688c - 1));
            }
            this.f689d = i;
            setLayoutParams(this.f686a[this.f689d]);
            if (this.f687b != null) {
                this.f687b.m443a(this, i);
            }
        }
    }

    public final void m516a(LayoutParams layoutParams, int i) {
        if (this.f686a == null) {
            this.f686a = new LayoutParams[this.f688c];
        }
        this.f686a[i] = layoutParams;
        if (i == this.f689d) {
            setLayoutParams(layoutParams);
        }
    }

    public final void m517a(C0874a c0874a) {
        this.f687b = c0874a;
    }

    public void m518b(boolean z) {
    }

    public void onFocusChange(View view, boolean z) {
        m518b(z);
    }
}
