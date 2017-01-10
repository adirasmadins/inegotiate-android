package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.CreateVolumeResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class CreateVolumeResultStaxUnmarshaller implements Unmarshaller<CreateVolumeResult, StaxUnmarshallerContext> {
    private static CreateVolumeResultStaxUnmarshaller instance;

    public static CreateVolumeResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new CreateVolumeResultStaxUnmarshaller();
        }
        return instance;
    }

    public CreateVolumeResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        CreateVolumeResult createVolumeResult = new CreateVolumeResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return createVolumeResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(".", i)) {
                    createVolumeResult.setVolume(VolumeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return createVolumeResult;
            }
        }
    }
}
