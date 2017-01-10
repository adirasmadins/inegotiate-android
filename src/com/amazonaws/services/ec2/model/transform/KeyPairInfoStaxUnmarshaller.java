package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.KeyPairInfo;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class KeyPairInfoStaxUnmarshaller implements Unmarshaller<KeyPairInfo, StaxUnmarshallerContext> {
    private static KeyPairInfoStaxUnmarshaller instance;

    public static KeyPairInfoStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new KeyPairInfoStaxUnmarshaller();
        }
        return instance;
    }

    public KeyPairInfo unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        KeyPairInfo keyPairInfo = new KeyPairInfo();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return keyPairInfo;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("keyName", i)) {
                    keyPairInfo.setKeyName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("keyFingerprint", i)) {
                    keyPairInfo.setKeyFingerprint(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return keyPairInfo;
            }
        }
    }
}
