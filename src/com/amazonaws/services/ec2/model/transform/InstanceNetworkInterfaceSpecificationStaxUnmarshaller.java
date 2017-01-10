package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceNetworkInterfaceSpecification;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceNetworkInterfaceSpecificationStaxUnmarshaller implements Unmarshaller<InstanceNetworkInterfaceSpecification, StaxUnmarshallerContext> {
    private static InstanceNetworkInterfaceSpecificationStaxUnmarshaller instance;

    public static InstanceNetworkInterfaceSpecificationStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceNetworkInterfaceSpecificationStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceNetworkInterfaceSpecification unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceNetworkInterfaceSpecification instanceNetworkInterfaceSpecification = new InstanceNetworkInterfaceSpecification();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceNetworkInterfaceSpecification;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("networkInterfaceId", i)) {
                    instanceNetworkInterfaceSpecification.setNetworkInterfaceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("deviceIndex", i)) {
                    instanceNetworkInterfaceSpecification.setDeviceIndex(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("subnetId", i)) {
                    instanceNetworkInterfaceSpecification.setSubnetId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("description", i)) {
                    instanceNetworkInterfaceSpecification.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("privateIpAddress", i)) {
                    instanceNetworkInterfaceSpecification.setPrivateIpAddress(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupSet/item/groupId", i)) {
                    instanceNetworkInterfaceSpecification.getGroups().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("deleteOnTermination", i)) {
                    instanceNetworkInterfaceSpecification.setDeleteOnTermination(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("privateIpAddressesSet/item", i)) {
                    instanceNetworkInterfaceSpecification.getPrivateIpAddresses().add(PrivateIpAddressSpecificationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("secondaryPrivateIpAddressCount", i)) {
                    instanceNetworkInterfaceSpecification.setSecondaryPrivateIpAddressCount(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceNetworkInterfaceSpecification;
            }
        }
    }
}
