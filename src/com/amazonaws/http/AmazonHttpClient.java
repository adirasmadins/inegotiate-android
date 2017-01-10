package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonServiceException.ErrorType;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.ResponseMetadata;
import com.amazonaws.handlers.RequestHandler;
import com.amazonaws.internal.CustomBackoffStrategy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.AWSRequestMetrics.Field;
import com.amazonaws.util.CountingInputStream;
import com.amazonaws.util.ResponseMetadataCache;
import com.amazonaws.util.TimingInfo;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpRequestBase;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class AmazonHttpClient {
    private static final int MAX_BACKOFF_IN_MILLISECONDS = 20000;
    public static final String PROFILING_SYSTEM_PROPERTY = "com.amazonaws.sdk.enableRuntimeProfiling";
    private static HttpClientFactory httpClientFactory;
    private static HttpRequestFactory httpRequestFactory;
    static final Log log;
    private static final Random random;
    private static final Log requestLog;
    private final ClientConfiguration config;
    private final HttpClient httpClient;
    private final ResponseMetadataCache responseMetadataCache;

    static {
        requestLog = LogFactory.getLog("com.amazonaws.request");
        log = LogFactory.getLog(AmazonHttpClient.class);
        random = new Random();
        httpRequestFactory = new HttpRequestFactory();
        httpClientFactory = new HttpClientFactory();
        List asList = Arrays.asList(new String[]{"1.6.0_06", "1.6.0_13", "1.6.0_17"});
        String property = System.getProperty("java.version");
        if (asList.contains(property)) {
            log.warn("Detected a possible problem with the current JVM version (" + property + ").  " + "If you experience XML parsing problems using the SDK, try upgrading to a more recent JVM update.");
        }
    }

    public AmazonHttpClient(ClientConfiguration clientConfiguration) {
        this.responseMetadataCache = new ResponseMetadataCache(50);
        this.config = clientConfiguration;
        this.httpClient = httpClientFactory.createHttpClient(this.config);
    }

    private void applyRequestData(Request<?> request) {
        if (this.config.getUserAgent() != null) {
            request.addHeader(HttpHeaders.USER_AGENT, this.config.getUserAgent());
        }
        if (request.getOriginalRequest() != null && request.getOriginalRequest().getRequestClientOptions() != null && request.getOriginalRequest().getRequestClientOptions().getClientMarker() != null) {
            request.addHeader(HttpHeaders.USER_AGENT, createUserAgentString(this.config.getUserAgent(), request.getOriginalRequest().getRequestClientOptions().getClientMarker()));
        }
    }

    private HttpResponse createResponse(HttpRequestBase httpRequestBase, Request<?> request, HttpResponse httpResponse) throws IOException {
        HttpResponse httpResponse2 = new HttpResponse(request, httpRequestBase);
        if (httpResponse.getEntity() != null) {
            httpResponse2.setContent(httpResponse.getEntity().getContent());
        }
        httpResponse2.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        httpResponse2.setStatusText(httpResponse.getStatusLine().getReasonPhrase());
        for (Header header : httpResponse.getAllHeaders()) {
            httpResponse2.addHeader(header.getName(), header.getValue());
        }
        return httpResponse2;
    }

    private static String createUserAgentString(String str, String str2) {
        return str.contains(str2) ? str : str.trim() + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str2.trim();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private <T> T executeHelper(com.amazonaws.Request<?> r20, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<T>> r21, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonServiceException> r22, com.amazonaws.http.ExecutionContext r23) throws com.amazonaws.AmazonClientException, com.amazonaws.AmazonServiceException {
        /*
        r19 = this;
        r7 = 0;
        r14 = r23.getAwsRequestMetrics();
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.ServiceName;
        r3 = r3.name();
        r4 = r20.getServiceName();
        r14.addProperty(r3, r4);
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.ServiceEndpoint;
        r3 = r3.name();
        r4 = r20.getEndpoint();
        r14.addProperty(r3, r4);
        r19.applyRequestData(r20);
        r6 = 0;
        r5 = 0;
        r4 = 0;
        r3 = 0;
        r15 = new java.util.HashMap;
        r15.<init>();
        r8 = r20.getParameters();
        r15.putAll(r8);
        r16 = new java.util.HashMap;
        r16.<init>();
        r8 = r20.getHeaders();
        r0 = r16;
        r0.putAll(r8);
        r10 = r5;
        r11 = r6;
        r8 = r7;
        r5 = r4;
        r4 = r3;
    L_0x0045:
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.AttemptCount;
        r3 = r3.name();
        r6 = r11 + 1;
        r6 = (long) r6;
        r14.setCounter(r3, r6);
        if (r11 <= 0) goto L_0x005f;
    L_0x0053:
        r0 = r20;
        r0.setParameters(r15);
        r0 = r20;
        r1 = r16;
        r0.setHeaders(r1);
    L_0x005f:
        r6 = 0;
        r7 = 0;
        r3 = r23.getSigner();	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        if (r3 == 0) goto L_0x008c;
    L_0x0067:
        r3 = r23.getCredentials();	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        if (r3 == 0) goto L_0x008c;
    L_0x006d:
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.RequestSigningTime;	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r14.startEvent(r3);	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r3 = r23.getSigner();	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r9 = r23.getCredentials();	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r0 = r20;
        r3.sign(r0, r9);	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.RequestSigningTime;	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r14.endEvent(r3);	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
    L_0x008c:
        r3 = requestLog;	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r3 = r3.isDebugEnabled();	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        if (r3 == 0) goto L_0x00b0;
    L_0x0094:
        r3 = requestLog;	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r9 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r9.<init>();	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r12 = "Sending Request: ";
        r9 = r9.append(r12);	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r12 = r20.toString();	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r9 = r9.append(r12);	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r9 = r9.toString();	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r3.debug(r9);	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
    L_0x00b0:
        r3 = httpRequestFactory;	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r0 = r19;
        r9 = r0.config;	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r0 = r20;
        r1 = r23;
        r6 = r3.createHttpRequest(r0, r9, r5, r1);	 Catch:{ IOException -> 0x02ed, all -> 0x02d9 }
        r3 = r6 instanceof org.apache.http.HttpEntityEnclosingRequest;	 Catch:{ IOException -> 0x02fa, all -> 0x02d9 }
        if (r3 == 0) goto L_0x032e;
    L_0x00c2:
        r0 = r6;
        r0 = (org.apache.http.HttpEntityEnclosingRequest) r0;	 Catch:{ IOException -> 0x02fa, all -> 0x02d9 }
        r3 = r0;
        r9 = r3.getEntity();	 Catch:{ IOException -> 0x02fa, all -> 0x02d9 }
    L_0x00ca:
        if (r10 == 0) goto L_0x00cf;
    L_0x00cc:
        r6.setURI(r10);	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
    L_0x00cf:
        if (r11 <= 0) goto L_0x00ec;
    L_0x00d1:
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.RetryPauseTime;	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        r14.startEvent(r3);	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        r3 = r23.getCustomBackoffStrategy();	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        r0 = r19;
        r0.pauseExponentially(r11, r4, r3);	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.RetryPauseTime;	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        r14.endEvent(r3);	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
    L_0x00ec:
        if (r9 == 0) goto L_0x0101;
    L_0x00ee:
        r3 = r9.getContent();	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        if (r11 <= 0) goto L_0x0159;
    L_0x00f4:
        r5 = r3.markSupported();	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        if (r5 == 0) goto L_0x0101;
    L_0x00fa:
        r3.reset();	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        r5 = -1;
        r3.mark(r5);	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
    L_0x0101:
        r12 = 0;
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.HttpRequestTime;	 Catch:{ IOException -> 0x0307, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x0307, all -> 0x02d9 }
        r14.startEvent(r3);	 Catch:{ IOException -> 0x0307, all -> 0x02d9 }
        r0 = r19;
        r3 = r0.httpClient;	 Catch:{ IOException -> 0x0307, all -> 0x02d9 }
        r7 = r3.execute(r6);	 Catch:{ IOException -> 0x0307, all -> 0x02d9 }
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.HttpRequestTime;	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r14.endEvent(r3);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r0 = r19;
        r3 = r0.isRequestSuccessful(r7);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        if (r3 == 0) goto L_0x01e0;
    L_0x0124:
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.StatusCode;	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4 = r7.getStatusLine();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4 = r4.getStatusCode();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4 = java.lang.Integer.valueOf(r4);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r14.addProperty(r3, r4);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r13 = r21.needsConnectionLeftOpen();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r3 = r19;
        r4 = r20;
        r5 = r21;
        r8 = r23;
        r3 = r3.handleResponse(r4, r5, r6, r7, r8);	 Catch:{ IOException -> 0x0314, all -> 0x02dc }
        r4 = r11 + 1;
        if (r13 != 0) goto L_0x0158;
    L_0x014d:
        r4 = r7.getEntity();	 Catch:{ Throwable -> 0x032b }
        r4 = r4.getContent();	 Catch:{ Throwable -> 0x032b }
        r4.close();	 Catch:{ Throwable -> 0x032b }
    L_0x0158:
        return r3;
    L_0x0159:
        r5 = r3.markSupported();	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        if (r5 == 0) goto L_0x0101;
    L_0x015f:
        r5 = -1;
        r3.mark(r5);	 Catch:{ IOException -> 0x0164, all -> 0x02d9 }
        goto L_0x0101;
    L_0x0164:
        r3 = move-exception;
        r5 = r10;
        r17 = r7;
        r7 = r8;
        r8 = r17;
        r18 = r4;
        r4 = r9;
        r9 = r6;
        r6 = r3;
        r3 = r18;
    L_0x0172:
        r10 = log;	 Catch:{ all -> 0x01ca }
        r12 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ca }
        r12.<init>();	 Catch:{ all -> 0x01ca }
        r13 = "Unable to execute HTTP request: ";
        r12 = r12.append(r13);	 Catch:{ all -> 0x01ca }
        r13 = r6.getMessage();	 Catch:{ all -> 0x01ca }
        r12 = r12.append(r13);	 Catch:{ all -> 0x01ca }
        r12 = r12.toString();	 Catch:{ all -> 0x01ca }
        r10.info(r12, r6);	 Catch:{ all -> 0x01ca }
        r10 = com.amazonaws.util.AWSRequestMetrics.Field.Exception;	 Catch:{ all -> 0x01ca }
        r10 = r10.name();	 Catch:{ all -> 0x01ca }
        r12 = r6.toString();	 Catch:{ all -> 0x01ca }
        r14.addProperty(r10, r12);	 Catch:{ all -> 0x01ca }
        r10 = com.amazonaws.util.AWSRequestMetrics.Field.AWSRequestID;	 Catch:{ all -> 0x01ca }
        r10 = r10.name();	 Catch:{ all -> 0x01ca }
        r12 = 0;
        r14.addProperty(r10, r12);	 Catch:{ all -> 0x01ca }
        r0 = r19;
        r9 = r0.shouldRetry(r9, r6, r11);	 Catch:{ all -> 0x01ca }
        if (r9 != 0) goto L_0x02bc;
    L_0x01ad:
        r3 = new com.amazonaws.AmazonClientException;	 Catch:{ all -> 0x01ca }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01ca }
        r4.<init>();	 Catch:{ all -> 0x01ca }
        r5 = "Unable to execute HTTP request: ";
        r4 = r4.append(r5);	 Catch:{ all -> 0x01ca }
        r5 = r6.getMessage();	 Catch:{ all -> 0x01ca }
        r4 = r4.append(r5);	 Catch:{ all -> 0x01ca }
        r4 = r4.toString();	 Catch:{ all -> 0x01ca }
        r3.<init>(r4, r6);	 Catch:{ all -> 0x01ca }
        throw r3;	 Catch:{ all -> 0x01ca }
    L_0x01ca:
        r3 = move-exception;
        r17 = r8;
        r8 = r7;
        r7 = r17;
    L_0x01d0:
        r4 = r11 + 1;
        if (r8 != 0) goto L_0x01df;
    L_0x01d4:
        r4 = r7.getEntity();	 Catch:{ Throwable -> 0x02d6 }
        r4 = r4.getContent();	 Catch:{ Throwable -> 0x02d6 }
        r4.close();	 Catch:{ Throwable -> 0x02d6 }
    L_0x01df:
        throw r3;
    L_0x01e0:
        r0 = r19;
        r3 = r0.isTemporaryRedirect(r7);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        if (r3 == 0) goto L_0x0259;
    L_0x01e8:
        r3 = "location";
        r3 = r7.getHeaders(r3);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4 = 0;
        r3 = r3[r4];	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r3 = r3.getValue();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4 = log;	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r5 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r5.<init>();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r13 = "Redirecting to: ";
        r5 = r5.append(r13);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r5 = r5.append(r3);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r5 = r5.toString();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4.debug(r5);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r10 = java.net.URI.create(r3);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r6.setURI(r10);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4 = com.amazonaws.util.AWSRequestMetrics.Field.StatusCode;	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4 = r4.name();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r5 = r7.getStatusLine();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r5 = r5.getStatusCode();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r14.addProperty(r4, r5);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4 = com.amazonaws.util.AWSRequestMetrics.Field.RedirectLocation;	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4 = r4.name();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r14.addProperty(r4, r3);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.AWSRequestID;	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r4 = 0;
        r14.addProperty(r3, r4);	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r3 = r12;
        r4 = r10;
        r6 = r8;
    L_0x023f:
        r5 = r11 + 1;
        if (r6 != 0) goto L_0x0331;
    L_0x0243:
        r7 = r7.getEntity();	 Catch:{ Throwable -> 0x02b6 }
        r7 = r7.getContent();	 Catch:{ Throwable -> 0x02b6 }
        r7.close();	 Catch:{ Throwable -> 0x02b6 }
        r7 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r9;
    L_0x0252:
        r10 = r5;
        r11 = r6;
        r8 = r7;
        r5 = r4;
        r4 = r3;
        goto L_0x0045;
    L_0x0259:
        r8 = r22.needsConnectionLeftOpen();	 Catch:{ IOException -> 0x02e0, all -> 0x02d9 }
        r0 = r19;
        r1 = r20;
        r2 = r22;
        r4 = r0.handleErrorResponse(r1, r2, r6, r7);	 Catch:{ IOException -> 0x031e, all -> 0x02d9 }
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.AWSRequestID;	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r5 = r4.getRequestId();	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r14.addProperty(r3, r5);	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.AWSErrorCode;	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r5 = r4.getErrorCode();	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r14.addProperty(r3, r5);	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r3 = com.amazonaws.util.AWSRequestMetrics.Field.StatusCode;	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r3 = r3.name();	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r5 = r4.getStatusCode();	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r14.addProperty(r3, r5);	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r0 = r19;
        r3 = r0.shouldRetry(r6, r4, r11);	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        if (r3 != 0) goto L_0x02ab;
    L_0x029a:
        throw r4;	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
    L_0x029b:
        r3 = move-exception;
        r5 = r10;
        r17 = r7;
        r7 = r8;
        r8 = r17;
        r18 = r4;
        r4 = r9;
        r9 = r6;
        r6 = r3;
        r3 = r18;
        goto L_0x0172;
    L_0x02ab:
        r0 = r19;
        r1 = r20;
        r0.resetRequestAfterError(r1, r4);	 Catch:{ IOException -> 0x029b, all -> 0x02d9 }
        r3 = r4;
        r6 = r8;
        r4 = r10;
        goto L_0x023f;
    L_0x02b6:
        r7 = move-exception;
        r7 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r9;
        goto L_0x0252;
    L_0x02bc:
        r0 = r19;
        r1 = r20;
        r0.resetRequestAfterError(r1, r6);	 Catch:{ all -> 0x01ca }
        r6 = r11 + 1;
        if (r7 != 0) goto L_0x0252;
    L_0x02c7:
        r8 = r8.getEntity();	 Catch:{ Throwable -> 0x02d3 }
        r8 = r8.getContent();	 Catch:{ Throwable -> 0x02d3 }
        r8.close();	 Catch:{ Throwable -> 0x02d3 }
        goto L_0x0252;
    L_0x02d3:
        r8 = move-exception;
        goto L_0x0252;
    L_0x02d6:
        r4 = move-exception;
        goto L_0x01df;
    L_0x02d9:
        r3 = move-exception;
        goto L_0x01d0;
    L_0x02dc:
        r3 = move-exception;
        r8 = r13;
        goto L_0x01d0;
    L_0x02e0:
        r3 = move-exception;
        r4 = r9;
        r5 = r10;
        r9 = r6;
        r6 = r3;
        r3 = r12;
        r17 = r7;
        r7 = r8;
        r8 = r17;
        goto L_0x0172;
    L_0x02ed:
        r3 = move-exception;
        r9 = r6;
        r6 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r10;
        r17 = r7;
        r7 = r8;
        r8 = r17;
        goto L_0x0172;
    L_0x02fa:
        r3 = move-exception;
        r9 = r6;
        r6 = r3;
        r3 = r4;
        r4 = r5;
        r5 = r10;
        r17 = r7;
        r7 = r8;
        r8 = r17;
        goto L_0x0172;
    L_0x0307:
        r3 = move-exception;
        r4 = r9;
        r5 = r10;
        r9 = r6;
        r6 = r3;
        r3 = r12;
        r17 = r7;
        r7 = r8;
        r8 = r17;
        goto L_0x0172;
    L_0x0314:
        r3 = move-exception;
        r8 = r7;
        r4 = r9;
        r5 = r10;
        r9 = r6;
        r7 = r13;
        r6 = r3;
        r3 = r12;
        goto L_0x0172;
    L_0x031e:
        r3 = move-exception;
        r4 = r9;
        r5 = r10;
        r9 = r6;
        r6 = r3;
        r3 = r12;
        r17 = r7;
        r7 = r8;
        r8 = r17;
        goto L_0x0172;
    L_0x032b:
        r4 = move-exception;
        goto L_0x0158;
    L_0x032e:
        r9 = r5;
        goto L_0x00ca;
    L_0x0331:
        r7 = r6;
        r6 = r5;
        r5 = r4;
        r4 = r9;
        goto L_0x0252;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.executeHelper(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.ExecutionContext):T");
    }

    private AmazonServiceException handleErrorResponse(Request<?> request, HttpResponseHandler<AmazonServiceException> httpResponseHandler, HttpRequestBase httpRequestBase, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        HttpResponse createResponse = createResponse(httpRequestBase, request, httpResponse);
        if (httpResponseHandler.needsConnectionLeftOpen() && (httpRequestBase instanceof HttpEntityEnclosingRequestBase)) {
            createResponse.setContent(new HttpMethodReleaseInputStream((HttpEntityEnclosingRequestBase) httpRequestBase));
        }
        try {
            amazonServiceException = (AmazonServiceException) httpResponseHandler.handle(createResponse);
            requestLog.debug("Received error response: " + amazonServiceException.toString());
        } catch (Throwable e) {
            if (statusCode == 413) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(413);
                amazonServiceException.setErrorType(ErrorType.Client);
                amazonServiceException.setErrorCode("Request entity too large");
            } else if (statusCode == 503 && "Service Unavailable".equalsIgnoreCase(httpResponse.getStatusLine().getReasonPhrase())) {
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.getServiceName());
                amazonServiceException.setStatusCode(503);
                amazonServiceException.setErrorType(ErrorType.Service);
                amazonServiceException.setErrorCode("Service unavailable");
            } else {
                throw new AmazonClientException("Unable to unmarshall error response (" + e.getMessage() + ")", e);
            }
        }
        amazonServiceException.setStatusCode(statusCode);
        amazonServiceException.setServiceName(request.getServiceName());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    private <T> T handleResponse(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpRequestBase httpRequestBase, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        HttpResponse createResponse = createResponse(httpRequestBase, request, httpResponse);
        if (httpResponseHandler.needsConnectionLeftOpen() && (httpRequestBase instanceof HttpEntityEnclosingRequest)) {
            createResponse.setContent(new HttpMethodReleaseInputStream((HttpEntityEnclosingRequest) httpRequestBase));
        }
        try {
            CountingInputStream countingInputStream;
            if (System.getProperty(PROFILING_SYSTEM_PROPERTY) != null) {
                InputStream countingInputStream2 = new CountingInputStream(createResponse.getContent());
                createResponse.setContent(countingInputStream2);
                countingInputStream = countingInputStream2;
            } else {
                countingInputStream = null;
            }
            AWSRequestMetrics awsRequestMetrics = executionContext.getAwsRequestMetrics();
            awsRequestMetrics.startEvent(Field.ResponseProcessingTime.name());
            AmazonWebServiceResponse amazonWebServiceResponse = (AmazonWebServiceResponse) httpResponseHandler.handle(createResponse);
            awsRequestMetrics.endEvent(Field.ResponseProcessingTime.name());
            if (countingInputStream != null) {
                awsRequestMetrics.setCounter(Field.BytesProcessed.name(), countingInputStream.getByteCount());
            }
            if (amazonWebServiceResponse == null) {
                throw new RuntimeException("Unable to unmarshall response metadata");
            }
            this.responseMetadataCache.add(request.getOriginalRequest(), amazonWebServiceResponse.getResponseMetadata());
            if (requestLog.isDebugEnabled()) {
                requestLog.debug("Received successful response: " + httpResponse.getStatusLine().getStatusCode() + ", AWS Request ID: " + amazonWebServiceResponse.getRequestId());
            }
            awsRequestMetrics.addProperty(Field.AWSRequestID.name(), amazonWebServiceResponse.getRequestId());
            return amazonWebServiceResponse.getResult();
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to unmarshall response (" + e.getMessage() + ")", e);
        }
    }

    private boolean isRequestSuccessful(HttpResponse httpResponse) {
        return httpResponse.getStatusLine().getStatusCode() / 100 == 2;
    }

    private boolean isTemporaryRedirect(HttpResponse httpResponse) {
        return httpResponse.getStatusLine().getStatusCode() == 307 && httpResponse.getHeaders(HttpHeaders.LOCATION) != null && httpResponse.getHeaders(HttpHeaders.LOCATION).length > 0;
    }

    private boolean isThrottlingException(AmazonServiceException amazonServiceException) {
        return amazonServiceException == null ? false : "Throttling".equals(amazonServiceException.getErrorCode()) || "ThrottlingException".equals(amazonServiceException.getErrorCode()) || "ProvisionedThroughputExceededException".equals(amazonServiceException.getErrorCode());
    }

    private void pauseExponentially(int i, AmazonServiceException amazonServiceException, CustomBackoffStrategy customBackoffStrategy) {
        long backoffPeriod;
        if (customBackoffStrategy != null) {
            backoffPeriod = (long) customBackoffStrategy.getBackoffPeriod(i);
        } else {
            backoffPeriod = 300;
            if (isThrottlingException(amazonServiceException)) {
                backoffPeriod = (long) (random.nextInt(100) + 500);
            }
            backoffPeriod = (long) (((double) backoffPeriod) * Math.pow(2.0d, (double) i));
        }
        backoffPeriod = Math.min(backoffPeriod, 20000);
        if (log.isDebugEnabled()) {
            log.debug("Retriable error detected, will retry in " + backoffPeriod + "ms, attempt number: " + i);
        }
        try {
            Thread.sleep(backoffPeriod);
        } catch (Throwable e) {
            throw new AmazonClientException(e.getMessage(), e);
        }
    }

    private void resetRequestAfterError(Request<?> request, Exception exception) throws AmazonClientException {
        if (request.getContent() != null && request.getContent().markSupported()) {
            try {
                request.getContent().reset();
            } catch (IOException e) {
                throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exception);
            }
        }
    }

    private boolean shouldRetry(HttpRequestBase httpRequestBase, Exception exception, int i) {
        if (i >= this.config.getMaxErrorRetry()) {
            return false;
        }
        if (httpRequestBase instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequestBase).getEntity();
            if (!(entity == null || entity.isRepeatable())) {
                if (!log.isDebugEnabled()) {
                    return false;
                }
                log.debug("Entity not repeatable");
                return false;
            }
        }
        if (exception instanceof IOException) {
            if (log.isDebugEnabled()) {
                log.debug("Retrying on " + exception.getClass().getName() + ": " + exception.getMessage());
            }
            return true;
        } else if (!(exception instanceof AmazonServiceException)) {
            return false;
        } else {
            AmazonServiceException amazonServiceException = (AmazonServiceException) exception;
            return (amazonServiceException.getStatusCode() == 500 || amazonServiceException.getStatusCode() == 503) ? true : isThrottlingException(amazonServiceException);
        }
    }

    public <T> T execute(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) throws AmazonClientException, AmazonServiceException {
        long currentTimeMillis = System.currentTimeMillis();
        if (executionContext == null) {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
        List requestHandlers = executionContext.getRequestHandlers();
        List<RequestHandler> arrayList = requestHandlers == null ? new ArrayList() : requestHandlers;
        for (RequestHandler beforeRequest : arrayList) {
            beforeRequest.beforeRequest(request);
        }
        try {
            TimingInfo timingInfo = new TimingInfo(currentTimeMillis);
            T executeHelper = executeHelper(request, httpResponseHandler, httpResponseHandler2, executionContext);
            timingInfo.setEndTime(System.currentTimeMillis());
            for (RequestHandler beforeRequest2 : arrayList) {
                try {
                    beforeRequest2.afterResponse(request, executeHelper, timingInfo);
                } catch (ClassCastException e) {
                }
            }
            return executeHelper;
        } catch (Exception e2) {
            Exception exception = e2;
            for (RequestHandler beforeRequest22 : arrayList) {
                beforeRequest22.afterError(request, exception);
            }
            throw exception;
        }
    }

    protected void finalize() throws Throwable {
        shutdown();
        super.finalize();
    }

    public ResponseMetadata getResponseMetadataForRequest(AmazonWebServiceRequest amazonWebServiceRequest) {
        return this.responseMetadataCache.get(amazonWebServiceRequest);
    }

    public void shutdown() {
        IdleConnectionReaper.removeConnectionManager(this.httpClient.getConnectionManager());
        this.httpClient.getConnectionManager().shutdown();
    }
}
