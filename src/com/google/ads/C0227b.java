package com.google.ads;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/* renamed from: com.google.ads.b */
public class C0227b {
    private static C0227b f76c;
    private final BigInteger f77a;
    private BigInteger f78b;

    static {
        f76c = null;
    }

    public static synchronized C0227b m51a() {
        C0227b c0227b;
        synchronized (C0227b.class) {
            if (f76c == null) {
                f76c = new C0227b();
            }
            c0227b = f76c;
        }
        return c0227b;
    }

    public synchronized BigInteger m54b() {
        return this.f77a;
    }

    public synchronized BigInteger m55c() {
        BigInteger bigInteger;
        bigInteger = this.f78b;
        this.f78b = this.f78b.add(BigInteger.ONE);
        return bigInteger;
    }

    private C0227b() {
        this.f78b = BigInteger.ONE;
        this.f77a = C0227b.m53d();
    }

    private static BigInteger m53d() {
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            UUID randomUUID = UUID.randomUUID();
            instance.update(C0227b.m52a(randomUUID.getLeastSignificantBits()));
            instance.update(C0227b.m52a(randomUUID.getMostSignificantBits()));
            Object obj = new byte[9];
            obj[0] = (byte) 0;
            System.arraycopy(instance.digest(), 0, obj, 1, 8);
            return new BigInteger(obj);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Cannot find MD5 message digest algorithm.");
        }
    }

    private static byte[] m52a(long j) {
        return BigInteger.valueOf(j).toByteArray();
    }
}
