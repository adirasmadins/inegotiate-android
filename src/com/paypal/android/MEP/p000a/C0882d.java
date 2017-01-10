package com.paypal.android.MEP.p000a;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.amazonaws.services.s3.internal.Mimetypes;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.C0890a;
import com.paypal.android.MEP.C0890a.C0869b;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.PayPalPreapproval;
import com.paypal.android.MEP.p002b.C0898b;
import com.paypal.android.MEP.p002b.C0901e;
import com.paypal.android.MEP.p002b.C0902f;
import com.paypal.android.p001b.C0872j;
import com.paypal.android.p001b.C0893g;
import com.paypal.android.p001b.C0893g.C0874a;
import com.paypal.android.p001b.C0936a;
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
import com.paypal.android.p003a.p004a.C0906a;
import com.paypal.android.p003a.p004a.C0908c;
import com.paypal.android.p003a.p004a.C0912g;
import com.paypal.android.p003a.p004a.C0913h;
import com.paypal.android.p003a.p004a.C0916k;
import java.util.Hashtable;
import java.util.Vector;
import org.codehaus.jackson.io.CharacterEscapes;

/* renamed from: com.paypal.android.MEP.a.d */
public final class C0882d extends C0872j implements TextWatcher, OnClickListener, C0869b, C0874a {
    public static boolean f618a;
    private static C0939e f619l;
    private C0880a f620b;
    private Button f621c;
    private Button f622d;
    private Button f623e;
    private TextView f624f;
    private C0898b f625g;
    private C0944i f626h;
    private C0944i f627i;
    private LinearLayout f628j;
    private RelativeLayout f629k;
    private TextView f630m;
    private C0901e f631n;
    private C0936a f632o;
    private WebView f633p;
    private String f634q;
    private Hashtable<String, Object> f635r;

    /* renamed from: com.paypal.android.MEP.a.d.1 */
    static /* synthetic */ class C08791 {
        public static void m463a() {
            if (PayPalActivity.getInstance() != null) {
                PayPalActivity.getInstance().sendBroadcast(new Intent(PayPalActivity._popIntent));
            }
        }

        public static void m464a(int i) {
            if (i < 0 || i >= 9) {
                throw new IllegalArgumentException("Attempted to push an unknown dialog.");
            } else if (PayPalActivity.getInstance() != null) {
                PayPalActivity.getInstance().sendBroadcast(new Intent(PayPalActivity._pushIntent + i));
            }
        }

        public static void m465b() {
            if (PayPalActivity.getInstance() != null) {
                PayPalActivity.getInstance().sendBroadcast(new Intent(PayPalActivity._updateIntent));
            }
        }

        public static void m466b(int i) {
            if (PayPalActivity.getInstance() != null) {
                PayPalActivity.getInstance().sendBroadcast(new Intent(PayPalActivity._replaceIntent + i));
            }
        }
    }

    /* renamed from: com.paypal.android.MEP.a.d.a */
    public enum C0880a {
        STATE_NORMAL,
        STATE_LOGGING_IN,
        STATE_ERROR,
        STATE_LOGGING_OUT
    }

    /* renamed from: com.paypal.android.MEP.a.d.b */
    private class C0881b extends WebViewClient {
        private /* synthetic */ C0882d f617a;

        private C0881b(C0882d c0882d, byte b) {
            this.f617a = c0882d;
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (str.equals("About.Quick.Pay")) {
                this.f617a.onClick(this.f617a.f633p);
            }
            return true;
        }
    }

    static {
        f619l = null;
        f618a = false;
    }

    public C0882d(Context context) {
        super(context);
        this.f635r = new Hashtable();
    }

    private void m468d() {
        Object obj = 1;
        String a = this.f631n.m550a();
        String b = this.f631n.m551b();
        Object obj2 = (C0925h.m686d(a) || C0925h.m687e(a)) ? 1 : null;
        if (b == null || b.length() <= 0) {
            obj = null;
        }
        if (obj2 != null && r0 != null) {
            this.f631n.m553d().setText(StringUtil.EMPTY_STRING);
            m473a(C0880a.STATE_LOGGING_IN);
            C0890a.m511a().m513a(this, a, b);
        }
    }

