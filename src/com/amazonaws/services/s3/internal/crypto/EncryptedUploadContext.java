package com.amazonaws.services.s3.internal.crypto;

import javax.crypto.SecretKey;

public class EncryptedUploadContext {
    private final String bucketName;
    private final SecretKey envelopeEncryptionKey;
    private byte[] firstIV;
    private boolean hasFinalPartBeenSeen;
    private final String key;
    private byte[] nextIV;

    public EncryptedUploadContext(String str, String str2, SecretKey secretKey) {
        this.bucketName = str;
        this.key = str2;
        this.envelopeEncryptionKey = secretKey;
    }

    public String getBucketName() {
        return this.bucketName;
    }

    public SecretKey getEnvelopeEncryptionKey() {
        return this.envelopeEncryptionKey;
    }

    public byte[] getFirstInitializationVector() {
        return this.firstIV;
    }

    public String getKey() {
        return this.key;
    }

    public byte[] getNextInitializationVector() {
        return this.nextIV;
    }

    public boolean hasFinalPartBeenSeen() {
        return this.hasFinalPartBeenSeen;
    }

    public void setFirstInitializationVector(byte[] bArr) {
        this.firstIV = bArr;
    }

    public void setHasFinalPartBeenSeen(boolean z) {
        this.hasFinalPartBeenSeen = z;
    }

    public void setNextInitializationVector(byte[] bArr) {
        this.nextIV = bArr;
    }
}
