package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CreateKeyPairResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateKeyPairResultStaxUnmarshaller implements Unmarshaller<CreateKeyPairResult, StaxUnmarshallerContext> {
    private static CreateKeyPairResultStaxUnmarshaller instance;

    public static CreateKeyPairResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateKeyPairResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateKeyPairResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateKeyPairResult createKeyPairResult = new CreateKeyPairResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createKeyPairResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(".", i)) {
                    createKeyPairResult.setKeyPair(KeyPairStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createKeyPairResult;
            }
        }
    }
}
