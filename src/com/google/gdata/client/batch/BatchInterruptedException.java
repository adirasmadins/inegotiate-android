package com.google.gdata.client.batch;

import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.IFeed;
import com.google.gdata.data.batch.BatchInterrupted;
import com.google.gdata.data.batch.IBatchInterrupted;
import com.google.gdata.util.ServiceException;
import com.google.gdata.util.common.base.Preconditions;

public class BatchInterruptedException extends ServiceException {
    private final IFeed feed;
    private final IBatchInterrupted interrupted;

    public BatchInterruptedException(IFeed feed, IBatchInterrupted interrupted) {
        super("Batch Interrupted (some operations might have succeeded) : " + interrupted.getReason());
        this.feed = feed;
        this.interrupted = interrupted;
    }

    @Deprecated
    public BatchInterrupted getBatchInterrupted() {
        boolean z = this.interrupted == null || (this.interrupted instanceof BatchInterrupted);
        Preconditions.checkState(z, "Use getIBatchInterrupted() instead");
        return (BatchInterrupted) this.interrupted;
    }

    public IBatchInterrupted getIBatchInterrupted() {
        return this.interrupted;
    }

    @Deprecated
    public BaseFeed<?, ?> getFeed() {
        boolean z = this.feed == null || (this.feed instanceof BaseFeed);
        Preconditions.checkState(z, "Use getIFeed() instead");
        return (BaseFeed) this.feed;
    }

    public IFeed getIFeed() {
        return this.feed;
    }
}
