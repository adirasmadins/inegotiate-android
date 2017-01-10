package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.CreateOrUpdateTagsRequest;
import com.amazonaws.services.autoscaling.model.Tag;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateOrUpdateTagsRequestMarshaller implements Marshaller<Request<CreateOrUpdateTagsRequest>, CreateOrUpdateTagsRequest> {
    public Request<CreateOrUpdateTagsRequest> marshall(CreateOrUpdateTagsRequest createOrUpdateTagsRequest) {
        if (createOrUpdateTagsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateOrUpdateTagsRequest> defaultRequest = new DefaultRequest(createOrUpdateTagsRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "CreateOrUpdateTags");
        defaultRequest.addParameter("Version", "2011-01-01");
        int i = 1;
        for (Tag tag : createOrUpdateTagsRequest.getTags()) {
            if (tag != null) {
                if (tag.getResourceId() != null) {
                    defaultRequest.addParameter("Tags.member." + i + ".ResourceId", StringUtils.fromString(tag.getResourceId()));
                }
                if (tag.getResourceType() != null) {
                    defaultRequest.addParameter("Tags.member." + i + ".ResourceType", StringUtils.fromString(tag.getResourceType()));
                }
                if (tag.getKey() != null) {
                    defaultRequest.addParameter("Tags.member." + i + ".Key", StringUtils.fromString(tag.getKey()));
                }
                if (tag.getValue() != null) {
                    defaultRequest.addParameter("Tags.member." + i + ".Value", StringUtils.fromString(tag.getValue()));
                }
                if (tag.isPropagateAtLaunch() != null) {
                    defaultRequest.addParameter("Tags.member." + i + ".PropagateAtLaunch", StringUtils.fromBoolean(tag.isPropagateAtLaunch()));
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
