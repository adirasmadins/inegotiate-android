package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.DiskImageDetail;
import com.amazonaws.services.ec2.model.ImportVolumeRequest;
import com.amazonaws.services.ec2.model.VolumeDetail;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ImportVolumeRequestMarshaller implements Marshaller<Request<ImportVolumeRequest>, ImportVolumeRequest> {
    public Request<ImportVolumeRequest> marshall(ImportVolumeRequest importVolumeRequest) {
        if (importVolumeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ImportVolumeRequest> defaultRequest = new DefaultRequest(importVolumeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ImportVolume");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (importVolumeRequest.getAvailabilityZone() != null) {
            defaultRequest.addParameter("AvailabilityZone", StringUtils.fromString(importVolumeRequest.getAvailabilityZone()));
        }
        DiskImageDetail image = importVolumeRequest.getImage();
        if (image != null) {
            if (image.getFormat() != null) {
                defaultRequest.addParameter("Image.Format", StringUtils.fromString(image.getFormat()));
            }
            if (image.getBytes() != null) {
                defaultRequest.addParameter("Image.Bytes", StringUtils.fromLong(image.getBytes()));
            }
            if (image.getImportManifestUrl() != null) {
                defaultRequest.addParameter("Image.ImportManifestUrl", StringUtils.fromString(image.getImportManifestUrl()));
            }
        }
        if (importVolumeRequest.getDescription() != null) {
            defaultRequest.addParameter("Description", StringUtils.fromString(importVolumeRequest.getDescription()));
        }
        VolumeDetail volume = importVolumeRequest.getVolume();
        if (!(volume == null || volume.getSize() == null)) {
            defaultRequest.addParameter("Volume.Size", StringUtils.fromLong(volume.getSize()));
        }
        return defaultRequest;
    }
}
