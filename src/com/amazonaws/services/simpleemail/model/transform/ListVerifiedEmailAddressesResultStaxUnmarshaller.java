package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.ListVerifiedEmailAddressesResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ListVerifiedEmailAddressesResultStaxUnmarshaller implements Unmarshaller<ListVerifiedEmailAddressesResult, StaxUnmarshallerContext> {
    private static ListVerifiedEmailAddressesResultStaxUnmarshaller instance;

    public static ListVerifiedEmailAddressesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListVerifiedEmailAddressesResultStaxUnmarshaller();
        }
        return instance;
    }

    public ListVerifiedEmailAddressesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ListVerifiedEmailAddressesResult listVerifiedEmailAddressesResult = new ListVerifiedEmailAddressesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return listVerifiedEmailAddressesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("VerifiedEmailAddresses/member", i)) {
                    listVerifiedEmailAddressesResult.getVerifiedEmailAddresses().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return listVerifiedEmailAddressesResult;
            }
        }
    }
}
