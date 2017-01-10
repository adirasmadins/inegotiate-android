package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DescribeSnapshotsRequest;
import com.amazonaws.services.ec2.model.Filter;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class DescribeSnapshotsRequestMarshaller implements Marshaller<Request<DescribeSnapshotsRequest>, DescribeSnapshotsRequest> {
    public Request<DescribeSnapshotsRequest> marshall(DescribeSnapshotsRequest describeSnapshotsRequest) {
        if (describeSnapshotsRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<DescribeSnapshotsRequest> defaultRequest = new DefaultRequest(describeSnapshotsRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "DescribeSnapshots");
        defaultRequest.addParameter("Version", "2012-08-15");
        int i = 1;
        for (String str : describeSnapshotsRequest.getSnapshotIds()) {
            if (str != null) {
                defaultRequest.addParameter("SnapshotId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (String str2 : describeSnapshotsRequest.getOwnerIds()) {
            if (str2 != null) {
                defaultRequest.addParameter("Owner." + i, StringUtils.fromString(str2));
            }
            i++;
        }
        i = 1;
        for (String str22 : describeSnapshotsRequest.getRestorableByUserIds()) {
            if (str22 != null) {
                defaultRequest.addParameter("RestorableBy." + i, StringUtils.fromString(str22));
            }
            i++;
        }
        i = 1;
        for (Filter filter : describeSnapshotsRequest.getFilters()) {
            if (filter != null) {
                if (filter.getName() != null) {
                    defaultRequest.addParameter("Filter." + i + ".Name", StringUtils.fromString(filter.getName()));
                }
                int i2 = 1;
                for (String str222 : filter.getValues()) {
                    if (str222 != null) {
                        defaultRequest.addParameter("Filter." + i + ".Value." + i2, StringUtils.fromString(str222));
                    }
                    i2++;
                }
            }
            i++;
        }
        return defaultRequest;
    }
}
