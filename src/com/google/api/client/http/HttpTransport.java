package com.google.api.client.http;

import com.google.api.client.util.ArrayMap;
import com.google.gdata.client.GDataProtocol.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class HttpTransport {
    static final Logger LOGGER;
    private static LowLevelHttpTransport lowLevelHttpTransport;
    private final ArrayMap<String, HttpParser> contentTypeToParserMap;
    public HttpHeaders defaultHeaders;
    public List<HttpExecuteIntercepter> intercepters;

    static {
        LOGGER = Logger.getLogger(HttpTransport.class.getName());
    }

    public static void setLowLevelHttpTransport(LowLevelHttpTransport lowLevelHttpTransport) {
        lowLevelHttpTransport = lowLevelHttpTransport;
    }

    public static LowLevelHttpTransport useLowLevelHttpTransport() {
        LowLevelHttpTransport lowLevelHttpTransportInterface = lowLevelHttpTransport;
        if (lowLevelHttpTransportInterface == null) {
            boolean isAppEngineSdkOnClasspath = false;
            try {
                Class.forName("com.google.appengine.api.urlfetch.URLFetchServiceFactory");
                isAppEngineSdkOnClasspath = true;
                lowLevelHttpTransportInterface = (LowLevelHttpTransport) Class.forName("com.google.api.client.appengine.UrlFetchTransport").getField("INSTANCE").get(null);
                lowLevelHttpTransport = lowLevelHttpTransportInterface;
            } catch (Exception e) {
                boolean isApacheHttpClientOnClasspath = false;
                try {
                    Class.forName("org.apache.http.client.HttpClient");
                    isApacheHttpClientOnClasspath = true;
                    lowLevelHttpTransportInterface = (LowLevelHttpTransport) Class.forName("com.google.api.client.apache.ApacheHttpTransport").getField("INSTANCE").get(null);
                    lowLevelHttpTransport = lowLevelHttpTransportInterface;
                } catch (Exception e2) {
                    try {
                        lowLevelHttpTransportInterface = (LowLevelHttpTransport) Class.forName("com.google.api.client.javanet.NetHttpTransport").getField("INSTANCE").get(null);
                        lowLevelHttpTransport = lowLevelHttpTransportInterface;
                    } catch (Exception e3) {
                        StringBuilder buf = new StringBuilder("Missing required low-level HTTP transport package.\n");
                        if (isAppEngineSdkOnClasspath) {
                            buf.append("For Google App Engine, the required package is \"com.google.api.client.appengine\".\n");
                        }
                        if (isApacheHttpClientOnClasspath) {
                            boolean isAndroidOnClasspath = false;
                            try {
                                Class.forName("android.util.Log");
                                isAndroidOnClasspath = true;
                            } catch (Exception e4) {
                            }
                            if (isAndroidOnClasspath) {
                                buf.append("For Android, the preferred package is \"com.google.api.client.apache\".\n");
                            } else {
                                buf.append("For Apache HTTP Client, the preferred package is \"com.google.api.client.apache\".\n");
                            }
                        }
                        if (isAppEngineSdkOnClasspath || isApacheHttpClientOnClasspath) {
                            buf.append("Alternatively, use");
                        } else {
                            buf.append("Use");
                        }
                        buf.append(" package \"com.google.api.client.javanet\".");
                        throw new IllegalStateException(buf.toString());
                    }
                }
            }
            if (LOGGER.isLoggable(Level.CONFIG)) {
                LOGGER.config("Using low-level HTTP transport: " + lowLevelHttpTransportInterface.getClass().getName());
            }
        }
        return lowLevelHttpTransportInterface;
    }

    public void addParser(HttpParser parser) {
        this.contentTypeToParserMap.put(getNormalizedContentType(parser.getContentType()), parser);
    }

    public HttpParser getParser(String contentType) {
        if (contentType == null) {
            return null;
        }
        return (HttpParser) this.contentTypeToParserMap.get(getNormalizedContentType(contentType));
    }

    private String getNormalizedContentType(String contentType) {
        int semicolon = contentType.indexOf(59);
        return semicolon == -1 ? contentType : contentType.substring(0, semicolon);
    }

    public HttpTransport() {
        this.defaultHeaders = new HttpHeaders();
        this.contentTypeToParserMap = ArrayMap.create();
        this.intercepters = new ArrayList(1);
        useLowLevelHttpTransport();
    }

    public HttpRequest buildRequest() {
        return new HttpRequest(this, null);
    }

    public HttpRequest buildDeleteRequest() {
        return new HttpRequest(this, "DELETE");
    }

    public HttpRequest buildGetRequest() {
        return new HttpRequest(this, "GET");
    }

    public HttpRequest buildPostRequest() {
        return new HttpRequest(this, "POST");
    }

    public HttpRequest buildPutRequest() {
        return new HttpRequest(this, "PUT");
    }

    public HttpRequest buildPatchRequest() {
        return new HttpRequest(this, Method.PATCH);
    }

    public HttpRequest buildHeadRequest() {
        return new HttpRequest(this, "HEAD");
    }

    public void removeIntercepters(Class<?> intercepterClass) {
        Iterator<HttpExecuteIntercepter> iterable = this.intercepters.iterator();
        while (iterable.hasNext()) {
            if (intercepterClass.isAssignableFrom(((HttpExecuteIntercepter) iterable.next()).getClass())) {
                iterable.remove();
            }
        }
    }
}
