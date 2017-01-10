package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.PurchaseReservedInstancesOfferingRequest;
import com.amazonaws.services.ec2.model.ReservedInstanceLimitPrice;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class PurchaseReservedInstancesOfferingRequestMarshaller implements Marshaller<Request<PurchaseReservedInstancesOfferingRequest>, PurchaseReservedInstancesOfferingRequest> {
    public Request<PurchaseReservedInstancesOfferingRequest> marshall(PurchaseReservedInstancesOfferingRequest purchaseReservedInstancesOfferingRequest) {
        if (purchaseReservedInstancesOfferingRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<PurchaseReservedInstancesOfferingRequest> defaultRequest = new DefaultRequest(purchaseReservedInstancesOfferingRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "PurchaseReservedInstancesOffering");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (purchaseReservedInstancesOfferingRequest.getReservedInstancesOfferingId() != null) {
            defaultRequest.addParameter("ReservedInstancesOfferingId", StringUtils.fromString(purchaseReservedInstancesOfferingRequest.getReservedInstancesOfferingId()));
        }
        if (purchaseReservedInstancesOfferingRequest.getInstanceCount() != null) {
            defaultRequest.addParameter("InstanceCount", StringUtils.fromInteger(purchaseReservedInstancesOfferingRequest.getInstanceCount()));
        }
        ReservedInstanceLimitPrice limitPrice = purchaseReservedInstancesOfferingRequest.getLimitPrice();
        if (limitPrice != null) {
            if (limitPrice.getAmount() != null) {
                defaultRequest.addParameter("LimitPrice.Amount", StringUtils.fromDouble(limitPrice.getAmount()));
            }
            if (limitPrice.getCurrencyCode() != null) {
                defaultRequest.addParameter("LimitPrice.CurrencyCode", StringUtils.fromString(limitPrice.getCurrencyCode()));
            }
        }
        return defaultRequest;
    }
}
