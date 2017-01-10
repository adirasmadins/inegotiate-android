package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.gdata.util.common.base.StringUtil;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Checksum;

@Beta
public final class Files {
    private static final int TEMP_DIR_ATTEMPTS = 10000;

    /* renamed from: com.google.common.io.Files.1 */
    static class C06721 implements InputSupplier<FileInputStream> {
        final /* synthetic */ File val$file;

        C06721(File file) {
            this.val$file = file;
        }

        public FileInputStream getInput() throws IOException {
            return new FileInputStream(this.val$file);
        }
    }

    /* renamed from: com.google.common.io.Files.2 */
    static class C06732 implements OutputSupplier<FileOutputStream> {
        final /* synthetic */ boolean val$append;
        final /* synthetic */ File val$file;

        C06732(File file, boolean z) {
            this.val$file = file;
            this.val$append = z;
        }

        public FileOutputStream getOutput() throws IOException {
            return new FileOutputStream(this.val$file, this.val$append);
        }
    }

    private Files() {
    }

    public static BufferedReader newReader(File file, Charset charset) throws FileNotFoundException {
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }

    public static BufferedWriter newWriter(File file, Charset charset) throws FileNotFoundException {
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }

    public static InputSupplier<FileInputStream> newInputStreamSupplier(File file) {
        Preconditions.checkNotNull(file);
        return new C06721(file);
    }

    public static OutputSupplier<FileOutputStream> newOutputStreamSupplier(File file) {
        return newOutputStreamSupplier(file, false);
    }

    public static OutputSupplier<FileOutputStream> newOutputStreamSupplier(File file, boolean append) {
        Preconditions.checkNotNull(file);
        return new C06732(file, append);
    }

    public static InputSupplier<InputStreamReader> newReaderSupplier(File file, Charset charset) {
        return CharStreams.newReaderSupplier(newInputStreamSupplier(file), charset);
    }

    public static OutputSupplier<OutputStreamWriter> newWriterSupplier(File file, Charset charset) {
        return newWriterSupplier(file, charset, false);
    }

    public static OutputSupplier<OutputStreamWriter> newWriterSupplier(File file, Charset charset, boolean append) {
        return CharStreams.newWriterSupplier(newOutputStreamSupplier(file, append), charset);
    }

    public static byte[] toByteArray(File file) throws IOException {
        Preconditions.checkArgument(file.length() <= 2147483647L);
        if (file.length() == 0) {
            return ByteStreams.toByteArray(newInputStreamSupplier(file));
        }
        byte[] b = new byte[((int) file.length())];
        boolean threw = true;
        InputStream in = new FileInputStream(file);
        try {
            ByteStreams.readFully(in, b);
            threw = false;
            return b;
        } finally {
            Closeables.close(in, threw);
        }
    }

    public static String toString(File file, Charset charset) throws IOException {
        return new String(toByteArray(file), charset.name());
    }

    public static void copy(InputSupplier<? extends InputStream> from, File to) throws IOException {
        ByteStreams.copy((InputSupplier) from, newOutputStreamSupplier(to));
    }

    public static void write(byte[] from, File to) throws IOException {
        ByteStreams.write(from, newOutputStreamSupplier(to));
    }

    public static void copy(File from, OutputSupplier<? extends OutputStream> to) throws IOException {
        ByteStreams.copy(newInputStreamSupplier(from), (OutputSupplier) to);
    }

    public static void copy(File from, OutputStream to) throws IOException {
        ByteStreams.copy(newInputStreamSupplier(from), to);
    }

    public static void copy(File from, File to) throws IOException {
        boolean z;
        if (from.equals(to)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z, "Source %s and destination %s must be different", from, to);
        copy(newInputStreamSupplier(from), to);
    }

    public static <R extends Readable & Closeable> void copy(InputSupplier<R> from, File to, Charset charset) throws IOException {
        CharStreams.copy((InputSupplier) from, newWriterSupplier(to, charset));
    }

    public static void write(CharSequence from, File to, Charset charset) throws IOException {
        write(from, to, charset, false);
    }

    public static void append(CharSequence from, File to, Charset charset) throws IOException {
        write(from, to, charset, true);
    }

    private static void write(CharSequence from, File to, Charset charset, boolean append) throws IOException {
        CharStreams.write(from, newWriterSupplier(to, charset, append));
    }

    public static <W extends Appendable & Closeable> void copy(File from, Charset charset, OutputSupplier<W> to) throws IOException {
        CharStreams.copy(newReaderSupplier(from, charset), (OutputSupplier) to);
    }

    public static void copy(File from, Charset charset, Appendable to) throws IOException {
        CharStreams.copy(newReaderSupplier(from, charset), to);
    }

