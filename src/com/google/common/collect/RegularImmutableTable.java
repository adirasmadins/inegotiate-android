package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableBiMap.Builder;
import com.google.common.collect.Table.Cell;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
abstract class RegularImmutableTable<R, C, V> extends ImmutableTable<R, C, V> {
    private static final Function<Cell<Object, Object, Object>, Object> GET_VALUE_FUNCTION;
    private final ImmutableSet<Cell<R, C, V>> cellSet;
    @Nullable
    private volatile transient ImmutableList<V> valueList;

    /* renamed from: com.google.common.collect.RegularImmutableTable.1 */
    static class C05961 implements Function<Cell<Object, Object, Object>, Object> {
        C05961() {
        }

        public Object apply(Cell<Object, Object, Object> from) {
            return from.getValue();
        }
    }

    /* renamed from: com.google.common.collect.RegularImmutableTable.2 */
    static class C05972 implements Comparator<Cell<R, C, V>> {
        final /* synthetic */ Comparator val$columnComparator;
        final /* synthetic */ Comparator val$rowComparator;

        C05972(Comparator comparator, Comparator comparator2) {
            this.val$rowComparator = comparator;
            this.val$columnComparator = comparator2;
        }

        public int compare(Cell<R, C, V> cell1, Cell<R, C, V> cell2) {
            int i = 0;
            int rowCompare = this.val$rowComparator == null ? 0 : this.val$rowComparator.compare(cell1.getRowKey(), cell2.getRowKey());
            if (rowCompare != 0) {
                return rowCompare;
            }
            if (this.val$columnComparator != null) {
                i = this.val$columnComparator.compare(cell1.getColumnKey(), cell2.getColumnKey());
            }
            return i;
        }
    }

    @VisibleForTesting
    @Immutable
    static final class DenseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
        private final ImmutableBiMap<C, Integer> columnKeyToIndex;
        private volatile transient ImmutableMap<C, Map<R, V>> columnMap;
        private final ImmutableBiMap<R, Integer> rowKeyToIndex;
        private volatile transient ImmutableMap<R, Map<C, V>> rowMap;
        private final V[][] values;

        public /* bridge */ /* synthetic */ Set cellSet() {
            return super.cellSet();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }

        private static <E> ImmutableBiMap<E, Integer> makeIndex(ImmutableSet<E> set) {
            Builder<E, Integer> indexBuilder = ImmutableBiMap.builder();
            int i = 0;
            Iterator i$ = set.iterator();
            while (i$.hasNext()) {
                indexBuilder.put(i$.next(), Integer.valueOf(i));
                i++;
            }
            return indexBuilder.build();
        }

        DenseImmutableTable(ImmutableSet<Cell<R, C, V>> cellSet, ImmutableSet<R> rowSpace, ImmutableSet<C> columnSpace) {
            super(null);
            this.values = (Object[][]) ((Object[][]) Array.newInstance(Object.class, new int[]{rowSpace.size(), columnSpace.size()}));
            this.rowKeyToIndex = makeIndex(rowSpace);
            this.columnKeyToIndex = makeIndex(columnSpace);
            Iterator i$ = cellSet.iterator();
            while (i$.hasNext()) {
                Cell<R, C, V> cell = (Cell) i$.next();
                R rowKey = cell.getRowKey();
                C columnKey = cell.getColumnKey();
                int rowIndex = ((Integer) this.rowKeyToIndex.get(rowKey)).intValue();
                int columnIndex = ((Integer) this.columnKeyToIndex.get(columnKey)).intValue();
                Preconditions.checkArgument(this.values[rowIndex][columnIndex] == null, "duplicate key: (%s, %s)", rowKey, columnKey);
                this.values[rowIndex][columnIndex] = cell.getValue();
            }
        }

