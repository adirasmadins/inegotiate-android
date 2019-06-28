package com.google.api.client.json;

import java.lang.reflect.Field;
import java.util.Collection;

public class CustomizeJsonParser {
    public boolean stopAt(Object context, String key) {
        return false;
    }

    public void handleUnrecognizedKey(Object context, String key) {
    }

    public Collection<Object> newInstanceForArray(Object context, Field field) {
        return null;
    }

    public Object newInstanceForObject(Object context, Class<?> cls) {
        return null;
    }
}
