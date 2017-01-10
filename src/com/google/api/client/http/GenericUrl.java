package com.google.api.client.http;

import com.google.api.client.escape.CharEscapers;
import com.google.api.client.escape.Escaper;
import com.google.api.client.escape.PercentEscaper;
import com.google.api.client.util.GenericData;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public class GenericUrl extends GenericData {
    private static final Escaper URI_FRAGMENT_ESCAPER;
    public String fragment;
    public String host;
    public List<String> pathParts;
    public int port;
    public String scheme;

    static {
        URI_FRAGMENT_ESCAPER = new PercentEscaper("=&-_.!~*'()@:$,;/?:", false);
    }

    public GenericUrl() {
        this.port = -1;
    }

    public GenericUrl(String encodedUrl) {
        this.port = -1;
        try {
            URI uri = new URI(encodedUrl);
            this.scheme = uri.getScheme().toLowerCase();
            this.host = uri.getHost();
            this.port = uri.getPort();
            this.pathParts = toPathParts(uri.getRawPath());
            this.fragment = uri.getFragment();
            String query = uri.getRawQuery();
            if (query != null) {
                UrlEncodedParser.parse(query, (Object) this);
            }
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int hashCode() {
        return build().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || !(obj instanceof GenericUrl)) {
            return false;
        }
        return build().equals(((GenericUrl) obj).toString());
    }

    public String toString() {
        return build();
    }

    public GenericUrl clone() {
        GenericUrl result = (GenericUrl) super.clone();
        result.pathParts = new ArrayList(this.pathParts);
        return result;
    }

    public final String build() {
        StringBuilder buf = new StringBuilder();
        buf.append(this.scheme).append("://").append(this.host);
        int port = this.port;
        if (port != -1) {
            buf.append(':').append(port);
        }
        if (this.pathParts != null) {
            appendRawPathFromParts(buf);
        }
        boolean first = true;
        for (Entry<String, Object> nameValueEntry : entrySet()) {
            Collection<?> value = nameValueEntry.getValue();
            if (value != null) {
                String name = CharEscapers.escapeUriQuery((String) nameValueEntry.getKey());
                if (value instanceof Collection) {
                    for (Object repeatedValue : value) {
                        first = appendParam(first, buf, name, repeatedValue);
                    }
                } else {
                    first = appendParam(first, buf, name, value);
                }
            }
        }
        String fragment = this.fragment;
        if (fragment != null) {
            buf.append('#').append(URI_FRAGMENT_ESCAPER.escape(fragment));
        }
        return buf.toString();
    }

    public Object getFirst(String name) {
        Collection<Object> value = get(name);
        if (!(value instanceof Collection)) {
            return value;
        }
        Iterator<Object> iterator = value.iterator();
        return iterator.hasNext() ? iterator.next() : null;
    }

    public Collection<Object> getAll(String name) {
        Collection<Object> value = get(name);
        if (value == null) {
            return Collections.emptySet();
        }
        if (value instanceof Collection) {
            return Collections.unmodifiableCollection(value);
        }
        return Collections.singleton(value);
    }

    public String getRawPath() {
        if (this.pathParts == null) {
            return null;
        }
        StringBuilder buf = new StringBuilder();
        appendRawPathFromParts(buf);
        return buf.toString();
    }

    public void setRawPath(String encodedPath) {
        this.pathParts = toPathParts(encodedPath);
    }

    public void appendRawPath(String encodedPath) {
        if (encodedPath != null && encodedPath.length() != 0) {
            List<String> pathParts = this.pathParts;
            List<String> appendedPathParts = toPathParts(encodedPath);
            if (pathParts == null || pathParts.isEmpty()) {
                this.pathParts = appendedPathParts;
                return;
            }
            int size = pathParts.size();
            pathParts.set(size - 1, ((String) pathParts.get(size - 1)) + ((String) appendedPathParts.get(0)));
            pathParts.addAll(appendedPathParts.subList(1, appendedPathParts.size()));
        }
    }

    public static List<String> toPathParts(String encodedPath) {
        if (encodedPath == null || encodedPath.length() == 0) {
            return null;
        }
        List<String> result = new ArrayList();
        int cur = 0;
        boolean notDone = true;
        while (notDone) {
            String sub;
            int slash = encodedPath.indexOf(47, cur);
            notDone = slash != -1;
            if (notDone) {
                sub = encodedPath.substring(cur, slash);
            } else {
                sub = encodedPath.substring(cur);
            }
            result.add(CharEscapers.decodeUri(sub));
            cur = slash + 1;
        }
        return result;
    }

    private void appendRawPathFromParts(StringBuilder buf) {
        List<String> pathParts = this.pathParts;
        int size = pathParts.size();
        for (int i = 0; i < size; i++) {
            String pathPart = (String) pathParts.get(i);
            if (i != 0) {
                buf.append('/');
            }
            if (pathPart.length() != 0) {
                buf.append(CharEscapers.escapeUriPath(pathPart));
            }
        }
    }

    private static boolean appendParam(boolean first, StringBuilder buf, String name, Object value) {
        if (first) {
            first = false;
            buf.append('?');
        } else {
            buf.append('&');
        }
        buf.append(name);
        String stringValue = CharEscapers.escapeUriQuery(value.toString());
        if (stringValue.length() != 0) {
            buf.append('=').append(stringValue);
        }
        return first;
    }
}
