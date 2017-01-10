package com.amazonaws.services.sns.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sns.model.Subscription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SubscriptionStaxUnmarshaller implements Unmarshaller<Subscription, StaxUnmarshallerContext> {
    private static SubscriptionStaxUnmarshaller instance;

    public static SubscriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SubscriptionStaxUnmarshaller();
        }
        return instance;
    }

    public Subscription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Subscription subscription = new Subscription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return subscription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("SubscriptionArn", i)) {
                    subscription.setSubscriptionArn(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Owner", i)) {
                    subscription.setOwner(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Protocol", i)) {
                    subscription.setProtocol(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Endpoint", i)) {
                    subscription.setEndpoint(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("TopicArn", i)) {
                    subscription.setTopicArn(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return subscription;
            }
        }
    }
}
