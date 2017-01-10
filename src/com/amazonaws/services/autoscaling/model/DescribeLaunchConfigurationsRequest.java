package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeLaunchConfigurationsRequest extends AmazonWebServiceRequest {
    private List<String> launchConfigurationNames;
    private Integer maxRecords;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLaunchConfigurationsRequest)) {
            return false;
        }
        DescribeLaunchConfigurationsRequest describeLaunchConfigurationsRequest = (DescribeLaunchConfigurationsRequest) obj;
        if (((describeLaunchConfigurationsRequest.getLaunchConfigurationNames() == null ? 1 : 0) ^ (getLaunchConfigurationNames() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeLaunchConfigurationsRequest.getLaunchConfigurationNames() != null && !describeLaunchConfigurationsRequest.getLaunchConfigurationNames().equals(getLaunchConfigurationNames())) {
            return false;
        }
        if (((describeLaunchConfigurationsRequest.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeLaunchConfigurationsRequest.getNextToken() != null && !describeLaunchConfigurationsRequest.getNextToken().equals(getNextToken())) {
            return false;
        }
        return ((describeLaunchConfigurationsRequest.getMaxRecords() == null ? 1 : 0) ^ (getMaxRecords() == null ? 1 : 0)) == 0 ? describeLaunchConfigurationsRequest.getMaxRecords() == null || describeLaunchConfigurationsRequest.getMaxRecords().equals(getMaxRecords()) : false;
    }

    public List<String> getLaunchConfigurationNames() {
        if (this.launchConfigurationNames == null) {
            this.launchConfigurationNames = new ArrayList();
        }
        return this.launchConfigurationNames;
    }

    public Integer getMaxRecords() {
        return this.maxRecords;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNextToken() == null ? 0 : getNextToken().hashCode()) + (((getLaunchConfigurationNames() == null ? 0 : getLaunchConfigurationNames().hashCode()) + 31) * 31)) * 31;
        if (getMaxRecords() != null) {
            i = getMaxRecords().hashCode();
        }
        return hashCode + i;
    }

    public void setLaunchConfigurationNames(Collection<String> collection) {
        if (collection == null) {
            this.launchConfigurationNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.launchConfigurationNames = arrayList;
    }

    public void setMaxRecords(Integer num) {
        this.maxRecords = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.launchConfigurationNames != null) {
            stringBuilder.append("LaunchConfigurationNames: " + this.launchConfigurationNames + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        if (this.maxRecords != null) {
            stringBuilder.append("MaxRecords: " + this.maxRecords + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeLaunchConfigurationsRequest withLaunchConfigurationNames(Collection<String> collection) {
        if (collection == null) {
            this.launchConfigurationNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.launchConfigurationNames = arrayList;
        }
        return this;
    }

    public DescribeLaunchConfigurationsRequest withLaunchConfigurationNames(String... strArr) {
        if (getLaunchConfigurationNames() == null) {
            setLaunchConfigurationNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getLaunchConfigurationNames().add(add);
        }
        return this;
    }

    public DescribeLaunchConfigurationsRequest withMaxRecords(Integer num) {
        this.maxRecords = num;
        return this;
    }

    public DescribeLaunchConfigurationsRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
