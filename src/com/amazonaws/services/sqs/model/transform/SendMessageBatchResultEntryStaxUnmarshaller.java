package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.SendMessageBatchResultEntry;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SendMessageBatchResultEntryStaxUnmarshaller implements Unmarshaller<SendMessageBatchResultEntry, StaxUnmarshallerContext> {
    private static SendMessageBatchResultEntryStaxUnmarshaller instance;

    public static SendMessageBatchResultEntryStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SendMessageBatchResultEntryStaxUnmarshaller();
        }
        return instance;
    }

    public SendMessageBatchResultEntry unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SendMessageBatchResultEntry sendMessageBatchResultEntry = new SendMessageBatchResultEntry();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return sendMessageBatchResultEntry;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Id", i)) {
                    sendMessageBatchResultEntry.setId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MessageId", i)) {
                    sendMessageBatchResultEntry.setMessageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MD5OfMessageBody", i)) {
                    sendMessageBatchResultEntry.setMD5OfMessageBody(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return sendMessageBatchResultEntry;
            }
        }
    }
}
