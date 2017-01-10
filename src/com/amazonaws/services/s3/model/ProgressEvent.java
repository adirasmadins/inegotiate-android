package com.amazonaws.services.s3.model;

public class ProgressEvent {
    public static final int CANCELED_EVENT_CODE = 8;
    public static final int COMPLETED_EVENT_CODE = 2;
    public static final int FAILED_EVENT_CODE = 4;
    public static final int PART_COMPLETED_EVENT_CODE = 2048;
    public static final int PART_FAILED_EVENT_CODE = 4096;
    public static final int PART_STARTED_EVENT_CODE = 1024;
    public static final int STARTED_EVENT_CODE = 1;
    private int bytesTransfered;
    private int eventCode;

    public ProgressEvent(int i) {
        this.bytesTransfered = i;
    }

    public int getBytesTransfered() {
        return this.bytesTransfered;
    }

    public int getEventCode() {
        return this.eventCode;
    }

    public void setBytesTransfered(int i) {
        this.bytesTransfered = i;
    }

    public void setEventCode(int i) {
        this.eventCode = i;
    }
}
