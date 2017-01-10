package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public final class ReflectionMap extends AbstractMap<String, Object> {
    final ClassInfo classInfo;
    private EntrySet entrySet;
    final Object object;
    final int size;

    static final class Entry implements java.util.Map.Entry<String, Object> {
        private final ClassInfo classInfo;
        private final String fieldName;
        private Object fieldValue;
        private boolean isFieldValueComputed;
        private final Object object;

        public Entry(Object object, String fieldName) {
            this.classInfo = ClassInfo.of(object.getClass());
            this.object = object;
            this.fieldName = fieldName;
        }

        public String getKey() {
            return this.fieldName;
        }

        public Object getValue() {
            if (this.isFieldValueComputed) {
                return this.fieldValue;
            }
            this.isFieldValueComputed = true;
            Object value = this.classInfo.getFieldInfo(this.fieldName).getValue(this.object);
            this.fieldValue = value;
            return value;
        }

        public Object setValue(Object value) {
            FieldInfo fieldInfo = this.classInfo.getFieldInfo(this.fieldName);
            Object oldValue = getValue();
            fieldInfo.setValue(this.object, value);
            this.fieldValue = value;
            return oldValue;
        }
    }

    static final class EntryIterator implements Iterator<java.util.Map.Entry<String, Object>> {
        final ClassInfo classInfo;
        private int fieldIndex;
        private final String[] fieldNames;
        private final int numFields;
        private final Object object;

        EntryIterator(ClassInfo classInfo, Object object) {
            this.fieldIndex = 0;
            this.classInfo = classInfo;
            this.object = object;
            Collection<String> keyNames = this.classInfo.getKeyNames();
            int size = keyNames.size();
            this.numFields = size;
            if (size == 0) {
                this.fieldNames = null;
                return;
            }
            String[] fieldNames = new String[size];
            this.fieldNames = fieldNames;
            int i = 0;
            for (String keyName : keyNames) {
                int i2 = i + 1;
                fieldNames[i] = keyName;
                i = i2;
            }
            Arrays.sort(fieldNames);
        }

        public boolean hasNext() {
            return this.fieldIndex < this.numFields;
        }

        public java.util.Map.Entry<String, Object> next() {
            int fieldIndex = this.fieldIndex;
            if (fieldIndex >= this.numFields) {
                throw new NoSuchElementException();
            }
            String fieldName = this.fieldNames[fieldIndex];
            this.fieldIndex++;
            return new Entry(this.object, fieldName);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    final class EntrySet extends AbstractSet<java.util.Map.Entry<String, Object>> {
        EntrySet() {
        }

        public Iterator<java.util.Map.Entry<String, Object>> iterator() {
            return new EntryIterator(ReflectionMap.this.classInfo, ReflectionMap.this.object);
        }

        public int size() {
            return ReflectionMap.this.size;
        }
    }

    public ReflectionMap(Object object) {
        this.object = object;
        ClassInfo classInfo = ClassInfo.of(object.getClass());
        this.classInfo = classInfo;
        this.size = classInfo.getKeyCount();
    }

    public Set<java.util.Map.Entry<String, Object>> entrySet() {
        EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }
}
