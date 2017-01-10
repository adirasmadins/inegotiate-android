package com.paypal.android.MEP.p002b;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Build.VERSION;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.amazonaws.javax.xml.stream.xerces.util.XMLChar;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.PayPal;
import com.paypal.android.MEP.PayPalActivity;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* renamed from: com.paypal.android.MEP.b.e */
public final class C0901e extends RelativeLayout implements OnClickListener {
    private boolean f716a;
    private int f717b;
    private LinearLayout f718c;
    private LinearLayout f719d;
    private ImageView f720e;
    private ImageView f721f;
    private ImageView f722g;
    private ImageView f723h;
    private TextView f724i;
    private EditText f725j;
    private EditText f726k;
    private GradientDrawable f727l;

    public C0901e(Context context) {
        int i;
        super(context);
        PayPal instance = PayPal.getInstance();
        setLayoutParams(new LayoutParams(-1, -2));
        setPadding(5, 5, 5, 5);
        this.f718c = new LinearLayout(context);
        this.f718c.setId(5001);
        this.f718c.setBackgroundColor(0);
        this.f718c.setOrientation(0);
        this.f718c.setGravity(3);
        this.f718c.setPadding(5, 0, 5, 0);
        if (instance.isLightCountry()) {
            i = 0;
        } else {
            this.f720e = C0922e.m672a(context, "tab-selected-email.png");
            this.f720e.setPadding(5, 0, 5, 0);
            this.f720e.setFocusable(false);
            this.f718c.addView(this.f720e);
            this.f721f = C0922e.m672a(context, "tab-unselected-email.png");
            this.f721f.setPadding(5, 0, 5, 0);
            this.f721f.setOnClickListener(this);
            this.f721f.setFocusable(false);
            this.f718c.addView(this.f721f);
            this.f722g = C0922e.m672a(context, "tab-selected-phone.png");
            this.f722g.setPadding(5, 0, 5, 0);
            this.f722g.setFocusable(false);
            this.f718c.addView(this.f722g);
            this.f723h = C0922e.m672a(context, "tab-unselected-phone.png");
            this.f723h.setPadding(5, 0, 5, 0);
            this.f723h.setOnClickListener(this);
            this.f723h.setFocusable(false);
            this.f718c.addView(this.f723h);
            i = -1;
        }
        ViewGroup.LayoutParams layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(9);
        this.f718c.setLayoutParams(layoutParams);
        this.f719d = new LinearLayout(context);
        this.f719d.setId(5002);
        this.f727l = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-789517, -3355444});
        this.f727l.setCornerRadius(5.0f);
        this.f727l.setStroke(1, -5197648);
        this.f719d.setBackgroundDrawable(this.f727l);
        this.f719d.setOrientation(1);
        this.f719d.setGravity(3);
        this.f719d.setPadding(10, 5, 10, 5);
        layoutParams = new LayoutParams(-1, -2);
        layoutParams.addRule(5, this.f718c.getId());
        layoutParams.addRule(3, this.f718c.getId());
        layoutParams.setMargins(0, i, 0, 0);
        this.f719d.setLayoutParams(layoutParams);
        this.f724i = new TextView(context);
        this.f724i.setId(5003);
        this.f724i.setTypeface(Typeface.create("Helvetica", 1));
        this.f724i.setTextSize(16.0f);
        this.f724i.setTextColor(-16777216);
        ViewGroup.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams2.setMargins(0, 2, 0, 2);
        this.f724i.setLayoutParams(layoutParams2);
        this.f719d.addView(this.f724i);
        this.f725j = new EditText(context);
        this.f725j.setId(5004);
        this.f725j.setLayoutParams(layoutParams2);
        this.f725j.setSingleLine(true);
        this.f719d.addView(this.f725j);
        this.f726k = new EditText(context);
        this.f726k.setId(5005);
        this.f726k.setLayoutParams(layoutParams2);
        this.f726k.setSingleLine(true);
        this.f719d.addView(this.f726k);
        addView(this.f718c);
        addView(this.f719d);
        if (!VERSION.SDK.equals("3")) {
            bringChildToFront(this.f718c);
        }
        PayPal.logd("LoginWidget", "Setup login tab, authMethod " + Integer.toString(instance.getAuthMethod()));
        if (instance.getAuthMethod() == 1 && instance.isHeavyCountry()) {
            this.f716a = false;
            m549b(instance);
            return;
        }
        m548a(instance);
    }

    private void m548a(PayPal payPal) {
        PayPal.logd("LoginWidget", "Setup login tab for email");
        if (!payPal.isLightCountry()) {
            this.f720e.setVisibility(0);
            this.f721f.setVisibility(8);
            this.f722g.setVisibility(8);
            this.f723h.setVisibility(0);
        }
        this.f716a = true;
        this.f724i.setText(C0925h.m680a("ANDROID_login_with_email_and_password") + ":");
        this.f725j.setVisibility(0);
        this.f725j.setHint(C0925h.m680a("ANDROID_email_field"));
        this.f725j.setInputType(32);
        this.f725j.setText(payPal.getAccountEmail());
        this.f726k.setText(StringUtil.EMPTY_STRING);
        this.f726k.setHint(C0925h.m680a("ANDROID_password_field"));
        this.f726k.setInputType(XMLChar.MASK_NCNAME);
        this.f726k.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.f717b = 0;
    }

    private void m549b(PayPal payPal) {
        int i = 0;
        PayPal.logd("LoginWidget", "Setup login tab for PIN");
        if (!payPal.isLightCountry()) {
            this.f720e.setVisibility(8);
            this.f721f.setVisibility(0);
            this.f722g.setVisibility(0);
            this.f723h.setVisibility(8);
        }
        if (this.f716a) {
            this.f724i.setText(C0925h.m680a("ANDROID_login_with_phone_and_pin") + ":");
        } else {
            this.f724i.setText(C0925h.m680a("ANDROID_login_with_pin") + ":");
        }
        EditText editText = this.f725j;
        if (!this.f716a) {
            i = 8;
        }
        editText.setVisibility(i);
        this.f725j.setHint(C0925h.m680a("ANDROID_phone_field"));
        this.f725j.setInputType(3);
        this.f725j.setText(payPal.getAccountPhone());
        this.f726k.setText(StringUtil.EMPTY_STRING);
        this.f726k.setHint(C0925h.m680a("ANDROID_pin_field"));
        this.f726k.setInputType(3);
        this.f726k.setTransformationMethod(PasswordTransformationMethod.getInstance());
        this.f717b = 1;
    }

    public final String m550a() {
        return this.f725j.getText().toString().replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, StringUtil.EMPTY_STRING);
    }

    public final String m551b() {
        return this.f726k.getText().toString();
    }

    public final EditText m552c() {
        return this.f725j;
    }

    public final EditText m553d() {
        return this.f726k;
    }

    public final void m554e() {
        try {
            ((InputMethodManager) PayPalActivity.getInstance().getSystemService("input_method")).hideSoftInputFromWindow(this.f725j.getWindowToken(), 0);
        } catch (Exception e) {
        }
        try {
            ((InputMethodManager) PayPalActivity.getInstance().getSystemService("input_method")).hideSoftInputFromWindow(this.f726k.getWindowToken(), 0);
        } catch (Exception e2) {
        }
    }

    public final void onClick(View view) {
        if (view == this.f721f) {
            if (this.f717b != 0) {
                m548a(PayPal.getInstance());
            }
        } else if (view == this.f723h && this.f717b != 1) {
            m549b(PayPal.getInstance());
        }
    }
}
