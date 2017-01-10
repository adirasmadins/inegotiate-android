package com.google.api.client.util;

import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GenericData extends AbstractMap<String, Object> implements Cloneable {
    final ClassInfo classInfo;
    private EntrySet entrySet;
    public ArrayMap<String, Object> unknownFields;

    final class EntryIterator implements Iterator<Entry<String, Object>> {
        private final EntryIterator fieldIterator;
        private boolean startedUnknown;
        private final Iterator<Entry<String, Object>> unknownIterator;

        EntryIterator() {
            this.fieldIterator = new EntryIterator(GenericData.this.classInfo, GenericData.this);
            this.unknownIterator = GenericData.this.unknownFields.entrySet().iterator();
        }

        public boolean hasNext() {
            return (!this.startedUnknown && this.fieldIterator.hasNext()) || this.unknownIterator.hasNext();
        }

        public Entry<String, Object> next() {
            if (!this.startedUnknown) {
                EntryIterator fieldIterator = this.fieldIterator;
                if (fieldIterator.hasNext()) {
                    return fieldIterator.next();
                }
                this.startedUnknown = true;
            }
            return (Entry) this.unknownIterator.next();
        }

        public void remove() {
            if (this.startedUnknown) {
                this.unknownIterator.remove();
            }
            throw new UnsupportedOperationException();
        }
    }

    final class EntrySet extends AbstractSet<Entry<String, Object>> {
        EntrySet() {
        }

        public Iterator<Entry<String, Object>> iterator() {
            return new EntryIterator();
        }

        public int size() {
            return GenericData.this.size();
        }
    }

    public GenericData() {
        this.unknownFields = ArrayMap.create();
        this.classInfo = ClassInfo.of(getClass());
    }

    public int size() {
        return this.classInfo.getKeyCount() + this.unknownFields.size();
    }

    public final Object get(Object name) {
        if (!(name instanceof String)) {
            return null;
        }
        String fieldName = (String) name;
        FieldInfo fieldInfo = this.classInfo.getFieldInfo(fieldName);
        if (fieldInfo != null) {
            return fieldInfo.getValue(this);
        }
        return this.unknownFields.get(fieldName);
    }

    public final Object put(String name, Object value) {
        FieldInfo fieldInfo = this.classInfo.getFieldInfo(name);
        if (fieldInfo == null) {
            return this.unknownFields.put(name, value);
        }
        Object oldValue = fieldInfo.getValue(this);
        fieldInfo.setValue(this, value);
        return oldValue;
    }

    public final void set(String name, Object value) {
        FieldInfo fieldInfo = this.classInfo.getFieldInfo(name);
        if (fieldInfo != null) {
            fieldInfo.setValue(this, value);
        } else {
            this.unknownFields.put(name, value);
        }
    }

    public final void putAll(Map<? extends String, ?> map) {
        for (Entry<? extends String, ?> entry : map.entrySet()) {
            set((String) entry.getKey(), entry.getValue());
        }
    }

    public final Object remove(Object name) {
        if (!(name instanceof String)) {
            return null;
        }
        if (this.classInfo.getFieldInfo((String) name) == null) {
            return this.unknownFields.remove(name);
        }
        throw new UnsupportedOperationException();
    }

    public Set<Entry<String, Object>> entrySet() {
        EntrySet entrySet = this.entrySet;
        if (entrySet != null) {
            return entrySet;
        }
        entrySet = new EntrySet();
        this.entrySet = entrySet;
        return entrySet;
    }

    public GenericData clone() {
        try {
            GenericData result = (GenericData) super.clone();
            result.entrySet = null;
            DataUtil.cloneInternal(this, result);
            result.unknownFields = (ArrayMap) DataUtil.clone(this.unknownFields);
            return result;
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
    }
}
