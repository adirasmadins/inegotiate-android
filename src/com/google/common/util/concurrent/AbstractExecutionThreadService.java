package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.Service.State;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

@Beta
public abstract class AbstractExecutionThreadService implements Service {
    private static final Logger logger;
    private final Service delegate;

    /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService.1 */
    class C06821 extends AbstractService {

        /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService.1.1 */
        class C06811 implements Runnable {
            C06811() {
            }

            public void run() {
                try {
                    AbstractExecutionThreadService.this.startUp();
                    C06821.this.notifyStarted();
                    if (C06821.this.isRunning()) {
                        AbstractExecutionThreadService.this.run();
                    }
                    AbstractExecutionThreadService.this.shutDown();
                    C06821.this.notifyStopped();
                } catch (Throwable t) {
                    C06821.this.notifyFailed(t);
                    RuntimeException propagate = Throwables.propagate(t);
                }
            }
        }

        C06821() {
        }

        protected final void doStart() {
            AbstractExecutionThreadService.this.executor().execute(new C06811());
        }

        protected void doStop() {
            AbstractExecutionThreadService.this.triggerShutdown();
        }
    }

    /* renamed from: com.google.common.util.concurrent.AbstractExecutionThreadService.2 */
    class C06832 implements Executor {
        C06832() {
        }

        public void execute(Runnable command) {
            new Thread(command, AbstractExecutionThreadService.this.getServiceName()).start();
        }
    }

    protected abstract void run() throws Exception;

    public AbstractExecutionThreadService() {
        this.delegate = new C06821();
    }

    static {
        logger = Logger.getLogger(AbstractExecutionThreadService.class.getName());
    }

    protected void startUp() throws Exception {
    }

    protected void shutDown() throws Exception {
    }

    protected void triggerShutdown() {
    }

    protected Executor executor() {
        return new C06832();
    }

    public String toString() {
        return getServiceName() + " [" + state() + "]";
    }

    public final ListenableFuture<State> start() {
        return this.delegate.start();
    }

    public final State startAndWait() {
        return this.delegate.startAndWait();
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public final State state() {
        return this.delegate.state();
    }

    public final ListenableFuture<State> stop() {
        return this.delegate.stop();
    }

    public final State stopAndWait() {
        return this.delegate.stopAndWait();
    }

    protected String getServiceName() {
        return getClass().getSimpleName();
    }
}
