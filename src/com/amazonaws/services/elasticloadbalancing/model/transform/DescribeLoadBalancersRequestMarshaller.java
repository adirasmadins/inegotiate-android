package com.amazonaws.services.elasticloadbalancing.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.elasticloadbalancing.model.DescribeLoadBalancersRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeLoadBalancersRequestMarshaller implements Marshaller<Request<DescribeLoadBalancersRequest>, DescribeLoadBalancersRequest> {
    public Request<DescribeLoadBalancersRequest> marshall(DescribeLoadBalancersRequest describeLoadBalancersRequest) {
        if (describeLoadBalancersRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeLoadBalancersRequest> defaultRequest = new DefaultRequest(describeLoadBalancersRequest, "AmazonElasticLoadBalancing");
        defaultRequest.addParameter("Action", "DescribeLoadBalancers");
        defaultRequest.addParameter("Version", "2012-06-01");
        int i = 1;
        for (String str : describeLoadBalancersRequest.getLoadBalancerNames()) {
            if (str != null) {
                defaultRequest.addParameter("LoadBalancerNames.member." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (describeLoadBalancersRequest.getMarker() != null) {
            defaultRequest.addParameter("Marker", StringUtils.fromString(describeLoadBalancersRequest.getMarker()));
        }
        return defaultRequest;
    }
}
