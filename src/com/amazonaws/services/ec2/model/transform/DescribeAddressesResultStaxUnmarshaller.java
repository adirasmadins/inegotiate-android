package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeAddressesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeAddressesResultStaxUnmarshaller implements Unmarshaller<DescribeAddressesResult, StaxUnmarshallerContext> {
    private static DescribeAddressesResultStaxUnmarshaller instance;

    public static DescribeAddressesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeAddressesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeAddressesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeAddressesResult describeAddressesResult = new DescribeAddressesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeAddressesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("addressesSet/item", i)) {
                    describeAddressesResult.getAddresses().add(AddressStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeAddressesResult;
            }
        }
    }
}