    private boolean m469e() {
        String a = this.f631n.m550a();
        String b = this.f631n.m551b();
        boolean z = C0925h.m686d(a) || C0925h.m687e(a);
        boolean z2 = b != null && b.length() > 0;
        return z && z2;
    }

    public final void m470a() {
        m476b();
    }

    public final void m471a(int i, Object obj) {
        C0919b e = C0919b.m619e();
        if (this.f620b == C0880a.STATE_LOGGING_IN) {
            switch (i) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                    e.m656a("currentUser", this.f631n.m550a());
                    if (PayPal.getInstance().getPayType() == 3) {
                        e.m662j();
                    } else {
                        e.m661i();
                    }
                default:
            }
        }
    }

    protected final void m472a(Context context) {
        View a;
        PayPal instance = PayPal.getInstance();
        super.m440a(context);
        this.f620b = C0880a.STATE_NORMAL;
        View a2 = C0921d.m667a(context, -1, -2);
        a2.setOrientation(1);
        a2.setPadding(5, 5, 5, 15);
        a2.addView(C0934o.m737b(C0933a.HELVETICA_16_BOLD, context));
        this.f625g = new C0898b(context, this);
        this.f625g.m517a((C0874a) this);
        a2.addView(this.f625g);
        if (instance.getPayType() == 3) {
            this.f625g.m545a(false, true);
        } else if (!instance.canShowCart()) {
            this.f625g.m545a(false, false);
        }
        addView(a2);
        this.f628j = new LinearLayout(context);
        this.f628j.setOrientation(1);
        this.f628j.setLayoutParams(new LayoutParams(-1, -1));
        this.f628j.setBackgroundDrawable(C0921d.m665a());
        this.f628j.setPadding(10, 5, 10, 5);
        this.f628j.addView(new C0941h(C0925h.m680a("ANDROID_login"), context));
        this.f626h = new C0944i(context, C0943a.RED_ALERT);
        this.f626h.m748a("Placeholder");
        this.f626h.setVisibility(8);
        this.f626h.setPadding(0, 5, 0, 5);
        this.f628j.addView(this.f626h);
        this.f627i = new C0944i(context, C0943a.BLUE_ALERT);
        this.f627i.m748a(C0925h.m680a("ANDROID_not_you_message"));
        this.f627i.setVisibility(8);
        this.f627i.setPadding(0, 5, 0, 5);
        this.f628j.addView(this.f627i);
        this.f631n = new C0901e(context);
        this.f631n.m552c().addTextChangedListener(this);
        this.f631n.m553d().addTextChangedListener(this);
        this.f628j.addView(this.f631n);
        a2 = C0921d.m667a(context, -1, -2);
        a2.setOrientation(0);
        a2.setGravity(16);
        a2.setPadding(5, 5, 5, 0);
        this.f632o = new C0936a(context);
        this.f632o.setChecked(instance.getIsRememberMe());
        this.f632o.setOnClickListener(this);
        if (instance.getAuthSetting() == 1) {
            a2.addView(this.f632o);
        }
        this.f633p = new WebView(context);
        this.f633p.setWebViewClient(new C0881b());
        this.f633p.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        this.f633p.setBackgroundColor(0);
        this.f633p.loadData("<html><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"><head><style type=\"text/css\">b {color:#1B3664; font-family:Helvetica; font-size:12;}a {color:#686868; font-family:Helvetica; font-size:12;}</style></head><body><b>" + C0925h.m680a("ANDROID_checkbox_opt_in") + "</b>" + "  " + "<a href=\"About.Quick.Pay\">" + C0925h.m680a("ANDROID_checkbox_whats_this") + "</a>" + "</body>" + "</html>", Mimetypes.MIMETYPE_HTML, "utf-8");
        if (instance.getAuthSetting() == 1) {
            a2.addView(this.f633p);
        }
        this.f628j.addView(a2);
        a2 = C0921d.m667a(context, -1, -2);
        a2.setPadding(5, 5, 5, 5);
        a2.setOrientation(0);
        a2.setGravity(1);
        if (instance.getPayType() == 3 || instance.getShippingEnabled() || instance.isPersonalPayment()) {
            this.f622d = null;
            this.f623e = new Button(context);
            this.f623e.setLayoutParams(new LinearLayout.LayoutParams(-1, C0921d.m669b()));
            this.f623e.setId(184424834);
            this.f623e.setText(C0925h.m680a("ANDROID_login"));
            this.f623e.setTextColor(-16777216);
            this.f623e.setBackgroundDrawable(C0922e.m671a());
            this.f623e.setOnClickListener(this);
            this.f623e.setEnabled(false);
            a2.addView(this.f623e);
        } else {
            a = C0921d.m667a(context, -1, -2);
            a.setOrientation(1);
            a.setPadding(5, 0, 5, 5);
            View a3 = C0934o.m736a(C0933a.HELVETICA_10_NORMAL, context);
            a3.setTextColor(-16777216);
            a3.setText(C0925h.m680a("ANDROID_review_text"));
            a3.setGravity(3);
            a.addView(a3);
            this.f628j.addView(a);
            this.f622d = new Button(context);
            ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, C0921d.m669b(), 0.5f);
            layoutParams.setMargins(0, 0, 5, 0);
            this.f622d.setLayoutParams(layoutParams);
            if (instance.getTextType() == 1) {
                this.f622d.setText(C0925h.m680a("ANDROID_donate"));
            } else {
                this.f622d.setText(C0925h.m680a("ANDROID_pay"));
            }
            this.f622d.setTextColor(-16777216);
            this.f622d.setBackgroundDrawable(C0922e.m671a());
            this.f622d.setOnClickListener(this);
            this.f622d.setEnabled(false);
            a2.addView(this.f622d);
            this.f623e = new Button(context);
            layoutParams = new LinearLayout.LayoutParams(-1, C0921d.m669b(), 0.5f);
            layoutParams.setMargins(5, 0, 0, 0);
            this.f623e.setLayoutParams(layoutParams);
            this.f623e.setId(184424834);
            this.f623e.setText(C0925h.m680a("ANDROID_review"));
            this.f623e.setTextColor(-16777216);
            this.f623e.setBackgroundDrawable(C0922e.m673b());
            this.f623e.setOnClickListener(this);
            this.f623e.setEnabled(false);
            a2.addView(this.f623e);
        }
        this.f628j.addView(a2);
        a2 = C0921d.m667a(context, -1, -2);
        a2.setPadding(5, 5, 5, 5);
        a2.setOrientation(0);
        a2.setGravity(1);
        this.f621c = new Button(context);
        this.f621c.setLayoutParams(new LinearLayout.LayoutParams(-1, C0921d.m669b()));
        this.f621c.setText(C0925h.m680a("ANDROID_cancel"));
        this.f621c.setTextColor(-16777216);
        this.f621c.setBackgroundDrawable(C0922e.m673b());
        this.f621c.setOnClickListener(this);
        a2.addView(this.f621c);
        this.f628j.addView(a2);
        this.f624f = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
        this.f624f.setLayoutParams(new LayoutParams(-1, -2));
        this.f624f.setPadding(10, 10, 10, 10);
        this.f624f.setTextColor(-16776961);
        this.f624f.setGravity(17);
        this.f624f.setOnClickListener(this);
        CharSequence spannableString = new SpannableString(C0925h.m680a("ANDROID_help"));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        this.f624f.setText(spannableString);
        this.f624f.setFocusable(true);
        this.f628j.addView(this.f624f);
        this.f628j.invalidate();
        addView(this.f628j);
        this.f629k = new RelativeLayout(context);
        this.f629k.setLayoutParams(new LayoutParams(-1, -1));
        this.f629k.setBackgroundDrawable(C0921d.m665a());
        a = C0921d.m667a(context, -1, -2);
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(a.getLayoutParams());
        layoutParams2.addRule(13);
        a.setLayoutParams(layoutParams2);
        a.setOrientation(1);
        a.setGravity(1);
        if (f619l == null) {
            f619l = new C0939e(context);
        } else {
            ((LinearLayout) f619l.getParent()).removeAllViews();
        }
        this.f630m = C0934o.m736a(C0933a.HELVETICA_16_NORMAL, context);
        this.f630m.setGravity(1);
        this.f630m.setTextColor(-13408615);
        this.f630m.setText(C0925h.m680a("ANDROID_logging_in_message"));
        a.addView(f619l);
        a.addView(this.f630m);
        this.f629k.addView(a);
        this.f629k.setVisibility(8);
        addView(this.f629k);
        if (instance.getIsRememberMe()) {
            m473a(C0880a.STATE_LOGGING_IN);
            this.f631n.m553d().setText(StringUtil.EMPTY_STRING);
            C0919b.m619e().m656a("delegate", (Object) this);
            C0919b.m619e().m656a("quickPay", (Object) "false");
            C0919b.m619e().m653a(10);
        }
        if (f618a) {
            m473a(C0880a.STATE_ERROR);
        }
    }

    public final void m473a(C0880a c0880a) {
        this.f620b = c0880a;
        C08791.m465b();
    }

    public final void m474a(C0893g c0893g, int i) {
    }

    public final void m475a(String str, Object obj) {
        this.f635r.put(str, obj);
    }

    public final void afterTextChanged(Editable editable) {
        if (this.f631n.m552c().getText().length() <= 0 || this.f631n.m553d().getText().length() <= 0) {
            if (this.f623e != null) {
                this.f623e.setEnabled(false);
            }
            if (this.f622d != null) {
                this.f622d.setEnabled(false);
            }
        } else {
            if (this.f623e != null) {
                this.f623e.setEnabled(true);
            }
            if (this.f622d != null) {
                this.f622d.setEnabled(true);
            }
        }
        m476b();
    }

    public final void m476b() {
        if (this.f620b == C0880a.STATE_LOGGING_IN || this.f620b == C0880a.STATE_LOGGING_OUT) {
            this.f625g.m545a(false, true);
            this.f628j.setVisibility(8);
            this.f629k.setVisibility(0);
            f619l.m742a();
        } else if (this.f620b == C0880a.STATE_NORMAL || this.f620b == C0880a.STATE_ERROR) {
            if (PayPal.getInstance().canShowCart()) {
                this.f625g.m545a(true, false);
            }
            f619l.m743b();
            this.f629k.setVisibility(8);
            this.f628j.setVisibility(0);
            if (this.f620b != C0880a.STATE_ERROR) {
                return;
            }
            if (f618a) {
                this.f627i.setVisibility(0);
                this.f626h.setVisibility(8);
                return;
            }
            this.f627i.setVisibility(8);
            this.f626h.setVisibility(0);
            this.f626h.m748a(this.f634q);
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final C0880a m477c() {
        return this.f620b;
    }

    public final void m478d(String str) {
        f618a = false;
        this.f634q = str;
        if (this.f620b == C0880a.STATE_LOGGING_IN) {
            m473a(C0880a.STATE_ERROR);
        } else if (this.f620b == C0880a.STATE_LOGGING_OUT) {
            m473a(C0880a.STATE_ERROR);
        }
    }

    public final void m479l() {
        C0919b.m619e().m656a("usernameOrPhone", this.f635r.get("usernameOrPhone"));
        C0919b.m619e().m656a("passwordOrPin", this.f635r.get("passwordOrPin"));
        C0919b.m619e().m656a("delegate", (Object) this);
        C0919b.m619e().m653a(0);
    }

    public final void onClick(View view) {
        C0919b e = C0919b.m619e();
        PayPal instance = PayPal.getInstance();
        Context instance2 = PayPalActivity.getInstance();
        if (view == this.f632o) {
            instance.setIsRememberMe(this.f632o.isChecked());
        } else if (view == this.f633p) {
            C08791.m464a(1);
        } else if (view == this.f622d) {
            if (m469e()) {
                m473a(C0880a.STATE_NORMAL);
                this.f631n.m554e();
                if (instance.getServer() == 2) {
                    instance2.paymentSucceeded("27892", (String) e.m657c("PaymentExecStatus"), true);
                    return;
                }
                e.m656a("quickPay", (Object) "true");
                m468d();
            }
        } else if (view == this.f623e) {
            if (m469e()) {
                m473a(C0880a.STATE_NORMAL);
                this.f631n.m554e();
                if (instance.getServer() == 2) {
                    if (instance.getPayType() == 3) {
                        PayPalPreapproval preapproval = instance.getPreapproval();
                        preapproval.setStartDate("2011-07-06T23:59:49.000-07:00");
                        preapproval.setEndDate("2011-08-07T23:59:49.000-07:00");
                        preapproval.setPinRequired(true);
                    }
                    C0875a.f590a = new Hashtable();
                    Vector vector = new Vector();
                    Vector vector2 = new Vector();
                    C0908c c0908c = new C0908c();
                    c0908c.m562a("0");
                    c0908c.f745a = new C0906a();
                    c0908c.f745a.m559b("USD");
                    c0908c.f745a.m557a("2.00");
                    c0908c.f748d = new Vector();
                    C0916k c0916k = new C0916k();
                    c0916k.f783a = new C0906a();
                    c0916k.f783a.m559b("USD");
                    c0916k.f783a.m557a("2.00");
                    c0916k.f784b = new C0912g();
                    c0916k.f784b.m567a("2093");
                    c0916k.f784b.m569b("BANK_INSTANT");
                    c0908c.f748d.add(c0916k);
                    vector.add(c0908c);
                    c0908c = new C0908c();
                    c0908c.m562a("1");
                    c0908c.f745a = new C0906a();
                    c0908c.f745a.m559b("USD");
                    c0908c.f745a.m557a("2.00");
                    c0908c.f748d = new Vector();
                    c0916k = new C0916k();
                    c0916k.f783a = new C0906a();
                    c0916k.f783a.m559b("USD");
                    c0916k.f783a.m557a("2.00");
                    c0916k.f784b = new C0912g();
                    c0916k.f784b.m567a("9853");
                    c0916k.f784b.m569b("CREDITCARD");
                    c0908c.f748d.add(c0916k);
                    vector.add(c0908c);
                    c0908c = new C0908c();
                    c0908c.m562a("2");
                    c0908c.f745a = new C0906a();
                    c0908c.f745a.m559b("USD");
                    c0908c.f745a.m557a("2.00");
                    c0908c.f748d = new Vector();
                    c0916k = new C0916k();
                    c0916k.f783a = new C0906a();
                    c0916k.f783a.m559b("USD");
                    c0916k.f783a.m557a("2.00");
                    c0916k.f784b = new C0912g();
                    c0916k.f784b.m567a("9691");
                    c0916k.f784b.m569b("CREDITCARD");
                    c0908c.f748d.add(c0916k);
                    vector.add(c0908c);
                    C0875a.f590a.put("FundingPlanId", "0");
                    C0875a.f590a.put("FundingPlans", vector);
                    C0913h c0913h = new C0913h();
                    c0913h.m572a("Trenton");
                    c0913h.m577c("123 Home St");
                    c0913h.m579d("Apt B");
                    c0913h.m581e("08601");
                    c0913h.m583f("NJ");
                    c0913h.m585g("1");
                    c0913h.m575b("US");
                    vector2.add(c0913h);
                    c0913h = new C0913h();
                    c0913h.m572a("Hamlin");
                    c0913h.m577c("3012 Church Rd");
                    c0913h.m579d(StringUtil.EMPTY_STRING);
                    c0913h.m581e("14464");
                    c0913h.m583f("NY");
                    c0913h.m585g("2");
                    c0913h.m575b("US");
                    vector2.add(c0913h);
                    C0875a.f590a.put("ShippingAddressId", "1");
                    C0875a.f590a.put("AvailableAddresses", vector2);
                    PayPalActivity.getInstance().sendBroadcast(new Intent(PayPalActivity.LOGIN_SUCCESS));
                    return;
                }
                e.m656a("quickPay", (Object) "false");
                m468d();
            }
        } else if (view == this.f621c) {
            new C0902f(instance2).show();
        } else if (view == this.f624f) {
            C08791.m464a(2);
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
