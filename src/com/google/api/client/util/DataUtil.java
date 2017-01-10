package com.google.api.client.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public class DataUtil {
    public static Map<String, Object> mapOf(Object data) {
        if (data == null) {
            return Collections.emptyMap();
        }
        if (data instanceof Map) {
            return (Map) data;
        }
        return new ReflectionMap(data);
    }

    public static <T> T clone(T data) {
        if (FieldInfo.isPrimitive((Object) data)) {
            return data;
        }
        T clone;
        if (data instanceof GenericData) {
            clone = ((GenericData) data).clone();
        } else if (data instanceof ArrayMap) {
            clone = ((ArrayMap) data).clone();
        } else {
            clone = ClassInfo.newInstance(data.getClass());
        }
        cloneInternal(data, clone);
        return clone;
    }

    static void cloneInternal(Object src, Object dest) {
        Class<?> srcClass = src.getClass();
        if (Collection.class.isAssignableFrom(srcClass)) {
            Collection<Object> srcCollection = (Collection) src;
            if (ArrayList.class.isAssignableFrom(srcClass)) {
                ((ArrayList) dest).ensureCapacity(srcCollection.size());
            }
            Collection<Object> destCollection = (Collection) dest;
            for (Object srcValue : srcCollection) {
                Object srcValue2;
                destCollection.add(clone(srcValue2));
            }
            return;
        }
        boolean isGenericData = GenericData.class.isAssignableFrom(srcClass);
        if (!isGenericData) {
            if (Map.class.isAssignableFrom(srcClass)) {
                if (ArrayMap.class.isAssignableFrom(srcClass)) {
                    ArrayMap<Object, Object> destMap = (ArrayMap) dest;
                    ArrayMap<Object, Object> srcMap = (ArrayMap) src;
                    int size = srcMap.size();
                    for (int i = 0; i < size; i++) {
                        srcValue2 = srcMap.getValue(i);
                        if (!FieldInfo.isPrimitive(srcValue2)) {
                            destMap.set(i, clone(srcValue2));
                        }
                    }
                    return;
                }
                Map<String, Object> destMap2 = (Map) dest;
                for (Entry<String, Object> srcEntry : ((Map) src).entrySet()) {
                    destMap2.put(srcEntry.getKey(), clone(srcEntry.getValue()));
                }
                return;
            }
        }
        ClassInfo classInfo = ClassInfo.of(srcClass);
        for (String fieldName : classInfo.getKeyNames()) {
            FieldInfo fieldInfo = classInfo.getFieldInfo(fieldName);
            if (!(fieldInfo.isFinal || (isGenericData && fieldInfo.isPrimitive))) {
                srcValue2 = fieldInfo.getValue(src);
                if (srcValue2 != null) {
                    fieldInfo.setValue(dest, clone(srcValue2));
                }
            }
        }
    }

    private DataUtil() {
    }
}
