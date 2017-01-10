package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeAvailabilityZonesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeAvailabilityZonesResultStaxUnmarshaller implements Unmarshaller<DescribeAvailabilityZonesResult, StaxUnmarshallerContext> {
    private static DescribeAvailabilityZonesResultStaxUnmarshaller instance;

    public static DescribeAvailabilityZonesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeAvailabilityZonesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeAvailabilityZonesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeAvailabilityZonesResult describeAvailabilityZonesResult = new DescribeAvailabilityZonesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeAvailabilityZonesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("availabilityZoneInfo/item", i)) {
                    describeAvailabilityZonesResult.getAvailabilityZones().add(AvailabilityZoneStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeAvailabilityZonesResult;
            }
        }
    }
}
