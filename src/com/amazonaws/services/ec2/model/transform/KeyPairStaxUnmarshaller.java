package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.KeyPair;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class KeyPairStaxUnmarshaller implements Unmarshaller<KeyPair, StaxUnmarshallerContext> {
    private static KeyPairStaxUnmarshaller instance;

    public static KeyPairStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new KeyPairStaxUnmarshaller();
        }
        return instance;
    }

    public KeyPair unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        KeyPair keyPair = new KeyPair();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return keyPair;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("keyName", i)) {
                    keyPair.setKeyName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("keyFingerprint", i)) {
                    keyPair.setKeyFingerprint(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("keyMaterial", i)) {
                    keyPair.setKeyMaterial(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return keyPair;
            }
        }
    }
}
