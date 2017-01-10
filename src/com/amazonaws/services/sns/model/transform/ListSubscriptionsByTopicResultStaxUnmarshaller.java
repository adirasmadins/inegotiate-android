package com.amazonaws.services.sns.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sns.model.ListSubscriptionsByTopicResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ListSubscriptionsByTopicResultStaxUnmarshaller implements Unmarshaller<ListSubscriptionsByTopicResult, StaxUnmarshallerContext> {
    private static ListSubscriptionsByTopicResultStaxUnmarshaller instance;

    public static ListSubscriptionsByTopicResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListSubscriptionsByTopicResultStaxUnmarshaller();
        }
        return instance;
    }

    public ListSubscriptionsByTopicResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ListSubscriptionsByTopicResult listSubscriptionsByTopicResult = new ListSubscriptionsByTopicResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return listSubscriptionsByTopicResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Subscriptions/member", i)) {
                    listSubscriptionsByTopicResult.getSubscriptions().add(SubscriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    listSubscriptionsByTopicResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return listSubscriptionsByTopicResult;
            }
        }
    }
}
