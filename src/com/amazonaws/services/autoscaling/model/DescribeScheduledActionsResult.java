package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeScheduledActionsResult {
    private String nextToken;
    private List<ScheduledUpdateGroupAction> scheduledUpdateGroupActions;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeScheduledActionsResult)) {
            return false;
        }
        DescribeScheduledActionsResult describeScheduledActionsResult = (DescribeScheduledActionsResult) obj;
        if (((describeScheduledActionsResult.getScheduledUpdateGroupActions() == null ? 1 : 0) ^ (getScheduledUpdateGroupActions() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeScheduledActionsResult.getScheduledUpdateGroupActions() != null && !describeScheduledActionsResult.getScheduledUpdateGroupActions().equals(getScheduledUpdateGroupActions())) {
            return false;
        }
        return ((describeScheduledActionsResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeScheduledActionsResult.getNextToken() == null || describeScheduledActionsResult.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<ScheduledUpdateGroupAction> getScheduledUpdateGroupActions() {
        if (this.scheduledUpdateGroupActions == null) {
            this.scheduledUpdateGroupActions = new ArrayList();
        }
        return this.scheduledUpdateGroupActions;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getScheduledUpdateGroupActions() == null ? 0 : getScheduledUpdateGroupActions().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setScheduledUpdateGroupActions(Collection<ScheduledUpdateGroupAction> collection) {
        if (collection == null) {
            this.scheduledUpdateGroupActions = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.scheduledUpdateGroupActions = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.scheduledUpdateGroupActions != null) {
            stringBuilder.append("ScheduledUpdateGroupActions: " + this.scheduledUpdateGroupActions + ", ");
        }
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeScheduledActionsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public DescribeScheduledActionsResult withScheduledUpdateGroupActions(Collection<ScheduledUpdateGroupAction> collection) {
        if (collection == null) {
            this.scheduledUpdateGroupActions = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.scheduledUpdateGroupActions = arrayList;
        }
        return this;
    }

    public DescribeScheduledActionsResult withScheduledUpdateGroupActions(ScheduledUpdateGroupAction... scheduledUpdateGroupActionArr) {
        if (getScheduledUpdateGroupActions() == null) {
            setScheduledUpdateGroupActions(new ArrayList(scheduledUpdateGroupActionArr.length));
        }
        for (Object add : scheduledUpdateGroupActionArr) {
            getScheduledUpdateGroupActions().add(add);
        }
        return this;
    }
}
