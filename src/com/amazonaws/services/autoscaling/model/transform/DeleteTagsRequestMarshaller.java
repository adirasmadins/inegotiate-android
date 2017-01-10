package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.DeleteTagsRequest;
import com.amazonaws.services.autoscaling.model.Tag;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DeleteTagsRequestMarshaller implements Marshaller<Request<DeleteTagsRequest>, DeleteTagsRequest> {
    public Request<DeleteTagsRequest> marshall(DeleteTagsRequest deleteTagsRequest) {
        if (deleteTagsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DeleteTagsRequest> defaultRequest = new DefaultRequest(deleteTagsRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "DeleteTags");
        defaultRequest.addParameter("Version", "2011-01-01");
        int i = 1;
        for (Tag tag : deleteTagsRequest.getTags()) {
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
