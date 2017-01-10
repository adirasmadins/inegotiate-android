package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.Table.Cell;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
public final class ArrayTable<R, C, V> implements Table<R, C, V>, Serializable {
    private static final long serialVersionUID = 0;
    private final V[][] array;
    private transient CellSet cellSet;
    private final ImmutableMap<C, Integer> columnKeyToIndex;
    private final ImmutableList<C> columnList;
    private transient ColumnMap columnMap;
    private final ImmutableMap<R, Integer> rowKeyToIndex;
    private final ImmutableList<R> rowList;
    private transient RowMap rowMap;
    private transient Collection<V> values;

    private class CellSet extends AbstractSet<Cell<R, C, V>> {

        /* renamed from: com.google.common.collect.ArrayTable.CellSet.1 */
        class C04171 extends AbstractIndexedListIterator<Cell<R, C, V>> {

            /* renamed from: com.google.common.collect.ArrayTable.CellSet.1.1 */
            class C04161 extends AbstractCell<R, C, V> {
                final int columnIndex;
                final int rowIndex;
                final /* synthetic */ int val$index;

                C04161(int i) {
                    this.val$index = i;
                    this.rowIndex = this.val$index / ArrayTable.this.columnList.size();
                    this.columnIndex = this.val$index % ArrayTable.this.columnList.size();
                }

                public R getRowKey() {
                    return ArrayTable.this.rowList.get(this.rowIndex);
                }

                public C getColumnKey() {
                    return ArrayTable.this.columnList.get(this.columnIndex);
                }

                public V getValue() {
                    return ArrayTable.this.array[this.rowIndex][this.columnIndex];
                }
            }

            C04171(int x0) {
                super(x0);
            }

            protected Cell<R, C, V> get(int index) {
                return new C04161(index);
            }
        }

        private CellSet() {
        }

        public Iterator<Cell<R, C, V>> iterator() {
            return new C04171(size());
        }

