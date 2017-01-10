package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.ListIdentitiesResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ListIdentitiesResultStaxUnmarshaller implements Unmarshaller<ListIdentitiesResult, StaxUnmarshallerContext> {
    private static ListIdentitiesResultStaxUnmarshaller instance;

    public static ListIdentitiesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListIdentitiesResultStaxUnmarshaller();
        }
        return instance;
    }

    public ListIdentitiesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ListIdentitiesResult listIdentitiesResult = new ListIdentitiesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return listIdentitiesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Identities/member", i)) {
                    listIdentitiesResult.getIdentities().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    listIdentitiesResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return listIdentitiesResult;
            }
        }
    }
}
