package com.amazonaws.javax.xml.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

public class FileBufferManager extends BufferManager {
    static final boolean DEBUG = false;
    static final int DEFAULT_LENGTH = 8192;
    static final int THRESH_HOLD = 81920;
    boolean calledGetMore;
    CharBuffer charBuffer;
    CharsetDecoder decoder;
    FileChannel fChannel;
    long filepos;
    long filesize;
    long remaining;

    public FileBufferManager(FileInputStream stream, String encodingName) throws IOException {
        this.decoder = null;
        this.fChannel = null;
        this.charBuffer = null;
        this.remaining = -1;
        this.filepos = 0;
        this.filesize = -1;
        init(stream);
        setDecoder(StringEncodings.UTF8);
    }

    void init(FileInputStream stream) throws IOException {
        this.charBuffer = CharBuffer.allocate(16384);
        this.fChannel = stream.getChannel();
        this.filesize = this.fChannel.size();
        this.remaining = this.filesize;
    }

    public boolean arrangeCapacity(int length) throws IOException {
        if (!this.calledGetMore) {
            getMore();
        }
        if (getCharBuffer().limit() - getCharBuffer().position() >= length) {
            return true;
        }
        while (getCharBuffer().limit() - getCharBuffer().position() < length && !endOfStream()) {
            getMore();
        }
        if (getCharBuffer().limit() - getCharBuffer().position() < length) {
            return DEBUG;
        }
        return true;
    }

    public ByteBuffer getMoreBytes() throws IOException {
        int len = getLength();
        if (this.endOfStream) {
            return ByteBuffer.allocate(0);
        }
        ByteBuffer bb;
        if (this.filesize > 81920) {
            bb = this.fChannel.map(MapMode.READ_ONLY, this.filepos, (long) len);
            this.filepos += (long) bb.limit();
        } else {
            bb = ByteBuffer.allocate(getLength());
            this.fChannel.read(bb);
            this.filepos = this.fChannel.position();
            bb.flip();
        }
        this.remaining = this.filesize - this.filepos;
        if (this.remaining >= 1) {
            return bb;
        }
        this.endOfStream = true;
        return bb;
    }

    public boolean getMore() throws IOException {
        this.calledGetMore = true;
        if (this.endOfStream) {
            return DEBUG;
        }
        ByteBuffer bb = getMoreBytes();
        if (this.charBuffer.position() != 0) {
            this.charBuffer.compact();
        } else {
            this.charBuffer.clear();
        }
        int before = this.charBuffer.position();
        CoderResult cr = this.decoder.decode(bb, this.charBuffer, DEBUG);
        while (bb.remaining() > 0) {
            if (cr.isOverflow()) {
                resizeCharBuffer(this.charBuffer.limit() + bb.remaining());
            }
            cr = this.decoder.decode(bb, this.charBuffer, true);
        }
        if (cr.isUnderflow()) {
            cr = this.decoder.decode(bb, this.charBuffer, true);
            this.decoder.flush(this.charBuffer);
        }
        this.decoder.reset();
        if (this.charBuffer.position() <= before) {
            return DEBUG;
        }
        this.charBuffer.flip();
        return true;
    }

    public CharBuffer getCharBuffer() {
        return this.charBuffer;
    }

    CharSequence getCharSequence() {
        return this.charBuffer.subSequence(0, this.charBuffer.remaining());
    }

    CharBuffer resizeCharBuffer(int capacity) {
        this.charBuffer = CharBuffer.allocate(capacity).put((CharBuffer) this.charBuffer.flip());
        return this.charBuffer;
    }

    int getLength() {
        return this.remaining < 16384 ? (int) this.remaining : 16384;
    }

    void setDecoder(String encoding) throws IOException {
        if (encoding != null) {
            this.decoder = Charset.forName(encoding).newDecoder();
            return;
        }
        ByteBuffer byteBuffer = ByteBuffer.allocate(4);
        this.fChannel.read(byteBuffer);
        byte[] b = new byte[4];
        byteBuffer.get(b);
        this.decoder = Charset.forName((String) getEncodingName(b, 4)[0]).newDecoder();
    }

    static void printByteBuffer(ByteBuffer bb) {
        System.out.println("------------ByteBuffer Details---------");
        System.out.println(new StringBuffer().append("bb.position = ").append(bb.position()).toString());
        System.out.println(new StringBuffer().append("bb.remaining() = ").append(bb.remaining()).toString());
        System.out.println(new StringBuffer().append("bb.limit = ").append(bb.limit()).toString());
        System.out.println(new StringBuffer().append("bb.capacity = ").append(bb.capacity()).toString());
    }

    static void printCharBuffer(CharBuffer bb) {
        System.out.println("----------- CharBuffer Details---------");
        System.out.println(new StringBuffer().append("bb.position = ").append(bb.position()).toString());
        System.out.println(new StringBuffer().append("bb.remaining() = ").append(bb.remaining()).toString());
        System.out.println(new StringBuffer().append("bb.limit = ").append(bb.limit()).toString());
        System.out.println(new StringBuffer().append("bb.capacity = ").append(bb.capacity()).toString());
    }

    public static void main(String[] args) {
        try {
            FileBufferManager fb = new FileBufferManager(new FileInputStream(args[0]), StringEncodings.UTF8);
            CharBuffer cb = fb.getCharBuffer();
            int i = 0;
            while (fb.getMore()) {
                int i2 = i + 1;
                System.out.println(new StringBuffer().append("Loop ").append(i).append(" = ").append(fb.getCharBuffer().toString()).toString());
                System.out.println("------------Loop CharBuffer details--------");
                printCharBuffer(cb);
                i = i2;
            }
            System.out.println(new StringBuffer().append("End of file reached = ").append(fb.endOfStream()).toString());
            System.out.println(new StringBuffer().append("Total no. of loops required = ").append(i).toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close() throws IOException {
        if (this.fChannel != null) {
            this.fChannel.close();
        }
    }

    public void setEncoding(String encoding) throws IOException {
    }
}
