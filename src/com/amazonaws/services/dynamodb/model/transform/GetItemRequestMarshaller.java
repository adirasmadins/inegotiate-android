package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodb.model.AttributeValue;
import com.amazonaws.services.dynamodb.model.GetItemRequest;
import com.amazonaws.services.dynamodb.model.Key;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.JSONWriter;
import com.google.common.net.HttpHeaders;
import com.google.gdata.util.common.base.StringUtil;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.List;

public class GetItemRequestMarshaller implements Marshaller<Request<GetItemRequest>, GetItemRequest> {
    private String getString(String str) {
        return str == null ? StringUtil.EMPTY_STRING : str;
    }

    public Request<GetItemRequest> marshall(GetItemRequest getItemRequest) {
        if (getItemRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<GetItemRequest> defaultRequest = new DefaultRequest(getItemRequest, "AmazonDynamoDB");
        defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20111205.GetItem");
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
            List<Object> ss;
            Writer stringWriter = new StringWriter();
            JSONWriter jSONWriter = new JSONWriter(stringWriter);
            jSONWriter.object();
            if (getItemRequest.getTableName() != null) {
                jSONWriter.key("TableName").value(getItemRequest.getTableName());
            }
            Key key = getItemRequest.getKey();
            if (key != null) {
                List<ByteBuffer> bs;
                jSONWriter.key("Key");
                jSONWriter.object();
                AttributeValue hashKeyElement = key.getHashKeyElement();
                if (hashKeyElement != null) {
                    jSONWriter.key("HashKeyElement");
                    jSONWriter.object();
                    if (hashKeyElement.getS() != null) {
                        jSONWriter.key("S").value(hashKeyElement.getS());
                    }
                    if (hashKeyElement.getN() != null) {
                        jSONWriter.key("N").value(hashKeyElement.getN());
                    }
                    if (hashKeyElement.getB() != null) {
                        jSONWriter.key("B").value(hashKeyElement.getB());
                    }
                    ss = hashKeyElement.getSS();
                    if (ss != null && ss.size() > 0) {
                        jSONWriter.key("SS");
                        jSONWriter.array();
                        for (Object obj : ss) {
                            if (obj != null) {
                                jSONWriter.value(obj);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    ss = hashKeyElement.getNS();
                    if (ss != null && ss.size() > 0) {
                        jSONWriter.key("NS");
                        jSONWriter.array();
                        for (Object obj2 : ss) {
                            if (obj2 != null) {
                                jSONWriter.value(obj2);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    bs = hashKeyElement.getBS();
                    if (bs != null && bs.size() > 0) {
                        jSONWriter.key("BS");
                        jSONWriter.array();
                        for (ByteBuffer byteBuffer : bs) {
                            if (byteBuffer != null) {
                                jSONWriter.value(byteBuffer);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    jSONWriter.endObject();
                }
                AttributeValue rangeKeyElement = key.getRangeKeyElement();
                if (rangeKeyElement != null) {
                    jSONWriter.key("RangeKeyElement");
                    jSONWriter.object();
                    if (rangeKeyElement.getS() != null) {
                        jSONWriter.key("S").value(rangeKeyElement.getS());
                    }
                    if (rangeKeyElement.getN() != null) {
                        jSONWriter.key("N").value(rangeKeyElement.getN());
                    }
                    if (rangeKeyElement.getB() != null) {
                        jSONWriter.key("B").value(rangeKeyElement.getB());
                    }
                    ss = rangeKeyElement.getSS();
                    if (ss != null && ss.size() > 0) {
                        jSONWriter.key("SS");
                        jSONWriter.array();
                        for (Object obj22 : ss) {
                            if (obj22 != null) {
                                jSONWriter.value(obj22);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    ss = rangeKeyElement.getNS();
                    if (ss != null && ss.size() > 0) {
                        jSONWriter.key("NS");
                        jSONWriter.array();
                        for (Object obj222 : ss) {
                            if (obj222 != null) {
                                jSONWriter.value(obj222);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    bs = rangeKeyElement.getBS();
                    if (bs != null && bs.size() > 0) {
                        jSONWriter.key("BS");
                        jSONWriter.array();
                        for (ByteBuffer byteBuffer2 : bs) {
                            if (byteBuffer2 != null) {
                                jSONWriter.value(byteBuffer2);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    jSONWriter.endObject();
                }
                jSONWriter.endObject();
            }
            ss = getItemRequest.getAttributesToGet();
            if (ss != null && ss.size() > 0) {
                jSONWriter.key("AttributesToGet");
                jSONWriter.array();
                for (Object obj2222 : ss) {
                    if (obj2222 != null) {
                        jSONWriter.value(obj2222);
                    }
                }
                jSONWriter.endArray();
            }
            if (getItemRequest.isConsistentRead() != null) {
                jSONWriter.key("ConsistentRead").value(getItemRequest.isConsistentRead());
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
