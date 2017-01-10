package com.paypal.android.MEP;

import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.p003a.C0925h;
import java.io.Serializable;
import java.math.BigDecimal;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class PayPalReceiverDetails implements Serializable {
    private static final long serialVersionUID = 3;
    private String f572a;
    private BigDecimal f573b;
    private PayPalInvoiceData f574c;
    private int f575d;
    private int f576e;
    private String f577f;
    private String f578g;
    private String f579h;
    private boolean f580i;

    public PayPalReceiverDetails() {
        this.f572a = null;
        this.f573b = null;
        this.f574c = null;
        this.f575d = 3;
        this.f576e = 22;
        this.f577f = null;
        this.f578g = null;
        this.f579h = null;
        this.f580i = false;
    }

    public String getCustomID() {
        return this.f578g;
    }

    public String getDescription() {
        return this.f577f;
    }

    public PayPalInvoiceData getInvoiceData() {
        return this.f574c;
    }

    public boolean getIsPrimary() {
        return this.f580i;
    }

    public String getMerchantName() {
        return this.f579h;
    }

    public int getPaymentSubtype() {
        return this.f576e;
    }

    public int getPaymentType() {
        return this.f575d;
    }

    public String getRecipient() {
        return this.f572a;
    }

    public BigDecimal getSubtotal() {
        return this.f573b;
    }

    public BigDecimal getTotal() {
        BigDecimal add = BigDecimal.ZERO.add(this.f573b);
        if (this.f574c == null) {
            return add;
        }
        if (this.f574c.getTax() != null) {
            add = add.add(this.f574c.getTax());
        }
        return this.f574c.getShipping() != null ? add.add(this.f574c.getShipping()) : add;
    }

    public boolean isEmailRecipient() {
        return C0925h.m686d(this.f572a);
    }

    public boolean isPhoneRecipient() {
        return C0925h.m687e(this.f572a);
    }

    public void setCustomID(String str) {
        this.f578g = str;
    }

    public void setDescription(String str) {
        this.f577f = str;
    }

    public void setInvoiceData(PayPalInvoiceData payPalInvoiceData) {
        this.f574c = payPalInvoiceData;
    }

    public void setIsPrimary(boolean z) {
        this.f580i = z;
    }

    public void setMerchantName(String str) {
        this.f579h = str;
    }

    public void setPaymentSubtype(int i) {
        this.f576e = i;
    }

    public void setPaymentType(int i) {
        this.f575d = i;
    }

    public void setRecipient(String str) {
        this.f572a = str.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, StringUtil.EMPTY_STRING);
    }

    public void setSubtotal(BigDecimal bigDecimal) {
        this.f573b = bigDecimal.setScale(2, 4);
    }
}
