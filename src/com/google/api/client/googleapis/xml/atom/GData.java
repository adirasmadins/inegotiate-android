package com.google.api.client.googleapis.xml.atom;

import com.google.api.client.util.ArrayMap;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.DataUtil;
import com.google.api.client.util.FieldInfo;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import org.codehaus.jackson.impl.JsonWriteContext;
import org.codehaus.jackson.io.CharacterEscapes;

public class GData {

    static class FieldsMask {
        StringBuilder buf;
        int numDifferences;

        FieldsMask() {
            this.buf = new StringBuilder();
        }

        void append(String name) {
            StringBuilder buf = this.buf;
            int i = this.numDifferences + 1;
            this.numDifferences = i;
            if (i != 1) {
                buf.append(',');
            }
            buf.append(name);
        }

        void append(String name, FieldsMask subFields) {
            boolean isSingle = true;
            append(name);
            StringBuilder buf = this.buf;
            if (subFields.numDifferences != 1) {
                isSingle = false;
            }
            if (isSingle) {
                buf.append('/');
            } else {
                buf.append('(');
            }
            buf.append(subFields.buf);
            if (!isSingle) {
                buf.append(')');
            }
        }
    }

    public static String getFieldsFor(Class<?> dataClass) {
        StringBuilder fieldsBuf = new StringBuilder();
        appendFieldsFor(fieldsBuf, dataClass, new int[1]);
        return fieldsBuf.toString();
    }

    public static String getFeedFields(Class<?> feedClass, Class<?> entryClass) {
        StringBuilder fieldsBuf = new StringBuilder();
        appendFeedFields(fieldsBuf, feedClass, entryClass);
        return fieldsBuf.toString();
    }

    private static void appendFieldsFor(StringBuilder fieldsBuf, Class<?> dataClass, int[] numFields) {
        if (Map.class.isAssignableFrom(dataClass) || Collection.class.isAssignableFrom(dataClass)) {
            throw new IllegalArgumentException("cannot specify field mask for a Map or Collection class: " + dataClass);
        }
        ClassInfo classInfo = ClassInfo.of(dataClass);
        Iterator i$ = new TreeSet(classInfo.getKeyNames()).iterator();
        while (i$.hasNext()) {
            String name = (String) i$.next();
            FieldInfo fieldInfo = classInfo.getFieldInfo(name);
            if (!fieldInfo.isFinal) {
                int i = numFields[0] + 1;
                numFields[0] = i;
                if (i != 1) {
                    fieldsBuf.append(',');
                }
                fieldsBuf.append(name);
                Class<?> fieldClass = fieldInfo.type;
                if (Collection.class.isAssignableFrom(fieldClass)) {
                    fieldClass = ClassInfo.getCollectionParameter(fieldInfo.field);
                }
                if (fieldClass != null) {
                    if (fieldInfo.isPrimitive) {
                        if (!(name.charAt(0) == '@' || name.equals("text()"))) {
                        }
                    } else if (!(Collection.class.isAssignableFrom(fieldClass) || Map.class.isAssignableFrom(fieldClass))) {
                        int[] subNumFields = new int[1];
                        int openParenIndex = fieldsBuf.length();
                        fieldsBuf.append('(');
                        appendFieldsFor(fieldsBuf, fieldClass, subNumFields);
                        updateFieldsBasedOnNumFields(fieldsBuf, openParenIndex, subNumFields[0]);
                    }
                }
            }
        }
    }

    private static void appendFeedFields(StringBuilder fieldsBuf, Class<?> feedClass, Class<?> entryClass) {
        int[] numFields = new int[1];
        appendFieldsFor(fieldsBuf, feedClass, numFields);
        if (numFields[0] != 0) {
            fieldsBuf.append(",");
        }
        fieldsBuf.append("entry(");
        int openParenIndex = fieldsBuf.length() - 1;
        numFields[0] = 0;
        appendFieldsFor(fieldsBuf, entryClass, numFields);
        updateFieldsBasedOnNumFields(fieldsBuf, openParenIndex, numFields[0]);
    }

    private static void updateFieldsBasedOnNumFields(StringBuilder fieldsBuf, int openParenIndex, int numFields) {
        switch (numFields) {
            case CharacterEscapes.ESCAPE_NONE /*0*/:
                fieldsBuf.deleteCharAt(openParenIndex);
            case JsonWriteContext.STATUS_OK_AFTER_COMMA /*1*/:
                fieldsBuf.setCharAt(openParenIndex, '/');
            default:
                fieldsBuf.append(')');
        }
    }

    public static ArrayMap<String, Object> computePatch(Object patched, Object original) {
        FieldsMask fieldsMask = new FieldsMask();
        ArrayMap<String, Object> result = computePatchInternal(fieldsMask, patched, original);
        if (fieldsMask.numDifferences != 0) {
            result.put("@gd:fields", fieldsMask.buf.toString());
        }
        return result;
    }

    public static ArrayMap<String, Object> computePatchInternal(FieldsMask fieldsMask, Object patchedObject, Object originalObject) {
        ArrayMap<String, Object> result = ArrayMap.create();
        Map<String, Object> patchedMap = DataUtil.mapOf(patchedObject);
        Map<String, Object> originalMap = DataUtil.mapOf(originalObject);
        HashSet<String> fieldNames = new HashSet();
        fieldNames.addAll(patchedMap.keySet());
        fieldNames.addAll(originalMap.keySet());
        Iterator i$ = fieldNames.iterator();
        while (i$.hasNext()) {
            String name = (String) i$.next();
            Collection<Object> originalValue = originalMap.get(name);
            Collection<Object> patchedValue = patchedMap.get(name);
            if (originalValue != patchedValue) {
                Class type = originalValue == null ? patchedValue.getClass() : originalValue.getClass();
                if (!FieldInfo.isPrimitive(type)) {
                    FieldsMask subFieldsMask;
                    if (Collection.class.isAssignableFrom(type)) {
                        if (!(originalValue == null || patchedValue == null)) {
                            Collection<Object> patchedCollection = patchedValue;
                            int size = originalValue.size();
                            if (size == patchedCollection.size()) {
                                int i = 0;
                                while (i < size) {
                                    subFieldsMask = new FieldsMask();
                                    computePatchInternal(subFieldsMask, patchedValue, originalValue);
                                    if (subFieldsMask.numDifferences != 0) {
                                        break;
                                    }
                                    i++;
                                }
                                if (i != size) {
                                }
                            }
                        }
                        throw new UnsupportedOperationException("not yet implemented: support for patching collections");
                    } else if (originalValue == null) {
                        fieldsMask.append(name);
                        result.add(name, DataUtil.mapOf(patchedValue));
                    } else if (patchedValue == null) {
                        fieldsMask.append(name);
                    } else {
                        subFieldsMask = new FieldsMask();
                        ArrayMap<String, Object> patch = computePatchInternal(subFieldsMask, patchedValue, originalValue);
                        if (subFieldsMask.numDifferences != 0) {
                            fieldsMask.append(name, subFieldsMask);
                            result.add(name, patch);
                        }
                    }
                } else if (originalValue == null || !originalValue.equals(patchedValue)) {
                    fieldsMask.append(name);
                    if (patchedValue != null) {
                        result.add(name, patchedValue);
                    }
                }
            }
        }
        return result;
    }

    private GData() {
    }
}
