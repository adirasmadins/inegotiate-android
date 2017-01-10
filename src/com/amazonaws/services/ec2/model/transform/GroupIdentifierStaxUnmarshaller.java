package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.GroupIdentifier;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class GroupIdentifierStaxUnmarshaller implements Unmarshaller<GroupIdentifier, StaxUnmarshallerContext> {
    private static GroupIdentifierStaxUnmarshaller instance;

    public static GroupIdentifierStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GroupIdentifierStaxUnmarshaller();
        }
        return instance;
    }

    public GroupIdentifier unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GroupIdentifier groupIdentifier = new GroupIdentifier();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return groupIdentifier;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("groupName", i)) {
                    groupIdentifier.setGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupId", i)) {
                    groupIdentifier.setGroupId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return groupIdentifier;
            }
        }
    }
}
