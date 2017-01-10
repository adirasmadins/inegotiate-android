package com.amazonaws.http;

import com.amazonaws.ClientConfiguration;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.NTCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

class HttpClientFactory {
    HttpClientFactory() {
    }

    public HttpClient createHttpClient(ClientConfiguration clientConfiguration) {
        String userAgent = clientConfiguration.getUserAgent();
        if (!userAgent.equals(ClientConfiguration.DEFAULT_USER_AGENT)) {
            userAgent = userAgent + ", " + ClientConfiguration.DEFAULT_USER_AGENT;
        }
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpClientParams.setRedirecting(basicHttpParams, false);
        HttpProtocolParams.setUserAgent(basicHttpParams, userAgent);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, clientConfiguration.getConnectionTimeout());
        HttpConnectionParams.setSoTimeout(basicHttpParams, clientConfiguration.getSocketTimeout());
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        int i = clientConfiguration.getSocketBufferSizeHints()[0];
        int i2 = clientConfiguration.getSocketBufferSizeHints()[1];
        if (i > 0 || i2 > 0) {
            HttpConnectionParams.setSocketBufferSize(basicHttpParams, Math.max(i, i2));
        }
        HttpClient defaultHttpClient = new DefaultHttpClient(ConnectionManagerFactory.createThreadSafeClientConnManager(clientConfiguration, basicHttpParams), basicHttpParams);
        userAgent = clientConfiguration.getProxyHost();
        int proxyPort = clientConfiguration.getProxyPort();
        if (userAgent != null && proxyPort > 0) {
            AmazonHttpClient.log.info("Configuring Proxy. Proxy Host: " + userAgent + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + "Proxy Port: " + proxyPort);
            defaultHttpClient.getParams().setParameter("http.route.default-proxy", new HttpHost(userAgent, proxyPort));
            String proxyUsername = clientConfiguration.getProxyUsername();
            String proxyPassword = clientConfiguration.getProxyPassword();
            String proxyDomain = clientConfiguration.getProxyDomain();
            String proxyWorkstation = clientConfiguration.getProxyWorkstation();
            if (!(proxyUsername == null || proxyPassword == null)) {
                defaultHttpClient.getCredentialsProvider().setCredentials(new AuthScope(userAgent, proxyPort), new NTCredentials(proxyUsername, proxyPassword, proxyWorkstation, proxyDomain));
            }
        }
        return defaultHttpClient;
    }
}
