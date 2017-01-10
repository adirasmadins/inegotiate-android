package com.amazonaws.services.simpleemail.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpleemail.model.GetIdentityVerificationAttributesResult;
import com.amazonaws.services.simpleemail.model.IdentityVerificationAttributes;
import com.amazonaws.transform.MapEntry;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import java.util.Map.Entry;

public class GetIdentityVerificationAttributesResultStaxUnmarshaller implements Unmarshaller<GetIdentityVerificationAttributesResult, StaxUnmarshallerContext> {
    private static GetIdentityVerificationAttributesResultStaxUnmarshaller instance;

    private static class VerificationAttributesMapEntryUnmarshaller implements Unmarshaller<Entry<String, IdentityVerificationAttributes>, StaxUnmarshallerContext> {
        private static VerificationAttributesMapEntryUnmarshaller instance;

        private VerificationAttributesMapEntryUnmarshaller() {
        }

        public static VerificationAttributesMapEntryUnmarshaller getInstance() {
            if (instance == null) {
                instance = new VerificationAttributesMapEntryUnmarshaller();
            }
            return instance;
        }

        public Entry<String, IdentityVerificationAttributes> unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
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
                        mapEntry.setValue(IdentityVerificationAttributesStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                    }
                } else {
                    break;
                }
            }
            return mapEntry;
        }
    }

    public static GetIdentityVerificationAttributesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new GetIdentityVerificationAttributesResultStaxUnmarshaller();
        }
        return instance;
    }

    public GetIdentityVerificationAttributesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        GetIdentityVerificationAttributesResult getIdentityVerificationAttributesResult = new GetIdentityVerificationAttributesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return getIdentityVerificationAttributesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("VerificationAttributes/entry", i)) {
                    Entry unmarshall = VerificationAttributesMapEntryUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext);
                    getIdentityVerificationAttributesResult.getVerificationAttributes().put(unmarshall.getKey(), unmarshall.getValue());
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return getIdentityVerificationAttributesResult;
            }
        }
    }
}