        public ImmutableMap<R, V> column(C columnKey) {
            Preconditions.checkNotNull(columnKey);
            Integer columnIndexInteger = (Integer) this.columnKeyToIndex.get(columnKey);
            if (columnIndexInteger == null) {
                return ImmutableMap.of();
            }
            int columnIndex = columnIndexInteger.intValue();
            ImmutableMap.Builder<R, V> columnBuilder = ImmutableMap.builder();
            for (int i = 0; i < this.values.length; i++) {
                V value = this.values[i][columnIndex];
                if (value != null) {
                    columnBuilder.put(this.rowKeyToIndex.inverse().get(Integer.valueOf(i)), value);
                }
            }
            return columnBuilder.build();
        }

        public ImmutableSet<C> columnKeySet() {
            return this.columnKeyToIndex.keySet();
        }

        private ImmutableMap<C, Map<R, V>> makeColumnMap() {
            ImmutableMap.Builder<C, Map<R, V>> columnMapBuilder = ImmutableMap.builder();
            for (int c = 0; c < this.columnKeyToIndex.size(); c++) {
                ImmutableMap.Builder<R, V> rowMapBuilder = ImmutableMap.builder();
                for (int r = 0; r < this.rowKeyToIndex.size(); r++) {
                    V value = this.values[r][c];
                    if (value != null) {
                        rowMapBuilder.put(this.rowKeyToIndex.inverse().get(Integer.valueOf(r)), value);
                    }
                }
                columnMapBuilder.put(this.columnKeyToIndex.inverse().get(Integer.valueOf(c)), rowMapBuilder.build());
            }
            return columnMapBuilder.build();
        }

        public ImmutableMap<C, Map<R, V>> columnMap() {
            ImmutableMap<C, Map<R, V>> result = this.columnMap;
            if (result != null) {
                return result;
            }
            result = makeColumnMap();
            this.columnMap = result;
            return result;
        }

