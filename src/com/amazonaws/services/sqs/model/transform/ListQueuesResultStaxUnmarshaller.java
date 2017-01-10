package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ListQueuesResultStaxUnmarshaller implements Unmarshaller<ListQueuesResult, StaxUnmarshallerContext> {
    private static ListQueuesResultStaxUnmarshaller instance;

    public static ListQueuesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListQueuesResultStaxUnmarshaller();
        }
        return instance;
    }

    public ListQueuesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ListQueuesResult listQueuesResult = new ListQueuesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return listQueuesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("QueueUrl", i)) {
                    listQueuesResult.getQueueUrls().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return listQueuesResult;
            }
        }
    }
}
