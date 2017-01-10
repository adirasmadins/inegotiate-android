package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeImagesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeImagesResultStaxUnmarshaller implements Unmarshaller<DescribeImagesResult, StaxUnmarshallerContext> {
    private static DescribeImagesResultStaxUnmarshaller instance;

    public static DescribeImagesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeImagesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeImagesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeImagesResult describeImagesResult = new DescribeImagesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeImagesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("imagesSet/item", i)) {
                    describeImagesResult.getImages().add(ImageStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeImagesResult;
            }
        }
    }
}
