package com.google.common.hash;

import com.google.common.annotations.Beta;

@Beta
public final class Funnels {

    private enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        public void funnel(byte[] from, Sink into) {
            into.putBytes(from);
        }

        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }
    }

    private enum StringFunnel implements Funnel<CharSequence> {
        INSTANCE;

        public void funnel(CharSequence from, Sink into) {
            into.putString(from);
        }

        public String toString() {
            return "Funnels.stringFunnel()";
        }
    }

    private Funnels() {
    }

    public static Funnel<byte[]> byteArrayFunnel() {
        return ByteArrayFunnel.INSTANCE;
    }

    public static Funnel<CharSequence> stringFunnel() {
        return StringFunnel.INSTANCE;
    }
}
