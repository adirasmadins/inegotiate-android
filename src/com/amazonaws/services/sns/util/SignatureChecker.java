package com.amazonaws.services.sns.util;

import com.google.gdata.util.common.base.StringUtil;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;

public class SignatureChecker {
    private final String MESSAGE;
    private final String MESSAGE_ID;
    private final String NOTIFICATION_TYPE;
    private final String SIGNATURE;
    private final String SIGNATURE_VERSION;
    private final String SUBJECT;
    private final String SUBSCRIBE_TYPE;
    private final String SUBSCRIBE_URL;
    private final String TIMESTAMP;
    private final String TOKEN;
    private final String TOPIC;
    private final String TYPE;
    private final String UNSUBSCRIBE_TYPE;
    private Signature sigChecker;

    public SignatureChecker() {
        this.NOTIFICATION_TYPE = "Notification";
        this.SUBSCRIBE_TYPE = "SubscriptionConfirmation";
        this.UNSUBSCRIBE_TYPE = "UnsubscriptionConfirmation";
        this.TYPE = "Type";
        this.SUBSCRIBE_URL = "SubscribeURL";
        this.MESSAGE = "Message";
        this.TIMESTAMP = "Timestamp";
        this.SIGNATURE_VERSION = "SignatureVersion";
        this.SIGNATURE = "Signature";
        this.MESSAGE_ID = "MessageId";
        this.SUBJECT = "Subject";
        this.TOPIC = "TopicArn";
        this.TOKEN = "Token";
    }

    private Map<String, String> parseJSON(String str) {
        Map<String, String> hashMap = new HashMap();
        try {
            JsonParser createJsonParser = new JsonFactory().createJsonParser(str);
            createJsonParser.nextToken();
            while (createJsonParser.nextToken() != JsonToken.END_OBJECT) {
                String currentName = createJsonParser.getCurrentName();
                createJsonParser.nextToken();
                hashMap.put(currentName, createJsonParser.getText());
            }
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e2) {
        }
        return hashMap;
    }

    private TreeMap<String, String> publishMessageValues(Map<String, String> map) {
        int i = 0;
        TreeMap<String, String> treeMap = new TreeMap();
        String[] strArr = new String[]{"Message", "MessageId", "Subject", "Type", "Timestamp", "TopicArn"};
        int length = strArr.length;
        while (i < length) {
            Object obj = strArr[i];
            if (map.containsKey(obj)) {
                treeMap.put(obj, map.get(obj));
            }
            i++;
        }
        return treeMap;
    }

    private TreeMap<String, String> subscribeMessageValues(Map<String, String> map) {
        int i = 0;
        TreeMap<String, String> treeMap = new TreeMap();
        String[] strArr = new String[]{"SubscribeURL", "Message", "MessageId", "Type", "Timestamp", "Token", "TopicArn"};
        int length = strArr.length;
        while (i < length) {
            Object obj = strArr[i];
            if (map.containsKey(obj)) {
                treeMap.put(obj, map.get(obj));
            }
            i++;
        }
        return treeMap;
    }

    protected String stringToSign(SortedMap<String, String> sortedMap) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : sortedMap.keySet()) {
            stringBuilder.append(str).append("\n");
            stringBuilder.append((String) sortedMap.get(str)).append("\n");
        }
        return stringBuilder.toString();
    }

    public boolean verifyMessageSignature(String str, PublicKey publicKey) {
        Map parseJSON = parseJSON(str);
        if (!((String) parseJSON.get("SignatureVersion")).equals("1")) {
            return false;
        }
        String str2 = (String) parseJSON.get("Type");
        String str3 = (String) parseJSON.get("Signature");
        String str4 = StringUtil.EMPTY_STRING;
        if (str2.equals("Notification")) {
            str2 = stringToSign(publishMessageValues(parseJSON));
        } else if (str2.equals("SubscriptionConfirmation")) {
            str2 = stringToSign(subscribeMessageValues(parseJSON));
        } else if (str2.equals("UnsubscriptionConfirmation")) {
            str2 = stringToSign(subscribeMessageValues(parseJSON));
        } else {
            throw new RuntimeException("Cannot process message of type " + str2);
        }
        return verifySignature(str2, str3, publicKey);
    }

    public boolean verifySignature(String str, String str2, PublicKey publicKey) {
        boolean z = false;
        try {
            byte[] decodeBase64 = Base64.decodeBase64(str2.getBytes());
            this.sigChecker = Signature.getInstance("SHA1withRSA");
            this.sigChecker.initVerify(publicKey);
            this.sigChecker.update(str.getBytes());
            z = this.sigChecker.verify(decodeBase64);
        } catch (NoSuchAlgorithmException e) {
        } catch (InvalidKeyException e2) {
        } catch (SignatureException e3) {
        }
        return z;
    }
}
