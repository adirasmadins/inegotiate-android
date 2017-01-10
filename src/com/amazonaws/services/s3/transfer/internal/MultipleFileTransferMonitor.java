package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.transfer.Transfer.TransferState;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MultipleFileTransferMonitor implements TransferMonitor {
    private final Future<?> future;
    private final Collection<? extends AbstractTransfer> subTransfers;
    private final AbstractTransfer transfer;

    /* renamed from: com.amazonaws.services.s3.transfer.internal.MultipleFileTransferMonitor.1 */
    class C00681 implements Future<Object> {
        C00681() {
        }

        public boolean cancel(boolean z) {
            return true;
        }

        public Object get() throws InterruptedException, ExecutionException {
            Object obj = null;
            for (AbstractTransfer monitor : MultipleFileTransferMonitor.this.subTransfers) {
                obj = monitor.getMonitor().getFuture().get();
            }
            return obj;
        }

        public Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            Object obj = null;
            for (AbstractTransfer monitor : MultipleFileTransferMonitor.this.subTransfers) {
                obj = monitor.getMonitor().getFuture().get(j, timeUnit);
            }
            return obj;
        }

        public boolean isCancelled() {
            return MultipleFileTransferMonitor.this.transfer.getState() == TransferState.Canceled;
        }

        public boolean isDone() {
            return MultipleFileTransferMonitor.this.isDone();
        }
    }

    public MultipleFileTransferMonitor(AbstractTransfer abstractTransfer, Collection<? extends AbstractTransfer> collection) {
        this.subTransfers = collection;
        this.transfer = abstractTransfer;
        this.future = new C00681();
    }

    public Future<?> getFuture() {
        return this.future;
    }

    public synchronized boolean isDone() {
        boolean z;
        for (AbstractTransfer isDone : this.subTransfers) {
            if (!isDone.isDone()) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }
}
