package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.CreateVolumePermission;
import com.amazonaws.services.ec2.model.CreateVolumePermissionModifications;
import com.amazonaws.services.ec2.model.ModifySnapshotAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ModifySnapshotAttributeRequestMarshaller implements Marshaller<Request<ModifySnapshotAttributeRequest>, ModifySnapshotAttributeRequest> {
    public Request<ModifySnapshotAttributeRequest> marshall(ModifySnapshotAttributeRequest modifySnapshotAttributeRequest) {
        int i = 1;
        if (modifySnapshotAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ModifySnapshotAttributeRequest> defaultRequest = new DefaultRequest(modifySnapshotAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ModifySnapshotAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (modifySnapshotAttributeRequest.getSnapshotId() != null) {
            defaultRequest.addParameter("SnapshotId", StringUtils.fromString(modifySnapshotAttributeRequest.getSnapshotId()));
        }
        if (modifySnapshotAttributeRequest.getAttribute() != null) {
            defaultRequest.addParameter("Attribute", StringUtils.fromString(modifySnapshotAttributeRequest.getAttribute()));
        }
        if (modifySnapshotAttributeRequest.getOperationType() != null) {
            defaultRequest.addParameter("OperationType", StringUtils.fromString(modifySnapshotAttributeRequest.getOperationType()));
        }
        int i2 = 1;
        for (String str : modifySnapshotAttributeRequest.getUserIds()) {
            if (str != null) {
                defaultRequest.addParameter("UserId." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        i2 = 1;
        for (String str2 : modifySnapshotAttributeRequest.getGroupNames()) {
            if (str2 != null) {
                defaultRequest.addParameter("UserGroup." + i2, StringUtils.fromString(str2));
            }
            i2++;
        }
        CreateVolumePermissionModifications createVolumePermission = modifySnapshotAttributeRequest.getCreateVolumePermission();
        if (createVolumePermission != null) {
            i2 = 1;
            for (CreateVolumePermission createVolumePermission2 : createVolumePermission.getAdd()) {
                if (createVolumePermission2 != null) {
                    if (createVolumePermission2.getUserId() != null) {
                        defaultRequest.addParameter("CreateVolumePermission.Add." + i2 + ".UserId", StringUtils.fromString(createVolumePermission2.getUserId()));
                    }
                    if (createVolumePermission2.getGroup() != null) {
                        defaultRequest.addParameter("CreateVolumePermission.Add." + i2 + ".Group", StringUtils.fromString(createVolumePermission2.getGroup()));
                    }
                }
                i2++;
            }
            for (CreateVolumePermission createVolumePermission22 : createVolumePermission.getRemove()) {
                if (createVolumePermission22 != null) {
                    if (createVolumePermission22.getUserId() != null) {
                        defaultRequest.addParameter("CreateVolumePermission.Remove." + i + ".UserId", StringUtils.fromString(createVolumePermission22.getUserId()));
                    }
                    if (createVolumePermission22.getGroup() != null) {
                        defaultRequest.addParameter("CreateVolumePermission.Remove." + i + ".Group", StringUtils.fromString(createVolumePermission22.getGroup()));
                    }
                }
                i++;
            }
        }
        return defaultRequest;
    }
}
