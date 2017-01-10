package com.amazonaws.services.ec2.model;

public class Storage {
    private S3Storage s3;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Storage)) {
            return false;
        }
        Storage storage = (Storage) obj;
        return ((storage.getS3() == null ? 1 : 0) ^ (getS3() == null ? 1 : 0)) == 0 ? storage.getS3() == null || storage.getS3().equals(getS3()) : false;
    }

    public S3Storage getS3() {
        return this.s3;
    }

    public int hashCode() {
        return (getS3() == null ? 0 : getS3().hashCode()) + 31;
    }

    public void setS3(S3Storage s3Storage) {
        this.s3 = s3Storage;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.s3 != null) {
            stringBuilder.append("S3: " + this.s3 + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Storage withS3(S3Storage s3Storage) {
        this.s3 = s3Storage;
        return this;
    }
}
