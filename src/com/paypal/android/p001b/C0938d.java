package com.paypal.android.p001b;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

/* renamed from: com.paypal.android.b.d */
public final class C0938d extends C0937b implements OnClickListener {
    private C0894a f830a;

    /* renamed from: com.paypal.android.b.d.a */
    public interface C0894a {
        void m519a();
    }

    public C0938d(Context context) {
        super(context);
        setOnClickListener(this);
    }

    public final void m741a(C0894a c0894a) {
        this.f830a = c0894a;
    }

    protected final void drawableStateChanged() {
    }

    public final void onClick(View view) {
        if (view == this) {
            m739a(m738a() == 0 ? 1 : 0);
            if (this.f830a != null) {
                this.f830a.m519a();
            }
        }
    }
}
