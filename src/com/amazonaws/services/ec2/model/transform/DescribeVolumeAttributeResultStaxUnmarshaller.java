package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeVolumeAttributeResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeVolumeAttributeResultStaxUnmarshaller implements Unmarshaller<DescribeVolumeAttributeResult, StaxUnmarshallerContext> {
    private static DescribeVolumeAttributeResultStaxUnmarshaller instance;

    public static DescribeVolumeAttributeResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeVolumeAttributeResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeVolumeAttributeResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeVolumeAttributeResult describeVolumeAttributeResult = new DescribeVolumeAttributeResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeVolumeAttributeResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("volumeId", i)) {
                    describeVolumeAttributeResult.setVolumeId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("autoEnableIO/value", i)) {
                    describeVolumeAttributeResult.setAutoEnableIO(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("productCodes/item", i)) {
                    describeVolumeAttributeResult.getProductCodes().add(ProductCodeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeVolumeAttributeResult;
            }
        }
    }
}
