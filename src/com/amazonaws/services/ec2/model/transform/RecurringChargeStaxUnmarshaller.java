package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.RecurringCharge;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class RecurringChargeStaxUnmarshaller implements Unmarshaller<RecurringCharge, StaxUnmarshallerContext> {
    private static RecurringChargeStaxUnmarshaller instance;

    public static RecurringChargeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new RecurringChargeStaxUnmarshaller();
        }
        return instance;
    }

    public RecurringCharge unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        RecurringCharge recurringCharge = new RecurringCharge();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return recurringCharge;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("frequency", i)) {
                    recurringCharge.setFrequency(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("amount", i)) {
                    recurringCharge.setAmount(DoubleStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return recurringCharge;
            }
        }
    }
}
