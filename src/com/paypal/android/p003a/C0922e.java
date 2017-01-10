package com.paypal.android.p003a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.StateListDrawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.p003a.p004a.C0915j;
import java.io.ByteArrayInputStream;

/* renamed from: com.paypal.android.a.e */
public final class C0922e {
    public static Drawable m670a(int i, int i2) {
        Throwable th;
        Drawable drawable = null;
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(C0924g.m675a(i, i2));
            try {
                drawable = Drawable.createFromStream(byteArrayInputStream, StringUtil.EMPTY_STRING + i + "." + i2);
                try {
                    byteArrayInputStream.close();
                } catch (Throwable th2) {
                }
            } catch (Throwable th3) {
                th = th3;
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th4) {
                    }
                }
                throw th;
            }
        } catch (Throwable th5) {
            Throwable th6 = th5;
            byteArrayInputStream = drawable;
            th = th6;
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th;
        }
        return drawable;
    }

    public static StateListDrawable m671a() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-6733, -22016});
        Drawable gradientDrawable2 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-211356, -1937101});
        Drawable gradientDrawable3 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-803493, -3845098});
        Drawable gradientDrawable4 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{2147272292, 2145546547});
        gradientDrawable.setCornerRadius(5.0f);
        gradientDrawable.setStroke(1, -3637191);
        gradientDrawable2.setCornerRadius(5.0f);
        gradientDrawable2.setStroke(1, -1858224);
        gradientDrawable3.setCornerRadius(5.0f);
        gradientDrawable3.setStroke(1, -3042498);
        gradientDrawable4.setCornerRadius(5.0f);
        gradientDrawable4.setStroke(1, 2145625424);
        stateListDrawable.addState(new int[]{16842910, -16842919, -16842908}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842910, -16842919, 16842908}, gradientDrawable2);
        stateListDrawable.addState(new int[]{16842910, 16842919, -16842908}, gradientDrawable3);
        stateListDrawable.addState(new int[]{16842910, 16842919, 16842908}, gradientDrawable3);
        stateListDrawable.addState(new int[]{-16842910, -16842919, -16842908}, gradientDrawable4);
        stateListDrawable.addState(new int[]{-16842910, -16842919, 16842908}, gradientDrawable4);
        stateListDrawable.addState(new int[]{-16842910, 16842919, -16842908}, gradientDrawable4);
        stateListDrawable.addState(new int[]{-16842910, 16842919, 16842908}, gradientDrawable4);
        return stateListDrawable;
    }

    public static ImageView m672a(Context context, String str) {
        ImageView imageView = new ImageView(context);
        Drawable a = C0922e.m670a(((Integer) C0915j.f781a.get(str)).intValue(), ((Integer) C0915j.f782b.get(str)).intValue());
        imageView.setLayoutParams(new LayoutParams((int) (((double) a.getIntrinsicWidth()) * Math.pow((double) PayPal.getInstance().getDensity(), 2.0d)), (int) (((double) a.getIntrinsicHeight()) * Math.pow((double) PayPal.getInstance().getDensity(), 2.0d))));
        imageView.setImageDrawable(a);
        imageView.setScaleType(ScaleType.FIT_XY);
        return imageView;
    }

    public static StateListDrawable m673b() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-197380, -3355444});
        Drawable gradientDrawable2 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-3487030, -6645094});
        Drawable gradientDrawable3 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-7302507, -10395036});
        Drawable gradientDrawable4 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{2143996618, 2140838554});
        gradientDrawable.setCornerRadius(5.0f);
        gradientDrawable.setStroke(1, -10066330);
        gradientDrawable2.setCornerRadius(5.0f);
        gradientDrawable2.setStroke(1, -12303292);
        gradientDrawable3.setCornerRadius(5.0f);
        gradientDrawable3.setStroke(1, -13421773);
        gradientDrawable4.setCornerRadius(5.0f);
        gradientDrawable4.setStroke(1, 2135180356);
        stateListDrawable.addState(new int[]{16842910, -16842919, -16842908}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842910, -16842919, 16842908}, gradientDrawable2);
        stateListDrawable.addState(new int[]{16842910, 16842919, -16842908}, gradientDrawable3);
        stateListDrawable.addState(new int[]{16842910, 16842919, 16842908}, gradientDrawable3);
        stateListDrawable.addState(new int[]{-16842910, -16842919, -16842908}, gradientDrawable4);
        stateListDrawable.addState(new int[]{-16842910, -16842919, 16842908}, gradientDrawable4);
        stateListDrawable.addState(new int[]{-16842910, 16842919, -16842908}, gradientDrawable4);
        stateListDrawable.addState(new int[]{-16842910, 16842919, 16842908}, gradientDrawable4);
        return stateListDrawable;
    }
}
