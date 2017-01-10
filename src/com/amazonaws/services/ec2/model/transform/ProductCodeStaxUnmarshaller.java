package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ProductCode;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ProductCodeStaxUnmarshaller implements Unmarshaller<ProductCode, StaxUnmarshallerContext> {
    private static ProductCodeStaxUnmarshaller instance;

    public static ProductCodeStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ProductCodeStaxUnmarshaller();
        }
        return instance;
    }

    public ProductCode unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ProductCode productCode = new ProductCode();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return productCode;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("productCode", i)) {
                    productCode.setProductCodeId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("type", i)) {
                    productCode.setProductCodeType(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return productCode;
            }
        }
    }
}
