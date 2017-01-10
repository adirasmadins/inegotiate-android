package com.amazonaws.services.s3.internal;

public class Constants {
    public static String DEFAULT_ENCODING = null;
    public static final int DEFAULT_STREAM_BUFFER_SIZE = 131072;
    public static final int FAILED_PRECONDITION_STATUS_CODE = 412;
    public static final long GB = 1073741824;
    public static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
    public static final int KB = 1024;
    public static final int MAXIMUM_UPLOAD_PARTS = 10000;
    public static final int MB = 1048576;
    public static final String NULL_VERSION_ID = "null";
    public static String S3_HOSTNAME = null;
    public static String S3_SERVICE_NAME = null;
    public static final String XML_NAMESPACE = "http://s3.amazonaws.com/doc/2006-03-01/";

    static {
        S3_HOSTNAME = "s3.amazonaws.com";
        S3_SERVICE_NAME = "Amazon S3";
        DEFAULT_ENCODING = StringEncodings.UTF8;
    }
}
