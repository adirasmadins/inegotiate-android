package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.Request;
import com.amazonaws.services.dynamodb.model.QueryRequest;
import com.amazonaws.transform.Marshaller;
import com.google.gdata.util.common.base.StringUtil;

public class QueryRequestMarshaller implements Marshaller<Request<QueryRequest>, QueryRequest> {
    private String getString(String str) {
        return str == null ? StringUtil.EMPTY_STRING : str;
    }

    public com.amazonaws.Request<com.amazonaws.services.dynamodb.model.QueryRequest> marshall(com.amazonaws.services.dynamodb.model.QueryRequest r11) {
        /* JADX: method processing error */
/*
        Error: java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Arrays.java:3181)
	at java.util.ArrayList.grow(ArrayList.java:261)
	at java.util.ArrayList.ensureExplicitCapacity(ArrayList.java:235)
	at java.util.ArrayList.ensureCapacityInternal(ArrayList.java:227)
	at java.util.ArrayList.add(ArrayList.java:458)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:447)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
	at jadx.core.utils.BlockUtils.collectWhileDominates(BlockUtils.java:448)
*/
        /*
        r10 = this;
        r2 = 0;
        if (r11 != 0) goto L_0x000b;
    L_0x0003:
        r0 = new com.amazonaws.AmazonClientException;
        r1 = "Invalid argument passed to marshall(...)";
        r0.<init>(r1);
        throw r0;
    L_0x000b:
        r3 = new com.amazonaws.DefaultRequest;
        r0 = "AmazonDynamoDB";
        r3.<init>(r11, r0);
        r0 = "DynamoDB_20111205.Query";
        r1 = "X-Amz-Target";
        r3.addHeader(r1, r0);
        r0 = "Content-Type";
        r1 = "application/x-amz-json-1.0";
        r3.addHeader(r0, r1);
        r0 = com.amazonaws.http.HttpMethodName.POST;
        r3.setHttpMethod(r0);
        r0 = "";
        r1 = "//";
        r4 = "/";
        r0 = r0.replaceAll(r1, r4);
        r1 = "?";
        r1 = r0.contains(r1);
        if (r1 == 0) goto L_0x0073;
    L_0x0037:
        r1 = "?";
        r1 = r0.indexOf(r1);
        r1 = r1 + 1;
        r1 = r0.substring(r1);
        r4 = "?";
        r4 = r0.indexOf(r4);
        r0 = r0.substring(r2, r4);
        r4 = "[;&]";
        r4 = r1.split(r4);
        r5 = r4.length;
        r1 = r2;
    L_0x0055:
        if (r1 >= r5) goto L_0x0073;
    L_0x0057:
        r6 = r4[r1];
        r7 = "=";
        r7 = r6.split(r7);
        r8 = r7.length;
        r9 = 2;
        if (r8 != r9) goto L_0x006e;
    L_0x0063:
        r6 = r7[r2];
        r8 = 1;
        r7 = r7[r8];
        r3.addParameter(r6, r7);
    L_0x006b:
        r1 = r1 + 1;
        goto L_0x0055;
    L_0x006e:
        r7 = 0;
        r3.addParameter(r6, r7);
        goto L_0x006b;
    L_0x0073:
        r3.setResourcePath(r0);
        r2 = new java.io.StringWriter;	 Catch:{ Throwable -> 0x00c0 }
        r2.<init>();	 Catch:{ Throwable -> 0x00c0 }
        r4 = new com.amazonaws.util.json.JSONWriter;	 Catch:{ Throwable -> 0x00c0 }
        r4.<init>(r2);	 Catch:{ Throwable -> 0x00c0 }
        r4.object();	 Catch:{ Throwable -> 0x00c0 }
        r0 = r11.getTableName();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0096;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0089:
        r0 = "TableName";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r1 = r11.getTableName();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r1);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0096:
        r0 = r11.getAttributesToGet();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x00e1;	 Catch:{ Throwable -> 0x00c0 }
    L_0x009c:
        r1 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 <= 0) goto L_0x00e1;	 Catch:{ Throwable -> 0x00c0 }
    L_0x00a2:
        r1 = "AttributesToGet";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r1);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r1 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x00ae:
        r0 = r1.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x00de;	 Catch:{ Throwable -> 0x00c0 }
    L_0x00b4:
        r0 = r1.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x00ae;	 Catch:{ Throwable -> 0x00c0 }
    L_0x00bc:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x00ae;
    L_0x00c0:
        r0 = move-exception;
        r1 = new com.amazonaws.AmazonClientException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Unable to marshall request to JSON: ";
        r2 = r2.append(r3);
        r3 = r0.getMessage();
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x00de:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x00e1:
        r0 = r11.getLimit();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x00f4;	 Catch:{ Throwable -> 0x00c0 }
    L_0x00e7:
        r0 = "Limit";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r1 = r11.getLimit();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r1);	 Catch:{ Throwable -> 0x00c0 }
    L_0x00f4:
        r0 = r11.isConsistentRead();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0107;	 Catch:{ Throwable -> 0x00c0 }
    L_0x00fa:
        r0 = "ConsistentRead";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r1 = r11.isConsistentRead();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r1);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0107:
        r0 = r11.isCount();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x011a;	 Catch:{ Throwable -> 0x00c0 }
    L_0x010d:
        r0 = "Count";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r1 = r11.isCount();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r1);	 Catch:{ Throwable -> 0x00c0 }
    L_0x011a:
        r1 = r11.getHashKeyValue();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x01eb;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0120:
        r0 = "HashKeyValue";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r4.object();	 Catch:{ Throwable -> 0x00c0 }
        r0 = r1.getS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x013b;	 Catch:{ Throwable -> 0x00c0 }
    L_0x012e:
        r0 = "S";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r5 = r1.getS();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r5);	 Catch:{ Throwable -> 0x00c0 }
    L_0x013b:
        r0 = r1.getN();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x014e;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0141:
        r0 = "N";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r5 = r1.getN();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r5);	 Catch:{ Throwable -> 0x00c0 }
    L_0x014e:
        r0 = r1.getB();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0161;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0154:
        r0 = "B";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r5 = r1.getB();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r5);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0161:
        r0 = r1.getSS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x018e;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0167:
        r5 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r5 <= 0) goto L_0x018e;	 Catch:{ Throwable -> 0x00c0 }
    L_0x016d:
        r5 = "SS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r5);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r5 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x0179:
        r0 = r5.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x018b;	 Catch:{ Throwable -> 0x00c0 }
    L_0x017f:
        r0 = r5.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0179;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0187:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x0179;	 Catch:{ Throwable -> 0x00c0 }
    L_0x018b:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x018e:
        r0 = r1.getNS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x01bb;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0194:
        r5 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r5 <= 0) goto L_0x01bb;	 Catch:{ Throwable -> 0x00c0 }
    L_0x019a:
        r5 = "NS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r5);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r5 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x01a6:
        r0 = r5.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x01b8;	 Catch:{ Throwable -> 0x00c0 }
    L_0x01ac:
        r0 = r5.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x01a6;	 Catch:{ Throwable -> 0x00c0 }
    L_0x01b4:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x01a6;	 Catch:{ Throwable -> 0x00c0 }
    L_0x01b8:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x01bb:
        r0 = r1.getBS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x01e8;	 Catch:{ Throwable -> 0x00c0 }
    L_0x01c1:
        r1 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 <= 0) goto L_0x01e8;	 Catch:{ Throwable -> 0x00c0 }
    L_0x01c7:
        r1 = "BS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r1);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r1 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x01d3:
        r0 = r1.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x01e5;	 Catch:{ Throwable -> 0x00c0 }
    L_0x01d9:
        r0 = r1.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.nio.ByteBuffer) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x01d3;	 Catch:{ Throwable -> 0x00c0 }
    L_0x01e1:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x01d3;	 Catch:{ Throwable -> 0x00c0 }
    L_0x01e5:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x01e8:
        r4.endObject();	 Catch:{ Throwable -> 0x00c0 }
    L_0x01eb:
        r5 = r11.getRangeKeyCondition();	 Catch:{ Throwable -> 0x00c0 }
        if (r5 == 0) goto L_0x0300;	 Catch:{ Throwable -> 0x00c0 }
    L_0x01f1:
        r0 = "RangeKeyCondition";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r4.object();	 Catch:{ Throwable -> 0x00c0 }
        r0 = r5.getAttributeValueList();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x02ea;	 Catch:{ Throwable -> 0x00c0 }
    L_0x01ff:
        r1 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 <= 0) goto L_0x02ea;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0205:
        r1 = "AttributeValueList";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r1);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r6 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x0211:
        r0 = r6.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x02e7;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0217:
        r0 = r6.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (com.amazonaws.services.dynamodb.model.AttributeValue) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0211;	 Catch:{ Throwable -> 0x00c0 }
    L_0x021f:
        r4.object();	 Catch:{ Throwable -> 0x00c0 }
        r1 = r0.getS();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x0235;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0228:
        r1 = "S";	 Catch:{ Throwable -> 0x00c0 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x00c0 }
        r7 = r0.getS();	 Catch:{ Throwable -> 0x00c0 }
        r1.value(r7);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0235:
        r1 = r0.getN();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x0248;	 Catch:{ Throwable -> 0x00c0 }
    L_0x023b:
        r1 = "N";	 Catch:{ Throwable -> 0x00c0 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x00c0 }
        r7 = r0.getN();	 Catch:{ Throwable -> 0x00c0 }
        r1.value(r7);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0248:
        r1 = r0.getB();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x025b;	 Catch:{ Throwable -> 0x00c0 }
    L_0x024e:
        r1 = "B";	 Catch:{ Throwable -> 0x00c0 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x00c0 }
        r7 = r0.getB();	 Catch:{ Throwable -> 0x00c0 }
        r1.value(r7);	 Catch:{ Throwable -> 0x00c0 }
    L_0x025b:
        r1 = r0.getSS();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x0288;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0261:
        r7 = r1.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r7 <= 0) goto L_0x0288;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0267:
        r7 = "SS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r7);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r7 = r1.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x0273:
        r1 = r7.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x0285;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0279:
        r1 = r7.next();	 Catch:{ Throwable -> 0x00c0 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x0273;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0281:
        r4.value(r1);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x0273;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0285:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x0288:
        r1 = r0.getNS();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x02b5;	 Catch:{ Throwable -> 0x00c0 }
    L_0x028e:
        r7 = r1.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r7 <= 0) goto L_0x02b5;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0294:
        r7 = "NS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r7);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r7 = r1.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x02a0:
        r1 = r7.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x02b2;	 Catch:{ Throwable -> 0x00c0 }
    L_0x02a6:
        r1 = r7.next();	 Catch:{ Throwable -> 0x00c0 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x02a0;	 Catch:{ Throwable -> 0x00c0 }
    L_0x02ae:
        r4.value(r1);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x02a0;	 Catch:{ Throwable -> 0x00c0 }
    L_0x02b2:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x02b5:
        r0 = r0.getBS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x02e2;	 Catch:{ Throwable -> 0x00c0 }
    L_0x02bb:
        r1 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 <= 0) goto L_0x02e2;	 Catch:{ Throwable -> 0x00c0 }
    L_0x02c1:
        r1 = "BS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r1);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r1 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x02cd:
        r0 = r1.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x02df;	 Catch:{ Throwable -> 0x00c0 }
    L_0x02d3:
        r0 = r1.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.nio.ByteBuffer) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x02cd;	 Catch:{ Throwable -> 0x00c0 }
    L_0x02db:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x02cd;	 Catch:{ Throwable -> 0x00c0 }
    L_0x02df:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x02e2:
        r4.endObject();	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x0211;	 Catch:{ Throwable -> 0x00c0 }
    L_0x02e7:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x02ea:
        r0 = r5.getComparisonOperator();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x02fd;	 Catch:{ Throwable -> 0x00c0 }
    L_0x02f0:
        r0 = "ComparisonOperator";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r1 = r5.getComparisonOperator();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r1);	 Catch:{ Throwable -> 0x00c0 }
    L_0x02fd:
        r4.endObject();	 Catch:{ Throwable -> 0x00c0 }
    L_0x0300:
        r0 = r11.isScanIndexForward();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0313;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0306:
        r0 = "ScanIndexForward";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r1 = r11.isScanIndexForward();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r1);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0313:
        r1 = r11.getExclusiveStartKey();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x04c6;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0319:
        r0 = "ExclusiveStartKey";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r4.object();	 Catch:{ Throwable -> 0x00c0 }
        r5 = r1.getHashKeyElement();	 Catch:{ Throwable -> 0x00c0 }
        if (r5 == 0) goto L_0x03f2;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0327:
        r0 = "HashKeyElement";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r4.object();	 Catch:{ Throwable -> 0x00c0 }
        r0 = r5.getS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0342;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0335:
        r0 = "S";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r6 = r5.getS();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r6);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0342:
        r0 = r5.getN();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0355;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0348:
        r0 = "N";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r6 = r5.getN();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r6);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0355:
        r0 = r5.getB();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0368;	 Catch:{ Throwable -> 0x00c0 }
    L_0x035b:
        r0 = "B";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r6 = r5.getB();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r6);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0368:
        r0 = r5.getSS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0395;	 Catch:{ Throwable -> 0x00c0 }
    L_0x036e:
        r6 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r6 <= 0) goto L_0x0395;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0374:
        r6 = "SS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r6);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r6 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x0380:
        r0 = r6.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0392;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0386:
        r0 = r6.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0380;	 Catch:{ Throwable -> 0x00c0 }
    L_0x038e:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x0380;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0392:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x0395:
        r0 = r5.getNS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x03c2;	 Catch:{ Throwable -> 0x00c0 }
    L_0x039b:
        r6 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r6 <= 0) goto L_0x03c2;	 Catch:{ Throwable -> 0x00c0 }
    L_0x03a1:
        r6 = "NS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r6);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r6 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x03ad:
        r0 = r6.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x03bf;	 Catch:{ Throwable -> 0x00c0 }
    L_0x03b3:
        r0 = r6.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x03ad;	 Catch:{ Throwable -> 0x00c0 }
    L_0x03bb:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x03ad;	 Catch:{ Throwable -> 0x00c0 }
    L_0x03bf:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x03c2:
        r0 = r5.getBS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x03ef;	 Catch:{ Throwable -> 0x00c0 }
    L_0x03c8:
        r5 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r5 <= 0) goto L_0x03ef;	 Catch:{ Throwable -> 0x00c0 }
    L_0x03ce:
        r5 = "BS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r5);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r5 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x03da:
        r0 = r5.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x03ec;	 Catch:{ Throwable -> 0x00c0 }
    L_0x03e0:
        r0 = r5.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.nio.ByteBuffer) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x03da;	 Catch:{ Throwable -> 0x00c0 }
    L_0x03e8:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x03da;	 Catch:{ Throwable -> 0x00c0 }
    L_0x03ec:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x03ef:
        r4.endObject();	 Catch:{ Throwable -> 0x00c0 }
    L_0x03f2:
        r1 = r1.getRangeKeyElement();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 == 0) goto L_0x04c3;	 Catch:{ Throwable -> 0x00c0 }
    L_0x03f8:
        r0 = "RangeKeyElement";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r4.object();	 Catch:{ Throwable -> 0x00c0 }
        r0 = r1.getS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0413;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0406:
        r0 = "S";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r5 = r1.getS();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r5);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0413:
        r0 = r1.getN();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0426;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0419:
        r0 = "N";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r5 = r1.getN();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r5);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0426:
        r0 = r1.getB();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0439;	 Catch:{ Throwable -> 0x00c0 }
    L_0x042c:
        r0 = "B";	 Catch:{ Throwable -> 0x00c0 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x00c0 }
        r5 = r1.getB();	 Catch:{ Throwable -> 0x00c0 }
        r0.value(r5);	 Catch:{ Throwable -> 0x00c0 }
    L_0x0439:
        r0 = r1.getSS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0466;	 Catch:{ Throwable -> 0x00c0 }
    L_0x043f:
        r5 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r5 <= 0) goto L_0x0466;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0445:
        r5 = "SS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r5);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r5 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x0451:
        r0 = r5.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0463;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0457:
        r0 = r5.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0451;	 Catch:{ Throwable -> 0x00c0 }
    L_0x045f:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x0451;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0463:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x0466:
        r0 = r1.getNS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0493;	 Catch:{ Throwable -> 0x00c0 }
    L_0x046c:
        r5 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r5 <= 0) goto L_0x0493;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0472:
        r5 = "NS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r5);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r5 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x047e:
        r0 = r5.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x0490;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0484:
        r0 = r5.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x047e;	 Catch:{ Throwable -> 0x00c0 }
    L_0x048c:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x047e;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0490:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x0493:
        r0 = r1.getBS();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x04c0;	 Catch:{ Throwable -> 0x00c0 }
    L_0x0499:
        r1 = r0.size();	 Catch:{ Throwable -> 0x00c0 }
        if (r1 <= 0) goto L_0x04c0;	 Catch:{ Throwable -> 0x00c0 }
    L_0x049f:
        r1 = "BS";	 Catch:{ Throwable -> 0x00c0 }
        r4.key(r1);	 Catch:{ Throwable -> 0x00c0 }
        r4.array();	 Catch:{ Throwable -> 0x00c0 }
        r1 = r0.iterator();	 Catch:{ Throwable -> 0x00c0 }
    L_0x04ab:
        r0 = r1.hasNext();	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x04bd;	 Catch:{ Throwable -> 0x00c0 }
    L_0x04b1:
        r0 = r1.next();	 Catch:{ Throwable -> 0x00c0 }
        r0 = (java.nio.ByteBuffer) r0;	 Catch:{ Throwable -> 0x00c0 }
        if (r0 == 0) goto L_0x04ab;	 Catch:{ Throwable -> 0x00c0 }
    L_0x04b9:
        r4.value(r0);	 Catch:{ Throwable -> 0x00c0 }
        goto L_0x04ab;	 Catch:{ Throwable -> 0x00c0 }
    L_0x04bd:
        r4.endArray();	 Catch:{ Throwable -> 0x00c0 }
    L_0x04c0:
        r4.endObject();	 Catch:{ Throwable -> 0x00c0 }
    L_0x04c3:
        r4.endObject();	 Catch:{ Throwable -> 0x00c0 }
    L_0x04c6:
        r4.endObject();	 Catch:{ Throwable -> 0x00c0 }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x00c0 }
        r1 = "UTF-8";	 Catch:{ Throwable -> 0x00c0 }
        r1 = r0.getBytes(r1);	 Catch:{ Throwable -> 0x00c0 }
        r2 = new com.amazonaws.util.StringInputStream;	 Catch:{ Throwable -> 0x00c0 }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x00c0 }
        r3.setContent(r2);	 Catch:{ Throwable -> 0x00c0 }
        r0 = "Content-Length";	 Catch:{ Throwable -> 0x00c0 }
        r1 = r1.length;	 Catch:{ Throwable -> 0x00c0 }
        r1 = java.lang.Integer.toString(r1);	 Catch:{ Throwable -> 0x00c0 }
        r3.addHeader(r0, r1);	 Catch:{ Throwable -> 0x00c0 }
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodb.model.transform.QueryRequestMarshaller.marshall(com.amazonaws.services.dynamodb.model.QueryRequest):com.amazonaws.Request<com.amazonaws.services.dynamodb.model.QueryRequest>");
    }
}
