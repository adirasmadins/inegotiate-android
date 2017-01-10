package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.SecurityGroup;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SecurityGroupStaxUnmarshaller implements Unmarshaller<SecurityGroup, StaxUnmarshallerContext> {
    private static SecurityGroupStaxUnmarshaller instance;

    public static SecurityGroupStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SecurityGroupStaxUnmarshaller();
        }
        return instance;
    }

    public SecurityGroup unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SecurityGroup securityGroup = new SecurityGroup();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return securityGroup;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("ownerId", i)) {
                    securityGroup.setOwnerId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupName", i)) {
                    securityGroup.setGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupId", i)) {
                    securityGroup.setGroupId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupDescription", i)) {
                    securityGroup.setDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ipPermissions/item", i)) {
                    securityGroup.getIpPermissions().add(IpPermissionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ipPermissionsEgress/item", i)) {
                    securityGroup.getIpPermissionsEgress().add(IpPermissionStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("vpcId", i)) {
                    securityGroup.setVpcId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("tagSet/item", i)) {
                    securityGroup.getTags().add(TagStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return securityGroup;
            }
        }
    }
}
