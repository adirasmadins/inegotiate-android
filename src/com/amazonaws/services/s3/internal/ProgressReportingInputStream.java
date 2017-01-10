package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.model.ProgressEvent;
import com.amazonaws.services.s3.model.ProgressListener;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProgressReportingInputStream extends FilterInputStream {
    private static final int NOTIFICATION_THRESHOLD = 8192;
    private boolean fireCompletedEvent;
    private final ProgressListener listener;
    private int unnotifiedByteCount;

    public ProgressReportingInputStream(InputStream inputStream, ProgressListener progressListener) {
        super(inputStream);
        this.listener = progressListener;
    }

    private void notify(int i) {
        this.unnotifiedByteCount += i;
        if (this.unnotifiedByteCount >= NOTIFICATION_THRESHOLD) {
            this.listener.progressChanged(new ProgressEvent(this.unnotifiedByteCount));
            this.unnotifiedByteCount = 0;
        }
    }

    private void notifyCompleted() {
        if (this.fireCompletedEvent) {
            ProgressEvent progressEvent = new ProgressEvent(this.unnotifiedByteCount);
            progressEvent.setEventCode(2);
            this.unnotifiedByteCount = 0;
            this.listener.progressChanged(progressEvent);
        }
    }

    public void close() throws IOException {
        if (this.unnotifiedByteCount > 0) {
            this.listener.progressChanged(new ProgressEvent(this.unnotifiedByteCount));
            this.unnotifiedByteCount = 0;
        }
        super.close();
    }

    public boolean getFireCompletedEvent() {
        return this.fireCompletedEvent;
    }

    public int read() throws IOException {
        int read = super.read();
        if (read == -1) {
            notifyCompleted();
        }
        if (read != -1) {
            notify(1);
        }
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = super.read(bArr, i, i2);
        if (read == -1) {
            notifyCompleted();
        }
        if (read != -1) {
            notify(read);
        }
        return read;
    }

    public void setFireCompletedEvent(boolean z) {
        this.fireCompletedEvent = z;
    }
}
