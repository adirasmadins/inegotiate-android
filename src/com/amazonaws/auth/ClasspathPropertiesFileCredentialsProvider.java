package com.amazonaws.auth;

import com.amazonaws.AmazonClientException;
import java.io.InputStream;

public class ClasspathPropertiesFileCredentialsProvider implements AWSCredentialsProvider {
    private static String DEFAULT_PROPERTIES_FILE;
    private final String credentialsFilePath;

    static {
        DEFAULT_PROPERTIES_FILE = "AwsCredentials.properties";
    }

    public ClasspathPropertiesFileCredentialsProvider() {
        this(DEFAULT_PROPERTIES_FILE);
    }

    public ClasspathPropertiesFileCredentialsProvider(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Credentials file path cannot be null");
        } else if (str.startsWith("/")) {
            this.credentialsFilePath = str;
        } else {
            this.credentialsFilePath = "/" + str;
        }
    }

    public AWSCredentials getCredentials() {
        InputStream resourceAsStream = getClass().getResourceAsStream(this.credentialsFilePath);
        if (resourceAsStream == null) {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.credentialsFilePath + " file on the classpath");
        }
        try {
            return new PropertiesCredentials(resourceAsStream);
        } catch (Throwable e) {
            throw new AmazonClientException("Unable to load AWS credentials from the " + this.credentialsFilePath + " file on the classpath", e);
        }
    }

    public void refresh() {
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.credentialsFilePath + ")";
    }
}
