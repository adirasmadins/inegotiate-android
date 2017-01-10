package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.SpotPrice;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SpotPriceStaxUnmarshaller implements Unmarshaller<SpotPrice, StaxUnmarshallerContext> {
    private static SpotPriceStaxUnmarshaller instance;

    public static SpotPriceStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SpotPriceStaxUnmarshaller();
        }
        return instance;
    }

    public SpotPrice unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SpotPrice spotPrice = new SpotPrice();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return spotPrice;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("instanceType", i)) {
                    spotPrice.setInstanceType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("productDescription", i)) {
                    spotPrice.setProductDescription(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("spotPrice", i)) {
                    spotPrice.setSpotPrice(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("timestamp", i)) {
                    spotPrice.setTimestamp(DateStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("availabilityZone", i)) {
                    spotPrice.setAvailabilityZone(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return spotPrice;
            }
        }
    }
}
