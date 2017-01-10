package com.amazonaws.util;

import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.google.gdata.model.QName;
import com.google.gdata.util.common.base.StringUtil;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

public class HttpUtils {
    private static final String DEFAULT_ENCODING = "UTF-8";

    public static String encodeParameters(Request<?> request) {
        List list;
        if (request.getParameters().size() > 0) {
            List arrayList = new ArrayList(request.getParameters().size());
            for (Entry entry : request.getParameters().entrySet()) {
                arrayList.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
            }
            list = arrayList;
        } else {
            list = null;
        }
        return list != null ? URLEncodedUtils.format(list, DEFAULT_ENCODING) : null;
    }

    public static boolean isUsingNonDefaultPort(URI uri) {
        String toLowerCase = uri.getScheme().toLowerCase();
        int port = uri.getPort();
        return port <= 0 ? false : (toLowerCase.equals("http") && port == 80) ? false : (toLowerCase.equals("https") && port == 443) ? false : true;
    }

    public static String urlEncode(String str, boolean z) {
        if (str == null) {
            return StringUtil.EMPTY_STRING;
        }
        try {
            String replace = URLEncoder.encode(str, DEFAULT_ENCODING).replace("+", "%20").replace(QName.ANY_LOCALNAME, "%2A").replace("%7E", "~");
            return z ? replace.replace("%2F", "/") : replace;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean usePayloadForQueryParameters(Request<?> request) {
        return HttpMethodName.POST.equals(request.getHttpMethod()) && (request.getContent() == null);
    }
}
