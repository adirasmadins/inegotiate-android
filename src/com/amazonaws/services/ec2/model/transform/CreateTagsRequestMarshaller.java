package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CreateTagsRequest;
import com.amazonaws.services.ec2.model.Tag;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateTagsRequestMarshaller implements Marshaller<Request<CreateTagsRequest>, CreateTagsRequest> {
    public Request<CreateTagsRequest> marshall(CreateTagsRequest createTagsRequest) {
        int i = 1;
        if (createTagsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateTagsRequest> defaultRequest = new DefaultRequest(createTagsRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CreateTags");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i2 = 1;
        for (String str : createTagsRequest.getResources()) {
            if (str != null) {
                defaultRequest.addParameter("ResourceId." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        for (Tag tag : createTagsRequest.getTags()) {
            if (tag != null) {
                if (tag.getKey() != null) {
                    defaultRequest.addParameter("Tag." + i + ".Key", StringUtils.fromString(tag.getKey()));
                }
                if (tag.getValue() != null) {
                    defaultRequest.addParameter("Tag." + i + ".Value", StringUtils.fromString(tag.getValue()));
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