        public int size() {
            return ArrayTable.this.size();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Cell)) {
                return false;
            }
            Cell<?, ?, ?> cell = (Cell) obj;
            Integer rowIndex = (Integer) ArrayTable.this.rowKeyToIndex.get(cell.getRowKey());
            Integer columnIndex = (Integer) ArrayTable.this.columnKeyToIndex.get(cell.getColumnKey());
            if (rowIndex == null || columnIndex == null || !Objects.equal(ArrayTable.this.array[rowIndex.intValue()][columnIndex.intValue()], cell.getValue())) {
                return false;
            }
            return true;
        }
    }

    private class Column extends AbstractMap<R, V> {
        final int columnIndex;
        ColumnEntrySet entrySet;

        Column(int columnIndex) {
            this.columnIndex = columnIndex;
        }

        public Set<Entry<R, V>> entrySet() {
            Set<Entry<R, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set columnEntrySet = new ColumnEntrySet(this.columnIndex);
            this.entrySet = columnEntrySet;
            return columnEntrySet;
        }

        public V get(Object rowKey) {
            return ArrayTable.this.getIndexed((Integer) ArrayTable.this.rowKeyToIndex.get(rowKey), Integer.valueOf(this.columnIndex));
        }

        public boolean containsKey(Object rowKey) {
            return ArrayTable.this.rowKeyToIndex.containsKey(rowKey);
        }

        public V put(R rowKey, V value) {
            boolean z;
            Preconditions.checkNotNull(rowKey);
            Integer rowIndex = (Integer) ArrayTable.this.rowKeyToIndex.get(rowKey);
            if (rowIndex != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Row %s not in %s", rowKey, ArrayTable.this.rowList);
            return ArrayTable.this.set(rowIndex.intValue(), this.columnIndex, value);
        }

        public Set<R> keySet() {
            return ArrayTable.this.rowKeySet();
        }
    }

    private class ColumnEntrySet extends AbstractSet<Entry<R, V>> {
        final int columnIndex;

        /* renamed from: com.google.common.collect.ArrayTable.ColumnEntrySet.1 */
        class C04191 extends AbstractIndexedListIterator<Entry<R, V>> {

            /* renamed from: com.google.common.collect.ArrayTable.ColumnEntrySet.1.1 */
            class C04181 extends AbstractMapEntry<R, V> {
                final /* synthetic */ int val$rowIndex;

                C04181(int i) {
                    this.val$rowIndex = i;
                }

                public R getKey() {
                    return ArrayTable.this.rowList.get(this.val$rowIndex);
                }

                public V getValue() {
                    return ArrayTable.this.array[this.val$rowIndex][ColumnEntrySet.this.columnIndex];
                }

                public V setValue(V value) {
                    return ArrayTable.this.set(this.val$rowIndex, ColumnEntrySet.this.columnIndex, value);
                }
            }

            C04191(int x0) {
                super(x0);
            }

            protected Entry<R, V> get(int rowIndex) {
                return new C04181(rowIndex);
            }
        }

        ColumnEntrySet(int columnIndex) {
            this.columnIndex = columnIndex;
        }

        public Iterator<Entry<R, V>> iterator() {
            return new C04191(size());
        }

        public int size() {
            return ArrayTable.this.rowList.size();
        }
    }

    private class ColumnMap extends AbstractMap<C, Map<R, V>> {
        transient ColumnMapEntrySet entrySet;

        private ColumnMap() {
        }

        public Set<Entry<C, Map<R, V>>> entrySet() {
            Set<Entry<C, Map<R, V>>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set columnMapEntrySet = new ColumnMapEntrySet(null);
            this.entrySet = columnMapEntrySet;
            return columnMapEntrySet;
        }

        public Map<R, V> get(Object columnKey) {
            Integer columnIndex = (Integer) ArrayTable.this.columnKeyToIndex.get(columnKey);
            return columnIndex == null ? null : new Column(columnIndex.intValue());
        }

        public boolean containsKey(Object columnKey) {
            return ArrayTable.this.containsColumn(columnKey);
        }

        public Set<C> keySet() {
            return ArrayTable.this.columnKeySet();
        }

        public Map<R, V> remove(Object columnKey) {
            throw new UnsupportedOperationException();
        }
    }

    private class ColumnMapEntrySet extends AbstractSet<Entry<C, Map<R, V>>> {

        /* renamed from: com.google.common.collect.ArrayTable.ColumnMapEntrySet.1 */
        class C04201 extends AbstractIndexedListIterator<Entry<C, Map<R, V>>> {
            C04201(int x0) {
                super(x0);
            }

            protected Entry<C, Map<R, V>> get(int index) {
                return Maps.immutableEntry(ArrayTable.this.columnList.get(index), new Column(index));
            }
        }

        private ColumnMapEntrySet() {
        }

        public Iterator<Entry<C, Map<R, V>>> iterator() {
            return new C04201(size());
        }

        public int size() {
            return ArrayTable.this.columnList.size();
        }
    }

    private class Row extends AbstractMap<C, V> {
        RowEntrySet entrySet;
        final int rowIndex;

        Row(int rowIndex) {
            this.rowIndex = rowIndex;
        }

        public Set<Entry<C, V>> entrySet() {
            Set<Entry<C, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set rowEntrySet = new RowEntrySet(this.rowIndex);
            this.entrySet = rowEntrySet;
            return rowEntrySet;
        }

        public V get(Object columnKey) {
            return ArrayTable.this.getIndexed(Integer.valueOf(this.rowIndex), (Integer) ArrayTable.this.columnKeyToIndex.get(columnKey));
        }

        public boolean containsKey(Object columnKey) {
            return ArrayTable.this.containsColumn(columnKey);
        }

        public V put(C columnKey, V value) {
            boolean z;
            Preconditions.checkNotNull(columnKey);
            Integer columnIndex = (Integer) ArrayTable.this.columnKeyToIndex.get(columnKey);
            if (columnIndex != null) {
                z = true;
            } else {
                z = false;
            }
            Preconditions.checkArgument(z, "Column %s not in %s", columnKey, ArrayTable.this.columnList);
            return ArrayTable.this.set(this.rowIndex, columnIndex.intValue(), value);
        }

        public Set<C> keySet() {
            return ArrayTable.this.columnKeySet();
        }
    }

    private class RowEntrySet extends AbstractSet<Entry<C, V>> {
        final int rowIndex;

        /* renamed from: com.google.common.collect.ArrayTable.RowEntrySet.1 */
        class C04221 extends AbstractIndexedListIterator<Entry<C, V>> {

            /* renamed from: com.google.common.collect.ArrayTable.RowEntrySet.1.1 */
            class C04211 extends AbstractMapEntry<C, V> {
                final /* synthetic */ int val$columnIndex;

                C04211(int i) {
                    this.val$columnIndex = i;
                }

                public C getKey() {
                    return ArrayTable.this.columnList.get(this.val$columnIndex);
                }

                public V getValue() {
                    return ArrayTable.this.array[RowEntrySet.this.rowIndex][this.val$columnIndex];
                }

                public V setValue(V value) {
                    return ArrayTable.this.set(RowEntrySet.this.rowIndex, this.val$columnIndex, value);
                }
            }

            C04221(int x0) {
                super(x0);
            }

            protected Entry<C, V> get(int columnIndex) {
                return new C04211(columnIndex);
            }
        }

        RowEntrySet(int rowIndex) {
            this.rowIndex = rowIndex;
        }

        public Iterator<Entry<C, V>> iterator() {
            return new C04221(size());
        }

        public int size() {
            return ArrayTable.this.columnList.size();
        }
    }

    private class RowMap extends AbstractMap<R, Map<C, V>> {
        transient RowMapEntrySet entrySet;

        private RowMap() {
        }

        public Set<Entry<R, Map<C, V>>> entrySet() {
            Set<Entry<R, Map<C, V>>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            Set rowMapEntrySet = new RowMapEntrySet(null);
            this.entrySet = rowMapEntrySet;
            return rowMapEntrySet;
        }

        public Map<C, V> get(Object rowKey) {
            Integer rowIndex = (Integer) ArrayTable.this.rowKeyToIndex.get(rowKey);
            return rowIndex == null ? null : new Row(rowIndex.intValue());
        }

        public boolean containsKey(Object rowKey) {
            return ArrayTable.this.containsRow(rowKey);
        }

        public Set<R> keySet() {
            return ArrayTable.this.rowKeySet();
        }

        public Map<C, V> remove(Object rowKey) {
            throw new UnsupportedOperationException();
        }
    }

    private class RowMapEntrySet extends AbstractSet<Entry<R, Map<C, V>>> {

        /* renamed from: com.google.common.collect.ArrayTable.RowMapEntrySet.1 */
        class C04231 extends AbstractIndexedListIterator<Entry<R, Map<C, V>>> {
            C04231(int x0) {
                super(x0);
            }

            protected Entry<R, Map<C, V>> get(int index) {
                return Maps.immutableEntry(ArrayTable.this.rowList.get(index), new Row(index));
            }
        }

        private RowMapEntrySet() {
        }

        public Iterator<Entry<R, Map<C, V>>> iterator() {
            return new C04231(size());
        }

        public int size() {
            return ArrayTable.this.rowList.size();
        }
    }

    private class Values extends AbstractCollection<V> {

        /* renamed from: com.google.common.collect.ArrayTable.Values.1 */
        class C04241 extends AbstractIndexedListIterator<V> {
            C04241(int x0) {
                super(x0);
            }

            protected V get(int index) {
                return ArrayTable.this.array[index / ArrayTable.this.columnList.size()][index % ArrayTable.this.columnList.size()];
            }
        }

        private Values() {
        }

        public Iterator<V> iterator() {
            return new C04241(size());
        }

        public int size() {
            return ArrayTable.this.size();
        }

        public boolean contains(Object value) {
            return ArrayTable.this.containsValue(value);
        }
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> rowKeys, Iterable<? extends C> columnKeys) {
        return new ArrayTable(rowKeys, columnKeys);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table) {
        return new ArrayTable((Table) table);
    }

    public static <R, C, V> ArrayTable<R, C, V> create(ArrayTable<R, C, V> table) {
        return new ArrayTable((ArrayTable) table);
    }

    private ArrayTable(Iterable<? extends R> rowKeys, Iterable<? extends C> columnKeys) {
        boolean z;
        int i;
        boolean z2 = true;
        this.rowList = ImmutableList.copyOf((Iterable) rowKeys);
        this.columnList = ImmutableList.copyOf((Iterable) columnKeys);
        if (this.rowList.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (this.columnList.isEmpty()) {
            z2 = false;
        }
        Preconditions.checkArgument(z2);
        Builder<R, Integer> rowBuilder = ImmutableMap.builder();
        for (i = 0; i < this.rowList.size(); i++) {
            rowBuilder.put(this.rowList.get(i), Integer.valueOf(i));
        }
        this.rowKeyToIndex = rowBuilder.build();
        Builder<C, Integer> columnBuilder = ImmutableMap.builder();
        for (i = 0; i < this.columnList.size(); i++) {
            columnBuilder.put(this.columnList.get(i), Integer.valueOf(i));
        }
        this.columnKeyToIndex = columnBuilder.build();
        this.array = (Object[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{this.rowList.size(), this.columnList.size()}));
    }

    private ArrayTable(Table<R, C, V> table) {
        this(table.rowKeySet(), table.columnKeySet());
        putAll(table);
    }

    private ArrayTable(ArrayTable<R, C, V> table) {
        this.rowList = table.rowList;
        this.columnList = table.columnList;
        this.rowKeyToIndex = table.rowKeyToIndex;
        this.columnKeyToIndex = table.columnKeyToIndex;
        Object[][] copy = (Object[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{this.rowList.size(), this.columnList.size()}));
        this.array = copy;
        for (int i = 0; i < this.rowList.size(); i++) {
            System.arraycopy(table.array[i], 0, copy[i], 0, table.array[i].length);
        }
    }

    public ImmutableList<R> rowKeyList() {
        return this.rowList;
    }

    public ImmutableList<C> columnKeyList() {
        return this.columnList;
    }

    public V at(int rowIndex, int columnIndex) {
        return this.array[rowIndex][columnIndex];
    }

    public V set(int rowIndex, int columnIndex, @Nullable V value) {
        V oldValue = this.array[rowIndex][columnIndex];
        this.array[rowIndex][columnIndex] = value;
        return oldValue;
    }

    public V[][] toArray(Class<V> valueClass) {
        Object[][] copy = (Object[][]) ((Object[][]) Array.newInstance(valueClass, new int[]{this.rowList.size(), this.columnList.size()}));
        for (int i = 0; i < this.rowList.size(); i++) {
            System.arraycopy(this.array[i], 0, copy[i], 0, this.array[i].length);
        }
        return copy;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    public void eraseAll() {
        for (V[] row : this.array) {
            Arrays.fill(row, null);
        }
    }

    public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey) {
        return containsRow(rowKey) && containsColumn(columnKey);
    }

    public boolean containsColumn(@Nullable Object columnKey) {
        return this.columnKeyToIndex.containsKey(columnKey);
    }

    public boolean containsRow(@Nullable Object rowKey) {
        return this.rowKeyToIndex.containsKey(rowKey);
    }

    public boolean containsValue(@Nullable Object value) {
        for (V[] arr$ : this.array) {
            for (V element : r0[r4]) {
                if (Objects.equal(value, element)) {
                    return true;
                }
            }
        }
        return false;
    }

    public V get(@Nullable Object rowKey, @Nullable Object columnKey) {
        return getIndexed((Integer) this.rowKeyToIndex.get(rowKey), (Integer) this.columnKeyToIndex.get(columnKey));
    }

    private V getIndexed(Integer rowIndex, Integer columnIndex) {
        return (rowIndex == null || columnIndex == null) ? null : this.array[rowIndex.intValue()][columnIndex.intValue()];
    }

    public boolean isEmpty() {
        return false;
    }

    public V put(R rowKey, C columnKey, @Nullable V value) {
        boolean z;
        Preconditions.checkNotNull(rowKey);
        Preconditions.checkNotNull(columnKey);
        Integer rowIndex = (Integer) this.rowKeyToIndex.get(rowKey);
        if (rowIndex != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Row %s not in %s", rowKey, this.rowList);
        Integer columnIndex = (Integer) this.columnKeyToIndex.get(columnKey);
        if (columnIndex != null) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Column %s not in %s", columnKey, this.columnList);
        return set(rowIndex.intValue(), columnIndex.intValue(), value);
    }

    public void putAll(Table<? extends R, ? extends C, ? extends V> table) {
        for (Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
            put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
        }
    }

    @Deprecated
    public V remove(Object rowKey, Object columnKey) {
        throw new UnsupportedOperationException();
    }

    public V erase(@Nullable Object rowKey, @Nullable Object columnKey) {
        Integer rowIndex = (Integer) this.rowKeyToIndex.get(rowKey);
        Integer columnIndex = (Integer) this.columnKeyToIndex.get(columnKey);
        if (rowIndex == null || columnIndex == null) {
            return null;
        }
        return set(rowIndex.intValue(), columnIndex.intValue(), null);
    }

    public int size() {
        return this.rowList.size() * this.columnList.size();
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Table)) {
            return false;
        }
        return cellSet().equals(((Table) obj).cellSet());
    }

    public int hashCode() {
        return cellSet().hashCode();
    }

    public String toString() {
        return rowMap().toString();
    }

    public Set<Cell<R, C, V>> cellSet() {
        Set<Cell<R, C, V>> set = this.cellSet;
        if (set != null) {
            return set;
        }
        Set cellSet = new CellSet();
        this.cellSet = cellSet;
        return cellSet;
    }

    public Map<R, V> column(C columnKey) {
        Preconditions.checkNotNull(columnKey);
        Integer columnIndex = (Integer) this.columnKeyToIndex.get(columnKey);
        return columnIndex == null ? ImmutableMap.of() : new Column(columnIndex.intValue());
    }

    public ImmutableSet<C> columnKeySet() {
        return this.columnKeyToIndex.keySet();
    }

    public Map<C, Map<R, V>> columnMap() {
        Map<C, Map<R, V>> map = this.columnMap;
        if (map != null) {
            return map;
        }
        Map columnMap = new ColumnMap();
        this.columnMap = columnMap;
        return columnMap;
    }

    public Map<C, V> row(R rowKey) {
        Preconditions.checkNotNull(rowKey);
        Integer rowIndex = (Integer) this.rowKeyToIndex.get(rowKey);
        return rowIndex == null ? ImmutableMap.of() : new Row(rowIndex.intValue());
    }

    public ImmutableSet<R> rowKeySet() {
        return this.rowKeyToIndex.keySet();
    }

    public Map<R, Map<C, V>> rowMap() {
        Map<R, Map<C, V>> map = this.rowMap;
        if (map != null) {
            return map;
        }
        Map rowMap = new RowMap();
        this.rowMap = rowMap;
        return rowMap;
    }

    public Collection<V> values() {
        Collection<V> collection = this.values;
        if (collection != null) {
            return collection;
        }
        collection = new Values();
        this.values = collection;
        return collection;
    }
}
