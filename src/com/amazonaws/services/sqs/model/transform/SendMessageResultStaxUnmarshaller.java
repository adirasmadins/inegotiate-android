package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.SendMessageResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SendMessageResultStaxUnmarshaller implements Unmarshaller<SendMessageResult, StaxUnmarshallerContext> {
    private static SendMessageResultStaxUnmarshaller instance;

    public static SendMessageResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SendMessageResultStaxUnmarshaller();
        }
        return instance;
    }

    public SendMessageResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SendMessageResult sendMessageResult = new SendMessageResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return sendMessageResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("MD5OfMessageBody", i)) {
                    sendMessageResult.setMD5OfMessageBody(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MessageId", i)) {
                    sendMessageResult.setMessageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return sendMessageResult;
            }
        }
    }
}
