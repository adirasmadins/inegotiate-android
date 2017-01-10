package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpledb.model.Attribute;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class AttributeStaxUnmarshaller implements Unmarshaller<Attribute, StaxUnmarshallerContext> {
    private static AttributeStaxUnmarshaller instance;

    public static AttributeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new AttributeStaxUnmarshaller();
        }
        return instance;
    }

    public Attribute unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Attribute attribute = new Attribute();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return attribute;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Name", i)) {
                    attribute.setName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Name/@encoding", i)) {
                    attribute.setAlternateNameEncoding(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Value", i)) {
                    attribute.setValue(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Value/@encoding", i)) {
                    attribute.setAlternateValueEncoding(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return attribute;
            }
        }
    }
}
