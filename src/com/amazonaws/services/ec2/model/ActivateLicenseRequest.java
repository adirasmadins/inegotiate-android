package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;

public class ActivateLicenseRequest extends AmazonWebServiceRequest {
    private Integer capacity;
    private String licenseId;

    public ActivateLicenseRequest(String str, Integer num) {
        this.licenseId = str;
        this.capacity = num;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ActivateLicenseRequest)) {
            return false;
        }
        ActivateLicenseRequest activateLicenseRequest = (ActivateLicenseRequest) obj;
        if (((activateLicenseRequest.getLicenseId() == null ? 1 : 0) ^ (getLicenseId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (activateLicenseRequest.getLicenseId() != null && !activateLicenseRequest.getLicenseId().equals(getLicenseId())) {
            return false;
        }
        return ((activateLicenseRequest.getCapacity() == null ? 1 : 0) ^ (getCapacity() == null ? 1 : 0)) == 0 ? activateLicenseRequest.getCapacity() == null || activateLicenseRequest.getCapacity().equals(getCapacity()) : false;
    }

    public Integer getCapacity() {
        return this.capacity;
    }

    public String getLicenseId() {
        return this.licenseId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLicenseId() == null ? 0 : getLicenseId().hashCode()) + 31) * 31;
        if (getCapacity() != null) {
            i = getCapacity().hashCode();
        }
        return hashCode + i;
    }

    public void setCapacity(Integer num) {
        this.capacity = num;
    }

    public void setLicenseId(String str) {
        this.licenseId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.licenseId != null) {
            stringBuilder.append("LicenseId: " + this.licenseId + ", ");
        }
        if (this.capacity != null) {
            stringBuilder.append("Capacity: " + this.capacity + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ActivateLicenseRequest withCapacity(Integer num) {
        this.capacity = num;
        return this;
    }

    public ActivateLicenseRequest withLicenseId(String str) {
        this.licenseId = str;
        return this;
    }
}
