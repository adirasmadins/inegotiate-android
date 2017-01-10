package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DeletePlacementGroupRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeletePlacementGroupRequestMarshaller implements Marshaller<Request<DeletePlacementGroupRequest>, DeletePlacementGroupRequest> {
    public Request<DeletePlacementGroupRequest> marshall(DeletePlacementGroupRequest deletePlacementGroupRequest) {
        if (deletePlacementGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeletePlacementGroupRequest> defaultRequest = new DefaultRequest(deletePlacementGroupRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DeletePlacementGroup");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (deletePlacementGroupRequest.getGroupName() != null) {
            defaultRequest.addParameter("GroupName", StringUtils.fromString(deletePlacementGroupRequest.getGroupName()));
        }
        return defaultRequest;
    }
}
