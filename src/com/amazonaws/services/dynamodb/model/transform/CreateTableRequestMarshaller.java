package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodb.model.CreateTableRequest;
import com.amazonaws.services.dynamodb.model.KeySchema;
import com.amazonaws.services.dynamodb.model.KeySchemaElement;
import com.amazonaws.services.dynamodb.model.ProvisionedThroughput;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.JSONWriter;
import com.google.common.net.HttpHeaders;
import com.google.gdata.util.common.base.StringUtil;
import java.io.StringWriter;
import java.io.Writer;

public class CreateTableRequestMarshaller implements Marshaller<Request<CreateTableRequest>, CreateTableRequest> {
    private String getString(String str) {
        return str == null ? StringUtil.EMPTY_STRING : str;
    }

    public Request<CreateTableRequest> marshall(CreateTableRequest createTableRequest) {
        if (createTableRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateTableRequest> defaultRequest = new DefaultRequest(createTableRequest, "AmazonDynamoDB");
        defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20111205.CreateTable");
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
            if (createTableRequest.getTableName() != null) {
                jSONWriter.key("TableName").value(createTableRequest.getTableName());
            }
            KeySchema keySchema = createTableRequest.getKeySchema();
            if (keySchema != null) {
                jSONWriter.key("KeySchema");
                jSONWriter.object();
                KeySchemaElement hashKeyElement = keySchema.getHashKeyElement();
                if (hashKeyElement != null) {
                    jSONWriter.key("HashKeyElement");
                    jSONWriter.object();
                    if (hashKeyElement.getAttributeName() != null) {
                        jSONWriter.key("AttributeName").value(hashKeyElement.getAttributeName());
                    }
                    if (hashKeyElement.getAttributeType() != null) {
                        jSONWriter.key("AttributeType").value(hashKeyElement.getAttributeType());
                    }
                    jSONWriter.endObject();
                }
                KeySchemaElement rangeKeyElement = keySchema.getRangeKeyElement();
                if (rangeKeyElement != null) {
                    jSONWriter.key("RangeKeyElement");
                    jSONWriter.object();
                    if (rangeKeyElement.getAttributeName() != null) {
                        jSONWriter.key("AttributeName").value(rangeKeyElement.getAttributeName());
                    }
                    if (rangeKeyElement.getAttributeType() != null) {
                        jSONWriter.key("AttributeType").value(rangeKeyElement.getAttributeType());
                    }
                    jSONWriter.endObject();
                }
                jSONWriter.endObject();
            }
            ProvisionedThroughput provisionedThroughput = createTableRequest.getProvisionedThroughput();
            if (provisionedThroughput != null) {
                jSONWriter.key("ProvisionedThroughput");
                jSONWriter.object();
                if (provisionedThroughput.getReadCapacityUnits() != null) {
                    jSONWriter.key("ReadCapacityUnits").value(provisionedThroughput.getReadCapacityUnits());
                }
                if (provisionedThroughput.getWriteCapacityUnits() != null) {
                    jSONWriter.key("WriteCapacityUnits").value(provisionedThroughput.getWriteCapacityUnits());
                }
                jSONWriter.endObject();
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
