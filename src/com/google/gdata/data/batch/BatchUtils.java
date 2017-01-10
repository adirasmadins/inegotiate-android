package com.google.gdata.data.batch;

import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.ExtensionProfile;
import com.google.gdata.util.Namespaces;

public class BatchUtils {
    public static void declareExtensions(ExtensionProfile extProfile) {
        extProfile.declareAdditionalNamespace(Namespaces.batchNs);
        declareEntryExtensions(extProfile);
        declareFeedExtensions(extProfile);
    }

    public static void declareFeedExtensions(ExtensionProfile extProfile) {
        extProfile.declare(BaseFeed.class, BatchOperation.getDefaultDescription());
    }

    public static void declareEntryExtensions(ExtensionProfile extProfile) {
        extProfile.declare(BaseEntry.class, BatchId.getDefaultDescription());
        extProfile.declare(BaseEntry.class, BatchOperation.getDefaultDescription());
        extProfile.declare(BaseEntry.class, BatchInterrupted.getDefaultDescription());
        extProfile.declare(BaseEntry.class, BatchStatus.getDefaultDescription());
    }

    public static String getBatchId(BaseEntry<?> entry) {
        return BatchId.getIdFrom(entry);
    }

    public static void setBatchId(ExtensionPoint extPoint, String id) {
        if (id == null) {
            extPoint.removeExtension(BatchId.class);
        } else {
            extPoint.setExtension(new BatchId(id));
        }
    }

    public static BatchOperationType getBatchOperationType(ExtensionPoint extPoint) {
        BatchOperation op = (BatchOperation) extPoint.getExtension(BatchOperation.class);
        return op == null ? null : op.getType();
    }

    public static void setBatchOperationType(ExtensionPoint extPoint, BatchOperationType op) {
        if (op == null) {
            extPoint.removeExtension(BatchOperation.class);
        } else {
            extPoint.setExtension(new BatchOperation(op));
        }
    }

    public static BatchInterrupted getBatchInterrupted(ExtensionPoint extPoint) {
        return (BatchInterrupted) extPoint.getExtension(BatchInterrupted.class);
    }

    public static BatchStatus getBatchStatus(ExtensionPoint extPoint) {
        return (BatchStatus) extPoint.getExtension(BatchStatus.class);
    }

    public static boolean isSuccess(ExtensionPoint extPoint) {
        int code = getRequiredBatchStatusCode(extPoint);
        return code >= 200 && code < 300;
    }

    public static boolean isFailure(ExtensionPoint extPoint) {
        return !isSuccess(extPoint);
    }

    private static int getRequiredBatchStatusCode(ExtensionPoint extPoint) {
        BatchStatus batchStatus = getBatchStatus(extPoint);
        if (batchStatus != null) {
            return batchStatus.getCode();
        }
        throw new IllegalArgumentException("Not a batch response entry; Missing BatchStatus extension.");
    }
}
