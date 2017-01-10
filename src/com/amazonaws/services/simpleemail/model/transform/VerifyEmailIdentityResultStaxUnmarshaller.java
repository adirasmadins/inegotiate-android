package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.VerifyEmailIdentityResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class VerifyEmailIdentityResultStaxUnmarshaller implements Unmarshaller<VerifyEmailIdentityResult, StaxUnmarshallerContext> {
    private static VerifyEmailIdentityResultStaxUnmarshaller instance;

    public static VerifyEmailIdentityResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VerifyEmailIdentityResultStaxUnmarshaller();
        }
        return instance;
    }

    public VerifyEmailIdentityResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        VerifyEmailIdentityResult verifyEmailIdentityResult = new VerifyEmailIdentityResult();
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
        return verifyEmailIdentityResult;
    }
}
