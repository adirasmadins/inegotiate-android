package com.amazonaws;

import com.amazonaws.auth.AWSCredentials;
import java.util.HashMap;
import java.util.Map;

public abstract class AmazonWebServiceRequest {
    private AWSCredentials credentials;
    private String delegationToken;
    private final RequestClientOptions requestClientOptions;

    public AmazonWebServiceRequest() {
        this.requestClientOptions = new RequestClientOptions();
    }

    public Map<String, String> copyPrivateRequestParameters() {
        Map hashMap = new HashMap();
        if (this.delegationToken != null) {
            hashMap.put("SecurityToken", this.delegationToken);
        }
        return hashMap;
    }

    public String getDelegationToken() {
        return this.delegationToken;
    }

    public RequestClientOptions getRequestClientOptions() {
        return this.requestClientOptions;
    }

    public AWSCredentials getRequestCredentials() {
        return this.credentials;
    }

    public void setDelegationToken(String str) {
        this.delegationToken = str;
    }

    public void setRequestCredentials(AWSCredentials aWSCredentials) {
        this.credentials = aWSCredentials;
    }
}
