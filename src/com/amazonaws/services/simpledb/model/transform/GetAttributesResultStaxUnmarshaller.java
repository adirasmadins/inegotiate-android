package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpledb.model.GetAttributesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class GetAttributesResultStaxUnmarshaller implements Unmarshaller<GetAttributesResult, StaxUnmarshallerContext> {
    private static GetAttributesResultStaxUnmarshaller instance;

    public static GetAttributesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetAttributesResultStaxUnmarshaller();
        }
        return instance;
    }

    public GetAttributesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetAttributesResult getAttributesResult = new GetAttributesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return getAttributesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Attribute", i)) {
                    getAttributesResult.getAttributes().add(AttributeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return getAttributesResult;
            }
        }
    }
}
