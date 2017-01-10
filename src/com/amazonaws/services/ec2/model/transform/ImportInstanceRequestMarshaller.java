package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.BlockDeviceMapping;
import com.amazonaws.services.ec2.model.DiskImage;
import com.amazonaws.services.ec2.model.DiskImageDetail;
import com.amazonaws.services.ec2.model.EbsBlockDevice;
import com.amazonaws.services.ec2.model.ImportInstanceLaunchSpecification;
import com.amazonaws.services.ec2.model.ImportInstanceRequest;
import com.amazonaws.services.ec2.model.Placement;
import com.amazonaws.services.ec2.model.VolumeDetail;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ImportInstanceRequestMarshaller implements Marshaller<Request<ImportInstanceRequest>, ImportInstanceRequest> {
    public Request<ImportInstanceRequest> marshall(ImportInstanceRequest importInstanceRequest) {
        int i = 1;
        if (importInstanceRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ImportInstanceRequest> defaultRequest = new DefaultRequest(importInstanceRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ImportInstance");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (importInstanceRequest.getDescription() != null) {
            defaultRequest.addParameter("Description", StringUtils.fromString(importInstanceRequest.getDescription()));
        }
        ImportInstanceLaunchSpecification launchSpecification = importInstanceRequest.getLaunchSpecification();
        if (launchSpecification != null) {
            if (launchSpecification.getArchitecture() != null) {
                defaultRequest.addParameter("LaunchSpecification.Architecture", StringUtils.fromString(launchSpecification.getArchitecture()));
            }
            int i2 = 1;
            for (String str : launchSpecification.getSecurityGroups()) {
                if (str != null) {
                    defaultRequest.addParameter("LaunchSpecification.SecurityGroup." + i2, StringUtils.fromString(str));
                }
                i2++;
            }
            if (launchSpecification.getAdditionalInfo() != null) {
                defaultRequest.addParameter("LaunchSpecification.AdditionalInfo", StringUtils.fromString(launchSpecification.getAdditionalInfo()));
            }
            if (launchSpecification.getUserData() != null) {
                defaultRequest.addParameter("LaunchSpecification.UserData", StringUtils.fromString(launchSpecification.getUserData()));
            }
            if (launchSpecification.getInstanceType() != null) {
                defaultRequest.addParameter("LaunchSpecification.InstanceType", StringUtils.fromString(launchSpecification.getInstanceType()));
            }
            Placement placement = launchSpecification.getPlacement();
            if (placement != null) {
                if (placement.getAvailabilityZone() != null) {
                    defaultRequest.addParameter("LaunchSpecification.Placement.AvailabilityZone", StringUtils.fromString(placement.getAvailabilityZone()));
                }
                if (placement.getGroupName() != null) {
                    defaultRequest.addParameter("LaunchSpecification.Placement.GroupName", StringUtils.fromString(placement.getGroupName()));
                }
                if (placement.getTenancy() != null) {
                    defaultRequest.addParameter("LaunchSpecification.Placement.Tenancy", StringUtils.fromString(placement.getTenancy()));
                }
            }
            i2 = 1;
            for (BlockDeviceMapping blockDeviceMapping : launchSpecification.getBlockDeviceMappings()) {
                if (blockDeviceMapping != null) {
                    if (blockDeviceMapping.getVirtualName() != null) {
                        defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i2 + ".VirtualName", StringUtils.fromString(blockDeviceMapping.getVirtualName()));
                    }
                    if (blockDeviceMapping.getDeviceName() != null) {
                        defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i2 + ".DeviceName", StringUtils.fromString(blockDeviceMapping.getDeviceName()));
                    }
                    EbsBlockDevice ebs = blockDeviceMapping.getEbs();
                    if (ebs != null) {
                        if (ebs.getSnapshotId() != null) {
                            defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i2 + ".Ebs.SnapshotId", StringUtils.fromString(ebs.getSnapshotId()));
                        }
                        if (ebs.getVolumeSize() != null) {
                            defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i2 + ".Ebs.VolumeSize", StringUtils.fromInteger(ebs.getVolumeSize()));
                        }
                        if (ebs.isDeleteOnTermination() != null) {
                            defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i2 + ".Ebs.DeleteOnTermination", StringUtils.fromBoolean(ebs.isDeleteOnTermination()));
                        }
                        if (ebs.getVolumeType() != null) {
                            defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i2 + ".Ebs.VolumeType", StringUtils.fromString(ebs.getVolumeType()));
                        }
                        if (ebs.getIops() != null) {
                            defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i2 + ".Ebs.Iops", StringUtils.fromInteger(ebs.getIops()));
                        }
                    }
                    if (blockDeviceMapping.getNoDevice() != null) {
                        defaultRequest.addParameter("LaunchSpecification.BlockDeviceMapping." + i2 + ".NoDevice", StringUtils.fromString(blockDeviceMapping.getNoDevice()));
                    }
                }
                i2++;
            }
            if (launchSpecification.isMonitoring() != null) {
                defaultRequest.addParameter("LaunchSpecification.Monitoring", StringUtils.fromBoolean(launchSpecification.isMonitoring()));
            }
            if (launchSpecification.getSubnetId() != null) {
                defaultRequest.addParameter("LaunchSpecification.SubnetId", StringUtils.fromString(launchSpecification.getSubnetId()));
            }
            if (launchSpecification.isDisableApiTermination() != null) {
                defaultRequest.addParameter("LaunchSpecification.DisableApiTermination", StringUtils.fromBoolean(launchSpecification.isDisableApiTermination()));
            }
            if (launchSpecification.getInstanceInitiatedShutdownBehavior() != null) {
                defaultRequest.addParameter("LaunchSpecification.InstanceInitiatedShutdownBehavior", StringUtils.fromString(launchSpecification.getInstanceInitiatedShutdownBehavior()));
            }
            if (launchSpecification.getPrivateIpAddress() != null) {
                defaultRequest.addParameter("LaunchSpecification.PrivateIpAddress", StringUtils.fromString(launchSpecification.getPrivateIpAddress()));
            }
        }
        for (DiskImage diskImage : importInstanceRequest.getDiskImages()) {
            if (diskImage != null) {
                DiskImageDetail image = diskImage.getImage();
                if (image != null) {
                    if (image.getFormat() != null) {
                        defaultRequest.addParameter("DiskImage." + i + ".Image.Format", StringUtils.fromString(image.getFormat()));
                    }
                    if (image.getBytes() != null) {
                        defaultRequest.addParameter("DiskImage." + i + ".Image.Bytes", StringUtils.fromLong(image.getBytes()));
                    }
                    if (image.getImportManifestUrl() != null) {
                        defaultRequest.addParameter("DiskImage." + i + ".Image.ImportManifestUrl", StringUtils.fromString(image.getImportManifestUrl()));
                    }
                }
                if (diskImage.getDescription() != null) {
                    defaultRequest.addParameter("DiskImage." + i + ".Description", StringUtils.fromString(diskImage.getDescription()));
                }
                VolumeDetail volume = diskImage.getVolume();
                if (!(volume == null || volume.getSize() == null)) {
                    defaultRequest.addParameter("DiskImage." + i + ".Volume.Size", StringUtils.fromLong(volume.getSize()));
                }
            }
            i++;
        }
        if (importInstanceRequest.getPlatform() != null) {
            defaultRequest.addParameter("Platform", StringUtils.fromString(importInstanceRequest.getPlatform()));
        }
        return defaultRequest;
    }
}
