package com.amazonaws.services.s3.model;

import java.security.Provider;

public class CryptoConfiguration {
    private Provider cryptoProvider;
    private CryptoStorageMode storageMode;

    public CryptoConfiguration() {
        this.storageMode = CryptoStorageMode.ObjectMetadata;
        this.cryptoProvider = null;
    }

    public Provider getCryptoProvider() {
        return this.cryptoProvider;
    }

    public CryptoStorageMode getStorageMode() {
        return this.storageMode;
    }

    public void setCryptoProvider(Provider provider) {
        this.cryptoProvider = provider;
    }

    public void setStorageMode(CryptoStorageMode cryptoStorageMode) {
        this.storageMode = cryptoStorageMode;
    }

    public CryptoConfiguration withCryptoProvider(Provider provider) {
        this.cryptoProvider = provider;
        return this;
    }

    public CryptoConfiguration withStorageMode(CryptoStorageMode cryptoStorageMode) {
        this.storageMode = cryptoStorageMode;
        return this;
    }
}
