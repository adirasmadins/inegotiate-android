package com.google.gdata.util.httputil;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Deprecated
public final class ParamMap {
    private final Map<String, List<String>> map;

    public ParamMap() {
        this.map = Maps.newHashMap();
    }

    @Deprecated
    public String[] get(String name) {
        List<String> l = (List) this.map.get(name);
        return l == null ? null : (String[]) l.toArray(new String[l.size()]);
    }

    public boolean containsKey(String name) {
        return this.map.containsKey(name);
    }

    @Deprecated
    public void append(String name, String value) {
        List<String> l = (List) this.map.get(name);
        if (l != null) {
            l.add(value);
            return;
        }
        this.map.put(name, Lists.newArrayList(value));
    }

    @Deprecated
    public void put(String name, String[] values) {
        this.map.put(name, Lists.newArrayList((Object[]) values));
    }

    @Deprecated
    public Map<String, String[]> toMap() {
        Map<String, String[]> newMap = Maps.newHashMap();
        for (Entry<String, List<String>> entry : this.map.entrySet()) {
            List<String> l = (List) entry.getValue();
            newMap.put(entry.getKey(), l.toArray(new String[l.size()]));
        }
        return newMap;
    }
}
