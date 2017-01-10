package com.amazonaws.util.json;

import com.google.gdata.util.common.base.StringUtil;
import com.paypal.android.MEP.PayPal;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringReader;
import org.codehaus.jackson.io.CharacterEscapes;

public class JSONTokener {
    private int character;
    private boolean eof;
    private int index;
    private int line;
    private char previous;
    private Reader reader;
    private boolean usePrevious;

    public JSONTokener(Reader reader) {
        if (!reader.markSupported()) {
            reader = new BufferedReader(reader);
        }
        this.reader = reader;
        this.eof = false;
        this.usePrevious = false;
        this.previous = '\u0000';
        this.index = 0;
        this.character = 1;
        this.line = 1;
    }

    public JSONTokener(String str) {
        this(new StringReader(str));
    }

    public static int dehexchar(char c) {
        return (c < '0' || c > '9') ? (c < 'A' || c > 'F') ? (c < 'a' || c > 'f') ? -1 : c - 87 : c - 55 : c - 48;
    }

    public void back() throws JSONException {
        if (this.usePrevious || this.index <= 0) {
            throw new JSONException("Stepping back two steps is not supported");
        }
        this.index--;
        this.character--;
        this.usePrevious = true;
        this.eof = false;
    }

    public boolean end() {
        return this.eof && !this.usePrevious;
    }

    public boolean more() throws JSONException {
        next();
        if (end()) {
            return false;
        }
        back();
        return true;
    }

    public char next() throws JSONException {
        int i;
        int i2 = 0;
        if (this.usePrevious) {
            this.usePrevious = false;
            i = this.previous;
        } else {
            try {
                i = this.reader.read();
                if (i <= 0) {
                    this.eof = true;
                    i = 0;
                }
            } catch (Throwable e) {
                throw new JSONException(e);
            }
        }
        this.index++;
        if (this.previous == '\r') {
            this.line++;
            if (i != 10) {
                i2 = 1;
            }
            this.character = i2;
        } else if (i == 10) {
            this.line++;
            this.character = 0;
        } else {
            this.character++;
        }
        this.previous = (char) i;
        return this.previous;
    }

    public char next(char c) throws JSONException {
        char next = next();
        if (next == c) {
            return next;
        }
        throw syntaxError("Expected '" + c + "' and instead saw '" + next + "'");
    }

    public String next(int i) throws JSONException {
        if (i == 0) {
            return StringUtil.EMPTY_STRING;
        }
        char[] cArr = new char[i];
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = next();
            if (end()) {
                throw syntaxError("Substring bounds error");
            }
        }
        return new String(cArr);
    }

    public char nextClean() throws JSONException {
        char next;
        do {
            next = next();
            if (next == '\u0000') {
                break;
            }
        } while (next <= ' ');
        return next;
    }

    public String nextString(char c) throws JSONException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            char next = next();
            switch (next) {
                case CharacterEscapes.ESCAPE_NONE /*0*/:
                case PayPal.PAYMENT_SUBTYPE_INSURANCE /*10*/:
                case PayPal.PAYMENT_SUBTYPE_MORTGAGE /*13*/:
                    throw syntaxError("Unterminated string");
                case '\\':
                    next = next();
                    switch (next) {
                        case '\"':
                        case '\'':
                        case '/':
                        case '\\':
                            stringBuffer.append(next);
                            break;
                        case 'b':
                            stringBuffer.append('\b');
                            break;
                        case 'f':
                            stringBuffer.append('\f');
                            break;
                        case 'n':
                            stringBuffer.append('\n');
                            break;
                        case 'r':
                            stringBuffer.append('\r');
                            break;
                        case 't':
                            stringBuffer.append('\t');
                            break;
                        case 'u':
                            stringBuffer.append((char) Integer.parseInt(next(4), 16));
                            break;
                        default:
                            throw syntaxError("Illegal escape.");
                    }
                default:
                    if (next != c) {
                        stringBuffer.append(next);
                        break;
                    }
                    return stringBuffer.toString();
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String nextTo(char r4) throws com.amazonaws.util.json.JSONException {
        /*
        r3 = this;
        r0 = new java.lang.StringBuffer;
        r0.<init>();
    L_0x0005:
        r1 = r3.next();
        if (r1 == r4) goto L_0x0015;
    L_0x000b:
        if (r1 == 0) goto L_0x0015;
    L_0x000d:
        r2 = 10;
        if (r1 == r2) goto L_0x0015;
    L_0x0011:
        r2 = 13;
        if (r1 != r2) goto L_0x0023;
    L_0x0015:
        if (r1 == 0) goto L_0x001a;
    L_0x0017:
        r3.back();
    L_0x001a:
        r0 = r0.toString();
        r0 = r0.trim();
        return r0;
    L_0x0023:
        r0.append(r1);
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.util.json.JSONTokener.nextTo(char):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String nextTo(java.lang.String r4) throws com.amazonaws.util.json.JSONException {
        /*
        r3 = this;
        r0 = new java.lang.StringBuffer;
        r0.<init>();
    L_0x0005:
        r1 = r3.next();
        r2 = r4.indexOf(r1);
        if (r2 >= 0) goto L_0x0019;
    L_0x000f:
        if (r1 == 0) goto L_0x0019;
    L_0x0011:
        r2 = 10;
        if (r1 == r2) goto L_0x0019;
    L_0x0015:
        r2 = 13;
        if (r1 != r2) goto L_0x0027;
    L_0x0019:
        if (r1 == 0) goto L_0x001e;
    L_0x001b:
        r3.back();
    L_0x001e:
        r0 = r0.toString();
        r0 = r0.trim();
        return r0;
    L_0x0027:
        r0.append(r1);
        goto L_0x0005;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.util.json.JSONTokener.nextTo(java.lang.String):java.lang.String");
    }

    public Object nextValue() throws JSONException {
        char nextClean = nextClean();
        switch (nextClean) {
            case '\"':
            case '\'':
                return nextString(nextClean);
            case '(':
            case '[':
                back();
                return new JSONArray(this);
            case '{':
                back();
                return new JSONObject(this);
            default:
                StringBuffer stringBuffer = new StringBuffer();
                while (nextClean >= ' ' && ",:]}/\\\"[{;=#".indexOf(nextClean) < 0) {
                    stringBuffer.append(nextClean);
                    nextClean = next();
                }
                back();
                String trim = stringBuffer.toString().trim();
                if (!trim.equals(StringUtil.EMPTY_STRING)) {
                    return JSONObject.stringToValue(trim);
                }
                throw syntaxError("Missing value");
        }
    }

    public char skipTo(char c) throws JSONException {
        try {
            char next;
            int i = this.index;
            int i2 = this.character;
            int i3 = this.line;
            this.reader.mark(Integer.MAX_VALUE);
            do {
                next = next();
                if (next == '\u0000') {
                    this.reader.reset();
                    this.index = i;
                    this.character = i2;
                    this.line = i3;
                    break;
                }
            } while (next != c);
            back();
            return next;
        } catch (Throwable e) {
            throw new JSONException(e);
        }
    }

    public JSONException syntaxError(String str) {
        return new JSONException(str + toString());
    }

    public String toString() {
        return " at " + this.index + " [character " + this.character + " line " + this.line + "]";
    }
}
