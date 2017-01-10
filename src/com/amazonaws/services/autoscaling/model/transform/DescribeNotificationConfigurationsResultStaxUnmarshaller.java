package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribeNotificationConfigurationsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeNotificationConfigurationsResultStaxUnmarshaller implements Unmarshaller<DescribeNotificationConfigurationsResult, StaxUnmarshallerContext> {
    private static DescribeNotificationConfigurationsResultStaxUnmarshaller instance;

    public static DescribeNotificationConfigurationsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeNotificationConfigurationsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeNotificationConfigurationsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeNotificationConfigurationsResult describeNotificationConfigurationsResult = new DescribeNotificationConfigurationsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeNotificationConfigurationsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("NotificationConfigurations/member", i)) {
                    describeNotificationConfigurationsResult.getNotificationConfigurations().add(NotificationConfigurationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    describeNotificationConfigurationsResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeNotificationConfigurationsResult;
            }
        }
    }
}
