package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.DeleteIdentityResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DeleteIdentityResultStaxUnmarshaller implements Unmarshaller<DeleteIdentityResult, StaxUnmarshallerContext> {
    private static DeleteIdentityResultStaxUnmarshaller instance;

    public static DeleteIdentityResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DeleteIdentityResultStaxUnmarshaller();
        }
        return instance;
    }

    public DeleteIdentityResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DeleteIdentityResult deleteIdentityResult = new DeleteIdentityResult();
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
        return deleteIdentityResult;
    }
}
