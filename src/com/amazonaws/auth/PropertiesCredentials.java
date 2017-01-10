package com.amazonaws.auth;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesCredentials implements AWSCredentials {
    private final String accessKey;
    private final String secretAccessKey;

    public PropertiesCredentials(File file) throws FileNotFoundException, IOException, IllegalArgumentException {
        if (file.exists()) {
            Properties properties = new Properties();
            properties.load(new FileInputStream(file));
            if (properties.getProperty("accessKey") == null || properties.getProperty("secretKey") == null) {
                throw new IllegalArgumentException("The specified file (" + file.getAbsolutePath() + ") " + "doesn't contain the expected properties 'accessKey' and 'secretKey'.");
            }
            this.accessKey = properties.getProperty("accessKey");
            this.secretAccessKey = properties.getProperty("secretKey");
            return;
        }
        throw new FileNotFoundException("File doesn't exist:  " + file.getAbsolutePath());
    }

    public PropertiesCredentials(InputStream inputStream) throws IOException {
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            if (properties.getProperty("accessKey") == null || properties.getProperty("secretKey") == null) {
                throw new IllegalArgumentException("The specified properties data doesn't contain the expected properties 'accessKey' and 'secretKey'.");
            }
            this.accessKey = properties.getProperty("accessKey");
            this.secretAccessKey = properties.getProperty("secretKey");
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    public String getAWSAccessKeyId() {
        return this.accessKey;
    }

    public String getAWSSecretKey() {
        return this.secretAccessKey;
    }
}
