package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.SpotDatafeedSubscription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SpotDatafeedSubscriptionStaxUnmarshaller implements Unmarshaller<SpotDatafeedSubscription, StaxUnmarshallerContext> {
    private static SpotDatafeedSubscriptionStaxUnmarshaller instance;

    public static SpotDatafeedSubscriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SpotDatafeedSubscriptionStaxUnmarshaller();
        }
        return instance;
    }

    public SpotDatafeedSubscription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SpotDatafeedSubscription spotDatafeedSubscription = new SpotDatafeedSubscription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return spotDatafeedSubscription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("ownerId", i)) {
                    spotDatafeedSubscription.setOwnerId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("bucket", i)) {
                    spotDatafeedSubscription.setBucket(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("prefix", i)) {
                    spotDatafeedSubscription.setPrefix(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("state", i)) {
                    spotDatafeedSubscription.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("fault", i)) {
                    spotDatafeedSubscription.setFault(SpotInstanceStateFaultStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return spotDatafeedSubscription;
            }
        }
    }
}
