package com.paypal.android.MEP;

import java.io.Serializable;
import java.math.BigDecimal;

public class PayPalInvoiceItem implements Serializable {
    private static final long serialVersionUID = 5;
    BigDecimal f541a;
    private String f542b;
    private String f543c;
    private BigDecimal f544d;
    private int f545e;

    public PayPalInvoiceItem() {
        this.f542b = null;
        this.f543c = null;
        this.f541a = null;
        this.f544d = null;
        this.f545e = 0;
    }

    public PayPalInvoiceItem(String str, String str2, BigDecimal bigDecimal, int i) {
        this.f542b = str;
        this.f543c = str2;
        this.f544d = bigDecimal;
        this.f545e = i;
        this.f541a = bigDecimal.multiply(new BigDecimal(i).setScale(2, 4));
    }

    public String getID() {
        return this.f543c;
    }

    public String getName() {
        return this.f542b;
    }

    public int getQuantity() {
        return this.f545e;
    }

    public BigDecimal getTotalPrice() {
        return this.f541a;
    }

    public BigDecimal getUnitPrice() {
        return this.f544d;
    }

    public boolean isValid() {
        return (this.f542b == null || this.f542b.length() <= 0) ? (this.f543c == null || this.f543c.length() <= 0) ? (this.f541a == null || this.f541a.compareTo(BigDecimal.ZERO) <= 0) ? (this.f544d != null && this.f544d.compareTo(BigDecimal.ZERO) > 0) || this.f545e > 0 : true : true : true;
    }

    public void setID(String str) {
        this.f543c = str;
    }

    public void setName(String str) {
        this.f542b = str;
    }

    public void setQuantity(int i) {
        this.f545e = i;
    }

    public void setTotalPrice(BigDecimal bigDecimal) {
        this.f541a = bigDecimal.setScale(2, 4);
    }

    public void setUnitPrice(BigDecimal bigDecimal) {
        this.f544d = bigDecimal.setScale(2, 4);
    }
}
