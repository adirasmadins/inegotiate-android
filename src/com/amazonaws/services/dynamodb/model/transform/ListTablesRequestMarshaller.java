package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodb.model.ListTablesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.JSONWriter;
import com.google.common.net.HttpHeaders;
import com.google.gdata.util.common.base.StringUtil;
import java.io.StringWriter;
import java.io.Writer;

public class ListTablesRequestMarshaller implements Marshaller<Request<ListTablesRequest>, ListTablesRequest> {
    private String getString(String str) {
        return str == null ? StringUtil.EMPTY_STRING : str;
    }

    public Request<ListTablesRequest> marshall(ListTablesRequest listTablesRequest) {
        if (listTablesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ListTablesRequest> defaultRequest = new DefaultRequest(listTablesRequest, "AmazonDynamoDB");
        defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20111205.ListTables");
        defaultRequest.addHeader(HttpHeaders.CONTENT_TYPE, "application/x-amz-json-1.0");
        defaultRequest.setHttpMethod(HttpMethodName.POST);
        String replaceAll = StringUtil.EMPTY_STRING.replaceAll("//", "/");
        if (replaceAll.contains("?")) {
            String substring = replaceAll.substring(replaceAll.indexOf("?") + 1);
            replaceAll = replaceAll.substring(0, replaceAll.indexOf("?"));
            for (String str : substring.split("[;&]")) {
                String[] split = str.split("=");
                if (split.length == 2) {
                    defaultRequest.addParameter(split[0], split[1]);
                } else {
                    defaultRequest.addParameter(str, null);
                }
            }
        }
        defaultRequest.setResourcePath(replaceAll);
        try {
            Writer stringWriter = new StringWriter();
            JSONWriter jSONWriter = new JSONWriter(stringWriter);
            jSONWriter.object();
            if (listTablesRequest.getExclusiveStartTableName() != null) {
                jSONWriter.key("ExclusiveStartTableName").value(listTablesRequest.getExclusiveStartTableName());
            }
            if (listTablesRequest.getLimit() != null) {
                jSONWriter.key("Limit").value(listTablesRequest.getLimit());
            }
            jSONWriter.endObject();
            replaceAll = stringWriter.toString();
            byte[] bytes = replaceAll.getBytes(StringEncodings.UTF8);
            defaultRequest.setContent(new StringInputStream(replaceAll));
            defaultRequest.addHeader(HttpHeaders.CONTENT_LENGTH, Integer.toString(bytes.length));
            return defaultRequest;
        } catch (Throwable th) {
            AmazonClientException amazonClientException = new AmazonClientException("Unable to marshall request to JSON: " + th.getMessage(), th);
        }
    }
}
