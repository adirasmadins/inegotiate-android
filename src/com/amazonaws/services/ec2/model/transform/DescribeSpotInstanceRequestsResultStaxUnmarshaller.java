package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeSpotInstanceRequestsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeSpotInstanceRequestsResultStaxUnmarshaller implements Unmarshaller<DescribeSpotInstanceRequestsResult, StaxUnmarshallerContext> {
    private static DescribeSpotInstanceRequestsResultStaxUnmarshaller instance;

    public static DescribeSpotInstanceRequestsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeSpotInstanceRequestsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeSpotInstanceRequestsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeSpotInstanceRequestsResult describeSpotInstanceRequestsResult = new DescribeSpotInstanceRequestsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeSpotInstanceRequestsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("spotInstanceRequestSet/item", i)) {
                    describeSpotInstanceRequestsResult.getSpotInstanceRequests().add(SpotInstanceRequestStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeSpotInstanceRequestsResult;
            }
        }
    }
}
