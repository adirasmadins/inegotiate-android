package com.paypal.android.p001b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;

/* renamed from: com.paypal.android.b.k */
public class C0896k extends C0895c {
    private LinearLayout f693e;

    public C0896k(Context context) {
        super(context);
        LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 1;
        this.b.setLayoutParams(layoutParams);
        this.b.setOrientation(1);
        this.b.setGravity(17);
        this.b.setPadding(10, 0, 10, 0);
        this.f693e = new LinearLayout(context);
        this.f693e.setLayoutParams(layoutParams);
        this.f693e.setOrientation(1);
        this.f693e.setGravity(17);
        this.f693e.setPadding(5, 0, 5, 5);
        this.b.addView(this.f693e);
        this.c.setVisibility(0);
    }

    public final void m525a(View view) {
        this.f693e.addView(view);
    }

    public void m526c() {
    }

    public final void m527c(Drawable drawable) {
        this.f693e.setBackgroundDrawable(drawable);
    }

    public final void m528d() {
        this.f693e.removeAllViews();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        this.a.setBackgroundDrawable(drawable);
    }
}
