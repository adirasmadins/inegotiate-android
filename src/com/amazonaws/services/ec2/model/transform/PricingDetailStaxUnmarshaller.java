package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.PricingDetail;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class PricingDetailStaxUnmarshaller implements Unmarshaller<PricingDetail, StaxUnmarshallerContext> {
    private static PricingDetailStaxUnmarshaller instance;

    public static PricingDetailStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PricingDetailStaxUnmarshaller();
        }
        return instance;
    }

    public PricingDetail unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PricingDetail pricingDetail = new PricingDetail();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return pricingDetail;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression(DBAdapter.PRICE, i)) {
                    pricingDetail.setPrice(DoubleStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("count", i)) {
                    pricingDetail.setCount(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return pricingDetail;
            }
        }
    }
}
