package com.amazonaws.transform;

import java.util.Map.Entry;

public class MapEntry<K, V> implements Entry<K, V> {
    private K key;
    private V value;

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public K setKey(K k) {
        this.key = k;
        return this.key;
    }

    public V setValue(V v) {
        this.value = v;
        return this.value;
    }
}
