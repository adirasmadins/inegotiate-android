package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.javax.xml.stream.events.XMLEvent;
import com.amazonaws.services.ec2.model.ImportKeyPairResult;
import com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazonaws.transform.Unmarshaller;

public class ImportKeyPairResultStaxUnmarshaller implements Unmarshaller<ImportKeyPairResult, StaxUnmarshallerContext> {
    private static ImportKeyPairResultStaxUnmarshaller instance;

    public static ImportKeyPairResultStaxUnmarshaller getInstance() {
        if (instance == null) {
            instance = new ImportKeyPairResultStaxUnmarshaller();
        }
        return instance;
    }

    public ImportKeyPairResult unmarshall(StaxUnmarshallerContext staxUnmarshallerContext) throws Exception {
        ImportKeyPairResult importKeyPairResult = new ImportKeyPairResult();
        int currentDepth = staxUnmarshallerContext.getCurrentDepth();
        int i = currentDepth + 1;
        if (staxUnmarshallerContext.isStartOfDocument()) {
            i++;
        }
        while (true) {
            XMLEvent nextEvent = staxUnmarshallerContext.nextEvent();
            if (nextEvent.isEndDocument()) {
                return importKeyPairResult;
            }
            if (nextEvent.isAttribute() || nextEvent.isStartElement()) {
                if (staxUnmarshallerContext.testExpression("keyName", i)) {
                    importKeyPairResult.setKeyName(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                } else if (staxUnmarshallerContext.testExpression("keyFingerprint", i)) {
                    importKeyPairResult.setKeyFingerprint(StringStaxUnmarshaller.getInstance().unmarshall(staxUnmarshallerContext));
                }
            } else if (nextEvent.isEndElement() && staxUnmarshallerContext.getCurrentDepth() < currentDepth) {
                return importKeyPairResult;
            }
        }
    }
}
