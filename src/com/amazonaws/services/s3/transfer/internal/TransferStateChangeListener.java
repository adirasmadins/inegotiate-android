package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.transfer.Transfer;
import com.amazonaws.services.s3.transfer.Transfer.TransferState;

public interface TransferStateChangeListener {
    void transferStateChanged(Transfer transfer, TransferState transferState);
}
