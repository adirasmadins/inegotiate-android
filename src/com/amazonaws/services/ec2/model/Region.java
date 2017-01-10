package com.amazonaws.services.ec2.model;

public class Region {
    private String endpoint;
    private String regionName;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Region)) {
            return false;
        }
        Region region = (Region) obj;
        if (((region.getRegionName() == null ? 1 : 0) ^ (getRegionName() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (region.getRegionName() != null && !region.getRegionName().equals(getRegionName())) {
            return false;
        }
        return ((region.getEndpoint() == null ? 1 : 0) ^ (getEndpoint() == null ? 1 : 0)) == 0 ? region.getEndpoint() == null || region.getEndpoint().equals(getEndpoint()) : false;
    }

    public String getEndpoint() {
        return this.endpoint;
    }

    public String getRegionName() {
        return this.regionName;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getRegionName() == null ? 0 : getRegionName().hashCode()) + 31) * 31;
        if (getEndpoint() != null) {
            i = getEndpoint().hashCode();
        }
        return hashCode + i;
    }

    public void setEndpoint(String str) {
        this.endpoint = str;
    }

    public void setRegionName(String str) {
        this.regionName = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.regionName != null) {
            stringBuilder.append("RegionName: " + this.regionName + ", ");
        }
        if (this.endpoint != null) {
            stringBuilder.append("Endpoint: " + this.endpoint + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Region withEndpoint(String str) {
        this.endpoint = str;
        return this;
    }

    public Region withRegionName(String str) {
        this.regionName = str;
        return this;
    }
}
