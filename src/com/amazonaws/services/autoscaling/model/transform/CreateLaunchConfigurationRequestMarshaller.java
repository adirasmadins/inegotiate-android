package com.amazonaws.services.autoscaling.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.autoscaling.model.BlockDeviceMapping;
import com.amazonaws.services.autoscaling.model.CreateLaunchConfigurationRequest;
import com.amazonaws.services.autoscaling.model.Ebs;
import com.amazonaws.services.autoscaling.model.InstanceMonitoring;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateLaunchConfigurationRequestMarshaller implements Marshaller<Request<CreateLaunchConfigurationRequest>, CreateLaunchConfigurationRequest> {
    public Request<CreateLaunchConfigurationRequest> marshall(CreateLaunchConfigurationRequest createLaunchConfigurationRequest) {
        int i = 1;
        if (createLaunchConfigurationRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateLaunchConfigurationRequest> defaultRequest = new DefaultRequest(createLaunchConfigurationRequest, "AmazonAutoScaling");
        defaultRequest.addParameter("Action", "CreateLaunchConfiguration");
        defaultRequest.addParameter("Version", "2011-01-01");
        if (createLaunchConfigurationRequest.getLaunchConfigurationName() != null) {
            defaultRequest.addParameter("LaunchConfigurationName", StringUtils.fromString(createLaunchConfigurationRequest.getLaunchConfigurationName()));
        }
        if (createLaunchConfigurationRequest.getImageId() != null) {
            defaultRequest.addParameter("ImageId", StringUtils.fromString(createLaunchConfigurationRequest.getImageId()));
        }
        if (createLaunchConfigurationRequest.getKeyName() != null) {
            defaultRequest.addParameter("KeyName", StringUtils.fromString(createLaunchConfigurationRequest.getKeyName()));
        }
        int i2 = 1;
        for (String str : createLaunchConfigurationRequest.getSecurityGroups()) {
            if (str != null) {
                defaultRequest.addParameter("SecurityGroups.member." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        if (createLaunchConfigurationRequest.getUserData() != null) {
            defaultRequest.addParameter("UserData", StringUtils.fromString(createLaunchConfigurationRequest.getUserData()));
        }
        if (createLaunchConfigurationRequest.getInstanceType() != null) {
            defaultRequest.addParameter("InstanceType", StringUtils.fromString(createLaunchConfigurationRequest.getInstanceType()));
        }
        if (createLaunchConfigurationRequest.getKernelId() != null) {
            defaultRequest.addParameter("KernelId", StringUtils.fromString(createLaunchConfigurationRequest.getKernelId()));
        }
        if (createLaunchConfigurationRequest.getRamdiskId() != null) {
            defaultRequest.addParameter("RamdiskId", StringUtils.fromString(createLaunchConfigurationRequest.getRamdiskId()));
        }
        for (BlockDeviceMapping blockDeviceMapping : createLaunchConfigurationRequest.getBlockDeviceMappings()) {
            if (blockDeviceMapping != null) {
                if (blockDeviceMapping.getVirtualName() != null) {
                    defaultRequest.addParameter("BlockDeviceMappings.member." + i + ".VirtualName", StringUtils.fromString(blockDeviceMapping.getVirtualName()));
                }
                if (blockDeviceMapping.getDeviceName() != null) {
                    defaultRequest.addParameter("BlockDeviceMappings.member." + i + ".DeviceName", StringUtils.fromString(blockDeviceMapping.getDeviceName()));
                }
                Ebs ebs = blockDeviceMapping.getEbs();
                if (ebs != null) {
                    if (ebs.getSnapshotId() != null) {
                        defaultRequest.addParameter("BlockDeviceMappings.member." + i + ".Ebs.SnapshotId", StringUtils.fromString(ebs.getSnapshotId()));
                    }
                    if (ebs.getVolumeSize() != null) {
                        defaultRequest.addParameter("BlockDeviceMappings.member." + i + ".Ebs.VolumeSize", StringUtils.fromInteger(ebs.getVolumeSize()));
                    }
                }
            }
            i++;
        }
        InstanceMonitoring instanceMonitoring = createLaunchConfigurationRequest.getInstanceMonitoring();
        if (!(instanceMonitoring == null || instanceMonitoring.isEnabled() == null)) {
            defaultRequest.addParameter("InstanceMonitoring.Enabled", StringUtils.fromBoolean(instanceMonitoring.isEnabled()));
        }
        if (createLaunchConfigurationRequest.getSpotPrice() != null) {
            defaultRequest.addParameter("SpotPrice", StringUtils.fromString(createLaunchConfigurationRequest.getSpotPrice()));
        }
        if (createLaunchConfigurationRequest.getIamInstanceProfile() != null) {
            defaultRequest.addParameter("IamInstanceProfile", StringUtils.fromString(createLaunchConfigurationRequest.getIamInstanceProfile()));
        }
        return defaultRequest;
    }
}
