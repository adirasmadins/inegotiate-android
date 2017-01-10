package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeVolumesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeVolumesResultStaxUnmarshaller implements Unmarshaller<DescribeVolumesResult, StaxUnmarshallerContext> {
    private static DescribeVolumesResultStaxUnmarshaller instance;

    public static DescribeVolumesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeVolumesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeVolumesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeVolumesResult describeVolumesResult = new DescribeVolumesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeVolumesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("volumeSet/item", i)) {
                    describeVolumesResult.getVolumes().add(VolumeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeVolumesResult;
            }
        }
    }
}
