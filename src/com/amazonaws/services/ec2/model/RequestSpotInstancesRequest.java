package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.Date;

public class RequestSpotInstancesRequest extends AmazonWebServiceRequest {
    private String availabilityZoneGroup;
    private Integer instanceCount;
    private String launchGroup;
    private LaunchSpecification launchSpecification;
    private String spotPrice;
    private String type;
    private Date validFrom;
    private Date validUntil;

    public RequestSpotInstancesRequest(String str) {
        this.spotPrice = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RequestSpotInstancesRequest)) {
            return false;
        }
        RequestSpotInstancesRequest requestSpotInstancesRequest = (RequestSpotInstancesRequest) obj;
        if (((requestSpotInstancesRequest.getSpotPrice() == null ? 1 : 0) ^ (getSpotPrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (requestSpotInstancesRequest.getSpotPrice() != null && !requestSpotInstancesRequest.getSpotPrice().equals(getSpotPrice())) {
            return false;
        }
        if (((requestSpotInstancesRequest.getInstanceCount() == null ? 1 : 0) ^ (getInstanceCount() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (requestSpotInstancesRequest.getInstanceCount() != null && !requestSpotInstancesRequest.getInstanceCount().equals(getInstanceCount())) {
            return false;
        }
        if (((requestSpotInstancesRequest.getType() == null ? 1 : 0) ^ (getType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (requestSpotInstancesRequest.getType() != null && !requestSpotInstancesRequest.getType().equals(getType())) {
            return false;
        }
        if (((requestSpotInstancesRequest.getValidFrom() == null ? 1 : 0) ^ (getValidFrom() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (requestSpotInstancesRequest.getValidFrom() != null && !requestSpotInstancesRequest.getValidFrom().equals(getValidFrom())) {
            return false;
        }
        if (((requestSpotInstancesRequest.getValidUntil() == null ? 1 : 0) ^ (getValidUntil() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (requestSpotInstancesRequest.getValidUntil() != null && !requestSpotInstancesRequest.getValidUntil().equals(getValidUntil())) {
            return false;
        }
        if (((requestSpotInstancesRequest.getLaunchGroup() == null ? 1 : 0) ^ (getLaunchGroup() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (requestSpotInstancesRequest.getLaunchGroup() != null && !requestSpotInstancesRequest.getLaunchGroup().equals(getLaunchGroup())) {
            return false;
        }
        if (((requestSpotInstancesRequest.getAvailabilityZoneGroup() == null ? 1 : 0) ^ (getAvailabilityZoneGroup() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (requestSpotInstancesRequest.getAvailabilityZoneGroup() != null && !requestSpotInstancesRequest.getAvailabilityZoneGroup().equals(getAvailabilityZoneGroup())) {
            return false;
        }
        return ((requestSpotInstancesRequest.getLaunchSpecification() == null ? 1 : 0) ^ (getLaunchSpecification() == null ? 1 : 0)) == 0 ? requestSpotInstancesRequest.getLaunchSpecification() == null || requestSpotInstancesRequest.getLaunchSpecification().equals(getLaunchSpecification()) : false;
    }

    public String getAvailabilityZoneGroup() {
        return this.availabilityZoneGroup;
    }

    public Integer getInstanceCount() {
        return this.instanceCount;
    }

    public String getLaunchGroup() {
        return this.launchGroup;
    }

    public LaunchSpecification getLaunchSpecification() {
        return this.launchSpecification;
    }

    public String getSpotPrice() {
        return this.spotPrice;
    }

    public String getType() {
        return this.type;
    }

    public Date getValidFrom() {
        return this.validFrom;
    }

    public Date getValidUntil() {
        return this.validUntil;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAvailabilityZoneGroup() == null ? 0 : getAvailabilityZoneGroup().hashCode()) + (((getLaunchGroup() == null ? 0 : getLaunchGroup().hashCode()) + (((getValidUntil() == null ? 0 : getValidUntil().hashCode()) + (((getValidFrom() == null ? 0 : getValidFrom().hashCode()) + (((getType() == null ? 0 : getType().hashCode()) + (((getInstanceCount() == null ? 0 : getInstanceCount().hashCode()) + (((getSpotPrice() == null ? 0 : getSpotPrice().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getLaunchSpecification() != null) {
            i = getLaunchSpecification().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZoneGroup(String str) {
        this.availabilityZoneGroup = str;
    }

    public void setInstanceCount(Integer num) {
        this.instanceCount = num;
    }

    public void setLaunchGroup(String str) {
        this.launchGroup = str;
    }

    public void setLaunchSpecification(LaunchSpecification launchSpecification) {
        this.launchSpecification = launchSpecification;
    }

    public void setSpotPrice(String str) {
        this.spotPrice = str;
    }

    public void setType(SpotInstanceType spotInstanceType) {
        this.type = spotInstanceType.toString();
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValidFrom(Date date) {
        this.validFrom = date;
    }

    public void setValidUntil(Date date) {
        this.validUntil = date;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.spotPrice != null) {
            stringBuilder.append("SpotPrice: " + this.spotPrice + ", ");
        }
        if (this.instanceCount != null) {
            stringBuilder.append("InstanceCount: " + this.instanceCount + ", ");
        }
        if (this.type != null) {
            stringBuilder.append("Type: " + this.type + ", ");
        }
        if (this.validFrom != null) {
            stringBuilder.append("ValidFrom: " + this.validFrom + ", ");
        }
        if (this.validUntil != null) {
            stringBuilder.append("ValidUntil: " + this.validUntil + ", ");
        }
        if (this.launchGroup != null) {
            stringBuilder.append("LaunchGroup: " + this.launchGroup + ", ");
        }
        if (this.availabilityZoneGroup != null) {
            stringBuilder.append("AvailabilityZoneGroup: " + this.availabilityZoneGroup + ", ");
        }
        if (this.launchSpecification != null) {
            stringBuilder.append("LaunchSpecification: " + this.launchSpecification + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public RequestSpotInstancesRequest withAvailabilityZoneGroup(String str) {
        this.availabilityZoneGroup = str;
        return this;
    }

    public RequestSpotInstancesRequest withInstanceCount(Integer num) {
        this.instanceCount = num;
        return this;
    }

    public RequestSpotInstancesRequest withLaunchGroup(String str) {
        this.launchGroup = str;
        return this;
    }

    public RequestSpotInstancesRequest withLaunchSpecification(LaunchSpecification launchSpecification) {
        this.launchSpecification = launchSpecification;
        return this;
    }

    public RequestSpotInstancesRequest withSpotPrice(String str) {
        this.spotPrice = str;
        return this;
    }

    public RequestSpotInstancesRequest withType(SpotInstanceType spotInstanceType) {
        this.type = spotInstanceType.toString();
        return this;
    }

    public RequestSpotInstancesRequest withType(String str) {
        this.type = str;
        return this;
    }

    public RequestSpotInstancesRequest withValidFrom(Date date) {
        this.validFrom = date;
        return this;
    }

    public RequestSpotInstancesRequest withValidUntil(Date date) {
        this.validUntil = date;
        return this;
    }
}
