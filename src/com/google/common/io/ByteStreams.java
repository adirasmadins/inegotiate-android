package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.zip.Checksum;

@Beta
public final class ByteStreams {
    private static final int BUF_SIZE = 4096;

    /* renamed from: com.google.common.io.ByteStreams.1 */
    static class C06611 implements InputSupplier<ByteArrayInputStream> {
        final /* synthetic */ byte[] val$b;
        final /* synthetic */ int val$len;
        final /* synthetic */ int val$off;

        C06611(byte[] bArr, int i, int i2) {
            this.val$b = bArr;
            this.val$off = i;
            this.val$len = i2;
        }

        public ByteArrayInputStream getInput() {
            return new ByteArrayInputStream(this.val$b, this.val$off, this.val$len);
        }
    }

    /* renamed from: com.google.common.io.ByteStreams.2 */
    static class C06622 implements ByteProcessor<Long> {
        final /* synthetic */ Checksum val$checksum;

        C06622(Checksum checksum) {
            this.val$checksum = checksum;
        }

        public boolean processBytes(byte[] buf, int off, int len) {
            this.val$checksum.update(buf, off, len);
            return true;
        }

        public Long getResult() {
            long result = this.val$checksum.getValue();
            this.val$checksum.reset();
            return Long.valueOf(result);
        }
    }

    /* renamed from: com.google.common.io.ByteStreams.3 */
    static class C06633 implements ByteProcessor<byte[]> {
        final /* synthetic */ MessageDigest val$md;

        C06633(MessageDigest messageDigest) {
            this.val$md = messageDigest;
        }

        public boolean processBytes(byte[] buf, int off, int len) {
            this.val$md.update(buf, off, len);
            return true;
        }

        public byte[] getResult() {
            return this.val$md.digest();
        }
    }

    /* renamed from: com.google.common.io.ByteStreams.4 */
    static class C06644 implements InputSupplier<InputStream> {
        final /* synthetic */ long val$length;
        final /* synthetic */ long val$offset;
        final /* synthetic */ InputSupplier val$supplier;

        C06644(InputSupplier inputSupplier, long j, long j2) {
            this.val$supplier = inputSupplier;
            this.val$offset = j;
            this.val$length = j2;
        }

        public InputStream getInput() throws IOException {
            InputStream in = (InputStream) this.val$supplier.getInput();
            if (this.val$offset > 0) {
                try {
                    ByteStreams.skipFully(in, this.val$offset);
                } catch (IOException e) {
                    Closeables.closeQuietly(in);
                    throw e;
                }
            }
            return new LimitInputStream(in, this.val$length);
        }
    }

    /* renamed from: com.google.common.io.ByteStreams.5 */
    static class C06655 implements InputSupplier<InputStream> {
        final /* synthetic */ Iterable val$suppliers;

        C06655(Iterable iterable) {
            this.val$suppliers = iterable;
        }

        public InputStream getInput() throws IOException {
            return new MultiInputStream(this.val$suppliers.iterator());
        }
    }

    private static class ByteArrayDataInputStream implements ByteArrayDataInput {
        final DataInput input;

        ByteArrayDataInputStream(byte[] bytes) {
            this.input = new DataInputStream(new ByteArrayInputStream(bytes));
        }

        ByteArrayDataInputStream(byte[] bytes, int start) {
            this.input = new DataInputStream(new ByteArrayInputStream(bytes, start, bytes.length - start));
        }

