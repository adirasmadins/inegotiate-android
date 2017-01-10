package com.paypal.android.MEP;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.p003a.C0919b;
import com.paypal.android.p003a.C0924g;
import com.paypal.android.p003a.C0925h;
import com.paypal.android.p003a.C0931m;
import com.paypal.android.p005c.C0926a;
import java.io.Serializable;
import java.util.Locale;
import junit.framework.Assert;

public final class PayPal {
    public static final int AUTH_SETTING_DISABLED = 0;
    public static final int AUTH_SETTING_ENABLED = 1;
    public static final int BUTTON_152x33 = 0;
    public static final int BUTTON_194x37 = 1;
    public static final int BUTTON_278x43 = 2;
    public static final int BUTTON_294x45 = 3;
    public static final int ENV_LIVE = 1;
    public static final int ENV_NONE = 2;
    public static final int ENV_SANDBOX = 0;
    public static final int FEEPAYER_EACHRECEIVER = 0;
    public static final int FEEPAYER_PRIMARYRECEIVER = 2;
    public static final int FEEPAYER_SECONDARYONLY = 3;
    public static final int FEEPAYER_SENDER = 1;
    public static final int LOGIN_VIA_DRT = 2;
    public static final int LOGIN_VIA_EMAIL = 0;
    public static final int LOGIN_VIA_EMAIL_EBAY_USER = 3;
    public static final int LOGIN_VIA_PHONE = 1;
    public static final int NUM_STYLES = 4;
    public static final int PAYMENT_SUBTYPE_AFFILIATE = 0;
    public static final int PAYMENT_SUBTYPE_B2B = 1;
    public static final int PAYMENT_SUBTYPE_CHILDCARE = 15;
    public static final int PAYMENT_SUBTYPE_CONTRACTORS = 17;
    public static final int PAYMENT_SUBTYPE_DONATIONS = 6;
    public static final int PAYMENT_SUBTYPE_ENTERTAINMENT = 18;
    public static final int PAYMENT_SUBTYPE_EVENTS = 16;
    public static final int PAYMENT_SUBTYPE_GOVERNMENT = 9;
    public static final int PAYMENT_SUBTYPE_INSURANCE = 10;
    public static final int PAYMENT_SUBTYPE_INVOICE = 20;
    public static final int PAYMENT_SUBTYPE_MEDICAL = 14;
    public static final int PAYMENT_SUBTYPE_MORTGAGE = 13;
    public static final int PAYMENT_SUBTYPE_NONE = 22;
    public static final int PAYMENT_SUBTYPE_PAYROLL = 2;
    public static final int PAYMENT_SUBTYPE_REBATES = 3;
    public static final int PAYMENT_SUBTYPE_REFUNDS = 4;
    public static final int PAYMENT_SUBTYPE_REIMBURSEMENTS = 5;
    public static final int PAYMENT_SUBTYPE_REIMBUSEMENTS = 5;
    public static final int PAYMENT_SUBTYPE_REMITTANCES = 11;
    public static final int PAYMENT_SUBTYPE_RENT = 12;
    public static final int PAYMENT_SUBTYPE_TOURISM = 19;
    public static final int PAYMENT_SUBTYPE_TRANSFER = 21;
    public static final int PAYMENT_SUBTYPE_TUITION = 8;
    public static final int PAYMENT_SUBTYPE_UTILITIES = 7;
    public static final int PAYMENT_TYPE_GOODS = 0;
    public static final int PAYMENT_TYPE_NONE = 3;
    public static final int PAYMENT_TYPE_PERSONAL = 2;
    public static final int PAYMENT_TYPE_SERVICE = 1;
    public static final int PAY_TYPE_CHAINED = 2;
    public static final int PAY_TYPE_PARALLEL = 1;
    public static final int PAY_TYPE_PREAPPROVAL = 3;
    public static final int PAY_TYPE_SIMPLE = 0;
    private static final String[] f514a;
    private static final String[] f515b;
    private static C0926a f516f;
    private C0866a f517c;
    private final C0867b f518d;
    private Boolean f519e;
    private boolean f520g;
    private String f521h;
    private String f522i;

