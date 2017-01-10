package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.BlockDeviceMapping;
import com.amazonaws.services.ec2.model.EbsBlockDevice;
import com.amazonaws.services.ec2.model.IamInstanceProfileSpecification;
import com.amazonaws.services.ec2.model.InstanceLicenseSpecification;
import com.amazonaws.services.ec2.model.InstanceNetworkInterfaceSpecification;
import com.amazonaws.services.ec2.model.Placement;
import com.amazonaws.services.ec2.model.PrivateIpAddressSpecification;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class RunInstancesRequestMarshaller implements Marshaller<Request<RunInstancesRequest>, RunInstancesRequest> {
    public Request<RunInstancesRequest> marshall(RunInstancesRequest runInstancesRequest) {
        if (runInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<RunInstancesRequest> defaultRequest = new DefaultRequest(runInstancesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "RunInstances");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (runInstancesRequest.getImageId() != null) {
            defaultRequest.addParameter("ImageId", StringUtils.fromString(runInstancesRequest.getImageId()));
        }
        if (runInstancesRequest.getMinCount() != null) {
            defaultRequest.addParameter("MinCount", StringUtils.fromInteger(runInstancesRequest.getMinCount()));
        }
        if (runInstancesRequest.getMaxCount() != null) {
            defaultRequest.addParameter("MaxCount", StringUtils.fromInteger(runInstancesRequest.getMaxCount()));
        }
        if (runInstancesRequest.getKeyName() != null) {
            defaultRequest.addParameter("KeyName", StringUtils.fromString(runInstancesRequest.getKeyName()));
        }
        int i = 1;
        for (String str : runInstancesRequest.getSecurityGroups()) {
            if (str != null) {
                defaultRequest.addParameter("SecurityGroup." + i, StringUtils.fromString(str));
            }
            i++;
        }
        i = 1;
        for (String str2 : runInstancesRequest.getSecurityGroupIds()) {
            if (str2 != null) {
                defaultRequest.addParameter("SecurityGroupId." + i, StringUtils.fromString(str2));
            }
            i++;
        }
        if (runInstancesRequest.getUserData() != null) {
            defaultRequest.addParameter("UserData", StringUtils.fromString(runInstancesRequest.getUserData()));
        }
        if (runInstancesRequest.getAddressingType() != null) {
            defaultRequest.addParameter("AddressingType", StringUtils.fromString(runInstancesRequest.getAddressingType()));
        }
        if (runInstancesRequest.getInstanceType() != null) {
            defaultRequest.addParameter("InstanceType", StringUtils.fromString(runInstancesRequest.getInstanceType()));
        }
        Placement placement = runInstancesRequest.getPlacement();
        if (placement != null) {
            if (placement.getAvailabilityZone() != null) {
                defaultRequest.addParameter("Placement.AvailabilityZone", StringUtils.fromString(placement.getAvailabilityZone()));
            }
            if (placement.getGroupName() != null) {
                defaultRequest.addParameter("Placement.GroupName", StringUtils.fromString(placement.getGroupName()));
            }
            if (placement.getTenancy() != null) {
                defaultRequest.addParameter("Placement.Tenancy", StringUtils.fromString(placement.getTenancy()));
            }
        }
        if (runInstancesRequest.getKernelId() != null) {
            defaultRequest.addParameter("KernelId", StringUtils.fromString(runInstancesRequest.getKernelId()));
        }
        if (runInstancesRequest.getRamdiskId() != null) {
            defaultRequest.addParameter("RamdiskId", StringUtils.fromString(runInstancesRequest.getRamdiskId()));
        }
        i = 1;
        for (BlockDeviceMapping blockDeviceMapping : runInstancesRequest.getBlockDeviceMappings()) {
            if (blockDeviceMapping != null) {
                if (blockDeviceMapping.getVirtualName() != null) {
                    defaultRequest.addParameter("BlockDeviceMapping." + i + ".VirtualName", StringUtils.fromString(blockDeviceMapping.getVirtualName()));
                }
                if (blockDeviceMapping.getDeviceName() != null) {
                    defaultRequest.addParameter("BlockDeviceMapping." + i + ".DeviceName", StringUtils.fromString(blockDeviceMapping.getDeviceName()));
                }
                EbsBlockDevice ebs = blockDeviceMapping.getEbs();
                if (ebs != null) {
                    if (ebs.getSnapshotId() != null) {
                        defaultRequest.addParameter("BlockDeviceMapping." + i + ".Ebs.SnapshotId", StringUtils.fromString(ebs.getSnapshotId()));
                    }
                    if (ebs.getVolumeSize() != null) {
                        defaultRequest.addParameter("BlockDeviceMapping." + i + ".Ebs.VolumeSize", StringUtils.fromInteger(ebs.getVolumeSize()));
                    }
                    if (ebs.isDeleteOnTermination() != null) {
                        defaultRequest.addParameter("BlockDeviceMapping." + i + ".Ebs.DeleteOnTermination", StringUtils.fromBoolean(ebs.isDeleteOnTermination()));
                    }
                    if (ebs.getVolumeType() != null) {
                        defaultRequest.addParameter("BlockDeviceMapping." + i + ".Ebs.VolumeType", StringUtils.fromString(ebs.getVolumeType()));
                    }
                    if (ebs.getIops() != null) {
                        defaultRequest.addParameter("BlockDeviceMapping." + i + ".Ebs.Iops", StringUtils.fromInteger(ebs.getIops()));
                    }
                }
                if (blockDeviceMapping.getNoDevice() != null) {
                    defaultRequest.addParameter("BlockDeviceMapping." + i + ".NoDevice", StringUtils.fromString(blockDeviceMapping.getNoDevice()));
                }
            }
            i++;
        }
        if (runInstancesRequest.isMonitoring() != null) {
            defaultRequest.addParameter("Monitoring.Enabled", StringUtils.fromBoolean(runInstancesRequest.isMonitoring()));
        }
        if (runInstancesRequest.getSubnetId() != null) {
            defaultRequest.addParameter("SubnetId", StringUtils.fromString(runInstancesRequest.getSubnetId()));
        }
        if (runInstancesRequest.isDisableApiTermination() != null) {
            defaultRequest.addParameter("DisableApiTermination", StringUtils.fromBoolean(runInstancesRequest.isDisableApiTermination()));
        }
        if (runInstancesRequest.getInstanceInitiatedShutdownBehavior() != null) {
            defaultRequest.addParameter("InstanceInitiatedShutdownBehavior", StringUtils.fromString(runInstancesRequest.getInstanceInitiatedShutdownBehavior()));
        }
        InstanceLicenseSpecification license = runInstancesRequest.getLicense();
        if (!(license == null || license.getPool() == null)) {
            defaultRequest.addParameter("License.Pool", StringUtils.fromString(license.getPool()));
        }
        if (runInstancesRequest.getPrivateIpAddress() != null) {
            defaultRequest.addParameter("PrivateIpAddress", StringUtils.fromString(runInstancesRequest.getPrivateIpAddress()));
        }
        if (runInstancesRequest.getClientToken() != null) {
            defaultRequest.addParameter("ClientToken", StringUtils.fromString(runInstancesRequest.getClientToken()));
        }
        if (runInstancesRequest.getAdditionalInfo() != null) {
            defaultRequest.addParameter("AdditionalInfo", StringUtils.fromString(runInstancesRequest.getAdditionalInfo()));
        }
        int i2 = 1;
        for (InstanceNetworkInterfaceSpecification instanceNetworkInterfaceSpecification : runInstancesRequest.getNetworkInterfaces()) {
            if (instanceNetworkInterfaceSpecification != null) {
                if (instanceNetworkInterfaceSpecification.getNetworkInterfaceId() != null) {
                    defaultRequest.addParameter("NetworkInterface." + i2 + ".NetworkInterfaceId", StringUtils.fromString(instanceNetworkInterfaceSpecification.getNetworkInterfaceId()));
                }
                if (instanceNetworkInterfaceSpecification.getDeviceIndex() != null) {
                    defaultRequest.addParameter("NetworkInterface." + i2 + ".DeviceIndex", StringUtils.fromInteger(instanceNetworkInterfaceSpecification.getDeviceIndex()));
                }
                if (instanceNetworkInterfaceSpecification.getSubnetId() != null) {
                    defaultRequest.addParameter("NetworkInterface." + i2 + ".SubnetId", StringUtils.fromString(instanceNetworkInterfaceSpecification.getSubnetId()));
                }
                if (instanceNetworkInterfaceSpecification.getDescription() != null) {
                    defaultRequest.addParameter("NetworkInterface." + i2 + ".Description", StringUtils.fromString(instanceNetworkInterfaceSpecification.getDescription()));
                }
                if (instanceNetworkInterfaceSpecification.getPrivateIpAddress() != null) {
                    defaultRequest.addParameter("NetworkInterface." + i2 + ".PrivateIpAddress", StringUtils.fromString(instanceNetworkInterfaceSpecification.getPrivateIpAddress()));
                }
                int i3 = 1;
                for (String str3 : instanceNetworkInterfaceSpecification.getGroups()) {
                    if (str3 != null) {
                        defaultRequest.addParameter("NetworkInterface." + i2 + ".SecurityGroupId." + i3, StringUtils.fromString(str3));
                    }
                    i3++;
                }
                if (instanceNetworkInterfaceSpecification.isDeleteOnTermination() != null) {
                    defaultRequest.addParameter("NetworkInterface." + i2 + ".DeleteOnTermination", StringUtils.fromBoolean(instanceNetworkInterfaceSpecification.isDeleteOnTermination()));
                }
                i3 = 1;
                for (PrivateIpAddressSpecification privateIpAddressSpecification : instanceNetworkInterfaceSpecification.getPrivateIpAddresses()) {
                    if (privateIpAddressSpecification != null) {
                        if (privateIpAddressSpecification.getPrivateIpAddress() != null) {
                            defaultRequest.addParameter("NetworkInterface." + i2 + ".PrivateIpAddresses." + i3 + ".PrivateIpAddress", StringUtils.fromString(privateIpAddressSpecification.getPrivateIpAddress()));
                        }
                        if (privateIpAddressSpecification.isPrimary() != null) {
                            defaultRequest.addParameter("NetworkInterface." + i2 + ".PrivateIpAddresses." + i3 + ".Primary", StringUtils.fromBoolean(privateIpAddressSpecification.isPrimary()));
                        }
                    }
                    i3++;
                }
                if (instanceNetworkInterfaceSpecification.getSecondaryPrivateIpAddressCount() != null) {
                    defaultRequest.addParameter("NetworkInterface." + i2 + ".SecondaryPrivateIpAddressCount", StringUtils.fromInteger(instanceNetworkInterfaceSpecification.getSecondaryPrivateIpAddressCount()));
                }
            }
            i2++;
        }
        IamInstanceProfileSpecification iamInstanceProfile = runInstancesRequest.getIamInstanceProfile();
        if (iamInstanceProfile != null) {
            if (iamInstanceProfile.getArn() != null) {
                defaultRequest.addParameter("IamInstanceProfile.Arn", StringUtils.fromString(iamInstanceProfile.getArn()));
            }
            if (iamInstanceProfile.getName() != null) {
                defaultRequest.addParameter("IamInstanceProfile.Name", StringUtils.fromString(iamInstanceProfile.getName()));
            }
        }
        if (runInstancesRequest.isEbsOptimized() != null) {
            defaultRequest.addParameter("EbsOptimized", StringUtils.fromBoolean(runInstancesRequest.isEbsOptimized()));
        }
        return defaultRequest;
    }
}
