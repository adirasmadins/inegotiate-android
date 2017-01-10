package com.paypal.android.p001b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;

/* renamed from: com.paypal.android.b.b */
public class C0937b extends Button implements OnFocusChangeListener {
    private int f828a;
    private Drawable[] f829b;

    public C0937b(Context context) {
        super(context);
        this.f828a = 0;
        setOnFocusChangeListener(this);
        setLayoutParams(new LayoutParams(-2, -2));
    }

    public final int m738a() {
        return this.f828a;
    }

    public final void m739a(int i) {
        if (this.f828a != 2) {
            if (i < 0 || i >= 3) {
                throw new IllegalArgumentException("State " + i + " is outside the acceptable range 0-" + 2);
            }
            this.f828a = i;
            if (this.f829b != null) {
                Drawable drawable = this.f829b[this.f828a];
                if (drawable != null) {
                    setBackgroundColor(0);
                    setBackgroundDrawable(drawable);
                }
            }
        }
    }

    public final void m740a(int i, Drawable drawable) {
        if (i < 0 || i >= 3) {
            throw new IllegalArgumentException("State " + i + " is outside the acceptable range 0-" + 2);
        }
        if (this.f829b == null) {
            this.f829b = new Drawable[3];
        }
        this.f829b[i] = drawable;
        if (i == this.f828a && drawable != null) {
            setBackgroundDrawable(drawable);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (!StateSet.stateSetMatches(new int[]{16842919}, drawableState)) {
            if (!StateSet.stateSetMatches(new int[]{16842908}, drawableState)) {
                m739a(0);
                return;
            }
        }
        m739a(1);
    }

    public void onFocusChange(View view, boolean z) {
    }
}
