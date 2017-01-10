package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.CreateAppCookieStickinessPolicyResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateAppCookieStickinessPolicyResultStaxUnmarshaller implements Unmarshaller<CreateAppCookieStickinessPolicyResult, StaxUnmarshallerContext> {
    private static CreateAppCookieStickinessPolicyResultStaxUnmarshaller instance;

    public static CreateAppCookieStickinessPolicyResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateAppCookieStickinessPolicyResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateAppCookieStickinessPolicyResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateAppCookieStickinessPolicyResult createAppCookieStickinessPolicyResult = new CreateAppCookieStickinessPolicyResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (!nextEvent.isEndDocument()) {
                if (!nextEvent.isAttribute() && !nextEvent.isStartElement() && nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                    break;
                }
            } else {
                break;
            }
        }
        return createAppCookieStickinessPolicyResult;
    }
}
