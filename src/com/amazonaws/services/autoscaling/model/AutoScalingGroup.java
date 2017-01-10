package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class AutoScalingGroup {
    private String autoScalingGroupARN;
    private String autoScalingGroupName;
    private List<String> availabilityZones;
    private Date createdTime;
    private Integer defaultCooldown;
    private Integer desiredCapacity;
    private List<EnabledMetric> enabledMetrics;
    private Integer healthCheckGracePeriod;
    private String healthCheckType;
    private List<Instance> instances;
    private String launchConfigurationName;
    private List<String> loadBalancerNames;
    private Integer maxSize;
    private Integer minSize;
    private String placementGroup;
    private String status;
    private List<SuspendedProcess> suspendedProcesses;
    private List<TagDescription> tags;
    private List<String> terminationPolicies;
    private String vPCZoneIdentifier;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AutoScalingGroup)) {
            return false;
        }
        AutoScalingGroup autoScalingGroup = (AutoScalingGroup) obj;
        if (((autoScalingGroup.getAutoScalingGroupName() == null ? 1 : 0) ^ (getAutoScalingGroupName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getAutoScalingGroupName() != null && !autoScalingGroup.getAutoScalingGroupName().equals(getAutoScalingGroupName())) {
            return false;
        }
        if (((autoScalingGroup.getAutoScalingGroupARN() == null ? 1 : 0) ^ (getAutoScalingGroupARN() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getAutoScalingGroupARN() != null && !autoScalingGroup.getAutoScalingGroupARN().equals(getAutoScalingGroupARN())) {
            return false;
        }
        if (((autoScalingGroup.getLaunchConfigurationName() == null ? 1 : 0) ^ (getLaunchConfigurationName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getLaunchConfigurationName() != null && !autoScalingGroup.getLaunchConfigurationName().equals(getLaunchConfigurationName())) {
            return false;
        }
        if (((autoScalingGroup.getMinSize() == null ? 1 : 0) ^ (getMinSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getMinSize() != null && !autoScalingGroup.getMinSize().equals(getMinSize())) {
            return false;
        }
        if (((autoScalingGroup.getMaxSize() == null ? 1 : 0) ^ (getMaxSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getMaxSize() != null && !autoScalingGroup.getMaxSize().equals(getMaxSize())) {
            return false;
        }
        if (((autoScalingGroup.getDesiredCapacity() == null ? 1 : 0) ^ (getDesiredCapacity() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getDesiredCapacity() != null && !autoScalingGroup.getDesiredCapacity().equals(getDesiredCapacity())) {
            return false;
        }
        if (((autoScalingGroup.getDefaultCooldown() == null ? 1 : 0) ^ (getDefaultCooldown() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getDefaultCooldown() != null && !autoScalingGroup.getDefaultCooldown().equals(getDefaultCooldown())) {
            return false;
        }
        if (((autoScalingGroup.getAvailabilityZones() == null ? 1 : 0) ^ (getAvailabilityZones() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getAvailabilityZones() != null && !autoScalingGroup.getAvailabilityZones().equals(getAvailabilityZones())) {
            return false;
        }
        if (((autoScalingGroup.getLoadBalancerNames() == null ? 1 : 0) ^ (getLoadBalancerNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getLoadBalancerNames() != null && !autoScalingGroup.getLoadBalancerNames().equals(getLoadBalancerNames())) {
            return false;
        }
        if (((autoScalingGroup.getHealthCheckType() == null ? 1 : 0) ^ (getHealthCheckType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getHealthCheckType() != null && !autoScalingGroup.getHealthCheckType().equals(getHealthCheckType())) {
            return false;
        }
        if (((autoScalingGroup.getHealthCheckGracePeriod() == null ? 1 : 0) ^ (getHealthCheckGracePeriod() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getHealthCheckGracePeriod() != null && !autoScalingGroup.getHealthCheckGracePeriod().equals(getHealthCheckGracePeriod())) {
            return false;
        }
        if (((autoScalingGroup.getInstances() == null ? 1 : 0) ^ (getInstances() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getInstances() != null && !autoScalingGroup.getInstances().equals(getInstances())) {
            return false;
        }
        if (((autoScalingGroup.getCreatedTime() == null ? 1 : 0) ^ (getCreatedTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getCreatedTime() != null && !autoScalingGroup.getCreatedTime().equals(getCreatedTime())) {
            return false;
        }
        if (((autoScalingGroup.getSuspendedProcesses() == null ? 1 : 0) ^ (getSuspendedProcesses() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getSuspendedProcesses() != null && !autoScalingGroup.getSuspendedProcesses().equals(getSuspendedProcesses())) {
            return false;
        }
        if (((autoScalingGroup.getPlacementGroup() == null ? 1 : 0) ^ (getPlacementGroup() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getPlacementGroup() != null && !autoScalingGroup.getPlacementGroup().equals(getPlacementGroup())) {
            return false;
        }
        if (((autoScalingGroup.getVPCZoneIdentifier() == null ? 1 : 0) ^ (getVPCZoneIdentifier() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getVPCZoneIdentifier() != null && !autoScalingGroup.getVPCZoneIdentifier().equals(getVPCZoneIdentifier())) {
            return false;
        }
        if (((autoScalingGroup.getEnabledMetrics() == null ? 1 : 0) ^ (getEnabledMetrics() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getEnabledMetrics() != null && !autoScalingGroup.getEnabledMetrics().equals(getEnabledMetrics())) {
            return false;
        }
        if (((autoScalingGroup.getStatus() == null ? 1 : 0) ^ (getStatus() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getStatus() != null && !autoScalingGroup.getStatus().equals(getStatus())) {
            return false;
        }
        if (((autoScalingGroup.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (autoScalingGroup.getTags() != null && !autoScalingGroup.getTags().equals(getTags())) {
            return false;
        }
        return ((autoScalingGroup.getTerminationPolicies() == null ? 1 : 0) ^ (getTerminationPolicies() == null ? 1 : 0)) == 0 ? autoScalingGroup.getTerminationPolicies() == null || autoScalingGroup.getTerminationPolicies().equals(getTerminationPolicies()) : false;
    }

    public String getAutoScalingGroupARN() {
        return this.autoScalingGroupARN;
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

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public Integer getDefaultCooldown() {
        return this.defaultCooldown;
    }

    public Integer getDesiredCapacity() {
        return this.desiredCapacity;
    }

    public List<EnabledMetric> getEnabledMetrics() {
        if (this.enabledMetrics == null) {
            this.enabledMetrics = new ArrayList();
        }
        return this.enabledMetrics;
    }

    public Integer getHealthCheckGracePeriod() {
        return this.healthCheckGracePeriod;
    }

    public String getHealthCheckType() {
        return this.healthCheckType;
    }

    public List<Instance> getInstances() {
        if (this.instances == null) {
            this.instances = new ArrayList();
        }
        return this.instances;
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

    public String getStatus() {
        return this.status;
    }

    public List<SuspendedProcess> getSuspendedProcesses() {
        if (this.suspendedProcesses == null) {
            this.suspendedProcesses = new ArrayList();
        }
        return this.suspendedProcesses;
    }

    public List<TagDescription> getTags() {
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
        int hashCode = ((getTags() == null ? 0 : getTags().hashCode()) + (((getStatus() == null ? 0 : getStatus().hashCode()) + (((getEnabledMetrics() == null ? 0 : getEnabledMetrics().hashCode()) + (((getVPCZoneIdentifier() == null ? 0 : getVPCZoneIdentifier().hashCode()) + (((getPlacementGroup() == null ? 0 : getPlacementGroup().hashCode()) + (((getSuspendedProcesses() == null ? 0 : getSuspendedProcesses().hashCode()) + (((getCreatedTime() == null ? 0 : getCreatedTime().hashCode()) + (((getInstances() == null ? 0 : getInstances().hashCode()) + (((getHealthCheckGracePeriod() == null ? 0 : getHealthCheckGracePeriod().hashCode()) + (((getHealthCheckType() == null ? 0 : getHealthCheckType().hashCode()) + (((getLoadBalancerNames() == null ? 0 : getLoadBalancerNames().hashCode()) + (((getAvailabilityZones() == null ? 0 : getAvailabilityZones().hashCode()) + (((getDefaultCooldown() == null ? 0 : getDefaultCooldown().hashCode()) + (((getDesiredCapacity() == null ? 0 : getDesiredCapacity().hashCode()) + (((getMaxSize() == null ? 0 : getMaxSize().hashCode()) + (((getMinSize() == null ? 0 : getMinSize().hashCode()) + (((getLaunchConfigurationName() == null ? 0 : getLaunchConfigurationName().hashCode()) + (((getAutoScalingGroupARN() == null ? 0 : getAutoScalingGroupARN().hashCode()) + (((getAutoScalingGroupName() == null ? 0 : getAutoScalingGroupName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getTerminationPolicies() != null) {
            i = getTerminationPolicies().hashCode();
        }
        return hashCode + i;
    }

    public void setAutoScalingGroupARN(String str) {
        this.autoScalingGroupARN = str;
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

    public void setCreatedTime(Date date) {
        this.createdTime = date;
    }

    public void setDefaultCooldown(Integer num) {
        this.defaultCooldown = num;
    }

    public void setDesiredCapacity(Integer num) {
        this.desiredCapacity = num;
    }

    public void setEnabledMetrics(Collection<EnabledMetric> collection) {
        if (collection == null) {
            this.enabledMetrics = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.enabledMetrics = arrayList;
    }

    public void setHealthCheckGracePeriod(Integer num) {
        this.healthCheckGracePeriod = num;
    }

    public void setHealthCheckType(String str) {
        this.healthCheckType = str;
    }

    public void setInstances(Collection<Instance> collection) {
        if (collection == null) {
            this.instances = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.instances = arrayList;
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

    public void setStatus(String str) {
        this.status = str;
    }

    public void setSuspendedProcesses(Collection<SuspendedProcess> collection) {
        if (collection == null) {
            this.suspendedProcesses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.suspendedProcesses = arrayList;
    }

    public void setTags(Collection<TagDescription> collection) {
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
        if (this.autoScalingGroupARN != null) {
            stringBuilder.append("AutoScalingGroupARN: " + this.autoScalingGroupARN + ", ");
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
        if (this.instances != null) {
            stringBuilder.append("Instances: " + this.instances + ", ");
        }
        if (this.createdTime != null) {
            stringBuilder.append("CreatedTime: " + this.createdTime + ", ");
        }
        if (this.suspendedProcesses != null) {
            stringBuilder.append("SuspendedProcesses: " + this.suspendedProcesses + ", ");
        }
        if (this.placementGroup != null) {
            stringBuilder.append("PlacementGroup: " + this.placementGroup + ", ");
        }
        if (this.vPCZoneIdentifier != null) {
            stringBuilder.append("VPCZoneIdentifier: " + this.vPCZoneIdentifier + ", ");
        }
        if (this.enabledMetrics != null) {
            stringBuilder.append("EnabledMetrics: " + this.enabledMetrics + ", ");
        }
        if (this.status != null) {
            stringBuilder.append("Status: " + this.status + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        if (this.terminationPolicies != null) {
            stringBuilder.append("TerminationPolicies: " + this.terminationPolicies + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AutoScalingGroup withAutoScalingGroupARN(String str) {
        this.autoScalingGroupARN = str;
        return this;
    }

    public AutoScalingGroup withAutoScalingGroupName(String str) {
        this.autoScalingGroupName = str;
        return this;
    }

    public AutoScalingGroup withAvailabilityZones(Collection<String> collection) {
        if (collection == null) {
            this.availabilityZones = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.availabilityZones = arrayList;
        }
        return this;
    }

    public AutoScalingGroup withAvailabilityZones(String... strArr) {
        if (getAvailabilityZones() == null) {
            setAvailabilityZones(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAvailabilityZones().add(add);
        }
        return this;
    }

    public AutoScalingGroup withCreatedTime(Date date) {
        this.createdTime = date;
        return this;
    }

    public AutoScalingGroup withDefaultCooldown(Integer num) {
        this.defaultCooldown = num;
        return this;
    }

    public AutoScalingGroup withDesiredCapacity(Integer num) {
        this.desiredCapacity = num;
        return this;
    }

    public AutoScalingGroup withEnabledMetrics(Collection<EnabledMetric> collection) {
        if (collection == null) {
            this.enabledMetrics = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.enabledMetrics = arrayList;
        }
        return this;
    }

    public AutoScalingGroup withEnabledMetrics(EnabledMetric... enabledMetricArr) {
        if (getEnabledMetrics() == null) {
            setEnabledMetrics(new ArrayList(enabledMetricArr.length));
        }
        for (Object add : enabledMetricArr) {
            getEnabledMetrics().add(add);
        }
        return this;
    }

    public AutoScalingGroup withHealthCheckGracePeriod(Integer num) {
        this.healthCheckGracePeriod = num;
        return this;
    }

    public AutoScalingGroup withHealthCheckType(String str) {
        this.healthCheckType = str;
        return this;
    }

    public AutoScalingGroup withInstances(Collection<Instance> collection) {
        if (collection == null) {
            this.instances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instances = arrayList;
        }
        return this;
    }

    public AutoScalingGroup withInstances(Instance... instanceArr) {
        if (getInstances() == null) {
            setInstances(new ArrayList(instanceArr.length));
        }
        for (Object add : instanceArr) {
            getInstances().add(add);
        }
        return this;
    }

    public AutoScalingGroup withLaunchConfigurationName(String str) {
        this.launchConfigurationName = str;
        return this;
    }

    public AutoScalingGroup withLoadBalancerNames(Collection<String> collection) {
        if (collection == null) {
            this.loadBalancerNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.loadBalancerNames = arrayList;
        }
        return this;
    }

    public AutoScalingGroup withLoadBalancerNames(String... strArr) {
        if (getLoadBalancerNames() == null) {
            setLoadBalancerNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getLoadBalancerNames().add(add);
        }
        return this;
    }

    public AutoScalingGroup withMaxSize(Integer num) {
        this.maxSize = num;
        return this;
    }

    public AutoScalingGroup withMinSize(Integer num) {
        this.minSize = num;
        return this;
    }

    public AutoScalingGroup withPlacementGroup(String str) {
        this.placementGroup = str;
        return this;
    }

    public AutoScalingGroup withStatus(String str) {
        this.status = str;
        return this;
    }

    public AutoScalingGroup withSuspendedProcesses(Collection<SuspendedProcess> collection) {
        if (collection == null) {
            this.suspendedProcesses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.suspendedProcesses = arrayList;
        }
        return this;
    }

    public AutoScalingGroup withSuspendedProcesses(SuspendedProcess... suspendedProcessArr) {
        if (getSuspendedProcesses() == null) {
            setSuspendedProcesses(new ArrayList(suspendedProcessArr.length));
        }
        for (Object add : suspendedProcessArr) {
            getSuspendedProcesses().add(add);
        }
        return this;
    }

    public AutoScalingGroup withTags(Collection<TagDescription> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public AutoScalingGroup withTags(TagDescription... tagDescriptionArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagDescriptionArr.length));
        }
        for (Object add : tagDescriptionArr) {
            getTags().add(add);
        }
        return this;
    }

    public AutoScalingGroup withTerminationPolicies(Collection<String> collection) {
        if (collection == null) {
            this.terminationPolicies = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.terminationPolicies = arrayList;
        }
        return this;
    }

    public AutoScalingGroup withTerminationPolicies(String... strArr) {
        if (getTerminationPolicies() == null) {
            setTerminationPolicies(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getTerminationPolicies().add(add);
        }
        return this;
    }

    public AutoScalingGroup withVPCZoneIdentifier(String str) {
        this.vPCZoneIdentifier = str;
        return this;
    }
}
