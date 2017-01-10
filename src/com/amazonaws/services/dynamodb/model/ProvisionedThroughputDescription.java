package com.amazonaws.services.dynamodb.model;

import java.util.Date;

public class ProvisionedThroughputDescription {
    private Date lastDecreaseDateTime;
    private Date lastIncreaseDateTime;
    private Long readCapacityUnits;
    private Long writeCapacityUnits;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ProvisionedThroughputDescription)) {
            return false;
        }
        ProvisionedThroughputDescription provisionedThroughputDescription = (ProvisionedThroughputDescription) obj;
        if (((provisionedThroughputDescription.getLastIncreaseDateTime() == null ? 1 : 0) ^ (getLastIncreaseDateTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (provisionedThroughputDescription.getLastIncreaseDateTime() != null && !provisionedThroughputDescription.getLastIncreaseDateTime().equals(getLastIncreaseDateTime())) {
            return false;
        }
        if (((provisionedThroughputDescription.getLastDecreaseDateTime() == null ? 1 : 0) ^ (getLastDecreaseDateTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (provisionedThroughputDescription.getLastDecreaseDateTime() != null && !provisionedThroughputDescription.getLastDecreaseDateTime().equals(getLastDecreaseDateTime())) {
            return false;
        }
        if (((provisionedThroughputDescription.getReadCapacityUnits() == null ? 1 : 0) ^ (getReadCapacityUnits() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (provisionedThroughputDescription.getReadCapacityUnits() != null && !provisionedThroughputDescription.getReadCapacityUnits().equals(getReadCapacityUnits())) {
            return false;
        }
        return ((provisionedThroughputDescription.getWriteCapacityUnits() == null ? 1 : 0) ^ (getWriteCapacityUnits() == null ? 1 : 0)) == 0 ? provisionedThroughputDescription.getWriteCapacityUnits() == null || provisionedThroughputDescription.getWriteCapacityUnits().equals(getWriteCapacityUnits()) : false;
    }

    public Date getLastDecreaseDateTime() {
        return this.lastDecreaseDateTime;
    }

    public Date getLastIncreaseDateTime() {
        return this.lastIncreaseDateTime;
    }

    public Long getReadCapacityUnits() {
        return this.readCapacityUnits;
    }

    public Long getWriteCapacityUnits() {
        return this.writeCapacityUnits;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getReadCapacityUnits() == null ? 0 : getReadCapacityUnits().hashCode()) + (((getLastDecreaseDateTime() == null ? 0 : getLastDecreaseDateTime().hashCode()) + (((getLastIncreaseDateTime() == null ? 0 : getLastIncreaseDateTime().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getWriteCapacityUnits() != null) {
            i = getWriteCapacityUnits().hashCode();
        }
        return hashCode + i;
    }

    public void setLastDecreaseDateTime(Date date) {
        this.lastDecreaseDateTime = date;
    }

    public void setLastIncreaseDateTime(Date date) {
        this.lastIncreaseDateTime = date;
    }

    public void setReadCapacityUnits(Long l) {
        this.readCapacityUnits = l;
    }

    public void setWriteCapacityUnits(Long l) {
        this.writeCapacityUnits = l;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.lastIncreaseDateTime != null) {
            stringBuilder.append("LastIncreaseDateTime: " + this.lastIncreaseDateTime + ", ");
        }
        if (this.lastDecreaseDateTime != null) {
            stringBuilder.append("LastDecreaseDateTime: " + this.lastDecreaseDateTime + ", ");
        }
        if (this.readCapacityUnits != null) {
            stringBuilder.append("ReadCapacityUnits: " + this.readCapacityUnits + ", ");
        }
        if (this.writeCapacityUnits != null) {
            stringBuilder.append("WriteCapacityUnits: " + this.writeCapacityUnits + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ProvisionedThroughputDescription withLastDecreaseDateTime(Date date) {
        this.lastDecreaseDateTime = date;
        return this;
    }

    public ProvisionedThroughputDescription withLastIncreaseDateTime(Date date) {
        this.lastIncreaseDateTime = date;
        return this;
    }

    public ProvisionedThroughputDescription withReadCapacityUnits(Long l) {
        this.readCapacityUnits = l;
        return this;
    }

    public ProvisionedThroughputDescription withWriteCapacityUnits(Long l) {
        this.writeCapacityUnits = l;
        return this;
    }
}
