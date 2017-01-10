package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSequentialList;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true, serializable = true)
public class LinkedListMultimap<K, V> implements ListMultimap<K, V>, Serializable {
    @GwtIncompatible("java serialization not supported")
    private static final long serialVersionUID = 0;
    private transient List<Entry<K, V>> entries;
    private transient Node<K, V> head;
    private transient Multiset<K> keyCount;
    private transient Set<K> keySet;
    private transient Map<K, Node<K, V>> keyToKeyHead;
    private transient Map<K, Node<K, V>> keyToKeyTail;
    private transient Multiset<K> keys;
    private transient Map<K, Collection<V>> map;
    private transient Node<K, V> tail;
    private transient List<V> valuesList;

    /* renamed from: com.google.common.collect.LinkedListMultimap.1 */
    class C04811 extends AbstractSequentialList<V> {
        final /* synthetic */ Object val$key;

        C04811(Object obj) {
            this.val$key = obj;
        }

        public int size() {
            return LinkedListMultimap.this.keyCount.count(this.val$key);
        }

        public ListIterator<V> listIterator(int index) {
            return new ValueForKeyIterator(this.val$key, index);
        }

        public boolean removeAll(Collection<?> c) {
            return Iterators.removeAll(iterator(), c);
        }

        public boolean retainAll(Collection<?> c) {
            return Iterators.retainAll(iterator(), c);
        }
    }

    /* renamed from: com.google.common.collect.LinkedListMultimap.2 */
    class C04822 extends AbstractSet<K> {
        C04822() {
        }

        public int size() {
            return LinkedListMultimap.this.keyCount.elementSet().size();
        }

        public Iterator<K> iterator() {
            return new DistinctKeyIterator(null);
        }

        public boolean contains(Object key) {
            return LinkedListMultimap.this.keyCount.contains(key);
        }

        public boolean removeAll(Collection<?> c) {
            Preconditions.checkNotNull(c);
            return super.removeAll(c);
        }
    }

    /* renamed from: com.google.common.collect.LinkedListMultimap.3 */
    class C04843 extends AbstractSequentialList<V> {

        /* renamed from: com.google.common.collect.LinkedListMultimap.3.1 */
        class C04831 implements ListIterator<V> {
            final /* synthetic */ NodeIterator val$nodes;

            C04831(NodeIterator nodeIterator) {
                this.val$nodes = nodeIterator;
            }

            public boolean hasNext() {
                return this.val$nodes.hasNext();
            }

            public V next() {
                return this.val$nodes.next().value;
            }

            public boolean hasPrevious() {
                return this.val$nodes.hasPrevious();
            }

            public V previous() {
                return this.val$nodes.previous().value;
            }

            public int nextIndex() {
                return this.val$nodes.nextIndex();
            }

            public int previousIndex() {
                return this.val$nodes.previousIndex();
            }

            public void remove() {
                this.val$nodes.remove();
            }

            public void set(V e) {
                this.val$nodes.setValue(e);
            }

            public void add(V v) {
                throw new UnsupportedOperationException();
            }
        }

        C04843() {
        }

        public int size() {
            return LinkedListMultimap.this.keyCount.size();
        }

        public ListIterator<V> listIterator(int index) {
            return new C04831(new NodeIterator(index));
        }
    }

    /* renamed from: com.google.common.collect.LinkedListMultimap.4 */
    static class C04854 extends AbstractMapEntry<K, V> {
        final /* synthetic */ Node val$node;

        C04854(Node node) {
            this.val$node = node;
        }

        public K getKey() {
            return this.val$node.key;
        }

        public V getValue() {
            return this.val$node.value;
        }

        public V setValue(V value) {
            V oldValue = this.val$node.value;
            this.val$node.value = value;
            return oldValue;
        }
    }

    /* renamed from: com.google.common.collect.LinkedListMultimap.5 */
    class C04875 extends AbstractSequentialList<Entry<K, V>> {

        /* renamed from: com.google.common.collect.LinkedListMultimap.5.1 */
        class C04861 implements ListIterator<Entry<K, V>> {
            final /* synthetic */ ListIterator val$nodes;

            C04861(ListIterator listIterator) {
                this.val$nodes = listIterator;
            }

