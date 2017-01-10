package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.autoscaling.model.ScalingActivityInProgressException;
import com.amazonaws.transform.StandardErrorUnmarshaller;
import org.w3c.dom.Node;

public class ScalingActivityInProgressExceptionUnmarshaller extends StandardErrorUnmarshaller {
    public ScalingActivityInProgressExceptionUnmarshaller() {
        super(ScalingActivityInProgressException.class);
    }

    public AmazonServiceException unmarshall(Node node) throws Exception {
        String parseErrorCode = parseErrorCode(node);
        return (parseErrorCode == null || !parseErrorCode.equals("ScalingActivityInProgress")) ? null : (ScalingActivityInProgressException) super.unmarshall(node);
    }
}
