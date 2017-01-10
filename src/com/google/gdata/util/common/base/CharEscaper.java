package com.google.gdata.util.common.base;

import com.amazonaws.services.s3.model.ProgressEvent;
import java.io.IOException;

public abstract class CharEscaper implements Escaper {
    private static final int DEST_PAD = 32;
    private static final ThreadLocal<char[]> DEST_TL;

    /* renamed from: com.google.gdata.util.common.base.CharEscaper.1 */
    class C07471 implements Appendable {
        final /* synthetic */ Appendable val$out;

        public Appendable append(CharSequence csq) throws IOException {
            return append(csq, 0, csq.length());
        }

        public Appendable append(CharSequence csq, int start, int end) throws IOException {
            int unescapedChunkStart = start;
            for (int i = start; i < end; i++) {
                char[] escaped = CharEscaper.this.escape(csq.charAt(i));
                if (escaped != null) {
                    if (unescapedChunkStart < i) {
                        this.val$out.append(csq, unescapedChunkStart, i);
                    }
                    outputChars(escaped);
                    unescapedChunkStart = i + 1;
                }
            }
            if (unescapedChunkStart < end) {
                this.val$out.append(csq, unescapedChunkStart, end);
            }
            return this;
        }

        public Appendable append(char c) throws IOException {
            char[] escaped = CharEscaper.this.escape(c);
            if (escaped == null) {
                this.val$out.append(c);
            } else {
                outputChars(escaped);
            }
            return this;
        }

        C07471(Appendable appendable) throws IOException {
            this.val$out = appendable;
        }

        private void outputChars(char[] chars) throws IOException {
            for (char c : chars) {
                this.val$out.append(c);
            }
        }
    }

    /* renamed from: com.google.gdata.util.common.base.CharEscaper.2 */
    static class C07482 extends ThreadLocal<char[]> {
        C07482() {
        }

        protected char[] initialValue() {
            return new char[ProgressEvent.PART_STARTED_EVENT_CODE];
        }
    }

    protected abstract char[] escape(char c);

    public String escape(String string) {
        int length = string.length();
        for (int index = 0; index < length; index++) {
            if (escape(string.charAt(index)) != null) {
                return escapeSlow(string, index);
            }
        }
        return string;
    }

    public Appendable escape(Appendable out) {
        Preconditions.checkNotNull(out);
        return new C07471(out);
    }

    protected String escapeSlow(String s, int index) {
        int sizeNeeded;
        int slen = s.length();
        char[] dest = (char[]) DEST_TL.get();
        int destSize = dest.length;
        int destIndex = 0;
        int lastEscape = 0;
        while (index < slen) {
            char[] r = escape(s.charAt(index));
            if (r != null) {
                int rlen = r.length;
                int charsSkipped = index - lastEscape;
                sizeNeeded = (destIndex + charsSkipped) + rlen;
                if (destSize < sizeNeeded) {
                    destSize = ((slen - index) + sizeNeeded) + DEST_PAD;
                    dest = growBuffer(dest, destIndex, destSize);
                }
                if (charsSkipped > 0) {
                    s.getChars(lastEscape, index, dest, destIndex);
                    destIndex += charsSkipped;
                }
                if (rlen > 0) {
                    System.arraycopy(r, 0, dest, destIndex, rlen);
                    destIndex += rlen;
                }
                lastEscape = index + 1;
            }
            index++;
        }
        int charsLeft = slen - lastEscape;
        if (charsLeft > 0) {
            sizeNeeded = destIndex + charsLeft;
            if (destSize < sizeNeeded) {
                dest = growBuffer(dest, destIndex, sizeNeeded);
            }
            s.getChars(lastEscape, slen, dest, destIndex);
            destIndex = sizeNeeded;
        }
        return new String(dest, 0, destIndex);
    }

    private static final char[] growBuffer(char[] dest, int index, int size) {
        char[] copy = new char[size];
        if (index > 0) {
            System.arraycopy(dest, 0, copy, 0, index);
        }
        return copy;
    }

    static {
        DEST_TL = new C07482();
    }
}
