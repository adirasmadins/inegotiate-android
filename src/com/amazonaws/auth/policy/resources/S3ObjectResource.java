package com.amazonaws.auth.policy.resources;

import com.amazonaws.auth.policy.Resource;

public class S3ObjectResource extends Resource {
    public S3ObjectResource(String str, String str2) {
        super("arn:aws:s3:::" + str + "/" + str2);
    }
}
