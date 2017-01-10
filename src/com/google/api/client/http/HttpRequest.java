package com.google.api.client.http;

import com.google.api.client.util.Strings;
import com.google.common.net.HttpHeaders;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class HttpRequest {
    private static final String USER_AGENT_SUFFIX = "Google-API-Java-Client/1.2.2-alpha";
    public HttpContent content;
    public boolean disableContentLogging;
    public HttpHeaders headers;
    public String method;
    public final HttpTransport transport;
    public GenericUrl url;

    HttpRequest(HttpTransport transport, String method) {
        this.transport = transport;
        this.headers = transport.defaultHeaders.clone();
        this.method = method;
    }

    public void setUrl(String encodedUrl) {
        this.url = new GenericUrl(encodedUrl);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.api.client.http.HttpResponse execute() throws java.io.IOException {
        /*
        r34 = this;
        r0 = r34;
        r0 = r0.method;
        r31 = r0;
        com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(r31);
        r0 = r34;
        r0 = r0.url;
        r31 = r0;
        com.google.api.client.repackaged.com.google.common.base.Preconditions.checkNotNull(r31);
        r0 = r34;
        r0 = r0.transport;
        r27 = r0;
        r0 = r27;
        r0 = r0.intercepters;
        r31 = r0;
        r14 = r31.iterator();
    L_0x0022:
        r31 = r14.hasNext();
        if (r31 == 0) goto L_0x0036;
    L_0x0028:
        r16 = r14.next();
        r16 = (com.google.api.client.http.HttpExecuteIntercepter) r16;
        r0 = r16;
        r1 = r34;
        r0.intercept(r1);
        goto L_0x0022;
    L_0x0036:
        r21 = com.google.api.client.http.HttpTransport.useLowLevelHttpTransport();
        r0 = r34;
        r0 = r0.method;
        r23 = r0;
        r0 = r34;
        r0 = r0.url;
        r28 = r0;
        r29 = r28.build();
        r31 = "DELETE";
        r0 = r23;
        r1 = r31;
        r31 = r0.equals(r1);
        if (r31 == 0) goto L_0x00fb;
    L_0x0056:
        r0 = r21;
        r1 = r29;
        r20 = r0.buildDeleteRequest(r1);
    L_0x005e:
        r19 = com.google.api.client.http.HttpTransport.LOGGER;
        r31 = java.util.logging.Level.CONFIG;
        r0 = r19;
        r1 = r31;
        r18 = r0.isLoggable(r1);
        r17 = 0;
        if (r18 == 0) goto L_0x009d;
    L_0x006e:
        r17 = new java.lang.StringBuilder;
        r17.<init>();
        r31 = "-------------- REQUEST  --------------";
        r0 = r17;
        r1 = r31;
        r31 = r0.append(r1);
        r32 = com.google.api.client.util.Strings.LINE_SEPARATOR;
        r31.append(r32);
        r0 = r17;
        r1 = r23;
        r31 = r0.append(r1);
        r32 = 32;
        r31 = r31.append(r32);
        r0 = r31;
        r1 = r29;
        r31 = r0.append(r1);
        r32 = com.google.api.client.util.Strings.LINE_SEPARATOR;
        r31.append(r32);
    L_0x009d:
        r0 = r34;
        r13 = r0.headers;
        r0 = r13.userAgent;
        r31 = r0;
        if (r31 != 0) goto L_0x01a2;
    L_0x00a7:
        r31 = "Google-API-Java-Client/1.2.2-alpha";
        r0 = r31;
        r13.userAgent = r0;
    L_0x00ad:
        r12 = new java.util.HashSet;
        r12.<init>();
        r0 = r34;
        r0 = r0.headers;
        r31 = r0;
        r31 = r31.entrySet();
        r14 = r31.iterator();
    L_0x00c0:
        r31 = r14.hasNext();
        if (r31 == 0) goto L_0x01fa;
    L_0x00c6:
        r11 = r14.next();
        r11 = (java.util.Map.Entry) r11;
        r24 = r11.getKey();
        r24 = (java.lang.String) r24;
        r22 = r24.toLowerCase();
        r0 = r22;
        r31 = r12.add(r0);
        if (r31 != 0) goto L_0x01bf;
    L_0x00de:
        r31 = new java.lang.IllegalArgumentException;
        r32 = new java.lang.StringBuilder;
        r32.<init>();
        r33 = "multiple headers of the same name (headers are case insensitive): ";
        r32 = r32.append(r33);
        r0 = r32;
        r1 = r22;
        r32 = r0.append(r1);
        r32 = r32.toString();
        r31.<init>(r32);
        throw r31;
    L_0x00fb:
        r31 = "GET";
        r0 = r23;
        r1 = r31;
        r31 = r0.equals(r1);
        if (r31 == 0) goto L_0x0111;
    L_0x0107:
        r0 = r21;
        r1 = r29;
        r20 = r0.buildGetRequest(r1);
        goto L_0x005e;
    L_0x0111:
        r31 = "HEAD";
        r0 = r23;
        r1 = r31;
        r31 = r0.equals(r1);
        if (r31 == 0) goto L_0x0135;
    L_0x011d:
        r31 = r21.supportsHead();
        if (r31 != 0) goto L_0x012b;
    L_0x0123:
        r31 = new java.lang.IllegalArgumentException;
        r32 = "HTTP transport doesn't support HEAD";
        r31.<init>(r32);
        throw r31;
    L_0x012b:
        r0 = r21;
        r1 = r29;
        r20 = r0.buildHeadRequest(r1);
        goto L_0x005e;
    L_0x0135:
        r31 = "PATCH";
        r0 = r23;
        r1 = r31;
        r31 = r0.equals(r1);
        if (r31 == 0) goto L_0x0159;
    L_0x0141:
        r31 = r21.supportsPatch();
        if (r31 != 0) goto L_0x014f;
    L_0x0147:
        r31 = new java.lang.IllegalArgumentException;
        r32 = "HTTP transport doesn't support PATCH";
        r31.<init>(r32);
        throw r31;
    L_0x014f:
        r0 = r21;
        r1 = r29;
        r20 = r0.buildPatchRequest(r1);
        goto L_0x005e;
    L_0x0159:
        r31 = "POST";
        r0 = r23;
        r1 = r31;
        r31 = r0.equals(r1);
        if (r31 == 0) goto L_0x016f;
    L_0x0165:
        r0 = r21;
        r1 = r29;
        r20 = r0.buildPostRequest(r1);
        goto L_0x005e;
    L_0x016f:
        r31 = "PUT";
        r0 = r23;
        r1 = r31;
        r31 = r0.equals(r1);
        if (r31 == 0) goto L_0x0185;
    L_0x017b:
        r0 = r21;
        r1 = r29;
        r20 = r0.buildPutRequest(r1);
        goto L_0x005e;
    L_0x0185:
        r31 = new java.lang.IllegalArgumentException;
        r32 = new java.lang.StringBuilder;
        r32.<init>();
        r33 = "illegal method: ";
        r32 = r32.append(r33);
        r0 = r32;
        r1 = r23;
        r32 = r0.append(r1);
        r32 = r32.toString();
        r31.<init>(r32);
        throw r31;
    L_0x01a2:
        r31 = new java.lang.StringBuilder;
        r31.<init>();
        r0 = r13.userAgent;
        r32 = r0;
        r31 = r31.append(r32);
        r32 = " Google-API-Java-Client/1.2.2-alpha";
        r31 = r31.append(r32);
        r31 = r31.toString();
        r0 = r31;
        r13.userAgent = r0;
        goto L_0x00ad;
    L_0x01bf:
        r30 = r11.getValue();
        if (r30 == 0) goto L_0x00c0;
    L_0x01c5:
        r0 = r30;
        r0 = r0 instanceof java.util.Collection;
        r31 = r0;
        if (r31 == 0) goto L_0x01eb;
    L_0x01cd:
        r30 = (java.util.Collection) r30;
        r15 = r30.iterator();
    L_0x01d3:
        r31 = r15.hasNext();
        if (r31 == 0) goto L_0x00c0;
    L_0x01d9:
        r25 = r15.next();
        r0 = r19;
        r1 = r17;
        r2 = r20;
        r3 = r24;
        r4 = r25;
        addHeader(r0, r1, r2, r3, r4);
        goto L_0x01d3;
    L_0x01eb:
        r0 = r19;
        r1 = r17;
        r2 = r20;
        r3 = r24;
        r4 = r30;
        addHeader(r0, r1, r2, r3, r4);
        goto L_0x00c0;
    L_0x01fa:
        r0 = r34;
        r6 = r0.content;
        if (r6 == 0) goto L_0x02f0;
    L_0x0200:
        r8 = r6.getEncoding();
        r9 = r6.getLength();
        r7 = r6.getType();
        r31 = 0;
        r31 = (r9 > r31 ? 1 : (r9 == r31 ? 0 : -1));
        if (r31 == 0) goto L_0x02ed;
    L_0x0212:
        if (r8 != 0) goto L_0x02ed;
    L_0x0214:
        r31 = com.google.api.client.http.LogContent.isTextBasedContentType(r7);
        if (r31 == 0) goto L_0x02ed;
    L_0x021a:
        if (r18 == 0) goto L_0x0224;
    L_0x021c:
        r0 = r34;
        r0 = r0.disableContentLogging;
        r31 = r0;
        if (r31 == 0) goto L_0x0230;
    L_0x0224:
        r31 = java.util.logging.Level.ALL;
        r0 = r19;
        r1 = r31;
        r31 = r0.isLoggable(r1);
        if (r31 == 0) goto L_0x0236;
    L_0x0230:
        r5 = new com.google.api.client.http.LogContent;
        r5.<init>(r6, r7, r8, r9);
        r6 = r5;
    L_0x0236:
        r31 = 256; // 0x100 float:3.59E-43 double:1.265E-321;
        r31 = (r9 > r31 ? 1 : (r9 == r31 ? 0 : -1));
        if (r31 < 0) goto L_0x02ed;
    L_0x023c:
        r5 = new com.google.api.client.http.GZipContent;
        r5.<init>(r6, r7);
        r8 = r5.getEncoding();
        r9 = r5.getLength();
    L_0x0249:
        if (r18 == 0) goto L_0x02b9;
    L_0x024b:
        r31 = new java.lang.StringBuilder;
        r31.<init>();
        r32 = "Content-Type: ";
        r31 = r31.append(r32);
        r0 = r31;
        r31 = r0.append(r7);
        r31 = r31.toString();
        r0 = r17;
        r1 = r31;
        r31 = r0.append(r1);
        r32 = com.google.api.client.util.Strings.LINE_SEPARATOR;
        r31.append(r32);
        if (r8 == 0) goto L_0x0291;
    L_0x026f:
        r31 = new java.lang.StringBuilder;
        r31.<init>();
        r32 = "Content-Encoding: ";
        r31 = r31.append(r32);
        r0 = r31;
        r31 = r0.append(r8);
        r31 = r31.toString();
        r0 = r17;
        r1 = r31;
        r31 = r0.append(r1);
        r32 = com.google.api.client.util.Strings.LINE_SEPARATOR;
        r31.append(r32);
    L_0x0291:
        r31 = 0;
        r31 = (r9 > r31 ? 1 : (r9 == r31 ? 0 : -1));
        if (r31 < 0) goto L_0x02b9;
    L_0x0297:
        r31 = new java.lang.StringBuilder;
        r31.<init>();
        r32 = "Content-Length: ";
        r31 = r31.append(r32);
        r0 = r31;
        r31 = r0.append(r9);
        r31 = r31.toString();
        r0 = r17;
        r1 = r31;
        r31 = r0.append(r1);
        r32 = com.google.api.client.util.Strings.LINE_SEPARATOR;
        r31.append(r32);
    L_0x02b9:
        r0 = r20;
        r0.setContent(r5);
    L_0x02be:
        if (r18 == 0) goto L_0x02cb;
    L_0x02c0:
        r31 = r17.toString();
        r0 = r19;
        r1 = r31;
        r0.config(r1);
    L_0x02cb:
        r26 = new com.google.api.client.http.HttpResponse;
        r31 = r20.execute();
        r0 = r26;
        r1 = r27;
        r2 = r31;
        r0.<init>(r1, r2);
        r0 = r26;
        r0 = r0.isSuccessStatusCode;
        r31 = r0;
        if (r31 != 0) goto L_0x02ec;
    L_0x02e2:
        r31 = new com.google.api.client.http.HttpResponseException;
        r0 = r31;
        r1 = r26;
        r0.<init>(r1);
        throw r31;
    L_0x02ec:
        return r26;
    L_0x02ed:
        r5 = r6;
        goto L_0x0249;
    L_0x02f0:
        r5 = r6;
        goto L_0x02be;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.http.HttpRequest.execute():com.google.api.client.http.HttpResponse");
    }

    private static void addHeader(Logger logger, StringBuilder logbuf, LowLevelHttpRequest lowLevelHttpRequest, String name, Object value) {
        String stringValue = value.toString();
        if (logbuf != null) {
            logbuf.append(name).append(": ");
            if (!HttpHeaders.AUTHORIZATION.equals(name) || logger.isLoggable(Level.ALL)) {
                logbuf.append(stringValue);
            } else {
                logbuf.append("<Not Logged>");
            }
            logbuf.append(Strings.LINE_SEPARATOR);
        }
        lowLevelHttpRequest.addHeader(name, stringValue);
    }
}
