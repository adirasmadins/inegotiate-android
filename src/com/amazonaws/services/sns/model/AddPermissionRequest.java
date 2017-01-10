package com.amazonaws.services.sns.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AddPermissionRequest extends AmazonWebServiceRequest {
    private List<String> aWSAccountIds;
    private List<String> actionNames;
    private String label;
    private String topicArn;

    public AddPermissionRequest(String str, String str2, List<String> list, List<String> list2) {
        this.topicArn = str;
        this.label = str2;
        this.aWSAccountIds = list;
        this.actionNames = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AddPermissionRequest)) {
            return false;
        }
        AddPermissionRequest addPermissionRequest = (AddPermissionRequest) obj;
        if (((addPermissionRequest.getTopicArn() == null ? 1 : 0) ^ (getTopicArn() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (addPermissionRequest.getTopicArn() != null && !addPermissionRequest.getTopicArn().equals(getTopicArn())) {
            return false;
        }
        if (((addPermissionRequest.getLabel() == null ? 1 : 0) ^ (getLabel() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (addPermissionRequest.getLabel() != null && !addPermissionRequest.getLabel().equals(getLabel())) {
            return false;
        }
        if (((addPermissionRequest.getAWSAccountIds() == null ? 1 : 0) ^ (getAWSAccountIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (addPermissionRequest.getAWSAccountIds() != null && !addPermissionRequest.getAWSAccountIds().equals(getAWSAccountIds())) {
            return false;
        }
        return ((addPermissionRequest.getActionNames() == null ? 1 : 0) ^ (getActionNames() == null ? 1 : 0)) == 0 ? addPermissionRequest.getActionNames() == null || addPermissionRequest.getActionNames().equals(getActionNames()) : false;
    }

    public List<String> getAWSAccountIds() {
        if (this.aWSAccountIds == null) {
            this.aWSAccountIds = new ArrayList();
        }
        return this.aWSAccountIds;
    }

    public List<String> getActionNames() {
        if (this.actionNames == null) {
            this.actionNames = new ArrayList();
        }
        return this.actionNames;
    }

    public String getLabel() {
        return this.label;
    }

    public String getTopicArn() {
        return this.topicArn;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getAWSAccountIds() == null ? 0 : getAWSAccountIds().hashCode()) + (((getLabel() == null ? 0 : getLabel().hashCode()) + (((getTopicArn() == null ? 0 : getTopicArn().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getActionNames() != null) {
            i = getActionNames().hashCode();
        }
        return hashCode + i;
    }

    public void setAWSAccountIds(Collection<String> collection) {
        if (collection == null) {
            this.aWSAccountIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.aWSAccountIds = arrayList;
    }

    public void setActionNames(Collection<String> collection) {
        if (collection == null) {
            this.actionNames = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.actionNames = arrayList;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setTopicArn(String str) {
        this.topicArn = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.topicArn != null) {
            stringBuilder.append("TopicArn: " + this.topicArn + ", ");
        }
        if (this.label != null) {
            stringBuilder.append("Label: " + this.label + ", ");
        }
        if (this.aWSAccountIds != null) {
            stringBuilder.append("AWSAccountIds: " + this.aWSAccountIds + ", ");
        }
        if (this.actionNames != null) {
            stringBuilder.append("ActionNames: " + this.actionNames + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public AddPermissionRequest withAWSAccountIds(Collection<String> collection) {
        if (collection == null) {
            this.aWSAccountIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.aWSAccountIds = arrayList;
        }
        return this;
    }

    public AddPermissionRequest withAWSAccountIds(String... strArr) {
        if (getAWSAccountIds() == null) {
            setAWSAccountIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getAWSAccountIds().add(add);
        }
        return this;
    }

    public AddPermissionRequest withActionNames(Collection<String> collection) {
        if (collection == null) {
            this.actionNames = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.actionNames = arrayList;
        }
        return this;
    }

    public AddPermissionRequest withActionNames(String... strArr) {
        if (getActionNames() == null) {
            setActionNames(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getActionNames().add(add);
        }
        return this;
    }

    public AddPermissionRequest withLabel(String str) {
        this.label = str;
        return this;
    }

    public AddPermissionRequest withTopicArn(String str) {
        this.topicArn = str;
        return this;
    }
}
