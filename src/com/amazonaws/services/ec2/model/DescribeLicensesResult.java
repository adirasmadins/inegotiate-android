package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DescribeLicensesResult {
    private List<License> licenses;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeLicensesResult)) {
            return false;
        }
        DescribeLicensesResult describeLicensesResult = (DescribeLicensesResult) obj;
        return ((describeLicensesResult.getLicenses() == null ? 1 : 0) ^ (getLicenses() == null ? 1 : 0)) == 0 ? describeLicensesResult.getLicenses() == null || describeLicensesResult.getLicenses().equals(getLicenses()) : false;
    }

    public List<License> getLicenses() {
        if (this.licenses == null) {
            this.licenses = new ArrayList();
        }
        return this.licenses;
    }

    public int hashCode() {
        return (getLicenses() == null ? 0 : getLicenses().hashCode()) + 31;
    }

    public void setLicenses(Collection<License> collection) {
        if (collection == null) {
            this.licenses = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.licenses = arrayList;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.licenses != null) {
            stringBuilder.append("Licenses: " + this.licenses + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DescribeLicensesResult withLicenses(Collection<License> collection) {
        if (collection == null) {
            this.licenses = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.licenses = arrayList;
        }
        return this;
    }

    public DescribeLicensesResult withLicenses(License... licenseArr) {
        if (getLicenses() == null) {
            setLicenses(new ArrayList(licenseArr.length));
        }
        for (Object add : licenseArr) {
            getLicenses().add(add);
        }
        return this;
    }
}