        public void readFully(byte[] b) {
            try {
                this.input.readFully(b);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public void readFully(byte[] b, int off, int len) {
            try {
                this.input.readFully(b, off, len);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public int skipBytes(int n) {
            try {
                return this.input.skipBytes(n);
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public boolean readBoolean() {
            try {
                return this.input.readBoolean();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public byte readByte() {
            try {
                return this.input.readByte();
            } catch (EOFException e) {
                throw new IllegalStateException(e);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public int readUnsignedByte() {
            try {
                return this.input.readUnsignedByte();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public short readShort() {
            try {
                return this.input.readShort();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public int readUnsignedShort() {
            try {
                return this.input.readUnsignedShort();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public char readChar() {
            try {
                return this.input.readChar();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public int readInt() {
            try {
                return this.input.readInt();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public long readLong() {
            try {
                return this.input.readLong();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public float readFloat() {
            try {
                return this.input.readFloat();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public double readDouble() {
            try {
                return this.input.readDouble();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String readLine() {
            try {
                return this.input.readLine();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }

        public String readUTF() {
            try {
                return this.input.readUTF();
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        }
    }

    private static class ByteArrayDataOutputStream implements ByteArrayDataOutput {
        final ByteArrayOutputStream byteArrayOutputSteam;
        final DataOutput output;

        ByteArrayDataOutputStream() {
            this(new ByteArrayOutputStream());
        }

        ByteArrayDataOutputStream(int size) {
            this(new ByteArrayOutputStream(size));
        }

        ByteArrayDataOutputStream(ByteArrayOutputStream byteArrayOutputSteam) {
            this.byteArrayOutputSteam = byteArrayOutputSteam;
            this.output = new DataOutputStream(byteArrayOutputSteam);
        }

        public void write(int b) {
            try {
                this.output.write(b);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void write(byte[] b) {
            try {
                this.output.write(b);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void write(byte[] b, int off, int len) {
            try {
                this.output.write(b, off, len);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeBoolean(boolean v) {
            try {
                this.output.writeBoolean(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeByte(int v) {
            try {
                this.output.writeByte(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeBytes(String s) {
            try {
                this.output.writeBytes(s);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeChar(int v) {
            try {
                this.output.writeChar(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeChars(String s) {
            try {
                this.output.writeChars(s);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeDouble(double v) {
            try {
                this.output.writeDouble(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeFloat(float v) {
            try {
                this.output.writeFloat(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeInt(int v) {
            try {
                this.output.writeInt(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeLong(long v) {
            try {
                this.output.writeLong(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeShort(int v) {
            try {
                this.output.writeShort(v);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public void writeUTF(String s) {
            try {
                this.output.writeUTF(s);
            } catch (IOException impossible) {
                throw new AssertionError(impossible);
            }
        }

        public byte[] toByteArray() {
            return this.byteArrayOutputSteam.toByteArray();
        }
    }

    private ByteStreams() {
    }

    public static InputSupplier<ByteArrayInputStream> newInputStreamSupplier(byte[] b) {
        return newInputStreamSupplier(b, 0, b.length);
    }

    public static InputSupplier<ByteArrayInputStream> newInputStreamSupplier(byte[] b, int off, int len) {
        return new C06611(b, off, len);
    }

    public static void write(byte[] from, OutputSupplier<? extends OutputStream> to) throws IOException {
        Preconditions.checkNotNull(from);
        boolean threw = true;
        OutputStream out = (OutputStream) to.getOutput();
        try {
            out.write(from);
            threw = false;
        } finally {
            Closeables.close(out, threw);
        }
    }

    public static long copy(InputSupplier<? extends InputStream> from, OutputSupplier<? extends OutputStream> to) throws IOException {
        OutputStream out;
        boolean z;
        boolean z2 = true;
        int successfulOps = 0;
        InputStream in = (InputStream) from.getInput();
        try {
            out = (OutputStream) to.getOutput();
            long count = copy(in, out);
            successfulOps = 0 + 1;
            if (successfulOps < 1) {
                z = true;
            } else {
                z = false;
            }
            Closeables.close(out, z);
            if (successfulOps + 1 >= 2) {
                z2 = false;
            }
            Closeables.close(in, z2);
            return count;
        } catch (Throwable th) {
            if (successfulOps >= 2) {
                z2 = false;
            }
            Closeables.close(in, z2);
        }
    }

    public static long copy(InputSupplier<? extends InputStream> from, OutputStream to) throws IOException {
        boolean threw = true;
        InputStream in = (InputStream) from.getInput();
        try {
            long count = copy(in, to);
            threw = false;
            return count;
        } finally {
            Closeables.close(in, threw);
        }
    }

    public static long copy(InputStream from, OutputSupplier<? extends OutputStream> to) throws IOException {
        boolean threw = true;
        OutputStream out = (OutputStream) to.getOutput();
        try {
            long count = copy(from, out);
            threw = false;
            return count;
        } finally {
            Closeables.close(out, threw);
        }
    }

    public static long copy(InputStream from, OutputStream to) throws IOException {
        byte[] buf = new byte[BUF_SIZE];
        long total = 0;
        while (true) {
            int r = from.read(buf);
            if (r == -1) {
                return total;
            }
            to.write(buf, 0, r);
            total += (long) r;
        }
    }

    public static long copy(ReadableByteChannel from, WritableByteChannel to) throws IOException {
        ByteBuffer buf = ByteBuffer.allocate(BUF_SIZE);
        long total = 0;
        while (from.read(buf) != -1) {
            buf.flip();
            while (buf.hasRemaining()) {
                total += (long) to.write(buf);
            }
            buf.clear();
        }
        return total;
    }

    public static byte[] toByteArray(InputStream in) throws IOException {
        OutputStream out = new ByteArrayOutputStream();
        copy(in, out);
        return out.toByteArray();
    }

    public static byte[] toByteArray(InputSupplier<? extends InputStream> supplier) throws IOException {
        boolean threw = true;
        InputStream in = (InputStream) supplier.getInput();
        try {
            byte[] result = toByteArray(in);
            threw = false;
            return result;
        } finally {
            Closeables.close(in, threw);
        }
    }

    public static ByteArrayDataInput newDataInput(byte[] bytes) {
        return new ByteArrayDataInputStream(bytes);
    }

    public static ByteArrayDataInput newDataInput(byte[] bytes, int start) {
        Preconditions.checkPositionIndex(start, bytes.length);
        return new ByteArrayDataInputStream(bytes, start);
    }

    public static ByteArrayDataOutput newDataOutput() {
        return new ByteArrayDataOutputStream();
    }

    public static ByteArrayDataOutput newDataOutput(int size) {
        boolean z;
        if (size >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "Invalid size: %s", Integer.valueOf(size));
        return new ByteArrayDataOutputStream(size);
    }

    public static long length(InputSupplier<? extends InputStream> supplier) throws IOException {
        long count = 0;
        boolean threw = true;
        InputStream in = (InputStream) supplier.getInput();
        while (true) {
            try {
                long amt = in.skip(2147483647L);
                if (amt != 0) {
                    count += amt;
                } else if (in.read() == -1) {
                    break;
                } else {
                    count++;
                }
            } finally {
                Closeables.close(in, threw);
            }
        }
        threw = false;
        return count;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean equal(com.google.common.io.InputSupplier<? extends java.io.InputStream> r11, com.google.common.io.InputSupplier<? extends java.io.InputStream> r12) throws java.io.IOException {
        /*
        r7 = 0;
        r10 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r10];
        r1 = new byte[r10];
        r6 = 1;
        r2 = r11.getInput();
        r2 = (java.io.InputStream) r2;
        r3 = r12.getInput();	 Catch:{ all -> 0x0042 }
        r3 = (java.io.InputStream) r3;	 Catch:{ all -> 0x0042 }
    L_0x0014:
        r8 = 0;
        r9 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r4 = read(r2, r0, r8, r9);	 Catch:{ all -> 0x003d }
        r8 = 0;
        r9 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r5 = read(r3, r1, r8, r9);	 Catch:{ all -> 0x003d }
        if (r4 != r5) goto L_0x002a;
    L_0x0024:
        r8 = java.util.Arrays.equals(r0, r1);	 Catch:{ all -> 0x003d }
        if (r8 != 0) goto L_0x0032;
    L_0x002a:
        r6 = 0;
        com.google.common.io.Closeables.close(r3, r6);	 Catch:{ all -> 0x0042 }
        com.google.common.io.Closeables.close(r2, r6);
    L_0x0031:
        return r7;
    L_0x0032:
        if (r4 == r10) goto L_0x0014;
    L_0x0034:
        r6 = 0;
        r7 = 1;
        com.google.common.io.Closeables.close(r3, r6);	 Catch:{ all -> 0x0042 }
        com.google.common.io.Closeables.close(r2, r6);
        goto L_0x0031;
    L_0x003d:
        r7 = move-exception;
        com.google.common.io.Closeables.close(r3, r6);	 Catch:{ all -> 0x0042 }
        throw r7;	 Catch:{ all -> 0x0042 }
    L_0x0042:
        r7 = move-exception;
        com.google.common.io.Closeables.close(r2, r6);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.ByteStreams.equal(com.google.common.io.InputSupplier, com.google.common.io.InputSupplier):boolean");
    }

    public static void readFully(InputStream in, byte[] b) throws IOException {
        readFully(in, b, 0, b.length);
    }

    public static void readFully(InputStream in, byte[] b, int off, int len) throws IOException {
        if (read(in, b, off, len) != len) {
            throw new EOFException();
        }
    }

    public static void skipFully(InputStream in, long n) throws IOException {
        while (n > 0) {
            long amt = in.skip(n);
            if (amt != 0) {
                n -= amt;
            } else if (in.read() == -1) {
                throw new EOFException();
            } else {
                n--;
            }
        }
    }

    public static <T> T readBytes(InputSupplier<? extends InputStream> supplier, ByteProcessor<T> processor) throws IOException {
        T result;
        byte[] buf = new byte[BUF_SIZE];
        boolean threw = true;
        InputStream in = (InputStream) supplier.getInput();
        while (true) {
            try {
                int amt = in.read(buf);
                if (amt != -1) {
                    if (!processor.processBytes(buf, 0, amt)) {
                        break;
                    }
                }
                break;
                result = processor.getResult();
                return result;
            } finally {
                Closeables.close(in, threw);
            }
        }
        threw = false;
        result = processor.getResult();
        return result;
    }

    public static long getChecksum(InputSupplier<? extends InputStream> supplier, Checksum checksum) throws IOException {
        return ((Long) readBytes(supplier, new C06622(checksum))).longValue();
    }

    public static byte[] getDigest(InputSupplier<? extends InputStream> supplier, MessageDigest md) throws IOException {
        return (byte[]) readBytes(supplier, new C06633(md));
    }

    public static int read(InputStream in, byte[] b, int off, int len) throws IOException {
        if (len < 0) {
            throw new IndexOutOfBoundsException("len is negative");
        }
        int total = 0;
        while (total < len) {
            int result = in.read(b, off + total, len - total);
            if (result == -1) {
                break;
            }
            total += result;
        }
        return total;
    }

    public static InputSupplier<InputStream> slice(InputSupplier<? extends InputStream> supplier, long offset, long length) {
        boolean z;
        boolean z2 = true;
        Preconditions.checkNotNull(supplier);
        if (offset >= 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "offset is negative");
        if (length < 0) {
            z2 = false;
        }
        Preconditions.checkArgument(z2, "length is negative");
        return new C06644(supplier, offset, length);
    }

    public static InputSupplier<InputStream> join(Iterable<? extends InputSupplier<? extends InputStream>> suppliers) {
        return new C06655(suppliers);
    }

    public static InputSupplier<InputStream> join(InputSupplier<? extends InputStream>... suppliers) {
        return join(Arrays.asList(suppliers));
    }
}
