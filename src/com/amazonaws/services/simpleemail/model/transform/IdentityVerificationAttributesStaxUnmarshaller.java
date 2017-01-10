package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.IdentityVerificationAttributes;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class IdentityVerificationAttributesStaxUnmarshaller implements Unmarshaller<IdentityVerificationAttributes, StaxUnmarshallerContext> {
    private static IdentityVerificationAttributesStaxUnmarshaller instance;

    public static IdentityVerificationAttributesStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new IdentityVerificationAttributesStaxUnmarshaller();
        }
        return instance;
    }

    public IdentityVerificationAttributes unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        IdentityVerificationAttributes identityVerificationAttributes = new IdentityVerificationAttributes();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return identityVerificationAttributes;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("VerificationStatus", i)) {
                    identityVerificationAttributes.setVerificationStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("VerificationToken", i)) {
                    identityVerificationAttributes.setVerificationToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return identityVerificationAttributes;
            }
        }
    }
}
