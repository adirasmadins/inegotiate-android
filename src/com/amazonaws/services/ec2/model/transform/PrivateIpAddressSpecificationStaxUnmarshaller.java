package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.PrivateIpAddressSpecification;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class PrivateIpAddressSpecificationStaxUnmarshaller implements Unmarshaller<PrivateIpAddressSpecification, StaxUnmarshallerContext> {
    private static PrivateIpAddressSpecificationStaxUnmarshaller instance;

    public static PrivateIpAddressSpecificationStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PrivateIpAddressSpecificationStaxUnmarshaller();
        }
        return instance;
    }

    public PrivateIpAddressSpecification unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PrivateIpAddressSpecification privateIpAddressSpecification = new PrivateIpAddressSpecification();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return privateIpAddressSpecification;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("privateIpAddress", i)) {
                    privateIpAddressSpecification.setPrivateIpAddress(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("primary", i)) {
                    privateIpAddressSpecification.setPrimary(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return privateIpAddressSpecification;
            }
        }
    }
}
