package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.PriceSchedule;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.LongStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;
import com.doviknissim.inegotiate.app.DBAdapter;

public class PriceScheduleStaxUnmarshaller implements Unmarshaller<PriceSchedule, StaxUnmarshallerContext> {
    private static PriceScheduleStaxUnmarshaller instance;

    public static PriceScheduleStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new PriceScheduleStaxUnmarshaller();
        }
        return instance;
    }

    public PriceSchedule unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        PriceSchedule priceSchedule = new PriceSchedule();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return priceSchedule;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("term", i)) {
                    priceSchedule.setTerm(LongStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression(DBAdapter.PRICE, i)) {
                    priceSchedule.setPrice(DoubleStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("currencyCode", i)) {
                    priceSchedule.setCurrencyCode(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("active", i)) {
                    priceSchedule.setActive(BooleanStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return priceSchedule;
            }
        }
    }
}
