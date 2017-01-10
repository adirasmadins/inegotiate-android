package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.DescribeLicensesResult;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class DescribeLicensesResultStaxUnmarshaller implements Unmarshaller<DescribeLicensesResult, StaxUnmarshallerContext> {
    private static DescribeLicensesResultStaxUnmarshaller instance;

    public static DescribeLicensesResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new DescribeLicensesResultStaxUnmarshaller();
        }
        return instance;
    }

    public DescribeLicensesResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        DescribeLicensesResult describeLicensesResult = new DescribeLicensesResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return describeLicensesResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("licenseSet/item", i)) {
                    describeLicensesResult.getLicenses().add(LicenseStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return describeLicensesResult;
            }
        }
    }
}
