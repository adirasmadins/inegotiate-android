package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.NotificationConfiguration;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class NotificationConfigurationStaxUnmarshaller implements Unmarshaller<NotificationConfiguration, StaxUnmarshallerContext> {
    private static NotificationConfigurationStaxUnmarshaller instance;

    public static NotificationConfigurationStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new NotificationConfigurationStaxUnmarshaller();
        }
        return instance;
    }

    public NotificationConfiguration unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        NotificationConfiguration notificationConfiguration = new NotificationConfiguration();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return notificationConfiguration;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AutoScalingGroupName", i)) {
                    notificationConfiguration.setAutoScalingGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("TopicARN", i)) {
                    notificationConfiguration.setTopicARN(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NotificationType", i)) {
                    notificationConfiguration.setNotificationType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return notificationConfiguration;
            }
        }
    }
}
