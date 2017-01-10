package com.google.api.client.googleapis.auth;

import com.google.api.client.http.HttpParser;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.util.Map;

public final class AuthKeyValueParser implements HttpParser {
    public static final AuthKeyValueParser INSTANCE;

    static {
        INSTANCE = new AuthKeyValueParser();
    }

    public String getContentType() {
        return "text/plain";
    }

    public <T> T parse(HttpResponse response, Class<T> dataClass) throws IOException {
        T newInstance = ClassInfo.newInstance(dataClass);
        ClassInfo classInfo = ClassInfo.of(dataClass);
        response.disableContentLogging = true;
        InputStream content = response.getContent();
        BufferedReader reader = new BufferedReader(new InputStreamReader(content));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            try {
                int equals = line.indexOf(61);
                String key = line.substring(0, equals);
                String value = line.substring(equals + 1);
                Field field = classInfo.getField(key);
                if (field != null) {
                    Object valueOf;
                    Class<?> fieldClass = field.getType();
                    if (fieldClass == Boolean.TYPE || fieldClass == Boolean.class) {
                        valueOf = Boolean.valueOf(value);
                    } else {
                        String fieldValue = value;
                    }
                    FieldInfo.setFieldValue(field, newInstance, valueOf);
                } else if (GenericData.class.isAssignableFrom(dataClass)) {
                    ((GenericData) newInstance).set(key, value);
                } else if (Map.class.isAssignableFrom(dataClass)) {
                    ((Map) newInstance).put(key, value);
                }
            } finally {
                content.close();
            }
        }
        return newInstance;
    }

    private AuthKeyValueParser() {
    }
}
