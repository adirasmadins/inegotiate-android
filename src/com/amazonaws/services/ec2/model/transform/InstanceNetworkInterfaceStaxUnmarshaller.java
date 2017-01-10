package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceNetworkInterface;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class InstanceNetworkInterfaceStaxUnmarshaller implements Unmarshaller<InstanceNetworkInterface, StaxUnmarshallerContext> {
    private static InstanceNetworkInterfaceStaxUnmarshaller instance;

    public static InstanceNetworkInterfaceStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceNetworkInterfaceStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceNetworkInterface unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceNetworkInterface instanceNetworkInterface = new InstanceNetworkInterface();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceNetworkInterface;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("networkInterfaceId", i)) {
                    instanceNetworkInterface.setNetworkInterfaceId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("subnetId", i)) {
                    instanceNetworkInterface.setSubnetId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("vpcId", i)) {
                    instanceNetworkInterface.setVpcId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("description", i)) {
                    instanceNetworkInterface.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ownerId", i)) {
                    instanceNetworkInterface.setOwnerId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression(DBAdapter.STATUS, i)) {
                    instanceNetworkInterface.setStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("privateIpAddress", i)) {
                    instanceNetworkInterface.setPrivateIpAddress(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("privateDnsName", i)) {
                    instanceNetworkInterface.setPrivateDnsName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("sourceDestCheck", i)) {
                    instanceNetworkInterface.setSourceDestCheck(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupSet/item", i)) {
                    instanceNetworkInterface.getGroups().add(GroupIdentifierStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("attachment", i)) {
                    instanceNetworkInterface.setAttachment(InstanceNetworkInterfaceAttachmentStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("association", i)) {
                    instanceNetworkInterface.setAssociation(InstanceNetworkInterfaceAssociationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceNetworkInterface;
            }
        }
    }
}
