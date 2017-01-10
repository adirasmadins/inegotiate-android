package com.amazonaws.services.cloudwatch.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DimensionStaxUnmarshaller implements Unmarshaller<Dimension, StaxUnmarshallerContext> {
    private static DimensionStaxUnmarshaller instance;

    public static DimensionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DimensionStaxUnmarshaller();
        }
        return instance;
    }

    public Dimension unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Dimension dimension = new Dimension();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return dimension;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Name", i)) {
                    dimension.setName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Value", i)) {
                    dimension.setValue(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return dimension;
            }
        }
    }
}
