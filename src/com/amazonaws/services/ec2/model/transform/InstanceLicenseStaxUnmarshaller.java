package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.InstanceLicense;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class InstanceLicenseStaxUnmarshaller implements Unmarshaller<InstanceLicense, StaxUnmarshallerContext> {
    private static InstanceLicenseStaxUnmarshaller instance;

    public static InstanceLicenseStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new InstanceLicenseStaxUnmarshaller();
        }
        return instance;
    }

    public InstanceLicense unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        InstanceLicense instanceLicense = new InstanceLicense();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return instanceLicense;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("pool", i)) {
                    instanceLicense.setPool(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return instanceLicense;
            }
        }
    }
}
