package com.paypal.android.MEP.p000a;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.PasswordTransformationMethod;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.text.util.Linkify;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.paypal.android.MEP.C0890a.C0869b;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalPreapproval;
import com.paypal.android.MEP.p000a.C0882d.C08791;
import com.paypal.android.MEP.p002b.C0897a;
import com.paypal.android.MEP.p002b.C0897a.C0873b;
import com.paypal.android.MEP.p002b.C0898b;
import com.paypal.android.MEP.p002b.C0902f;
import com.paypal.android.p001b.C0872j;
import com.paypal.android.p001b.C0893g;
import com.paypal.android.p001b.C0893g.C0874a;
import com.paypal.android.p001b.C0939e;
import com.paypal.android.p001b.C0941h;
import com.paypal.android.p001b.C0944i;
import com.paypal.android.p001b.C0944i.C0943a;
import com.paypal.android.p003a.C0919b;
import com.paypal.android.p003a.C0921d;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;
import java.util.regex.Pattern;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.paypal.android.MEP.a.g */
public final class C0888g extends C0872j implements OnClickListener, C0869b, C0873b, C0874a {
    private static C0939e f663n;
    private C0887a f664a;
    private C0898b f665b;
    private Button f666c;
    private Button f667d;
    private Button f668e;
    private Button f669f;
    private C0944i f670g;
    private C0944i f671h;
    private String f672i;
    private LinearLayout f673j;
    private LinearLayout f674k;
    private RelativeLayout f675l;
    private TextView f676m;

    /* renamed from: com.paypal.android.MEP.a.g.a */
    public enum C0887a {
        STATE_PIN,
        STATE_REVIEW,
        STATE_CONFIRM_PREAPPROVAL,
        STATE_ERROR
    }

    static {
        f663n = null;
    }

    public C0888g(Context context) {
        super(context);
        this.f676m = null;
    }

    private void m496a(C0887a c0887a) {
        this.f664a = c0887a;
        C08791.m465b();
    }

    public final void m497a() {
    }

    public final void m498a(int i, Object obj) {
        PayPalActivity.getInstance().paymentSucceeded((String) C0919b.m619e().m657c("PreapprovalKey"), (String) C0919b.m619e().m657c("PaymentExecStatus"), true);
    }

