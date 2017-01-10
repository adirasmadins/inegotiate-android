package com.paypal.android.MEP.p000a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.p000a.C0882d.C08791;
import com.paypal.android.p001b.C0872j;
import com.paypal.android.p001b.C0941h;
import com.paypal.android.p003a.C0919b;
import com.paypal.android.p003a.C0921d;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

/* renamed from: com.paypal.android.MEP.a.f */
public final class C0886f extends C0872j implements OnClickListener {
    private Button f657a;

    public C0886f(Context context) {
        super(context);
    }

    public final void m493a() {
    }

    protected final void m494a(Context context) {
        String str;
        super.m440a(context);
        setId(9006);
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new LayoutParams(-1, -1));
        linearLayout.setBackgroundDrawable(C0921d.m665a());
        linearLayout.setPadding(10, 5, 10, 5);
        linearLayout.setGravity(1);
        linearLayout.addView(new C0941h(C0925h.m680a("ANDROID_help"), context));
        View linearLayout2 = new LinearLayout(context);
        linearLayout2.setOrientation(1);
        linearLayout2.setLayoutParams(new LayoutParams(-1, -2));
        linearLayout2.setPadding(0, 0, 0, 15);
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-1, -1510918, -1510918, -1510918, -1510918, -1510918});
        gradientDrawable.setCornerRadius(10.0f);
        gradientDrawable.setStroke(2, -8280890);
        linearLayout2.setBackgroundDrawable(gradientDrawable);
        View a = C0934o.m736a(C0933a.HELVETICA_16_BOLD, context);
        a.setText(C0925h.m680a("ANDROID_about_paypal"));
        linearLayout2.addView(a);
        a = C0934o.m736a(C0933a.HELVETICA_16_NORMAL, context);
        a.setText(C0925h.m680a("ANDROID_help_string"));
        Linkify.addLinks(a, 1);
        linearLayout2.addView(a);
        a = C0934o.m736a(C0933a.HELVETICA_16_BOLD, context);
        a.setText(C0925h.m680a("ANDROID_sign_up"));
        linearLayout2.addView(a);
        a = C0934o.m736a(C0933a.HELVETICA_16_NORMAL, context);
        a.setText(C0925h.m680a("ANDROID_no_account"));
        Linkify.addLinks(a, 1);
        linearLayout2.addView(a);
        a = C0934o.m736a(C0933a.HELVETICA_16_BOLD, context);
        a.setText(C0925h.m680a("ANDROID_forgot_password"));
        linearLayout2.addView(a);
        a = C0934o.m736a(C0933a.HELVETICA_16_NORMAL, context);
        a.setText(C0925h.m680a("ANDROID_forgot_password_body"));
        Linkify.addLinks(a, 1);
        linearLayout2.addView(a);
        if (PayPal.getInstance().shouldShowFees()) {
            a = C0934o.m736a(C0933a.HELVETICA_16_BOLD, context);
            a.setText(C0925h.m680a("ANDROID_help_fees_header"));
            linearLayout2.addView(a);
            a = C0934o.m736a(C0933a.HELVETICA_16_NORMAL, context);
            a.setText(C0925h.m680a("ANDROID_help_fees_body"));
            Linkify.addLinks(a, 1);
            linearLayout2.addView(a);
        }
        TelephonyManager telephonyManager = (TelephonyManager) PayPal.getInstance().getParentContext().getSystemService("phone");
        String str2 = telephonyManager.getPhoneType() == 1 ? "IMEI" : "MEID";
        View a2 = C0934o.m736a(C0933a.HELVETICA_16_BOLD, context);
        a2.setPadding(5, 1, 5, 2);
        a2.setText(C0925h.m680a("ANDROID_debug_support"));
        linearLayout2.addView(a2);
        a2 = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, context);
        a2.setPadding(5, 1, 5, 2);
        a2.setText(C0925h.m680a("ANDROID_debug_version") + ": " + PayPal.getVersionWithoutBuild());
        linearLayout2.addView(a2);
        a2 = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, context);
        a2.setPadding(5, 1, 5, 2);
        a2.setText(C0925h.m680a("ANDROID_debug_build") + ": " + PayPal.getBuild());
        linearLayout2.addView(a2);
        a2 = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, context);
        a2.setPadding(5, 1, 5, 2);
        a2.setText(C0925h.m680a("ANDROID_debug_platform") + ": " + "Android");
        linearLayout2.addView(a2);
        a2 = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, context);
        a2.setPadding(5, 1, 5, 2);
        a2.setText(C0925h.m680a("ANDROID_debug_model") + ": " + Build.MODEL);
        linearLayout2.addView(a2);
        a2 = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, context);
        a2.setPadding(5, 1, 5, 2);
        a2.setText(C0925h.m680a("ANDROID_debug_os") + ": " + VERSION.RELEASE);
        linearLayout2.addView(a2);
        switch (PayPal.getInstance().getServer()) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                str = "Sandbox";
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                str = "Demo";
                break;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                str = "Stage (" + C0919b.m612b() + ")";
                break;
            default:
                str = "Live";
                break;
        }
        View a3 = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, context);
        a3.setPadding(5, 1, 5, 2);
        a3.setText(C0925h.m680a("ANDROID_debug_server") + ": " + str);
        linearLayout2.addView(a3);
        a2 = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, context);
        a2.setPadding(5, 1, 5, 2);
        a2.setText(str2 + ": " + telephonyManager.getDeviceId());
        linearLayout2.addView(a2);
        linearLayout.addView(linearLayout2);
        this.f657a = new Button(context);
        this.f657a.setText(C0925h.m680a("ANDROID_ok"));
        this.f657a.setLayoutParams(new LayoutParams(-1, C0921d.m669b()));
        this.f657a.setGravity(17);
        this.f657a.setBackgroundDrawable(C0922e.m671a());
        this.f657a.setTextColor(-16777216);
        this.f657a.setOnClickListener(this);
        a = new LinearLayout(context);
        a.setOrientation(1);
        a.setLayoutParams(new LayoutParams(-1, -2));
        a.setPadding(0, 15, 0, 0);
        a.addView(this.f657a);
        linearLayout.addView(a);
        addView(linearLayout);
    }

    public final void m495b() {
    }

    public final void onClick(View view) {
        if (view == this.f657a) {
            C08791.m463a();
        }
    }
}
