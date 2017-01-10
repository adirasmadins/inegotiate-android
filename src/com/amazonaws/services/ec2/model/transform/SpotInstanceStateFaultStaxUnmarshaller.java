package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.SpotInstanceStateFault;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SpotInstanceStateFaultStaxUnmarshaller implements Unmarshaller<SpotInstanceStateFault, StaxUnmarshallerContext> {
    private static SpotInstanceStateFaultStaxUnmarshaller instance;

    public static SpotInstanceStateFaultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SpotInstanceStateFaultStaxUnmarshaller();
        }
        return instance;
    }

    public SpotInstanceStateFault unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SpotInstanceStateFault spotInstanceStateFault = new SpotInstanceStateFault();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return spotInstanceStateFault;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("code", i)) {
                    spotInstanceStateFault.setCode(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("message", i)) {
                    spotInstanceStateFault.setMessage(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return spotInstanceStateFault;
            }
        }
    }
}
