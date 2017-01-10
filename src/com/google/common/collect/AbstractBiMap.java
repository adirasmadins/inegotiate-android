package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible("Not needed in emulated source.")
    private static final long serialVersionUID = 0;
    private transient Map<K, V> delegate;
    private transient Set<Entry<K, V>> entrySet;
    private transient AbstractBiMap<V, K> inverse;
    private transient Set<K> keySet;
    private transient Set<V> valueSet;

    private class EntrySet extends ForwardingSet<Entry<K, V>> {
        final Set<Entry<K, V>> esDelegate;

        /* renamed from: com.google.common.collect.AbstractBiMap.EntrySet.1 */
        class C04011 implements Iterator<Entry<K, V>> {
            Entry<K, V> entry;
            final /* synthetic */ Iterator val$iterator;

            /* renamed from: com.google.common.collect.AbstractBiMap.EntrySet.1.1 */
            class C04001 extends ForwardingMapEntry<K, V> {
                final /* synthetic */ Entry val$finalEntry;

                C04001(Entry entry) {
                    this.val$finalEntry = entry;
                }

                protected Entry<K, V> delegate() {
                    return this.val$finalEntry;
                }

                public V setValue(V value) {
                    Preconditions.checkState(EntrySet.this.contains(this), "entry no longer in map");
                    if (Objects.equal(value, getValue())) {
                        return value;
                    }
                    boolean z;
                    if (AbstractBiMap.this.containsValue(value)) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Preconditions.checkArgument(z, "value already present: %s", value);
                    V oldValue = this.val$finalEntry.setValue(value);
                    Preconditions.checkState(Objects.equal(value, AbstractBiMap.this.get(getKey())), "entry no longer in map");
                    AbstractBiMap.this.updateInverseMap(getKey(), true, oldValue, value);
                    return oldValue;
                }
            }

            C04011(Iterator it) {
                this.val$iterator = it;
            }

            public boolean hasNext() {
                return this.val$iterator.hasNext();
            }

            public Entry<K, V> next() {
                this.entry = (Entry) this.val$iterator.next();
                return new C04001(this.entry);
            }

            public void remove() {
                Preconditions.checkState(this.entry != null);
                V value = this.entry.getValue();
                this.val$iterator.remove();
                AbstractBiMap.this.removeFromInverseMap(value);
            }
        }

        private EntrySet() {
            this.esDelegate = AbstractBiMap.this.delegate.entrySet();
        }

        protected Set<Entry<K, V>> delegate() {
            return this.esDelegate;
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean remove(Object object) {
            if (!this.esDelegate.contains(object)) {
                return false;
            }
            Entry<?, ?> entry = (Entry) object;
            AbstractBiMap.this.inverse.delegate.remove(entry.getValue());
            this.esDelegate.remove(entry);
            return true;
        }

        public Iterator<Entry<K, V>> iterator() {
            return new C04011(this.esDelegate.iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] array) {
            return standardToArray(array);
        }

        public boolean contains(Object o) {
            return Maps.containsEntryImpl(delegate(), o);
        }

        public boolean containsAll(Collection<?> c) {
            return standardContainsAll(c);
        }

        public boolean removeAll(Collection<?> c) {
            return standardRemoveAll(c);
        }

        public boolean retainAll(Collection<?> c) {
            return standardRetainAll(c);
        }
    }

    private static class Inverse<K, V> extends AbstractBiMap<K, V> {
        @GwtIncompatible("Not needed in emulated source.")
        private static final long serialVersionUID = 0;

        protected /* bridge */ /* synthetic */ Object delegate() {
            return super.delegate();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }

        private Inverse(Map<K, V> backward, AbstractBiMap<V, K> forward) {
            super(forward, null);
        }

        @GwtIncompatible("java.io.ObjectOuputStream")
        private void writeObject(ObjectOutputStream stream) throws IOException {
            stream.defaultWriteObject();
            stream.writeObject(inverse());
        }

        @GwtIncompatible("java.io.ObjectInputStream")
        private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
            stream.defaultReadObject();
            setInverse((AbstractBiMap) stream.readObject());
        }

        @GwtIncompatible("Not needed in the emulated source.")
        Object readResolve() {
            return inverse().inverse();
        }
    }

    private class KeySet extends ForwardingSet<K> {

        /* renamed from: com.google.common.collect.AbstractBiMap.KeySet.1 */
        class C04021 implements Iterator<K> {
            Entry<K, V> entry;
            final /* synthetic */ Iterator val$iterator;

            C04021(Iterator it) {
                this.val$iterator = it;
            }

            public boolean hasNext() {
                return this.val$iterator.hasNext();
            }

            public K next() {
                this.entry = (Entry) this.val$iterator.next();
                return this.entry.getKey();
            }

            public void remove() {
                Preconditions.checkState(this.entry != null);
                V value = this.entry.getValue();
                this.val$iterator.remove();
                AbstractBiMap.this.removeFromInverseMap(value);
            }
        }

        private KeySet() {
        }

        protected Set<K> delegate() {
            return AbstractBiMap.this.delegate.keySet();
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean remove(Object key) {
            if (!contains(key)) {
                return false;
            }
            AbstractBiMap.this.removeFromBothMaps(key);
            return true;
        }

        public boolean removeAll(Collection<?> keysToRemove) {
            return standardRemoveAll(keysToRemove);
        }

        public boolean retainAll(Collection<?> keysToRetain) {
            return standardRetainAll(keysToRetain);
        }

        public Iterator<K> iterator() {
            return new C04021(AbstractBiMap.this.delegate.entrySet().iterator());
        }
    }

    private class ValueSet extends ForwardingSet<V> {
        final Set<V> valuesDelegate;

        /* renamed from: com.google.common.collect.AbstractBiMap.ValueSet.1 */
        class C04031 implements Iterator<V> {
            final /* synthetic */ Iterator val$iterator;
            V valueToRemove;

            C04031(Iterator it) {
                this.val$iterator = it;
            }

            public boolean hasNext() {
                return this.val$iterator.hasNext();
            }

            public V next() {
                V next = this.val$iterator.next();
                this.valueToRemove = next;
                return next;
            }

            public void remove() {
                this.val$iterator.remove();
                AbstractBiMap.this.removeFromInverseMap(this.valueToRemove);
            }
        }

        private ValueSet() {
            this.valuesDelegate = AbstractBiMap.this.inverse.keySet();
        }

        protected Set<V> delegate() {
            return this.valuesDelegate;
        }

        public Iterator<V> iterator() {
            return new C04031(AbstractBiMap.this.delegate.values().iterator());
        }

        public Object[] toArray() {
            return standardToArray();
        }

        public <T> T[] toArray(T[] array) {
            return standardToArray(array);
        }

        public String toString() {
            return standardToString();
        }
    }

    AbstractBiMap(Map<K, V> forward, Map<V, K> backward) {
        setDelegates(forward, backward);
    }

    private AbstractBiMap(Map<K, V> backward, AbstractBiMap<V, K> forward) {
        this.delegate = backward;
        this.inverse = forward;
    }

    protected Map<K, V> delegate() {
        return this.delegate;
    }

    void setDelegates(Map<K, V> forward, Map<V, K> backward) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkState(this.delegate == null);
        if (this.inverse == null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkState(z);
        Preconditions.checkArgument(forward.isEmpty());
        Preconditions.checkArgument(backward.isEmpty());
        if (forward == backward) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        this.delegate = forward;
        this.inverse = new Inverse(this, null);
    }

    void setInverse(AbstractBiMap<V, K> inverse) {
        this.inverse = inverse;
    }

    public boolean containsValue(Object value) {
        return this.inverse.containsKey(value);
    }

    public V put(K key, V value) {
        return putInBothMaps(key, value, false);
    }

    public V forcePut(K key, V value) {
        return putInBothMaps(key, value, true);
    }

    private V putInBothMaps(@Nullable K key, @Nullable V value, boolean force) {
        boolean containedKey = containsKey(key);
        if (containedKey && Objects.equal(value, get(key))) {
            return value;
        }
        if (force) {
            inverse().remove(value);
        } else {
            Preconditions.checkArgument(!containsValue(value), "value already present: %s", value);
        }
        V oldValue = this.delegate.put(key, value);
        updateInverseMap(key, containedKey, oldValue, value);
        return oldValue;
    }

    private void updateInverseMap(K key, boolean containedKey, V oldValue, V newValue) {
        if (containedKey) {
            removeFromInverseMap(oldValue);
        }
        this.inverse.delegate.put(newValue, key);
    }

    public V remove(Object key) {
        return containsKey(key) ? removeFromBothMaps(key) : null;
    }

    private V removeFromBothMaps(Object key) {
        V oldValue = this.delegate.remove(key);
        removeFromInverseMap(oldValue);
        return oldValue;
    }

    private void removeFromInverseMap(V oldValue) {
        this.inverse.delegate.remove(oldValue);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public void clear() {
        this.delegate.clear();
        this.inverse.delegate.clear();
    }

    public BiMap<V, K> inverse() {
        return this.inverse;
    }

    public Set<K> keySet() {
        Set<K> set = this.keySet;
        if (set != null) {
            return set;
        }
        set = new KeySet();
        this.keySet = set;
        return set;
    }

    public Set<V> values() {
        Set<V> set = this.valueSet;
        if (set != null) {
            return set;
        }
        set = new ValueSet();
        this.valueSet = set;
        return set;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = this.entrySet;
        if (set != null) {
            return set;
        }
        set = new EntrySet();
        this.entrySet = set;
        return set;
    }
}
