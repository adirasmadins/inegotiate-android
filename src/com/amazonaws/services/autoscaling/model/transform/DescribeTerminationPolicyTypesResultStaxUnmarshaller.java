package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.autoscaling.model.DescribeTerminationPolicyTypesResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeTerminationPolicyTypesResultStaxUnmarshaller implements Unmarshaller<DescribeTerminationPolicyTypesResult, StaxUnmarshallerContext> {
    private static DescribeTerminationPolicyTypesResultStaxUnmarshaller instance;

    public static DescribeTerminationPolicyTypesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeTerminationPolicyTypesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeTerminationPolicyTypesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeTerminationPolicyTypesResult describeTerminationPolicyTypesResult = new DescribeTerminationPolicyTypesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeTerminationPolicyTypesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("TerminationPolicyTypes/member", i)) {
                    describeTerminationPolicyTypesResult.getTerminationPolicyTypes().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeTerminationPolicyTypesResult;
            }
        }
    }
}
