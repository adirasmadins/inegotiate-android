package com.amazonaws.services.s3.internal.crypto;

import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class EncryptionInstruction {
    private final byte[] encryptedSymmetricKey;
    private final Map<String, String> materialsDescription;
    private final Cipher symmetricCipher;
    private final SecretKey symmetricKey;

    public EncryptionInstruction(Map<String, String> map, byte[] bArr, SecretKey secretKey, Cipher cipher) {
        this.materialsDescription = map;
        this.encryptedSymmetricKey = bArr;
        this.symmetricKey = secretKey;
        this.symmetricCipher = cipher;
    }

    public byte[] getEncryptedSymmetricKey() {
        return this.encryptedSymmetricKey;
    }

    public Map<String, String> getMaterialsDescription() {
        return this.materialsDescription;
    }

    public Cipher getSymmetricCipher() {
        return this.symmetricCipher;
    }

    public SecretKey getSymmetricKey() {
        return this.symmetricKey;
    }
}