    /* renamed from: com.paypal.android.MEP.PayPal.a */
    private class C0866a {
        protected PayPalAdvancedPayment f493a;
        protected PayPalPreapproval f494b;
        protected CheckoutButton f495c;
        protected Context f496d;
        protected String f497e;
        protected String f498f;
        protected String f499g;
        protected String f500h;
        protected String f501i;
        protected int f502j;
        protected int f503k;
        protected int f504l;
        protected boolean f505m;
        protected boolean f506n;

        public C0866a(PayPal payPal) {
            this.f500h = "https://www.paypal.com";
            this.f501i = "https://www.paypal.com";
            this.f493a = null;
            this.f494b = null;
            this.f495c = null;
        }
    }

    /* renamed from: com.paypal.android.MEP.PayPal.b */
    private class C0867b {
        protected String f507a;
        protected String f508b;
        protected String f509c;
        protected int f510d;
        protected int f511e;
        protected boolean f512f;
        final /* synthetic */ PayPal f513g;

        public C0867b(PayPal payPal) {
            this.f513g = payPal;
        }
    }

    static {
        String[] strArr = new String[PAYMENT_SUBTYPE_REFUNDS];
        strArr[PAYMENT_TYPE_GOODS] = "GOODS";
        strArr[PAY_TYPE_PARALLEL] = "SERVICE";
        strArr[PAY_TYPE_CHAINED] = "PERSONAL";
        strArr[PAY_TYPE_PREAPPROVAL] = "NONE";
        f514a = strArr;
        f515b = new String[]{"AFFILIATE_PAYMENTS", "B2B", "PAYROLL", "REBATES", "REFUNDS", "REIMBURSEMENTS", "DONATIONS", "UTILITIES", "TUITION", "GOVERNMENT", "INSURANCE", "REMITTANCES", "RENT", "MORTGAGE", "MEDICAL", "CHILD_CARE", "EVENT_PLANNING", "GENERAL_CONTRACTORS", "ENTERTAINMENT", "TOURISM", "INVOICE", "TRANSFER", "NONE"};
        f516f = null;
    }

    private PayPal() {
        this.f519e = Boolean.valueOf(false);
        this.f520g = false;
        this.f521h = null;
        this.f522i = StringUtil.EMPTY_STRING;
        this.f517c = new C0866a(this);
        this.f518d = new C0867b(this);
        resetAccount();
    }

    private static String m424a(String str) {
        return str == null ? StringUtil.EMPTY_STRING : str;
    }

    public static String getBuild() {
        String str = "1.5.5.44";
        return str.substring(str.lastIndexOf(46) + PAY_TYPE_PARALLEL);
    }

    public static PayPal getInstance() {
        return PayPalActivity._paypal;
    }

    public static String getPaySubtype(int i) {
        return f515b[i];
    }

    public static String getPayType(int i) {
        return f514a[i];
    }

    public static String getVersion() {
        return "1.5.5.44";
    }

    public static String getVersionWithoutBuild() {
        String str = "1.5.5.44";
        return str.substring(PAYMENT_TYPE_GOODS, str.lastIndexOf(46));
    }

    public static PayPal initWithAppID(Context context, String str, int i) throws IllegalStateException {
        if (PayPalActivity._paypal != null) {
            PayPalActivity._paypal.deinitialize();
        }
        PayPal payPal = new PayPal();
        PayPalActivity._paypal = payPal;
        payPal.f517c.f496d = context;
        PayPalActivity._paypal.f517c.f497e = str;
        PayPalActivity._paypal.f517c.f502j = i;
        PayPalActivity._paypal.f517c.f506n = false;
        PayPalActivity._paypal.f517c.f505m = true;
        C0919b.m616c();
        payPal = PayPalActivity._paypal;
        C0924g.m674a();
        Locale locale = Locale.getDefault();
        String str2 = locale.getLanguage() + '_' + locale.getCountry();
        payPal.setLanguage(str2);
        C0925h.m685c(str2);
        if (!PayPalActivity._paypal.f519e.booleanValue()) {
            synchronized (PayPalActivity._paypal) {
                try {
                    PayPalActivity._paypal.wait();
                } catch (InterruptedException e) {
                }
            }
        }
        return PayPalActivity._paypal;
    }

