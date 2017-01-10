package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DeleteTagsRequest extends AmazonWebServiceRequest {
    private List<String> resources;
    private List<Tag> tags;

    public DeleteTagsRequest(List<String> list) {
        this.resources = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteTagsRequest)) {
            return false;
        }
        DeleteTagsRequest deleteTagsRequest = (DeleteTagsRequest) obj;
        if (((deleteTagsRequest.getResources() == null ? 1 : 0) ^ (getResources() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (deleteTagsRequest.getResources() != null && !deleteTagsRequest.getResources().equals(getResources())) {
            return false;
        }
        return ((deleteTagsRequest.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) == 0 ? deleteTagsRequest.getTags() == null || deleteTagsRequest.getTags().equals(getTags()) : false;
    }

    public List<String> getResources() {
        if (this.resources == null) {
            this.resources = new ArrayList();
        }
        return this.resources;
    }

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getResources() == null ? 0 : getResources().hashCode()) + 31) * 31;
        if (getTags() != null) {
            i = getTags().hashCode();
        }
        return hashCode + i;
    }

    public void setResources(Collection<String> collection) {
        if (collection == null) {
            this.resources = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.resources = arrayList;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.resources != null) {
            stringBuilder.append("Resources: " + this.resources + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DeleteTagsRequest withResources(Collection<String> collection) {
        if (collection == null) {
            this.resources = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.resources = arrayList;
        }
        return this;
    }

    public DeleteTagsRequest withResources(String... strArr) {
        if (getResources() == null) {
            setResources(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getResources().add(add);
        }
        return this;
    }

    public DeleteTagsRequest withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public DeleteTagsRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }
}
