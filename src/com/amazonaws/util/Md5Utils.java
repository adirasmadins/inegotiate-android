package com.amazonaws.util;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Md5Utils {
    public static byte[] computeMD5Hash(InputStream inputStream) throws NoSuchAlgorithmException, IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[16384];
            while (true) {
                int read = bufferedInputStream.read(bArr, 0, bArr.length);
                if (read == -1) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            return digest;
        } finally {
            try {
                bufferedInputStream.close();
            } catch (Exception e) {
                System.err.println("Unable to close input stream of hash candidate: " + e);
            }
        }
    }

    public static byte[] computeMD5Hash(byte[] bArr) throws NoSuchAlgorithmException, IOException {
        return computeMD5Hash(new ByteArrayInputStream(bArr));
    }
}
