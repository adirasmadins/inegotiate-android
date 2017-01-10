package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.elasticloadbalancing.model.Listener;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ListenerStaxUnmarshaller implements Unmarshaller<Listener, StaxUnmarshallerContext> {
    private static ListenerStaxUnmarshaller instance;

    public static ListenerStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ListenerStaxUnmarshaller();
        }
        return instance;
    }

    public Listener unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        Listener listener = new Listener();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i += 2;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return listener;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("Protocol", i)) {
                    listener.setProtocol(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("LoadBalancerPort", i)) {
                    listener.setLoadBalancerPort(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("InstanceProtocol", i)) {
                    listener.setInstanceProtocol(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("InstancePort", i)) {
                    listener.setInstancePort(IntegerStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("SSLCertificateId", i)) {
                    listener.setSSLCertificateId(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return listener;
            }
        }
    }
}
