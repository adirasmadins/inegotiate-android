package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.IdentityDkimAttributes;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class IdentityDkimAttributesStaxUnmarshaller implements Unmarshaller<IdentityDkimAttributes, StaxUnmarshallerContext> {
    private static IdentityDkimAttributesStaxUnmarshaller instance;

    public static IdentityDkimAttributesStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new IdentityDkimAttributesStaxUnmarshaller();
        }
        return instance;
    }

    public IdentityDkimAttributes unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        IdentityDkimAttributes identityDkimAttributes = new IdentityDkimAttributes();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return identityDkimAttributes;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("DkimEnabled", i)) {
                    identityDkimAttributes.setDkimEnabled(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("DkimVerificationStatus", i)) {
                    identityDkimAttributes.setDkimVerificationStatus(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("DkimTokens/member", i)) {
                    identityDkimAttributes.getDkimTokens().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return identityDkimAttributes;
            }
        }
    }
}
