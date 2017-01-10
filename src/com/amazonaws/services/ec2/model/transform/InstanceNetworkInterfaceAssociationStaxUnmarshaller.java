package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceNetworkInterfaceAssociation;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceNetworkInterfaceAssociationStaxUnmarshaller implements Unmarshaller<InstanceNetworkInterfaceAssociation, StaxUnmarshallerContext> {
    private static InstanceNetworkInterfaceAssociationStaxUnmarshaller instance;

    public static InstanceNetworkInterfaceAssociationStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceNetworkInterfaceAssociationStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceNetworkInterfaceAssociation unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceNetworkInterfaceAssociation instanceNetworkInterfaceAssociation = new InstanceNetworkInterfaceAssociation();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceNetworkInterfaceAssociation;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("publicIp", i)) {
                    instanceNetworkInterfaceAssociation.setPublicIp(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ipOwnerId", i)) {
                    instanceNetworkInterfaceAssociation.setIpOwnerId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceNetworkInterfaceAssociation;
            }
        }
    }
}
