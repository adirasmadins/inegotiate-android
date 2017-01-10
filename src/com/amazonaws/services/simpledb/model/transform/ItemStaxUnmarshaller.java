package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpledb.model.Item;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ItemStaxUnmarshaller implements Unmarshaller<Item, StaxUnmarshallerContext> {
    private static ItemStaxUnmarshaller instance;

    public static ItemStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ItemStaxUnmarshaller();
        }
        return instance;
    }

    public Item unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Item item = new Item();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return item;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Name", i)) {
                    item.setName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Name/@encoding", i)) {
                    item.setAlternateNameEncoding(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Attribute", i)) {
                    item.getAttributes().add(AttributeStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return item;
            }
        }
    }
}
