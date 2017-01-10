package com.google.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.WeakHashMap;

public class FieldInfo {
    private static final ThreadLocal<WeakHashMap<Field, FieldInfo>> CACHE;
    public final Field field;
    public final boolean isFinal;
    public final boolean isPrimitive;
    public final String name;
    public final Class<?> type;

    /* renamed from: com.google.api.client.util.FieldInfo.1 */
    static class C03311 extends ThreadLocal<WeakHashMap<Field, FieldInfo>> {
        C03311() {
        }

        protected WeakHashMap<Field, FieldInfo> initialValue() {
            return new WeakHashMap();
        }
    }

    static {
        CACHE = new C03311();
    }

    public static FieldInfo of(Field field) {
        if (field == null) {
            return null;
        }
        WeakHashMap<Field, FieldInfo> cache = (WeakHashMap) CACHE.get();
        FieldInfo fieldInfo = (FieldInfo) cache.get(field);
        if (fieldInfo != null || Modifier.isStatic(field.getModifiers())) {
            return fieldInfo;
        }
        Key key = (Key) field.getAnnotation(Key.class);
        if (key == null) {
            return null;
        }
        String fieldName = key.value();
        if ("##default".equals(fieldName)) {
            fieldName = field.getName();
        }
        fieldInfo = new FieldInfo(field, fieldName);
        cache.put(field, fieldInfo);
        field.setAccessible(true);
        return fieldInfo;
    }

    FieldInfo(Field field, String name) {
        this.field = field;
        this.name = name.intern();
        this.isFinal = Modifier.isFinal(field.getModifiers());
        Class type = field.getType();
        this.type = type;
        this.isPrimitive = isPrimitive(type);
    }

    public Object getValue(Object obj) {
        return getFieldValue(this.field, obj);
    }

    public void setValue(Object obj, Object value) {
        setFieldValue(this.field, obj, value);
    }

    public ClassInfo getClassInfo() {
        return ClassInfo.of(this.field.getDeclaringClass());
    }

    public static boolean isPrimitive(Class<?> fieldClass) {
        return fieldClass.isPrimitive() || fieldClass == Character.class || fieldClass == String.class || fieldClass == Integer.class || fieldClass == Long.class || fieldClass == Short.class || fieldClass == Byte.class || fieldClass == Float.class || fieldClass == Double.class || fieldClass == BigInteger.class || fieldClass == BigDecimal.class || fieldClass == DateTime.class || fieldClass == Boolean.class;
    }

    public static boolean isPrimitive(Object fieldValue) {
        return fieldValue == null || isPrimitive(fieldValue.getClass());
    }

    public static Object getFieldValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void setFieldValue(Field field, Object obj, Object value) {
        if (Modifier.isFinal(field.getModifiers())) {
            Object finalValue = getFieldValue(field, obj);
            if (value == null) {
                if (finalValue == null) {
                    return;
                }
            } else if (value.equals(finalValue)) {
                return;
            }
            throw new IllegalArgumentException("expected final value <" + finalValue + "> but was <" + value + "> on " + field.getName() + " field in " + obj.getClass().getName());
        }
        try {
            field.set(obj, value);
        } catch (SecurityException e) {
            throw new IllegalArgumentException(e);
        } catch (IllegalAccessException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public static Object parsePrimitiveValue(Class<?> primitiveClass, String stringValue) {
        if (stringValue == null || primitiveClass == null || primitiveClass == String.class) {
            return stringValue;
        }
        if (primitiveClass == Character.class || primitiveClass == Character.TYPE) {
            if (stringValue.length() == 1) {
                return Character.valueOf(stringValue.charAt(0));
            }
            throw new IllegalArgumentException("expected type Character/char but got " + primitiveClass);
        } else if (primitiveClass == Boolean.class || primitiveClass == Boolean.TYPE) {
            return Boolean.valueOf(stringValue);
        } else {
            if (primitiveClass == Byte.class || primitiveClass == Byte.TYPE) {
                return Byte.valueOf(stringValue);
            }
            if (primitiveClass == Short.class || primitiveClass == Short.TYPE) {
                return Short.valueOf(stringValue);
            }
            if (primitiveClass == Integer.class || primitiveClass == Integer.TYPE) {
                return Integer.valueOf(stringValue);
            }
            if (primitiveClass == Long.class || primitiveClass == Long.TYPE) {
                return Long.valueOf(stringValue);
            }
            if (primitiveClass == Float.class || primitiveClass == Float.TYPE) {
                return Float.valueOf(stringValue);
            }
            if (primitiveClass == Double.class || primitiveClass == Double.TYPE) {
                return Double.valueOf(stringValue);
            }
            if (primitiveClass == DateTime.class) {
                return DateTime.parseRfc3339(stringValue);
            }
            if (primitiveClass == BigInteger.class) {
                return new BigInteger(stringValue);
            }
            if (primitiveClass == BigDecimal.class) {
                return new BigDecimal(stringValue);
            }
            throw new IllegalArgumentException("expected primitive class, but got: " + primitiveClass);
        }
    }
}
