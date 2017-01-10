package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SendMessageBatchResultStaxUnmarshaller implements Unmarshaller<SendMessageBatchResult, StaxUnmarshallerContext> {
    private static SendMessageBatchResultStaxUnmarshaller instance;

    public static SendMessageBatchResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SendMessageBatchResultStaxUnmarshaller();
        }
        return instance;
    }

    public SendMessageBatchResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SendMessageBatchResult sendMessageBatchResult = new SendMessageBatchResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return sendMessageBatchResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("SendMessageBatchResultEntry", i)) {
                    sendMessageBatchResult.getSuccessful().add(SendMessageBatchResultEntryStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("BatchResultErrorEntry", i)) {
                    sendMessageBatchResult.getFailed().add(BatchResultErrorEntryStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return sendMessageBatchResult;
            }
        }
    }
}
