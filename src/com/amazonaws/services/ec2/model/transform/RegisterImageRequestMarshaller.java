package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.BlockDeviceMapping;
import com.amazonaws.services.ec2.model.EbsBlockDevice;
import com.amazonaws.services.ec2.model.RegisterImageRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class RegisterImageRequestMarshaller implements Marshaller<Request<RegisterImageRequest>, RegisterImageRequest> {
    public Request<RegisterImageRequest> marshall(RegisterImageRequest registerImageRequest) {
        if (registerImageRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<RegisterImageRequest> defaultRequest = new DefaultRequest(registerImageRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "RegisterImage");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (registerImageRequest.getImageLocation() != null) {
            defaultRequest.addParameter("ImageLocation", StringUtils.fromString(registerImageRequest.getImageLocation()));
        }
        if (registerImageRequest.getName() != null) {
            defaultRequest.addParameter("Name", StringUtils.fromString(registerImageRequest.getName()));
        }
        if (registerImageRequest.getDescription() != null) {
            defaultRequest.addParameter("Description", StringUtils.fromString(registerImageRequest.getDescription()));
        }
        if (registerImageRequest.getArchitecture() != null) {
            defaultRequest.addParameter("Architecture", StringUtils.fromString(registerImageRequest.getArchitecture()));
        }
        if (registerImageRequest.getKernelId() != null) {
            defaultRequest.addParameter("KernelId", StringUtils.fromString(registerImageRequest.getKernelId()));
        }
        if (registerImageRequest.getRamdiskId() != null) {
            defaultRequest.addParameter("RamdiskId", StringUtils.fromString(registerImageRequest.getRamdiskId()));
        }
        if (registerImageRequest.getRootDeviceName() != null) {
            defaultRequest.addParameter("RootDeviceName", StringUtils.fromString(registerImageRequest.getRootDeviceName()));
        }
        int i = 1;
        for (BlockDeviceMapping blockDeviceMapping : registerImageRequest.getBlockDeviceMappings()) {
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
        return defaultRequest;
    }
}
