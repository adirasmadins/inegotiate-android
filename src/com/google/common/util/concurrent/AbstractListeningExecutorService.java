package com.google.common.util.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

abstract class AbstractListeningExecutorService implements ListeningExecutorService {
    AbstractListeningExecutorService() {
    }

    public ListenableFuture<?> submit(Runnable task) {
        ListenableFutureTask<Void> ftask = ListenableFutureTask.create(task, null);
        execute(ftask);
        return ftask;
    }

    public <T> ListenableFuture<T> submit(Runnable task, T result) {
        ListenableFutureTask<T> ftask = ListenableFutureTask.create(task, result);
        execute(ftask);
        return ftask;
    }

    public <T> ListenableFuture<T> submit(Callable<T> task) {
        ListenableFutureTask<T> ftask = ListenableFutureTask.create(task);
        execute(ftask);
        return ftask;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T doInvokeAny(java.util.Collection<? extends java.util.concurrent.Callable<T>> r21, boolean r22, long r23) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
        r20 = this;
        r16 = r21.size();
        if (r16 <= 0) goto L_0x0076;
    L_0x0006:
        r18 = 1;
    L_0x0008:
        com.google.common.base.Preconditions.checkArgument(r18);
        r9 = new java.util.ArrayList;
        r0 = r16;
        r9.<init>(r0);
        r4 = new java.util.concurrent.ExecutorCompletionService;
        r0 = r20;
        r4.<init>(r0);
        r5 = 0;
        if (r22 == 0) goto L_0x0079;
    L_0x001c:
        r12 = java.lang.System.nanoTime();	 Catch:{ all -> 0x008a }
    L_0x0020:
        r11 = r21.iterator();	 Catch:{ all -> 0x008a }
        r18 = r11.next();	 Catch:{ all -> 0x008a }
        r18 = (java.util.concurrent.Callable) r18;	 Catch:{ all -> 0x008a }
        r0 = r18;
        r18 = r4.submit(r0);	 Catch:{ all -> 0x008a }
        r0 = r18;
        r9.add(r0);	 Catch:{ all -> 0x008a }
        r16 = r16 + -1;
        r3 = 1;
        r6 = r5;
    L_0x0039:
        r8 = r4.poll();	 Catch:{ all -> 0x00b7 }
        if (r8 != 0) goto L_0x0056;
    L_0x003f:
        if (r16 <= 0) goto L_0x007c;
    L_0x0041:
        r16 = r16 + -1;
        r18 = r11.next();	 Catch:{ all -> 0x00b7 }
        r18 = (java.util.concurrent.Callable) r18;	 Catch:{ all -> 0x00b7 }
        r0 = r18;
        r18 = r4.submit(r0);	 Catch:{ all -> 0x00b7 }
        r0 = r18;
        r9.add(r0);	 Catch:{ all -> 0x00b7 }
        r3 = r3 + 1;
    L_0x0056:
        if (r8 == 0) goto L_0x00db;
    L_0x0058:
        r3 = r3 + -1;
        r18 = r8.get();	 Catch:{ ExecutionException -> 0x00c9, RuntimeException -> 0x00ce }
        r10 = r9.iterator();
    L_0x0062:
        r19 = r10.hasNext();
        if (r19 == 0) goto L_0x00d8;
    L_0x0068:
        r8 = r10.next();
        r8 = (java.util.concurrent.Future) r8;
        r19 = 1;
        r0 = r19;
        r8.cancel(r0);
        goto L_0x0062;
    L_0x0076:
        r18 = 0;
        goto L_0x0008;
    L_0x0079:
        r12 = 0;
        goto L_0x0020;
    L_0x007c:
        if (r3 != 0) goto L_0x00a3;
    L_0x007e:
        if (r6 != 0) goto L_0x00d9;
    L_0x0080:
        r5 = new java.util.concurrent.ExecutionException;	 Catch:{ all -> 0x00b7 }
        r18 = 0;
        r0 = r18;
        r5.<init>(r0);	 Catch:{ all -> 0x00b7 }
    L_0x0089:
        throw r5;	 Catch:{ all -> 0x008a }
    L_0x008a:
        r18 = move-exception;
    L_0x008b:
        r10 = r9.iterator();
    L_0x008f:
        r19 = r10.hasNext();
        if (r19 == 0) goto L_0x00d7;
    L_0x0095:
        r8 = r10.next();
        r8 = (java.util.concurrent.Future) r8;
        r19 = 1;
        r0 = r19;
        r8.cancel(r0);
        goto L_0x008f;
    L_0x00a3:
        if (r22 == 0) goto L_0x00c4;
    L_0x00a5:
        r18 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{ all -> 0x00b7 }
        r0 = r23;
        r2 = r18;
        r8 = r4.poll(r0, r2);	 Catch:{ all -> 0x00b7 }
        if (r8 != 0) goto L_0x00ba;
    L_0x00b1:
        r18 = new java.util.concurrent.TimeoutException;	 Catch:{ all -> 0x00b7 }
        r18.<init>();	 Catch:{ all -> 0x00b7 }
        throw r18;	 Catch:{ all -> 0x00b7 }
    L_0x00b7:
        r18 = move-exception;
        r5 = r6;
        goto L_0x008b;
    L_0x00ba:
        r14 = java.lang.System.nanoTime();	 Catch:{ all -> 0x00b7 }
        r18 = r14 - r12;
        r23 = r23 - r18;
        r12 = r14;
        goto L_0x0056;
    L_0x00c4:
        r8 = r4.take();	 Catch:{ all -> 0x00b7 }
        goto L_0x0056;
    L_0x00c9:
        r7 = move-exception;
        r5 = r7;
    L_0x00cb:
        r6 = r5;
        goto L_0x0039;
    L_0x00ce:
        r17 = move-exception;
        r5 = new java.util.concurrent.ExecutionException;	 Catch:{ all -> 0x00b7 }
        r0 = r17;
        r5.<init>(r0);	 Catch:{ all -> 0x00b7 }
        goto L_0x00cb;
    L_0x00d7:
        throw r18;
    L_0x00d8:
        return r18;
    L_0x00d9:
        r5 = r6;
        goto L_0x0089;
    L_0x00db:
        r5 = r6;
        goto L_0x00cb;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractListeningExecutorService.doInvokeAny(java.util.Collection, boolean, long):T");
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
        try {
            return doInvokeAny(tasks, false, 0);
        } catch (TimeoutException e) {
            throw new AssertionError();
        }
    }

