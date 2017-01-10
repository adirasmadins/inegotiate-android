package com.google.gdata.util.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
public interface Predicate<T> {
    boolean apply(T t);

    boolean equals(Object obj);
}
