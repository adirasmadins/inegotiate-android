package com.amazonaws.services.elasticloadbalancing.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class LoadBalancerDescription {
    private List<String> availabilityZones;
    private List<BackendServerDescription> backendServerDescriptions;
    private String canonicalHostedZoneName;
    private String canonicalHostedZoneNameID;
    private Date createdTime;
    private String dNSName;
    private HealthCheck healthCheck;
    private List<Instance> instances;
    private List<ListenerDescription> listenerDescriptions;
    private String loadBalancerName;
    private Policies policies;
    private String scheme;
    private List<String> securityGroups;
    private SourceSecurityGroup sourceSecurityGroup;
    private List<String> subnets;
    private String vPCId;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LoadBalancerDescription)) {
            return false;
        }
        LoadBalancerDescription loadBalancerDescription = (LoadBalancerDescription) obj;
        if (((loadBalancerDescription.getLoadBalancerName() == null ? 1 : 0) ^ (getLoadBalancerName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getLoadBalancerName() != null && !loadBalancerDescription.getLoadBalancerName().equals(getLoadBalancerName())) {
            return false;
        }
        if (((loadBalancerDescription.getDNSName() == null ? 1 : 0) ^ (getDNSName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getDNSName() != null && !loadBalancerDescription.getDNSName().equals(getDNSName())) {
            return false;
        }
        if (((loadBalancerDescription.getCanonicalHostedZoneName() == null ? 1 : 0) ^ (getCanonicalHostedZoneName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getCanonicalHostedZoneName() != null && !loadBalancerDescription.getCanonicalHostedZoneName().equals(getCanonicalHostedZoneName())) {
            return false;
        }
        if (((loadBalancerDescription.getCanonicalHostedZoneNameID() == null ? 1 : 0) ^ (getCanonicalHostedZoneNameID() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getCanonicalHostedZoneNameID() != null && !loadBalancerDescription.getCanonicalHostedZoneNameID().equals(getCanonicalHostedZoneNameID())) {
            return false;
        }
        if (((loadBalancerDescription.getListenerDescriptions() == null ? 1 : 0) ^ (getListenerDescriptions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getListenerDescriptions() != null && !loadBalancerDescription.getListenerDescriptions().equals(getListenerDescriptions())) {
            return false;
        }
        if (((loadBalancerDescription.getPolicies() == null ? 1 : 0) ^ (getPolicies() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getPolicies() != null && !loadBalancerDescription.getPolicies().equals(getPolicies())) {
            return false;
        }
        if (((loadBalancerDescription.getBackendServerDescriptions() == null ? 1 : 0) ^ (getBackendServerDescriptions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getBackendServerDescriptions() != null && !loadBalancerDescription.getBackendServerDescriptions().equals(getBackendServerDescriptions())) {
            return false;
        }
        if (((loadBalancerDescription.getAvailabilityZones() == null ? 1 : 0) ^ (getAvailabilityZones() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getAvailabilityZones() != null && !loadBalancerDescription.getAvailabilityZones().equals(getAvailabilityZones())) {
            return false;
        }
        if (((loadBalancerDescription.getSubnets() == null ? 1 : 0) ^ (getSubnets() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getSubnets() != null && !loadBalancerDescription.getSubnets().equals(getSubnets())) {
            return false;
        }
        if (((loadBalancerDescription.getVPCId() == null ? 1 : 0) ^ (getVPCId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getVPCId() != null && !loadBalancerDescription.getVPCId().equals(getVPCId())) {
            return false;
        }
        if (((loadBalancerDescription.getInstances() == null ? 1 : 0) ^ (getInstances() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getInstances() != null && !loadBalancerDescription.getInstances().equals(getInstances())) {
            return false;
        }
        if (((loadBalancerDescription.getHealthCheck() == null ? 1 : 0) ^ (getHealthCheck() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getHealthCheck() != null && !loadBalancerDescription.getHealthCheck().equals(getHealthCheck())) {
            return false;
        }
        if (((loadBalancerDescription.getSourceSecurityGroup() == null ? 1 : 0) ^ (getSourceSecurityGroup() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getSourceSecurityGroup() != null && !loadBalancerDescription.getSourceSecurityGroup().equals(getSourceSecurityGroup())) {
            return false;
        }
        if (((loadBalancerDescription.getSecurityGroups() == null ? 1 : 0) ^ (getSecurityGroups() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getSecurityGroups() != null && !loadBalancerDescription.getSecurityGroups().equals(getSecurityGroups())) {
            return false;
        }
        if (((loadBalancerDescription.getCreatedTime() == null ? 1 : 0) ^ (getCreatedTime() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (loadBalancerDescription.getCreatedTime() != null && !loadBalancerDescription.getCreatedTime().equals(getCreatedTime())) {
            return false;
        }
        return ((loadBalancerDescription.getScheme() == null ? 1 : 0) ^ (getScheme() == null ? 1 : 0)) == 0 ? loadBalancerDescription.getScheme() == null || loadBalancerDescription.getScheme().equals(getScheme()) : false;
    }

    public List<String> getAvailabilityZones() {
        if (this.availabilityZones == null) {
            this.availabilityZones = new ArrayList();
        }
        return this.availabilityZones;
    }

    public List<BackendServerDescription> getBackendServerDescriptions() {
        if (this.backendServerDescriptions == null) {
            this.backendServerDescriptions = new ArrayList();
        }
        return this.backendServerDescriptions;
    }

    public String getCanonicalHostedZoneName() {
        return this.canonicalHostedZoneName;
    }

    public String getCanonicalHostedZoneNameID() {
        return this.canonicalHostedZoneNameID;
    }

    public Date getCreatedTime() {
        return this.createdTime;
    }

    public String getDNSName() {
        return this.dNSName;
    }

    public HealthCheck getHealthCheck() {
        return this.healthCheck;
    }

    public List<Instance> getInstances() {
        if (this.instances == null) {
            this.instances = new ArrayList();
        }
        return this.instances;
    }

    public List<ListenerDescription> getListenerDescriptions() {
        if (this.listenerDescriptions == null) {
            this.listenerDescriptions = new ArrayList();
        }
        return this.listenerDescriptions;
    }

    public String getLoadBalancerName() {
        return this.loadBalancerName;
    }

    public Policies getPolicies() {
        return this.policies;
    }

    public String getScheme() {
        return this.scheme;
    }

    public List<String> getSecurityGroups() {
        if (this.securityGroups == null) {
            this.securityGroups = new ArrayList();
        }
        return this.securityGroups;
    }

    public SourceSecurityGroup getSourceSecurityGroup() {
        return this.sourceSecurityGroup;
    }

    public List<String> getSubnets() {
        if (this.subnets == null) {
            this.subnets = new ArrayList();
        }
        return this.subnets;
    }

    public String getVPCId() {
        return this.vPCId;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCreatedTime() == null ? 0 : getCreatedTime().hashCode()) + (((getSecurityGroups() == null ? 0 : getSecurityGroups().hashCode()) + (((getSourceSecurityGroup() == null ? 0 : getSourceSecurityGroup().hashCode()) + (((getHealthCheck() == null ? 0 : getHealthCheck().hashCode()) + (((getInstances() == null ? 0 : getInstances().hashCode()) + (((getVPCId() == null ? 0 : getVPCId().hashCode()) + (((getSubnets() == null ? 0 : getSubnets().hashCode()) + (((getAvailabilityZones() == null ? 0 : getAvailabilityZones().hashCode()) + (((getBackendServerDescriptions() == null ? 0 : getBackendServerDescriptions().hashCode()) + (((getPolicies() == null ? 0 : getPolicies().hashCode()) + (((getListenerDescriptions() == null ? 0 : getListenerDescriptions().hashCode()) + (((getCanonicalHostedZoneNameID() == null ? 0 : getCanonicalHostedZoneNameID().hashCode()) + (((getCanonicalHostedZoneName() == null ? 0 : getCanonicalHostedZoneName().hashCode()) + (((getDNSName() == null ? 0 : getDNSName().hashCode()) + (((getLoadBalancerName() == null ? 0 : getLoadBalancerName().hashCode()) + 31) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        if (getScheme() != null) {
            i = getScheme().hashCode();
        }
        return hashCode + i;
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

    public void setBackendServerDescriptions(Collection<BackendServerDescription> collection) {
        if (collection == null) {
            this.backendServerDescriptions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.backendServerDescriptions = arrayList;
    }

    public void setCanonicalHostedZoneName(String str) {
        this.canonicalHostedZoneName = str;
    }

    public void setCanonicalHostedZoneNameID(String str) {
        this.canonicalHostedZoneNameID = str;
    }

    public void setCreatedTime(Date date) {
        this.createdTime = date;
    }

    public void setDNSName(String str) {
        this.dNSName = str;
    }

    public void setHealthCheck(HealthCheck healthCheck) {
        this.healthCheck = healthCheck;
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

    public void setListenerDescriptions(Collection<ListenerDescription> collection) {
        if (collection == null) {
            this.listenerDescriptions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.listenerDescriptions = arrayList;
    }

    public void setLoadBalancerName(String str) {
        this.loadBalancerName = str;
    }

    public void setPolicies(Policies policies) {
        this.policies = policies;
    }

    public void setScheme(String str) {
        this.scheme = str;
    }

    public void setSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.securityGroups = arrayList;
    }

    public void setSourceSecurityGroup(SourceSecurityGroup sourceSecurityGroup) {
        this.sourceSecurityGroup = sourceSecurityGroup;
    }

    public void setSubnets(Collection<String> collection) {
        if (collection == null) {
            this.subnets = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.subnets = arrayList;
    }

    public void setVPCId(String str) {
        this.vPCId = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.loadBalancerName != null) {
            stringBuilder.append("LoadBalancerName: " + this.loadBalancerName + ", ");
        }
        if (this.dNSName != null) {
            stringBuilder.append("DNSName: " + this.dNSName + ", ");
        }
        if (this.canonicalHostedZoneName != null) {
            stringBuilder.append("CanonicalHostedZoneName: " + this.canonicalHostedZoneName + ", ");
        }
        if (this.canonicalHostedZoneNameID != null) {
            stringBuilder.append("CanonicalHostedZoneNameID: " + this.canonicalHostedZoneNameID + ", ");
        }
        if (this.listenerDescriptions != null) {
            stringBuilder.append("ListenerDescriptions: " + this.listenerDescriptions + ", ");
        }
        if (this.policies != null) {
            stringBuilder.append("Policies: " + this.policies + ", ");
        }
        if (this.backendServerDescriptions != null) {
            stringBuilder.append("BackendServerDescriptions: " + this.backendServerDescriptions + ", ");
        }
        if (this.availabilityZones != null) {
            stringBuilder.append("AvailabilityZones: " + this.availabilityZones + ", ");
        }
        if (this.subnets != null) {
            stringBuilder.append("Subnets: " + this.subnets + ", ");
        }
        if (this.vPCId != null) {
            stringBuilder.append("VPCId: " + this.vPCId + ", ");
        }
        if (this.instances != null) {
            stringBuilder.append("Instances: " + this.instances + ", ");
        }
        if (this.healthCheck != null) {
            stringBuilder.append("HealthCheck: " + this.healthCheck + ", ");
        }
        if (this.sourceSecurityGroup != null) {
            stringBuilder.append("SourceSecurityGroup: " + this.sourceSecurityGroup + ", ");
        }
        if (this.securityGroups != null) {
            stringBuilder.append("SecurityGroups: " + this.securityGroups + ", ");
        }
        if (this.createdTime != null) {
            stringBuilder.append("CreatedTime: " + this.createdTime + ", ");
        }
        if (this.scheme != null) {
            stringBuilder.append("Scheme: " + this.scheme + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public LoadBalancerDescription withAvailabilityZones(Collection<String> collection) {
        if (collection == null) {
            this.availabilityZones = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.availabilityZones = arrayList;
        }
        return this;
    }

    public LoadBalancerDescription withAvailabilityZones(String... strArr) {
        if (getAvailabilityZones() == null) {
            setAvailabilityZones(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAvailabilityZones().add(add);
        }
        return this;
    }

    public LoadBalancerDescription withBackendServerDescriptions(Collection<BackendServerDescription> collection) {
        if (collection == null) {
            this.backendServerDescriptions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.backendServerDescriptions = arrayList;
        }
        return this;
    }

    public LoadBalancerDescription withBackendServerDescriptions(BackendServerDescription... backendServerDescriptionArr) {
        if (getBackendServerDescriptions() == null) {
            setBackendServerDescriptions(new ArrayList(backendServerDescriptionArr.length));
        }
        for (Object add : backendServerDescriptionArr) {
            getBackendServerDescriptions().add(add);
        }
        return this;
    }

    public LoadBalancerDescription withCanonicalHostedZoneName(String str) {
        this.canonicalHostedZoneName = str;
        return this;
    }

    public LoadBalancerDescription withCanonicalHostedZoneNameID(String str) {
        this.canonicalHostedZoneNameID = str;
        return this;
    }

    public LoadBalancerDescription withCreatedTime(Date date) {
        this.createdTime = date;
        return this;
    }

    public LoadBalancerDescription withDNSName(String str) {
        this.dNSName = str;
        return this;
    }

    public LoadBalancerDescription withHealthCheck(HealthCheck healthCheck) {
        this.healthCheck = healthCheck;
        return this;
    }

    public LoadBalancerDescription withInstances(Collection<Instance> collection) {
        if (collection == null) {
            this.instances = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.instances = arrayList;
        }
        return this;
    }

    public LoadBalancerDescription withInstances(Instance... instanceArr) {
        if (getInstances() == null) {
            setInstances(new ArrayList(instanceArr.length));
        }
        for (Object add : instanceArr) {
            getInstances().add(add);
        }
        return this;
    }

    public LoadBalancerDescription withListenerDescriptions(Collection<ListenerDescription> collection) {
        if (collection == null) {
            this.listenerDescriptions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.listenerDescriptions = arrayList;
        }
        return this;
    }

    public LoadBalancerDescription withListenerDescriptions(ListenerDescription... listenerDescriptionArr) {
        if (getListenerDescriptions() == null) {
            setListenerDescriptions(new ArrayList(listenerDescriptionArr.length));
        }
        for (Object add : listenerDescriptionArr) {
            getListenerDescriptions().add(add);
        }
        return this;
    }

    public LoadBalancerDescription withLoadBalancerName(String str) {
        this.loadBalancerName = str;
        return this;
    }

    public LoadBalancerDescription withPolicies(Policies policies) {
        this.policies = policies;
        return this;
    }

    public LoadBalancerDescription withScheme(String str) {
        this.scheme = str;
        return this;
    }

    public LoadBalancerDescription withSecurityGroups(Collection<String> collection) {
        if (collection == null) {
            this.securityGroups = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.securityGroups = arrayList;
        }
        return this;
    }

    public LoadBalancerDescription withSecurityGroups(String... strArr) {
        if (getSecurityGroups() == null) {
            setSecurityGroups(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSecurityGroups().add(add);
        }
        return this;
    }

    public LoadBalancerDescription withSourceSecurityGroup(SourceSecurityGroup sourceSecurityGroup) {
        this.sourceSecurityGroup = sourceSecurityGroup;
        return this;
    }

    public LoadBalancerDescription withSubnets(Collection<String> collection) {
        if (collection == null) {
            this.subnets = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.subnets = arrayList;
        }
        return this;
    }

    public LoadBalancerDescription withSubnets(String... strArr) {
        if (getSubnets() == null) {
            setSubnets(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getSubnets().add(add);
        }
        return this;
    }

    public LoadBalancerDescription withVPCId(String str) {
        this.vPCId = str;
        return this;
    }
}
