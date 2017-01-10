package com.amazonaws.http;

import java.util.ArrayList;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.conn.ClientConnectionManager;

public class IdleConnectionReaper extends Thread {
    private static final int PERIOD_MILLISECONDS = 60000;
    private static ArrayList<ClientConnectionManager> connectionManagers;
    private static IdleConnectionReaper instance;
    static final Log log;

    static {
        connectionManagers = new ArrayList();
        log = LogFactory.getLog(IdleConnectionReaper.class);
    }

    private IdleConnectionReaper() {
        super("java-sdk-http-connection-reaper");
        setDaemon(true);
        start();
    }

    public static synchronized void registerConnectionManager(ClientConnectionManager clientConnectionManager) {
        synchronized (IdleConnectionReaper.class) {
            if (instance == null) {
                instance = new IdleConnectionReaper();
            }
            connectionManagers.add(clientConnectionManager);
        }
    }

    public static synchronized void removeConnectionManager(ClientConnectionManager clientConnectionManager) {
        synchronized (IdleConnectionReaper.class) {
            connectionManagers.remove(clientConnectionManager);
        }
    }

    public static synchronized void shutdown() {
        synchronized (IdleConnectionReaper.class) {
            if (instance != null) {
                instance.interrupt();
                connectionManagers.clear();
                instance = null;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r5 = this;
    L_0x0000:
        r0 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0033 }
        r1 = com.amazonaws.http.IdleConnectionReaper.class;
        monitor-enter(r1);	 Catch:{ InterruptedException -> 0x0033 }
        r0 = connectionManagers;	 Catch:{ all -> 0x003c }
        r0 = r0.clone();	 Catch:{ all -> 0x003c }
        r0 = (java.util.List) r0;	 Catch:{ all -> 0x003c }
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        r1 = r0.iterator();	 Catch:{ InterruptedException -> 0x0033 }
    L_0x0016:
        r0 = r1.hasNext();	 Catch:{ InterruptedException -> 0x0033 }
        if (r0 == 0) goto L_0x0000;
    L_0x001c:
        r0 = r1.next();	 Catch:{ InterruptedException -> 0x0033 }
        r0 = (org.apache.http.conn.ClientConnectionManager) r0;	 Catch:{ InterruptedException -> 0x0033 }
        r2 = 60;
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ Throwable -> 0x002a }
        r0.closeIdleConnections(r2, r4);	 Catch:{ Throwable -> 0x002a }
        goto L_0x0016;
    L_0x002a:
        r0 = move-exception;
        r2 = log;	 Catch:{ InterruptedException -> 0x0033 }
        r3 = "Unable to close idle connections";
        r2.warn(r3, r0);	 Catch:{ InterruptedException -> 0x0033 }
        goto L_0x0016;
    L_0x0033:
        r0 = move-exception;
        r0 = java.lang.Thread.currentThread();
        r0.interrupt();
        return;
    L_0x003c:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003c }
        throw r0;	 Catch:{ InterruptedException -> 0x0033 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.IdleConnectionReaper.run():void");
    }
}
