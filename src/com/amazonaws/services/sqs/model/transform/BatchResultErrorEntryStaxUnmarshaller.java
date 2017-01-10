package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class BatchResultErrorEntryStaxUnmarshaller implements Unmarshaller<BatchResultErrorEntry, StaxUnmarshallerContext> {
    private static BatchResultErrorEntryStaxUnmarshaller instance;

    public static BatchResultErrorEntryStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new BatchResultErrorEntryStaxUnmarshaller();
        }
        return instance;
    }

    public BatchResultErrorEntry unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        BatchResultErrorEntry batchResultErrorEntry = new BatchResultErrorEntry();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return batchResultErrorEntry;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Id", i)) {
                    batchResultErrorEntry.setId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("SenderFault", i)) {
                    batchResultErrorEntry.setSenderFault(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Code", i)) {
                    batchResultErrorEntry.setCode(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Message", i)) {
                    batchResultErrorEntry.setMessage(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return batchResultErrorEntry;
            }
        }
    }
}
