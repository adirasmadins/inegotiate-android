package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeSecurityGroupsResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeSecurityGroupsResultStaxUnmarshaller implements Unmarshaller<DescribeSecurityGroupsResult, StaxUnmarshallerContext> {
    private static DescribeSecurityGroupsResultStaxUnmarshaller instance;

    public static DescribeSecurityGroupsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeSecurityGroupsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeSecurityGroupsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeSecurityGroupsResult describeSecurityGroupsResult = new DescribeSecurityGroupsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeSecurityGroupsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("securityGroupInfo/item", i)) {
                    describeSecurityGroupsResult.getSecurityGroups().add(SecurityGroupStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeSecurityGroupsResult;
            }
        }
    }
}