            public boolean hasNext() {
                return this.val$nodes.hasNext();
            }

            public Entry<K, V> next() {
                return LinkedListMultimap.createEntry((Node) this.val$nodes.next());
            }

            public void remove() {
                this.val$nodes.remove();
            }

            public boolean hasPrevious() {
                return this.val$nodes.hasPrevious();
            }

            public Entry<K, V> previous() {
                return LinkedListMultimap.createEntry((Node) this.val$nodes.previous());
            }

            public int nextIndex() {
                return this.val$nodes.nextIndex();
            }

            public int previousIndex() {
                return this.val$nodes.previousIndex();
            }

            public void set(Entry<K, V> entry) {
                throw new UnsupportedOperationException();
            }

            public void add(Entry<K, V> entry) {
                throw new UnsupportedOperationException();
            }
        }

        C04875() {
        }

        public int size() {
            return LinkedListMultimap.this.keyCount.size();
        }

        public ListIterator<Entry<K, V>> listIterator(int index) {
            return new C04861(new NodeIterator(index));
        }
    }

    /* renamed from: com.google.common.collect.LinkedListMultimap.6 */
    class C04886 extends AbstractMap<K, Collection<V>> {
        Set<Entry<K, Collection<V>>> entrySet;

        C04886() {
        }

        public Set<Entry<K, Collection<V>>> entrySet() {
            Set<Entry<K, Collection<V>>> result = this.entrySet;
            if (result != null) {
                return result;
            }
            result = new AsMapEntries(null);
            this.entrySet = result;
            return result;
        }

        public boolean containsKey(@Nullable Object key) {
            return LinkedListMultimap.this.containsKey(key);
        }

        public Collection<V> get(@Nullable Object key) {
            Collection<V> collection = LinkedListMultimap.this.get(key);
            return collection.isEmpty() ? null : collection;
        }

        public Collection<V> remove(@Nullable Object key) {
            Collection<V> collection = LinkedListMultimap.this.removeAll(key);
            return collection.isEmpty() ? null : collection;
        }
    }

    private class AsMapEntries extends AbstractSet<Entry<K, Collection<V>>> {

        /* renamed from: com.google.common.collect.LinkedListMultimap.AsMapEntries.1 */
        class C04901 implements Iterator<Entry<K, Collection<V>>> {
            final /* synthetic */ Iterator val$keyIterator;

            /* renamed from: com.google.common.collect.LinkedListMultimap.AsMapEntries.1.1 */
            class C04891 extends AbstractMapEntry<K, Collection<V>> {
                final /* synthetic */ Object val$key;

                C04891(Object obj) {
                    this.val$key = obj;
                }

                public K getKey() {
                    return this.val$key;
                }

                public Collection<V> getValue() {
                    return LinkedListMultimap.this.get(this.val$key);
                }
            }

            C04901(Iterator it) {
                this.val$keyIterator = it;
            }

            public boolean hasNext() {
                return this.val$keyIterator.hasNext();
            }

            public Entry<K, Collection<V>> next() {
                return new C04891(this.val$keyIterator.next());
            }

            public void remove() {
                this.val$keyIterator.remove();
            }
        }

        private AsMapEntries() {
        }

        public int size() {
            return LinkedListMultimap.this.keyCount.elementSet().size();
        }

        public Iterator<Entry<K, Collection<V>>> iterator() {
            return new C04901(new DistinctKeyIterator(null));
        }
    }

    private class DistinctKeyIterator implements Iterator<K> {
        Node<K, V> current;
        Node<K, V> next;
        final Set<K> seenKeys;

        private DistinctKeyIterator() {
            this.seenKeys = Sets.newHashSetWithExpectedSize(LinkedListMultimap.this.keySet().size());
            this.next = LinkedListMultimap.this.head;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public K next() {
            LinkedListMultimap.checkElement(this.next);
            this.current = this.next;
            this.seenKeys.add(this.current.key);
            do {
                this.next = this.next.next;
                if (this.next == null) {
                    break;
                }
            } while (!this.seenKeys.add(this.next.key));
            return this.current.key;
        }

        public void remove() {
            Preconditions.checkState(this.current != null);
            LinkedListMultimap.this.removeAllNodes(this.current.key);
            this.current = null;
        }
    }

