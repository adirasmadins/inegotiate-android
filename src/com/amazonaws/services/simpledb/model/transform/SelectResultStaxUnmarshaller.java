package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpledb.model.SelectResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SelectResultStaxUnmarshaller implements Unmarshaller<SelectResult, StaxUnmarshallerContext> {
    private static SelectResultStaxUnmarshaller instance;

    public static SelectResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SelectResultStaxUnmarshaller();
        }
        return instance;
    }

    public SelectResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SelectResult selectResult = new SelectResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return selectResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Item", i)) {
                    selectResult.getItems().add(ItemStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("NextToken", i)) {
                    selectResult.setNextToken(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return selectResult;
            }
        }
    }
}