    public static boolean equal(File file1, File file2) throws IOException {
        if (file1 == file2 || file1.equals(file2)) {
            return true;
        }
        long len1 = file1.length();
        long len2 = file2.length();
        if (len1 == 0 || len2 == 0 || len1 == len2) {
            return ByteStreams.equal(newInputStreamSupplier(file1), newInputStreamSupplier(file2));
        }
        return false;
    }

    public static File createTempDir() {
        File baseDir = new File(System.getProperty("java.io.tmpdir"));
        String baseName = System.currentTimeMillis() + "-";
        for (int counter = 0; counter < TEMP_DIR_ATTEMPTS; counter++) {
            File tempDir = new File(baseDir, baseName + counter);
            if (tempDir.mkdir()) {
                return tempDir;
            }
        }
        throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + baseName + "0 to " + baseName + 9999 + ')');
    }

    public static void touch(File file) throws IOException {
        if (!file.createNewFile() && !file.setLastModified(System.currentTimeMillis())) {
            throw new IOException("Unable to update modification time of " + file);
        }
    }

    public static void createParentDirs(File file) throws IOException {
        File parent = file.getCanonicalFile().getParentFile();
        if (parent != null) {
            parent.mkdirs();
            if (!parent.isDirectory()) {
                throw new IOException("Unable to create parent directories of " + file);
            }
        }
    }

    public static void move(File from, File to) throws IOException {
        Preconditions.checkNotNull(to);
        Preconditions.checkArgument(!from.equals(to), "Source %s and destination %s must be different", from, to);
        if (!from.renameTo(to)) {
            copy(from, to);
            if (!from.delete()) {
                if (to.delete()) {
                    throw new IOException("Unable to delete " + from);
                }
                throw new IOException("Unable to delete " + to);
            }
        }
    }

    public static String readFirstLine(File file, Charset charset) throws IOException {
        return CharStreams.readFirstLine(newReaderSupplier(file, charset));
    }

    public static List<String> readLines(File file, Charset charset) throws IOException {
        return CharStreams.readLines(newReaderSupplier(file, charset));
    }

    public static <T> T readLines(File file, Charset charset, LineProcessor<T> callback) throws IOException {
        return CharStreams.readLines(newReaderSupplier(file, charset), callback);
    }

    public static <T> T readBytes(File file, ByteProcessor<T> processor) throws IOException {
        return ByteStreams.readBytes(newInputStreamSupplier(file), processor);
    }

    public static long getChecksum(File file, Checksum checksum) throws IOException {
        return ByteStreams.getChecksum(newInputStreamSupplier(file), checksum);
    }

    public static byte[] getDigest(File file, MessageDigest md) throws IOException {
        return ByteStreams.getDigest(newInputStreamSupplier(file), md);
    }

    public static MappedByteBuffer map(File file) throws IOException {
        return map(file, MapMode.READ_ONLY);
    }

    public static MappedByteBuffer map(File file, MapMode mode) throws IOException {
        if (file.exists()) {
            return map(file, mode, file.length());
        }
        throw new FileNotFoundException(file.toString());
    }

    public static MappedByteBuffer map(File file, MapMode mode, long size) throws FileNotFoundException, IOException {
        RandomAccessFile raf = new RandomAccessFile(file, mode == MapMode.READ_ONLY ? "r" : "rw");
        boolean threw = true;
        try {
            MappedByteBuffer mbb = map(raf, mode, size);
            threw = false;
            return mbb;
        } finally {
            Closeables.close(raf, threw);
        }
    }

    private static MappedByteBuffer map(RandomAccessFile raf, MapMode mode, long size) throws IOException {
        FileChannel channel = raf.getChannel();
        boolean threw = true;
        try {
            MappedByteBuffer mbb = channel.map(mode, 0, size);
            threw = false;
            return mbb;
        } finally {
            Closeables.close(channel, threw);
        }
    }

    public static String simplifyPath(String pathname) {
        if (pathname.length() == 0) {
            return ".";
        }
        Iterable<String> components = Splitter.on('/').omitEmptyStrings().split(pathname);
        Iterable path = new ArrayList();
        for (String component : components) {
            if (!component.equals(".")) {
                if (!component.equals("..")) {
                    path.add(component);
                } else if (path.size() <= 0 || ((String) path.get(path.size() - 1)).equals("..")) {
                    path.add("..");
                } else {
                    path.remove(path.size() - 1);
                }
            }
        }
        String result = Joiner.on('/').join(path);
        if (pathname.charAt(0) == '/') {
            result = "/" + result;
        }
        while (result.startsWith("/../")) {
            result = result.substring(3);
        }
        if (result.equals("/..")) {
            return "/";
        }
        if (StringUtil.EMPTY_STRING.equals(result)) {
            return ".";
        }
        return result;
    }

    public static String getFileExtension(String fileName) {
        Preconditions.checkNotNull(fileName);
        int dotIndex = fileName.lastIndexOf(46);
        return dotIndex == -1 ? StringUtil.EMPTY_STRING : fileName.substring(dotIndex + 1);
    }
}
