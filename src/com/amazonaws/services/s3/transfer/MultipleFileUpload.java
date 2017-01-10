package com.amazonaws.services.s3.transfer;

public interface MultipleFileUpload extends Transfer {
    String getBucketName();

    String getKeyPrefix();
}