    public static int logd(String str, String str2) {
        return PAYMENT_TYPE_GOODS;
    }

    public static int loge(String str, String str2) {
        return Log.e(str, str2);
    }

    public final boolean canShowCart() {
        if (getPayType() == PAY_TYPE_PREAPPROVAL) {
            return false;
        }
        if (getPayment().getReceivers().size() == PAY_TYPE_PARALLEL) {
            PayPalReceiverDetails payPalReceiverDetails = (PayPalReceiverDetails) getPayment().getReceivers().get(PAYMENT_TYPE_GOODS);
            if (payPalReceiverDetails.getInvoiceData() == null) {
                return false;
            }
            PayPalInvoiceData invoiceData = payPalReceiverDetails.getInvoiceData();
            if (invoiceData.getTax() == null && invoiceData.getShipping() == null && invoiceData.getInvoiceItems().size() == 0) {
                return false;
            }
        }
        return true;
    }

    public final Intent checkout(PayPalAdvancedPayment payPalAdvancedPayment, Context context) {
        return checkout(payPalAdvancedPayment, context, null, null);
    }

    public final Intent checkout(PayPalAdvancedPayment payPalAdvancedPayment, Context context, PayPalResultDelegate payPalResultDelegate) {
        return checkout(payPalAdvancedPayment, context, null, payPalResultDelegate);
    }

    public final Intent checkout(PayPalAdvancedPayment payPalAdvancedPayment, Context context, PaymentAdjuster paymentAdjuster) {
        return checkout(payPalAdvancedPayment, context, paymentAdjuster, null);
    }

    public final Intent checkout(PayPalAdvancedPayment payPalAdvancedPayment, Context context, PaymentAdjuster paymentAdjuster, PayPalResultDelegate payPalResultDelegate) {
        this.f517c.f493a = payPalAdvancedPayment;
        this.f517c.f494b = null;
        Intent intent = new Intent(context, PayPalActivity.class);
        intent.putExtra(PayPalActivity.EXTRA_PAYMENT_INFO, payPalAdvancedPayment);
        if (paymentAdjuster != null) {
            intent.putExtra(PayPalActivity.EXTRA_PAYMENT_ADJUSTER, (Serializable) paymentAdjuster);
        }
        if (payPalResultDelegate != null) {
            intent.putExtra(PayPalActivity.EXTRA_RESULT_DELEGATE, (Serializable) payPalResultDelegate);
        }
        return intent;
    }

    public final Intent checkout(PayPalPayment payPalPayment, Context context) {
        return checkout(payPalPayment, context, null, null);
    }

    public final Intent checkout(PayPalPayment payPalPayment, Context context, PayPalResultDelegate payPalResultDelegate) {
        return checkout(payPalPayment, context, null, payPalResultDelegate);
    }

    public final Intent checkout(PayPalPayment payPalPayment, Context context, PaymentAdjuster paymentAdjuster) {
        return checkout(payPalPayment, context, paymentAdjuster, null);
    }

    public final Intent checkout(PayPalPayment payPalPayment, Context context, PaymentAdjuster paymentAdjuster, PayPalResultDelegate payPalResultDelegate) {
        PayPalAdvancedPayment payPalAdvancedPayment = new PayPalAdvancedPayment();
        payPalAdvancedPayment.setCurrencyType(payPalPayment.getCurrencyType());
        payPalAdvancedPayment.setIpnUrl(payPalPayment.getIpnUrl());
        payPalAdvancedPayment.setMemo(payPalPayment.getMemo());
        PayPalReceiverDetails payPalReceiverDetails = new PayPalReceiverDetails();
        payPalReceiverDetails.setRecipient(payPalPayment.getRecipient());
        payPalReceiverDetails.setSubtotal(payPalPayment.getSubtotal());
        payPalReceiverDetails.setInvoiceData(payPalPayment.getInvoiceData());
        payPalReceiverDetails.setPaymentType(payPalPayment.getPaymentType());
        payPalReceiverDetails.setPaymentSubtype(payPalPayment.getPaymentSubtype());
        payPalReceiverDetails.setDescription(payPalPayment.getMemo());
        payPalReceiverDetails.setCustomID(payPalPayment.getCustomID());
        payPalReceiverDetails.setMerchantName(payPalPayment.getMerchantName());
        payPalReceiverDetails.setIsPrimary(false);
        payPalAdvancedPayment.getReceivers().add(payPalReceiverDetails);
        return checkout(payPalAdvancedPayment, context, paymentAdjuster, payPalResultDelegate);
    }

