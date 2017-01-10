package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.CreateLBCookieStickinessPolicyResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateLBCookieStickinessPolicyResultStaxUnmarshaller implements Unmarshaller<CreateLBCookieStickinessPolicyResult, StaxUnmarshallerContext> {
    private static CreateLBCookieStickinessPolicyResultStaxUnmarshaller instance;

    public static CreateLBCookieStickinessPolicyResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateLBCookieStickinessPolicyResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateLBCookieStickinessPolicyResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateLBCookieStickinessPolicyResult createLBCookieStickinessPolicyResult = new CreateLBCookieStickinessPolicyResult();
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
        return createLBCookieStickinessPolicyResult;
    }
}
