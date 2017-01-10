package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Service.State;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;

@Beta
public abstract class AbstractService implements Service {
    private final ReentrantLock lock;
    private final Transition shutdown;
    private boolean shutdownWhenStartupFinishes;
    private final Transition startup;
    private State state;

    private class Transition extends AbstractFuture<State> {
        private Transition() {
        }

        public State get(long timeout, TimeUnit unit) throws InterruptedException, TimeoutException, ExecutionException {
            try {
                return (State) super.get(timeout, unit);
            } catch (TimeoutException e) {
                throw new TimeoutException(AbstractService.this.toString());
            }
        }
    }

    protected abstract void doStart();

    protected abstract void doStop();

    public AbstractService() {
        this.lock = new ReentrantLock();
        this.startup = new Transition();
        this.shutdown = new Transition();
        this.state = State.NEW;
        this.shutdownWhenStartupFinishes = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.util.concurrent.ListenableFuture<com.google.common.util.concurrent.Service.State> start() {
        /*
        r3 = this;
        r1 = r3.lock;
        r1.lock();
        r1 = r3.state;	 Catch:{ Throwable -> 0x001a }
        r2 = com.google.common.util.concurrent.Service.State.NEW;	 Catch:{ Throwable -> 0x001a }
        if (r1 != r2) goto L_0x0012;
    L_0x000b:
        r1 = com.google.common.util.concurrent.Service.State.STARTING;	 Catch:{ Throwable -> 0x001a }
        r3.state = r1;	 Catch:{ Throwable -> 0x001a }
        r3.doStart();	 Catch:{ Throwable -> 0x001a }
    L_0x0012:
        r1 = r3.lock;
        r1.unlock();
    L_0x0017:
        r1 = r3.startup;
        return r1;
    L_0x001a:
        r0 = move-exception;
        r3.notifyFailed(r0);	 Catch:{ all -> 0x0024 }
        r1 = r3.lock;
        r1.unlock();
        goto L_0x0017;
    L_0x0024:
        r1 = move-exception;
        r2 = r3.lock;
        r2.unlock();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractService.start():com.google.common.util.concurrent.ListenableFuture<com.google.common.util.concurrent.Service$State>");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.util.concurrent.ListenableFuture<com.google.common.util.concurrent.Service.State> stop() {
        /*
        r3 = this;
        r1 = r3.lock;
        r1.lock();
        r1 = r3.state;	 Catch:{ Throwable -> 0x0036 }
        r2 = com.google.common.util.concurrent.Service.State.NEW;	 Catch:{ Throwable -> 0x0036 }
        if (r1 != r2) goto L_0x0025;
    L_0x000b:
        r1 = com.google.common.util.concurrent.Service.State.TERMINATED;	 Catch:{ Throwable -> 0x0036 }
        r3.state = r1;	 Catch:{ Throwable -> 0x0036 }
        r1 = r3.startup;	 Catch:{ Throwable -> 0x0036 }
        r2 = com.google.common.util.concurrent.Service.State.TERMINATED;	 Catch:{ Throwable -> 0x0036 }
        r1.set(r2);	 Catch:{ Throwable -> 0x0036 }
        r1 = r3.shutdown;	 Catch:{ Throwable -> 0x0036 }
        r2 = com.google.common.util.concurrent.Service.State.TERMINATED;	 Catch:{ Throwable -> 0x0036 }
        r1.set(r2);	 Catch:{ Throwable -> 0x0036 }
    L_0x001d:
        r1 = r3.lock;
        r1.unlock();
    L_0x0022:
        r1 = r3.shutdown;
        return r1;
    L_0x0025:
        r1 = r3.state;	 Catch:{ Throwable -> 0x0036 }
        r2 = com.google.common.util.concurrent.Service.State.STARTING;	 Catch:{ Throwable -> 0x0036 }
        if (r1 != r2) goto L_0x0040;
    L_0x002b:
        r1 = 1;
        r3.shutdownWhenStartupFinishes = r1;	 Catch:{ Throwable -> 0x0036 }
        r1 = r3.startup;	 Catch:{ Throwable -> 0x0036 }
        r2 = com.google.common.util.concurrent.Service.State.STOPPING;	 Catch:{ Throwable -> 0x0036 }
        r1.set(r2);	 Catch:{ Throwable -> 0x0036 }
        goto L_0x001d;
    L_0x0036:
        r0 = move-exception;
        r3.notifyFailed(r0);	 Catch:{ all -> 0x004e }
        r1 = r3.lock;
        r1.unlock();
        goto L_0x0022;
    L_0x0040:
        r1 = r3.state;	 Catch:{ Throwable -> 0x0036 }
        r2 = com.google.common.util.concurrent.Service.State.RUNNING;	 Catch:{ Throwable -> 0x0036 }
        if (r1 != r2) goto L_0x001d;
    L_0x0046:
        r1 = com.google.common.util.concurrent.Service.State.STOPPING;	 Catch:{ Throwable -> 0x0036 }
        r3.state = r1;	 Catch:{ Throwable -> 0x0036 }
        r3.doStop();	 Catch:{ Throwable -> 0x0036 }
        goto L_0x001d;
    L_0x004e:
        r1 = move-exception;
        r2 = r3.lock;
        r2.unlock();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractService.stop():com.google.common.util.concurrent.ListenableFuture<com.google.common.util.concurrent.Service$State>");
    }

    public State startAndWait() {
        return (State) Futures.getUnchecked(start());
    }

    public State stopAndWait() {
        return (State) Futures.getUnchecked(stop());
    }

    protected final void notifyStarted() {
        this.lock.lock();
        try {
            if (this.state != State.STARTING) {
                IllegalStateException failure = new IllegalStateException("Cannot notifyStarted() when the service is " + this.state);
                notifyFailed(failure);
                throw failure;
            }
            this.state = State.RUNNING;
            if (this.shutdownWhenStartupFinishes) {
                stop();
            } else {
                this.startup.set(State.RUNNING);
            }
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
        }
    }

    protected final void notifyStopped() {
        this.lock.lock();
        try {
            if (this.state == State.STOPPING || this.state == State.RUNNING) {
                this.state = State.TERMINATED;
                this.shutdown.set(State.TERMINATED);
                return;
            }
            IllegalStateException failure = new IllegalStateException("Cannot notifyStopped() when the service is " + this.state);
            notifyFailed(failure);
            throw failure;
        } finally {
            this.lock.unlock();
        }
    }

    protected final void notifyFailed(Throwable cause) {
        Preconditions.checkNotNull(cause);
        this.lock.lock();
        try {
            if (this.state == State.STARTING) {
                this.startup.setException(cause);
                this.shutdown.setException(new Exception("Service failed to start.", cause));
            } else if (this.state == State.STOPPING) {
                this.shutdown.setException(cause);
            } else if (this.state == State.RUNNING) {
                this.shutdown.setException(new Exception("Service failed while running", cause));
            } else if (this.state == State.NEW || this.state == State.TERMINATED) {
                throw new IllegalStateException("Failed while in state:" + this.state, cause);
            }
            this.state = State.FAILED;
        } finally {
            this.lock.unlock();
        }
    }

    public final boolean isRunning() {
        return state() == State.RUNNING;
    }

    public final State state() {
        this.lock.lock();
        try {
            State state;
            if (this.shutdownWhenStartupFinishes && this.state == State.STARTING) {
                state = State.STOPPING;
                return state;
            }
            state = this.state;
            this.lock.unlock();
            return state;
        } finally {
            this.lock.unlock();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + state() + "]";
    }
}
