package com.google.common.hash;

import com.google.common.base.Preconditions;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class MessageDigestHashFunction extends AbstractStreamingHashFunction {
    private final String algorithmName;
    private final int bits;

    private static class MessageDigestHasher implements Hasher {
        private final MessageDigest digest;
        private boolean done;
        private final ByteBuffer scratch;

        private MessageDigestHasher(MessageDigest digest) {
            this.digest = digest;
            this.scratch = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        }

        public Hasher putByte(byte b) {
            checkNotDone();
            this.digest.update(b);
            return this;
        }

        public Hasher putBytes(byte[] bytes) {
            checkNotDone();
            this.digest.update(bytes);
            return this;
        }

        public Hasher putBytes(byte[] bytes, int off, int len) {
            checkNotDone();
            Preconditions.checkPositionIndexes(off, off + len, bytes.length);
            this.digest.update(bytes, off, len);
            return this;
        }

        public Hasher putShort(short s) {
            checkNotDone();
            this.scratch.putShort(s);
            this.digest.update(this.scratch.array(), 0, 2);
            this.scratch.clear();
            return this;
        }

        public Hasher putInt(int i) {
            checkNotDone();
            this.scratch.putInt(i);
            this.digest.update(this.scratch.array(), 0, 4);
            this.scratch.clear();
            return this;
        }

        public Hasher putLong(long l) {
            checkNotDone();
            this.scratch.putLong(l);
            this.digest.update(this.scratch.array(), 0, 8);
            this.scratch.clear();
            return this;
        }

        public Hasher putFloat(float f) {
            checkNotDone();
            this.scratch.putFloat(f);
            this.digest.update(this.scratch.array(), 0, 4);
            this.scratch.clear();
            return this;
        }

        public Hasher putDouble(double d) {
            checkNotDone();
            this.scratch.putDouble(d);
            this.digest.update(this.scratch.array(), 0, 8);
            this.scratch.clear();
            return this;
        }

        public Hasher putBoolean(boolean b) {
            return putByte(b ? (byte) 1 : (byte) 0);
        }

        public Hasher putChar(char c) {
            checkNotDone();
            this.scratch.putChar(c);
            this.digest.update(this.scratch.array(), 0, 2);
            this.scratch.clear();
            return this;
        }

        public Hasher putString(CharSequence charSequence) {
            for (int i = 0; i < charSequence.length(); i++) {
                putChar(charSequence.charAt(i));
            }
            return this;
        }

        public Hasher putString(CharSequence charSequence, Charset charset) {
            try {
                return putBytes(charSequence.toString().getBytes(charset.name()));
            } catch (UnsupportedEncodingException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public <T> Hasher putObject(T instance, Funnel<? super T> funnel) {
            checkNotDone();
            funnel.funnel(instance, this);
            return this;
        }

        private void checkNotDone() {
            Preconditions.checkState(!this.done, "Cannot use Hasher after calling #hash() on it");
        }

        public HashCode hash() {
            this.done = true;
            return HashCodes.fromBytes(this.digest.digest());
        }
    }

    MessageDigestHashFunction(String algorithmName) {
        this.algorithmName = algorithmName;
        this.bits = getMessageDigest(algorithmName).getDigestLength() * 8;
    }

    public int bits() {
        return this.bits;
    }

    private static MessageDigest getMessageDigest(String algorithmName) {
        try {
            return MessageDigest.getInstance(algorithmName);
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public Hasher newHasher() {
        return new MessageDigestHasher(null);
    }
}
