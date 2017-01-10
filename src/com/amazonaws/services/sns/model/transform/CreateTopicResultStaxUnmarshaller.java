package com.amazonaws.services.sns.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sns.model.CreateTopicResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateTopicResultStaxUnmarshaller implements Unmarshaller<CreateTopicResult, StaxUnmarshallerContext> {
    private static CreateTopicResultStaxUnmarshaller instance;

    public static CreateTopicResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateTopicResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateTopicResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateTopicResult createTopicResult = new CreateTopicResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createTopicResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("TopicArn", i)) {
                    createTopicResult.setTopicArn(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createTopicResult;
            }
        }
    }
}
