package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CreateSpotDatafeedSubscriptionResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateSpotDatafeedSubscriptionResultStaxUnmarshaller implements Unmarshaller<CreateSpotDatafeedSubscriptionResult, StaxUnmarshallerContext> {
    private static CreateSpotDatafeedSubscriptionResultStaxUnmarshaller instance;

    public static CreateSpotDatafeedSubscriptionResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateSpotDatafeedSubscriptionResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateSpotDatafeedSubscriptionResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateSpotDatafeedSubscriptionResult createSpotDatafeedSubscriptionResult = new CreateSpotDatafeedSubscriptionResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createSpotDatafeedSubscriptionResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("spotDatafeedSubscription", i)) {
                    createSpotDatafeedSubscriptionResult.setSpotDatafeedSubscription(SpotDatafeedSubscriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createSpotDatafeedSubscriptionResult;
            }
        }
    }
}