    public final void m499a(Context context) {
        PayPalPreapproval preapproval = PayPal.getInstance().getPreapproval();
        super.m440a(context);
        if (preapproval.getPinRequired()) {
            C0919b.m619e().m655a("mpl-preapproval-PIN");
            this.f664a = C0887a.STATE_PIN;
        } else {
            this.f664a = C0887a.STATE_REVIEW;
        }
        View a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setPadding(5, 5, 5, 15);
        a.addView(C0934o.m737b(C0933a.HELVETICA_16_BOLD, context));
        this.f665b = new C0898b(context, this);
        this.f665b.m517a((C0874a) this);
        a.addView(this.f665b);
        addView(a);
        this.f673j = new LinearLayout(context);
        this.f673j.setOrientation(1);
        this.f673j.setLayoutParams(new LayoutParams(-1, -1));
        this.f673j.setPadding(5, 5, 5, 5);
        this.f673j.setBackgroundDrawable(C0921d.m665a());
        this.f673j.addView(new C0941h(C0925h.m680a("ANDROID_create_code"), context));
        a = new TextView(context);
        a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        a.setBackgroundColor(0);
        a.setTextColor(-13408615);
        a.setGravity(3);
        a.setTypeface(Typeface.create("Helvetica", 1));
        a.setTextSize(12.0f);
        a.setPadding(5, 5, 5, 5);
        a.setText(C0925h.m680a("ANDROID_require_pin").replace("%m", preapproval.getMerchantName()));
        this.f673j.addView(a);
        a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setPadding(5, 10, 5, 10);
        this.f671h = new C0944i(context, C0943a.YELLOW_ALERT);
        this.f671h.m748a("This page is currently being used to test components.");
        this.f671h.setPadding(0, 5, 0, 5);
        this.f671h.setVisibility(8);
        a.addView(this.f671h);
        this.f673j.addView(a);
        a = new EditText(context);
        a.setInputType(3);
        a.setLayoutParams(new LayoutParams(-1, -2));
        a.setHint(C0925h.m680a("ANDROID_enter_code"));
        a.setSingleLine(true);
        a.setId(8001);
        a.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.f673j.addView(a);
        a = new EditText(context);
        a.setInputType(3);
        a.setLayoutParams(new LayoutParams(-1, -2));
        a.setHint(C0925h.m680a("ANDROID_reenter_code"));
        a.setSingleLine(true);
        a.setId(8002);
        a.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.f673j.addView(a);
        a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setGravity(1);
        this.f669f = new Button(context);
        this.f669f.setText(C0925h.m680a("ANDROID_create"));
        this.f669f.setLayoutParams(new LinearLayout.LayoutParams(-1, C0921d.m669b(), 0.5f));
        this.f669f.setGravity(17);
        this.f669f.setBackgroundDrawable(C0922e.m671a());
        this.f669f.setTextColor(-16777216);
        this.f669f.setOnClickListener(this);
        View a2 = C0921d.m667a(context, -1, -2);
        a2.setOrientation(1);
        a2.setGravity(1);
        a2.addView(this.f669f);
        a2.setPadding(0, 15, 0, 15);
        a.addView(a2);
        this.f667d = new Button(context);
        this.f667d.setText(C0925h.m680a("ANDROID_cancel"));
        this.f667d.setLayoutParams(new LinearLayout.LayoutParams(-1, C0921d.m669b(), 0.5f));
        this.f667d.setGravity(17);
        this.f667d.setBackgroundDrawable(C0922e.m673b());
        this.f667d.setTextColor(-16777216);
        this.f667d.setOnClickListener(this);
        a.addView(this.f667d);
        this.f673j.addView(a);
        addView(this.f673j);
        this.f674k = new LinearLayout(context);
        this.f674k.setOrientation(1);
        this.f674k.setLayoutParams(new LayoutParams(-1, -1));
        this.f674k.setPadding(5, 5, 5, 5);
        this.f674k.setBackgroundDrawable(C0921d.m665a());
        this.f674k.addView(new C0941h(C0925h.m680a("ANDROID_review"), context));
        a = new LinearLayout(context);
        a.setOrientation(1);
        a.setBackgroundDrawable(C0921d.m666a(-1, -1510918, -7829368));
        a.setPadding(10, 10, 10, 10);
        this.f674k.addView(a);
        a2 = new TextView(context);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        a2.setBackgroundColor(0);
        a2.setTextColor(-7829368);
        a2.setGravity(3);
        a2.setTypeface(Typeface.create("Helvetica", 1));
        a2.setTextSize(12.0f);
        a2.setText(C0925h.m680a("ANDROID_payment_method"));
        a.addView(a2);
        a2 = new LinearLayout(context);
        a2.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        a2.setOrientation(0);
        a.addView(a2);
        a = new TextView(context);
        a.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        a.setBackgroundColor(0);
        a.setTextColor(-16777216);
        a.setGravity(3);
        a.setTypeface(Typeface.create("Helvetica", 0));
        a.setTextSize(12.0f);
        a.setText(C0925h.m680a("ANDROID_primary_source") + ":");
        a2.addView(a);
        a = new TextView(context);
        a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        a.setBackgroundColor(0);
        a.setTextColor(-16777216);
        a.setGravity(5);
        a.setTypeface(Typeface.create("Helvetica", 0));
        a.setTextSize(12.0f);
        a.setText(C0925h.m680a("ANDROID_paypal_balance"));
        a2.addView(a);
        a = new TextView(context);
        a.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        a.setBackgroundColor(0);
        a.setTextColor(-16777216);
        a.setGravity(3);
        a.setTypeface(Typeface.create("Helvetica", 0));
        a.setTextSize(12.0f);
        a.setPadding(10, 10, 10, 10);
        String str = C0925h.m680a("ANDROID_preapproval_agreement").replace("%m", preapproval.getMerchantName()) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + C0925h.m680a("ANDROID_view_policies");
        CharSequence spannableString = new SpannableString(str);
        spannableString.setSpan(new UnderlineSpan(), str.indexOf(C0925h.m680a("ANDROID_view_policies")), spannableString.length(), 0);
        spannableString.setSpan(new URLSpan(new String("https://www.paypal.com/" + PayPalActivity._paypal.getLanguage().substring(0, 2) + "/cgi-bin/webscr?cmd=xpt/Marketing/popup/FundingMixEducation-outside")), str.indexOf(C0925h.m680a("ANDROID_view_policies")), spannableString.length(), 33);
        Linkify.addLinks(spannableString, Pattern.compile(C0925h.m680a("ANDROID_view_policies")), "https://");
        a.setText(spannableString);
        a.setMovementMethod(LinkMovementMethod.getInstance());
        this.f674k.addView(a);
        a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setPadding(5, 10, 5, 10);
        this.f670g = new C0944i(context, C0943a.YELLOW_ALERT);
        this.f670g.m748a("This page is currently being used to test components.");
        this.f670g.setPadding(0, 5, 0, 5);
        this.f670g.setVisibility(8);
        a.addView(this.f670g);
        this.f674k.addView(a);
        a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setGravity(1);
        this.f666c = new Button(context);
        if (PayPal.getInstance().getPreapproval().getType() == 1) {
            this.f666c.setText(C0925h.m680a("ANDROID_agree_pay"));
        } else {
            this.f666c.setText(C0925h.m680a("ANDROID_agree"));
        }
        this.f666c.setLayoutParams(new LinearLayout.LayoutParams(-1, C0921d.m669b(), 0.5f));
        this.f666c.setGravity(17);
        this.f666c.setBackgroundDrawable(C0922e.m671a());
        this.f666c.setTextColor(-16777216);
        this.f666c.setOnClickListener(this);
        a2 = C0921d.m667a(context, -1, -2);
        a2.setOrientation(1);
        a2.setGravity(1);
        a2.addView(this.f666c);
        a2.setPadding(0, 15, 0, 15);
        a.addView(a2);
        this.f668e = new Button(context);
        this.f668e.setText(C0925h.m680a("ANDROID_cancel"));
        this.f668e.setLayoutParams(new LinearLayout.LayoutParams(-1, C0921d.m669b(), 0.5f));
        this.f668e.setGravity(17);
        this.f668e.setBackgroundDrawable(C0922e.m673b());
        this.f668e.setTextColor(-16777216);
        this.f668e.setOnClickListener(this);
        a.addView(this.f668e);
        this.f674k.addView(a);
        addView(this.f674k);
        this.f675l = new RelativeLayout(context);
        this.f675l.setLayoutParams(new LayoutParams(-1, -1));
        this.f675l.setBackgroundDrawable(C0921d.m665a());
        a2 = C0921d.m667a(context, -1, -2);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(a2.getLayoutParams());
        layoutParams.addRule(13);
        a2.setLayoutParams(layoutParams);
        a2.setOrientation(1);
        a2.setGravity(1);
        if (f663n == null) {
            f663n = new C0939e(context);
        } else {
            ((LinearLayout) f663n.getParent()).removeAllViews();
        }
        this.f676m = C0934o.m736a(C0933a.HELVETICA_16_NORMAL, context);
        this.f676m.setGravity(1);
        this.f676m.setTextColor(-13408615);
        this.f676m.setText(C0925h.m680a("ANDROID_processing_transaction_message"));
        a2.addView(f663n);
        a2.addView(this.f676m);
        this.f675l.addView(a2);
        this.f675l.setVisibility(8);
        addView(this.f675l);
        if (preapproval.getPinRequired()) {
            this.f674k.setVisibility(8);
        } else {
            this.f673j.setVisibility(8);
        }
    }

