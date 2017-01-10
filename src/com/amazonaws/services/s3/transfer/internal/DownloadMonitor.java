package com.amazonaws.services.s3.transfer.internal;

import java.util.concurrent.Future;

public class DownloadMonitor implements TransferMonitor {
    private final DownloadImpl download;
    private final Future<?> future;

    public DownloadMonitor(DownloadImpl downloadImpl, Future<?> future) {
        this.download = downloadImpl;
        this.future = future;
    }

    public Future<?> getFuture() {
        return this.future;
    }

    public boolean isDone() {
        return this.download.isDone();
    }
}
