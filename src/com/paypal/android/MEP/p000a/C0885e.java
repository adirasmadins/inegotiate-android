package com.paypal.android.MEP.p000a;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.C0890a;
import com.paypal.android.MEP.C0890a.C0869b;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.p000a.C0882d.C08791;
import com.paypal.android.MEP.p002b.C0898b;
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
import java.util.Hashtable;

/* renamed from: com.paypal.android.MEP.a.e */
public final class C0885e extends C0872j implements TextWatcher, OnClickListener, C0869b, C0874a {
    public static String f640a;
    private static C0939e f641l;
    private C0884a f642b;
    private String f643c;
    private LinearLayout f644d;
    private RelativeLayout f645e;
    private C0898b f646f;
    private EditText f647g;
    private EditText f648h;
    private EditText f649i;
    private Button f650j;
    private Button f651k;
    private TextView f652m;
    private Hashtable<String, Object> f653n;
    private C0944i f654o;
    private LinearLayout f655p;
    private Context f656q;

    /* renamed from: com.paypal.android.MEP.a.e.1 */
    class C08831 implements Runnable {
        C08831(C0885e c0885e) {
        }

        public final void run() {
            long currentTimeMillis = System.currentTimeMillis();
            float f = 0.0f;
            while (f < 3.0f) {
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
                long currentTimeMillis2 = System.currentTimeMillis();
                f = (((float) (currentTimeMillis2 - currentTimeMillis)) / 1000.0f) + f;
                currentTimeMillis = currentTimeMillis2;
            }
            C0885e.f641l.m743b();
            PayPalActivity.getInstance().paymentSucceeded((String) C0919b.m619e().m657c("PayKey"), (String) C0919b.m619e().m657c("PaymentExecStatus"), true);
        }
    }

    /* renamed from: com.paypal.android.MEP.a.e.a */
    public enum C0884a {
        STATE_NORMAL,
        STATE_ERROR,
        STATE_PIN_SUCCESS
    }

    static {
        f641l = null;
        f640a = null;
    }

    public C0885e(Context context) {
        super(context);
    }

