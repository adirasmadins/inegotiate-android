package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset.Entry;
import com.google.common.primitives.Ints;
import com.google.gdata.client.spreadsheet.CellQuery;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible(emulated = true)
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    private static final BstAggregate<Node<Object>> DISTINCT_AGGREGATE;
    private static final BstNodeFactory<Node<Object>> NODE_FACTORY;
    private static final BstAggregate<Node<Object>> SIZE_AGGREGATE;
    @GwtIncompatible("not needed in emulated source")
    private static final long serialVersionUID = 1;
    private final transient GeneralRange<E> range;
    private final transient Reference<Node<E>> rootReference;

    /* renamed from: com.google.common.collect.TreeMultiset.1 */
    class C06471 extends AbstractLinkedIterator<BstInOrderPath<Node<E>>> {
        final /* synthetic */ BstSide val$direction;

        C06471(BstInOrderPath x0, BstSide bstSide) {
            this.val$direction = bstSide;
            super(x0);
        }

        protected BstInOrderPath<Node<E>> computeNext(BstInOrderPath<Node<E>> previous) {
            if (!previous.hasNext(this.val$direction)) {
                return null;
            }
            BstInOrderPath<Node<E>> next = previous.next(this.val$direction);
            if (!TreeMultiset.this.range.contains(((Node) next.getTip()).getKey())) {
                next = null;
            }
            return next;
        }
    }

    /* renamed from: com.google.common.collect.TreeMultiset.2 */
    class C06482 implements Iterator<Entry<E>> {
        E toRemove;
        final /* synthetic */ Iterator val$pathIterator;

        C06482(Iterator it) {
            this.val$pathIterator = it;
            this.toRemove = null;
        }

        public boolean hasNext() {
            return this.val$pathIterator.hasNext();
        }

        public Entry<E> next() {
            BstInOrderPath<Node<E>> path = (BstInOrderPath) this.val$pathIterator.next();
            TreeMultiset treeMultiset = TreeMultiset.this;
            Object key = ((Node) path.getTip()).getKey();
            this.toRemove = key;
            return new LiveEntry(key, ((Node) path.getTip()).elemCount(), null);
        }

        public void remove() {
            boolean z;
            if (this.toRemove != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkState(z);
            TreeMultiset.this.setCount(this.toRemove, 0);
            this.toRemove = null;
        }
    }

    /* renamed from: com.google.common.collect.TreeMultiset.3 */
    static class C06493 implements BstAggregate<Node<Object>> {
        C06493() {
        }

        public int entryValue(Node<Object> node) {
            return 1;
        }

        public long treeValue(@Nullable Node<Object> tree) {
            return (long) TreeMultiset.distinctOrZero(tree);
        }
    }

    /* renamed from: com.google.common.collect.TreeMultiset.4 */
    static class C06504 implements BstAggregate<Node<Object>> {
        C06504() {
        }

        public int entryValue(Node<Object> entry) {
            return entry.elemCount();
        }

        public long treeValue(@Nullable Node<Object> tree) {
            return TreeMultiset.sizeOrZero(tree);
        }
    }

    /* renamed from: com.google.common.collect.TreeMultiset.5 */
    static class C06515 extends BstNodeFactory<Node<Object>> {
        C06515() {
        }

        public Node<Object> createNode(Node<Object> source, @Nullable Node<Object> left, @Nullable Node<Object> right) {
            return new Node(source.elemCount(), left, right, null);
        }
    }

    private abstract class MultisetModifier implements BstModifier<E, Node<E>> {
        abstract int newCount(int i);

        private MultisetModifier() {
        }

        @Nullable
        public BstModificationResult<Node<E>> modify(E key, @Nullable Node<E> originalEntry) {
            int oldCount = TreeMultiset.countOrZero(originalEntry);
            int newCount = newCount(oldCount);
            if (oldCount == newCount) {
                return BstModificationResult.identity(originalEntry);
            }
            if (newCount == 0) {
                return BstModificationResult.rebalancingChange(originalEntry, null);
            }
            if (oldCount == 0) {
                return BstModificationResult.rebalancingChange(null, new Node(newCount, null));
            }
            return BstModificationResult.rebuildingChange(originalEntry, new Node(newCount, null));
        }
    }

    private final class AddModifier extends MultisetModifier {
        private final int countToAdd;

        private AddModifier(int countToAdd) {
            super(null);
            Preconditions.checkArgument(countToAdd > 0);
            this.countToAdd = countToAdd;
        }

        int newCount(int oldCount) {
            Preconditions.checkArgument(this.countToAdd <= Integer.MAX_VALUE - oldCount, "Cannot add this many elements");
            return this.countToAdd + oldCount;
        }
    }

    private final class ConditionalSetCountModifier extends MultisetModifier {
        private final int expectedCount;
        private final int setCount;
        final /* synthetic */ TreeMultiset this$0;

        private ConditionalSetCountModifier(TreeMultiset treeMultiset, int expectedCount, int setCount) {
            int i;
            int i2 = 1;
            this.this$0 = treeMultiset;
            super(null);
            if (setCount >= 0) {
                i = 1;
            } else {
                i = 0;
            }
            if (expectedCount < 0) {
                i2 = 0;
            }
            Preconditions.checkArgument(i2 & i);
            this.expectedCount = expectedCount;
            this.setCount = setCount;
        }

        int newCount(int oldCount) {
            return oldCount == this.expectedCount ? this.setCount : oldCount;
        }
    }

    class LiveEntry extends AbstractEntry<E> {
        private int count;
        private final E element;
        private Node<E> expectedRoot;

        private LiveEntry(E element, int count) {
            this.expectedRoot = (Node) TreeMultiset.this.rootReference.get();
            this.element = element;
            this.count = count;
        }

        public E getElement() {
            return this.element;
        }

        public int getCount() {
            if (TreeMultiset.this.rootReference.get() == this.expectedRoot) {
                return this.count;
            }
            this.expectedRoot = (Node) TreeMultiset.this.rootReference.get();
            int count = TreeMultiset.this.count(this.element);
            this.count = count;
            return count;
        }
    }

    private static final class Node<E> extends BstNode<E, Node<E>> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int distinct;
        private final long size;

        private Node(E key, int elemCount, @Nullable Node<E> left, @Nullable Node<E> right) {
            super(key, left, right);
            Preconditions.checkArgument(elemCount > 0);
            this.size = (((long) elemCount) + TreeMultiset.sizeOrZero(left)) + TreeMultiset.sizeOrZero(right);
            this.distinct = (TreeMultiset.distinctOrZero(left) + 1) + TreeMultiset.distinctOrZero(right);
        }

        int elemCount() {
            return Ints.checkedCast((this.size - TreeMultiset.sizeOrZero((Node) childOrNull(BstSide.LEFT))) - TreeMultiset.sizeOrZero((Node) childOrNull(BstSide.RIGHT)));
        }

        private Node(E key, int elemCount) {
            this(key, elemCount, null, null);
        }
    }

    static final class Reference<T> {
        T value;

        public T get() {
            return this.value;
        }

        public boolean compareAndSet(T expected, T newValue) {
            if (this.value != expected) {
                return false;
            }
            this.value = newValue;
            return true;
        }
    }

    private final class RemoveModifier extends MultisetModifier {
        private final int countToRemove;

        private RemoveModifier(int countToRemove) {
            super(null);
            Preconditions.checkArgument(countToRemove > 0);
            this.countToRemove = countToRemove;
        }

        int newCount(int oldCount) {
            return Math.max(0, oldCount - this.countToRemove);
        }
    }

    private final class SetCountModifier extends MultisetModifier {
        private final int countToSet;

        private SetCountModifier(int countToSet) {
            super(null);
            Preconditions.checkArgument(countToSet >= 0);
            this.countToSet = countToSet;
        }

        int newCount(int oldCount) {
            return this.countToSet;
        }
    }

    public /* bridge */ /* synthetic */ boolean add(Object x0) {
        return super.add(x0);
    }

    public /* bridge */ /* synthetic */ boolean addAll(Collection x0) {
        return super.addAll(x0);
    }

    public /* bridge */ /* synthetic */ boolean contains(Object x0) {
        return super.contains(x0);
    }

    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    public /* bridge */ /* synthetic */ SortedSet elementSet() {
        return super.elementSet();
    }

    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public /* bridge */ /* synthetic */ boolean equals(Object x0) {
        return super.equals(x0);
    }

    public /* bridge */ /* synthetic */ Entry firstEntry() {
        return super.firstEntry();
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public /* bridge */ /* synthetic */ Entry lastEntry() {
        return super.lastEntry();
    }

    public /* bridge */ /* synthetic */ Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    public /* bridge */ /* synthetic */ Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    public /* bridge */ /* synthetic */ boolean remove(Object x0) {
        return super.remove(x0);
    }

    public /* bridge */ /* synthetic */ boolean removeAll(Collection x0) {
        return super.removeAll(x0);
    }

    public /* bridge */ /* synthetic */ boolean retainAll(Collection x0) {
        return super.retainAll(x0);
    }

    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object x0, BoundType x1, Object x2, BoundType x3) {
        return super.subMultiset(x0, x1, x2, x3);
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset(Ordering.natural());
    }

    public static <E> TreeMultiset<E> create(@Nullable Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset(Ordering.natural()) : new TreeMultiset(comparator);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> elements) {
        TreeMultiset<E> multiset = create();
        Iterables.addAll(multiset, elements);
        return multiset;
    }

    public Iterator<E> iterator() {
        return super.iterator();
    }

    private TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        this.rootReference = new Reference();
    }

    private TreeMultiset(GeneralRange<E> range, Reference<Node<E>> root) {
        super(range.comparator());
        this.range = range;
        this.rootReference = root;
    }

    E checkElement(Object o) {
        return o;
    }

    int distinctElements() {
        return Ints.checkedCast(BstRangeOps.totalInRange(distinctAggregate(), this.range, (Node) this.rootReference.get()));
    }

    public int size() {
        return Ints.saturatedCast(BstRangeOps.totalInRange(sizeAggregate(), this.range, (Node) this.rootReference.get()));
    }

    public int count(@Nullable Object element) {
        try {
            E e = checkElement(element);
            if (this.range.contains(e)) {
                return countOrZero((Node) BstOperations.seek(comparator(), (BstNode) this.rootReference.get(), e));
            }
            return 0;
        } catch (ClassCastException e2) {
            return 0;
        } catch (NullPointerException e3) {
            return 0;
        }
    }

    private int mutate(@Nullable E e, MultisetModifier modifier) {
        BstMutationResult<E, Node<E>> mutationResult = BstOperations.mutate(comparator(), BstMutationRule.createRule(modifier, BstCountBasedBalancePolicies.singleRebalancePolicy(distinctAggregate()), nodeFactory()), (BstNode) this.rootReference.get(), e);
        if (this.rootReference.compareAndSet(mutationResult.getOriginalRoot(), mutationResult.getChangedRoot())) {
            return countOrZero((Node) mutationResult.getOriginalTarget());
        }
        throw new ConcurrentModificationException();
    }

    public int add(E element, int occurrences) {
        checkElement(element);
        if (occurrences == 0) {
            return count(element);
        }
        Preconditions.checkArgument(this.range.contains(element));
        return mutate(element, new AddModifier(occurrences, null));
    }

    public int remove(@Nullable Object element, int occurrences) {
        if (element == null) {
            return 0;
        }
        if (occurrences == 0) {
            return count(element);
        }
        try {
            E e = checkElement(element);
            if (this.range.contains(e)) {
                return mutate(e, new RemoveModifier(occurrences, null));
            }
            return 0;
        } catch (ClassCastException e2) {
            return 0;
        }
    }

    public boolean setCount(E element, int oldCount, int newCount) {
        checkElement(element);
        Preconditions.checkArgument(this.range.contains(element));
        return mutate(element, new ConditionalSetCountModifier(oldCount, newCount, null)) == oldCount;
    }

    public int setCount(E element, int count) {
        checkElement(element);
        Preconditions.checkArgument(this.range.contains(element));
        return mutate(element, new SetCountModifier(count, null));
    }

    private BstPathFactory<Node<E>, BstInOrderPath<Node<E>>> pathFactory() {
        return BstInOrderPath.inOrderFactory();
    }

    Iterator<Entry<E>> entryIterator() {
        return iteratorInDirection((BstInOrderPath) BstRangeOps.furthestPath(this.range, BstSide.LEFT, pathFactory(), (Node) this.rootReference.get()), BstSide.RIGHT);
    }

    Iterator<Entry<E>> descendingEntryIterator() {
        return iteratorInDirection((BstInOrderPath) BstRangeOps.furthestPath(this.range, BstSide.RIGHT, pathFactory(), (Node) this.rootReference.get()), BstSide.LEFT);
    }

    private Iterator<Entry<E>> iteratorInDirection(@Nullable BstInOrderPath<Node<E>> start, BstSide direction) {
        return new C06482(new C06471(start, direction));
    }

    public void clear() {
        Node<E> root = (Node) this.rootReference.get();
        if (!this.rootReference.compareAndSet(root, (Node) BstRangeOps.minusRange(this.range, BstCountBasedBalancePolicies.fullRebalancePolicy(distinctAggregate()), nodeFactory(), root))) {
            throw new ConcurrentModificationException();
        }
    }

    public SortedMultiset<E> headMultiset(E upperBound, BoundType boundType) {
        Preconditions.checkNotNull(upperBound);
        return new TreeMultiset(this.range.intersect(GeneralRange.upTo(this.comparator, upperBound, boundType)), this.rootReference);
    }

    public SortedMultiset<E> tailMultiset(E lowerBound, BoundType boundType) {
        Preconditions.checkNotNull(lowerBound);
        return new TreeMultiset(this.range.intersect(GeneralRange.downTo(this.comparator, lowerBound, boundType)), this.rootReference);
    }

    public Comparator<? super E> comparator() {
        return super.comparator();
    }

    private static long sizeOrZero(@Nullable Node<?> node) {
        return node == null ? 0 : node.size;
    }

    private static int distinctOrZero(@Nullable Node<?> node) {
        return node == null ? 0 : node.distinct;
    }

    private static int countOrZero(@Nullable Node<?> entry) {
        return entry == null ? 0 : entry.elemCount();
    }

    private BstAggregate<Node<E>> distinctAggregate() {
        return DISTINCT_AGGREGATE;
    }

    static {
        DISTINCT_AGGREGATE = new C06493();
        SIZE_AGGREGATE = new C06504();
        NODE_FACTORY = new C06515();
    }

    private BstAggregate<Node<E>> sizeAggregate() {
        return SIZE_AGGREGATE;
    }

    private BstNodeFactory<Node<E>> nodeFactory() {
        return NODE_FACTORY;
    }

    @GwtIncompatible("java.io.ObjectOutputStream")
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        stream.writeObject(elementSet().comparator());
        Serialization.writeMultiset(this, stream);
    }

    @GwtIncompatible("java.io.ObjectInputStream")
    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        Object comparator = (Comparator) stream.readObject();
        Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set((Object) this, comparator);
        Serialization.getFieldSetter(TreeMultiset.class, CellQuery.RANGE).set((Object) this, GeneralRange.all(comparator));
        Serialization.getFieldSetter(TreeMultiset.class, "rootReference").set((Object) this, new Reference());
        Serialization.populateMultiset(this, stream);
    }
}
