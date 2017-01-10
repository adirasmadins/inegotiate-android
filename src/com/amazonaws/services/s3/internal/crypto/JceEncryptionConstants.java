package com.amazonaws.services.s3.internal.crypto;

public class JceEncryptionConstants {
    public static int SYMMETRIC_CIPHER_BLOCK_SIZE;
    public static String SYMMETRIC_CIPHER_METHOD;
    public static String SYMMETRIC_KEY_ALGORITHM;
    public static int SYMMETRIC_KEY_LENGTH;

    static {
        SYMMETRIC_KEY_ALGORITHM = "AES";
        SYMMETRIC_CIPHER_METHOD = "AES/CBC/PKCS5Padding";
        SYMMETRIC_KEY_LENGTH = 256;
        SYMMETRIC_CIPHER_BLOCK_SIZE = 16;
    }
}
