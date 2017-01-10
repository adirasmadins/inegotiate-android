package com.paypal.android.p001b;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;
import org.codehaus.jackson.impl.JsonWriteContext;

/* renamed from: com.paypal.android.b.i */
public final class C0944i extends LinearLayout {
    private Context f840a;
    private GradientDrawable f841b;
    private ImageView f842c;
    private TextView f843d;

    /* renamed from: com.paypal.android.b.i.1 */
    static /* synthetic */ class C09421 {
        static final /* synthetic */ int[] f834a;

        static {
            f834a = new int[C0943a.values().length];
            try {
                f834a[C0943a.RED_ALERT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f834a[C0943a.YELLOW_ALERT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f834a[C0943a.GREEN_ALERT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f834a[C0943a.BLUE_ALERT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.paypal.android.b.i.a */
    public enum C0943a {
        RED_ALERT,
        YELLOW_ALERT,
        GREEN_ALERT,
        BLUE_ALERT
    }

    public C0944i(Context context, C0943a c0943a) {
        super(context);
        this.f840a = context;
        setOrientation(0);
        setLayoutParams(new LayoutParams(-1, -2));
        setGravity(16);
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        linearLayout.setPadding(5, 10, 5, 10);
        switch (C09421.f834a[c0943a.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                this.f841b = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-3172, -52});
                this.f841b.setStroke(1, -12529);
                this.f841b.setCornerRadius(3.0f);
                setBackgroundDrawable(this.f841b);
                this.f842c = C0922e.m672a(this.f840a, "system-icon-error.png");
                this.f843d = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                this.f843d.setTextColor(-65536);
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                this.f841b = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-3172, -52});
                this.f841b.setStroke(1, -12529);
                this.f841b.setCornerRadius(3.0f);
                setBackgroundDrawable(this.f841b);
                this.f842c = C0922e.m672a(this.f840a, "system-icon-alert.png");
                this.f843d = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                this.f843d.setTextColor(-65536);
                break;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                this.f841b = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-3219987, -1510918});
                this.f841b.setStroke(1, -8280890);
                this.f841b.setCornerRadius(3.0f);
                setBackgroundDrawable(this.f841b);
                this.f842c = C0922e.m672a(this.f840a, "system-icon-confirmation.png");
                this.f843d = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                this.f843d.setTextColor(-13408768);
                break;
            case JsonWriteContext.STATUS_EXPECT_VALUE /*4*/:
                this.f841b = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-3219987, -1510918});
                this.f841b.setStroke(1, -8280890);
                this.f841b.setCornerRadius(3.0f);
                setBackgroundDrawable(this.f841b);
                this.f842c = C0922e.m672a(this.f840a, "system-icon-notification.png");
                this.f843d = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                this.f843d.setTextColor(-13408615);
                break;
        }
        linearLayout.addView(this.f842c);
        addView(linearLayout);
        addView(this.f843d);
    }

    public final void m748a(String str) {
        this.f843d.setText(str);
    }
}
