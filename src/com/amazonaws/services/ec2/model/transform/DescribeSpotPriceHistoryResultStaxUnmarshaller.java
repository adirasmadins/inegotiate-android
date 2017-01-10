package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeSpotPriceHistoryResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeSpotPriceHistoryResultStaxUnmarshaller implements Unmarshaller<DescribeSpotPriceHistoryResult, StaxUnmarshallerContext> {
    private static DescribeSpotPriceHistoryResultStaxUnmarshaller instance;

    public static DescribeSpotPriceHistoryResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeSpotPriceHistoryResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeSpotPriceHistoryResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeSpotPriceHistoryResult describeSpotPriceHistoryResult = new DescribeSpotPriceHistoryResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeSpotPriceHistoryResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("spotPriceHistorySet/item", i)) {
                    describeSpotPriceHistoryResult.getSpotPriceHistory().add(SpotPriceStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("nextToken", i)) {
                    describeSpotPriceHistoryResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeSpotPriceHistoryResult;
            }
        }
    }
}
