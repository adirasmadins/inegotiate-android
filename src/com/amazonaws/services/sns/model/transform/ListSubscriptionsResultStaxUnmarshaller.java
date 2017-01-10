package com.amazonaws.services.sns.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sns.model.ListSubscriptionsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ListSubscriptionsResultStaxUnmarshaller implements Unmarshaller<ListSubscriptionsResult, StaxUnmarshallerContext> {
    private static ListSubscriptionsResultStaxUnmarshaller instance;

    public static ListSubscriptionsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListSubscriptionsResultStaxUnmarshaller();
        }
        return instance;
    }

    public ListSubscriptionsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ListSubscriptionsResult listSubscriptionsResult = new ListSubscriptionsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return listSubscriptionsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Subscriptions/member", i)) {
                    listSubscriptionsResult.getSubscriptions().add(SubscriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    listSubscriptionsResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return listSubscriptionsResult;
            }
        }
    }
}
