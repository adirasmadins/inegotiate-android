package com.amazonaws.services.autoscaling.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeTagsResult {
    private String nextToken;
    private List<TagDescription> tags;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeTagsResult)) {
            return false;
        }
        DescribeTagsResult describeTagsResult = (DescribeTagsResult) obj;
        if (((describeTagsResult.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeTagsResult.getTags() != null && !describeTagsResult.getTags().equals(getTags())) {
            return false;
        }
        return ((describeTagsResult.getNextToken() == null ? 1 : 0) ^ (getNextToken() == null ? 1 : 0)) == 0 ? describeTagsResult.getNextToken() == null || describeTagsResult.getNextToken().equals(getNextToken()) : false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<TagDescription> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getTags() == null ? 0 : getTags().hashCode()) + 31) * 31;
        if (getNextToken() != null) {
            i = getNextToken().hashCode();
        }
        return hashCode + i;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
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
        if (this.nextToken != null) {
            stringBuilder.append("NextToken: " + this.nextToken + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeTagsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
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
