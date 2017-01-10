package com.google.gdata.data.batch;

import com.google.gdata.util.ContentType;

public interface IBatchStatus {
    int getCode();

    String getContent();

    ContentType getContentType();

    String getReason();
}
