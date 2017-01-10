package com.amazonaws.services.ec2.model;

public class ExportToS3TaskSpecification {
    private String containerFormat;
    private String diskImageFormat;
    private String s3Bucket;
    private String s3Prefix;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ExportToS3TaskSpecification)) {
            return false;
        }
        ExportToS3TaskSpecification exportToS3TaskSpecification = (ExportToS3TaskSpecification) obj;
        if (((exportToS3TaskSpecification.getDiskImageFormat() == null ? 1 : 0) ^ (getDiskImageFormat() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportToS3TaskSpecification.getDiskImageFormat() != null && !exportToS3TaskSpecification.getDiskImageFormat().equals(getDiskImageFormat())) {
            return false;
        }
        if (((exportToS3TaskSpecification.getContainerFormat() == null ? 1 : 0) ^ (getContainerFormat() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportToS3TaskSpecification.getContainerFormat() != null && !exportToS3TaskSpecification.getContainerFormat().equals(getContainerFormat())) {
            return false;
        }
        if (((exportToS3TaskSpecification.getS3Bucket() == null ? 1 : 0) ^ (getS3Bucket() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportToS3TaskSpecification.getS3Bucket() != null && !exportToS3TaskSpecification.getS3Bucket().equals(getS3Bucket())) {
            return false;
        }
        return ((exportToS3TaskSpecification.getS3Prefix() == null ? 1 : 0) ^ (getS3Prefix() == null ? 1 : 0)) == 0 ? exportToS3TaskSpecification.getS3Prefix() == null || exportToS3TaskSpecification.getS3Prefix().equals(getS3Prefix()) : false;
    }

    public String getContainerFormat() {
        return this.containerFormat;
    }

    public String getDiskImageFormat() {
        return this.diskImageFormat;
    }

    public String getS3Bucket() {
        return this.s3Bucket;
    }

    public String getS3Prefix() {
        return this.s3Prefix;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getS3Bucket() == null ? 0 : getS3Bucket().hashCode()) + (((getContainerFormat() == null ? 0 : getContainerFormat().hashCode()) + (((getDiskImageFormat() == null ? 0 : getDiskImageFormat().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getS3Prefix() != null) {
            i = getS3Prefix().hashCode();
        }
        return hashCode + i;
    }

    public void setContainerFormat(ContainerFormat containerFormat) {
        this.containerFormat = containerFormat.toString();
    }

    public void setContainerFormat(String str) {
        this.containerFormat = str;
    }

    public void setDiskImageFormat(DiskImageFormat diskImageFormat) {
        this.diskImageFormat = diskImageFormat.toString();
    }

    public void setDiskImageFormat(String str) {
        this.diskImageFormat = str;
    }

    public void setS3Bucket(String str) {
        this.s3Bucket = str;
    }

    public void setS3Prefix(String str) {
        this.s3Prefix = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.diskImageFormat != null) {
            stringBuilder.append("DiskImageFormat: " + this.diskImageFormat + ", ");
        }
        if (this.containerFormat != null) {
            stringBuilder.append("ContainerFormat: " + this.containerFormat + ", ");
        }
        if (this.s3Bucket != null) {
            stringBuilder.append("S3Bucket: " + this.s3Bucket + ", ");
        }
        if (this.s3Prefix != null) {
            stringBuilder.append("S3Prefix: " + this.s3Prefix + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ExportToS3TaskSpecification withContainerFormat(ContainerFormat containerFormat) {
        this.containerFormat = containerFormat.toString();
        return this;
    }

    public ExportToS3TaskSpecification withContainerFormat(String str) {
        this.containerFormat = str;
        return this;
    }

    public ExportToS3TaskSpecification withDiskImageFormat(DiskImageFormat diskImageFormat) {
        this.diskImageFormat = diskImageFormat.toString();
        return this;
    }

    public ExportToS3TaskSpecification withDiskImageFormat(String str) {
        this.diskImageFormat = str;
        return this;
    }

    public ExportToS3TaskSpecification withS3Bucket(String str) {
        this.s3Bucket = str;
        return this;
    }

    public ExportToS3TaskSpecification withS3Prefix(String str) {
        this.s3Prefix = str;
        return this;
    }
}
