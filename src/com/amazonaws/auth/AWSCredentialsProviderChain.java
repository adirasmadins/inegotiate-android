package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class AWSCredentialsProviderChain implements AWSCredentialsProvider {
    private static final Log log;
    private List<AWSCredentialsProvider> credentialsProviders;

    static {
        log = LogFactory.getLog(AWSCredentialsProviderChain.class);
    }

    public AWSCredentialsProviderChain(AWSCredentialsProvider... aWSCredentialsProviderArr) {
        this.credentialsProviders = new LinkedList();
        if (aWSCredentialsProviderArr == null || aWSCredentialsProviderArr.length == 0) {
            throw new IllegalArgumentException("No credential providers specified");
        }
        for (Object add : aWSCredentialsProviderArr) {
            this.credentialsProviders.add(add);
        }
    }

    public AWSCredentials getCredentials() {
        for (AWSCredentialsProvider aWSCredentialsProvider : this.credentialsProviders) {
            try {
                AWSCredentials credentials = aWSCredentialsProvider.getCredentials();
                if (!(credentials.getAWSAccessKeyId() == null || credentials.getAWSSecretKey() == null)) {
                    log.debug("Loading credentials from " + aWSCredentialsProvider.toString());
                    return credentials;
                }
            } catch (Exception e) {
                log.debug("Unable to load credentials from " + aWSCredentialsProvider.toString() + ": " + e.getMessage());
            }
        }
        throw new AmazonClientException("Unable to load AWS credentials from any provider in the chain");
    }

    public void refresh() {
        for (AWSCredentialsProvider refresh : this.credentialsProviders) {
            refresh.refresh();
        }
    }
}
