package com.amazonaws.services.ec2.model;

public class PriceScheduleSpecification {
    private String currencyCode;
    private Double price;
    private Long term;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PriceScheduleSpecification)) {
            return false;
        }
        PriceScheduleSpecification priceScheduleSpecification = (PriceScheduleSpecification) obj;
        if (((priceScheduleSpecification.getTerm() == null ? 1 : 0) ^ (getTerm() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (priceScheduleSpecification.getTerm() != null && !priceScheduleSpecification.getTerm().equals(getTerm())) {
            return false;
        }
        if (((priceScheduleSpecification.getPrice() == null ? 1 : 0) ^ (getPrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (priceScheduleSpecification.getPrice() != null && !priceScheduleSpecification.getPrice().equals(getPrice())) {
            return false;
        }
        return ((priceScheduleSpecification.getCurrencyCode() == null ? 1 : 0) ^ (getCurrencyCode() == null ? 1 : 0)) == 0 ? priceScheduleSpecification.getCurrencyCode() == null || priceScheduleSpecification.getCurrencyCode().equals(getCurrencyCode()) : false;
    }

    public String getCurrencyCode() {
        return this.currencyCode;
    }

    public Double getPrice() {
        return this.price;
    }

    public Long getTerm() {
        return this.term;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getPrice() == null ? 0 : getPrice().hashCode()) + (((getTerm() == null ? 0 : getTerm().hashCode()) + 31) * 31)) * 31;
        if (getCurrencyCode() != null) {
            i = getCurrencyCode().hashCode();
        }
        return hashCode + i;
    }

    public void setCurrencyCode(String str) {
        this.currencyCode = str;
    }

    public void setPrice(Double d) {
        this.price = d;
    }

    public void setTerm(Long l) {
        this.term = l;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.term != null) {
            stringBuilder.append("Term: " + this.term + ", ");
        }
        if (this.price != null) {
            stringBuilder.append("Price: " + this.price + ", ");
        }
        if (this.currencyCode != null) {
            stringBuilder.append("CurrencyCode: " + this.currencyCode + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PriceScheduleSpecification withCurrencyCode(String str) {
        this.currencyCode = str;
        return this;
    }

    public PriceScheduleSpecification withPrice(Double d) {
        this.price = d;
        return this;
    }

    public PriceScheduleSpecification withTerm(Long l) {
        this.term = l;
        return this;
    }
}