    public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return doInvokeAny(tasks, true, unit.toNanos(timeout));
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
        if (tasks == null) {
            throw new NullPointerException();
        }
        List<Future<T>> futures = new ArrayList(tasks.size());
        try {
            for (Callable<T> t : tasks) {
                ListenableFutureTask<T> f = ListenableFutureTask.create(t);
                futures.add(f);
                execute(f);
            }
            for (Future<T> f2 : futures) {
                if (!f2.isDone()) {
                    try {
                        f2.get();
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    }
                }
            }
            if (!true) {
                for (Future<T> f22 : futures) {
                    f22.cancel(true);
                }
            }
            return futures;
        } catch (Throwable th) {
            if (!false) {
                for (Future<T> f222 : futures) {
                    f222.cancel(true);
                }
            }
        }
    }

    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
        if (tasks == null || unit == null) {
            throw new NullPointerException();
        }
        long nanos = unit.toNanos(timeout);
        List<Future<T>> futures = new ArrayList(tasks.size());
        try {
            long now;
            for (Callable<T> t : tasks) {
                futures.add(ListenableFutureTask.create(t));
            }
            long lastTime = System.nanoTime();
            Iterator<Future<T>> it = futures.iterator();
            while (it.hasNext()) {
                execute((Runnable) it.next());
                now = System.nanoTime();
                nanos -= now - lastTime;
                lastTime = now;
                if (nanos <= 0) {
                    if (null == null) {
                        for (Future<T> f : futures) {
                            f.cancel(true);
                        }
                    }
                    return futures;
                }
            }
            for (Future<T> f2 : futures) {
                if (!f2.isDone()) {
                    if (nanos <= 0) {
                        if (null == null) {
                            for (Future<T> f22 : futures) {
                                f22.cancel(true);
                            }
                        }
                        return futures;
                    }
                    try {
                        f22.get(nanos, TimeUnit.NANOSECONDS);
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    } catch (TimeoutException e3) {
                        if (null == null) {
                            for (Future<T> f222 : futures) {
                                f222.cancel(true);
                            }
                        }
                    }
                    now = System.nanoTime();
                    nanos -= now - lastTime;
                    lastTime = now;
                }
            }
            if (!true) {
                for (Future<T> f2222 : futures) {
                    f2222.cancel(true);
                }
            }
            return futures;
        } catch (Throwable th) {
            if (null == null) {
                for (Future<T> f22222 : futures) {
                    f22222.cancel(true);
                }
            }
        }
    }
}
