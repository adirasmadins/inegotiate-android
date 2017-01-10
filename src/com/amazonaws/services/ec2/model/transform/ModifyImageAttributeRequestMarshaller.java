package com.amazonaws.services.ec2.model.transform;

import com.amazonaws.AmazonClientException;
import com.amazonaws.DefaultRequest;
import com.amazonaws.Request;
import com.amazonaws.services.ec2.model.LaunchPermission;
import com.amazonaws.services.ec2.model.LaunchPermissionModifications;
import com.amazonaws.services.ec2.model.ModifyImageAttributeRequest;
import com.amazonaws.transform.Marshaller;
import com.amazonaws.util.StringUtils;

public class ModifyImageAttributeRequestMarshaller implements Marshaller<Request<ModifyImageAttributeRequest>, ModifyImageAttributeRequest> {
    public Request<ModifyImageAttributeRequest> marshall(ModifyImageAttributeRequest modifyImageAttributeRequest) {
        int i = 1;
        if (modifyImageAttributeRequest == null) {
            throw new AmazonClientException("Invalid argument passed to marshall(...)");
        }
        Request<ModifyImageAttributeRequest> defaultRequest = new DefaultRequest(modifyImageAttributeRequest, "AmazonEC2");
        defaultRequest.addParameter("Action", "ModifyImageAttribute");
        defaultRequest.addParameter("Version", "2012-08-15");
        if (modifyImageAttributeRequest.getImageId() != null) {
            defaultRequest.addParameter("ImageId", StringUtils.fromString(modifyImageAttributeRequest.getImageId()));
        }
        if (modifyImageAttributeRequest.getAttribute() != null) {
            defaultRequest.addParameter("Attribute", StringUtils.fromString(modifyImageAttributeRequest.getAttribute()));
        }
        if (modifyImageAttributeRequest.getOperationType() != null) {
            defaultRequest.addParameter("OperationType", StringUtils.fromString(modifyImageAttributeRequest.getOperationType()));
        }
        int i2 = 1;
        for (String str : modifyImageAttributeRequest.getUserIds()) {
            if (str != null) {
                defaultRequest.addParameter("UserId." + i2, StringUtils.fromString(str));
            }
            i2++;
        }
        i2 = 1;
        for (String str2 : modifyImageAttributeRequest.getUserGroups()) {
            if (str2 != null) {
                defaultRequest.addParameter("UserGroup." + i2, StringUtils.fromString(str2));
            }
            i2++;
        }
        i2 = 1;
        for (String str22 : modifyImageAttributeRequest.getProductCodes()) {
            if (str22 != null) {
                defaultRequest.addParameter("ProductCode." + i2, StringUtils.fromString(str22));
            }
            i2++;
        }
        if (modifyImageAttributeRequest.getValue() != null) {
            defaultRequest.addParameter("Value", StringUtils.fromString(modifyImageAttributeRequest.getValue()));
        }
        LaunchPermissionModifications launchPermission = modifyImageAttributeRequest.getLaunchPermission();
        if (launchPermission != null) {
            i2 = 1;
            for (LaunchPermission launchPermission2 : launchPermission.getAdd()) {
                if (launchPermission2 != null) {
                    if (launchPermission2.getUserId() != null) {
                        defaultRequest.addParameter("LaunchPermission.Add." + i2 + ".UserId", StringUtils.fromString(launchPermission2.getUserId()));
                    }
                    if (launchPermission2.getGroup() != null) {
                        defaultRequest.addParameter("LaunchPermission.Add." + i2 + ".Group", StringUtils.fromString(launchPermission2.getGroup()));
                    }
                }
                i2++;
            }
            for (LaunchPermission launchPermission22 : launchPermission.getRemove()) {
                if (launchPermission22 != null) {
                    if (launchPermission22.getUserId() != null) {
                        defaultRequest.addParameter("LaunchPermission.Remove." + i + ".UserId", StringUtils.fromString(launchPermission22.getUserId()));
                    }
                    if (launchPermission22.getGroup() != null) {
                        defaultRequest.addParameter("LaunchPermission.Remove." + i + ".Group", StringUtils.fromString(launchPermission22.getGroup()));
                    }
                }
                i++;
            }
        }
        if (modifyImageAttributeRequest.getDescription() != null) {
            defaultRequest.addParameter("Description.Value", StringUtils.fromString(modifyImageAttributeRequest.getDescription()));
        }
        return defaultRequest;
    }
}
