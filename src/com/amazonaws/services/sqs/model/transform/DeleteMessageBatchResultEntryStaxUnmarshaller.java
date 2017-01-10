package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResultEntry;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DeleteMessageBatchResultEntryStaxUnmarshaller implements Unmarshaller<DeleteMessageBatchResultEntry, StaxUnmarshallerContext> {
    private static DeleteMessageBatchResultEntryStaxUnmarshaller instance;

    public static DeleteMessageBatchResultEntryStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteMessageBatchResultEntryStaxUnmarshaller();
        }
        return instance;
    }

    public DeleteMessageBatchResultEntry unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DeleteMessageBatchResultEntry deleteMessageBatchResultEntry = new DeleteMessageBatchResultEntry();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return deleteMessageBatchResultEntry;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Id", i)) {
                    deleteMessageBatchResultEntry.setId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return deleteMessageBatchResultEntry;
            }
        }
    }
}
