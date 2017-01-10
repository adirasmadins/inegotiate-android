package com.paypal.android.MEP.p002b;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.StateListDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.C0890a.C0869b;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.MEP.p000a.C0875a;
import com.paypal.android.MEP.p000a.C0882d.C08791;
import com.paypal.android.p001b.C0896k;
import com.paypal.android.p001b.C0939e;
import com.paypal.android.p001b.C0940f;
import com.paypal.android.p003a.C0919b;
import com.paypal.android.p003a.C0921d;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0934o;
import com.paypal.android.p003a.C0934o.C0933a;
import com.paypal.android.p003a.p004a.C0906a;
import com.paypal.android.p003a.p004a.C0908c;
import com.paypal.android.p003a.p004a.C0911f;
import com.paypal.android.p003a.p004a.C0912g;
import com.paypal.android.p003a.p004a.C0913h;
import com.paypal.android.p003a.p004a.C0916k;
import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.commons.logging.impl.SimpleLog;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.paypal.android.MEP.b.a */
public final class C0897a extends C0896k implements OnTouchListener, C0869b {
    private static C0939e f694l;
    private static boolean f695q;
    boolean f696e;
    Vector<Hashtable> f697f;
    private GradientDrawable f698g;
    private GradientDrawable f699h;
    private C0892a f700i;
    private LinearLayout f701j;
    private LinearLayout f702k;
    private TextView f703m;
    private C0875a f704n;
    private Vector<String> f705o;
    private Vector<String> f706p;
    private int f707r;
    private C0873b f708s;
    private OnClickListener f709t;
    private String f710u;

    /* renamed from: com.paypal.android.MEP.b.a.b */
    public interface C0873b {
        void m442a(C0897a c0897a, int i);
    }

