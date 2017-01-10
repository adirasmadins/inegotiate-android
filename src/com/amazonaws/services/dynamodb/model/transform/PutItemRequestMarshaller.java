package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodb.model.AttributeValue;
import com.amazonaws.services.dynamodb.model.ExpectedAttributeValue;
import com.amazonaws.services.dynamodb.model.PutItemRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringInputStream;
import com.amazonaws.util.json.JSONWriter;
import com.google.common.net.HttpHeaders;
import com.google.gdata.util.common.base.StringUtil;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map.Entry;

public class PutItemRequestMarshaller implements Marshaller<Request<PutItemRequest>, PutItemRequest> {
    private String getString(String str) {
        return str == null ? StringUtil.EMPTY_STRING : str;
    }

    public Request<PutItemRequest> marshall(PutItemRequest putItemRequest) {
        if (putItemRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<PutItemRequest> defaultRequest = new DefaultRequest(putItemRequest, "AmazonDynamoDB");
        defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20111205.PutItem");
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
            if (putItemRequest.getTableName() != null) {
                jSONWriter.key("TableName").value(putItemRequest.getTableName());
            }
            if (putItemRequest.getItem() != null) {
                jSONWriter.key("Item");
                jSONWriter.object();
                for (Entry entry : putItemRequest.getItem().entrySet()) {
                    if (entry.getValue() != null) {
                        jSONWriter.key((String) entry.getKey());
                        jSONWriter.object();
                        if (((AttributeValue) entry.getValue()).getS() != null) {
                            jSONWriter.key("S").value(((AttributeValue) entry.getValue()).getS());
                        }
                        if (((AttributeValue) entry.getValue()).getN() != null) {
                            jSONWriter.key("N").value(((AttributeValue) entry.getValue()).getN());
                        }
                        if (((AttributeValue) entry.getValue()).getB() != null) {
                            jSONWriter.key("B").value(((AttributeValue) entry.getValue()).getB());
                        }
                        ss = ((AttributeValue) entry.getValue()).getSS();
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
                        ss = ((AttributeValue) entry.getValue()).getNS();
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
                        List<ByteBuffer> bs = ((AttributeValue) entry.getValue()).getBS();
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
                }
                jSONWriter.endObject();
            }
            if (putItemRequest.getExpected() != null) {
                jSONWriter.key("Expected");
                jSONWriter.object();
                for (Entry entry2 : putItemRequest.getExpected().entrySet()) {
                    if (entry2.getValue() != null) {
                        jSONWriter.key((String) entry2.getKey());
                        jSONWriter.object();
                        AttributeValue value = ((ExpectedAttributeValue) entry2.getValue()).getValue();
                        if (value != null) {
                            jSONWriter.key("Value");
                            jSONWriter.object();
                            if (value.getS() != null) {
                                jSONWriter.key("S").value(value.getS());
                            }
                            if (value.getN() != null) {
                                jSONWriter.key("N").value(value.getN());
                            }
                            if (value.getB() != null) {
                                jSONWriter.key("B").value(value.getB());
                            }
                            ss = value.getSS();
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
                            ss = value.getNS();
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
                            List<ByteBuffer> bs2 = value.getBS();
                            if (bs2 != null && bs2.size() > 0) {
                                jSONWriter.key("BS");
                                jSONWriter.array();
                                for (ByteBuffer byteBuffer2 : bs2) {
                                    if (byteBuffer2 != null) {
                                        jSONWriter.value(byteBuffer2);
                                    }
                                }
                                jSONWriter.endArray();
                            }
                            jSONWriter.endObject();
                        }
                        if (((ExpectedAttributeValue) entry2.getValue()).isExists() != null) {
                            jSONWriter.key("Exists").value(((ExpectedAttributeValue) entry2.getValue()).isExists());
                        }
                        jSONWriter.endObject();
                    }
                }
                jSONWriter.endObject();
            }
            if (putItemRequest.getReturnValues() != null) {
                jSONWriter.key("ReturnValues").value(putItemRequest.getReturnValues());
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
