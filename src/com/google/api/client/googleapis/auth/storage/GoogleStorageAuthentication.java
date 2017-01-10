package com.google.api.client.googleapis.auth.storage;

import com.google.api.client.auth.HmacSha;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpExecuteIntercepter;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpTransport;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Pattern;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

public final class GoogleStorageAuthentication {
    private static final String HOST = "commondatastorage.googleapis.com";

    static class Intercepter implements HttpExecuteIntercepter {
        private static final Pattern WHITESPACE_PATTERN;
        String accessKey;
        String secret;

        Intercepter() {
        }

        static {
            WHITESPACE_PATTERN = Pattern.compile("\\s+");
        }

        public void intercept(HttpRequest request) throws IOException {
            HttpHeaders headers = request.headers;
            StringBuilder messageBuf = new StringBuilder();
            messageBuf.append(request.method).append('\n');
            String contentMD5 = headers.contentMD5;
            if (contentMD5 != null) {
                messageBuf.append(contentMD5);
            }
            messageBuf.append('\n');
            HttpContent content = request.content;
            if (content != null) {
                messageBuf.append(content.getType());
            }
            messageBuf.append('\n');
            if (headers.date != null) {
                messageBuf.append(headers.date);
            }
            messageBuf.append('\n');
            TreeMap<String, String> extensions = new TreeMap();
            for (Entry<String, Object> headerEntry : headers.entrySet()) {
                String name = ((String) headerEntry.getKey()).toLowerCase();
                Collection<Object> value = headerEntry.getValue();
                if (value != null) {
                    if (name.startsWith("x-goog-")) {
                        if (value instanceof Collection) {
                            Collection<Object> collectionValue = value;
                            StringBuilder buf = new StringBuilder();
                            boolean first = true;
                            for (Object repeatedValue : collectionValue) {
                                if (first) {
                                    first = false;
                                } else {
                                    buf.append(',');
                                }
                                buf.append(WHITESPACE_PATTERN.matcher(repeatedValue.toString()).replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
                            }
                            extensions.put(name, buf.toString());
                        } else {
                            extensions.put(name, WHITESPACE_PATTERN.matcher(value.toString()).replaceAll(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR));
                        }
                    }
                }
            }
            for (Entry<String, String> extensionEntry : extensions.entrySet()) {
                messageBuf.append((String) extensionEntry.getKey()).append(':').append((String) extensionEntry.getValue()).append('\n');
            }
            GenericUrl url = request.url;
            String host = url.host;
            if (host.endsWith(GoogleStorageAuthentication.HOST)) {
                int bucketNameLength = (host.length() - GoogleStorageAuthentication.HOST.length()) - 1;
                if (bucketNameLength > 0) {
                    String bucket = host.substring(0, bucketNameLength);
                    if (!bucket.equals("c")) {
                        messageBuf.append('/').append(bucket);
                    }
                }
                if (url.pathParts != null) {
                    messageBuf.append(url.getRawPath());
                }
                if (url.get("acl") != null) {
                    messageBuf.append("?acl");
                } else {
                    if (url.get("location") != null) {
                        messageBuf.append("?location");
                    } else {
                        if (url.get("logging") != null) {
                            messageBuf.append("?logging");
                        } else {
                            if (url.get("requestPayment") != null) {
                                messageBuf.append("?requestPayment");
                            } else {
                                if (url.get("torrent") != null) {
                                    messageBuf.append("?torrent");
                                }
                            }
                        }
                    }
                }
                try {
                    HttpHeaders httpHeaders = request.headers;
                    httpHeaders.authorization = "GOOG1 " + this.accessKey + ":" + HmacSha.sign(this.secret, messageBuf.toString());
                    return;
                } catch (GeneralSecurityException e) {
                    IOException io = new IOException();
                    io.initCause(e);
                    throw io;
                }
            }
            throw new IllegalArgumentException("missing host commondatastorage.googleapis.com");
        }
    }

    public static void authorize(HttpTransport transport, String accessKey, String secret) {
        transport.removeIntercepters(Intercepter.class);
        Intercepter intercepter = new Intercepter();
        intercepter.accessKey = accessKey;
        intercepter.secret = secret;
        transport.intercepters.add(intercepter);
    }

    private GoogleStorageAuthentication() {
    }
}
