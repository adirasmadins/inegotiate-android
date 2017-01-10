package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.Nullable;

@GwtCompatible
@Beta
public interface Cache<K, V> extends Function<K, V> {
    @Deprecated
    V apply(K k);

    ConcurrentMap<K, V> asMap();

    void cleanUp();

    @Deprecated
    V get(K k) throws ExecutionException;

    V get(K k, Callable<? extends V> callable) throws ExecutionException;

    ImmutableMap<K, V> getAllPresent(Iterable<? extends K> iterable);

    @Nullable
    V getIfPresent(K k);

    @Deprecated
    V getUnchecked(K k);

    void invalidate(Object obj);

    void invalidateAll();

    void invalidateAll(Iterable<?> iterable);

    void put(K k, V v);

    long size();

    CacheStats stats();
}
