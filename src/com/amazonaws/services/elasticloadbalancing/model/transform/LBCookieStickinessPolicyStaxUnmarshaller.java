package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.LBCookieStickinessPolicy;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class LBCookieStickinessPolicyStaxUnmarshaller implements Unmarshaller<LBCookieStickinessPolicy, StaxUnmarshallerContext> {
    private static LBCookieStickinessPolicyStaxUnmarshaller instance;

    public static LBCookieStickinessPolicyStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LBCookieStickinessPolicyStaxUnmarshaller();
        }
        return instance;
    }

    public LBCookieStickinessPolicy unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        LBCookieStickinessPolicy lBCookieStickinessPolicy = new LBCookieStickinessPolicy();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return lBCookieStickinessPolicy;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("PolicyName", i)) {
                    lBCookieStickinessPolicy.setPolicyName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("CookieExpirationPeriod", i)) {
                    lBCookieStickinessPolicy.setCookieExpirationPeriod(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return lBCookieStickinessPolicy;
            }
        }
    }
}
