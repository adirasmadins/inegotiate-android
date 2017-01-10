package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList.Builder;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@GwtCompatible(serializable = true)
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableList<Comparator<? super T>> comparators;

    CompoundOrdering(Comparator<? super T> primary, Comparator<? super T> secondary) {
        this.comparators = ImmutableList.of(primary, secondary);
    }

    CompoundOrdering(Iterable<? extends Comparator<? super T>> comparators) {
        this.comparators = ImmutableList.copyOf((Iterable) comparators);
    }

    CompoundOrdering(List<? extends Comparator<? super T>> comparators, Comparator<? super T> lastComparator) {
        this.comparators = new Builder().addAll((Iterable) comparators).add((Object) lastComparator).build();
    }

    public int compare(T left, T right) {
        Iterator i$ = this.comparators.iterator();
        while (i$.hasNext()) {
            int result = ((Comparator) i$.next()).compare(left, right);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof CompoundOrdering)) {
            return false;
        }
        return this.comparators.equals(((CompoundOrdering) object).comparators);
    }

    public int hashCode() {
        return this.comparators.hashCode();
    }

    public String toString() {
        return "Ordering.compound(" + this.comparators + ")";
    }
}