    private void m480a(String str, boolean z) {
        View a = C0921d.m667a(this.f656q, -1, -2);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.getLayoutParams());
        layoutParams.addRule(13);
        a.setLayoutParams(layoutParams);
        a.setOrientation(1);
        a.setGravity(1);
        if (f641l == null) {
            f641l = new C0939e(this.f656q);
        } else {
            ((LinearLayout) f641l.getParent()).removeAllViews();
        }
        this.f652m = C0934o.m736a(C0933a.HELVETICA_16_NORMAL, this.f656q);
        this.f652m.setGravity(1);
        this.f652m.setTextColor(-13408615);
        this.f652m.setText(str);
        if (z) {
            View a2 = C0921d.m667a(this.f656q, -2, -2);
            a2.setOrientation(1);
            a2.setPadding(5, 10, 5, 10);
            View c0944i = new C0944i(this.f656q, C0943a.GREEN_ALERT);
            c0944i.m748a(C0925h.m680a("ANDROID_pin_success"));
            c0944i.setPadding(5, 5, 5, 5);
            a2.addView(c0944i);
            a.addView(a2);
        }
        a.addView(f641l);
        a.addView(this.f652m);
        this.f645e.removeAllViews();
        this.f645e.addView(a);
    }

    private boolean m482d() {
        return this.f647g.getText().toString().length() < 9 ? false : C0925h.m687e(this.f647g.getText().toString());
    }

    private boolean m483e() {
        String obj = this.f648h.getText().toString();
        String obj2 = this.f649i.getText().toString();
        return (obj.length() < 4 || obj.length() > 8 || obj2.length() < 4 || obj2.length() > 8 || !obj.equals(obj2)) ? false : C0925h.m688f(obj);
    }

    private void m484f() {
        try {
            ((InputMethodManager) PayPalActivity.getInstance().getSystemService("input_method")).hideSoftInputFromWindow(this.f647g.getWindowToken(), 0);
        } catch (Exception e) {
        }
        try {
            ((InputMethodManager) PayPalActivity.getInstance().getSystemService("input_method")).hideSoftInputFromWindow(this.f648h.getWindowToken(), 0);
        } catch (Exception e2) {
        }
        try {
            ((InputMethodManager) PayPalActivity.getInstance().getSystemService("input_method")).hideSoftInputFromWindow(this.f649i.getWindowToken(), 0);
        } catch (Exception e3) {
        }
    }

    public final void m485a() {
    }

    public final void m486a(int i, Object obj) {
        this.f642b = C0884a.STATE_PIN_SUCCESS;
        C08791.m465b();
    }

    public final void m487a(Context context) {
        super.m440a(context);
        this.f656q = context;
        this.f642b = C0884a.STATE_NORMAL;
        View a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setPadding(5, 5, 5, 15);
        a.addView(C0934o.m737b(C0933a.HELVETICA_16_BOLD, context));
        this.f646f = new C0898b(context, this);
        this.f646f.m517a((C0874a) this);
        a.addView(this.f646f);
        addView(a);
        this.f644d = C0921d.m667a(context, -1, -1);
        this.f644d.setOrientation(1);
        this.f644d.setPadding(10, 5, 10, 5);
        this.f644d.setBackgroundDrawable(C0921d.m665a());
        this.f644d.addView(new C0941h(C0925h.m680a("ANDROID_payment_made"), context));
        this.f655p = C0921d.m667a(context, -1, -2);
        this.f655p.setOrientation(1);
        this.f655p.setPadding(5, 10, 5, 10);
        this.f654o = new C0944i(context, C0943a.YELLOW_ALERT);
        this.f654o.m748a("This page is currently being used to test components.");
        this.f654o.setPadding(0, 5, 0, 5);
        this.f655p.setVisibility(8);
        this.f655p.addView(this.f654o);
        this.f644d.addView(this.f655p);
        a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setPadding(5, 0, 5, 5);
        View a2 = C0934o.m736a(C0933a.HELVETICA_16_BOLD, context);
        a2.setTextColor(-14993820);
        a2.setText(C0925h.m680a("ANDROID_create_a_pin"));
        a2.setGravity(3);
        a.addView(a2);
        this.f644d.addView(a);
        a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setPadding(10, 10, 10, 5);
        a.setBackgroundDrawable(C0921d.m665a());
        this.f647g = new EditText(context);
        this.f647g.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.f647g.setInputType(3);
        this.f647g.setHint(C0925h.m680a("ANDROID_enter_mobile"));
        this.f647g.setSingleLine(true);
        this.f647g.addTextChangedListener(this);
        a.addView(this.f647g);
        this.f648h = new EditText(context);
        this.f648h.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.f648h.setInputType(3);
        this.f648h.setHint(C0925h.m680a("ANDROID_enter_pin"));
        this.f648h.setSingleLine(true);
        this.f648h.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.f648h.addTextChangedListener(this);
        a.addView(this.f648h);
        this.f649i = new EditText(context);
        this.f649i.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        this.f649i.setInputType(3);
        this.f649i.setHint(C0925h.m680a("ANDROID_reenter_pin"));
        this.f649i.setSingleLine(true);
        this.f649i.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.f649i.addTextChangedListener(this);
        a.addView(this.f649i);
        this.f644d.addView(a);
        a = C0921d.m667a(context, -1, -2);
        a.setGravity(1);
        a.setOrientation(1);
        a.setPadding(5, 10, 5, 5);
        this.f650j = new Button(context);
        this.f650j.setLayoutParams(new RelativeLayout.LayoutParams(-1, C0921d.m669b()));
        this.f650j.setText(C0925h.m680a("ANDROID_create_pin"));
        this.f650j.setTextColor(-16777216);
        this.f650j.setBackgroundDrawable(C0922e.m671a());
        this.f650j.setOnClickListener(this);
        this.f650j.setEnabled(false);
        a.addView(this.f650j);
        this.f644d.addView(a);
        a = C0921d.m667a(context, -1, -2);
        a.setGravity(1);
        a.setOrientation(1);
        a.setPadding(5, 5, 5, 10);
        this.f651k = new Button(context);
        this.f651k.setLayoutParams(new RelativeLayout.LayoutParams(-1, C0921d.m669b()));
        this.f651k.setText(C0925h.m680a("ANDROID_skip"));
        this.f651k.setTextColor(-16777216);
        this.f651k.setBackgroundDrawable(C0922e.m673b());
        this.f651k.setOnClickListener(this);
        a.addView(this.f651k);
        this.f644d.addView(a);
        addView(this.f644d);
        this.f645e = new RelativeLayout(context);
        this.f645e.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f645e.setBackgroundDrawable(C0921d.m665a());
        m480a(C0925h.m680a("ANDROID_creating_pin"), false);
        this.f645e.setVisibility(8);
        addView(this.f645e);
        this.f653n = new Hashtable();
        if (!PayPal.getInstance().canShowCart()) {
            this.f646f.m545a(false, false);
        }
    }

    public final void m488a(C0893g c0893g, int i) {
    }

    public final void m489a(String str, Object obj) {
        this.f653n.put(str, obj);
    }

    public final void afterTextChanged(Editable editable) {
        if (m482d() && m483e()) {
            this.f650j.setEnabled(true);
        } else {
            this.f650j.setEnabled(false);
        }
    }

    public final void m490b() {
        if (this.f642b == C0884a.STATE_ERROR) {
            this.f644d.setVisibility(0);
            this.f645e.setVisibility(8);
            this.f654o.m748a(this.f643c);
            this.f655p.setVisibility(0);
        } else if (this.f642b == C0884a.STATE_PIN_SUCCESS) {
            f641l.m743b();
            m480a(C0925h.m680a("ANDROID_returning_to_merchant"), true);
            f641l.m742a();
            new Thread(new C08831(this)).start();
        }
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void m491d(String str) {
        f641l.m743b();
        this.f643c = str;
        this.f642b = C0884a.STATE_ERROR;
        this.f648h.setText(StringUtil.EMPTY_STRING);
        this.f649i.setText(StringUtil.EMPTY_STRING);
        C08791.m465b();
    }

    public final void m492l() {
        C0919b.m619e().m656a("NewPhone", this.f653n.get("mobileNumber"));
        C0919b.m619e().m656a("NewPin", this.f653n.get("newPIN"));
        C0919b.m619e().m656a("delegate", (Object) this);
        C0919b.m619e().m653a(11);
    }

    public final void onClick(View view) {
        if (view == this.f650j) {
            if (m482d() && m483e()) {
                m484f();
                if (PayPal.getInstance().getServer() != 2) {
                    C0890a.m511a().m514b(this, this.f647g.getText().toString(), this.f648h.getText().toString());
                }
                this.f644d.setVisibility(8);
                this.f645e.setVisibility(0);
                f641l.m742a();
                if (PayPal.getInstance().getServer() == 2) {
                    this.f642b = C0884a.STATE_PIN_SUCCESS;
                    C08791.m465b();
                }
            }
        } else if (view == this.f651k) {
            m484f();
            if (f640a == null || f640a.length() == 0) {
                f640a = "11111111";
            }
            PayPalActivity.getInstance().paymentSucceeded((String) C0919b.m619e().m657c("PayKey"), (String) C0919b.m619e().m657c("PaymentExecStatus"));
        }
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
