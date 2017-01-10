package com.google.gdata.util.common.net;

import com.google.common.collect.ForwardingMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimaps;
import com.google.gdata.util.common.base.Preconditions;
import com.google.gdata.util.common.base.StringUtil;
import com.google.gdata.util.httputil.FormUrlDecoder;
import com.google.gdata.util.httputil.FormUrlDecoder.Callback;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class UriParameterMap extends ForwardingMultimap<String, String> implements ListMultimap<String, String>, Cloneable, Serializable {
    public static final UriParameterMap EMPTY_MAP;
    private static final long serialVersionUID = -3053773769157973706L;
    private final ListMultimap<String, String> delegate;

    /* renamed from: com.google.gdata.util.common.net.UriParameterMap.1 */
    class C07771 implements Callback {
        C07771() {
        }

        public void handleParameter(String name, String value) {
            UriParameterMap.this.put(name, value);
        }
    }

    static {
        EMPTY_MAP = new UriParameterMap(ImmutableListMultimap.of());
    }

    private UriParameterMap(ListMultimap<String, String> delegate) {
        this.delegate = delegate;
    }

    public UriParameterMap() {
        this(LinkedListMultimap.create());
    }

    public static UriParameterMap parse(String query) {
        return parse(query, UriEncoder.DEFAULT_ENCODING);
    }

    public static UriParameterMap parse(String query, Charset encoding) {
        Preconditions.checkNotNull(query);
        UriParameterMap map = new UriParameterMap();
        map.merge(query, encoding);
        return map;
    }

    public static UriParameterMap unmodifiableMap(UriParameterMap map) {
        return new UriParameterMap(Multimaps.unmodifiableListMultimap(map.delegate()));
    }

    protected ListMultimap<String, String> delegate() {
        return this.delegate;
    }

    void merge(String query, Charset encoding) {
        Preconditions.checkNotNull(query);
        Preconditions.checkNotNull(encoding);
        FormUrlDecoder.parseWithCallback(query, encoding.name(), new C07771());
    }

    public String getFirst(String key) {
        Preconditions.checkNotNull(key);
        List<String> values = get(key);
        return values.isEmpty() ? null : (String) values.get(0);
    }

    public void appendTo(StringBuilder out, Charset encoding) {
        try {
            appendTo((Appendable) out, encoding);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public void appendTo(Appendable out, Charset encoding) throws IOException {
        Preconditions.checkNotNull(out);
        Iterator<Entry<String, String>> i = entries().iterator();
        while (i.hasNext()) {
            Entry<String, String> entry = (Entry) i.next();
            out.append(UriEncoder.encode((String) entry.getKey(), encoding));
            if (!StringUtil.EMPTY_STRING.equals(entry.getValue())) {
                out.append("=");
                out.append(UriEncoder.encode((String) entry.getValue(), encoding));
            }
            if (i.hasNext()) {
                out.append("&");
            }
        }
    }

    public UriParameterMap clone() {
        return new UriParameterMap(LinkedListMultimap.create(delegate()));
    }

    public String toString(Charset encoding) {
        StringBuilder out = new StringBuilder();
        appendTo(out, encoding);
        return out.toString();
    }

    public Map<String, String[]> copyToArrayMap() {
        Builder<String, String[]> builder = ImmutableMap.builder();
        for (Entry<String, Collection<String>> entry : delegate().asMap().entrySet()) {
            Collection<String> values = (Collection) entry.getValue();
            builder.put(entry.getKey(), values.toArray(new String[values.size()]));
        }
        return builder.build();
    }

    public String toString() {
        return toString(UriEncoder.DEFAULT_ENCODING);
    }

    public List<String> get(String key) {
        return delegate().get(key);
    }

    public List<String> removeAll(Object key) {
        return delegate().removeAll(key);
    }

    public List<String> replaceValues(String key, Iterable<? extends String> values) {
        return delegate().replaceValues(key, values);
    }
}
