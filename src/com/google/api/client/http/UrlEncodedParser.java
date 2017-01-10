package com.google.api.client.http;

import com.google.api.client.escape.CharEscapers;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public final class UrlEncodedParser implements HttpParser {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    public String contentType;
    public boolean disableContentLogging;

    public UrlEncodedParser() {
        this.contentType = CONTENT_TYPE;
    }

    public String getContentType() {
        return this.contentType;
    }

    public <T> T parse(HttpResponse response, Class<T> dataClass) throws IOException {
        if (this.disableContentLogging) {
            response.disableContentLogging = true;
        }
        Object newInstance = ClassInfo.newInstance(dataClass);
        parse(response.parseAsString(), newInstance);
        return newInstance;
    }

    public static void parse(String content, Object data) {
        Class<?> clazz = data.getClass();
        ClassInfo classInfo = ClassInfo.of(clazz);
        GenericData genericData = GenericData.class.isAssignableFrom(clazz) ? (GenericData) data : null;
        Map<Object, Object> map = Map.class.isAssignableFrom(clazz) ? (Map) data : null;
        int length = content.length();
        int nextEquals = content.indexOf(61);
        int amp;
        for (int cur = 0; cur < length; cur = amp + 1) {
            String name;
            String stringValue;
            amp = content.indexOf(38, cur);
            if (amp == -1) {
                amp = length;
            }
            if (nextEquals == -1 || nextEquals >= amp) {
                name = content.substring(cur, amp);
                stringValue = StringUtil.EMPTY_STRING;
            } else {
                name = content.substring(cur, nextEquals);
                stringValue = CharEscapers.decodeUri(content.substring(nextEquals + 1, amp));
                nextEquals = content.indexOf(61, amp + 1);
            }
            name = CharEscapers.decodeUri(name);
            FieldInfo fieldInfo = classInfo.getFieldInfo(name);
            if (fieldInfo != null) {
                Class<?> type = fieldInfo.type;
                if (Collection.class.isAssignableFrom(type)) {
                    Collection<Object> collection = (Collection) fieldInfo.getValue(data);
                    if (collection == null) {
                        collection = ClassInfo.newCollectionInstance(type);
                        fieldInfo.setValue(data, collection);
                    }
                    collection.add(FieldInfo.parsePrimitiveValue(ClassInfo.getCollectionParameter(fieldInfo.field), stringValue));
                } else {
                    fieldInfo.setValue(data, FieldInfo.parsePrimitiveValue(type, stringValue));
                }
            } else {
                ArrayList<String> listValue = (ArrayList) map.get(name);
                if (listValue == null) {
                    listValue = new ArrayList();
                    if (genericData != null) {
                        genericData.set(name, listValue);
                    } else {
                        map.put(name, listValue);
                    }
                }
                listValue.add(stringValue);
            }
        }
    }
}
