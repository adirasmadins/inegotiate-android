package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeRegionsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeRegionsResultStaxUnmarshaller implements Unmarshaller<DescribeRegionsResult, StaxUnmarshallerContext> {
    private static DescribeRegionsResultStaxUnmarshaller instance;

    public static DescribeRegionsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeRegionsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeRegionsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeRegionsResult describeRegionsResult = new DescribeRegionsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeRegionsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("regionInfo/item", i)) {
                    describeRegionsResult.getRegions().add(RegionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeRegionsResult;
            }
        }
    }
}
