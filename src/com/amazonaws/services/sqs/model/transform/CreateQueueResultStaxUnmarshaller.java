package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateQueueResultStaxUnmarshaller implements Unmarshaller<CreateQueueResult, StaxUnmarshallerContext> {
    private static CreateQueueResultStaxUnmarshaller instance;

    public static CreateQueueResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateQueueResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateQueueResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateQueueResult createQueueResult = new CreateQueueResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createQueueResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("QueueUrl", i)) {
                    createQueueResult.setQueueUrl(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createQueueResult;
            }
        }
    }
}
