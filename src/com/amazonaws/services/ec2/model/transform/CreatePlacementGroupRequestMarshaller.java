package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CreatePlacementGroupRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreatePlacementGroupRequestMarshaller implements Marshaller<Request<CreatePlacementGroupRequest>, CreatePlacementGroupRequest> {
    public Request<CreatePlacementGroupRequest> marshall(CreatePlacementGroupRequest createPlacementGroupRequest) {
        if (createPlacementGroupRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreatePlacementGroupRequest> defaultRequest = new DefaultRequest(createPlacementGroupRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CreatePlacementGroup");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (createPlacementGroupRequest.getGroupName() != null) {
            defaultRequest.addParameter("GroupName", StringUtils.fromString(createPlacementGroupRequest.getGroupName()));
        }
        if (createPlacementGroupRequest.getStrategy() != null) {
            defaultRequest.addParameter("Strategy", StringUtils.fromString(createPlacementGroupRequest.getStrategy()));
        }
        return defaultRequest;
    }
}
