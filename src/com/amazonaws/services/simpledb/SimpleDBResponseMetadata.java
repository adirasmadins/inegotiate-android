package com.amazonaws.services.simpledb;

import com.amazonaws.ResponseMetadata;
import java.util.Map;

public class SimpleDBResponseMetadata extends ResponseMetadata {
    public static final String BOX_USAGE = "BOX_USAGE";

    public SimpleDBResponseMetadata(ResponseMetadata responseMetadata) {
        super(responseMetadata);
    }

    public SimpleDBResponseMetadata(Map<String, String> map) {
        super((Map) map);
    }

    public float getBoxUsage() {
        String str = (String) this.metadata.get(BOX_USAGE);
        return (str == null || str.trim().length() == 0) ? 0.0f : Float.parseFloat(str);
    }
}
