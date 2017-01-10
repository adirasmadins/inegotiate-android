package com.paypal.android.MEP;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;

public class PayPalAdvancedPayment implements Serializable {
    private static final long serialVersionUID = 2;
    private String f533a;
    private ArrayList<PayPalReceiverDetails> f534b;
    private String f535c;
    private String f536d;
    private String f537e;

    public PayPalAdvancedPayment() {
        this.f533a = null;
        this.f534b = new ArrayList();
        this.f535c = null;
        this.f536d = null;
        this.f537e = null;
    }

    public String getCurrencyType() {
        return this.f533a;
    }

    public String getIpnUrl() {
        return this.f535c;
    }

    public String getMemo() {
        return this.f536d;
    }

    public String getMerchantName() {
        return this.f537e;
    }

    public PayPalReceiverDetails getPrimaryReceiver() {
        for (int i = 0; i < this.f534b.size(); i++) {
            if (((PayPalReceiverDetails) this.f534b.get(i)).getIsPrimary()) {
                return (PayPalReceiverDetails) this.f534b.get(i);
            }
        }
        return null;
    }

    public ArrayList<PayPalReceiverDetails> getReceivers() {
        return this.f534b;
    }

    public BigDecimal getTotal() {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (int i = 0; i < this.f534b.size(); i++) {
            bigDecimal = bigDecimal.add(((PayPalReceiverDetails) this.f534b.get(i)).getTotal());
        }
        return bigDecimal;
    }

    public BigDecimal getTotalShipping() {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        int i = 0;
        while (i < this.f534b.size()) {
            if (!(((PayPalReceiverDetails) this.f534b.get(i)).getInvoiceData() == null || ((PayPalReceiverDetails) this.f534b.get(i)).getInvoiceData().getShipping() == null)) {
                bigDecimal = bigDecimal.add(((PayPalReceiverDetails) this.f534b.get(i)).getInvoiceData().getShipping());
            }
            i++;
        }
        return bigDecimal;
    }

    public BigDecimal getTotalSubtotal() {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        for (int i = 0; i < this.f534b.size(); i++) {
            if (((PayPalReceiverDetails) this.f534b.get(i)).getSubtotal() != null) {
                bigDecimal = bigDecimal.add(((PayPalReceiverDetails) this.f534b.get(i)).getSubtotal());
            }
        }
        return bigDecimal;
    }

    public BigDecimal getTotalTax() {
        BigDecimal bigDecimal = BigDecimal.ZERO;
        int i = 0;
        while (i < this.f534b.size()) {
            if (!(((PayPalReceiverDetails) this.f534b.get(i)).getInvoiceData() == null || ((PayPalReceiverDetails) this.f534b.get(i)).getInvoiceData().getTax() == null)) {
                bigDecimal = bigDecimal.add(((PayPalReceiverDetails) this.f534b.get(i)).getInvoiceData().getTax());
            }
            i++;
        }
        return bigDecimal;
    }

    public boolean hasPrimaryReceiever() {
        for (int i = 0; i < this.f534b.size(); i++) {
            if (((PayPalReceiverDetails) this.f534b.get(i)).getIsPrimary()) {
                return true;
            }
        }
        return false;
    }

    public boolean isValid() {
        if (this.f534b.size() <= 0) {
            return false;
        }
        int i = 0;
        while (i < this.f534b.size()) {
            if (((PayPalReceiverDetails) this.f534b.get(i)).getRecipient() == null || ((PayPalReceiverDetails) this.f534b.get(i)).getRecipient().length() <= 0 || ((PayPalReceiverDetails) this.f534b.get(i)).getSubtotal().compareTo(BigDecimal.ZERO) <= 0) {
                return false;
            }
            i++;
        }
        boolean z = (!this.f533a.equals("AUD") || getTotal().compareTo(new BigDecimal("11000")) < 0) ? (!this.f533a.equals("CAD") || getTotal().compareTo(new BigDecimal("11000")) < 0) ? (!this.f533a.equals("CHF") || getTotal().compareTo(new BigDecimal("11000")) < 0) ? (!this.f533a.equals("CZK") || getTotal().compareTo(new BigDecimal("200000")) < 0) ? (!this.f533a.equals("DKK") || getTotal().compareTo(new BigDecimal("55000")) < 0) ? (!this.f533a.equals("EUR") || getTotal().compareTo(new BigDecimal("7500")) < 0) ? (!this.f533a.equals("GBP") || getTotal().compareTo(new BigDecimal("7500")) < 0) ? (!this.f533a.equals("HKD") || getTotal().compareTo(new BigDecimal("80000")) < 0) ? (!this.f533a.equals("HUF") || getTotal().compareTo(new BigDecimal("2000000")) < 0) ? (!this.f533a.equals("ILS") || getTotal().compareTo(new BigDecimal("40000")) < 0) ? (!this.f533a.equals("JPY") || getTotal().compareTo(new BigDecimal("1000000")) < 0) ? (!this.f533a.equals("MXN") || getTotal().compareTo(new BigDecimal("130000")) < 0) ? (!this.f533a.equals("MYR") || getTotal().compareTo(new BigDecimal("35000")) < 0) ? (!this.f533a.equals("NOK") || getTotal().compareTo(new BigDecimal("60000")) < 0) ? (!this.f533a.equals("NZD") || getTotal().compareTo(new BigDecimal("15000")) < 0) ? (!this.f533a.equals("PHP") || getTotal().compareTo(new BigDecimal("500000")) < 0) ? (!this.f533a.equals("PLN") || getTotal().compareTo(new BigDecimal("30000")) < 0) ? (!this.f533a.equals("SEK") || getTotal().compareTo(new BigDecimal("75000")) < 0) ? (!this.f533a.equals("SGD") || getTotal().compareTo(new BigDecimal("15000")) < 0) ? (!this.f533a.equals("THB") || getTotal().compareTo(new BigDecimal("350000")) < 0) ? (!this.f533a.equals("TWD") || getTotal().compareTo(new BigDecimal("350000")) < 0) ? !this.f533a.equals("USD") || getTotal().compareTo(new BigDecimal("10000")) < 0 : false : false : false : false : false : false : false : false : false : false : false : false : false : false : false : false : false : false : false : false : false;
        return z;
    }

    public void setCurrencyType(String str) {
        this.f533a = str.toUpperCase();
    }

    public void setCurrencyType(Currency currency) {
        this.f533a = currency.getCurrencyCode();
    }

    public void setIpnUrl(String str) {
        this.f535c = str;
    }

    public void setMemo(String str) {
        this.f536d = str;
    }

    public void setMerchantName(String str) {
        this.f537e = str;
    }

    public void setReceivers(ArrayList<PayPalReceiverDetails> arrayList) {
        this.f534b = arrayList;
    }
}
