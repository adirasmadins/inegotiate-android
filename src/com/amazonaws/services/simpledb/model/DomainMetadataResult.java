package com.amazonaws.services.simpledb.model;

public class DomainMetadataResult {
    private Integer attributeNameCount;
    private Long attributeNamesSizeBytes;
    private Integer attributeValueCount;
    private Long attributeValuesSizeBytes;
    private Integer itemCount;
    private Long itemNamesSizeBytes;
    private Integer timestamp;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DomainMetadataResult)) {
            return false;
        }
        DomainMetadataResult domainMetadataResult = (DomainMetadataResult) obj;
        if (((domainMetadataResult.getItemCount() == null ? 1 : 0) ^ (getItemCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (domainMetadataResult.getItemCount() != null && !domainMetadataResult.getItemCount().equals(getItemCount())) {
            return false;
        }
        if (((domainMetadataResult.getItemNamesSizeBytes() == null ? 1 : 0) ^ (getItemNamesSizeBytes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (domainMetadataResult.getItemNamesSizeBytes() != null && !domainMetadataResult.getItemNamesSizeBytes().equals(getItemNamesSizeBytes())) {
            return false;
        }
        if (((domainMetadataResult.getAttributeNameCount() == null ? 1 : 0) ^ (getAttributeNameCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (domainMetadataResult.getAttributeNameCount() != null && !domainMetadataResult.getAttributeNameCount().equals(getAttributeNameCount())) {
            return false;
        }
        if (((domainMetadataResult.getAttributeNamesSizeBytes() == null ? 1 : 0) ^ (getAttributeNamesSizeBytes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (domainMetadataResult.getAttributeNamesSizeBytes() != null && !domainMetadataResult.getAttributeNamesSizeBytes().equals(getAttributeNamesSizeBytes())) {
            return false;
        }
        if (((domainMetadataResult.getAttributeValueCount() == null ? 1 : 0) ^ (getAttributeValueCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (domainMetadataResult.getAttributeValueCount() != null && !domainMetadataResult.getAttributeValueCount().equals(getAttributeValueCount())) {
            return false;
        }
        if (((domainMetadataResult.getAttributeValuesSizeBytes() == null ? 1 : 0) ^ (getAttributeValuesSizeBytes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (domainMetadataResult.getAttributeValuesSizeBytes() != null && !domainMetadataResult.getAttributeValuesSizeBytes().equals(getAttributeValuesSizeBytes())) {
            return false;
        }
        return ((domainMetadataResult.getTimestamp() == null ? 1 : 0) ^ (getTimestamp() == null ? 1 : 0)) == 0 ? domainMetadataResult.getTimestamp() == null || domainMetadataResult.getTimestamp().equals(getTimestamp()) : false;
    }

    public Integer getAttributeNameCount() {
        return this.attributeNameCount;
    }

    public Long getAttributeNamesSizeBytes() {
        return this.attributeNamesSizeBytes;
    }

    public Integer getAttributeValueCount() {
        return this.attributeValueCount;
    }

    public Long getAttributeValuesSizeBytes() {
        return this.attributeValuesSizeBytes;
    }

    public Integer getItemCount() {
        return this.itemCount;
    }

    public Long getItemNamesSizeBytes() {
        return this.itemNamesSizeBytes;
    }

    public Integer getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAttributeValuesSizeBytes() == null ? 0 : getAttributeValuesSizeBytes().hashCode()) + (((getAttributeValueCount() == null ? 0 : getAttributeValueCount().hashCode()) + (((getAttributeNamesSizeBytes() == null ? 0 : getAttributeNamesSizeBytes().hashCode()) + (((getAttributeNameCount() == null ? 0 : getAttributeNameCount().hashCode()) + (((getItemNamesSizeBytes() == null ? 0 : getItemNamesSizeBytes().hashCode()) + (((getItemCount() == null ? 0 : getItemCount().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getTimestamp() != null) {
            i = getTimestamp().hashCode();
        }
        return hashCode + i;
    }

    public void setAttributeNameCount(Integer num) {
        this.attributeNameCount = num;
    }

    public void setAttributeNamesSizeBytes(Long l) {
        this.attributeNamesSizeBytes = l;
    }

    public void setAttributeValueCount(Integer num) {
        this.attributeValueCount = num;
    }

    public void setAttributeValuesSizeBytes(Long l) {
        this.attributeValuesSizeBytes = l;
    }

    public void setItemCount(Integer num) {
        this.itemCount = num;
    }

    public void setItemNamesSizeBytes(Long l) {
        this.itemNamesSizeBytes = l;
    }

    public void setTimestamp(Integer num) {
        this.timestamp = num;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.itemCount != null) {
            stringBuilder.append("ItemCount: " + this.itemCount + ", ");
        }
        if (this.itemNamesSizeBytes != null) {
            stringBuilder.append("ItemNamesSizeBytes: " + this.itemNamesSizeBytes + ", ");
        }
        if (this.attributeNameCount != null) {
            stringBuilder.append("AttributeNameCount: " + this.attributeNameCount + ", ");
        }
        if (this.attributeNamesSizeBytes != null) {
            stringBuilder.append("AttributeNamesSizeBytes: " + this.attributeNamesSizeBytes + ", ");
        }
        if (this.attributeValueCount != null) {
            stringBuilder.append("AttributeValueCount: " + this.attributeValueCount + ", ");
        }
        if (this.attributeValuesSizeBytes != null) {
            stringBuilder.append("AttributeValuesSizeBytes: " + this.attributeValuesSizeBytes + ", ");
        }
        if (this.timestamp != null) {
            stringBuilder.append("Timestamp: " + this.timestamp + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DomainMetadataResult withAttributeNameCount(Integer num) {
        this.attributeNameCount = num;
        return this;
    }

    public DomainMetadataResult withAttributeNamesSizeBytes(Long l) {
        this.attributeNamesSizeBytes = l;
        return this;
    }

    public DomainMetadataResult withAttributeValueCount(Integer num) {
        this.attributeValueCount = num;
        return this;
    }

    public DomainMetadataResult withAttributeValuesSizeBytes(Long l) {
        this.attributeValuesSizeBytes = l;
        return this;
    }

    public DomainMetadataResult withItemCount(Integer num) {
        this.itemCount = num;
        return this;
    }

    public DomainMetadataResult withItemNamesSizeBytes(Long l) {
        this.itemNamesSizeBytes = l;
        return this;
    }

    public DomainMetadataResult withTimestamp(Integer num) {
        this.timestamp = num;
        return this;
    }
}
