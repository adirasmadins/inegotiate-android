package com.amazonaws.services.sns.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.sns.model.ConfirmSubscriptionResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ConfirmSubscriptionResultStaxUnmarshaller implements Unmarshaller<ConfirmSubscriptionResult, StaxUnmarshallerContext> {
    private static ConfirmSubscriptionResultStaxUnmarshaller instance;

    public static ConfirmSubscriptionResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ConfirmSubscriptionResultStaxUnmarshaller();
        }
        return instance;
    }

    public ConfirmSubscriptionResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ConfirmSubscriptionResult confirmSubscriptionResult = new ConfirmSubscriptionResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return confirmSubscriptionResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("SubscriptionArn", i)) {
                    confirmSubscriptionResult.setSubscriptionArn(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return confirmSubscriptionResult;
            }
        }
    }
}
