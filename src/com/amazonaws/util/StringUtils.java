package com.amazonaws.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.Date;
import org.apache.commons.codec.binary.Base64;

public class StringUtils {
    private static final DateUtils dateUtils;

    static {
        dateUtils = new DateUtils();
    }

    public static String fromBigDecimal(BigDecimal bigDecimal) {
        return bigDecimal.toString();
    }

    public static String fromBigInteger(BigInteger bigInteger) {
        return bigInteger.toString();
    }

    public static String fromBoolean(Boolean bool) {
        return Boolean.toString(bool.booleanValue());
    }

    public static String fromByte(Byte b) {
        return Byte.toString(b.byteValue());
    }

    public static String fromByteBuffer(ByteBuffer byteBuffer) {
        byte[] encodeBase64;
        if (byteBuffer.hasArray()) {
            encodeBase64 = Base64.encodeBase64(byteBuffer.array());
        } else {
            encodeBase64 = new byte[byteBuffer.limit()];
            byteBuffer.get(encodeBase64);
            encodeBase64 = Base64.encodeBase64(encodeBase64);
        }
        return new String(encodeBase64);
    }

    public static String fromDate(Date date) {
        return dateUtils.formatIso8601Date(date);
    }

    public static String fromDouble(Double d) {
        return Double.toString(d.doubleValue());
    }

    public static String fromFloat(Float f) {
        return Float.toString(f.floatValue());
    }

    public static String fromInteger(Integer num) {
        return Integer.toString(num.intValue());
    }

    public static String fromLong(Long l) {
        return Long.toString(l.longValue());
    }

    public static String fromString(String str) {
        return str;
    }

    public static String join(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            stringBuilder.append(strArr[i].toString());
            if (i < strArr.length - 1) {
                stringBuilder.append(str);
            }
        }
        return stringBuilder.toString();
    }

    public static String replace(String str, String str2, String str3) {
        StringBuffer stringBuffer = new StringBuffer(str.length());
        stringBuffer.append(str);
        int indexOf = stringBuffer.indexOf(str2);
        while (indexOf != -1) {
            stringBuffer = stringBuffer.replace(indexOf, str2.length() + indexOf, str3);
            indexOf = stringBuffer.indexOf(str2);
        }
        return stringBuffer.toString();
    }

    public static BigDecimal toBigDecimal(String str) {
        return new BigDecimal(str);
    }

    public static BigInteger toBigInteger(String str) {
        return new BigInteger(str);
    }

    public static Boolean toBoolean(StringBuilder stringBuilder) {
        return Boolean.valueOf(Boolean.getBoolean(stringBuilder.toString()));
    }

    public static Integer toInteger(StringBuilder stringBuilder) {
        return Integer.valueOf(Integer.parseInt(stringBuilder.toString()));
    }

    public static String toString(StringBuilder stringBuilder) {
        return stringBuilder.toString();
    }
}
