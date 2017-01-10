package com.google.gdata.client.uploader;

public interface ProgressListener {
    void progressChanged(ResumableHttpFileUploader resumableHttpFileUploader);
}
