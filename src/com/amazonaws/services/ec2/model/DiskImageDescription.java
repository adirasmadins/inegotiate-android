package com.amazonaws.services.ec2.model;

public class DiskImageDescription {
    private String checksum;
    private String format;
    private String importManifestUrl;
    private Long size;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DiskImageDescription)) {
            return false;
        }
        DiskImageDescription diskImageDescription = (DiskImageDescription) obj;
        if (((diskImageDescription.getFormat() == null ? 1 : 0) ^ (getFormat() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (diskImageDescription.getFormat() != null && !diskImageDescription.getFormat().equals(getFormat())) {
            return false;
        }
        if (((diskImageDescription.getSize() == null ? 1 : 0) ^ (getSize() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (diskImageDescription.getSize() != null && !diskImageDescription.getSize().equals(getSize())) {
            return false;
        }
        if (((diskImageDescription.getImportManifestUrl() == null ? 1 : 0) ^ (getImportManifestUrl() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (diskImageDescription.getImportManifestUrl() != null && !diskImageDescription.getImportManifestUrl().equals(getImportManifestUrl())) {
            return false;
        }
        return ((diskImageDescription.getChecksum() == null ? 1 : 0) ^ (getChecksum() == null ? 1 : 0)) == 0 ? diskImageDescription.getChecksum() == null || diskImageDescription.getChecksum().equals(getChecksum()) : false;
    }

    public String getChecksum() {
        return this.checksum;
    }

    public String getFormat() {
        return this.format;
    }

    public String getImportManifestUrl() {
        return this.importManifestUrl;
    }

    public Long getSize() {
        return this.size;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getImportManifestUrl() == null ? 0 : getImportManifestUrl().hashCode()) + (((getSize() == null ? 0 : getSize().hashCode()) + (((getFormat() == null ? 0 : getFormat().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getChecksum() != null) {
            i = getChecksum().hashCode();
        }
        return hashCode + i;
    }

    public void setChecksum(String str) {
        this.checksum = str;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setImportManifestUrl(String str) {
        this.importManifestUrl = str;
    }

    public void setSize(Long l) {
        this.size = l;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.format != null) {
            stringBuilder.append("Format: " + this.format + ", ");
        }
        if (this.size != null) {
            stringBuilder.append("Size: " + this.size + ", ");
        }
        if (this.importManifestUrl != null) {
            stringBuilder.append("ImportManifestUrl: " + this.importManifestUrl + ", ");
        }
        if (this.checksum != null) {
            stringBuilder.append("Checksum: " + this.checksum + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public DiskImageDescription withChecksum(String str) {
        this.checksum = str;
        return this;
    }

    public DiskImageDescription withFormat(String str) {
        this.format = str;
        return this;
    }

    public DiskImageDescription withImportManifestUrl(String str) {
        this.importManifestUrl = str;
        return this;
    }

    public DiskImageDescription withSize(Long l) {
        this.size = l;
        return this;
    }
}
