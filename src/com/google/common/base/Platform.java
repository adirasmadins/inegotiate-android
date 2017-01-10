package com.google.common.base;

import com.amazonaws.services.s3.model.ProgressEvent;
import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
final class Platform {
    private static final ThreadLocal<char[]> DEST_TL;

    /* renamed from: com.google.common.base.Platform.1 */
    static class C03521 extends ThreadLocal<char[]> {
        C03521() {
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

    static long systemNanoTime() {
        return System.nanoTime();
    }

    static {
        DEST_TL = new C03521();
    }

    static CharMatcher precomputeCharMatcher(CharMatcher matcher) {
        return matcher.precomputedInternal();
    }
}
