package com.google.api.client.http;

import com.google.api.client.escape.CharEscapers;
import com.google.api.client.util.DataUtil;
import com.google.api.client.util.Strings;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.Map.Entry;

public final class UrlEncodedContent implements HttpContent {
    private byte[] content;
    public String contentType;
    public Object data;

    public UrlEncodedContent() {
        this.contentType = UrlEncodedParser.CONTENT_TYPE;
    }

    public String getEncoding() {
        return null;
    }

    public long getLength() {
        return (long) computeContent().length;
    }

    public String getType() {
        return this.contentType;
    }

    public void writeTo(OutputStream out) throws IOException {
        out.write(computeContent());
    }

    private byte[] computeContent() {
        if (this.content == null) {
            StringBuilder buf = new StringBuilder();
            boolean first = true;
            for (Entry<String, Object> nameValueEntry : DataUtil.mapOf(this.data).entrySet()) {
                Collection<?> value = nameValueEntry.getValue();
                if (value != null) {
                    String name = CharEscapers.escapeUri((String) nameValueEntry.getKey());
                    if (value instanceof Collection) {
                        for (Object repeatedValue : value) {
                            first = appendParam(first, buf, name, repeatedValue);
                        }
                    } else {
                        first = appendParam(first, buf, name, value);
                    }
                }
            }
            this.content = Strings.toBytesUtf8(buf.toString());
        }
        return this.content;
    }

    private static boolean appendParam(boolean first, StringBuilder buf, String name, Object value) {
        if (first) {
            first = false;
        } else {
            buf.append('&');
        }
        buf.append(name);
        String stringValue = CharEscapers.escapeUri(value.toString());
        if (stringValue.length() != 0) {
            buf.append('=').append(stringValue);
        }
        return first;
    }
}
