package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.DescribeInstanceHealthRequest;
import com.amazonaws.services.elasticloadbalancing.model.Instance;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeInstanceHealthRequestMarshaller implements Marshaller<Request<DescribeInstanceHealthRequest>, DescribeInstanceHealthRequest> {
    public Request<DescribeInstanceHealthRequest> marshall(DescribeInstanceHealthRequest describeInstanceHealthRequest) {
        if (describeInstanceHealthRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeInstanceHealthRequest> defaultRequest = new DefaultRequest(describeInstanceHealthRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "DescribeInstanceHealth");
        defaultRequest.addParameter("Version", "2012-06-01");
        if (describeInstanceHealthRequest.getLoadBalancerName() != null) {
            defaultRequest.addParameter("LoadBalancerName", StringUtils.fromString(describeInstanceHealthRequest.getLoadBalancerName()));
        }
        int i = 1;
        for (Instance instance : describeInstanceHealthRequest.getInstances()) {
            if (!(instance == null || instance.getInstanceId() == null)) {
                defaultRequest.addParameter("Instances.member." + i + ".InstanceId", StringUtils.fromString(instance.getInstanceId()));
            }
            i++;
        }
        return defaultRequest;
    }
}
