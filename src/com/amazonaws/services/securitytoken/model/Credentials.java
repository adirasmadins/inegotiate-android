package com.amazonaws.services.securitytoken.model;

import java.util.Date;

public class Credentials {
    private String accessKeyId;
    private Date expiration;
    private String secretAccessKey;
    private String sessionToken;

    public Credentials(String str, String str2, String str3, Date date) {
        this.accessKeyId = str;
        this.secretAccessKey = str2;
        this.sessionToken = str3;
        this.expiration = date;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Credentials)) {
            return false;
        }
        Credentials credentials = (Credentials) obj;
        if (((credentials.getAccessKeyId() == null ? 1 : 0) ^ (getAccessKeyId() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (credentials.getAccessKeyId() != null && !credentials.getAccessKeyId().equals(getAccessKeyId())) {
            return false;
        }
        if (((credentials.getSecretAccessKey() == null ? 1 : 0) ^ (getSecretAccessKey() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (credentials.getSecretAccessKey() != null && !credentials.getSecretAccessKey().equals(getSecretAccessKey())) {
            return false;
        }
        if (((credentials.getSessionToken() == null ? 1 : 0) ^ (getSessionToken() == null ? 1 : 0)) != 0) {
            return false;
        }
        if (credentials.getSessionToken() != null && !credentials.getSessionToken().equals(getSessionToken())) {
            return false;
        }
        return ((credentials.getExpiration() == null ? 1 : 0) ^ (getExpiration() == null ? 1 : 0)) == 0 ? credentials.getExpiration() == null || credentials.getExpiration().equals(getExpiration()) : false;
    }

    public String getAccessKeyId() {
        return this.accessKeyId;
    }

    public Date getExpiration() {
        return this.expiration;
    }

    public String getSecretAccessKey() {
        return this.secretAccessKey;
    }

    public String getSessionToken() {
        return this.sessionToken;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((getSessionToken() == null ? 0 : getSessionToken().hashCode()) + (((getSecretAccessKey() == null ? 0 : getSecretAccessKey().hashCode()) + (((getAccessKeyId() == null ? 0 : getAccessKeyId().hashCode()) + 31) * 31)) * 31)) * 31;
        if (getExpiration() != null) {
            i = getExpiration().hashCode();
        }
        return hashCode + i;
    }

    public void setAccessKeyId(String str) {
        this.accessKeyId = str;
    }

    public void setExpiration(Date date) {
        this.expiration = date;
    }

    public void setSecretAccessKey(String str) {
        this.secretAccessKey = str;
    }

    public void setSessionToken(String str) {
        this.sessionToken = str;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (this.accessKeyId != null) {
            stringBuilder.append("AccessKeyId: " + this.accessKeyId + ", ");
        }
        if (this.secretAccessKey != null) {
            stringBuilder.append("SecretAccessKey: " + this.secretAccessKey + ", ");
        }
        if (this.sessionToken != null) {
            stringBuilder.append("SessionToken: " + this.sessionToken + ", ");
        }
        if (this.expiration != null) {
            stringBuilder.append("Expiration: " + this.expiration + ", ");
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public Credentials withAccessKeyId(String str) {
        this.accessKeyId = str;
        return this;
    }

    public Credentials withExpiration(Date date) {
        this.expiration = date;
        return this;
    }

    public Credentials withSecretAccessKey(String str) {
        this.secretAccessKey = str;
        return this;
    }

    public Credentials withSessionToken(String str) {
        this.sessionToken = str;
        return this;
    }
}