    public final void deinitialize() {
        C0919b.m617d();
        PayPalActivity._paypal = null;
        f516f = null;
    }

    public final String getAccountCountryDialingCode() {
        return this.f522i.length() > 0 ? this.f522i : C0919b.m636m();
    }

    public final String getAccountEmail() {
        return m424a(this.f518d.f508b);
    }

    public final String getAccountName() {
        return m424a(this.f518d.f507a);
    }

    public final String getAccountPhone() {
        return this.f518d.f509c;
    }

    public final String getAdjustPaymentError() {
        return this.f521h == null ? C0925h.m680a("ANDROID_calc_error") : this.f521h;
    }

    public final String getAppID() {
        return this.f517c.f497e;
    }

    public final int getAuthMethod() {
        return this.f518d.f510d;
    }

    public final int getAuthSetting() {
        return this.f518d.f511e;
    }

    public final String getCancelUrl() {
        return this.f517c.f500h;
    }

    public final CheckoutButton getCheckoutButton(Context context, int i, int i2) {
        this.f517c.f495c = new CheckoutButton(context);
        this.f517c.f495c.m423a(i, i2);
        this.f517c.f503k = i2;
        this.f517c.f495c.setActive(true);
        return this.f517c.f495c;
    }

    public final float getDensity() {
        return getParentContext().getResources().getDisplayMetrics().density;
    }

    public final String getDeviceReferenceToken() {
        return C0931m.m711b();
    }

    public final boolean getDynamicAmountCalculationEnabled() {
        return this.f517c.f506n;
    }

    public final int getFeesPayer() {
        return this.f517c.f504l;
    }

    public final String getFlowContext() {
        return null;
    }

    public final boolean getIsRememberMe() {
        return this.f520g;
    }

    public final String getLanguage() {
        return this.f517c.f499g;
    }

    public final Context getParentContext() {
        return this.f517c.f496d;
    }

    public final int getPayType() {
        return (this.f517c.f493a != null || this.f517c.f494b == null) ? this.f517c.f493a.getReceivers().size() == PAY_TYPE_PARALLEL ? PAYMENT_TYPE_GOODS : this.f517c.f493a.hasPrimaryReceiever() ? PAY_TYPE_CHAINED : PAY_TYPE_PARALLEL : PAY_TYPE_PREAPPROVAL;
    }

    public final PayPalAdvancedPayment getPayment() {
        return this.f517c.f493a;
    }

    public final PayPalPreapproval getPreapproval() {
        return this.f517c.f494b;
    }

    public final String getPreapprovalKey() {
        return this.f517c.f498f;
    }

    public final String getReturnUrl() {
        return this.f517c.f501i;
    }

    public final int getServer() {
        return this.f517c.f502j;
    }

    public final String getSessionToken() {
        return null;
    }

    public final boolean getShippingEnabled() {
        return this.f517c.f505m;
    }

    public final int getTextType() {
        return this.f517c.f503k;
    }

    public final boolean hasCreatedPIN() {
        return this.f518d.f512f;
    }

    public final boolean isHeavyCountry() {
        String iSO3Country = Locale.getDefault().getISO3Country();
        return iSO3Country.equals("USA") || iSO3Country.equals("GBR") || iSO3Country.equals("CAN") || iSO3Country.equals("AUS") || iSO3Country.equals("ESP") || iSO3Country.equals("ITA") || iSO3Country.equals("FRA") || iSO3Country.equals("SGP") || iSO3Country.equals("MYS");
    }

    public final boolean isLibraryInitialized() {
        return PayPalActivity._paypal == null ? false : this.f519e.booleanValue();
    }

    public final boolean isLightCountry() {
        return !isHeavyCountry();
    }

