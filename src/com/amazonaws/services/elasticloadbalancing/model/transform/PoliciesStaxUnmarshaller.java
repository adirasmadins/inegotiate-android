package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.Policies;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class PoliciesStaxUnmarshaller implements Unmarshaller<Policies, StaxUnmarshallerContext> {
    private static PoliciesStaxUnmarshaller instance;

    public static PoliciesStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PoliciesStaxUnmarshaller();
        }
        return instance;
    }

    public Policies unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Policies policies = new Policies();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return policies;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AppCookieStickinessPolicies/member", i)) {
                    policies.getAppCookieStickinessPolicies().add(AppCookieStickinessPolicyStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("LBCookieStickinessPolicies/member", i)) {
                    policies.getLBCookieStickinessPolicies().add(LBCookieStickinessPolicyStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("OtherPolicies/member", i)) {
                    policies.getOtherPolicies().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return policies;
            }
        }
    }
}
