package com.amazonaws.services.ec2.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeLicensesRequest extends AmazonWebServiceRequest {
    private List<Filter> filters;
    private List<String> licenseIds;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLicensesRequest)) {
            return false;
        }
        DescribeLicensesRequest describeLicensesRequest = (DescribeLicensesRequest) obj;
        if (((describeLicensesRequest.getLicenseIds() == null ? 1 : 0) ^ (getLicenseIds() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (describeLicensesRequest.getLicenseIds() != null && !describeLicensesRequest.getLicenseIds().equals(getLicenseIds())) {
            return false;
        }
        return ((describeLicensesRequest.getFilters() == null ? 1 : 0) ^ (getFilters() == null ? 1 : 0)) == 0 ? describeLicensesRequest.getFilters() == null || describeLicensesRequest.getFilters().equals(getFilters()) : false;
    }

    public List<Filter> getFilters() {
        if (this.filters == null) {
            this.filters = new ArrayList();
        }
        return this.filters;
    }

    public List<String> getLicenseIds() {
        if (this.licenseIds == null) {
            this.licenseIds = new ArrayList();
        }
        return this.licenseIds;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getLicenseIds() == null ? 0 : getLicenseIds().hashCode()) + 31) * 31;
        if (getFilters() != null) {
            i = getFilters().hashCode();
        }
        return hashCode + i;
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

    public void setLicenseIds(Collection<String> collection) {
        if (collection == null) {
            this.licenseIds = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.licenseIds = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.licenseIds != null) {
            stringBuilder.append("LicenseIds: " + this.licenseIds + ", ");
        }
        if (this.filters != null) {
            stringBuilder.append("Filters: " + this.filters + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeLicensesRequest withFilters(Collection<Filter> collection) {
        if (collection == null) {
            this.filters = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.filters = arrayList;
        }
        return this;
    }

    public DescribeLicensesRequest withFilters(Filter... filterArr) {
        if (getFilters() == null) {
            setFilters(new ArrayList(filterArr.length));
        }
        for (Object add : filterArr) {
            getFilters().add(add);
        }
        return this;
    }

    public DescribeLicensesRequest withLicenseIds(Collection<String> collection) {
        if (collection == null) {
            this.licenseIds = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.licenseIds = arrayList;
        }
        return this;
    }

    public DescribeLicensesRequest withLicenseIds(String... strArr) {
        if (getLicenseIds() == null) {
            setLicenseIds(new ArrayList(strArr.length));
        }
        for (Object add : strArr) {
            getLicenseIds().add(add);
        }
        return this;
    }
}
