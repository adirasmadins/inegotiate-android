package com.amazonaws.services.autoscaling.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CreateOrUpdateTagsRequest extends AmazonWebServiceRequest {
    private List<Tag> tags;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateOrUpdateTagsRequest)) {
            return false;
        }
        CreateOrUpdateTagsRequest createOrUpdateTagsRequest = (CreateOrUpdateTagsRequest) obj;
        return ((createOrUpdateTagsRequest.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) == 0 ? createOrUpdateTagsRequest.getTags() == null || createOrUpdateTagsRequest.getTags().equals(getTags()) : false;
    }

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public int hashCode() {
        return (getTags() == null ? 0 : getTags().hashCode()) + 31;
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
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public CreateOrUpdateTagsRequest withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public CreateOrUpdateTagsRequest withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }
}
