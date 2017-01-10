package com.amazonaws.services.ec2.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class License {
    private List<LicenseCapacity> capacities;
    private String licenseId;
    private String pool;
    private List<Tag> tags;
    private String type;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof License)) {
            return false;
        }
        License license = (License) obj;
        if (((license.getLicenseId() == null ? 1 : 0) ^ (getLicenseId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (license.getLicenseId() != null && !license.getLicenseId().equals(getLicenseId())) {
            return false;
        }
        if (((license.getType() == null ? 1 : 0) ^ (getType() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (license.getType() != null && !license.getType().equals(getType())) {
            return false;
        }
        if (((license.getPool() == null ? 1 : 0) ^ (getPool() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (license.getPool() != null && !license.getPool().equals(getPool())) {
            return false;
        }
        if (((license.getCapacities() == null ? 1 : 0) ^ (getCapacities() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (license.getCapacities() != null && !license.getCapacities().equals(getCapacities())) {
            return false;
        }
        return ((license.getTags() == null ? 1 : 0) ^ (getTags() == null ? 1 : 0)) == 0 ? license.getTags() == null || license.getTags().equals(getTags()) : false;
    }

    public List<LicenseCapacity> getCapacities() {
        if (this.capacities == null) {
            this.capacities = new ArrayList();
        }
        return this.capacities;
    }

    public String getLicenseId() {
        return this.licenseId;
    }

    public String getPool() {
        return this.pool;
    }

    public List<Tag> getTags() {
        if (this.tags == null) {
            this.tags = new ArrayList();
        }
        return this.tags;
    }

    public String getType() {
        return this.type;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getCapacities() == null ? 0 : getCapacities().hashCode()) + (((getPool() == null ? 0 : getPool().hashCode()) + (((getType() == null ? 0 : getType().hashCode()) + (((getLicenseId() == null ? 0 : getLicenseId().hashCode()) + 31) * 31)) * 31)) * 31)) * 31;
        if (getTags() != null) {
            i = getTags().hashCode();
        }
        return hashCode + i;
    }

    public void setCapacities(Collection<LicenseCapacity> collection) {
        if (collection == null) {
            this.capacities = null;
            return;
        }
        List arrayList = new ArrayList(collection.size());
        arrayList.addAll(collection);
        this.capacities = arrayList;
    }

    public void setLicenseId(String str) {
        this.licenseId = str;
    }

    public void setPool(String str) {
        this.pool = str;
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

    public void setType(String str) {
        this.type = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.licenseId != null) {
            stringBuilder.append("LicenseId: " + this.licenseId + ", ");
        }
        if (this.type != null) {
            stringBuilder.append("Type: " + this.type + ", ");
        }
        if (this.pool != null) {
            stringBuilder.append("Pool: " + this.pool + ", ");
        }
        if (this.capacities != null) {
            stringBuilder.append("Capacities: " + this.capacities + ", ");
        }
        if (this.tags != null) {
            stringBuilder.append("Tags: " + this.tags + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public License withCapacities(Collection<LicenseCapacity> collection) {
        if (collection == null) {
            this.capacities = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.capacities = arrayList;
        }
        return this;
    }

    public License withCapacities(LicenseCapacity... licenseCapacityArr) {
        if (getCapacities() == null) {
            setCapacities(new ArrayList(licenseCapacityArr.length));
        }
        for (Object add : licenseCapacityArr) {
            getCapacities().add(add);
        }
        return this;
    }

    public License withLicenseId(String str) {
        this.licenseId = str;
        return this;
    }

    public License withPool(String str) {
        this.pool = str;
        return this;
    }

    public License withTags(Collection<Tag> collection) {
        if (collection == null) {
            this.tags = null;
        } else {
            List arrayList = new ArrayList(collection.size());
            arrayList.addAll(collection);
            this.tags = arrayList;
        }
        return this;
    }

    public License withTags(Tag... tagArr) {
        if (getTags() == null) {
            setTags(new ArrayList(tagArr.length));
        }
        for (Object add : tagArr) {
            getTags().add(add);
        }
        return this;
    }

    public License withType(String str) {
        this.type = str;
        return this;
    }
}
