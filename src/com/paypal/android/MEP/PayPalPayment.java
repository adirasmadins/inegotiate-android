package com.paypal.android.MEP;

import com.google.gdata.util.common.base.StringUtil;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Iterator;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class PayPalPayment implements Serializable {
    private static final long serialVersionUID = 1;
    private String f546a;
    private String f547b;
    private BigDecimal f548c;
    private PayPalInvoiceData f549d;
    private int f550e;
    private int f551f;
    private String f552g;
    private String f553h;
    private String f554i;
    private String f555j;

    public PayPalPayment() {
        this.f546a = null;
        this.f547b = null;
        this.f548c = null;
        this.f549d = null;
        this.f550e = 3;
        this.f551f = 22;
        this.f552g = null;
        this.f553h = null;
        this.f554i = null;
        this.f555j = null;
    }

    public PayPalPayment(String str, Currency currency, int i, PayPalInvoiceData payPalInvoiceData, String str2, String str3, String str4, String str5) {
        this.f547b = str.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, StringUtil.EMPTY_STRING);
        this.f546a = currency.getCurrencyCode();
        this.f549d = payPalInvoiceData;
        this.f550e = i;
        this.f551f = 22;
        this.f552g = str3;
        this.f553h = str2;
        this.f554i = str4;
        this.f555j = str5;
        this.f548c = new BigDecimal(0);
        Iterator it = payPalInvoiceData.f538a.iterator();
        while (it.hasNext()) {
            this.f548c = this.f548c.add(((PayPalInvoiceItem) it.next()).f541a);
        }
        this.f548c = this.f548c.setScale(2, 4);
    }

    public String getCurrencyType() {
        return this.f546a;
    }

    public String getCustomID() {
        return this.f552g;
    }

    @Deprecated
    public String getDescription() {
        return this.f555j;
    }

    public PayPalInvoiceData getInvoiceData() {
        return this.f549d;
    }

    public String getIpnUrl() {
        return this.f554i;
    }

    public String getMemo() {
        return this.f555j;
    }

    public String getMerchantName() {
        return this.f553h;
    }

    public int getPaymentSubtype() {
        return this.f551f;
    }

    public int getPaymentType() {
        return this.f550e;
    }

    public String getRecipient() {
        return this.f547b;
    }

    public BigDecimal getSubtotal() {
        return this.f548c;
    }

    public void setCurrencyType(String str) {
        this.f546a = str.toUpperCase();
    }

    public void setCurrencyType(Currency currency) {
        this.f546a = currency.getCurrencyCode();
    }

    public void setCustomID(String str) {
        this.f552g = str;
    }

    @Deprecated
    public void setDescription(String str) {
        this.f555j = str;
    }

    public void setInvoiceData(PayPalInvoiceData payPalInvoiceData) {
        this.f549d = payPalInvoiceData;
    }

    public void setIpnUrl(String str) {
        this.f554i = str;
    }

    public void setMemo(String str) {
        this.f555j = str;
    }

    public void setMerchantName(String str) {
        this.f553h = str;
    }

    public void setPaymentSubtype(int i) {
        this.f551f = i;
    }

    public void setPaymentType(int i) {
        this.f550e = i;
    }

    public void setRecipient(String str) {
        this.f547b = str.replace(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, StringUtil.EMPTY_STRING);
    }

    public void setSubtotal(BigDecimal bigDecimal) {
        this.f548c = bigDecimal.setScale(2, 4);
    }
}
