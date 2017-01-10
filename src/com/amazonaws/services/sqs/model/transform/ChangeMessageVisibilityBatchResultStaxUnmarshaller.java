package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ChangeMessageVisibilityBatchResultStaxUnmarshaller implements Unmarshaller<ChangeMessageVisibilityBatchResult, StaxUnmarshallerContext> {
    private static ChangeMessageVisibilityBatchResultStaxUnmarshaller instance;

    public static ChangeMessageVisibilityBatchResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ChangeMessageVisibilityBatchResultStaxUnmarshaller();
        }
        return instance;
    }

    public ChangeMessageVisibilityBatchResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ChangeMessageVisibilityBatchResult changeMessageVisibilityBatchResult = new ChangeMessageVisibilityBatchResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return changeMessageVisibilityBatchResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("ChangeMessageVisibilityBatchResultEntry", i)) {
                    changeMessageVisibilityBatchResult.getSuccessful().add(ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("BatchResultErrorEntry", i)) {
                    changeMessageVisibilityBatchResult.getFailed().add(BatchResultErrorEntryStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return changeMessageVisibilityBatchResult;
            }
        }
    }
}
