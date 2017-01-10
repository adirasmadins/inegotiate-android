package com.amazonaws.services.cloudwatch.model;

import java.util.Date;

public class Datapoint {
    private Double average;
    private Double maximum;
    private Double minimum;
    private Double sampleCount;
    private Double sum;
    private Date timestamp;
    private String unit;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Datapoint)) {
            return false;
        }
        Datapoint datapoint = (Datapoint) obj;
        if (((datapoint.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (datapoint.getTimestamp() != null && !datapoint.getTimestamp().equals(getTimestamp())) {
            return false;
        }
        if (((datapoint.getSampleCount() == null ? 1 : 0) ^ (getSampleCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (datapoint.getSampleCount() != null && !datapoint.getSampleCount().equals(getSampleCount())) {
            return false;
        }
        if (((datapoint.getAverage() == null ? 1 : 0) ^ (getAverage() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (datapoint.getAverage() != null && !datapoint.getAverage().equals(getAverage())) {
            return false;
        }
        if (((datapoint.getSum() == null ? 1 : 0) ^ (getSum() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (datapoint.getSum() != null && !datapoint.getSum().equals(getSum())) {
            return false;
        }
        if (((datapoint.getMinimum() == null ? 1 : 0) ^ (getMinimum() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (datapoint.getMinimum() != null && !datapoint.getMinimum().equals(getMinimum())) {
            return false;
        }
        if (((datapoint.getMaximum() == null ? 1 : 0) ^ (getMaximum() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (datapoint.getMaximum() != null && !datapoint.getMaximum().equals(getMaximum())) {
            return false;
        }
        return ((datapoint.getUnit() == null ? 1 : 0) ^ (getUnit() == null ? 1 : 0)) == 0 ? datapoint.getUnit() == null || datapoint.getUnit().equals(getUnit()) : false;
    }

    public Double getAverage() {
        return this.average;
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

    public Date getTimestamp() {
        return this.timestamp;
    }

    public String getUnit() {
        return this.unit;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getMaximum() == null ? 0 : getMaximum().hashCode()) + (((getMinimum() == null ? 0 : getMinimum().hashCode()) + (((getSum() == null ? 0 : getSum().hashCode()) + (((getAverage() == null ? 0 : getAverage().hashCode()) + (((getSampleCount() == null ? 0 : getSampleCount().hashCode()) + (((getTimestamp() == null ? 0 : getTimestamp().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getUnit() != null) {
            i = getUnit().hashCode();
        }
        return hashCode + i;
    }

    public void setAverage(Double d) {
        this.average = d;
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

    public void setTimestamp(Date date) {
        this.timestamp = date;
    }

    public void setUnit(StandardUnit standardUnit) {
        this.unit = standardUnit.toString();
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.timestamp != null) {
            stringBuilder.append("Timestamp: " + this.timestamp + ", ");
        }
        if (this.sampleCount != null) {
            stringBuilder.append("SampleCount: " + this.sampleCount + ", ");
        }
        if (this.average != null) {
            stringBuilder.append("Average: " + this.average + ", ");
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
        if (this.unit != null) {
            stringBuilder.append("Unit: " + this.unit + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Datapoint withAverage(Double d) {
        this.average = d;
        return this;
    }

    public Datapoint withMaximum(Double d) {
        this.maximum = d;
        return this;
    }

    public Datapoint withMinimum(Double d) {
        this.minimum = d;
        return this;
    }

    public Datapoint withSampleCount(Double d) {
        this.sampleCount = d;
        return this;
    }

    public Datapoint withSum(Double d) {
        this.sum = d;
        return this;
    }

    public Datapoint withTimestamp(Date date) {
        this.timestamp = date;
        return this;
    }

    public Datapoint withUnit(StandardUnit standardUnit) {
        this.unit = standardUnit.toString();
        return this;
    }

    public Datapoint withUnit(String str) {
        this.unit = str;
        return this;
    }
}
