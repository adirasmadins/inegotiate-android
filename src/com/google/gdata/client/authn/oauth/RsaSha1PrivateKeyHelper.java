package com.google.gdata.client.authn.oauth;

import com.google.gdata.util.common.util.Base64;
import com.google.gdata.util.common.util.Base64DecoderException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;

public class RsaSha1PrivateKeyHelper {
    private RsaSha1PrivateKeyHelper() {
    }

    public static PrivateKey getPrivateKeyFromFilename(String filename) throws Base64DecoderException, InvalidKeySpecException, IOException, NoSuchAlgorithmException {
        return getPrivateKey(new File(filename));
    }

    public static PrivateKey getPrivateKey(File file) throws Base64DecoderException, InvalidKeySpecException, IOException, NoSuchAlgorithmException {
        return getPrivateKey(new BufferedReader(new FileReader(file)));
    }

    public static PrivateKey getPrivateKey(Reader privateKeyReader) throws Base64DecoderException, InvalidKeySpecException, IOException, NoSuchAlgorithmException {
        return getPrivateKey(readToString(privateKeyReader));
    }

    public static PrivateKey getPrivateKey(String privateKeyString) throws Base64DecoderException, InvalidKeySpecException, NoSuchAlgorithmException {
        String begin = "-----BEGIN PRIVATE KEY-----";
        String end = "-----END PRIVATE KEY-----";
        if (privateKeyString.contains(begin) && privateKeyString.contains(end)) {
            privateKeyString = privateKeyString.substring(begin.length(), privateKeyString.lastIndexOf(end));
        }
        return getPrivateKey(Base64.decode(privateKeyString));
    }

    public static PrivateKey getPrivateKey(byte[] privateKeyBytes) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(privateKeyBytes));
    }

    private static String readToString(Reader in) throws IOException {
        StringBuffer buf = new StringBuffer();
        try {
            int c = in.read();
            while (c != -1) {
                buf.append((char) c);
                c = in.read();
            }
            String stringBuffer = buf.toString();
            try {
                in.close();
            } catch (Exception e) {
            }
            return stringBuffer;
        } catch (IOException e2) {
            throw e2;
        } catch (Throwable th) {
            try {
                in.close();
            } catch (Exception e3) {
            }
        }
    }
}
