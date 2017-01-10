package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeKeyPairsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeKeyPairsResultStaxUnmarshaller implements Unmarshaller<DescribeKeyPairsResult, StaxUnmarshallerContext> {
    private static DescribeKeyPairsResultStaxUnmarshaller instance;

    public static DescribeKeyPairsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeKeyPairsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeKeyPairsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeKeyPairsResult describeKeyPairsResult = new DescribeKeyPairsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeKeyPairsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("keySet/item", i)) {
                    describeKeyPairsResult.getKeyPairs().add(KeyPairInfoStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeKeyPairsResult;
            }
        }
    }
}
