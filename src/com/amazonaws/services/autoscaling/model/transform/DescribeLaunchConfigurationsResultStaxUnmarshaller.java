package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribeLaunchConfigurationsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeLaunchConfigurationsResultStaxUnmarshaller implements Unmarshaller<DescribeLaunchConfigurationsResult, StaxUnmarshallerContext> {
    private static DescribeLaunchConfigurationsResultStaxUnmarshaller instance;

    public static DescribeLaunchConfigurationsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeLaunchConfigurationsResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeLaunchConfigurationsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeLaunchConfigurationsResult describeLaunchConfigurationsResult = new DescribeLaunchConfigurationsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeLaunchConfigurationsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("LaunchConfigurations/member", i)) {
                    describeLaunchConfigurationsResult.getLaunchConfigurations().add(LaunchConfigurationStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    describeLaunchConfigurationsResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeLaunchConfigurationsResult;
            }
        }
    }
}
