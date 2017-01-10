package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeVolumeStatusResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeVolumeStatusResultStaxUnmarshaller implements Unmarshaller<DescribeVolumeStatusResult, StaxUnmarshallerContext> {
    private static DescribeVolumeStatusResultStaxUnmarshaller instance;

    public static DescribeVolumeStatusResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeVolumeStatusResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeVolumeStatusResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeVolumeStatusResult describeVolumeStatusResult = new DescribeVolumeStatusResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeVolumeStatusResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("volumeStatusSet/item", i)) {
                    describeVolumeStatusResult.getVolumeStatuses().add(VolumeStatusItemStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("nextToken", i)) {
                    describeVolumeStatusResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeVolumeStatusResult;
            }
        }
    }
}
