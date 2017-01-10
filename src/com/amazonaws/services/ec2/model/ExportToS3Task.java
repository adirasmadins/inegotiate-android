package com.amazonaws.services.ec2.model;

public class ExportToS3Task {
    private String containerFormat;
    private String diskImageFormat;
    private String s3Bucket;
    private String s3Key;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ExportToS3Task)) {
            return false;
        }
        ExportToS3Task exportToS3Task = (ExportToS3Task) obj;
        if (((exportToS3Task.getDiskImageFormat() == null ? 1 : 0) ^ (getDiskImageFormat() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportToS3Task.getDiskImageFormat() != null && !exportToS3Task.getDiskImageFormat().equals(getDiskImageFormat())) {
            return false;
        }
        if (((exportToS3Task.getContainerFormat() == null ? 1 : 0) ^ (getContainerFormat() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportToS3Task.getContainerFormat() != null && !exportToS3Task.getContainerFormat().equals(getContainerFormat())) {
            return false;
        }
        if (((exportToS3Task.getS3Bucket() == null ? 1 : 0) ^ (getS3Bucket() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (exportToS3Task.getS3Bucket() != null && !exportToS3Task.getS3Bucket().equals(getS3Bucket())) {
            return false;
        }
        return ((exportToS3Task.getS3Key() == null ? 1 : 0) ^ (getS3Key() == null ? 1 : 0)) == 0 ? exportToS3Task.getS3Key() == null || exportToS3Task.getS3Key().equals(getS3Key()) : false;
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

    public String getS3Key() {
        return this.s3Key;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getS3Bucket() == null ? 0 : getS3Bucket().hashCode()) + (((getContainerFormat() == null ? 0 : getContainerFormat().hashCode()) + (((getDiskImageFormat() == null ? 0 : getDiskImageFormat().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getS3Key() != null) {
            i = getS3Key().hashCode();
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

    public void setS3Key(String str) {
        this.s3Key = str;
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
        if (this.s3Key != null) {
            stringBuilder.append("S3Key: " + this.s3Key + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public ExportToS3Task withContainerFormat(ContainerFormat containerFormat) {
        this.containerFormat = containerFormat.toString();
        return this;
    }

    public ExportToS3Task withContainerFormat(String str) {
        this.containerFormat = str;
        return this;
    }

    public ExportToS3Task withDiskImageFormat(DiskImageFormat diskImageFormat) {
        this.diskImageFormat = diskImageFormat.toString();
        return this;
    }

    public ExportToS3Task withDiskImageFormat(String str) {
        this.diskImageFormat = str;
        return this;
    }

    public ExportToS3Task withS3Bucket(String str) {
        this.s3Bucket = str;
        return this;
    }

    public ExportToS3Task withS3Key(String str) {
        this.s3Key = str;
        return this;
    }
}
