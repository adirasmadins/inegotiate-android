package com.paypal.android.p001b;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.p003a.C0922e;

/* renamed from: com.paypal.android.b.j */
public abstract class C0872j extends RelativeLayout {
    private ScrollView f588a;
    private LinearLayout f589b;

    public C0872j(Context context) {
        int i = 640;
        int i2 = 800;
        super(context);
        int width = PayPalActivity.getInstance().getWindowManager().getDefaultDisplay().getWidth();
        int height = PayPalActivity.getInstance().getWindowManager().getDefaultDisplay().getHeight();
        if ((width <= height || height < 800) && (height <= width || width < 800)) {
            i2 = 640;
            i = 480;
        }
        if (width > height && height > i) {
            setPadding((width - i2) / 2, (height - i) / 2, (width - i2) / 2, (height - i) / 2);
        } else if (height <= width || width <= i) {
            setPadding(10, 10, 10, 10);
        } else {
            setPadding((width - i) / 2, (height - i2) / 2, (width - i) / 2, (height - i2) / 2);
        }
        setBackgroundColor(2130706432);
        m440a(context);
    }

    public abstract void m439a();

    protected void m440a(Context context) {
        this.f588a = new ScrollView(context);
        this.f588a.setLayoutParams(new LayoutParams(-1, -1));
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-1, -987685, -987685, -987685});
        gradientDrawable.setCornerRadius(10.0f);
        gradientDrawable.setGradientRadius(10.0f);
        this.f588a.setBackgroundDrawable(gradientDrawable);
        this.f588a.setFillViewport(true);
        super.addView(this.f588a);
        this.f589b = new LinearLayout(context);
        this.f589b.setOrientation(1);
        this.f589b.setLayoutParams(new LayoutParams(-1, -1));
        this.f589b.setBackgroundColor(0);
        this.f588a.addView(this.f589b);
        View linearLayout;
        ViewGroup.LayoutParams layoutParams;
        if (PayPal.getInstance().getServer() == 0) {
            linearLayout = new LinearLayout(PayPalActivity.getInstance());
            layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.addView(C0922e.m672a(context, "banner-sandbox.png"));
            super.addView(linearLayout);
        } else if (PayPal.getInstance().getServer() == 2) {
            linearLayout = new LinearLayout(PayPalActivity.getInstance());
            layoutParams = new LayoutParams(-2, -2);
            layoutParams.addRule(12);
            layoutParams.addRule(11);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.addView(C0922e.m672a(context, "banner-demo.png"));
            super.addView(linearLayout);
        }
    }

    public void addView(View view) {
        this.f589b.addView(view);
    }

    public abstract void m441b();

    protected void onMeasure(int i, int i2) {
        int i3 = 640;
        int i4 = 800;
        int i5 = 10;
        int size = MeasureSpec.getSize(i);
        int height = PayPalActivity.getInstance().getWindowManager().getDefaultDisplay().getHeight();
        Object obj = height - MeasureSpec.getSize(i2) > 100 ? 1 : null;
        if ((size <= height || height < 800) && (height <= size || size < 800)) {
            i4 = 640;
            i3 = 480;
        }
        int i6;
        int i7;
        if (size > height && height > i3) {
            i6 = (size - i4) / 2;
            i7 = (height - i3) / 2;
            i4 = (size - i4) / 2;
            if (obj == null) {
                i5 = (height - i3) / 2;
            }
            setPadding(i6, i7, i4, i5);
        } else if (height <= size || size <= i3) {
            setPadding(10, 10, 10, 10);
        } else {
            i6 = (size - i3) / 2;
            i7 = (height - i4) / 2;
            i3 = (size - i3) / 2;
            if (obj == null) {
                i5 = (height - i4) / 2;
            }
            setPadding(i6, i7, i3, i5);
        }
        super.onMeasure(i, i2);
    }
}
