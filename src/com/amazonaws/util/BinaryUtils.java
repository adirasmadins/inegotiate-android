package com.amazonaws.util;

import java.util.Locale;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class BinaryUtils {
    private static final String DEFAULT_ENCODING = "UTF-8";
    private static final Log log;

    static {
        log = LogFactory.getLog(BinaryUtils.class);
    }

    public static byte[] fromBase64(String str) {
        try {
            return Base64.decodeBase64(str.getBytes(DEFAULT_ENCODING));
        } catch (Throwable e) {
            log.warn("Tried to Base64-decode a String with the wrong encoding: ", e);
            return Base64.decodeBase64(str.getBytes());
        }
    }

    public static byte[] fromHex(String str) {
        int i = 0;
        byte[] bArr = new byte[((str.length() + 1) / 2)];
        int i2 = 0;
        while (i2 < str.length()) {
            String substring = str.substring(i2, i2 + 2);
            int i3 = i2 + 2;
            i2 = i + 1;
            bArr[i] = (byte) Integer.parseInt(substring, 16);
            i = i2;
            i2 = i3;
        }
        return bArr;
    }

    public static String toBase64(byte[] bArr) {
        return new String(Base64.encodeBase64(bArr));
    }

    public static String toHex(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte toHexString : bArr) {
            String toHexString2 = Integer.toHexString(toHexString);
            if (toHexString2.length() == 1) {
                stringBuilder.append("0");
            } else if (toHexString2.length() == 8) {
                toHexString2 = toHexString2.substring(6);
            }
            stringBuilder.append(toHexString2);
        }
        return stringBuilder.toString().toLowerCase(Locale.getDefault());
    }
}
