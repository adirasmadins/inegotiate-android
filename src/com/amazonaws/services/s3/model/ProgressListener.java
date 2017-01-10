package com.amazonaws.services.s3.model;

public interface ProgressListener {
    void progressChanged(ProgressEvent progressEvent);
}
