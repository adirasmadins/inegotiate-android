package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.SetIdentityNotificationTopicResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SetIdentityNotificationTopicResultStaxUnmarshaller implements Unmarshaller<SetIdentityNotificationTopicResult, StaxUnmarshallerContext> {
    private static SetIdentityNotificationTopicResultStaxUnmarshaller instance;

    public static SetIdentityNotificationTopicResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetIdentityNotificationTopicResultStaxUnmarshaller();
        }
        return instance;
    }

    public SetIdentityNotificationTopicResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SetIdentityNotificationTopicResult setIdentityNotificationTopicResult = new SetIdentityNotificationTopicResult();
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
        return setIdentityNotificationTopicResult;
    }
}
