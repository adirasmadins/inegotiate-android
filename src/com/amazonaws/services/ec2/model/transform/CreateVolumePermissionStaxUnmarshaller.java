package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CreateVolumePermission;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateVolumePermissionStaxUnmarshaller implements Unmarshaller<CreateVolumePermission, StaxUnmarshallerContext> {
    private static CreateVolumePermissionStaxUnmarshaller instance;

    public static CreateVolumePermissionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateVolumePermissionStaxUnmarshaller();
        }
        return instance;
    }

    public CreateVolumePermission unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateVolumePermission createVolumePermission = new CreateVolumePermission();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createVolumePermission;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("userId", i)) {
                    createVolumePermission.setUserId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("group", i)) {
                    createVolumePermission.setGroup(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createVolumePermission;
            }
        }
    }
}
