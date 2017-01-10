package com.paypal.android.MEP.p000a;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout.LayoutParams;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.p002b.C0898b;
import com.paypal.android.p001b.C0872j;
import com.paypal.android.p001b.C0893g;
import com.paypal.android.p001b.C0893g.C0874a;
import com.paypal.android.p001b.C0941h;
import com.paypal.android.p001b.C0944i;
import com.paypal.android.p001b.C0944i.C0943a;
import com.paypal.android.p003a.C0919b;
import com.paypal.android.p003a.C0921d;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;

/* renamed from: com.paypal.android.MEP.a.c */
public final class C0878c extends C0872j implements OnClickListener, C0874a {
    String f607a;
    String f608b;
    private Intent f609c;
    private C0944i f610d;
    private C0898b f611e;

    /* renamed from: com.paypal.android.MEP.a.c.1 */
    class C08771 implements OnClickListener {
        private /* synthetic */ C0878c f606a;

        C08771(C0878c c0878c) {
            this.f606a = c0878c;
        }

        public final void onClick(View view) {
            PayPalActivity.getInstance().paymentFailed((String) C0919b.m619e().m657c("CorrelationId"), (String) C0919b.m619e().m657c("PayKey"), this.f606a.f607a, this.f606a.f608b, true, false);
        }
    }

    public C0878c(Context context) {
        super(context);
        this.f609c = null;
        this.f607a = StringUtil.EMPTY_STRING;
        this.f608b = StringUtil.EMPTY_STRING;
    }

    public C0878c(Context context, Intent intent) {
        super(context);
        this.f609c = null;
        this.f607a = StringUtil.EMPTY_STRING;
        this.f608b = StringUtil.EMPTY_STRING;
        this.f609c = intent;
        try {
            this.f607a = this.f609c.getStringExtra("FATAL_ERROR_ID");
            this.f608b = this.f609c.getStringExtra("FATAL_ERROR_MESSAGE");
            this.f610d.m748a(this.f608b);
        } catch (Exception e) {
            this.f607a = "10001";
            this.f608b = C0925h.m680a("ANDROID_10001");
        }
    }

    public final void m459a() {
    }

    protected final void m460a(Context context) {
        super.m440a(context);
        View a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setPadding(5, 5, 5, 15);
        a.addView(C0934o.m737b(C0933a.HELVETICA_16_BOLD, context));
        this.f611e = new C0898b(context, this);
        this.f611e.m517a((C0874a) this);
        a.addView(this.f611e);
        addView(a);
        a = C0921d.m667a(context, -1, -1);
        a.setBackgroundDrawable(C0921d.m665a());
        a.setPadding(10, 5, 10, 5);
        a.setOrientation(1);
        a.addView(new C0941h(C0925h.m680a("ANDROID_error_heading"), context));
        View a2 = C0921d.m667a(context, -1, -2);
        a2.setOrientation(1);
        a2.setPadding(5, 10, 5, 10);
        this.f610d = new C0944i(context, C0943a.RED_ALERT);
        this.f610d.m748a(C0925h.m680a("ANDROID_10001"));
        this.f610d.setPadding(0, 5, 0, 5);
        this.f610d.setVisibility(0);
        a2.addView(this.f610d);
        a.addView(a2);
        a2 = new Button(context);
        a2.setText(C0925h.m680a("ANDROID_ok"));
        a2.setLayoutParams(new LayoutParams(-1, C0921d.m669b()));
        a2.setGravity(1);
        a2.setBackgroundDrawable(C0922e.m671a());
        a2.setTextColor(-16777216);
        a2.setOnClickListener(new C08771(this));
        a.addView(a2);
        addView(a);
    }

    public final void m461a(C0893g c0893g, int i) {
    }

    public final void m462b() {
    }

    public final void onClick(View view) {
    }
}
