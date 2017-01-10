package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.IamInstanceProfileSpecification;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class IamInstanceProfileSpecificationStaxUnmarshaller implements Unmarshaller<IamInstanceProfileSpecification, StaxUnmarshallerContext> {
    private static IamInstanceProfileSpecificationStaxUnmarshaller instance;

    public static IamInstanceProfileSpecificationStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new IamInstanceProfileSpecificationStaxUnmarshaller();
        }
        return instance;
    }

    public IamInstanceProfileSpecification unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        IamInstanceProfileSpecification iamInstanceProfileSpecification = new IamInstanceProfileSpecification();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return iamInstanceProfileSpecification;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("arn", i)) {
                    iamInstanceProfileSpecification.setArn(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("name", i)) {
                    iamInstanceProfileSpecification.setName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return iamInstanceProfileSpecification;
            }
        }
    }
}
