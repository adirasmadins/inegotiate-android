package com.amazonaws.util;

import com.amazonaws.ResponseMetadata;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseMetadataCache {
    private Map<Integer, ResponseMetadata> map;
    private final int maxEntries;
    private List<Object> objectList;

    public ResponseMetadataCache(int i) {
        this.maxEntries = i;
        this.objectList = new ArrayList(i);
        this.map = new HashMap();
    }

    private void evictOldest() {
        this.map.remove(this.objectList.remove(0));
    }

    private void store(int i, ResponseMetadata responseMetadata) {
        this.map.put(Integer.valueOf(i), responseMetadata);
        this.objectList.add(Integer.valueOf(i));
    }

    public synchronized void add(Object obj, ResponseMetadata responseMetadata) {
        if (obj != null) {
            if (this.map.size() >= this.maxEntries) {
                evictOldest();
            }
            store(System.identityHashCode(obj), responseMetadata);
        }
    }

    public ResponseMetadata get(Object obj) {
        return (ResponseMetadata) this.map.get(Integer.valueOf(System.identityHashCode(obj)));
    }
}
