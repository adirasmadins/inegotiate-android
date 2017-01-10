package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResultEntry;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller implements Unmarshaller<ChangeMessageVisibilityBatchResultEntry, StaxUnmarshallerContext> {
    private static ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller instance;

    public static ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller();
        }
        return instance;
    }

    public ChangeMessageVisibilityBatchResultEntry unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ChangeMessageVisibilityBatchResultEntry changeMessageVisibilityBatchResultEntry = new ChangeMessageVisibilityBatchResultEntry();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return changeMessageVisibilityBatchResultEntry;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Id", i)) {
                    changeMessageVisibilityBatchResultEntry.setId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return changeMessageVisibilityBatchResultEntry;
            }
        }
    }
}
