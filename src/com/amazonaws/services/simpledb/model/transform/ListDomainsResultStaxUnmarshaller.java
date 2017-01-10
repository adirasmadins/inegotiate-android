package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpledb.model.ListDomainsResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ListDomainsResultStaxUnmarshaller implements Unmarshaller<ListDomainsResult, StaxUnmarshallerContext> {
    private static ListDomainsResultStaxUnmarshaller instance;

    public static ListDomainsResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListDomainsResultStaxUnmarshaller();
        }
        return instance;
    }

    public ListDomainsResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ListDomainsResult listDomainsResult = new ListDomainsResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return listDomainsResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("DomainName", i)) {
                    listDomainsResult.getDomainNames().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    listDomainsResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return listDomainsResult;
            }
        }
    }
}