    private class MultisetView extends AbstractCollection<K> implements Multiset<K> {

        /* renamed from: com.google.common.collect.LinkedListMultimap.MultisetView.1 */
        class C04911 implements Iterator<K> {
            final /* synthetic */ Iterator val$nodes;

            C04911(Iterator it) {
                this.val$nodes = it;
            }

            public boolean hasNext() {
                return this.val$nodes.hasNext();
            }

            public K next() {
                return ((Node) this.val$nodes.next()).key;
            }

            public void remove() {
                this.val$nodes.remove();
            }
        }

        /* renamed from: com.google.common.collect.LinkedListMultimap.MultisetView.2 */
        class C04942 extends AbstractSet<Multiset.Entry<K>> {

            /* renamed from: com.google.common.collect.LinkedListMultimap.MultisetView.2.1 */
            class C04931 implements Iterator<Multiset.Entry<K>> {
                final /* synthetic */ Iterator val$keyIterator;

                /* renamed from: com.google.common.collect.LinkedListMultimap.MultisetView.2.1.1 */
                class C04921 extends AbstractEntry<K> {
                    final /* synthetic */ Object val$key;

                    C04921(Object obj) {
                        this.val$key = obj;
                    }

                    public K getElement() {
                        return this.val$key;
                    }

                    public int getCount() {
                        return LinkedListMultimap.this.keyCount.count(this.val$key);
                    }
                }

                C04931(Iterator it) {
                    this.val$keyIterator = it;
                }

                public boolean hasNext() {
                    return this.val$keyIterator.hasNext();
                }

                public Multiset.Entry<K> next() {
                    return new C04921(this.val$keyIterator.next());
                }

                public void remove() {
                    this.val$keyIterator.remove();
                }
            }

            C04942() {
            }

            public int size() {
                return LinkedListMultimap.this.keyCount.elementSet().size();
            }

            public Iterator<Multiset.Entry<K>> iterator() {
                return new C04931(new DistinctKeyIterator(null));
            }
        }

        private MultisetView() {
        }

        public int size() {
            return LinkedListMultimap.this.keyCount.size();
        }

        public Iterator<K> iterator() {
            return new C04911(new NodeIterator());
        }

        public int count(@Nullable Object key) {
            return LinkedListMultimap.this.keyCount.count(key);
        }

