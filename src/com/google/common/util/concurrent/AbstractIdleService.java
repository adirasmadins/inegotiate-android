package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.Service.State;
import java.util.concurrent.Executor;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@Beta
public abstract class AbstractIdleService implements Service {
    private final Service delegate;

    /* renamed from: com.google.common.util.concurrent.AbstractIdleService.1 */
    class C06861 extends AbstractService {

        /* renamed from: com.google.common.util.concurrent.AbstractIdleService.1.1 */
        class C06841 implements Runnable {
            C06841() {
            }

            public void run() {
                try {
                    AbstractIdleService.this.startUp();
                    C06861.this.notifyStarted();
                } catch (Throwable t) {
                    C06861.this.notifyFailed(t);
                    RuntimeException propagate = Throwables.propagate(t);
                }
            }
        }

        /* renamed from: com.google.common.util.concurrent.AbstractIdleService.1.2 */
        class C06852 implements Runnable {
            C06852() {
            }

            public void run() {
                try {
                    AbstractIdleService.this.shutDown();
                    C06861.this.notifyStopped();
                } catch (Throwable t) {
                    C06861.this.notifyFailed(t);
                    RuntimeException propagate = Throwables.propagate(t);
                }
            }
        }

        C06861() {
        }

        protected final void doStart() {
            AbstractIdleService.this.executor(State.STARTING).execute(new C06841());
        }

        protected final void doStop() {
            AbstractIdleService.this.executor(State.STOPPING).execute(new C06852());
        }
    }

    /* renamed from: com.google.common.util.concurrent.AbstractIdleService.2 */
    class C06872 implements Executor {
        final /* synthetic */ State val$state;

        C06872(State state) {
            this.val$state = state;
        }

        public void execute(Runnable command) {
            new Thread(command, AbstractIdleService.this.getServiceName() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.val$state).start();
        }
    }

    protected abstract void shutDown() throws Exception;

    protected abstract void startUp() throws Exception;

    public AbstractIdleService() {
        this.delegate = new C06861();
    }

    protected Executor executor(State state) {
        return new C06872(state);
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

    private String getServiceName() {
        return getClass().getSimpleName();
    }
}
