package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.CreateLoadBalancerResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateLoadBalancerResultStaxUnmarshaller implements Unmarshaller<CreateLoadBalancerResult, StaxUnmarshallerContext> {
    private static CreateLoadBalancerResultStaxUnmarshaller instance;

    public static CreateLoadBalancerResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateLoadBalancerResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateLoadBalancerResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateLoadBalancerResult createLoadBalancerResult = new CreateLoadBalancerResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createLoadBalancerResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("DNSName", i)) {
                    createLoadBalancerResult.setDNSName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createLoadBalancerResult;
            }
        }
    }
}
