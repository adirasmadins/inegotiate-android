package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Equivalences;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.concurrent.ConcurrentMap;

@Beta
public final class Interners {

    /* renamed from: com.google.common.collect.Interners.1 */
    static class C04581 implements Interner<E> {
        final /* synthetic */ ConcurrentMap val$map;

        C04581(ConcurrentMap concurrentMap) {
            this.val$map = concurrentMap;
        }

        public E intern(E sample) {
            E canonical = this.val$map.putIfAbsent(Preconditions.checkNotNull(sample), sample);
            return canonical == null ? sample : canonical;
        }
    }

    private static class CustomInterner<E> implements Interner<E> {
        private final MapMakerInternalMap<E, Dummy> map;

        private enum Dummy {
            VALUE
        }

        CustomInterner(GenericMapMaker<? super E, Object> mm) {
            this.map = mm.strongValues().keyEquivalence(Equivalences.equals()).makeCustomMap();
        }

        public E intern(E sample) {
            do {
                ReferenceEntry<E, Dummy> entry = this.map.getEntry(sample);
                if (entry != null) {
                    E canonical = entry.getKey();
                    if (canonical != null) {
                        return canonical;
                    }
                }
            } while (((Dummy) this.map.putIfAbsent(sample, Dummy.VALUE)) != null);
            return sample;
        }
    }

    private static class InternerFunction<E> implements Function<E, E> {
        private final Interner<E> interner;

        public InternerFunction(Interner<E> interner) {
            this.interner = interner;
        }

        public E apply(E input) {
            return this.interner.intern(input);
        }

        public int hashCode() {
            return this.interner.hashCode();
        }

        public boolean equals(Object other) {
            if (!(other instanceof InternerFunction)) {
                return false;
            }
            return this.interner.equals(((InternerFunction) other).interner);
        }
    }

    private Interners() {
    }

    public static <E> Interner<E> newStrongInterner() {
        return new C04581(new MapMaker().makeMap());
    }

    @GwtIncompatible("java.lang.ref.WeakReference")
    public static <E> Interner<E> newWeakInterner() {
        return new CustomInterner(new MapMaker().weakKeys());
    }

    public static <E> Function<E, E> asFunction(Interner<E> interner) {
        return new InternerFunction((Interner) Preconditions.checkNotNull(interner));
    }
}
