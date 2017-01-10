package com.paypal.android.MEP;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.StateListDrawable;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.p000a.C0882d;
import com.paypal.android.p003a.C0919b;
import com.paypal.android.p003a.C0922e;
import com.paypal.android.p003a.C0925h;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public final class CheckoutButton extends LinearLayout implements OnClickListener {
    public static final int TEXT_DONATE = 1;
    public static final int TEXT_PAY = 0;
    private static boolean f467p;
    private int f468a;
    private int f469b;
    private int f470c;
    private int f471d;
    private boolean f472e;
    private LinearLayout f473f;
    private GradientDrawable f474g;
    private TextView f475h;
    private TextView f476i;
    private LinearLayout f477j;
    private Context f478k;
    private StateListDrawable f479l;
    private TextView f480m;
    private TextView f481n;
    private ImageView f482o;

    static {
        f467p = false;
    }

    public CheckoutButton(Context context) {
        super(context);
        this.f478k = context;
    }

    protected final void m423a(int i, int i2) {
        int i3;
        float f;
        int i4;
        this.f468a = i;
        switch (this.f468a) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                this.f469b = 152;
                this.f470c = 33;
                this.f471d = 18;
                i3 = 22;
                f = 6.0f;
                break;
            case JsonWriteContext.STATUS_OK_AFTER_COLON /*2*/:
                this.f469b = 278;
                this.f470c = 43;
                this.f471d = 22;
                i3 = 30;
                f = 10.0f;
                break;
            case JsonWriteContext.STATUS_OK_AFTER_SPACE /*3*/:
                this.f469b = 294;
                this.f470c = 45;
                this.f471d = 28;
                i3 = 40;
                f = 10.0f;
                break;
            default:
                this.f469b = 194;
                this.f470c = 37;
                this.f471d = 20;
                i3 = 22;
                f = 6.0f;
                break;
        }
        Typeface create = Typeface.create("Helvetica", 0);
        float f2 = (2.5f * ((float) this.f468a)) + 10.0f;
        float f3 = ((float) this.f471d) - 8.0f;
        float density = PayPal.getInstance().getDensity();
        this.f469b = (int) (((float) this.f469b) * density);
        this.f470c = (int) (((float) this.f470c) * density);
        this.f471d = (int) (density * ((float) this.f471d));
        setOrientation(TEXT_DONATE);
        setPadding(0, 0, 0, 0);
        this.f474g = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-1, -1});
        this.f474g.setSize(this.f469b, this.f470c + this.f471d);
        this.f474g.setCornerRadius(f);
        this.f474g.setStroke(TEXT_DONATE, -5789785);
        this.f473f = new LinearLayout(this.f478k);
        this.f473f.setLayoutParams(new LayoutParams(-1, this.f471d));
        this.f473f.setOrientation(0);
        this.f473f.setPadding(0, 2, 0, 0);
        this.f475h = new TextView(this.f478k);
        this.f475h.setLayoutParams(new LayoutParams(-1, -1, 1.0f));
        this.f475h.setGravity(3);
        this.f475h.setPadding(5, 0, 0, 0);
        this.f475h.setTypeface(create, TEXT_DONATE);
        this.f475h.setTextSize(f3);
        this.f475h.setTextColor(-15066598);
        this.f475h.setSingleLine(true);
        this.f475h.setText(StringUtil.EMPTY_STRING);
        this.f475h.setOnClickListener(this);
        this.f476i = new TextView(this.f478k);
        this.f476i.setLayoutParams(new LayoutParams(-2, -1));
        this.f476i.setGravity(5);
        this.f476i.setPadding(0, 0, 5, 0);
        this.f476i.setTypeface(create);
        this.f476i.setTextSize(f3);
        this.f476i.setTextColor(-14993820);
        this.f476i.setFocusable(true);
        CharSequence spannableString = new SpannableString(C0925h.m680a("ANDROID_not_you"));
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        this.f476i.setText(spannableString);
        this.f476i.setOnClickListener(this);
        this.f473f.addView(this.f475h);
        this.f473f.addView(this.f476i);
        addView(this.f473f);
        this.f477j = new LinearLayout(this.f478k);
        this.f477j.setLayoutParams(new LayoutParams(-1, -1));
        this.f477j.setGravity(17);
        this.f477j.setOrientation(0);
        this.f477j.setPadding(2, 2, 2, 2);
        this.f477j.setOnClickListener(this);
        Drawable gradientDrawable = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-4922, -22016});
        gradientDrawable.setSize(this.f469b, this.f470c);
        gradientDrawable.setCornerRadius(f);
        gradientDrawable.setStroke(TEXT_DONATE, -3637191);
        Drawable gradientDrawable2 = new GradientDrawable(Orientation.TOP_BOTTOM, new int[]{-12951, -1937101});
        gradientDrawable2.setSize(this.f469b, this.f470c);
        gradientDrawable2.setCornerRadius(f);
        gradientDrawable2.setStroke(TEXT_DONATE, -3637191);
        this.f479l = new StateListDrawable();
        StateListDrawable stateListDrawable = this.f479l;
        int[] iArr = new int[TEXT_DONATE];
        iArr[0] = -16842919;
        stateListDrawable.addState(iArr, gradientDrawable);
        stateListDrawable = this.f479l;
        int[] iArr2 = new int[TEXT_DONATE];
        iArr2[0] = 16842919;
        stateListDrawable.addState(iArr2, gradientDrawable2);
        this.f477j.setBackgroundDrawable(this.f479l);
        String str = i2 == TEXT_DONATE ? "donate" : "pay";
        String toLowerCase = PayPal.getInstance().getLanguage().toLowerCase();
        String substring = toLowerCase.substring(0, 2);
        String[] split = C0925h.m680a("ANDROID_" + str + "_button").split("%PP", -1);
        for (i4 = 0; i4 < split.length; i4 += TEXT_DONATE) {
            int indexOf = split[0].indexOf("\\n");
            if (indexOf != -1) {
                split[i4] = split[i4].substring(0, indexOf) + '\n' + split[i4].substring(indexOf + 2);
            }
        }
        if (substring.equals("pl") || (substring.equals("fr") && str.equals("donate"))) {
            f = f2 - (2.0f + (0.5f * ((float) this.f468a)));
            i4 = 3;
        } else if (substring.equals("zh") || substring.equals("jp")) {
            f = (2.0f + (0.5f * ((float) this.f468a))) + f2;
            i4 = TEXT_DONATE;
        } else {
            f = f2;
            i4 = 3;
        }
        this.f480m = new TextView(this.f478k);
        if (split[0].equals(StringUtil.EMPTY_STRING)) {
            this.f480m.setVisibility(8);
        } else {
            this.f480m.setText(split[0]);
            this.f480m.setTypeface(create, i4);
            this.f480m.setTextSize(f);
            this.f480m.setTextColor(-14993820);
            this.f480m.setGravity(17);
            this.f480m.setVisibility(0);
        }
        this.f481n = new TextView(this.f478k);
        if (split.length <= TEXT_DONATE || split[TEXT_DONATE].equals(StringUtil.EMPTY_STRING)) {
            this.f481n.setVisibility(8);
        } else {
            this.f481n.setText(split[TEXT_DONATE]);
            this.f481n.setTypeface(create, i4);
            this.f481n.setTextSize(f);
            this.f481n.setTextColor(-14993820);
            if (split[0].equals(StringUtil.EMPTY_STRING)) {
                this.f481n.setGravity(17);
            }
            this.f481n.setVisibility(0);
        }
        str = "paypal_";
        if (toLowerCase.equals("zh_hk")) {
            str = str + "cn_";
        }
        this.f482o = C0922e.m672a(this.f478k, str + "logo_" + i3 + ".png");
        this.f482o.setVisibility(0);
        this.f477j.addView(this.f480m);
        this.f477j.addView(this.f482o);
        this.f477j.addView(this.f481n);
        addView(this.f477j);
        updateButton();
        setSelected(false);
    }

    public final void onClick(View view) {
        if (!f467p && view != this.f475h) {
            if (view == this.f476i) {
                PayPal.logd("CheckoutButton", "reset the account");
                PayPal.getInstance().resetAccount();
                C0919b.m619e().m653a(12);
                C0882d.f618a = true;
            } else if (view == this.f477j) {
                C0882d.f618a = false;
            }
            f467p = true;
            performClick();
            setActive(false);
        }
    }

    public final void setActive(boolean z) {
        setClickable(z);
        setFocusable(z);
    }

    public final void updateButton() {
        boolean z = true;
        PayPal instance = PayPal.getInstance();
        f467p = false;
        updateName();
        if (!(instance.getIsRememberMe() && instance.getAuthSetting() == TEXT_DONATE)) {
            z = false;
        }
        this.f472e = z;
        if (!this.f472e || this.f475h.getText().toString().length() <= 0) {
            this.f473f.setVisibility(8);
            setMinimumWidth(this.f469b);
            setMinimumHeight(this.f470c);
            setBackgroundColor(0);
        } else {
            this.f473f.setVisibility(0);
            setMinimumWidth(this.f469b);
            setMinimumHeight(this.f470c + this.f471d);
            setBackgroundDrawable(this.f474g);
        }
        invalidate();
    }

    public final void updateName() {
        CharSequence accountName = PayPal.getInstance().getAccountName();
        if (accountName.length() > 21) {
            accountName = accountName.substring(0, 21) + "...";
        }
        this.f475h.setText(accountName);
    }
}
