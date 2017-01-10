package com.google.gdata.util.httputil;

import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.BitSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FastURLEncoder {
    @Deprecated
    public static final BitSet CPLUSPLUS_COMPAT_SAFE_OCTETS;
    private static final BitSet DEFAULT_SAFE_OCTETS;
    private static final char[] HEX_DIGITS;
    private static boolean verifyAgainstJava;

    static {
        int i;
        verifyAgainstJava = false;
        HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        DEFAULT_SAFE_OCTETS = new BitSet(256);
        for (i = 48; i <= 57; i++) {
            DEFAULT_SAFE_OCTETS.set(i);
        }
        for (i = 65; i <= 90; i++) {
            DEFAULT_SAFE_OCTETS.set(i);
        }
        for (i = 97; i <= 122; i++) {
            DEFAULT_SAFE_OCTETS.set(i);
        }
        DEFAULT_SAFE_OCTETS.set(45);
        DEFAULT_SAFE_OCTETS.set(95);
        DEFAULT_SAFE_OCTETS.set(46);
        DEFAULT_SAFE_OCTETS.set(42);
        CPLUSPLUS_COMPAT_SAFE_OCTETS = new BitSet(256);
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(33);
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(41);
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(40);
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(42);
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(44);
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(45);
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(46);
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(47);
        for (i = 48; i <= 57; i++) {
            CPLUSPLUS_COMPAT_SAFE_OCTETS.set(i);
        }
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(58);
        for (i = 65; i <= 90; i++) {
            CPLUSPLUS_COMPAT_SAFE_OCTETS.set(i);
        }
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(95);
        for (i = 97; i <= 122; i++) {
            CPLUSPLUS_COMPAT_SAFE_OCTETS.set(i);
        }
        CPLUSPLUS_COMPAT_SAFE_OCTETS.set(126);
    }

    private FastURLEncoder() {
    }

    @VisibleForTesting
    static void setVerifyAgainstJava(boolean shouldVerify) {
        verifyAgainstJava = shouldVerify;
    }

    @VisibleForTesting
    static boolean getVerifyAgainstJava() {
        return verifyAgainstJava;
    }

    @Deprecated
    public static String encode(String s, String encoding, BitSet safeOctets, boolean plusForSpace) throws UnsupportedEncodingException {
        StringBuilder out = new StringBuilder(s.length() * 2);
        try {
            if (encode(s, encoding, safeOctets, plusForSpace, out)) {
                return out.toString();
            }
            return s;
        } catch (UnsupportedEncodingException e) {
            throw e;
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    @Deprecated
    public static boolean encode(String s, String encoding, BitSet safeOctets, boolean plusForSpace, Appendable out) throws UnsupportedEncodingException, IOException {
        byte[] data = s.getBytes(encoding);
        boolean containsSpace = false;
        int outputLength = 0;
        for (int c : data) {
            int c2;
            if (c2 < 0) {
                c2 += 256;
            }
            if (safeOctets.get(c2)) {
                out.append((char) c2);
                outputLength++;
            } else if (plusForSpace && c2 == 32) {
                containsSpace = true;
                out.append('+');
                outputLength++;
            } else {
                out.append('%');
                out.append(HEX_DIGITS[c2 >> 4]);
                out.append(HEX_DIGITS[c2 & 15]);
                outputLength += 3;
            }
        }
        return containsSpace || outputLength != s.length();
    }

    @Deprecated
    public static String encode(String s, String encoding) throws UnsupportedEncodingException {
        String result = encode(s, encoding, DEFAULT_SAFE_OCTETS, true);
        if (verifyAgainstJava) {
            String jresult = URLEncoder.encode(s, encoding);
            if (!jresult.equals(result)) {
                Logger.getLogger(FastURLEncoder.class.getName()).log(Level.SEVERE, "FastURLEncoder does not match java. Java: '" + jresult + "'  FastURLEncoder: '" + result + "'");
                return jresult;
            }
        }
        return result;
    }

    @Deprecated
    public static void encode(String s, String encoding, Appendable out) throws UnsupportedEncodingException, IOException {
        encode(s, encoding, DEFAULT_SAFE_OCTETS, true, out);
    }

    @Deprecated
    public static String encode(String s) {
        try {
            return encode(s, StringEncodings.UTF8);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Deprecated
    public static void encode(String s, Appendable out) throws IOException {
        try {
            encode(s, StringEncodings.UTF8, out);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Deprecated
    public static String encode(String s, BitSet safeOctets, boolean plusForSpace) {
        try {
            return encode(s, StringEncodings.UTF8, safeOctets, plusForSpace);
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    @Deprecated
    public static BitSet createSafeOctetBitSet() {
        return (BitSet) DEFAULT_SAFE_OCTETS.clone();
    }
}
