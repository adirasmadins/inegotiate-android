package com.google.common.hash;

import com.google.common.annotations.Beta;

@Beta
public interface Funnel<T> {
    void funnel(T t, Sink sink);
}
