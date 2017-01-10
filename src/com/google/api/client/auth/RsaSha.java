package com.google.api.client.auth;

import com.google.api.client.util.Base64;
import com.google.api.client.util.Strings;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;

public class RsaSha {
    private static final String BEGIN = "-----BEGIN PRIVATE KEY-----";
    private static final String END = "-----END PRIVATE KEY-----";

    private RsaSha() {
    }

    public static PrivateKey getPrivateKeyFromKeystore(InputStream keyStream, String storePass, String alias, String keyPass) throws IOException, GeneralSecurityException {
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        try {
            keyStore.load(keyStream, storePass.toCharArray());
            PrivateKey privateKey = (PrivateKey) keyStore.getKey(alias, keyPass.toCharArray());
            return privateKey;
        } finally {
            keyStream.close();
        }
    }

    public static PrivateKey getPrivateKeyFromPk8(File file) throws IOException, GeneralSecurityException {
        byte[] privKeyBytes = new byte[((int) file.length())];
        DataInputStream inputStream = new DataInputStream(new FileInputStream(file));
        try {
            inputStream.readFully(privKeyBytes);
            String str = new String(privKeyBytes);
            if (str.startsWith(BEGIN) && str.endsWith(END)) {
                str = str.substring(BEGIN.length(), str.lastIndexOf(END));
            }
            return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(Base64.decode(Strings.toBytesUtf8(str))));
        } finally {
            inputStream.close();
        }
    }

    public static String sign(PrivateKey privateKey, String data) throws GeneralSecurityException {
        Signature signature = Signature.getInstance("SHA1withRSA");
        signature.initSign(privateKey);
        signature.update(Strings.toBytesUtf8(data));
        return Strings.fromBytesUtf8(Base64.encode(signature.sign()));
    }
}