        public int add(@Nullable K k, int occurrences) {
            throw new UnsupportedOperationException();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int remove(@javax.annotation.Nullable java.lang.Object r5, int r6) {
            /*
            r4 = this;
            if (r6 < 0) goto L_0x0024;
        L_0x0002:
            r3 = 1;
        L_0x0003:
            com.google.common.base.Preconditions.checkArgument(r3);
            r1 = r4.count(r5);
            r2 = new com.google.common.collect.LinkedListMultimap$ValueForKeyIterator;
            r3 = com.google.common.collect.LinkedListMultimap.this;
            r2.<init>(r5);
            r0 = r6;
        L_0x0012:
            r6 = r0 + -1;
            if (r0 <= 0) goto L_0x0026;
        L_0x0016:
            r3 = r2.hasNext();
            if (r3 == 0) goto L_0x0026;
        L_0x001c:
            r2.next();
            r2.remove();
            r0 = r6;
            goto L_0x0012;
        L_0x0024:
            r3 = 0;
            goto L_0x0003;
        L_0x0026:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.LinkedListMultimap.MultisetView.remove(java.lang.Object, int):int");
        }

        public int setCount(K element, int count) {
            return Multisets.setCountImpl(this, element, count);
        }

        public boolean setCount(K element, int oldCount, int newCount) {
            return Multisets.setCountImpl(this, element, oldCount, newCount);
        }

        public boolean removeAll(Collection<?> c) {
            return Iterators.removeAll(iterator(), c);
        }

        public boolean retainAll(Collection<?> c) {
            return Iterators.retainAll(iterator(), c);
        }

        public Set<K> elementSet() {
            return LinkedListMultimap.this.keySet();
        }

        public Set<Multiset.Entry<K>> entrySet() {
            return new C04942();
        }

        public boolean equals(@Nullable Object object) {
            return LinkedListMultimap.this.keyCount.equals(object);
        }

        public int hashCode() {
            return LinkedListMultimap.this.keyCount.hashCode();
        }

        public String toString() {
            return LinkedListMultimap.this.keyCount.toString();
        }
    }

    private static final class Node<K, V> {
        final K key;
        Node<K, V> next;
        Node<K, V> nextSibling;
        Node<K, V> previous;
        Node<K, V> previousSibling;
        V value;

        Node(@Nullable K key, @Nullable V value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    private class NodeIterator implements ListIterator<Node<K, V>> {
        Node<K, V> current;
        Node<K, V> next;
        int nextIndex;
        Node<K, V> previous;

        NodeIterator() {
            this.next = LinkedListMultimap.this.head;
        }

        NodeIterator(int index) {
            int size = LinkedListMultimap.this.size();
            Preconditions.checkPositionIndex(index, size);
            int index2;
            if (index < size / 2) {
                this.next = LinkedListMultimap.this.head;
                index2 = index;
                while (true) {
                    index = index2 - 1;
                    if (index2 <= 0) {
                        break;
                    }
                    next();
                    index2 = index;
                }
            } else {
                this.previous = LinkedListMultimap.this.tail;
                this.nextIndex = size;
                index2 = index;
                while (true) {
                    index = index2 + 1;
                    if (index2 >= size) {
                        break;
                    }
                    previous();
                    index2 = index;
                }
            }
            this.current = null;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public Node<K, V> next() {
            LinkedListMultimap.checkElement(this.next);
            Node node = this.next;
            this.current = node;
            this.previous = node;
            this.next = this.next.next;
            this.nextIndex++;
            return this.current;
        }

        public void remove() {
            Preconditions.checkState(this.current != null);
            if (this.current != this.next) {
                this.previous = this.current.previous;
                this.nextIndex--;
            } else {
                this.next = this.current.next;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
        }

        public boolean hasPrevious() {
            return this.previous != null;
        }

        public Node<K, V> previous() {
            LinkedListMultimap.checkElement(this.previous);
            Node node = this.previous;
            this.current = node;
            this.next = node;
            this.previous = this.previous.previous;
            this.nextIndex--;
            return this.current;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void set(Node<K, V> node) {
            throw new UnsupportedOperationException();
        }

        public void add(Node<K, V> node) {
            throw new UnsupportedOperationException();
        }

        void setValue(V value) {
            Preconditions.checkState(this.current != null);
            this.current.value = value;
        }
    }

    private class ValueForKeyIterator implements ListIterator<V> {
        Node<K, V> current;
        final Object key;
        Node<K, V> next;
        int nextIndex;
        Node<K, V> previous;

        ValueForKeyIterator(@Nullable Object key) {
            this.key = key;
            this.next = (Node) LinkedListMultimap.this.keyToKeyHead.get(key);
        }

        public ValueForKeyIterator(@Nullable Object key, int index) {
            int size = LinkedListMultimap.this.keyCount.count(key);
            Preconditions.checkPositionIndex(index, size);
            int index2;
            if (index < size / 2) {
                this.next = (Node) LinkedListMultimap.this.keyToKeyHead.get(key);
                index2 = index;
                while (true) {
                    index = index2 - 1;
                    if (index2 <= 0) {
                        break;
                    }
                    next();
                    index2 = index;
                }
            } else {
                this.previous = (Node) LinkedListMultimap.this.keyToKeyTail.get(key);
                this.nextIndex = size;
                index2 = index;
                while (true) {
                    index = index2 + 1;
                    if (index2 >= size) {
                        break;
                    }
                    previous();
                    index2 = index;
                }
            }
            this.key = key;
            this.current = null;
        }

        public boolean hasNext() {
            return this.next != null;
        }

        public V next() {
            LinkedListMultimap.checkElement(this.next);
            Node node = this.next;
            this.current = node;
            this.previous = node;
            this.next = this.next.nextSibling;
            this.nextIndex++;
            return this.current.value;
        }

        public boolean hasPrevious() {
            return this.previous != null;
        }

        public V previous() {
            LinkedListMultimap.checkElement(this.previous);
            Node node = this.previous;
            this.current = node;
            this.next = node;
            this.previous = this.previous.previousSibling;
            this.nextIndex--;
            return this.current.value;
        }

        public int nextIndex() {
            return this.nextIndex;
        }

        public int previousIndex() {
            return this.nextIndex - 1;
        }

        public void remove() {
            Preconditions.checkState(this.current != null);
            if (this.current != this.next) {
                this.previous = this.current.previousSibling;
                this.nextIndex--;
            } else {
                this.next = this.current.nextSibling;
            }
            LinkedListMultimap.this.removeNode(this.current);
            this.current = null;
        }

        public void set(V value) {
            Preconditions.checkState(this.current != null);
            this.current.value = value;
        }

        public void add(V value) {
            this.previous = LinkedListMultimap.this.addNode(this.key, value, this.next);
            this.nextIndex++;
            this.current = null;
        }
    }

    public static <K, V> LinkedListMultimap<K, V> create() {
        return new LinkedListMultimap();
    }

    public static <K, V> LinkedListMultimap<K, V> create(int expectedKeys) {
        return new LinkedListMultimap(expectedKeys);
    }

    public static <K, V> LinkedListMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new LinkedListMultimap((Multimap) multimap);
    }

    LinkedListMultimap() {
        this.keyCount = LinkedHashMultiset.create();
        this.keyToKeyHead = Maps.newHashMap();
        this.keyToKeyTail = Maps.newHashMap();
    }

    private LinkedListMultimap(int expectedKeys) {
        this.keyCount = LinkedHashMultiset.create(expectedKeys);
        this.keyToKeyHead = Maps.newHashMapWithExpectedSize(expectedKeys);
        this.keyToKeyTail = Maps.newHashMapWithExpectedSize(expectedKeys);
    }

    private LinkedListMultimap(Multimap<? extends K, ? extends V> multimap) {
        this(multimap.keySet().size());
        putAll(multimap);
    }

    private Node<K, V> addNode(@Nullable K key, @Nullable V value, @Nullable Node<K, V> nextSibling) {
        Node<K, V> node = new Node(key, value);
        if (this.head == null) {
            this.tail = node;
            this.head = node;
            this.keyToKeyHead.put(key, node);
            this.keyToKeyTail.put(key, node);
        } else if (nextSibling == null) {
            this.tail.next = node;
            node.previous = this.tail;
            Node<K, V> keyTail = (Node) this.keyToKeyTail.get(key);
            if (keyTail == null) {
                this.keyToKeyHead.put(key, node);
            } else {
                keyTail.nextSibling = node;
                node.previousSibling = keyTail;
            }
            this.keyToKeyTail.put(key, node);
            this.tail = node;
        } else {
            node.previous = nextSibling.previous;
            node.previousSibling = nextSibling.previousSibling;
            node.next = nextSibling;
            node.nextSibling = nextSibling;
            if (nextSibling.previousSibling == null) {
                this.keyToKeyHead.put(key, node);
            } else {
                nextSibling.previousSibling.nextSibling = node;
            }
            if (nextSibling.previous == null) {
                this.head = node;
            } else {
                nextSibling.previous.next = node;
            }
            nextSibling.previous = node;
            nextSibling.previousSibling = node;
        }
        this.keyCount.add(key);
        return node;
    }

    private void removeNode(Node<K, V> node) {
        if (node.previous != null) {
            node.previous.next = node.next;
        } else {
            this.head = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        } else {
            this.tail = node.previous;
        }
        if (node.previousSibling != null) {
            node.previousSibling.nextSibling = node.nextSibling;
        } else if (node.nextSibling != null) {
            this.keyToKeyHead.put(node.key, node.nextSibling);
        } else {
            this.keyToKeyHead.remove(node.key);
        }
        if (node.nextSibling != null) {
            node.nextSibling.previousSibling = node.previousSibling;
        } else if (node.previousSibling != null) {
            this.keyToKeyTail.put(node.key, node.previousSibling);
        } else {
            this.keyToKeyTail.remove(node.key);
        }
        this.keyCount.remove(node.key);
    }

    private void removeAllNodes(@Nullable Object key) {
        Iterator<V> i = new ValueForKeyIterator(key);
        while (i.hasNext()) {
            i.next();
            i.remove();
        }
    }

    private static void checkElement(@Nullable Object node) {
        if (node == null) {
            throw new NoSuchElementException();
        }
    }

    public int size() {
        return this.keyCount.size();
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public boolean containsKey(@Nullable Object key) {
        return this.keyToKeyHead.containsKey(key);
    }

    public boolean containsValue(@Nullable Object value) {
        Iterator<Node<K, V>> i = new NodeIterator();
        while (i.hasNext()) {
            if (Objects.equal(((Node) i.next()).value, value)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsEntry(@Nullable Object key, @Nullable Object value) {
        Iterator<V> i = new ValueForKeyIterator(key);
        while (i.hasNext()) {
            if (Objects.equal(i.next(), value)) {
                return true;
            }
        }
        return false;
    }

    public boolean put(@Nullable K key, @Nullable V value) {
        addNode(key, value, null);
        return true;
    }

    public boolean remove(@Nullable Object key, @Nullable Object value) {
        Iterator<V> values = new ValueForKeyIterator(key);
        while (values.hasNext()) {
            if (Objects.equal(values.next(), value)) {
                values.remove();
                return true;
            }
        }
        return false;
    }

    public boolean putAll(@Nullable K key, Iterable<? extends V> values) {
        boolean changed = false;
        for (V value : values) {
            changed |= put(key, value);
        }
        return changed;
    }

    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        boolean changed = false;
        for (Entry<? extends K, ? extends V> entry : multimap.entries()) {
            changed |= put(entry.getKey(), entry.getValue());
        }
        return changed;
    }

    public List<V> replaceValues(@Nullable K key, Iterable<? extends V> values) {
        List<V> oldValues = getCopy(key);
        ListIterator<V> keyValues = new ValueForKeyIterator(key);
        Iterator<? extends V> newValues = values.iterator();
        while (keyValues.hasNext() && newValues.hasNext()) {
            keyValues.next();
            keyValues.set(newValues.next());
        }
        while (keyValues.hasNext()) {
            keyValues.next();
            keyValues.remove();
        }
        while (newValues.hasNext()) {
            keyValues.add(newValues.next());
        }
        return oldValues;
    }

    private List<V> getCopy(@Nullable Object key) {
        return Collections.unmodifiableList(Lists.newArrayList(new ValueForKeyIterator(key)));
    }

    public List<V> removeAll(@Nullable Object key) {
        List<V> oldValues = getCopy(key);
        removeAllNodes(key);
        return oldValues;
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.keyCount.clear();
        this.keyToKeyHead.clear();
        this.keyToKeyTail.clear();
    }

    public List<V> get(@Nullable K key) {
        return new C04811(key);
    }

    public Set<K> keySet() {
        Set<K> result = this.keySet;
        if (result != null) {
            return result;
        }
        result = new C04822();
        this.keySet = result;
        return result;
    }

    public Multiset<K> keys() {
        Multiset<K> result = this.keys;
        if (result != null) {
            return result;
        }
        result = new MultisetView();
        this.keys = result;
        return result;
    }

    public List<V> values() {
        List<V> result = this.valuesList;
        if (result != null) {
            return result;
        }
        result = new C04843();
        this.valuesList = result;
        return result;
    }

    private static <K, V> Entry<K, V> createEntry(Node<K, V> node) {
        return new C04854(node);
    }

    public List<Entry<K, V>> entries() {
        List<Entry<K, V>> result = this.entries;
        if (result != null) {
            return result;
        }
        result = new C04875();
        this.entries = result;
        return result;
    }

    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> result = this.map;
        if (result != null) {
            return result;
        }
        result = new C04886();
        this.map = result;
        return result;
    }

    public boolean equals(@Nullable Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Multimap)) {
            return false;
        }
        return asMap().equals(((Multimap) other).asMap());
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    public String toString() {
        return asMap().toString();
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeInt(size());
        for (Entry<K, V> entry : entries()) {
            stream.writeObject(entry.getKey());
            stream.writeObject(entry.getValue());
        }
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        this.keyCount = LinkedHashMultiset.create();
        this.keyToKeyHead = Maps.newHashMap();
        this.keyToKeyTail = Maps.newHashMap();
        int size = stream.readInt();
        for (int i = 0; i < size; i++) {
            put(stream.readObject(), stream.readObject());
        }
    }
}
