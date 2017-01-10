package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.SetIdentityDkimEnabledResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SetIdentityDkimEnabledResultStaxUnmarshaller implements Unmarshaller<SetIdentityDkimEnabledResult, StaxUnmarshallerContext> {
    private static SetIdentityDkimEnabledResultStaxUnmarshaller instance;

    public static SetIdentityDkimEnabledResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SetIdentityDkimEnabledResultStaxUnmarshaller();
        }
        return instance;
    }

    public SetIdentityDkimEnabledResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SetIdentityDkimEnabledResult setIdentityDkimEnabledResult = new SetIdentityDkimEnabledResult();
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
        return setIdentityDkimEnabledResult;
    }
}
