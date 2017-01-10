package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.ListenerDescription;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ListenerDescriptionStaxUnmarshaller implements Unmarshaller<ListenerDescription, StaxUnmarshallerContext> {
    private static ListenerDescriptionStaxUnmarshaller instance;

    public static ListenerDescriptionStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListenerDescriptionStaxUnmarshaller();
        }
        return instance;
    }

    public ListenerDescription unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ListenerDescription listenerDescription = new ListenerDescription();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return listenerDescription;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Listener", i)) {
                    listenerDescription.setListener(ListenerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("PolicyNames/member", i)) {
                    listenerDescription.getPolicyNames().add(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return listenerDescription;
            }
        }
    }
}
