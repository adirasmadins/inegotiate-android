package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.PutScheduledUpdateGroupActionRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class PutScheduledUpdateGroupActionRequestMarshaller implements Marshaller<Request<PutScheduledUpdateGroupActionRequest>, PutScheduledUpdateGroupActionRequest> {
    public Request<PutScheduledUpdateGroupActionRequest> marshall(PutScheduledUpdateGroupActionRequest putScheduledUpdateGroupActionRequest) {
        if (putScheduledUpdateGroupActionRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<PutScheduledUpdateGroupActionRequest> defaultRequest = new DefaultRequest(putScheduledUpdateGroupActionRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "PutScheduledUpdateGroupAction");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (putScheduledUpdateGroupActionRequest.getAutoScalingGroupName() != null) {
            defaultRequest.addParameter("AutoScalingGroupName", StringUtils.fromString(putScheduledUpdateGroupActionRequest.getAutoScalingGroupName()));
        }
        if (putScheduledUpdateGroupActionRequest.getScheduledActionName() != null) {
            defaultRequest.addParameter("ScheduledActionName", StringUtils.fromString(putScheduledUpdateGroupActionRequest.getScheduledActionName()));
        }
        if (putScheduledUpdateGroupActionRequest.getTime() != null) {
            defaultRequest.addParameter("Time", StringUtils.fromDate(putScheduledUpdateGroupActionRequest.getTime()));
        }
        if (putScheduledUpdateGroupActionRequest.getStartTime() != null) {
            defaultRequest.addParameter("StartTime", StringUtils.fromDate(putScheduledUpdateGroupActionRequest.getStartTime()));
        }
        if (putScheduledUpdateGroupActionRequest.getEndTime() != null) {
            defaultRequest.addParameter("EndTime", StringUtils.fromDate(putScheduledUpdateGroupActionRequest.getEndTime()));
        }
        if (putScheduledUpdateGroupActionRequest.getRecurrence() != null) {
            defaultRequest.addParameter("Recurrence", StringUtils.fromString(putScheduledUpdateGroupActionRequest.getRecurrence()));
        }
        if (putScheduledUpdateGroupActionRequest.getMinSize() != null) {
            defaultRequest.addParameter("MinSize", StringUtils.fromInteger(putScheduledUpdateGroupActionRequest.getMinSize()));
        }
        if (putScheduledUpdateGroupActionRequest.getMaxSize() != null) {
            defaultRequest.addParameter("MaxSize", StringUtils.fromInteger(putScheduledUpdateGroupActionRequest.getMaxSize()));
        }
        if (putScheduledUpdateGroupActionRequest.getDesiredCapacity() != null) {
            defaultRequest.addParameter("DesiredCapacity", StringUtils.fromInteger(putScheduledUpdateGroupActionRequest.getDesiredCapacity()));
        }
        return defaultRequest;
    }
}
