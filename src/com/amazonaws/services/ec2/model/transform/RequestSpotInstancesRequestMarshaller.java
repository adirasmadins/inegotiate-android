package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.BlockDeviceMapping;
import com.amazonaws.services.ec2.model.EbsBlockDevice;
import com.amazonaws.services.ec2.model.GroupIdentifier;
import com.amazonaws.services.ec2.model.IamInstanceProfileSpecification;
import com.amazonaws.services.ec2.model.InstanceNetworkInterfaceSpecification;
import com.amazonaws.services.ec2.model.LaunchSpecification;
import com.amazonaws.services.ec2.model.PrivateIpAddressSpecification;
import com.amazonaws.services.ec2.model.RequestSpotInstancesRequest;
import com.amazonaws.services.ec2.model.SpotPlacement;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class RequestSpotInstancesRequestMarshaller implements Marshaller<Request<RequestSpotInstancesRequest>, RequestSpotInstancesRequest> {
    public Request<RequestSpotInstancesRequest> marshall(RequestSpotInstancesRequest requestSpotInstancesRequest) {
        if (requestSpotInstancesRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<RequestSpotInstancesRequest> defaultRequest = new DefaultRequest(requestSpotInstancesRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "RequestSpotInstances");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (requestSpotInstancesRequest.getSpotPrice() != null) {
            defaultRequest.addParameter("SpotPrice", StringUtils.fromString(requestSpotInstancesRequest.getSpotPrice()));
        }
        if (requestSpotInstancesRequest.getInstanceCount() != null) {
            defaultRequest.addParameter("InstanceCount", StringUtils.fromInteger(requestSpotInstancesRequest.getInstanceCount()));
        }
        if (requestSpotInstancesRequest.getType() != null) {
            defaultRequest.addParameter("Type", StringUtils.fromString(requestSpotInstancesRequest.getType()));
        }
        if (requestSpotInstancesRequest.getValidFrom() != null) {
            defaultRequest.addParameter("ValidFrom", StringUtils.fromDate(requestSpotInstancesRequest.getValidFrom()));
        }
        if (requestSpotInstancesRequest.getValidUntil() != null) {
            defaultRequest.addParameter("ValidUntil", StringUtils.fromDate(requestSpotInstancesRequest.getValidUntil()));
        }
        if (requestSpotInstancesRequest.getLaunchGroup() != null) {
            defaultRequest.addParameter("LaunchGroup", StringUtils.fromString(requestSpotInstancesRequest.getLaunchGroup()));
        }
        if (requestSpotInstancesRequest.getAvailabilityZoneGroup() != null) {
            defaultRequest.addParameter("AvailabilityZoneGroup", StringUtils.fromString(requestSpotInstancesRequest.getAvailabilityZoneGroup()));
        }
        LaunchSpecification launchSpecification = requestSpotInstancesRequest.getLaunchSpecification();
        if (launchSpecification != null) {
            if (launchSpecification.getImageId() != null) {
                defaultRequest.addParameter("LaunchSpecification.ImageId", StringUtils.fromString(launchSpecification.getImageId()));
            }
            if (launchSpecification.getKeyName() != null) {
                defaultRequest.addParameter("LaunchSpecification.KeyName", StringUtils.fromString(launchSpecification.getKeyName()));
            }
            int i = 1;
            for (GroupIdentifier groupIdentifier : launchSpecification.getAllSecurityGroups()) {
                if (groupIdentifier != null) {
                    if (groupIdentifier.getGroupName() != null) {
                        defaultRequest.addParameter("LaunchSpecification.GroupSet." + i + ".GroupName", StringUtils.fromString(groupIdentifier.getGroupName()));
                    }
                    if (groupIdentifier.getGroupId() != null) {
                        defaultRequest.addParameter("LaunchSpecification.GroupSet." + i + ".GroupId", StringUtils.fromString(groupIdentifier.getGroupId()));
                    }
                }
                i++;
            }
            i = 1;
            for (String str : launchSpecification.getSecurityGroups()) {
                if (str != null) {
                    defaultRequest.addParameter("LaunchSpecification.SecurityGroup." + i, StringUtils.fromString(str));
                }
                i++;
            }
            if (launchSpecification.getUserData() != null) {
                defaultRequest.addParameter("LaunchSpecification.UserData", StringUtils.fromString(launchSpecification.getUserData()));
            }
            if (launchSpecification.getAddressingType() != null) {
                defaultRequest.addParameter("LaunchSpecification.AddressingType", StringUtils.fromString(launchSpecification.getAddressingType()));
            }
            if (launchSpecification.getInstanceType() != null) {
                defaultRequest.addParameter("LaunchSpecification.InstanceType", StringUtils.fromString(launchSpecification.getInstanceType()));
            }
            SpotPlacement placement = launchSpecification.getPlacement();
            if (placement != null) {
                if (placement.getAvailabilityZone() != null) {
                    defaultRequest.addParameter("LaunchSpecification.Placement.AvailabilityZone", StringUtils.fromString(placement.getAvailabilityZone()));
                }
                if (placement.getGroupName() != null) {
                    defaultRequest.addParameter("LaunchSpecification.Placement.GroupName", StringUtils.fromString(placement.getGroupName()));
                }
            }
            if (launchSpecification.getKernelId() != null) {
                defaultRequest.addParameter("LaunchSpecification.KernelId", StringUtils.fromString(launchSpecification.getKernelId()));
            }
            if (launchSpecification.getRamdiskId() != null) {
                defaultRequest.addParameter("LaunchSpecification.RamdiskId", StringUtils.fromString(launchSpecification.getRamdiskId()));
            }
            i = 1;
            for (BlockDeviceMapping blockDeviceMapping : launchSpecification.getBlockDeviceMappings()) {
                if (blockDeviceMapping != null) {
                    if (blockDeviceMapping.getVirtualName() != null) {
                        defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i + ".VirtualName", StringUtils.fromString(blockDeviceMapping.getVirtualName()));
                    }
                    if (blockDeviceMapping.getDeviceName() != null) {
                        defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i + ".DeviceName", StringUtils.fromString(blockDeviceMapping.getDeviceName()));
                    }
                    EbsBlockDevice ebs = blockDeviceMapping.getEbs();
                    if (ebs != null) {
                        if (ebs.getSnapshotId() != null) {
                            defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i + ".Ebs.SnapshotId", StringUtils.fromString(ebs.getSnapshotId()));
                        }
                        if (ebs.getVolumeSize() != null) {
                            defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i + ".Ebs.VolumeSize", StringUtils.fromInteger(ebs.getVolumeSize()));
                        }
                        if (ebs.isDeleteOnTermination() != null) {
                            defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i + ".Ebs.DeleteOnTermination", StringUtils.fromBoolean(ebs.isDeleteOnTermination()));
                        }
                        if (ebs.getVolumeType() != null) {
                            defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i + ".Ebs.VolumeType", StringUtils.fromString(ebs.getVolumeType()));
                        }
                        if (ebs.getIops() != null) {
                            defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i + ".Ebs.Iops", StringUtils.fromInteger(ebs.getIops()));
                        }
                    }
                    if (blockDeviceMapping.getNoDevice() != null) {
                        defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i + ".NoDevice", StringUtils.fromString(blockDeviceMapping.getNoDevice()));
                    }
                }
                i++;
            }
            if (launchSpecification.isMonitoringEnabled() != null) {
                defaultRequest.addParameter("LaunchSpecification.Monitoring.Enabled", StringUtils.fromBoolean(launchSpecification.isMonitoringEnabled()));
            }
            if (launchSpecification.getSubnetId() != null) {
                defaultRequest.addParameter("LaunchSpecification.SubnetId", StringUtils.fromString(launchSpecification.getSubnetId()));
            }
            int i2 = 1;
            for (InstanceNetworkInterfaceSpecification instanceNetworkInterfaceSpecification : launchSpecification.getNetworkInterfaces()) {
                if (instanceNetworkInterfaceSpecification != null) {
                    if (instanceNetworkInterfaceSpecification.getNetworkInterfaceId() != null) {
                        defaultRequest.addParameter("LaunchSpecification.NetworkInterfaceSet." + i2 + ".NetworkInterfaceId", StringUtils.fromString(instanceNetworkInterfaceSpecification.getNetworkInterfaceId()));
                    }
                    if (instanceNetworkInterfaceSpecification.getDeviceIndex() != null) {
                        defaultRequest.addParameter("LaunchSpecification.NetworkInterfaceSet." + i2 + ".DeviceIndex", StringUtils.fromInteger(instanceNetworkInterfaceSpecification.getDeviceIndex()));
                    }
                    if (instanceNetworkInterfaceSpecification.getSubnetId() != null) {
                        defaultRequest.addParameter("LaunchSpecification.NetworkInterfaceSet." + i2 + ".SubnetId", StringUtils.fromString(instanceNetworkInterfaceSpecification.getSubnetId()));
                    }
                    if (instanceNetworkInterfaceSpecification.getDescription() != null) {
                        defaultRequest.addParameter("LaunchSpecification.NetworkInterfaceSet." + i2 + ".Description", StringUtils.fromString(instanceNetworkInterfaceSpecification.getDescription()));
                    }
                    if (instanceNetworkInterfaceSpecification.getPrivateIpAddress() != null) {
                        defaultRequest.addParameter("LaunchSpecification.NetworkInterfaceSet." + i2 + ".PrivateIpAddress", StringUtils.fromString(instanceNetworkInterfaceSpecification.getPrivateIpAddress()));
                    }
                    int i3 = 1;
                    for (String str2 : instanceNetworkInterfaceSpecification.getGroups()) {
                        if (str2 != null) {
                            defaultRequest.addParameter("LaunchSpecification.NetworkInterfaceSet." + i2 + ".SecurityGroupId." + i3, StringUtils.fromString(str2));
                        }
                        i3++;
                    }
                    if (instanceNetworkInterfaceSpecification.isDeleteOnTermination() != null) {
                        defaultRequest.addParameter("LaunchSpecification.NetworkInterfaceSet." + i2 + ".DeleteOnTermination", StringUtils.fromBoolean(instanceNetworkInterfaceSpecification.isDeleteOnTermination()));
                    }
                    i3 = 1;
                    for (PrivateIpAddressSpecification privateIpAddressSpecification : instanceNetworkInterfaceSpecification.getPrivateIpAddresses()) {
                        if (privateIpAddressSpecification != null) {
                            if (privateIpAddressSpecification.getPrivateIpAddress() != null) {
                                defaultRequest.addParameter("LaunchSpecification.NetworkInterfaceSet." + i2 + ".PrivateIpAddresses." + i3 + ".PrivateIpAddress", StringUtils.fromString(privateIpAddressSpecification.getPrivateIpAddress()));
                            }
                            if (privateIpAddressSpecification.isPrimary() != null) {
                                defaultRequest.addParameter("LaunchSpecification.NetworkInterfaceSet." + i2 + ".PrivateIpAddresses." + i3 + ".Primary", StringUtils.fromBoolean(privateIpAddressSpecification.isPrimary()));
                            }
                        }
                        i3++;
                    }
                    if (instanceNetworkInterfaceSpecification.getSecondaryPrivateIpAddressCount() != null) {
                        defaultRequest.addParameter("LaunchSpecification.NetworkInterfaceSet." + i2 + ".SecondaryPrivateIpAddressCount", StringUtils.fromInteger(instanceNetworkInterfaceSpecification.getSecondaryPrivateIpAddressCount()));
                    }
                }
                i2++;
            }
            IamInstanceProfileSpecification iamInstanceProfile = launchSpecification.getIamInstanceProfile();
            if (iamInstanceProfile != null) {
                if (iamInstanceProfile.getArn() != null) {
                    defaultRequest.addParameter("LaunchSpecification.IamInstanceProfile.Arn", StringUtils.fromString(iamInstanceProfile.getArn()));
                }
                if (iamInstanceProfile.getName() != null) {
                    defaultRequest.addParameter("LaunchSpecification.IamInstanceProfile.Name", StringUtils.fromString(iamInstanceProfile.getName()));
                }
            }
            if (launchSpecification.isEbsOptimized() != null) {
                defaultRequest.addParameter("LaunchSpecification.EbsOptimized", StringUtils.fromBoolean(launchSpecification.isEbsOptimized()));
            }
        }
        return defaultRequest;
    }
}
