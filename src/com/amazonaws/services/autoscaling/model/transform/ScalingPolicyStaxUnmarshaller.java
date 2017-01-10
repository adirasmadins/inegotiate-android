package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.ScalingPolicy;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ScalingPolicyStaxUnmarshaller implements Unmarshaller<ScalingPolicy, StaxUnmarshallerContext> {
    private static ScalingPolicyStaxUnmarshaller instance;

    public static ScalingPolicyStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ScalingPolicyStaxUnmarshaller();
        }
        return instance;
    }

    public ScalingPolicy unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ScalingPolicy scalingPolicy = new ScalingPolicy();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return scalingPolicy;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("AutoScalingGroupName", i)) {
                    scalingPolicy.setAutoScalingGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("PolicyName", i)) {
                    scalingPolicy.setPolicyName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ScalingAdjustment", i)) {
                    scalingPolicy.setScalingAdjustment(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AdjustmentType", i)) {
                    scalingPolicy.setAdjustmentType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Cooldown", i)) {
                    scalingPolicy.setCooldown(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("PolicyARN", i)) {
                    scalingPolicy.setPolicyARN(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Alarms/member", i)) {
                    scalingPolicy.getAlarms().add(AlarmStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("MinAdjustmentStep", i)) {
                    scalingPolicy.setMinAdjustmentStep(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return scalingPolicy;
            }
        }
    }
}
