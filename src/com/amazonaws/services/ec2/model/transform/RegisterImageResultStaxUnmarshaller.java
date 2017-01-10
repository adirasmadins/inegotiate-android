package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.RegisterImageResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class RegisterImageResultStaxUnmarshaller implements Unmarshaller<RegisterImageResult, StaxUnmarshallerContext> {
    private static RegisterImageResultStaxUnmarshaller instance;

    public static RegisterImageResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RegisterImageResultStaxUnmarshaller();
        }
        return instance;
    }

    public RegisterImageResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        RegisterImageResult registerImageResult = new RegisterImageResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return registerImageResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("imageId", i)) {
                    registerImageResult.setImageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return registerImageResult;
            }
        }
    }
}
