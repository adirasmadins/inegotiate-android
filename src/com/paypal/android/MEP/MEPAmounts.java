package com.paypal.android.MEP;

import java.math.BigDecimal;

public class MEPAmounts {
    private String f489a;
    private BigDecimal f490b;
    private BigDecimal f491c;
    private BigDecimal f492d;

    public String getCurrency() {
        return this.f489a;
    }

    public BigDecimal getPaymentAmount() {
        return this.f490b;
    }

    public BigDecimal getShipping() {
        return this.f492d;
    }

    public BigDecimal getTax() {
        return this.f491c;
    }

    public void setCurrency(String str) {
        this.f489a = str;
    }

    public void setPaymentAmount(String str) {
        try {
            this.f490b = new BigDecimal(str);
        } catch (NumberFormatException e) {
            this.f490b = new BigDecimal("0.0");
        }
    }

    public void setPaymentAmount(BigDecimal bigDecimal) {
        this.f490b = bigDecimal;
    }

    public void setShipping(String str) {
        try {
            this.f492d = new BigDecimal(str);
        } catch (NumberFormatException e) {
            this.f492d = new BigDecimal("0.0");
        }
    }

    public void setShipping(BigDecimal bigDecimal) {
        this.f492d = bigDecimal;
    }

    public void setTax(String str) {
        try {
            this.f491c = new BigDecimal(str);
        } catch (NumberFormatException e) {
            this.f491c = new BigDecimal("0.0");
        }
    }

    public void setTax(BigDecimal bigDecimal) {
        this.f491c = bigDecimal;
    }
}
