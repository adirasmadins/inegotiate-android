package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.LaunchPermission;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class LaunchPermissionStaxUnmarshaller implements Unmarshaller<LaunchPermission, StaxUnmarshallerContext> {
    private static LaunchPermissionStaxUnmarshaller instance;

    public static LaunchPermissionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LaunchPermissionStaxUnmarshaller();
        }
        return instance;
    }

    public LaunchPermission unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        LaunchPermission launchPermission = new LaunchPermission();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return launchPermission;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("userId", i)) {
                    launchPermission.setUserId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("group", i)) {
                    launchPermission.setGroup(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return launchPermission;
            }
        }
    }
}
