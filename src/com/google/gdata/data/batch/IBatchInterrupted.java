package com.google.gdata.data.batch;

import com.google.gdata.util.ContentType;

public interface IBatchInterrupted {
    String getContent();

    ContentType getContentType();

    int getErrorCount();

    String getReason();

    int getSkippedCount();

    int getSuccessCount();

    int getTotalCount();
}
