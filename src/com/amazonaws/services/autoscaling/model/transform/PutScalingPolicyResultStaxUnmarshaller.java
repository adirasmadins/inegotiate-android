package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.PutScalingPolicyResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class PutScalingPolicyResultStaxUnmarshaller implements Unmarshaller<PutScalingPolicyResult, StaxUnmarshallerContext> {
    private static PutScalingPolicyResultStaxUnmarshaller instance;

    public static PutScalingPolicyResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PutScalingPolicyResultStaxUnmarshaller();
        }
        return instance;
    }

    public PutScalingPolicyResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PutScalingPolicyResult putScalingPolicyResult = new PutScalingPolicyResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return putScalingPolicyResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("PolicyARN", i)) {
                    putScalingPolicyResult.setPolicyARN(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return putScalingPolicyResult;
            }
        }
    }
}
