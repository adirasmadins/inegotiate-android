package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.SourceSecurityGroup;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class SourceSecurityGroupStaxUnmarshaller implements Unmarshaller<SourceSecurityGroup, StaxUnmarshallerContext> {
    private static SourceSecurityGroupStaxUnmarshaller instance;

    public static SourceSecurityGroupStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new SourceSecurityGroupStaxUnmarshaller();
        }
        return instance;
    }

    public SourceSecurityGroup unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        SourceSecurityGroup sourceSecurityGroup = new SourceSecurityGroup();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return sourceSecurityGroup;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("OwnerAlias", i)) {
                    sourceSecurityGroup.setOwnerAlias(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("GroupName", i)) {
                    sourceSecurityGroup.setGroupName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return sourceSecurityGroup;
            }
        }
    }
}
