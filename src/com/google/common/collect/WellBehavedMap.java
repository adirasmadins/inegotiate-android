package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible
final class WellBehavedMap<K, V> extends ForwardingMap<K, V> {
    private final Map<K, V> delegate;
    private Set<Entry<K, V>> entrySet;

    private static class KeyToEntryConverter<K, V> extends InvertibleFunction<K, Entry<K, V>> {
        final Map<K, V> map;

        /* renamed from: com.google.common.collect.WellBehavedMap.KeyToEntryConverter.1 */
        class C06521 extends AbstractMapEntry<K, V> {
            final /* synthetic */ Object val$key;

            C06521(Object obj) {
                this.val$key = obj;
            }

            public K getKey() {
                return this.val$key;
            }

            public V getValue() {
                return KeyToEntryConverter.this.map.get(this.val$key);
            }

            public V setValue(V value) {
                return KeyToEntryConverter.this.map.put(this.val$key, value);
            }
        }

        KeyToEntryConverter(Map<K, V> map) {
            this.map = map;
        }

        public Entry<K, V> apply(K key) {
            return new C06521(key);
        }

        public K invert(Entry<K, V> entry) {
            return entry.getKey();
        }
    }

    private WellBehavedMap(Map<K, V> delegate) {
        this.delegate = delegate;
    }

    static <K, V> WellBehavedMap<K, V> wrap(Map<K, V> delegate) {
        return new WellBehavedMap(delegate);
    }

    protected Map<K, V> delegate() {
        return this.delegate;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> es = this.entrySet;
        if (es != null) {
            return es;
        }
        es = Sets.transform(this.delegate.keySet(), new KeyToEntryConverter(this));
        this.entrySet = es;
        return es;
    }
}
