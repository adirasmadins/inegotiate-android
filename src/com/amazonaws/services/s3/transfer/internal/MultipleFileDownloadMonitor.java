package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.transfer.Transfer.TransferState;
import java.util.Collection;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MultipleFileDownloadMonitor implements TransferMonitor {
    private final MultipleFileDownloadImpl download;
    private final Collection<DownloadImpl> fileDownloads;
    private final Future<?> future;

    /* renamed from: com.amazonaws.services.s3.transfer.internal.MultipleFileDownloadMonitor.1 */
    class C00671 implements Future<Object> {
        C00671() {
        }

        public boolean cancel(boolean z) {
            return true;
        }

        public Object get() throws InterruptedException, ExecutionException {
            Object obj = null;
            for (DownloadImpl monitor : MultipleFileDownloadMonitor.this.fileDownloads) {
                obj = monitor.getMonitor().getFuture().get();
            }
            return obj;
        }

        public Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            Object obj = null;
            for (DownloadImpl monitor : MultipleFileDownloadMonitor.this.fileDownloads) {
                obj = monitor.getMonitor().getFuture().get(j, timeUnit);
            }
            return obj;
        }

        public boolean isCancelled() {
            return MultipleFileDownloadMonitor.this.download.getState() == TransferState.Canceled;
        }

        public boolean isDone() {
            return MultipleFileDownloadMonitor.this.isDone();
        }
    }

    public MultipleFileDownloadMonitor(MultipleFileDownloadImpl multipleFileDownloadImpl, Collection<DownloadImpl> collection) {
        this.fileDownloads = collection;
        this.download = multipleFileDownloadImpl;
        this.future = new C00671();
    }

    public Future<?> getFuture() {
        return this.future;
    }

    public boolean isDone() {
        for (DownloadImpl isDone : this.fileDownloads) {
            if (!isDone.isDone()) {
                return false;
            }
        }
        return true;
    }
}
