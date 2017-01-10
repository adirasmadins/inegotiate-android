package com.paypal.android.p003a;

import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* renamed from: com.paypal.android.a.c */
public final class C0920c extends SSLSocketFactory {
    private javax.net.ssl.SSLSocketFactory f809a;

    public C0920c() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException {
        super(null);
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init(null, new TrustManager[]{new C0935p()}, null);
            this.f809a = instance.getSocketFactory();
            setHostnameVerifier(new AllowAllHostnameVerifier());
        } catch (Exception e) {
        }
    }

    public final Socket createSocket() throws IOException {
        return this.f809a.createSocket();
    }

    public final Socket createSocket(Socket socket, String str, int i, boolean z) throws IOException {
        return this.f809a.createSocket(socket, str, i, z);
    }
}
