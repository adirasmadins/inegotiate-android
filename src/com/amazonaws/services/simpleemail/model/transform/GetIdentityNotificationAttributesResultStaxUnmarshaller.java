package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.GetIdentityNotificationAttributesResult;
import com.amazonaws.services.simpleemail.model.IdentityNotificationAttributes;
import com.amazonaws.transform.MapEntry;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.Map.Entry;

public class GetIdentityNotificationAttributesResultStaxUnmarshaller implements Unmarshaller<GetIdentityNotificationAttributesResult, StaxUnmarshallerContext> {
    private static GetIdentityNotificationAttributesResultStaxUnmarshaller instance;

    private static class NotificationAttributesMapEntryUnmarshaller implements Unmarshaller<Entry<String, IdentityNotificationAttributes>, StaxUnmarshallerContext> {
        private static NotificationAttributesMapEntryUnmarshaller instance;

        private NotificationAttributesMapEntryUnmarshaller() {
        }

        public static NotificationAttributesMapEntryUnmarshaller getInstance() {
            if (instance == null) {
                instance = new NotificationAttributesMapEntryUnmarshaller();
            }
            return instance;
        }

        public Entry<String, IdentityNotificationAttributes> unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
            int currentDepth = staxUnmarshallerContext.getCurrentDepth();
            int i = currentDepth + 1;
            MapEntry mapEntry = new MapEntry();
            while (true) {
                XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
                if (!nextEvent.isEndDocument()) {
                    if (!nextEvent.isAttribute() && !nextEvent.isStartElement()) {
                        if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                            break;
                        }
                    } else if (staxUnmarshallerContext.testExpression("key", i)) {
                        mapEntry.setKey(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                    } else if (staxUnmarshallerContext.testExpression("value", i)) {
                        mapEntry.setValue(IdentityNotificationAttributesStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                    }
                } else {
                    break;
                }
            }
            return mapEntry;
        }
    }

    public static GetIdentityNotificationAttributesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetIdentityNotificationAttributesResultStaxUnmarshaller();
        }
        return instance;
    }

    public GetIdentityNotificationAttributesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetIdentityNotificationAttributesResult getIdentityNotificationAttributesResult = new GetIdentityNotificationAttributesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return getIdentityNotificationAttributesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("NotificationAttributes/entry", i)) {
                    Entry unmarshall = NotificationAttributesMapEntryUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    getIdentityNotificationAttributesResult.getNotificationAttributes().put(unmarshall.getKey(), unmarshall.getValue());
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return getIdentityNotificationAttributesResult;
            }
        }
    }
}
