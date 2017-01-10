package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeTagsResult {
    private List<TagDescription> tags;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeTagsResult)) {
            return false;
        }
        DescribeTagsResult describeTagsResult = (DescribeTagsResult) obj;
        return ((describeTagsResult.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) == 0 ? describeTagsResult.getTags() == null || describeTagsResult.getTags().equals(getTags()) : false;
    }

    public List<TagDescription> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public int hashCode() {
        return (getTags() == null ? 0 : getTags().hashCode()) + 31;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeTagsResult withTags(Collection<TagDescription> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public DescribeTagsResult withTags(TagDescription... tagDescriptionArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagDescriptionArr.length));
        }
        for (Object add : tagDescriptionArr) {
            getTags().add(add);
        }
        return this;
    }
}
