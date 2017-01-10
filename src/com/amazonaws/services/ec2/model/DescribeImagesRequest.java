package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeImagesRequest extends AmazonWebServiceRequest {
    private List<String> executableUsers;
    private List<Filter> filters;
    private List<String> imageIds;
    private List<String> owners;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeImagesRequest)) {
            return false;
        }
        DescribeImagesRequest describeImagesRequest = (DescribeImagesRequest) obj;
        if (((describeImagesRequest.getImageIds() == null ? 1 : 0) ^ (getImageIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeImagesRequest.getImageIds() != null && !describeImagesRequest.getImageIds().equals(getImageIds())) {
            return false;
        }
        if (((describeImagesRequest.getOwners() == null ? 1 : 0) ^ (getOwners() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeImagesRequest.getOwners() != null && !describeImagesRequest.getOwners().equals(getOwners())) {
            return false;
        }
        if (((describeImagesRequest.getExecutableUsers() == null ? 1 : 0) ^ (getExecutableUsers() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeImagesRequest.getExecutableUsers() != null && !describeImagesRequest.getExecutableUsers().equals(getExecutableUsers())) {
            return false;
        }
        return ((describeImagesRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeImagesRequest.getFilters() == null || describeImagesRequest.getFilters().equals(getFilters()) : false;
    }

    public List<String> getExecutableUsers() {
        if (this.executableUsers == null) {
            this.executableUsers = new ArrayList();
        }
        return this.executableUsers;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getImageIds() {
        if (this.imageIds == null) {
            this.imageIds = new ArrayList();
        }
        return this.imageIds;
    }

    public List<String> getOwners() {
        if (this.owners == null) {
            this.owners = new ArrayList();
        }
        return this.owners;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getExecutableUsers() == null ? 0 : getExecutableUsers().hashCode()) + (((getOwners() == null ? 0 : getOwners().hashCode()) + (((getImageIds() == null ? 0 : getImageIds().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getFilters() != null) {
            i = getFilters().hashCode();
        }
        return hashCode + i;
    }

    public void setExecutableUsers(Collection<String> collection) {
        if (collection == null) {
            this.executableUsers = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.executableUsers = arrayList;
    }

    public void setFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.filters = arrayList;
    }

    public void setImageIds(Collection<String> collection) {
        if (collection == null) {
            this.imageIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.imageIds = arrayList;
    }

    public void setOwners(Collection<String> collection) {
        if (collection == null) {
            this.owners = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.owners = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.imageIds != null) {
            stringBuilder.append("ImageIds: " + this.imageIds + ", ");
        }
        if (this.owners != null) {
            stringBuilder.append("Owners: " + this.owners + ", ");
        }
        if (this.executableUsers != null) {
            stringBuilder.append("ExecutableUsers: " + this.executableUsers + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeImagesRequest withExecutableUsers(Collection<String> collection) {
        if (collection == null) {
            this.executableUsers = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.executableUsers = arrayList;
        }
        return this;
    }

    public DescribeImagesRequest withExecutableUsers(String... strArr) {
        if (getExecutableUsers() == null) {
            setExecutableUsers(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getExecutableUsers().add(add);
        }
        return this;
    }

    public DescribeImagesRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeImagesRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeImagesRequest withImageIds(Collection<String> collection) {
        if (collection == null) {
            this.imageIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.imageIds = arrayList;
        }
        return this;
    }

    public DescribeImagesRequest withImageIds(String... strArr) {
        if (getImageIds() == null) {
            setImageIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getImageIds().add(add);
        }
        return this;
    }

    public DescribeImagesRequest withOwners(Collection<String> collection) {
        if (collection == null) {
            this.owners = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.owners = arrayList;
        }
        return this;
    }

    public DescribeImagesRequest withOwners(String... strArr) {
        if (getOwners() == null) {
            setOwners(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getOwners().add(add);
        }
        return this;
    }
}
