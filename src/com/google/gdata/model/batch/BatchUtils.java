package com.google.gdata.model.batch;

import com.google.gdata.client.batch.BatchInterruptedException;
import com.google.gdata.data.BaseEntry;
import com.google.gdata.data.BaseFeed;
import com.google.gdata.data.ExtensionPoint;
import com.google.gdata.data.Feed;
import com.google.gdata.data.IEntry;
import com.google.gdata.data.IFeed;
import com.google.gdata.data.batch.BatchOperationType;
import com.google.gdata.data.batch.IBatchInterrupted;
import com.google.gdata.data.batch.IBatchStatus;
import com.google.gdata.model.Element;
import com.google.gdata.model.atom.Entry;

public class BatchUtils {
    public static String getBatchId(IEntry entry) {
        if (entry instanceof Entry) {
            return BatchId.getIdFrom((Entry) entry);
        }
        return com.google.gdata.data.batch.BatchUtils.getBatchId((BaseEntry) entry);
    }

    public static void setBatchId(IEntry entry, String id) {
        if (entry instanceof Element) {
            ((Element) entry).setElement(BatchId.KEY, id == null ? null : new BatchId(id));
        } else {
            com.google.gdata.data.batch.BatchUtils.setBatchId((ExtensionPoint) entry, id);
        }
    }

    public static BatchOperationType getBatchOperationType(IEntry entry) {
        if (entry instanceof Element) {
            return getBatchOperationType((Element) entry);
        }
        return com.google.gdata.data.batch.BatchUtils.getBatchOperationType((ExtensionPoint) entry);
    }

    public static BatchOperationType getBatchOperationType(IFeed feed) {
        if (feed instanceof Element) {
            return getBatchOperationType((Element) feed);
        }
        return com.google.gdata.data.batch.BatchUtils.getBatchOperationType((ExtensionPoint) feed);
    }

    private static BatchOperationType getBatchOperationType(Element element) {
        BatchOperation op = (BatchOperation) element.getElement(BatchOperation.KEY);
        return op == null ? null : op.getType();
    }

    public static void setBatchOperationType(IEntry entry, BatchOperationType op) {
        if (entry instanceof Element) {
            setBatchOperationType((Element) entry, op);
        } else {
            com.google.gdata.data.batch.BatchUtils.setBatchOperationType((ExtensionPoint) entry, op);
        }
    }

    public static void setBatchOperationType(IFeed feed, BatchOperationType op) {
        if (feed instanceof Element) {
            setBatchOperationType((Element) feed, op);
        } else {
            com.google.gdata.data.batch.BatchUtils.setBatchOperationType((ExtensionPoint) feed, op);
        }
    }

    private static void setBatchOperationType(Element entry, BatchOperationType op) {
        entry.setElement(BatchOperation.KEY, op == null ? null : new BatchOperation(op));
    }

    public static IBatchInterrupted getInterrupted(IEntry entry) {
        if (entry instanceof Element) {
            return (IBatchInterrupted) ((Element) entry).getElement(BatchInterrupted.KEY);
        }
        return com.google.gdata.data.batch.BatchUtils.getBatchInterrupted((ExtensionPoint) entry);
    }

    public static IBatchStatus getStatus(IEntry entry) {
        if (entry instanceof Element) {
            return (IBatchStatus) ((Element) entry).getElement(BatchStatus.KEY);
        }
        return com.google.gdata.data.batch.BatchUtils.getBatchStatus((ExtensionPoint) entry);
    }

    public static boolean isSuccess(IEntry entry) {
        int code = getRequiredBatchStatusCode(entry);
        return code >= 200 && code < 300;
    }

    public static boolean isFailure(IEntry entry) {
        return !isSuccess(entry);
    }

    private static int getRequiredBatchStatusCode(IEntry entry) {
        IBatchStatus batchStatus = getStatus(entry);
        if (batchStatus != null) {
            return batchStatus.getCode();
        }
        throw new IllegalArgumentException("Not a batch response entry; Missing BatchStatus extension.");
    }

    public static void throwIfInterrupted(IFeed ifeed) throws BatchInterruptedException {
        int count = ifeed.getEntries().size();
        if (count > 0) {
            IBatchInterrupted interrupted;
            IEntry ientry = (IEntry) ifeed.getEntries().get(count - 1);
            if (ientry instanceof Entry) {
                Feed feed = (Feed) ifeed;
                interrupted = (IBatchInterrupted) ((Entry) ientry).getElement(BatchInterrupted.KEY);
            } else if (ientry instanceof BaseEntry) {
                BaseFeed<?, ?> baseFeed = (BaseFeed) ifeed;
                interrupted = com.google.gdata.data.batch.BatchUtils.getBatchInterrupted((BaseEntry) ientry);
            } else {
                throw new IllegalStateException("Unrecognized entry type:" + ientry.getClass());
            }
            if (interrupted != null) {
                throw new BatchInterruptedException(ifeed, interrupted);
            }
        }
    }

    private BatchUtils() {
    }
}
