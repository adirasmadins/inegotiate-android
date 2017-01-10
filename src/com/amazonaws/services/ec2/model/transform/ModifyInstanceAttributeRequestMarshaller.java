package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.EbsInstanceBlockDeviceSpecification;
import com.amazonaws.services.ec2.model.InstanceBlockDeviceMappingSpecification;
import com.amazonaws.services.ec2.model.ModifyInstanceAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ModifyInstanceAttributeRequestMarshaller implements Marshaller<Request<ModifyInstanceAttributeRequest>, ModifyInstanceAttributeRequest> {
    public Request<ModifyInstanceAttributeRequest> marshall(ModifyInstanceAttributeRequest modifyInstanceAttributeRequest) {
        int i = 1;
        if (modifyInstanceAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ModifyInstanceAttributeRequest> defaultRequest = new DefaultRequest(modifyInstanceAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ModifyInstanceAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (modifyInstanceAttributeRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(modifyInstanceAttributeRequest.getInstanceId()));
        }
        if (modifyInstanceAttributeRequest.getAttribute() != null) {
            defaultRequest.addParameter("Attribute", StringUtils.fromString(modifyInstanceAttributeRequest.getAttribute()));
        }
        if (modifyInstanceAttributeRequest.getValue() != null) {
            defaultRequest.addParameter("Value", StringUtils.fromString(modifyInstanceAttributeRequest.getValue()));
        }
        int i2 = 1;
        for (InstanceBlockDeviceMappingSpecification instanceBlockDeviceMappingSpecification : modifyInstanceAttributeRequest.getBlockDeviceMappings()) {
            if (instanceBlockDeviceMappingSpecification != null) {
                if (instanceBlockDeviceMappingSpecification.getDeviceName() != null) {
                    defaultRequest.addParameter("BlockDeviceMapping." + i2 + ".DeviceName", StringUtils.fromString(instanceBlockDeviceMappingSpecification.getDeviceName()));
                }
                EbsInstanceBlockDeviceSpecification ebs = instanceBlockDeviceMappingSpecification.getEbs();
                if (ebs != null) {
                    if (ebs.getVolumeId() != null) {
                        defaultRequest.addParameter("BlockDeviceMapping." + i2 + ".Ebs.VolumeId", StringUtils.fromString(ebs.getVolumeId()));
                    }
                    if (ebs.isDeleteOnTermination() != null) {
                        defaultRequest.addParameter("BlockDeviceMapping." + i2 + ".Ebs.DeleteOnTermination", StringUtils.fromBoolean(ebs.isDeleteOnTermination()));
                    }
                }
                if (instanceBlockDeviceMappingSpecification.getVirtualName() != null) {
                    defaultRequest.addParameter("BlockDeviceMapping." + i2 + ".VirtualName", StringUtils.fromString(instanceBlockDeviceMappingSpecification.getVirtualName()));
                }
                if (instanceBlockDeviceMappingSpecification.getNoDevice() != null) {
                    defaultRequest.addParameter("BlockDeviceMapping." + i2 + ".NoDevice", StringUtils.fromString(instanceBlockDeviceMappingSpecification.getNoDevice()));
                }
            }
            i2++;
        }
        if (modifyInstanceAttributeRequest.isSourceDestCheck() != null) {
            defaultRequest.addParameter("SourceDestCheck.Value", StringUtils.fromBoolean(modifyInstanceAttributeRequest.isSourceDestCheck()));
        }
        if (modifyInstanceAttributeRequest.isDisableApiTermination() != null) {
            defaultRequest.addParameter("DisableApiTermination.Value", StringUtils.fromBoolean(modifyInstanceAttributeRequest.isDisableApiTermination()));
        }
        if (modifyInstanceAttributeRequest.getInstanceType() != null) {
            defaultRequest.addParameter("InstanceType.Value", StringUtils.fromString(modifyInstanceAttributeRequest.getInstanceType()));
        }
        if (modifyInstanceAttributeRequest.getKernel() != null) {
            defaultRequest.addParameter("Kernel.Value", StringUtils.fromString(modifyInstanceAttributeRequest.getKernel()));
        }
        if (modifyInstanceAttributeRequest.getRamdisk() != null) {
            defaultRequest.addParameter("Ramdisk.Value", StringUtils.fromString(modifyInstanceAttributeRequest.getRamdisk()));
        }
        if (modifyInstanceAttributeRequest.getUserData() != null) {
            defaultRequest.addParameter("UserData.Value", StringUtils.fromString(modifyInstanceAttributeRequest.getUserData()));
        }
        if (modifyInstanceAttributeRequest.getInstanceInitiatedShutdownBehavior() != null) {
            defaultRequest.addParameter("InstanceInitiatedShutdownBehavior.Value", StringUtils.fromString(modifyInstanceAttributeRequest.getInstanceInitiatedShutdownBehavior()));
        }
        for (String str : modifyInstanceAttributeRequest.getGroups()) {
            if (str != null) {
                defaultRequest.addParameter("GroupId." + i, StringUtils.fromString(str));
            }
            i++;
        }
        if (modifyInstanceAttributeRequest.isEbsOptimized() != null) {
            defaultRequest.addParameter("EbsOptimized.Value", StringUtils.fromBoolean(modifyInstanceAttributeRequest.isEbsOptimized()));
        }
        return defaultRequest;
    }
}
