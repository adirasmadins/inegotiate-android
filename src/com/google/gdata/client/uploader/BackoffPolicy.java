package com.google.gdata.client.uploader;

public interface BackoffPolicy {
    public static final BackoffPolicy DEFAULT;
    public static final long STOP = -1;

    /* renamed from: com.google.gdata.client.uploader.BackoffPolicy.1 */
    static class C07141 implements BackoffPolicy {
        private static final long BACKOFF_DELAY_LIMIT_MS = 64000;
        private static final long BACKOFF_FACTOR = 2;
        private static final long INITIAL_BACKOFF_MS = 500;
        private long backoffMs;

        public long getNextBackoffMs() {
            long returnValueMs = this.backoffMs;
            long nextBackoffMs = this.backoffMs * BACKOFF_FACTOR;
            if (nextBackoffMs > BACKOFF_DELAY_LIMIT_MS) {
                nextBackoffMs = BACKOFF_DELAY_LIMIT_MS;
            }
            this.backoffMs = nextBackoffMs;
            return returnValueMs;
        }

        C07141() {
            this.backoffMs = INITIAL_BACKOFF_MS;
        }

        public void reset() {
            this.backoffMs = INITIAL_BACKOFF_MS;
        }
    }

    long getNextBackoffMs();

    void reset();

    static {
        DEFAULT = new C07141();
    }
}
