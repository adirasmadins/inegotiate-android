package com.amazonaws.services.simpledb.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.simpledb.model.DomainMetadataResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DomainMetadataResultStaxUnmarshaller implements Unmarshaller<DomainMetadataResult, StaxUnmarshallerContext> {
    private static DomainMetadataResultStaxUnmarshaller instance;

    public static DomainMetadataResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DomainMetadataResultStaxUnmarshaller();
        }
        return instance;
    }

    public DomainMetadataResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DomainMetadataResult domainMetadataResult = new DomainMetadataResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return domainMetadataResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("ItemCount", i)) {
                    domainMetadataResult.setItemCount(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("ItemNamesSizeBytes", i)) {
                    domainMetadataResult.setItemNamesSizeBytes(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AttributeNameCount", i)) {
                    domainMetadataResult.setAttributeNameCount(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AttributeNamesSizeBytes", i)) {
                    domainMetadataResult.setAttributeNamesSizeBytes(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AttributeValueCount", i)) {
                    domainMetadataResult.setAttributeValueCount(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("AttributeValuesSizeBytes", i)) {
                    domainMetadataResult.setAttributeValuesSizeBytes(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("Timestamp", i)) {
                    domainMetadataResult.setTimestamp(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return domainMetadataResult;
            }
        }
    }
}
