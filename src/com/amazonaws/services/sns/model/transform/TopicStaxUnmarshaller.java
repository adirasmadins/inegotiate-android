package com.amazonaws.services.sns.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sns.model.Topic;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class TopicStaxUnmarshaller implements Unmarshaller<Topic, StaxUnmarshallerContext> {
    private static TopicStaxUnmarshaller instance;

    public static TopicStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new TopicStaxUnmarshaller();
        }
        return instance;
    }

    public Topic unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Topic topic = new Topic();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return topic;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("TopicArn", i)) {
                    topic.setTopicArn(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return topic;
            }
        }
    }
}
