package com.paypal.android.MEP.p000a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.paypal.android.MEP.C0890a;
import com.paypal.android.MEP.C0890a.C0869b;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.p000a.C0882d.C08791;
import com.paypal.android.MEP.p002b.C0897a;
import com.paypal.android.MEP.p002b.C0897a.C0873b;
import com.paypal.android.MEP.p002b.C0897a.C0892a;
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
import java.util.Hashtable;
import org.codehaus.jackson.impl.JsonWriteContext;

/* renamed from: com.paypal.android.MEP.a.a */
public final class C0875a extends C0872j implements OnClickListener, C0869b, C0873b, C0874a {
    public static Hashtable<String, Object> f590a;
    private static C0939e f591n;
    private C0871a f592b;
    private C0898b f593c;
    private Button f594d;
    private Button f595e;
    private C0897a f596f;
    private C0897a f597g;
    private C0897a f598h;
    private C0944i f599i;
    private String f600j;
    private LinearLayout f601k;
    private RelativeLayout f602l;
    private TextView f603m;
    private Context f604o;

    /* renamed from: com.paypal.android.MEP.a.a.1 */
    static /* synthetic */ class C08701 {
        static final /* synthetic */ int[] f582a;

        static {
            f582a = new int[C0892a.values().length];
            try {
                f582a[C0892a.PAYMENT_DETAILS_FEES.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f582a[C0892a.PAYMENT_DETAILS_FUNDING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f582a[C0892a.PAYMENT_DETAILS_SHIPPING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.paypal.android.MEP.a.a.a */
    public enum C0871a {
        STATE_NORMAL,
        STATE_SENDING_PAYMENT,
        STATE_ERROR,
        STATE_UPDATING
    }

    static {
        f590a = null;
        f591n = null;
    }

    public C0875a(Context context) {
        super(context);
        this.f603m = null;
        this.f604o = context;
    }

    private void m444a(String str) {
        View a = C0921d.m667a(this.f604o, -1, -2);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.getLayoutParams());
        layoutParams.addRule(13);
        a.setLayoutParams(layoutParams);
        a.setOrientation(1);
        a.setGravity(1);
        if (f591n == null) {
            f591n = new C0939e(this.f604o);
        } else {
            ((LinearLayout) f591n.getParent()).removeAllViews();
        }
        this.f603m = C0934o.m736a(C0933a.HELVETICA_16_NORMAL, this.f604o);
        this.f603m.setGravity(1);
        this.f603m.setTextColor(-13408615);
        this.f603m.setText(str);
        a.addView(f591n);
        a.addView(this.f603m);
        this.f602l.removeAllViews();
        this.f602l.addView(a);
    }

    public final void m445a() {
    }

    public final void m446a(int i, Object obj) {
        if (this.f592b == C0871a.STATE_SENDING_PAYMENT) {
            PayPal instance = PayPal.getInstance();
            PayPalActivity instance2 = PayPalActivity.getInstance();
            C0919b e = C0919b.m619e();
            String str = (String) e.m657c("PayKey");
            String str2 = (String) e.m657c("PaymentExecStatus");
            if (instance.getServer() == 2) {
                instance2.setTransactionSuccessful(true);
                instance2.paymentSucceeded(str, str2, false);
                C0885e.f640a = (String) obj;
                C08791.m466b(7);
            } else if (instance.hasCreatedPIN() || instance.isLightCountry() || instance.getPayType() == 3) {
                instance2.paymentSucceeded(str, str2, true);
            } else {
                instance2.setTransactionSuccessful(true);
                instance2.paymentSucceeded(str, str2, false);
                C0885e.f640a = (String) obj;
                C08791.m466b(7);
            }
        }
    }

    public final void m447a(Context context) {
        PayPal instance = PayPal.getInstance();
        super.m440a(context);
        this.f604o = context;
        this.f592b = C0871a.STATE_NORMAL;
        View a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setPadding(5, 5, 5, 15);
        a.addView(C0934o.m737b(C0933a.HELVETICA_16_BOLD, context));
        this.f593c = new C0898b(context, this);
        this.f593c.m517a((C0874a) this);
        a.addView(this.f593c);
        addView(a);
        this.f601k = new LinearLayout(context);
        this.f601k.setOrientation(1);
        this.f601k.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f601k.setPadding(5, 5, 5, 5);
        this.f601k.setBackgroundDrawable(C0921d.m665a());
        this.f601k.addView(new C0941h(C0925h.m680a("ANDROID_review"), context));
        a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setPadding(5, 10, 5, 10);
        this.f599i = new C0944i(context, C0943a.YELLOW_ALERT);
        this.f599i.m748a("This page is currently being used to test components.");
        this.f599i.setPadding(0, 5, 0, 5);
        this.f599i.setVisibility(8);
        a.addView(this.f599i);
        this.f601k.addView(a);
        this.f597g = new C0897a(context, C0892a.PAYMENT_DETAILS_FEES, this);
        this.f597g.m517a((C0874a) this);
        this.f597g.setPadding(0, 5, 0, 5);
        this.f597g.m538a((C0873b) this);
        if (PayPal.getInstance().shouldShowFees()) {
            this.f601k.addView(this.f597g);
        }
        this.f596f = new C0897a(context, C0892a.PAYMENT_DETAILS_FUNDING, this);
        this.f596f.m517a((C0874a) this);
        this.f596f.setPadding(0, 5, 0, 5);
        this.f596f.m538a((C0873b) this);
        this.f601k.addView(this.f596f);
        this.f598h = new C0897a(context, C0892a.PAYMENT_DETAILS_SHIPPING, this);
        this.f598h.m517a((C0874a) this);
        this.f598h.setPadding(0, 5, 0, 5);
        this.f598h.m538a((C0873b) this);
        if (instance.getShippingEnabled()) {
            this.f601k.addView(this.f598h);
        }
        a = C0921d.m667a(context, -1, -2);
        a.setGravity(1);
        a.setPadding(5, 10, 5, 5);
        this.f595e = new Button(context);
        if (instance.getTextType() == 1) {
            this.f595e.setText(C0925h.m680a("ANDROID_donate"));
        } else {
            this.f595e.setText(C0925h.m680a("ANDROID_pay"));
        }
        this.f595e.setLayoutParams(new LinearLayout.LayoutParams(-1, C0921d.m669b(), 0.5f));
        this.f595e.setGravity(17);
        this.f595e.setBackgroundDrawable(C0922e.m671a());
        this.f595e.setTextColor(-16777216);
        this.f595e.setOnClickListener(this);
        a.addView(this.f595e);
        this.f601k.addView(a);
        View a2 = C0921d.m667a(context, -1, -2);
        a2.setGravity(1);
        a2.setPadding(5, 5, 5, 10);
        this.f594d = new Button(context);
        this.f594d.setText(C0925h.m680a("ANDROID_cancel"));
        this.f594d.setLayoutParams(new LinearLayout.LayoutParams(-1, C0921d.m669b(), 0.5f));
        this.f594d.setGravity(17);
        this.f594d.setBackgroundDrawable(C0922e.m673b());
        this.f594d.setTextColor(-16777216);
        this.f594d.setOnClickListener(this);
        a2.addView(this.f594d);
        this.f601k.addView(a2);
        addView(this.f601k);
        this.f602l = new RelativeLayout(context);
        this.f602l.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f602l.setBackgroundDrawable(C0921d.m665a());
        a = C0921d.m667a(context, -1, -2);
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(a.getLayoutParams());
        layoutParams.addRule(13);
        a.setLayoutParams(layoutParams);
        a.setOrientation(1);
        a.setGravity(1);
        if (f591n == null) {
            f591n = new C0939e(context);
        } else {
            ((LinearLayout) f591n.getParent()).removeAllViews();
        }
        this.f603m = C0934o.m736a(C0933a.HELVETICA_16_NORMAL, context);
        this.f603m.setGravity(1);
        this.f603m.setTextColor(-13408615);
        this.f603m.setText(C0925h.m680a("ANDROID_processing_transaction_message"));
        a.addView(f591n);
        a.addView(this.f603m);
        this.f602l.addView(a);
        this.f602l.setVisibility(8);
        addView(this.f602l);
        if (!PayPal.getInstance().canShowCart()) {
            this.f593c.m545a(false, false);
        }
    }

    public final void m448a(C0871a c0871a) {
        this.f592b = c0871a;
        C08791.m465b();
    }

    public final void m449a(C0897a c0897a, int i) {
        switch (C08701.f582a[c0897a.m540b().ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                if (this.f596f != null) {
                    this.f596f.setNextFocusUpId(i);
                }
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                if (this.f598h != null) {
                    this.f598h.setNextFocusUpId(i);
                }
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                if (this.f595e != null) {
                    this.f595e.setNextFocusUpId(i);
                }
            default:
        }
    }

    public final void m450a(C0893g c0893g, int i) {
        if (i == 1) {
            if (!(this.f593c == null || c0893g == this.f593c)) {
                this.f593c.m521a(0);
            }
            if (!(this.f596f == null || c0893g == this.f596f)) {
                this.f596f.m536a(0);
            }
            if (!(this.f597g == null || c0893g == this.f597g)) {
                this.f597g.m536a(0);
            }
            if (this.f598h != null && c0893g != this.f598h) {
                this.f598h.m536a(0);
            }
        }
    }

    public final void m451a(String str, Object obj) {
    }

    public final void m452b() {
        if (this.f596f != null) {
            this.f596f.m542c();
        }
        if (this.f597g != null) {
            this.f597g.m542c();
        }
        if (this.f598h != null) {
            this.f598h.m542c();
        }
        if (this.f592b == C0871a.STATE_SENDING_PAYMENT) {
            m444a(C0925h.m680a("ANDROID_processing_transaction_message"));
            this.f593c.m545a(false, true);
            this.f601k.setVisibility(8);
            this.f602l.setVisibility(0);
            f591n.m742a();
        } else if (this.f592b == C0871a.STATE_UPDATING) {
            m444a(C0925h.m680a("ANDROID_getting_information"));
            this.f593c.m545a(false, true);
            this.f601k.setVisibility(8);
            this.f602l.setVisibility(0);
            f591n.m742a();
        } else if (this.f592b == C0871a.STATE_NORMAL || this.f592b == C0871a.STATE_ERROR) {
            if (PayPal.getInstance().canShowCart()) {
                this.f593c.m545a(true, false);
            } else {
                this.f593c.m545a(false, false);
            }
            f591n.m743b();
            this.f602l.setVisibility(8);
            this.f601k.setVisibility(0);
            if (this.f592b == C0871a.STATE_ERROR) {
                this.f599i.m748a(this.f600j);
                this.f599i.setVisibility(0);
            }
        }
    }

    public final C0871a m453c() {
        return this.f592b;
    }

    public final void m454d() {
        if (this.f593c != null) {
            this.f593c.m521a(0);
        }
        if (this.f596f != null) {
            this.f596f.m536a(0);
        }
        if (this.f597g != null) {
            this.f597g.m536a(0);
        }
        if (this.f598h != null) {
            this.f598h.m536a(0);
        }
    }

    public final void m455d(String str) {
        if (this.f592b == C0871a.STATE_SENDING_PAYMENT) {
            this.f600j = str;
            m448a(C0871a.STATE_ERROR);
        }
    }

    public final void m456l() {
        C0919b.m619e().m656a("delegate", (Object) this);
        C0919b.m619e().m653a(4);
    }

    public final void onClick(View view) {
        if (this.f594d == view) {
            new C0902f(PayPalActivity.getInstance()).show();
        } else if (this.f595e == view) {
            m448a(C0871a.STATE_SENDING_PAYMENT);
            if (PayPal.getInstance().getServer() == 2) {
                m446a(4, (Object) "10088342");
            } else {
                C0890a.m511a().m512a(this);
            }
        } else if ((view.getId() & 2130706432) == 2130706432) {
            this.f596f.m536a(0);
        } else if ((view.getId() & 2113929216) == 2113929216) {
            this.f597g.m536a(0);
        } else if ((view.getId() & 2097152000) == 2097152000) {
            this.f598h.m536a(0);
        }
    }
}
