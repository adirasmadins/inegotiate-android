package com.google.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.WeakHashMap;

public final class ClassInfo {
    private static final ThreadLocal<WeakHashMap<Class<?>, ClassInfo>> CACHE;
    public final Class<?> clazz;
    private final IdentityHashMap<String, FieldInfo> keyNameToFieldInfoMap;

    /* renamed from: com.google.api.client.util.ClassInfo.1 */
    static class C03301 extends ThreadLocal<WeakHashMap<Class<?>, ClassInfo>> {
        C03301() {
        }

        protected WeakHashMap<Class<?>, ClassInfo> initialValue() {
            return new WeakHashMap();
        }
    }

    static {
        CACHE = new C03301();
    }

    public static ClassInfo of(Class<?> clazz) {
        if (clazz == null) {
            return null;
        }
        WeakHashMap<Class<?>, ClassInfo> cache = (WeakHashMap) CACHE.get();
        ClassInfo classInfo = (ClassInfo) cache.get(clazz);
        if (classInfo != null) {
            return classInfo;
        }
        classInfo = new ClassInfo(clazz);
        cache.put(clazz, classInfo);
        return classInfo;
    }

    public FieldInfo getFieldInfo(String keyName) {
        if (keyName == null) {
            return null;
        }
        IdentityHashMap<String, FieldInfo> keyNameToFieldInfoMap = this.keyNameToFieldInfoMap;
        if (keyNameToFieldInfoMap != null) {
            return (FieldInfo) keyNameToFieldInfoMap.get(keyName.intern());
        }
        return null;
    }

    public Field getField(String keyName) {
        FieldInfo fieldInfo = getFieldInfo(keyName);
        return fieldInfo == null ? null : fieldInfo.field;
    }

    public int getKeyCount() {
        IdentityHashMap<String, FieldInfo> keyNameToFieldInfoMap = this.keyNameToFieldInfoMap;
        if (keyNameToFieldInfoMap == null) {
            return 0;
        }
        return keyNameToFieldInfoMap.size();
    }

    public Collection<String> getKeyNames() {
        IdentityHashMap<String, FieldInfo> keyNameToFieldInfoMap = this.keyNameToFieldInfoMap;
        if (keyNameToFieldInfoMap == null) {
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(keyNameToFieldInfoMap.keySet());
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException e) {
            throw handleExceptionForNewInstance(e, clazz);
        } catch (InstantiationException e2) {
            throw handleExceptionForNewInstance(e2, clazz);
        }
    }

    private static IllegalArgumentException handleExceptionForNewInstance(Exception e, Class<?> clazz) {
        StringBuilder buf = new StringBuilder("unable to create new instance of class ").append(clazz.getName());
        if (Modifier.isAbstract(clazz.getModifiers())) {
            buf.append(" (and) because it is abstract");
        }
        if (!(clazz.getEnclosingClass() == null || Modifier.isStatic(clazz.getModifiers()))) {
            buf.append(" (and) because it is not static");
        }
        if (Modifier.isPublic(clazz.getModifiers())) {
            try {
                clazz.getConstructor(new Class[0]);
            } catch (NoSuchMethodException e2) {
                buf.append(" (and) because it has no public default constructor");
            }
        } else {
            buf.append(" (and) because it is not public");
        }
        throw new IllegalArgumentException(buf.toString(), e);
    }

    public static Collection<Object> newCollectionInstance(Class<?> collectionClass) {
        if (collectionClass == null || collectionClass.isAssignableFrom(ArrayList.class)) {
            return new ArrayList();
        }
        if ((collectionClass.getModifiers() & 1536) == 0) {
            return (Collection) newInstance(collectionClass);
        }
        if (collectionClass.isAssignableFrom(HashSet.class)) {
            return new HashSet();
        }
        if (collectionClass.isAssignableFrom(TreeSet.class)) {
            return new TreeSet();
        }
        throw new IllegalArgumentException("no default collection class defined for class: " + collectionClass.getName());
    }

    public static Map<String, Object> newMapInstance(Class<?> mapClass) {
        if (mapClass != null && (mapClass.getModifiers() & 1536) == 0) {
            return (Map) newInstance(mapClass);
        }
        if (mapClass == null || mapClass.isAssignableFrom(ArrayMap.class)) {
            return ArrayMap.create();
        }
        if (mapClass.isAssignableFrom(TreeMap.class)) {
            return new TreeMap();
        }
        throw new IllegalArgumentException("no default map class defined for class: " + mapClass.getName());
    }

    public static Class<?> getCollectionParameter(Field field) {
        if (field != null) {
            Type genericType = field.getGenericType();
            if (genericType instanceof ParameterizedType) {
                Type[] typeArgs = ((ParameterizedType) genericType).getActualTypeArguments();
                if (typeArgs.length == 1 && (typeArgs[0] instanceof Class)) {
                    return (Class) typeArgs[0];
                }
            }
        }
        return null;
    }

    public static Class<?> getMapValueParameter(Field field) {
        if (field != null) {
            return getMapValueParameter(field.getGenericType());
        }
        return null;
    }

    public static Class<?> getMapValueParameter(Type genericType) {
        if (genericType instanceof ParameterizedType) {
            Type[] typeArgs = ((ParameterizedType) genericType).getActualTypeArguments();
            if (typeArgs.length == 2 && (typeArgs[1] instanceof Class)) {
                return (Class) typeArgs[1];
            }
        }
        return null;
    }

    private ClassInfo(Class<?> clazz) {
        this.clazz = clazz;
        Class<?> superClass = clazz.getSuperclass();
        IdentityHashMap<String, FieldInfo> keyNameToFieldInfoMap = new IdentityHashMap();
        if (superClass != null) {
            IdentityHashMap<String, FieldInfo> superKeyNameToFieldInfoMap = of(superClass).keyNameToFieldInfoMap;
            if (superKeyNameToFieldInfoMap != null) {
                keyNameToFieldInfoMap.putAll(superKeyNameToFieldInfoMap);
            }
        }
        for (Field field : clazz.getDeclaredFields()) {
            FieldInfo fieldInfo = FieldInfo.of(field);
            if (fieldInfo != null) {
                String fieldName = fieldInfo.name;
                FieldInfo conflictingFieldInfo = (FieldInfo) keyNameToFieldInfoMap.get(fieldName);
                if (conflictingFieldInfo != null) {
                    throw new IllegalArgumentException("two fields have the same data key name: " + field + " and " + conflictingFieldInfo.field);
                }
                keyNameToFieldInfoMap.put(fieldName, fieldInfo);
            }
        }
        if (keyNameToFieldInfoMap.isEmpty()) {
            this.keyNameToFieldInfoMap = null;
        } else {
            this.keyNameToFieldInfoMap = keyNameToFieldInfoMap;
        }
    }
}
