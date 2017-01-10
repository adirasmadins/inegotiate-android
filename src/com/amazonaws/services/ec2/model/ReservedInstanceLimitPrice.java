package com.amazonaws.services.ec2.model;

public class ReservedInstanceLimitPrice {
    private Double amount;
    private String currencyCode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ReservedInstanceLimitPrice)) {
            return false;
        }
        ReservedInstanceLimitPrice reservedInstanceLimitPrice = (ReservedInstanceLimitPrice) obj;
        if (((reservedInstanceLimitPrice.getAmount() == null ? 1 : 0) ^ (getAmount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (reservedInstanceLimitPrice.getAmount() != null && !reservedInstanceLimitPrice.getAmount().equals(getAmount())) {
            return false;
        }
        return ((reservedInstanceLimitPrice.getCurrencyCode() == null ? 1 : 0) ^ (getCurrencyCode() == null ? 1 : 0)) == 0 ? reservedInstanceLimitPrice.getCurrencyCode() == null || reservedInstanceLimitPrice.getCurrencyCode().equals(getCurrencyCode()) : false;
    }

    public Double getAmount() {
        return this.amount;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAmount() == null ? 0 : getAmount().hashCode()) + 31) * 31;
        if (getCurrencyCode() != null) {
            i = getCurrencyCode().hashCode();
        }
        return hashCode + i;
    }

    public void setAmount(Double d) {
        this.amount = d;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.amount != null) {
            stringBuilder.append("Amount: " + this.amount + ", ");
        }
        if (this.currencyCode != null) {
            stringBuilder.append("CurrencyCode: " + this.currencyCode + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ReservedInstanceLimitPrice withAmount(Double d) {
        this.amount = d;
        return this;
    }

    public ReservedInstanceLimitPrice withCurrencyCode(String str) {
        this.currencyCode = str;
        return this;
    }
}
