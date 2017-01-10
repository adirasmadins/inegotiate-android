package com.amazonaws.services.s3.transfer;

import java.io.IOException;

public interface MultipleFileDownload extends Transfer {
    void abort() throws IOException;

    String getBucketName();

    String getKeyPrefix();
}
