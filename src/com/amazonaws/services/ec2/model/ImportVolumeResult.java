package com.amazonaws.services.ec2.model;

public class ImportVolumeResult {
    private ConversionTask conversionTask;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportVolumeResult)) {
            return false;
        }
        ImportVolumeResult importVolumeResult = (ImportVolumeResult) obj;
        return ((importVolumeResult.getConversionTask() == null ? 1 : 0) ^ (getConversionTask() == null ? 1 : 0)) == 0 ? importVolumeResult.getConversionTask() == null || importVolumeResult.getConversionTask().equals(getConversionTask()) : false;
    }

    public ConversionTask getConversionTask() {
        return this.conversionTask;
    }

    public int hashCode() {
        return (getConversionTask() == null ? 0 : getConversionTask().hashCode()) + 31;
    }

    public void setConversionTask(ConversionTask conversionTask) {
        this.conversionTask = conversionTask;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.conversionTask != null) {
            stringBuilder.append("ConversionTask: " + this.conversionTask + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ImportVolumeResult withConversionTask(ConversionTask conversionTask) {
        this.conversionTask = conversionTask;
        return this;
    }
}
