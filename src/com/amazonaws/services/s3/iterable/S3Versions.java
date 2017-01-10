package com.amazonaws.services.s3.iterable;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3VersionSummary;
import com.amazonaws.services.s3.model.VersionListing;
import java.util.Iterator;

public class S3Versions implements Iterable<S3VersionSummary> {
    private Integer batchSize;
    private String bucketName;
    private String key;
    private String prefix;
    private AmazonS3 s3;

    private class VersionIterator implements Iterator<S3VersionSummary> {
        private Iterator<S3VersionSummary> currentIterator;
        private VersionListing currentListing;
        private S3VersionSummary nextSummary;

        private VersionIterator() {
            this.currentListing = null;
            this.currentIterator = null;
            this.nextSummary = null;
        }

        private S3VersionSummary nextMatchingSummary() {
            return (S3Versions.this.getKey() == null || (this.nextSummary != null && this.nextSummary.getKey().equals(S3Versions.this.getKey()))) ? this.nextSummary : null;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void prepareCurrentListing() {
            /*
            r2 = this;
        L_0x0000:
            r0 = r2.currentListing;
            if (r0 == 0) goto L_0x0014;
        L_0x0004:
            r0 = r2.currentIterator;
            r0 = r0.hasNext();
            if (r0 != 0) goto L_0x0072;
        L_0x000c:
            r0 = r2.currentListing;
            r0 = r0.isTruncated();
            if (r0 == 0) goto L_0x0072;
        L_0x0014:
            r0 = r2.currentListing;
            if (r0 != 0) goto L_0x0063;
        L_0x0018:
            r0 = new com.amazonaws.services.s3.model.ListVersionsRequest;
            r0.<init>();
            r1 = com.amazonaws.services.s3.iterable.S3Versions.this;
            r1 = r1.getBucketName();
            r0.setBucketName(r1);
            r1 = com.amazonaws.services.s3.iterable.S3Versions.this;
            r1 = r1.getKey();
            if (r1 == 0) goto L_0x0059;
        L_0x002e:
            r1 = com.amazonaws.services.s3.iterable.S3Versions.this;
            r1 = r1.getKey();
            r0.setPrefix(r1);
        L_0x0037:
            r1 = com.amazonaws.services.s3.iterable.S3Versions.this;
            r1 = r1.getBatchSize();
            r0.setMaxResults(r1);
            r1 = com.amazonaws.services.s3.iterable.S3Versions.this;
            r1 = r1.getS3();
            r0 = r1.listVersions(r0);
            r2.currentListing = r0;
        L_0x004c:
            r0 = r2.currentListing;
            r0 = r0.getVersionSummaries();
            r0 = r0.iterator();
            r2.currentIterator = r0;
            goto L_0x0000;
        L_0x0059:
            r1 = com.amazonaws.services.s3.iterable.S3Versions.this;
            r1 = r1.getPrefix();
            r0.setPrefix(r1);
            goto L_0x0037;
        L_0x0063:
            r0 = com.amazonaws.services.s3.iterable.S3Versions.this;
            r0 = r0.getS3();
            r1 = r2.currentListing;
            r0 = r0.listNextBatchOfVersions(r1);
            r2.currentListing = r0;
            goto L_0x004c;
        L_0x0072:
            r0 = r2.nextSummary;
            if (r0 != 0) goto L_0x0088;
        L_0x0076:
            r0 = r2.currentIterator;
            r0 = r0.hasNext();
            if (r0 == 0) goto L_0x0088;
        L_0x007e:
            r0 = r2.currentIterator;
            r0 = r0.next();
            r0 = (com.amazonaws.services.s3.model.S3VersionSummary) r0;
            r2.nextSummary = r0;
        L_0x0088:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.s3.iterable.S3Versions.VersionIterator.prepareCurrentListing():void");
        }

        public boolean hasNext() {
            prepareCurrentListing();
            return nextMatchingSummary() != null;
        }

        public S3VersionSummary next() {
            prepareCurrentListing();
            S3VersionSummary nextMatchingSummary = nextMatchingSummary();
            this.nextSummary = null;
            return nextMatchingSummary;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private S3Versions(AmazonS3 amazonS3, String str) {
        this.s3 = amazonS3;
        this.bucketName = str;
    }

    public static S3Versions forKey(AmazonS3 amazonS3, String str, String str2) {
        S3Versions s3Versions = new S3Versions(amazonS3, str);
        s3Versions.key = str2;
        return s3Versions;
    }

    public static S3Versions inBucket(AmazonS3 amazonS3, String str) {
        return new S3Versions(amazonS3, str);
    }

    public static S3Versions withPrefix(AmazonS3 amazonS3, String str, String str2) {
        S3Versions s3Versions = new S3Versions(amazonS3, str);
        s3Versions.prefix = str2;
        return s3Versions;
    }

    public Integer getBatchSize() {
        return this.batchSize;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public String getKey() {
        return this.key;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public AmazonS3 getS3() {
        return this.s3;
    }

    public Iterator<S3VersionSummary> iterator() {
        return new VersionIterator();
    }

    public S3Versions withBatchSize(int i) {
        this.batchSize = Integer.valueOf(i);
        return this;
    }
}
