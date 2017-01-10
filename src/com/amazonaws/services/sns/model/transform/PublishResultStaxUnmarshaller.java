package com.amazonaws.services.sns.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class PublishResultStaxUnmarshaller implements Unmarshaller<PublishResult, StaxUnmarshallerContext> {
    private static PublishResultStaxUnmarshaller instance;

    public static PublishResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PublishResultStaxUnmarshaller();
        }
        return instance;
    }

    public PublishResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PublishResult publishResult = new PublishResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return publishResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("MessageId", i)) {
                    publishResult.setMessageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return publishResult;
            }
        }
    }
}
