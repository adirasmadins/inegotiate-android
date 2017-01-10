package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.AppCookieStickinessPolicy;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AppCookieStickinessPolicyStaxUnmarshaller implements Unmarshaller<AppCookieStickinessPolicy, StaxUnmarshallerContext> {
    private static AppCookieStickinessPolicyStaxUnmarshaller instance;

    public static AppCookieStickinessPolicyStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AppCookieStickinessPolicyStaxUnmarshaller();
        }
        return instance;
    }

    public AppCookieStickinessPolicy unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AppCookieStickinessPolicy appCookieStickinessPolicy = new AppCookieStickinessPolicy();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return appCookieStickinessPolicy;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("PolicyName", i)) {
                    appCookieStickinessPolicy.setPolicyName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("CookieName", i)) {
                    appCookieStickinessPolicy.setCookieName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return appCookieStickinessPolicy;
            }
        }
    }
}
