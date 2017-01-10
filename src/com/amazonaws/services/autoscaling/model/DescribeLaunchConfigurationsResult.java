package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeLaunchConfigurationsResult {
    private List<LaunchConfiguration> launchConfigurations;
    private String nextToken;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLaunchConfigurationsResult)) {
            return false;
        }
        DescribeLaunchConfigurationsResult describeLaunchConfigurationsResult = (DescribeLaunchConfigurationsResult) obj;
        if (((describeLaunchConfigurationsResult.getLaunchConfigurations() == null ? 1 : 0) ^ (getLaunchConfigurations() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeLaunchConfigurationsResult.getLaunchConfigurations() != null && !describeLaunchConfigurationsResult.getLaunchConfigurations().equals(getLaunchConfigurations())) {
            return false;
        }
        return ((describeLaunchConfigurationsResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeLaunchConfigurationsResult.getNextToken() == null || describeLaunchConfigurationsResult.getNextToken().equals(getNextToken()) : false;
    }

    public List<LaunchConfiguration> getLaunchConfigurations() {
        if (this.launchConfigurations == null) {
            this.launchConfigurations = new ArrayList();
        }
        return this.launchConfigurations;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLaunchConfigurations() == null ? 0 : getLaunchConfigurations().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setLaunchConfigurations(Collection<LaunchConfiguration> collection) {
        if (collection == null) {
            this.launchConfigurations = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.launchConfigurations = arrayList;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.launchConfigurations != null) {
            stringBuilder.append("LaunchConfigurations: " + this.launchConfigurations + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeLaunchConfigurationsResult withLaunchConfigurations(Collection<LaunchConfiguration> collection) {
        if (collection == null) {
            this.launchConfigurations = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.launchConfigurations = arrayList;
        }
        return this;
    }

    public DescribeLaunchConfigurationsResult withLaunchConfigurations(LaunchConfiguration... launchConfigurationArr) {
        if (getLaunchConfigurations() == null) {
            setLaunchConfigurations(new ArrayList(launchConfigurationArr.length));
        }
        for (Object add : launchConfigurationArr) {
            getLaunchConfigurations().add(add);
        }
        return this;
    }

    public DescribeLaunchConfigurationsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }
}
