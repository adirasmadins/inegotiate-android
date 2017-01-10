package com.amazonaws.util.json;

import com.amazonaws.util.BinaryUtils;
import com.google.gdata.data.Category;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.Date;

public class JSONWriter {
    private static final int maxdepth = 20;
    private boolean comma;
    protected char mode;
    private JSONObject[] stack;
    private int top;
    protected Writer writer;

    public JSONWriter(Writer writer) {
        this.comma = false;
        this.mode = 'i';
        this.stack = new JSONObject[maxdepth];
        this.top = 0;
        this.writer = writer;
    }

    private JSONWriter append(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Null pointer");
        } else if (this.mode == 'o' || this.mode == 'a') {
            try {
                if (this.comma && this.mode == 'a') {
                    this.writer.write(44);
                }
                this.writer.write(str);
                if (this.mode == 'o') {
                    this.mode = 'k';
                }
                this.comma = true;
                return this;
            } catch (Throwable e) {
                throw new JSONException(e);
            }
        } else {
            throw new JSONException("Value out of sequence.");
        }
    }

    private JSONWriter end(char c, char c2) throws JSONException {
        if (this.mode != c) {
            throw new JSONException(c == 'a' ? "Misplaced endArray." : "Misplaced endObject.");
        }
        pop(c);
        try {
            this.writer.write(c2);
            this.comma = true;
            return this;
        } catch (Throwable e) {
            throw new JSONException(e);
        }
    }

    private void pop(char c) throws JSONException {
        char c2 = 'a';
        if (this.top <= 0) {
            throw new JSONException("Nesting error.");
        }
        if ((this.stack[this.top + -1] == null ? 'a' : 'k') != c) {
            throw new JSONException("Nesting error.");
        }
        this.top--;
        if (this.top == 0) {
            c2 = 'd';
        } else if (this.stack[this.top - 1] != null) {
            c2 = 'k';
        }
        this.mode = c2;
    }

    private void push(JSONObject jSONObject) throws JSONException {
        if (this.top >= maxdepth) {
            throw new JSONException("Nesting too deep.");
        }
        this.stack[this.top] = jSONObject;
        this.mode = jSONObject == null ? 'a' : 'k';
        this.top++;
    }

    public JSONWriter array() throws JSONException {
        if (this.mode == 'i' || this.mode == 'o' || this.mode == 'a') {
            push(null);
            append("[");
            this.comma = false;
            return this;
        }
        throw new JSONException("Misplaced array.");
    }

    public JSONWriter endArray() throws JSONException {
        return end('a', ']');
    }

    public JSONWriter endObject() throws JSONException {
        return end('k', Category.SCHEME_SUFFIX);
    }

    public JSONWriter key(String str) throws JSONException {
        if (str == null) {
            throw new JSONException("Null key.");
        } else if (this.mode == 'k') {
            try {
                this.stack[this.top - 1].putOnce(str, Boolean.TRUE);
                if (this.comma) {
                    this.writer.write(44);
                }
                this.writer.write(JSONObject.quote(str));
                this.writer.write(58);
                this.comma = false;
                this.mode = 'o';
                return this;
            } catch (Throwable e) {
                throw new JSONException(e);
            }
        } else {
            throw new JSONException("Misplaced key.");
        }
    }

    public JSONWriter object() throws JSONException {
        if (this.mode == 'i') {
            this.mode = 'o';
        }
        if (this.mode == 'o' || this.mode == 'a') {
            append("{");
            push(new JSONObject());
            this.comma = false;
            return this;
        }
        throw new JSONException("Misplaced object.");
    }

    public JSONWriter value(double d) throws JSONException {
        return value(new Double(d));
    }

    public JSONWriter value(long j) throws JSONException {
        return value(new Long(j));
    }

    public JSONWriter value(Object obj) throws JSONException {
        return append(JSONObject.valueToString(obj));
    }

    public JSONWriter value(ByteBuffer byteBuffer) throws JSONException {
        byte[] bArr = new byte[byteBuffer.capacity()];
        byteBuffer.get(bArr, 0, bArr.length);
        return value(BinaryUtils.toBase64(bArr));
    }

    public JSONWriter value(Date date) throws JSONException {
        return value(new Long(date.getTime() / 1000));
    }

    public JSONWriter value(boolean z) throws JSONException {
        return append(z ? "true" : "false");
    }
}
