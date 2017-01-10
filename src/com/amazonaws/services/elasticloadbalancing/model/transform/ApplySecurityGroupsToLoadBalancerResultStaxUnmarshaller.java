package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.ApplySecurityGroupsToLoadBalancerResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ApplySecurityGroupsToLoadBalancerResultStaxUnmarshaller implements Unmarshaller<ApplySecurityGroupsToLoadBalancerResult, StaxUnmarshallerContext> {
    private static ApplySecurityGroupsToLoadBalancerResultStaxUnmarshaller instance;

    public static ApplySecurityGroupsToLoadBalancerResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ApplySecurityGroupsToLoadBalancerResultStaxUnmarshaller();
        }
        return instance;
    }

    public ApplySecurityGroupsToLoadBalancerResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ApplySecurityGroupsToLoadBalancerResult applySecurityGroupsToLoadBalancerResult = new ApplySecurityGroupsToLoadBalancerResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return applySecurityGroupsToLoadBalancerResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("SecurityGroups/member", i)) {
                    applySecurityGroupsToLoadBalancerResult.getSecurityGroups().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return applySecurityGroupsToLoadBalancerResult;
            }
        }
    }
}
