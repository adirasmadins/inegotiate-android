package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.googleapis.GoogleHeaders;
import com.google.api.client.googleapis.auth.AuthKeyValueParser;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.UrlEncodedContent;
import com.google.api.client.util.Key;
import java.io.IOException;

public final class ClientLogin {
    @Key
    public String accountType;
    @Key("source")
    public String applicationName;
    @Key("service")
    public String authTokenType;
    @Key("logincaptcha")
    public String captchaAnswer;
    @Key("logintoken")
    public String captchaToken;
    @Key("Passwd")
    public String password;
    @Key("Email")
    public String username;

    public static final class ErrorInfo {
        @Key("CaptchaToken")
        public String captchaToken;
        @Key("CaptchaUrl")
        public String captchaUrl;
        @Key("Error")
        public String error;
        @Key("Url")
        public String url;
    }

    public static final class Response {
        @Key("Auth")
        public String auth;

        public String getAuthorizationHeaderValue() {
            return GoogleHeaders.getGoogleLoginValue(this.auth);
        }

        public void setAuthorizationHeader(HttpTransport googleTransport) {
            googleTransport.defaultHeaders.authorization = GoogleHeaders.getGoogleLoginValue(this.auth);
        }
    }

    public Response authenticate() throws HttpResponseException, IOException {
        HttpTransport transport = new HttpTransport();
        transport.addParser(AuthKeyValueParser.INSTANCE);
        HttpRequest request = transport.buildPostRequest();
        request.setUrl("https://www.google.com/accounts/ClientLogin");
        UrlEncodedContent content = new UrlEncodedContent();
        content.data = this;
        request.disableContentLogging = true;
        request.content = content;
        return (Response) request.execute().parseAs(Response.class);
    }
}
