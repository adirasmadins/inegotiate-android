package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.Request;
import com.amazonaws.handlers.AbstractRequestHandler;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.DescribeSpotInstanceRequestsResult;
import com.amazonaws.services.ec2.model.GroupIdentifier;
import com.amazonaws.services.ec2.model.ImportKeyPairRequest;
import com.amazonaws.services.ec2.model.LaunchSpecification;
import com.amazonaws.services.ec2.model.RequestSpotInstancesResult;
import com.amazonaws.services.ec2.model.Reservation;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.SpotInstanceRequest;
import com.amazonaws.util.TimingInfo;
import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.codec.binary.Base64;

public class EC2RequestHandler extends AbstractRequestHandler {
    private void populateLaunchSpecificationSecurityGroupNames(LaunchSpecification launchSpecification) {
        Collection arrayList = new ArrayList();
        for (GroupIdentifier groupName : launchSpecification.getAllSecurityGroups()) {
            arrayList.add(groupName.getGroupName());
        }
        launchSpecification.setSecurityGroups(arrayList);
    }

    private void populateReservationSecurityGroupNames(Reservation reservation) {
        Collection arrayList = new ArrayList();
        for (GroupIdentifier groupName : reservation.getGroups()) {
            arrayList.add(groupName.getGroupName());
        }
        reservation.setGroupNames(arrayList);
    }

    public void afterResponse(Request<?> request, Object obj, TimingInfo timingInfo) {
        if (obj instanceof DescribeSpotInstanceRequestsResult) {
            for (SpotInstanceRequest launchSpecification : ((DescribeSpotInstanceRequestsResult) obj).getSpotInstanceRequests()) {
                populateLaunchSpecificationSecurityGroupNames(launchSpecification.getLaunchSpecification());
            }
        } else if (obj instanceof RequestSpotInstancesResult) {
            for (SpotInstanceRequest launchSpecification2 : ((RequestSpotInstancesResult) obj).getSpotInstanceRequests()) {
                populateLaunchSpecificationSecurityGroupNames(launchSpecification2.getLaunchSpecification());
            }
        } else if (obj instanceof DescribeInstancesResult) {
            for (Reservation populateReservationSecurityGroupNames : ((DescribeInstancesResult) obj).getReservations()) {
                populateReservationSecurityGroupNames(populateReservationSecurityGroupNames);
            }
        } else if (obj instanceof RunInstancesResult) {
            populateReservationSecurityGroupNames(((RunInstancesResult) obj).getReservation());
        }
    }

    public void beforeRequest(Request<?> request) {
        AmazonWebServiceRequest originalRequest = request.getOriginalRequest();
        if (originalRequest instanceof ImportKeyPairRequest) {
            request.addParameter("PublicKeyMaterial", new String(Base64.encodeBase64(((ImportKeyPairRequest) originalRequest).getPublicKeyMaterial().getBytes())));
        }
    }
}
