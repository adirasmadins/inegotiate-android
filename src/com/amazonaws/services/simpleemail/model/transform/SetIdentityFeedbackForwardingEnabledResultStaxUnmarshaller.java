package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.SetIdentityFeedbackForwardingEnabledResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SetIdentityFeedbackForwardingEnabledResultStaxUnmarshaller implements Unmarshaller<SetIdentityFeedbackForwardingEnabledResult, StaxUnmarshallerContext> {
    private static SetIdentityFeedbackForwardingEnabledResultStaxUnmarshaller instance;

    public static SetIdentityFeedbackForwardingEnabledResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetIdentityFeedbackForwardingEnabledResultStaxUnmarshaller();
        }
        return instance;
    }

    public SetIdentityFeedbackForwardingEnabledResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SetIdentityFeedbackForwardingEnabledResult setIdentityFeedbackForwardingEnabledResult = new SetIdentityFeedbackForwardingEnabledResult();
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
        return setIdentityFeedbackForwardingEnabledResult;
    }
}
