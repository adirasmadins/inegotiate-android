package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@Beta
public final class Futures {
    private static final Ordering<Constructor<?>> WITH_STRING_PARAM_FIRST;

    /* renamed from: com.google.common.util.concurrent.Futures.1 */
    static class C06971 implements Function<Exception, X> {
        C06971() {
        }

        public X apply(Exception e) {
            throw new AssertionError("impossible");
        }
    }

    /* renamed from: com.google.common.util.concurrent.Futures.2 */
    static class C06982 implements Function<Exception, X> {
        final /* synthetic */ Exception val$exception;

        C06982(Exception exception) {
            this.val$exception = exception;
        }

        public X apply(Exception e) {
            return this.val$exception;
        }
    }

    /* renamed from: com.google.common.util.concurrent.Futures.3 */
    static class C06993 implements AsyncFunction<I, O> {
        final /* synthetic */ Function val$function;

        C06993(Function function) {
            this.val$function = function;
        }

        public ListenableFuture<O> apply(I input) {
            return (ListenableFuture) this.val$function.apply(input);
        }
    }

    /* renamed from: com.google.common.util.concurrent.Futures.4 */
    static class C07004 implements Function<I, ListenableFuture<O>> {
        final /* synthetic */ Function val$function;

        C07004(Function function) {
            this.val$function = function;
        }

        public ListenableFuture<O> apply(I input) {
            return Futures.immediateFuture(this.val$function.apply(input));
        }
    }

    /* renamed from: com.google.common.util.concurrent.Futures.5 */
    static class C07015 implements Future<O> {
        final /* synthetic */ Function val$function;
        final /* synthetic */ Future val$future;

        C07015(Future future, Function function) {
            this.val$future = future;
            this.val$function = function;
        }

        public boolean cancel(boolean mayInterruptIfRunning) {
            return this.val$future.cancel(mayInterruptIfRunning);
        }

        public boolean isCancelled() {
            return this.val$future.isCancelled();
        }

        public boolean isDone() {
            return this.val$future.isDone();
        }

        public O get() throws InterruptedException, ExecutionException {
            return applyTransformation(this.val$future.get());
        }

        public O get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
            return applyTransformation(this.val$future.get(timeout, unit));
        }

