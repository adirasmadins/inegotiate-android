package com.amazonaws.services.sns.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sns.model.SubscribeResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SubscribeResultStaxUnmarshaller implements Unmarshaller<SubscribeResult, StaxUnmarshallerContext> {
    private static SubscribeResultStaxUnmarshaller instance;

    public static SubscribeResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SubscribeResultStaxUnmarshaller();
        }
        return instance;
    }

    public SubscribeResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SubscribeResult subscribeResult = new SubscribeResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return subscribeResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("SubscriptionArn", i)) {
                    subscribeResult.setSubscriptionArn(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return subscribeResult;
            }
        }
    }
}
