package com.google.gdata.client;

public enum ClientLoginAccountType {
    GOOGLE("GOOGLE"),
    HOSTED("HOSTED"),
    HOSTED_OR_GOOGLE("HOSTED_OR_GOOGLE");
    
    private final String accountTypeValue;

    private ClientLoginAccountType(String accountTypeValue) {
        this.accountTypeValue = accountTypeValue;
    }

    public String getValue() {
        return this.accountTypeValue;
    }
}
