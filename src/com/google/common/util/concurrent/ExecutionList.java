package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ExecutionList {
    private static final Logger log;
    private boolean executed;
    private final Queue<RunnableExecutorPair> runnables;

    private static class RunnableExecutorPair {
        final Executor executor;
        final Runnable runnable;

        RunnableExecutorPair(Runnable runnable, Executor executor) {
            this.runnable = runnable;
            this.executor = executor;
        }

        void execute() {
            try {
                this.executor.execute(this.runnable);
            } catch (RuntimeException e) {
                ExecutionList.log.log(Level.SEVERE, "RuntimeException while executing runnable " + this.runnable + " with executor " + this.executor, e);
            }
        }
    }

    static {
        log = Logger.getLogger(ExecutionList.class.getName());
    }

    public ExecutionList() {
        this.runnables = Lists.newLinkedList();
        this.executed = false;
    }

    public void add(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        boolean executeImmediate = false;
        synchronized (this.runnables) {
            if (this.executed) {
                executeImmediate = true;
            } else {
                this.runnables.add(new RunnableExecutorPair(runnable, executor));
            }
        }
        if (executeImmediate) {
            new RunnableExecutorPair(runnable, executor).execute();
        }
    }

    public void execute() {
        synchronized (this.runnables) {
            if (this.executed) {
                return;
            }
            this.executed = true;
            while (!this.runnables.isEmpty()) {
                ((RunnableExecutorPair) this.runnables.poll()).execute();
            }
        }
    }
}
