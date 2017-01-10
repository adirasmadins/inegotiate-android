package com.amazonaws.util;

import com.amazonaws.http.AmazonHttpClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AWSRequestMetrics {
    private static final Object COMMA_SEPARATOR;
    private static final Object KEY_VALUE_SEPARATOR;
    private static final Log latencyLogger;
    private final Map<String, Long> eventsBeingProfiled;
    private final boolean profilingSystemPropertyEnabled;
    private final Map<String, List<Object>> properties;
    private final TimingInfo timingInfo;

    public enum Field {
        StatusCode,
        AWSErrorCode,
        AWSRequestID,
        BytesProcessed,
        AttemptCount,
        ResponseProcessingTime,
        ClientExecuteTime,
        RequestSigningTime,
        HttpRequestTime,
        RequestMarshallTime,
        RetryPauseTime,
        RedirectLocation,
        Exception,
        CredentialsRequestTime,
        ServiceEndpoint,
        ServiceName
    }

    static {
        latencyLogger = LogFactory.getLog("com.amazonaws.latency");
        KEY_VALUE_SEPARATOR = "=";
        COMMA_SEPARATOR = ", ";
    }

    public AWSRequestMetrics() {
        this.properties = new HashMap();
        this.eventsBeingProfiled = new HashMap();
        this.timingInfo = new TimingInfo();
        this.profilingSystemPropertyEnabled = isProfilingEnabled();
    }

    private static boolean isProfilingEnabled() {
        return System.getProperty(AmazonHttpClient.PROFILING_SYSTEM_PROPERTY) != null;
    }

    private void keyValueFormat(Object obj, Object obj2, StringBuilder stringBuilder) {
        stringBuilder.append(obj).append(KEY_VALUE_SEPARATOR).append(obj2).append(COMMA_SEPARATOR);
    }

    public void addProperty(String str, Object obj) {
        List list = (List) this.properties.get(str);
        if (list == null) {
            list = new ArrayList();
            this.properties.put(str, list);
        }
        list.add(obj);
    }

    public void endEvent(String str) {
        if (this.profilingSystemPropertyEnabled) {
            Long l = (Long) this.eventsBeingProfiled.get(str);
            if (l == null) {
                throw new IllegalStateException("Trying to end an event which was never started. " + str);
            }
            this.timingInfo.addSubMeasurement(str, new TimingInfo(l.longValue(), System.nanoTime()));
        }
    }

    public TimingInfo getTimingInfo() {
        return this.timingInfo;
    }

    public void incrementCounter(String str) {
        if (this.profilingSystemPropertyEnabled) {
            this.timingInfo.incrementCounter(str);
        }
    }

    public void log() {
        if (this.profilingSystemPropertyEnabled) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Entry entry : this.properties.entrySet()) {
                keyValueFormat(entry.getKey(), entry.getValue(), stringBuilder);
            }
            for (Entry entry2 : this.timingInfo.getAllCounters().entrySet()) {
                keyValueFormat(entry2.getKey(), entry2.getValue(), stringBuilder);
            }
            for (Entry entry22 : this.timingInfo.getSubMeasurementsByName().entrySet()) {
                keyValueFormat(entry22.getKey(), entry22.getValue(), stringBuilder);
            }
            latencyLogger.info(stringBuilder.toString());
        }
    }

    public void setCounter(String str, long j) {
        if (this.profilingSystemPropertyEnabled) {
            this.timingInfo.setCounter(str, j);
        }
    }

    public void startEvent(String str) {
        if (this.profilingSystemPropertyEnabled) {
            this.eventsBeingProfiled.put(str, Long.valueOf(System.nanoTime()));
        }
    }
}
