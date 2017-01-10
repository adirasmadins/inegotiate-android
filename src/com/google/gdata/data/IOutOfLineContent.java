package com.google.gdata.data;

import com.google.gdata.util.ContentType;

public interface IOutOfLineContent extends IContent {
    String getEtag();

    ContentType getMimeType();

    String getUri();
}
