package com.amazonaws.services.ec2.model;

public class RecurringCharge {
    private Double amount;
    private String frequency;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RecurringCharge)) {
            return false;
        }
        RecurringCharge recurringCharge = (RecurringCharge) obj;
        if (((recurringCharge.getFrequency() == null ? 1 : 0) ^ (getFrequency() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (recurringCharge.getFrequency() != null && !recurringCharge.getFrequency().equals(getFrequency())) {
            return false;
        }
        return ((recurringCharge.getAmount() == null ? 1 : 0) ^ (getAmount() == null ? 1 : 0)) == 0 ? recurringCharge.getAmount() == null || recurringCharge.getAmount().equals(getAmount()) : false;
    }

    public Double getAmount() {
        return this.amount;
    }

    public String getFrequency() {
        return this.frequency;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getFrequency() == null ? 0 : getFrequency().hashCode()) + 31) * 31;
        if (getAmount() != null) {
            i = getAmount().hashCode();
        }
        return hashCode + i;
    }

    public void setAmount(Double d) {
        this.amount = d;
    }

    public void setFrequency(String str) {
        this.frequency = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.frequency != null) {
            stringBuilder.append("Frequency: " + this.frequency + ", ");
        }
        if (this.amount != null) {
            stringBuilder.append("Amount: " + this.amount + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public RecurringCharge withAmount(Double d) {
        this.amount = d;
        return this;
    }

    public RecurringCharge withFrequency(String str) {
        this.frequency = str;
        return this;
    }
}
