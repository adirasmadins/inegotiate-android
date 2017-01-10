package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.ProgressListener;

public class TransferProgressUpdatingListener implements ProgressListener {
    private final TransferProgressImpl transferProgress;

    public TransferProgressUpdatingListener(TransferProgressImpl transferProgressImpl) {
        this.transferProgress = transferProgressImpl;
    }

    public void progressChanged(ProgressEvent progressEvent) {
        this.transferProgress.updateProgress((long) progressEvent.getBytesTransfered());
    }
}
