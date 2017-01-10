package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateAutoScalingGroupRequest extends AmazonWebServiceRequest {
    private String autoScalingGroupName;
    private List<String> availabilityZones;
    private Integer defaultCooldown;
    private Integer desiredCapacity;
    private Integer healthCheckGracePeriod;
    private String healthCheckType;
    private String launchConfigurationName;
    private List<String> loadBalancerNames;
    private Integer maxSize;
    private Integer minSize;
    private String placementGroup;
    private List<Tag> tags;
    private List<String> terminationPolicies;
    private String vPCZoneIdentifier;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateAutoScalingGroupRequest)) {
            return false;
        }
        CreateAutoScalingGroupRequest createAutoScalingGroupRequest = (CreateAutoScalingGroupRequest) obj;
        if (((createAutoScalingGroupRequest.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getAutoScalingGroupName() != null && !createAutoScalingGroupRequest.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getLaunchConfigurationName() == null ? 1 : 0) ^ (getLaunchConfigurationName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getLaunchConfigurationName() != null && !createAutoScalingGroupRequest.getLaunchConfigurationName().equals(getLaunchConfigurationName())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getMinSize() == null ? 1 : 0) ^ (getMinSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getMinSize() != null && !createAutoScalingGroupRequest.getMinSize().equals(getMinSize())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getMaxSize() == null ? 1 : 0) ^ (getMaxSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getMaxSize() != null && !createAutoScalingGroupRequest.getMaxSize().equals(getMaxSize())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getDesiredCapacity() == null ? 1 : 0) ^ (getDesiredCapacity() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getDesiredCapacity() != null && !createAutoScalingGroupRequest.getDesiredCapacity().equals(getDesiredCapacity())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getDefaultCooldown() == null ? 1 : 0) ^ (getDefaultCooldown() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getDefaultCooldown() != null && !createAutoScalingGroupRequest.getDefaultCooldown().equals(getDefaultCooldown())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getAvailabilityZones() == null ? 1 : 0) ^ (getAvailabilityZones() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getAvailabilityZones() != null && !createAutoScalingGroupRequest.getAvailabilityZones().equals(getAvailabilityZones())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getLoadBalancerNames() == null ? 1 : 0) ^ (getLoadBalancerNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getLoadBalancerNames() != null && !createAutoScalingGroupRequest.getLoadBalancerNames().equals(getLoadBalancerNames())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getHealthCheckType() == null ? 1 : 0) ^ (getHealthCheckType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getHealthCheckType() != null && !createAutoScalingGroupRequest.getHealthCheckType().equals(getHealthCheckType())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getHealthCheckGracePeriod() == null ? 1 : 0) ^ (getHealthCheckGracePeriod() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getHealthCheckGracePeriod() != null && !createAutoScalingGroupRequest.getHealthCheckGracePeriod().equals(getHealthCheckGracePeriod())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getPlacementGroup() == null ? 1 : 0) ^ (getPlacementGroup() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getPlacementGroup() != null && !createAutoScalingGroupRequest.getPlacementGroup().equals(getPlacementGroup())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getVPCZoneIdentifier() == null ? 1 : 0) ^ (getVPCZoneIdentifier() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getVPCZoneIdentifier() != null && !createAutoScalingGroupRequest.getVPCZoneIdentifier().equals(getVPCZoneIdentifier())) {
            return false;
        }
        if (((createAutoScalingGroupRequest.getTerminationPolicies() == null ? 1 : 0) ^ (getTerminationPolicies() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (createAutoScalingGroupRequest.getTerminationPolicies() != null && !createAutoScalingGroupRequest.getTerminationPolicies().equals(getTerminationPolicies())) {
            return false;
        }
        return ((createAutoScalingGroupRequest.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) == 0 ? createAutoScalingGroupRequest.getTags() == null || createAutoScalingGroupRequest.getTags().equals(getTags()) : false;
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

    public List<String> getLoadBalancerNames() {
        if (this.loadBalancerNames == null) {
            this.loadBalancerNames = new ArrayList();
        }
        return this.loadBalancerNames;
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

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
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
        int hashCode = ((getTerminationPolicies() == null ? 0 : getTerminationPolicies().hashCode()) + (((getVPCZoneIdentifier() == null ? 0 : getVPCZoneIdentifier().hashCode()) + (((getPlacementGroup() == null ? 0 : getPlacementGroup().hashCode()) + (((getHealthCheckGracePeriod() == null ? 0 : getHealthCheckGracePeriod().hashCode()) + (((getHealthCheckType() == null ? 0 : getHealthCheckType().hashCode()) + (((getLoadBalancerNames() == null ? 0 : getLoadBalancerNames().hashCode()) + (((getAvailabilityZones() == null ? 0 : getAvailabilityZones().hashCode()) + (((getDefaultCooldown() == null ? 0 : getDefaultCooldown().hashCode()) + (((getDesiredCapacity() == null ? 0 : getDesiredCapacity().hashCode()) + (((getMaxSize() == null ? 0 : getMaxSize().hashCode()) + (((getMinSize() == null ? 0 : getMinSize().hashCode()) + (((getLaunchConfigurationName() == null ? 0 : getLaunchConfigurationName().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getTags() != null) {
            i = getTags().hashCode();
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

    public void setLoadBalancerNames(Collection<String> collection) {
        if (collection == null) {
            this.loadBalancerNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.loadBalancerNames = arrayList;
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

    public void setTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.tags = arrayList;
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
        if (this.loadBalancerNames != null) {
            stringBuilder.append("LoadBalancerNames: " + this.loadBalancerNames + ", ");
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
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateAutoScalingGroupRequest withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public CreateAutoScalingGroupRequest withAvailabilityZones(Collection<String> collection) {
        if (collection == null) {
            this.availabilityZones = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.availabilityZones = arrayList;
        }
        return this;
    }

    public CreateAutoScalingGroupRequest withAvailabilityZones(String... strArr) {
        if (getAvailabilityZones() == null) {
            setAvailabilityZones(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAvailabilityZones().add(add);
        }
        return this;
    }

    public CreateAutoScalingGroupRequest withDefaultCooldown(Integer num) {
        this.defaultCooldown = num;
        return this;
    }

    public CreateAutoScalingGroupRequest withDesiredCapacity(Integer num) {
        this.desiredCapacity = num;
        return this;
    }

    public CreateAutoScalingGroupRequest withHealthCheckGracePeriod(Integer num) {
        this.healthCheckGracePeriod = num;
        return this;
    }

    public CreateAutoScalingGroupRequest withHealthCheckType(String str) {
        this.healthCheckType = str;
        return this;
    }

    public CreateAutoScalingGroupRequest withLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
        return this;
    }

    public CreateAutoScalingGroupRequest withLoadBalancerNames(Collection<String> collection) {
        if (collection == null) {
            this.loadBalancerNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.loadBalancerNames = arrayList;
        }
        return this;
    }

    public CreateAutoScalingGroupRequest withLoadBalancerNames(String... strArr) {
        if (getLoadBalancerNames() == null) {
            setLoadBalancerNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getLoadBalancerNames().add(add);
        }
        return this;
    }

    public CreateAutoScalingGroupRequest withMaxSize(Integer num) {
        this.maxSize = num;
        return this;
    }

    public CreateAutoScalingGroupRequest withMinSize(Integer num) {
        this.minSize = num;
        return this;
    }

    public CreateAutoScalingGroupRequest withPlacementGroup(String str) {
        this.placementGroup = str;
        return this;
    }

    public CreateAutoScalingGroupRequest withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public CreateAutoScalingGroupRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }

    public CreateAutoScalingGroupRequest withTerminationPolicies(Collection<String> collection) {
        if (collection == null) {
            this.terminationPolicies = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.terminationPolicies = arrayList;
        }
        return this;
    }

    public CreateAutoScalingGroupRequest withTerminationPolicies(String... strArr) {
        if (getTerminationPolicies() == null) {
            setTerminationPolicies(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getTerminationPolicies().add(add);
        }
        return this;
    }

    public CreateAutoScalingGroupRequest withVPCZoneIdentifier(String str) {
        this.vPCZoneIdentifier = str;
        return this;
    }
}
