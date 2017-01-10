package com.amazonaws.services.s3.transfer.internal;

import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.ProgressListener;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ProgressListenerChain implements ProgressListener {
    private static final Log log;
    private final List<ProgressListener> listeners;

    static {
        log = LogFactory.getLog(ProgressListenerChain.class);
    }

    public ProgressListenerChain(ProgressListener... progressListenerArr) {
        this.listeners = new ArrayList();
        for (ProgressListener addProgressListener : progressListenerArr) {
            addProgressListener(addProgressListener);
        }
    }

    public synchronized void addProgressListener(ProgressListener progressListener) {
        if (progressListener != null) {
            this.listeners.add(progressListener);
        }
    }

    public void progressChanged(ProgressEvent progressEvent) {
        for (ProgressListener progressChanged : this.listeners) {
            try {
                progressChanged.progressChanged(progressEvent);
            } catch (Throwable th) {
                log.warn("Couldn't update progress listener", th);
            }
        }
    }

    public synchronized void removeProgressListener(ProgressListener progressListener) {
        if (progressListener != null) {
            this.listeners.remove(progressListener);
        }
    }
}
