package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodb.model.AttributeValue;
import com.amazonaws.services.dynamodb.model.BatchGetItemRequest;
import com.amazonaws.services.dynamodb.model.Key;
import com.amazonaws.services.dynamodb.model.KeysAndAttributes;
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

public class BatchGetItemRequestMarshaller implements Marshaller<Request<BatchGetItemRequest>, BatchGetItemRequest> {
    private String getString(String str) {
        return str == null ? StringUtil.EMPTY_STRING : str;
    }

    public Request<BatchGetItemRequest> marshall(BatchGetItemRequest batchGetItemRequest) {
        if (batchGetItemRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<BatchGetItemRequest> defaultRequest = new DefaultRequest(batchGetItemRequest, "AmazonDynamoDB");
        defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20111205.BatchGetItem");
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
            if (batchGetItemRequest.getRequestItems() != null) {
                jSONWriter.key("RequestItems");
                jSONWriter.object();
                for (Entry entry : batchGetItemRequest.getRequestItems().entrySet()) {
                    if (entry.getValue() != null) {
                        jSONWriter.key((String) entry.getKey());
                        jSONWriter.object();
                        List<Key> keys = ((KeysAndAttributes) entry.getValue()).getKeys();
                        if (keys != null && keys.size() > 0) {
                            jSONWriter.key("Keys");
                            jSONWriter.array();
                            for (Key key : keys) {
                                if (key != null) {
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
                                        List<Object> ss = hashKeyElement.getSS();
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
                                        List<ByteBuffer> bs = hashKeyElement.getBS();
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
                                        List<Object> ss2 = rangeKeyElement.getSS();
                                        if (ss2 != null && ss2.size() > 0) {
                                            jSONWriter.key("SS");
                                            jSONWriter.array();
                                            for (Object obj3 : ss2) {
                                                if (obj3 != null) {
                                                    jSONWriter.value(obj3);
                                                }
                                            }
                                            jSONWriter.endArray();
                                        }
                                        ss2 = rangeKeyElement.getNS();
                                        if (ss2 != null && ss2.size() > 0) {
                                            jSONWriter.key("NS");
                                            jSONWriter.array();
                                            for (Object obj32 : ss2) {
                                                if (obj32 != null) {
                                                    jSONWriter.value(obj32);
                                                }
                                            }
                                            jSONWriter.endArray();
                                        }
                                        List<ByteBuffer> bs2 = rangeKeyElement.getBS();
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
                                    jSONWriter.endObject();
                                }
                            }
                            jSONWriter.endArray();
                        }
                        List<Object> attributesToGet = ((KeysAndAttributes) entry.getValue()).getAttributesToGet();
                        if (attributesToGet != null && attributesToGet.size() > 0) {
                            jSONWriter.key("AttributesToGet");
                            jSONWriter.array();
                            for (Object obj4 : attributesToGet) {
                                if (obj4 != null) {
                                    jSONWriter.value(obj4);
                                }
                            }
                            jSONWriter.endArray();
                        }
                        jSONWriter.endObject();
                    }
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
