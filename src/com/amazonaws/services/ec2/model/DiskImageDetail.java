package com.amazonaws.services.ec2.model;

public class DiskImageDetail {
    private Long bytes;
    private String format;
    private String importManifestUrl;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DiskImageDetail)) {
            return false;
        }
        DiskImageDetail diskImageDetail = (DiskImageDetail) obj;
        if (((diskImageDetail.getFormat() == null ? 1 : 0) ^ (getFormat() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (diskImageDetail.getFormat() != null && !diskImageDetail.getFormat().equals(getFormat())) {
            return false;
        }
        if (((diskImageDetail.getBytes() == null ? 1 : 0) ^ (getBytes() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (diskImageDetail.getBytes() != null && !diskImageDetail.getBytes().equals(getBytes())) {
            return false;
        }
        return ((diskImageDetail.getImportManifestUrl() == null ? 1 : 0) ^ (getImportManifestUrl() == null ? 1 : 0)) == 0 ? diskImageDetail.getImportManifestUrl() == null || diskImageDetail.getImportManifestUrl().equals(getImportManifestUrl()) : false;
    }

    public Long getBytes() {
        return this.bytes;
    }

    public String getFormat() {
        return this.format;
    }

    public String getImportManifestUrl() {
        return this.importManifestUrl;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getBytes() == null ? 0 : getBytes().hashCode()) + (((getFormat() == null ? 0 : getFormat().hashCode()) + 31) * 31)) * 31;
        if (getImportManifestUrl() != null) {
            i = getImportManifestUrl().hashCode();
        }
        return hashCode + i;
    }

    public void setBytes(Long l) {
        this.bytes = l;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setImportManifestUrl(String str) {
        this.importManifestUrl = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.format != null) {
            stringBuilder.append("Format: " + this.format + ", ");
        }
        if (this.bytes != null) {
            stringBuilder.append("Bytes: " + this.bytes + ", ");
        }
        if (this.importManifestUrl != null) {
            stringBuilder.append("ImportManifestUrl: " + this.importManifestUrl + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DiskImageDetail withBytes(Long l) {
        this.bytes = l;
        return this;
    }

    public DiskImageDetail withFormat(String str) {
        this.format = str;
        return this;
    }

    public DiskImageDetail withImportManifestUrl(String str) {
        this.importManifestUrl = str;
        return this;
    }
}
