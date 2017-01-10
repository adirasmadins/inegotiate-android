package com.google.common.cache;

import com.google.common.annotations.Beta;
import java.util.concurrent.Executor;

@Beta
public final class RemovalListeners {

    /* renamed from: com.google.common.cache.RemovalListeners.1 */
    static class C03981 implements RemovalListener<K, V> {
        final /* synthetic */ Executor val$executor;
        final /* synthetic */ RemovalListener val$listener;

        /* renamed from: com.google.common.cache.RemovalListeners.1.1 */
        class C03971 implements Runnable {
            final /* synthetic */ RemovalNotification val$notification;

            C03971(RemovalNotification removalNotification) {
                this.val$notification = removalNotification;
            }

            public void run() {
                C03981.this.val$listener.onRemoval(this.val$notification);
            }
        }

        C03981(Executor executor, RemovalListener removalListener) {
            this.val$executor = executor;
            this.val$listener = removalListener;
        }

        public void onRemoval(RemovalNotification<K, V> notification) {
            this.val$executor.execute(new C03971(notification));
        }
    }

    private RemovalListeners() {
    }

    public static <K, V> RemovalListener<K, V> asynchronous(RemovalListener<K, V> listener, Executor executor) {
        return new C03981(executor, listener);
    }
}
