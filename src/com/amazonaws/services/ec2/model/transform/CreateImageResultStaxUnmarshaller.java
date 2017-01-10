package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CreateImageResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateImageResultStaxUnmarshaller implements Unmarshaller<CreateImageResult, StaxUnmarshallerContext> {
    private static CreateImageResultStaxUnmarshaller instance;

    public static CreateImageResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateImageResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateImageResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateImageResult createImageResult = new CreateImageResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createImageResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("imageId", i)) {
                    createImageResult.setImageId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createImageResult;
            }
        }
    }
}
