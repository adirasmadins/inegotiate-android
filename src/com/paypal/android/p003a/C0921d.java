package com.paypal.android.p003a;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

/* renamed from: com.paypal.android.a.d */
public final class C0921d {
    public static GradientDrawable m665a() {
        GradientDrawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-1, -1510918, -1510918, -1510918, -1510918, -1510918});
        gradientDrawable.setCornerRadius(10.0f);
        gradientDrawable.setStroke(2, -7829368);
        return gradientDrawable;
    }

    public static GradientDrawable m666a(int i, int i2, int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-1, i2, i2, i2, i2, i2});
        gradientDrawable.setCornerRadius(5.0f);
        gradientDrawable.setStroke(2, i3);
        return gradientDrawable;
    }

    public static LinearLayout m667a(Context context, int i, int i2) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LayoutParams(i, i2));
        return linearLayout;
    }

    public static LinearLayout m668a(Context context, int i, int i2, float f) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setLayoutParams(new LayoutParams(-1, -2, 0.5f));
        return linearLayout;
    }

    public static int m669b() {
        return VERSION.SDK.equals("3") ? 40 : -2;
    }
}
