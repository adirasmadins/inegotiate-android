package com.amazonaws.services.s3.internal;

import com.amazonaws.Request;
import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.ResponseHeaderOverrides;
import com.doviknissim.inegotiate.app.DBAdapter;
import com.google.gdata.util.common.base.StringUtil;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

public class RestUtils {
    private static final List<String> SIGNED_PARAMETERS;

    static {
        SIGNED_PARAMETERS = Arrays.asList(new String[]{"acl", "torrent", "logging", "location", "policy", "requestPayment", "versioning", "versions", "versionId", "notification", "uploadId", "uploads", "partNumber", "website", "delete", "lifecycle", "tagging", "cors", ResponseHeaderOverrides.RESPONSE_HEADER_CACHE_CONTROL, ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_DISPOSITION, ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_ENCODING, ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_LANGUAGE, ResponseHeaderOverrides.RESPONSE_HEADER_CONTENT_TYPE, ResponseHeaderOverrides.RESPONSE_HEADER_EXPIRES});
    }

    public static <T> String makeS3CanonicalString(String str, String str2, Request<T> request, String str3) {
        String str4;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str + "\n");
        Map headers = request.getHeaders();
        SortedMap treeMap = new TreeMap();
        if (headers != null && headers.size() > 0) {
            for (Entry entry : headers.entrySet()) {
                str4 = (String) entry.getKey();
                String str5 = (String) entry.getValue();
                if (str4 != null) {
                    str4 = str4.toString().toLowerCase(Locale.getDefault());
                    if (str4.equals("content-type") || str4.equals("content-md5") || str4.equals(DBAdapter.DATE) || str4.startsWith(Headers.AMAZON_PREFIX)) {
                        treeMap.put(str4, str5);
                    }
                }
            }
        }
        if (treeMap.containsKey(Headers.S3_ALTERNATE_DATE)) {
            treeMap.put(DBAdapter.DATE, StringUtil.EMPTY_STRING);
        }
        if (str3 != null) {
            treeMap.put(DBAdapter.DATE, str3);
        }
        if (!treeMap.containsKey("content-type")) {
            treeMap.put("content-type", StringUtil.EMPTY_STRING);
        }
        if (!treeMap.containsKey("content-md5")) {
            treeMap.put("content-md5", StringUtil.EMPTY_STRING);
        }
        for (Entry entry2 : request.getParameters().entrySet()) {
            if (((String) entry2.getKey()).startsWith(Headers.AMAZON_PREFIX)) {
                treeMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        for (Entry entry22 : treeMap.entrySet()) {
            str4 = (String) entry22.getKey();
            Object value = entry22.getValue();
            if (str4.startsWith(Headers.AMAZON_PREFIX)) {
                stringBuilder.append(str4).append(':').append(value);
            } else {
                stringBuilder.append(value);
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append(str2);
        String[] strArr = (String[]) request.getParameters().keySet().toArray(new String[request.getParameters().size()]);
        Arrays.sort(strArr);
        char c = '?';
        for (String str6 : strArr) {
            if (SIGNED_PARAMETERS.contains(str6)) {
                stringBuilder.append(c);
                stringBuilder.append(str6);
                str4 = (String) request.getParameters().get(str6);
                if (str4 != null) {
                    stringBuilder.append("=").append(str4);
                }
                c = '&';
            }
        }
        return stringBuilder.toString();
    }
}
