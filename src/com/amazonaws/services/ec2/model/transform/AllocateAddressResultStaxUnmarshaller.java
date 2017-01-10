package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.AllocateAddressResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AllocateAddressResultStaxUnmarshaller implements Unmarshaller<AllocateAddressResult, StaxUnmarshallerContext> {
    private static AllocateAddressResultStaxUnmarshaller instance;

    public static AllocateAddressResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AllocateAddressResultStaxUnmarshaller();
        }
        return instance;
    }

    public AllocateAddressResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AllocateAddressResult allocateAddressResult = new AllocateAddressResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return allocateAddressResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("publicIp", i)) {
                    allocateAddressResult.setPublicIp(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("domain", i)) {
                    allocateAddressResult.setDomain(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("allocationId", i)) {
                    allocateAddressResult.setAllocationId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return allocateAddressResult;
            }
        }
    }
}
