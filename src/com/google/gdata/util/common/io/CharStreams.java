package com.google.gdata.util.common.io;

import com.google.gdata.util.common.base.Preconditions;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class CharStreams {
    private static final int BUF_SIZE = 2048;

    /* renamed from: com.google.gdata.util.common.io.CharStreams.1 */
    static class C07681 implements InputSupplier<StringReader> {
        final /* synthetic */ String val$value;

        C07681(String str) {
            this.val$value = str;
        }

        public StringReader getInput() {
            return new StringReader(this.val$value);
        }
    }

    /* renamed from: com.google.gdata.util.common.io.CharStreams.2 */
    static class C07692 implements InputSupplier<InputStreamReader> {
        final /* synthetic */ Charset val$charset;
        final /* synthetic */ InputSupplier val$in;

        C07692(InputSupplier inputSupplier, Charset charset) throws IOException {
            this.val$in = inputSupplier;
            this.val$charset = charset;
        }

        public InputStreamReader getInput() throws IOException {
            return new InputStreamReader((InputStream) this.val$in.getInput(), this.val$charset);
        }
    }

    /* renamed from: com.google.gdata.util.common.io.CharStreams.3 */
    static class C07703 implements OutputSupplier<OutputStreamWriter> {
        final /* synthetic */ Charset val$charset;
        final /* synthetic */ OutputSupplier val$out;

        C07703(OutputSupplier outputSupplier, Charset charset) throws IOException {
            this.val$out = outputSupplier;
            this.val$charset = charset;
        }

        public OutputStreamWriter getOutput() throws IOException {
            return new OutputStreamWriter((OutputStream) this.val$out.getOutput(), this.val$charset);
        }
    }

    /* renamed from: com.google.gdata.util.common.io.CharStreams.4 */
    static class C07714 implements InputSupplier<Reader> {
        final /* synthetic */ Iterable val$suppliers;

        C07714(Iterable iterable) throws IOException {
            this.val$suppliers = iterable;
        }

        public Reader getInput() throws IOException {
            return new MultiReader(this.val$suppliers.iterator());
        }
    }

    private CharStreams() {
    }

    public static InputSupplier<StringReader> newReaderSupplier(String value) {
        Preconditions.checkNotNull(value);
        return new C07681(value);
    }

    public static InputSupplier<InputStreamReader> newReaderSupplier(InputSupplier<? extends InputStream> in, Charset charset) {
        Preconditions.checkNotNull(in);
        Preconditions.checkNotNull(charset);
        return new C07692(in, charset);
    }

    public static OutputSupplier<OutputStreamWriter> newWriterSupplier(OutputSupplier<? extends OutputStream> out, Charset charset) {
        Preconditions.checkNotNull(out);
        Preconditions.checkNotNull(charset);
        return new C07703(out, charset);
    }

    public static <W extends Appendable & Closeable> void write(CharSequence from, OutputSupplier<W> to) throws IOException {
        Preconditions.checkNotNull(from);
        boolean threw = true;
        Appendable out = (Appendable) to.getOutput();
        try {
            out.append(from);
            threw = false;
        } finally {
            Closeables.close((Closeable) out, threw);
        }
    }

    public static <R extends Readable & Closeable, W extends Appendable & Closeable> long copy(InputSupplier<R> from, OutputSupplier<W> to) throws IOException {
        boolean threw = true;
        Readable in = (Readable) from.getInput();
        W out;
        try {
            out = (Appendable) to.getOutput();
            long count = copy(in, (Appendable) out);
            threw = false;
            Closeables.close((Closeable) in, threw);
            return count;
        } catch (Throwable th) {
        } finally {
            Closeables.close((Closeable) out, threw);
        }
    }

    public static <R extends Readable & Closeable> long copy(InputSupplier<R> from, Appendable to) throws IOException {
        boolean threw = true;
        Readable in = (Readable) from.getInput();
        try {
            long count = copy(in, to);
            threw = false;
            return count;
        } finally {
            Closeables.close((Closeable) in, threw);
        }
    }

    public static long copy(Readable from, Appendable to) throws IOException {
        CharBuffer buf = CharBuffer.allocate(BUF_SIZE);
        long total = 0;
        while (true) {
            int r = from.read(buf);
            if (r == -1) {
                return total;
            }
            buf.flip();
            to.append(buf, 0, r);
            total += (long) r;
        }
    }

    public static String toString(Readable r) throws IOException {
        return toStringBuilder(r).toString();
    }

    public static <R extends Readable & Closeable> String toString(InputSupplier<R> supplier) throws IOException {
        return toStringBuilder((InputSupplier) supplier).toString();
    }

    private static StringBuilder toStringBuilder(Readable r) throws IOException {
        Appendable sb = new StringBuilder();
        copy(r, sb);
        return sb;
    }

    private static <R extends Readable & Closeable> StringBuilder toStringBuilder(InputSupplier<R> supplier) throws IOException {
        boolean threw = true;
        Readable r = (Readable) supplier.getInput();
        try {
            StringBuilder result = toStringBuilder(r);
            threw = false;
            return result;
        } finally {
            Closeables.close((Closeable) r, threw);
        }
    }

    public static <R extends Readable & Closeable> String readFirstLine(InputSupplier<R> supplier) throws IOException {
        boolean threw = true;
        Readable r = (Readable) supplier.getInput();
        try {
            String line = new LineReader(r).readLine();
            threw = false;
            return line;
        } finally {
            Closeables.close((Closeable) r, threw);
        }
    }

    public static <R extends Readable & Closeable> List<String> readLines(InputSupplier<R> supplier) throws IOException {
        boolean threw = true;
        Readable r = (Readable) supplier.getInput();
        try {
            List<String> result = readLines(r);
            threw = false;
            return result;
        } finally {
            Closeables.close((Closeable) r, threw);
        }
    }

    public static List<String> readLines(Readable r) throws IOException {
        List<String> result = new ArrayList();
        LineReader lineReader = new LineReader(r);
        while (true) {
            String line = lineReader.readLine();
            if (line == null) {
                return result;
            }
            result.add(line);
        }
    }

    public static <R extends Readable & Closeable, T> T readLines(InputSupplier<R> supplier, LineProcessor<T> callback) throws IOException {
        Readable r = (Readable) supplier.getInput();
        try {
            LineReader lineReader = new LineReader(r);
            String line;
            do {
                line = lineReader.readLine();
                if (line == null) {
                    break;
                }
            } while (callback.processLine(line));
            Closeables.close((Closeable) r, false);
            return callback.getResult();
        } catch (Throwable th) {
            Closeables.close((Closeable) r, true);
        }
    }

    public static InputSupplier<Reader> join(Iterable<? extends InputSupplier<? extends Reader>> suppliers) {
        return new C07714(suppliers);
    }

    public static InputSupplier<Reader> join(InputSupplier<? extends Reader>... suppliers) {
        return join(Arrays.asList(suppliers));
    }

    public static void skipFully(Reader reader, long n) throws IOException {
        while (n > 0) {
            long amt = reader.skip(n);
            if (amt != 0) {
                n -= amt;
            } else if (reader.read() == -1) {
                throw new EOFException();
            } else {
                n--;
            }
        }
    }

    public static Writer asWriter(Appendable target) {
        if (target instanceof Writer) {
            return (Writer) target;
        }
        return new AppendableWriter(target);
    }
}
