package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.IamInstanceProfile;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class IamInstanceProfileStaxUnmarshaller implements Unmarshaller<IamInstanceProfile, StaxUnmarshallerContext> {
    private static IamInstanceProfileStaxUnmarshaller instance;

    public static IamInstanceProfileStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new IamInstanceProfileStaxUnmarshaller();
        }
        return instance;
    }

    public IamInstanceProfile unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        IamInstanceProfile iamInstanceProfile = new IamInstanceProfile();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return iamInstanceProfile;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("arn", i)) {
                    iamInstanceProfile.setArn(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("id", i)) {
                    iamInstanceProfile.setId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return iamInstanceProfile;
            }
        }
    }
}
