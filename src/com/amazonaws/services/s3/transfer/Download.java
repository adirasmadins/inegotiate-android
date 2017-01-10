package com.amazonaws.services.s3.transfer;

import com.amazonaws.services.s3.model.ObjectMetadata;
import java.io.IOException;

public interface Download extends Transfer {
    void abort() throws IOException;

    String getBucketName();

    String getKey();

    ObjectMetadata getObjectMetadata();
}
