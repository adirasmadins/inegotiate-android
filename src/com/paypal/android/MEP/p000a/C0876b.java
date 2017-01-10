package com.paypal.android.MEP.p000a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.paypal.android.MEP.p000a.C0882d.C08791;
import com.paypal.android.p001b.C0872j;
import com.paypal.android.p001b.C0941h;
import com.paypal.android.p003a.C0921d;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;

/* renamed from: com.paypal.android.MEP.a.b */
public final class C0876b extends C0872j implements OnClickListener {
    private Button f605a;

    public C0876b(Context context) {
        super(context);
        setId(9005);
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.setBackgroundDrawable(C0921d.m665a());
        linearLayout.setPadding(10, 5, 10, 5);
        linearLayout.setGravity(1);
        linearLayout.addView(new C0941h(C0925h.m680a("ANDROID_about_quickpay"), context));
        View linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LayoutParams(-1, -2));
        linearLayout2.setPadding(0, 0, 0, 15);
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-1, -1510918, -1510918, -1510918, -1510918, -1510918});
        gradientDrawable.setCornerRadius(10.0f);
        gradientDrawable.setStroke(2, -8280890);
        linearLayout2.setBackgroundDrawable(gradientDrawable);
        View a = C0934o.m736a(C0933a.HELVETICA_16_BOLD, context);
        a.setText(C0925h.m680a("ANDROID_for_checkout"));
        linearLayout2.addView(a);
        a = C0934o.m736a(C0933a.HELVETICA_16_NORMAL, context);
        a.setText(C0925h.m680a("ANDROID_quickpay_help"));
        linearLayout2.addView(a);
        linearLayout.addView(linearLayout2);
        this.f605a = new Button(context);
        this.f605a.setText(C0925h.m680a("ANDROID_ok"));
        this.f605a.setLayoutParams(new LayoutParams(-1, C0921d.m669b()));
        this.f605a.setGravity(17);
        this.f605a.setBackgroundDrawable(C0922e.m671a());
        this.f605a.setTextColor(-16777216);
        this.f605a.setOnClickListener(this);
        linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LayoutParams(-1, -2));
        linearLayout2.setPadding(0, 15, 0, 0);
        linearLayout2.addView(this.f605a);
        linearLayout.addView(linearLayout2);
        addView(linearLayout);
    }

    public final void m457a() {
    }

    public final void m458b() {
    }

    public final void onClick(View view) {
        if (view == this.f605a) {
            C08791.m463a();
        }
    }
}
