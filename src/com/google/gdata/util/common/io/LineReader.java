package com.google.gdata.util.common.io;

import com.google.common.collect.Lists;
import com.google.gdata.util.common.base.Preconditions;
import com.google.protobuf.CodedOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.Queue;

public final class LineReader {
    private final char[] buf;
    private final CharBuffer cbuf;
    private final LineBuffer lineBuf;
    private final Queue<String> lines;
    private final Readable readable;
    private final Reader reader;

    /* renamed from: com.google.gdata.util.common.io.LineReader.1 */
    class C07761 extends LineBuffer {
        C07761() {
        }

        protected void handleLine(String line, String end) {
            LineReader.this.lines.add(line);
        }
    }

    public LineReader(Readable readable) {
        this.buf = new char[CodedOutputStream.DEFAULT_BUFFER_SIZE];
        this.cbuf = CharBuffer.wrap(this.buf);
        this.lines = Lists.newLinkedList();
        this.lineBuf = new C07761();
        Preconditions.checkNotNull(readable);
        this.readable = readable;
        this.reader = readable instanceof Reader ? (Reader) readable : null;
    }

    public String readLine() throws IOException {
        while (this.lines.peek() == null) {
            this.cbuf.clear();
            int read = this.reader != null ? this.reader.read(this.buf, 0, this.buf.length) : this.readable.read(this.cbuf);
            if (read == -1) {
                this.lineBuf.finish();
                break;
            }
            this.lineBuf.add(this.buf, 0, read);
        }
        return (String) this.lines.poll();
    }
}
