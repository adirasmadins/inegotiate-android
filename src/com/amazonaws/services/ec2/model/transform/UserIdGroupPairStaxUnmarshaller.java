package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.UserIdGroupPair;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class UserIdGroupPairStaxUnmarshaller implements Unmarshaller<UserIdGroupPair, StaxUnmarshallerContext> {
    private static UserIdGroupPairStaxUnmarshaller instance;

    public static UserIdGroupPairStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new UserIdGroupPairStaxUnmarshaller();
        }
        return instance;
    }

    public UserIdGroupPair unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        UserIdGroupPair userIdGroupPair = new UserIdGroupPair();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return userIdGroupPair;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("userId", i)) {
                    userIdGroupPair.setUserId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupName", i)) {
                    userIdGroupPair.setGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("groupId", i)) {
                    userIdGroupPair.setGroupId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return userIdGroupPair;
            }
        }
    }
}
