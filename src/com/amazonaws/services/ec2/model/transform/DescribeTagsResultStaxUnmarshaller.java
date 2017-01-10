package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeTagsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeTagsResultStaxUnmarshaller implements Unmarshaller<DescribeTagsResult, StaxUnmarshallerContext> {
    private static DescribeTagsResultStaxUnmarshaller instance;

    public static DescribeTagsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeTagsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeTagsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeTagsResult describeTagsResult = new DescribeTagsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeTagsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("tagSet/item", i)) {
                    describeTagsResult.getTags().add(TagDescriptionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeTagsResult;
            }
        }
    }
}
