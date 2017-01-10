package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ReceiveMessageResultStaxUnmarshaller implements Unmarshaller<ReceiveMessageResult, StaxUnmarshallerContext> {
    private static ReceiveMessageResultStaxUnmarshaller instance;

    public static ReceiveMessageResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ReceiveMessageResultStaxUnmarshaller();
        }
        return instance;
    }

    public ReceiveMessageResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ReceiveMessageResult receiveMessageResult = new ReceiveMessageResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return receiveMessageResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Message", i)) {
                    receiveMessageResult.getMessages().add(MessageStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return receiveMessageResult;
            }
        }
    }
}
