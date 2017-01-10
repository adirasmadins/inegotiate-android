package com.amazonaws.services.cloudwatch.model;

public class StatisticSet {
    private Double maximum;
    private Double minimum;
    private Double sampleCount;
    private Double sum;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StatisticSet)) {
            return false;
        }
        StatisticSet statisticSet = (StatisticSet) obj;
        if (((statisticSet.getSampleCount() == null ? 1 : 0) ^ (getSampleCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (statisticSet.getSampleCount() != null && !statisticSet.getSampleCount().equals(getSampleCount())) {
            return false;
        }
        if (((statisticSet.getSum() == null ? 1 : 0) ^ (getSum() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (statisticSet.getSum() != null && !statisticSet.getSum().equals(getSum())) {
            return false;
        }
        if (((statisticSet.getMinimum() == null ? 1 : 0) ^ (getMinimum() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (statisticSet.getMinimum() != null && !statisticSet.getMinimum().equals(getMinimum())) {
            return false;
        }
        return ((statisticSet.getMaximum() == null ? 1 : 0) ^ (getMaximum() == null ? 1 : 0)) == 0 ? statisticSet.getMaximum() == null || statisticSet.getMaximum().equals(getMaximum()) : false;
    }

    public Double getMaximum() {
        return this.maximum;
    }

    public Double getMinimum() {
        return this.minimum;
    }

    public Double getSampleCount() {
        return this.sampleCount;
    }

    public Double getSum() {
        return this.sum;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMinimum() == null ? 0 : getMinimum().hashCode()) + (((getSum() == null ? 0 : getSum().hashCode()) + (((getSampleCount() == null ? 0 : getSampleCount().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getMaximum() != null) {
            i = getMaximum().hashCode();
        }
        return hashCode + i;
    }

    public void setMaximum(Double d) {
        this.maximum = d;
    }

    public void setMinimum(Double d) {
        this.minimum = d;
    }

    public void setSampleCount(Double d) {
        this.sampleCount = d;
    }

    public void setSum(Double d) {
        this.sum = d;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.sampleCount != null) {
            stringBuilder.append("SampleCount: " + this.sampleCount + ", ");
        }
        if (this.sum != null) {
            stringBuilder.append("Sum: " + this.sum + ", ");
        }
        if (this.minimum != null) {
            stringBuilder.append("Minimum: " + this.minimum + ", ");
        }
        if (this.maximum != null) {
            stringBuilder.append("Maximum: " + this.maximum + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public StatisticSet withMaximum(Double d) {
        this.maximum = d;
        return this;
    }

    public StatisticSet withMinimum(Double d) {
        this.minimum = d;
        return this;
    }

    public StatisticSet withSampleCount(Double d) {
        this.sampleCount = d;
        return this;
    }

    public StatisticSet withSum(Double d) {
        this.sum = d;
        return this;
    }
}
