package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.VerifyDomainIdentityResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class VerifyDomainIdentityResultStaxUnmarshaller implements Unmarshaller<VerifyDomainIdentityResult, StaxUnmarshallerContext> {
    private static VerifyDomainIdentityResultStaxUnmarshaller instance;

    public static VerifyDomainIdentityResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VerifyDomainIdentityResultStaxUnmarshaller();
        }
        return instance;
    }

    public VerifyDomainIdentityResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        VerifyDomainIdentityResult verifyDomainIdentityResult = new VerifyDomainIdentityResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return verifyDomainIdentityResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("VerificationToken", i)) {
                    verifyDomainIdentityResult.setVerificationToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return verifyDomainIdentityResult;
            }
        }
    }
}
