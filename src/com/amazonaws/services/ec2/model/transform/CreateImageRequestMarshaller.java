package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.BlockDeviceMapping;
import com.amazonaws.services.ec2.model.CreateImageRequest;
import com.amazonaws.services.ec2.model.EbsBlockDevice;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class CreateImageRequestMarshaller implements Marshaller<Request<CreateImageRequest>, CreateImageRequest> {
    public Request<CreateImageRequest> marshall(CreateImageRequest createImageRequest) {
        if (createImageRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<CreateImageRequest> defaultRequest = new DefaultRequest(createImageRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "CreateImage");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (createImageRequest.getInstanceId() != null) {
            defaultRequest.addParameter("InstanceId", StringUtils.fromString(createImageRequest.getInstanceId()));
        }
        if (createImageRequest.getName() != null) {
            defaultRequest.addParameter("Name", StringUtils.fromString(createImageRequest.getName()));
        }
        if (createImageRequest.getDescription() != null) {
            defaultRequest.addParameter("Description", StringUtils.fromString(createImageRequest.getDescription()));
        }
        if (createImageRequest.isNoReboot() != null) {
            defaultRequest.addParameter("NoReboot", StringUtils.fromBoolean(createImageRequest.isNoReboot()));
        }
        int i = 1;
        for (BlockDeviceMapping blockDeviceMapping : createImageRequest.getBlockDeviceMappings()) {
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
