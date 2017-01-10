package com.amazonaws.services.s3.model;

import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;

public class EncryptionMaterials {
    private KeyPair keyPair;
    private SecretKey symmetricKey;

    public EncryptionMaterials(KeyPair keyPair) {
        this(keyPair, null);
    }

    protected EncryptionMaterials(KeyPair keyPair, SecretKey secretKey) {
        this.keyPair = keyPair;
        this.symmetricKey = secretKey;
    }

    public EncryptionMaterials(SecretKey secretKey) {
        this(null, secretKey);
    }

    public EncryptionMaterialsAccessor getAccessor() {
        return null;
    }

    public KeyPair getKeyPair() {
        return this.keyPair;
    }

    public Map<String, String> getMaterialsDescription() {
        return new HashMap();
    }

    public SecretKey getSymmetricKey() {
        return this.symmetricKey;
    }
}
