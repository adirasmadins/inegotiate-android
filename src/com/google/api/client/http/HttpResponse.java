package com.google.api.client.http;

import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Strings;
import com.google.gdata.util.common.base.StringUtil;
import com.google.protobuf.CodedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

public final class HttpResponse {
    private InputStream content;
    public final String contentEncoding;
    private long contentLength;
    public final String contentType;
    public boolean disableContentLogging;
    public final HttpHeaders headers;
    public final boolean isSuccessStatusCode;
    private LowLevelHttpResponse response;
    public final int statusCode;
    public final String statusMessage;
    public final HttpTransport transport;

    HttpResponse(HttpTransport transport, LowLevelHttpResponse response) {
        this.transport = transport;
        this.response = response;
        this.contentLength = response.getContentLength();
        this.contentType = response.getContentType();
        this.contentEncoding = response.getContentEncoding();
        int code = response.getStatusCode();
        this.statusCode = code;
        this.isSuccessStatusCode = isSuccessStatusCode(code);
        String message = response.getReasonPhrase();
        this.statusMessage = message;
        Logger logger = HttpTransport.LOGGER;
        boolean loggable = logger.isLoggable(Level.CONFIG);
        StringBuilder logbuf = null;
        if (loggable) {
            logbuf = new StringBuilder();
            logbuf.append("-------------- RESPONSE --------------").append(Strings.LINE_SEPARATOR);
            String statusLine = response.getStatusLine();
            if (statusLine != null) {
                logbuf.append(statusLine);
            } else {
                logbuf.append(code);
                if (message != null) {
                    logbuf.append(' ').append(message);
                }
            }
            logbuf.append(Strings.LINE_SEPARATOR);
        }
        int size = response.getHeaderCount();
        Class<? extends HttpHeaders> headersClass = transport.defaultHeaders.getClass();
        ClassInfo classInfo = ClassInfo.of(headersClass);
        HttpHeaders headers = (HttpHeaders) ClassInfo.newInstance(headersClass);
        this.headers = headers;
        HashMap<String, String> fieldNameMap = HttpHeaders.getFieldNameMap(headersClass);
        for (int i = 0; i < size; i++) {
            String headerName = response.getHeaderName(i);
            String headerValue = response.getHeaderValue(i);
            if (loggable) {
                logbuf.append(headerName + ": " + headerValue).append(Strings.LINE_SEPARATOR);
            }
            String fieldName = (String) fieldNameMap.get(headerName);
            if (fieldName == null) {
                fieldName = headerName;
            }
            FieldInfo fieldInfo = classInfo.getFieldInfo(fieldName);
            if (fieldInfo != null) {
                Class<?> type = fieldInfo.type;
                if (Collection.class.isAssignableFrom(type)) {
                    Collection<Object> collection = (Collection) fieldInfo.getValue(headers);
                    if (collection == null) {
                        collection = ClassInfo.newCollectionInstance(type);
                        fieldInfo.setValue(headers, collection);
                    }
                    collection.add(FieldInfo.parsePrimitiveValue(ClassInfo.getCollectionParameter(fieldInfo.field), headerValue));
                } else {
                    fieldInfo.setValue(headers, FieldInfo.parsePrimitiveValue(type, headerValue));
                }
            } else {
                ArrayList<String> listValue = (ArrayList) headers.get(fieldName);
                if (listValue == null) {
                    listValue = new ArrayList();
                    headers.set(fieldName, listValue);
                }
                listValue.add(headerValue);
            }
        }
        if (loggable) {
            logger.config(logbuf.toString());
        }
    }

    public InputStream getContent() throws IOException {
        if (this.response == null) {
            return this.content;
        }
        InputStream content = this.response.getContent();
        this.response = null;
        if (content == null) {
            return content;
        }
        byte[] debugContentByteArray = null;
        Logger logger = HttpTransport.LOGGER;
        boolean loggable = (!this.disableContentLogging && logger.isLoggable(Level.CONFIG)) || logger.isLoggable(Level.ALL);
        if (loggable) {
            ByteArrayOutputStream debugStream = new ByteArrayOutputStream();
            InputStreamContent.copy(content, debugStream);
            debugContentByteArray = debugStream.toByteArray();
            content = new ByteArrayInputStream(debugContentByteArray);
            logger.config("Response size: " + debugContentByteArray.length + " bytes");
        }
        String contentEncoding = this.contentEncoding;
        if (contentEncoding != null && contentEncoding.contains("gzip")) {
            InputStream content2 = new GZIPInputStream(content);
            this.contentLength = -1;
            if (loggable) {
                debugStream = new ByteArrayOutputStream();
                InputStreamContent.copy(content2, debugStream);
                debugContentByteArray = debugStream.toByteArray();
                content = new ByteArrayInputStream(debugContentByteArray);
            } else {
                content = content2;
            }
        }
        if (loggable) {
            String contentType = this.contentType;
            if (debugContentByteArray.length != 0 && LogContent.isTextBasedContentType(contentType)) {
                logger.config(new String(debugContentByteArray));
            }
        }
        this.content = content;
        return content;
    }

    public void ignore() throws IOException {
        InputStream content = getContent();
        if (content != null) {
            content.close();
        }
    }

    public HttpParser getParser() {
        return this.transport.getParser(this.contentType);
    }

    public <T> T parseAs(Class<T> dataClass) throws IOException {
        HttpParser parser = getParser();
        if (parser != null) {
            return parser.parse(this, dataClass);
        }
        InputStream content = getContent();
        if (this.contentType != null) {
            throw new IllegalArgumentException("No parser defined for Content-Type: " + this.contentType);
        } else if (content == null) {
            return null;
        } else {
            throw new IllegalArgumentException("Missing Content-Type header in response: " + parseAsString());
        }
    }

    public String parseAsString() throws IOException {
        int bufferSize = CodedOutputStream.DEFAULT_BUFFER_SIZE;
        InputStream content = getContent();
        if (content == null) {
            return StringUtil.EMPTY_STRING;
        }
        try {
            long contentLength = this.contentLength;
            if (contentLength != -1) {
                bufferSize = (int) contentLength;
            }
            int length = 0;
            byte[] buffer = new byte[bufferSize];
            byte[] tmp = new byte[CodedOutputStream.DEFAULT_BUFFER_SIZE];
            while (true) {
                int bytesRead = content.read(tmp);
                if (bytesRead == -1) {
                    break;
                }
                if (length + bytesRead > bufferSize) {
                    bufferSize = Math.max(bufferSize << 1, length + bytesRead);
                    byte[] newbuffer = new byte[bufferSize];
                    System.arraycopy(buffer, 0, newbuffer, 0, length);
                    buffer = newbuffer;
                }
                System.arraycopy(tmp, 0, buffer, length, bytesRead);
                length += bytesRead;
            }
            String str = new String(buffer, 0, length);
            return str;
        } finally {
            content.close();
        }
    }

    public static boolean isSuccessStatusCode(int statusCode) {
        return statusCode >= 200 && statusCode < 300;
    }
}
