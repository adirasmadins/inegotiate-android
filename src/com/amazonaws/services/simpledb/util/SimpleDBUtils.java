package com.amazonaws.services.simpledb.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

public class SimpleDBUtils {
    private static String dateFormat;

    static {
        dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    }

    public static Date decodeDate(String str) throws ParseException {
        return new SimpleDateFormat(dateFormat).parse(str.substring(0, str.length() - 3) + str.substring(str.length() - 2));
    }

    public static float decodeRealNumberRangeFloat(String str, int i, int i2) {
        int pow = (int) Math.pow(10.0d, (double) i);
        return (float) (((double) (Long.parseLong(str, 10) - ((long) (i2 * pow)))) / ((double) pow));
    }

    public static int decodeRealNumberRangeInt(String str, int i) {
        return (int) (Long.parseLong(str, 10) - ((long) i));
    }

    public static long decodeRealNumberRangeLong(String str, long j) {
        return Long.parseLong(str, 10) - j;
    }

    public static float decodeZeroPaddingFloat(String str) {
        return Float.valueOf(str).floatValue();
    }

    public static int decodeZeroPaddingInt(String str) {
        return Integer.parseInt(str, 10);
    }

    public static long decodeZeroPaddingLong(String str) {
        return Long.parseLong(str, 10);
    }

    public static String encodeDate(Date date) {
        String format = new SimpleDateFormat(dateFormat).format(date);
        return format.substring(0, format.length() - 2) + ":" + format.substring(format.length() - 2);
    }

    public static String encodeRealNumberRange(float f, int i, int i2, int i3) {
        int pow = (int) Math.pow(10.0d, (double) i2);
        String l = Long.toString(((long) Math.round(((float) pow) * f)) + ((long) (pow * i3)));
        int length = (i + i2) - l.length();
        StringBuffer stringBuffer = new StringBuffer(l.length() + length);
        for (pow = 0; pow < length; pow++) {
            stringBuffer.insert(pow, '0');
        }
        stringBuffer.append(l);
        return stringBuffer.toString();
    }

    public static String encodeRealNumberRange(int i, int i2, int i3) {
        String l = Long.toString((long) (i + i3));
        int length = i2 - l.length();
        StringBuffer stringBuffer = new StringBuffer(l.length() + length);
        for (int i4 = 0; i4 < length; i4++) {
            stringBuffer.insert(i4, '0');
        }
        stringBuffer.append(l);
        return stringBuffer.toString();
    }

    public static String encodeRealNumberRange(long j, int i, long j2) {
        String l = Long.toString(j + j2);
        int length = i - l.length();
        StringBuffer stringBuffer = new StringBuffer(l.length() + length);
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.insert(i2, '0');
        }
        stringBuffer.append(l);
        return stringBuffer.toString();
    }

    public static String encodeZeroPadding(float f, int i) {
        String f2 = Float.toString(f);
        int indexOf = f2.indexOf(46);
        if (indexOf < 0) {
            indexOf = f2.length();
        }
        int i2 = i - indexOf;
        StringBuffer stringBuffer = new StringBuffer(f2.length() + i2);
        for (indexOf = 0; indexOf < i2; indexOf++) {
            stringBuffer.insert(indexOf, '0');
        }
        stringBuffer.append(f2);
        return stringBuffer.toString();
    }

    public static String encodeZeroPadding(int i, int i2) {
        String num = Integer.toString(i);
        int length = i2 - num.length();
        StringBuffer stringBuffer = new StringBuffer(num.length() + length);
        for (int i3 = 0; i3 < length; i3++) {
            stringBuffer.insert(i3, '0');
        }
        stringBuffer.append(num);
        return stringBuffer.toString();
    }

    public static String encodeZeroPadding(long j, int i) {
        String l = Long.toString(j);
        int length = i - l.length();
        StringBuffer stringBuffer = new StringBuffer(l.length() + length);
        for (int i2 = 0; i2 < length; i2++) {
            stringBuffer.insert(i2, '0');
        }
        stringBuffer.append(l);
        return stringBuffer.toString();
    }

    public static String quoteName(String str) {
        return "`" + replaceChar(str, "`", "``") + "`";
    }

    public static String quoteValue(String str) {
        return "'" + replaceChar(str, "'", "''") + "'";
    }

    public static String quoteValues(Collection<String> collection) {
        StringBuilder stringBuilder = new StringBuilder();
        Object obj = 1;
        for (String str : collection) {
            if (obj == null) {
                stringBuilder.append(",");
            }
            obj = null;
            stringBuilder.append(quoteValue(str));
        }
        return stringBuilder.toString();
    }

    protected static String replaceChar(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder(str);
        int i = 0;
        while (i < stringBuilder.length()) {
            i = stringBuilder.indexOf(str2, i);
            if (i == -1) {
                break;
            }
            stringBuilder.replace(i, str2.length() + i, str3);
            i += str3.length();
        }
        return stringBuilder.toString();
    }
}
