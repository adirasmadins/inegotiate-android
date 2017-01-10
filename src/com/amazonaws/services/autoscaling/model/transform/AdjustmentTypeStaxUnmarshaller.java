package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.AdjustmentType;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AdjustmentTypeStaxUnmarshaller implements Unmarshaller<AdjustmentType, StaxUnmarshallerContext> {
    private static AdjustmentTypeStaxUnmarshaller instance;

    public static AdjustmentTypeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AdjustmentTypeStaxUnmarshaller();
        }
        return instance;
    }

    public AdjustmentType unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AdjustmentType adjustmentType = new AdjustmentType();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return adjustmentType;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AdjustmentType", i)) {
                    adjustmentType.setAdjustmentType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return adjustmentType;
            }
        }
    }
}
