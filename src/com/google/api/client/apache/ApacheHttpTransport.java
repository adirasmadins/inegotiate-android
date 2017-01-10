package com.google.api.client.apache;

import com.amazonaws.javax.xml.stream.xerces.impl.io.UCSReader;
import com.google.api.client.http.LowLevelHttpTransport;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public final class ApacheHttpTransport extends LowLevelHttpTransport {
    public static final ApacheHttpTransport INSTANCE;
    public final HttpClient httpClient;

    static {
        INSTANCE = new ApacheHttpTransport();
    }

    ApacheHttpTransport() {
        HttpParams params = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(params, false);
        HttpConnectionParams.setConnectionTimeout(params, 20000);
        HttpConnectionParams.setSoTimeout(params, 20000);
        HttpConnectionParams.setSocketBufferSize(params, UCSReader.DEFAULT_BUFFER_SIZE);
        ConnManagerParams.setTimeout(params, 20000);
        params.setBooleanParameter("http.protocol.handle-redirects", false);
        SchemeRegistry registry = new SchemeRegistry();
        registry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        registry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        this.httpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(params, registry), params);
    }

    public boolean supportsHead() {
        return true;
    }

    public boolean supportsPatch() {
        return true;
    }

    public ApacheHttpRequest buildDeleteRequest(String url) {
        return new ApacheHttpRequest(this.httpClient, new HttpDelete(url));
    }

    public ApacheHttpRequest buildGetRequest(String url) {
        return new ApacheHttpRequest(this.httpClient, new HttpGet(url));
    }

    public ApacheHttpRequest buildHeadRequest(String url) {
        return new ApacheHttpRequest(this.httpClient, new HttpHead(url));
    }

    public ApacheHttpRequest buildPatchRequest(String url) {
        return new ApacheHttpRequest(this.httpClient, new HttpPatch(url));
    }

    public ApacheHttpRequest buildPostRequest(String url) {
        return new ApacheHttpRequest(this.httpClient, new HttpPost(url));
    }

    public ApacheHttpRequest buildPutRequest(String url) {
        return new ApacheHttpRequest(this.httpClient, new HttpPut(url));
    }
}
