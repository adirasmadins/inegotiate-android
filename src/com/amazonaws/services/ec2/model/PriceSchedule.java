package com.amazonaws.services.ec2.model;

public class PriceSchedule {
    private Boolean active;
    private String currencyCode;
    private Double price;
    private Long term;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PriceSchedule)) {
            return false;
        }
        PriceSchedule priceSchedule = (PriceSchedule) obj;
        if (((priceSchedule.getTerm() == null ? 1 : 0) ^ (getTerm() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (priceSchedule.getTerm() != null && !priceSchedule.getTerm().equals(getTerm())) {
            return false;
        }
        if (((priceSchedule.getPrice() == null ? 1 : 0) ^ (getPrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (priceSchedule.getPrice() != null && !priceSchedule.getPrice().equals(getPrice())) {
            return false;
        }
        if (((priceSchedule.getCurrencyCode() == null ? 1 : 0) ^ (getCurrencyCode() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (priceSchedule.getCurrencyCode() != null && !priceSchedule.getCurrencyCode().equals(getCurrencyCode())) {
            return false;
        }
        return ((priceSchedule.isActive() == null ? 1 : 0) ^ (isActive() == null ? 1 : 0)) == 0 ? priceSchedule.isActive() == null || priceSchedule.isActive().equals(isActive()) : false;
    }

    public Boolean getActive() {
        return this.active;
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
        int hashCode = ((getCurrencyCode() == null ? 0 : getCurrencyCode().hashCode()) + (((getPrice() == null ? 0 : getPrice().hashCode()) + (((getTerm() == null ? 0 : getTerm().hashCode()) + 31) * 31)) * 31)) * 31;
        if (isActive() != null) {
            i = isActive().hashCode();
        }
        return hashCode + i;
    }

    public Boolean isActive() {
        return this.active;
    }

    public void setActive(Boolean bool) {
        this.active = bool;
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
        if (this.active != null) {
            stringBuilder.append("Active: " + this.active + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public PriceSchedule withActive(Boolean bool) {
        this.active = bool;
        return this;
    }

    public PriceSchedule withCurrencyCode(String str) {
        this.currencyCode = str;
        return this;
    }

    public PriceSchedule withPrice(Double d) {
        this.price = d;
        return this;
    }

    public PriceSchedule withTerm(Long l) {
        this.term = l;
        return this;
    }
}