    public final boolean isPersonalPayment() {
        if (this.f517c.f493a == null) {
            return false;
        }
        for (int i = PAYMENT_TYPE_GOODS; i < this.f517c.f493a.getReceivers().size(); i += PAY_TYPE_PARALLEL) {
            if (((PayPalReceiverDetails) this.f517c.f493a.getReceivers().get(i)).getPaymentType() != PAY_TYPE_CHAINED) {
                return false;
            }
        }
        return true;
    }

    public final void onInitializeCompletedError(int i, Object obj) {
    }

    public final void onInitializeCompletedOK(int i, Object obj) {
    }

    public final Intent preapprove(PayPalPreapproval payPalPreapproval, Context context) {
        return preapprove(payPalPreapproval, context, null);
    }

    public final Intent preapprove(PayPalPreapproval payPalPreapproval, Context context, PayPalResultDelegate payPalResultDelegate) {
        this.f517c.f494b = payPalPreapproval;
        this.f517c.f493a = null;
        Intent intent = new Intent(context, PayPalActivity.class);
        intent.putExtra(PayPalActivity.EXTRA_PREAPPROVAL_INFO, payPalPreapproval);
        if (payPalResultDelegate != null) {
            intent.putExtra(PayPalActivity.EXTRA_RESULT_DELEGATE, (Serializable) payPalResultDelegate);
        }
        return intent;
    }

    public final void resetAccount() {
        this.f520g = false;
        C0867b c0867b = this.f518d;
        c0867b.f513g.setAccountName(null);
        c0867b.f513g.setAccountEmail(null);
        c0867b.f513g.setAccountPhone(null);
        c0867b.f513g.setAuthMethod(PAYMENT_TYPE_GOODS);
        c0867b.f513g.setAuthSetting(PAYMENT_TYPE_GOODS);
        c0867b.f513g.setPINCreated(false);
    }

    public final void setAccountCountryDialingCode(String str) {
        Assert.assertNotNull(StringUtil.EMPTY_STRING, str);
        this.f522i = str;
    }

    public final void setAccountEmail(String str) {
        this.f518d.f508b = str;
    }

    public final void setAccountName(String str) {
        this.f518d.f507a = str;
    }

    public final void setAccountPhone(String str) {
        this.f518d.f509c = str;
    }

    public final void setAdjustPaymentError(String str) {
        this.f521h = str;
    }

    public final void setAuthMethod(int i) {
        this.f518d.f510d = i;
    }

    public final void setAuthSetting(int i) {
        this.f518d.f511e = i;
    }

    public final void setCancelUrl(String str) {
        this.f517c.f500h = str;
    }

    public final void setDeviceReferenceToken(String str) {
    }

    public final void setDynamicAmountCalculationEnabled(boolean z) {
        this.f517c.f506n = z;
    }

    public final void setFeesPayer(int i) {
        this.f517c.f504l = i;
    }

    public final void setIsRememberMe(boolean z) {
        this.f520g = z;
    }

    public final void setLanguage(String str) {
        if (!C0925h.m684b(str)) {
            str = "en_US";
        }
        this.f517c.f499g = str;
        C0925h.m685c(this.f517c.f499g);
    }

    public final void setLibraryInitialized(boolean z) {
        synchronized (PayPalActivity._paypal) {
            PayPalActivity._paypal.f519e = Boolean.valueOf(z);
            PayPalActivity._paypal.notifyAll();
        }
    }

    public final void setPINCreated(boolean z) {
        this.f518d.f512f = z;
    }

    public final void setPreapprovalKey(String str) {
        this.f517c.f498f = str;
    }

    public final void setReturnUrl(String str) {
        this.f517c.f501i = str;
    }

    public final void setSessionToken(String str) {
    }

    public final void setShippingEnabled(boolean z) {
        this.f517c.f505m = z;
    }

    public final boolean shouldShowFees() {
        String iSO3Country = Locale.getDefault().getISO3Country();
        boolean z = (Locale.GERMANY.getISO3Country().compareTo(iSO3Country) == 0 || Locale.ITALY.getISO3Country().compareTo(iSO3Country) == 0) ? true : PAYMENT_TYPE_GOODS;
        return !z && isPersonalPayment();
    }

    public final void shutdown() {
        C0925h.m683a();
        C0924g.m678b();
        this.f517c = null;
    }
}
