package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeSpotDatafeedSubscriptionResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeSpotDatafeedSubscriptionResultStaxUnmarshaller implements Unmarshaller<DescribeSpotDatafeedSubscriptionResult, StaxUnmarshallerContext> {
    private static DescribeSpotDatafeedSubscriptionResultStaxUnmarshaller instance;

    public static DescribeSpotDatafeedSubscriptionResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeSpotDatafeedSubscriptionResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeSpotDatafeedSubscriptionResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeSpotDatafeedSubscriptionResult describeSpotDatafeedSubscriptionResult = new DescribeSpotDatafeedSubscriptionResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeSpotDatafeedSubscriptionResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("spotDatafeedSubscription", i)) {
                    describeSpotDatafeedSubscriptionResult.setSpotDatafeedSubscription(SpotDatafeedSubscriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeSpotDatafeedSubscriptionResult;
            }
        }
    }
}
