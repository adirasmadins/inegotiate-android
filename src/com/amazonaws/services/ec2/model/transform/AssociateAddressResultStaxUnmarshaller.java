package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.AssociateAddressResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AssociateAddressResultStaxUnmarshaller implements Unmarshaller<AssociateAddressResult, StaxUnmarshallerContext> {
    private static AssociateAddressResultStaxUnmarshaller instance;

    public static AssociateAddressResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AssociateAddressResultStaxUnmarshaller();
        }
        return instance;
    }

    public AssociateAddressResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        AssociateAddressResult associateAddressResult = new AssociateAddressResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return associateAddressResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("associationId", i)) {
                    associateAddressResult.setAssociationId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return associateAddressResult;
            }
        }
    }
}
