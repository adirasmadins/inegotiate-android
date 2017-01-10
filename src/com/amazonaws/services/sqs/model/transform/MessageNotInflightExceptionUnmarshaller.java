package com.amazonaws.services.sqs.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.sqs.model.MessageNotInflightException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class MessageNotInflightExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public MessageNotInflightExceptionUnmarshaller() {
        super(MessageNotInflightException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("AWS.SimpleQueueService.MessageNotInflight")) ? null : (MessageNotInflightException) super.unmarshall(node);
    }
}