    /* renamed from: com.paypal.android.MEP.b.a.1 */
    static /* synthetic */ class C08911 {
        static final /* synthetic */ int[] f681a;

        static {
            f681a = new int[C0892a.values().length];
            try {
                f681a[C0892a.PAYMENT_DETAILS_FUNDING.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f681a[C0892a.PAYMENT_DETAILS_FEES.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f681a[C0892a.PAYMENT_DETAILS_SHIPPING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    /* renamed from: com.paypal.android.MEP.b.a.a */
    public enum C0892a {
        PAYMENT_DETAILS_FUNDING,
        PAYMENT_DETAILS_FEES,
        PAYMENT_DETAILS_SHIPPING
    }

    static {
        f694l = null;
        f695q = false;
    }

    public C0897a(Context context, C0892a c0892a, C0875a c0875a) {
        super(context);
        this.f702k = null;
        this.f703m = null;
        this.f704n = null;
        this.f705o = new Vector(3);
        this.f706p = new Vector(3);
        this.f696e = false;
        this.f697f = null;
        this.f707r = 0;
        this.f708s = null;
        this.f709t = new C0900d(this);
        this.f710u = null;
        setOnTouchListener(this);
        this.f704n = c0875a;
        this.f700i = c0892a;
        setBackgroundColor(-16711681);
        m516a(new LayoutParams(-1, -2), 0);
        m516a(new LayoutParams(-1, -2), 1);
        this.f698g = C0921d.m666a(-1, -1510918, -3154193);
        this.f699h = C0921d.m666a(-1, -4336918, -3154193);
        setBackgroundDrawable(this.f698g);
        setGravity(16);
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-10066330, -3487030});
        gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 5.0f, 5.0f, 5.0f, 5.0f});
        gradientDrawable.setStroke(2, -10066330);
        m527c(gradientDrawable);
        m522a(C0922e.m670a(111410, 464));
        m524b(C0922e.m670a(118786, 430));
        this.a.setOrientation(1);
        View a = C0921d.m667a(context, -1, -2);
        a.setOrientation(0);
        a.setGravity(16);
        View a2 = C0934o.m736a(C0933a.HELVETICA_14_BOLD, context);
        r0 = this.f700i == C0892a.PAYMENT_DETAILS_FUNDING ? C0925h.m680a("ANDROID_funding") + ":" : this.f700i == C0892a.PAYMENT_DETAILS_FEES ? C0925h.m680a("ANDROID_fee") + ":" : PayPal.getInstance().getTextType() == 1 ? C0925h.m680a("ANDROID_mailing_address") + ":" : C0925h.m680a("ANDROID_ship_to") + ":";
        a2.setText(r0);
        a2.setGravity(3);
        a.addView(a2);
        a.addView(this.c);
        this.c.setVisibility(0);
        this.a.addView(a);
        this.f702k = C0921d.m667a(context, -1, -2);
        this.f702k.setOrientation(1);
        m531a(context, this.f702k);
        this.a.addView(this.f702k);
        this.f701j = C0921d.m667a(context, -1, -2);
        this.f701j.setOrientation(0);
        this.f701j.setGravity(16);
        a = C0921d.m667a(context, -1, -2);
        a.setOrientation(1);
        a.setGravity(1);
        this.f703m = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
        this.f703m.setLayoutParams(new LayoutParams(-1, -1));
        this.f703m.setTextColor(-13408615);
        this.f703m.setText(C0925h.m680a("ANDROID_getting_information"));
        this.f703m.setGravity(1);
        this.f703m.setSingleLine(false);
        a.addView(this.f703m);
        if (this.f700i == C0892a.PAYMENT_DETAILS_FUNDING) {
            if (f694l == null) {
                f694l = new C0939e(context);
            } else {
                ((LinearLayout) f694l.getParent()).removeAllViews();
            }
            f694l.setGravity(1);
            this.f701j.addView(f694l);
            this.f701j.addView(a);
            this.f701j.setVisibility(8);
        }
        this.a.addView(this.f701j);
        if (this.f700i == C0892a.PAYMENT_DETAILS_FEES) {
            m523a(false);
        }
        f695q = false;
    }

    private Button m529a(Context context, String str, int i) {
        Button button = new Button(context);
        button.setText(str);
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, C0921d.m669b());
        layoutParams.setMargins(0, 3, 0, 2);
        button.setLayoutParams(layoutParams);
        button.setGravity(17);
        Drawable stateListDrawable = new StateListDrawable();
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-328451, -4336918});
        Drawable gradientDrawable2 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-6702886, -11966331});
        Drawable gradientDrawable3 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-13605994, -16764058});
        Drawable gradientDrawable4 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{2140780762, 2135517317});
        gradientDrawable.setCornerRadius(5.0f);
        gradientDrawable.setStroke(1, -6307088);
        gradientDrawable2.setCornerRadius(5.0f);
        gradientDrawable2.setStroke(1, -10650469);
        gradientDrawable3.setCornerRadius(5.0f);
        gradientDrawable3.setStroke(1, -16764058);
        gradientDrawable4.setCornerRadius(5.0f);
        gradientDrawable4.setStroke(1, 2136833179);
        stateListDrawable.addState(new int[]{16842910, -16842919, -16842908}, gradientDrawable);
        stateListDrawable.addState(new int[]{16842910, -16842919, 16842908}, gradientDrawable2);
        stateListDrawable.addState(new int[]{16842910, 16842919, -16842908}, gradientDrawable3);
        stateListDrawable.addState(new int[]{16842910, 16842919, 16842908}, gradientDrawable3);
        stateListDrawable.addState(new int[]{-16842910, -16842919, -16842908}, gradientDrawable4);
        stateListDrawable.addState(new int[]{-16842910, -16842919, 16842908}, gradientDrawable4);
        stateListDrawable.addState(new int[]{-16842910, 16842919, -16842908}, gradientDrawable4);
        stateListDrawable.addState(new int[]{-16842910, 16842919, 16842908}, gradientDrawable4);
        button.setBackgroundDrawable(stateListDrawable);
        button.setTextColor(-16777216);
        button.setFocusable(true);
        button.setOnClickListener(this.f709t);
        if (this.f700i == C0892a.PAYMENT_DETAILS_FUNDING) {
            button.setId(2130706432 | i);
        } else if (this.f700i == C0892a.PAYMENT_DETAILS_FEES) {
            button.setId(2113929216 | i);
        } else if (this.f700i == C0892a.PAYMENT_DETAILS_SHIPPING) {
            button.setId(2097152000 | i);
        }
        return button;
    }

    private void m531a(Context context, LinearLayout linearLayout) {
        Hashtable g = PayPal.getInstance().getServer() == 2 ? C0875a.f590a : C0919b.m619e().m660g();
        Vector vector;
        String b;
        String b2;
        BigDecimal bigDecimal;
        if (this.f700i == C0892a.PAYMENT_DETAILS_FUNDING) {
            C0908c c0908c;
            vector = (Vector) g.get("FundingPlans");
            if (vector == null || vector.size() == 0) {
                c0908c = (C0908c) g.get("DefaultFundingPlan");
            } else {
                C0908c c0908c2 = (C0908c) vector.elementAt(0);
                try {
                    c0908c = (C0908c) vector.elementAt(Integer.parseInt((String) g.get("FundingPlanId")));
                } catch (Exception e) {
                    c0908c = c0908c2;
                }
            }
            for (int i = 0; i < c0908c.f748d.size(); i++) {
                View a;
                Object obj;
                C0916k c0916k = (C0916k) c0908c.f748d.get(i);
                b = c0916k.f783a.m558b();
                BigDecimal a2 = c0916k.f783a.m556a();
                String c = c0916k.f784b.m570c();
                b2 = c0916k.f784b.m568b();
                if (b2 == null) {
                    b2 = StringUtil.EMPTY_STRING;
                }
                View c0940f = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
                Object obj2 = !PayPal.getInstance().getLanguage().contains("fr_") ? 1 : null;
                if (c.indexOf("BALANCE") != -1) {
                    if (obj2 != null) {
                        c0940f.m745a(c0916k.f784b.m566a() + " (" + b + "):");
                    } else {
                        c0940f.m745a(c0916k.f784b.m566a() + " (" + b + ") :");
                    }
                } else if (c.equals("BANK_DELAYED")) {
                    if (b2 == null || b2.length() <= 0) {
                        if (obj2 != null) {
                            c0940f.m745a(c0916k.f784b.m566a() + " (" + C0925h.m680a("ANDROID_echeck") + "):");
                        } else {
                            c0940f.m745a(c0916k.f784b.m566a() + " (" + C0925h.m680a("ANDROID_echeck") + ") :");
                        }
                    } else if (obj2 != null) {
                        c0940f.m745a(c0916k.f784b.m566a() + " x" + b2 + " (" + C0925h.m680a("ANDROID_echeck") + "):");
                    } else {
                        c0940f.m745a(c0916k.f784b.m566a() + " x" + b2 + " (" + C0925h.m680a("ANDROID_echeck") + ") :");
                    }
                } else if (c.equals("BANK_INSTANT")) {
                    if (b2 == null || b2.length() <= 0) {
                        c0940f.m745a(c0916k.f784b.m566a() + ":");
                    } else {
                        c0940f.m745a(c0916k.f784b.m566a() + " x" + b2 + ":");
                    }
                } else if (!c.equals("CREDITCARD") && !c.equals("DEBITCARD")) {
                    c0940f.m745a(c0916k.f784b.m566a());
                } else if (b2 == null || b2.length() <= 0) {
                    c0940f.m745a(c0916k.f784b.m566a() + ":");
                } else {
                    c0940f.m745a(c0916k.f784b.m566a() + " x" + b2 + ":");
                }
                c0940f.m747b(C0925h.m682a(a2, b));
                linearLayout.addView(c0940f);
                if (c.equals("BANK_DELAYED")) {
                    a = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                    a.setLayoutParams(new LayoutParams(-1, -2, 0.5f));
                    a.setPadding(2, 2, 2, 2);
                    a.setBackgroundColor(0);
                    a.setText(C0925h.m680a("ANDROID_echeck_note"));
                    linearLayout.addView(a);
                }
                bigDecimal = new BigDecimal("0");
                if (!(c0908c.f746b == null || c0908c.f746b.m556a() == null)) {
                    bigDecimal = c0908c.f746b.m556a();
                }
                BigDecimal total = PayPal.getInstance().getPayment().getTotal();
                if (b.equals(PayPal.getInstance().getPayment().getCurrencyType())) {
                    obj = a2.compareTo(total.add(bigDecimal)) > 0 ? 1 : null;
                } else {
                    total = c0908c.f745a.m556a().subtract(c0908c.f747c.f766b.m556a());
                    BigDecimal a3 = c0908c.f747c.f765a.m556a();
                    int i2 = 0;
                    while (i2 < c0908c.f748d.size()) {
                        c0916k = (C0916k) c0908c.f748d.elementAt(i2);
                        if (c0908c.f745a.m558b().equals(c0916k.f783a.m558b())) {
                            BigDecimal bigDecimal2 = a3;
                            a3 = total.subtract(c0916k.f783a.m556a());
                            bigDecimal = bigDecimal2;
                        } else {
                            bigDecimal = a3.subtract(c0916k.f783a.m556a());
                            a3 = total;
                        }
                        i2++;
                        total = a3;
                        a3 = bigDecimal;
                    }
                    obj = (total.compareTo(BigDecimal.ZERO) == 0 && a3.compareTo(BigDecimal.ZERO) == 0) ? null : 1;
                }
                if (obj != null) {
                    a = C0934o.m736a(C0933a.HELVETICA_12_NORMAL, context);
                    a.setLayoutParams(new LayoutParams(-1, -2, 0.5f));
                    a.setPadding(2, 2, 2, 2);
                    a.setBackgroundColor(0);
                    a.setText(C0925h.m680a("ANDROID_negative_balance"));
                    linearLayout.addView(a);
                }
            }
            C0911f c0911f = c0908c.f747c;
            if (c0911f != null) {
                float parseFloat = Float.parseFloat(c0911f.m564a());
                View c0940f2 = new C0940f(context, C0933a.HELVETICA_12_NORMAL, C0933a.HELVETICA_12_NORMAL);
                c0940f2.m745a("1 " + c0911f.f765a.m558b() + " = " + parseFloat + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + c0911f.f766b.m558b());
                c0940f2.m747b(StringUtil.EMPTY_STRING);
                linearLayout.addView(c0940f2);
            }
            boolean z = true;
            if (vector != null && vector.size() > 0) {
                z = vector.size() > 1;
            }
            if (((C0916k) c0908c.f748d.elementAt(0)).f784b.m570c().equals("BALANCE") && c0908c.f748d.size() == 1) {
                z = false;
            }
            m523a(z);
        } else if (this.f700i == C0892a.PAYMENT_DETAILS_FEES) {
            try {
                vector = (Vector) g.get("FundingPlans");
                C0908c c0908c3 = (vector == null || vector.size() == 0) ? (C0908c) g.get("DefaultFundingPlan") : (C0908c) vector.elementAt(Integer.parseInt((String) g.get("FundingPlanId")));
                if (c0908c3 != null) {
                    C0906a c0906a = c0908c3.f746b;
                    if (c0906a != null) {
                        bigDecimal = c0906a.m556a();
                        String b3 = c0906a.m558b();
                        View c0940f3 = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
                        if (bigDecimal.compareTo(BigDecimal.ZERO) > 0) {
                            c0940f3.m745a(C0925h.m680a("ANDROID_i_pay"));
                        } else {
                            c0940f3.m745a(C0925h.m680a("ANDROID_free"));
                        }
                        c0940f3.m747b(C0925h.m682a(bigDecimal, b3));
                        linearLayout.addView(c0940f3);
                        if (bigDecimal.compareTo(BigDecimal.ZERO) <= 0) {
                            m523a(false);
                        }
                    } else {
                        View c0940f4 = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
                        c0940f4.m745a(C0925h.m680a("ANDROID_free"));
                        linearLayout.addView(c0940f4);
                    }
                    m523a(false);
                }
            } catch (Exception e2) {
            }
        } else if (this.f700i == C0892a.PAYMENT_DETAILS_SHIPPING) {
            vector = (Vector) g.get("AvailableAddresses");
            String str = (String) g.get("ShippingAddressId");
            if (vector != null && vector.size() > 0) {
                C0913h c0913h = null;
                for (int i3 = 0; i3 < vector.size(); i3++) {
                    c0913h = (C0913h) vector.elementAt(i3);
                    if (c0913h.m586h().equals(str)) {
                        break;
                    }
                }
                if (c0913h != null) {
                    str = c0913h.m571a();
                    b2 = c0913h.m578d();
                    String e3 = c0913h.m580e();
                    b = c0913h.m574b();
                    String g2 = c0913h.m584g();
                    String f = c0913h.m582f();
                    View c0940f5 = new C0940f(context, C0933a.HELVETICA_14_NORMAL, C0933a.HELVETICA_14_NORMAL);
                    StringBuffer stringBuffer = new StringBuffer();
                    if (str != null && str.length() > 0) {
                        stringBuffer.append(str + "\n");
                    }
                    if (b2 != null && b2.length() > 0) {
                        stringBuffer.append(b2);
                        if (e3 != null && e3.length() > 0) {
                            stringBuffer.append(", ");
                        }
                    }
                    if (e3 != null && e3.length() > 0) {
                        stringBuffer.append(e3);
                    }
                    if ((b2 != null && b2.length() > 0) || (e3 != null && e3.length() > 0)) {
                        stringBuffer.append("\n");
                    }
                    if (b != null && b.length() > 0) {
                        stringBuffer.append(b);
                        if ((g2 != null && g2.length() > 0) || (f != null && f.length() > 0)) {
                            stringBuffer.append(", ");
                        }
                    }
                    if (g2 != null && g2.length() > 0) {
                        stringBuffer.append(g2);
                        if (f != null && f.length() > 0) {
                            stringBuffer.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        }
                    }
                    if (f != null && f.length() > 0) {
                        stringBuffer.append(f);
                    }
                    c0940f5.m745a(stringBuffer.toString());
                    m523a(vector.size() > 1);
                    linearLayout.addView(c0940f5);
                }
            }
        }
    }

    private void m534c(boolean z) {
        if (z) {
            this.f702k.setVisibility(8);
            this.f701j.setVisibility(0);
            f694l.m742a();
            return;
        }
        f694l.m743b();
        this.f701j.setVisibility(8);
        this.f702k.setVisibility(0);
    }

    private void m535e() {
        this.f697f = new Vector();
        Vector vector = (Vector) (PayPal.getInstance().getServer() == 2 ? C0875a.f590a : C0919b.m619e().m660g()).get("FundingPlans");
        for (int i = 0; i < vector.size(); i++) {
            Object obj;
            C0908c c0908c = (C0908c) vector.get(i);
            C0916k c0916k = (C0916k) c0908c.f748d.get(0);
            C0912g c0912g = c0916k.f784b;
            String c = c0912g.m570c();
            String a = c0912g.m566a();
            if (c.equals("BALANCE")) {
                obj = a + "(" + c0916k.f783a.m558b() + ")";
            } else if ((c.equals("BANK_DELAYED") || c.equals("BANK_INSTANT") || c.equals("CREDITCARD") || c.equals("DEBITCARD")) && c0912g.m568b() != null && c0912g.m568b().length() > 0) {
                obj = a + " x" + c0912g.m568b();
            } else {
                String str = a;
            }
            if (c.equals("BANK_DELAYED")) {
                obj = obj + " (" + C0925h.m680a("ANDROID_echeck") + ")";
            }
            Hashtable hashtable = new Hashtable();
            hashtable.put("label", obj);
            hashtable.put("plan", c0908c);
            this.f697f.add(hashtable);
        }
        C08791.m465b();
    }

    public final void m536a(int i) {
        this.f707r = i;
        if (i == 1) {
            switch (C08911.f681a[this.f700i.ordinal()]) {
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    Vector vector = (Vector) (PayPal.getInstance().getServer() == 2 ? C0875a.f590a : C0919b.m619e().m660g()).get("FundingPlans");
                    if (vector == null || vector.size() == 0) {
                        m534c(true);
                        C0919b.m619e().m656a("delegate", (Object) this);
                        C0919b.m619e().m653a(5);
                        return;
                    }
                    m535e();
                    super.m521a(i);
                    return;
                case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                    int id;
                    m528d();
                    String str = (String) ((Hashtable) ((Vector) C0919b.m619e().m660g().get("PricingDetails")).get(0)).get("FeeBearer");
                    View a = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, getContext());
                    a.setLayoutParams(new LayoutParams(-2, -2));
                    a.setBackgroundColor(0);
                    a.setText(C0925h.m680a("ANDROID_choose_who_pays_the_fee") + ":");
                    a.setTextColor(-1);
                    m525a(a);
                    if (str.compareTo("ApplyFeeToReceiver") == 0) {
                        a = m529a(getContext(), C0925h.m680a("ANDROID_i_pay"), 0);
                        id = a.getId();
                        m525a(a);
                        a.setNextFocusUpId(getId());
                    } else {
                        a = m529a(getContext(), C0925h.m680a("NDROID_recipient_pays"), 1);
                        id = a.getId();
                        m525a(a);
                        a.setNextFocusUpId(getId());
                    }
                    setNextFocusDownId(id);
                    if (this.f708s != null) {
                        this.f708s.m442a(this, id);
                    }
                    super.m521a(i);
                    return;
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                    if (PayPal.getInstance().getServer() != 2) {
                        if (((Vector) PayPalActivity._networkHandler.m660g().get("AvailableAddresses")) == null) {
                            this.f697f = null;
                        } else {
                            this.f697f = new Vector();
                        }
                    } else if (((Vector) C0875a.f590a.get("AvailableAddresses")) == null) {
                        this.f697f = null;
                    } else {
                        this.f697f = new Vector();
                    }
                    C08791.m465b();
                    super.m521a(i);
                    return;
                default:
                    return;
            }
        }
        m528d();
        this.f697f = null;
        super.m521a(i);
    }

    public final void m537a(int i, Object obj) {
        f695q = false;
        switch (i) {
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                C0919b.m619e().m653a(6);
            case JsonWriteContext.STATUS_EXPECT_NAME /*5*/:
                m535e();
                if (((Vector) C0919b.m619e().m657c("FundingPlans")).size() == 1) {
                    m523a(false);
                    PayPalActivity.getInstance().sendBroadcast(new Intent(PayPalActivity.CREATE_PAYMENT_SUCCESS));
                }
            case SimpleLog.LOG_LEVEL_FATAL /*6*/:
                try {
                    if (PayPal.getInstance().getServer() != 2) {
                        C0875a.f590a = C0919b.m619e().m660g();
                    }
                    PayPalActivity.getInstance().sendBroadcast(new Intent(PayPalActivity.CREATE_PAYMENT_SUCCESS));
                } catch (Throwable th) {
                }
            default:
        }
    }

    public final void m538a(C0873b c0873b) {
        this.f708s = c0873b;
    }

    public final void m539a(String str, Object obj) {
    }

    public final C0892a m540b() {
        return this.f700i;
    }

    public final void m541b(boolean z) {
        if (z) {
            setBackgroundDrawable(this.f699h);
        } else {
            setBackgroundDrawable(this.f698g);
        }
    }

    public final void m542c() {
        int i;
        if (this.f710u != null) {
            this.f704n.m455d(this.f710u);
            this.f710u = null;
            m534c(false);
        }
        if (this.f697f != null) {
            m534c(false);
            super.m521a(1);
            m528d();
            View a;
            int i2;
            switch (C08911.f681a[this.f700i.ordinal()]) {
                case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                    a = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, getContext());
                    a.setLayoutParams(new LayoutParams(-2, -2));
                    a.setBackgroundColor(0);
                    a.setText(C0925h.m680a("ANDROID_change_funding") + ":");
                    a.setTextColor(-1);
                    if (this.f697f.size() > 0) {
                        m525a(a);
                    }
                    int i3 = 0;
                    i = 0;
                    boolean z = false;
                    int i4 = 0;
                    while (i3 < this.f697f.size()) {
                        boolean z2;
                        try {
                            Hashtable hashtable = (Hashtable) this.f697f.get(i3);
                            C0908c c0908c = (C0908c) hashtable.get("plan");
                            if (!((String) (PayPal.getInstance().getServer() == 2 ? C0875a.f590a : C0919b.m619e().m660g()).get("FundingPlanId")).equals(c0908c.m561a())) {
                                View a2 = m529a(getContext(), (String) hashtable.get("label"), i4);
                                int id = a2.getId();
                                this.f706p.add(c0908c.m561a());
                                m525a(a2);
                                if (!z) {
                                    setNextFocusDownId(id);
                                    z = true;
                                }
                                i4++;
                                i = id;
                            }
                            i2 = i;
                            z2 = z;
                            i = i4;
                        } catch (Throwable th) {
                            i2 = i;
                            z2 = z;
                            i = i4;
                        }
                        i3++;
                        z = z2;
                        i4 = i;
                        i = i2;
                    }
                    if (!(i == 0 || this.f708s == null)) {
                        this.f708s.m442a(this, i);
                    }
                    if (i4 == 0) {
                        a.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                    }
                case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                    Hashtable g = PayPal.getInstance().getServer() == 2 ? C0875a.f590a : C0919b.m619e().m660g();
                    Vector vector = (Vector) g.get("AvailableAddresses");
                    String str = (String) g.get("ShippingAddressId");
                    if (vector != null && vector.size() > 1) {
                        a = C0934o.m736a(C0933a.HELVETICA_14_NORMAL, getContext());
                        a.setLayoutParams(new LayoutParams(-2, -2));
                        a.setBackgroundColor(0);
                        if (PayPal.getInstance().getTextType() == 1) {
                            a.setText(C0925h.m680a("ANDROID_change_mailing_address_to") + ":");
                        } else {
                            a.setText(C0925h.m680a("ANDROID_change_shipping_to") + ":");
                        }
                        a.setTextColor(-1);
                        m525a(a);
                        this.f705o.removeAllElements();
                        int i5 = 0;
                        boolean z3 = false;
                        i = 0;
                        while (i5 < vector.size()) {
                            C0913h c0913h = (C0913h) vector.elementAt(i5);
                            try {
                                String d = c0913h.m578d();
                                String e = c0913h.m580e();
                                String b = c0913h.m574b();
                                String g2 = c0913h.m584g();
                                String f = c0913h.m582f();
                                d = d + (d.length() > 0 ? "\n" : StringUtil.EMPTY_STRING);
                                if (e != null) {
                                    d = d + e + (e.length() > 0 ? "\n" : StringUtil.EMPTY_STRING);
                                }
                                d = d + b;
                                if (g2 != null) {
                                    d = d + ", " + g2;
                                }
                                if (f != null) {
                                    d = d + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + f;
                                }
                                if (str == null || !str.equals(c0913h.m586h())) {
                                    boolean z4;
                                    View a3 = m529a(getContext(), d, i);
                                    int id2 = a3.getId();
                                    this.f705o.add(c0913h.m586h());
                                    m525a(a3);
                                    if (z3) {
                                        z4 = z3;
                                    } else {
                                        setNextFocusDownId(id2);
                                        z4 = true;
                                    }
                                    boolean z5 = z4;
                                    i2 = i + 1;
                                    z3 = z5;
                                    i5++;
                                    i = i2;
                                } else {
                                    i2 = i;
                                    i5++;
                                    i = i2;
                                }
                            } catch (Throwable th2) {
                                i2 = i;
                            }
                        }
                        if (this.f697f.size() == 0) {
                            View view = new View(getContext());
                            view.setMinimumWidth(10);
                            view.setMinimumHeight(10);
                            m525a(view);
                        }
                        if (i == 0) {
                            a.setText(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
                        }
                    }
                default:
            }
        }
    }

    public final void m543d(String str) {
        this.f710u = str;
        f695q = false;
        C08791.m465b();
    }

    public final void m544l() {
        switch (C08911.f681a[this.f700i.ordinal()]) {
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                if (this.f696e) {
                    this.f696e = false;
                    C0919b.m619e().m656a("delegate", (Object) this);
                }
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                C0919b.m619e().m656a("delegate", (Object) this);
                if (this.f696e) {
                    this.f696e = false;
                } else {
                    C0919b.m619e().m653a(7);
                }
            default:
        }
    }

    public final void onClick(View view) {
        if (this.f707r == 0) {
            this.f704n.m454d();
        }
        super.onClick(view);
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                if (isClickable()) {
                    setBackgroundDrawable(this.f699h);
                    break;
                }
                break;
            default:
                setBackgroundDrawable(this.f698g);
                break;
        }
        return false;
    }
}