        private O applyTransformation(I input) throws ExecutionException {
            try {
                return this.val$function.apply(input);
            } catch (Throwable t) {
                ExecutionException executionException = new ExecutionException(t);
            }
        }
    }

    /* renamed from: com.google.common.util.concurrent.Futures.6 */
    static class C07026 implements Runnable {
        final /* synthetic */ FutureCallback val$callback;
        final /* synthetic */ ListenableFuture val$future;

        C07026(ListenableFuture listenableFuture, FutureCallback futureCallback) {
            this.val$future = listenableFuture;
            this.val$callback = futureCallback;
        }

        public void run() {
            try {
                this.val$callback.onSuccess(Uninterruptibles.getUninterruptibly(this.val$future));
            } catch (ExecutionException e) {
                this.val$callback.onFailure(e.getCause());
            } catch (RuntimeException e2) {
                this.val$callback.onFailure(e2);
            } catch (Error e3) {
                this.val$callback.onFailure(e3);
            }
        }
    }

    /* renamed from: com.google.common.util.concurrent.Futures.7 */
    static class C07037 implements Function<Constructor<?>, Boolean> {
        C07037() {
        }

        public Boolean apply(Constructor<?> input) {
            return Boolean.valueOf(Arrays.asList(input.getParameterTypes()).contains(String.class));
        }
    }

    private static class ChainingListenableFuture<I, O> extends AbstractFuture<O> implements Runnable {
        private AsyncFunction<? super I, ? extends O> function;
        private ListenableFuture<? extends I> inputFuture;
        private final BlockingQueue<Boolean> mayInterruptIfRunningChannel;
        private final CountDownLatch outputCreated;
        private volatile ListenableFuture<? extends O> outputFuture;

        /* renamed from: com.google.common.util.concurrent.Futures.ChainingListenableFuture.1 */
        class C07041 implements Runnable {
            final /* synthetic */ ListenableFuture val$outputFuture;

            C07041(ListenableFuture listenableFuture) {
                this.val$outputFuture = listenableFuture;
            }

            public void run() {
                try {
                    ChainingListenableFuture.this.set(Uninterruptibles.getUninterruptibly(this.val$outputFuture));
                } catch (CancellationException e) {
                    ChainingListenableFuture.this.cancel(false);
                } catch (ExecutionException e2) {
                    ChainingListenableFuture.this.setException(e2.getCause());
                } finally {
                    ChainingListenableFuture.this.outputFuture = null;
                }
            }
        }

        private ChainingListenableFuture(AsyncFunction<? super I, ? extends O> function, ListenableFuture<? extends I> inputFuture) {
            this.mayInterruptIfRunningChannel = new LinkedBlockingQueue(1);
            this.outputCreated = new CountDownLatch(1);
            this.function = (AsyncFunction) Preconditions.checkNotNull(function);
            this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(inputFuture);
        }

        public O get() throws InterruptedException, ExecutionException {
            if (!isDone()) {
                ListenableFuture<? extends I> inputFuture = this.inputFuture;
                if (inputFuture != null) {
                    inputFuture.get();
                }
                this.outputCreated.await();
                ListenableFuture<? extends O> outputFuture = this.outputFuture;
                if (outputFuture != null) {
                    outputFuture.get();
                }
            }
            return super.get();
        }

        public O get(long timeout, TimeUnit unit) throws TimeoutException, ExecutionException, InterruptedException {
            if (!isDone()) {
                long start;
                if (unit != TimeUnit.NANOSECONDS) {
                    timeout = TimeUnit.NANOSECONDS.convert(timeout, unit);
                    unit = TimeUnit.NANOSECONDS;
                }
                ListenableFuture<? extends I> inputFuture = this.inputFuture;
                if (inputFuture != null) {
                    start = System.nanoTime();
                    inputFuture.get(timeout, unit);
                    timeout -= Math.max(0, System.nanoTime() - start);
                }
                start = System.nanoTime();
                if (this.outputCreated.await(timeout, unit)) {
                    timeout -= Math.max(0, System.nanoTime() - start);
                    ListenableFuture<? extends O> outputFuture = this.outputFuture;
                    if (outputFuture != null) {
                        outputFuture.get(timeout, unit);
                    }
                } else {
                    throw new TimeoutException();
                }
            }
            return super.get(timeout, unit);
        }

        public boolean cancel(boolean mayInterruptIfRunning) {
            if (!super.cancel(mayInterruptIfRunning)) {
                return false;
            }
            Uninterruptibles.putUninterruptibly(this.mayInterruptIfRunningChannel, Boolean.valueOf(mayInterruptIfRunning));
            cancel(this.inputFuture, mayInterruptIfRunning);
            cancel(this.outputFuture, mayInterruptIfRunning);
            return true;
        }

        private void cancel(@Nullable Future<?> future, boolean mayInterruptIfRunning) {
            if (future != null) {
                future.cancel(mayInterruptIfRunning);
            }
        }

        public void run() {
            try {
                try {
                    ListenableFuture<? extends O> outputFuture = this.function.apply(Uninterruptibles.getUninterruptibly(this.inputFuture));
                    this.outputFuture = outputFuture;
                    if (isCancelled()) {
                        outputFuture.cancel(((Boolean) Uninterruptibles.takeUninterruptibly(this.mayInterruptIfRunningChannel)).booleanValue());
                        this.outputFuture = null;
                        return;
                    }
                    outputFuture.addListener(new C07041(outputFuture), MoreExecutors.sameThreadExecutor());
                    this.function = null;
                    this.inputFuture = null;
                    this.outputCreated.countDown();
                } catch (UndeclaredThrowableException e) {
                    setException(e.getCause());
                } catch (Exception e2) {
                    setException(e2);
                } catch (Error e3) {
                    setException(e3);
                } finally {
                    this.function = null;
                    this.inputFuture = null;
                    this.outputCreated.countDown();
                }
            } catch (CancellationException e4) {
                cancel(false);
                this.function = null;
                this.inputFuture = null;
                this.outputCreated.countDown();
            } catch (ExecutionException e5) {
                setException(e5.getCause());
                this.function = null;
                this.inputFuture = null;
                this.outputCreated.countDown();
            }
        }
    }

    private static class ListFuture<V> extends AbstractFuture<List<V>> {
        final boolean allMustSucceed;
        ImmutableList<? extends ListenableFuture<? extends V>> futures;
        final AtomicInteger remaining;
        List<V> values;

        /* renamed from: com.google.common.util.concurrent.Futures.ListFuture.1 */
        class C07051 implements Runnable {
            C07051() {
            }

            public void run() {
                ListFuture.this.values = null;
                ListFuture.this.futures = null;
            }
        }

        /* renamed from: com.google.common.util.concurrent.Futures.ListFuture.2 */
        class C07062 implements Runnable {
            final /* synthetic */ int val$index;
            final /* synthetic */ ListenableFuture val$listenable;

            C07062(int i, ListenableFuture listenableFuture) {
                this.val$index = i;
                this.val$listenable = listenableFuture;
            }

            public void run() {
                ListFuture.this.setOneValue(this.val$index, this.val$listenable);
            }
        }

        ListFuture(ImmutableList<? extends ListenableFuture<? extends V>> futures, boolean allMustSucceed, Executor listenerExecutor) {
            this.futures = futures;
            this.values = Lists.newArrayListWithCapacity(futures.size());
            this.allMustSucceed = allMustSucceed;
            this.remaining = new AtomicInteger(futures.size());
            init(listenerExecutor);
        }

        private void init(Executor listenerExecutor) {
            addListener(new C07051(), MoreExecutors.sameThreadExecutor());
            if (this.futures.isEmpty()) {
                set(Lists.newArrayList(this.values));
                return;
            }
            int i;
            for (i = 0; i < this.futures.size(); i++) {
                this.values.add(null);
            }
            ImmutableList<? extends ListenableFuture<? extends V>> localFutures = this.futures;
            for (i = 0; i < localFutures.size(); i++) {
                ListenableFuture<? extends V> listenable = (ListenableFuture) localFutures.get(i);
                listenable.addListener(new C07062(i, listenable), listenerExecutor);
            }
        }

        private void setOneValue(int index, Future<? extends V> future) {
            int newRemaining;
            Iterable localValues;
            boolean z = true;
            List<V> localValues2 = this.values;
            if (isDone() || localValues2 == null) {
                Preconditions.checkState(this.allMustSucceed, "Future was done before all dependencies completed");
                return;
            }
            try {
                Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
                localValues2.set(index, Uninterruptibles.getUninterruptibly(future));
                newRemaining = this.remaining.decrementAndGet();
                if (newRemaining < 0) {
                    z = false;
                }
                Preconditions.checkState(z, "Less than 0 remaining futures");
                if (newRemaining == 0) {
                    localValues = this.values;
                    if (localValues != null) {
                        set(Lists.newArrayList(localValues));
                    } else {
                        Preconditions.checkState(isDone());
                    }
                }
            } catch (CancellationException e) {
                if (this.allMustSucceed) {
                    cancel(false);
                }
                newRemaining = this.remaining.decrementAndGet();
                if (newRemaining < 0) {
                    z = false;
                }
                Preconditions.checkState(z, "Less than 0 remaining futures");
                if (newRemaining == 0) {
                    localValues = this.values;
                    if (localValues != null) {
                        set(Lists.newArrayList(localValues));
                    } else {
                        Preconditions.checkState(isDone());
                    }
                }
            } catch (ExecutionException e2) {
                if (this.allMustSucceed) {
                    setException(e2.getCause());
                }
                newRemaining = this.remaining.decrementAndGet();
                if (newRemaining < 0) {
                    z = false;
                }
                Preconditions.checkState(z, "Less than 0 remaining futures");
                if (newRemaining == 0) {
                    localValues = this.values;
                    if (localValues != null) {
                        set(Lists.newArrayList(localValues));
                    } else {
                        Preconditions.checkState(isDone());
                    }
                }
            } catch (RuntimeException e3) {
                if (this.allMustSucceed) {
                    setException(e3);
                }
                newRemaining = this.remaining.decrementAndGet();
                if (newRemaining < 0) {
                    z = false;
                }
                Preconditions.checkState(z, "Less than 0 remaining futures");
                if (newRemaining == 0) {
                    localValues = this.values;
                    if (localValues != null) {
                        set(Lists.newArrayList(localValues));
                    } else {
                        Preconditions.checkState(isDone());
                    }
                }
            } catch (Error e4) {
                setException(e4);
                newRemaining = this.remaining.decrementAndGet();
                if (newRemaining < 0) {
                    z = false;
                }
                Preconditions.checkState(z, "Less than 0 remaining futures");
                if (newRemaining == 0) {
                    localValues = this.values;
                    if (localValues != null) {
                        set(Lists.newArrayList(localValues));
                    } else {
                        Preconditions.checkState(isDone());
                    }
                }
            } catch (Throwable th) {
                newRemaining = this.remaining.decrementAndGet();
                if (newRemaining < 0) {
                    z = false;
                }
                Preconditions.checkState(z, "Less than 0 remaining futures");
                if (newRemaining == 0) {
                    localValues = this.values;
                    if (localValues != null) {
                        set(Lists.newArrayList(localValues));
                    } else {
                        Preconditions.checkState(isDone());
                    }
                }
            }
        }

        public List<V> get() throws InterruptedException, ExecutionException {
            callAllGets();
            return (List) super.get();
        }

        private void callAllGets() throws InterruptedException {
            List<? extends ListenableFuture<? extends V>> oldFutures = this.futures;
            if (oldFutures != null && !isDone()) {
                for (ListenableFuture<? extends V> future : oldFutures) {
                    while (!future.isDone()) {
                        try {
                            future.get();
                        } catch (Error e) {
                            throw e;
                        } catch (InterruptedException e2) {
                            throw e2;
                        } catch (Throwable th) {
                            if (this.allMustSucceed) {
                                return;
                            }
                        }
                    }
                }
            }
        }
    }

    private static class MappingCheckedFuture<V, X extends Exception> extends AbstractCheckedFuture<V, X> {
        final Function<Exception, X> mapper;

        MappingCheckedFuture(ListenableFuture<V> delegate, Function<Exception, X> mapper) {
            super(delegate);
            this.mapper = (Function) Preconditions.checkNotNull(mapper);
        }

        protected X mapException(Exception e) {
            return (Exception) this.mapper.apply(e);
        }
    }

    private Futures() {
    }

    public static <V, X extends Exception> CheckedFuture<V, X> makeChecked(ListenableFuture<V> future, Function<Exception, X> mapper) {
        return new MappingCheckedFuture((ListenableFuture) Preconditions.checkNotNull(future), mapper);
    }

    public static <V> ListenableFuture<V> immediateFuture(@Nullable V value) {
        SettableFuture<V> future = SettableFuture.create();
        future.set(value);
        return future;
    }

    public static <V, X extends Exception> CheckedFuture<V, X> immediateCheckedFuture(@Nullable V value) {
        SettableFuture<V> future = SettableFuture.create();
        future.set(value);
        return makeChecked(future, new C06971());
    }

    public static <V> ListenableFuture<V> immediateFailedFuture(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        SettableFuture<V> future = SettableFuture.create();
        future.setException(throwable);
        return future;
    }

    public static <V, X extends Exception> CheckedFuture<V, X> immediateFailedCheckedFuture(X exception) {
        Preconditions.checkNotNull(exception);
        return makeChecked(immediateFailedFuture(exception), new C06982(exception));
    }

    @Deprecated
    public static <I, O> ListenableFuture<O> chain(ListenableFuture<I> input, Function<? super I, ? extends ListenableFuture<? extends O>> function) {
        return chain(input, function, MoreExecutors.sameThreadExecutor());
    }

    @Deprecated
    public static <I, O> ListenableFuture<O> chain(ListenableFuture<I> input, Function<? super I, ? extends ListenableFuture<? extends O>> function, Executor executor) {
        Preconditions.checkNotNull(function);
        ChainingListenableFuture<I, O> chain = new ChainingListenableFuture(input, null);
        input.addListener(chain, executor);
        return chain;
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, AsyncFunction<? super I, ? extends O> function) {
        return transform((ListenableFuture) input, (AsyncFunction) function, MoreExecutors.sameThreadExecutor());
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> input, AsyncFunction<? super I, ? extends O> function, Executor executor) {
        ChainingListenableFuture<I, O> output = new ChainingListenableFuture(input, null);
        input.addListener(output, executor);
        return output;
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> future, Function<? super I, ? extends O> function) {
        return transform((ListenableFuture) future, (Function) function, MoreExecutors.sameThreadExecutor());
    }

    public static <I, O> ListenableFuture<O> transform(ListenableFuture<I> future, Function<? super I, ? extends O> function, Executor executor) {
        Preconditions.checkNotNull(function);
        return chain(future, new C07004(function), executor);
    }

    @Beta
    public static <I, O> Future<O> lazyTransform(Future<I> future, Function<? super I, ? extends O> function) {
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(function);
        return new C07015(future, function);
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(ListenableFuture<? extends V>... futures) {
        return new ListFuture(ImmutableList.copyOf((Object[]) futures), true, MoreExecutors.sameThreadExecutor());
    }

    @Beta
    public static <V> ListenableFuture<List<V>> allAsList(Iterable<? extends ListenableFuture<? extends V>> futures) {
        return new ListFuture(ImmutableList.copyOf((Iterable) futures), true, MoreExecutors.sameThreadExecutor());
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(ListenableFuture<? extends V>... futures) {
        return new ListFuture(ImmutableList.copyOf((Object[]) futures), false, MoreExecutors.sameThreadExecutor());
    }

    @Beta
    public static <V> ListenableFuture<List<V>> successfulAsList(Iterable<? extends ListenableFuture<? extends V>> futures) {
        return new ListFuture(ImmutableList.copyOf((Iterable) futures), false, MoreExecutors.sameThreadExecutor());
    }

    public static <V> void addCallback(ListenableFuture<V> future, FutureCallback<? super V> callback) {
        addCallback(future, callback, MoreExecutors.sameThreadExecutor());
    }

    public static <V> void addCallback(ListenableFuture<V> future, FutureCallback<? super V> callback, Executor executor) {
        Preconditions.checkNotNull(callback);
        future.addListener(new C07026(future, callback), executor);
    }

    @Beta
    public static <V, X extends Exception> V get(Future<V> future, Class<X> exceptionClass) throws Exception {
        boolean z;
        Preconditions.checkNotNull(future);
        if (RuntimeException.class.isAssignableFrom(exceptionClass)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Futures.get exception type (%s) must not be a RuntimeException", exceptionClass);
        try {
            return future.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw newWithCause(exceptionClass, e);
        } catch (ExecutionException e2) {
            wrapAndThrowExceptionOrError(e2.getCause(), exceptionClass);
            throw new AssertionError();
        }
    }

    @Beta
    public static <V, X extends Exception> V get(Future<V> future, long timeout, TimeUnit unit, Class<X> exceptionClass) throws Exception {
        boolean z;
        Preconditions.checkNotNull(future);
        Preconditions.checkNotNull(unit);
        if (RuntimeException.class.isAssignableFrom(exceptionClass)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Futures.get exception type (%s) must not be a RuntimeException", exceptionClass);
        try {
            return future.get(timeout, unit);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw newWithCause(exceptionClass, e);
        } catch (TimeoutException e2) {
            throw newWithCause(exceptionClass, e2);
        } catch (ExecutionException e3) {
            wrapAndThrowExceptionOrError(e3.getCause(), exceptionClass);
            throw new AssertionError();
        }
    }

    private static <X extends Exception> void wrapAndThrowExceptionOrError(Throwable cause, Class<X> exceptionClass) throws Exception {
        if (cause instanceof Error) {
            throw new ExecutionError((Error) cause);
        } else if (cause instanceof RuntimeException) {
            throw new UncheckedExecutionException(cause);
        } else {
            throw newWithCause(exceptionClass, cause);
        }
    }

    @Beta
    public static <V> V getUnchecked(Future<V> future) {
        Preconditions.checkNotNull(future);
        try {
            return Uninterruptibles.getUninterruptibly(future);
        } catch (ExecutionException e) {
            wrapAndThrowUnchecked(e.getCause());
            throw new AssertionError();
        }
    }

    private static void wrapAndThrowUnchecked(Throwable cause) {
        if (cause instanceof Error) {
            throw new ExecutionError((Error) cause);
        }
        throw new UncheckedExecutionException(cause);
    }

    private static <X extends Exception> X newWithCause(Class<X> exceptionClass, Throwable cause) {
        for (Constructor<X> constructor : preferringStrings(Arrays.asList(exceptionClass.getConstructors()))) {
            Exception instance = (Exception) newFromConstructor(constructor, cause);
            if (instance != null) {
                if (instance.getCause() == null) {
                    instance.initCause(cause);
                }
                return instance;
            }
        }
        throw new IllegalArgumentException("No appropriate constructor for exception of type " + exceptionClass + " in response to chained exception", cause);
    }

    private static <X extends Exception> List<Constructor<X>> preferringStrings(List<Constructor<X>> constructors) {
        return WITH_STRING_PARAM_FIRST.sortedCopy(constructors);
    }

    static {
        WITH_STRING_PARAM_FIRST = Ordering.natural().onResultOf(new C07037()).reverse();
    }

    @Nullable
    private static <X> X newFromConstructor(Constructor<X> constructor, Throwable cause) {
        X x = null;
        Class<?>[] paramTypes = constructor.getParameterTypes();
        Object[] params = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            Class<?> paramType = paramTypes[i];
            if (!paramType.equals(String.class)) {
                if (!paramType.equals(Throwable.class)) {
                    break;
                }
                params[i] = cause;
            } else {
                params[i] = cause.toString();
            }
        }
        try {
            x = constructor.newInstance(params);
        } catch (IllegalArgumentException e) {
        } catch (InstantiationException e2) {
        } catch (IllegalAccessException e3) {
        } catch (InvocationTargetException e4) {
        }
        return x;
    }
}
