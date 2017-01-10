package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.LicenseCapacity;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class LicenseCapacityStaxUnmarshaller implements Unmarshaller<LicenseCapacity, StaxUnmarshallerContext> {
    private static LicenseCapacityStaxUnmarshaller instance;

    public static LicenseCapacityStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new LicenseCapacityStaxUnmarshaller();
        }
        return instance;
    }

    public LicenseCapacity unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        LicenseCapacity licenseCapacity = new LicenseCapacity();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return licenseCapacity;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("capacity", i)) {
                    licenseCapacity.setCapacity(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("instanceCapacity", i)) {
                    licenseCapacity.setInstanceCapacity(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("state", i)) {
                    licenseCapacity.setState(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("earliestAllowedDeactivationTime", i)) {
                    licenseCapacity.setEarliestAllowedDeactivationTime(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return licenseCapacity;
            }
        }
    }
}
