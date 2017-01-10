package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.http.HttpMethodName;
import com.amazonaws.services.dynamodb.model.AttributeValue;
import com.amazonaws.services.dynamodb.model.Condition;
import com.amazonaws.services.dynamodb.model.Key;
import com.amazonaws.services.dynamodb.model.ScanRequest;
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

public class ScanRequestMarshaller implements Marshaller<Request<ScanRequest>, ScanRequest> {
    private String getString(String str) {
        return str == null ? StringUtil.EMPTY_STRING : str;
    }

    public Request<ScanRequest> marshall(ScanRequest scanRequest) {
        if (scanRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ScanRequest> defaultRequest = new DefaultRequest(scanRequest, "AmazonDynamoDB");
        defaultRequest.addHeader("X-Amz-Target", "DynamoDB_20111205.Scan");
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
            AttributeValue rangeKeyElement;
            Writer stringWriter = new StringWriter();
            JSONWriter jSONWriter = new JSONWriter(stringWriter);
            jSONWriter.object();
            if (scanRequest.getTableName() != null) {
                jSONWriter.key("TableName").value(scanRequest.getTableName());
            }
            List<Object> attributesToGet = scanRequest.getAttributesToGet();
            if (attributesToGet != null && attributesToGet.size() > 0) {
                jSONWriter.key("AttributesToGet");
                jSONWriter.array();
                for (Object obj : attributesToGet) {
                    if (obj != null) {
                        jSONWriter.value(obj);
                    }
                }
                jSONWriter.endArray();
            }
            if (scanRequest.getLimit() != null) {
                jSONWriter.key("Limit").value(scanRequest.getLimit());
            }
            if (scanRequest.isCount() != null) {
                jSONWriter.key("Count").value(scanRequest.isCount());
            }
            if (scanRequest.getScanFilter() != null) {
                jSONWriter.key("ScanFilter");
                jSONWriter.object();
                for (Entry entry : scanRequest.getScanFilter().entrySet()) {
                    if (entry.getValue() != null) {
                        jSONWriter.key((String) entry.getKey());
                        jSONWriter.object();
                        List<AttributeValue> attributeValueList = ((Condition) entry.getValue()).getAttributeValueList();
                        if (attributeValueList != null && attributeValueList.size() > 0) {
                            jSONWriter.key("AttributeValueList");
                            jSONWriter.array();
                            for (AttributeValue rangeKeyElement2 : attributeValueList) {
                                if (rangeKeyElement2 != null) {
                                    jSONWriter.object();
                                    if (rangeKeyElement2.getS() != null) {
                                        jSONWriter.key("S").value(rangeKeyElement2.getS());
                                    }
                                    if (rangeKeyElement2.getN() != null) {
                                        jSONWriter.key("N").value(rangeKeyElement2.getN());
                                    }
                                    if (rangeKeyElement2.getB() != null) {
                                        jSONWriter.key("B").value(rangeKeyElement2.getB());
                                    }
                                    List<Object> ss = rangeKeyElement2.getSS();
                                    if (ss != null && ss.size() > 0) {
                                        jSONWriter.key("SS");
                                        jSONWriter.array();
                                        for (Object obj2 : ss) {
                                            if (obj2 != null) {
                                                jSONWriter.value(obj2);
                                            }
                                        }
                                        jSONWriter.endArray();
                                    }
                                    ss = rangeKeyElement2.getNS();
                                    if (ss != null && ss.size() > 0) {
                                        jSONWriter.key("NS");
                                        jSONWriter.array();
                                        for (Object obj22 : ss) {
                                            if (obj22 != null) {
                                                jSONWriter.value(obj22);
                                            }
                                        }
                                        jSONWriter.endArray();
                                    }
                                    List<ByteBuffer> bs = rangeKeyElement2.getBS();
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
                            jSONWriter.endArray();
                        }
                        if (((Condition) entry.getValue()).getComparisonOperator() != null) {
                            jSONWriter.key("ComparisonOperator").value(((Condition) entry.getValue()).getComparisonOperator());
                        }
                        jSONWriter.endObject();
                    }
                }
                jSONWriter.endObject();
            }
            Key exclusiveStartKey = scanRequest.getExclusiveStartKey();
            if (exclusiveStartKey != null) {
                List<ByteBuffer> bs2;
                jSONWriter.key("ExclusiveStartKey");
                jSONWriter.object();
                AttributeValue hashKeyElement = exclusiveStartKey.getHashKeyElement();
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
                    attributesToGet = hashKeyElement.getSS();
                    if (attributesToGet != null && attributesToGet.size() > 0) {
                        jSONWriter.key("SS");
                        jSONWriter.array();
                        for (Object obj3 : attributesToGet) {
                            if (obj3 != null) {
                                jSONWriter.value(obj3);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    attributesToGet = hashKeyElement.getNS();
                    if (attributesToGet != null && attributesToGet.size() > 0) {
                        jSONWriter.key("NS");
                        jSONWriter.array();
                        for (Object obj32 : attributesToGet) {
                            if (obj32 != null) {
                                jSONWriter.value(obj32);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    bs2 = hashKeyElement.getBS();
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
                rangeKeyElement2 = exclusiveStartKey.getRangeKeyElement();
                if (rangeKeyElement2 != null) {
                    jSONWriter.key("RangeKeyElement");
                    jSONWriter.object();
                    if (rangeKeyElement2.getS() != null) {
                        jSONWriter.key("S").value(rangeKeyElement2.getS());
                    }
                    if (rangeKeyElement2.getN() != null) {
                        jSONWriter.key("N").value(rangeKeyElement2.getN());
                    }
                    if (rangeKeyElement2.getB() != null) {
                        jSONWriter.key("B").value(rangeKeyElement2.getB());
                    }
                    attributesToGet = rangeKeyElement2.getSS();
                    if (attributesToGet != null && attributesToGet.size() > 0) {
                        jSONWriter.key("SS");
                        jSONWriter.array();
                        for (Object obj322 : attributesToGet) {
                            if (obj322 != null) {
                                jSONWriter.value(obj322);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    attributesToGet = rangeKeyElement2.getNS();
                    if (attributesToGet != null && attributesToGet.size() > 0) {
                        jSONWriter.key("NS");
                        jSONWriter.array();
                        for (Object obj3222 : attributesToGet) {
                            if (obj3222 != null) {
                                jSONWriter.value(obj3222);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    bs2 = rangeKeyElement2.getBS();
                    if (bs2 != null && bs2.size() > 0) {
                        jSONWriter.key("BS");
                        jSONWriter.array();
                        for (ByteBuffer byteBuffer22 : bs2) {
                            if (byteBuffer22 != null) {
                                jSONWriter.value(byteBuffer22);
                            }
                        }
                        jSONWriter.endArray();
                    }
                    jSONWriter.endObject();
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
