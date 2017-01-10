package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.GetIdentityDkimAttributesResult;
import com.amazonaws.services.simpleemail.model.IdentityDkimAttributes;
import com.amazonaws.transform.MapEntry;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.Map.Entry;

public class GetIdentityDkimAttributesResultStaxUnmarshaller implements Unmarshaller<GetIdentityDkimAttributesResult, StaxUnmarshallerContext> {
    private static GetIdentityDkimAttributesResultStaxUnmarshaller instance;

    private static class DkimAttributesMapEntryUnmarshaller implements Unmarshaller<Entry<String, IdentityDkimAttributes>, StaxUnmarshallerContext> {
        private static DkimAttributesMapEntryUnmarshaller instance;

        private DkimAttributesMapEntryUnmarshaller() {
        }

        public static DkimAttributesMapEntryUnmarshaller getInstance() {
            if (instance == null) {
                instance = new DkimAttributesMapEntryUnmarshaller();
            }
            return instance;
        }

        public Entry<String, IdentityDkimAttributes> unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
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
                        mapEntry.setValue(IdentityDkimAttributesStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                    }
                } else {
                    break;
                }
            }
            return mapEntry;
        }
    }

    public static GetIdentityDkimAttributesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetIdentityDkimAttributesResultStaxUnmarshaller();
        }
        return instance;
    }

    public GetIdentityDkimAttributesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetIdentityDkimAttributesResult getIdentityDkimAttributesResult = new GetIdentityDkimAttributesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return getIdentityDkimAttributesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("DkimAttributes/entry", i)) {
                    Entry unmarshall = DkimAttributesMapEntryUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    getIdentityDkimAttributesResult.getDkimAttributes().put(unmarshall.getKey(), unmarshall.getValue());
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return getIdentityDkimAttributesResult;
            }
        }
    }
}
