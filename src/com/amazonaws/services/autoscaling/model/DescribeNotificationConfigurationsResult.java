package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeNotificationConfigurationsResult {
    private String nextToken;
    private List<NotificationConfiguration> notificationConfigurations;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeNotificationConfigurationsResult)) {
            return false;
        }
        DescribeNotificationConfigurationsResult describeNotificationConfigurationsResult = (DescribeNotificationConfigurationsResult) obj;
        if (((describeNotificationConfigurationsResult.getNotificationConfigurations() == null ? 1 : 0) ^ (getNotificationConfigurations() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeNotificationConfigurationsResult.getNotificationConfigurations() != null && !describeNotificationConfigurationsResult.getNotificationConfigurations().equals(getNotificationConfigurations())) {
            return false;
        }
        return ((describeNotificationConfigurationsResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeNotificationConfigurationsResult.getNextToken() == null || describeNotificationConfigurationsResult.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<NotificationConfiguration> getNotificationConfigurations() {
        if (this.notificationConfigurations == null) {
            this.notificationConfigurations = new ArrayList();
        }
        return this.notificationConfigurations;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getNotificationConfigurations() == null ? 0 : getNotificationConfigurations().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setNotificationConfigurations(Collection<NotificationConfiguration> collection) {
        if (collection == null) {
            this.notificationConfigurations = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.notificationConfigurations = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.notificationConfigurations != null) {
            stringBuilder.append("NotificationConfigurations: " + this.notificationConfigurations + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeNotificationConfigurationsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribeNotificationConfigurationsResult withNotificationConfigurations(Collection<NotificationConfiguration> collection) {
        if (collection == null) {
            this.notificationConfigurations = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.notificationConfigurations = arrayList;
        }
        return this;
    }

    public DescribeNotificationConfigurationsResult withNotificationConfigurations(NotificationConfiguration... notificationConfigurationArr) {
        if (getNotificationConfigurations() == null) {
            setNotificationConfigurations(new ArrayList(notificationConfigurationArr.length));
        }
        for (Object add : notificationConfigurationArr) {
            getNotificationConfigurations().add(add);
        }
        return this;
    }
}
