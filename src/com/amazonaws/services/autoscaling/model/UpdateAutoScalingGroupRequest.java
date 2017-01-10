package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UpdateAutoScalingGroupRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private List<String> availabilityZones;
    private Integer defaultCooldown;
    private Integer desiredCapacity;
    private Integer healthCheckGracePeriod;
    private String healthCheckType;
    private String launchConfigurationName;
    private Integer maxSize;
    private Integer minSize;
    private String placementGroup;
    private List<String> terminationPolicies;
    private String vPCZoneIdentifier;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateAutoScalingGroupRequest)) {
            return false;
        }
        UpdateAutoScalingGroupRequest updateAutoScalingGroupRequest = (UpdateAutoScalingGroupRequest) obj;
        if (((updateAutoScalingGroupRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getAutoScalingGroupName() != null && !updateAutoScalingGroupRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((updateAutoScalingGroupRequest.getLaunchConfigurationName() == null ? 1 : 0) ^ (getLaunchConfigurationName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getLaunchConfigurationName() != null && !updateAutoScalingGroupRequest.getLaunchConfigurationName().equals(getLaunchConfigurationName())) {
            return false;
        }
        if (((updateAutoScalingGroupRequest.getMinSize() == null ? 1 : 0) ^ (getMinSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getMinSize() != null && !updateAutoScalingGroupRequest.getMinSize().equals(getMinSize())) {
            return false;
        }
        if (((updateAutoScalingGroupRequest.getMaxSize() == null ? 1 : 0) ^ (getMaxSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getMaxSize() != null && !updateAutoScalingGroupRequest.getMaxSize().equals(getMaxSize())) {
            return false;
        }
        if (((updateAutoScalingGroupRequest.getDesiredCapacity() == null ? 1 : 0) ^ (getDesiredCapacity() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getDesiredCapacity() != null && !updateAutoScalingGroupRequest.getDesiredCapacity().equals(getDesiredCapacity())) {
            return false;
        }
        if (((updateAutoScalingGroupRequest.getDefaultCooldown() == null ? 1 : 0) ^ (getDefaultCooldown() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getDefaultCooldown() != null && !updateAutoScalingGroupRequest.getDefaultCooldown().equals(getDefaultCooldown())) {
            return false;
        }
        if (((updateAutoScalingGroupRequest.getAvailabilityZones() == null ? 1 : 0) ^ (getAvailabilityZones() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getAvailabilityZones() != null && !updateAutoScalingGroupRequest.getAvailabilityZones().equals(getAvailabilityZones())) {
            return false;
        }
        if (((updateAutoScalingGroupRequest.getHealthCheckType() == null ? 1 : 0) ^ (getHealthCheckType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getHealthCheckType() != null && !updateAutoScalingGroupRequest.getHealthCheckType().equals(getHealthCheckType())) {
            return false;
        }
        if (((updateAutoScalingGroupRequest.getHealthCheckGracePeriod() == null ? 1 : 0) ^ (getHealthCheckGracePeriod() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getHealthCheckGracePeriod() != null && !updateAutoScalingGroupRequest.getHealthCheckGracePeriod().equals(getHealthCheckGracePeriod())) {
            return false;
        }
        if (((updateAutoScalingGroupRequest.getPlacementGroup() == null ? 1 : 0) ^ (getPlacementGroup() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getPlacementGroup() != null && !updateAutoScalingGroupRequest.getPlacementGroup().equals(getPlacementGroup())) {
            return false;
        }
        if (((updateAutoScalingGroupRequest.getVPCZoneIdentifier() == null ? 1 : 0) ^ (getVPCZoneIdentifier() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (updateAutoScalingGroupRequest.getVPCZoneIdentifier() != null && !updateAutoScalingGroupRequest.getVPCZoneIdentifier().equals(getVPCZoneIdentifier())) {
            return false;
        }
        return ((updateAutoScalingGroupRequest.getTerminationPolicies() == null ? 1 : 0) ^ (getTerminationPolicies() == null ? 1 : 0)) == 0 ? updateAutoScalingGroupRequest.getTerminationPolicies() == null || updateAutoScalingGroupRequest.getTerminationPolicies().equals(getTerminationPolicies()) : false;
    }

    public String getAutoScalingGroupName() {
        return this.autoScalingGroupName;
    }

    public List<String> getAvailabilityZones() {
        if (this.availabilityZones == null) {
            this.availabilityZones = new ArrayList();
        }
        return this.availabilityZones;
    }

    public Integer getDefaultCooldown() {
        return this.defaultCooldown;
    }

    public Integer getDesiredCapacity() {
        return this.desiredCapacity;
    }

    public Integer getHealthCheckGracePeriod() {
        return this.healthCheckGracePeriod;
    }

    public String getHealthCheckType() {
        return this.healthCheckType;
    }

    public String getLaunchConfigurationName() {
        return this.launchConfigurationName;
    }

    public Integer getMaxSize() {
        return this.maxSize;
    }

    public Integer getMinSize() {
        return this.minSize;
    }

    public String getPlacementGroup() {
        return this.placementGroup;
    }

    public List<String> getTerminationPolicies() {
        if (this.terminationPolicies == null) {
            this.terminationPolicies = new ArrayList();
        }
        return this.terminationPolicies;
    }

    public String getVPCZoneIdentifier() {
        return this.vPCZoneIdentifier;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getVPCZoneIdentifier() == null ? 0 : getVPCZoneIdentifier().hashCode()) + (((getPlacementGroup() == null ? 0 : getPlacementGroup().hashCode()) + (((getHealthCheckGracePeriod() == null ? 0 : getHealthCheckGracePeriod().hashCode()) + (((getHealthCheckType() == null ? 0 : getHealthCheckType().hashCode()) + (((getAvailabilityZones() == null ? 0 : getAvailabilityZones().hashCode()) + (((getDefaultCooldown() == null ? 0 : getDefaultCooldown().hashCode()) + (((getDesiredCapacity() == null ? 0 : getDesiredCapacity().hashCode()) + (((getMaxSize() == null ? 0 : getMaxSize().hashCode()) + (((getMinSize() == null ? 0 : getMinSize().hashCode()) + (((getLaunchConfigurationName() == null ? 0 : getLaunchConfigurationName().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getTerminationPolicies() != null) {
            i = getTerminationPolicies().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
    }

    public void setAvailabilityZones(Collection<String> collection) {
        if (collection == null) {
            this.availabilityZones = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.availabilityZones = arrayList;
    }

    public void setDefaultCooldown(Integer num) {
        this.defaultCooldown = num;
    }

    public void setDesiredCapacity(Integer num) {
        this.desiredCapacity = num;
    }

    public void setHealthCheckGracePeriod(Integer num) {
        this.healthCheckGracePeriod = num;
    }

    public void setHealthCheckType(String str) {
        this.healthCheckType = str;
    }

    public void setLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
    }

    public void setMaxSize(Integer num) {
        this.maxSize = num;
    }

    public void setMinSize(Integer num) {
        this.minSize = num;
    }

    public void setPlacementGroup(String str) {
        this.placementGroup = str;
    }

    public void setTerminationPolicies(Collection<String> collection) {
        if (collection == null) {
            this.terminationPolicies = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.terminationPolicies = arrayList;
    }

    public void setVPCZoneIdentifier(String str) {
        this.vPCZoneIdentifier = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.autoScalingGroupName != null) {
            stringBuilder.append("AutoScalingGroupName: " + this.autoScalingGroupName + ", ");
        }
        if (this.launchConfigurationName != null) {
            stringBuilder.append("LaunchConfigurationName: " + this.launchConfigurationName + ", ");
        }
        if (this.minSize != null) {
            stringBuilder.append("MinSize: " + this.minSize + ", ");
        }
        if (this.maxSize != null) {
            stringBuilder.append("MaxSize: " + this.maxSize + ", ");
        }
        if (this.desiredCapacity != null) {
            stringBuilder.append("DesiredCapacity: " + this.desiredCapacity + ", ");
        }
        if (this.defaultCooldown != null) {
            stringBuilder.append("DefaultCooldown: " + this.defaultCooldown + ", ");
        }
        if (this.availabilityZones != null) {
            stringBuilder.append("AvailabilityZones: " + this.availabilityZones + ", ");
        }
        if (this.healthCheckType != null) {
            stringBuilder.append("HealthCheckType: " + this.healthCheckType + ", ");
        }
        if (this.healthCheckGracePeriod != null) {
            stringBuilder.append("HealthCheckGracePeriod: " + this.healthCheckGracePeriod + ", ");
        }
        if (this.placementGroup != null) {
            stringBuilder.append("PlacementGroup: " + this.placementGroup + ", ");
        }
        if (this.vPCZoneIdentifier != null) {
            stringBuilder.append("VPCZoneIdentifier: " + this.vPCZoneIdentifier + ", ");
        }
        if (this.terminationPolicies != null) {
            stringBuilder.append("TerminationPolicies: " + this.terminationPolicies + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public UpdateAutoScalingGroupRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public UpdateAutoScalingGroupRequest withAvailabilityZones(Collection<String> collection) {
        if (collection == null) {
            this.availabilityZones = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.availabilityZones = arrayList;
        }
        return this;
    }

    public UpdateAutoScalingGroupRequest withAvailabilityZones(String... strArr) {
        if (getAvailabilityZones() == null) {
            setAvailabilityZones(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAvailabilityZones().add(add);
        }
        return this;
    }

    public UpdateAutoScalingGroupRequest withDefaultCooldown(Integer num) {
        this.defaultCooldown = num;
        return this;
    }

    public UpdateAutoScalingGroupRequest withDesiredCapacity(Integer num) {
        this.desiredCapacity = num;
        return this;
    }

    public UpdateAutoScalingGroupRequest withHealthCheckGracePeriod(Integer num) {
        this.healthCheckGracePeriod = num;
        return this;
    }

    public UpdateAutoScalingGroupRequest withHealthCheckType(String str) {
        this.healthCheckType = str;
        return this;
    }

    public UpdateAutoScalingGroupRequest withLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
        return this;
    }

    public UpdateAutoScalingGroupRequest withMaxSize(Integer num) {
        this.maxSize = num;
        return this;
    }

    public UpdateAutoScalingGroupRequest withMinSize(Integer num) {
        this.minSize = num;
        return this;
    }

    public UpdateAutoScalingGroupRequest withPlacementGroup(String str) {
        this.placementGroup = str;
        return this;
    }

    public UpdateAutoScalingGroupRequest withTerminationPolicies(Collection<String> collection) {
        if (collection == null) {
            this.terminationPolicies = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.terminationPolicies = arrayList;
        }
        return this;
    }

    public UpdateAutoScalingGroupRequest withTerminationPolicies(String... strArr) {
        if (getTerminationPolicies() == null) {
            setTerminationPolicies(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getTerminationPolicies().add(add);
        }
        return this;
    }

    public UpdateAutoScalingGroupRequest withVPCZoneIdentifier(String str) {
        this.vPCZoneIdentifier = str;
        return this;
    }
}
