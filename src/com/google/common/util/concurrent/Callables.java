package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import javax.annotation.Nullable;

public final class Callables {

    /* renamed from: com.google.common.util.concurrent.Callables.1 */
    static class C06961 implements Callable<T> {
        final /* synthetic */ Object val$value;

        C06961(Object obj) {
            this.val$value = obj;
        }

        public T call() {
            return this.val$value;
        }
    }

    private Callables() {
    }

    public static <T> Callable<T> returning(@Nullable T value) {
        return new C06961(value);
    }
}
