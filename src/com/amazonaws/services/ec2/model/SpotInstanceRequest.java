package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class SpotInstanceRequest {
    private String availabilityZoneGroup;
    private Date createTime;
    private SpotInstanceStateFault fault;
    private String instanceId;
    private String launchGroup;
    private LaunchSpecification launchSpecification;
    private String launchedAvailabilityZone;
    private String productDescription;
    private String spotInstanceRequestId;
    private String spotPrice;
    private String state;
    private List<Tag> tags;
    private String type;
    private Date validFrom;
    private Date validUntil;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SpotInstanceRequest)) {
            return false;
        }
        SpotInstanceRequest spotInstanceRequest = (SpotInstanceRequest) obj;
        if (((spotInstanceRequest.getSpotInstanceRequestId() == null ? 1 : 0) ^ (getSpotInstanceRequestId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getSpotInstanceRequestId() != null && !spotInstanceRequest.getSpotInstanceRequestId().equals(getSpotInstanceRequestId())) {
            return false;
        }
        if (((spotInstanceRequest.getSpotPrice() == null ? 1 : 0) ^ (getSpotPrice() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getSpotPrice() != null && !spotInstanceRequest.getSpotPrice().equals(getSpotPrice())) {
            return false;
        }
        if (((spotInstanceRequest.getType() == null ? 1 : 0) ^ (getType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getType() != null && !spotInstanceRequest.getType().equals(getType())) {
            return false;
        }
        if (((spotInstanceRequest.getState() == null ? 1 : 0) ^ (getState() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getState() != null && !spotInstanceRequest.getState().equals(getState())) {
            return false;
        }
        if (((spotInstanceRequest.getFault() == null ? 1 : 0) ^ (getFault() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getFault() != null && !spotInstanceRequest.getFault().equals(getFault())) {
            return false;
        }
        if (((spotInstanceRequest.getValidFrom() == null ? 1 : 0) ^ (getValidFrom() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getValidFrom() != null && !spotInstanceRequest.getValidFrom().equals(getValidFrom())) {
            return false;
        }
        if (((spotInstanceRequest.getValidUntil() == null ? 1 : 0) ^ (getValidUntil() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getValidUntil() != null && !spotInstanceRequest.getValidUntil().equals(getValidUntil())) {
            return false;
        }
        if (((spotInstanceRequest.getLaunchGroup() == null ? 1 : 0) ^ (getLaunchGroup() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getLaunchGroup() != null && !spotInstanceRequest.getLaunchGroup().equals(getLaunchGroup())) {
            return false;
        }
        if (((spotInstanceRequest.getAvailabilityZoneGroup() == null ? 1 : 0) ^ (getAvailabilityZoneGroup() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getAvailabilityZoneGroup() != null && !spotInstanceRequest.getAvailabilityZoneGroup().equals(getAvailabilityZoneGroup())) {
            return false;
        }
        if (((spotInstanceRequest.getLaunchSpecification() == null ? 1 : 0) ^ (getLaunchSpecification() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getLaunchSpecification() != null && !spotInstanceRequest.getLaunchSpecification().equals(getLaunchSpecification())) {
            return false;
        }
        if (((spotInstanceRequest.getInstanceId() == null ? 1 : 0) ^ (getInstanceId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getInstanceId() != null && !spotInstanceRequest.getInstanceId().equals(getInstanceId())) {
            return false;
        }
        if (((spotInstanceRequest.getCreateTime() == null ? 1 : 0) ^ (getCreateTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getCreateTime() != null && !spotInstanceRequest.getCreateTime().equals(getCreateTime())) {
            return false;
        }
        if (((spotInstanceRequest.getProductDescription() == null ? 1 : 0) ^ (getProductDescription() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getProductDescription() != null && !spotInstanceRequest.getProductDescription().equals(getProductDescription())) {
            return false;
        }
        if (((spotInstanceRequest.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (spotInstanceRequest.getTags() != null && !spotInstanceRequest.getTags().equals(getTags())) {
            return false;
        }
        return ((spotInstanceRequest.getLaunchedAvailabilityZone() == null ? 1 : 0) ^ (getLaunchedAvailabilityZone() == null ? 1 : 0)) == 0 ? spotInstanceRequest.getLaunchedAvailabilityZone() == null || spotInstanceRequest.getLaunchedAvailabilityZone().equals(getLaunchedAvailabilityZone()) : false;
    }

    public String getAvailabilityZoneGroup() {
        return this.availabilityZoneGroup;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public SpotInstanceStateFault getFault() {
        return this.fault;
    }

    public String getInstanceId() {
        return this.instanceId;
    }

    public String getLaunchGroup() {
        return this.launchGroup;
    }

    public LaunchSpecification getLaunchSpecification() {
        return this.launchSpecification;
    }

    public String getLaunchedAvailabilityZone() {
        return this.launchedAvailabilityZone;
    }

    public String getProductDescription() {
        return this.productDescription;
    }

    public String getSpotInstanceRequestId() {
        return this.spotInstanceRequestId;
    }

    public String getSpotPrice() {
        return this.spotPrice;
    }

    public String getState() {
        return this.state;
    }

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
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
        int hashCode = ((getTags() == null ? 0 : getTags().hashCode()) + (((getProductDescription() == null ? 0 : getProductDescription().hashCode()) + (((getCreateTime() == null ? 0 : getCreateTime().hashCode()) + (((getInstanceId() == null ? 0 : getInstanceId().hashCode()) + (((getLaunchSpecification() == null ? 0 : getLaunchSpecification().hashCode()) + (((getAvailabilityZoneGroup() == null ? 0 : getAvailabilityZoneGroup().hashCode()) + (((getLaunchGroup() == null ? 0 : getLaunchGroup().hashCode()) + (((getValidUntil() == null ? 0 : getValidUntil().hashCode()) + (((getValidFrom() == null ? 0 : getValidFrom().hashCode()) + (((getFault() == null ? 0 : getFault().hashCode()) + (((getState() == null ? 0 : getState().hashCode()) + (((getType() == null ? 0 : getType().hashCode()) + (((getSpotPrice() == null ? 0 : getSpotPrice().hashCode()) + (((getSpotInstanceRequestId() == null ? 0 : getSpotInstanceRequestId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getLaunchedAvailabilityZone() != null) {
            i = getLaunchedAvailabilityZone().hashCode();
        }
        return hashCode + i;
    }

    public void setAvailabilityZoneGroup(String str) {
        this.availabilityZoneGroup = str;
    }

    public void setCreateTime(Date date) {
        this.createTime = date;
    }

    public void setFault(SpotInstanceStateFault spotInstanceStateFault) {
        this.fault = spotInstanceStateFault;
    }

    public void setInstanceId(String str) {
        this.instanceId = str;
    }

    public void setLaunchGroup(String str) {
        this.launchGroup = str;
    }

    public void setLaunchSpecification(LaunchSpecification launchSpecification) {
        this.launchSpecification = launchSpecification;
    }

    public void setLaunchedAvailabilityZone(String str) {
        this.launchedAvailabilityZone = str;
    }

    public void setProductDescription(String str) {
        this.productDescription = str;
    }

    public void setSpotInstanceRequestId(String str) {
        this.spotInstanceRequestId = str;
    }

    public void setSpotPrice(String str) {
        this.spotPrice = str;
    }

    public void setState(String str) {
        this.state = str;
    }

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.tags = arrayList;
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
        if (this.spotInstanceRequestId != null) {
            stringBuilder.append("SpotInstanceRequestId: " + this.spotInstanceRequestId + ", ");
        }
        if (this.spotPrice != null) {
            stringBuilder.append("SpotPrice: " + this.spotPrice + ", ");
        }
        if (this.type != null) {
            stringBuilder.append("Type: " + this.type + ", ");
        }
        if (this.state != null) {
            stringBuilder.append("State: " + this.state + ", ");
        }
        if (this.fault != null) {
            stringBuilder.append("Fault: " + this.fault + ", ");
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
        if (this.instanceId != null) {
            stringBuilder.append("InstanceId: " + this.instanceId + ", ");
        }
        if (this.createTime != null) {
            stringBuilder.append("CreateTime: " + this.createTime + ", ");
        }
        if (this.productDescription != null) {
            stringBuilder.append("ProductDescription: " + this.productDescription + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        if (this.launchedAvailabilityZone != null) {
            stringBuilder.append("LaunchedAvailabilityZone: " + this.launchedAvailabilityZone + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public SpotInstanceRequest withAvailabilityZoneGroup(String str) {
        this.availabilityZoneGroup = str;
        return this;
    }

    public SpotInstanceRequest withCreateTime(Date date) {
        this.createTime = date;
        return this;
    }

    public SpotInstanceRequest withFault(SpotInstanceStateFault spotInstanceStateFault) {
        this.fault = spotInstanceStateFault;
        return this;
    }

    public SpotInstanceRequest withInstanceId(String str) {
        this.instanceId = str;
        return this;
    }

    public SpotInstanceRequest withLaunchGroup(String str) {
        this.launchGroup = str;
        return this;
    }

    public SpotInstanceRequest withLaunchSpecification(LaunchSpecification launchSpecification) {
        this.launchSpecification = launchSpecification;
        return this;
    }

    public SpotInstanceRequest withLaunchedAvailabilityZone(String str) {
        this.launchedAvailabilityZone = str;
        return this;
    }

    public SpotInstanceRequest withProductDescription(String str) {
        this.productDescription = str;
        return this;
    }

    public SpotInstanceRequest withSpotInstanceRequestId(String str) {
        this.spotInstanceRequestId = str;
        return this;
    }

    public SpotInstanceRequest withSpotPrice(String str) {
        this.spotPrice = str;
        return this;
    }

    public SpotInstanceRequest withState(String str) {
        this.state = str;
        return this;
    }

    public SpotInstanceRequest withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public SpotInstanceRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }

    public SpotInstanceRequest withType(SpotInstanceType spotInstanceType) {
        this.type = spotInstanceType.toString();
        return this;
    }

    public SpotInstanceRequest withType(String str) {
        this.type = str;
        return this;
    }

    public SpotInstanceRequest withValidFrom(Date date) {
        this.validFrom = date;
        return this;
    }

    public SpotInstanceRequest withValidUntil(Date date) {
        this.validUntil = date;
        return this;
    }
}
