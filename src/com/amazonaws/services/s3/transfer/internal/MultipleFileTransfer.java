package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.transfer.Transfer;
import com.amazonaws.services.s3.transfer.Transfer.TransferState;
import com.amazonaws.services.s3.transfer.TransferProgress;
import java.util.Collection;

public abstract class MultipleFileTransfer extends AbstractTransfer {
    protected final Collection<? extends Transfer> subTransfers;

    MultipleFileTransfer(String str, TransferProgress transferProgress, ProgressListenerChain progressListenerChain, Collection<? extends Transfer> collection) {
        super(str, transferProgress, progressListenerChain);
        this.subTransfers = collection;
    }

    public void collateFinalState() {
        Object obj = null;
        for (Transfer transfer : this.subTransfers) {
            if (transfer.getState() == TransferState.Failed) {
                setState(TransferState.Failed);
                return;
            }
            obj = transfer.getState() == TransferState.Canceled ? 1 : obj;
        }
        if (obj != null) {
            setState(TransferState.Canceled);
        } else {
            setState(TransferState.Completed);
        }
    }
}