        public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey) {
            return get(rowKey, columnKey) != null;
        }

        public boolean containsColumn(@Nullable Object columnKey) {
            return this.columnKeyToIndex.containsKey(columnKey);
        }

        public boolean containsRow(@Nullable Object rowKey) {
            return this.rowKeyToIndex.containsKey(rowKey);
        }

        public V get(@Nullable Object rowKey, @Nullable Object columnKey) {
            Integer rowIndex = (Integer) this.rowKeyToIndex.get(rowKey);
            Integer columnIndex = (Integer) this.columnKeyToIndex.get(columnKey);
            return (rowIndex == null || columnIndex == null) ? null : this.values[rowIndex.intValue()][columnIndex.intValue()];
        }

        public ImmutableMap<C, V> row(R rowKey) {
            Preconditions.checkNotNull(rowKey);
            Integer rowIndex = (Integer) this.rowKeyToIndex.get(rowKey);
            if (rowIndex == null) {
                return ImmutableMap.of();
            }
            ImmutableMap.Builder<C, V> rowBuilder = ImmutableMap.builder();
            V[] row = this.values[rowIndex.intValue()];
            for (int r = 0; r < row.length; r++) {
                V value = row[r];
                if (value != null) {
                    rowBuilder.put(this.columnKeyToIndex.inverse().get(Integer.valueOf(r)), value);
                }
            }
            return rowBuilder.build();
        }

        public ImmutableSet<R> rowKeySet() {
            return this.rowKeyToIndex.keySet();
        }

        private ImmutableMap<R, Map<C, V>> makeRowMap() {
            ImmutableMap.Builder<R, Map<C, V>> rowMapBuilder = ImmutableMap.builder();
            for (int r = 0; r < this.values.length; r++) {
                V[] row = this.values[r];
                ImmutableMap.Builder<C, V> columnMapBuilder = ImmutableMap.builder();
                for (int c = 0; c < row.length; c++) {
                    V value = row[c];
                    if (value != null) {
                        columnMapBuilder.put(this.columnKeyToIndex.inverse().get(Integer.valueOf(c)), value);
                    }
                }
                rowMapBuilder.put(this.rowKeyToIndex.inverse().get(Integer.valueOf(r)), columnMapBuilder.build());
            }
            return rowMapBuilder.build();
        }

        public ImmutableMap<R, Map<C, V>> rowMap() {
            ImmutableMap<R, Map<C, V>> result = this.rowMap;
            if (result != null) {
                return result;
            }
            result = makeRowMap();
            this.rowMap = result;
            return result;
        }
    }

    @VisibleForTesting
    @Immutable
    static final class SparseImmutableTable<R, C, V> extends RegularImmutableTable<R, C, V> {
        private final ImmutableMap<C, Map<R, V>> columnMap;
        private final ImmutableMap<R, Map<C, V>> rowMap;

        /* renamed from: com.google.common.collect.RegularImmutableTable.SparseImmutableTable.1 */
        static class C05981 implements Function<ImmutableMap.Builder<B, V>, Map<B, V>> {
            C05981() {
            }

            public Map<B, V> apply(ImmutableMap.Builder<B, V> from) {
                return from.build();
            }
        }

        public /* bridge */ /* synthetic */ Set cellSet() {
            return super.cellSet();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }

        private static final <A, B, V> Map<A, ImmutableMap.Builder<B, V>> makeIndexBuilder(ImmutableSet<A> keySpace) {
            Map<A, ImmutableMap.Builder<B, V>> indexBuilder = Maps.newLinkedHashMap();
            Iterator i$ = keySpace.iterator();
            while (i$.hasNext()) {
                indexBuilder.put(i$.next(), ImmutableMap.builder());
            }
            return indexBuilder;
        }

        private static final <A, B, V> ImmutableMap<A, Map<B, V>> buildIndex(Map<A, ImmutableMap.Builder<B, V>> indexBuilder) {
            return ImmutableMap.copyOf(Maps.transformValues((Map) indexBuilder, new C05981()));
        }

        SparseImmutableTable(ImmutableSet<Cell<R, C, V>> cellSet, ImmutableSet<R> rowSpace, ImmutableSet<C> columnSpace) {
            super(null);
            Map<R, ImmutableMap.Builder<C, V>> rowIndexBuilder = makeIndexBuilder(rowSpace);
            Map<C, ImmutableMap.Builder<R, V>> columnIndexBuilder = makeIndexBuilder(columnSpace);
            Iterator i$ = cellSet.iterator();
            while (i$.hasNext()) {
                Cell<R, C, V> cell = (Cell) i$.next();
                R rowKey = cell.getRowKey();
                C columnKey = cell.getColumnKey();
                V value = cell.getValue();
                ((ImmutableMap.Builder) rowIndexBuilder.get(rowKey)).put(columnKey, value);
                ((ImmutableMap.Builder) columnIndexBuilder.get(columnKey)).put(rowKey, value);
            }
            this.rowMap = buildIndex(rowIndexBuilder);
            this.columnMap = buildIndex(columnIndexBuilder);
        }

        public ImmutableMap<R, V> column(C columnKey) {
            Preconditions.checkNotNull(columnKey);
            return (ImmutableMap) Objects.firstNonNull((ImmutableMap) this.columnMap.get(columnKey), ImmutableMap.of());
        }

        public ImmutableSet<C> columnKeySet() {
            return this.columnMap.keySet();
        }

        public ImmutableMap<C, Map<R, V>> columnMap() {
            return this.columnMap;
        }

        public ImmutableMap<C, V> row(R rowKey) {
            Preconditions.checkNotNull(rowKey);
            return (ImmutableMap) Objects.firstNonNull((ImmutableMap) this.rowMap.get(rowKey), ImmutableMap.of());
        }

        public ImmutableSet<R> rowKeySet() {
            return this.rowMap.keySet();
        }

        public ImmutableMap<R, Map<C, V>> rowMap() {
            return this.rowMap;
        }

        public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey) {
            Map<C, V> row = (Map) this.rowMap.get(rowKey);
            return row != null && row.containsKey(columnKey);
        }

        public boolean containsColumn(@Nullable Object columnKey) {
            return this.columnMap.containsKey(columnKey);
        }

        public boolean containsRow(@Nullable Object rowKey) {
            return this.rowMap.containsKey(rowKey);
        }

        public V get(@Nullable Object rowKey, @Nullable Object columnKey) {
            Map<C, V> row = (Map) this.rowMap.get(rowKey);
            return row == null ? null : row.get(columnKey);
        }
    }

    private RegularImmutableTable(ImmutableSet<Cell<R, C, V>> cellSet) {
        this.cellSet = cellSet;
    }

    static {
        GET_VALUE_FUNCTION = new C05961();
    }

    private Function<Cell<R, C, V>, V> getValueFunction() {
        return GET_VALUE_FUNCTION;
    }

    public final ImmutableCollection<V> values() {
        ImmutableList<V> result = this.valueList;
        if (result != null) {
            return result;
        }
        result = ImmutableList.copyOf(Iterables.transform(cellSet(), getValueFunction()));
        this.valueList = result;
        return result;
    }

    public final int size() {
        return cellSet().size();
    }

    public final boolean containsValue(@Nullable Object value) {
        return values().contains(value);
    }

    public final boolean isEmpty() {
        return false;
    }

    public final ImmutableSet<Cell<R, C, V>> cellSet() {
        return this.cellSet;
    }

    static final <R, C, V> RegularImmutableTable<R, C, V> forCells(List<Cell<R, C, V>> cells, @Nullable Comparator<? super R> rowComparator, @Nullable Comparator<? super C> columnComparator) {
        Preconditions.checkNotNull(cells);
        if (!(rowComparator == null && columnComparator == null)) {
            Collections.sort(cells, new C05972(rowComparator, columnComparator));
        }
        return forCellsInternal(cells, rowComparator, columnComparator);
    }

    static final <R, C, V> RegularImmutableTable<R, C, V> forCells(Iterable<Cell<R, C, V>> cells) {
        return forCellsInternal(cells, null, null);
    }

    private static final <R, C, V> RegularImmutableTable<R, C, V> forCellsInternal(Iterable<Cell<R, C, V>> cells, @Nullable Comparator<? super R> rowComparator, @Nullable Comparator<? super C> columnComparator) {
        ImmutableSet.Builder<Cell<R, C, V>> cellSetBuilder = ImmutableSet.builder();
        ImmutableSet.Builder<R> rowSpaceBuilder = ImmutableSet.builder();
        ImmutableSet.Builder<C> columnSpaceBuilder = ImmutableSet.builder();
        for (Object cell : cells) {
            cellSetBuilder.add(cell);
            rowSpaceBuilder.add(cell.getRowKey());
            columnSpaceBuilder.add(cell.getColumnKey());
        }
        ImmutableSet<Cell<R, C, V>> cellSet = cellSetBuilder.build();
        ImmutableSet<R> rowSpace = rowSpaceBuilder.build();
        if (rowComparator != null) {
            Collection rowList = Lists.newArrayList((Iterable) rowSpace);
            Collections.sort(rowList, rowComparator);
            rowSpace = ImmutableSet.copyOf(rowList);
        }
        ImmutableSet<C> columnSpace = columnSpaceBuilder.build();
        if (columnComparator != null) {
            Collection columnList = Lists.newArrayList((Iterable) columnSpace);
            Collections.sort(columnList, columnComparator);
            columnSpace = ImmutableSet.copyOf(columnList);
        }
        return cellSet.size() > (rowSpace.size() * columnSpace.size()) / 2 ? new DenseImmutableTable(cellSet, rowSpace, columnSpace) : new SparseImmutableTable(cellSet, rowSpace, columnSpace);
    }
}
