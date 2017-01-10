package com.google.api.client.escape;

import com.amazonaws.services.s3.model.ProgressEvent;

final class Platform {
    private static final ThreadLocal<char[]> DEST_TL;

    /* renamed from: com.google.api.client.escape.Platform.1 */
    static class C03281 extends ThreadLocal<char[]> {
        C03281() {
        }

        protected char[] initialValue() {
            return new char[ProgressEvent.PART_STARTED_EVENT_CODE];
        }
    }

    private Platform() {
    }

    static char[] charBufferFromThreadLocal() {
        return (char[]) DEST_TL.get();
    }

    static {
        DEST_TL = new C03281();
    }
}
