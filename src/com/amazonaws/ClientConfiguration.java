package com.amazonaws;

import com.amazonaws.util.VersionInfoUtils;

public class ClientConfiguration {
    public static final int DEFAULT_MAX_CONNECTIONS = 50;
    public static final int DEFAULT_MAX_RETRIES = 3;
    public static final int DEFAULT_SOCKET_TIMEOUT = 50000;
    public static final String DEFAULT_USER_AGENT;
    private int connectionTimeout;
    private int maxConnections;
    private int maxErrorRetry;
    private Protocol protocol;
    private String proxyDomain;
    private String proxyHost;
    private String proxyPassword;
    private int proxyPort;
    private String proxyUsername;
    private String proxyWorkstation;
    private int socketReceiveBufferSizeHint;
    private int socketSendBufferSizeHint;
    private int socketTimeout;
    private String userAgent;

    static {
        DEFAULT_USER_AGENT = VersionInfoUtils.getUserAgent();
    }

    public ClientConfiguration() {
        this.userAgent = DEFAULT_USER_AGENT;
        this.maxErrorRetry = DEFAULT_MAX_RETRIES;
        this.protocol = Protocol.HTTPS;
        this.proxyHost = null;
        this.proxyPort = -1;
        this.proxyUsername = null;
        this.proxyPassword = null;
        this.proxyDomain = null;
        this.proxyWorkstation = null;
        this.maxConnections = DEFAULT_MAX_CONNECTIONS;
        this.socketTimeout = DEFAULT_SOCKET_TIMEOUT;
        this.connectionTimeout = DEFAULT_SOCKET_TIMEOUT;
        this.socketSendBufferSizeHint = 0;
        this.socketReceiveBufferSizeHint = 0;
    }

    public ClientConfiguration(ClientConfiguration clientConfiguration) {
        this.userAgent = DEFAULT_USER_AGENT;
        this.maxErrorRetry = DEFAULT_MAX_RETRIES;
        this.protocol = Protocol.HTTPS;
        this.proxyHost = null;
        this.proxyPort = -1;
        this.proxyUsername = null;
        this.proxyPassword = null;
        this.proxyDomain = null;
        this.proxyWorkstation = null;
        this.maxConnections = DEFAULT_MAX_CONNECTIONS;
        this.socketTimeout = DEFAULT_SOCKET_TIMEOUT;
        this.connectionTimeout = DEFAULT_SOCKET_TIMEOUT;
        this.socketSendBufferSizeHint = 0;
        this.socketReceiveBufferSizeHint = 0;
        this.connectionTimeout = clientConfiguration.connectionTimeout;
        this.maxConnections = clientConfiguration.maxConnections;
        this.maxErrorRetry = clientConfiguration.maxErrorRetry;
        this.protocol = clientConfiguration.protocol;
        this.proxyDomain = clientConfiguration.proxyDomain;
        this.proxyHost = clientConfiguration.proxyHost;
        this.proxyPassword = clientConfiguration.proxyPassword;
        this.proxyPort = clientConfiguration.proxyPort;
        this.proxyUsername = clientConfiguration.proxyUsername;
        this.proxyWorkstation = clientConfiguration.proxyWorkstation;
        this.socketTimeout = clientConfiguration.socketTimeout;
        this.userAgent = clientConfiguration.userAgent;
        this.socketReceiveBufferSizeHint = clientConfiguration.socketReceiveBufferSizeHint;
        this.socketSendBufferSizeHint = clientConfiguration.socketSendBufferSizeHint;
    }

    public int getConnectionTimeout() {
        return this.connectionTimeout;
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public int getMaxErrorRetry() {
        return this.maxErrorRetry;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public String getProxyDomain() {
        return this.proxyDomain;
    }

    public String getProxyHost() {
        return this.proxyHost;
    }

    public String getProxyPassword() {
        return this.proxyPassword;
    }

    public int getProxyPort() {
        return this.proxyPort;
    }

    public String getProxyUsername() {
        return this.proxyUsername;
    }

    public String getProxyWorkstation() {
        return this.proxyWorkstation;
    }

    public int[] getSocketBufferSizeHints() {
        return new int[]{this.socketSendBufferSizeHint, this.socketReceiveBufferSizeHint};
    }

    public int getSocketTimeout() {
        return this.socketTimeout;
    }

    public String getUserAgent() {
        return this.userAgent;
    }

    public void setConnectionTimeout(int i) {
        this.connectionTimeout = i;
    }

    public void setMaxConnections(int i) {
        this.maxConnections = i;
    }

    public void setMaxErrorRetry(int i) {
        this.maxErrorRetry = i;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public void setProxyDomain(String str) {
        this.proxyDomain = str;
    }

    public void setProxyHost(String str) {
        this.proxyHost = str;
    }

    public void setProxyPassword(String str) {
        this.proxyPassword = str;
    }

    public void setProxyPort(int i) {
        this.proxyPort = i;
    }

    public void setProxyUsername(String str) {
        this.proxyUsername = str;
    }

    public void setProxyWorkstation(String str) {
        this.proxyWorkstation = str;
    }

    public void setSocketBufferSizeHints(int i, int i2) {
        this.socketSendBufferSizeHint = i;
        this.socketReceiveBufferSizeHint = i2;
    }

    public void setSocketTimeout(int i) {
        this.socketTimeout = i;
    }

    public void setUserAgent(String str) {
        this.userAgent = str;
    }

    public ClientConfiguration withConnectionTimeout(int i) {
        setConnectionTimeout(i);
        return this;
    }

    public ClientConfiguration withMaxConnections(int i) {
        setMaxConnections(i);
        return this;
    }

    public ClientConfiguration withMaxErrorRetry(int i) {
        setMaxErrorRetry(i);
        return this;
    }

    public ClientConfiguration withProtocol(Protocol protocol) {
        setProtocol(protocol);
        return this;
    }

    public ClientConfiguration withProxyDomain(String str) {
        setProxyDomain(str);
        return this;
    }

    public ClientConfiguration withProxyHost(String str) {
        setProxyHost(str);
        return this;
    }

    public ClientConfiguration withProxyPassword(String str) {
        setProxyPassword(str);
        return this;
    }

    public ClientConfiguration withProxyPort(int i) {
        setProxyPort(i);
        return this;
    }

    public ClientConfiguration withProxyUsername(String str) {
        setProxyUsername(str);
        return this;
    }

    public ClientConfiguration withProxyWorkstation(String str) {
        setProxyWorkstation(str);
        return this;
    }

    public ClientConfiguration withSocketBufferSizeHints(int i, int i2) {
        setSocketBufferSizeHints(i, i2);
        return this;
    }

    public ClientConfiguration withSocketTimeout(int i) {
        setSocketTimeout(i);
        return this;
    }

    public ClientConfiguration withUserAgent(String str) {
        setUserAgent(str);
        return this;
    }
}