    public final void m500a(C0897a c0897a, int i) {
    }

    public final void m501a(C0893g c0893g, int i) {
        if (i == 1 && this.f665b != null && c0893g != this.f665b) {
            this.f665b.m521a(0);
        }
    }

    public final void m502a(String str, Object obj) {
    }

    public final void m503b() {
        if (this.f664a == C0887a.STATE_CONFIRM_PREAPPROVAL) {
            this.f665b.m545a(false, true);
            this.f673j.setVisibility(8);
            this.f674k.setVisibility(8);
            this.f675l.setVisibility(0);
            f663n.m742a();
        } else if (this.f664a == C0887a.STATE_PIN || this.f664a == C0887a.STATE_REVIEW || this.f664a == C0887a.STATE_ERROR) {
            this.f665b.m545a(true, false);
            f663n.m743b();
            this.f675l.setVisibility(8);
            if (this.f664a == C0887a.STATE_PIN) {
                this.f673j.setVisibility(0);
                this.f674k.setVisibility(8);
            } else if (this.f664a == C0887a.STATE_REVIEW) {
                this.f673j.setVisibility(8);
                this.f674k.setVisibility(0);
            } else if (this.f674k.getVisibility() == 0) {
                this.f670g.m748a(this.f672i);
                this.f670g.setVisibility(0);
            } else {
                this.f671h.m748a(this.f672i);
                this.f671h.setVisibility(0);
            }
        }
    }

