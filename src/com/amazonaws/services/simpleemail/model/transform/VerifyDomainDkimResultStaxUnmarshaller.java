package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.VerifyDomainDkimResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class VerifyDomainDkimResultStaxUnmarshaller implements Unmarshaller<VerifyDomainDkimResult, StaxUnmarshallerContext> {
    private static VerifyDomainDkimResultStaxUnmarshaller instance;

    public static VerifyDomainDkimResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new VerifyDomainDkimResultStaxUnmarshaller();
        }
        return instance;
    }

    public VerifyDomainDkimResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        VerifyDomainDkimResult verifyDomainDkimResult = new VerifyDomainDkimResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return verifyDomainDkimResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("DkimTokens/member", i)) {
                    verifyDomainDkimResult.getDkimTokens().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return verifyDomainDkimResult;
            }
        }
    }
}
