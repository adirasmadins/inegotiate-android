package com.paypal.android.MEP;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class PayPalInvoiceData implements Serializable {
    private static final long serialVersionUID = 4;
    ArrayList<PayPalInvoiceItem> f538a;
    private BigDecimal f539b;
    private BigDecimal f540c;

    public PayPalInvoiceData() {
        this.f538a = new ArrayList();
        this.f539b = null;
        this.f540c = null;
    }

    public PayPalInvoiceData(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
        this.f538a = new ArrayList();
        this.f539b = bigDecimal;
        this.f540c = bigDecimal2;
    }

    public void add(PayPalInvoiceItem payPalInvoiceItem) {
        this.f538a.add(payPalInvoiceItem);
    }

    public ArrayList<PayPalInvoiceItem> getInvoiceItems() {
        return this.f538a;
    }

    public BigDecimal getShipping() {
        return this.f540c;
    }

    public BigDecimal getTax() {
        return this.f539b;
    }

    public void setInvoiceItems(ArrayList<PayPalInvoiceItem> arrayList) {
        this.f538a = arrayList;
    }

    public void setShipping(BigDecimal bigDecimal) {
        this.f540c = bigDecimal.setScale(2, 4);
    }

    public void setTax(BigDecimal bigDecimal) {
        this.f539b = bigDecimal.setScale(2, 4);
    }
}