    public final C0887a m504c() {
        return this.f664a;
    }

    public final void m505d(String str) {
        if (this.f664a == C0887a.STATE_CONFIRM_PREAPPROVAL) {
            this.f672i = str;
            m496a(C0887a.STATE_ERROR);
        }
    }

    public final void m506l() {
    }

    public final void onClick(View view) {
        int i = 0;
        if (this.f667d == view || this.f668e == view) {
            new C0902f(PayPalActivity.getInstance()).show();
        } else if (this.f666c == view) {
            m496a(C0887a.STATE_CONFIRM_PREAPPROVAL);
            if (PayPal.getInstance().getServer() == 2) {
                PayPalActivity.getInstance().paymentSucceeded("Demo Preapproval Key", "COMPLETED", true);
                return;
            }
            C0919b.m619e().m656a("delegate", (Object) this);
            C0919b.m619e().m653a(14);
        } else if (this.f669f == view) {
            try {
                ((InputMethodManager) PayPalActivity.getInstance().getSystemService("input_method")).hideSoftInputFromWindow(findViewById(8001).getWindowToken(), 0);
            } catch (Exception e) {
            }
            try {
                ((InputMethodManager) PayPalActivity.getInstance().getSystemService("input_method")).hideSoftInputFromWindow(findViewById(8002).getWindowToken(), 0);
            } catch (Exception e2) {
            }
            Editable text = ((EditText) findViewById(8001)).getText();
            Editable text2 = ((EditText) findViewById(8002)).getText();
            Object obj = text.toString();
            String obj2 = text2.toString();
            int i2 = (obj == null || obj2 == null) ? true : 0;
            if (!obj.equals(obj2)) {
                i2 = true;
            }
            if (obj.length() < 4 || obj.length() > 8) {
                i2 = true;
            }
            while (i < obj.length()) {
                if (obj.charAt(i) < '0' || obj.charAt(i) > '9') {
                    i2 = true;
                }
                i++;
            }
            if (i2 != 0) {
                this.f672i = C0925h.m680a("ANDROID_pin_invalid");
                m496a(C0887a.STATE_ERROR);
                return;
            }
            C0919b.m619e().m656a("Pin", obj);
            m496a(C0887a.STATE_REVIEW);
        }
    }
}
