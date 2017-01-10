package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DeleteMessageBatchResultStaxUnmarshaller implements Unmarshaller<DeleteMessageBatchResult, StaxUnmarshallerContext> {
    private static DeleteMessageBatchResultStaxUnmarshaller instance;

    public static DeleteMessageBatchResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteMessageBatchResultStaxUnmarshaller();
        }
        return instance;
    }

    public DeleteMessageBatchResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DeleteMessageBatchResult deleteMessageBatchResult = new DeleteMessageBatchResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return deleteMessageBatchResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("DeleteMessageBatchResultEntry", i)) {
                    deleteMessageBatchResult.getSuccessful().add(DeleteMessageBatchResultEntryStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("BatchResultErrorEntry", i)) {
                    deleteMessageBatchResult.getFailed().add(BatchResultErrorEntryStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return deleteMessageBatchResult;
            }
        }
    }
}
