package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import java.util.concurrent.Callable;

public class UploadPartCallable implements Callable<PartETag> {
    private final UploadPartRequest request;
    private final AmazonS3 s3;

    public UploadPartCallable(AmazonS3 amazonS3, UploadPartRequest uploadPartRequest) {
        this.s3 = amazonS3;
        this.request = uploadPartRequest;
    }

    public PartETag call() throws Exception {
        return this.s3.uploadPart(this.request).getPartETag();
    }
}
