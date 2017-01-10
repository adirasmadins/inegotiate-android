package com.amazonaws.services.dynamodb.model.transform;

import com.amazonaws.Request;
import com.amazonaws.services.dynamodb.model.UpdateItemRequest;
import com.amazonaws.transform.Marshaller;
import com.google.gdata.util.common.base.StringUtil;

public class UpdateItemRequestMarshaller implements Marshaller<Request<UpdateItemRequest>, UpdateItemRequest> {
    private String getString(String str) {
        return str == null ? StringUtil.EMPTY_STRING : str;
    }

    public com.amazonaws.Request<com.amazonaws.services.dynamodb.model.UpdateItemRequest> marshall(com.amazonaws.services.dynamodb.model.UpdateItemRequest r11) {
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
        r0 = "DynamoDB_20111205.UpdateItem";
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
        r2 = new java.io.StringWriter;	 Catch:{ Throwable -> 0x0115 }
        r2.<init>();	 Catch:{ Throwable -> 0x0115 }
        r4 = new com.amazonaws.util.json.JSONWriter;	 Catch:{ Throwable -> 0x0115 }
        r4.<init>(r2);	 Catch:{ Throwable -> 0x0115 }
        r4.object();	 Catch:{ Throwable -> 0x0115 }
        r0 = r11.getTableName();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0096;	 Catch:{ Throwable -> 0x0115 }
    L_0x0089:
        r0 = "TableName";	 Catch:{ Throwable -> 0x0115 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r1 = r11.getTableName();	 Catch:{ Throwable -> 0x0115 }
        r0.value(r1);	 Catch:{ Throwable -> 0x0115 }
    L_0x0096:
        r1 = r11.getKey();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0267;	 Catch:{ Throwable -> 0x0115 }
    L_0x009c:
        r0 = "Key";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r4.object();	 Catch:{ Throwable -> 0x0115 }
        r5 = r1.getHashKeyElement();	 Catch:{ Throwable -> 0x0115 }
        if (r5 == 0) goto L_0x0193;	 Catch:{ Throwable -> 0x0115 }
    L_0x00aa:
        r0 = "HashKeyElement";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r4.object();	 Catch:{ Throwable -> 0x0115 }
        r0 = r5.getS();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x00c5;	 Catch:{ Throwable -> 0x0115 }
    L_0x00b8:
        r0 = "S";	 Catch:{ Throwable -> 0x0115 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r6 = r5.getS();	 Catch:{ Throwable -> 0x0115 }
        r0.value(r6);	 Catch:{ Throwable -> 0x0115 }
    L_0x00c5:
        r0 = r5.getN();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x00d8;	 Catch:{ Throwable -> 0x0115 }
    L_0x00cb:
        r0 = "N";	 Catch:{ Throwable -> 0x0115 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r6 = r5.getN();	 Catch:{ Throwable -> 0x0115 }
        r0.value(r6);	 Catch:{ Throwable -> 0x0115 }
    L_0x00d8:
        r0 = r5.getB();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x00eb;	 Catch:{ Throwable -> 0x0115 }
    L_0x00de:
        r0 = "B";	 Catch:{ Throwable -> 0x0115 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r6 = r5.getB();	 Catch:{ Throwable -> 0x0115 }
        r0.value(r6);	 Catch:{ Throwable -> 0x0115 }
    L_0x00eb:
        r0 = r5.getSS();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0136;	 Catch:{ Throwable -> 0x0115 }
    L_0x00f1:
        r6 = r0.size();	 Catch:{ Throwable -> 0x0115 }
        if (r6 <= 0) goto L_0x0136;	 Catch:{ Throwable -> 0x0115 }
    L_0x00f7:
        r6 = "SS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r6);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r6 = r0.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x0103:
        r0 = r6.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0133;	 Catch:{ Throwable -> 0x0115 }
    L_0x0109:
        r0 = r6.next();	 Catch:{ Throwable -> 0x0115 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0103;	 Catch:{ Throwable -> 0x0115 }
    L_0x0111:
        r4.value(r0);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x0103;
    L_0x0115:
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
    L_0x0133:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x0136:
        r0 = r5.getNS();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0163;	 Catch:{ Throwable -> 0x0115 }
    L_0x013c:
        r6 = r0.size();	 Catch:{ Throwable -> 0x0115 }
        if (r6 <= 0) goto L_0x0163;	 Catch:{ Throwable -> 0x0115 }
    L_0x0142:
        r6 = "NS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r6);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r6 = r0.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x014e:
        r0 = r6.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0160;	 Catch:{ Throwable -> 0x0115 }
    L_0x0154:
        r0 = r6.next();	 Catch:{ Throwable -> 0x0115 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x014e;	 Catch:{ Throwable -> 0x0115 }
    L_0x015c:
        r4.value(r0);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x014e;	 Catch:{ Throwable -> 0x0115 }
    L_0x0160:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x0163:
        r0 = r5.getBS();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0190;	 Catch:{ Throwable -> 0x0115 }
    L_0x0169:
        r5 = r0.size();	 Catch:{ Throwable -> 0x0115 }
        if (r5 <= 0) goto L_0x0190;	 Catch:{ Throwable -> 0x0115 }
    L_0x016f:
        r5 = "BS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r5);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r5 = r0.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x017b:
        r0 = r5.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x018d;	 Catch:{ Throwable -> 0x0115 }
    L_0x0181:
        r0 = r5.next();	 Catch:{ Throwable -> 0x0115 }
        r0 = (java.nio.ByteBuffer) r0;	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x017b;	 Catch:{ Throwable -> 0x0115 }
    L_0x0189:
        r4.value(r0);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x017b;	 Catch:{ Throwable -> 0x0115 }
    L_0x018d:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x0190:
        r4.endObject();	 Catch:{ Throwable -> 0x0115 }
    L_0x0193:
        r1 = r1.getRangeKeyElement();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0264;	 Catch:{ Throwable -> 0x0115 }
    L_0x0199:
        r0 = "RangeKeyElement";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r4.object();	 Catch:{ Throwable -> 0x0115 }
        r0 = r1.getS();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x01b4;	 Catch:{ Throwable -> 0x0115 }
    L_0x01a7:
        r0 = "S";	 Catch:{ Throwable -> 0x0115 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r5 = r1.getS();	 Catch:{ Throwable -> 0x0115 }
        r0.value(r5);	 Catch:{ Throwable -> 0x0115 }
    L_0x01b4:
        r0 = r1.getN();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x01c7;	 Catch:{ Throwable -> 0x0115 }
    L_0x01ba:
        r0 = "N";	 Catch:{ Throwable -> 0x0115 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r5 = r1.getN();	 Catch:{ Throwable -> 0x0115 }
        r0.value(r5);	 Catch:{ Throwable -> 0x0115 }
    L_0x01c7:
        r0 = r1.getB();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x01da;	 Catch:{ Throwable -> 0x0115 }
    L_0x01cd:
        r0 = "B";	 Catch:{ Throwable -> 0x0115 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r5 = r1.getB();	 Catch:{ Throwable -> 0x0115 }
        r0.value(r5);	 Catch:{ Throwable -> 0x0115 }
    L_0x01da:
        r0 = r1.getSS();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0207;	 Catch:{ Throwable -> 0x0115 }
    L_0x01e0:
        r5 = r0.size();	 Catch:{ Throwable -> 0x0115 }
        if (r5 <= 0) goto L_0x0207;	 Catch:{ Throwable -> 0x0115 }
    L_0x01e6:
        r5 = "SS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r5);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r5 = r0.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x01f2:
        r0 = r5.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0204;	 Catch:{ Throwable -> 0x0115 }
    L_0x01f8:
        r0 = r5.next();	 Catch:{ Throwable -> 0x0115 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x01f2;	 Catch:{ Throwable -> 0x0115 }
    L_0x0200:
        r4.value(r0);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x01f2;	 Catch:{ Throwable -> 0x0115 }
    L_0x0204:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x0207:
        r0 = r1.getNS();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0234;	 Catch:{ Throwable -> 0x0115 }
    L_0x020d:
        r5 = r0.size();	 Catch:{ Throwable -> 0x0115 }
        if (r5 <= 0) goto L_0x0234;	 Catch:{ Throwable -> 0x0115 }
    L_0x0213:
        r5 = "NS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r5);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r5 = r0.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x021f:
        r0 = r5.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0231;	 Catch:{ Throwable -> 0x0115 }
    L_0x0225:
        r0 = r5.next();	 Catch:{ Throwable -> 0x0115 }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x021f;	 Catch:{ Throwable -> 0x0115 }
    L_0x022d:
        r4.value(r0);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x021f;	 Catch:{ Throwable -> 0x0115 }
    L_0x0231:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x0234:
        r0 = r1.getBS();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x0261;	 Catch:{ Throwable -> 0x0115 }
    L_0x023a:
        r1 = r0.size();	 Catch:{ Throwable -> 0x0115 }
        if (r1 <= 0) goto L_0x0261;	 Catch:{ Throwable -> 0x0115 }
    L_0x0240:
        r1 = "BS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r1 = r0.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x024c:
        r0 = r1.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x025e;	 Catch:{ Throwable -> 0x0115 }
    L_0x0252:
        r0 = r1.next();	 Catch:{ Throwable -> 0x0115 }
        r0 = (java.nio.ByteBuffer) r0;	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x024c;	 Catch:{ Throwable -> 0x0115 }
    L_0x025a:
        r4.value(r0);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x024c;	 Catch:{ Throwable -> 0x0115 }
    L_0x025e:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x0261:
        r4.endObject();	 Catch:{ Throwable -> 0x0115 }
    L_0x0264:
        r4.endObject();	 Catch:{ Throwable -> 0x0115 }
    L_0x0267:
        r0 = r11.getAttributeUpdates();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x039d;	 Catch:{ Throwable -> 0x0115 }
    L_0x026d:
        r0 = "AttributeUpdates";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r4.object();	 Catch:{ Throwable -> 0x0115 }
        r0 = r11.getAttributeUpdates();	 Catch:{ Throwable -> 0x0115 }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x0115 }
        r5 = r0.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x0281:
        r0 = r5.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x039a;	 Catch:{ Throwable -> 0x0115 }
    L_0x0287:
        r0 = r5.next();	 Catch:{ Throwable -> 0x0115 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x0115 }
        r1 = r0.getValue();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0281;	 Catch:{ Throwable -> 0x0115 }
    L_0x0293:
        r1 = r0.getKey();	 Catch:{ Throwable -> 0x0115 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0115 }
        r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r4.object();	 Catch:{ Throwable -> 0x0115 }
        r1 = r0.getValue();	 Catch:{ Throwable -> 0x0115 }
        r1 = (com.amazonaws.services.dynamodb.model.AttributeValueUpdate) r1;	 Catch:{ Throwable -> 0x0115 }
        r6 = r1.getValue();	 Catch:{ Throwable -> 0x0115 }
        if (r6 == 0) goto L_0x0376;	 Catch:{ Throwable -> 0x0115 }
    L_0x02ab:
        r1 = "Value";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r4.object();	 Catch:{ Throwable -> 0x0115 }
        r1 = r6.getS();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x02c6;	 Catch:{ Throwable -> 0x0115 }
    L_0x02b9:
        r1 = "S";	 Catch:{ Throwable -> 0x0115 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r7 = r6.getS();	 Catch:{ Throwable -> 0x0115 }
        r1.value(r7);	 Catch:{ Throwable -> 0x0115 }
    L_0x02c6:
        r1 = r6.getN();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x02d9;	 Catch:{ Throwable -> 0x0115 }
    L_0x02cc:
        r1 = "N";	 Catch:{ Throwable -> 0x0115 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r7 = r6.getN();	 Catch:{ Throwable -> 0x0115 }
        r1.value(r7);	 Catch:{ Throwable -> 0x0115 }
    L_0x02d9:
        r1 = r6.getB();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x02ec;	 Catch:{ Throwable -> 0x0115 }
    L_0x02df:
        r1 = "B";	 Catch:{ Throwable -> 0x0115 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r7 = r6.getB();	 Catch:{ Throwable -> 0x0115 }
        r1.value(r7);	 Catch:{ Throwable -> 0x0115 }
    L_0x02ec:
        r1 = r6.getSS();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0319;	 Catch:{ Throwable -> 0x0115 }
    L_0x02f2:
        r7 = r1.size();	 Catch:{ Throwable -> 0x0115 }
        if (r7 <= 0) goto L_0x0319;	 Catch:{ Throwable -> 0x0115 }
    L_0x02f8:
        r7 = "SS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r7);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r7 = r1.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x0304:
        r1 = r7.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0316;	 Catch:{ Throwable -> 0x0115 }
    L_0x030a:
        r1 = r7.next();	 Catch:{ Throwable -> 0x0115 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0304;	 Catch:{ Throwable -> 0x0115 }
    L_0x0312:
        r4.value(r1);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x0304;	 Catch:{ Throwable -> 0x0115 }
    L_0x0316:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x0319:
        r1 = r6.getNS();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0346;	 Catch:{ Throwable -> 0x0115 }
    L_0x031f:
        r7 = r1.size();	 Catch:{ Throwable -> 0x0115 }
        if (r7 <= 0) goto L_0x0346;	 Catch:{ Throwable -> 0x0115 }
    L_0x0325:
        r7 = "NS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r7);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r7 = r1.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x0331:
        r1 = r7.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0343;	 Catch:{ Throwable -> 0x0115 }
    L_0x0337:
        r1 = r7.next();	 Catch:{ Throwable -> 0x0115 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0331;	 Catch:{ Throwable -> 0x0115 }
    L_0x033f:
        r4.value(r1);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x0331;	 Catch:{ Throwable -> 0x0115 }
    L_0x0343:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x0346:
        r1 = r6.getBS();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0373;	 Catch:{ Throwable -> 0x0115 }
    L_0x034c:
        r6 = r1.size();	 Catch:{ Throwable -> 0x0115 }
        if (r6 <= 0) goto L_0x0373;	 Catch:{ Throwable -> 0x0115 }
    L_0x0352:
        r6 = "BS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r6);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r6 = r1.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x035e:
        r1 = r6.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0370;	 Catch:{ Throwable -> 0x0115 }
    L_0x0364:
        r1 = r6.next();	 Catch:{ Throwable -> 0x0115 }
        r1 = (java.nio.ByteBuffer) r1;	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x035e;	 Catch:{ Throwable -> 0x0115 }
    L_0x036c:
        r4.value(r1);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x035e;	 Catch:{ Throwable -> 0x0115 }
    L_0x0370:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x0373:
        r4.endObject();	 Catch:{ Throwable -> 0x0115 }
    L_0x0376:
        r1 = r0.getValue();	 Catch:{ Throwable -> 0x0115 }
        r1 = (com.amazonaws.services.dynamodb.model.AttributeValueUpdate) r1;	 Catch:{ Throwable -> 0x0115 }
        r1 = r1.getAction();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0395;	 Catch:{ Throwable -> 0x0115 }
    L_0x0382:
        r1 = "Action";	 Catch:{ Throwable -> 0x0115 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r0 = r0.getValue();	 Catch:{ Throwable -> 0x0115 }
        r0 = (com.amazonaws.services.dynamodb.model.AttributeValueUpdate) r0;	 Catch:{ Throwable -> 0x0115 }
        r0 = r0.getAction();	 Catch:{ Throwable -> 0x0115 }
        r1.value(r0);	 Catch:{ Throwable -> 0x0115 }
    L_0x0395:
        r4.endObject();	 Catch:{ Throwable -> 0x0115 }
        goto L_0x0281;	 Catch:{ Throwable -> 0x0115 }
    L_0x039a:
        r4.endObject();	 Catch:{ Throwable -> 0x0115 }
    L_0x039d:
        r0 = r11.getExpected();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x04d3;	 Catch:{ Throwable -> 0x0115 }
    L_0x03a3:
        r0 = "Expected";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r4.object();	 Catch:{ Throwable -> 0x0115 }
        r0 = r11.getExpected();	 Catch:{ Throwable -> 0x0115 }
        r0 = r0.entrySet();	 Catch:{ Throwable -> 0x0115 }
        r5 = r0.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x03b7:
        r0 = r5.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x04d0;	 Catch:{ Throwable -> 0x0115 }
    L_0x03bd:
        r0 = r5.next();	 Catch:{ Throwable -> 0x0115 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Throwable -> 0x0115 }
        r1 = r0.getValue();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x03b7;	 Catch:{ Throwable -> 0x0115 }
    L_0x03c9:
        r1 = r0.getKey();	 Catch:{ Throwable -> 0x0115 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0115 }
        r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r4.object();	 Catch:{ Throwable -> 0x0115 }
        r1 = r0.getValue();	 Catch:{ Throwable -> 0x0115 }
        r1 = (com.amazonaws.services.dynamodb.model.ExpectedAttributeValue) r1;	 Catch:{ Throwable -> 0x0115 }
        r6 = r1.getValue();	 Catch:{ Throwable -> 0x0115 }
        if (r6 == 0) goto L_0x04ac;	 Catch:{ Throwable -> 0x0115 }
    L_0x03e1:
        r1 = "Value";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r4.object();	 Catch:{ Throwable -> 0x0115 }
        r1 = r6.getS();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x03fc;	 Catch:{ Throwable -> 0x0115 }
    L_0x03ef:
        r1 = "S";	 Catch:{ Throwable -> 0x0115 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r7 = r6.getS();	 Catch:{ Throwable -> 0x0115 }
        r1.value(r7);	 Catch:{ Throwable -> 0x0115 }
    L_0x03fc:
        r1 = r6.getN();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x040f;	 Catch:{ Throwable -> 0x0115 }
    L_0x0402:
        r1 = "N";	 Catch:{ Throwable -> 0x0115 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r7 = r6.getN();	 Catch:{ Throwable -> 0x0115 }
        r1.value(r7);	 Catch:{ Throwable -> 0x0115 }
    L_0x040f:
        r1 = r6.getB();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0422;	 Catch:{ Throwable -> 0x0115 }
    L_0x0415:
        r1 = "B";	 Catch:{ Throwable -> 0x0115 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r7 = r6.getB();	 Catch:{ Throwable -> 0x0115 }
        r1.value(r7);	 Catch:{ Throwable -> 0x0115 }
    L_0x0422:
        r1 = r6.getSS();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x044f;	 Catch:{ Throwable -> 0x0115 }
    L_0x0428:
        r7 = r1.size();	 Catch:{ Throwable -> 0x0115 }
        if (r7 <= 0) goto L_0x044f;	 Catch:{ Throwable -> 0x0115 }
    L_0x042e:
        r7 = "SS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r7);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r7 = r1.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x043a:
        r1 = r7.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x044c;	 Catch:{ Throwable -> 0x0115 }
    L_0x0440:
        r1 = r7.next();	 Catch:{ Throwable -> 0x0115 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x043a;	 Catch:{ Throwable -> 0x0115 }
    L_0x0448:
        r4.value(r1);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x043a;	 Catch:{ Throwable -> 0x0115 }
    L_0x044c:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x044f:
        r1 = r6.getNS();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x047c;	 Catch:{ Throwable -> 0x0115 }
    L_0x0455:
        r7 = r1.size();	 Catch:{ Throwable -> 0x0115 }
        if (r7 <= 0) goto L_0x047c;	 Catch:{ Throwable -> 0x0115 }
    L_0x045b:
        r7 = "NS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r7);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r7 = r1.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x0467:
        r1 = r7.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0479;	 Catch:{ Throwable -> 0x0115 }
    L_0x046d:
        r1 = r7.next();	 Catch:{ Throwable -> 0x0115 }
        r1 = (java.lang.String) r1;	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0467;	 Catch:{ Throwable -> 0x0115 }
    L_0x0475:
        r4.value(r1);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x0467;	 Catch:{ Throwable -> 0x0115 }
    L_0x0479:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x047c:
        r1 = r6.getBS();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x04a9;	 Catch:{ Throwable -> 0x0115 }
    L_0x0482:
        r6 = r1.size();	 Catch:{ Throwable -> 0x0115 }
        if (r6 <= 0) goto L_0x04a9;	 Catch:{ Throwable -> 0x0115 }
    L_0x0488:
        r6 = "BS";	 Catch:{ Throwable -> 0x0115 }
        r4.key(r6);	 Catch:{ Throwable -> 0x0115 }
        r4.array();	 Catch:{ Throwable -> 0x0115 }
        r6 = r1.iterator();	 Catch:{ Throwable -> 0x0115 }
    L_0x0494:
        r1 = r6.hasNext();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x04a6;	 Catch:{ Throwable -> 0x0115 }
    L_0x049a:
        r1 = r6.next();	 Catch:{ Throwable -> 0x0115 }
        r1 = (java.nio.ByteBuffer) r1;	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x0494;	 Catch:{ Throwable -> 0x0115 }
    L_0x04a2:
        r4.value(r1);	 Catch:{ Throwable -> 0x0115 }
        goto L_0x0494;	 Catch:{ Throwable -> 0x0115 }
    L_0x04a6:
        r4.endArray();	 Catch:{ Throwable -> 0x0115 }
    L_0x04a9:
        r4.endObject();	 Catch:{ Throwable -> 0x0115 }
    L_0x04ac:
        r1 = r0.getValue();	 Catch:{ Throwable -> 0x0115 }
        r1 = (com.amazonaws.services.dynamodb.model.ExpectedAttributeValue) r1;	 Catch:{ Throwable -> 0x0115 }
        r1 = r1.isExists();	 Catch:{ Throwable -> 0x0115 }
        if (r1 == 0) goto L_0x04cb;	 Catch:{ Throwable -> 0x0115 }
    L_0x04b8:
        r1 = "Exists";	 Catch:{ Throwable -> 0x0115 }
        r1 = r4.key(r1);	 Catch:{ Throwable -> 0x0115 }
        r0 = r0.getValue();	 Catch:{ Throwable -> 0x0115 }
        r0 = (com.amazonaws.services.dynamodb.model.ExpectedAttributeValue) r0;	 Catch:{ Throwable -> 0x0115 }
        r0 = r0.isExists();	 Catch:{ Throwable -> 0x0115 }
        r1.value(r0);	 Catch:{ Throwable -> 0x0115 }
    L_0x04cb:
        r4.endObject();	 Catch:{ Throwable -> 0x0115 }
        goto L_0x03b7;	 Catch:{ Throwable -> 0x0115 }
    L_0x04d0:
        r4.endObject();	 Catch:{ Throwable -> 0x0115 }
    L_0x04d3:
        r0 = r11.getReturnValues();	 Catch:{ Throwable -> 0x0115 }
        if (r0 == 0) goto L_0x04e6;	 Catch:{ Throwable -> 0x0115 }
    L_0x04d9:
        r0 = "ReturnValues";	 Catch:{ Throwable -> 0x0115 }
        r0 = r4.key(r0);	 Catch:{ Throwable -> 0x0115 }
        r1 = r11.getReturnValues();	 Catch:{ Throwable -> 0x0115 }
        r0.value(r1);	 Catch:{ Throwable -> 0x0115 }
    L_0x04e6:
        r4.endObject();	 Catch:{ Throwable -> 0x0115 }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x0115 }
        r1 = "UTF-8";	 Catch:{ Throwable -> 0x0115 }
        r1 = r0.getBytes(r1);	 Catch:{ Throwable -> 0x0115 }
        r2 = new com.amazonaws.util.StringInputStream;	 Catch:{ Throwable -> 0x0115 }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0115 }
        r3.setContent(r2);	 Catch:{ Throwable -> 0x0115 }
        r0 = "Content-Length";	 Catch:{ Throwable -> 0x0115 }
        r1 = r1.length;	 Catch:{ Throwable -> 0x0115 }
        r1 = java.lang.Integer.toString(r1);	 Catch:{ Throwable -> 0x0115 }
        r3.addHeader(r0, r1);	 Catch:{ Throwable -> 0x0115 }
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.services.dynamodb.model.transform.UpdateItemRequestMarshaller.marshall(com.amazonaws.services.dynamodb.model.UpdateItemRequest):com.amazonaws.Request<com.amazonaws.services.dynamodb.model.UpdateItemRequest>");
    }
}
